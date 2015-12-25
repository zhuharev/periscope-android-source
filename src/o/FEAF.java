// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;

public final class FEAF
    implements android.os.Parcelable.Creator
{

    public FEAF()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new android.support.v7.widget.RecyclerView.SavedState(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new android.support.v7.widget.RecyclerView.SavedState[i];
    }
}
