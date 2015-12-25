// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.ep;

public final class LocationSettingsStates
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ep();
    public final boolean CY;
    public final boolean CZ;
    public final boolean Da;
    public final boolean Db;
    public final boolean Dc;
    public final boolean Dd;
    public final boolean De;
    public final int wB;

    public LocationSettingsStates(int i, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, 
            boolean flag6)
    {
        wB = i;
        CY = flag;
        CZ = flag1;
        Da = flag2;
        Db = flag3;
        Dc = flag4;
        Dd = flag5;
        De = flag6;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        ep._mth02CA(this, parcel);
    }

}
