// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.dx;
import o.ee;
import o.ek;
import o.el;

// Referenced classes of package com.google.android.gms.location.internal:
//            LocationRequestInternal

public class LocationRequestUpdateData
    implements SafeParcelable
{

    public static final ee CREATOR = new ee();
    public int Dm;
    public LocationRequestInternal Dn;
    public el Do;
    public ek Dp;
    public dx Dq;
    public PendingIntent mPendingIntent;
    public final int wB;

    public LocationRequestUpdateData(int i, int j, LocationRequestInternal locationrequestinternal, IBinder ibinder, PendingIntent pendingintent, IBinder ibinder1, IBinder ibinder2)
    {
        wB = i;
        Dm = j;
        Dn = locationrequestinternal;
        if (ibinder == null)
        {
            locationrequestinternal = null;
        } else
        {
            locationrequestinternal = o.el.if._mth02BE(ibinder);
        }
        Do = locationrequestinternal;
        mPendingIntent = pendingintent;
        if (ibinder1 == null)
        {
            locationrequestinternal = null;
        } else
        {
            locationrequestinternal = o.ek.if._mth1FBE(ibinder1);
        }
        Dp = locationrequestinternal;
        if (ibinder2 == null)
        {
            locationrequestinternal = null;
        } else
        {
            locationrequestinternal = o.dx.if._mth02BC(ibinder2);
        }
        Dq = locationrequestinternal;
    }

    public static LocationRequestUpdateData _mth02CA(LocationRequestInternal locationrequestinternal, o.eb._cls02CB _pcls02cb, dx dx1)
    {
        IBinder ibinder = _pcls02cb.asBinder();
        if (dx1 != null)
        {
            _pcls02cb = dx1.asBinder();
        } else
        {
            _pcls02cb = null;
        }
        return new LocationRequestUpdateData(1, 1, locationrequestinternal, ibinder, null, null, _pcls02cb);
    }

    public static LocationRequestUpdateData _mth02CA(o.eb.if if1, dx dx1)
    {
        return new LocationRequestUpdateData(1, 2, null, null, null, if1.asBinder(), null);
    }

    public static LocationRequestUpdateData _mth02CA(o.eb._cls02CB _pcls02cb, dx dx1)
    {
        IBinder ibinder = _pcls02cb.asBinder();
        if (dx1 != null)
        {
            _pcls02cb = dx1.asBinder();
        } else
        {
            _pcls02cb = null;
        }
        return new LocationRequestUpdateData(1, 2, null, ibinder, null, null, _pcls02cb);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ee._mth02CA(this, parcel, i);
    }

}
