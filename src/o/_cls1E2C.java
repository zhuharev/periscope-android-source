// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            FE93, _cls0645, FF90

public class _cls1E2C
{

    public final FE93 jp;

    public _cls1E2C(FE93 fe93)
    {
        jp = fe93;
    }

    public void _mth02C6(boolean flag)
    {
        if (flag)
        {
            FE93 fe93 = jp;
            Iterator iterator = _cls0645._mth02CA(fe93.qX).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                FF90 ff90 = (FF90)iterator.next();
                if (!ff90._mth027C() && !ff90.isCancelled())
                {
                    ff90.pause();
                    if (!fe93.qZ)
                    {
                        ff90.begin();
                    } else
                    {
                        fe93.qY.add(ff90);
                    }
                }
            } while (true);
        }
    }
}
