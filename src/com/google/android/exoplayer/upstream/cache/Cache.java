// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream.cache;

import java.io.File;
import java.util.NavigableSet;
import java.util.Set;

// Referenced classes of package com.google.android.exoplayer.upstream.cache:
//            CacheSpan

public interface Cache
{
    public static interface Listener
    {

        public abstract void onSpanAdded(Cache cache, CacheSpan cachespan);

        public abstract void onSpanRemoved(Cache cache, CacheSpan cachespan);

        public abstract void onSpanTouched(Cache cache, CacheSpan cachespan, CacheSpan cachespan1);
    }


    public abstract NavigableSet addListener(String s, Listener listener);

    public abstract void commitFile(File file);

    public abstract long getCacheSpace();

    public abstract NavigableSet getCachedSpans(String s);

    public abstract Set getKeys();

    public abstract boolean isCached(String s, long l, long l1);

    public abstract void releaseHoleSpan(CacheSpan cachespan);

    public abstract void removeListener(String s, Listener listener);

    public abstract void removeSpan(CacheSpan cachespan);

    public abstract File startFile(String s, long l, long l1);

    public abstract CacheSpan startReadWrite(String s, long l);

    public abstract CacheSpan startReadWriteNonBlocking(String s, long l);
}
