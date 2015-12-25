// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;

final class TrackSampleTable
{

    public static final int NO_SAMPLE = -1;
    public final int flags[];
    public final long offsets[];
    public final int sampleCount;
    public final int sizes[];
    public final long timestampsUs[];

    TrackSampleTable(long al[], int ai[], long al1[], int ai1[])
    {
        boolean flag;
        if (ai.length == al1.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (al.length == al1.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (ai1.length == al1.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        offsets = al;
        sizes = ai;
        timestampsUs = al1;
        flags = ai1;
        sampleCount = al.length;
    }

    public final int getIndexOfEarlierOrEqualSynchronizationSample(long l)
    {
        for (int i = Util.binarySearchFloor(timestampsUs, l, true, false); i >= 0; i--)
        {
            if (timestampsUs[i] <= l && (flags[i] & 1) != 0)
            {
                return i;
            }
        }

        return -1;
    }

    public final int getIndexOfLaterOrEqualSynchronizationSample(long l)
    {
        for (int i = Util.binarySearchCeil(timestampsUs, l, true, false); i < timestampsUs.length; i++)
        {
            if (timestampsUs[i] >= l && (flags[i] & 1) != 0)
            {
                return i;
            }
        }

        return -1;
    }
}
