// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import o.152C;
import o.gx;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLng

public final class LatLngBounds
    implements SafeParcelable
{

    public static final gx CREATOR = new gx();
    public final LatLng Fh;
    public final LatLng Fi;
    public final int wB;

    public LatLngBounds(int i, LatLng latlng, LatLng latlng1)
    {
        if (latlng == null)
        {
            throw new NullPointerException(String.valueOf("null southwest"));
        }
        if (latlng1 == null)
        {
            throw new NullPointerException(String.valueOf("null northeast"));
        }
        boolean flag;
        if (latlng1.latitude >= latlng.latitude)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        double d = latlng.latitude;
        double d1 = latlng1.latitude;
        if (!flag)
        {
            throw new IllegalArgumentException(String.format("southern latitude exceeds northern latitude (%s > %s)", new Object[] {
                Double.valueOf(d), Double.valueOf(d1)
            }));
        } else
        {
            wB = i;
            Fh = latlng;
            Fi = latlng1;
            return;
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof LatLngBounds))
        {
            return false;
        }
        obj = (LatLngBounds)obj;
        return Fh.equals(((LatLngBounds) (obj)).Fh) && Fi.equals(((LatLngBounds) (obj)).Fi);
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Fh, Fi
        });
    }

    public final String toString()
    {
        return (new _cls152C(this, (byte)0))._mth02CA("southwest", Fh)._mth02CA("northeast", Fi).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        gx._mth02CA(this, parcel, i);
    }

    public final boolean _mth02BD(LatLng latlng)
    {
        double d = latlng.latitude;
        boolean flag;
        if (Fh.latitude <= d && d <= Fi.latitude)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            double d1 = latlng.longitude;
            boolean flag1;
            if (Fh.longitude <= Fi.longitude)
            {
                if (Fh.longitude <= d1 && d1 <= Fi.longitude)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            } else
            if (Fh.longitude <= d1 || d1 <= Fi.longitude)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                return true;
            }
        }
        return false;
    }

}
