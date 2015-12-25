// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


final class _cls14AC
{

    public final String advertisingId;
    public final String tA;
    public final String tB;
    public final String tC;
    public final String tD;
    public final String tE;
    private String tg;
    public final String tu;
    public final String tv;
    public final String tw;
    public final String tx;
    public final Boolean ty;
    public final String tz;

    public _cls14AC(String s, String s1, String s2, String s3, String s4, Boolean boolean1, String s5, 
            String s6, String s7, String s8, String s9, String s10)
    {
        tu = s;
        tv = s1;
        tw = s2;
        tx = s3;
        advertisingId = s4;
        ty = boolean1;
        tz = s5;
        tA = s6;
        tB = s7;
        tC = s8;
        tD = s9;
        tE = s10;
    }

    public final String toString()
    {
        if (tg == null)
        {
            tg = (new StringBuilder("appBundleId=")).append(tu).append(", executionId=").append(tv).append(", installationId=").append(tw).append(", androidId=").append(tx).append(", advertisingId=").append(advertisingId).append(", limitAdTrackingEnabled=").append(ty).append(", betaDeviceToken=").append(tz).append(", buildId=").append(tA).append(", osVersion=").append(tB).append(", deviceModel=").append(tC).append(", appVersionCode=").append(tD).append(", appVersionName=").append(tE).toString();
        }
        return tg;
    }
}
