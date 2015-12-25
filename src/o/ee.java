// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.LocationRequestUpdateData;

// Referenced classes of package o:
//            el, ek, dx

public final class ee
    implements android.os.Parcelable.Creator
{

    public ee()
    {
    }

    public static LocationRequestUpdateData _mth02BB(Parcel parcel)
    {
        int k = _cls141D.if._mth02CA(parcel);
        int j = 0;
        int i = 1;
        LocationRequestInternal locationrequestinternal = null;
        android.os.IBinder ibinder2 = null;
        PendingIntent pendingintent = null;
        android.os.IBinder ibinder1 = null;
        android.os.IBinder ibinder = null;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = parcel.readInt();
                switch (l & 0xffff)
                {
                case 1: // '\001'
                    _cls141D.if._mth02CA(parcel, l, 4);
                    i = parcel.readInt();
                    break;

                case 1000: 
                    _cls141D.if._mth02CA(parcel, l, 4);
                    j = parcel.readInt();
                    break;

                case 2: // '\002'
                    locationrequestinternal = (LocationRequestInternal)_cls141D.if._mth02CA(parcel, l, LocationRequestInternal.CREATOR);
                    break;

                case 3: // '\003'
                    ibinder2 = _cls141D.if._mth02CE(parcel, l);
                    break;

                case 4: // '\004'
                    pendingintent = (PendingIntent)_cls141D.if._mth02CA(parcel, l, PendingIntent.CREATOR);
                    break;

                case 5: // '\005'
                    ibinder1 = _cls141D.if._mth02CE(parcel, l);
                    break;

                case 6: // '\006'
                    ibinder = _cls141D.if._mth02CE(parcel, l);
                    break;

                default:
                    _cls141D.if._mth02CA(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new LocationRequestUpdateData(j, i, locationrequestinternal, ibinder2, pendingintent, ibinder1, ibinder);
            }
        } while (true);
    }

    public static void _mth02CA(LocationRequestUpdateData locationrequestupdatedata, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = locationrequestupdatedata.Dm;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(k);
        k = locationrequestupdatedata.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(k);
        _cls141D.if._mth02CA(parcel, 2, locationrequestupdatedata.Dn, i, false);
        android.os.IBinder ibinder;
        if (locationrequestupdatedata.Do == null)
        {
            ibinder = null;
        } else
        {
            ibinder = locationrequestupdatedata.Do.asBinder();
        }
        _cls141D.if._mth02CA(parcel, 3, ibinder, false);
        _cls141D.if._mth02CA(parcel, 4, locationrequestupdatedata.mPendingIntent, i, false);
        if (locationrequestupdatedata.Dp == null)
        {
            ibinder = null;
        } else
        {
            ibinder = locationrequestupdatedata.Dp.asBinder();
        }
        _cls141D.if._mth02CA(parcel, 5, ibinder, false);
        if (locationrequestupdatedata.Dq == null)
        {
            locationrequestupdatedata = null;
        } else
        {
            locationrequestupdatedata = locationrequestupdatedata.Dq.asBinder();
        }
        _cls141D.if._mth02CA(parcel, 6, locationrequestupdatedata, false);
        _cls141D.if._mth141D(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth02BB(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new LocationRequestUpdateData[i];
    }
}
