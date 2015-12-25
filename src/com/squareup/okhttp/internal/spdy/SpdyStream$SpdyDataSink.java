// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import o.vr;
import o.wm;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyStream, SpdyConnection

final class this._cls0
    implements wm
{

    static final boolean $assertionsDisabled;
    private static final long EMIT_BUFFER_SIZE = 16384L;
    private boolean closed;
    private boolean finished;
    private final vr sendBuffer = new vr();
    final SpdyStream this$0;

    private void emitDataFrame(boolean flag)
    {
        SpdyStream spdystream = SpdyStream.this;
        spdystream;
        JVM INSTR monitorenter ;
        SpdyStream.access$1100(SpdyStream.this).nter();
        for (; bytesLeftInWriteWindow <= 0L && !finished && !closed && SpdyStream.access$800(SpdyStream.this) == null; SpdyStream.access$900(SpdyStream.this)) { }
        SpdyStream.access$1100(SpdyStream.this).xitAndThrowIfTimedOut();
        break MISSING_BLOCK_LABEL_89;
        Exception exception;
        exception;
        SpdyStream.access$1100(SpdyStream.this).xitAndThrowIfTimedOut();
        throw exception;
        long l;
        SpdyStream.access$1200(SpdyStream.this);
        l = Math.min(bytesLeftInWriteWindow, sendBuffer.size);
        SpdyStream spdystream1 = SpdyStream.this;
        spdystream1.bytesLeftInWriteWindow = spdystream1.bytesLeftInWriteWindow - l;
        spdystream;
        JVM INSTR monitorexit ;
          goto _L1
        spdystream1;
        throw spdystream1;
_L1:
        SpdyConnection spdyconnection = SpdyStream.access$500(SpdyStream.this);
        int i = SpdyStream.access$600(SpdyStream.this);
        if (flag && l == sendBuffer.size)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        spdyconnection.writeData(i, flag, sendBuffer, l);
        return;
    }

    public final void close()
    {
        if (!$assertionsDisabled && Thread.holdsLock(SpdyStream.this))
        {
            throw new AssertionError();
        }
        SpdyStream spdystream = SpdyStream.this;
        spdystream;
        JVM INSTR monitorenter ;
        boolean flag = closed;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        spdystream;
        JVM INSTR monitorexit ;
        return;
        spdystream;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        if (!sink.finished)
        {
            if (sendBuffer.size > 0L)
            {
                while (sendBuffer.size > 0L) 
                {
                    emitDataFrame(true);
                }
            } else
            {
                SpdyStream.access$500(SpdyStream.this).writeData(SpdyStream.access$600(SpdyStream.this), true, null, 0L);
            }
        }
        spdystream = SpdyStream.this;
        spdystream;
        JVM INSTR monitorenter ;
        closed = true;
        spdystream;
        JVM INSTR monitorexit ;
          goto _L2
        exception;
        throw exception;
_L2:
        SpdyStream.access$500(SpdyStream.this).flush();
        SpdyStream.access$1000(SpdyStream.this);
        return;
    }

    public final void flush()
    {
        if (!$assertionsDisabled && Thread.holdsLock(SpdyStream.this))
        {
            throw new AssertionError();
        }
        SpdyStream spdystream = SpdyStream.this;
        spdystream;
        JVM INSTR monitorenter ;
        SpdyStream.access$1200(SpdyStream.this);
        spdystream;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        while (sendBuffer.size > 0L) 
        {
            emitDataFrame(false);
        }
        SpdyStream.access$500(SpdyStream.this).flush();
        return;
    }

    public final wo timeout()
    {
        return SpdyStream.access$1100(SpdyStream.this);
    }

    public final void write(vr vr1, long l)
    {
        if (!$assertionsDisabled && Thread.holdsLock(SpdyStream.this))
        {
            throw new AssertionError();
        }
        sendBuffer.write(vr1, l);
        while (sendBuffer.size >= 16384L) 
        {
            emitDataFrame(false);
        }
    }

    static 
    {
        boolean flag;
        if (!com/squareup/okhttp/internal/spdy/SpdyStream.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }



/*
    static boolean access$202( , boolean flag)
    {
        .finished = flag;
        return flag;
    }

*/


    finished()
    {
        this$0 = SpdyStream.this;
        super();
    }
}
