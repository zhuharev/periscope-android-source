// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import o.FEAF;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static class eY extends android.view.w.SavedState
{

    public static final android.os.iew.SavedState.eY CREATOR = new FEAF();
    Parcelable eY;

    static void _mth02CA(eY ey, eY ey1)
    {
        ey.eY = ey1.eY;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.eToParcel(parcel, i);
        parcel.writeParcelable(eY, 0);
    }


    public (Parcel parcel)
    {
        super(parcel);
        eY = parcel.readParcelable(android/support/v7/widget/RecyclerView$02BB.getClassLoader());
    }

    eY(Parcelable parcelable)
    {
        super(parcelable);
    }
}
