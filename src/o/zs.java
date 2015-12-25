// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class zs extends Enum
{

    public static final zs aWX;
    public static final zs aWY;
    public static final zs aWZ;
    public static final zs aXa;
    public static final zs aXb;
    public static final zs aXc;
    public static final zs aXd;
    public static final zs aXe;
    public static final zs aXf;
    private static zs aXg;
    private static zs aXh;
    private static final zs aXi[];

    private zs(String s, int i)
    {
        super(s, i);
    }

    public static zs valueOf(String s)
    {
        return (zs)Enum.valueOf(o/zs, s);
    }

    public static zs[] values()
    {
        return (zs[])aXi.clone();
    }

    static 
    {
        aWX = new zs("Followers", 0);
        aWY = new zs("Following", 1);
        aWZ = new zs("MutualFollow", 2);
        aXa = new zs("Blocked", 3);
        aXb = new zs("SuggestedTwitter", 4);
        aXc = new zs("SuggestedFeatured", 5);
        aXd = new zs("SuggestedHearts", 6);
        aXe = new zs("SuggestedPopular", 7);
        aXf = new zs("SearchResults", 8);
        aXg = new zs("Live", 9);
        aXh = new zs("Replay", 10);
        aXi = (new zs[] {
            aWX, aWY, aWZ, aXa, aXb, aXc, aXd, aXe, aXf, aXg, 
            aXh
        });
    }
}
