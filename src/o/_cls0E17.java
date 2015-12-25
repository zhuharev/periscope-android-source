// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public final class _cls0E17
    implements android.os.Parcelable.Creator
{

    public _cls0E17()
    {
    }

    public static void _mth02CA(Status status, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = status.wC;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(k);
        k = status.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(k);
        _cls141D.if._mth02CA(parcel, 2, status.wD, false);
        _cls141D.if._mth02CA(parcel, 3, status.mPendingIntent, i, false);
        _cls141D.if._mth141D(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int k = _cls141D.if._mth02CA(parcel);
        int j = 0;
        int i = 0;
        String s = null;
        PendingIntent pendingintent = null;
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
                    s = _cls141D.if._mth02CB(parcel, l);
                    break;

                case 3: // '\003'
                    pendingintent = (PendingIntent)_cls141D.if._mth02CA(parcel, l, PendingIntent.CREATOR);
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
                return new Status(j, i, s, pendingintent);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new Status[i];
    }
}
