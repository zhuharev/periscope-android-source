// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.EOFException;
import java.io.IOException;
import o.vr;
import o.vv;
import o.wn;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyStream, SpdyConnection, Settings, ErrorCode

final class <init>
    implements wn
{

    static final boolean $assertionsDisabled;
    private boolean closed;
    private boolean finished;
    private final long maxByteCount;
    private final vr readBuffer;
    private final vr receiveBuffer;
    final SpdyStream this$0;

    private void checkNotClosed()
    {
        if (closed)
        {
            throw new IOException("stream closed");
        }
        if (SpdyStream.access$800(SpdyStream.this) != null)
        {
            throw new IOException((new StringBuilder("stream was reset: ")).append(SpdyStream.access$800(SpdyStream.this)).toString());
        } else
        {
            return;
        }
    }

    private void waitUntilReadable()
    {
        SpdyStream.access$700(SpdyStream.this).er();
        for (; readBuffer.size == 0L && !finished && !closed && SpdyStream.access$800(SpdyStream.this) == null; SpdyStream.access$900(SpdyStream.this)) { }
        SpdyStream.access$700(SpdyStream.this).tAndThrowIfTimedOut();
        return;
        Exception exception;
        exception;
        SpdyStream.access$700(SpdyStream.this).tAndThrowIfTimedOut();
        throw exception;
    }

    public final void close()
    {
        SpdyStream spdystream = SpdyStream.this;
        spdystream;
        JVM INSTR monitorenter ;
        vr vr1;
        closed = true;
        vr1 = readBuffer;
        vr1._mth02D1(vr1.size);
        break MISSING_BLOCK_LABEL_38;
        Object obj;
        obj;
        throw new AssertionError(obj);
        notifyAll();
        spdystream;
        JVM INSTR monitorexit ;
          goto _L1
        obj;
        throw obj;
_L1:
        SpdyStream.access$1000(SpdyStream.this);
        return;
    }

    public final long read(vr vr1, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        SpdyStream spdystream = SpdyStream.this;
        spdystream;
        JVM INSTR monitorenter ;
        long l1;
        waitUntilReadable();
        checkNotClosed();
        l1 = readBuffer.size;
        if (l1 != 0L)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        spdystream;
        JVM INSTR monitorexit ;
        return -1L;
        l = readBuffer.read(vr1, Math.min(l, readBuffer.size));
        vr1 = SpdyStream.this;
        vr1.unacknowledgedBytesRead = ((SpdyStream) (vr1)).unacknowledgedBytesRead + l;
        if (unacknowledgedBytesRead >= (long)(SpdyStream.access$500(SpdyStream.this).okHttpSettings.getInitialWindowSize(0x10000) / 2))
        {
            SpdyStream.access$500(SpdyStream.this).writeWindowUpdateLater(SpdyStream.access$600(SpdyStream.this), unacknowledgedBytesRead);
            unacknowledgedBytesRead = 0L;
        }
        spdystream;
        JVM INSTR monitorexit ;
          goto _L1
        vr1;
        throw vr1;
_L1:
        vr1 = SpdyStream.access$500(SpdyStream.this);
        vr1;
        JVM INSTR monitorenter ;
        SpdyConnection spdyconnection = SpdyStream.access$500(SpdyStream.this);
        spdyconnection.unacknowledgedBytesRead = spdyconnection.unacknowledgedBytesRead + l;
        if (SpdyStream.access$500(SpdyStream.this).unacknowledgedBytesRead >= (long)(SpdyStream.access$500(SpdyStream.this).okHttpSettings.getInitialWindowSize(0x10000) / 2))
        {
            SpdyStream.access$500(SpdyStream.this).writeWindowUpdateLater(0, SpdyStream.access$500(SpdyStream.this).unacknowledgedBytesRead);
            SpdyStream.access$500(SpdyStream.this).unacknowledgedBytesRead = 0L;
        }
        vr1;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    final void receive(vv vv1, long l)
    {
        long l1;
        l1 = l;
        if (!$assertionsDisabled)
        {
            l1 = l;
            if (Thread.holdsLock(SpdyStream.this))
            {
                throw new AssertionError();
            }
        }
_L3:
        if (l1 <= 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        SpdyStream spdystream = SpdyStream.this;
        spdystream;
        JVM INSTR monitorenter ;
        long l2;
        boolean flag1;
        flag1 = finished;
        l = readBuffer.size;
        l2 = maxByteCount;
        boolean flag;
        if (l + l1 > l2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        spdystream;
        JVM INSTR monitorexit ;
          goto _L1
        vv1;
        throw vv1;
_L1:
        if (flag)
        {
            vv1._mth02D1(l1);
            closeLater(ErrorCode.FLOW_CONTROL_ERROR);
            return;
        }
        if (flag1)
        {
            vv1._mth02D1(l1);
            return;
        }
        l = vv1.read(receiveBuffer, l1);
        if (l == -1L)
        {
            throw new EOFException();
        }
        l1 -= l;
        spdystream = SpdyStream.this;
        spdystream;
        JVM INSTR monitorenter ;
        if (readBuffer.size == 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        readBuffer._mth02CA(receiveBuffer);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        notifyAll();
        spdystream;
        JVM INSTR monitorexit ;
        if (true) goto _L3; else goto _L2
        vv1;
        throw vv1;
_L2:
    }

    public final wo timeout()
    {
        return SpdyStream.access$700(SpdyStream.this);
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
    static boolean access$102(A a, boolean flag)
    {
        a.finished = flag;
        return flag;
    }

*/


    private finished(long l)
    {
        this$0 = SpdyStream.this;
        super();
        receiveBuffer = new vr();
        readBuffer = new vr();
        maxByteCount = l;
    }

    maxByteCount(long l, maxByteCount maxbytecount)
    {
        this(l);
    }
}
