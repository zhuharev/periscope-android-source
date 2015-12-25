// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.common.api.Scope;

public final class _cls0E16
    implements android.os.Parcelable.Creator
{

    public _cls0E16()
    {
    }

    public static void _mth02CA(Scope scope, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int i = parcel.dataPosition();
        int j = scope.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(j);
        _cls141D.if._mth02CA(parcel, 2, scope.xh, false);
        _cls141D.if._mth141D(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        String s = null;
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
                    s = _cls141D.if._mth02CB(parcel, k);
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
                return new Scope(i, s);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new Scope[i];
    }
}
