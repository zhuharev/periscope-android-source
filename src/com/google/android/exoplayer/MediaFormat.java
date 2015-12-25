// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MediaFormat
{

    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = 0x7fffffffffffffffL;
    public final boolean adaptive;
    public final int bitrate;
    public final int channelCount;
    public final long durationUs;
    private android.media.MediaFormat frameworkMediaFormat;
    private int hashCode;
    public final int height;
    public final List initializationData;
    public final String language;
    public final int maxHeight;
    public final int maxInputSize;
    public final int maxWidth;
    public final String mimeType;
    public final float pixelWidthHeightRatio;
    public final int rotationDegrees;
    public final int sampleRate;
    public final long subsampleOffsetUs;
    public final int trackId;
    public final int width;

    MediaFormat(int i, String s, int j, int k, long l, int i1, 
            int j1, int k1, float f, int l1, int i2, String s1, long l2, List list, boolean flag, int j2, int k2)
    {
        trackId = i;
        mimeType = Assertions.checkNotEmpty(s);
        bitrate = j;
        maxInputSize = k;
        durationUs = l;
        width = i1;
        height = j1;
        rotationDegrees = k1;
        pixelWidthHeightRatio = f;
        channelCount = l1;
        sampleRate = i2;
        language = s1;
        subsampleOffsetUs = l2;
        if (list == null)
        {
            list = Collections.emptyList();
        }
        initializationData = list;
        adaptive = flag;
        maxWidth = j2;
        maxHeight = k2;
    }

    public static MediaFormat createAudioFormat(int i, String s, int j, int k, long l, int i1, int j1, 
            List list, String s1)
    {
        return new MediaFormat(i, s, j, k, l, -1, -1, -1, -1F, i1, j1, s1, 0x7fffffffffffffffL, list, false, -1, -1);
    }

    public static MediaFormat createFormatForMimeType(int i, String s, int j, long l)
    {
        return new MediaFormat(i, s, j, -1, l, -1, -1, -1, -1F, -1, -1, null, 0x7fffffffffffffffL, null, false, -1, -1);
    }

    public static MediaFormat createTextFormat(int i, String s, int j, long l, String s1)
    {
        return createTextFormat(i, s, j, l, s1, 0x7fffffffffffffffL);
    }

    public static MediaFormat createTextFormat(int i, String s, int j, long l, String s1, long l1)
    {
        return new MediaFormat(i, s, j, -1, l, -1, -1, -1, -1F, -1, -1, s1, l1, null, false, -1, -1);
    }

    public static MediaFormat createVideoFormat(int i, String s, int j, int k, long l, int i1, int j1, 
            List list)
    {
        return createVideoFormat(i, s, j, k, l, i1, j1, list, -1, -1F);
    }

    public static MediaFormat createVideoFormat(int i, String s, int j, int k, long l, int i1, int j1, 
            List list, int k1, float f)
    {
        return new MediaFormat(i, s, j, k, l, i1, j1, k1, f, -1, -1, null, 0x7fffffffffffffffL, list, false, -1, -1);
    }

    private static final void maybeSetIntegerV16(android.media.MediaFormat mediaformat, String s, int i)
    {
        if (i != -1)
        {
            mediaformat.setInteger(s, i);
        }
    }

    private static final void maybeSetStringV16(android.media.MediaFormat mediaformat, String s, String s1)
    {
        if (s1 != null)
        {
            mediaformat.setString(s, s1);
        }
    }

    public final MediaFormat copyAsAdaptive()
    {
        return new MediaFormat(trackId, mimeType, -1, -1, durationUs, -1, -1, -1, -1F, -1, -1, null, 0x7fffffffffffffffL, null, true, maxWidth, maxHeight);
    }

    public final MediaFormat copyWithDurationUs(long l)
    {
        return new MediaFormat(trackId, mimeType, bitrate, maxInputSize, l, width, height, rotationDegrees, pixelWidthHeightRatio, channelCount, sampleRate, language, subsampleOffsetUs, initializationData, adaptive, maxWidth, maxHeight);
    }

    public final MediaFormat copyWithMaxVideoDimensions(int i, int j)
    {
        return new MediaFormat(trackId, mimeType, bitrate, maxInputSize, durationUs, width, height, rotationDegrees, pixelWidthHeightRatio, channelCount, sampleRate, language, subsampleOffsetUs, initializationData, adaptive, i, j);
    }

    public final MediaFormat copyWithSubsampleOffsetUs(long l)
    {
        return new MediaFormat(trackId, mimeType, bitrate, maxInputSize, durationUs, width, height, rotationDegrees, pixelWidthHeightRatio, channelCount, sampleRate, language, l, initializationData, adaptive, maxWidth, maxHeight);
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (MediaFormat)obj;
        if (adaptive != ((MediaFormat) (obj)).adaptive || bitrate != ((MediaFormat) (obj)).bitrate || maxInputSize != ((MediaFormat) (obj)).maxInputSize || width != ((MediaFormat) (obj)).width || height != ((MediaFormat) (obj)).height || rotationDegrees != ((MediaFormat) (obj)).rotationDegrees || pixelWidthHeightRatio != ((MediaFormat) (obj)).pixelWidthHeightRatio || maxWidth != ((MediaFormat) (obj)).maxWidth || maxHeight != ((MediaFormat) (obj)).maxHeight || channelCount != ((MediaFormat) (obj)).channelCount || sampleRate != ((MediaFormat) (obj)).sampleRate || trackId != ((MediaFormat) (obj)).trackId || !Util.areEqual(language, ((MediaFormat) (obj)).language) || !Util.areEqual(mimeType, ((MediaFormat) (obj)).mimeType) || initializationData.size() != ((MediaFormat) (obj)).initializationData.size())
        {
            return false;
        }
        for (int i = 0; i < initializationData.size(); i++)
        {
            if (!Arrays.equals((byte[])initializationData.get(i), (byte[])((MediaFormat) (obj)).initializationData.get(i)))
            {
                return false;
            }
        }

        return true;
    }

    public final android.media.MediaFormat getFrameworkMediaFormatV16()
    {
        if (frameworkMediaFormat == null)
        {
            android.media.MediaFormat mediaformat = new android.media.MediaFormat();
            mediaformat.setString("mime", mimeType);
            maybeSetStringV16(mediaformat, "language", language);
            maybeSetIntegerV16(mediaformat, "max-input-size", maxInputSize);
            maybeSetIntegerV16(mediaformat, "width", width);
            maybeSetIntegerV16(mediaformat, "height", height);
            maybeSetIntegerV16(mediaformat, "rotation-degrees", rotationDegrees);
            maybeSetIntegerV16(mediaformat, "max-width", maxWidth);
            maybeSetIntegerV16(mediaformat, "max-height", maxHeight);
            maybeSetIntegerV16(mediaformat, "channel-count", channelCount);
            maybeSetIntegerV16(mediaformat, "sample-rate", sampleRate);
            for (int i = 0; i < initializationData.size(); i++)
            {
                mediaformat.setByteBuffer((new StringBuilder("csd-")).append(i).toString(), ByteBuffer.wrap((byte[])initializationData.get(i)));
            }

            if (durationUs != -1L)
            {
                mediaformat.setLong("durationUs", durationUs);
            }
            frameworkMediaFormat = mediaformat;
        }
        return frameworkMediaFormat;
    }

    public final int hashCode()
    {
        if (hashCode == 0)
        {
            int i1 = trackId;
            int i;
            if (mimeType == null)
            {
                i = 0;
            } else
            {
                i = mimeType.hashCode();
            }
            int j1 = bitrate;
            int k1 = maxInputSize;
            int l1 = width;
            int i2 = height;
            int j2 = rotationDegrees;
            int k2 = Float.floatToRawIntBits(pixelWidthHeightRatio);
            int l2 = (int)durationUs;
            int k;
            if (adaptive)
            {
                k = 1231;
            } else
            {
                k = 1237;
            }
            int i3 = maxWidth;
            int j3 = maxHeight;
            int k3 = channelCount;
            int l3 = sampleRate;
            int l;
            if (language == null)
            {
                l = 0;
            } else
            {
                l = language.hashCode();
            }
            k = ((((((((((((((i1 + 527) * 31 + i) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + l2) * 31 + k) * 31 + i3) * 31 + j3) * 31 + k3) * 31 + l3) * 31 + l;
            for (int j = 0; j < initializationData.size(); j++)
            {
                k = k * 31 + Arrays.hashCode((byte[])initializationData.get(j));
            }

            hashCode = k;
        }
        return hashCode;
    }

    final void setFrameworkFormatV16(android.media.MediaFormat mediaformat)
    {
        frameworkMediaFormat = mediaformat;
    }

    public final String toString()
    {
        return (new StringBuilder("MediaFormat(")).append(trackId).append(", ").append(mimeType).append(", ").append(bitrate).append(", ").append(maxInputSize).append(", ").append(width).append(", ").append(height).append(", ").append(rotationDegrees).append(", ").append(pixelWidthHeightRatio).append(", ").append(channelCount).append(", ").append(sampleRate).append(", ").append(language).append(", ").append(durationUs).append(", ").append(adaptive).append(", ").append(maxWidth).append(", ").append(maxHeight).append(")").toString();
    }
}
