// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.LinkedHashMap;
import java.util.concurrent.Callable;

// Referenced classes of package o:
//            _cls1D66

final class _cls1E8B
    implements Callable
{

    private _cls1D66 km;

    _cls1E8B(_cls1D66 _pcls1d66)
    {
        km = _pcls1d66;
        super();
    }

    private Void _mth01CF()
    {
        _cls1D66 _lcls1d66 = km;
        _lcls1d66;
        JVM INSTR monitorenter ;
        Object obj = km.kj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        _lcls1d66;
        JVM INSTR monitorexit ;
        return null;
        km.trimToSize();
        obj = km;
        Exception exception;
        boolean flag;
        if (((_cls1D66) (obj)).redundantOpCount >= 2000 && ((_cls1D66) (obj)).redundantOpCount >= ((_cls1D66) (obj)).lruEntries.size())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        km.rebuildJournal();
        km.redundantOpCount = 0;
        _lcls1d66;
        JVM INSTR monitorexit ;
          goto _L1
        exception;
        throw exception;
_L1:
        return null;
    }

    public final Object call()
    {
        return _mth01CF();
    }
}
