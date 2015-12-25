// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;

// Referenced classes of package o:
//            hp

public static abstract class g.String extends Binder
    implements hp
{

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        case 1598968902: 
            parcel1.writeString("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
            _mth02CA(parcel.readString(), parcel.createTypedArrayList(Scope.CREATOR), _mth02B3(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
            _mth02CA(parcel.readString(), parcel.readString(), _mth02B3(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }

    public g.String()
    {
        attachInterface(this, "com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
    }
}
