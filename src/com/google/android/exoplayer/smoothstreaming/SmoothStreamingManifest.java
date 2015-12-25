// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.FormatWrapper;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.UriUtil;
import com.google.android.exoplayer.util.Util;
import java.util.List;
import java.util.UUID;

public class SmoothStreamingManifest
{
    public static class ProtectionElement
    {

        public final byte data[];
        public final UUID uuid;

        public ProtectionElement(UUID uuid1, byte abyte0[])
        {
            uuid = uuid1;
            data = abyte0;
        }
    }

    public static class StreamElement
    {

        public static final int TYPE_AUDIO = 0;
        public static final int TYPE_TEXT = 2;
        public static final int TYPE_UNKNOWN = -1;
        public static final int TYPE_VIDEO = 1;
        private static final String URL_PLACEHOLDER_BITRATE = "{bitrate}";
        private static final String URL_PLACEHOLDER_START_TIME = "{start time}";
        private final String baseUri;
        public final int chunkCount;
        private final List chunkStartTimes;
        private final long chunkStartTimesUs[];
        private final String chunkTemplate;
        public final int displayHeight;
        public final int displayWidth;
        public final String language;
        private final long lastChunkDurationUs;
        public final int maxHeight;
        public final int maxWidth;
        public final String name;
        public final int qualityLevels;
        public final String subType;
        public final long timescale;
        public final TrackElement tracks[];
        public final int type;

        public Uri buildRequestUri(int i, int j)
        {
            boolean flag;
            if (tracks != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            if (chunkStartTimes != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            if (j < chunkStartTimes.size())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            String s = chunkTemplate.replace("{bitrate}", Integer.toString(tracks[i].format.bitrate)).replace("{start time}", ((Long)chunkStartTimes.get(j)).toString());
            return UriUtil.resolveToUri(baseUri, s);
        }

        public long getChunkDurationUs(int i)
        {
            if (i == chunkCount - 1)
            {
                return lastChunkDurationUs;
            } else
            {
                return chunkStartTimesUs[i + 1] - chunkStartTimesUs[i];
            }
        }

        public int getChunkIndex(long l)
        {
            return Util.binarySearchFloor(chunkStartTimesUs, l, true, true);
        }

        public long getStartTimeUs(int i)
        {
            return chunkStartTimesUs[i];
        }

        public StreamElement(String s, String s1, int i, String s2, long l, String s3, 
                int j, int k, int i1, int j1, int k1, String s4, TrackElement atrackelement[], 
                List list, long l1)
        {
            baseUri = s;
            chunkTemplate = s1;
            type = i;
            subType = s2;
            timescale = l;
            name = s3;
            qualityLevels = j;
            maxWidth = k;
            maxHeight = i1;
            displayWidth = j1;
            displayHeight = k1;
            language = s4;
            tracks = atrackelement;
            chunkCount = list.size();
            chunkStartTimes = list;
            lastChunkDurationUs = Util.scaleLargeTimestamp(l1, 0xf4240L, l);
            chunkStartTimesUs = Util.scaleLargeTimestamps(list, 0xf4240L, l);
        }
    }

    public static class TrackElement
        implements FormatWrapper
    {

        public final byte csd[][];
        public final Format format;

        public Format getFormat()
        {
            return format;
        }

        public TrackElement(int i, int j, String s, byte abyte0[][], int k, int l, int i1, 
                int j1)
        {
            csd = abyte0;
            format = new Format(String.valueOf(i), s, k, l, -1F, j1, i1, j);
        }
    }


    public final long durationUs;
    public final long dvrWindowLengthUs;
    public final boolean isLive;
    public final int lookAheadCount;
    public final int majorVersion;
    public final int minorVersion;
    public final ProtectionElement protectionElement;
    public final StreamElement streamElements[];

    public SmoothStreamingManifest(int i, int j, long l, long l1, long l2, int k, boolean flag, ProtectionElement protectionelement, StreamElement astreamelement[])
    {
        majorVersion = i;
        minorVersion = j;
        lookAheadCount = k;
        isLive = flag;
        protectionElement = protectionelement;
        streamElements = astreamelement;
        if (l2 == 0L)
        {
            l2 = -1L;
        } else
        {
            l2 = Util.scaleLargeTimestamp(l2, 0xf4240L, l);
        }
        dvrWindowLengthUs = l2;
        if (l1 == 0L)
        {
            l = -1L;
        } else
        {
            l = Util.scaleLargeTimestamp(l1, 0xf4240L, l);
        }
        durationUs = l;
    }
}
