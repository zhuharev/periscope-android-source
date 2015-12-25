// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.location.LocationAvailability;

public final class di
    implements android.os.Parcelable.Creator
{

    public di()
    {
    }

    public static void _mth02CA(LocationAvailability locationavailability, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int i = parcel.dataPosition();
        int j = locationavailability.CB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(j);
        j = locationavailability.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(j);
        j = locationavailability.CC;
        _cls141D.if._mth02CB(parcel, 2, 4);
        parcel.writeInt(j);
        long l = locationavailability.CD;
        _cls141D.if._mth02CB(parcel, 3, 8);
        parcel.writeLong(l);
        j = locationavailability.CE;
        _cls141D.if._mth02CB(parcel, 4, 4);
        parcel.writeInt(j);
        _cls141D.if._mth141D(parcel, i);
    }

    public static LocationAvailability _mth02CE(Parcel parcel)
    {
        int i1 = _cls141D.if._mth02CA(parcel);
        int l = 0;
        int k = 1000;
        int j = 1;
        int i = 1;
        long l1 = 0L;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = parcel.readInt();
                switch (j1 & 0xffff)
                {
                case 1: // '\001'
                    _cls141D.if._mth02CA(parcel, j1, 4);
                    j = parcel.readInt();
                    break;

                case 1000: 
                    _cls141D.if._mth02CA(parcel, j1, 4);
                    l = parcel.readInt();
                    break;

                case 2: // '\002'
                    _cls141D.if._mth02CA(parcel, j1, 4);
                    i = parcel.readInt();
                    break;

                case 3: // '\003'
                    _cls141D.if._mth02CA(parcel, j1, 8);
                    l1 = parcel.readLong();
                    break;

                case 4: // '\004'
                    _cls141D.if._mth02CA(parcel, j1, 4);
                    k = parcel.readInt();
                    break;

                default:
                    _cls141D.if._mth02CA(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(i1).toString(), parcel);
            } else
            {
                return new LocationAvailability(l, k, j, i, l1);
            }
        } while (true);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth02CE(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new LocationAvailability[i];
    }
}
