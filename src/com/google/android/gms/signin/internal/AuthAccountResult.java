// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.hm;

public class AuthAccountResult
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new hm();
    public final int wB;

    public AuthAccountResult()
    {
        this(1);
    }

    public AuthAccountResult(int i)
    {
        wB = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hm._mth02CA(this, parcel);
    }

}
