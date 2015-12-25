// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;

// Referenced classes of package o:
//            bo

static final class zznJ
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

    IBinder(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
