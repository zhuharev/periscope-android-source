// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public final class gv
    implements android.os.Parcelable.Creator
{

    public gv()
    {
    }

    public static void _mth02CA(CircleOptions circleoptions, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = circleoptions.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(k);
        _cls141D.if._mth02CA(parcel, 2, circleoptions.ES, i, false);
        double d = circleoptions.ET;
        _cls141D.if._mth02CB(parcel, 3, 8);
        parcel.writeDouble(d);
        float f = circleoptions.EU;
        _cls141D.if._mth02CB(parcel, 4, 4);
        parcel.writeFloat(f);
        i = circleoptions.EV;
        _cls141D.if._mth02CB(parcel, 5, 4);
        parcel.writeInt(i);
        i = circleoptions.EW;
        _cls141D.if._mth02CB(parcel, 6, 4);
        parcel.writeInt(i);
        f = circleoptions.EX;
        _cls141D.if._mth02CB(parcel, 7, 4);
        parcel.writeFloat(f);
        boolean flag = circleoptions.EY;
        _cls141D.if._mth02CB(parcel, 8, 4);
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

    public static CircleOptions _mth037A(Parcel parcel)
    {
        int l = _cls141D.if._mth02CA(parcel);
        int k = 0;
        LatLng latlng = null;
        double d = 0.0D;
        float f1 = 0.0F;
        int j = 0;
        int i = 0;
        float f = 0.0F;
        boolean flag = false;
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
                    latlng = (LatLng)_cls141D.if._mth02CA(parcel, i1, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    _cls141D.if._mth02CA(parcel, i1, 8);
                    d = parcel.readDouble();
                    break;

                case 4: // '\004'
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    f1 = parcel.readFloat();
                    break;

                case 5: // '\005'
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    j = parcel.readInt();
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
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    if (parcel.readInt() != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
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
                return new CircleOptions(k, latlng, d, f1, j, i, f, flag);
            }
        } while (true);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth037A(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new CircleOptions[i];
    }
}
