// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import o.de;
import o.df;

public class DetectedActivity
    implements SafeParcelable
{

    public static final df CREATOR = new df();
    public int Cw;
    public int Cx;
    public final int wB;

    public DetectedActivity(int i, int j, int k)
    {
        wB = i;
        Cw = j;
        Cx = k;
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
        obj = (DetectedActivity)obj;
        return Cw == ((DetectedActivity) (obj)).Cw && Cx == ((DetectedActivity) (obj)).Cx;
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(Cw), Integer.valueOf(Cx)
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("DetectedActivity [type=");
        int i = Cw;
        if (i > 15)
        {
            i = 4;
        }
        String s;
        switch (i)
        {
        case 0: // '\0'
            s = "IN_VEHICLE";
            break;

        case 1: // '\001'
            s = "ON_BICYCLE";
            break;

        case 2: // '\002'
            s = "ON_FOOT";
            break;

        case 3: // '\003'
            s = "STILL";
            break;

        case 4: // '\004'
            s = "UNKNOWN";
            break;

        case 5: // '\005'
            s = "TILTING";
            break;

        case 7: // '\007'
            s = "WALKING";
            break;

        case 8: // '\b'
            s = "RUNNING";
            break;

        case 6: // '\006'
        default:
            s = Integer.toString(i);
            break;
        }
        return stringbuilder.append(s).append(", confidence=").append(Cx).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        df._mth02CA(this, parcel);
    }

    static 
    {
        new de();
    }
}
