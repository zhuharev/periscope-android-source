// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream.cache;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CacheSpan
    implements Comparable
{

    private static final String SUFFIX = ".v1.exo";
    private static final String SUFFIX_ESCAPED = "\\.v1\\.exo";
    private static final Pattern cacheFilePattern = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)(\\.v1\\.exo)$");
    public final File file;
    public final boolean isCached;
    public final String key;
    public final long lastAccessTimestamp;
    public final long length;
    public final long position;

    CacheSpan(String s, long l, long l1, boolean flag, long l2, File file1)
    {
        key = s;
        position = l;
        length = l1;
        isCached = flag;
        file = file1;
        lastAccessTimestamp = l2;
    }

    public static CacheSpan createCacheEntry(File file1)
    {
        Matcher matcher = cacheFilePattern.matcher(file1.getName());
        if (!matcher.matches())
        {
            return null;
        } else
        {
            return createCacheEntry(matcher.group(1), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)), file1);
        }
    }

    private static CacheSpan createCacheEntry(String s, long l, long l1, File file1)
    {
        return new CacheSpan(s, l, file1.length(), true, l1, file1);
    }

    public static CacheSpan createClosedHole(String s, long l, long l1)
    {
        return new CacheSpan(s, l, l1, false, -1L, null);
    }

    public static CacheSpan createLookup(String s, long l)
    {
        return new CacheSpan(s, l, -1L, false, -1L, null);
    }

    public static CacheSpan createOpenHole(String s, long l)
    {
        return new CacheSpan(s, l, -1L, false, -1L, null);
    }

    public static File getCacheFileName(File file1, String s, long l, long l1)
    {
        return new File(file1, (new StringBuilder()).append(s).append(".").append(l).append(".").append(l1).append(".v1.exo").toString());
    }

    public final int compareTo(CacheSpan cachespan)
    {
        if (!key.equals(cachespan.key))
        {
            return key.compareTo(cachespan.key);
        }
        long l = position - cachespan.position;
        if (l == 0L)
        {
            return 0;
        }
        return l >= 0L ? 1 : -1;
    }

    public final volatile int compareTo(Object obj)
    {
        return compareTo((CacheSpan)obj);
    }

    public final boolean isOpenEnded()
    {
        return length == -1L;
    }

    public final CacheSpan touch()
    {
        long l = System.currentTimeMillis();
        File file1 = getCacheFileName(file.getParentFile(), key, position, l);
        file.renameTo(file1);
        return createCacheEntry(key, position, l, file1);
    }

}
