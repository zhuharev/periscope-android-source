// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.audio;

import android.media.AudioTimestamp;
import android.media.MediaFormat;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer.util.Ac3Util;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.exoplayer.audio:
//            AudioCapabilities

public final class AudioTrack
{
    static class AudioTrackUtil
    {

        protected android.media.AudioTrack audioTrack;
        private long endPlaybackHeadPosition;
        private boolean isPassthrough;
        private long lastRawPlaybackHeadPosition;
        private long passthroughWorkaroundPauseOffset;
        private long rawPlaybackHeadWrapCount;
        private int sampleRate;
        private long stopPlaybackHeadPosition;
        private long stopTimestampUs;

        public long getPlaybackHeadPosition()
        {
            if (stopTimestampUs != -1L)
            {
                long l = ((SystemClock.elapsedRealtime() * 1000L - stopTimestampUs) * (long)sampleRate) / 0xf4240L;
                return Math.min(endPlaybackHeadPosition, stopPlaybackHeadPosition + l);
            }
            int i = audioTrack.getPlayState();
            if (i == 1)
            {
                return 0L;
            }
            long l2 = 0xffffffffL & (long)audioTrack.getPlaybackHeadPosition();
            long l1 = l2;
            if (Util.SDK_INT <= 22)
            {
                l1 = l2;
                if (isPassthrough)
                {
                    if (i == 2 && l2 == 0L)
                    {
                        passthroughWorkaroundPauseOffset = lastRawPlaybackHeadPosition;
                    }
                    l1 = l2 + passthroughWorkaroundPauseOffset;
                }
            }
            if (lastRawPlaybackHeadPosition > l1)
            {
                rawPlaybackHeadWrapCount = rawPlaybackHeadWrapCount + 1L;
            }
            lastRawPlaybackHeadPosition = l1;
            return (rawPlaybackHeadWrapCount << 32) + l1;
        }

        public long getPlaybackHeadPositionUs()
        {
            return (getPlaybackHeadPosition() * 0xf4240L) / (long)sampleRate;
        }

        public long getTimestampFramePosition()
        {
            throw new UnsupportedOperationException();
        }

        public long getTimestampNanoTime()
        {
            throw new UnsupportedOperationException();
        }

        public void handleEndOfStream(long l)
        {
            stopPlaybackHeadPosition = getPlaybackHeadPosition();
            stopTimestampUs = SystemClock.elapsedRealtime() * 1000L;
            endPlaybackHeadPosition = l;
            audioTrack.stop();
        }

        public boolean overrideHasPendingData()
        {
            return Util.SDK_INT <= 22 && isPassthrough && audioTrack.getPlayState() == 2 && audioTrack.getPlaybackHeadPosition() == 0;
        }

        public void pause()
        {
            if (stopTimestampUs != -1L)
            {
                return;
            } else
            {
                audioTrack.pause();
                return;
            }
        }

        public void reconfigure(android.media.AudioTrack audiotrack, boolean flag)
        {
            audioTrack = audiotrack;
            isPassthrough = flag;
            stopTimestampUs = -1L;
            lastRawPlaybackHeadPosition = 0L;
            rawPlaybackHeadWrapCount = 0L;
            passthroughWorkaroundPauseOffset = 0L;
            if (audiotrack != null)
            {
                sampleRate = audiotrack.getSampleRate();
            }
        }

        public boolean updateTimestamp()
        {
            return false;
        }

        private AudioTrackUtil()
        {
        }

        AudioTrackUtil(_cls1 _pcls1)
        {
            this();
        }
    }

    static class AudioTrackUtilV19 extends AudioTrackUtil
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

        public void reconfigure(android.media.AudioTrack audiotrack, boolean flag)
        {
            super.reconfigure(audiotrack, flag);
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

        public AudioTrackUtilV19()
        {
            super(null);
        }
    }

    public static final class InitializationException extends Exception
    {

        public final int audioTrackState;

        public InitializationException(int i, int j, int k, int l)
        {
            super((new StringBuilder("AudioTrack init failed: ")).append(i).append(", Config(").append(j).append(", ").append(k).append(", ").append(l).append(")").toString());
            audioTrackState = i;
        }
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException
    {

        public InvalidAudioTrackTimestampException(String s)
        {
            super(s);
        }
    }

    public static final class WriteException extends Exception
    {

        public final int errorCode;

        public WriteException(int i)
        {
            super((new StringBuilder("AudioTrack write failed: ")).append(i).toString());
            errorCode = i;
        }
    }


