// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.location.LocationRequest;

public final class dk
    implements android.os.Parcelable.Creator
{

    public dk()
    {
    }

    public static void _mth02CA(LocationRequest locationrequest, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int i = locationrequest.mPriority;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(i);
        i = locationrequest.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(i);
        long l = locationrequest.CF;
        _cls141D.if._mth02CB(parcel, 2, 8);
        parcel.writeLong(l);
        l = locationrequest.CG;
        _cls141D.if._mth02CB(parcel, 3, 8);
        parcel.writeLong(l);
        boolean flag = locationrequest.CH;
        _cls141D.if._mth02CB(parcel, 4, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        l = locationrequest.CI;
        _cls141D.if._mth02CB(parcel, 5, 8);
        parcel.writeLong(l);
        i = locationrequest.CJ;
        _cls141D.if._mth02CB(parcel, 6, 4);
        parcel.writeInt(i);
        float f = locationrequest.CK;
        _cls141D.if._mth02CB(parcel, 7, 4);
        parcel.writeFloat(f);
        l = locationrequest.CL;
        _cls141D.if._mth02CB(parcel, 8, 8);
        parcel.writeLong(l);
        _cls141D.if._mth141D(parcel, j);
    }

    public static LocationRequest _mth02CF(Parcel parcel)
    {
        int l = _cls141D.if._mth02CA(parcel);
        int k = 0;
        int j = 102;
        long l4 = 0x36ee80L;
        long l3 = 0x927c0L;
        boolean flag = false;
        long l2 = 0x7fffffffffffffffL;
        int i = 0x7fffffff;
        float f = 0.0F;
        long l1 = 0L;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = parcel.readInt();
                switch (i1 & 0xffff)
                {
                case 1: // '\001'
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    j = parcel.readInt();
                    break;

                case 1000: 
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    k = parcel.readInt();
                    break;

                case 2: // '\002'
                    _cls141D.if._mth02CA(parcel, i1, 8);
                    l4 = parcel.readLong();
                    break;

                case 3: // '\003'
                    _cls141D.if._mth02CA(parcel, i1, 8);
                    l3 = parcel.readLong();
                    break;

                case 4: // '\004'
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    if (parcel.readInt() != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    break;

                case 5: // '\005'
                    _cls141D.if._mth02CA(parcel, i1, 8);
                    l2 = parcel.readLong();
                    break;

                case 6: // '\006'
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    i = parcel.readInt();
                    break;

                case 7: // '\007'
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    f = parcel.readFloat();
                    break;

                case 8: // '\b'
                    _cls141D.if._mth02CA(parcel, i1, 8);
                    l1 = parcel.readLong();
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
                return new LocationRequest(k, j, l4, l3, flag, l2, i, f, l1);
            }
        } while (true);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth02CF(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new LocationRequest[i];
    }
}
