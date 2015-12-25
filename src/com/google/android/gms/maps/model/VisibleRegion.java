// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import o.152C;
import o.hj;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLng, LatLngBounds

public final class VisibleRegion
    implements SafeParcelable
{

    public static final hj CREATOR = new hj();
    public final LatLng FG;
    public final LatLng FH;
    public final LatLng FI;
    public final LatLng FJ;
    public final LatLngBounds FK;
    public final int wB;

    public VisibleRegion(int i, LatLng latlng, LatLng latlng1, LatLng latlng2, LatLng latlng3, LatLngBounds latlngbounds)
    {
        wB = i;
        FG = latlng;
        FH = latlng1;
        FI = latlng2;
        FJ = latlng3;
        FK = latlngbounds;
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
        if (!(obj instanceof VisibleRegion))
        {
            return false;
        }
        obj = (VisibleRegion)obj;
        return FG.equals(((VisibleRegion) (obj)).FG) && FH.equals(((VisibleRegion) (obj)).FH) && FI.equals(((VisibleRegion) (obj)).FI) && FJ.equals(((VisibleRegion) (obj)).FJ) && FK.equals(((VisibleRegion) (obj)).FK);
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            FG, FH, FI, FJ, FK
        });
    }

    public final String toString()
    {
        return (new _cls152C(this, (byte)0))._mth02CA("nearLeft", FG)._mth02CA("nearRight", FH)._mth02CA("farLeft", FI)._mth02CA("farRight", FJ)._mth02CA("latLngBounds", FK).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        hj._mth02CA(this, parcel, i);
    }

}
