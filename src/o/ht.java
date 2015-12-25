// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.AuthAccountResult;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ExecutorService;

// Referenced classes of package o:
//            _cls1435, db, _cls0E44, hr, 
//            _cls14D9, hq, dc, _cls14B4, 
//            hv, hu

public final class ht extends _cls1435
    implements db
{
    static final class if extends hp.if
    {

        private final ExecutorService FP;
        private final dc xe;

        static _cls1427.if _mth02CA(if if1)
        {
            return if1.xe.Cp;
        }

        public final void _mth02CA(String s, String s1, hr hr1)
        {
            FP.submit(new hv(this, s, s1, hr1));
        }

        public final void _mth02CA(String s, ArrayList arraylist, hr hr1)
        {
            FP.submit(new hu(this, arraylist, s, hr1));
        }

        public if(dc dc1, ExecutorService executorservice)
        {
            xe = dc1;
            FP = executorservice;
        }
    }


    private final boolean FO;
    private final ExecutorService FP;
    private Integer xL;
    private final _cls0E44 xO;
    private final dc xe;

    public ht(Context context, Looper looper, boolean flag, _cls0E44 _pcls0e44, dc dc1, _cls09AA._cls02CA _pcls02ca, _cls09AA._cls02CB _pcls02cb, 
            ExecutorService executorservice)
    {
        super(context, looper, 44, _pcls0e44, _pcls02ca, _pcls02cb);
        FO = flag;
        xO = _pcls0e44;
        xe = dc1;
        xL = _pcls0e44.xL;
        FP = executorservice;
    }

    public final void connect()
    {
        _mth02CA(new _cls1435.aux(this));
    }

    public final void _mth0283()
    {
        RemoteException remoteexception;
        try
        {
            ((hr)_mth05E5())._mth150B(xL.intValue());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RemoteException remoteexception)
        {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public final boolean _mth0294()
    {
        return FO;
    }

    protected final IInterface _mth02CA(IBinder ibinder)
    {
        return hr.if._mth02B3(ibinder);
    }

    public final void _mth02CA(bx._cls02CA _pcls02ca)
    {
        if (_pcls02ca == null)
        {
            throw new NullPointerException(String.valueOf("Expecting a valid IResolveAccountCallbacks"));
        }
        Object obj;
        try
        {
            obj = xO;
            if (((_cls0E44) (obj)).xw != null)
            {
                obj = ((_cls0E44) (obj)).xw;
                break MISSING_BLOCK_LABEL_49;
            }
        }
        catch (RemoteException remoteexception)
        {
            Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
            try
            {
                _pcls02ca._mth02CA(new ResolveAccountResponse(8));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (bx._cls02CA _pcls02ca)
            {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.", remoteexception);
            }
            return;
        }
        obj = new Account("<<default account>>", "com.google");
        ((hr)_mth05E5())._mth02CA(new ResolveAccountRequest(((Account) (obj)), xL.intValue()), _pcls02ca);
        return;
    }

    public final void _mth02CA(_cls14B4 _pcls14b4, Set set, bx.if if1)
    {
        if (if1 == null)
        {
            throw new NullPointerException(String.valueOf("Expecting a valid ISignInCallbacks"));
        }
        try
        {
            ((hr)_mth05E5())._mth02CA(new AuthAccountRequest(_pcls14b4, set), if1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (_cls14B4 _pcls14b4)
        {
            Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
        }
        try
        {
            if1._mth02CA(new ConnectionResult(8, null), new AuthAccountResult());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Set set)
        {
            Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.", _pcls14b4);
        }
    }

    public final void _mth02CA(_cls14B4 _pcls14b4, boolean flag)
    {
        try
        {
            ((hr)_mth05E5())._mth02CA(_pcls14b4, xL.intValue(), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (_cls14B4 _pcls14b4)
        {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    protected final String _mth03C4()
    {
        return "com.google.android.gms.signin.service.START";
    }

    protected final String _mth0413()
    {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected final Bundle _mth05DC()
    {
        Object obj = xe;
        Integer integer = xO.xL;
        ExecutorService executorservice = FP;
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", ((dc) (obj)).Cm);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", ((dc) (obj)).Cn);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", ((dc) (obj)).Co);
        if (((dc) (obj)).Cp != null)
        {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper((new if(((dc) (obj)), executorservice)).asBinder()));
        }
        if (integer != null)
        {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", integer.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", ((dc) (obj)).Cq);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", ((dc) (obj)).Cr);
        obj = xO.wU;
        if (!super.mContext.getPackageName().equals(obj))
        {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", xO.wU);
        }
        return bundle;
    }
}
