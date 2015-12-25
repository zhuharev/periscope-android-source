// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import java.util.List;
import java.util.Map;

public class TwitterCollection
{
    public static final class Content
    {

        public final Map tweetMap;
        public final Map userMap;

        public Content(Map map, Map map1)
        {
            tweetMap = map;
            userMap = map1;
        }
    }

    public static final class Metadata
    {

        public final Position position;
        public final String timelineId;
        public final List timelineItems;

        public Metadata(String s, Position position1, List list)
        {
            timelineId = s;
            position = position1;
            timelineItems = list;
        }
    }

    public static final class Metadata.Position
    {

        public final Long maxPosition;
        public final Long minPosition;

        public Metadata.Position(Long long1, Long long2)
        {
            maxPosition = long1;
            minPosition = long2;
        }
    }

    public static class TimelineItem
    {

        public final TweetItem tweetItem;

        public TimelineItem(TweetItem tweetitem)
        {
            tweetItem = tweetitem;
        }
    }

    public static final class TimelineItem.TweetItem
    {

        public final Long id;

        public TimelineItem.TweetItem(Long long1)
        {
            id = long1;
        }
    }


    public final Content contents;
    public final Metadata metadata;

    public TwitterCollection(Content content, Metadata metadata1)
    {
        contents = content;
        metadata = metadata1;
    }
}
