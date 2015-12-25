// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import com.google.android.exoplayer.upstream.Allocator;

public interface LoadControl
{

    public abstract Allocator getAllocator();

    public abstract void register(Object obj, int i);

    public abstract void trimAllocator();

    public abstract void unregister(Object obj);

    public abstract boolean update(Object obj, long l, long l1, boolean flag);
}
