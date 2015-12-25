// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// Referenced classes of package o:
//            gi, bg

public final class gz
    implements android.os.Parcelable.Creator
{

    public gz()
    {
    }

    public static MarkerOptions _mth02C8(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        LatLng latlng = null;
        String s1 = null;
        String s = null;
        android.os.IBinder ibinder = null;
        float f5 = 0.0F;
        float f4 = 0.0F;
        boolean flag5 = false;
        boolean flag4 = false;
        boolean flag3 = false;
        float f3 = 0.0F;
        float f2 = 0.5F;
        float f1 = 0.0F;
        float f = 1.0F;
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
                    latlng = (LatLng)_cls141D.if._mth02CA(parcel, k, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    s1 = _cls141D.if._mth02CB(parcel, k);
                    break;

                case 4: // '\004'
                    s = _cls141D.if._mth02CB(parcel, k);
                    break;

                case 5: // '\005'
                    ibinder = _cls141D.if._mth02CE(parcel, k);
                    break;

                case 6: // '\006'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f5 = parcel.readFloat();
                    break;

                case 7: // '\007'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f4 = parcel.readFloat();
                    break;

                case 8: // '\b'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    boolean flag;
                    if (parcel.readInt() != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    flag5 = flag;
                    break;

                case 9: // '\t'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    boolean flag1;
                    if (parcel.readInt() != 0)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    flag4 = flag1;
                    break;

                case 10: // '\n'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    boolean flag2;
                    if (parcel.readInt() != 0)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    flag3 = flag2;
                    break;

                case 11: // '\013'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f3 = parcel.readFloat();
                    break;

                case 12: // '\f'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f2 = parcel.readFloat();
                    break;

                case 13: // '\r'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f1 = parcel.readFloat();
                    break;

                case 14: // '\016'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f = parcel.readFloat();
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
                return new MarkerOptions(i, latlng, s1, s, ibinder, f5, f4, flag5, flag4, flag3, f3, f2, f1, f);
            }
        } while (true);
    }

    public static void _mth02CA(MarkerOptions markeroptions, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = markeroptions.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(k);
        _cls141D.if._mth02CA(parcel, 2, markeroptions.EC, i, false);
        _cls141D.if._mth02CA(parcel, 3, markeroptions.Fk, false);
        _cls141D.if._mth02CA(parcel, 4, markeroptions.Fl, false);
        android.os.IBinder ibinder;
        if (markeroptions.Fm == null)
        {
            ibinder = null;
        } else
        {
            ibinder = markeroptions.Fm.DU.asBinder();
        }
        _cls141D.if._mth02CA(parcel, 5, ibinder, false);
        float f = markeroptions.Ff;
        _cls141D.if._mth02CB(parcel, 6, 4);
        parcel.writeFloat(f);
        f = markeroptions.Fg;
        _cls141D.if._mth02CB(parcel, 7, 4);
        parcel.writeFloat(f);
        boolean flag = markeroptions.Fn;
        _cls141D.if._mth02CB(parcel, 8, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = markeroptions.EY;
        _cls141D.if._mth02CB(parcel, 9, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = markeroptions.Fo;
        _cls141D.if._mth02CB(parcel, 10, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        f = markeroptions.Fp;
        _cls141D.if._mth02CB(parcel, 11, 4);
        parcel.writeFloat(f);
        f = markeroptions.Fq;
        _cls141D.if._mth02CB(parcel, 12, 4);
        parcel.writeFloat(f);
        f = markeroptions.Fr;
        _cls141D.if._mth02CB(parcel, 13, 4);
        parcel.writeFloat(f);
        f = markeroptions.mAlpha;
        _cls141D.if._mth02CB(parcel, 14, 4);
        parcel.writeFloat(f);
        _cls141D.if._mth141D(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth02C8(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new MarkerOptions[i];
    }
}
