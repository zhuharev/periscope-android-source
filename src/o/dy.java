// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface dy
    extends IInterface
{
    public static abstract class if extends Binder
        implements dy
    {

        public static dy _mth02BD(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            if (iinterface != null && (iinterface instanceof dy))
            {
                return (dy)iinterface;
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
                parcel1.writeString("com.google.android.gms.location.internal.IGeofencerCallbacks");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                _mth02CA(parcel.readInt(), parcel.createStringArray());
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                _mth02CB(parcel.readInt(), parcel.createStringArray());
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                i = parcel.readInt();
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                _mth02CA(i, parcel);
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        public if()
        {
            attachInterface(this, "com.google.android.gms.location.internal.IGeofencerCallbacks");
        }
    }

    static final class if.if
        implements dy
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final void _mth02CA(int i, PendingIntent pendingintent)
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            parcel.writeInt(i);
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_38;
            parcel.writeInt(0);
            zznJ.transact(3, parcel, null, 1);
            parcel.recycle();
            return;
            pendingintent;
            parcel.recycle();
            throw pendingintent;
        }

        public final void _mth02CA(int i, String as[])
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            parcel.writeInt(i);
            parcel.writeStringArray(as);
            zznJ.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            as;
            parcel.recycle();
            throw as;
        }

        public final void _mth02CB(int i, String as[])
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            parcel.writeInt(i);
            parcel.writeStringArray(as);
            zznJ.transact(2, parcel, null, 1);
            parcel.recycle();
            return;
            as;
            parcel.recycle();
            throw as;
        }

        if.if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void _mth02CA(int i, PendingIntent pendingintent);

    public abstract void _mth02CA(int i, String as[]);

    public abstract void _mth02CB(int i, String as[]);
}
