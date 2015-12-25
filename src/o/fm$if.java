// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

// Referenced classes of package o:
//            fm, fe, hk, ff, 
//            fb, gm, hl, fj, 
//            fi, bg

public static abstract class if.zznJ extends Binder
    implements fm
{
    static final class if
        implements fm
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final void _mth02BB(bg bg1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (bg1 == null) goto _L2; else goto _L1
_L1:
            bg1 = bg1.asBinder();
_L4:
            parcel.writeStrongBinder(bg1);
            zznJ.transact(1, parcel, parcel1, 0);
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

        public final fe _mth02BC(bg bg1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (bg1 == null) goto _L2; else goto _L1
_L1:
            bg1 = bg1.asBinder();
_L4:
            parcel.writeStrongBinder(bg1);
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            bg1 = fe.if._mth02C9(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return bg1;
            bg1;
            parcel1.recycle();
            parcel.recycle();
            throw bg1;
_L2:
            bg1 = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final fi _mth02BD(bg bg1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (bg1 == null) goto _L2; else goto _L1
_L1:
            bg1 = bg1.asBinder();
_L4:
            parcel.writeStrongBinder(bg1);
            zznJ.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            bg1 = fi.if._mth0640(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return bg1;
            bg1;
            parcel1.recycle();
            parcel.recycle();
            throw bg1;
_L2:
            bg1 = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final ff _mth02CA(bg bg1, GoogleMapOptions googlemapoptions)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (bg1 == null) goto _L2; else goto _L1
_L1:
            bg1 = bg1.asBinder();
_L4:
            parcel.writeStrongBinder(bg1);
            if (googlemapoptions == null)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            parcel.writeInt(1);
            googlemapoptions.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_57;
            parcel.writeInt(0);
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            bg1 = ff.if._mth02CC(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return bg1;
            bg1;
            parcel1.recycle();
            parcel.recycle();
            throw bg1;
_L2:
            bg1 = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final fj _mth02CA(bg bg1, StreetViewPanoramaOptions streetviewpanoramaoptions)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (bg1 == null) goto _L2; else goto _L1
_L1:
            bg1 = bg1.asBinder();
_L4:
            parcel.writeStrongBinder(bg1);
            if (streetviewpanoramaoptions == null)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            parcel.writeInt(1);
            streetviewpanoramaoptions.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_57;
            parcel.writeInt(0);
            zznJ.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            bg1 = fj.if._mth1427(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return bg1;
            bg1;
            parcel1.recycle();
            parcel.recycle();
            throw bg1;
_L2:
            bg1 = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(bg bg1, int i)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (bg1 == null) goto _L2; else goto _L1
_L1:
            bg1 = bg1.asBinder();
_L4:
            parcel.writeStrongBinder(bg1);
            parcel.writeInt(i);
            zznJ.transact(6, parcel, parcel1, 0);
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

        public final fb _mth4EA0()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            fb fb1;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            zznJ.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            fb1 = fb.if._mth02BF(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return fb1;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public final gm _mth51AB()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            gm gm1;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            zznJ.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            gm1 = gm.if._mth0674(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return gm1;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public static fm FF9E(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
        if (iinterface != null && (iinterface instanceof fm))
        {
            return (fm)iinterface;
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
            parcel1.writeString("com.google.android.gms.maps.internal.ICreator");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            _mth02BB(_mth141D(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            parcel = _mth02BC(_mth141D(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel = parcel.asBinder();
            } else
            {
                parcel = null;
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            bg bg = _mth141D(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                hk hk1 = GoogleMapOptions.CREATOR;
                parcel = hk._mth02B9(parcel);
            } else
            {
                parcel = null;
            }
            parcel = _mth02CA(bg, parcel);
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel = parcel.asBinder();
            } else
            {
                parcel = null;
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            parcel = _mth4EA0();
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel = parcel.asBinder();
            } else
            {
                parcel = null;
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            parcel = _mth51AB();
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel = parcel.asBinder();
            } else
            {
                parcel = null;
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            _mth02CA(_mth141D(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            bg bg1 = _mth141D(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                hl hl1 = StreetViewPanoramaOptions.CREATOR;
                parcel = hl._mth0559(parcel);
            } else
            {
                parcel = null;
            }
            parcel = _mth02CA(bg1, parcel);
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel = parcel.asBinder();
            } else
            {
                parcel = null;
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            parcel = _mth02BD(_mth141D(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel = parcel.asBinder();
            } else
            {
                parcel = null;
            }
            parcel1.writeStrongBinder(parcel);
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }
}
