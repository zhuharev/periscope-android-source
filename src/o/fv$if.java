// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package o:
//            fv, fc

public static abstract class g.String extends Binder
    implements fv
{
    static final class if
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

        if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public static fv _mth02B9(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
        if (iinterface != null && (iinterface instanceof fv))
        {
            return (fv)iinterface;
        } else
        {
            return new if(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        case 1598968902: 
            parcel1.writeString("com.google.android.gms.maps.internal.IOnMapReadyCallback");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
            _mth02CA(_mth02C8(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }

    public g.String()
    {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnMapReadyCallback");
    }
}
