// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

public final class hc
    implements android.os.Parcelable.Creator
{

    public hc()
    {
    }

    public static void _mth02CA(PolylineOptions polylineoptions, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int i = polylineoptions.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(i);
        _cls141D.if._mth02CA(parcel, 2, polylineoptions.Fu, false);
        float f = polylineoptions.Fb;
        _cls141D.if._mth02CB(parcel, 3, 4);
        parcel.writeFloat(f);
        i = polylineoptions._fld0196;
        _cls141D.if._mth02CB(parcel, 4, 4);
        parcel.writeInt(i);
        f = polylineoptions.EX;
        _cls141D.if._mth02CB(parcel, 5, 4);
        parcel.writeFloat(f);
        boolean flag = polylineoptions.EY;
        _cls141D.if._mth02CB(parcel, 6, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = polylineoptions.Fw;
        _cls141D.if._mth02CB(parcel, 7, 4);
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

    public static PolylineOptions _mth02CD(Parcel parcel)
    {
        int k = _cls141D.if._mth02CA(parcel);
        int j = 0;
        java.util.ArrayList arraylist = null;
        float f1 = 0.0F;
        int i = 0;
        float f = 0.0F;
        boolean flag3 = false;
        boolean flag2 = false;
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
                    arraylist = _cls141D.if._mth02CE(parcel, l, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    _cls141D.if._mth02CA(parcel, l, 4);
                    f1 = parcel.readFloat();
                    break;

                case 4: // '\004'
                    _cls141D.if._mth02CA(parcel, l, 4);
                    i = parcel.readInt();
                    break;

                case 5: // '\005'
                    _cls141D.if._mth02CA(parcel, l, 4);
                    f = parcel.readFloat();
                    break;

                case 6: // '\006'
                    _cls141D.if._mth02CA(parcel, l, 4);
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

                case 7: // '\007'
                    _cls141D.if._mth02CA(parcel, l, 4);
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
                    _cls141D.if._mth02CA(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new PolylineOptions(j, arraylist, f1, i, f, flag3, flag2);
            }
        } while (true);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth02CD(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new PolylineOptions[i];
    }
}
