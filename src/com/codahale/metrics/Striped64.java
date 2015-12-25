// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Random;
import sun.misc.Unsafe;

abstract class Striped64 extends Number
{
    static final class Cell
    {

        private static final Unsafe UNSAFE;
        private static final long valueOffset;
        volatile long p0;
        volatile long p1;
        volatile long p2;
        volatile long p3;
        volatile long p4;
        volatile long p5;
        volatile long p6;
        volatile long q0;
        volatile long q1;
        volatile long q2;
        volatile long q3;
        volatile long q4;
        volatile long q5;
        volatile long q6;
        volatile long value;

        final boolean cas(long l, long l1)
        {
            return UNSAFE.compareAndSwapLong(this, valueOffset, l, l1);
        }

        static 
        {
            try
            {
                UNSAFE = Striped64.getUnsafe();
                valueOffset = UNSAFE.objectFieldOffset(com/codahale/metrics/Striped64$Cell.getDeclaredField("value"));
            }
            catch (Exception exception)
            {
                throw new Error(exception);
            }
        }

        Cell(long l)
        {
            value = l;
        }
    }

    static final class HashCode
    {

        static final Random rng = new Random();
        int code;


        HashCode()
        {
            int i = rng.nextInt();
            if (i == 0)
            {
                i = 1;
            }
            code = i;
        }
    }

    static final class ThreadHashCode extends ThreadLocal
    {

        public final HashCode initialValue()
        {
            return new HashCode();
        }

        public final volatile Object initialValue()
        {
            return initialValue();
        }

        ThreadHashCode()
        {
        }
    }


    static final int NCPU = Runtime.getRuntime().availableProcessors();
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    static final ThreadHashCode threadHashCode = new ThreadHashCode();
    volatile transient long base;
    volatile transient int busy;
    volatile transient Cell cells[];

    Striped64()
    {
    }

    private static Unsafe getUnsafe()
    {
        SecurityException securityexception;
        Unsafe unsafe;
        PrivilegedActionException privilegedactionexception;
        try
        {
            unsafe = Unsafe.getUnsafe();
        }
        // Misplaced declaration of an exception variable
        catch (SecurityException securityexception)
        {
            try
            {
                unsafe = (Unsafe)AccessController.doPrivileged(new _cls1());
            }
            // Misplaced declaration of an exception variable
            catch (PrivilegedActionException privilegedactionexception)
            {
                throw new RuntimeException("Could not initialize intrinsics", privilegedactionexception.getCause());
            }
            return unsafe;
        }
        return unsafe;
    }

    final boolean casBase(long l, long l1)
    {
        return UNSAFE.compareAndSwapLong(this, baseOffset, l, l1);
    }

    final boolean casBusy()
    {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    abstract long fn(long l, long l1);

    final void internalReset(long l)
    {
        Cell acell[] = cells;
        base = l;
        if (acell != null)
        {
            int j = acell.length;
            for (int i = 0; i < j; i++)
            {
                Cell cell = acell[i];
                if (cell != null)
                {
                    cell.value = l;
                }
            }

        }
    }

    final void retryUpdate(long l, HashCode hashcode, boolean flag)
    {
        int j;
        int k;
        k = hashcode.code;
        j = 0;
_L6:
        Cell acell[] = cells;
        if (acell == null) goto _L2; else goto _L1
_L1:
        int i1 = acell.length;
        if (i1 <= 0) goto _L2; else goto _L3
_L3:
        Object obj = acell[i1 - 1 & k];
        if (obj != null) goto _L5; else goto _L4
_L4:
        if (busy != 0)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        acell = new Cell(l);
        if (busy != 0 || !casBusy())
        {
            break MISSING_BLOCK_LABEL_165;
        }
        i1 = 0;
        obj = cells;
        int i;
        i = i1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        int j1 = obj.length;
        i = i1;
        if (j1 > 0)
        {
            j1 = j1 - 1 & k;
            i = i1;
            if (obj[j1] == null)
            {
                obj[j1] = acell;
                i = 1;
            }
        }
        busy = 0;
        break MISSING_BLOCK_LABEL_157;
        hashcode;
        busy = 0;
        throw hashcode;
        if (i != 0)
        {
            break; /* Loop/switch isn't completed */
        }
          goto _L6
        boolean flag1;
        i = 0;
        flag1 = flag;
          goto _L7
_L5:
        if (flag) goto _L9; else goto _L8
_L8:
        flag1 = true;
        i = j;
          goto _L7
_L9:
        long l1 = ((Cell) (obj)).value;
        if (((Cell) (obj)).cas(l1, fn(l1, l)))
        {
            break; /* Loop/switch isn't completed */
        }
        if (i1 < NCPU && cells == acell) goto _L11; else goto _L10
_L10:
        i = 0;
        flag1 = flag;
          goto _L7
_L11:
        if (j != 0) goto _L13; else goto _L12
_L12:
        i = 1;
        flag1 = flag;
          goto _L7
_L13:
        i = j;
        flag1 = flag;
        if (busy != 0) goto _L7; else goto _L14
_L14:
        i = j;
        flag1 = flag;
        if (!casBusy()) goto _L7; else goto _L15
_L15:
        if (cells != acell) goto _L17; else goto _L16
_L16:
        Cell acell1[] = new Cell[i1 << 1];
        i = 0;
        break MISSING_BLOCK_LABEL_499;
_L20:
        cells = acell1;
_L17:
        busy = 0;
        break MISSING_BLOCK_LABEL_332;
        hashcode;
        busy = 0;
        throw hashcode;
        j = 0;
          goto _L6
_L7:
        j = k << 13 ^ k;
        j ^= j >>> 17;
        k = j ^ j << 5;
        j = i;
        flag = flag1;
          goto _L6
_L2:
        if (busy != 0 || cells != acell || !casBusy())
        {
            break MISSING_BLOCK_LABEL_467;
        }
        i = 0;
        if (cells != acell)
        {
            break MISSING_BLOCK_LABEL_443;
        }
        acell = new Cell[2];
        acell[k & 1] = new Cell(l);
        cells = acell;
        i = 1;
        busy = 0;
        continue; /* Loop/switch isn't completed */
        hashcode;
        busy = 0;
        throw hashcode;
        if (i != 0) goto _L18; else goto _L6
_L18:
        break; /* Loop/switch isn't completed */
        long l2 = base;
        if (casBase(l2, fn(l2, l))) goto _L19; else goto _L6
_L19:
        hashcode.code = k;
        return;
        while (i < i1) 
        {
            acell1[i] = acell[i];
            i++;
        }
          goto _L20
    }

    static 
    {
        try
        {
            UNSAFE = getUnsafe();
            baseOffset = UNSAFE.objectFieldOffset(com/codahale/metrics/Striped64.getDeclaredField("base"));
            busyOffset = UNSAFE.objectFieldOffset(com/codahale/metrics/Striped64.getDeclaredField("busy"));
        }
        catch (Exception exception)
        {
            throw new Error(exception);
        }
    }


    private class _cls1
        implements PrivilegedExceptionAction
    {

        public final volatile Object run()
        {
            return run();
        }

        public final Unsafe run()
        {
            Field afield[] = sun/misc/Unsafe.getDeclaredFields();
            int j = afield.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = afield[i];
                ((Field) (obj)).setAccessible(true);
                obj = ((Field) (obj)).get(null);
                if (sun/misc/Unsafe.isInstance(obj))
                {
                    return (Unsafe)sun/misc/Unsafe.cast(obj);
                }
            }

            throw new NoSuchFieldError("the Unsafe");
        }

        _cls1()
        {
        }
    }

}
