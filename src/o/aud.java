// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.math.BigInteger;

// Referenced classes of package o:
//            auf, aug

final class aud extends auf
{
    public static final class if extends auf.if
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

        public final if _mth0140(int i)
        {
            bEx = Integer.valueOf(i);
            return this;
        }

        public final if _mth02CA(Double double1)
        {
            timestampPlaybackOffset = double1;
            return this;
        }

        public final if _mth02CB(Double double1)
        {
            latitude = double1;
            return this;
        }

        public final if _mth02CB(Integer integer)
        {
            version = integer;
            return this;
        }

        public final if _mth02CB(Long long1)
        {
            timestamp = long1;
            return this;
        }

        public final if _mth02CB(aug aug1)
        {
            aVk = aug1;
            return this;
        }

        public final if _mth02CE(Double double1)
        {
            longitude = double1;
            return this;
        }

        public final if _mth02CE(Integer integer)
        {
            participantIndex = integer;
            return this;
        }

        public final if _mth02CF(Integer integer)
        {
            invitedCount = integer;
            return this;
        }

        public final if _mth0407(String s)
        {
            channel = s;
            return this;
        }

        public final if _mth0433(String s)
        {
            userId = s;
            return this;
        }

        public final if _mth0630(String s)
        {
            uuid = s;
            return this;
        }

        public final if _mth0640(BigInteger biginteger)
        {
            bEu = biginteger;
            return this;
        }

        public final if _mth068A(String s)
        {
            signature = s;
            return this;
        }

        public final if _mth0719(String s)
        {
            username = s;
            return this;
        }

        public final if _mth0E07(String s)
        {
            displayName = s;
            return this;
        }

        public final if _mth0E27(String s)
        {
            initials = s;
            return this;
        }

        public final if _mth1426(String s)
        {
            profileImageUrl = s;
            return this;
        }

        public final if _mth1427(BigInteger biginteger)
        {
            broadcasterNtp = biginteger;
            return this;
        }

        public final if _mth1484(String s)
        {
            body = s;
            return this;
        }

        public final if _mth14BC(String s)
        {
            broadcasterBlockedMessage = s;
            return this;
        }

        public final if _mth14D1(String s)
        {
            broadcasterBlockedUserId = s;
            return this;
        }

        public final if _mth1506(String s)
        {
            broadcasterBlockedUsername = s;
            return this;
        }

        public final if _mth1D16(String s)
        {
            blockedMessageUUID = s;
            return this;
        }

        public final if _mth1D2C(String s)
        {
            bEv = s;
            return this;
        }

        public final if _mth1D31(String s)
        {
            bEw = s;
            return this;
        }

