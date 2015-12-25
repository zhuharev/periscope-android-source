// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer.drm.DrmSessionManager;
import com.google.android.exoplayer.util.MimeTypes;
import com.google.android.exoplayer.util.TraceUtil;
import com.google.android.exoplayer.util.Util;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecTrackRenderer, MediaFormat, CodecCounters, MediaCodecUtil, 
//            MediaFormatHolder, SampleSource

public class MediaCodecVideoTrackRenderer extends MediaCodecTrackRenderer
{
    public static interface EventListener
        extends MediaCodecTrackRenderer.EventListener
    {

        public abstract void onDrawnToSurface(Surface surface1);

        public abstract void onDroppedFrames(int i, long l);

        public abstract void onVideoSizeChanged(int i, int j, int k, float f);
    }

    public static interface FrameReleaseTimeHelper
    {

        public abstract long adjustReleaseTime(long l, long l1);

        public abstract void disable();

        public abstract void enable();
    }


    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    public static final int MSG_SET_SURFACE = 1;
    private final long allowedJoiningTimeUs;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrameCount;
    private final EventListener eventListener;
    private final FrameReleaseTimeHelper frameReleaseTimeHelper;
    private long joiningDeadlineUs;
    private int lastReportedHeight;
    private float lastReportedPixelWidthHeightRatio;
    private int lastReportedUnappliedRotationDegrees;
    private int lastReportedWidth;
    private final int maxDroppedFrameCountToNotify;
    private float pendingPixelWidthHeightRatio;
    private int pendingRotationDegrees;
    private boolean renderedFirstFrame;
    private boolean reportedDrawnToSurface;
    private Surface surface;
    private final int videoScalingMode;

    public MediaCodecVideoTrackRenderer(SampleSource samplesource, int i)
    {
        this(samplesource, null, true, i);
    }

    public MediaCodecVideoTrackRenderer(SampleSource samplesource, int i, long l)
    {
        this(samplesource, null, true, i, l);
    }

    public MediaCodecVideoTrackRenderer(SampleSource samplesource, int i, long l, Handler handler, EventListener eventlistener, int j)
    {
        this(samplesource, null, true, i, l, null, handler, eventlistener, j);
    }

