// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream.cache;


// Referenced classes of package com.google.android.exoplayer.upstream.cache:
//            CacheEvictor, Cache, CacheSpan

public final class NoOpCacheEvictor
    implements CacheEvictor
{

    public NoOpCacheEvictor()
    {
    }

    public final void onSpanAdded(Cache cache, CacheSpan cachespan)
    {
    }

    public final void onSpanRemoved(Cache cache, CacheSpan cachespan)
    {
    }

    public final void onSpanTouched(Cache cache, CacheSpan cachespan, CacheSpan cachespan1)
    {
    }

    public final void onStartFile(Cache cache, String s, long l, long l1)
    {
    }
}
