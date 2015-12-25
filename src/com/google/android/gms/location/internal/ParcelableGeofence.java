// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;
import o.ef;

public class ParcelableGeofence
    implements SafeParcelable
{

    public static final ef CREATOR = new ef();
    public final String Dr;
    public final long Ds;
    public final short Dt;
    public final double Du;
    public final double Dv;
    public final float Dw;
    public final int Dx;
    public final int Dy;
    public final int Dz;
    public final int wB;

    public ParcelableGeofence(int i, String s, int j, short word0, double d, double d1, float f, long l, int k, int i1)
    {
        if (s == null || s.length() > 100)
        {
            throw new IllegalArgumentException((new StringBuilder("requestId is null or too long: ")).append(s).toString());
        }
        if (f <= 0.0F)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid radius: ")).append(f).toString());
        }
        if (d > 90D || d < -90D)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid latitude: ")).append(d).toString());
        }
        if (d1 > 180D || d1 < -180D)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid longitude: ")).append(d1).toString());
        }
        int j1 = j & 7;
        if (j1 == 0)
        {
            throw new IllegalArgumentException((new StringBuilder("No supported transition specified: ")).append(j).toString());
        } else
        {
            wB = i;
            Dt = word0;
            Dr = s;
            Du = d;
            Dv = d1;
            Dw = f;
            Ds = l;
            Dx = j1;
            Dy = k;
            Dz = i1;
            return;
        }
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
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof ParcelableGeofence))
        {
            return false;
        }
        obj = (ParcelableGeofence)obj;
        if (Dw != ((ParcelableGeofence) (obj)).Dw)
        {
            return false;
        }
        if (Du != ((ParcelableGeofence) (obj)).Du)
        {
            return false;
        }
        if (Dv != ((ParcelableGeofence) (obj)).Dv)
        {
            return false;
        }
        return Dt == ((ParcelableGeofence) (obj)).Dt;
    }

    public int hashCode()
    {
        long l = Double.doubleToLongBits(Du);
        int i = (int)(l >>> 32 ^ l);
        l = Double.doubleToLongBits(Dv);
        return ((((i + 31) * 31 + (int)(l >>> 32 ^ l)) * 31 + Float.floatToIntBits(Dw)) * 31 + Dt) * 31 + Dx;
    }

    public String toString()
    {
        Locale locale = Locale.US;
        String s;
        switch (Dt)
        {
        case 1: // '\001'
            s = "CIRCLE";
            break;

        default:
            s = null;
            break;
        }
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] {
            s, Dr, Integer.valueOf(Dx), Double.valueOf(Du), Double.valueOf(Dv), Float.valueOf(Dw), Integer.valueOf(Dy / 1000), Integer.valueOf(Dz), Long.valueOf(Ds)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ef._mth02CA(this, parcel);
    }

}
