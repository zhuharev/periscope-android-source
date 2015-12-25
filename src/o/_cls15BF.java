// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.SystemClock;
import android.util.Log;

// Referenced classes of package o:
//            _cls1551

public final class _cls15BF
{

    private final long zj;
    private final int zk;
    private final _cls1551 zl;

    public _cls15BF()
    {
        zj = 60000L;
        zk = 10;
        zl = new _cls1551(10);
    }

    public _cls15BF(int i, long l)
    {
        zj = l;
        zk = 1024;
        zl = new _cls1551();
    }

    public final Long _mth02B3(String s)
    {
        long l1 = SystemClock.elapsedRealtime();
        long l = zj;
        this;
        JVM INSTR monitorenter ;
_L3:
        if (zl.size() < zk) goto _L2; else goto _L1
_L1:
        int i = zl.size() - 1;
_L4:
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        if (l1 - ((Long)zl.FB48[(i << 1) + 1]).longValue() > l)
        {
            zl.removeAt(i);
        }
        break MISSING_BLOCK_LABEL_148;
        l /= 2L;
        Log.w("ConnectionTracker", (new StringBuilder("The max capacity ")).append(zk).append(" is not enough. Current durationThreshold is: ").append(l).toString());
          goto _L3
_L2:
        s = (Long)zl.put(s, Long.valueOf(l1));
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
        i--;
          goto _L4
    }

    public final boolean _mth02B4(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = ((String) (zl.remove(s)));
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }
}
