// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.Closeable;
import o.wn;

// Referenced classes of package com.squareup.okhttp.internal:
//            DiskLruCache, Util

public final class <init>
    implements Closeable
{

    private final String key;
    private final long lengths[];
    private final long sequenceNumber;
    private final wn sources[];
    final DiskLruCache this$0;

    public final void close()
    {
        wn awn[] = sources;
        int j = awn.length;
        for (int i = 0; i < j; i++)
        {
            Util.closeQuietly(awn[i]);
        }

    }

    public final sources edit()
    {
        return DiskLruCache.access$2200(DiskLruCache.this, key, sequenceNumber);
    }

    public final long getLength(int i)
    {
        return lengths[i];
    }

    public final wn getSource(int i)
    {
        return sources[i];
    }

    public final String key()
    {
        return key;
    }


    private (String s, long l, wn awn[], long al[])
    {
        this$0 = DiskLruCache.this;
        super();
        key = s;
        sequenceNumber = l;
        sources = awn;
        lengths = al;
    }

    lengths(String s, long l, wn awn[], long al[], lengths lengths1)
    {
        this(s, l, awn, al);
    }
}
