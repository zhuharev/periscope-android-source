// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Serializable;

public final class wr
    implements Serializable, Comparable
{

    public final long VE;

    private wr(long l)
    {
        VE = l;
    }

    private static void _mth02CA(StringBuilder stringbuilder, long l)
    {
        String s = Long.toHexString(l);
        for (int i = s.length(); i < 8; i++)
        {
            stringbuilder.append('0');
        }

        stringbuilder.append(s);
    }

    public static wr _mth05D9(long l)
    {
        boolean flag;
        if (l < 0x1e5ae01dc00L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            l += 0x20251fe2400L;
        } else
        {
            l -= 0x1e5ae01dc00L;
        }
        long l1 = l / 1000L;
        long l2 = (l % 1000L << 32) / 1000L;
        l = l1;
        if (flag)
        {
            l = l1 | 0x80000000L;
        }
        return new wr(l << 32 | l2);
    }

    public final volatile int compareTo(Object obj)
    {
        obj = (wr)obj;
        long l = VE;
        long l1 = ((wr) (obj)).VE;
        if (l < l1)
        {
            return -1;
        }
        return l != l1 ? 1 : 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof wr)
        {
            return VE == ((wr)obj).VE;
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return (int)(VE ^ VE >>> 32);
    }

    public final String toString()
    {
        long l = VE;
        StringBuilder stringbuilder = new StringBuilder();
        _mth02CA(stringbuilder, l >>> 32 & 0xffffffffL);
        stringbuilder.append('.');
        _mth02CA(stringbuilder, 0xffffffffL & l);
        return stringbuilder.toString();
    }
}
