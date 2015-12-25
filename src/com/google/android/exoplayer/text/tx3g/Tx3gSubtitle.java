// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.tx3g;

import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.util.Assertions;
import java.util.Collections;
import java.util.List;

final class Tx3gSubtitle
    implements Subtitle
{

    private final List cues;

    public Tx3gSubtitle(Cue cue)
    {
        cues = Collections.singletonList(cue);
    }

    public final List getCues(long l)
    {
        if (l >= 0L)
        {
            return cues;
        } else
        {
            return Collections.emptyList();
        }
    }

    public final long getEventTime(int i)
    {
        boolean flag;
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        return 0L;
    }

    public final int getEventTimeCount()
    {
        return 1;
    }

    public final long getLastEventTime()
    {
        return 0L;
    }

    public final int getNextEventTimeIndex(long l)
    {
        return l >= 0L ? -1 : 0;
    }
}
