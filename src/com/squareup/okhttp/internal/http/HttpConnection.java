// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import o.vr;
import o.vu;
import o.vv;
import o.wc;
import o.wm;
import o.wn;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            StatusLine, OkHeaders, RetryableSink, HttpEngine

public final class HttpConnection
{
    abstract class AbstractSource
        implements wn
    {

        protected boolean closed;
        final HttpConnection this$0;

        protected final void endOfInput(boolean flag)
        {
            if (state != 5)
            {
                throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
            }
            state = 0;
            if (flag && onIdle == 1)
            {
                onIdle = 0;
                Internal.instance.recycle(pool, connection);
                return;
            }
            if (onIdle == 2)
            {
                state = 6;
                connection.getSocket().close();
            }
        }

        public wo timeout()
        {
            return source.timeout();
        }

        protected final void unexpectedEndOfInput()
        {
            Util.closeQuietly(connection.getSocket());
            state = 6;
        }

        private AbstractSource()
        {
            this$0 = HttpConnection.this;
            super();
        }

        AbstractSource(_cls1 _pcls1)
        {
            this();
        }
    }

    final class ChunkedSink
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
            sink._mth02B8("0\r\n\r\n");
            state = 3;
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
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final wo timeout()
        {
            return sink.timeout();
        }

