// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.internal.ClientIdentity;
import com.google.android.gms.location.internal.LocationRequestInternal;

public final class ed
    implements android.os.Parcelable.Creator
{

    public ed()
    {
    }

    public static void _mth02CA(LocationRequestInternal locationrequestinternal, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        _cls141D.if._mth02CA(parcel, 1, locationrequestinternal.Dg, i, false);
        i = locationrequestinternal.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(i);
        boolean flag = locationrequestinternal.Dh;
        _cls141D.if._mth02CB(parcel, 2, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = locationrequestinternal.Di;
        _cls141D.if._mth02CB(parcel, 3, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        flag = locationrequestinternal.Dj;
        _cls141D.if._mth02CB(parcel, 4, 4);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        _cls141D.if._mth02CA(parcel, 5, locationrequestinternal.Dk, false);
        _cls141D.if._mth02CA(parcel, 6, locationrequestinternal.mTag, false);
        flag = locationrequestinternal.Dl;
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

    public static LocationRequestInternal _mth141D(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        LocationRequest locationrequest = null;
        boolean flag7 = false;
        boolean flag6 = true;
        boolean flag5 = true;
        Object obj = LocationRequestInternal.Df;
        String s = null;
        boolean flag4 = false;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (k & 0xffff)
                {
                case 1: // '\001'
                    locationrequest = (LocationRequest)_cls141D.if._mth02CA(parcel, k, LocationRequest.CREATOR);
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
                    flag7 = flag;
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
                    flag6 = flag1;
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
                    flag5 = flag2;
                    break;

                case 5: // '\005'
                    obj = _cls141D.if._mth02CE(parcel, k, ClientIdentity.CREATOR);
                    break;

                case 6: // '\006'
                    s = _cls141D.if._mth02CB(parcel, k);
                    break;

                case 7: // '\007'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    boolean flag3;
                    if (parcel.readInt() != 0)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    flag4 = flag3;
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
                return new LocationRequestInternal(i, locationrequest, flag7, flag6, flag5, ((java.util.List) (obj)), s, flag4);
            }
        } while (true);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth141D(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new LocationRequestInternal[i];
    }
}
