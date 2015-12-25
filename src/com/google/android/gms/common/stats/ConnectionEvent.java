// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.stats;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.15AA;
import o.15C1;

public final class ConnectionEvent extends _cls15C1
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls15AA();
    public final int wB;
    public final long yF;
    public int yG;
    public final String yH;
    public final String yI;
    public final String yJ;
    public final String yK;
    public final String yL;
    public final String yM;
    public final long yN;
    public final long yO;
    private long yP;

    public ConnectionEvent(int i, long l, int j, String s, String s1, String s2, 
            String s3, String s4, String s5, long l1, long l2)
    {
        wB = i;
        yF = l;
        yG = j;
        yH = s;
        yI = s1;
        yJ = s2;
        yK = s3;
        yP = -1L;
        yL = s4;
        yM = s5;
        yN = l1;
        yO = l2;
    }

    public ConnectionEvent(long l, int i, String s, String s1, String s2, String s3, 
            String s4, String s5, long l1, long l2)
    {
        this(1, l, i, s, s1, s2, s3, s4, s5, l1, l2);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final int getEventType()
    {
        return yG;
    }

    public final long getTimeMillis()
    {
        return yF;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        _cls15AA._mth02CA(this, parcel);
    }

    public final long _mth10D8()
    {
        return yP;
    }

    public final String _mth13B0()
    {
        StringBuilder stringbuilder = (new StringBuilder("\t")).append(yH).append("/").append(yI).append("\t").append(yJ).append("/").append(yK).append("\t");
        String s;
        if (yL == null)
        {
            s = "";
        } else
        {
            s = yL;
        }
        return stringbuilder.append(s).append("\t").append(yO).toString();
    }

}
