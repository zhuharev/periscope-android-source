// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Set;
import o.0E2B;
import o.14B4;

public class AuthAccountRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls0E2B();
    public final int wB;
    public final IBinder xn;
    public final Scope xo[];

    public AuthAccountRequest(int i, IBinder ibinder, Scope ascope[])
    {
        wB = i;
        xn = ibinder;
        xo = ascope;
    }

    public AuthAccountRequest(_cls14B4 _pcls14b4, Set set)
    {
        this(1, _pcls14b4.asBinder(), (Scope[])set.toArray(new Scope[set.size()]));
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        _cls0E2B._mth02CA(this, parcel, i);
    }

}
