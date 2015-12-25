// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.location.LocationSettingsStates;

public final class ep
    implements android.os.Parcelable.Creator
{

    public ep()
    {
    }

    public static void _mth02CA(LocationSettingsStates locationsettingsstates, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        boolean flag = locationsettingsstates.CY;
        _cls141D.if._mth02CB(parcel, 1, 4);
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        i = locationsettingsstates.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(i);
        flag = locationsettingsstates.CZ;
        _cls141D.if._mth02CB(parcel, 2, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = locationsettingsstates.Da;
        _cls141D.if._mth02CB(parcel, 3, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = locationsettingsstates.Db;
        _cls141D.if._mth02CB(parcel, 4, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = locationsettingsstates.Dc;
        _cls141D.if._mth02CB(parcel, 5, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = locationsettingsstates.Dd;
        _cls141D.if._mth02CB(parcel, 6, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = locationsettingsstates.De;
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

    public final Object createFromParcel(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        boolean flag13 = false;
        boolean flag12 = false;
        boolean flag11 = false;
        boolean flag10 = false;
        boolean flag9 = false;
        boolean flag8 = false;
        boolean flag7 = false;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (k & 0xffff)
                {
                case 1: // '\001'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    boolean flag;
                    if (parcel.readInt() != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    flag13 = flag;
                    break;

                case 1000: 
                    _cls141D.if._mth02CA(parcel, k, 4);
                    i = parcel.readInt();
                    break;

                case 2: // '\002'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    boolean flag1;
                    if (parcel.readInt() != 0)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    flag12 = flag1;
                    break;

                case 3: // '\003'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    boolean flag2;
                    if (parcel.readInt() != 0)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    flag11 = flag2;
                    break;

                case 4: // '\004'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    boolean flag3;
                    if (parcel.readInt() != 0)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    flag10 = flag3;
                    break;

                case 5: // '\005'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    boolean flag4;
                    if (parcel.readInt() != 0)
                    {
                        flag4 = true;
                    } else
                    {
                        flag4 = false;
                    }
                    flag9 = flag4;
                    break;

                case 6: // '\006'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    boolean flag5;
                    if (parcel.readInt() != 0)
                    {
                        flag5 = true;
                    } else
                    {
                        flag5 = false;
                    }
                    flag8 = flag5;
                    break;

                case 7: // '\007'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    boolean flag6;
                    if (parcel.readInt() != 0)
                    {
                        flag6 = true;
                    } else
                    {
                        flag6 = false;
                    }
                    flag7 = flag6;
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
                return new LocationSettingsStates(i, flag13, flag12, flag11, flag10, flag9, flag8, flag7);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new LocationSettingsStates[i];
    }
}
