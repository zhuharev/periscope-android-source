// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class hl
    implements android.os.Parcelable.Creator
{

    public hl()
    {
    }

    public static void _mth02CA(StreetViewPanoramaOptions streetviewpanoramaoptions, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = streetviewpanoramaoptions.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(k);
        _cls141D.if._mth02CA(parcel, 2, streetviewpanoramaoptions.EA, i, false);
        _cls141D.if._mth02CA(parcel, 3, streetviewpanoramaoptions.EB, false);
        _cls141D.if._mth02CA(parcel, 4, streetviewpanoramaoptions.EC, i, false);
        Object obj = streetviewpanoramaoptions.ED;
        if (obj != null)
        {
            _cls141D.if._mth02CB(parcel, 5, 4);
            parcel.writeInt(((Integer) (obj)).intValue());
        }
        obj = streetviewpanoramaoptions.EE;
        if (obj != null)
        {
            if (((Boolean) (obj)).booleanValue())
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            i = -1;
        }
        _cls141D.if._mth02CB(parcel, 6, 4);
        parcel.writeInt(i);
        obj = streetviewpanoramaoptions.Ei;
        if (obj != null)
        {
            if (((Boolean) (obj)).booleanValue())
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            i = -1;
        }
        _cls141D.if._mth02CB(parcel, 7, 4);
        parcel.writeInt(i);
        obj = streetviewpanoramaoptions.EF;
        if (obj != null)
        {
            if (((Boolean) (obj)).booleanValue())
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            i = -1;
        }
        _cls141D.if._mth02CB(parcel, 8, 4);
        parcel.writeInt(i);
        obj = streetviewpanoramaoptions.EG;
        if (obj != null)
        {
            if (((Boolean) (obj)).booleanValue())
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            i = -1;
        }
        _cls141D.if._mth02CB(parcel, 9, 4);
        parcel.writeInt(i);
        streetviewpanoramaoptions = streetviewpanoramaoptions.Ec;
        if (streetviewpanoramaoptions != null)
        {
            if (streetviewpanoramaoptions.booleanValue())
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            i = -1;
        }
        _cls141D.if._mth02CB(parcel, 10, 4);
        parcel.writeInt(i);
        _cls141D.if._mth141D(parcel, j);
    }

    public static StreetViewPanoramaOptions _mth0559(Parcel parcel)
    {
        int k = _cls141D.if._mth02CA(parcel);
        int i = 0;
        StreetViewPanoramaCamera streetviewpanoramacamera = null;
        String s = null;
        LatLng latlng = null;
        Integer integer = null;
        byte byte4 = 0;
        byte byte3 = 0;
        byte byte2 = 0;
        byte byte1 = 0;
        byte byte0 = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int j = parcel.readInt();
                switch (j & 0xffff)
                {
                case 1: // '\001'
                    _cls141D.if._mth02CA(parcel, j, 4);
                    i = parcel.readInt();
                    break;

                case 2: // '\002'
                    streetviewpanoramacamera = (StreetViewPanoramaCamera)_cls141D.if._mth02CA(parcel, j, StreetViewPanoramaCamera.CREATOR);
                    break;

                case 3: // '\003'
                    s = _cls141D.if._mth02CB(parcel, j);
                    break;

                case 4: // '\004'
                    latlng = (LatLng)_cls141D.if._mth02CA(parcel, j, LatLng.CREATOR);
                    break;

                case 5: // '\005'
                    if ((0xffff0000 & j) != 0xffff0000)
                    {
                        j = j >> 16 & 0xffff;
                    } else
                    {
                        j = parcel.readInt();
                    }
                    if (j == 0)
                    {
                        integer = null;
                    } else
                    {
                        if (j != 4)
                        {
                            throw new android.support.v4.app.Fragment.if((new StringBuilder("Expected size ")).append(4).append(" got ").append(j).append(" (0x").append(Integer.toHexString(j)).append(")").toString(), parcel);
                        }
                        integer = Integer.valueOf(parcel.readInt());
                    }
                    break;

                case 6: // '\006'
                    _cls141D.if._mth02CA(parcel, j, 4);
                    byte4 = (byte)parcel.readInt();
                    break;

                case 7: // '\007'
                    _cls141D.if._mth02CA(parcel, j, 4);
                    byte3 = (byte)parcel.readInt();
                    break;

                case 8: // '\b'
                    _cls141D.if._mth02CA(parcel, j, 4);
                    byte2 = (byte)parcel.readInt();
                    break;

                case 9: // '\t'
                    _cls141D.if._mth02CA(parcel, j, 4);
                    byte1 = (byte)parcel.readInt();
                    break;

                case 10: // '\n'
                    _cls141D.if._mth02CA(parcel, j, 4);
                    byte0 = (byte)parcel.readInt();
                    break;

                default:
                    _cls141D.if._mth02CA(parcel, j);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new StreetViewPanoramaOptions(i, streetviewpanoramacamera, s, latlng, integer, byte4, byte3, byte2, byte1, byte0);
            }
        } while (true);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth0559(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new StreetViewPanoramaOptions[i];
    }
}
