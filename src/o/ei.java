// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.internal.ParcelableGeofence;

public final class ei
    implements android.os.Parcelable.Creator
{

    public ei()
    {
    }

    public static void _mth02CA(GeofencingRequest geofencingrequest, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int i = parcel.dataPosition();
        _cls141D.if._mth02CA(parcel, 1, geofencingrequest.Cy, false);
        int j = geofencingrequest.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(j);
        j = geofencingrequest.Cz;
        _cls141D.if._mth02CB(parcel, 2, 4);
        parcel.writeInt(j);
        _cls141D.if._mth141D(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int k = _cls141D.if._mth02CA(parcel);
        int j = 0;
        java.util.ArrayList arraylist = null;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = parcel.readInt();
                switch (l & 0xffff)
                {
                case 1: // '\001'
                    arraylist = _cls141D.if._mth02CE(parcel, l, ParcelableGeofence.CREATOR);
                    break;

                case 1000: 
                    _cls141D.if._mth02CA(parcel, l, 4);
                    j = parcel.readInt();
                    break;

                case 2: // '\002'
                    _cls141D.if._mth02CA(parcel, l, 4);
                    i = parcel.readInt();
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
                return new GeofencingRequest(j, arraylist, i);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new GeofencingRequest[i];
    }
}
