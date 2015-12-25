// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.gi;
import o.gw;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLng, LatLngBounds

public final class GroundOverlayOptions
    implements SafeParcelable
{

    public static final gw CREATOR = new gw();
    public float ER;
    public float EX;
    public boolean EY;
    public gi EZ;
    public LatLng Fa;
    public float Fb;
    public float Fc;
    public LatLngBounds Fd;
    public float Fe;
    public float Ff;
    public float Fg;
    public final int wB;

    public GroundOverlayOptions()
    {
        EY = true;
        Fe = 0.0F;
        Ff = 0.5F;
        Fg = 0.5F;
        wB = 1;
    }

    public GroundOverlayOptions(int i, IBinder ibinder, LatLng latlng, float f, float f1, LatLngBounds latlngbounds, float f2, 
            float f3, boolean flag, float f4, float f5, float f6)
    {
        EY = true;
        Fe = 0.0F;
        Ff = 0.5F;
        Fg = 0.5F;
        wB = i;
        EZ = new gi(o.bg.if._mth141D(ibinder));
        Fa = latlng;
        Fb = f;
        Fc = f1;
        Fd = latlngbounds;
        ER = f2;
        EX = f3;
        EY = flag;
        Fe = f4;
        Ff = f5;
        Fg = f6;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        gw._mth02CA(this, parcel, i);
    }

}
