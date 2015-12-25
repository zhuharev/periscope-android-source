// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

// Referenced classes of package o:
//            rv, ra, rl

static final class Rp
    implements IInterface
{

    private final IBinder Rp;

    public final IBinder asBinder()
    {
        return Rp;
    }

    public final String getId()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s;
        parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        Rp.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        s = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s;
_L2:
        ra._mth0454()._mth02BE("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
        parcel1.recycle();
        parcel.recycle();
        return null;
        Object obj;
        obj;
        parcel1.recycle();
        parcel.recycle();
        throw obj;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final boolean _mth0688()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        parcel.writeInt(1);
        Rp.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
_L2:
        ra._mth0454()._mth02BE("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
        parcel1.recycle();
        parcel.recycle();
        return false;
        Object obj;
        obj;
        parcel1.recycle();
        parcel.recycle();
        throw obj;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public .IBinder(IBinder ibinder)
    {
        Rp = ibinder;
    }
}
