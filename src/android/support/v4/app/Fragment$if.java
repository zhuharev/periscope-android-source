// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package android.support.v4.app:
//            Fragment

public static class ion extends RuntimeException
{

    public ion(RemoteException remoteexception)
    {
        super(remoteexception);
    }

    public ion(String s)
    {
        super(s);
    }

    public ion(String s, Parcel parcel)
    {
        super((new StringBuilder()).append(s).append(" Parcel: pos=").append(parcel.dataPosition()).append(" size=").append(parcel.dataSize()).toString());
    }

    public ion(String s, ReflectiveOperationException reflectiveoperationexception)
    {
        super(s, reflectiveoperationexception);
    }
}
