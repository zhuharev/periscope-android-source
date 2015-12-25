// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class uf extends Enum
{

    public static final uf Tr;
    public static final uf Ts;
    public static final uf Tt;
    public static final uf Tu;
    private static final uf Tv[];

    private uf(String s, int i)
    {
        super(s, i);
    }

    public static uf valueOf(String s)
    {
        return (uf)Enum.valueOf(o/uf, s);
    }

    public static uf[] values()
    {
        return (uf[])Tv.clone();
    }

    static 
    {
        Tr = new uf("GET", 0);
        Ts = new uf("POST", 1);
        Tt = new uf("PUT", 2);
        Tu = new uf("DELETE", 3);
        Tv = (new uf[] {
            Tr, Ts, Tt, Tu
        });
    }
}