        public final void write(vr vr1, long l)
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
                sink.FE73(l);
                sink._mth02B8("\r\n");
                sink.write(vr1, l);
                sink._mth02B8("\r\n");
                return;
            }
        }

        private ChunkedSink()
        {
            this$0 = HttpConnection.this;
            super();
        }

        ChunkedSink(_cls1 _pcls1)
        {
            this();
        }
    }

    class ChunkedSource extends AbstractSource
    {

        private static final long NO_CHUNK_YET = -1L;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpEngine httpEngine;
        final HttpConnection this$0;

        private void readChunkSize()
        {
            if (bytesRemainingInChunk != -1L)
            {
                source.FF90();
            }
            try
            {
                bytesRemainingInChunk = source.FF7A();
                String s = source.FF90().trim();
                if (bytesRemainingInChunk < 0L || !s.isEmpty() && !s.startsWith(";"))
                {
                    throw new ProtocolException((new StringBuilder("expected chunk size and optional extensions but was \"")).append(bytesRemainingInChunk).append(s).append("\"").toString());
                }
            }
            catch (NumberFormatException numberformatexception)
            {
                throw new ProtocolException(numberformatexception.getMessage());
            }
            if (bytesRemainingInChunk == 0L)
            {
                hasMoreChunks = false;
                com.squareup.okhttp.Headers.Builder builder = new com.squareup.okhttp.Headers.Builder();
                readHeaders(builder);
                httpEngine.receiveHeaders(builder.build());
                endOfInput(true);
            }
        }

        public void close()
        {
            if (closed)
            {
                return;
            }
            if (hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS))
            {
                unexpectedEndOfInput();
            }
            closed = true;
        }

        public long read(vr vr1, long l)
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (!hasMoreChunks)
            {
                return -1L;
            }
            if (bytesRemainingInChunk == 0L || bytesRemainingInChunk == -1L)
            {
                readChunkSize();
                if (!hasMoreChunks)
                {
                    return -1L;
                }
            }
            l = source.read(vr1, Math.min(l, bytesRemainingInChunk));
            if (l == -1L)
            {
                unexpectedEndOfInput();
                throw new IOException("unexpected end of stream");
            } else
            {
                bytesRemainingInChunk = bytesRemainingInChunk - l;
                return l;
            }
        }

        ChunkedSource(HttpEngine httpengine)
        {
            this$0 = HttpConnection.this;
            super(null);
            bytesRemainingInChunk = -1L;
            hasMoreChunks = true;
            httpEngine = httpengine;
        }
    }

    final class FixedLengthSink
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
                state = 3;
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
                sink.flush();
                return;
            }
        }

        public final wo timeout()
        {
            return sink.timeout();
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
                sink.write(vr1, l);
                bytesRemaining = bytesRemaining - l;
                return;
            }
        }

        private FixedLengthSink(long l)
        {
            this$0 = HttpConnection.this;
            super();
            bytesRemaining = l;
        }

        FixedLengthSink(long l, _cls1 _pcls1)
        {
            this(l);
        }
    }

    class FixedLengthSource extends AbstractSource
    {

        private long bytesRemaining;
        final HttpConnection this$0;

        public void close()
        {
            if (closed)
            {
                return;
            }
            if (bytesRemaining != 0L && !Util.discard(this, 100, TimeUnit.MILLISECONDS))
            {
                unexpectedEndOfInput();
            }
            closed = true;
        }

        public long read(vr vr1, long l)
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (bytesRemaining == 0L)
            {
                return -1L;
            }
            l = source.read(vr1, Math.min(bytesRemaining, l));
            if (l == -1L)
            {
                unexpectedEndOfInput();
                throw new ProtocolException("unexpected end of stream");
            }
            bytesRemaining = bytesRemaining - l;
            if (bytesRemaining == 0L)
            {
                endOfInput(true);
            }
            return l;
        }

        public FixedLengthSource(long l)
        {
            this$0 = HttpConnection.this;
            super(null);
            bytesRemaining = l;
            if (bytesRemaining == 0L)
            {
                endOfInput(true);
            }
        }
    }

    class UnknownLengthSource extends AbstractSource
    {

        private boolean inputExhausted;
        final HttpConnection this$0;

        public void close()
        {
            if (closed)
            {
                return;
            }
            if (!inputExhausted)
            {
                unexpectedEndOfInput();
            }
            closed = true;
        }

        public long read(vr vr1, long l)
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (inputExhausted)
            {
                return -1L;
            }
            l = source.read(vr1, l);
            if (l == -1L)
            {
                inputExhausted = true;
                endOfInput(false);
                return -1L;
            } else
            {
                return l;
            }
        }

        private UnknownLengthSource()
        {
            this$0 = HttpConnection.this;
            super(null);
        }

        UnknownLengthSource(_cls1 _pcls1)
        {
            this();
        }
    }


    private static final int ON_IDLE_CLOSE = 2;
    private static final int ON_IDLE_HOLD = 0;
    private static final int ON_IDLE_POOL = 1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final Connection connection;
    private int onIdle;
    private final ConnectionPool pool;
    private final vu sink;
    private final Socket socket;
    private final vv source;
    private int state;

    public HttpConnection(ConnectionPool connectionpool, Connection connection1, Socket socket1)
    {
        state = 0;
        onIdle = 0;
        pool = connectionpool;
        connection = connection1;
        socket = socket1;
        source = wc._mth02CB(wc._mth02CB(socket1));
        sink = wc._mth02CA(wc._mth02CA(socket1));
    }

    public final long bufferSize()
    {
        return source.FE93().size;
    }

    public final void closeIfOwnedBy(Object obj)
    {
        Internal.instance.closeIfOwnedBy(connection, obj);
    }

    public final void closeOnIdle()
    {
        onIdle = 2;
        if (state == 0)
        {
            state = 6;
            connection.getSocket().close();
        }
    }

    public final void flush()
    {
        sink.flush();
    }

    public final boolean isClosed()
    {
        return state == 6;
    }

    public final boolean isReadable()
    {
        Object obj;
        int i;
        boolean flag;
        try
        {
            i = socket.getSoTimeout();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return true;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        socket.setSoTimeout(1);
        flag = source.FF46();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        socket.setSoTimeout(i);
        return false;
        socket.setSoTimeout(i);
        return true;
        obj;
        socket.setSoTimeout(i);
        throw obj;
    }

    public final wm newChunkedSink()
    {
        if (state != 1)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        } else
        {
            state = 2;
            return new ChunkedSink(null);
        }
    }

    public final wn newChunkedSource(HttpEngine httpengine)
    {
        if (state != 4)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        } else
        {
            state = 5;
            return new ChunkedSource(httpengine);
        }
    }

    public final wm newFixedLengthSink(long l)
    {
        if (state != 1)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        } else
        {
            state = 2;
            return new FixedLengthSink(l, null);
        }
    }

    public final wn newFixedLengthSource(long l)
    {
        if (state != 4)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        } else
        {
            state = 5;
            return new FixedLengthSource(l);
        }
    }

    public final wn newUnknownLengthSource()
    {
        if (state != 4)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        } else
        {
            state = 5;
            return new UnknownLengthSource(null);
        }
    }

    public final void poolOnIdle()
    {
        onIdle = 1;
        if (state == 0)
        {
            onIdle = 0;
            Internal.instance.recycle(pool, connection);
        }
    }

    public final void readHeaders(com.squareup.okhttp.Headers.Builder builder)
    {
        do
        {
            String s = source.FF90();
            if (s.length() != 0)
            {
                Internal.instance.addLenient(builder, s);
            } else
            {
                return;
            }
        } while (true);
    }

    public final com.squareup.okhttp.Response.Builder readResponse()
    {
        if (state != 1 && state != 3)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        }
        com.squareup.okhttp.Response.Builder builder;
        try
        {
            StatusLine statusline;
            do
            {
                statusline = StatusLine.parse(source.FF90());
                builder = (new com.squareup.okhttp.Response.Builder()).protocol(statusline.protocol).code(statusline.code).message(statusline.message);
                com.squareup.okhttp.Headers.Builder builder1 = new com.squareup.okhttp.Headers.Builder();
                readHeaders(builder1);
                builder1.add(OkHeaders.SELECTED_PROTOCOL, statusline.protocol.toString());
                builder.headers(builder1.build());
            } while (statusline.code == 100);
            state = 4;
        }
        catch (EOFException eofexception)
        {
            IOException ioexception = new IOException((new StringBuilder("unexpected end of stream on ")).append(connection).append(" (recycle count=").append(Internal.instance.recycleCount(connection)).append(")").toString());
            ioexception.initCause(eofexception);
            throw ioexception;
        }
        return builder;
    }

    public final void setTimeouts(int i, int j)
    {
        if (i != 0)
        {
            source.timeout().timeout(i, TimeUnit.MILLISECONDS);
        }
        if (j != 0)
        {
            sink.timeout().timeout(j, TimeUnit.MILLISECONDS);
        }
    }

    public final void writeRequest(Headers headers, String s)
    {
        if (state != 0)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        }
        sink._mth02B8(s)._mth02B8("\r\n");
        int i = 0;
        for (int j = headers.size(); i < j; i++)
        {
            sink._mth02B8(headers.name(i))._mth02B8(": ")._mth02B8(headers.value(i))._mth02B8("\r\n");
        }

        sink._mth02B8("\r\n");
        state = 1;
    }

    public final void writeRequestBody(RetryableSink retryablesink)
    {
        if (state != 1)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        } else
        {
            state = 3;
            retryablesink.writeToSocket(sink);
            return;
        }
    }




/*
    static int access$402(HttpConnection httpconnection, int i)
    {
        httpconnection.state = i;
        return i;
    }

*/




/*
    static int access$602(HttpConnection httpconnection, int i)
    {
        httpconnection.onIdle = i;
        return i;
    }

*/


}
