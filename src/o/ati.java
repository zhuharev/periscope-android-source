// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            atv

public final class ati extends atv
{

    private final atv.if bDP;
    private final String bDQ;

    public ati(atv.if if1, String s)
    {
        if (if1 == null)
        {
            throw new NullPointerException("Null type");
        } else
        {
            bDP = if1;
            bDQ = s;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof atv)
        {
            obj = (atv)obj;
            return bDP.equals(((atv) (obj)).fZ()) && (bDQ != null ? bDQ.equals(((atv) (obj)).ga()) : ((atv) (obj)).ga() == null);
        } else
        {
            return false;
        }
    }

    public final atv.if fZ()
    {
        return bDP;
    }

    public final String ga()
    {
        return bDQ;
    }

    public final int hashCode()
    {
        int j = bDP.hashCode();
        int i;
        if (bDQ == null)
        {
            i = 0;
        } else
        {
            i = bDQ.hashCode();
        }
        return (j ^ 0xf4243) * 0xf4243 ^ i;
    }

    public final String toString()
    {
        return (new StringBuilder("FeedItem{type=")).append(bDP).append(", itemId=").append(bDQ).append("}").toString();
    }
}
