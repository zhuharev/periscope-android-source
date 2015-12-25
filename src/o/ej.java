// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.location.GestureRequest;
import java.util.ArrayList;
import java.util.List;

public final class ej
    implements android.os.Parcelable.Creator
{

    public ej()
    {
    }

    public static GestureRequest _mth02BC(Parcel parcel)
    {
        int l = _cls141D.if._mth02CA(parcel);
        int i = 0;
        ArrayList arraylist = null;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int j = parcel.readInt();
                switch (j & 0xffff)
                {
                case 1: // '\001'
                    if ((0xffff0000 & j) != 0xffff0000)
                    {
                        j = j >> 16 & 0xffff;
                    } else
                    {
                        j = parcel.readInt();
                    }
                    int i1 = parcel.dataPosition();
                    if (j == 0)
                    {
                        arraylist = null;
                    } else
                    {
                        arraylist = new ArrayList();
                        int j1 = parcel.readInt();
                        for (int k = 0; k < j1; k++)
                        {
                            arraylist.add(Integer.valueOf(parcel.readInt()));
                        }

                        parcel.setDataPosition(i1 + j);
                    }
                    break;

                case 1000: 
                    _cls141D.if._mth02CA(parcel, j, 4);
                    i = parcel.readInt();
                    break;

                default:
                    _cls141D.if._mth02CA(parcel, j);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new GestureRequest(i, arraylist);
            }
        } while (true);
    }

    public static void _mth02CA(GestureRequest gesturerequest, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int l = parcel.dataPosition();
        List list = gesturerequest.CA;
        if (list != null)
        {
            parcel.writeInt(-65535);
            parcel.writeInt(0);
            int i1 = parcel.dataPosition();
            int j1 = list.size();
            parcel.writeInt(j1);
            for (int i = 0; i < j1; i++)
            {
                parcel.writeInt(((Integer)list.get(i)).intValue());
            }

            int j = parcel.dataPosition();
            parcel.setDataPosition(i1 - 4);
            parcel.writeInt(j - i1);
            parcel.setDataPosition(j);
        }
        int k = gesturerequest.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(k);
        _cls141D.if._mth141D(parcel, l);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth02BC(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new GestureRequest[i];
    }
}
