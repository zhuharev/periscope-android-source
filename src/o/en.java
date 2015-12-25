// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import java.util.Collections;

public final class en
    implements android.os.Parcelable.Creator
{

    public en()
    {
    }

    public static void _mth02CA(LocationSettingsRequest locationsettingsrequest, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        _cls141D.if._mth02CA(parcel, 1, Collections.unmodifiableList(locationsettingsrequest.CR), false);
        int i = locationsettingsrequest.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(i);
        boolean flag = locationsettingsrequest.CS;
        _cls141D.if._mth02CB(parcel, 2, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = locationsettingsrequest.CT;
        _cls141D.if._mth02CB(parcel, 3, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = locationsettingsrequest.CU;
        _cls141D.if._mth02CB(parcel, 4, 4);
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
        java.util.ArrayList arraylist = null;
        boolean flag5 = false;
        boolean flag4 = false;
        boolean flag3 = false;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (k & 0xffff)
                {
                case 1: // '\001'
                    arraylist = _cls141D.if._mth02CE(parcel, k, LocationRequest.CREATOR);
                    break;

                case 1000: 
                    _cls141D.if._mth02CA(parcel, k, 4);
                    i = parcel.readInt();
                    break;

                case 2: // '\002'
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

                case 3: // '\003'
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

                case 4: // '\004'
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
                return new LocationSettingsRequest(i, arraylist, flag5, flag4, flag3);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new LocationSettingsRequest[i];
    }
}
