// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.List;

// Referenced classes of package o:
//            aub

public final class atm extends aub
{

    private final List bDT;
    private final String userId;
    private final String username;

    public atm(String s, String s1, List list)
    {
        if (s == null)
        {
            throw new NullPointerException("Null userId");
        }
        userId = s;
        if (s1 == null)
        {
            throw new NullPointerException("Null username");
        }
        username = s1;
        if (list == null)
        {
            throw new NullPointerException("Null broadcasts");
        } else
        {
            bDT = list;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof aub)
        {
            obj = (aub)obj;
            return userId.equals(((aub) (obj)).fd()) && username.equals(((aub) (obj)).gj()) && bDT.equals(((aub) (obj)).gk());
        } else
        {
            return false;
        }
    }

    public final String fd()
    {
        return userId;
    }

    public final String gj()
    {
        return username;
    }

    public final List gk()
    {
        return bDT;
    }

    public final int hashCode()
    {
        return ((userId.hashCode() ^ 0xf4243) * 0xf4243 ^ username.hashCode()) * 0xf4243 ^ bDT.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("UserBroadcasts{userId=")).append(userId).append(", username=").append(username).append(", broadcasts=").append(bDT).append("}").toString();
    }
}
