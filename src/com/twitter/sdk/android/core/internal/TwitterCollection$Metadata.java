// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import java.util.List;

// Referenced classes of package com.twitter.sdk.android.core.internal:
//            TwitterCollection

public static final class timelineItems
{
    public static final class Position
    {

        public final Long maxPosition;
        public final Long minPosition;

        public Position(Long long1, Long long2)
        {
            maxPosition = long1;
            minPosition = long2;
        }
    }


    public final Position position;
    public final String timelineId;
    public final List timelineItems;

    public Position(String s, Position position1, List list)
    {
        timelineId = s;
        position = position1;
        timelineItems = list;
    }
}
