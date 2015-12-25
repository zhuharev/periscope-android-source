// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text;

import java.util.List;

// Referenced classes of package com.google.android.exoplayer.text:
//            Subtitle

final class PlayableSubtitle
    implements Subtitle
{

    private final long offsetUs;
    public final long startTimeUs;
    private final Subtitle subtitle;

    public PlayableSubtitle(Subtitle subtitle1, boolean flag, long l, long l1)
    {
        subtitle = subtitle1;
        startTimeUs = l;
        if (!flag)
        {
            l = 0L;
        }
        offsetUs = l + l1;
    }

    public final List getCues(long l)
    {
        return subtitle.getCues(l - offsetUs);
    }

    public final long getEventTime(int i)
    {
        return subtitle.getEventTime(i) + offsetUs;
    }

    public final int getEventTimeCount()
    {
        return subtitle.getEventTimeCount();
    }

    public final long getLastEventTime()
    {
        return subtitle.getLastEventTime() + offsetUs;
    }

    public final int getNextEventTimeIndex(long l)
    {
        return subtitle.getNextEventTimeIndex(l - offsetUs);
    }
}
