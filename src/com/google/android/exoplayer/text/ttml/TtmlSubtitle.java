// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.ttml;

import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.exoplayer.text.ttml:
//            TtmlNode

public final class TtmlSubtitle
    implements Subtitle
{

    private final long eventTimesUs[];
    private final Map globalStyles;
    private final TtmlNode root;

    public TtmlSubtitle(TtmlNode ttmlnode, Map map)
    {
        root = ttmlnode;
        if (map != null)
        {
            map = Collections.unmodifiableMap(map);
        } else
        {
            map = Collections.emptyMap();
        }
        globalStyles = map;
        eventTimesUs = ttmlnode.getEventTimesUs();
    }

    public final List getCues(long l)
    {
        CharSequence charsequence = root.getText(l, globalStyles);
        if (charsequence == null)
        {
            return Collections.emptyList();
        } else
        {
            return Collections.singletonList(new Cue(charsequence));
        }
    }

    public final long getEventTime(int i)
    {
        return eventTimesUs[i];
    }

    public final int getEventTimeCount()
    {
        return eventTimesUs.length;
    }

    final Map getGlobalStyles()
    {
        return globalStyles;
    }

    public final long getLastEventTime()
    {
        if (eventTimesUs.length == 0)
        {
            return -1L;
        } else
        {
            return eventTimesUs[eventTimesUs.length - 1];
        }
    }

    public final int getNextEventTimeIndex(long l)
    {
        int i = Util.binarySearchCeil(eventTimesUs, l, false, false);
        if (i < eventTimesUs.length)
        {
            return i;
        } else
        {
            return -1;
        }
    }

    final TtmlNode getRoot()
    {
        return root;
    }
}
