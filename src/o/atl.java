// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            atz

public final class atl extends atz
{

    private final boolean aYS;
    private final String broadcastId;
    private final String userId;

    public atl(String s, String s1, boolean flag)
    {
        if (s == null)
        {
            throw new NullPointerException("Null broadcastId");
        }
        broadcastId = s;
        if (s1 == null)
        {
            throw new NullPointerException("Null userId");
        } else
        {
            userId = s1;
            aYS = flag;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof atz)
        {
            obj = (atz)obj;
            return broadcastId.equals(((atz) (obj)).fW()) && userId.equals(((atz) (obj)).fd()) && aYS == ((atz) (obj)).gi();
        } else
        {
            return false;
        }
    }

    final String fW()
    {
        return broadcastId;
    }

    final String fd()
    {
        return userId;
    }

    final boolean gi()
    {
        return aYS;
    }

    public final int hashCode()
    {
        int i = broadcastId.hashCode();
        int j = userId.hashCode();
        char c;
        if (aYS)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        return ((i ^ 0xf4243) * 0xf4243 ^ j) * 0xf4243 ^ c;
    }

    public final String toString()
    {
        return (new StringBuilder("ParticipantKey{broadcastId=")).append(broadcastId).append(", userId=").append(userId).append(", replay=").append(aYS).append("}").toString();
    }
}
