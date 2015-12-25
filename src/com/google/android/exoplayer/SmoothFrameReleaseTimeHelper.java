// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.view.Choreographer;

public final class SmoothFrameReleaseTimeHelper
    implements MediaCodecVideoTrackRenderer.FrameReleaseTimeHelper, android.view.Choreographer.FrameCallback
{

    private static final long CHOREOGRAPHER_SAMPLE_DELAY_MILLIS = 500L;
    private static final long MAX_ALLOWED_DRIFT_NS = 0x1312d00L;
    private static final int MIN_FRAMES_FOR_ADJUSTMENT = 6;
    private static final long VSYNC_OFFSET_PERCENTAGE = 80L;
    private long adjustedLastFrameTimeNs;
    private Choreographer choreographer;
    private int frameCount;
    private boolean haveSync;
    private long lastUnadjustedFrameTimeUs;
    private long pendingAdjustedFrameTimeNs;
    private long sampledVsyncTimeNs;
    private long syncFrameTimeNs;
    private long syncReleaseTimeNs;
    private final boolean usePrimaryDisplayVsync;
    private final long vsyncDurationNs;
    private final long vsyncOffsetNs;

    public SmoothFrameReleaseTimeHelper(float f, boolean flag)
    {
        usePrimaryDisplayVsync = flag;
        if (flag)
        {
            vsyncDurationNs = (long)(1000000000D / (double)f);
            vsyncOffsetNs = (vsyncDurationNs * 80L) / 100L;
            return;
        } else
        {
            vsyncDurationNs = -1L;
            vsyncOffsetNs = -1L;
            return;
        }
    }

    private static long closestVsync(long l, long l1, long l2)
    {
        long l3 = l1 + l2 * ((l - l1) / l2);
        if (l <= l3)
        {
            l1 = l3 - l2;
        } else
        {
            l1 = l3;
            l3 += l2;
        }
        if (l3 - l < l - l1)
        {
            return l3;
        } else
        {
            return l1;
        }
    }

    private boolean isDriftTooLarge(long l, long l1)
    {
        long l2 = syncFrameTimeNs;
        return Math.abs(l1 - syncReleaseTimeNs - (l - l2)) > 0x1312d00L;
    }

    public final long adjustReleaseTime(long l, long l1)
    {
        long l6 = 1000L * l;
        long l2 = l6;
        long l3 = l1;
        long l4 = l2;
        long l5 = l3;
        if (haveSync)
        {
            if (l != lastUnadjustedFrameTimeUs)
            {
                frameCount = frameCount + 1;
                adjustedLastFrameTimeNs = pendingAdjustedFrameTimeNs;
            }
            if (frameCount >= 6)
            {
                l4 = (l6 - syncFrameTimeNs) / (long)frameCount;
                l4 = adjustedLastFrameTimeNs + l4;
                if (isDriftTooLarge(l4, l1))
                {
                    haveSync = false;
                    l4 = l2;
                    l5 = l3;
                } else
                {
                    l5 = (syncReleaseTimeNs + l4) - syncFrameTimeNs;
                }
            } else
            {
                l4 = l2;
                l5 = l3;
                if (isDriftTooLarge(l6, l1))
                {
                    haveSync = false;
                    l5 = l3;
                    l4 = l2;
                }
            }
        }
        if (!haveSync)
        {
            syncFrameTimeNs = l6;
            syncReleaseTimeNs = l1;
            frameCount = 0;
            haveSync = true;
            onSynced();
        }
        lastUnadjustedFrameTimeUs = l;
        pendingAdjustedFrameTimeNs = l4;
        if (sampledVsyncTimeNs == 0L)
        {
            return l5;
        } else
        {
            return closestVsync(l5, sampledVsyncTimeNs, vsyncDurationNs) - vsyncOffsetNs;
        }
    }

    public final void disable()
    {
        if (usePrimaryDisplayVsync)
        {
            choreographer.removeFrameCallback(this);
            choreographer = null;
        }
    }

    public final void doFrame(long l)
    {
        sampledVsyncTimeNs = l;
        choreographer.postFrameCallbackDelayed(this, 500L);
    }

    public final void enable()
    {
        haveSync = false;
        if (usePrimaryDisplayVsync)
        {
            sampledVsyncTimeNs = 0L;
            choreographer = Choreographer.getInstance();
            choreographer.postFrameCallback(this);
        }
    }

    protected final void onSynced()
    {
    }
}
