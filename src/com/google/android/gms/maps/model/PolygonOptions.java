// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import o.hb;

public final class PolygonOptions
    implements SafeParcelable
{

    public static final hb CREATOR = new hb();
    public float EU;
    public int EV;
    public int EW;
    public float EX;
    public boolean EY;
    public final List Fu;
    public final List Fv;
    public boolean Fw;
    public final int wB;

    public PolygonOptions()
    {
        EU = 10F;
        EV = 0xff000000;
        EW = 0;
        EX = 0.0F;
        EY = true;
        Fw = false;
        wB = 1;
        Fu = new ArrayList();
        Fv = new ArrayList();
    }

    public PolygonOptions(int i, ArrayList arraylist, ArrayList arraylist1, float f, int j, int k, float f1, 
            boolean flag, boolean flag1)
    {
        EU = 10F;
        EV = 0xff000000;
        EW = 0;
        EX = 0.0F;
        EY = true;
        Fw = false;
        wB = i;
        Fu = arraylist;
        Fv = arraylist1;
        EU = f;
        EV = j;
        EW = k;
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
        hb._mth02CA(this, parcel);
    }

}
