// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import o.em;

public final class LocationResult
    implements SafeParcelable
{

    public static final List CM = Collections.emptyList();
    public static final android.os.Parcelable.Creator CREATOR = new em();
    public final List CN;
    public final int wB;

    public LocationResult(int i, List list)
    {
        wB = i;
        CN = list;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof LocationResult))
        {
            return false;
        }
        obj = (LocationResult)obj;
        if (((LocationResult) (obj)).CN.size() != CN.size())
        {
            return false;
        }
        obj = ((LocationResult) (obj)).CN.iterator();
        Iterator iterator = CN.iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            Location location = (Location)iterator.next();
            Location location1 = (Location)((Iterator) (obj)).next();
            if (location.getTime() != location1.getTime())
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int i = 17;
        for (Iterator iterator = CN.iterator(); iterator.hasNext();)
        {
            long l = ((Location)iterator.next()).getTime();
            i = i * 31 + (int)(l ^ l >>> 32);
        }

        return i;
    }

    public final String toString()
    {
        return (new StringBuilder("LocationResult[locations: ")).append(CN).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        em._mth02CA(this, parcel);
    }

}
