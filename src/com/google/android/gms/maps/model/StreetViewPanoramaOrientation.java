// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import o.152C;
import o.hg;

public class StreetViewPanoramaOrientation
    implements SafeParcelable
{
    public static final class if
    {

        public float EM;
        public float EN;

        public if()
        {
        }
    }


    public static final hg CREATOR = new hg();
    public final float EM;
    public final float EN;
    public final int wB;

    public StreetViewPanoramaOrientation(float f, float f1)
    {
        this(1, f, f1);
    }

    public StreetViewPanoramaOrientation(int i, float f, float f1)
    {
        boolean flag;
        if (-90F <= f && f <= 90F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalArgumentException(String.valueOf("Tilt needs to be between -90 and 90 inclusive"));
        }
        wB = i;
        EM = 0.0F + f;
        if ((double)f1 <= 0.0D)
        {
            f1 = f1 % 360F + 360F;
        }
        EN = f1 % 360F;
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
        if (!(obj instanceof StreetViewPanoramaOrientation))
        {
            return false;
        }
        obj = (StreetViewPanoramaOrientation)obj;
        return Float.floatToIntBits(EM) == Float.floatToIntBits(((StreetViewPanoramaOrientation) (obj)).EM) && Float.floatToIntBits(EN) == Float.floatToIntBits(((StreetViewPanoramaOrientation) (obj)).EN);
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Float.valueOf(EM), Float.valueOf(EN)
        });
    }

    public String toString()
    {
        return (new _cls152C(this, (byte)0))._mth02CA("tilt", Float.valueOf(EM))._mth02CA("bearing", Float.valueOf(EN)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hg._mth02CA(this, parcel);
    }

}
