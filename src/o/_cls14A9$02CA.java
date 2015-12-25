// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayDeque;
import java.util.Queue;

// Referenced classes of package o:
//            _cls14A9

static final class <init>
{

    final ArrayDeque nZ;

    final ject _mth1F30()
    {
        ArrayDeque arraydeque = nZ;
        arraydeque;
        JVM INSTR monitorenter ;
        Object obj = (nZ)nZ.poll();
        arraydeque;
        JVM INSTR monitorexit ;
          goto _L1
        obj;
        throw obj;
_L1:
        Object obj1 = obj;
        if (obj == null)
        {
            obj1 = new nit>((byte)0);
        }
        return ((nit>) (obj1));
    }

    private rayDeque()
    {
        nZ = new ArrayDeque();
    }

    rayDeque(byte byte0)
    {
        this();
    }
}
