// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.List;

// Referenced classes of package o:
//            ub, _cls0E01, tl, th, 
//            _cls1439

final class _cls098C
    implements ub
{

    private final _cls1439 sI;
    private final _cls0E01 sJ;

    _cls098C(_cls1439 _pcls1439, _cls0E01 _pcls0e01)
    {
        sI = _pcls1439;
        sJ = _pcls0e01;
    }

    public final boolean send(List list)
    {
        long l = System.nanoTime();
        _cls0E01 _lcls0e01 = sJ;
        tl tl3 = _lcls0e01.sU;
        long l1 = tl3.sR._mth1D65(tl3.Tf);
        boolean flag;
        if (l - _lcls0e01.sT >= 0xf4240L * l1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (sI.send(list))
            {
                list = sJ;
                list.sT = 0L;
                tl tl1 = ((_cls0E01) (list)).sU;
                list.sU = new tl(tl1.sR, tl1.Tg);
                return true;
            } else
            {
                list = sJ;
                list.sT = l;
                tl tl2 = ((_cls0E01) (list)).sU;
                list.sU = new tl(tl2.Tf + 1, tl2.sR, tl2.Tg);
                return false;
            }
        } else
        {
            return false;
        }
    }
}
