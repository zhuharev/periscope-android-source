// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.codahale.metrics.Counter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            ya, yl, yn, ql, 
//            yd, ye, ym, yi, 
//            aug, xx, _cls0675, yj, 
//            xz, zl, zz, xw, 
//            zp, agp, yf, aui, 
//            auf

public final class yk
    implements ya
{
    final class if extends yd
    {

        private yk aVh;
        public final yi aVi = new yi();
        private boolean aVj;

        private boolean _mth02CA(ym ym1)
        {
            if (yk._mth02CE(aVh))
            {
                long l = yk._mth02CA(aVh).L();
                long l1 = ym1.e();
                return 0L != l && l >= l1;
            }
            return ym1.aVm <= yk._mth02CA(aVh).J();
        }

        public final void clear()
        {
            super.clear();
            aVi.aUO.clear();
        }

        public final void d()
        {
            this;
            JVM INSTR monitorenter ;
            aVj = false;
            notifyAll();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void pause()
        {
            this;
            JVM INSTR monitorenter ;
            aVj = true;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void _mth02CA(Map map, Map map1)
        {
            long l = 100L;
            this;
            JVM INSTR monitorenter ;
            while (aVj) 
            {
                wait();
            }
            this;
            JVM INSTR monitorexit ;
              goto _L1
            map;
            throw map;
_L1:
            yf yf1;
            for (map = map.values().iterator(); map.hasNext(); _mth02CA((ym)yf1.aUB.poll(), yf1.aUC))
            {
                yf1 = (yf)map.next();
            }

            if (yk._mth02CA(aVh)._mth02CE(yk._mth141D(aVh)))
            {
                if (yk._mth141D(aVh) != null && yk._mth02BD(aVh).g())
                {
                    yk._mth02CA(aVh, yk._mth141D(aVh), null, yk._mth02BD(aVh).aVr, null);
                    map = yk._mth02BD(aVh);
                    map.aVq = false;
                    map.aVp = false;
                }
                if (aui._mth02BF(yk._mth02BB(aVh)) && yk._mth02BC(aVh).g())
                {
                    yk._mth02CA(aVh, yk._mth141D(aVh), yk._mth02BB(aVh), null, yk._mth02BC(aVh).aVr);
                    map = yk._mth02BC(aVh);
                    map.aVq = false;
                    map.aVp = false;
                }
                map = map1.values().iterator();
                do
                {
                    if (!map.hasNext())
                    {
                        break;
                    }
                    map1 = (yf)map.next();
                    ym ym1 = (ym)((yf) (map1)).aUB.poll();
                    _mth02CA(((yf) (map1)).aUC);
                    long l1 = l;
                    if (ym1 != null)
                    {
                        if (map1.ready())
                        {
                            static final class _cls1
                            {

                                static final int aUJ[];

                                static 
                                {
                                    aUJ = new int[aug.values().length];
                                    try
                                    {
                                        aUJ[aug.bEK.ordinal()] = 1;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror) { }
                                    try
                                    {
                                        aUJ[aug.bEL.ordinal()] = 2;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror1) { }
                                    try
                                    {
                                        aUJ[aug.bEE.ordinal()] = 3;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror2) { }
                                    try
                                    {
                                        aUJ[aug.bEB.ordinal()] = 4;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror3) { }
                                    try
                                    {
                                        aUJ[aug.bEz.ordinal()] = 5;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror4) { }
                                    try
                                    {
                                        aUJ[aug.bEA.ordinal()] = 6;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror5) { }
                                    try
                                    {
                                        aUJ[aug.bEy.ordinal()] = 7;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror6) { }
                                }
                            }

                            switch (_cls1.aUJ[ym1.aVk.ordinal()])
                            {
                            case 7: // '\007'
                            default:
                                break;

                            case 1: // '\001'
                            case 2: // '\002'
                            case 3: // '\003'
                            case 4: // '\004'
                            case 5: // '\005'
                            case 6: // '\006'
                                if (ym1.aVk != aug.bEB || yk._mth037A(aVh) <= 20 && ym1.aVm <= yk.c())
                                {
                                    boolean flag;
                                    if (ym1.aVl.fd() == null || !yk._mth1FBE(aVh)._mth14EB(ym1.aVl.fd()))
                                    {
                                        flag = true;
                                    } else
                                    {
                                        flag = false;
                                    }
                                    if (flag)
                                    {
                                        if (_mth02CA(ym1))
                                        {
                                            yk._mth02BE(aVh)._mth1429(ym1.aVl);
                                            if (ym1.aVk == aug.bEB)
                                            {
                                                yk._mth02BF(aVh);
                                            }
                                        } else
                                        {
                                            aug._cls02CA _lcls02ca = ym1.aVk.aUC;
                                            _mth02CE(_lcls02ca, ym1);
                                            if (_lcls02ca.duration <= 0L)
                                            {
                                                super._mth02CA(super.aUq);
                                            }
                                            super._mth02CA(super.aUr);
                                        }
                                    }
                                }
                                break;
                            }
                            map1.aUD = SystemClock.elapsedRealtime();
                            l = Math.min(l, ((yf) (map1)).aUC.duration);
                            continue;
                        }
                        ((yf) (map1)).aUB.offer(ym1);
                        l1 = Math.min(l, ((yf) (map1)).aUC.duration - (SystemClock.elapsedRealtime() - ((yf) (map1)).aUD));
                    }
                    l = l1;
                } while (true);
            } else
            {
                l = 500L;
            }
            FE76(l);
            return;
        }

        public final boolean _mth02CA(aug._cls02CA _pcls02ca, BlockingQueue blockingqueue, Object obj)
        {
            obj = (ym)obj;
            if ((_pcls02ca == aug._cls02CA.bFa || _pcls02ca == aug._cls02CA.bEZ) && blockingqueue.size() > _pcls02ca.bFc)
            {
                return ((ym) (obj)).e() - yk._mth02CA(aVh).L() < _pcls02ca.bFd;
            } else
            {
                return false;
            }
        }

        public final boolean _mth1D5B(Object obj)
        {
            obj = (ym)obj;
            if (((ym) (obj)).aVk != aug.bEz && ((ym) (obj)).aVk != aug.bEA)
            {
                return true;
            } else
            {
                return _mth02CA(((ym) (obj)));
            }
        }

        public if()
        {
            aVh = yk.this;
            Object obj;
            if (yk._mth02CE(yk.this))
            {
                obj = new _cls02CA();
            } else
            {
                obj = new _cls02CB();
            }
            super(((java.util.Comparator) (obj)), yk._mth02CF(yk.this));
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private static final long aUS;
    private zl aUE;
    private final zz aUK;
    private if aUT;
    private yj aUU;
    private xz aUV;
    private final Handler aUW = new Handler(Looper.getMainLooper());
    private volatile xx aUX;
    private volatile boolean aUY;
    private int aUZ;
    private xw aVa;
    private yd.if aVb;
    private String aVc;
    private final ql mEventBus;

    public yk(ql ql1, zp zp, xw xw, agp agp, boolean flag, agp agp1)
    {
        mEventBus = ql1;
        aUE = zp;
        aUK = agp;
        aUY = flag;
        aVa = xw;
        aVb = agp1;
    }

    static long c()
    {
        return aUS;
    }

    static String _mth02BB(yk yk1)
    {
        return yk1.aVc;
    }

    static yn _mth02BC(yk yk1)
    {
        return yk1.aUV;
    }

    static yn _mth02BD(yk yk1)
    {
        return yk1.aUU;
    }

    static ql _mth02BE(yk yk1)
    {
        return yk1.mEventBus;
    }

    static int _mth02BF(yk yk1)
    {
        int i = yk1.aUZ;
        yk1.aUZ = i + 1;
        return i;
    }

    static zz _mth02CA(yk yk1)
    {
        return yk1.aUK;
    }

    static void _mth02CA(yk yk1, xx xx1, String s, String s1, String s2)
    {
        yk1.aUW.post(new yl(yk1, s1, s2, xx1, s));
    }

    static xw _mth02CB(yk yk1)
    {
        return yk1.aVa;
    }

    static boolean _mth02CE(yk yk1)
    {
        return yk1.aUY;
    }

    static yd.if _mth02CF(yk yk1)
    {
        return yk1.aVb;
    }

    static int _mth037A(yk yk1)
    {
        return yk1.aUZ;
    }

    static xx _mth141D(yk yk1)
    {
        return yk1.aUX;
    }

    static zl _mth1FBE(yk yk1)
    {
        return yk1.aUE;
    }

    public final void clear()
    {
        aUZ = 0;
        if (aUT != null)
        {
            aUT.clear();
        }
        if (aUU != null)
        {
            yj yj1 = aUU;
            yj1.aVq = false;
            yj1.aVp = false;
        }
        if (aUV != null)
        {
            xz xz1 = aUV;
            xz1.aVq = false;
            xz1.aVp = false;
        }
    }

    public final void init()
    {
        aUZ = 0;
        mEventBus._mth02CA(this, false, 0);
    }

    public final void kill()
    {
        mEventBus.unregister(this);
        if (aUT != null)
        {
            if if1 = aUT;
            if1.aUv = false;
            if1.clear();
        }
    }

    public final void onEventMainThread(ye ye1)
    {
        if (aUT == null || aUU == null)
        {
            return;
        }
        Object obj = new ArrayList();
        Iterator iterator = ye1.aUz.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ym ym1 = (ym)iterator.next();
            if (!aUT.aVi._mth02CB(ym1.aVl))
            {
                ((ArrayList) (obj)).add(ym1);
            }
        } while (true);
        if (ye1.Ug == 1)
        {
            aUU._mth02CA(((List) (obj)), ye1.aUA, ye1.cursor);
        } else
        {
            aUV._mth02CA(((List) (obj)), ye1.aUA, ye1.cursor);
        }
        for (ye1 = ((ArrayList) (obj)).iterator(); ye1.hasNext(); aUT._mth02CA(((ym) (obj)).aVk.aUC, obj))
        {
            obj = (ym)ye1.next();
        }

    }

    public final void pause()
    {
        if (aUT != null)
        {
            aUT.pause();
        }
    }

    public final void resume()
    {
        if (aUT != null)
        {
            aUT.d();
        }
    }

    public final void seek(long l)
    {
        aUU.seekTo(l);
        aUV.seekTo(l);
        Object obj = aUU;
        obj.aVq = false;
        obj.aVp = true;
        obj = aUV;
        obj.aVq = false;
        obj.aVp = true;
        if (aUT != null)
        {
            aUT.clear();
            aUT.d();
        }
    }

    public final void _mth02CA(xx xx1, String s, String s1)
    {
        s = null;
        if (aUX != null)
        {
            s = aUX.aUj;
        }
        _cls0675.setString("oldChannel", s);
        _cls0675.setString("newChannel", xx1.aUj);
        aUX = xx1;
        aVc = s1;
    }

    public final long _mth1D45(int i)
    {
        return ((Counter)aUT.aVi.aUR.get(i)).getCount();
    }

    public final void _mth1D5B(boolean flag)
    {
        aUY = flag;
        if (aUT != null || aUU != null)
        {
            mEventBus.unregister(this);
            if (aUT != null)
            {
                if if1 = aUT;
                if1.aUv = false;
                if1.clear();
            }
        }
        aUT = new if();
        aUU = new yj(aUY, Collections.unmodifiableMap(((yd) (aUT)).aUt));
        aUV = new xz(aUY, Collections.unmodifiableMap(((yd) (aUT)).aUt));
        aUT.start();
    }

    public final int FEDB()
    {
        Integer integer = (Integer)((yd) (aUT)).aUw.get(aug._cls02CA.bFa);
        if (integer != null)
        {
            return integer.intValue();
        } else
        {
            return 0;
        }
    }

    public final int FF4B()
    {
        Integer integer = (Integer)((yd) (aUT)).aUw.get(aug._cls02CA.bEZ);
        if (integer != null)
        {
            return integer.intValue();
        } else
        {
            return 0;
        }
    }

    static 
    {
        aUS = TimeUnit.SECONDS.toMillis(60L);
    }
}
