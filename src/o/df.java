// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.location.DetectedActivity;

public final class df
    implements android.os.Parcelable.Creator
{

    public df()
    {
    }

    public static void _mth02CA(DetectedActivity detectedactivity, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int i = parcel.dataPosition();
        int j = detectedactivity.Cw;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(j);
        j = detectedactivity.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(j);
        j = detectedactivity.Cx;
        _cls141D.if._mth02CB(parcel, 2, 4);
        parcel.writeInt(j);
        _cls141D.if._mth141D(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int l = _cls141D.if._mth02CA(parcel);
        int k = 0;
        int j = 0;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = parcel.readInt();
                switch (i1 & 0xffff)
                {
                case 1: // '\001'
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    j = parcel.readInt();
                    break;

                case 1000: 
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    k = parcel.readInt();
                    break;

                case 2: // '\002'
                    _cls141D.if._mth02CA(parcel, i1, 4);
                    i = parcel.readInt();
                    break;

                default:
                    _cls141D.if._mth02CA(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new DetectedActivity(k, j, i);
            }
        } while (true);
    }

    public final volatile Object[] newArray(int i)
    {
        return new DetectedActivity[i];
    }
}
