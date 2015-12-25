// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package o:
//            ft

public static abstract class g.String extends Binder
    implements ft
{
    static final class if
        implements ft
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final void FB83()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        case 1598968902: 
            parcel1.writeString("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
            FB83();
            parcel1.writeNoException();
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }

    public g.String()
    {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnMapLoadedCallback");
    }
}
