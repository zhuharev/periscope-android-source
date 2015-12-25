// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.net.ProtocolException;
import o.vr;
import o.vu;
import o.wm;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

final class <init>
    implements wm
{

    private long bytesRemaining;
    private boolean closed;
    final HttpConnection this$0;

    public final void close()
    {
        if (closed)
        {
            return;
        }
        closed = true;
        if (bytesRemaining > 0L)
        {
            throw new ProtocolException("unexpected end of stream");
        } else
        {
            HttpConnection.access$402(HttpConnection.this, 3);
            return;
        }
    }

    public final void flush()
    {
        if (closed)
        {
            return;
        } else
        {
            HttpConnection.access$300(HttpConnection.this).flush();
            return;
        }
    }

    public final wo timeout()
    {
        return HttpConnection.access$300(HttpConnection.this).timeout();
    }

    public final void write(vr vr1, long l)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        Util.checkOffsetAndCount(vr1.size, 0L, l);
        if (l > bytesRemaining)
        {
            throw new ProtocolException((new StringBuilder("expected ")).append(bytesRemaining).append(" bytes but received ").append(l).toString());
        } else
        {
            HttpConnection.access$300(HttpConnection.this).write(vr1, l);
            bytesRemaining = bytesRemaining - l;
            return;
        }
    }

    private (long l)
    {
        this$0 = HttpConnection.this;
        super();
        bytesRemaining = l;
    }

    bytesRemaining(long l, bytesRemaining bytesremaining)
    {
        this(l);
    }
}
