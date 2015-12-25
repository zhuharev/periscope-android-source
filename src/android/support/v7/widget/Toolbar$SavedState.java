// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import o.13AB;

// Referenced classes of package android.support.v7.widget:
//            Toolbar

public static class iJ extends android.view.
{

    public static final android.os.bar.SavedState.iJ CREATOR = new _cls13AB();
    int iI;
    boolean iJ;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeInt(iI);
        if (iJ)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }


    public (Parcel parcel)
    {
        super(parcel);
        iI = parcel.readInt();
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        iJ = flag;
    }

    public iJ(Parcelable parcelable)
    {
        super(parcelable);
    }
}
