// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.net.Uri;
import com.google.android.exoplayer.util.Assertions;
import java.util.Arrays;

public final class DataSpec
{

    public static final int FLAG_ALLOW_GZIP = 1;
    public final long absoluteStreamPosition;
    public final int flags;
    public final String key;
    public final long length;
    public final long position;
    public final byte postBody[];
    public final Uri uri;

    public DataSpec(Uri uri1)
    {
        this(uri1, 0);
    }

    public DataSpec(Uri uri1, int i)
    {
        this(uri1, 0L, -1L, null, i);
    }

    public DataSpec(Uri uri1, long l, long l1, long l2, 
            String s, int i)
    {
        this(uri1, null, l, l1, l2, s, i);
    }

    public DataSpec(Uri uri1, long l, long l1, String s)
    {
        this(uri1, l, l, l1, s, 0);
    }

    public DataSpec(Uri uri1, long l, long l1, String s, int i)
    {
        this(uri1, l, l, l1, s, i);
    }

    public DataSpec(Uri uri1, byte abyte0[], long l, long l1, long l2, String s, int i)
    {
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (l1 >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (l2 > 0L || l2 == -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        uri = uri1;
        postBody = abyte0;
        absoluteStreamPosition = l;
        position = l1;
        length = l2;
        key = s;
        flags = i;
    }

    public final String toString()
    {
        return (new StringBuilder("DataSpec[")).append(uri).append(", ").append(Arrays.toString(postBody)).append(", ").append(absoluteStreamPosition).append(", ").append(position).append(", ").append(length).append(", ").append(key).append(", ").append(flags).append("]").toString();
    }
}
