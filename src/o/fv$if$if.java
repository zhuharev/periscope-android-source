// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package o:
//            fv, fc

static final class zznJ
    implements fv
{

    private IBinder zznJ;

    public final IBinder asBinder()
    {
        return zznJ;
    }

    public final void _mth02CA(fc fc1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapReadyCallback");
        if (fc1 == null) goto _L2; else goto _L1
_L1:
        fc1 = fc1.asBinder();
_L4:
        parcel.writeStrongBinder(fc1);
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        fc1;
        parcel1.recycle();
        parcel.recycle();
        throw fc1;
_L2:
        fc1 = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    IBinder(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
