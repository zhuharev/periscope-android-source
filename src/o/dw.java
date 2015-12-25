// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.internal.FusedLocationProviderResult;

public final class dw
    implements android.os.Parcelable.Creator
{

    public dw()
    {
    }

    public static void _mth02CA(FusedLocationProviderResult fusedlocationproviderresult, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        _cls141D.if._mth02CA(parcel, 1, fusedlocationproviderresult.CW, i, false);
        i = fusedlocationproviderresult.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(i);
        _cls141D.if._mth141D(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        Status status = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (k & 0xffff)
                {
                case 1: // '\001'
                    status = (Status)_cls141D.if._mth02CA(parcel, k, Status.CREATOR);
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
                return new FusedLocationProviderResult(i, status);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new FusedLocationProviderResult[i];
    }
}
