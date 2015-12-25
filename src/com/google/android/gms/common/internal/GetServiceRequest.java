// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.072B;
import o.0E20;
import o.10EB;

public class GetServiceRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls10EB();
    public final int version;
    public final int xp;
    public int xq;
    public String xr;
    public IBinder xs;
    public Scope xt[];
    public Bundle xu;
    public Account xv;

    public GetServiceRequest(int i)
    {
        version = 2;
        xq = _cls072B.wF;
        xp = i;
    }

    public GetServiceRequest(int i, int j, int k, String s, IBinder ibinder, Scope ascope[], Bundle bundle, 
            Account account)
    {
        version = i;
        xp = j;
        xq = k;
        xr = s;
        if (i < 2)
        {
            s = null;
            if (ibinder != null)
            {
                s = _cls0E20._mth02CB(o._cls14B4.if._mth02CB(ibinder));
            }
            xv = s;
        } else
        {
            xs = ibinder;
            xv = account;
        }
        xt = ascope;
        xu = bundle;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        _cls10EB._mth02CA(this, parcel, i);
    }

}
