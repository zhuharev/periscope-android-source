// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package o:
//            bg

public static abstract class g.String extends Binder
    implements bg
{
    static final class if
        implements bg
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public static bg _mth141D(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        if (iinterface != null && (iinterface instanceof bg))
        {
            return (bg)iinterface;
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
            parcel1.writeString("com.google.android.gms.dynamic.IObjectWrapper");
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }

    public g.String()
    {
        attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
    }
}
