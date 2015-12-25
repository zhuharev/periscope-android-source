// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.location.LocationResult;

public final class em
    implements android.os.Parcelable.Creator
{

    public em()
    {
    }

    public static void _mth02CA(LocationResult locationresult, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int i = parcel.dataPosition();
        _cls141D.if._mth02CA(parcel, 1, locationresult.CN, false);
        int j = locationresult.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(j);
        _cls141D.if._mth141D(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        Object obj = LocationResult.CM;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (k & 0xffff)
                {
                case 1: // '\001'
                    obj = _cls141D.if._mth02CE(parcel, k, Location.CREATOR);
                    break;

                case 1000: 
                    _cls141D.if._mth02CA(parcel, k, 4);
                    i = parcel.readInt();
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
                return new LocationResult(i, ((java.util.List) (obj)));
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new LocationResult[i];
    }
}
