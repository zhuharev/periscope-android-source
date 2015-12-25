// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.hh;

public final class Tile
    implements SafeParcelable
{

    public static final hh CREATOR = new hh();
    public final byte data[];
    public final int height;
    public final int wB;
    public final int width;

    public Tile(int i, int j, int k, byte abyte0[])
    {
        wB = i;
        width = j;
        height = k;
        data = abyte0;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        hh._mth02CA(this, parcel);
    }

}
