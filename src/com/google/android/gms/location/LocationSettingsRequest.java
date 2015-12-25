// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import o.en;

public final class LocationSettingsRequest
    implements SafeParcelable
{
    public static final class if
    {

        private boolean CS;
        private boolean CT;
        private boolean CU;
        public final ArrayList CV = new ArrayList();

        public if()
        {
            CS = false;
            CT = false;
            CU = false;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new en();
    public final List CR;
    public final boolean CS;
    public final boolean CT;
    public final boolean CU;
    public final int wB;

    public LocationSettingsRequest(int i, List list, boolean flag, boolean flag1, boolean flag2)
    {
        wB = i;
        CR = list;
        CS = flag;
        CT = flag1;
        CU = flag2;
    }

    public LocationSettingsRequest(ArrayList arraylist, boolean flag, boolean flag1, boolean flag2)
    {
        this(((List) (arraylist)), flag, flag1, flag2);
    }

    private LocationSettingsRequest(List list, boolean flag, boolean flag1, boolean flag2)
    {
        this(2, list, flag, flag1, flag2);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        en._mth02CA(this, parcel);
    }

}
