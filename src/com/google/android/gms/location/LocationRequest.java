// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import o.dk;

public final class LocationRequest
    implements SafeParcelable
{

    public static final dk CREATOR = new dk();
    public long CF;
    public long CG;
    public boolean CH;
    public long CI;
    public int CJ;
    public float CK;
    public long CL;
    public int mPriority;
    public final int wB;

    public LocationRequest()
    {
        wB = 1;
        mPriority = 102;
        CF = 0x36ee80L;
        CG = 0x927c0L;
        CH = false;
        CI = 0x7fffffffffffffffL;
        CJ = 0x7fffffff;
        CK = 0.0F;
        CL = 0L;
    }

    public LocationRequest(int i, int j, long l, long l1, boolean flag, 
            long l2, int k, float f, long l3)
    {
        wB = i;
        mPriority = j;
        CF = l;
        CG = l1;
        CH = flag;
        CI = l2;
        CJ = k;
        CK = f;
        CL = l3;
    }

    public static void _mth1FBE(long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid interval: ")).append(l).toString());
        } else
        {
            return;
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof LocationRequest))
        {
            return false;
        }
        obj = (LocationRequest)obj;
        return mPriority == ((LocationRequest) (obj)).mPriority && CF == ((LocationRequest) (obj)).CF && CG == ((LocationRequest) (obj)).CG && CH == ((LocationRequest) (obj)).CH && CI == ((LocationRequest) (obj)).CI && CJ == ((LocationRequest) (obj)).CJ && CK == ((LocationRequest) (obj)).CK;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(mPriority), Long.valueOf(CF), Long.valueOf(CG), Boolean.valueOf(CH), Long.valueOf(CI), Integer.valueOf(CJ), Float.valueOf(CK)
        });
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StringBuilder stringbuilder1 = stringbuilder.append("Request[");
        String s;
        switch (mPriority)
        {
        case 100: // 'd'
            s = "PRIORITY_HIGH_ACCURACY";
            break;

        case 102: // 'f'
            s = "PRIORITY_BALANCED_POWER_ACCURACY";
            break;

        case 104: // 'h'
            s = "PRIORITY_LOW_POWER";
            break;

        case 105: // 'i'
            s = "PRIORITY_NO_POWER";
            break;

        case 101: // 'e'
        case 103: // 'g'
        default:
            s = "???";
            break;
        }
        stringbuilder1.append(s);
        if (mPriority != 105)
        {
            stringbuilder.append(" requested=");
            stringbuilder.append(CF).append("ms");
        }
        stringbuilder.append(" fastest=");
        stringbuilder.append(CG).append("ms");
        if (CL > CF)
        {
            stringbuilder.append(" maxWait=");
            stringbuilder.append(CL).append("ms");
        }
        if (CI != 0x7fffffffffffffffL)
        {
            long l = CI;
            long l1 = SystemClock.elapsedRealtime();
            stringbuilder.append(" expireIn=");
            stringbuilder.append(l - l1).append("ms");
        }
        if (CJ != 0x7fffffff)
        {
            stringbuilder.append(" num=").append(CJ);
        }
        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        dk._mth02CA(this, parcel);
    }

}
