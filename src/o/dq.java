// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.location.internal.ClientIdentity;

public final class dq
    implements android.os.Parcelable.Creator
{

    public dq()
    {
    }

    public static void _mth02CA(ClientIdentity clientidentity, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int i = parcel.dataPosition();
        int j = clientidentity.uid;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(j);
        j = clientidentity.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(j);
        _cls141D.if._mth02CA(parcel, 2, clientidentity.packageName, false);
        _cls141D.if._mth141D(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int k = _cls141D.if._mth02CA(parcel);
        int j = 0;
        int i = 0;
        String s = null;
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
                return new ClientIdentity(j, i, s);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ClientIdentity[i];
    }
}
