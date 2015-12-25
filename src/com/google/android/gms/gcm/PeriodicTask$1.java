// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Parcel;

// Referenced classes of package com.google.android.gms.gcm:
//            PeriodicTask

final class 
    implements android.os.tor
{

    public final Object createFromParcel(Parcel parcel)
    {
        return zzeu(parcel);
    }

    public final Object[] newArray(int i)
    {
        return zzgE(i);
    }

    public final PeriodicTask zzeu(Parcel parcel)
    {
        return new PeriodicTask(parcel, null);
    }

    public final PeriodicTask[] zzgE(int i)
    {
        return new PeriodicTask[i];
    }

    ()
    {
    }
}
