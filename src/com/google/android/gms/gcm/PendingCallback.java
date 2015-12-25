// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public class PendingCallback
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    final IBinder zzaeJ;

    public PendingCallback(Parcel parcel)
    {
        zzaeJ = parcel.readStrongBinder();
    }

    public int describeContents()
    {
        return 0;
    }

    public IBinder getIBinder()
    {
        return zzaeJ;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeStrongBinder(zzaeJ);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final Object createFromParcel(Parcel parcel)
        {
            return zzet(parcel);
        }

        public final Object[] newArray(int i)
        {
            return zzgD(i);
        }

        public final PendingCallback zzet(Parcel parcel)
        {
            return new PendingCallback(parcel);
        }

        public final PendingCallback[] zzgD(int i)
        {
            return new PendingCallback[i];
        }

        _cls1()
        {
        }
    }

}
