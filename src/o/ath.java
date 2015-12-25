// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            atu

public final class ath extends atu
{

    private final long bDN;
    private final int bDO;

    public ath(long l, int i)
    {
        bDN = l;
        bDO = i;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof atu)
        {
            obj = (atu)obj;
            return bDN == ((atu) (obj)).fX() && bDO == ((atu) (obj)).fY();
        } else
        {
            return false;
        }
    }

    public final long fX()
    {
        return bDN;
    }

    public final int fY()
    {
        return bDO;
    }

    public final int hashCode()
    {
        return (int)(bDN >>> 32 ^ bDN ^ 0xf4243L) * 0xf4243 ^ bDO;
    }

    public final String toString()
    {
        return (new StringBuilder("FaderKey{itemId=")).append(bDN).append(", mergeCount=").append(bDO).append("}").toString();
    }
}
