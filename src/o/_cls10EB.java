// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;

public final class _cls10EB
    implements android.os.Parcelable.Creator
{

    public _cls10EB()
    {
    }

    public static void _mth02CA(GetServiceRequest getservicerequest, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = getservicerequest.version;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(k);
        k = getservicerequest.xp;
        _cls141D.if._mth02CB(parcel, 2, 4);
        parcel.writeInt(k);
        k = getservicerequest.xq;
        _cls141D.if._mth02CB(parcel, 3, 4);
        parcel.writeInt(k);
        _cls141D.if._mth02CA(parcel, 4, getservicerequest.xr, false);
        _cls141D.if._mth02CA(parcel, 5, getservicerequest.xs, false);
        _cls141D.if._mth02CA(parcel, 6, getservicerequest.xt, i, false);
        _cls141D.if._mth02CA(parcel, 7, getservicerequest.xu, false);
        _cls141D.if._mth02CA(parcel, 8, getservicerequest.xv, i, false);
        _cls141D.if._mth141D(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int l = _cls141D.if._mth02CA(parcel);
        int k = 0;
        int j = 0;
        int i = 0;
        String s = null;
        android.os.IBinder ibinder = null;
        Scope ascope[] = null;
        android.os.Bundle bundle = null;
        Account account = null;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = parcel.readInt();
                switch (i1 & 0xffff)
                {
                case 1: // '\001'
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    k = parcel.readInt();
                    break;

                case 2: // '\002'
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    j = parcel.readInt();
                    break;

                case 3: // '\003'
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    i = parcel.readInt();
                    break;

                case 4: // '\004'
                    s = _cls141D.if._mth02CB(parcel, i1);
                    break;

                case 5: // '\005'
                    ibinder = _cls141D.if._mth02CE(parcel, i1);
                    break;

                case 6: // '\006'
                    ascope = (Scope[])_cls141D.if._mth02CB(parcel, i1, Scope.CREATOR);
                    break;

                case 7: // '\007'
                    bundle = _cls141D.if._mth02CF(parcel, i1);
                    break;

                case 8: // '\b'
                    account = (Account)_cls141D.if._mth02CA(parcel, i1, Account.CREATOR);
                    break;

                default:
                    _cls141D.if._mth02CA(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new GetServiceRequest(k, j, i, s, ibinder, ascope, bundle, account);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new GetServiceRequest[i];
    }
}
