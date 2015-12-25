// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;

import java.util.List;

// Referenced classes of package com.twitter.sdk.android.core.models:
//            Tweet, Coordinates, TweetEntities, Place, 
//            User

public class TweetBuilder
{

    private Coordinates coordinates;
    private String createdAt;
    private Object currentUserRetweet;
    private TweetEntities entities;
    private Integer favoriteCount;
    private boolean favorited;
    private String filterLevel;
    private long id;
    private String idStr;
    private String inReplyToScreenName;
    private long inReplyToStatusId;
    private String inReplyToStatusIdStr;
    private long inReplyToUserId;
    private String inReplyToUserIdStr;
    private String lang;
    private Place place;
    private boolean possiblySensitive;
    private int retweetCount;
    private boolean retweeted;
    private Tweet retweetedStatus;
    private Object scopes;
    private String source;
    private String text;
    private boolean truncated;
    private User user;
    private boolean withheldCopyright;
    private List withheldInCountries;
    private String withheldScope;

    public TweetBuilder()
    {
        id = -1L;
    }

    public Tweet build()
    {
        return new Tweet(coordinates, createdAt, currentUserRetweet, entities, favoriteCount, favorited, filterLevel, id, idStr, inReplyToScreenName, inReplyToStatusId, inReplyToStatusIdStr, inReplyToUserId, inReplyToUserIdStr, lang, place, possiblySensitive, scopes, retweetCount, retweeted, retweetedStatus, source, text, truncated, user, withheldCopyright, withheldInCountries, withheldScope);
    }

    public TweetBuilder copy(Tweet tweet)
    {
        coordinates = tweet.coordinates;
        createdAt = tweet.createdAt;
        currentUserRetweet = tweet.currentUserRetweet;
        entities = tweet.entities;
        favoriteCount = tweet.favoriteCount;
        favorited = tweet.favorited;
        filterLevel = tweet.filterLevel;
        id = tweet.id;
        idStr = tweet.idStr;
        inReplyToScreenName = tweet.inReplyToScreenName;
        inReplyToStatusId = tweet.inReplyToStatusId;
        inReplyToStatusIdStr = tweet.inReplyToStatusIdStr;
        inReplyToUserId = tweet.inReplyToUserId;
        inReplyToUserIdStr = tweet.inReplyToStatusIdStr;
        lang = tweet.lang;
        place = tweet.place;
        possiblySensitive = tweet.possiblySensitive;
        scopes = tweet.scopes;
        retweetCount = tweet.retweetCount;
        retweeted = tweet.retweeted;
        retweetedStatus = tweet.retweetedStatus;
        source = tweet.source;
        text = tweet.text;
        truncated = tweet.truncated;
        user = tweet.user;
        withheldCopyright = tweet.withheldCopyright;
        withheldInCountries = tweet.withheldInCountries;
        withheldScope = tweet.withheldScope;
        return this;
    }

    public TweetBuilder setCoordinates(Coordinates coordinates1)
    {
        coordinates = coordinates1;
        return this;
    }

    public TweetBuilder setCreatedAt(String s)
    {
        createdAt = s;
        return this;
    }

    public TweetBuilder setCurrentUserRetweet(Object obj)
    {
        currentUserRetweet = obj;
        return this;
    }

    public TweetBuilder setEntities(TweetEntities tweetentities)
    {
        entities = tweetentities;
        return this;
    }

    public TweetBuilder setFavoriteCount(Integer integer)
    {
        favoriteCount = integer;
        return this;
    }

    public TweetBuilder setFavorited(boolean flag)
    {
        favorited = flag;
        return this;
    }

    public TweetBuilder setFilterLevel(String s)
    {
        filterLevel = s;
        return this;
    }

    public TweetBuilder setId(long l)
    {
        id = l;
        return this;
    }

    public TweetBuilder setIdStr(String s)
    {
        idStr = s;
        return this;
    }

    public TweetBuilder setInReplyToScreenName(String s)
    {
        inReplyToScreenName = s;
        return this;
    }

    public TweetBuilder setInReplyToStatusId(long l)
    {
        inReplyToStatusId = l;
        return this;
    }

    public TweetBuilder setInReplyToStatusIdStr(String s)
    {
        inReplyToStatusIdStr = s;
        return this;
    }

    public TweetBuilder setInReplyToUserId(long l)
    {
        inReplyToUserId = l;
        return this;
    }

    public TweetBuilder setInReplyToUserIdStr(String s)
    {
        inReplyToUserIdStr = s;
        return this;
    }

    public TweetBuilder setLang(String s)
    {
        lang = s;
        return this;
    }

    public TweetBuilder setPlace(Place place1)
    {
        place = place1;
        return this;
    }

    public TweetBuilder setPossiblySensitive(boolean flag)
    {
        possiblySensitive = flag;
        return this;
    }

    public TweetBuilder setRetweetCount(int i)
    {
        retweetCount = i;
        return this;
    }

    public TweetBuilder setRetweeted(boolean flag)
    {
        retweeted = flag;
        return this;
    }

    public TweetBuilder setRetweetedStatus(Tweet tweet)
    {
        retweetedStatus = tweet;
        return this;
    }

    public TweetBuilder setScopes(Object obj)
    {
        scopes = obj;
        return this;
    }

    public TweetBuilder setSource(String s)
    {
        source = s;
        return this;
    }

    public TweetBuilder setText(String s)
    {
        text = s;
        return this;
    }

    public TweetBuilder setTruncated(boolean flag)
    {
        truncated = flag;
        return this;
    }

    public TweetBuilder setUser(User user1)
    {
        user = user1;
        return this;
    }

    public TweetBuilder setWithheldCopyright(boolean flag)
    {
        withheldCopyright = flag;
        return this;
    }

    public TweetBuilder setWithheldInCountries(List list)
    {
        withheldInCountries = list;
        return this;
    }

    public TweetBuilder setWithheldScope(String s)
    {
        withheldScope = s;
        return this;
    }
}
