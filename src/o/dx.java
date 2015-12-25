// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.location.internal.FusedLocationProviderResult;

public interface dx
    extends IInterface
{
    public static abstract class if extends Binder
        implements dx
    {

        public static dx _mth02BC(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (iinterface != null && (iinterface instanceof dx))
            {
                return (dx)iinterface;
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
                parcel1.writeString("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                if (parcel.readInt() != 0)
                {
                    parcel = (FusedLocationProviderResult)FusedLocationProviderResult.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                _mth02CA(parcel);
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        public if()
        {
            attachInterface(this, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
        }
    }

    static final class if.if
        implements dx
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final void _mth02CA(FusedLocationProviderResult fusedlocationproviderresult)
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (fusedlocationproviderresult == null)
            {
                break MISSING_BLOCK_LABEL_28;
            }
            parcel.writeInt(1);
            fusedlocationproviderresult.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_33;
            parcel.writeInt(0);
            zznJ.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            fusedlocationproviderresult;
            parcel.recycle();
            throw fusedlocationproviderresult;
        }

        if.if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void _mth02CA(FusedLocationProviderResult fusedlocationproviderresult);
}
