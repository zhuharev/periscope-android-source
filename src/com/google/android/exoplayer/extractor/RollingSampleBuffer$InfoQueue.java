// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.util.Assertions;

// Referenced classes of package com.google.android.exoplayer.extractor:
//            RollingSampleBuffer

static final class capacity
{

    private static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    private int absoluteReadIndex;
    private int capacity;
    private byte encryptionKeys[][];
    private int flags[];
    private long offsets[];
    private int queueSize;
    private int relativeReadIndex;
    private int relativeWriteIndex;
    private int sizes[];
    private long timesUs[];

    public final void clear()
    {
        absoluteReadIndex = 0;
        relativeReadIndex = 0;
        relativeWriteIndex = 0;
        queueSize = 0;
    }

    public final void commitSample(long l, int i, long l1, int j, byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        timesUs[relativeWriteIndex] = l;
        offsets[relativeWriteIndex] = l1;
        sizes[relativeWriteIndex] = j;
        flags[relativeWriteIndex] = i;
        encryptionKeys[relativeWriteIndex] = abyte0;
        queueSize = queueSize + 1;
        if (queueSize != capacity)
        {
            break MISSING_BLOCK_LABEL_337;
        }
        i = capacity + 1000;
        abyte0 = new long[i];
        long al[] = new long[i];
        int ai[] = new int[i];
        int ai1[] = new int[i];
        byte abyte1[][] = new byte[i][];
        j = capacity - relativeReadIndex;
        System.arraycopy(offsets, relativeReadIndex, abyte0, 0, j);
        System.arraycopy(timesUs, relativeReadIndex, al, 0, j);
        System.arraycopy(flags, relativeReadIndex, ai, 0, j);
        System.arraycopy(sizes, relativeReadIndex, ai1, 0, j);
        System.arraycopy(encryptionKeys, relativeReadIndex, abyte1, 0, j);
        int k = relativeReadIndex;
        System.arraycopy(offsets, 0, abyte0, j, k);
        System.arraycopy(timesUs, 0, al, j, k);
        System.arraycopy(flags, 0, ai, j, k);
        System.arraycopy(sizes, 0, ai1, j, k);
        System.arraycopy(encryptionKeys, 0, abyte1, j, k);
        offsets = abyte0;
        timesUs = al;
        flags = ai;
        sizes = ai1;
        encryptionKeys = abyte1;
        relativeReadIndex = 0;
        relativeWriteIndex = capacity;
        queueSize = capacity;
        capacity = i;
        this;
        JVM INSTR monitorexit ;
        return;
        relativeWriteIndex = relativeWriteIndex + 1;
        if (relativeWriteIndex == capacity)
        {
            relativeWriteIndex = 0;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }

    public final long discardUpstreamSamples(int i)
    {
        i = getWriteIndex() - i;
        boolean flag;
        if (i >= 0 && i <= queueSize)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (i == 0)
        {
            if (absoluteReadIndex == 0)
            {
                return 0L;
            }
            if (relativeWriteIndex == 0)
            {
                i = capacity;
            } else
            {
                i = relativeWriteIndex;
            }
            i--;
            return offsets[i] + (long)sizes[i];
        } else
        {
            queueSize = queueSize - i;
            relativeWriteIndex = ((relativeWriteIndex + capacity) - i) % capacity;
            return offsets[relativeWriteIndex];
        }
    }

    public final int getReadIndex()
    {
        return absoluteReadIndex;
    }

    public final int getWriteIndex()
    {
        return absoluteReadIndex + queueSize;
    }

    public final long moveToNextSample()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        long l;
        queueSize = queueSize - 1;
        i = relativeReadIndex;
        relativeReadIndex = i + 1;
        absoluteReadIndex = absoluteReadIndex + 1;
        if (relativeReadIndex == capacity)
        {
            relativeReadIndex = 0;
        }
        if (queueSize <= 0)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        l = offsets[relativeReadIndex];
        this;
        JVM INSTR monitorexit ;
        return l;
        long l1;
        l = sizes[i];
        l1 = offsets[i];
        this;
        JVM INSTR monitorexit ;
        return l + l1;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean peekSample(SampleHolder sampleholder, asHolder asholder)
    {
        this;
        JVM INSTR monitorenter ;
        if (queueSize != 0)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        sampleholder.timeUs = timesUs[relativeReadIndex];
        sampleholder.size = sizes[relativeReadIndex];
        sampleholder.flags = flags[relativeReadIndex];
        asholder.offset = offsets[relativeReadIndex];
        asholder.encryptionKeyId = encryptionKeys[relativeReadIndex];
        this;
        JVM INSTR monitorexit ;
        return true;
        sampleholder;
        throw sampleholder;
    }

    public final long skipToKeyframeBefore(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (queueSize != 0 && l >= timesUs[relativeReadIndex])
        {
            break MISSING_BLOCK_LABEL_29;
        }
        this;
        JVM INSTR monitorexit ;
        return -1L;
        int i;
        if (relativeWriteIndex == 0)
        {
            i = capacity;
            break MISSING_BLOCK_LABEL_51;
        }
        i = relativeWriteIndex;
        if (l <= timesUs[i - 1])
        {
            break MISSING_BLOCK_LABEL_71;
        }
        this;
        JVM INSTR monitorexit ;
        return -1L;
        int k;
        i = 0;
        k = -1;
        int j = relativeReadIndex;
_L1:
        if (j == relativeWriteIndex || timesUs[j] > l)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        if ((flags[j] & 1) != 0)
        {
            k = i;
        }
        j = (j + 1) % capacity;
        i++;
          goto _L1
        if (k != -1)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        this;
        JVM INSTR monitorexit ;
        return -1L;
        queueSize = queueSize - k;
        relativeReadIndex = (relativeReadIndex + k) % capacity;
        absoluteReadIndex = absoluteReadIndex + k;
        l = offsets[relativeReadIndex];
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public asHolder()
    {
        capacity = 1000;
        offsets = new long[capacity];
        timesUs = new long[capacity];
        flags = new int[capacity];
        sizes = new int[capacity];
        encryptionKeys = new byte[capacity][];
    }
}
