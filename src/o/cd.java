// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package o:
//            _cls09AA, ce, cf, cg, 
//            _cls1448, cc, _cls0E44, _cls09A8, 
//            _cls067B, ch, ci, bv, 
//            bx, bs, _cls05E3, _cls072B, 
//            _cls0E05, dv, eh

public final class cd extends _cls09AA
{
    static interface aux
    {

        public abstract void cancel();

        public abstract boolean isReady();

        public abstract _cls09A8._cls02CB _mth028F();

        public abstract Integer _mth02B7();

        public abstract void _mth02CA(_cls02CF _pcls02cf);

        public abstract void _mth02CA(_cls09A8._cls02CA _pcls02ca);

        public abstract void _mth02CB(Status status);

        public abstract void _mth02CE(Status status);

        public abstract void _mth1EC8();
    }

    final class if extends Handler
    {

        private cd Bt;

        public final void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 4: default 36
        //                       1 39
        //                       2 86
        //                       3 94
        //                       4 109;
               goto _L1 _L2 _L3 _L4 _L5
_L2:
            message = Bt;
            ((cd) (message)).AZ.lock();
            if (message.FF2A())
            {
                message.connect();
            }
            ((cd) (message)).AZ.unlock();
            return;
            Exception exception;
            exception;
            ((cd) (message)).AZ.unlock();
            throw exception;
_L3:
            cd._mth02CA(Bt);
            return;
_L4:
            ((_cls02CA)message.obj)._mth02CB(Bt);
            return;
_L5:
            throw (RuntimeException)message.obj;
_L1:
            Log.w("GoogleApiClientImpl", (new StringBuilder("Unknown message id: ")).append(message.what).toString());
            return;
        }

        if(Looper looper)
        {
            Bt = cd.this;
            super(looper);
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    final ReentrantLock AZ;
    final Condition Ba;
    final _cls1448 Bb;
    final LinkedList Bc;
    volatile boolean Bd;
    long Be;
    long Bf;
    final if Bg;
    _cls02CE Bh;
    final HashMap Bi;
    final HashMap Bj;
    Set Bk;
    final HashMap Bl;
    volatile ci Bm;
    private ConnectionResult Bn;
    private final Set Bo;
    final Set Bp;
    final ce Bq;
    private final cf Br;
    private final cg Bs;
    final Context mContext;
    private final int wY;
    final Looper wZ;
    final _cls0E44 xO;
    final _cls072B xa;
    final _cls09A8.if xb;

    public cd(Context context, Looper looper, _cls0E44 _pcls0e44, _cls072B _pcls072b, _cls09A8.if if1, Map map, ArrayList arraylist, 
            ArrayList arraylist1, int i)
    {
        AZ = new ReentrantLock();
        Bc = new LinkedList();
        Be = 0x1d4c0L;
        Bf = 5000L;
        Bi = new HashMap();
        Bj = new HashMap();
        Bk = new HashSet();
        Bn = null;
        Bo = Collections.newSetFromMap(new WeakHashMap());
        Bp = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75F, 2));
        Bq = new ce(this);
        Br = new cf(this);
        Bs = new cg(this);
        mContext = context;
        Bb = new _cls1448(looper, Bs);
        wZ = looper;
        Bg = new if(looper);
        xa = _pcls072b;
        wY = i;
        Bl = new HashMap();
        Ba = AZ.newCondition();
        Bm = new cc(this);
        arraylist = arraylist.iterator();
_L3:
        _cls09AA._cls02CA _lcls02ca;
        _cls1448 _lcls1448;
        if (!arraylist.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        _lcls02ca = (_cls09AA._cls02CA)arraylist.next();
        _lcls1448 = Bb;
        if (_lcls02ca == null)
        {
            throw new NullPointerException("null reference");
        }
        _pcls072b = ((_cls072B) (_lcls1448.zzpd));
        _pcls072b;
        JVM INSTR monitorenter ;
        if (_lcls1448.yi.contains(_lcls02ca))
        {
            Log.w("GmsClientEvents", (new StringBuilder("registerConnectionCallbacks(): listener ")).append(_lcls02ca).append(" is already registered").toString());
            break MISSING_BLOCK_LABEL_349;
        }
        _lcls1448.yi.add(_lcls02ca);
        _pcls072b;
        JVM INSTR monitorexit ;
          goto _L1
        context;
        throw context;
_L1:
        if (_lcls1448.yh.isConnected())
        {
            _lcls1448.mHandler.sendMessage(_lcls1448.mHandler.obtainMessage(1, _lcls02ca));
        }
        if (true) goto _L3; else goto _L2
_L2:
        for (_pcls072b = arraylist1.iterator(); _pcls072b.hasNext(); Bb._mth02CA(arraylist))
        {
            arraylist = (_cls09AA._cls02CB)_pcls072b.next();
        }

        _pcls072b = _pcls0e44.xI;
        Object obj;
        for (arraylist = map.keySet().iterator(); arraylist.hasNext(); Bi.put(arraylist1._mth028F(), obj))
        {
            arraylist1 = (_cls09A8)arraylist.next();
            obj = map.get(arraylist1);
            i = 0;
            if (_pcls072b.get(arraylist1) != null)
            {
                if (((_cls067B)_pcls072b.get(arraylist1)).ws)
                {
                    i = 1;
                } else
                {
                    i = 2;
                }
            }
            Bl.put(arraylist1, Integer.valueOf(i));
            obj = arraylist1._mth027B()._mth02CA(context, looper, _pcls0e44, obj, Br, new ch(this, arraylist1, i));
        }

        xO = _pcls0e44;
        xb = if1;
        return;
    }

