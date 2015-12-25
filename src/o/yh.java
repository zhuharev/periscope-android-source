// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.SystemClock;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Referenced classes of package o:
//            yd, yf, auf, zz, 
//            aug, ql

final class yh extends yd
{
    static final class if
        implements Comparator
    {

        public final int compare(Object obj, Object obj1)
        {
            obj = (auf)obj;
            obj1 = (auf)obj1;
            obj = ((auf) (obj)).gq();
            obj1 = ((auf) (obj1)).gq();
            if (obj == null && obj1 == null)
            {
                return 0;
            }
            if (obj == null)
            {
                return -1;
            }
            if (obj1 == null)
            {
                return 1;
            } else
            {
                return ((BigInteger) (obj)).compareTo(((BigInteger) (obj1)));
            }
        }

        if()
        {
        }
    }


    private final zz aUK;
    boolean aUL;
    private boolean aUM;
    private String aUN;
    private final ql mEventBus;

    public yh(zz zz1, ql ql1, yd.if if1, String s)
    {
        super(new if(), if1);
        aUM = false;
        mEventBus = ql1;
        aUK = zz1;
        aUN = s;
    }

    public final void _mth02CA(Map map, Map map1)
    {
        long l;
        int i = 0;
        int j = map.size();
        l = 200L;
        yf yf1;
        for (map = map.values().iterator(); map.hasNext(); _mth02CA((auf)yf1.aUB.poll(), yf1.aUC))
        {
            yf1 = (yf)map.next();
        }

        for (map = map1.values().iterator(); map.hasNext();)
        {
            map1 = (yf)map.next();
            auf auf1 = (auf)((yf) (map1)).aUB.poll();
            if (auf1 == null)
            {
                i++;
            } else
            {
                _mth02CA(((yf) (map1)).aUC);
                if (map1.ready())
                {
                    long l1 = aUK.getCurrentTimeMillis();
                    long l2 = _cls141D.if._mth02CA(auf1.gq());
                    long l3 = System.currentTimeMillis();
                    static final class _cls1
                    {

                        static final int aUJ[];

                        static 
                        {
                            aUJ = new int[aug.values().length];
                            try
                            {
                                aUJ[aug.bEG.ordinal()] = 1;
                            }
                            catch (NoSuchFieldError nosuchfielderror) { }
                        }
                    }

                    if (aUM)
                    {
                        switch (_cls1.aUJ[auf1.go().ordinal()])
                        {
                        case 1: // '\001'
                            mEventBus._mth1429(auf1);
                            break;
                        }
                    } else
                    {
                        boolean flag;
                        if (aUK.getCurrentTimeMillis() >= _cls141D.if._mth02CA(auf1.gq()))
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (flag)
                        {
                            mEventBus._mth1429(auf1);
                        } else
                        if (aUL && l3 >= l2 + (l1 - l3))
                        {
                            if (auf1.go() == aug.bED)
                            {
                                aUM = true;
                            }
                            mEventBus._mth1429(auf1);
                        } else
                        if (auf1.go() == aug.bEC)
                        {
                            mEventBus._mth1429(auf1);
                        } else
                        if (auf1.go() == aug.bEK && aUN.equals(auf1.gz()))
                        {
                            mEventBus._mth1429(auf1);
                        } else
                        {
                            _mth02CE(auf1.go().aUC, auf1);
                        }
                    }
                    map1.aUD = SystemClock.elapsedRealtime();
                    l = Math.min(l, ((yf) (map1)).aUC.duration);
                } else
                {
                    ((yf) (map1)).aUB.offer(auf1);
                    l = Math.min(l, ((yf) (map1)).aUC.duration - (SystemClock.elapsedRealtime() - ((yf) (map1)).aUD));
                }
            }
        }

        if (i < j)
        {
            break MISSING_BLOCK_LABEL_489;
        }
        super.aUp.lock();
        super.aUr.await();
        super.aUp.unlock();
        return;
        map;
        super.aUp.unlock();
        throw map;
        FE76(l);
        return;
    }

    public final boolean _mth02CA(aug._cls02CA _pcls02ca, BlockingQueue blockingqueue, Object obj)
    {
        obj = (auf)obj;
        if ((_pcls02ca == aug._cls02CA.bFa || _pcls02ca == aug._cls02CA.bEZ) && blockingqueue.size() > _pcls02ca.bFc)
        {
            return _cls141D.if._mth02CA(((auf) (obj)).gq()) - aUK.getCurrentTimeMillis() < _pcls02ca.bFd;
        } else
        {
            return false;
        }
    }

    public final boolean _mth1D5B(Object obj)
    {
        obj = (auf)obj;
        if (((auf) (obj)).go() != aug.bEz || ((auf) (obj)).go() != aug.bEA)
        {
            return true;
        }
        return aUK.getCurrentTimeMillis() >= _cls141D.if._mth02CA(((auf) (obj)).gq());
    }
}
