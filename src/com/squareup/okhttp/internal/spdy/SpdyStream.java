// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import o.vn;
import o.vr;
import o.vv;
import o.wm;
import o.wn;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyConnection, Settings, ErrorCode, HeadersMode

public final class SpdyStream
{
    final class SpdyDataSink
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
            writeTimeout.enter();
            while (bytesLeftInWriteWindow <= 0L && !finished && !closed && errorCode == null) 
            {
                waitForIo();
            }
            writeTimeout.exitAndThrowIfTimedOut();
            break MISSING_BLOCK_LABEL_89;
            Exception exception;
            exception;
            writeTimeout.exitAndThrowIfTimedOut();
            throw exception;
            long l;
            checkOutNotClosed();
            l = Math.min(bytesLeftInWriteWindow, sendBuffer.size);
            SpdyStream spdystream1 = SpdyStream.this;
            spdystream1.bytesLeftInWriteWindow = spdystream1.bytesLeftInWriteWindow - l;
            spdystream;
            JVM INSTR monitorexit ;
              goto _L1
            spdystream1;
            throw spdystream1;
_L1:
            SpdyConnection spdyconnection = connection;
            int i = id;
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
                    connection.writeData(id, true, null, 0L);
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
            connection.flush();
            cancelStreamIfNecessary();
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
            checkOutNotClosed();
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
            connection.flush();
            return;
        }

        public final wo timeout()
        {
            return writeTimeout;
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
        static boolean access$202(SpdyDataSink spdydatasink, boolean flag)
        {
            spdydatasink.finished = flag;
            return flag;
        }

*/


        SpdyDataSink()
        {
            this$0 = SpdyStream.this;
            super();
        }
    }

    final class SpdyDataSource
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
            if (errorCode != null)
            {
                throw new IOException((new StringBuilder("stream was reset: ")).append(errorCode).toString());
            } else
            {
                return;
            }
        }

        private void waitUntilReadable()
        {
            readTimeout.enter();
            while (readBuffer.size == 0L && !finished && !closed && errorCode == null) 
            {
                waitForIo();
            }
            readTimeout.exitAndThrowIfTimedOut();
            return;
            Exception exception;
            exception;
            readTimeout.exitAndThrowIfTimedOut();
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
            cancelStreamIfNecessary();
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
            if (unacknowledgedBytesRead >= (long)(connection.okHttpSettings.getInitialWindowSize(0x10000) / 2))
            {
                connection.writeWindowUpdateLater(id, unacknowledgedBytesRead);
                unacknowledgedBytesRead = 0L;
            }
            spdystream;
            JVM INSTR monitorexit ;
              goto _L1
            vr1;
            throw vr1;
_L1:
            vr1 = connection;
            vr1;
            JVM INSTR monitorenter ;
            SpdyConnection spdyconnection = connection;
            spdyconnection.unacknowledgedBytesRead = spdyconnection.unacknowledgedBytesRead + l;
            if (connection.unacknowledgedBytesRead >= (long)(connection.okHttpSettings.getInitialWindowSize(0x10000) / 2))
            {
                connection.writeWindowUpdateLater(0, connection.unacknowledgedBytesRead);
                connection.unacknowledgedBytesRead = 0L;
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
            return readTimeout;
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
        static boolean access$102(SpdyDataSource spdydatasource, boolean flag)
        {
            spdydatasource.finished = flag;
            return flag;
        }

*/


        private SpdyDataSource(long l)
        {
            this$0 = SpdyStream.this;
            super();
            receiveBuffer = new vr();
            readBuffer = new vr();
            maxByteCount = l;
        }

        SpdyDataSource(long l, _cls1 _pcls1)
        {
            this(l);
        }
    }

    class SpdyTimeout extends vn
    {

        final SpdyStream this$0;

        public void exitAndThrowIfTimedOut()
        {
            if (exit())
            {
                throw new InterruptedIOException("timeout");
            } else
            {
                return;
            }
        }

        protected void timedOut()
        {
            closeLater(ErrorCode.CANCEL);
        }

        SpdyTimeout()
        {
            this$0 = SpdyStream.this;
            super();
        }
    }


    static final boolean $assertionsDisabled;
    long bytesLeftInWriteWindow;
    private final SpdyConnection connection;
    private ErrorCode errorCode;
    private final int id;
    private final SpdyTimeout readTimeout = new SpdyTimeout();
    private final List requestHeaders;
    private List responseHeaders;
    final SpdyDataSink sink;
    private final SpdyDataSource source;
    long unacknowledgedBytesRead;
    private final SpdyTimeout writeTimeout = new SpdyTimeout();

    SpdyStream(int i, SpdyConnection spdyconnection, boolean flag, boolean flag1, List list)
    {
        unacknowledgedBytesRead = 0L;
        errorCode = null;
        if (spdyconnection == null)
        {
            throw new NullPointerException("connection == null");
        }
        if (list == null)
        {
            throw new NullPointerException("requestHeaders == null");
        } else
        {
            id = i;
            connection = spdyconnection;
            bytesLeftInWriteWindow = spdyconnection.peerSettings.getInitialWindowSize(0x10000);
            source = new SpdyDataSource(spdyconnection.okHttpSettings.getInitialWindowSize(0x10000), null);
            sink = new SpdyDataSink();
            source.finished = flag1;
            sink.finished = flag;
            requestHeaders = list;
            return;
        }
    }

    private void cancelStreamIfNecessary()
    {
        if (!$assertionsDisabled && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        boolean flag1;
        if (!source.finished && source.closed && (sink.finished || sink.closed))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = isOpen();
        this;
        JVM INSTR monitorexit ;
          goto _L1
        exception;
        throw exception;
_L1:
        if (flag)
        {
            close(ErrorCode.CANCEL);
            return;
        }
        if (!flag1)
        {
            connection.removeStream(id);
        }
        return;
    }

    private void checkOutNotClosed()
    {
        if (sink.closed)
        {
            throw new IOException("stream closed");
        }
        if (sink.finished)
        {
            throw new IOException("stream finished");
        }
        if (errorCode != null)
        {
            throw new IOException((new StringBuilder("stream was reset: ")).append(errorCode).toString());
        } else
        {
            return;
        }
    }

    private boolean closeInternal(ErrorCode errorcode)
    {
        if (!$assertionsDisabled && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        this;
        JVM INSTR monitorenter ;
        ErrorCode errorcode1 = errorCode;
        if (errorcode1 == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        boolean flag;
        if (!source.finished)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        flag = sink.finished;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        errorCode = errorcode;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
          goto _L1
        errorcode;
        throw errorcode;
_L1:
        connection.removeStream(id);
        return true;
    }

    private void waitForIo()
    {
        InterruptedException interruptedexception;
        try
        {
            wait();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InterruptedException interruptedexception)
        {
            throw new InterruptedIOException();
        }
    }

    final void addBytesToWriteWindow(long l)
    {
        bytesLeftInWriteWindow = bytesLeftInWriteWindow + l;
        if (l > 0L)
        {
            notifyAll();
        }
    }

    public final void close(ErrorCode errorcode)
    {
        if (!closeInternal(errorcode))
        {
            return;
        } else
        {
            connection.writeSynReset(id, errorcode);
            return;
        }
    }

    public final void closeLater(ErrorCode errorcode)
    {
        if (!closeInternal(errorcode))
        {
            return;
        } else
        {
            connection.writeSynResetLater(id, errorcode);
            return;
        }
    }

    public final SpdyConnection getConnection()
    {
        return connection;
    }

    public final ErrorCode getErrorCode()
    {
        this;
        JVM INSTR monitorenter ;
        ErrorCode errorcode = errorCode;
        this;
        JVM INSTR monitorexit ;
        return errorcode;
        Exception exception;
        exception;
        throw exception;
    }

    public final int getId()
    {
        return id;
    }

    public final List getRequestHeaders()
    {
        return requestHeaders;
    }

    public final List getResponseHeaders()
    {
        this;
        JVM INSTR monitorenter ;
        readTimeout.enter();
        while (responseHeaders == null && errorCode == null) 
        {
            waitForIo();
        }
        readTimeout.exitAndThrowIfTimedOut();
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        readTimeout.exitAndThrowIfTimedOut();
        throw exception;
        List list;
        if (responseHeaders == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        list = responseHeaders;
        this;
        JVM INSTR monitorexit ;
        return list;
        throw new IOException((new StringBuilder("stream was reset: ")).append(errorCode).toString());
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
    }

    public final wm getSink()
    {
        this;
        JVM INSTR monitorenter ;
        if (responseHeaders == null && !isLocallyInitiated())
        {
            throw new IllegalStateException("reply before requesting the sink");
        }
        this;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        return sink;
    }

    public final wn getSource()
    {
        return source;
    }

    public final boolean isLocallyInitiated()
    {
        boolean flag;
        if ((id & 1) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return connection.client == flag;
    }

    public final boolean isOpen()
    {
        this;
        JVM INSTR monitorenter ;
        if (errorCode == null)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        List list;
        if (!source.finished && !source.closed || !sink.finished && !sink.closed)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        list = responseHeaders;
        if (list != null)
        {
            return false;
        }
        this;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    public final wo readTimeout()
    {
        return readTimeout;
    }

    final void receiveData(vv vv, int i)
    {
        if (!$assertionsDisabled && Thread.holdsLock(this))
        {
            throw new AssertionError();
        } else
        {
            source.receive(vv, i);
            return;
        }
    }

    final void receiveFin()
    {
        if (!$assertionsDisabled && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        source.finished = true;
        flag = isOpen();
        notifyAll();
        this;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        if (!flag)
        {
            connection.removeStream(id);
        }
        return;
    }

    final void receiveHeaders(List list, HeadersMode headersmode)
    {
        Object obj;
        if (!$assertionsDisabled && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        obj = null;
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        if (responseHeaders != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        if (headersmode.failIfHeadersAbsent())
        {
            list = ErrorCode.PROTOCOL_ERROR;
            break MISSING_BLOCK_LABEL_117;
        }
        responseHeaders = list;
        flag = isOpen();
        notifyAll();
        list = obj;
        break MISSING_BLOCK_LABEL_117;
        if (headersmode.failIfHeadersPresent())
        {
            list = ErrorCode.STREAM_IN_USE;
            break MISSING_BLOCK_LABEL_117;
        }
        headersmode = new ArrayList();
        headersmode.addAll(responseHeaders);
        headersmode.addAll(list);
        responseHeaders = headersmode;
        list = obj;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        list;
        throw list;
_L1:
        if (list != null)
        {
            closeLater(list);
            return;
        }
        if (!flag)
        {
            connection.removeStream(id);
        }
        return;
    }

    final void receiveRstStream(ErrorCode errorcode)
    {
        this;
        JVM INSTR monitorenter ;
        if (errorCode == null)
        {
            errorCode = errorcode;
            notifyAll();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        errorcode;
        throw errorcode;
    }

    public final void reply(List list, boolean flag)
    {
        if (!$assertionsDisabled && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        throw new NullPointerException("responseHeaders == null");
        if (responseHeaders != null)
        {
            throw new IllegalStateException("reply already sent");
        }
        responseHeaders = list;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        sink.finished = true;
        flag1 = true;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        list;
        throw list;
_L1:
        connection.writeSynReply(id, flag1, list);
        if (flag1)
        {
            connection.flush();
        }
        return;
    }

    public final wo writeTimeout()
    {
        return writeTimeout;
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








}
