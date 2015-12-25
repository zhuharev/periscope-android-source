// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;

import java.io.Serializable;

// Referenced classes of package com.twitter.sdk.android.core.models:
//            Identifiable, UserEntities, Tweet

public class User
    implements Serializable, Identifiable
{

    public static final long INVALID_ID = -1L;
    private static final long serialVersionUID = 0x40b7e7b364d35e06L;
    public final boolean contributorsEnabled;
    public final String createdAt;
    public final boolean defaultProfile;
    public final boolean defaultProfileImage;
    public final String description;
    public final String email;
    public final UserEntities entities;
    public final int favouritesCount;
    public final boolean followRequestSent;
    public final int followersCount;
    public final int friendsCount;
    public final boolean geoEnabled;
    public final long id;
    public final String idStr;
    public final boolean isTranslator;
    public final String lang;
    public final int listedCount;
    public final String location;
    public final String name;
    public final String profileBackgroundColor;
    public final String profileBackgroundImageUrl;
    public final String profileBackgroundImageUrlHttps;
    public final boolean profileBackgroundTile;
    public final String profileBannerUrl;
    public final String profileImageUrl;
    public final String profileImageUrlHttps;
    public final String profileLinkColor;
    public final String profileSidebarBorderColor;
    public final String profileSidebarFillColor;
    public final String profileTextColor;
    public final boolean profileUseBackgroundImage;
    public final boolean protectedUser;
    public final String screenName;
    public final boolean showAllInlineMedia;
    public final Tweet status;
    public final int statusesCount;
    public final String timeZone;
    public final String url;
    public final int utcOffset;
    public final boolean verified;
    public final String withheldInCountries;
    public final String withheldScope;

    public User(boolean flag, String s, boolean flag1, boolean flag2, String s1, String s2, UserEntities userentities, 
            int i, boolean flag3, int j, int k, boolean flag4, long l, 
            String s3, boolean flag5, String s4, int i1, String s5, String s6, String s7, 
            String s8, String s9, boolean flag6, String s10, String s11, String s12, String s13, 
            String s14, String s15, String s16, boolean flag7, boolean flag8, String s17, boolean flag9, 
            Tweet tweet, int j1, String s18, String s19, int k1, boolean flag10, String s20, 
            String s21)
    {
        contributorsEnabled = flag;
        createdAt = s;
        defaultProfile = flag1;
        defaultProfileImage = flag2;
        description = s1;
        email = s2;
        entities = userentities;
        favouritesCount = i;
        followRequestSent = flag3;
        followersCount = j;
        friendsCount = k;
        geoEnabled = flag4;
        id = l;
        idStr = s3;
        isTranslator = flag5;
        lang = s4;
        listedCount = i1;
        location = s5;
        name = s6;
        profileBackgroundColor = s7;
        profileBackgroundImageUrl = s8;
        profileBackgroundImageUrlHttps = s9;
        profileBackgroundTile = flag6;
        profileBannerUrl = s10;
        profileImageUrl = s11;
        profileImageUrlHttps = s12;
        profileLinkColor = s13;
        profileSidebarBorderColor = s14;
        profileSidebarFillColor = s15;
        profileTextColor = s16;
        profileUseBackgroundImage = flag7;
        protectedUser = flag8;
        screenName = s17;
        showAllInlineMedia = flag9;
        status = tweet;
        statusesCount = j1;
        timeZone = s18;
        url = s19;
        utcOffset = k1;
        verified = flag10;
        withheldInCountries = s20;
        withheldScope = s21;
    }

    public long getId()
    {
        return id;
    }
}
