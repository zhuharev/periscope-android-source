// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.ResolveAccountRequest;

public final class _cls15A7
    implements android.os.Parcelable.Creator
{

    public _cls15A7()
    {
    }

    public static void _mth02CA(ResolveAccountRequest resolveaccountrequest, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = resolveaccountrequest.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(k);
        _cls141D.if._mth02CA(parcel, 2, resolveaccountrequest.xw, i, false);
        i = resolveaccountrequest.xx;
        _cls141D.if._mth02CB(parcel, 3, 4);
        parcel.writeInt(i);
        _cls141D.if._mth141D(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int k = _cls141D.if._mth02CA(parcel);
        int j = 0;
        Account account = null;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = parcel.readInt();
                switch (l & 0xffff)
                {
                case 1: // '\001'
                    _cls141D.if._mth02CA(parcel, l, 4);
                    j = parcel.readInt();
                    break;

                case 2: // '\002'
                    account = (Account)_cls141D.if._mth02CA(parcel, l, Account.CREATOR);
                    break;

                case 3: // '\003'
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
                return new ResolveAccountRequest(j, account, i);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ResolveAccountRequest[i];
    }
}
