// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package o:
//            ci, cd, _cls1448, ck, 
//            bw, bs, _cls09A8

public final class bv
    implements ci
{

    private final cd Au;

    public bv(cd cd1)
    {
        Au = cd1;
    }

    private void _mth02CA(cd.aux aux)
    {
        Object obj = Au;
        ((cd) (obj)).Bp.add(aux);
        aux._mth02CA(((cd) (obj)).Bq);
        obj = Au;
        _cls09A8._cls02CB _lcls02cb = aux._mth028F();
        obj = (_cls09A8._cls02CA)((cd) (obj)).Bi.get(_lcls02cb);
        if (obj == null)
        {
            throw new NullPointerException(String.valueOf("Appropriate Api was not requested."));
        }
        if (!((_cls09A8._cls02CA) (obj)).isConnected() && Au.Bj.containsKey(aux._mth028F()))
        {
            aux._mth02CB(new Status(17));
            return;
        } else
        {
            aux._mth02CA(((_cls09A8._cls02CA) (obj)));
            return;
        }
    }

    public final void begin()
    {
        while (!Au.Bc.isEmpty()) 
        {
            try
            {
                _mth02CA((cd.aux)Au.Bc.remove());
            }
            catch (DeadObjectException deadobjectexception)
            {
                Log.w("GACConnected", "Service died while flushing queue", deadobjectexception);
            }
        }
    }

    public final void connect()
    {
    }

    public final void disconnect()
    {
        Au.Bj.clear();
        Au.FEAF();
        Au._mth02BD(null);
        _cls1448 _lcls1448 = Au.Bb;
        _lcls1448.yl = false;
        _lcls1448.ym.incrementAndGet();
    }

    public final String getName()
    {
        return "CONNECTED";
    }

    public final void _mth02C1(int i)
    {
        _cls1448 _lcls1448_1;
        if (i == 1)
        {
            cd cd1 = Au;
            if (!cd1.Bd)
            {
                cd1.Bd = true;
                if (cd1.Bh == null)
                {
                    cd1.Bh = (cd._cls02CE)ck._mth02CA(cd1.mContext.getApplicationContext(), new cd._cls02CE(cd1), cd1.xa);
                }
                cd1.Bg.sendMessageDelayed(cd1.Bg.obtainMessage(1), cd1.Be);
                cd1.Bg.sendMessageDelayed(cd1.Bg.obtainMessage(2), cd1.Bf);
            }
        }
        for (Iterator iterator = Au.Bp.iterator(); iterator.hasNext(); ((cd.aux)iterator.next())._mth02CE(new Status(8, "The connection to Google Play services was lost"))) { }
        Au._mth02BD(null);
        _lcls1448_1 = Au.Bb;
        boolean flag;
        if (Looper.myLooper() == _lcls1448_1.mHandler.getLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalStateException(String.valueOf("onUnintentionalDisconnection must only be called on the Handler thread"));
        }
        _lcls1448_1.mHandler.removeMessages(1);
        Object obj = _lcls1448_1.zzpd;
        obj;
        JVM INSTR monitorenter ;
        _lcls1448_1.yn = true;
        Object obj1 = new ArrayList(_lcls1448_1.yi);
        int j = _lcls1448_1.ym.get();
        obj1 = ((ArrayList) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            _cls09AA._cls02CA _lcls02ca = (_cls09AA._cls02CA)((Iterator) (obj1)).next();
            if (!_lcls1448_1.yl || _lcls1448_1.ym.get() != j)
            {
                break;
            }
            if (_lcls1448_1.yi.contains(_lcls02ca))
            {
                _lcls02ca._mth02C1(i);
            }
        } while (true);
        _lcls1448_1.yj.clear();
        _lcls1448_1.yn = false;
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        _cls1448 _lcls1448 = Au.Bb;
        _lcls1448.yl = false;
        _lcls1448.ym.incrementAndGet();
        if (i == 2)
        {
            Au.connect();
        }
        return;
    }

    public final bs _mth02CA(bs bs)
    {
        return _mth02CB(bs);
    }

    public final void _mth02CA(ConnectionResult connectionresult, _cls09A8 _pcls09a8, int i)
    {
    }

    public final bs _mth02CB(bs bs)
    {
        DeadObjectException deadobjectexception;
        cd cd1;
        Object obj;
        try
        {
            _mth02CA(bs);
        }
        // Misplaced declaration of an exception variable
        catch (DeadObjectException deadobjectexception)
        {
            cd1 = Au;
            obj = new bw(this, this);
            obj = cd1.Bg.obtainMessage(3, obj);
            cd1.Bg.sendMessage(((android.os.Message) (obj)));
            return bs;
        }
        return bs;
    }

    public final void _mth141D(Bundle bundle)
    {
    }
}
