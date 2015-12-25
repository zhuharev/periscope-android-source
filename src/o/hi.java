// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.model.TileOverlayOptions;

// Referenced classes of package o:
//            gt

public final class hi
    implements android.os.Parcelable.Creator
{

    public hi()
    {
    }

    public static void _mth02CA(TileOverlayOptions tileoverlayoptions, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int i = tileoverlayoptions.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(i);
        _cls141D.if._mth02CA(parcel, 2, tileoverlayoptions.FB.asBinder(), false);
        boolean flag = tileoverlayoptions.EY;
        _cls141D.if._mth02CB(parcel, 3, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        float f = tileoverlayoptions.EX;
        _cls141D.if._mth02CB(parcel, 4, 4);
        parcel.writeFloat(f);
        flag = tileoverlayoptions.FD;
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

    public static TileOverlayOptions FE73(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        android.os.IBinder ibinder = null;
        boolean flag3 = false;
        float f = 0.0F;
        boolean flag2 = true;
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

                case 4: // '\004'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f = parcel.readFloat();
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
                return new TileOverlayOptions(i, ibinder, flag3, f, flag2);
            }
        } while (true);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return FE73(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new TileOverlayOptions[i];
    }
}
