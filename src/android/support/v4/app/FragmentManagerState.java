// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import o.0674;

// Referenced classes of package android.support.v4.app:
//            FragmentState, BackStackState

public final class FragmentManagerState
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls0674();
    public FragmentState _fld02C0[];
    public int _fld02C1[];
    public BackStackState _fld02E2[];

    public FragmentManagerState()
    {
    }

    public FragmentManagerState(Parcel parcel)
    {
        _fld02C0 = (FragmentState[])parcel.createTypedArray(FragmentState.CREATOR);
        _fld02C1 = parcel.createIntArray();
        _fld02E2 = (BackStackState[])parcel.createTypedArray(BackStackState.CREATOR);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeTypedArray(_fld02C0, i);
        parcel.writeIntArray(_fld02C1);
        parcel.writeTypedArray(_fld02E2, i);
    }

}
