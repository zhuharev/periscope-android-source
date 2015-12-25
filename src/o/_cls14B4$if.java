// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package o:
//            _cls14B4

public static abstract class .Parcel extends Binder
    implements _cls14B4
{
    /* member class not found */
    class if {}


    public static _cls14B4 _mth02CB(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        if (iinterface != null && (iinterface instanceof _cls14B4))
        {
            return (_cls14B4)iinterface;
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
            parcel1.writeString("com.google.android.gms.common.internal.IAccountAccessor");
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.common.internal.IAccountAccessor");
            parcel = _mth0393();
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
}
