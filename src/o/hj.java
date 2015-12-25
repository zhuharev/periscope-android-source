// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;

public final class hj
    implements android.os.Parcelable.Creator
{

    public hj()
    {
    }

    public static void _mth02CA(VisibleRegion visibleregion, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = visibleregion.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(k);
        _cls141D.if._mth02CA(parcel, 2, visibleregion.FG, i, false);
        _cls141D.if._mth02CA(parcel, 3, visibleregion.FH, i, false);
        _cls141D.if._mth02CA(parcel, 4, visibleregion.FI, i, false);
        _cls141D.if._mth02CA(parcel, 5, visibleregion.FJ, i, false);
        _cls141D.if._mth02CA(parcel, 6, visibleregion.FK, i, false);
        _cls141D.if._mth141D(parcel, j);
    }

    public static VisibleRegion FF9E(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        LatLng latlng3 = null;
        LatLng latlng2 = null;
        LatLng latlng1 = null;
        LatLng latlng = null;
        LatLngBounds latlngbounds = null;
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
                    latlng3 = (LatLng)_cls141D.if._mth02CA(parcel, k, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    latlng2 = (LatLng)_cls141D.if._mth02CA(parcel, k, LatLng.CREATOR);
                    break;

                case 4: // '\004'
                    latlng1 = (LatLng)_cls141D.if._mth02CA(parcel, k, LatLng.CREATOR);
                    break;

                case 5: // '\005'
                    latlng = (LatLng)_cls141D.if._mth02CA(parcel, k, LatLng.CREATOR);
                    break;

                case 6: // '\006'
                    latlngbounds = (LatLngBounds)_cls141D.if._mth02CA(parcel, k, LatLngBounds.CREATOR);
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
                return new VisibleRegion(i, latlng3, latlng2, latlng1, latlng, latlngbounds);
            }
        } while (true);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return FF9E(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new VisibleRegion[i];
    }
}
