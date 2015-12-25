// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import o.152C;
import o.hd;

// Referenced classes of package com.google.android.gms.maps.model:
//            StreetViewPanoramaOrientation

public class StreetViewPanoramaCamera
    implements SafeParcelable
{

    public static final hd CREATOR = new hd();
    public final float EL;
    public final float EM;
    public final float EN;
    private StreetViewPanoramaOrientation Fx;
    public final int wB;

    public StreetViewPanoramaCamera(int i, float f, float f1, float f2)
    {
        boolean flag;
        if (-90F <= f1 && f1 <= 90F)
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
        if ((double)f <= 0.0D)
        {
            f = 0.0F;
        }
        EL = f;
        EM = 0.0F + f1;
        if ((double)f2 <= 0.0D)
        {
            f = f2 % 360F + 360F;
        } else
        {
            f = f2;
        }
        EN = f % 360F;
        StreetViewPanoramaOrientation.if if1 = new StreetViewPanoramaOrientation.if();
        if1.EM = f1;
        if1.EN = f2;
        Fx = new StreetViewPanoramaOrientation(if1.EM, if1.EN);
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
        if (!(obj instanceof StreetViewPanoramaCamera))
        {
            return false;
        }
        obj = (StreetViewPanoramaCamera)obj;
        return Float.floatToIntBits(EL) == Float.floatToIntBits(((StreetViewPanoramaCamera) (obj)).EL) && Float.floatToIntBits(EM) == Float.floatToIntBits(((StreetViewPanoramaCamera) (obj)).EM) && Float.floatToIntBits(EN) == Float.floatToIntBits(((StreetViewPanoramaCamera) (obj)).EN);
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Float.valueOf(EL), Float.valueOf(EM), Float.valueOf(EN)
        });
    }

    public String toString()
    {
        return (new _cls152C(this, (byte)0))._mth02CA("zoom", Float.valueOf(EL))._mth02CA("tilt", Float.valueOf(EM))._mth02CA("bearing", Float.valueOf(EN)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hd._mth02CA(this, parcel);
    }

}
