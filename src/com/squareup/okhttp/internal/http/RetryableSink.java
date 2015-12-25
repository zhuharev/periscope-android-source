// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.net.ProtocolException;
import o.vr;
import o.wm;
import o.wo;

public final class RetryableSink
    implements wm
{

    private boolean closed;
    private final vr content;
    private final int limit;

    public RetryableSink()
    {
        this(-1);
    }

    public RetryableSink(int i)
    {
        content = new vr();
        limit = i;
    }

    public final void close()
    {
        if (closed)
        {
            return;
        }
        closed = true;
        if (content.size < (long)limit)
        {
            throw new ProtocolException((new StringBuilder("content-length promised ")).append(limit).append(" bytes, but received ").append(content.size).toString());
        } else
        {
            return;
        }
    }

    public final long contentLength()
    {
        return content.size;
    }

    public final void flush()
    {
    }

    public final wo timeout()
    {
        return wo.NONE;
    }

    public final void write(vr vr1, long l)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        Util.checkOffsetAndCount(vr1.size, 0L, l);
        if (limit != -1 && content.size > (long)limit - l)
        {
            throw new ProtocolException((new StringBuilder("exceeded content-length limit of ")).append(limit).append(" bytes").toString());
        } else
        {
            content.write(vr1, l);
            return;
        }
    }

    public final void writeToSocket(wm wm1)
    {
        vr vr1 = new vr();
        content._mth02CA(vr1, 0L, content.size);
        wm1.write(vr1, vr1.size);
    }
}
