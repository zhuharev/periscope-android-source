// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream.cache;

import java.util.Comparator;
import java.util.TreeSet;

// Referenced classes of package com.google.android.exoplayer.upstream.cache:
//            CacheEvictor, CacheSpan, Cache

public final class LeastRecentlyUsedCacheEvictor
    implements CacheEvictor, Comparator
{

    private long currentSize;
    private final TreeSet leastRecentlyUsed = new TreeSet(this);
    private final long maxBytes;

    public LeastRecentlyUsedCacheEvictor(long l)
    {
        maxBytes = l;
    }

    private void evictCache(Cache cache, long l)
    {
        while (currentSize + l > maxBytes) 
        {
            cache.removeSpan((CacheSpan)leastRecentlyUsed.first());
        }
    }

    public final int compare(CacheSpan cachespan, CacheSpan cachespan1)
    {
        if (cachespan.lastAccessTimestamp - cachespan1.lastAccessTimestamp == 0L)
        {
            return cachespan.compareTo(cachespan1);
        }
        return cachespan.lastAccessTimestamp >= cachespan1.lastAccessTimestamp ? 1 : -1;
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        return compare((CacheSpan)obj, (CacheSpan)obj1);
    }

    public final void onSpanAdded(Cache cache, CacheSpan cachespan)
    {
        leastRecentlyUsed.add(cachespan);
        currentSize = currentSize + cachespan.length;
        evictCache(cache, 0L);
    }

    public final void onSpanRemoved(Cache cache, CacheSpan cachespan)
    {
        leastRecentlyUsed.remove(cachespan);
        currentSize = currentSize - cachespan.length;
    }

    public final void onSpanTouched(Cache cache, CacheSpan cachespan, CacheSpan cachespan1)
    {
        onSpanRemoved(cache, cachespan);
        onSpanAdded(cache, cachespan1);
    }

    public final void onStartFile(Cache cache, String s, long l, long l1)
    {
        evictCache(cache, l1);
    }
}
