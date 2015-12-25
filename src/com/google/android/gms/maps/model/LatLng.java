// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.gy;

public final class LatLng
    implements SafeParcelable
{

    public static final gy CREATOR = new gy();
    public final double latitude;
    public final double longitude;
    public final int wB;

    public LatLng(double d, double d1)
    {
        this(1, d, d1);
    }

    public LatLng(int i, double d, double d1)
    {
        wB = i;
        if (-180D <= d1 && d1 < 180D)
        {
            longitude = d1;
        } else
        {
            longitude = ((d1 - 180D) % 360D + 360D) % 360D - 180D;
        }
        latitude = Math.max(-90D, Math.min(90D, d));
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof LatLng))
        {
            return false;
        }
        obj = (LatLng)obj;
        return Double.doubleToLongBits(latitude) == Double.doubleToLongBits(((LatLng) (obj)).latitude) && Double.doubleToLongBits(longitude) == Double.doubleToLongBits(((LatLng) (obj)).longitude);
    }

    public final int hashCode()
    {
        long l = Double.doubleToLongBits(latitude);
        int i = (int)(l >>> 32 ^ l);
        l = Double.doubleToLongBits(longitude);
        return (i + 31) * 31 + (int)(l >>> 32 ^ l);
    }

    public final String toString()
    {
        return (new StringBuilder("lat/lng: (")).append(latitude).append(",").append(longitude).append(")").toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        gy._mth02CA(this, parcel);
    }

}
