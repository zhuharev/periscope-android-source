// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.09F0;
import o.dw;

public final class FusedLocationProviderResult
    implements _cls09F0, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new dw();
    public final Status CW;
    public final int wB;

    public FusedLocationProviderResult(int i, Status status)
    {
        wB = i;
        CW = status;
    }

    private FusedLocationProviderResult(Status status)
    {
        this(1, status);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        dw._mth02CA(this, parcel, i);
    }

    public final Status _mth0390()
    {
        return CW;
    }

    static 
    {
        new FusedLocationProviderResult(Status.xi);
    }
}
