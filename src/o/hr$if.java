// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import com.google.android.gms.signin.internal.RecordConsentRequest;

// Referenced classes of package o:
//            hr, _cls14D9, hq, _cls14B4

public static abstract class if.zznJ extends Binder
    implements hr
{
    static final class if
        implements hr
    {

        private IBinder zznJ;

        public final IBinder asBinder()
        {
            return zznJ;
        }

        public final void _mth02CA(int i, Account account, hq hq1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            parcel.writeInt(i);
            if (account == null)
            {
                break MISSING_BLOCK_LABEL_43;
            }
            parcel.writeInt(1);
            account.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_49;
            parcel.writeInt(0);
            if (hq1 == null) goto _L2; else goto _L1
_L1:
            account = hq1.asBinder();
_L4:
            parcel.writeStrongBinder(account);
            zznJ.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            account;
            parcel1.recycle();
            parcel.recycle();
            throw account;
_L2:
            account = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(AuthAccountRequest authaccountrequest, hq hq1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (authaccountrequest == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            parcel.writeInt(1);
            authaccountrequest.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_38;
            parcel.writeInt(0);
            if (hq1 == null) goto _L2; else goto _L1
_L1:
            authaccountrequest = hq1.asBinder();
_L4:
            parcel.writeStrongBinder(authaccountrequest);
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            authaccountrequest;
            parcel1.recycle();
            parcel.recycle();
            throw authaccountrequest;
_L2:
            authaccountrequest = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(ResolveAccountRequest resolveaccountrequest, _cls14D9 _pcls14d9)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (resolveaccountrequest == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            parcel.writeInt(1);
            resolveaccountrequest.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_38;
            parcel.writeInt(0);
            if (_pcls14d9 == null) goto _L2; else goto _L1
_L1:
            resolveaccountrequest = _pcls14d9.asBinder();
_L4:
            parcel.writeStrongBinder(resolveaccountrequest);
            zznJ.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            resolveaccountrequest;
            parcel1.recycle();
            parcel.recycle();
            throw resolveaccountrequest;
_L2:
            resolveaccountrequest = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(CheckServerAuthResult checkserverauthresult)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (checkserverauthresult == null)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            parcel.writeInt(1);
            checkserverauthresult.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_37;
            parcel.writeInt(0);
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            checkserverauthresult;
            parcel1.recycle();
            parcel.recycle();
            throw checkserverauthresult;
        }

        public final void _mth02CA(RecordConsentRequest recordconsentrequest, hq hq1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (recordconsentrequest == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            parcel.writeInt(1);
            recordconsentrequest.writeToParcel(parcel, 0);
            break MISSING_BLOCK_LABEL_38;
            parcel.writeInt(0);
            if (hq1 == null) goto _L2; else goto _L1
_L1:
            recordconsentrequest = hq1.asBinder();
_L4:
            parcel.writeStrongBinder(recordconsentrequest);
            zznJ.transact(10, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            recordconsentrequest;
            parcel1.recycle();
            parcel.recycle();
            throw recordconsentrequest;
_L2:
            recordconsentrequest = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(hq hq1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (hq1 == null) goto _L2; else goto _L1
_L1:
            hq1 = hq1.asBinder();
_L4:
            parcel.writeStrongBinder(hq1);
            zznJ.transact(11, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            hq1;
            parcel1.recycle();
            parcel.recycle();
            throw hq1;
_L2:
            hq1 = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth02CA(_cls14B4 _pcls14b4, int i, boolean flag)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (_pcls14b4 == null) goto _L2; else goto _L1
_L1:
            _pcls14b4 = _pcls14b4.asBinder();
_L4:
            parcel.writeStrongBinder(_pcls14b4);
            parcel.writeInt(i);
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            zznJ.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            _pcls14b4;
            parcel1.recycle();
            parcel.recycle();
            throw _pcls14b4;
_L2:
            _pcls14b4 = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void _mth150B(int i)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            parcel.writeInt(i);
            zznJ.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public final void _mth1D57(boolean flag)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
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
            zznJ.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
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


    public static hr _mth02B3(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (iinterface != null && (iinterface instanceof hr))
        {
            return (hr)iinterface;
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
            parcel1.writeString("com.google.android.gms.signin.internal.ISignInService");
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            AuthAccountRequest authaccountrequest;
            if (parcel.readInt() != 0)
            {
                authaccountrequest = (AuthAccountRequest)AuthAccountRequest.CREATOR.createFromParcel(parcel);
            } else
            {
                authaccountrequest = null;
            }
            _mth02CA(authaccountrequest, FF70(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            if (parcel.readInt() != 0)
            {
                parcel = (CheckServerAuthResult)CheckServerAuthResult.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            _mth02CA(parcel);
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            boolean flag;
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            _mth1D57(flag);
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            ResolveAccountRequest resolveaccountrequest;
            if (parcel.readInt() != 0)
            {
                resolveaccountrequest = (ResolveAccountRequest)ResolveAccountRequest.CREATOR.createFromParcel(parcel);
            } else
            {
                resolveaccountrequest = null;
            }
            parcel = parcel.readStrongBinder();
            if (parcel == null)
            {
                parcel = null;
            } else
            {
                android.os.IInterface iinterface = parcel.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
                if (iinterface != null && (iinterface instanceof _cls14D9))
                {
                    parcel = (_cls14D9)iinterface;
                } else
                {
                    parcel = new f.if(parcel);
                }
            }
            _mth02CA(resolveaccountrequest, parcel);
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            _mth150B(parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            i = parcel.readInt();
            Account account;
            if (parcel.readInt() != 0)
            {
                account = (Account)Account.CREATOR.createFromParcel(parcel);
            } else
            {
                account = null;
            }
            _mth02CA(i, account, FF70(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            _cls14B4 _lcls14b4 = f._mth02CB(parcel.readStrongBinder());
            i = parcel.readInt();
            boolean flag1;
            if (parcel.readInt() != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            _mth02CA(_lcls14b4, i, flag1);
            parcel1.writeNoException();
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            RecordConsentRequest recordconsentrequest;
            if (parcel.readInt() != 0)
            {
                recordconsentrequest = (RecordConsentRequest)RecordConsentRequest.CREATOR.createFromParcel(parcel);
            } else
            {
                recordconsentrequest = null;
            }
            _mth02CA(recordconsentrequest, FF70(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            _mth02CA(FF70(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }
}
