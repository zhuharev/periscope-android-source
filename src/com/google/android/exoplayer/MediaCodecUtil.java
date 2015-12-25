// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.util.HashMap;

// Referenced classes of package com.google.android.exoplayer:
//            DecoderInfo

public final class MediaCodecUtil
{
    static final class CodecKey
    {

        public final String mimeType;
        public final boolean secure;

        public final boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj == null || obj.getClass() != com/google/android/exoplayer/MediaCodecUtil$CodecKey)
            {
                return false;
            }
            obj = (CodecKey)obj;
            return TextUtils.equals(mimeType, ((CodecKey) (obj)).mimeType) && secure == ((CodecKey) (obj)).secure;
        }

        public final int hashCode()
        {
            int i;
            if (mimeType == null)
            {
                i = 0;
            } else
            {
                i = mimeType.hashCode();
            }
            char c;
            if (secure)
            {
                c = '\u04CF';
            } else
            {
                c = '\u04D5';
            }
            return (i + 31) * 31 + c;
        }

        public CodecKey(String s, boolean flag)
        {
            mimeType = s;
            secure = flag;
        }
    }

    public static class DecoderQueryException extends IOException
    {

        private DecoderQueryException(Throwable throwable)
        {
            super("Failed to query underlying media codecs", throwable);
        }

    }

    static interface MediaCodecListCompat
    {

        public abstract int getCodecCount();

        public abstract MediaCodecInfo getCodecInfoAt(int i);

        public abstract boolean isSecurePlaybackSupported(String s, android.media.MediaCodecInfo.CodecCapabilities codeccapabilities);

        public abstract boolean secureDecodersExplicit();
    }

    static final class MediaCodecListCompatV16
        implements MediaCodecListCompat
    {

        public final int getCodecCount()
        {
            return MediaCodecList.getCodecCount();
        }

        public final MediaCodecInfo getCodecInfoAt(int i)
        {
            return MediaCodecList.getCodecInfoAt(i);
        }

        public final boolean isSecurePlaybackSupported(String s, android.media.MediaCodecInfo.CodecCapabilities codeccapabilities)
        {
            return "video/avc".equals(s);
        }

        public final boolean secureDecodersExplicit()
        {
            return false;
        }

        private MediaCodecListCompatV16()
        {
        }

    }

    static final class MediaCodecListCompatV21
        implements MediaCodecListCompat
    {

        private final int codecKind;
        private MediaCodecInfo mediaCodecInfos[];

        private void ensureMediaCodecInfosInitialized()
        {
            if (mediaCodecInfos == null)
            {
                mediaCodecInfos = (new MediaCodecList(codecKind)).getCodecInfos();
            }
        }

        public final int getCodecCount()
        {
            ensureMediaCodecInfosInitialized();
            return mediaCodecInfos.length;
        }

        public final MediaCodecInfo getCodecInfoAt(int i)
        {
            ensureMediaCodecInfosInitialized();
            return mediaCodecInfos[i];
        }

        public final boolean isSecurePlaybackSupported(String s, android.media.MediaCodecInfo.CodecCapabilities codeccapabilities)
        {
            return codeccapabilities.isFeatureSupported("secure-playback");
        }

        public final boolean secureDecodersExplicit()
        {
            return true;
        }

        public MediaCodecListCompatV21(boolean flag)
        {
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            codecKind = i;
        }
    }


    private static final String TAG = "MediaCodecUtil";
    private static final HashMap codecs = new HashMap();

    private MediaCodecUtil()
    {
    }

    private static int avcLevelToMaxFrameSize(int i)
    {
        switch (i)
        {
        case 1: // '\001'
            return 25344;

        case 2: // '\002'
            return 25344;

        case 8: // '\b'
            return 0x18c00;

        case 16: // '\020'
            return 0x18c00;

        case 32: // ' '
            return 0x18c00;

        case 64: // '@'
            return 0x31800;

        case 128: 
            return 0x65400;

        case 256: 
            return 0x65400;

        case 512: 
            return 0xe1000;

        case 1024: 
            return 0x140000;

        case 2048: 
            return 0x200000;

        case 4096: 
            return 0x200000;

        case 8192: 
            return 0x220000;

        case 16384: 
            return 0x564000;

        case 32768: 
            return 0x900000;
        }
        return -1;
    }

    public static DecoderInfo getDecoderInfo(String s, boolean flag)
    {
        s = getMediaCodecInfo(s, flag);
        if (s == null)
        {
            return null;
        } else
        {
            return new DecoderInfo((String)((Pair) (s)).first, isAdaptive((android.media.MediaCodecInfo.CodecCapabilities)((Pair) (s)).second));
        }
    }

    private static Pair getMediaCodecInfo(CodecKey codeckey, MediaCodecListCompat mediacodeclistcompat)
    {
        try
        {
            codeckey = getMediaCodecInfoInternal(codeckey, mediacodeclistcompat);
        }
        // Misplaced declaration of an exception variable
        catch (CodecKey codeckey)
        {
            throw new DecoderQueryException(codeckey);
        }
        return codeckey;
    }

    private static Pair getMediaCodecInfo(String s, boolean flag)
    {
        com/google/android/exoplayer/MediaCodecUtil;
        JVM INSTR monitorenter ;
        CodecKey codeckey;
        codeckey = new CodecKey(s, flag);
        if (!codecs.containsKey(codeckey))
        {
            break MISSING_BLOCK_LABEL_42;
        }
        s = (Pair)codecs.get(codeckey);
        com/google/android/exoplayer/MediaCodecUtil;
        JVM INSTR monitorexit ;
        return s;
        Object obj;
        if (Util.SDK_INT >= 21)
        {
            obj = new MediaCodecListCompatV21(flag);
            break MISSING_BLOCK_LABEL_71;
        }
        obj = new MediaCodecListCompatV16();
        Pair pair = getMediaCodecInfo(codeckey, ((MediaCodecListCompat) (obj)));
        obj = pair;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        obj = pair;
        if (pair != null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        obj = pair;
        if (Util.SDK_INT < 21)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        pair = getMediaCodecInfo(codeckey, ((MediaCodecListCompat) (new MediaCodecListCompatV16())));
        obj = pair;
        if (pair == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        Log.w("MediaCodecUtil", (new StringBuilder("MediaCodecList API didn't list secure decoder for: ")).append(s).append(". Assuming: ").append((String)pair.first).toString());
        obj = pair;
        com/google/android/exoplayer/MediaCodecUtil;
        JVM INSTR monitorexit ;
        return ((Pair) (obj));
        s;
        throw s;
    }

    private static Pair getMediaCodecInfoInternal(CodecKey codeckey, MediaCodecListCompat mediacodeclistcompat)
    {
        String s1 = codeckey.mimeType;
        int k = mediacodeclistcompat.getCodecCount();
        boolean flag = mediacodeclistcompat.secureDecodersExplicit();
        for (int i = 0; i < k; i++)
        {
            MediaCodecInfo mediacodecinfo = mediacodeclistcompat.getCodecInfoAt(i);
            String s2 = mediacodecinfo.getName();
            if (!isCodecUsableDecoder(mediacodecinfo, s2, flag))
            {
                continue;
            }
            String as[] = mediacodecinfo.getSupportedTypes();
            for (int j = 0; j < as.length; j++)
            {
                String s = as[j];
                if (!s.equalsIgnoreCase(s1))
                {
                    continue;
                }
                android.media.MediaCodecInfo.CodecCapabilities codeccapabilities = mediacodecinfo.getCapabilitiesForType(s);
                boolean flag1 = mediacodeclistcompat.isSecurePlaybackSupported(codeckey.mimeType, codeccapabilities);
                if (!flag)
                {
                    HashMap hashmap = codecs;
                    CodecKey codeckey1;
                    if (codeckey.secure)
                    {
                        codeckey1 = new CodecKey(s1, false);
                    } else
                    {
                        codeckey1 = codeckey;
                    }
                    hashmap.put(codeckey1, Pair.create(s2, codeccapabilities));
                    if (flag1)
                    {
                        HashMap hashmap1 = codecs;
                        CodecKey codeckey2;
                        if (codeckey.secure)
                        {
                            codeckey2 = codeckey;
                        } else
                        {
                            codeckey2 = new CodecKey(s1, true);
                        }
                        hashmap1.put(codeckey2, Pair.create((new StringBuilder()).append(s2).append(".secure").toString(), codeccapabilities));
                    }
                } else
                {
                    HashMap hashmap2 = codecs;
                    CodecKey codeckey3;
                    if (codeckey.secure == flag1)
                    {
                        codeckey3 = codeckey;
                    } else
                    {
                        codeckey3 = new CodecKey(s1, flag1);
                    }
                    hashmap2.put(codeckey3, Pair.create(s2, codeccapabilities));
                }
                if (codecs.containsKey(codeckey))
                {
                    return (Pair)codecs.get(codeckey);
                }
            }

        }

        return null;
    }

    private static boolean isAdaptive(android.media.MediaCodecInfo.CodecCapabilities codeccapabilities)
    {
        if (Util.SDK_INT >= 19)
        {
            return isAdaptiveV19(codeccapabilities);
        } else
        {
            return false;
        }
    }

    private static boolean isAdaptiveV19(android.media.MediaCodecInfo.CodecCapabilities codeccapabilities)
    {
        return codeccapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean isCodecUsableDecoder(MediaCodecInfo mediacodecinfo, String s, boolean flag)
    {
        if (mediacodecinfo.isEncoder() || !flag && s.endsWith(".secure"))
        {
            return false;
        }
        if (Util.SDK_INT == 16 && "OMX.qcom.audio.decoder.mp3".equals(s) && ("dlxu".equals(Util.DEVICE) || "protou".equals(Util.DEVICE) || "C6602".equals(Util.DEVICE) || "C6603".equals(Util.DEVICE) || "C6606".equals(Util.DEVICE) || "C6616".equals(Util.DEVICE) || "L36h".equals(Util.DEVICE) || "SO-02E".equals(Util.DEVICE)))
        {
            return false;
        }
        if (Util.SDK_INT == 16 && "OMX.qcom.audio.decoder.aac".equals(s) && ("C1504".equals(Util.DEVICE) || "C1505".equals(Util.DEVICE) || "C1604".equals(Util.DEVICE) || "C1605".equals(Util.DEVICE)))
        {
            return false;
        }
        return Util.SDK_INT > 19 || Util.DEVICE == null || !Util.DEVICE.startsWith("serrano") || !"samsung".equals(Util.MANUFACTURER) || !s.equals("OMX.SEC.vp8.dec");
    }

    public static boolean isH264ProfileSupported(int i, int j)
    {
        Object obj = getMediaCodecInfo("video/avc", false);
        if (obj == null)
        {
            return false;
        }
        obj = (android.media.MediaCodecInfo.CodecCapabilities)((Pair) (obj)).second;
        for (int k = 0; k < ((android.media.MediaCodecInfo.CodecCapabilities) (obj)).profileLevels.length; k++)
        {
            android.media.MediaCodecInfo.CodecProfileLevel codecprofilelevel = ((android.media.MediaCodecInfo.CodecCapabilities) (obj)).profileLevels[k];
            if (codecprofilelevel.profile == i && codecprofilelevel.level >= j)
            {
                return true;
            }
        }

        return false;
    }

    public static boolean isSizeAndRateSupportedV21(String s, boolean flag, int i, int j, double d)
    {
        boolean flag1;
        if (Util.SDK_INT >= 21)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        s = getMediaCodecInfo(s, flag);
        if (s == null)
        {
            return false;
        }
        s = ((android.media.MediaCodecInfo.CodecCapabilities)((Pair) (s)).second).getVideoCapabilities();
        return s != null && s.areSizeAndRateSupported(i, j, d);
    }

    public static int maxH264DecodableFrameSize()
    {
        Object obj = getMediaCodecInfo("video/avc", false);
        if (obj == null)
        {
            return 0;
        }
        int j = 0;
        obj = (android.media.MediaCodecInfo.CodecCapabilities)((Pair) (obj)).second;
        for (int i = 0; i < ((android.media.MediaCodecInfo.CodecCapabilities) (obj)).profileLevels.length; i++)
        {
            j = Math.max(avcLevelToMaxFrameSize(((android.media.MediaCodecInfo.CodecCapabilities) (obj)).profileLevels[i].level), j);
        }

        return j;
    }

    public static void warmCodec(String s, boolean flag)
    {
        com/google/android/exoplayer/MediaCodecUtil;
        JVM INSTR monitorenter ;
        getMediaCodecInfo(s, flag);
        com/google/android/exoplayer/MediaCodecUtil;
        JVM INSTR monitorexit ;
        return;
        s;
        Log.e("MediaCodecUtil", "Codec warming failed", s);
        com/google/android/exoplayer/MediaCodecUtil;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

}
