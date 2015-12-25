// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

public final class dd
    implements android.os.Parcelable.Creator
{

    public dd()
    {
    }

    public static void _mth02CA(ActivityRecognitionResult activityrecognitionresult, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int i = parcel.dataPosition();
        _cls141D.if._mth02CA(parcel, 1, activityrecognitionresult.Cs, false);
        int j = activityrecognitionresult.wB;
        _cls141D.if._mth02CB(parcel, 1000, 4);
        parcel.writeInt(j);
        long l = activityrecognitionresult.Ct;
        _cls141D.if._mth02CB(parcel, 2, 8);
        parcel.writeLong(l);
        l = activityrecognitionresult.Cu;
        _cls141D.if._mth02CB(parcel, 3, 8);
        parcel.writeLong(l);
        j = activityrecognitionresult.Cv;
        _cls141D.if._mth02CB(parcel, 4, 4);
        parcel.writeInt(j);
        _cls141D.if._mth141D(parcel, i);
    }

    public static ActivityRecognitionResult _mth02CB(Parcel parcel)
    {
        int k = _cls141D.if._mth02CA(parcel);
        int j = 0;
        java.util.ArrayList arraylist = null;
        long l2 = 0L;
        long l1 = 0L;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = parcel.readInt();
                switch (l & 0xffff)
                {
                case 1: // '\001'
                    arraylist = _cls141D.if._mth02CE(parcel, l, DetectedActivity.CREATOR);
                    break;

                case 1000: 
                    _cls141D.if._mth02CA(parcel, l, 4);
                    j = parcel.readInt();
                    break;

                case 2: // '\002'
                    _cls141D.if._mth02CA(parcel, l, 8);
                    l2 = parcel.readLong();
                    break;

                case 3: // '\003'
                    _cls141D.if._mth02CA(parcel, l, 8);
                    l1 = parcel.readLong();
                    break;

                case 4: // '\004'
                    _cls141D.if._mth02CA(parcel, l, 4);
                    i = parcel.readInt();
                    break;

                default:
                    _cls141D.if._mth02CA(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new ActivityRecognitionResult(j, arraylist, l2, l1, i);
            }
        } while (true);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth02CB(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new ActivityRecognitionResult[i];
    }
}
