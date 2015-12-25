// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.09F0;
import o.eo;

// Referenced classes of package com.google.android.gms.location:
//            LocationSettingsStates

public final class LocationSettingsResult
    implements _cls09F0, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new eo();
    public final Status CW;
    public final LocationSettingsStates CX;
    public final int wB;

    public LocationSettingsResult(int i, Status status, LocationSettingsStates locationsettingsstates)
    {
        wB = i;
        CW = status;
        CX = locationsettingsstates;
    }

    public LocationSettingsResult(Status status)
    {
        this(1, status, null);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        eo._mth02CA(this, parcel, i);
    }

    public final Status _mth0390()
    {
        return CW;
    }

}
