// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;

import java.util.List;

// Referenced classes of package com.twitter.sdk.android.core.models:
//            Identifiable, Coordinates, TweetEntities, Place, 
//            User

public class Tweet
    implements Identifiable
{

    public static final long INVALID_ID = -1L;
    public final Coordinates coordinates;
    public final String createdAt;
    public final Object currentUserRetweet;
    public final TweetEntities entities;
    public final Integer favoriteCount;
    public final boolean favorited;
    public final String filterLevel;
    public final long id;
    public final String idStr;
    public final String inReplyToScreenName;
    public final long inReplyToStatusId;
    public final String inReplyToStatusIdStr;
    public final long inReplyToUserId;
    public final String inReplyToUserIdStr;
    public final String lang;
    public final Place place;
    public final boolean possiblySensitive;
    public final int retweetCount;
    public final boolean retweeted;
    public final Tweet retweetedStatus;
    public final Object scopes;
    public final String source;
    public final String text;
    public final boolean truncated;
    public final User user;
    public final boolean withheldCopyright;
    public final List withheldInCountries;
    public final String withheldScope;

    public Tweet(Coordinates coordinates1, String s, Object obj, TweetEntities tweetentities, Integer integer, boolean flag, String s1, 
            long l, String s2, String s3, long l1, String s4, 
            long l2, String s5, String s6, Place place1, boolean flag1, Object obj1, 
            int i, boolean flag2, Tweet tweet, String s7, String s8, boolean flag3, User user1, 
            boolean flag4, List list, String s9)
    {
        coordinates = coordinates1;
        createdAt = s;
        currentUserRetweet = obj;
        entities = tweetentities;
        favoriteCount = integer;
        favorited = flag;
        filterLevel = s1;
        id = l;
        idStr = s2;
        inReplyToScreenName = s3;
        inReplyToStatusId = l1;
        inReplyToStatusIdStr = s4;
        inReplyToUserId = l2;
        inReplyToUserIdStr = s5;
        lang = s6;
        place = place1;
        possiblySensitive = flag1;
        scopes = obj1;
        retweetCount = i;
        retweeted = flag2;
        retweetedStatus = tweet;
        source = s7;
        text = s8;
        truncated = flag3;
        user = user1;
        withheldCopyright = flag4;
        withheldInCountries = list;
        withheldScope = s9;
    }

    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof Tweet))
        {
            return false;
        }
        obj = (Tweet)obj;
        return id == ((Tweet) (obj)).id;
    }

    public long getId()
    {
        return id;
    }

    public int hashCode()
    {
        return (int)id;
    }
}
