// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.ws;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import o.vr;
import o.vv;
import o.wn;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.ws:
//            WebSocketReader, WebSocketProtocol

final class <init>
    implements wn
{

    final WebSocketReader this$0;

    public final void close()
    {
        if (WebSocketReader.access$200(WebSocketReader.this))
        {
            return;
        }
        WebSocketReader.access$202(WebSocketReader.this, true);
        if (WebSocketReader.access$100(WebSocketReader.this))
        {
            return;
        }
        WebSocketReader.access$1000(WebSocketReader.this)._mth02D1(WebSocketReader.access$400(WebSocketReader.this) - WebSocketReader.access$300(WebSocketReader.this));
        for (; !WebSocketReader.access$500(WebSocketReader.this); WebSocketReader.access$1000(WebSocketReader.this)._mth02D1(WebSocketReader.access$400(WebSocketReader.this)))
        {
            WebSocketReader.access$600(WebSocketReader.this);
        }

    }

    public final long read(vr vr1, long l)
    {
        if (WebSocketReader.access$100(WebSocketReader.this))
        {
            throw new IOException("closed");
        }
        if (WebSocketReader.access$200(WebSocketReader.this))
        {
            throw new IllegalStateException("closed");
        }
        if (WebSocketReader.access$300(WebSocketReader.this) == WebSocketReader.access$400(WebSocketReader.this))
        {
            if (WebSocketReader.access$500(WebSocketReader.this))
            {
                return -1L;
            }
            WebSocketReader.access$600(WebSocketReader.this);
            if (WebSocketReader.access$700(WebSocketReader.this) != 0)
            {
                throw new ProtocolException((new StringBuilder("Expected continuation opcode. Got: ")).append(Integer.toHexString(WebSocketReader.access$700(WebSocketReader.this))).toString());
            }
            if (WebSocketReader.access$500(WebSocketReader.this) && WebSocketReader.access$400(WebSocketReader.this) == 0L)
            {
                return -1L;
            }
        }
        l = Math.min(l, WebSocketReader.access$400(WebSocketReader.this) - WebSocketReader.access$300(WebSocketReader.this));
        if (WebSocketReader.access$800(WebSocketReader.this))
        {
            l = Math.min(l, WebSocketReader.access$900(WebSocketReader.this).length);
            long l1 = WebSocketReader.access$1000(WebSocketReader.this).read(WebSocketReader.access$900(WebSocketReader.this), 0, (int)l);
            l = l1;
            if (l1 == -1L)
            {
                throw new EOFException();
            }
            WebSocketProtocol.toggleMask(WebSocketReader.access$900(WebSocketReader.this), l, WebSocketReader.access$1100(WebSocketReader.this), WebSocketReader.access$300(WebSocketReader.this));
            vr1._mth02BC(WebSocketReader.access$900(WebSocketReader.this), 0, (int)l);
        } else
        {
            long l2 = WebSocketReader.access$1000(WebSocketReader.this).read(vr1, l);
            l = l2;
            if (l2 == -1L)
            {
                throw new EOFException();
            }
        }
        WebSocketReader.access$302(WebSocketReader.this, WebSocketReader.access$300(WebSocketReader.this) + l);
        return l;
    }

    public final wo timeout()
    {
        return WebSocketReader.access$1000(WebSocketReader.this).timeout();
    }

    private I()
    {
        this$0 = WebSocketReader.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
