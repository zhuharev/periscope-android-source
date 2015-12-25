// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            atx

public final class atk extends atx
{

    private final int bDR;
    private final int bDS;
    private final long watchedTime;

    public atk(long l, int i, int j)
    {
        watchedTime = l;
        bDR = i;
        bDS = j;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof atx)
        {
            obj = (atx)obj;
            return watchedTime == ((atx) (obj)).gf() && bDR == ((atx) (obj)).gg() && bDS == ((atx) (obj)).gh();
        } else
        {
            return false;
        }
    }

    public final long gf()
    {
        return watchedTime;
    }

    public final int gg()
    {
        return bDR;
    }

    public final int gh()
    {
        return bDS;
    }

    public final int hashCode()
    {
        return ((int)(watchedTime >>> 32 ^ watchedTime ^ 0xf4243L) * 0xf4243 ^ bDR) * 0xf4243 ^ bDS;
    }

    public final String toString()
    {
        return (new StringBuilder("Meta{watchedTime=")).append(watchedTime).append(", numWatched=").append(bDR).append(", lostBeforeEnd=").append(bDS).append("}").toString();
    }
}
