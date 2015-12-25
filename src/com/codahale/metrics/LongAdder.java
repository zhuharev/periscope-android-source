// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Referenced classes of package com.codahale.metrics:
//            Striped64

class LongAdder extends Striped64
    implements Serializable
{

    private static final long serialVersionUID = 0x6499de12a37d0a3dL;

    LongAdder()
    {
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        busy = 0;
        cells = null;
        base = objectinputstream.readLong();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeLong(sum());
    }

    public void add(long l)
    {
label0:
        {
            Striped64.Cell acell[] = cells;
            if (acell == null)
            {
                long l1 = base;
                if (casBase(l1, l1 + l))
                {
                    break label0;
                }
            }
            boolean flag1 = true;
            Striped64.HashCode hashcode = (Striped64.HashCode)threadHashCode.get();
            int i = hashcode.code;
            boolean flag = flag1;
            if (acell != null)
            {
                int j = acell.length;
                flag = flag1;
                if (j > 0)
                {
                    Striped64.Cell cell = acell[j - 1 & i];
                    flag = flag1;
                    if (cell != null)
                    {
                        long l2 = cell.value;
                        boolean flag2 = cell.cas(l2, l2 + l);
                        flag = flag2;
                        if (flag2)
                        {
                            break label0;
                        }
                    }
                }
            }
            retryUpdate(l, hashcode, flag);
        }
    }

    public void decrement()
    {
        add(-1L);
    }

    public double doubleValue()
    {
        return (double)sum();
    }

    public float floatValue()
    {
        return (float)sum();
    }

    final long fn(long l, long l1)
    {
        return l + l1;
    }

    public void increment()
    {
        add(1L);
    }

    public int intValue()
    {
        return (int)sum();
    }

    public long longValue()
    {
        return sum();
    }

    public void reset()
    {
        internalReset(0L);
    }

    public long sum()
    {
        long l = base;
        Striped64.Cell acell[] = cells;
        long l1 = l;
        if (acell != null)
        {
            int j = acell.length;
            int i = 0;
            do
            {
                l1 = l;
                if (i >= j)
                {
                    break;
                }
                Striped64.Cell cell = acell[i];
                l1 = l;
                if (cell != null)
                {
                    l1 = l + cell.value;
                }
                i++;
                l = l1;
            } while (true);
        }
        return l1;
    }

    public long sumThenReset()
    {
        long l = base;
        Striped64.Cell acell[] = cells;
        base = 0L;
        long l1 = l;
        if (acell != null)
        {
            int j = acell.length;
            int i = 0;
            do
            {
                l1 = l;
                if (i >= j)
                {
                    break;
                }
                Striped64.Cell cell = acell[i];
                l1 = l;
                if (cell != null)
                {
                    l1 = l + cell.value;
                    cell.value = 0L;
                }
                i++;
                l = l1;
            } while (true);
        }
        return l1;
    }

    public String toString()
    {
        return Long.toString(sum());
    }
}
