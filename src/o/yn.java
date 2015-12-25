// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            yf, ym, aug, auf

abstract class yn
{

    private static final long aVn;
    private final boolean aUY;
    private final Map aVo;
    volatile boolean aVp;
    volatile boolean aVq;
    String aVr;
    private final int hg;
    private long FB3B;

    public yn(boolean flag, Map map, int i)
    {
        aUY = flag;
        aVo = map;
        hg = i;
    }

    private int f()
    {
        int i = 0;
        for (Iterator iterator = aVo.values().iterator(); iterator.hasNext();)
        {
            i += ((yf)iterator.next()).aUB.size();
        }

        return i;
    }

    final boolean g()
    {
label0:
        {
            if (!aVq)
            {
                if (!aVp)
                {
                    break label0;
                }
                boolean flag;
                if (f() < hg)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    Object obj = aug._cls02CA.bFa;
                    obj = (yf)aVo.get(obj);
                    int i;
                    if (obj != null)
                    {
                        i = ((yf) (obj)).aUB.size();
                    } else
                    {
                        i = 0;
                    }
                    if (i < hg)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (!i)
                    {
                        break label0;
                    }
                }
            }
            return true;
        }
        return false;
    }

    final void seekTo(long l)
    {
        if (aUY)
        {
            l = _mth2071(l);
        } else
        {
            l = FB3B + _mth2071(l);
        }
        aVr = String.valueOf(l);
    }

    public void _mth02CA(List list, boolean flag, String s)
    {
        boolean flag1;
label0:
        {
label1:
            {
                long l;
                long l1;
label2:
                {
                    double d1 = 0.0D;
                    Iterator iterator = list.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        ym ym1 = (ym)iterator.next();
                        static final class _cls1
                        {

                            static final int aUJ[];

                            static 
                            {
                                aUJ = new int[aug.values().length];
                                try
                                {
                                    aUJ[aug.bEH.ordinal()] = 1;
                                }
                                catch (NoSuchFieldError nosuchfielderror) { }
                                try
                                {
                                    aUJ[aug.bEE.ordinal()] = 2;
                                }
                                catch (NoSuchFieldError nosuchfielderror1) { }
                                try
                                {
                                    aUJ[aug.bEG.ordinal()] = 3;
                                }
                                catch (NoSuchFieldError nosuchfielderror2) { }
                                try
                                {
                                    aUJ[aug.bED.ordinal()] = 4;
                                }
                                catch (NoSuchFieldError nosuchfielderror3) { }
                                try
                                {
                                    aUJ[aug.bEA.ordinal()] = 5;
                                }
                                catch (NoSuchFieldError nosuchfielderror4) { }
                                try
                                {
                                    aUJ[aug.bEB.ordinal()] = 6;
                                }
                                catch (NoSuchFieldError nosuchfielderror5) { }
                                try
                                {
                                    aUJ[aug.bEz.ordinal()] = 7;
                                }
                                catch (NoSuchFieldError nosuchfielderror6) { }
                            }
                        }

                        switch (_cls1.aUJ[ym1.aVk.ordinal()])
                        {
                        case 1: // '\001'
                            Double double1 = ym1.aVl.gu();
                            double d = d1;
                            if (double1 != null)
                            {
                                d = d1 + double1.doubleValue();
                            }
                            d1 = d;
                            if (FB3B == 0L)
                            {
                                FB3B = ym1.timestamp;
                                d1 = d;
                            }
                            break;

                        case 2: // '\002'
                        case 3: // '\003'
                        case 4: // '\004'
                        case 5: // '\005'
                        case 6: // '\006'
                        case 7: // '\007'
                            if (FB3B == 0L)
                            {
                                FB3B = ym1.timestamp;
                            }
                            ym1.aVm = _mth1D62(ym1.timestamp - FB3B) - (long)d1;
                            break;
                        }
                    } while (true);
                    int i = list.size();
                    if (i <= 0 || !aUY || !flag)
                    {
                        break label1;
                    }
                    l1 = ((ym)list.get(i - 1)).e();
                    if (l1 == 0L)
                    {
                        break label1;
                    }
                    for (list = list.iterator(); list.hasNext();)
                    {
                        l = ((ym)list.next()).e();
                        if (l != 0L)
                        {
                            break label2;
                        }
                    }

                    l = 0L;
                }
                if (l != 0L && l1 < l + aVn)
                {
                    flag1 = true;
                    break label0;
                }
            }
            flag1 = false;
        }
        if (flag1 || flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aVq = flag1;
        aVp = flag;
        aVr = s;
    }

    protected abstract long _mth1D62(long l);

    protected abstract long _mth2071(long l);

    static 
    {
        aVn = TimeUnit.SECONDS.toMillis(8L);
    }
}
