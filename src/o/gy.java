// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;

public final class gy
    implements android.os.Parcelable.Creator
{

    public gy()
    {
    }

    public static LatLng _mth02BF(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        double d1 = 0.0D;
        double d = 0.0D;
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
                    _cls141D.if._mth02CA(parcel, k, 8);
                    d1 = parcel.readDouble();
                    break;

                case 3: // '\003'
                    _cls141D.if._mth02CA(parcel, k, 8);
                    d = parcel.readDouble();
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
                return new LatLng(i, d1, d);
            }
        } while (true);
    }

    public static void _mth02CA(LatLng latlng, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int i = parcel.dataPosition();
        int j = latlng.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(j);
        double d = latlng.latitude;
        _cls141D.if._mth02CB(parcel, 2, 8);
        parcel.writeDouble(d);
        d = latlng.longitude;
        _cls141D.if._mth02CB(parcel, 3, 8);
        parcel.writeDouble(d);
        _cls141D.if._mth141D(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth02BF(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new LatLng[i];
    }
}
