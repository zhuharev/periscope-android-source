// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import o.vr;
import o.vu;
import o.wm;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

final class <init>
    implements wm
{

    private boolean closed;
    final HttpConnection this$0;

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (!closed)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        closed = true;
        HttpConnection.access$300(HttpConnection.this)._mth02B8("0\r\n\r\n");
        HttpConnection.access$402(HttpConnection.this, 3);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void flush()
    {
        this;
        JVM INSTR monitorenter ;
        if (!closed)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        HttpConnection.access$300(HttpConnection.this).flush();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final wo timeout()
    {
        return HttpConnection.access$300(HttpConnection.this).timeout();
    }

    public final void write(vr vr, long l)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        if (l == 0L)
        {
            return;
        } else
        {
            HttpConnection.access$300(HttpConnection.this).FE73(l);
            HttpConnection.access$300(HttpConnection.this)._mth02B8("\r\n");
            HttpConnection.access$300(HttpConnection.this).write(vr, l);
            HttpConnection.access$300(HttpConnection.this)._mth02B8("\r\n");
            return;
        }
    }

    private ()
    {
        this$0 = HttpConnection.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
