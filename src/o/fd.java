// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

// Referenced classes of package o:
//            fr

public interface fd
    extends IInterface
{
    public static abstract class if extends Binder
        implements fd
    {

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        {
            switch (i)
            {
            case 1598968902: 
                parcel1.writeString("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                parcel = parcel.readStrongBinder();
                if (parcel == null)
                {
                    parcel = null;
                } else
                {
                    IInterface iinterface = parcel.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    if (iinterface != null && (iinterface instanceof fr))
                    {
                        parcel = (fr)iinterface;
                    } else
                    {
                        parcel = new fr.if.if(parcel);
                    }
                }
                _mth02CA(parcel);
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                deactivate();
                parcel1.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        public if()
        {
            attachInterface(this, "com.google.android.gms.maps.internal.ILocationSourceDelegate");
        }
    }

    static final class if.if
        implements fd
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final void deactivate()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            zznJ.transact(2, parcel, parcel1, 0);
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

        public final void _mth02CA(fr fr1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            if (fr1 == null) goto _L2; else goto _L1
_L1:
            fr1 = fr1.asBinder();
_L4:
            parcel.writeStrongBinder(fr1);
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fr1;
            parcel1.recycle();
            parcel.recycle();
            throw fr1;
_L2:
            fr1 = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        if.if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void deactivate();

    public abstract void _mth02CA(fr fr);
}
