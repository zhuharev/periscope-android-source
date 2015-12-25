// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import o.152C;
import o.hf;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLng, StreetViewPanoramaLink

public class StreetViewPanoramaLocation
    implements SafeParcelable
{

    public static final hf CREATOR = new hf();
    public final LatLng FA;
    public final String Fy;
    public final StreetViewPanoramaLink Fz[];
    public final int wB;

    public StreetViewPanoramaLocation(int i, StreetViewPanoramaLink astreetviewpanoramalink[], LatLng latlng, String s)
    {
        wB = i;
        Fz = astreetviewpanoramalink;
        FA = latlng;
        Fy = s;
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
        if (!(obj instanceof StreetViewPanoramaLocation))
        {
            return false;
        }
        obj = (StreetViewPanoramaLocation)obj;
        return Fy.equals(((StreetViewPanoramaLocation) (obj)).Fy) && FA.equals(((StreetViewPanoramaLocation) (obj)).FA);
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            FA, Fy
        });
    }

    public String toString()
    {
        return (new _cls152C(this, (byte)0))._mth02CA("panoId", Fy)._mth02CA("position", FA.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hf._mth02CA(this, parcel, i);
    }

}
