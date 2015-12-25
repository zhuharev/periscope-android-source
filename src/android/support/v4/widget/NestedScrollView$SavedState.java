// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import o.4E00;

// Referenced classes of package android.support.v4.widget:
//            NestedScrollView

public static class _cls03A5 extends android.view.w.SavedState
{

    public static final android.os.iew.SavedState._cls03A5 CREATOR = new _cls4E00();
    public int _fld03A5;

    public String toString()
    {
        return (new StringBuilder("HorizontalScrollView.SavedState{")).append(Integer.toHexString(System.identityHashCode(this))).append(" scrollPosition=").append(_fld03A5).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.arcel(parcel, i);
        parcel.writeInt(_fld03A5);
    }


    public (Parcel parcel)
    {
        super(parcel);
        _fld03A5 = parcel.readInt();
    }

    _cls03A5(Parcelable parcelable)
    {
        super(parcelable);
    }
}
