// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Parcel;

// Referenced classes of package com.google.android.gms.gcm:
//            OneoffTask

final class 
    implements android.os.eator
{

    public final Object createFromParcel(Parcel parcel)
    {
        return zzes(parcel);
    }

    public final Object[] newArray(int i)
    {
        return zzgC(i);
    }

    public final OneoffTask zzes(Parcel parcel)
    {
        return new OneoffTask(parcel, null);
    }

    public final OneoffTask[] zzgC(int i)
    {
        return new OneoffTask[i];
    }

    ()
    {
    }
}
