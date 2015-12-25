// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

// Referenced classes of package o:
//            FEAE

final class _cls14A9
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    final HashMap nV = new HashMap();
    final _cls02CA nW = new _cls02CA((byte)0);

    _cls14A9()
    {
    }

    final void _mth02BB(FEAE feae)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = (if)nV.get(feae);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        if (((if) (obj)).nY > 0)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        feae = (new StringBuilder("Cannot release a lock that is not held, key: ")).append(feae).append(", interestedThreads: ");
        int i;
        if (obj == null)
        {
            i = 0;
            break MISSING_BLOCK_LABEL_62;
        }
        i = ((if) (obj)).nY;
        throw new IllegalArgumentException(feae.append(i).toString());
        i = ((if) (obj)).nY - 1;
        obj.nY = i;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        if if1;
        _cls02CA _lcls02ca;
        if1 = (if)nV.remove(feae);
        if (!if1.equals(obj))
        {
            throw new IllegalStateException((new StringBuilder("Removed the wrong lock, expected to remove: ")).append(obj).append(", but actually removed: ").append(if1).append(", key: ").append(feae).toString());
        }
        _lcls02ca = nW;
        feae = _lcls02ca.nZ;
        feae;
        JVM INSTR monitorenter ;
        if (_lcls02ca.nZ.size() < 10)
        {
            _lcls02ca.nZ.offer(if1);
        }
        feae;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_213;
        obj;
        throw obj;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        feae;
        throw feae;
_L1:
        ((if) (obj)).nX.unlock();
        return;
    }
}
