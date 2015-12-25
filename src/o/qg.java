// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class qg
{

    public final String Pn;
    long Pt;
    private long Pu;
    boolean Pv;
    long Pw;

    public qg(String s)
    {
        Pn = s;
        Pt = 0L;
        Pu = 0L;
        Pv = false;
    }

    public final void stop()
    {
        if (Pv)
        {
            Pu = System.currentTimeMillis();
            Pw = Pw + (Pu - Pt);
        }
        Pt = 0L;
        Pu = 0L;
        Pv = false;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder("Timer ")).append(Pn).append(", ");
        Object obj;
        if (Pv)
        {
            obj = "Running";
        } else
        {
            obj = "Stopped";
        }
        obj = stringbuilder.append(((String) (obj))).append(", Current Time: ");
        long l;
        if (Pv)
        {
            l = Pw + (System.currentTimeMillis() - Pt);
        } else
        {
            l = Pw;
        }
        return ((StringBuilder) (obj)).append(l).append("ms").toString();
    }

    public final long _mth0422()
    {
        long l;
        if (Pv)
        {
            l = Pw + (System.currentTimeMillis() - Pt);
        } else
        {
            l = Pw;
        }
        return l / 1000L;
    }
}
