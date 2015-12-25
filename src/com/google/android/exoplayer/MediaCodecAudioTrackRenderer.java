// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer.audio.AudioCapabilities;
import com.google.android.exoplayer.audio.AudioTrack;
import com.google.android.exoplayer.drm.DrmSessionManager;
import com.google.android.exoplayer.util.MimeTypes;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecTrackRenderer, MediaClock, DecoderInfo, MediaFormat, 
//            MediaCodecUtil, CodecCounters, ExoPlaybackException, SampleSource

public class MediaCodecAudioTrackRenderer extends MediaCodecTrackRenderer
    implements MediaClock
{
    public static interface EventListener
        extends MediaCodecTrackRenderer.EventListener
    {

        public abstract void onAudioTrackInitializationError(com.google.android.exoplayer.audio.AudioTrack.InitializationException initializationexception);

        public abstract void onAudioTrackWriteError(com.google.android.exoplayer.audio.AudioTrack.WriteException writeexception);
    }


    public static final int MSG_SET_VOLUME = 1;
    private static final String RAW_DECODER_NAME = "OMX.google.raw.decoder";
    private boolean allowPositionDiscontinuity;
    private int audioSessionId;
    private final AudioTrack audioTrack;
    private long currentPositionUs;
    private final EventListener eventListener;
    private MediaFormat passthroughMediaFormat;

    public MediaCodecAudioTrackRenderer(SampleSource samplesource)
    {
        this(samplesource, ((DrmSessionManager) (null)), true);
    }

    public MediaCodecAudioTrackRenderer(SampleSource samplesource, Handler handler, EventListener eventlistener)
    {
        this(samplesource, null, true, handler, eventlistener);
    }

    public MediaCodecAudioTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag)
    {
        this(samplesource, drmsessionmanager, flag, null, null);
    }

    public MediaCodecAudioTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag, Handler handler, EventListener eventlistener)
    {
        this(samplesource, drmsessionmanager, flag, handler, eventlistener, null);
    }

    public MediaCodecAudioTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag, Handler handler, EventListener eventlistener, AudioCapabilities audiocapabilities)
    {
        this(samplesource, drmsessionmanager, flag, handler, eventlistener, audiocapabilities, 3);
    }

    public MediaCodecAudioTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag, Handler handler, EventListener eventlistener, AudioCapabilities audiocapabilities, int i)
    {
        super(samplesource, drmsessionmanager, flag, handler, eventlistener);
        eventListener = eventlistener;
        audioSessionId = 0;
        audioTrack = new AudioTrack(audiocapabilities, i);
    }

    private void notifyAudioTrackInitializationError(final com.google.android.exoplayer.audio.AudioTrack.InitializationException e)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls1());
        }
    }

    private void notifyAudioTrackWriteError(final com.google.android.exoplayer.audio.AudioTrack.WriteException e)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls2());
        }
    }

    private void seekToInternal(long l)
    {
        audioTrack.reset();
        currentPositionUs = l;
        allowPositionDiscontinuity = true;
    }

    protected boolean allowPassthrough(String s)
    {
        return audioTrack.isPassthroughSupported(s);
    }

    protected void configureCodec(MediaCodec mediacodec, String s, boolean flag, MediaFormat mediaformat, MediaCrypto mediacrypto)
    {
        String s1 = mediaformat.getString("mime");
        if ("OMX.google.raw.decoder".equals(s) && !"audio/raw".equals(s1))
        {
            mediaformat.setString("mime", "audio/raw");
            mediacodec.configure(mediaformat, null, mediacrypto, 0);
            mediaformat.setString("mime", s1);
            passthroughMediaFormat = mediaformat;
            return;
        } else
        {
            mediacodec.configure(mediaformat, null, mediacrypto, 0);
            passthroughMediaFormat = null;
            return;
        }
    }

    protected DecoderInfo getDecoderInfo(String s, boolean flag)
    {
        if (allowPassthrough(s))
        {
            return new DecoderInfo("OMX.google.raw.decoder", true);
        } else
        {
            return super.getDecoderInfo(s, flag);
        }
    }

    protected MediaClock getMediaClock()
    {
        return this;
    }

    public long getPositionUs()
    {
        long l = audioTrack.getCurrentPositionUs(isEnded());
        if (l != 0x8000000000000000L)
        {
            if (!allowPositionDiscontinuity)
            {
                l = Math.max(currentPositionUs, l);
            }
            currentPositionUs = l;
            allowPositionDiscontinuity = false;
        }
        return currentPositionUs;
    }

    protected void handleDiscontinuity()
    {
    }

    public void handleMessage(int i, Object obj)
    {
        if (i == 1)
        {
            audioTrack.setVolume(((Float)obj).floatValue());
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
        return MimeTypes.isAudio(mediaformat) && ("audio/x-unknown".equals(mediaformat) || allowPassthrough(mediaformat) || MediaCodecUtil.getDecoderInfo(mediaformat, false) != null);
    }

    protected boolean isEnded()
    {
        return super.isEnded() && !audioTrack.hasPendingData();
    }

    protected boolean isReady()
    {
        return audioTrack.hasPendingData() || super.isReady() && getSourceState() == 2;
    }

    protected void onAudioSessionId(int i)
    {
    }

    protected void onDisabled()
    {
        audioSessionId = 0;
        audioTrack.release();
        super.onDisabled();
        return;
        Exception exception;
        exception;
        super.onDisabled();
        throw exception;
    }

    protected void onEnabled(int i, long l, boolean flag)
    {
        super.onEnabled(i, l, flag);
        seekToInternal(l);
    }

    protected void onOutputFormatChanged(MediaFormat mediaformat)
    {
        boolean flag;
        if (passthroughMediaFormat != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        AudioTrack audiotrack = audioTrack;
        if (flag)
        {
            mediaformat = passthroughMediaFormat;
        }
        audiotrack.reconfigure(mediaformat, flag);
    }

    protected void onOutputStreamEnded()
    {
        audioTrack.handleEndOfStream();
    }

    protected void onStarted()
    {
        super.onStarted();
        audioTrack.play();
    }

    protected void onStopped()
    {
        audioTrack.pause();
        super.onStopped();
    }

    protected boolean processOutputBuffer(long l, long l1, MediaCodec mediacodec, ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo, 
            int i, boolean flag)
    {
        if (flag)
        {
            mediacodec.releaseOutputBuffer(i, false);
            mediacodec = codecCounters;
            mediacodec.skippedOutputBufferCount = ((CodecCounters) (mediacodec)).skippedOutputBufferCount + 1;
            audioTrack.handleDiscontinuity();
            return true;
        }
        if (audioTrack.isInitialized())
        {
            break MISSING_BLOCK_LABEL_127;
        }
label0:
        {
            if (audioSessionId != 0)
            {
                audioTrack.initialize(audioSessionId);
                break label0;
            }
            try
            {
                audioSessionId = audioTrack.initialize();
                onAudioSessionId(audioSessionId);
            }
            // Misplaced declaration of an exception variable
            catch (MediaCodec mediacodec)
            {
                notifyAudioTrackInitializationError(mediacodec);
                throw new ExoPlaybackException(mediacodec);
            }
        }
        if (getState() == 3)
        {
            audioTrack.play();
        }
        int j;
        try
        {
            j = audioTrack.handleBuffer(bytebuffer, bufferinfo.offset, bufferinfo.size, bufferinfo.presentationTimeUs);
        }
        // Misplaced declaration of an exception variable
        catch (MediaCodec mediacodec)
        {
            notifyAudioTrackWriteError(mediacodec);
            throw new ExoPlaybackException(mediacodec);
        }
        if ((j & 1) != 0)
        {
            handleDiscontinuity();
            allowPositionDiscontinuity = true;
        }
        if ((j & 2) != 0)
        {
            mediacodec.releaseOutputBuffer(i, false);
            mediacodec = codecCounters;
            mediacodec.renderedOutputBufferCount = ((CodecCounters) (mediacodec)).renderedOutputBufferCount + 1;
            return true;
        } else
        {
            return false;
        }
    }

    protected void seekTo(long l)
    {
        super.seekTo(l);
        seekToInternal(l);
    }


    private class _cls1
        implements Runnable
    {

        final MediaCodecAudioTrackRenderer this$0;
        final com.google.android.exoplayer.audio.AudioTrack.InitializationException val$e;

        public void run()
        {
            eventListener.onAudioTrackInitializationError(e);
        }

        _cls1()
        {
            this$0 = MediaCodecAudioTrackRenderer.this;
            e = initializationexception;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final MediaCodecAudioTrackRenderer this$0;
        final com.google.android.exoplayer.audio.AudioTrack.WriteException val$e;

        public void run()
        {
            eventListener.onAudioTrackWriteError(e);
        }

        _cls2()
        {
            this$0 = MediaCodecAudioTrackRenderer.this;
            e = writeexception;
            super();
        }
    }

}
