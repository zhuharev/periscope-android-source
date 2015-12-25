// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.AuthAccountResult;

public interface hq
    extends IInterface
{
    public static abstract class if extends Binder
        implements hq
    {

        public static hq FF70(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (iinterface != null && (iinterface instanceof hq))
            {
                return (hq)iinterface;
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
                parcel1.writeString("com.google.android.gms.signin.internal.ISignInCallbacks");
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                ConnectionResult connectionresult;
                if (parcel.readInt() != 0)
                {
                    connectionresult = (ConnectionResult)ConnectionResult.CREATOR.createFromParcel(parcel);
                } else
                {
                    connectionresult = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (AuthAccountResult)AuthAccountResult.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                _mth02CA(connectionresult, parcel);
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                if (parcel.readInt() != 0)
                {
                    parcel = (Status)Status.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                _mth141D(parcel);
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                if (parcel.readInt() != 0)
                {
                    parcel = (Status)Status.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                _mth02BB(parcel);
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                Status status;
                if (parcel.readInt() != 0)
                {
                    status = (Status)Status.CREATOR.createFromParcel(parcel);
                } else
                {
                    status = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (GoogleSignInAccount)GoogleSignInAccount.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                _mth02CA(status, parcel);
                parcel1.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        public if()
        {
            attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
        }
    }

    static final class if.if
        implements hq
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final void _mth02BB(Status status)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (status == null)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            parcel.writeInt(1);
            status.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_37;
            parcel.writeInt(0);
            zznJ.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            status;
            parcel1.recycle();
            parcel.recycle();
            throw status;
        }

        public final void _mth02CA(ConnectionResult connectionresult, AuthAccountResult authaccountresult)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (connectionresult == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            parcel.writeInt(1);
            connectionresult.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_38;
            parcel.writeInt(0);
            if (authaccountresult == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            authaccountresult.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_61;
            parcel.writeInt(0);
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            connectionresult;
            parcel1.recycle();
            parcel.recycle();
            throw connectionresult;
        }

        public final void _mth02CA(Status status, GoogleSignInAccount googlesigninaccount)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (status == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            parcel.writeInt(1);
            status.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_38;
            parcel.writeInt(0);
            if (googlesigninaccount == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            googlesigninaccount.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_61;
            parcel.writeInt(0);
            zznJ.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            status;
            parcel1.recycle();
            parcel.recycle();
            throw status;
        }

        public final void _mth141D(Status status)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (status == null)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            parcel.writeInt(1);
            status.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_37;
            parcel.writeInt(0);
            zznJ.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            status;
            parcel1.recycle();
            parcel.recycle();
            throw status;
        }

        if.if(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void _mth02BB(Status status);

    public abstract void _mth02CA(ConnectionResult connectionresult, AuthAccountResult authaccountresult);

    public abstract void _mth02CA(Status status, GoogleSignInAccount googlesigninaccount);

    public abstract void _mth141D(Status status);
}
