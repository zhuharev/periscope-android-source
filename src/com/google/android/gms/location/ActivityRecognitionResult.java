// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o.dd;

public class ActivityRecognitionResult
    implements SafeParcelable
{

    public static final dd CREATOR = new dd();
    public List Cs;
    public long Ct;
    public long Cu;
    public int Cv;
    public final int wB;

    public ActivityRecognitionResult(int i, ArrayList arraylist, long l, long l1, int j)
    {
        wB = i;
        Cs = arraylist;
        Ct = l;
        Cu = l1;
        Cv = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        Object obj1 = (ActivityRecognitionResult)obj;
        if (Ct == ((ActivityRecognitionResult) (obj1)).Ct && Cu == ((ActivityRecognitionResult) (obj1)).Cu && Cv == ((ActivityRecognitionResult) (obj1)).Cv)
        {
            obj = Cs;
            obj1 = ((ActivityRecognitionResult) (obj1)).Cs;
            boolean flag;
            if (obj == obj1 || obj != null && obj.equals(obj1))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Long.valueOf(Ct), Long.valueOf(Cu), Integer.valueOf(Cv), Cs
        });
    }

    public String toString()
    {
        return (new StringBuilder("ActivityRecognitionResult [probableActivities=")).append(Cs).append(", timeMillis=").append(Ct).append(", elapsedRealtimeMillis=").append(Cu).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        dd._mth02CA(this, parcel);
    }

}