        public if()
        {
        }
    }


    private final int Ug;
    private final aug aVk;
    private final BigInteger bEu;
    private final String bEv;
    private final String bEw;
    private final String blockedMessageUUID;
    private final String body;
    private final String broadcasterBlockedMessage;
    private final String broadcasterBlockedUserId;
    private final String broadcasterBlockedUsername;
    private final BigInteger broadcasterNtp;
    private final String channel;
    private final String displayName;
    private final String initials;
    private final Integer invitedCount;
    private final Double latitude;
    private final Double longitude;
    private final Integer participantIndex;
    private final String profileImageUrl;
    private final String signature;
    private final Long timestamp;
    private final Double timestampPlaybackOffset;
    private final String userId;
    private final String username;
    private final String uuid;
    private final Integer version;

    private aud(Integer integer, aug aug1, String s, String s1, Integer integer1, BigInteger biginteger, String s2, 
            Long long1, String s3, String s4, String s5, String s6, String s7, String s8, 
            Double double1, Double double2, Double double3, Integer integer2, String s9, String s10, String s11, 
            BigInteger biginteger1, String s12, String s13, String s14, int i)
    {
        if (integer == null)
        {
            throw new NullPointerException("Null version");
        }
        version = integer;
        if (aug1 == null)
        {
            throw new NullPointerException("Null type");
        } else
        {
            aVk = aug1;
            channel = s;
            userId = s1;
            participantIndex = integer1;
            bEu = biginteger;
            uuid = s2;
            timestamp = long1;
            signature = s3;
            username = s4;
            displayName = s5;
            initials = s6;
            profileImageUrl = s7;
            body = s8;
            timestampPlaybackOffset = double1;
            latitude = double2;
            longitude = double3;
            invitedCount = integer2;
            broadcasterBlockedMessage = s9;
            broadcasterBlockedUserId = s10;
            broadcasterBlockedUsername = s11;
            broadcasterNtp = biginteger1;
            blockedMessageUUID = s12;
            bEv = s13;
            bEw = s14;
            Ug = i;
            return;
        }
    }

    aud(Integer integer, aug aug1, String s, String s1, Integer integer1, BigInteger biginteger, String s2, 
            Long long1, String s3, String s4, String s5, String s6, String s7, String s8, 
            Double double1, Double double2, Double double3, Integer integer2, String s9, String s10, String s11, 
            BigInteger biginteger1, String s12, String s13, String s14, int i, byte byte0)
    {
        this(integer, aug1, s, s1, integer1, biginteger, s2, long1, s3, s4, s5, s6, s7, s8, double1, double2, double3, integer2, s9, s10, s11, biginteger1, s12, s13, s14, i);
    }

    public final String displayName()
    {
        return displayName;
    }

    public final String eI()
    {
        return body;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof auf)
        {
            obj = (auf)obj;
            return version.equals(((auf) (obj)).gn()) && aVk.equals(((auf) (obj)).go()) && (channel != null ? channel.equals(((auf) (obj)).fx()) : ((auf) (obj)).fx() == null) && (userId != null ? userId.equals(((auf) (obj)).fd()) : ((auf) (obj)).fd() == null) && (participantIndex != null ? participantIndex.equals(((auf) (obj)).gp()) : ((auf) (obj)).gp() == null) && (bEu != null ? bEu.equals(((auf) (obj)).gq()) : ((auf) (obj)).gq() == null) && (uuid != null ? uuid.equals(((auf) (obj))._mth1F35()) : ((auf) (obj))._mth1F35() == null) && (timestamp != null ? timestamp.equals(((auf) (obj)).gr()) : ((auf) (obj)).gr() == null) && (signature != null ? signature.equals(((auf) (obj)).gs()) : ((auf) (obj)).gs() == null) && (username != null ? username.equals(((auf) (obj)).gj()) : ((auf) (obj)).gj() == null) && (displayName != null ? displayName.equals(((auf) (obj)).displayName()) : ((auf) (obj)).displayName() == null) && (initials != null ? initials.equals(((auf) (obj)).gt()) : ((auf) (obj)).gt() == null) && (profileImageUrl != null ? profileImageUrl.equals(((auf) (obj)).fi()) : ((auf) (obj)).fi() == null) && (body != null ? body.equals(((auf) (obj)).eI()) : ((auf) (obj)).eI() == null) && (timestampPlaybackOffset != null ? timestampPlaybackOffset.equals(((auf) (obj)).gu()) : ((auf) (obj)).gu() == null) && (latitude != null ? latitude.equals(((auf) (obj)).gv()) : ((auf) (obj)).gv() == null) && (longitude != null ? longitude.equals(((auf) (obj)).gw()) : ((auf) (obj)).gw() == null) && (invitedCount != null ? invitedCount.equals(((auf) (obj)).gx()) : ((auf) (obj)).gx() == null) && (broadcasterBlockedMessage != null ? broadcasterBlockedMessage.equals(((auf) (obj)).gy()) : ((auf) (obj)).gy() == null) && (broadcasterBlockedUserId != null ? broadcasterBlockedUserId.equals(((auf) (obj)).gz()) : ((auf) (obj)).gz() == null) && (broadcasterBlockedUsername != null ? broadcasterBlockedUsername.equals(((auf) (obj)).gA()) : ((auf) (obj)).gA() == null) && (broadcasterNtp != null ? broadcasterNtp.equals(((auf) (obj)).gB()) : ((auf) (obj)).gB() == null) && (blockedMessageUUID != null ? blockedMessageUUID.equals(((auf) (obj)).gC()) : ((auf) (obj)).gC() == null) && (bEv != null ? bEv.equals(((auf) (obj)).gD()) : ((auf) (obj)).gD() == null) && (bEw != null ? bEw.equals(((auf) (obj)).gE()) : ((auf) (obj)).gE() == null) && Ug == ((auf) (obj)).gF();
        } else
        {
            return false;
        }
    }

    public final String fd()
    {
        return userId;
    }

    public final String fi()
    {
        return profileImageUrl;
    }

    public final String fx()
    {
        return channel;
    }

    public final String gA()
    {
        return broadcasterBlockedUsername;
    }

    public final BigInteger gB()
    {
        return broadcasterNtp;
    }

    public final String gC()
    {
        return blockedMessageUUID;
    }

    public final String gD()
    {
        return bEv;
    }

    public final String gE()
    {
        return bEw;
    }

    public final int gF()
    {
        return Ug;
    }

    public final String gj()
    {
        return username;
    }

    public final Integer gn()
    {
        return version;
    }

    public final aug go()
    {
        return aVk;
    }

    public final Integer gp()
    {
        return participantIndex;
    }

    public final BigInteger gq()
    {
        return bEu;
    }

    public final Long gr()
    {
        return timestamp;
    }

    public final String gs()
    {
        return signature;
    }

    public final String gt()
    {
        return initials;
    }

    public final Double gu()
    {
        return timestampPlaybackOffset;
    }

    public final Double gv()
    {
        return latitude;
    }

    public final Double gw()
    {
        return longitude;
    }

    public final Integer gx()
    {
        return invitedCount;
    }

    public final String gy()
    {
        return broadcasterBlockedMessage;
    }

    public final String gz()
    {
        return broadcasterBlockedUserId;
    }

    public final int hashCode()
    {
        int l5 = version.hashCode();
        int i6 = aVk.hashCode();
        int i;
        if (channel == null)
        {
            i = 0;
        } else
        {
            i = channel.hashCode();
        }
        int j;
        if (userId == null)
        {
            j = 0;
        } else
        {
            j = userId.hashCode();
        }
        int k;
        if (participantIndex == null)
        {
            k = 0;
        } else
        {
            k = participantIndex.hashCode();
        }
        int l;
        if (bEu == null)
        {
            l = 0;
        } else
        {
            l = bEu.hashCode();
        }
        int i1;
        if (uuid == null)
        {
            i1 = 0;
        } else
        {
            i1 = uuid.hashCode();
        }
        int j1;
        if (timestamp == null)
        {
            j1 = 0;
        } else
        {
            j1 = timestamp.hashCode();
        }
        int k1;
        if (signature == null)
        {
            k1 = 0;
        } else
        {
            k1 = signature.hashCode();
        }
        int l1;
        if (username == null)
        {
            l1 = 0;
        } else
        {
            l1 = username.hashCode();
        }
        int i2;
        if (displayName == null)
        {
            i2 = 0;
        } else
        {
            i2 = displayName.hashCode();
        }
        int j2;
        if (initials == null)
        {
            j2 = 0;
        } else
        {
            j2 = initials.hashCode();
        }
        int k2;
        if (profileImageUrl == null)
        {
            k2 = 0;
        } else
        {
            k2 = profileImageUrl.hashCode();
        }
        int l2;
        if (body == null)
        {
            l2 = 0;
        } else
        {
            l2 = body.hashCode();
        }
        int i3;
        if (timestampPlaybackOffset == null)
        {
            i3 = 0;
        } else
        {
            i3 = timestampPlaybackOffset.hashCode();
        }
        int j3;
        if (latitude == null)
        {
            j3 = 0;
        } else
        {
            j3 = latitude.hashCode();
        }
        int k3;
        if (longitude == null)
        {
            k3 = 0;
        } else
        {
            k3 = longitude.hashCode();
        }
        int l3;
        if (invitedCount == null)
        {
            l3 = 0;
        } else
        {
            l3 = invitedCount.hashCode();
        }
        int i4;
        if (broadcasterBlockedMessage == null)
        {
            i4 = 0;
        } else
        {
            i4 = broadcasterBlockedMessage.hashCode();
        }
        int j4;
        if (broadcasterBlockedUserId == null)
        {
            j4 = 0;
        } else
        {
            j4 = broadcasterBlockedUserId.hashCode();
        }
        int k4;
        if (broadcasterBlockedUsername == null)
        {
            k4 = 0;
        } else
        {
            k4 = broadcasterBlockedUsername.hashCode();
        }
        int l4;
        if (broadcasterNtp == null)
        {
            l4 = 0;
        } else
        {
            l4 = broadcasterNtp.hashCode();
        }
        int i5;
        if (blockedMessageUUID == null)
        {
            i5 = 0;
        } else
        {
            i5 = blockedMessageUUID.hashCode();
        }
        int j5;
        if (bEv == null)
        {
            j5 = 0;
        } else
        {
            j5 = bEv.hashCode();
        }
        int k5;
        if (bEw == null)
        {
            k5 = 0;
        } else
        {
            k5 = bEw.hashCode();
        }
        return (((((((((((((((((((((((((l5 ^ 0xf4243) * 0xf4243 ^ i6) * 0xf4243 ^ i) * 0xf4243 ^ j) * 0xf4243 ^ k) * 0xf4243 ^ l) * 0xf4243 ^ i1) * 0xf4243 ^ j1) * 0xf4243 ^ k1) * 0xf4243 ^ l1) * 0xf4243 ^ i2) * 0xf4243 ^ j2) * 0xf4243 ^ k2) * 0xf4243 ^ l2) * 0xf4243 ^ i3) * 0xf4243 ^ j3) * 0xf4243 ^ k3) * 0xf4243 ^ l3) * 0xf4243 ^ i4) * 0xf4243 ^ j4) * 0xf4243 ^ k4) * 0xf4243 ^ l4) * 0xf4243 ^ i5) * 0xf4243 ^ j5) * 0xf4243 ^ k5) * 0xf4243 ^ Ug;
    }

    public final String toString()
    {
        return (new StringBuilder("Message{version=")).append(version).append(", type=").append(aVk).append(", channel=").append(channel).append(", userId=").append(userId).append(", participantIndex=").append(participantIndex).append(", ntp=").append(bEu).append(", uuid=").append(uuid).append(", timestamp=").append(timestamp).append(", signature=").append(signature).append(", username=").append(username).append(", displayName=").append(displayName).append(", initials=").append(initials).append(", profileImageUrl=").append(profileImageUrl).append(", body=").append(body).append(", timestampPlaybackOffset=").append(timestampPlaybackOffset).append(", latitude=").append(latitude).append(", longitude=").append(longitude).append(", invitedCount=").append(invitedCount).append(", broadcasterBlockedMessage=").append(broadcasterBlockedMessage).append(", broadcasterBlockedUserId=").append(broadcasterBlockedUserId).append(", broadcasterBlockedUsername=").append(broadcasterBlockedUsername).append(", broadcasterNtp=").append(broadcasterNtp).append(", blockedMessageUUID=").append(blockedMessageUUID).append(", rawJson=").append(bEv).append(", rawPayload=").append(bEw).append(", source=").append(Ug).append("}").toString();
    }

    public final String _mth1F35()
    {
        return uuid;
    }
}
