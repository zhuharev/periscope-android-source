// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package o:
//            fz, bg

static final class zznJ
    implements fz
{

    private IBinder zznJ;

    public final IBinder asBinder()
    {
        return zznJ;
    }

    public final void _mth1FBE(bg bg1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
        if (bg1 == null) goto _L2; else goto _L1
_L1:
        bg1 = bg1.asBinder();
_L4:
        parcel.writeStrongBinder(bg1);
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        bg1;
        parcel1.recycle();
        parcel.recycle();
        throw bg1;
_L2:
        bg1 = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    IBinder(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
