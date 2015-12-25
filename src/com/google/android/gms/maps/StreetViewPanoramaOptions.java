// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import o.hl;

public final class StreetViewPanoramaOptions
    implements SafeParcelable
{

    public static final hl CREATOR = new hl();
    public StreetViewPanoramaCamera EA;
    public String EB;
    public LatLng EC;
    public Integer ED;
    public Boolean EE;
    public Boolean EF;
    public Boolean EG;
    public Boolean Ec;
    public Boolean Ei;
    public final int wB;

    public StreetViewPanoramaOptions()
    {
        EE = Boolean.valueOf(true);
        Ei = Boolean.valueOf(true);
        EF = Boolean.valueOf(true);
        EG = Boolean.valueOf(true);
        wB = 1;
    }

    public StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetviewpanoramacamera, String s, LatLng latlng, Integer integer, byte byte0, byte byte1, 
            byte byte2, byte byte3, byte byte4)
    {
        EE = Boolean.valueOf(true);
        Ei = Boolean.valueOf(true);
        EF = Boolean.valueOf(true);
        EG = Boolean.valueOf(true);
        wB = i;
        EA = streetviewpanoramacamera;
        EC = latlng;
        ED = integer;
        EB = s;
        EE = o._cls141D.if._mth02CA(byte0);
        Ei = o._cls141D.if._mth02CA(byte1);
        EF = o._cls141D.if._mth02CA(byte2);
        EG = o._cls141D.if._mth02CA(byte3);
        Ec = o._cls141D.if._mth02CA(byte4);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        hl._mth02CA(this, parcel, i);
    }

}
