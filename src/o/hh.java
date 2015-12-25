// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;

public final class hh
    implements android.os.Parcelable.Creator
{

    public hh()
    {
    }

    public static void _mth02CA(Tile tile, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int i = parcel.dataPosition();
        int j = tile.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(j);
        j = tile.width;
        _cls141D.if._mth02CB(parcel, 2, 4);
        parcel.writeInt(j);
        j = tile.height;
        _cls141D.if._mth02CB(parcel, 3, 4);
        parcel.writeInt(j);
        tile = tile.data;
        if (tile != null)
        {
            parcel.writeInt(-65532);
            parcel.writeInt(0);
            int k = parcel.dataPosition();
            parcel.writeByteArray(tile);
            int l = parcel.dataPosition();
            parcel.setDataPosition(k - 4);
            parcel.writeInt(l - k);
            parcel.setDataPosition(l);
        }
        _cls141D.if._mth141D(parcel, i);
    }

    public static Tile _mth1428(Parcel parcel)
    {
        int i1 = _cls141D.if._mth02CA(parcel);
        int k = 0;
        int j = 0;
        int i = 0;
        byte abyte0[] = null;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int l = parcel.readInt();
                switch (l & 0xffff)
                {
                case 1: // '\001'
                    _cls141D.if._mth02CA(parcel, l, 4);
                    k = parcel.readInt();
                    break;

                case 2: // '\002'
                    _cls141D.if._mth02CA(parcel, l, 4);
                    j = parcel.readInt();
                    break;

                case 3: // '\003'
                    _cls141D.if._mth02CA(parcel, l, 4);
                    i = parcel.readInt();
                    break;

                case 4: // '\004'
                    if ((0xffff0000 & l) != 0xffff0000)
                    {
                        l = l >> 16 & 0xffff;
                    } else
                    {
                        l = parcel.readInt();
                    }
                    int j1 = parcel.dataPosition();
                    if (l == 0)
                    {
                        abyte0 = null;
                    } else
                    {
                        abyte0 = parcel.createByteArray();
                        parcel.setDataPosition(j1 + l);
                    }
                    break;

                default:
                    _cls141D.if._mth02CA(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(i1).toString(), parcel);
            } else
            {
                return new Tile(k, j, i, abyte0);
            }
        } while (true);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth1428(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new Tile[i];
    }
}
