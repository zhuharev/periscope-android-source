// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.ValidateAccountRequest;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package o:
//            _cls148F, _cls072B, _cls0E44, _cls14B9, 
//            _cls14B4

public abstract class _cls1435
    implements _cls09A8._cls02CA, _cls1448.if
{
    /* member class not found */
    class aux {}

    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02BB {}

    /* member class not found */
    class _cls02BC {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}

    /* member class not found */
    class _cls141D {}


    public final Context mContext;
    private final Looper wZ;
    final Set wr;
    private final _cls0E44 xO;
    private final _cls148F xP;
    final _cls02CA xQ;
    _cls14B9 xR;
    _cls09AA._cls02CE xS;
    private IInterface xT;
    final ArrayList xU;
    private _cls02CF xV;
    private int xW;
    final _cls09AA._cls02CA xX;
    final _cls09AA._cls02CB xY;
    private final int xZ;
    private final _cls072B xa;
    private final Account xw;
    protected AtomicInteger ya;
    private final Object zzpd;

    public _cls1435(Context context, Looper looper, int i, _cls0E44 _pcls0e44, _cls09AA._cls02CA _pcls02ca, _cls09AA._cls02CB _pcls02cb)
    {
        _cls148F _lcls148f = _cls148F.FE76(context);
        _cls072B _lcls072b = _cls072B._mth026D();
        if (_pcls02ca == null)
        {
            throw new NullPointerException("null reference");
        }
        _pcls02ca = (_cls09AA._cls02CA)_pcls02ca;
        if (_pcls02cb == null)
        {
            throw new NullPointerException("null reference");
        } else
        {
            this(context, looper, _lcls148f, _lcls072b, i, _pcls0e44, _pcls02ca, (_cls09AA._cls02CB)_pcls02cb);
            return;
        }
    }

    private _cls1435(Context context, Looper looper, _cls148F _pcls148f, _cls072B _pcls072b, int i, _cls0E44 _pcls0e44, _cls09AA._cls02CA _pcls02ca, 
            _cls09AA._cls02CB _pcls02cb)
    {
        zzpd = new Object();
        xU = new ArrayList();
        xW = 1;
        ya = new AtomicInteger(0);
        if (context == null)
        {
            throw new NullPointerException(String.valueOf("Context must not be null"));
        }
        mContext = (Context)context;
        if (looper == null)
        {
            throw new NullPointerException(String.valueOf("Looper must not be null"));
        }
        wZ = (Looper)looper;
        if (_pcls148f == null)
        {
            throw new NullPointerException(String.valueOf("Supervisor must not be null"));
        }
        xP = (_cls148F)_pcls148f;
        if (_pcls072b == null)
        {
            throw new NullPointerException(String.valueOf("API availability must not be null"));
        }
        xa = (_cls072B)_pcls072b;
        xQ = new _cls02CA(looper);
        xZ = i;
        if (_pcls0e44 == null)
        {
            throw new NullPointerException("null reference");
        } else
        {
            xO = (_cls0E44)_pcls0e44;
            xw = _pcls0e44.xw;
            wr = _mth02CB(_pcls0e44.xH);
            xX = _pcls02ca;
            xY = _pcls02cb;
            return;
        }
    }

    private Set _mth02CB(Set set)
    {
        if (set == null)
        {
            return set;
        }
        for (Iterator iterator = set.iterator(); iterator.hasNext();)
        {
            if (!set.contains((Scope)iterator.next()))
            {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }

        return set;
    }

    public void disconnect()
    {
        ya.incrementAndGet();
        ArrayList arraylist = xU;
        arraylist;
        JVM INSTR monitorenter ;
        int j = xU.size();
        int i = 0;
_L6:
        if (i >= j) goto _L2; else goto _L1
_L1:
        _cls02CB _lcls02cb = (_cls02CB)xU.get(i);
        _lcls02cb;
        JVM INSTR monitorenter ;
        _lcls02cb.wo = null;
        _lcls02cb;
        JVM INSTR monitorexit ;
          goto _L3
        Exception exception1;
        exception1;
        throw exception1;
_L2:
        xU.clear();
        arraylist;
        JVM INSTR monitorexit ;
          goto _L4
        Exception exception;
        exception;
        throw exception;
_L4:
        _mth02CA(1, ((IInterface) (null)));
        return;
_L3:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final boolean isConnected()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        int i = xW;
        boolean flag;
        if (i == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean isConnecting()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        int i = xW;
        boolean flag;
        if (i == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean _mth0294()
    {
        return false;
    }

    public final IBinder _mth0295()
    {
        if (xR == null)
        {
            return null;
        } else
        {
            return xR.asBinder();
        }
    }

    public abstract IInterface _mth02CA(IBinder ibinder);

    void _mth02CA(int i, IInterface iinterface)
    {
        boolean flag;
        if (i == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (iinterface != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag == flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalArgumentException();
        }
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        xW = i;
        xT = iinterface;
        i;
        JVM INSTR tableswitch 1 3: default 302
    //                   1 260
    //                   2 100
    //                   3 308;
           goto _L1 _L2 _L3 _L1
_L1:
        break MISSING_BLOCK_LABEL_294;
_L3:
        if (xV != null)
        {
            Log.e("GmsClient", (new StringBuilder("Calling connect() while still connected, missing disconnect() for ")).append(_mth03C4()).toString());
            xP._mth02CB(_mth03C4(), xV, xO.wV);
            ya.incrementAndGet();
        }
        xV = new _cls02CF(ya.get());
        if (!xP._mth02CA(_mth03C4(), xV, xO.wV))
        {
            Log.e("GmsClient", (new StringBuilder("unable to connect to service: ")).append(_mth03C4()).toString());
            xQ.sendMessage(xQ.obtainMessage(3, ya.get(), 9));
        }
        break MISSING_BLOCK_LABEL_294;
_L2:
        if (xV != null)
        {
            xP._mth02CB(_mth03C4(), xV, xO.wV);
            xV = null;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        iinterface;
        throw iinterface;
    }

    public final void _mth02CA(String s, PrintWriter printwriter)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        IInterface iinterface;
        int i;
        i = xW;
        iinterface = xT;
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        s;
        throw s;
_L1:
        printwriter.append(s).append("mConnectState=");
        switch (i)
        {
        case 2: // '\002'
            printwriter.print("CONNECTING");
            break;

        case 3: // '\003'
            printwriter.print("CONNECTED");
            break;

        case 4: // '\004'
            printwriter.print("DISCONNECTING");
            break;

        case 1: // '\001'
            printwriter.print("DISCONNECTED");
            break;

        default:
            printwriter.print("UNKNOWN");
            break;
        }
        printwriter.append(" mService=");
        if (iinterface == null)
        {
            printwriter.println("null");
            return;
        } else
        {
            printwriter.append(_mth0413()).append("@").println(Integer.toHexString(System.identityHashCode(iinterface.asBinder())));
            return;
        }
    }

    public final void _mth02CA(_cls09AA._cls02CE _pcls02ce)
    {
        if (_pcls02ce == null)
        {
            throw new NullPointerException(String.valueOf("Connection progress callbacks cannot be null."));
        } else
        {
            xS = (_cls09AA._cls02CE)_pcls02ce;
            _mth02CA(2, ((IInterface) (null)));
            return;
        }
    }

    public final void _mth02CA(_cls14B4 _pcls14b4)
    {
        _pcls14b4 = new ValidateAccountRequest(_pcls14b4, (Scope[])wr.toArray(new Scope[wr.size()]), mContext.getPackageName(), null);
        try
        {
            xR._mth02CA(new _cls02CE(ya.get()), _pcls14b4);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (_cls14B4 _pcls14b4)
        {
            Log.w("GmsClient", "service died");
            xQ.sendMessage(xQ.obtainMessage(4, ya.get(), 1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (_cls14B4 _pcls14b4)
        {
            Log.w("GmsClient", "Remote exception occurred", _pcls14b4);
        }
    }

    public final void _mth02CA(_cls14B4 _pcls14b4, Set set)
    {
        GetServiceRequest getservicerequest;
        try
        {
            Bundle bundle = _mth05DC();
            getservicerequest = new GetServiceRequest(xZ);
            getservicerequest.xr = mContext.getPackageName();
            getservicerequest.xu = bundle;
        }
        // Misplaced declaration of an exception variable
        catch (_cls14B4 _pcls14b4)
        {
            Log.w("GmsClient", "service died");
            xQ.sendMessage(xQ.obtainMessage(4, ya.get(), 1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (_cls14B4 _pcls14b4)
        {
            Log.w("GmsClient", "Remote exception occurred", _pcls14b4);
            return;
        }
        if (set == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        getservicerequest.xt = (Scope[])set.toArray(new Scope[set.size()]);
        if (!_mth0294())
        {
            break MISSING_BLOCK_LABEL_119;
        }
        if (xw != null)
        {
            set = xw;
            break MISSING_BLOCK_LABEL_97;
        }
        set = new Account("<<default account>>", "com.google");
        getservicerequest.xv = set;
        if (_pcls14b4 == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        getservicerequest.xs = _pcls14b4.asBinder();
        break MISSING_BLOCK_LABEL_134;
        if (_mth0632())
        {
            getservicerequest.xv = xw;
        }
        xR._mth02CA(new _cls02CE(ya.get()), getservicerequest);
        return;
    }

    boolean _mth02CA(int i, int j, IInterface iinterface)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        int k = xW;
        if (k == i)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        _mth02CA(j, iinterface);
        obj;
        JVM INSTR monitorexit ;
        return true;
        iinterface;
        throw iinterface;
    }

    public abstract String _mth03C4();

    public abstract String _mth0413();

    public Bundle _mth05DC()
    {
        return new Bundle();
    }

    public final IInterface _mth05E5()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (xW == 4)
        {
            throw new DeadObjectException();
        }
        if (!isConnected())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
        IInterface iinterface;
        Exception exception;
        boolean flag;
        if (xT != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        throw new IllegalStateException(String.valueOf("Client is connected but service is null"));
        iinterface = xT;
        obj;
        JVM INSTR monitorexit ;
        return iinterface;
        exception;
        throw exception;
    }

    public boolean _mth0632()
    {
        return false;
    }
}
