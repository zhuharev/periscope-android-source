// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.drm.DrmSessionManager;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.TraceUtil;
import com.google.android.exoplayer.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer:
//            SampleSourceTrackRenderer, SampleSource, CodecCounters, SampleHolder, 
//            MediaFormatHolder, MediaFormat, ExoPlaybackException, CryptoInfo, 
//            MediaCodecUtil, DecoderInfo

public abstract class MediaCodecTrackRenderer extends SampleSourceTrackRenderer
{
    public static class DecoderInitializationException extends Exception
    {

        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public final String decoderName;
        public final String diagnosticInfo;

        private static String buildCustomDiagnosticInfo(int i)
        {
            String s;
            if (i < 0)
            {
                s = "neg_";
            } else
            {
                s = "";
            }
            return (new StringBuilder("com.google.android.exoplayer.MediaCodecTrackRenderer_")).append(s).append(Math.abs(i)).toString();
        }

        private static String getDiagnosticInfoV21(Throwable throwable)
        {
            if (throwable instanceof android.media.MediaCodec.CodecException)
            {
                return ((android.media.MediaCodec.CodecException)throwable).getDiagnosticInfo();
            } else
            {
                return null;
            }
        }

        public DecoderInitializationException(com.google.android.exoplayer.MediaFormat mediaformat, Throwable throwable, int i)
        {
            super((new StringBuilder("Decoder init failed: [")).append(i).append("], ").append(mediaformat).toString(), throwable);
            decoderName = null;
            diagnosticInfo = buildCustomDiagnosticInfo(i);
        }

        public DecoderInitializationException(com.google.android.exoplayer.MediaFormat mediaformat, Throwable throwable, String s)
        {
            super((new StringBuilder("Decoder init failed: ")).append(s).append(", ").append(mediaformat).toString(), throwable);
            decoderName = s;
            if (Util.SDK_INT >= 21)
            {
                mediaformat = getDiagnosticInfoV21(throwable);
            } else
            {
                mediaformat = null;
            }
            diagnosticInfo = mediaformat;
        }
    }

    public static interface EventListener
    {

        public abstract void onCryptoError(android.media.MediaCodec.CryptoException cryptoexception);

        public abstract void onDecoderInitializationError(DecoderInitializationException decoderinitializationexception);

        public abstract void onDecoderInitialized(String s, long l, long l1);
    }


    private static final long MAX_CODEC_HOTSWAP_TIME_MS = 1000L;
    private static final int RECONFIGURATION_STATE_NONE = 0;
    private static final int RECONFIGURATION_STATE_QUEUE_PENDING = 2;
    private static final int RECONFIGURATION_STATE_WRITE_PENDING = 1;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    protected static final int SOURCE_STATE_NOT_READY = 0;
    protected static final int SOURCE_STATE_READY = 1;
    protected static final int SOURCE_STATE_READY_READ_MAY_FAIL = 2;
    private MediaCodec codec;
    public final CodecCounters codecCounters = new CodecCounters();
    private boolean codecHasQueuedBuffers;
    private long codecHotswapTimeMs;
    private boolean codecIsAdaptive;
    private boolean codecNeedsEosFlushWorkaround;
    private boolean codecNeedsEosPropagationWorkaround;
    private boolean codecReceivedEos;
    private int codecReconfigurationState;
    private boolean codecReconfigured;
    private int codecReinitializationState;
    private final List decodeOnlyPresentationTimestamps = new ArrayList();
    private DrmInitData drmInitData;
    private final DrmSessionManager drmSessionManager;
    protected final Handler eventHandler;
    private final EventListener eventListener;
    private com.google.android.exoplayer.MediaFormat format;
    private final MediaFormatHolder formatHolder = new MediaFormatHolder();
    private ByteBuffer inputBuffers[];
    private int inputIndex;
    private boolean inputStreamEnded;
    private boolean openedDrmSession;
    private final android.media.MediaCodec.BufferInfo outputBufferInfo = new android.media.MediaCodec.BufferInfo();
    private ByteBuffer outputBuffers[];
    private int outputIndex;
    private boolean outputStreamEnded;
    private final boolean playClearSamplesWithoutKeys;
    private final SampleHolder sampleHolder = new SampleHolder(0);
    private int sourceState;
    private boolean waitingForFirstSyncFrame;
    private boolean waitingForKeys;

