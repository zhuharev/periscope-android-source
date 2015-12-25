// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class zv extends Enum
{

    public static final zv aYp;
    public static final zv aYq;
    public static final zv aYr;
    public static final zv aYs;
    public static final zv aYt;
    public static final zv aYu;
    public static final zv aYv;
    private static final zv aYw[];

    private zv(String s, int i)
    {
        super(s, i);
    }

    public static zv valueOf(String s)
    {
        return (zv)Enum.valueOf(o/zv, s);
    }

    public static zv[] values()
    {
        return (zv[])aYw.clone();
    }

    static 
    {
        aYp = new zv("OnNormalLogout", 0);
        aYq = new zv("OnUnauthorizedLogout", 1);
        aYr = new zv("OnBannedUserLogout", 2);
        aYs = new zv("OnBannedCopyrightUserLogout", 3);
        aYt = new zv("OnBannedSelfHarmUserLogout", 4);
        aYu = new zv("OnUnban", 5);
        aYv = new zv("OnLoggedIn", 6);
        aYw = (new zv[] {
            aYp, aYq, aYr, aYs, aYt, aYu, aYv
        });
    }
}
