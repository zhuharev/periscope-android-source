// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.CameraPosition;

// Referenced classes of package o:
//            gu

public interface fo
    extends IInterface
{
    public static abstract class if extends Binder
        implements fo
    {

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        {
            switch (i)
            {
            case 1598968902: 
                parcel1.writeString("com.google.android.gms.maps.internal.IOnCameraChangeListener");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IOnCameraChangeListener");
                if (parcel.readInt() != 0)
                {
                    gu gu1 = CameraPosition.CREATOR;
                    parcel = gu._mth02BD(parcel);
                } else
                {
                    parcel = null;
                }
                _mth02CA(parcel);
                parcel1.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        public if()
        {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnCameraChangeListener");
        }
    }

    static final class if.if
        implements fo
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final void _mth02CA(CameraPosition cameraposition)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnCameraChangeListener");
            if (cameraposition == null)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            parcel.writeInt(1);
            cameraposition.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_37;
            parcel.writeInt(0);
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            cameraposition;
            parcel1.recycle();
            parcel.recycle();
            throw cameraposition;
        }

        if.if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void _mth02CA(CameraPosition cameraposition);
}
