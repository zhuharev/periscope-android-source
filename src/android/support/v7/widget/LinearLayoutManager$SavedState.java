// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import o.1D69;

// Referenced classes of package android.support.v7.widget:
//            LinearLayoutManager

public static class cq
    implements Parcelable
{

    public static final android.os.ger.SavedState.cq CREATOR = new _cls1D69();
    int co;
    int cp;
    boolean cq;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(co);
        parcel.writeInt(cp);
        if (cq)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }


    public ()
    {
    }

    public (Parcel parcel)
    {
        co = parcel.readInt();
        cp = parcel.readInt();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cq = flag;
    }

    public cq(cq cq1)
    {
        co = cq1.co;
        cp = cq1.cp;
        cq = cq1.cq;
    }
}
