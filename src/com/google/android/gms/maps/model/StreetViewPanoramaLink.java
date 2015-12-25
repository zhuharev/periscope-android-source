// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import o.152C;
import o.he;

public class StreetViewPanoramaLink
    implements SafeParcelable
{

    public static final he CREATOR = new he();
    public final float EN;
    public final String Fy;
    public final int wB;

    public StreetViewPanoramaLink(int i, String s, float f)
    {
        wB = i;
        Fy = s;
        if ((double)f <= 0.0D)
        {
            f = f % 360F + 360F;
        }
        EN = f % 360F;
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
        if (!(obj instanceof StreetViewPanoramaLink))
        {
            return false;
        }
        obj = (StreetViewPanoramaLink)obj;
        return Fy.equals(((StreetViewPanoramaLink) (obj)).Fy) && Float.floatToIntBits(EN) == Float.floatToIntBits(((StreetViewPanoramaLink) (obj)).EN);
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Fy, Float.valueOf(EN)
        });
    }

    public String toString()
    {
        return (new _cls152C(this, (byte)0))._mth02CA("panoId", Fy)._mth02CA("bearing", Float.valueOf(EN)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        he._mth02CA(this, parcel);
    }

}
