// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.ws;

import java.io.IOException;
import java.util.Random;
import o.vr;
import o.vu;
import o.wm;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.ws:
//            WebSocketWriter

final class <init>
    implements wm
{

    private boolean isFirstFrame;
    private com.squareup.okhttp.ws.rameSink.isFirstFrame payloadType;
    final WebSocketWriter this$0;

    public final void close()
    {
        if (WebSocketWriter.access$400(WebSocketWriter.this))
        {
            throw new IOException("closed");
        }
        vu vu1 = WebSocketWriter.access$500(WebSocketWriter.this);
        vu1;
        JVM INSTR monitorenter ;
        WebSocketWriter.access$500(WebSocketWriter.this)._mth04C0(128);
        if (WebSocketWriter.access$600(WebSocketWriter.this))
        {
            WebSocketWriter.access$500(WebSocketWriter.this)._mth04C0(128);
            WebSocketWriter.access$800(WebSocketWriter.this).nextBytes(WebSocketWriter.access$700(WebSocketWriter.this));
            WebSocketWriter.access$500(WebSocketWriter.this)._mth02C8(WebSocketWriter.access$700(WebSocketWriter.this));
            break MISSING_BLOCK_LABEL_126;
        }
        WebSocketWriter.access$500(WebSocketWriter.this)._mth04C0(0);
        WebSocketWriter.access$500(WebSocketWriter.this).flush();
        vu1;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        WebSocketWriter.access$902(WebSocketWriter.this, false);
        return;
    }

    public final void flush()
    {
        if (WebSocketWriter.access$400(WebSocketWriter.this))
        {
            throw new IOException("closed");
        }
        vu vu1 = WebSocketWriter.access$500(WebSocketWriter.this);
        vu1;
        JVM INSTR monitorenter ;
        WebSocketWriter.access$500(WebSocketWriter.this).flush();
        vu1;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final wo timeout()
    {
        return WebSocketWriter.access$500(WebSocketWriter.this).timeout();
    }

    public final void write(vr vr, long l)
    {
        WebSocketWriter.access$300(WebSocketWriter.this, payloadType, vr, l, isFirstFrame, false);
        isFirstFrame = false;
    }


/*
    static com.squareup.okhttp.ws.rameSink access$102( , com.squareup.okhttp.ws.rameSink ramesink)
    {
        .payloadType = ramesink;
        return ramesink;
    }

*/


/*
    static boolean access$202(payloadType payloadtype, boolean flag)
    {
        payloadtype.isFirstFrame = flag;
        return flag;
    }

*/

    private isFirstFrame()
    {
        this$0 = WebSocketWriter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
