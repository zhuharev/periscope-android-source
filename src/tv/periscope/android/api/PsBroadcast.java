// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import android.text.format.Time;
import java.util.ArrayList;
import o.atn;
import o.ato;
import o.atw;
import o.aui;

class PsBroadcast
{

    public boolean availableForReplay;
    public String broadcastState;
    public String city;
    public String className;
    public String country;
    public String countryState;
    public String createdAt;
    public String endTime;
    public boolean featured;
    public String featuredCategory;
    public String featuredCategoryColor;
    public String featuredReason;
    public boolean hasLocation;
    public ArrayList heartThemes;
    public int height;
    public String id;
    public String imageUrl;
    public String imageUrlSmall;
    public double ipLat;
    public double ipLong;
    public boolean isLocked;
    public boolean isTrusted;
    public int numWatching;
    public int numWebWatching;
    public String pingTime;
    public String profileImageUrl;
    public ArrayList shareUserDisplayNames;
    public ArrayList shareUserIds;
    public long sortScore;
    public String startTime;
    public String timedOutTime;
    public String title;
    public String twitterUsername;
    public String updatedAt;
    public String userDisplayName;
    public String userId;
    public int width;

    PsBroadcast()
    {
    }

    private long parseTime(String s)
    {
        if (aui._mth02BF(s))
        {
            Time time = new Time();
            time.parse3339(s);
            return time.toMillis(false);
        } else
        {
            return 0L;
        }
    }

    public atn create()
    {
        o.atb atb = atn.gl().FEE8(id).FF68(title)._mth02CA(atw._mth02BD(country, city, countryState))._mth02E1(parseTime(createdAt))._mth03B9(featured)._mth0208(featuredCategory)._mth020B(featuredCategoryColor)._mth0268(featuredReason)._mth02EE(sortScore)._mth06E5(parseTime(startTime))._mth02CF(ipLat)._mth141D(ipLong)._mth026A(userId)._mth09F2(isLocked)._mth027E(imageUrl)._mth027F(imageUrlSmall)._mth029F(userDisplayName)._mth02B0(profileImageUrl)._mth03AA(twitterUsername)._mth1422(hasLocation)._mth02BF(shareUserIds)._mth02C8(shareUserDisplayNames)._mth02C9(heartThemes).fn();
        String s = broadcastState;
        byte byte0 = -1;
        switch (s.hashCode())
        {
        case -1391247659: 
            if (s.equals("NOT_STARTED"))
            {
                byte0 = 0;
            }
            break;

        case -60968498: 
            if (s.equals("PUBLISHED"))
            {
                byte0 = 1;
            }
            break;

        case -2026200673: 
            if (s.equals("RUNNING"))
            {
                byte0 = 2;
            }
            break;

        case -1466757626: 
            if (s.equals("TIMED_OUT"))
            {
                byte0 = 3;
            }
            break;

        case 66114202: 
            if (s.equals("ENDED"))
            {
                byte0 = 4;
            }
            break;
        }
        switch (byte0)
        {
        case 0: // '\0'
            atb.bDW = ato.bEb;
            break;

        case 1: // '\001'
            atb.bDW = ato.bEc;
            break;

        case 2: // '\002'
            atb.bDW = ato.bEd;
            break;

        case 3: // '\003'
            atb.bDW = ato.bEe;
            break;

        case 4: // '\004'
            atb.bDW = ato.bEf;
            break;
        }
        atb.bDV = parseTime(endTime);
        atb.bEa = numWatching + numWebWatching;
        atb.bDX = availableForReplay;
        atb.bDY = isTrusted;
        return atb;
    }
}
