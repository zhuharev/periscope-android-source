// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;

// Referenced classes of package o:
//            hh

public interface gt
    extends IInterface
{
    public static abstract class if extends Binder
        implements gt
    {

        public static gt FE7A(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            if (iinterface != null && (iinterface instanceof gt))
            {
                return (gt)iinterface;
            } else
            {
                return new if(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        {
            switch (i)
            {
            case 1598968902: 
                parcel1.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                parcel = _mth1FBE(parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                } else
                {
                    parcel1.writeInt(0);
                }
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        public if()
        {
            attachInterface(this, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        }
    }

    static final class if.if
        implements gt
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final Tile _mth1FBE(int i, int j, int k)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            Object obj;
label0:
            {
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                zznJ.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if (parcel1.readInt() != 0)
                {
                    obj = Tile.CREATOR;
                    obj = hh._mth1428(parcel1);
                    break label0;
                }
                obj = null;
            }
            parcel1.recycle();
            parcel.recycle();
            return ((Tile) (obj));
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        if.if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract Tile _mth1FBE(int i, int j, int k);
}
