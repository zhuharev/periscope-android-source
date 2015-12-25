// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.math.BigInteger;

// Referenced classes of package o:
//            aud, aug

public static final class .String extends .String
{

    private aug aVk;
    private BigInteger bEu;
    private String bEv;
    private String bEw;
    public Integer bEx;
    private String blockedMessageUUID;
    private String body;
    private String broadcasterBlockedMessage;
    private String broadcasterBlockedUserId;
    private String broadcasterBlockedUsername;
    private BigInteger broadcasterNtp;
    private String channel;
    private String displayName;
    private String initials;
    private Integer invitedCount;
    private Double latitude;
    private Double longitude;
    private Integer participantIndex;
    private String profileImageUrl;
    private String signature;
    private Long timestamp;
    private Double timestampPlaybackOffset;
    private String userId;
    private String username;
    private String uuid;
    private Integer version;

    public final aud gG()
    {
        String s1 = "";
        if (version == null)
        {
            s1 = (new StringBuilder()).append("").append(" version").toString();
        }
        String s = s1;
        if (aVk == null)
        {
            s = (new StringBuilder()).append(s1).append(" type").toString();
        }
        s1 = s;
        if (bEx == null)
        {
            s1 = (new StringBuilder()).append(s).append(" source").toString();
        }
        if (!s1.isEmpty())
        {
            throw new IllegalStateException((new StringBuilder("Missing required properties:")).append(s1).toString());
        } else
        {
            return new aud(version, aVk, channel, userId, participantIndex, bEu, uuid, timestamp, signature, username, displayName, initials, profileImageUrl, body, timestampPlaybackOffset, latitude, longitude, invitedCount, broadcasterBlockedMessage, broadcasterBlockedUserId, broadcasterBlockedUsername, broadcasterNtp, blockedMessageUUID, bEv, bEw, bEx.intValue(), (byte)0);
        }
    }

    public final .String _mth0140(int i)
    {
        bEx = Integer.valueOf(i);
        return this;
    }

    public final .Double _mth02CA(Double double1)
    {
        timestampPlaybackOffset = double1;
        return this;
    }

    public final .Double _mth02CB(Double double1)
    {
        latitude = double1;
        return this;
    }

    public final .Integer _mth02CB(Integer integer)
    {
        version = integer;
        return this;
    }

    public final .Long _mth02CB(Long long1)
    {
        timestamp = long1;
        return this;
    }

    public final  _mth02CB(aug aug)
    {
        aVk = aug;
        return this;
    }

    public final .Double _mth02CE(Double double1)
    {
        longitude = double1;
        return this;
    }

    public final .Integer _mth02CE(Integer integer)
    {
        participantIndex = integer;
        return this;
    }

    public final .Integer _mth02CF(Integer integer)
    {
        invitedCount = integer;
        return this;
    }

    public final .String _mth0407(String s)
    {
        channel = s;
        return this;
    }

    public final .String _mth0433(String s)
    {
        userId = s;
        return this;
    }

    public final .String _mth0630(String s)
    {
        uuid = s;
        return this;
    }

    public final .BigInteger _mth0640(BigInteger biginteger)
    {
        bEu = biginteger;
        return this;
    }

    public final .String _mth068A(String s)
    {
        signature = s;
        return this;
    }

    public final .String _mth0719(String s)
    {
        username = s;
        return this;
    }

    public final .String _mth0E07(String s)
    {
        displayName = s;
        return this;
    }

    public final .String _mth0E27(String s)
    {
        initials = s;
        return this;
    }

    public final .String _mth1426(String s)
    {
        profileImageUrl = s;
        return this;
    }

    public final .BigInteger _mth1427(BigInteger biginteger)
    {
        broadcasterNtp = biginteger;
        return this;
    }

    public final .String _mth1484(String s)
    {
        body = s;
        return this;
    }

    public final .String _mth14BC(String s)
    {
        broadcasterBlockedMessage = s;
        return this;
    }

    public final .String _mth14D1(String s)
    {
        broadcasterBlockedUserId = s;
        return this;
    }

    public final .String _mth1506(String s)
    {
        broadcasterBlockedUsername = s;
        return this;
    }

    public final .String _mth1D16(String s)
    {
        blockedMessageUUID = s;
        return this;
    }

    public final .String _mth1D2C(String s)
    {
        bEv = s;
        return this;
    }

    public final .String _mth1D31(String s)
    {
        bEw = s;
        return this;
    }

    public .String()
    {
    }
}
