// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Referenced classes of package o:
//            ci, cd, bx, bs, 
//            _cls09A8

public final class cc
    implements ci
{

    private final cd Au;

    public cc(cd cd1)
    {
        Au = cd1;
    }

    public final void begin()
    {
        for (Iterator iterator = Au.Bi.values().iterator(); iterator.hasNext(); ((_cls09A8._cls02CA)iterator.next()).disconnect()) { }
        Au.Bk = Collections.emptySet();
    }

    public final void connect()
    {
        cd cd1;
        cd1 = Au;
        cd1.AZ.lock();
        cd1.Bm = new bx(cd1, cd1.xO, cd1.Bl, cd1.xa, cd1.xb, cd1.AZ, cd1.mContext);
        cd1.Bm.begin();
        cd1.Ba.signalAll();
        cd1.AZ.unlock();
        return;
        Exception exception;
        exception;
        cd1.AZ.unlock();
        throw exception;
    }

    public final void disconnect()
    {
        cd.aux aux;
        for (Iterator iterator = Au.Bc.iterator(); iterator.hasNext(); aux.cancel())
        {
            aux = (cd.aux)iterator.next();
            aux._mth02CA(null);
        }

        Au.Bc.clear();
        Au.Bj.clear();
        Au.FEAF();
    }

    public final String getName()
    {
        return "DISCONNECTED";
    }

    public final void _mth02C1(int i)
    {
    }

    public final bs _mth02CA(bs bs)
    {
        Au.Bc.add(bs);
        return bs;
    }

    public final void _mth02CA(ConnectionResult connectionresult, _cls09A8 _pcls09a8, int i)
    {
    }

    public final bs _mth02CB(bs bs)
    {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void _mth141D(Bundle bundle)
    {
    }
}
