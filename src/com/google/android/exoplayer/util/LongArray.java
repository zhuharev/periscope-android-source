// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import java.util.Arrays;

public final class LongArray
{

    private static final int DEFAULT_INITIAL_CAPACITY = 32;
    private int size;
    private long values[];

    public LongArray()
    {
        this(32);
    }

    public LongArray(int i)
    {
        values = new long[i];
    }

    public final void add(long l)
    {
        if (size == values.length)
        {
            values = Arrays.copyOf(values, size << 1);
        }
        long al[] = values;
        int i = size;
        size = i + 1;
        al[i] = l;
    }

    public final long get(int i)
    {
        if (i < 0 || i >= size)
        {
            throw new IndexOutOfBoundsException((new StringBuilder("Invalid size ")).append(i).append(", size is ").append(size).toString());
        } else
        {
            return values[i];
        }
    }

    public final int size()
    {
        return size;
    }

    public final long[] toArray()
    {
        return Arrays.copyOf(values, size);
    }
}
