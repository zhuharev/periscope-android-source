// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.SparseArray;
import com.codahale.metrics.Counter;
import java.util.Map;

// Referenced classes of package o:
//            ya, yi, yh, zl, 
//            auf, aug, ql, yd, 
//            aue, FF6A, yc, zp, 
//            zz, agp, xx

public final class yg
    implements ya
{

    private final zl aUE;
    public final yh aUF;
    private final yc aUG;
    public yi aUH;
    public String aUI;
    public final ql mEventBus;

    public yg(ql ql1, zp zp, zz zz, yc yc1, agp agp)
    {
        aUH = new yi();
        mEventBus = ql1;
        aUE = zp;
        aUF = new yh(zz, ql1, agp, aUE.B());
        aUG = yc1;
    }

    private void _mth02CA(auf auf1)
    {
        String s = aUE.B();
        if (1 == auf1.gF() && s.equals(auf1.fd()))
        {
            (new StringBuilder("Not queueing our own event: ")).append(auf1.go());
            return;
        } else
        {
            aUF._mth02CA(auf1.go().aUC, auf1);
            return;
        }
    }

    public final void clear()
    {
        aUF.clear();
    }

    public final void init()
    {
        aUF.start();
        mEventBus._mth02CA(this, false, 0);
    }

    public final void kill()
    {
        yh yh1 = aUF;
        yh1.aUv = false;
        yh1.clear();
        mEventBus.unregister(this);
    }

    public final void onEventMainThread(aue aue1)
    {
label0:
        {
            aue1 = aue1.gm();
            if (aUE._mth14EB(aue1.fd()) && aue1.go().bER != aug.if.bEW)
            {
                return;
            }
            if (aue1.go().bER == aug.if.bEW && aUI != null && !aUI.equals(aue1.fd()))
            {
                FF6A._mth02CE("ChatQueue", (new StringBuilder("Received broadcast message from non-broadcaster: ")).append(aue1).toString());
                return;
            }
            if (aUH._mth02CB(aue1))
            {
                (new StringBuilder("Filtered message: ")).append(aue1);
                return;
            }
            static final class _cls1
            {

                static final int aUJ[];

                static 
                {
                    aUJ = new int[aug.values().length];
                    try
                    {
                        aUJ[aug.bED.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                    try
                    {
                        aUJ[aug.bEK.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        aUJ[aug.bEE.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        aUJ[aug.bEz.ordinal()] = 4;
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
                        aUJ[aug.bEy.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                }
            }

            switch (_cls1.aUJ[aue1.go().ordinal()])
            {
            default:
                break;

            case 1: // '\001'
                if (1 != aue1.gF() || !aUE.B().equals(aue1.fd()))
                {
                    aUF.aUL = true;
                    break;
                }
                break label0;

            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
                _mth02CA(aue1);
                return;

            case 6: // '\006'
                if (aUG.FF87() <= 20)
                {
                    _mth02CA(aue1);
                    return;
                }
                break label0;

            case 7: // '\007'
                return;
            }
            aUF._mth02CB(aue1.go().aUC, aue1);
        }
    }

    public final void pause()
    {
    }

    public final void resume()
    {
    }

    public final void seek(long l)
    {
    }

    public final void _mth02CA(xx xx, String s, String s1)
    {
        aUI = s;
    }

    public final long _mth1D45(int i)
    {
        return ((Counter)aUH.aUR.get(i)).getCount();
    }

    public final void _mth1D5B(boolean flag)
    {
    }

    public final int FEDB()
    {
        Integer integer = (Integer)((yd) (aUF)).aUw.get(aug._cls02CA.bFa);
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
        Integer integer = (Integer)((yd) (aUF)).aUw.get(aug._cls02CA.bEZ);
        if (integer != null)
        {
            return integer.intValue();
        } else
        {
            return 0;
        }
    }
}
