// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class zw extends Enum
{

    public static final zw aYA;
    public static final zw aYB;
    public static final zw aYC;
    public static final zw aYD;
    public static final zw aYE;
    public static final zw aYF;
    public static final zw aYG;
    public static final zw aYH;
    public static final zw aYI;
    public static final zw aYJ;
    public static final zw aYK;
    public static final zw aYL;
    public static final zw aYM;
    public static final zw aYN;
    public static final zw aYO;
    public static final zw aYP;
    public static final zw aYQ;
    private static final zw aYR[];
    public static final zw aYx;
    public static final zw aYy;
    public static final zw aYz;

    private zw(String s, int i)
    {
        super(s, i);
    }

    public static zw valueOf(String s)
    {
        return (zw)Enum.valueOf(o/zw, s);
    }

    public static zw[] values()
    {
        return (zw[])aYR.clone();
    }

    static 
    {
        aYx = new zw("Follow", 0);
        aYy = new zw("Unfollow", 1);
        aYz = new zw("Mute", 2);
        aYA = new zw("Unmute", 3);
        aYB = new zw("UserUpdated", 4);
        aYC = new zw("FollowersUpdated", 5);
        aYD = new zw("FollowingUpdated", 6);
        aYE = new zw("UserAdded", 7);
        aYF = new zw("SuggestedUsersProcessed", 8);
        aYG = new zw("SearchResultsUpdated", 9);
        aYH = new zw("MegaBroadcastProcessed", 10);
        aYI = new zw("BroadcastsUpdated", 11);
        aYJ = new zw("BroadcastViewersUpdated", 12);
        aYK = new zw("TwitterCredentialsUpdated", 13);
        aYL = new zw("GlobalFeedProcessed", 14);
        aYM = new zw("GlobalMapProcessed", 15);
        aYN = new zw("Block", 16);
        aYO = new zw("Unblock", 17);
        aYP = new zw("BlockedUpdated", 18);
        aYQ = new zw("MyBroadcastsUpdated", 19);
        aYR = (new zw[] {
            aYx, aYy, aYz, aYA, aYB, aYC, aYD, aYE, aYF, aYG, 
            aYH, aYI, aYJ, aYK, aYL, aYM, aYN, aYO, aYP, aYQ
        });
    }
}
