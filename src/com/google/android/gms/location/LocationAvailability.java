// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import o.di;

public final class LocationAvailability
    implements SafeParcelable
{

    public static final di CREATOR = new di();
    public int CB;
    public int CC;
    public long CD;
    public int CE;
    public final int wB;

    public LocationAvailability(int i, int j, int k, int l, long l1)
    {
        wB = i;
        CE = j;
        CB = k;
        CC = l;
        CD = l1;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof LocationAvailability))
        {
            return false;
        }
        obj = (LocationAvailability)obj;
        return CE == ((LocationAvailability) (obj)).CE && CB == ((LocationAvailability) (obj)).CB && CC == ((LocationAvailability) (obj)).CC && CD == ((LocationAvailability) (obj)).CD;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(CE), Integer.valueOf(CB), Integer.valueOf(CC), Long.valueOf(CD)
        });
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("LocationAvailability[isLocationAvailable: ");
        boolean flag;
        if (CE < 1000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return stringbuilder.append(flag).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        di._mth02CA(this, parcel);
    }

}
