// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;

public final class _cls15A8
    implements android.os.Parcelable.Creator
{

    public _cls15A8()
    {
    }

    public static void _mth02CA(ResolveAccountResponse resolveaccountresponse, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = resolveaccountresponse.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(k);
        _cls141D.if._mth02CA(parcel, 2, resolveaccountresponse.xn, false);
        _cls141D.if._mth02CA(parcel, 3, resolveaccountresponse.xy, i, false);
        boolean flag = resolveaccountresponse.xz;
        _cls141D.if._mth02CB(parcel, 4, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = resolveaccountresponse.xA;
        _cls141D.if._mth02CB(parcel, 5, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        _cls141D.if._mth141D(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        android.os.IBinder ibinder = null;
        ConnectionResult connectionresult = null;
        boolean flag3 = false;
        boolean flag2 = false;
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
                    ibinder = _cls141D.if._mth02CE(parcel, k);
                    break;

                case 3: // '\003'
                    connectionresult = (ConnectionResult)_cls141D.if._mth02CA(parcel, k, ConnectionResult.CREATOR);
                    break;

                case 4: // '\004'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    boolean flag;
                    if (parcel.readInt() != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    flag3 = flag;
                    break;

                case 5: // '\005'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    boolean flag1;
                    if (parcel.readInt() != 0)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    flag2 = flag1;
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
                return new ResolveAccountResponse(i, ibinder, connectionresult, flag3, flag2);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ResolveAccountResponse[i];
    }
}
