// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package o:
//            gg, bg

static final class zznJ
    implements gg
{

    private IBinder zznJ;

    public final IBinder asBinder()
    {
        return zznJ;
    }

    public final void _mth02BE(bg bg1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
        if (bg1 == null) goto _L2; else goto _L1
_L1:
        bg1 = bg1.asBinder();
_L4:
        parcel.writeStrongBinder(bg1);
        zznJ.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        bg1;
        parcel1.recycle();
        parcel.recycle();
        throw bg1;
_L2:
        bg1 = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void _mth1FBE(Bitmap bitmap)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        parcel.writeInt(1);
        bitmap.writeToParcel(parcel, 0);
        break MISSING_BLOCK_LABEL_37;
        parcel.writeInt(0);
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        bitmap;
        parcel1.recycle();
        parcel.recycle();
        throw bitmap;
    }

    IBinder(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