    public MediaCodecVideoTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag, int i)
    {
        this(samplesource, drmsessionmanager, flag, i, 0L);
    }

    public MediaCodecVideoTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag, int i, long l)
    {
        this(samplesource, drmsessionmanager, flag, i, l, null, null, null, -1);
    }

    public MediaCodecVideoTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag, int i, long l, FrameReleaseTimeHelper framereleasetimehelper, 
            Handler handler, EventListener eventlistener, int j)
    {
        super(samplesource, drmsessionmanager, flag, handler, eventlistener);
        videoScalingMode = i;
        allowedJoiningTimeUs = 1000L * l;
        frameReleaseTimeHelper = framereleasetimehelper;
        eventListener = eventlistener;
        maxDroppedFrameCountToNotify = j;
        joiningDeadlineUs = -1L;
        currentWidth = -1;
        currentHeight = -1;
        currentPixelWidthHeightRatio = -1F;
        pendingPixelWidthHeightRatio = -1F;
        lastReportedWidth = -1;
        lastReportedHeight = -1;
        lastReportedPixelWidthHeightRatio = -1F;
    }

    private void maybeNotifyDrawnToSurface()
    {
        if (eventHandler == null || eventListener == null || reportedDrawnToSurface)
        {
            return;
        } else
        {
            final Surface surface = this.surface;
            eventHandler.post(new _cls2());
            reportedDrawnToSurface = true;
            return;
        }
    }

    private void maybeNotifyDroppedFrameCount()
    {
        if (eventHandler == null || eventListener == null || droppedFrameCount == 0)
        {
            return;
        } else
        {
            long l = SystemClock.elapsedRealtime();
            final int countToNotify = droppedFrameCount;
            long l1 = droppedFrameAccumulationStartTimeMs;
            eventHandler.post(new _cls3());
            droppedFrameCount = 0;
            droppedFrameAccumulationStartTimeMs = l;
            return;
        }
    }

    private void maybeNotifyVideoSizeChanged()
    {
        if (eventHandler == null || eventListener == null || lastReportedWidth == this.currentWidth && lastReportedHeight == this.currentHeight && lastReportedUnappliedRotationDegrees == this.currentUnappliedRotationDegrees && lastReportedPixelWidthHeightRatio == this.currentPixelWidthHeightRatio)
        {
            return;
        } else
        {
            final int currentWidth = this.currentWidth;
            final int currentHeight = this.currentHeight;
            final int currentUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
            final float currentPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
            eventHandler.post(new _cls1());
            lastReportedWidth = currentWidth;
            lastReportedHeight = currentHeight;
            lastReportedUnappliedRotationDegrees = currentUnappliedRotationDegrees;
            lastReportedPixelWidthHeightRatio = currentPixelWidthHeightRatio;
            return;
        }
    }

    private void maybeSetMaxInputSize(MediaFormat mediaformat, boolean flag)
    {
        if (!"video/avc".equals(mediaformat.getString("mime")))
        {
            return;
        }
        if (mediaformat.containsKey("max-input-size"))
        {
            return;
        }
        int j = mediaformat.getInteger("height");
        int i = j;
        if (flag)
        {
            i = j;
            if (mediaformat.containsKey("max-height"))
            {
                i = Math.max(j, mediaformat.getInteger("max-height"));
            }
        }
        int k = mediaformat.getInteger("width");
        j = k;
        if (flag)
        {
            j = k;
            if (mediaformat.containsKey("max-width"))
            {
                j = Math.max(i, mediaformat.getInteger("max-width"));
            }
        }
        mediaformat.setInteger("max-input-size", ((j + 15) / 16) * ((i + 15) / 16) * 192);
    }

    private void setSurface(Surface surface1)
    {
        if (surface == surface1)
        {
            return;
        }
        surface = surface1;
        reportedDrawnToSurface = false;
        int i = getState();
        if (i == 2 || i == 3)
        {
            releaseCodec();
            maybeInitCodec();
        }
    }

    protected boolean canReconfigureCodec(MediaCodec mediacodec, boolean flag, com.google.android.exoplayer.MediaFormat mediaformat, com.google.android.exoplayer.MediaFormat mediaformat1)
    {
        return mediaformat1.mimeType.equals(mediaformat.mimeType) && (flag || mediaformat.width == mediaformat1.width && mediaformat.height == mediaformat1.height);
    }

    protected void configureCodec(MediaCodec mediacodec, String s, boolean flag, MediaFormat mediaformat, MediaCrypto mediacrypto)
    {
        maybeSetMaxInputSize(mediaformat, flag);
        mediacodec.configure(mediaformat, surface, mediacrypto, 0);
        mediacodec.setVideoScalingMode(videoScalingMode);
    }

    public void dropOutputBuffer(MediaCodec mediacodec, int i)
    {
        TraceUtil.beginSection("dropVideoBuffer");
        mediacodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        mediacodec = codecCounters;
        mediacodec.droppedOutputBufferCount = ((CodecCounters) (mediacodec)).droppedOutputBufferCount + 1;
        droppedFrameCount = droppedFrameCount + 1;
        if (droppedFrameCount == maxDroppedFrameCountToNotify)
        {
            maybeNotifyDroppedFrameCount();
        }
    }

    public void handleMessage(int i, Object obj)
    {
        if (i == 1)
        {
            setSurface((Surface)obj);
            return;
        } else
        {
            super.handleMessage(i, obj);
            return;
        }
    }

    protected boolean handlesTrack(com.google.android.exoplayer.MediaFormat mediaformat)
    {
        mediaformat = mediaformat.mimeType;
        return MimeTypes.isVideo(mediaformat) && ("video/x-unknown".equals(mediaformat) || MediaCodecUtil.getDecoderInfo(mediaformat, false) != null);
    }

    protected final boolean haveRenderedFirstFrame()
    {
        return renderedFirstFrame;
    }

    protected boolean isReady()
    {
        if (super.isReady() && (renderedFirstFrame || !codecInitialized() || getSourceState() == 2))
        {
            joiningDeadlineUs = -1L;
            return true;
        }
        if (joiningDeadlineUs == -1L)
        {
            return false;
        }
        if (SystemClock.elapsedRealtime() * 1000L < joiningDeadlineUs)
        {
            return true;
        } else
        {
            joiningDeadlineUs = -1L;
            return false;
        }
    }

    protected void onDisabled()
    {
        currentWidth = -1;
        currentHeight = -1;
        currentPixelWidthHeightRatio = -1F;
        pendingPixelWidthHeightRatio = -1F;
        lastReportedWidth = -1;
        lastReportedHeight = -1;
        lastReportedPixelWidthHeightRatio = -1F;
        if (frameReleaseTimeHelper != null)
        {
            frameReleaseTimeHelper.disable();
        }
        super.onDisabled();
    }

    protected void onEnabled(int i, long l, boolean flag)
    {
        super.onEnabled(i, l, flag);
        renderedFirstFrame = false;
        if (flag && allowedJoiningTimeUs > 0L)
        {
            joiningDeadlineUs = SystemClock.elapsedRealtime() * 1000L + allowedJoiningTimeUs;
        }
        if (frameReleaseTimeHelper != null)
        {
            frameReleaseTimeHelper.enable();
        }
    }

    protected void onInputFormatChanged(MediaFormatHolder mediaformatholder)
    {
        super.onInputFormatChanged(mediaformatholder);
        float f;
        if (mediaformatholder.format.pixelWidthHeightRatio == -1F)
        {
            f = 1.0F;
        } else
        {
            f = mediaformatholder.format.pixelWidthHeightRatio;
        }
        pendingPixelWidthHeightRatio = f;
        int i;
        if (mediaformatholder.format.rotationDegrees == -1)
        {
            i = 0;
        } else
        {
            i = mediaformatholder.format.rotationDegrees;
        }
        pendingRotationDegrees = i;
    }

    protected void onOutputFormatChanged(MediaFormat mediaformat)
    {
        boolean flag;
        if (mediaformat.containsKey("crop-right") && mediaformat.containsKey("crop-left") && mediaformat.containsKey("crop-bottom") && mediaformat.containsKey("crop-top"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int k;
        if (flag)
        {
            k = (mediaformat.getInteger("crop-right") - mediaformat.getInteger("crop-left")) + 1;
        } else
        {
            k = mediaformat.getInteger("width");
        }
        currentWidth = k;
        int i;
        if (flag)
        {
            i = (mediaformat.getInteger("crop-bottom") - mediaformat.getInteger("crop-top")) + 1;
        } else
        {
            i = mediaformat.getInteger("height");
        }
        currentHeight = i;
        currentPixelWidthHeightRatio = pendingPixelWidthHeightRatio;
        if (Util.SDK_INT >= 21)
        {
            if (pendingRotationDegrees == 90 || pendingRotationDegrees == 270)
            {
                int j = currentWidth;
                currentWidth = currentHeight;
                currentHeight = j;
                currentPixelWidthHeightRatio = 1.0F / currentPixelWidthHeightRatio;
                return;
            }
        } else
        {
            currentUnappliedRotationDegrees = pendingRotationDegrees;
        }
    }

    protected void onStarted()
    {
        super.onStarted();
        droppedFrameCount = 0;
        droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
    }

    protected void onStopped()
    {
        joiningDeadlineUs = -1L;
        maybeNotifyDroppedFrameCount();
        super.onStopped();
    }

    protected boolean processOutputBuffer(long l, long l1, MediaCodec mediacodec, ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo, 
            int i, boolean flag)
    {
        if (flag)
        {
            skipOutputBuffer(mediacodec, i);
            return true;
        }
        if (!renderedFirstFrame)
        {
            if (Util.SDK_INT >= 21)
            {
                renderOutputBufferV21(mediacodec, i, System.nanoTime());
            } else
            {
                renderOutputBuffer(mediacodec, i);
            }
            return true;
        }
        if (getState() != 3)
        {
            return false;
        }
        long l2 = SystemClock.elapsedRealtime();
        l1 = bufferinfo.presentationTimeUs - l - (l2 * 1000L - l1);
        l2 = System.nanoTime();
        l = l2 + 1000L * l1;
        if (frameReleaseTimeHelper != null)
        {
            l1 = frameReleaseTimeHelper.adjustReleaseTime(bufferinfo.presentationTimeUs, l);
            l = l1;
            l1 = (l1 - l2) / 1000L;
        }
        if (l1 < -30000L)
        {
            dropOutputBuffer(mediacodec, i);
            return true;
        }
        if (Util.SDK_INT >= 21)
        {
            if (l1 < 50000L)
            {
                renderOutputBufferV21(mediacodec, i, l);
                return true;
            }
        } else
        if (l1 < 30000L)
        {
            if (l1 > 11000L)
            {
                try
                {
                    Thread.sleep((l1 - 10000L) / 1000L);
                }
                // Misplaced declaration of an exception variable
                catch (ByteBuffer bytebuffer)
                {
                    Thread.currentThread().interrupt();
                }
            }
            renderOutputBuffer(mediacodec, i);
            return true;
        }
        return false;
    }

    public void renderOutputBuffer(MediaCodec mediacodec, int i)
    {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediacodec.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        mediacodec = codecCounters;
        mediacodec.renderedOutputBufferCount = ((CodecCounters) (mediacodec)).renderedOutputBufferCount + 1;
        renderedFirstFrame = true;
        maybeNotifyDrawnToSurface();
    }

    public void renderOutputBufferV21(MediaCodec mediacodec, int i, long l)
    {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediacodec.releaseOutputBuffer(i, l);
        TraceUtil.endSection();
        mediacodec = codecCounters;
        mediacodec.renderedOutputBufferCount = ((CodecCounters) (mediacodec)).renderedOutputBufferCount + 1;
        renderedFirstFrame = true;
        maybeNotifyDrawnToSurface();
    }

    protected void seekTo(long l)
    {
        super.seekTo(l);
        renderedFirstFrame = false;
        joiningDeadlineUs = -1L;
    }

    protected boolean shouldInitCodec()
    {
        return super.shouldInitCodec() && surface != null && surface.isValid();
    }

    public void skipOutputBuffer(MediaCodec mediacodec, int i)
    {
        TraceUtil.beginSection("skipVideoBuffer");
        mediacodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        mediacodec = codecCounters;
        mediacodec.skippedOutputBufferCount = ((CodecCounters) (mediacodec)).skippedOutputBufferCount + 1;
    }


    private class _cls2
        implements Runnable
    {

        final MediaCodecVideoTrackRenderer this$0;
        final Surface val$surface;

        public void run()
        {
            eventListener.onDrawnToSurface(surface);
        }

        _cls2()
        {
            this$0 = MediaCodecVideoTrackRenderer.this;
            surface = surface1;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final MediaCodecVideoTrackRenderer this$0;
        final int val$countToNotify;
        final long val$elapsedToNotify;

        public void run()
        {
            eventListener.onDroppedFrames(countToNotify, elapsedToNotify);
        }

        _cls3()
        {
            this$0 = MediaCodecVideoTrackRenderer.this;
            countToNotify = i;
            elapsedToNotify = l;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final MediaCodecVideoTrackRenderer this$0;
        final int val$currentHeight;
        final float val$currentPixelWidthHeightRatio;
        final int val$currentUnappliedRotationDegrees;
        final int val$currentWidth;

        public void run()
        {
            eventListener.onVideoSizeChanged(currentWidth, currentHeight, currentUnappliedRotationDegrees, currentPixelWidthHeightRatio);
        }

        _cls1()
        {
            this$0 = MediaCodecVideoTrackRenderer.this;
            currentWidth = i;
            currentHeight = j;
            currentUnappliedRotationDegrees = k;
            currentPixelWidthHeightRatio = f;
            super();
        }
    }

}