    private static final int BUFFER_MULTIPLICATION_FACTOR = 4;
    public static final long CURRENT_POSITION_NOT_SET = 0x8000000000000000L;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 0x4c4b40L;
    private static final long MAX_BUFFER_DURATION_US = 0xb71b0L;
    private static final long MAX_LATENCY_US = 0x4c4b40L;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final long MIN_BUFFER_DURATION_US = 0x3d090L;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final int MIN_TIMESTAMP_SAMPLE_INTERVAL_US = 0x7a120;
    public static final int RESULT_BUFFER_CONSUMED = 2;
    public static final int RESULT_POSITION_DISCONTINUITY = 1;
    public static final int SESSION_ID_NOT_SET = 0;
    private static final int START_IN_SYNC = 1;
    private static final int START_NEED_SYNC = 2;
    private static final int START_NOT_SET = 0;
    private static final String TAG = "AudioTrack";
    private static final int UNKNOWN_BITRATE = 0;
    public static boolean enablePreV21AudioSessionWorkaround = false;
    public static boolean failOnSpuriousAudioTimestamp = false;
    private final AudioCapabilities audioCapabilities;
    private boolean audioTimestampSet;
    private android.media.AudioTrack audioTrack;
    private final AudioTrackUtil audioTrackUtil;
    private int bufferSize;
    private int channelConfig;
    private int encoding;
    private int frameSize;
    private Method getLatencyMethod;
    private android.media.AudioTrack keepSessionIdAudioTrack;
    private long lastPlayheadSampleTimeUs;
    private long lastTimestampSampleTimeUs;
    private long latencyUs;
    private int minBufferSize;
    private int nextPlayheadOffsetIndex;
    private int passthroughBitrate;
    private int playheadOffsetCount;
    private final long playheadOffsets[];
    private final ConditionVariable releasingConditionVariable;
    private long resumeSystemTimeUs;
    private int sampleRate;
    private long smoothedPlayheadOffsetUs;
    private int startMediaTimeState;
    private long startMediaTimeUs;
    private final int streamType;
    private long submittedBytes;
    private byte temporaryBuffer[];
    private int temporaryBufferOffset;
    private int temporaryBufferSize;
    private float volume;

    public AudioTrack()
    {
        this(null, 3);
    }

    public AudioTrack(AudioCapabilities audiocapabilities, int i)
    {
        audioCapabilities = audiocapabilities;
        streamType = i;
        releasingConditionVariable = new ConditionVariable(true);
        if (Util.SDK_INT >= 18)
        {
            try
            {
                getLatencyMethod = android/media/AudioTrack.getMethod("getLatency", null);
            }
            // Misplaced declaration of an exception variable
            catch (AudioCapabilities audiocapabilities) { }
        }
        if (Util.SDK_INT >= 19)
        {
            audioTrackUtil = new AudioTrackUtilV19();
        } else
        {
            audioTrackUtil = new AudioTrackUtil(null);
        }
        playheadOffsets = new long[10];
        volume = 1.0F;
        startMediaTimeState = 0;
    }

    private long bytesToFrames(long l)
    {
        if (isPassthrough())
        {
            if (passthroughBitrate == 0)
            {
                return 0L;
            } else
            {
                return ((l << 3) * (long)sampleRate) / (long)(passthroughBitrate * 1000);
            }
        } else
        {
            return l / (long)frameSize;
        }
    }

