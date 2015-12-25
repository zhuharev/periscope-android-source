// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package o:
//            yf

public abstract class yd extends Thread
{
    public static interface if
    {

        public abstract void _mth0456(String s);

        public abstract void _mth0457(String s);
    }


    final ReentrantLock aUp = new ReentrantLock();
    final Condition aUq;
    final Condition aUr;
    private final Comparator aUs;
    final ConcurrentHashMap aUt = new ConcurrentHashMap();
    private final ConcurrentHashMap aUu = new ConcurrentHashMap();
    public volatile boolean aUv;
    final ConcurrentHashMap aUw = new ConcurrentHashMap();
    private final ConcurrentHashMap aUx = new ConcurrentHashMap();
    private final if aUy;

    protected yd(Comparator comparator, if if1)
    {
        aUq = aUp.newCondition();
        aUr = aUp.newCondition();
        aUv = true;
        aUs = comparator;
        aUy = if1;
    }

    private String a()
    {
        Object obj1 = (yf)aUt.get(aug._cls02CA.bFa);
        yf yf1 = (yf)aUu.get(aug._cls02CA.bFa);
        Object obj;
        if (aUw.get(aug._cls02CA.bFa) == null)
        {
            obj = "0";
        } else
        {
            obj = String.valueOf(aUw.get(aug._cls02CA.bFa));
        }
        if (obj1 != null)
        {
            obj1 = String.valueOf(((yf) (obj1)).aUB.size());
        } else
        {
            obj1 = "0";
        }
        obj1 = (new StringBuilder("C - T: ")).append(String.valueOf(aUx.get(aug._cls02CA.bFa))).append(" D:").append(((String) (obj))).append(" R: ").append(((String) (obj1))).append(" I: ");
        if (yf1 != null)
        {
            obj = Integer.valueOf(yf1.aUB.size());
        } else
        {
            obj = "0";
        }
        return ((StringBuilder) (obj1)).append(obj).toString();
    }

    private String FF92()
    {
        Object obj1 = (yf)aUt.get(aug._cls02CA.bEZ);
        yf yf1 = (yf)aUu.get(aug._cls02CA.bEZ);
        Object obj = (Integer)aUw.get(aug._cls02CA.bEZ);
        StringBuilder stringbuilder = (new StringBuilder("<3 - T: ")).append(aUx.get(aug._cls02CA.bEZ)).append(" D: ");
        if (obj == null)
        {
            obj = "0";
        }
        stringbuilder = stringbuilder.append(obj).append(" R: ");
        if (obj1 != null)
        {
            obj = Integer.valueOf(((yf) (obj1)).aUB.size());
        } else
        {
            obj = "0";
        }
        obj1 = stringbuilder.append(obj).append(" I: ");
        if (yf1 != null)
        {
            obj = Integer.valueOf(yf1.aUB.size());
        } else
        {
            obj = "0";
        }
        return ((StringBuilder) (obj1)).append(obj).toString();
    }

    public void clear()
    {
        aUw.clear();
        aUt.clear();
        aUu.clear();
        aUx.clear();
        _mth02CA(aUq);
        _mth02CA(aUr);
    }

    public final void run()
    {
        try
        {
            while (aUv) 
            {
                _mth02CA(aUt, aUu);
            }
        }
        catch (Exception exception)
        {
            return;
        }
    }

    protected final void _mth02CA(Object obj, aug._cls02CA _pcls02ca)
    {
        while (obj != null) 
        {
            _mth02CA(_pcls02ca);
            yf yf3 = (yf)aUt.get(_pcls02ca);
            yf yf2 = (yf)aUu.get(_pcls02ca);
            yf yf1 = yf2;
            if (yf2 == null)
            {
                yf1 = new yf(yf3.aUC, aUs);
                aUu.put(yf3.aUC, yf1);
            }
            if (_mth02CA(yf3.aUC, ((BlockingQueue) (yf1.aUB)), obj))
            {
                obj = yf3.aUC;
                if (aUu.get(obj) != null)
                {
                    if (aUw.get(obj) == null)
                    {
                        aUw.put(obj, Integer.valueOf(0));
                    }
                    aUw.put(obj, Integer.valueOf(((Integer)aUw.get(obj)).intValue() + 1));
                }
                obj = yf3.aUB.poll();
            } else
            if (_mth1D5B(obj))
            {
                yf1.aUB.offer(obj);
                obj = yf3.aUB.poll();
            } else
            {
                yf3.aUB.offer(obj);
                return;
            }
        }
    }

    protected abstract void _mth02CA(Map map, Map map1);

    void _mth02CA(Condition condition)
    {
        aUp.lock();
        condition.signal();
        aUp.unlock();
        return;
        condition;
        aUp.unlock();
        throw condition;
    }

    protected final void _mth02CA(aug._cls02CA _pcls02ca)
    {
        if (aUy == null)
        {
            return;
        }
        if (_pcls02ca == aug._cls02CA.bEZ)
        {
            aUy._mth0456(FF92());
            return;
        }
        if (_pcls02ca == aug._cls02CA.bFa)
        {
            aUy._mth0457(a());
        }
    }

    public final void _mth02CA(aug._cls02CA _pcls02ca, Object obj)
    {
        Integer integer = (Integer)aUx.get(_pcls02ca);
        if (integer == null)
        {
            aUx.put(_pcls02ca, Integer.valueOf(0));
        } else
        {
            aUx.put(_pcls02ca, Integer.valueOf(integer.intValue() + 1));
        }
        _mth02CE(_pcls02ca, obj);
        if (_pcls02ca.duration <= 0L)
        {
            _mth02CA(aUq);
        }
        _mth02CA(aUr);
        _mth02CA(_pcls02ca);
    }

    public abstract boolean _mth02CA(aug._cls02CA _pcls02ca, BlockingQueue blockingqueue, Object obj);

    public final void _mth02CB(aug._cls02CA _pcls02ca, Object obj)
    {
        _mth02CE(_pcls02ca, obj);
        if (_pcls02ca.duration <= 0L)
        {
            _mth02CA(aUq);
        }
        _mth02CA(aUr);
    }

    public final void _mth02CE(aug._cls02CA _pcls02ca, Object obj)
    {
        yf yf2 = (yf)aUt.get(_pcls02ca);
        yf yf1 = yf2;
        if (yf2 == null)
        {
            yf1 = new yf(_pcls02ca, aUs);
            aUt.put(_pcls02ca, yf1);
        }
        yf1.aUB.offer(obj);
    }

    protected abstract boolean _mth1D5B(Object obj);

    protected final void FE76(long l)
    {
        if (l <= 0L)
        {
            return;
        }
        aUp.lock();
        aUq.await(l, TimeUnit.MILLISECONDS);
        aUp.unlock();
        return;
        Exception exception;
        exception;
        aUp.unlock();
        throw exception;
    }
}