    private static void _mth02CA(aux aux1, _cls0E05 _pcls0e05, IBinder ibinder)
    {
        if (aux1.isReady())
        {
            aux1._mth02CA(new _cls02CB(aux1, _pcls0e05, ibinder, (byte)0));
            return;
        }
        if (ibinder != null && ibinder.isBinderAlive())
        {
            _pcls0e05 = new _cls02CB(aux1, _pcls0e05, ibinder, (byte)0);
            aux1._mth02CA(_pcls0e05);
            try
            {
                ibinder.linkToDeath(_pcls0e05, 0);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (_cls0E05 _pcls0e05)
            {
                aux1.cancel();
            }
            aux1._mth02B7();
            return;
        } else
        {
            aux1._mth02CA(null);
            aux1.cancel();
            aux1._mth02B7();
            return;
        }
    }

    static void _mth02CA(cd cd1)
    {
        cd1.AZ.lock();
        if (cd1.Bd)
        {
            cd1.connect();
        }
        cd1.AZ.unlock();
        return;
        Exception exception;
        exception;
        cd1.AZ.unlock();
        throw exception;
    }

    public final void connect()
    {
        AZ.lock();
        Bm.connect();
        AZ.unlock();
        return;
        Exception exception;
        exception;
        AZ.unlock();
        throw exception;
    }

    public final void disconnect()
    {
        AZ.lock();
        FF2A();
        Bm.disconnect();
        AZ.unlock();
        return;
        Exception exception;
        exception;
        AZ.unlock();
        throw exception;
    }

    public final void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.append(s).append("mState=").append(Bm.getName());
        printwriter.append(" mResuming=").print(Bd);
        printwriter.append(" mWorkQueue.size()=").print(Bc.size());
        printwriter.append(" mUnconsumedRunners.size()=").println(Bp.size());
        filedescriptor = (new StringBuilder()).append(s).append("  ").toString();
        _cls09A8 _lcls09a8;
        for (as = Bl.keySet().iterator(); as.hasNext(); ((_cls09A8._cls02CA)Bi.get(_lcls09a8._mth028F()))._mth02CA(filedescriptor, printwriter))
        {
            _lcls09a8 = (_cls09A8)as.next();
            printwriter.append(s).append(_lcls09a8.mName).println(":");
        }

    }

