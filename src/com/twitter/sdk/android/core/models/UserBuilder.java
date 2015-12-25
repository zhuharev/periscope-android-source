// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;


// Referenced classes of package com.twitter.sdk.android.core.models:
//            User, UserEntities, Tweet

public class UserBuilder
{

    private boolean contributorsEnabled;
    private String createdAt;
    private boolean defaultProfile;
    private boolean defaultProfileImage;
    private String description;
    private String email;
    private UserEntities entities;
    private int favouritesCount;
    private boolean followRequestSent;
    private int followersCount;
    private int friendsCount;
    private boolean geoEnabled;
    private long id;
    private String idStr;
    private boolean isTranslator;
    private String lang;
    private int listedCount;
    private String location;
    private String name;
    private String profileBackgroundColor;
    private String profileBackgroundImageUrl;
    private String profileBackgroundImageUrlHttps;
    private boolean profileBackgroundTile;
    private String profileBannerUrl;
    private String profileImageUrl;
    private String profileImageUrlHttps;
    private String profileLinkColor;
    private String profileSidebarBorderColor;
    private String profileSidebarFillColor;
    private String profileTextColor;
    private boolean profileUseBackgroundImage;
    private boolean protectedUser;
    private String screenName;
    private boolean showAllInlineMedia;
    private Tweet status;
    private int statusesCount;
    private String timeZone;
    private String url;
    private int utcOffset;
    private boolean verified;
    private String withheldInCountries;
    private String withheldScope;

    public UserBuilder()
    {
        id = -1L;
    }

    public User build()
    {
        return new User(contributorsEnabled, createdAt, defaultProfile, defaultProfileImage, description, email, entities, favouritesCount, followRequestSent, followersCount, friendsCount, geoEnabled, id, idStr, isTranslator, lang, listedCount, location, name, profileBackgroundColor, profileBackgroundImageUrl, profileBackgroundImageUrlHttps, profileBackgroundTile, profileBannerUrl, profileImageUrl, profileImageUrlHttps, profileLinkColor, profileSidebarBorderColor, profileSidebarFillColor, profileTextColor, profileUseBackgroundImage, protectedUser, screenName, showAllInlineMedia, status, statusesCount, timeZone, url, utcOffset, verified, withheldInCountries, withheldScope);
    }

    public UserBuilder setContributorsEnabled(boolean flag)
    {
        contributorsEnabled = flag;
        return this;
    }

    public UserBuilder setCreatedAt(String s)
    {
        createdAt = s;
        return this;
    }

    public UserBuilder setDefaultProfile(boolean flag)
    {
        defaultProfile = flag;
        return this;
    }

    public UserBuilder setDefaultProfileImage(boolean flag)
    {
        defaultProfileImage = flag;
        return this;
    }

    public UserBuilder setDescription(String s)
    {
        description = s;
        return this;
    }

    public UserBuilder setEmail(String s)
    {
        email = s;
        return this;
    }

    public UserBuilder setEntities(UserEntities userentities)
    {
        entities = userentities;
        return this;
    }

    public UserBuilder setFavouritesCount(int i)
    {
        favouritesCount = i;
        return this;
    }

    public UserBuilder setFollowRequestSent(boolean flag)
    {
        followRequestSent = flag;
        return this;
    }

    public UserBuilder setFollowersCount(int i)
    {
        followersCount = i;
        return this;
    }

    public UserBuilder setFriendsCount(int i)
    {
        friendsCount = i;
        return this;
    }

    public UserBuilder setGeoEnabled(boolean flag)
    {
        geoEnabled = flag;
        return this;
    }

    public UserBuilder setId(long l)
    {
        id = l;
        return this;
    }

    public UserBuilder setIdStr(String s)
    {
        idStr = s;
        return this;
    }

    public UserBuilder setIsTranslator(boolean flag)
    {
        isTranslator = flag;
        return this;
    }

    public UserBuilder setLang(String s)
    {
        lang = s;
        return this;
    }

    public UserBuilder setListedCount(int i)
    {
        listedCount = i;
        return this;
    }

    public UserBuilder setLocation(String s)
    {
        location = s;
        return this;
    }

    public UserBuilder setName(String s)
    {
        name = s;
        return this;
    }

    public UserBuilder setProfileBackgroundColor(String s)
    {
        profileBackgroundColor = s;
        return this;
    }

    public UserBuilder setProfileBackgroundImageUrl(String s)
    {
        profileBackgroundImageUrl = s;
        return this;
    }

    public UserBuilder setProfileBackgroundImageUrlHttps(String s)
    {
        profileBackgroundImageUrlHttps = s;
        return this;
    }

    public UserBuilder setProfileBackgroundTile(boolean flag)
    {
        profileBackgroundTile = flag;
        return this;
    }

    public UserBuilder setProfileBannerUrl(String s)
    {
        profileBannerUrl = s;
        return this;
    }

    public UserBuilder setProfileImageUrl(String s)
    {
        profileImageUrl = s;
        return this;
    }

    public UserBuilder setProfileImageUrlHttps(String s)
    {
        profileImageUrlHttps = s;
        return this;
    }

    public UserBuilder setProfileLinkColor(String s)
    {
        profileLinkColor = s;
        return this;
    }

    public UserBuilder setProfileSidebarBorderColor(String s)
    {
        profileSidebarBorderColor = s;
        return this;
    }

    public UserBuilder setProfileSidebarFillColor(String s)
    {
        profileSidebarFillColor = s;
        return this;
    }

    public UserBuilder setProfileTextColor(String s)
    {
        profileTextColor = s;
        return this;
    }

    public UserBuilder setProfileUseBackgroundImage(boolean flag)
    {
        profileUseBackgroundImage = flag;
        return this;
    }

    public UserBuilder setProtectedUser(boolean flag)
    {
        protectedUser = flag;
        return this;
    }

    public UserBuilder setScreenName(String s)
    {
        screenName = s;
        return this;
    }

    public UserBuilder setShowAllInlineMedia(boolean flag)
    {
        showAllInlineMedia = flag;
        return this;
    }

    public UserBuilder setStatus(Tweet tweet)
    {
        status = tweet;
        return this;
    }

    public UserBuilder setStatusesCount(int i)
    {
        statusesCount = i;
        return this;
    }

    public UserBuilder setTimeZone(String s)
    {
        timeZone = s;
        return this;
    }

    public UserBuilder setUrl(String s)
    {
        url = s;
        return this;
    }

    public UserBuilder setUtcOffset(int i)
    {
        utcOffset = i;
        return this;
    }

    public UserBuilder setVerified(boolean flag)
    {
        verified = flag;
        return this;
    }

    public UserBuilder setWithheldInCountries(String s)
    {
        withheldInCountries = s;
        return this;
    }

    public UserBuilder setWithheldScope(String s)
    {
        withheldScope = s;
        return this;
    }
}
