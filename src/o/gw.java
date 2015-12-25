// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

// Referenced classes of package o:
//            gi, bg

public final class gw
    implements android.os.Parcelable.Creator
{

    public gw()
    {
    }

    public static void _mth02CA(GroundOverlayOptions groundoverlayoptions, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = groundoverlayoptions.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(k);
        _cls141D.if._mth02CA(parcel, 2, groundoverlayoptions.EZ.DU.asBinder(), false);
        _cls141D.if._mth02CA(parcel, 3, groundoverlayoptions.Fa, i, false);
        float f = groundoverlayoptions.Fb;
        _cls141D.if._mth02CB(parcel, 4, 4);
        parcel.writeFloat(f);
        f = groundoverlayoptions.Fc;
        _cls141D.if._mth02CB(parcel, 5, 4);
        parcel.writeFloat(f);
        _cls141D.if._mth02CA(parcel, 6, groundoverlayoptions.Fd, i, false);
        f = groundoverlayoptions.ER;
        _cls141D.if._mth02CB(parcel, 7, 4);
        parcel.writeFloat(f);
        f = groundoverlayoptions.EX;
        _cls141D.if._mth02CB(parcel, 8, 4);
        parcel.writeFloat(f);
        boolean flag = groundoverlayoptions.EY;
        _cls141D.if._mth02CB(parcel, 9, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        f = groundoverlayoptions.Fe;
        _cls141D.if._mth02CB(parcel, 10, 4);
        parcel.writeFloat(f);
        f = groundoverlayoptions.Ff;
        _cls141D.if._mth02CB(parcel, 11, 4);
        parcel.writeFloat(f);
        f = groundoverlayoptions.Fg;
        _cls141D.if._mth02CB(parcel, 12, 4);
        parcel.writeFloat(f);
        _cls141D.if._mth141D(parcel, j);
    }

    public static GroundOverlayOptions _mth1FBE(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        android.os.IBinder ibinder = null;
        LatLng latlng = null;
        float f6 = 0.0F;
        float f5 = 0.0F;
        LatLngBounds latlngbounds = null;
        float f4 = 0.0F;
        float f3 = 0.0F;
        boolean flag = false;
        float f2 = 0.0F;
        float f1 = 0.0F;
        float f = 0.0F;
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
                    latlng = (LatLng)_cls141D.if._mth02CA(parcel, k, LatLng.CREATOR);
                    break;

                case 4: // '\004'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f6 = parcel.readFloat();
                    break;

                case 5: // '\005'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f5 = parcel.readFloat();
                    break;

                case 6: // '\006'
                    latlngbounds = (LatLngBounds)_cls141D.if._mth02CA(parcel, k, LatLngBounds.CREATOR);
                    break;

                case 7: // '\007'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f4 = parcel.readFloat();
                    break;

                case 8: // '\b'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f3 = parcel.readFloat();
                    break;

                case 9: // '\t'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    if (parcel.readInt() != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    break;

                case 10: // '\n'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f2 = parcel.readFloat();
                    break;

                case 11: // '\013'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f1 = parcel.readFloat();
                    break;

                case 12: // '\f'
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
                return new GroundOverlayOptions(i, ibinder, latlng, f6, f5, latlngbounds, f4, f3, flag, f2, f1, f);
            }
        } while (true);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth1FBE(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new GroundOverlayOptions[i];
    }
}
