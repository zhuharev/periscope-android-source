// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import o.hc;

public final class PolylineOptions
    implements SafeParcelable
{

    public static final hc CREATOR = new hc();
    public float EX;
    public boolean EY;
    public float Fb;
    public final List Fu;
    public boolean Fw;
    public final int wB;
    public int _fld0196;

    public PolylineOptions()
    {
        Fb = 10F;
        _fld0196 = 0xff000000;
        EX = 0.0F;
        EY = true;
        Fw = false;
        wB = 1;
        Fu = new ArrayList();
    }

    public PolylineOptions(int i, ArrayList arraylist, float f, int j, float f1, boolean flag, boolean flag1)
    {
        Fb = 10F;
        _fld0196 = 0xff000000;
        EX = 0.0F;
        EY = true;
        Fw = false;
        wB = i;
        Fu = arraylist;
        Fb = f;
        _fld0196 = j;
        EX = f1;
        EY = flag;
        Fw = flag1;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        hc._mth02CA(this, parcel);
    }

}
