// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class _cls1448
    implements android.os.Handler.Callback
{
    /* member class not found */
    class if {}


    public final Handler mHandler;
    public final if yh;
    public final ArrayList yi = new ArrayList();
    public final ArrayList yj = new ArrayList();
    public final ArrayList yk = new ArrayList();
    public volatile boolean yl;
    public final AtomicInteger ym = new AtomicInteger(0);
    public boolean yn;
    public final Object zzpd = new Object();

    public _cls1448(Looper looper, if if1)
    {
        yl = false;
        yn = false;
        yh = if1;
        mHandler = new Handler(looper, this);
    }

    public final boolean handleMessage(Message message)
    {
        _cls09AA._cls02CA _lcls02ca;
        if (message.what != 1)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        _lcls02ca = (_cls09AA._cls02CA)message.obj;
        message = ((Message) (zzpd));
        message;
        JVM INSTR monitorenter ;
        if (yl && yh.isConnected() && yi.contains(_lcls02ca))
        {
            _lcls02ca._mth141D(null);
        }
        message;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        return true;
        Log.wtf("GmsClientEvents", (new StringBuilder("Don't know how to handle message: ")).append(message.what).toString(), new Exception());
        return false;
    }

    public final void _mth02BB(Bundle bundle)
    {
        boolean flag;
        if (Looper.myLooper() == mHandler.getLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalStateException(String.valueOf("onConnectionSuccess must only be called on the Handler thread"));
        }
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        int i;
        Object obj1;
        _cls09AA._cls02CA _lcls02ca;
        if (!yn)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        throw new IllegalStateException();
        mHandler.removeMessages(1);
        yn = true;
        if (yj.size() == 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        throw new IllegalStateException();
        obj1 = new ArrayList(yi);
        i = ym.get();
        obj1 = ((ArrayList) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            _lcls02ca = (_cls09AA._cls02CA)((Iterator) (obj1)).next();
            if (!yl || !yh.isConnected() || ym.get() != i)
            {
                break;
            }
            if (!yj.contains(_lcls02ca))
            {
                _lcls02ca._mth141D(bundle);
            }
        } while (true);
        yj.clear();
        yn = false;
        obj;
        JVM INSTR monitorexit ;
        return;
        bundle;
        throw bundle;
    }

    public final void _mth02CA(_cls09AA._cls02CB _pcls02cb)
    {
        if (_pcls02cb == null)
        {
            throw new NullPointerException("null reference");
        }
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (yk.contains(_pcls02cb))
        {
            Log.w("GmsClientEvents", (new StringBuilder("registerConnectionFailedListener(): listener ")).append(_pcls02cb).append(" is already registered").toString());
            break MISSING_BLOCK_LABEL_71;
        }
        yk.add(_pcls02cb);
        obj;
        JVM INSTR monitorexit ;
        return;
        _pcls02cb;
        throw _pcls02cb;
    }

    public final void _mth141D(ConnectionResult connectionresult)
    {
        boolean flag;
        if (Looper.myLooper() == mHandler.getLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalStateException(String.valueOf("onConnectionFailure must only be called on the Handler thread"));
        }
        mHandler.removeMessages(1);
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        int i;
        obj1 = new ArrayList(yk);
        i = ym.get();
        obj1 = ((ArrayList) (obj1)).iterator();
_L5:
        _cls09AA._cls02CB _lcls02cb;
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_150;
        }
        _lcls02cb = (_cls09AA._cls02CB)((Iterator) (obj1)).next();
        if (!yl) goto _L2; else goto _L1
_L1:
        int j = ym.get();
        if (j == i) goto _L3; else goto _L2
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
_L3:
        if (!yk.contains(_lcls02cb)) goto _L5; else goto _L4
_L4:
        _lcls02cb._mth02CA(connectionresult);
          goto _L5
        obj;
        JVM INSTR monitorexit ;
        return;
        connectionresult;
        throw connectionresult;
    }
}
