// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;

public final class hk
    implements android.os.Parcelable.Creator
{

    public hk()
    {
    }

    public static GoogleMapOptions _mth02B9(Parcel parcel)
    {
        int k = _cls141D.if._mth02CA(parcel);
        int j = 0;
        byte byte10 = -1;
        byte byte9 = -1;
        int i = 0;
        CameraPosition cameraposition = null;
        byte byte8 = -1;
        byte byte7 = -1;
        byte byte6 = -1;
        byte byte5 = -1;
        byte byte4 = -1;
        byte byte3 = -1;
        byte byte2 = -1;
        byte byte1 = -1;
        byte byte0 = -1;
        do
        {
            if (parcel.dataPosition() >= k)
            {
                break;
            }
            int l = parcel.readInt();
            switch (l & 0xffff)
            {
            case 1: // '\001'
                _cls141D.if._mth02CA(parcel, l, 4);
                j = parcel.readInt();
                break;

            case 2: // '\002'
                _cls141D.if._mth02CA(parcel, l, 4);
                byte10 = (byte)parcel.readInt();
                break;

            case 3: // '\003'
                _cls141D.if._mth02CA(parcel, l, 4);
                byte9 = (byte)parcel.readInt();
                break;

            case 4: // '\004'
                _cls141D.if._mth02CA(parcel, l, 4);
                i = parcel.readInt();
                break;

            case 5: // '\005'
                cameraposition = (CameraPosition)_cls141D.if._mth02CA(parcel, l, CameraPosition.CREATOR);
                break;

            case 6: // '\006'
                _cls141D.if._mth02CA(parcel, l, 4);
                byte8 = (byte)parcel.readInt();
                break;

            case 7: // '\007'
                _cls141D.if._mth02CA(parcel, l, 4);
                byte7 = (byte)parcel.readInt();
                break;

            case 8: // '\b'
                _cls141D.if._mth02CA(parcel, l, 4);
                byte6 = (byte)parcel.readInt();
                break;

            case 9: // '\t'
                _cls141D.if._mth02CA(parcel, l, 4);
                byte5 = (byte)parcel.readInt();
                break;

            case 10: // '\n'
                _cls141D.if._mth02CA(parcel, l, 4);
                byte4 = (byte)parcel.readInt();
                break;

            case 11: // '\013'
                _cls141D.if._mth02CA(parcel, l, 4);
                byte3 = (byte)parcel.readInt();
                break;

            case 12: // '\f'
                _cls141D.if._mth02CA(parcel, l, 4);
                byte2 = (byte)parcel.readInt();
                break;

            case 14: // '\016'
                _cls141D.if._mth02CA(parcel, l, 4);
                byte1 = (byte)parcel.readInt();
                break;

            case 15: // '\017'
                _cls141D.if._mth02CA(parcel, l, 4);
                byte0 = (byte)parcel.readInt();
                break;

            case 13: // '\r'
            default:
                _cls141D.if._mth02CA(parcel, l);
                break;
            }
        } while (true);
        if (parcel.dataPosition() != k)
        {
            throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
        } else
        {
            return new GoogleMapOptions(j, byte10, byte9, i, cameraposition, byte8, byte7, byte6, byte5, byte4, byte3, byte2, byte1, byte0);
        }
    }

    public static void _mth02CA(GoogleMapOptions googlemapoptions, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int k = parcel.dataPosition();
        int j = googlemapoptions.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(j);
        Boolean boolean1 = googlemapoptions.Eb;
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
            {
                j = 1;
            } else
            {
                j = 0;
            }
        } else
        {
            j = -1;
        }
        _cls141D.if._mth02CB(parcel, 2, 4);
        parcel.writeInt(j);
        boolean1 = googlemapoptions.Ec;
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
            {
                j = 1;
            } else
            {
                j = 0;
            }
        } else
        {
            j = -1;
        }
        _cls141D.if._mth02CB(parcel, 3, 4);
        parcel.writeInt(j);
        j = googlemapoptions.Ed;
        _cls141D.if._mth02CB(parcel, 4, 4);
        parcel.writeInt(j);
        _cls141D.if._mth02CA(parcel, 5, googlemapoptions.Ee, i, false);
        boolean1 = googlemapoptions.Ef;
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
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
        boolean1 = googlemapoptions.Eg;
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
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
        boolean1 = googlemapoptions.Eh;
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
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
        boolean1 = googlemapoptions.Ei;
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
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
        boolean1 = googlemapoptions.Ej;
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
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
        boolean1 = googlemapoptions.Ek;
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
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
        _cls141D.if._mth02CB(parcel, 11, 4);
        parcel.writeInt(i);
        boolean1 = googlemapoptions.El;
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
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
        _cls141D.if._mth02CB(parcel, 12, 4);
        parcel.writeInt(i);
        boolean1 = googlemapoptions.Em;
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
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
        _cls141D.if._mth02CB(parcel, 14, 4);
        parcel.writeInt(i);
        googlemapoptions = googlemapoptions.En;
        if (googlemapoptions != null)
        {
            if (googlemapoptions.booleanValue())
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
        _cls141D.if._mth02CB(parcel, 15, 4);
        parcel.writeInt(i);
        _cls141D.if._mth141D(parcel, k);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth02B9(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new GoogleMapOptions[i];
    }
}
