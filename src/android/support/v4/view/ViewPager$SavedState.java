// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import o.1483;
import o.FE78;

// Referenced classes of package android.support.v4.view:
//            ViewPager

public static class FF4A extends android.view.SavedState
{

    public static final android.os.r.SavedState.FEAD CREATOR = FE78._mth02CA(new _cls1483());
    int position;
    Parcelable FEAD;
    ClassLoader FF4A;

    public String toString()
    {
        return (new StringBuilder("FragmentPager.SavedState{")).append(Integer.toHexString(System.identityHashCode(this))).append(" position=").append(position).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.riteToParcel(parcel, i);
        parcel.writeInt(position);
        parcel.writeParcelable(FEAD, i);
    }


    public (Parcel parcel, ClassLoader classloader)
    {
        super(parcel);
        ClassLoader classloader1 = classloader;
        if (classloader == null)
        {
            classloader1 = getClass().getClassLoader();
        }
        position = parcel.readInt();
        FEAD = parcel.readParcelable(classloader1);
        FF4A = classloader1;
    }

    public FF4A(Parcelable parcelable)
    {
        super(parcelable);
    }
}
