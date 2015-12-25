// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.util.Arrays;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            Allocator, Allocation

public final class DefaultAllocator
    implements Allocator
{

    private static final int AVAILABLE_EXTRA_CAPACITY = 100;
    private int allocatedCount;
    private Allocation availableAllocations[];
    private int availableCount;
    private final int individualAllocationSize;
    private final byte initialAllocationBlock[];

    public DefaultAllocator(int i)
    {
        this(i, 0);
    }

    public DefaultAllocator(int i, int j)
    {
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (j >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        individualAllocationSize = i;
        availableCount = j;
        availableAllocations = new Allocation[j + 100];
        if (j > 0)
        {
            initialAllocationBlock = new byte[j * i];
            for (int k = 0; k < j; k++)
            {
                availableAllocations[k] = new Allocation(initialAllocationBlock, k * i);
            }

            return;
        } else
        {
            initialAllocationBlock = null;
            return;
        }
    }

    public final Allocation allocate()
    {
        this;
        JVM INSTR monitorenter ;
        Allocation aallocation[];
        int i;
        allocatedCount = allocatedCount + 1;
        if (availableCount <= 0)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        aallocation = availableAllocations;
        i = availableCount - 1;
        availableCount = i;
        Allocation allocation = aallocation[i];
        availableAllocations[availableCount] = null;
        break MISSING_BLOCK_LABEL_68;
        allocation = new Allocation(new byte[individualAllocationSize], 0);
        this;
        JVM INSTR monitorexit ;
        return allocation;
        Exception exception;
        exception;
        throw exception;
    }

    public final void blockWhileTotalBytesAllocatedExceeds(int i)
    {
        this;
        JVM INSTR monitorenter ;
        for (; getTotalBytesAllocated() > i; wait()) { }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final int getIndividualAllocationLength()
    {
        return individualAllocationSize;
    }

    public final int getTotalBytesAllocated()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = allocatedCount;
        j = individualAllocationSize;
        this;
        JVM INSTR monitorexit ;
        return i * j;
        Exception exception;
        exception;
        throw exception;
    }

    public final void release(Allocation allocation)
    {
        this;
        JVM INSTR monitorenter ;
        Allocation aallocation[];
        int i;
        boolean flag;
        if (allocation.data == initialAllocationBlock || allocation.data.length == individualAllocationSize)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        allocatedCount = allocatedCount - 1;
        if (availableCount == availableAllocations.length)
        {
            availableAllocations = (Allocation[])Arrays.copyOf(availableAllocations, availableAllocations.length << 1);
        }
        aallocation = availableAllocations;
        i = availableCount;
        availableCount = i + 1;
        aallocation[i] = allocation;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        allocation;
        throw allocation;
    }

    public final void trim(int i)
    {
        this;
        JVM INSTR monitorenter ;
        i = Math.max(0, Util.ceilDivide(i, individualAllocationSize) - allocatedCount);
        int k = i;
        if (i < availableCount)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        i = k;
        if (initialAllocationBlock == null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        i = 0;
        int j = availableCount - 1;
_L2:
        if (i > j)
        {
            break; /* Loop/switch isn't completed */
        }
        Allocation allocation = availableAllocations[i];
        if (allocation.data == initialAllocationBlock)
        {
            i++;
            continue; /* Loop/switch isn't completed */
        }
        Allocation allocation1 = availableAllocations[i];
        if (allocation1.data != initialAllocationBlock)
        {
            j--;
            continue; /* Loop/switch isn't completed */
        }
        Allocation aallocation1[] = availableAllocations;
        int l;
        l = i + 1;
        aallocation1[i] = allocation1;
        Allocation aallocation[] = availableAllocations;
        int i1 = j - 1;
        aallocation[j] = allocation;
        i = l;
        j = i1;
        if (true) goto _L2; else goto _L1
_L1:
        j = Math.max(k, i);
        i = j;
        if (j < availableCount)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Arrays.fill(availableAllocations, i, availableCount, null);
        availableCount = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
