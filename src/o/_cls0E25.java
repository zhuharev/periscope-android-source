// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ValidateAccountRequest;

public final class _cls0E25
    implements android.os.Parcelable.Creator
{

    public _cls0E25()
    {
    }

    public static void _mth02CA(ValidateAccountRequest validateaccountrequest, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = validateaccountrequest.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(k);
        k = validateaccountrequest.xB;
        _cls141D.if._mth02CB(parcel, 2, 4);
        parcel.writeInt(k);
        _cls141D.if._mth02CA(parcel, 3, validateaccountrequest.xn, false);
        _cls141D.if._mth02CA(parcel, 4, validateaccountrequest.xo, i, false);
        _cls141D.if._mth02CA(parcel, 5, validateaccountrequest.xC, false);
        _cls141D.if._mth02CA(parcel, 6, validateaccountrequest.xD, false);
        _cls141D.if._mth141D(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int k = _cls141D.if._mth02CA(parcel);
        int j = 0;
        int i = 0;
        android.os.IBinder ibinder = null;
        Scope ascope[] = null;
        android.os.Bundle bundle = null;
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
                    j = parcel.readInt();
                    break;

                case 2: // '\002'
                    _cls141D.if._mth02CA(parcel, l, 4);
                    i = parcel.readInt();
                    break;

                case 3: // '\003'
                    ibinder = _cls141D.if._mth02CE(parcel, l);
                    break;

                case 4: // '\004'
                    ascope = (Scope[])_cls141D.if._mth02CB(parcel, l, Scope.CREATOR);
                    break;

                case 5: // '\005'
                    bundle = _cls141D.if._mth02CF(parcel, l);
                    break;

                case 6: // '\006'
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
                return new ValidateAccountRequest(j, i, ibinder, ascope, bundle, s);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ValidateAccountRequest[i];
    }
}
