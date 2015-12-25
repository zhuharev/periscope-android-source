// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface el
    extends IInterface
{
    public static abstract class if extends Binder
        implements el
    {

        public static el _mth02BE(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            if (iinterface != null && (iinterface instanceof el))
            {
                return (el)iinterface;
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
                parcel1.writeString("com.google.android.gms.location.ILocationListener");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.location.ILocationListener");
                if (parcel.readInt() != 0)
                {
                    parcel = (Location)Location.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                onLocationChanged(parcel);
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        public if()
        {
            attachInterface(this, "com.google.android.gms.location.ILocationListener");
        }
    }

    static final class if.if
        implements el
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final void onLocationChanged(Location location)
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.ILocationListener");
            if (location == null)
            {
                break MISSING_BLOCK_LABEL_28;
            }
            parcel.writeInt(1);
            location.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_33;
            parcel.writeInt(0);
            zznJ.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            location;
            parcel.recycle();
            throw location;
        }

        if.if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void onLocationChanged(Location location);
}
