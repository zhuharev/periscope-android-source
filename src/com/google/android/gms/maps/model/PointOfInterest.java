// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.ha;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLng

public final class PointOfInterest
    implements SafeParcelable
{

    public static final ha CREATOR = new ha();
    public final LatLng Fs;
    public final String Ft;
    public final String name;
    public final int wB;

    public PointOfInterest(int i, LatLng latlng, String s, String s1)
    {
        wB = i;
        Fs = latlng;
        Ft = s;
        name = s1;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        ha._mth02CA(this, parcel, i);
    }

}
