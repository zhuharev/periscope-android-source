// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

// Referenced classes of package com.google.android.exoplayer.audio:
//            AudioTrack

static class it> extends it>
{

    private final AudioTimestamp audioTimestamp = new AudioTimestamp();
    private long lastRawTimestampFramePosition;
    private long lastTimestampFramePosition;
    private long rawTimestampFramePositionWrapCount;

    public long getTimestampFramePosition()
    {
        return lastTimestampFramePosition;
    }

    public long getTimestampNanoTime()
    {
        return audioTimestamp.nanoTime;
    }

    public void reconfigure(AudioTrack audiotrack, boolean flag)
    {
        super.onfigure(audiotrack, flag);
        rawTimestampFramePositionWrapCount = 0L;
        lastRawTimestampFramePosition = 0L;
        lastTimestampFramePosition = 0L;
    }

    public boolean updateTimestamp()
    {
        boolean flag = audioTrack.getTimestamp(audioTimestamp);
        if (flag)
        {
            long l = audioTimestamp.framePosition;
            if (lastRawTimestampFramePosition > l)
            {
                rawTimestampFramePositionWrapCount = rawTimestampFramePositionWrapCount + 1L;
            }
            lastRawTimestampFramePosition = l;
            lastTimestampFramePosition = (rawTimestampFramePositionWrapCount << 32) + l;
        }
        return flag;
    }

    public ()
    {
        super(null);
    }
}
