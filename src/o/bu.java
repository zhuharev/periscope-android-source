// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package o:
//            _cls09B0, _cls09B9, _cls0E04, _cls09F0, 
//            _cls14B5, _cls0E1B

public abstract class bu extends _cls09B0
{
    public static final class if extends Handler
    {

        public final void handleMessage(Message message)
        {
            switch (message.what)
            {
            case 1: // '\001'
                Object obj = (Pair)message.obj;
                message = (_cls0E04)((Pair) (obj)).first;
                obj = (_cls09F0)((Pair) (obj)).second;
                try
                {
                    message._mth02CA(((_cls09F0) (obj)));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    bu._mth02CF(((_cls09F0) (obj)));
                }
                throw message;

            case 2: // '\002'
                ((bu)message.obj)._mth02CE(Status.xk);
                return;
            }
            Log.wtf("BasePendingResult", (new StringBuilder("Don't know how to handle message: ")).append(message.what).toString(), new Exception());
        }

        public if()
        {
            this(Looper.getMainLooper());
        }

        public if(Looper looper)
        {
            super(looper);
        }
    }


    private if Ak;
    private final CountDownLatch Al = new CountDownLatch(1);
    private final ArrayList Am = new ArrayList();
    private _cls0E04 An;
    private volatile _cls09F0 Ao;
    private volatile boolean Ap;
    private boolean Aq;
    private boolean Ar;
    private _cls14B5 As;
    private volatile _cls0E1B At;
    private final Object xm = new Object();

    protected bu(Looper looper)
    {
        Ak = new if(looper);
    }

    private boolean isCanceled()
    {
        Object obj = xm;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = Aq;
        obj;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    private void _mth02CE(_cls09F0 _pcls09f0)
    {
        Ao = _pcls09f0;
        As = null;
        Al.countDown();
        _pcls09f0 = Ao;
        if (An != null)
        {
            Ak.removeMessages(2);
            if (!Aq)
            {
                _pcls09f0 = Ak;
                _pcls09f0.sendMessage(_pcls09f0.obtainMessage(1, new Pair(An, _mth1FD3())));
            }
        }
        for (_pcls09f0 = Am.iterator(); _pcls09f0.hasNext(); _pcls09f0.next()) { }
        Am.clear();
    }

    public static void _mth02CF(_cls09F0 _pcls09f0)
    {
        if (_pcls09f0 instanceof _cls09B9)
        {
            return;
        } else
        {
            return;
        }
    }

    private _cls09F0 _mth1FD3()
    {
        Object obj = xm;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        Object obj1;
        if (!Ap)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        throw new IllegalStateException(String.valueOf("Result has already been consumed."));
        if (Al.getCount() == 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        throw new IllegalStateException(String.valueOf("Result is not ready."));
        obj1 = Ao;
        Ao = null;
        An = null;
        Ap = true;
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        obj1;
        throw obj1;
_L1:
        _mth1FD2();
        return ((_cls09F0) (obj1));
    }

    public final void cancel()
    {
        Object obj = xm;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (Aq)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        flag = Ap;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        _mth02CF(Ao);
        An = null;
        Aq = true;
        _mth02CE(_mth02CF(Status.xl));
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean isReady()
    {
        return Al.getCount() == 0L;
    }

    public final Integer _mth02B7()
    {
        return null;
    }

    public final void _mth02CA(_cls0E04 _pcls0e04)
    {
        boolean flag;
        if (!Ap)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalStateException(String.valueOf("Result has already been consumed."));
        }
        Object obj = xm;
        obj;
        JVM INSTR monitorenter ;
        boolean flag2;
        _cls0E1B _lcls0e1b = At;
        flag2 = isCanceled();
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        if if1;
        boolean flag1;
        if (Al.getCount() == 0L)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        if1 = Ak;
        if1.sendMessage(if1.obtainMessage(1, new Pair(_pcls0e04, _mth1FD3())));
        break MISSING_BLOCK_LABEL_118;
        An = _pcls0e04;
        obj;
        JVM INSTR monitorexit ;
        return;
        _pcls0e04;
        throw _pcls0e04;
    }

    public final void _mth02CB(_cls09F0 _pcls09f0)
    {
        Object obj = xm;
        obj;
        JVM INSTR monitorenter ;
        if (!Ar && !Aq)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        _mth02CF(_pcls09f0);
        obj;
        JVM INSTR monitorexit ;
        boolean flag;
        return;
_L2:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        throw new IllegalStateException(String.valueOf("Results have already been set"));
        if (!Ap)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        throw new IllegalStateException(String.valueOf("Result has already been consumed"));
        _mth02CE(_pcls09f0);
        obj;
        JVM INSTR monitorexit ;
        return;
        _pcls09f0;
        throw _pcls09f0;
        if (Al.getCount() == 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void _mth02CE(Status status)
    {
        Object obj = xm;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (Al.getCount() == 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        _mth02CB(_mth02CF(status));
        Ar = true;
        obj;
        JVM INSTR monitorexit ;
        return;
        status;
        throw status;
    }

    public abstract _cls09F0 _mth02CF(Status status);

    protected void _mth1FD2()
    {
    }
}
