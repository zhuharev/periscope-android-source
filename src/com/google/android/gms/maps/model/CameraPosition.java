// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import o.0693;
import o.152C;
import o.gu;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLng

public final class CameraPosition
    implements SafeParcelable
{
    public static final class if
    {

        LatLng EO;
        float EP;
        float EQ;
        float ER;

        public if()
        {
        }
    }


    public static final gu CREATOR = new gu();
    public final LatLng EK;
    public final float EL;
    public final float EM;
    public final float EN;
    public final int wB;

    public CameraPosition(int i, LatLng latlng, float f, float f1, float f2)
    {
        if (latlng == null)
        {
            throw new NullPointerException(String.valueOf("null camera target"));
        }
        boolean flag;
        if (0.0F <= f1 && f1 <= 90F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalArgumentException(String.format("Tilt needs to be between 0 and 90 inclusive: %s", new Object[] {
                Float.valueOf(f1)
            }));
        }
        wB = i;
        EK = latlng;
        EL = f;
        EM = 0.0F + f1;
        if ((double)f2 <= 0.0D)
        {
            f2 = f2 % 360F + 360F;
        }
        EN = f2 % 360F;
    }

    public CameraPosition(LatLng latlng, float f, float f1, float f2)
    {
        this(1, latlng, f, f1, f2);
    }

    public static CameraPosition _mth02CE(Context context, AttributeSet attributeset)
    {
        if (attributeset == null)
        {
            return null;
        }
        context = context.getResources().obtainAttributes(attributeset, _cls0693.MapAttrs);
        float f = 0.0F;
        float f1 = 0.0F;
        if (context.hasValue(_cls0693.MapAttrs_cameraTargetLat))
        {
            f = context.getFloat(_cls0693.MapAttrs_cameraTargetLat, 0.0F);
        }
        if (context.hasValue(_cls0693.MapAttrs_cameraTargetLng))
        {
            f1 = context.getFloat(_cls0693.MapAttrs_cameraTargetLng, 0.0F);
        }
        attributeset = new LatLng(f, f1);
        if if1 = new if();
        if1.EO = attributeset;
        if (context.hasValue(_cls0693.MapAttrs_cameraZoom))
        {
            if1.EP = context.getFloat(_cls0693.MapAttrs_cameraZoom, 0.0F);
        }
        if (context.hasValue(_cls0693.MapAttrs_cameraBearing))
        {
            if1.ER = context.getFloat(_cls0693.MapAttrs_cameraBearing, 0.0F);
        }
        if (context.hasValue(_cls0693.MapAttrs_cameraTilt))
        {
            if1.EQ = context.getFloat(_cls0693.MapAttrs_cameraTilt, 0.0F);
        }
        return new CameraPosition(if1.EO, if1.EP, if1.EQ, if1.ER);
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
        if (!(obj instanceof CameraPosition))
        {
            return false;
        }
        obj = (CameraPosition)obj;
        return EK.equals(((CameraPosition) (obj)).EK) && Float.floatToIntBits(EL) == Float.floatToIntBits(((CameraPosition) (obj)).EL) && Float.floatToIntBits(EM) == Float.floatToIntBits(((CameraPosition) (obj)).EM) && Float.floatToIntBits(EN) == Float.floatToIntBits(((CameraPosition) (obj)).EN);
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            EK, Float.valueOf(EL), Float.valueOf(EM), Float.valueOf(EN)
        });
    }

    public final String toString()
    {
        return (new _cls152C(this, (byte)0))._mth02CA("target", EK)._mth02CA("zoom", Float.valueOf(EL))._mth02CA("tilt", Float.valueOf(EM))._mth02CA("bearing", Float.valueOf(EN)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        gu._mth02CA(this, parcel, i);
    }

}
