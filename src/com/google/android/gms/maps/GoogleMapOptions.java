// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import o.0693;
import o.hk;

public final class GoogleMapOptions
    implements SafeParcelable
{

    public static final hk CREATOR = new hk();
    public Boolean Eb;
    public Boolean Ec;
    public int Ed;
    public CameraPosition Ee;
    public Boolean Ef;
    public Boolean Eg;
    public Boolean Eh;
    public Boolean Ei;
    public Boolean Ej;
    public Boolean Ek;
    public Boolean El;
    public Boolean Em;
    public Boolean En;
    public final int wB;

    public GoogleMapOptions()
    {
        Ed = -1;
        wB = 1;
    }

    public GoogleMapOptions(int i, byte byte0, byte byte1, int j, CameraPosition cameraposition, byte byte2, byte byte3, 
            byte byte4, byte byte5, byte byte6, byte byte7, byte byte8, byte byte9, byte byte10)
    {
        Ed = -1;
        wB = i;
        Eb = o._cls141D.if._mth02CA(byte0);
        Ec = o._cls141D.if._mth02CA(byte1);
        Ed = j;
        Ee = cameraposition;
        Ef = o._cls141D.if._mth02CA(byte2);
        Eg = o._cls141D.if._mth02CA(byte3);
        Eh = o._cls141D.if._mth02CA(byte4);
        Ei = o._cls141D.if._mth02CA(byte5);
        Ej = o._cls141D.if._mth02CA(byte6);
        Ek = o._cls141D.if._mth02CA(byte7);
        El = o._cls141D.if._mth02CA(byte8);
        Em = o._cls141D.if._mth02CA(byte9);
        En = o._cls141D.if._mth02CA(byte10);
    }

    public static GoogleMapOptions _mth02CB(Context context, AttributeSet attributeset)
    {
        if (attributeset == null)
        {
            return null;
        }
        TypedArray typedarray = context.getResources().obtainAttributes(attributeset, _cls0693.MapAttrs);
        GoogleMapOptions googlemapoptions = new GoogleMapOptions();
        if (typedarray.hasValue(_cls0693.MapAttrs_mapType))
        {
            googlemapoptions.Ed = typedarray.getInt(_cls0693.MapAttrs_mapType, -1);
        }
        if (typedarray.hasValue(_cls0693.MapAttrs_zOrderOnTop))
        {
            googlemapoptions.Eb = Boolean.valueOf(typedarray.getBoolean(_cls0693.MapAttrs_zOrderOnTop, false));
        }
        if (typedarray.hasValue(_cls0693.MapAttrs_useViewLifecycle))
        {
            googlemapoptions.Ec = Boolean.valueOf(typedarray.getBoolean(_cls0693.MapAttrs_useViewLifecycle, false));
        }
        if (typedarray.hasValue(_cls0693.MapAttrs_uiCompass))
        {
            googlemapoptions.Eg = Boolean.valueOf(typedarray.getBoolean(_cls0693.MapAttrs_uiCompass, true));
        }
        if (typedarray.hasValue(_cls0693.MapAttrs_uiRotateGestures))
        {
            googlemapoptions.Ek = Boolean.valueOf(typedarray.getBoolean(_cls0693.MapAttrs_uiRotateGestures, true));
        }
        if (typedarray.hasValue(_cls0693.MapAttrs_uiScrollGestures))
        {
            googlemapoptions.Eh = Boolean.valueOf(typedarray.getBoolean(_cls0693.MapAttrs_uiScrollGestures, true));
        }
        if (typedarray.hasValue(_cls0693.MapAttrs_uiTiltGestures))
        {
            googlemapoptions.Ej = Boolean.valueOf(typedarray.getBoolean(_cls0693.MapAttrs_uiTiltGestures, true));
        }
        if (typedarray.hasValue(_cls0693.MapAttrs_uiZoomGestures))
        {
            googlemapoptions.Ei = Boolean.valueOf(typedarray.getBoolean(_cls0693.MapAttrs_uiZoomGestures, true));
        }
        if (typedarray.hasValue(_cls0693.MapAttrs_uiZoomControls))
        {
            googlemapoptions.Ef = Boolean.valueOf(typedarray.getBoolean(_cls0693.MapAttrs_uiZoomControls, true));
        }
        if (typedarray.hasValue(_cls0693.MapAttrs_liteMode))
        {
            googlemapoptions.El = Boolean.valueOf(typedarray.getBoolean(_cls0693.MapAttrs_liteMode, false));
        }
        if (typedarray.hasValue(_cls0693.MapAttrs_uiMapToolbar))
        {
            googlemapoptions.Em = Boolean.valueOf(typedarray.getBoolean(_cls0693.MapAttrs_uiMapToolbar, true));
        }
        if (typedarray.hasValue(_cls0693.MapAttrs_ambientEnabled))
        {
            googlemapoptions.En = Boolean.valueOf(typedarray.getBoolean(_cls0693.MapAttrs_ambientEnabled, false));
        }
        googlemapoptions.Ee = CameraPosition._mth02CE(context, attributeset);
        typedarray.recycle();
        return googlemapoptions;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        hk._mth02CA(this, parcel, i);
    }

}
