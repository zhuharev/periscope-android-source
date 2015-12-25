// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.LinkedList;
import java.util.List;

// Referenced classes of package o:
//            FF6A, apd

public final class apc
{

    private final int bya[] = {
        0, 32, 4096
    };
    private LinkedList byb;
    private LinkedList byc;
    private LinkedList byd;
    private int bye;
    private int byf;

    public apc()
    {
        byb = new LinkedList();
        byc = new LinkedList();
        byd = new LinkedList();
        bye = 0;
        byf = 0;
    }

    private List FE7F(int i)
    {
        LinkedList linkedlist = byb;
        if (i > bya[2])
        {
            return byd;
        }
        if (i > bya[1])
        {
            linkedlist = byc;
        }
        return linkedlist;
    }

    public final void shutdown()
    {
        FF6A._mth02CB("RTMP", (new StringBuilder("Buffer pool: ")).append(byf).append(" / ").append(bye).toString());
    }

    public final void _mth02CB(apd apd1)
    {
        List list;
        if (apd1.ef() != this)
        {
            FF6A._mth02CB("RTMP", "Pool anomaly");
        }
        list = FE7F(apd1.buffer.length);
        apd1.length = 0;
        this;
        JVM INSTR monitorenter ;
        byf = byf - 1;
        list.add(apd1);
        this;
        JVM INSTR monitorexit ;
        return;
        apd1;
        throw apd1;
    }

    public final apd FE98(int i)
    {
        apd apd1 = null;
        this;
        JVM INSTR monitorenter ;
        List list;
        list = FE7F(i);
        if (list.size() > 0)
        {
            apd1 = (apd)list.remove(0);
        }
        apd apd2;
        apd2 = apd1;
        if (apd1 != null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        apd2 = new apd();
        apd2._mth02CA(this);
        bye = bye + 1;
        apd2.FEAB(i);
          goto _L1
_L3:
        list.add(apd2);
        this;
        JVM INSTR monitorexit ;
        return null;
_L1:
        byf = byf + 1;
        this;
        JVM INSTR monitorexit ;
        return apd2;
        Object obj;
        obj;
        throw obj;
        obj;
        if (true) goto _L3; else goto _L2
_L2:
    }
}
