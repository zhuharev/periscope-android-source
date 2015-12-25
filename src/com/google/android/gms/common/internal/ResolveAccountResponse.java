// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.15A8;

public class ResolveAccountResponse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls15A8();
    public final int wB;
    public boolean xA;
    public IBinder xn;
    public ConnectionResult xy;
    public boolean xz;

    public ResolveAccountResponse(int i)
    {
        this(new ConnectionResult(8, null));
    }

    public ResolveAccountResponse(int i, IBinder ibinder, ConnectionResult connectionresult, boolean flag, boolean flag1)
    {
        wB = i;
        xn = ibinder;
        xy = connectionresult;
        xz = flag;
        xA = flag1;
    }

    private ResolveAccountResponse(ConnectionResult connectionresult)
    {
        this(1, null, connectionresult, false, false);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse))
        {
            return false;
        }
        obj = (ResolveAccountResponse)obj;
        return xy.equals(((ResolveAccountResponse) (obj)).xy) && o._cls14B4.if._mth02CB(xn).equals(o._cls14B4.if._mth02CB(((ResolveAccountResponse) (obj)).xn));
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        _cls15A8._mth02CA(this, parcel, i);
    }

}
