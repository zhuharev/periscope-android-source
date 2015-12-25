// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.ResolveAccountResponse;

// Referenced classes of package o:
//            _cls14D9

public static abstract class String extends Binder
    implements _cls14D9
{
    /* member class not found */
    class if {}


    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        case 1598968902: 
            parcel1.writeString("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            if (parcel.readInt() != 0)
            {
                parcel = (ResolveAccountResponse)ResolveAccountResponse.CREATOR.createFromParcel(parcel);
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

    public String()
    {
        attachInterface(this, "com.google.android.gms.common.internal.IResolveAccountCallbacks");
    }
}
