// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import java.math.BigInteger;
import o.asy;
import o.auf;
import o.aug;
import tv.periscope.chatman.api.Sender;

public class PsMessage
{

    public final String blockedMessageUUID;
    public final String body;
    public final String broadcasterBlockedMessage;
    public final String broadcasterBlockedUserId;
    public final String broadcasterBlockedUsername;
    public final BigInteger broadcasterNtp;
    public final String displayName;
    public final String initials;
    public final Integer invitedCount;
    public final Double latitude;
    public final Double longitude;
    public final BigInteger ntpForLiveFrame;
    public final Integer participantIndex;
    public final String profileImageUrl;
    public final String signature;
    public final String signerToken;
    public final Long timestamp;
    public final Double timestampPlaybackOffset;
    public final int type;
    public final String userId;
    public final String username;
    public final String uuid;
    public final Integer version;

    public PsMessage(String s, auf auf1)
    {
        type = auf1.go().ordinal();
        signerToken = s;
        participantIndex = auf1.gp();
        version = auf1.gn();
        uuid = auf1._mth1F35();
        ntpForLiveFrame = auf1.gq();
        body = auf1.eI();
        username = auf1.gj();
        profileImageUrl = auf1.fi();
        initials = auf1.gt();
        timestamp = auf1.gr();
        signature = auf1.gs();
        displayName = auf1.displayName();
        userId = auf1.fd();
        timestampPlaybackOffset = auf1.gu();
        latitude = auf1.gv();
        longitude = auf1.gw();
        invitedCount = auf1.gx();
        broadcasterBlockedMessage = auf1.gy();
        broadcasterBlockedUserId = auf1.gz();
        broadcasterBlockedUsername = auf1.gA();
        broadcasterNtp = auf1.gB();
        blockedMessageUUID = auf1.gC();
    }

    private Double safe(Double double1)
    {
        if (double1 == null)
        {
            return Double.valueOf(0.0D);
        } else
        {
            return double1;
        }
    }

    private Integer safe(Integer integer)
    {
        if (integer == null)
        {
            return Integer.valueOf(0);
        } else
        {
            return integer;
        }
    }

    private Long safe(Long long1)
    {
        if (long1 == null)
        {
            return Long.valueOf(0L);
        } else
        {
            return long1;
        }
    }

    private String safe(String s)
    {
        if (s == null)
        {
            return "";
        } else
        {
            return s;
        }
    }

    private BigInteger safe(BigInteger biginteger)
    {
        if (biginteger == null)
        {
            return BigInteger.ZERO;
        } else
        {
            return biginteger;
        }
    }

    public auf toMessage(String s, String s1)
    {
        o.aud.if if1 = new o.aud.if();
        if1.bEx = Integer.valueOf(0);
        return if1._mth02CB(Integer.valueOf(2))._mth02CB(safe(version))._mth02CB(aug._mth0142(type))._mth0407(safe(s))._mth0433(safe(userId))._mth02CE(safe(participantIndex))._mth0640(safe(ntpForLiveFrame))._mth0630(safe(uuid))._mth02CB(safe(timestamp))._mth068A(safe(signature))._mth0719(safe(username))._mth0E07(safe(displayName))._mth0E27(safe(initials))._mth1426(safe(profileImageUrl))._mth1484(safe(body))._mth02CA(safe(timestampPlaybackOffset))._mth02CB(safe(latitude))._mth02CE(safe(longitude))._mth02CF(safe(invitedCount))._mth14BC(safe(broadcasterBlockedMessage))._mth14D1(safe(broadcasterBlockedUserId))._mth1506(safe(broadcasterBlockedUsername))._mth1427(safe(broadcasterNtp))._mth1D16(safe(blockedMessageUUID))._mth0140(1)._mth1D2C(s1).gG();
    }

    public auf toMessage(asy asy1)
    {
        Sender sender = asy1.eJ();
        o.aud.if if1 = new o.aud.if();
        if1.bEx = Integer.valueOf(0);
        return if1._mth02CB(Integer.valueOf(2))._mth02CB(safe(version))._mth02CB(aug._mth0142(type))._mth0433(safe(sender.userId))._mth02CE(safe(sender.participantIndex))._mth0640(safe(ntpForLiveFrame))._mth0630(safe(uuid))._mth02CB(safe(timestamp))._mth0719(safe(sender.username))._mth0E07(safe(sender.displayName))._mth1426(safe(sender.profileImageUrl))._mth1484(safe(body))._mth02CA(safe(timestampPlaybackOffset))._mth02CB(safe(latitude))._mth02CE(safe(longitude))._mth02CF(safe(invitedCount))._mth14BC(safe(broadcasterBlockedMessage))._mth14D1(safe(broadcasterBlockedUserId))._mth1506(safe(broadcasterBlockedUsername))._mth1427(safe(broadcasterNtp))._mth1D16(safe(blockedMessageUUID))._mth0140(2)._mth1D31(asy1.eK()).gG();
    }
}
