// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls15BD, _cls15BE, cn

public static final class Long
{

    public static cn yY;
    public static cn yZ = cn._mth02BB("gms:common:stats:connections:ignored_calling_processes", "");
    public static cn za = cn._mth02BB("gms:common:stats:connections:ignored_calling_services", "");
    public static cn zb = cn._mth02BB("gms:common:stats:connections:ignored_target_processes", "");
    public static cn zc = cn._mth02BB("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
    public static cn zd = cn._mth02CA("gms:common:stats:connections:time_out_duration", Long.valueOf(0x927c0L));

    static 
    {
        yY = cn._mth02CA("gms:common:stats:connections:level", Integer.valueOf(_cls15BE.zf));
    }
}
