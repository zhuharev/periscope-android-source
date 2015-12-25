// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.maps.model.LatLng;

// Referenced classes of package o:
//            nm, nl

public final class nn
{

    private double LC;

    public nn(double d)
    {
        LC = d;
    }

    public final nm _mth02BE(LatLng latlng)
    {
        double d = latlng.longitude / 360D;
        double d1 = Math.sin(Math.toRadians(latlng.latitude));
        d1 = (Math.log((1.0D + d1) / (1.0D - d1)) * 0.5D) / -6.2831853071795862D;
        return new nm(LC * (d + 0.5D), LC * (d1 + 0.5D));
    }

    public final LatLng _mth02CA(nl nl1)
    {
        double d = nl1.x / LC;
        return new LatLng(90D - Math.toDegrees(Math.atan(Math.exp(-(0.5D - nl1.y / LC) * 2D * 3.1415926535897931D)) * 2D), (d - 0.5D) * 360D);
    }
}
