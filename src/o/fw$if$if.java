// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package o:
//            fw, gq

static final class zznJ
    implements fw
{

    private IBinder zznJ;

    public final IBinder asBinder()
    {
        return zznJ;
    }

    public final boolean _mth02CA(gq gq1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerClickListener");
        if (gq1 == null) goto _L2; else goto _L1
_L1:
        gq1 = gq1.asBinder();
_L4:
        int i;
        parcel.writeStrongBinder(gq1);
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        gq1;
        parcel1.recycle();
        parcel.recycle();
        throw gq1;
_L2:
        gq1 = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    IBinder(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
