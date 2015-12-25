// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.UriUtil;
import com.google.android.exoplayer.util.Util;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifest

public static class chunkStartTimesUs
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
    public final chunkStartTimesUs tracks[];
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
        String s = chunkTemplate.replace("{bitrate}", Integer.toString(tracks[i].ormat.bitrate)).replace("{start time}", ((Long)chunkStartTimes.get(j)).toString());
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

    public (String s, String s1, int i, String s2, long l, String s3, 
            int j, int k, int i1, int j1, int k1, String s4,  a[], 
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
        tracks = a;
        chunkCount = list.size();
        chunkStartTimes = list;
        lastChunkDurationUs = Util.scaleLargeTimestamp(l1, 0xf4240L, l);
        chunkStartTimesUs = Util.scaleLargeTimestamps(list, 0xf4240L, l);
    }
}
