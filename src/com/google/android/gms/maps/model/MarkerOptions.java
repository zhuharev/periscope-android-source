// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.gi;
import o.gz;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLng

public final class MarkerOptions
    implements SafeParcelable
{

    public static final gz CREATOR = new gz();
    public LatLng EC;
    public boolean EY;
    public float Ff;
    public float Fg;
    public String Fk;
    public String Fl;
    public gi Fm;
    public boolean Fn;
    public boolean Fo;
    public float Fp;
    public float Fq;
    public float Fr;
    public float mAlpha;
    public final int wB;

    public MarkerOptions()
    {
        Ff = 0.5F;
        Fg = 1.0F;
        EY = true;
        Fo = false;
        Fp = 0.0F;
        Fq = 0.5F;
        Fr = 0.0F;
        mAlpha = 1.0F;
        wB = 1;
    }

    public MarkerOptions(int i, LatLng latlng, String s, String s1, IBinder ibinder, float f, float f1, 
            boolean flag, boolean flag1, boolean flag2, float f2, float f3, float f4, float f5)
    {
        Ff = 0.5F;
        Fg = 1.0F;
        EY = true;
        Fo = false;
        Fp = 0.0F;
        Fq = 0.5F;
        Fr = 0.0F;
        mAlpha = 1.0F;
        wB = i;
        EC = latlng;
        Fk = s;
        Fl = s1;
        if (ibinder == null)
        {
            latlng = null;
        } else
        {
            latlng = new gi(o.bg.if._mth141D(ibinder));
        }
        Fm = latlng;
        Ff = f;
        Fg = f1;
        Fn = flag;
        EY = flag1;
        Fo = flag2;
        Fp = f2;
        Fq = f3;
        Fr = f4;
        mAlpha = f5;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        gz._mth02CA(this, parcel, i);
    }

    public final MarkerOptions _mth02CB(gi gi1)
    {
        Fm = gi1;
        return this;
    }

    public final MarkerOptions _mth037A(LatLng latlng)
    {
        EC = latlng;
        return this;
    }

}
