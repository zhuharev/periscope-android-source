// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.subrip;

import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.util.Collections;
import java.util.List;

final class SubripSubtitle
    implements Subtitle
{

    private final long cueTimesUs[];
    private final Cue cues[];

    public SubripSubtitle(Cue acue[], long al[])
    {
        cues = acue;
        cueTimesUs = al;
    }

    public final List getCues(long l)
    {
        int i = Util.binarySearchFloor(cueTimesUs, l, true, false);
        if (i == -1 || cues[i] == null)
        {
            return Collections.emptyList();
        } else
        {
            return Collections.singletonList(cues[i]);
        }
    }

    public final long getEventTime(int i)
    {
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (i < cueTimesUs.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        return cueTimesUs[i];
    }

    public final int getEventTimeCount()
    {
        return cueTimesUs.length;
    }

    public final long getLastEventTime()
    {
        if (getEventTimeCount() == 0)
        {
            return -1L;
        } else
        {
            return cueTimesUs[cueTimesUs.length - 1];
        }
    }

    public final int getNextEventTimeIndex(long l)
    {
        int i = Util.binarySearchCeil(cueTimesUs, l, false, false);
        if (i < cueTimesUs.length)
        {
            return i;
        } else
        {
            return -1;
        }
    }
}
