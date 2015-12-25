// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.072B;
import o.0E25;
import o.14B4;

public class ValidateAccountRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls0E25();
    public final int wB;
    public final int xB;
    public final Bundle xC;
    public final String xD;
    public final IBinder xn;
    public final Scope xo[];

    public ValidateAccountRequest(int i, int j, IBinder ibinder, Scope ascope[], Bundle bundle, String s)
    {
        wB = i;
        xB = j;
        xn = ibinder;
        xo = ascope;
        xC = bundle;
        xD = s;
    }

    public ValidateAccountRequest(_cls14B4 _pcls14b4, Scope ascope[], String s, Bundle bundle)
    {
        int i = _cls072B.wF;
        if (_pcls14b4 == null)
        {
            _pcls14b4 = null;
        } else
        {
            _pcls14b4 = _pcls14b4.asBinder();
        }
        this(1, i, ((IBinder) (_pcls14b4)), ascope, bundle, s);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        _cls0E25._mth02CA(this, parcel, i);
    }

}
