// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import o.ed;

public class LocationRequestInternal
    implements SafeParcelable
{

    public static final ed CREATOR = new ed();
    public static final List Df = Collections.emptyList();
    public LocationRequest Dg;
    public boolean Dh;
    public boolean Di;
    public boolean Dj;
    public List Dk;
    public boolean Dl;
    public String mTag;
    public final int wB;

    public LocationRequestInternal(int i, LocationRequest locationrequest, boolean flag, boolean flag1, boolean flag2, List list, String s, 
            boolean flag3)
    {
        wB = i;
        Dg = locationrequest;
        Dh = flag;
        Di = flag1;
        Dj = flag2;
        Dk = list;
        mTag = s;
        Dl = flag3;
    }

    public static LocationRequestInternal _mth02CA(LocationRequest locationrequest)
    {
        return new LocationRequestInternal(1, locationrequest, false, true, true, Df, null, false);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof LocationRequestInternal))
        {
            return false;
        }
        obj = (LocationRequestInternal)obj;
        LocationRequest locationrequest = Dg;
        LocationRequest locationrequest1 = ((LocationRequestInternal) (obj)).Dg;
        boolean flag;
        if (locationrequest == locationrequest1 || locationrequest != null && locationrequest.equals(locationrequest1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && Dh == ((LocationRequestInternal) (obj)).Dh && Di == ((LocationRequestInternal) (obj)).Di && Dj == ((LocationRequestInternal) (obj)).Dj && Dl == ((LocationRequestInternal) (obj)).Dl)
        {
            List list = Dk;
            obj = ((LocationRequestInternal) (obj)).Dk;
            boolean flag1;
            if (list == obj || list != null && list.equals(obj))
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

    public int hashCode()
    {
        return Dg.hashCode();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Dg.toString());
        if (mTag != null)
        {
            stringbuilder.append(" tag=").append(mTag);
        }
        stringbuilder.append(" nlpDebug=").append(Dh);
        stringbuilder.append(" trigger=").append(Dj);
        stringbuilder.append(" restorePIListeners=").append(Di);
        stringbuilder.append(" hideAppOps=").append(Dl);
        stringbuilder.append(" clients=").append(Dk);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ed._mth02CA(this, parcel, i);
    }

}
