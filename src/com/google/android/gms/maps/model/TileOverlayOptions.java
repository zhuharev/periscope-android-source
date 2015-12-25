// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.gk;
import o.gt;
import o.hi;

public final class TileOverlayOptions
    implements SafeParcelable
{

    public static final hi CREATOR = new hi();
    public float EX;
    public boolean EY;
    public gt FB;
    private gk FC;
    public boolean FD;
    public final int wB;

    public TileOverlayOptions()
    {
        EY = true;
        FD = true;
        wB = 1;
    }

    public TileOverlayOptions(int i, IBinder ibinder, boolean flag, float f, boolean flag1)
    {
        EY = true;
        FD = true;
        wB = i;
        FB = o.gt.if.FE7A(ibinder);
        if (FB == null)
        {
            ibinder = null;
        } else
        {
            ibinder = new gk(this);
        }
        FC = ibinder;
        EY = flag;
        EX = f;
        FD = flag1;
    }

    public static gt _mth02CB(TileOverlayOptions tileoverlayoptions)
    {
        return tileoverlayoptions.FB;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        hi._mth02CA(this, parcel);
    }

}
