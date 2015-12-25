// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.ArrayList;

public final class hb
    implements android.os.Parcelable.Creator
{

    public hb()
    {
    }

    public static void _mth02CA(PolygonOptions polygonoptions, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int i = polygonoptions.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(i);
        _cls141D.if._mth02CA(parcel, 2, polygonoptions.Fu, false);
        java.util.List list = polygonoptions.Fv;
        if (list != null)
        {
            parcel.writeInt(-65533);
            parcel.writeInt(0);
            i = parcel.dataPosition();
            parcel.writeList(list);
            int k = parcel.dataPosition();
            parcel.setDataPosition(i - 4);
            parcel.writeInt(k - i);
            parcel.setDataPosition(k);
        }
        float f = polygonoptions.EU;
        _cls141D.if._mth02CB(parcel, 4, 4);
        parcel.writeFloat(f);
        i = polygonoptions.EV;
        _cls141D.if._mth02CB(parcel, 5, 4);
        parcel.writeInt(i);
        i = polygonoptions.EW;
        _cls141D.if._mth02CB(parcel, 6, 4);
        parcel.writeInt(i);
        f = polygonoptions.EX;
        _cls141D.if._mth02CB(parcel, 7, 4);
        parcel.writeFloat(f);
        boolean flag = polygonoptions.EY;
        _cls141D.if._mth02CB(parcel, 8, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = polygonoptions.Fw;
        _cls141D.if._mth02CB(parcel, 9, 4);
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
        return _mth02CC(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new PolygonOptions[i];
    }

    public final PolygonOptions _mth02CC(Parcel parcel)
    {
        int l = _cls141D.if._mth02CA(parcel);
        int k = 0;
        ArrayList arraylist = null;
        ArrayList arraylist1 = new ArrayList();
        float f1 = 0.0F;
        int j = 0;
        int i = 0;
        float f = 0.0F;
        boolean flag3 = false;
        boolean flag2 = false;
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
                    arraylist = _cls141D.if._mth02CE(parcel, i1, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    _cls141D.if._mth02CA(parcel, i1, arraylist1, getClass().getClassLoader());
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

                case 9: // '\t'
                    _cls141D.if._mth02CA(parcel, i1, 4);
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
                    _cls141D.if._mth02CA(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new PolygonOptions(k, arraylist, arraylist1, f1, j, i, f, flag3, flag2);
            }
        } while (true);
    }
}
