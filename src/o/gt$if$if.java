// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;

// Referenced classes of package o:
//            gt, hh

static final class zznJ
    implements gt
{

    private IBinder zznJ;

    public final IBinder asBinder()
    {
        return zznJ;
    }

    public final Tile _mth1FBE(int i, int j, int k)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        Object obj;
label0:
        {
            parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeInt(k);
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() != 0)
            {
                obj = Tile.CREATOR;
                obj = hh._mth1428(parcel1);
                break label0;
            }
            obj = null;
        }
        parcel1.recycle();
        parcel.recycle();
        return ((Tile) (obj));
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    IBinder(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