    private void checkAudioTrackInitialized()
    {
        int i;
        i = audioTrack.getState();
        if (i == 1)
        {
            return;
        }
        audioTrack.release();
        audioTrack = null;
          goto _L1
_L3:
        audioTrack = null;
          goto _L1
        Object obj;
        obj;
        audioTrack = null;
        throw obj;
_L1:
        throw new InitializationException(i, sampleRate, channelConfig, bufferSize);
        obj;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private long durationUsToFrames(long l)
    {
        return ((long)sampleRate * l) / 0xf4240L;
    }

    private long framesToDurationUs(long l)
    {
        return (0xf4240L * l) / (long)sampleRate;
    }

    private static int getEncodingForMimeType(String s)
    {
        if ("audio/ac3".equals(s))
        {
            return 5;
        }
        return !"audio/eac3".equals(s) ? 0 : 6;
    }

    private boolean hasCurrentPositionUs()
    {
        return isInitialized() && startMediaTimeState != 0;
    }

    private boolean isPassthrough()
    {
        return encoding == 5 || encoding == 6;
    }

    private void maybeSampleSyncParams()
    {
        Exception exception;
        long l = audioTrackUtil.getPlaybackHeadPositionUs();
        if (l == 0L)
        {
            return;
        }
        long l1 = System.nanoTime() / 1000L;
        if (l1 - lastPlayheadSampleTimeUs >= 30000L)
        {
            playheadOffsets[nextPlayheadOffsetIndex] = l - l1;
            nextPlayheadOffsetIndex = (nextPlayheadOffsetIndex + 1) % 10;
            if (playheadOffsetCount < 10)
            {
                playheadOffsetCount = playheadOffsetCount + 1;
            }
            lastPlayheadSampleTimeUs = l1;
            smoothedPlayheadOffsetUs = 0L;
            for (int i = 0; i < playheadOffsetCount; i++)
            {
                smoothedPlayheadOffsetUs = smoothedPlayheadOffsetUs + playheadOffsets[i] / (long)playheadOffsetCount;
            }

        }
        if (!isPassthrough() && l1 - lastTimestampSampleTimeUs >= 0x7a120L)
        {
            audioTimestampSet = audioTrackUtil.updateTimestamp();
            if (audioTimestampSet)
            {
                long l2 = audioTrackUtil.getTimestampNanoTime() / 1000L;
                long l3 = audioTrackUtil.getTimestampFramePosition();
                if (l2 < resumeSystemTimeUs)
                {
                    audioTimestampSet = false;
                } else
                if (Math.abs(l2 - l1) > 0x4c4b40L)
                {
                    String s = (new StringBuilder("Spurious audio timestamp (system clock mismatch): ")).append(l3).append(", ").append(l2).append(", ").append(l1).append(", ").append(l).toString();
                    if (failOnSpuriousAudioTimestamp)
                    {
                        throw new InvalidAudioTrackTimestampException(s);
                    }
                    Log.w("AudioTrack", s);
                    audioTimestampSet = false;
                } else
                if (Math.abs(framesToDurationUs(l3) - l) > 0x4c4b40L)
                {
                    String s1 = (new StringBuilder("Spurious audio timestamp (frame position mismatch): ")).append(l3).append(", ").append(l2).append(", ").append(l1).append(", ").append(l).toString();
                    if (failOnSpuriousAudioTimestamp)
                    {
                        throw new InvalidAudioTrackTimestampException(s1);
                    }
                    Log.w("AudioTrack", s1);
                    audioTimestampSet = false;
                }
            }
            if (getLatencyMethod != null)
            {
                try
                {
                    latencyUs = (long)((Integer)getLatencyMethod.invoke(audioTrack, null)).intValue() * 1000L - framesToDurationUs(bytesToFrames(bufferSize));
                    latencyUs = Math.max(latencyUs, 0L);
                    if (latencyUs > 0x4c4b40L)
                    {
                        Log.w("AudioTrack", (new StringBuilder("Ignoring impossibly large audio latency: ")).append(latencyUs).toString());
                        latencyUs = 0L;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    getLatencyMethod = null;
                }
            }
            lastTimestampSampleTimeUs = l1;
        }
    }

    private void releaseKeepSessionIdAudioTrack()
    {
        if (keepSessionIdAudioTrack == null)
        {
            return;
        } else
        {
            final android.media.AudioTrack toRelease = keepSessionIdAudioTrack;
            keepSessionIdAudioTrack = null;
            (new _cls2()).start();
            return;
        }
    }

    private void resetSyncParams()
    {
        smoothedPlayheadOffsetUs = 0L;
        playheadOffsetCount = 0;
        nextPlayheadOffsetIndex = 0;
        lastPlayheadSampleTimeUs = 0L;
        audioTimestampSet = false;
        lastTimestampSampleTimeUs = 0L;
    }

    private void setAudioTrackVolume()
    {
        if (isInitialized())
        {
            if (Util.SDK_INT >= 21)
            {
                setAudioTrackVolumeV21(audioTrack, volume);
                return;
            }
            setAudioTrackVolumeV3(audioTrack, volume);
        }
    }

    private static void setAudioTrackVolumeV21(android.media.AudioTrack audiotrack, float f)
    {
        audiotrack.setVolume(f);
    }

    private static void setAudioTrackVolumeV3(android.media.AudioTrack audiotrack, float f)
    {
        audiotrack.setStereoVolume(f, f);
    }

    private static int writeNonBlockingV21(android.media.AudioTrack audiotrack, ByteBuffer bytebuffer, int i)
    {
        return audiotrack.write(bytebuffer, i, 1);
    }

    public final long getCurrentPositionUs(boolean flag)
    {
        if (!hasCurrentPositionUs())
        {
            return 0x8000000000000000L;
        }
        if (audioTrack.getPlayState() == 3)
        {
            maybeSampleSyncParams();
        }
        long l = System.nanoTime() / 1000L;
        if (audioTimestampSet)
        {
            l = durationUsToFrames(l - audioTrackUtil.getTimestampNanoTime() / 1000L);
            return framesToDurationUs(audioTrackUtil.getTimestampFramePosition() + l) + startMediaTimeUs;
        }
        if (playheadOffsetCount == 0)
        {
            l = audioTrackUtil.getPlaybackHeadPositionUs() + startMediaTimeUs;
        } else
        {
            l = smoothedPlayheadOffsetUs + l + startMediaTimeUs;
        }
        long l1 = l;
        if (!flag)
        {
            l1 = l - latencyUs;
        }
        return l1;
    }

    public final int handleBuffer(ByteBuffer bytebuffer, int i, int j, long l)
    {
        if (j == 0)
        {
            return 2;
        }
        if (Util.SDK_INT <= 22 && isPassthrough())
        {
            if (audioTrack.getPlayState() == 2)
            {
                return 0;
            }
            if (audioTrack.getPlayState() == 1 && audioTrackUtil.getPlaybackHeadPosition() != 0L)
            {
                return 0;
            }
        }
        boolean flag = false;
        int k = ((flag) ? 1 : 0);
        if (temporaryBufferSize == 0)
        {
            if (isPassthrough() && passthroughBitrate == 0)
            {
                passthroughBitrate = Ac3Util.getBitrate(j, sampleRate);
            }
            l -= framesToDurationUs(bytesToFrames(j));
            if (startMediaTimeState == 0)
            {
                startMediaTimeUs = Math.max(0L, l);
                startMediaTimeState = 1;
                k = ((flag) ? 1 : 0);
            } else
            {
                long l1 = startMediaTimeUs + framesToDurationUs(bytesToFrames(submittedBytes));
                if (startMediaTimeState == 1 && Math.abs(l1 - l) > 0x30d40L)
                {
                    Log.e("AudioTrack", (new StringBuilder("Discontinuity detected [expected ")).append(l1).append(", got ").append(l).append("]").toString());
                    startMediaTimeState = 2;
                }
                k = ((flag) ? 1 : 0);
                if (startMediaTimeState == 2)
                {
                    startMediaTimeUs = startMediaTimeUs + (l - l1);
                    startMediaTimeState = 1;
                    k = 1;
                }
            }
        }
        if (temporaryBufferSize == 0)
        {
            temporaryBufferSize = j;
            bytebuffer.position(i);
            if (Util.SDK_INT < 21)
            {
                if (temporaryBuffer == null || temporaryBuffer.length < j)
                {
                    temporaryBuffer = new byte[j];
                }
                bytebuffer.get(temporaryBuffer, 0, j);
                temporaryBufferOffset = 0;
            }
        }
        i = 0;
        if (Util.SDK_INT < 21)
        {
            j = (int)(submittedBytes - audioTrackUtil.getPlaybackHeadPosition() * (long)frameSize);
            j = bufferSize - j;
            if (j > 0)
            {
                i = Math.min(temporaryBufferSize, j);
                int i1 = audioTrack.write(temporaryBuffer, temporaryBufferOffset, i);
                j = i1;
                i = j;
                if (i1 >= 0)
                {
                    temporaryBufferOffset = temporaryBufferOffset + j;
                    i = j;
                }
            }
        } else
        {
            i = writeNonBlockingV21(audioTrack, bytebuffer, temporaryBufferSize);
        }
        if (i < 0)
        {
            throw new WriteException(i);
        }
        temporaryBufferSize = temporaryBufferSize - i;
        submittedBytes = submittedBytes + (long)i;
        i = k;
        if (temporaryBufferSize == 0)
        {
            i = k | 2;
        }
        return i;
    }

    public final void handleDiscontinuity()
    {
        if (startMediaTimeState == 1)
        {
            startMediaTimeState = 2;
        }
    }

    public final void handleEndOfStream()
    {
        if (isInitialized())
        {
            audioTrackUtil.handleEndOfStream(bytesToFrames(submittedBytes));
        }
    }

    public final boolean hasPendingData()
    {
        return isInitialized() && (bytesToFrames(submittedBytes) > audioTrackUtil.getPlaybackHeadPosition() || audioTrackUtil.overrideHasPendingData());
    }

    public final int initialize()
    {
        return initialize(0);
    }

    public final int initialize(int i)
    {
        releasingConditionVariable.block();
        if (i == 0)
        {
            audioTrack = new android.media.AudioTrack(streamType, sampleRate, channelConfig, encoding, bufferSize, 1);
        } else
        {
            audioTrack = new android.media.AudioTrack(streamType, sampleRate, channelConfig, encoding, bufferSize, 1, i);
        }
        checkAudioTrackInitialized();
        i = audioTrack.getAudioSessionId();
        if (enablePreV21AudioSessionWorkaround && Util.SDK_INT < 21)
        {
            if (keepSessionIdAudioTrack != null && i != keepSessionIdAudioTrack.getAudioSessionId())
            {
                releaseKeepSessionIdAudioTrack();
            }
            if (keepSessionIdAudioTrack == null)
            {
                keepSessionIdAudioTrack = new android.media.AudioTrack(streamType, 4000, 4, 2, 2, 0, i);
            }
        }
        audioTrackUtil.reconfigure(audioTrack, isPassthrough());
        setAudioTrackVolume();
        return i;
    }

    public final boolean isInitialized()
    {
        return audioTrack != null;
    }

    public final boolean isPassthroughSupported(String s)
    {
        return audioCapabilities != null && audioCapabilities.supportsEncoding(getEncodingForMimeType(s));
    }

    public final void pause()
    {
        if (isInitialized())
        {
            resetSyncParams();
            audioTrackUtil.pause();
        }
    }

    public final void play()
    {
        if (isInitialized())
        {
            resumeSystemTimeUs = System.nanoTime() / 1000L;
            audioTrack.play();
        }
    }

    public final void reconfigure(MediaFormat mediaformat, boolean flag)
    {
        reconfigure(mediaformat, flag, 0);
    }

    public final void reconfigure(MediaFormat mediaformat, boolean flag, int i)
    {
        int j1 = mediaformat.getInteger("channel-count");
        int j;
        switch (j1)
        {
        case 1: // '\001'
            j = 4;
            break;

        case 2: // '\002'
            j = 12;
            break;

        case 6: // '\006'
            j = 252;
            break;

        case 8: // '\b'
            j = 1020;
            break;

        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 7: // '\007'
        default:
            throw new IllegalArgumentException((new StringBuilder("Unsupported channel count: ")).append(j1).toString());
        }
        int k1 = mediaformat.getInteger("sample-rate");
        mediaformat = mediaformat.getString("mime");
        int l;
        if (flag)
        {
            l = getEncodingForMimeType(mediaformat);
        } else
        {
            l = 2;
        }
        if (isInitialized() && sampleRate == k1 && channelConfig == j && encoding == l)
        {
            return;
        }
        reset();
        encoding = l;
        sampleRate = k1;
        channelConfig = j;
        passthroughBitrate = 0;
        frameSize = j1 * 2;
        minBufferSize = android.media.AudioTrack.getMinBufferSize(k1, j, l);
        if (minBufferSize != -2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (i == 0)
        {
            i = minBufferSize << 2;
            int k = (int)durationUsToFrames(0x3d090L) * frameSize;
            int i1 = (int)Math.max(minBufferSize, durationUsToFrames(0xb71b0L) * (long)frameSize);
            if (i < k)
            {
                i = k;
            } else
            if (i > i1)
            {
                i = i1;
            }
        }
        bufferSize = i;
    }

    public final void release()
    {
        reset();
        releaseKeepSessionIdAudioTrack();
    }

    public final void reset()
    {
        if (isInitialized())
        {
            submittedBytes = 0L;
            temporaryBufferSize = 0;
            startMediaTimeState = 0;
            latencyUs = 0L;
            resetSyncParams();
            if (audioTrack.getPlayState() == 3)
            {
                audioTrack.pause();
            }
            final android.media.AudioTrack toRelease = audioTrack;
            audioTrack = null;
            audioTrackUtil.reconfigure(null, false);
            releasingConditionVariable.close();
            (new _cls1()).start();
        }
    }

    public final void setVolume(float f)
    {
        if (volume != f)
        {
            volume = f;
            setAudioTrackVolume();
        }
    }

    static 
    {
        enablePreV21AudioSessionWorkaround = false;
        failOnSpuriousAudioTimestamp = false;
    }


    private class _cls2 extends Thread
    {

        final AudioTrack this$0;
        final android.media.AudioTrack val$toRelease;

        public void run()
        {
            toRelease.release();
        }

        _cls2()
        {
            this$0 = AudioTrack.this;
            toRelease = audiotrack1;
            super();
        }
    }


    private class _cls1 extends Thread
    {

        final AudioTrack this$0;
        final android.media.AudioTrack val$toRelease;

        public void run()
        {
            toRelease.flush();
            toRelease.release();
            releasingConditionVariable.open();
            return;
            Exception exception;
            exception;
            releasingConditionVariable.open();
            throw exception;
        }

        _cls1()
        {
            this$0 = AudioTrack.this;
            toRelease = audiotrack1;
            super();
        }
    }

}
