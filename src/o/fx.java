// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

// Referenced classes of package o:
//            gq

public interface fx
    extends IInterface
{
    public static abstract class if extends Binder
        implements fx
    {

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        {
            switch (i)
            {
            case 1598968902: 
                parcel1.writeString("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                _mth141D(gq.if._mth1D62(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                _mth02BB(gq.if._mth1D62(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                _mth02BC(gq.if._mth1D62(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        public if()
        {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerDragListener");
        }
    }

    static final class if.if
        implements fx
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final void _mth02BB(gq gq1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            if (gq1 == null) goto _L2; else goto _L1
_L1:
            gq1 = gq1.asBinder();
_L4:
            parcel.writeStrongBinder(gq1);
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            gq1;
            parcel1.recycle();
            parcel.recycle();
            throw gq1;
_L2:
            gq1 = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02BC(gq gq1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            if (gq1 == null) goto _L2; else goto _L1
_L1:
            gq1 = gq1.asBinder();
_L4:
            parcel.writeStrongBinder(gq1);
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            gq1;
            parcel1.recycle();
            parcel.recycle();
            throw gq1;
_L2:
            gq1 = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth141D(gq gq1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            if (gq1 == null) goto _L2; else goto _L1
_L1:
            gq1 = gq1.asBinder();
_L4:
            parcel.writeStrongBinder(gq1);
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            gq1;
            parcel1.recycle();
            parcel.recycle();
            throw gq1;
_L2:
            gq1 = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        if.if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void _mth02BB(gq gq);

    public abstract void _mth02BC(gq gq);

    public abstract void _mth141D(gq gq);
}