    public final Looper getLooper()
    {
        return wZ;
    }

    public final boolean isConnected()
    {
        return Bm instanceof bv;
    }

    public final boolean isConnecting()
    {
        return Bm instanceof bx;
    }

    final void _mth02BD(ConnectionResult connectionresult)
    {
        AZ.lock();
        Bn = connectionresult;
        Bm = new cc(this);
        Bm.begin();
        Ba.signalAll();
        AZ.unlock();
        return;
        connectionresult;
        AZ.unlock();
        throw connectionresult;
    }

    public final bs _mth02CA(dv dv)
    {
        boolean flag;
        if (((bs) (dv)).wR != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalArgumentException(String.valueOf("This task can not be executed (it's probably a Batch or malformed)"));
        }
        AZ.lock();
        if (!Bd)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        Bc.add(dv);
        aux aux1;
        for (; !Bc.isEmpty(); aux1._mth02CB(Status.xj))
        {
            aux1 = (aux)Bc.remove();
            Bp.add(aux1);
            aux1._mth02CA(Bq);
        }

        AZ.unlock();
        return dv;
        dv = Bm._mth02CB(dv);
        AZ.unlock();
        return dv;
        dv;
        AZ.unlock();
        throw dv;
    }

    public final bs _mth02CA(eh eh)
    {
        boolean flag;
        if (((bs) (eh)).wR != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalArgumentException(String.valueOf("This task can not be enqueued (it's probably a Batch or malformed)"));
        }
        if (!Bi.containsKey(((bs) (eh)).wR))
        {
            throw new IllegalArgumentException(String.valueOf("GoogleApiClient is not configured to use the API required for this call."));
        }
        AZ.lock();
        eh = Bm._mth02CA(eh);
        AZ.unlock();
        return eh;
        eh;
        AZ.unlock();
        throw eh;
    }

    public final _cls09A8._cls02CA _mth02CA(_cls09A8._cls02CB _pcls02cb)
    {
        _pcls02cb = (_cls09A8._cls02CA)Bi.get(_pcls02cb);
        if (_pcls02cb == null)
        {
            throw new NullPointerException(String.valueOf("Appropriate Api was not requested."));
        } else
        {
            return _pcls02cb;
        }
    }

    public final void _mth02CA(cl.if if1)
    {
        Bb._mth02CA(if1);
    }

    public final void _mth02CB(cl.if if1)
    {
        _cls1448 _lcls1448;
        _lcls1448 = Bb;
        if (if1 == null)
        {
            throw new NullPointerException("null reference");
        }
        Object obj = _lcls1448.zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (!_lcls1448.yk.remove(if1))
        {
            Log.w("GmsClientEvents", (new StringBuilder("unregisterConnectionFailedListener(): listener ")).append(if1).append(" not found").toString());
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        if1;
        throw if1;
    }

    final void FEAF()
    {
        for (Iterator iterator = Bp.iterator(); iterator.hasNext();)
        {
            aux aux1 = (aux)iterator.next();
            aux1._mth02CA(null);
            if (aux1._mth02B7() == null)
            {
                aux1.cancel();
            } else
            {
                aux1._mth1EC8();
                _mth02CA(aux1, null, _mth02CA(aux1._mth028F())._mth0295());
            }
        }

        Bp.clear();
        for (Iterator iterator1 = Bo.iterator(); iterator1.hasNext(); ((_cls05E3)iterator1.next()).clear()) { }
        Bo.clear();
    }

    final void FEE3()
    {
        AZ.lock();
        FF2A();
        Bm = new bv(this);
        Bm.begin();
        Ba.signalAll();
        AZ.unlock();
        return;
        Exception exception;
        exception;
        AZ.unlock();
        throw exception;
    }

    final boolean FF2A()
    {
        if (!Bd)
        {
            return false;
        }
        Bd = false;
        Bg.removeMessages(2);
        Bg.removeMessages(1);
        if (Bh != null)
        {
            Bh.unregister();
            Bh = null;
        }
        return true;
    }
}
