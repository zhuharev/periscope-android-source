// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public final class gx
    implements android.os.Parcelable.Creator
{

    public gx()
    {
    }

    public static LatLngBounds _mth02BE(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        LatLng latlng1 = null;
        LatLng latlng = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (k & 0xffff)
                {
                case 1: // '\001'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    i = parcel.readInt();
                    break;

                case 2: // '\002'
                    latlng1 = (LatLng)_cls141D.if._mth02CA(parcel, k, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    latlng = (LatLng)_cls141D.if._mth02CA(parcel, k, LatLng.CREATOR);
                    break;

                default:
                    _cls141D.if._mth02CA(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new LatLngBounds(i, latlng1, latlng);
            }
        } while (true);
    }

    public static void _mth02CA(LatLngBounds latlngbounds, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = latlngbounds.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(k);
        _cls141D.if._mth02CA(parcel, 2, latlngbounds.Fh, i, false);
        _cls141D.if._mth02CA(parcel, 3, latlngbounds.Fi, i, false);
        _cls141D.if._mth141D(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth02BE(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new LatLngBounds[i];
    }
}
