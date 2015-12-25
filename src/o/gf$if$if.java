// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package o:
//            gf, fh

static final class zznJ
    implements gf
{

    private IBinder zznJ;

    public final IBinder asBinder()
    {
        return zznJ;
    }

    public final void _mth02CA(fh fh1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
        if (fh1 == null) goto _L2; else goto _L1
_L1:
        fh1 = fh1.asBinder();
_L4:
        parcel.writeStrongBinder(fh1);
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        fh1;
        parcel1.recycle();
        parcel.recycle();
        throw fh1;
_L2:
        fh1 = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    IBinder(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
