// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class sd extends Enum
{

    private static sd RG;
    private static sd RH;
    private static sd RI;
    private static sd RJ;
    private static final sd RK[];
    public final int id;

    private sd(String s, int i, int j)
    {
        super(s, i);
        id = j;
    }

    public static sd valueOf(String s)
    {
        return (sd)Enum.valueOf(o/sd, s);
    }

    public static sd[] values()
    {
        return (sd[])RK.clone();
    }

    public static sd _mth15AE(String s)
    {
        if ("io.crash.air".equals(s))
        {
            return RI;
        }
        if (s != null)
        {
            return RJ;
        } else
        {
            return RG;
        }
    }

    public final String toString()
    {
        return Integer.toString(id);
    }

    static 
    {
        RG = new sd("DEVELOPER", 0, 1);
        RH = new sd("USER_SIDELOAD", 1, 2);
        RI = new sd("TEST_DISTRIBUTION", 2, 3);
        RJ = new sd("APP_STORE", 3, 4);
        RK = (new sd[] {
            RG, RH, RI, RJ
        });
    }
}
