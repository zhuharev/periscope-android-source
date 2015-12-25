// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class vf extends Enum
{

    public static final vf UL;
    public static final vf UM;
    public static final vf UN;
    private static final vf UO[];

    private vf(String s, int i)
    {
        super(s, i);
    }

    public static vf valueOf(String s)
    {
        return (vf)Enum.valueOf(o/vf, s);
    }

    public static vf[] values()
    {
        return (vf[])UO.clone();
    }

    static 
    {
        UL = new vf("USE_CACHE", 0);
        UM = new vf("SKIP_CACHE_LOOKUP", 1);
        UN = new vf("IGNORE_CACHE_EXPIRATION", 2);
        UO = (new vf[] {
            UL, UM, UN
        });
    }
}
