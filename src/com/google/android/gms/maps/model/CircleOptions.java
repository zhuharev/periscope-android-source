// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.gv;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLng

public final class CircleOptions
    implements SafeParcelable
{

    public static final gv CREATOR = new gv();
    public LatLng ES;
    public double ET;
    public float EU;
    public int EV;
    public int EW;
    public float EX;
    public boolean EY;
    public final int wB;

    public CircleOptions()
    {
        ES = null;
        ET = 0.0D;
        EU = 10F;
        EV = 0xff000000;
        EW = 0;
        EX = 0.0F;
        EY = true;
        wB = 1;
    }

    public CircleOptions(int i, LatLng latlng, double d, float f, int j, int k, 
            float f1, boolean flag)
    {
        ES = null;
        ET = 0.0D;
        EU = 10F;
        EV = 0xff000000;
        EW = 0;
        EX = 0.0F;
        EY = true;
        wB = i;
        ES = latlng;
        ET = d;
        EU = f;
        EV = j;
        EW = k;
        EX = f1;
        EY = flag;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        gv._mth02CA(this, parcel, i);
    }

}
