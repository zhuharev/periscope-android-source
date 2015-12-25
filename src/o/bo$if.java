// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;

// Referenced classes of package o:
//            bo

public static abstract class g.String extends Binder
    implements bo
{
    static final class if
        implements bo
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final void send(Message message)
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            if (message == null)
            {
                break MISSING_BLOCK_LABEL_28;
            }
            parcel.writeInt(1);
            message.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_33;
            parcel.writeInt(0);
            zznJ.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            message;
            parcel.recycle();
            throw message;
        }

        if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public static bo _mth02BB(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
        if (iinterface != null && (iinterface instanceof bo))
        {
            return (bo)iinterface;
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
            parcel1.writeString("com.google.android.gms.iid.IMessengerCompat");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.iid.IMessengerCompat");
            if (parcel.readInt() != 0)
            {
                parcel = (Message)Message.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            send(parcel);
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }

    public g.String()
    {
        attachInterface(this, "com.google.android.gms.iid.IMessengerCompat");
    }
}
