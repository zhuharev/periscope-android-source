// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

// Referenced classes of package o:
//            ek, di

public static abstract class g.String extends Binder
    implements ek
{
    static final class if
        implements ek
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final void _mth02CA(LocationAvailability locationavailability)
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
            if (locationavailability == null)
            {
                break MISSING_BLOCK_LABEL_28;
            }
            parcel.writeInt(1);
            locationavailability.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_33;
            parcel.writeInt(0);
            zznJ.transact(2, parcel, null, 1);
            parcel.recycle();
            return;
            locationavailability;
            parcel.recycle();
            throw locationavailability;
        }

        public final void _mth02CA(LocationResult locationresult)
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
            if (locationresult == null)
            {
                break MISSING_BLOCK_LABEL_28;
            }
            parcel.writeInt(1);
            locationresult.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_33;
            parcel.writeInt(0);
            zznJ.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            locationresult;
            parcel.recycle();
            throw locationresult;
        }

        if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public static ek _mth1FBE(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        if (iinterface != null && (iinterface instanceof ek))
        {
            return (ek)iinterface;
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
            parcel1.writeString("com.google.android.gms.location.ILocationCallback");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.location.ILocationCallback");
            if (parcel.readInt() != 0)
            {
                parcel = (LocationResult)LocationResult.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            _mth02CA(parcel);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.location.ILocationCallback");
            if (parcel.readInt() != 0)
            {
                parcel1 = LocationAvailability.CREATOR;
                parcel = di._mth02CE(parcel);
            } else
            {
                parcel = null;
            }
            _mth02CA(parcel);
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }

    public g.String()
    {
        attachInterface(this, "com.google.android.gms.location.ILocationCallback");
    }
}
