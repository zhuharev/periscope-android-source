// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.LocationRequestUpdateData;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;

// Referenced classes of package o:
//            dy, el, ea, ej, 
//            dk, ed, ee, dd, 
//            di

public interface dz
    extends IInterface
{
    public static abstract class if extends Binder
        implements dz
    {

        public static dz _mth037A(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (iinterface != null && (iinterface instanceof dz))
            {
                return (dz)iinterface;
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
                parcel1.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                ArrayList arraylist = parcel.createTypedArrayList(ParcelableGeofence.CREATOR);
                PendingIntent pendingintent;
                if (parcel.readInt() != 0)
                {
                    pendingintent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    pendingintent = null;
                }
                _mth02CA(arraylist, pendingintent, dy.if._mth02BD(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 57: // '9'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                GeofencingRequest geofencingrequest;
                if (parcel.readInt() != 0)
                {
                    geofencingrequest = (GeofencingRequest)GeofencingRequest.CREATOR.createFromParcel(parcel);
                } else
                {
                    geofencingrequest = null;
                }
                PendingIntent pendingintent2;
                if (parcel.readInt() != 0)
                {
                    pendingintent2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    pendingintent2 = null;
                }
                _mth02CA(geofencingrequest, pendingintent2, dy.if._mth02BD(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                PendingIntent pendingintent1;
                if (parcel.readInt() != 0)
                {
                    pendingintent1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    pendingintent1 = null;
                }
                _mth02CA(pendingintent1, dy.if._mth02BD(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                _mth02CA(parcel.createStringArray(), dy.if._mth02BD(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                _mth02CA(dy.if._mth02BD(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                long l = parcel.readLong();
                boolean flag;
                if (parcel.readInt() != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                _mth02CA(l, flag, parcel);
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                _mth02CE(parcel);
                parcel1.writeNoException();
                return true;

            case 64: // '@'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel = _mth06E5(parcel.readString());
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

            case 65: // 'A'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                parcel = _mth02CF(parcel);
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

            case 66: // 'B'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                parcel = _mth141D(parcel);
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

            case 60: // '<'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                Object obj;
                if (parcel.readInt() != 0)
                {
                    obj = GestureRequest.CREATOR;
                    obj = ej._mth02BC(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                parcel = _mth02CA(((GestureRequest) (obj)), parcel);
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

            case 61: // '='
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                parcel = _mth02BB(parcel);
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

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel = _mth03DB();
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

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                Object obj1;
                if (parcel.readInt() != 0)
                {
                    obj1 = LocationRequest.CREATOR;
                    obj1 = dk._mth02CF(parcel);
                } else
                {
                    obj1 = null;
                }
                _mth02CA(((LocationRequest) (obj1)), el.if._mth02BE(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 20: // '\024'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                Object obj2;
                if (parcel.readInt() != 0)
                {
                    obj2 = LocationRequest.CREATOR;
                    obj2 = dk._mth02CF(parcel);
                } else
                {
                    obj2 = null;
                }
                _mth02CA(((LocationRequest) (obj2)), el.if._mth02BE(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                Object obj3;
                if (parcel.readInt() != 0)
                {
                    obj3 = LocationRequest.CREATOR;
                    obj3 = dk._mth02CF(parcel);
                } else
                {
                    obj3 = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                _mth02CA(((LocationRequest) (obj3)), parcel);
                parcel1.writeNoException();
                return true;

            case 52: // '4'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                Object obj4;
                if (parcel.readInt() != 0)
                {
                    obj4 = LocationRequestInternal.CREATOR;
                    obj4 = ed._mth141D(parcel);
                } else
                {
                    obj4 = null;
                }
                _mth02CA(((LocationRequestInternal) (obj4)), el.if._mth02BE(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 53: // '5'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                Object obj5;
                if (parcel.readInt() != 0)
                {
                    obj5 = LocationRequestInternal.CREATOR;
                    obj5 = ed._mth141D(parcel);
                } else
                {
                    obj5 = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                _mth02CA(((LocationRequestInternal) (obj5)), parcel);
                parcel1.writeNoException();
                return true;

            case 10: // '\n'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                _mth02CA(el.if._mth02BE(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 11: // '\013'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                _mth02BC(parcel);
                parcel1.writeNoException();
                return true;

            case 59: // ';'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    ee ee1 = LocationRequestUpdateData.CREATOR;
                    parcel = ee._mth02BB(parcel);
                } else
                {
                    parcel = null;
                }
                _mth02CA(parcel);
                parcel1.writeNoException();
                return true;

            case 12: // '\f'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                boolean flag1;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                _mth02EE(flag1);
                parcel1.writeNoException();
                return true;

            case 13: // '\r'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    parcel = (Location)Location.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                _mth02CB(parcel);
                parcel1.writeNoException();
                return true;

            case 21: // '\025'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel = _mth1420(parcel.readString());
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

            case 26: // '\032'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                Location location;
                if (parcel.readInt() != 0)
                {
                    location = (Location)Location.CREATOR.createFromParcel(parcel);
                } else
                {
                    location = null;
                }
                _mth02CA(location, parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 34: // '"'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel = _mth1423(parcel.readString());
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

            case 63: // '?'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                LocationSettingsRequest locationsettingsrequest;
                if (parcel.readInt() != 0)
                {
                    locationsettingsrequest = (LocationSettingsRequest)LocationSettingsRequest.CREATOR.createFromParcel(parcel);
                } else
                {
                    locationsettingsrequest = null;
                }
                Object obj6 = parcel.readStrongBinder();
                if (obj6 == null)
                {
                    obj6 = null;
                } else
                {
                    IInterface iinterface = ((IBinder) (obj6)).queryLocalInterface("com.google.android.gms.location.internal.ISettingsCallbacks");
                    if (iinterface != null && (iinterface instanceof ea))
                    {
                        obj6 = (ea)iinterface;
                    } else
                    {
                        obj6 = new ea.if.if(((IBinder) (obj6)));
                    }
                }
                _mth02CA(locationsettingsrequest, ((ea) (obj6)), parcel.readString());
                parcel1.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }
    }

    static final class if.if
        implements dz
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final Status _mth02BB(PendingIntent pendingintent)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_37;
            parcel.writeInt(0);
            zznJ.transact(61, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() != 0)
            {
                pendingintent = (Status)Status.CREATOR.createFromParcel(parcel1);
                break MISSING_BLOCK_LABEL_81;
            }
            pendingintent = null;
            parcel1.recycle();
            parcel.recycle();
            return pendingintent;
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
        }

        public final void _mth02BC(PendingIntent pendingintent)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_37;
            parcel.writeInt(0);
            zznJ.transact(11, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
        }

        public final Status _mth02CA(GestureRequest gesturerequest, PendingIntent pendingintent)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (gesturerequest == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            parcel.writeInt(1);
            gesturerequest.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_38;
            parcel.writeInt(0);
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_61;
            parcel.writeInt(0);
            zznJ.transact(60, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() != 0)
            {
                gesturerequest = (Status)Status.CREATOR.createFromParcel(parcel1);
                break MISSING_BLOCK_LABEL_109;
            }
            gesturerequest = null;
            parcel1.recycle();
            parcel.recycle();
            return gesturerequest;
            gesturerequest;
            parcel1.recycle();
            parcel.recycle();
            throw gesturerequest;
        }

        public final void _mth02CA(long l, boolean flag, PendingIntent pendingintent)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeLong(l);
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_62;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_68;
            parcel.writeInt(0);
            zznJ.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
        }

        public final void _mth02CA(PendingIntent pendingintent, dy dy1, String s)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_37;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_43;
            parcel.writeInt(0);
            if (dy1 == null) goto _L2; else goto _L1
_L1:
            pendingintent = dy1.asBinder();
_L4:
            parcel.writeStrongBinder(pendingintent);
            parcel.writeString(s);
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
_L2:
            pendingintent = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(Location location, int i)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (location == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            parcel.writeInt(1);
            location.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_38;
            parcel.writeInt(0);
            parcel.writeInt(i);
            zznJ.transact(26, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            location;
            parcel1.recycle();
            parcel.recycle();
            throw location;
        }

        public final void _mth02CA(GeofencingRequest geofencingrequest, PendingIntent pendingintent, dy dy1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (geofencingrequest == null)
            {
                break MISSING_BLOCK_LABEL_37;
            }
            parcel.writeInt(1);
            geofencingrequest.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_43;
            parcel.writeInt(0);
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_63;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_69;
            parcel.writeInt(0);
            if (dy1 == null) goto _L2; else goto _L1
_L1:
            geofencingrequest = dy1.asBinder();
_L4:
            parcel.writeStrongBinder(geofencingrequest);
            zznJ.transact(57, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            geofencingrequest;
            parcel1.recycle();
            parcel.recycle();
            throw geofencingrequest;
_L2:
            geofencingrequest = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(LocationRequest locationrequest, PendingIntent pendingintent)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequest == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            parcel.writeInt(1);
            locationrequest.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_38;
            parcel.writeInt(0);
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_61;
            parcel.writeInt(0);
            zznJ.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            locationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequest;
        }

        public final void _mth02CA(LocationRequest locationrequest, el el1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequest == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            parcel.writeInt(1);
            locationrequest.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_38;
            parcel.writeInt(0);
            if (el1 == null) goto _L2; else goto _L1
_L1:
            locationrequest = el1.asBinder();
_L4:
            parcel.writeStrongBinder(locationrequest);
            zznJ.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            locationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequest;
_L2:
            locationrequest = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(LocationRequest locationrequest, el el1, String s)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequest == null)
            {
                break MISSING_BLOCK_LABEL_37;
            }
            parcel.writeInt(1);
            locationrequest.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_43;
            parcel.writeInt(0);
            if (el1 == null) goto _L2; else goto _L1
_L1:
            locationrequest = el1.asBinder();
_L4:
            parcel.writeStrongBinder(locationrequest);
            parcel.writeString(s);
            zznJ.transact(20, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            locationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequest;
_L2:
            locationrequest = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(LocationSettingsRequest locationsettingsrequest, ea ea1, String s)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationsettingsrequest == null)
            {
                break MISSING_BLOCK_LABEL_37;
            }
            parcel.writeInt(1);
            locationsettingsrequest.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_43;
            parcel.writeInt(0);
            if (ea1 == null) goto _L2; else goto _L1
_L1:
            locationsettingsrequest = ea1.asBinder();
_L4:
            parcel.writeStrongBinder(locationsettingsrequest);
            parcel.writeString(s);
            zznJ.transact(63, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            locationsettingsrequest;
            parcel1.recycle();
            parcel.recycle();
            throw locationsettingsrequest;
_L2:
            locationsettingsrequest = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(LocationRequestInternal locationrequestinternal, PendingIntent pendingintent)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequestinternal == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            parcel.writeInt(1);
            locationrequestinternal.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_38;
            parcel.writeInt(0);
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_61;
            parcel.writeInt(0);
            zznJ.transact(53, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            locationrequestinternal;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequestinternal;
        }

        public final void _mth02CA(LocationRequestInternal locationrequestinternal, el el1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequestinternal == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            parcel.writeInt(1);
            locationrequestinternal.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_38;
            parcel.writeInt(0);
            if (el1 == null) goto _L2; else goto _L1
_L1:
            locationrequestinternal = el1.asBinder();
_L4:
            parcel.writeStrongBinder(locationrequestinternal);
            zznJ.transact(52, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            locationrequestinternal;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequestinternal;
_L2:
            locationrequestinternal = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(LocationRequestUpdateData locationrequestupdatedata)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequestupdatedata == null)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            parcel.writeInt(1);
            locationrequestupdatedata.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_37;
            parcel.writeInt(0);
            zznJ.transact(59, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            locationrequestupdatedata;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequestupdatedata;
        }

        public final void _mth02CA(ArrayList arraylist, PendingIntent pendingintent, dy dy1, String s)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeTypedList(arraylist);
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_43;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_49;
            parcel.writeInt(0);
            if (dy1 == null) goto _L2; else goto _L1
_L1:
            arraylist = dy1.asBinder();
_L4:
            parcel.writeStrongBinder(arraylist);
            parcel.writeString(s);
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            arraylist;
            parcel1.recycle();
            parcel.recycle();
            throw arraylist;
_L2:
            arraylist = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(dy dy1, String s)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (dy1 == null) goto _L2; else goto _L1
_L1:
            dy1 = dy1.asBinder();
_L4:
            parcel.writeStrongBinder(dy1);
            parcel.writeString(s);
            zznJ.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            dy1;
            parcel1.recycle();
            parcel.recycle();
            throw dy1;
_L2:
            dy1 = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(el el1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (el1 == null) goto _L2; else goto _L1
_L1:
            el1 = el1.asBinder();
_L4:
            parcel.writeStrongBinder(el1);
            zznJ.transact(10, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            el1;
            parcel1.recycle();
            parcel.recycle();
            throw el1;
_L2:
            el1 = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(String as[], dy dy1, String s)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeStringArray(as);
            if (dy1 == null) goto _L2; else goto _L1
_L1:
            as = dy1.asBinder();
_L4:
            parcel.writeStrongBinder(as);
            parcel.writeString(s);
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            as;
            parcel1.recycle();
            parcel.recycle();
            throw as;
_L2:
            as = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CB(Location location)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (location == null)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            parcel.writeInt(1);
            location.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_37;
            parcel.writeInt(0);
            zznJ.transact(13, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            location;
            parcel1.recycle();
            parcel.recycle();
            throw location;
        }

        public final void _mth02CE(PendingIntent pendingintent)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_37;
            parcel.writeInt(0);
            zznJ.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
        }

        public final Status _mth02CF(PendingIntent pendingintent)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_37;
            parcel.writeInt(0);
            zznJ.transact(65, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() != 0)
            {
                pendingintent = (Status)Status.CREATOR.createFromParcel(parcel1);
                break MISSING_BLOCK_LABEL_81;
            }
            pendingintent = null;
            parcel1.recycle();
            parcel.recycle();
            return pendingintent;
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
        }

        public final void _mth02EE(boolean flag)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Exception exception;
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            zznJ.transact(12, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public final Location _mth03DB()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            Location location;
label0:
            {
                parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                zznJ.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                if (parcel1.readInt() != 0)
                {
                    location = (Location)Location.CREATOR.createFromParcel(parcel1);
                    break label0;
                }
                location = null;
            }
            parcel1.recycle();
            parcel.recycle();
            return location;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public final ActivityRecognitionResult _mth06E5(String s)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
label0:
            {
                parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel.writeString(s);
                zznJ.transact(64, parcel, parcel1, 0);
                parcel1.readException();
                if (parcel1.readInt() != 0)
                {
                    s = ActivityRecognitionResult.CREATOR;
                    s = dd._mth02CB(parcel1);
                    break label0;
                }
                s = null;
            }
            parcel1.recycle();
            parcel.recycle();
            return s;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public final Status _mth141D(PendingIntent pendingintent)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_37;
            parcel.writeInt(0);
            zznJ.transact(66, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() != 0)
            {
                pendingintent = (Status)Status.CREATOR.createFromParcel(parcel1);
                break MISSING_BLOCK_LABEL_81;
            }
            pendingintent = null;
            parcel1.recycle();
            parcel.recycle();
            return pendingintent;
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
        }

        public final Location _mth1420(String s)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
label0:
            {
                parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel.writeString(s);
                zznJ.transact(21, parcel, parcel1, 0);
                parcel1.readException();
                if (parcel1.readInt() != 0)
                {
                    s = (Location)Location.CREATOR.createFromParcel(parcel1);
                    break label0;
                }
                s = null;
            }
            parcel1.recycle();
            parcel.recycle();
            return s;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public final LocationAvailability _mth1423(String s)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
label0:
            {
                parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel.writeString(s);
                zznJ.transact(34, parcel, parcel1, 0);
                parcel1.readException();
                if (parcel1.readInt() != 0)
                {
                    s = LocationAvailability.CREATOR;
                    s = di._mth02CE(parcel1);
                    break label0;
                }
                s = null;
            }
            parcel1.recycle();
            parcel.recycle();
            return s;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        if.if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract Status _mth02BB(PendingIntent pendingintent);

    public abstract void _mth02BC(PendingIntent pendingintent);

    public abstract Status _mth02CA(GestureRequest gesturerequest, PendingIntent pendingintent);

    public abstract void _mth02CA(long l, boolean flag, PendingIntent pendingintent);

    public abstract void _mth02CA(PendingIntent pendingintent, dy dy, String s);

    public abstract void _mth02CA(Location location, int i);

    public abstract void _mth02CA(GeofencingRequest geofencingrequest, PendingIntent pendingintent, dy dy);

    public abstract void _mth02CA(LocationRequest locationrequest, PendingIntent pendingintent);

    public abstract void _mth02CA(LocationRequest locationrequest, el el);

    public abstract void _mth02CA(LocationRequest locationrequest, el el, String s);

    public abstract void _mth02CA(LocationSettingsRequest locationsettingsrequest, ea ea, String s);

    public abstract void _mth02CA(LocationRequestInternal locationrequestinternal, PendingIntent pendingintent);

    public abstract void _mth02CA(LocationRequestInternal locationrequestinternal, el el);

    public abstract void _mth02CA(LocationRequestUpdateData locationrequestupdatedata);

    public abstract void _mth02CA(ArrayList arraylist, PendingIntent pendingintent, dy dy, String s);

    public abstract void _mth02CA(dy dy, String s);

    public abstract void _mth02CA(el el);

    public abstract void _mth02CA(String as[], dy dy, String s);

    public abstract void _mth02CB(Location location);

    public abstract void _mth02CE(PendingIntent pendingintent);

    public abstract Status _mth02CF(PendingIntent pendingintent);

    public abstract void _mth02EE(boolean flag);

    public abstract Location _mth03DB();

    public abstract ActivityRecognitionResult _mth06E5(String s);

    public abstract Status _mth141D(PendingIntent pendingintent);

    public abstract Location _mth1420(String s);

    public abstract LocationAvailability _mth1423(String s);
}
