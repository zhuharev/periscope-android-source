// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            Reservoir, UniformSnapshot, Snapshot

public class SlidingWindowReservoir
    implements Reservoir
{

    private long count;
    private final long measurements[];

    public SlidingWindowReservoir(int i)
    {
        measurements = new long[i];
        count = 0L;
    }

    public Snapshot getSnapshot()
    {
        Object obj;
        int i;
        obj = new long[size()];
        i = 0;
_L3:
        if (i >= obj.length)
        {
            break; /* Loop/switch isn't completed */
        }
        this;
        JVM INSTR monitorenter ;
        obj[i] = measurements[i];
        this;
        JVM INSTR monitorexit ;
          goto _L1
        obj;
        throw obj;
_L1:
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        return new UniformSnapshot(((long []) (obj)));
    }

    public int size()
    {
        this;
        JVM INSTR monitorenter ;
        long l = Math.min(count, measurements.length);
        int i = (int)l;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public void update(long l)
    {
        this;
        JVM INSTR monitorenter ;
        long al[] = measurements;
        long l1 = count;
        count = 1L + l1;
        al[(int)(l1 % (long)measurements.length)] = l;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
