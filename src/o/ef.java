// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.location.internal.ParcelableGeofence;

public final class ef
    implements android.os.Parcelable.Creator
{

    public ef()
    {
    }

    public static void _mth02CA(ParcelableGeofence parcelablegeofence, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int i = parcel.dataPosition();
        _cls141D.if._mth02CA(parcel, 1, parcelablegeofence.Dr, false);
        int j = parcelablegeofence.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(j);
        long l = parcelablegeofence.Ds;
        _cls141D.if._mth02CB(parcel, 2, 8);
        parcel.writeLong(l);
        j = parcelablegeofence.Dt;
        _cls141D.if._mth02CB(parcel, 3, 4);
        parcel.writeInt(j);
        double d = parcelablegeofence.Du;
        _cls141D.if._mth02CB(parcel, 4, 8);
        parcel.writeDouble(d);
        d = parcelablegeofence.Dv;
        _cls141D.if._mth02CB(parcel, 5, 8);
        parcel.writeDouble(d);
        float f = parcelablegeofence.Dw;
        _cls141D.if._mth02CB(parcel, 6, 4);
        parcel.writeFloat(f);
        j = parcelablegeofence.Dx;
        _cls141D.if._mth02CB(parcel, 7, 4);
        parcel.writeInt(j);
        j = parcelablegeofence.Dy;
        _cls141D.if._mth02CB(parcel, 8, 4);
        parcel.writeInt(j);
        j = parcelablegeofence.Dz;
        _cls141D.if._mth02CB(parcel, 9, 4);
        parcel.writeInt(j);
        _cls141D.if._mth141D(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int i1 = _cls141D.if._mth02CA(parcel);
        int l = 0;
        String s = null;
        int k = 0;
        short word0 = 0;
        double d1 = 0.0D;
        double d = 0.0D;
        float f = 0.0F;
        long l1 = 0L;
        int j = 0;
        int i = -1;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = parcel.readInt();
                switch (j1 & 0xffff)
                {
                case 1: // '\001'
                    s = _cls141D.if._mth02CB(parcel, j1);
                    break;

                case 1000: 
                    _cls141D.if._mth02CA(parcel, j1, 4);
                    l = parcel.readInt();
                    break;

                case 2: // '\002'
                    _cls141D.if._mth02CA(parcel, j1, 8);
                    l1 = parcel.readLong();
                    break;

                case 3: // '\003'
                    _cls141D.if._mth02CA(parcel, j1, 4);
                    word0 = (short)parcel.readInt();
                    break;

                case 4: // '\004'
                    _cls141D.if._mth02CA(parcel, j1, 8);
                    d1 = parcel.readDouble();
                    break;

                case 5: // '\005'
                    _cls141D.if._mth02CA(parcel, j1, 8);
                    d = parcel.readDouble();
                    break;

                case 6: // '\006'
                    _cls141D.if._mth02CA(parcel, j1, 4);
                    f = parcel.readFloat();
                    break;

                case 7: // '\007'
                    _cls141D.if._mth02CA(parcel, j1, 4);
                    k = parcel.readInt();
                    break;

                case 8: // '\b'
                    _cls141D.if._mth02CA(parcel, j1, 4);
                    j = parcel.readInt();
                    break;

                case 9: // '\t'
                    _cls141D.if._mth02CA(parcel, j1, 4);
                    i = parcel.readInt();
                    break;

                default:
                    _cls141D.if._mth02CA(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(i1).toString(), parcel);
            } else
            {
                return new ParcelableGeofence(l, s, k, word0, d1, d, f, l1, j, i);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ParcelableGeofence[i];
    }
}
