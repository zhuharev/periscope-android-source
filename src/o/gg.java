// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

// Referenced classes of package o:
//            bg

public interface gg
    extends IInterface
{
    public static abstract class if extends Binder
        implements gg
    {

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        {
            switch (i)
            {
            case 1598968902: 
                parcel1.writeString("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                if (parcel.readInt() != 0)
                {
                    parcel = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                _mth1FBE(parcel);
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                _mth02BE(bg.if._mth141D(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        public if()
        {
            attachInterface(this, "com.google.android.gms.maps.internal.ISnapshotReadyCallback");
        }
    }

    static final class if.if
        implements gg
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final void _mth02BE(bg bg1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            if (bg1 == null) goto _L2; else goto _L1
_L1:
            bg1 = bg1.asBinder();
_L4:
            parcel.writeStrongBinder(bg1);
            zznJ.transact(2, parcel, parcel1, 0);
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

        public final void _mth1FBE(Bitmap bitmap)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            if (bitmap == null)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            parcel.writeInt(1);
            bitmap.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_37;
            parcel.writeInt(0);
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            bitmap;
            parcel1.recycle();
            parcel.recycle();
            throw bitmap;
        }

        if.if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void _mth02BE(bg bg);

    public abstract void _mth1FBE(Bitmap bitmap);
}