    public MediaCodecTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag, Handler handler, EventListener eventlistener)
    {
        super(new SampleSource[] {
            samplesource
        });
        boolean flag1;
        if (Util.SDK_INT >= 16)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        drmSessionManager = drmsessionmanager;
        playClearSamplesWithoutKeys = flag;
        eventHandler = handler;
        eventListener = eventlistener;
        codecReconfigurationState = 0;
        codecReinitializationState = 0;
    }

    private void checkForDiscontinuity(long l)
    {
        if (codec == null)
        {
            return;
        }
        if (readSource(l, formatHolder, sampleHolder, true) == -5)
        {
            flushCodec();
        }
    }

    private static boolean codecNeedsEosFlushWorkaround(String s)
    {
        return Util.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(s);
    }

    private static boolean codecNeedsEosPropagationWorkaround(String s)
    {
        return Util.SDK_INT <= 17 && "OMX.rk.video_decoder.avc".equals(s) && ("ht7s3".equals(Util.DEVICE) || "rk30sdk".equals(Util.DEVICE) || "rk31sdk".equals(Util.DEVICE));
    }

    private boolean drainOutputBuffer(long l, long l1)
    {
        if (outputStreamEnded)
        {
            return false;
        }
        if (outputIndex < 0)
        {
            outputIndex = codec.dequeueOutputBuffer(outputBufferInfo, getDequeueOutputBufferTimeoutUs());
        }
        if (outputIndex == -2)
        {
            onOutputFormatChanged(codec.getOutputFormat());
            CodecCounters codeccounters = codecCounters;
            codeccounters.outputFormatChangedCount = codeccounters.outputFormatChangedCount + 1;
            return true;
        }
        if (outputIndex == -3)
        {
            outputBuffers = codec.getOutputBuffers();
            CodecCounters codeccounters1 = codecCounters;
            codeccounters1.outputBuffersChangedCount = codeccounters1.outputBuffersChangedCount + 1;
            return true;
        }
        if (outputIndex < 0)
        {
            if (codecNeedsEosPropagationWorkaround && (inputStreamEnded || codecReinitializationState == 2))
            {
                processEndOfStream();
                return true;
            } else
            {
                return false;
            }
        }
        if ((outputBufferInfo.flags & 4) != 0)
        {
            processEndOfStream();
            return false;
        }
        int i = getDecodeOnlyIndex(outputBufferInfo.presentationTimeUs);
        MediaCodec mediacodec = codec;
        ByteBuffer bytebuffer = outputBuffers[outputIndex];
        android.media.MediaCodec.BufferInfo bufferinfo = outputBufferInfo;
        int j = outputIndex;
        boolean flag;
        if (i != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (processOutputBuffer(l, l1, mediacodec, bytebuffer, bufferinfo, j, flag))
        {
            if (i != -1)
            {
                decodeOnlyPresentationTimestamps.remove(i);
            }
            outputIndex = -1;
            return true;
        } else
        {
            return false;
        }
    }

    private boolean feedInputBuffer(long l, boolean flag)
    {
        if (inputStreamEnded || codecReinitializationState == 2)
        {
            return false;
        }
        if (inputIndex < 0)
        {
            inputIndex = codec.dequeueInputBuffer(0L);
            if (inputIndex < 0)
            {
                return false;
            }
            sampleHolder.data = inputBuffers[inputIndex];
            sampleHolder.clearData();
        }
        if (codecReinitializationState == 1)
        {
            if (!codecNeedsEosPropagationWorkaround)
            {
                codecReceivedEos = true;
                codec.queueInputBuffer(inputIndex, 0, 0, 0L, 4);
                inputIndex = -1;
            }
            codecReinitializationState = 2;
            return false;
        }
        int i;
        if (waitingForKeys)
        {
            i = -3;
        } else
        {
            if (codecReconfigurationState == 1)
            {
                for (i = 0; i < format.initializationData.size(); i++)
                {
                    byte abyte0[] = (byte[])format.initializationData.get(i);
                    sampleHolder.data.put(abyte0);
                }

                codecReconfigurationState = 2;
            }
            int j = readSource(l, formatHolder, sampleHolder, false);
            i = j;
            if (flag)
            {
                i = j;
                if (sourceState == 1)
                {
                    i = j;
                    if (j == -2)
                    {
                        sourceState = 2;
                        i = j;
                    }
                }
            }
        }
        if (i == -2)
        {
            return false;
        }
        if (i == -5)
        {
            flushCodec();
            return true;
        }
        if (i == -4)
        {
            if (codecReconfigurationState == 2)
            {
                sampleHolder.clearData();
                codecReconfigurationState = 1;
            }
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (i == -1)
        {
            if (codecReconfigurationState == 2)
            {
                sampleHolder.clearData();
                codecReconfigurationState = 1;
            }
            inputStreamEnded = true;
            if (!codecHasQueuedBuffers)
            {
                processEndOfStream();
                return false;
            }
            try
            {
                if (!codecNeedsEosPropagationWorkaround)
                {
                    codecReceivedEos = true;
                    codec.queueInputBuffer(inputIndex, 0, 0, 0L, 4);
                    inputIndex = -1;
                }
            }
            catch (android.media.MediaCodec.CryptoException cryptoexception)
            {
                notifyCryptoError(cryptoexception);
                throw new ExoPlaybackException(cryptoexception);
            }
            return false;
        }
        if (waitingForFirstSyncFrame)
        {
            if (!sampleHolder.isSyncFrame())
            {
                sampleHolder.clearData();
                if (codecReconfigurationState == 2)
                {
                    codecReconfigurationState = 1;
                }
                return true;
            }
            waitingForFirstSyncFrame = false;
        }
        flag = sampleHolder.isEncrypted();
        waitingForKeys = shouldWaitForKeys(flag);
        if (waitingForKeys)
        {
            return false;
        }
        android.media.MediaCodec.CryptoInfo cryptoinfo;
        int k;
        try
        {
            i = sampleHolder.data.position();
            k = sampleHolder.size;
            l = sampleHolder.timeUs;
            if (sampleHolder.isDecodeOnly())
            {
                decodeOnlyPresentationTimestamps.add(Long.valueOf(l));
            }
        }
        catch (android.media.MediaCodec.CryptoException cryptoexception1)
        {
            notifyCryptoError(cryptoexception1);
            throw new ExoPlaybackException(cryptoexception1);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_577;
        }
        cryptoinfo = getFrameworkCryptoInfo(sampleHolder, i - k);
        codec.queueSecureInputBuffer(inputIndex, 0, cryptoinfo, l, 0);
        break MISSING_BLOCK_LABEL_593;
        codec.queueInputBuffer(inputIndex, 0, i, l, 0);
        inputIndex = -1;
        codecHasQueuedBuffers = true;
        codecReconfigurationState = 0;
        return true;
    }

    private void flushCodec()
    {
        codecHotswapTimeMs = -1L;
        inputIndex = -1;
        outputIndex = -1;
        waitingForFirstSyncFrame = true;
        waitingForKeys = false;
        decodeOnlyPresentationTimestamps.clear();
        if (Util.SDK_INT < 18 || codecNeedsEosFlushWorkaround && codecReceivedEos)
        {
            releaseCodec();
            maybeInitCodec();
        } else
        if (codecReinitializationState != 0)
        {
            releaseCodec();
            maybeInitCodec();
        } else
        {
            codec.flush();
            codecHasQueuedBuffers = false;
        }
        if (codecReconfigured && format != null)
        {
            codecReconfigurationState = 1;
        }
    }

    private int getDecodeOnlyIndex(long l)
    {
        int j = decodeOnlyPresentationTimestamps.size();
        for (int i = 0; i < j; i++)
        {
            if (((Long)decodeOnlyPresentationTimestamps.get(i)).longValue() == l)
            {
                return i;
            }
        }

        return -1;
    }

    private static android.media.MediaCodec.CryptoInfo getFrameworkCryptoInfo(SampleHolder sampleholder, int i)
    {
        sampleholder = sampleholder.cryptoInfo.getFrameworkCryptoInfoV16();
        if (i == 0)
        {
            return sampleholder;
        }
        if (((android.media.MediaCodec.CryptoInfo) (sampleholder)).numBytesOfClearData == null)
        {
            sampleholder.numBytesOfClearData = new int[1];
        }
        int ai[] = ((android.media.MediaCodec.CryptoInfo) (sampleholder)).numBytesOfClearData;
        ai[0] = ai[0] + i;
        return sampleholder;
    }

    private boolean isWithinHotswapPeriod()
    {
        return SystemClock.elapsedRealtime() < codecHotswapTimeMs + 1000L;
    }

    private void notifyAndThrowDecoderInitError(DecoderInitializationException decoderinitializationexception)
    {
        notifyDecoderInitializationError(decoderinitializationexception);
        throw new ExoPlaybackException(decoderinitializationexception);
    }

    private void notifyCryptoError(final android.media.MediaCodec.CryptoException e)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls2());
        }
    }

    private void notifyDecoderInitializationError(final DecoderInitializationException e)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls1());
        }
    }

    private void notifyDecoderInitialized(final String decoderName, final long initializedTimestamp, final long initializationDuration)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls3());
        }
    }

    private void processEndOfStream()
    {
        if (codecReinitializationState == 2)
        {
            releaseCodec();
            maybeInitCodec();
            return;
        } else
        {
            outputStreamEnded = true;
            onOutputStreamEnded();
            return;
        }
    }

    private void readFormat(long l)
    {
        if (readSource(l, formatHolder, sampleHolder, false) == -4)
        {
            onInputFormatChanged(formatHolder);
        }
    }

    private void seekToInternal()
    {
        sourceState = 0;
        inputStreamEnded = false;
        outputStreamEnded = false;
    }

    private boolean shouldWaitForKeys(boolean flag)
    {
        if (!openedDrmSession)
        {
            return false;
        }
        int i = drmSessionManager.getState();
        if (i == 0)
        {
            throw new ExoPlaybackException(drmSessionManager.getError());
        }
        return i != 4 && (flag || !playClearSamplesWithoutKeys);
    }

    protected boolean canReconfigureCodec(MediaCodec mediacodec, boolean flag, com.google.android.exoplayer.MediaFormat mediaformat, com.google.android.exoplayer.MediaFormat mediaformat1)
    {
        return false;
    }

    protected final boolean codecInitialized()
    {
        return codec != null;
    }

    protected void configureCodec(MediaCodec mediacodec, String s, boolean flag, MediaFormat mediaformat, MediaCrypto mediacrypto)
    {
        mediacodec.configure(mediaformat, null, mediacrypto, 0);
    }

    protected void doSomeWork(long l, long l1)
    {
        int i;
        if (continueBufferingSource(l))
        {
            if (sourceState == 0)
            {
                i = 1;
            } else
            {
                i = sourceState;
            }
        } else
        {
            i = 0;
        }
        sourceState = i;
        checkForDiscontinuity(l);
        if (format == null)
        {
            readFormat(l);
        }
        if (codec == null && shouldInitCodec())
        {
            maybeInitCodec();
        }
        if (codec != null)
        {
            TraceUtil.beginSection("drainAndFeed");
            while (drainOutputBuffer(l, l1)) ;
            if (feedInputBuffer(l, true))
            {
                while (feedInputBuffer(l, false)) ;
            }
            TraceUtil.endSection();
        }
        codecCounters.ensureUpdated();
    }

    protected DecoderInfo getDecoderInfo(String s, boolean flag)
    {
        return MediaCodecUtil.getDecoderInfo(s, flag);
    }

    protected long getDequeueOutputBufferTimeoutUs()
    {
        return 0L;
    }

    protected final int getSourceState()
    {
        return sourceState;
    }

    protected final boolean haveFormat()
    {
        return format != null;
    }

    protected boolean isEnded()
    {
        return outputStreamEnded;
    }

    protected boolean isReady()
    {
        return format != null && !waitingForKeys && (sourceState != 0 || outputIndex >= 0 || isWithinHotswapPeriod());
    }

    protected final void maybeInitCodec()
    {
        Object obj;
        DecoderInfo decoderinfo;
        Object obj1;
        boolean flag;
        if (!shouldInitCodec())
        {
            return;
        }
        obj1 = format.mimeType;
        obj = null;
        flag = false;
        if (drmInitData != null)
        {
            if (drmSessionManager == null)
            {
                throw new ExoPlaybackException("Media requires a DrmSessionManager");
            }
            if (!openedDrmSession)
            {
                drmSessionManager.open(drmInitData);
                openedDrmSession = true;
            }
            int i = drmSessionManager.getState();
            if (i == 0)
            {
                throw new ExoPlaybackException(drmSessionManager.getError());
            }
            if (i == 3 || i == 4)
            {
                obj = drmSessionManager.getMediaCrypto();
                flag = drmSessionManager.requiresSecureDecoderComponent(((String) (obj1)));
            } else
            {
                return;
            }
        }
        decoderinfo = null;
        obj1 = getDecoderInfo(((String) (obj1)), flag);
        decoderinfo = ((DecoderInfo) (obj1));
        break MISSING_BLOCK_LABEL_177;
        MediaCodecUtil.DecoderQueryException decoderqueryexception;
        decoderqueryexception;
        notifyAndThrowDecoderInitError(new DecoderInitializationException(format, decoderqueryexception, -49998));
        if (decoderinfo == null)
        {
            notifyAndThrowDecoderInitError(new DecoderInitializationException(format, null, -49999));
        }
        String s = decoderinfo.name;
        codecIsAdaptive = decoderinfo.adaptive;
        codecNeedsEosPropagationWorkaround = codecNeedsEosPropagationWorkaround(s);
        codecNeedsEosFlushWorkaround = codecNeedsEosFlushWorkaround(s);
        try
        {
            long l = SystemClock.elapsedRealtime();
            TraceUtil.beginSection((new StringBuilder("createByCodecName(")).append(s).append(")").toString());
            codec = MediaCodec.createByCodecName(s);
            TraceUtil.endSection();
            TraceUtil.beginSection("configureCodec");
            configureCodec(codec, s, codecIsAdaptive, format.getFrameworkMediaFormatV16(), ((MediaCrypto) (obj)));
            TraceUtil.endSection();
            TraceUtil.beginSection("codec.start()");
            codec.start();
            TraceUtil.endSection();
            long l2 = SystemClock.elapsedRealtime();
            notifyDecoderInitialized(s, l2, l2 - l);
            inputBuffers = codec.getInputBuffers();
            outputBuffers = codec.getOutputBuffers();
        }
        catch (Exception exception)
        {
            notifyAndThrowDecoderInitError(new DecoderInitializationException(format, exception, s));
        }
        long l1;
        if (getState() == 3)
        {
            l1 = SystemClock.elapsedRealtime();
        } else
        {
            l1 = -1L;
        }
        codecHotswapTimeMs = l1;
        inputIndex = -1;
        outputIndex = -1;
        waitingForFirstSyncFrame = true;
        exception = codecCounters;
        exception.codecInitCount = ((CodecCounters) (exception)).codecInitCount + 1;
        return;
    }

    protected void onDisabled()
    {
        format = null;
        drmInitData = null;
        releaseCodec();
        if (openedDrmSession)
        {
            drmSessionManager.close();
            openedDrmSession = false;
        }
        super.onDisabled();
        return;
        Exception exception;
        exception;
        super.onDisabled();
        throw exception;
        exception;
        if (openedDrmSession)
        {
            drmSessionManager.close();
            openedDrmSession = false;
        }
        super.onDisabled();
        break MISSING_BLOCK_LABEL_83;
        exception;
        super.onDisabled();
        throw exception;
        throw exception;
    }

    protected void onEnabled(int i, long l, boolean flag)
    {
        super.onEnabled(i, l, flag);
        seekToInternal();
    }

    protected void onInputFormatChanged(MediaFormatHolder mediaformatholder)
    {
        com.google.android.exoplayer.MediaFormat mediaformat = format;
        format = mediaformatholder.format;
        drmInitData = mediaformatholder.drmInitData;
        if (codec != null && canReconfigureCodec(codec, codecIsAdaptive, mediaformat, format))
        {
            codecReconfigured = true;
            codecReconfigurationState = 1;
            return;
        }
        if (codecHasQueuedBuffers)
        {
            codecReinitializationState = 1;
            return;
        } else
        {
            releaseCodec();
            maybeInitCodec();
            return;
        }
    }

    protected void onOutputFormatChanged(MediaFormat mediaformat)
    {
    }

    protected void onOutputStreamEnded()
    {
    }

    protected void onStarted()
    {
    }

    protected void onStopped()
    {
    }

    protected abstract boolean processOutputBuffer(long l, long l1, MediaCodec mediacodec, ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo, 
            int i, boolean flag);

    protected void releaseCodec()
    {
        if (codec == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        codecHotswapTimeMs = -1L;
        inputIndex = -1;
        outputIndex = -1;
        waitingForKeys = false;
        decodeOnlyPresentationTimestamps.clear();
        inputBuffers = null;
        outputBuffers = null;
        codecReconfigured = false;
        codecHasQueuedBuffers = false;
        codecIsAdaptive = false;
        codecNeedsEosPropagationWorkaround = false;
        codecNeedsEosFlushWorkaround = false;
        codecReceivedEos = false;
        codecReconfigurationState = 0;
        codecReinitializationState = 0;
        CodecCounters codeccounters = codecCounters;
        codeccounters.codecReleaseCount = codeccounters.codecReleaseCount + 1;
        codec.stop();
        codec.release();
        codec = null;
        return;
        Exception exception;
        exception;
        codec = null;
        throw exception;
        exception;
        codec.release();
        codec = null;
        break MISSING_BLOCK_LABEL_155;
        exception;
        codec = null;
        throw exception;
        throw exception;
    }

    protected void seekTo(long l)
    {
        super.seekTo(l);
        seekToInternal();
    }

    protected boolean shouldInitCodec()
    {
        return codec == null && format != null;
    }


    private class _cls2
        implements Runnable
    {

        final MediaCodecTrackRenderer this$0;
        final android.media.MediaCodec.CryptoException val$e;

        public void run()
        {
            eventListener.onCryptoError(e);
        }

        _cls2()
        {
            this$0 = MediaCodecTrackRenderer.this;
            e = cryptoexception;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final MediaCodecTrackRenderer this$0;
        final DecoderInitializationException val$e;

        public void run()
        {
            eventListener.onDecoderInitializationError(e);
        }

        _cls1()
        {
            this$0 = MediaCodecTrackRenderer.this;
            e = decoderinitializationexception;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final MediaCodecTrackRenderer this$0;
        final String val$decoderName;
        final long val$initializationDuration;
        final long val$initializedTimestamp;

        public void run()
        {
            eventListener.onDecoderInitialized(decoderName, initializedTimestamp, initializationDuration);
        }

        _cls3()
        {
            this$0 = MediaCodecTrackRenderer.this;
            decoderName = s;
            initializedTimestamp = l;
            initializationDuration = l1;
            super();
        }
    }

}
