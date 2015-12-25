// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import o.02C8;

// Referenced classes of package android.support.v4.app:
//            Fragment

public static class _cls1D63
    implements Parcelable
{

    public static final android.os..SavedState._cls1D63 CREATOR = new _cls02C8();
    final Bundle _fld1D63;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeBundle(_fld1D63);
    }


    public (Parcel parcel, ClassLoader classloader)
    {
        _fld1D63 = parcel.readBundle();
    }
}
