// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import o.vr;
import o.vv;
import o.vw;
import o.wc;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Settings, Http2, Spdy3, Variant, 
//            SpdyStream, Ping, FrameWriter, ErrorCode, 
//            IncomingStreamHandler, PushObserver, FrameReader, HeadersMode

public final class SpdyConnection
    implements Closeable
{
    public static class Builder
    {

        private boolean client;
        private IncomingStreamHandler handler;
        private String hostName;
        private Protocol protocol;
        private PushObserver pushObserver;
        private Socket socket;

        public SpdyConnection build()
        {
            return new SpdyConnection(this, null);
        }

        public Builder handler(IncomingStreamHandler incomingstreamhandler)
        {
            handler = incomingstreamhandler;
            return this;
        }

        public Builder protocol(Protocol protocol1)
        {
            protocol = protocol1;
            return this;
        }

        public Builder pushObserver(PushObserver pushobserver)
        {
            pushObserver = pushobserver;
            return this;
        }







        public Builder(String s, boolean flag, Socket socket1)
        {
            handler = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
            protocol = Protocol.SPDY_3;
            pushObserver = PushObserver.CANCEL;
            hostName = s;
            client = flag;
            socket = socket1;
        }

        public Builder(boolean flag, Socket socket1)
        {
            this(((InetSocketAddress)socket1.getRemoteSocketAddress()).getHostName(), flag, socket1);
        }
    }

    class Reader extends NamedRunnable
        implements FrameReader.Handler
    {

        FrameReader frameReader;
        final SpdyConnection this$0;

        private void ackSettingsLater(Settings settings1)
        {
            class _cls2 extends NamedRunnable
            {

                final Reader this$1;
                final Settings val$peerSettings;

                public void execute()
                {
                    try
                    {
                        frameWriter.ackSettings(peerSettings);
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        return;
                    }
                }

                transient _cls2(Object aobj[], Settings settings1)
                {
                    this$1 = Reader.this;
                    peerSettings = settings1;
                    super(final_s, aobj);
                }
            }

            SpdyConnection.executor.execute(new _cls2(new Object[] {
                hostName
            }, settings1));
        }

        public void ackSettings()
        {
        }

        public void alternateService(int i, String s, vw vw, String s1, int j, long l)
        {
        }

        public void data(boolean flag, int i, vv vv1, int j)
        {
            if (pushedStream(i))
            {
                pushDataLater(i, vv1, j, flag);
                return;
            }
            SpdyStream spdystream = getStream(i);
            if (spdystream == null)
            {
                writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                vv1._mth02D1(j);
                return;
            }
            spdystream.receiveData(vv1, j);
            if (flag)
            {
                spdystream.receiveFin();
            }
        }

        protected void execute()
        {
            ErrorCode errorcode2 = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorcode3 = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorcode = errorcode2;
            ErrorCode errorcode1 = errorcode2;
            ErrorCode errorcode4;
            try
            {
                frameReader = variant.newReader(wc._mth02CB(wc._mth02CB(socket)), client);
            }
            catch (IOException ioexception)
            {
                break MISSING_BLOCK_LABEL_128;
            }
            finally
            {
                IOException ioexception1;
                try
                {
                    close(errorcode, errorcode3);
                }
                catch (IOException ioexception2) { }
                Util.closeQuietly(frameReader);
                throw exception;
            }
            errorcode = errorcode2;
            errorcode1 = errorcode2;
            if (client)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            errorcode = errorcode2;
            errorcode1 = errorcode2;
            frameReader.readConnectionPreface();
_L2:
            errorcode = errorcode2;
            errorcode1 = errorcode2;
            if (frameReader.nextFrame(this)) goto _L2; else goto _L1
_L1:
            errorcode = errorcode2;
            errorcode1 = errorcode2;
            errorcode2 = ErrorCode.NO_ERROR;
            errorcode = errorcode2;
            errorcode1 = errorcode2;
            errorcode4 = ErrorCode.CANCEL;
            try
            {
                close(errorcode2, errorcode4);
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception1) { }
            Util.closeQuietly(frameReader);
            return;
            errorcode = errorcode1;
            errorcode1 = ErrorCode.PROTOCOL_ERROR;
            errorcode = errorcode1;
            errorcode2 = ErrorCode.PROTOCOL_ERROR;
            try
            {
                close(errorcode1, errorcode2);
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception1) { }
            Util.closeQuietly(frameReader);
            return;
        }

        public void goAway(int i, ErrorCode errorcode, vw vw)
        {
            errorcode = SpdyConnection.this;
            errorcode;
            JVM INSTR monitorenter ;
            vw = (SpdyStream[])streams.values().toArray(new SpdyStream[streams.size()]);
            shutdown = true;
            errorcode;
            JVM INSTR monitorexit ;
              goto _L1
            vw;
            throw vw;
_L1:
            int k = vw.length;
            for (int j = 0; j < k; j++)
            {
                errorcode = vw[j];
                if (errorcode.getId() > i && errorcode.isLocallyInitiated())
                {
                    errorcode.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    removeStream(errorcode.getId());
                }
            }

            return;
        }

        public void headers(boolean flag, boolean flag1, int i, int j, List list, HeadersMode headersmode)
        {
            if (pushedStream(i))
            {
                pushHeadersLater(i, list, flag1);
                return;
            }
            SpdyConnection spdyconnection = SpdyConnection.this;
            spdyconnection;
            JVM INSTR monitorenter ;
            boolean flag2 = shutdown;
            if (!flag2)
            {
                break MISSING_BLOCK_LABEL_50;
            }
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            SpdyStream spdystream = getStream(i);
            if (spdystream != null)
            {
                break MISSING_BLOCK_LABEL_221;
            }
            if (!headersmode.failIfStreamAbsent())
            {
                break MISSING_BLOCK_LABEL_88;
            }
            writeSynResetLater(i, ErrorCode.INVALID_STREAM);
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            j = lastGoodStreamId;
            if (i > j)
            {
                break MISSING_BLOCK_LABEL_107;
            }
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            j = nextStreamId;
            if (i % 2 != j % 2)
            {
                break MISSING_BLOCK_LABEL_130;
            }
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            list = new SpdyStream(i, SpdyConnection.this, flag, flag1, list);
            lastGoodStreamId = i;
            streams.put(Integer.valueOf(i), list);
            class _cls1 extends NamedRunnable
            {

                final Reader this$1;
                final SpdyStream val$newStream;

                public void execute()
                {
                    try
                    {
                        handler.receive(newStream);
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        throw new RuntimeException(ioexception);
                    }
                }

                transient _cls1(Object aobj[], SpdyStream spdystream)
                {
                    this$1 = Reader.this;
                    newStream = spdystream;
                    super(final_s, aobj);
                }
            }

            SpdyConnection.executor.execute(new _cls1(new Object[] {
                hostName, Integer.valueOf(i)
            }, list));
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            spdyconnection;
            JVM INSTR monitorexit ;
              goto _L1
            list;
            throw list;
_L1:
            if (headersmode.failIfStreamPresent())
            {
                spdystream.closeLater(ErrorCode.PROTOCOL_ERROR);
                removeStream(i);
                return;
            }
            spdystream.receiveHeaders(list, headersmode);
            if (flag1)
            {
                spdystream.receiveFin();
            }
            return;
        }

        public void ping(boolean flag, int i, int j)
        {
            if (flag)
            {
                Ping ping1 = removePing(i);
                if (ping1 != null)
                {
                    ping1.receive();
                }
                return;
            } else
            {
                writePingLater(true, i, j, null);
                return;
            }
        }

        public void priority(int i, int j, int k, boolean flag)
        {
        }

        public void pushPromise(int i, int j, List list)
        {
            pushRequestLater(j, list);
        }

        public void rstStream(int i, ErrorCode errorcode)
        {
            if (pushedStream(i))
            {
                pushResetLater(i, errorcode);
                return;
            }
            SpdyStream spdystream = removeStream(i);
            if (spdystream != null)
            {
                spdystream.receiveRstStream(errorcode);
            }
        }

        public void settings(boolean flag, Settings settings1)
        {
            SpdyStream spdystream;
            long l1;
            l1 = 0L;
            spdystream = null;
            SpdyConnection spdyconnection = SpdyConnection.this;
            spdyconnection;
            JVM INSTR monitorenter ;
            int i = peerSettings.getInitialWindowSize(0x10000);
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_43;
            }
            peerSettings.clear();
            int j;
            peerSettings.merge(settings1);
            if (getProtocol() == Protocol.HTTP_2)
            {
                ackSettingsLater(settings1);
            }
            j = peerSettings.getInitialWindowSize(0x10000);
            long l;
            l = l1;
            settings1 = spdystream;
            if (j == -1)
            {
                break MISSING_BLOCK_LABEL_209;
            }
            l = l1;
            settings1 = spdystream;
            if (j == i)
            {
                break MISSING_BLOCK_LABEL_209;
            }
            l1 = j - i;
            if (!receivedInitialPeerSettings)
            {
                addBytesToWriteWindow(l1);
                receivedInitialPeerSettings = true;
            }
            l = l1;
            settings1 = spdystream;
            if (streams.isEmpty())
            {
                break MISSING_BLOCK_LABEL_209;
            }
            settings1 = (SpdyStream[])streams.values().toArray(new SpdyStream[streams.size()]);
            l = l1;
            spdyconnection;
            JVM INSTR monitorexit ;
              goto _L1
            settings1;
            throw settings1;
_L1:
            if (settings1 == null || l == 0L) goto _L3; else goto _L2
_L2:
            j = settings1.length;
            i = 0;
_L5:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            spdystream = settings1[i];
            spdystream;
            JVM INSTR monitorenter ;
            spdystream.addBytesToWriteWindow(l);
            spdystream;
            JVM INSTR monitorexit ;
              goto _L4
            settings1;
            throw settings1;
_L4:
            i++;
            if (true) goto _L5; else goto _L3
_L3:
        }

        public void windowUpdate(int i, long l)
        {
            if (i != 0)
            {
                break MISSING_BLOCK_LABEL_50;
            }
            Object obj = SpdyConnection.this;
            obj;
            JVM INSTR monitorenter ;
            SpdyConnection spdyconnection = SpdyConnection.this;
            spdyconnection.bytesLeftInWriteWindow = spdyconnection.bytesLeftInWriteWindow + l;
            notifyAll();
            obj;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
            obj = getStream(i);
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_86;
            }
            obj;
            JVM INSTR monitorenter ;
            ((SpdyStream) (obj)).addBytesToWriteWindow(l);
            obj;
            JVM INSTR monitorexit ;
            return;
            exception;
            throw exception;
        }

        private Reader()
        {
            this$0 = SpdyConnection.this;
            super("OkHttp %s", new Object[] {
                hostName
            });
        }

        Reader(_cls1 _pcls1)
        {
            this();
        }
    }


    static final boolean $assertionsDisabled;
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 0x1000000;
    private static final ExecutorService executor;
    long bytesLeftInWriteWindow;
    final boolean client;
    private final Set currentPushRequests;
    final FrameWriter frameWriter;
    private final IncomingStreamHandler handler;
    private final String hostName;
    private long idleStartTimeNs;
    private int lastGoodStreamId;
    private int nextPingId;
    private int nextStreamId;
    final Settings okHttpSettings;
    final Settings peerSettings;
    private Map pings;
    final Protocol protocol;
    private final ExecutorService pushExecutor;
    private final PushObserver pushObserver;
    final Reader readerRunnable;
    private boolean receivedInitialPeerSettings;
    private boolean shutdown;
    final Socket socket;
    private final Map streams;
    long unacknowledgedBytesRead;
    final Variant variant;

    private SpdyConnection(Builder builder)
    {
        streams = new HashMap();
        idleStartTimeNs = System.nanoTime();
        unacknowledgedBytesRead = 0L;
        okHttpSettings = new Settings();
        peerSettings = new Settings();
        receivedInitialPeerSettings = false;
        currentPushRequests = new LinkedHashSet();
        protocol = builder.protocol;
        pushObserver = builder.pushObserver;
        client = builder.client;
        handler = builder.handler;
        int i;
        if (builder.client)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        nextStreamId = i;
        if (builder.client && protocol == Protocol.HTTP_2)
        {
            nextStreamId = nextStreamId + 2;
        }
        if (builder.client)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        nextPingId = i;
        if (builder.client)
        {
            okHttpSettings.set(7, 0, 0x1000000);
        }
        hostName = builder.hostName;
        if (protocol == Protocol.HTTP_2)
        {
            variant = new Http2();
            pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[] {
                hostName
            }), true));
            peerSettings.set(7, 0, 65535);
            peerSettings.set(5, 0, 16384);
        } else
        if (protocol == Protocol.SPDY_3)
        {
            variant = new Spdy3();
            pushExecutor = null;
        } else
        {
            throw new AssertionError(protocol);
        }
        bytesLeftInWriteWindow = peerSettings.getInitialWindowSize(0x10000);
        socket = builder.socket;
        frameWriter = variant.newWriter(wc._mth02CA(wc._mth02CA(builder.socket)), client);
        readerRunnable = new Reader(null);
        (new Thread(readerRunnable)).start();
    }

    SpdyConnection(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    private void close(ErrorCode errorcode, ErrorCode errorcode1)
    {
        Object obj;
        if (!$assertionsDisabled && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        obj = null;
        shutdown(errorcode);
        errorcode = ((ErrorCode) (obj));
        break MISSING_BLOCK_LABEL_34;
        errorcode;
        SpdyStream aspdystream[] = null;
        Ping aping[] = null;
        this;
        JVM INSTR monitorenter ;
        if (!streams.isEmpty())
        {
            aspdystream = (SpdyStream[])streams.values().toArray(new SpdyStream[streams.size()]);
            streams.clear();
            setIdle(false);
        }
        if (pings != null)
        {
            aping = (Ping[])pings.values().toArray(new Ping[pings.size()]);
            pings = null;
        }
        this;
        JVM INSTR monitorexit ;
          goto _L1
        errorcode;
        throw errorcode;
_L1:
        obj = errorcode;
        if (aspdystream == null) goto _L3; else goto _L2
_L2:
        int i;
        int k;
        k = aspdystream.length;
        i = 0;
_L4:
        obj = errorcode;
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = aspdystream[i];
        ((SpdyStream) (obj)).close(errorcode1);
        obj = errorcode;
        break MISSING_BLOCK_LABEL_203;
        IOException ioexception;
        ioexception;
        obj = errorcode;
        if (errorcode != null)
        {
            obj = ioexception;
        }
        i++;
        errorcode = ((ErrorCode) (obj));
        if (true) goto _L4; else goto _L3
_L3:
        if (aping != null)
        {
            int l = aping.length;
            for (int j = 0; j < l; j++)
            {
                aping[j].cancel();
            }

        }
        frameWriter.close();
        errorcode = ((ErrorCode) (obj));
        break MISSING_BLOCK_LABEL_274;
        errorcode1;
        errorcode = ((ErrorCode) (obj));
        if (obj == null)
        {
            errorcode = errorcode1;
        }
        try
        {
            socket.close();
        }
        // Misplaced declaration of an exception variable
        catch (ErrorCode errorcode) { }
        if (errorcode != null)
        {
            throw errorcode;
        } else
        {
            return;
        }
    }

    private SpdyStream newStream(int i, List list, boolean flag, boolean flag1)
    {
        boolean flag2;
        if (!flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!flag1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        FrameWriter framewriter = frameWriter;
        framewriter;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        SpdyStream spdystream;
        int j;
        if (shutdown)
        {
            throw new IOException("shutdown");
        }
        j = nextStreamId;
        nextStreamId = nextStreamId + 2;
        spdystream = new SpdyStream(j, this, flag2, flag1, list);
        if (spdystream.isOpen())
        {
            streams.put(Integer.valueOf(j), spdystream);
            setIdle(false);
        }
        this;
        JVM INSTR monitorexit ;
          goto _L1
        list;
        throw list;
_L1:
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        frameWriter.synStream(flag2, flag1, j, i, list);
        break MISSING_BLOCK_LABEL_184;
        if (client)
        {
            throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
        }
        frameWriter.pushPromise(i, j, list);
        framewriter;
        JVM INSTR monitorexit ;
          goto _L2
        list;
        throw list;
_L2:
        if (!flag)
        {
            frameWriter.flush();
        }
        return spdystream;
    }

    private void pushDataLater(int i, vv vv1, int j, boolean flag)
    {
        vr vr1 = new vr();
        vv1._mth02BF(j);
        vv1.read(vr1, j);
        if (vr1.size != (long)j)
        {
            throw new IOException((new StringBuilder()).append(vr1.size).append(" != ").append(j).toString());
        } else
        {
            pushExecutor.execute(new _cls6(j, flag));
            return;
        }
    }

    private void pushHeadersLater(int i, List list, boolean flag)
    {
        pushExecutor.execute(new _cls5(list, flag));
    }

    private void pushRequestLater(int i, List list)
    {
        this;
        JVM INSTR monitorenter ;
        if (!currentPushRequests.contains(Integer.valueOf(i)))
        {
            break MISSING_BLOCK_LABEL_29;
        }
        writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
        this;
        JVM INSTR monitorexit ;
        return;
        currentPushRequests.add(Integer.valueOf(i));
        this;
        JVM INSTR monitorexit ;
          goto _L1
        list;
        throw list;
_L1:
        pushExecutor.execute(new _cls4(i, list));
        return;
    }

    private void pushResetLater(int i, ErrorCode errorcode)
    {
        pushExecutor.execute(new _cls7(i, errorcode));
    }

    private boolean pushedStream(int i)
    {
        return protocol == Protocol.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    private Ping removePing(int i)
    {
        this;
        JVM INSTR monitorenter ;
        Ping ping1;
        if (pings == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        ping1 = (Ping)pings.remove(Integer.valueOf(i));
        return ping1;
        this;
        JVM INSTR monitorexit ;
        return null;
        Exception exception;
        exception;
        throw exception;
    }

    private void setIdle(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag) goto _L2; else goto _L1
_L1:
        long l = System.nanoTime();
_L4:
        idleStartTimeNs = l;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
_L2:
        l = 0x7fffffffffffffffL;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void writePing(boolean flag, int i, int j, Ping ping1)
    {
        FrameWriter framewriter = frameWriter;
        framewriter;
        JVM INSTR monitorenter ;
        if (ping1 == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        ping1.send();
        frameWriter.ping(flag, i, j);
        framewriter;
        JVM INSTR monitorexit ;
        return;
        ping1;
        throw ping1;
    }

    private void writePingLater(boolean flag, int i, int j, Ping ping1)
    {
        executor.execute(new _cls3(j, ping1));
    }

    final void addBytesToWriteWindow(long l)
    {
        bytesLeftInWriteWindow = bytesLeftInWriteWindow + l;
        if (l > 0L)
        {
            notifyAll();
        }
    }

    public final void close()
    {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public final void flush()
    {
        frameWriter.flush();
    }

    public final long getIdleStartTimeNs()
    {
        this;
        JVM INSTR monitorenter ;
        long l = idleStartTimeNs;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public final Protocol getProtocol()
    {
        return protocol;
    }

    final SpdyStream getStream(int i)
    {
        this;
        JVM INSTR monitorenter ;
        SpdyStream spdystream = (SpdyStream)streams.get(Integer.valueOf(i));
        this;
        JVM INSTR monitorexit ;
        return spdystream;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean isIdle()
    {
        this;
        JVM INSTR monitorenter ;
        long l = idleStartTimeNs;
        if (l != 0x7fffffffffffffffL)
        {
            return true;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        throw exception;
    }

    public final SpdyStream newStream(List list, boolean flag, boolean flag1)
    {
        return newStream(0, list, flag, flag1);
    }

    public final int openStreamCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = streams.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final Ping ping()
    {
        Object obj = new Ping();
        this;
        JVM INSTR monitorenter ;
        int i;
        if (shutdown)
        {
            throw new IOException("shutdown");
        }
        i = nextPingId;
        nextPingId = nextPingId + 2;
        if (pings == null)
        {
            pings = new HashMap();
        }
        pings.put(Integer.valueOf(i), obj);
        this;
        JVM INSTR monitorexit ;
          goto _L1
        obj;
        throw obj;
_L1:
        writePing(false, i, 0x4f4b6f6b, ((Ping) (obj)));
        return ((Ping) (obj));
    }

    public final SpdyStream pushStream(int i, List list, boolean flag)
    {
        if (client)
        {
            throw new IllegalStateException("Client cannot push requests.");
        }
        if (protocol != Protocol.HTTP_2)
        {
            throw new IllegalStateException("protocol != HTTP_2");
        } else
        {
            return newStream(i, list, flag, false);
        }
    }

    final SpdyStream removeStream(int i)
    {
        this;
        JVM INSTR monitorenter ;
        SpdyStream spdystream = (SpdyStream)streams.remove(Integer.valueOf(i));
        if (spdystream == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        if (streams.isEmpty())
        {
            setIdle(true);
        }
        this;
        JVM INSTR monitorexit ;
        return spdystream;
        Exception exception;
        exception;
        throw exception;
    }

    public final void sendConnectionPreface()
    {
        frameWriter.connectionPreface();
        frameWriter.settings(okHttpSettings);
        int i = okHttpSettings.getInitialWindowSize(0x10000);
        if (i != 0x10000)
        {
            frameWriter.windowUpdate(0, i - 0x10000);
        }
    }

    public final void shutdown(ErrorCode errorcode)
    {
        FrameWriter framewriter = frameWriter;
        framewriter;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        boolean flag = shutdown;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        int i;
        shutdown = true;
        i = lastGoodStreamId;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        errorcode;
        throw errorcode;
_L1:
        frameWriter.goAway(i, errorcode, Util.EMPTY_BYTE_ARRAY);
        framewriter;
        JVM INSTR monitorexit ;
        return;
        errorcode;
        throw errorcode;
    }

    public final void writeData(int i, boolean flag, vr vr1, long l)
    {
        long l1;
        l1 = l;
        if (l == 0L)
        {
            frameWriter.data(flag, i, vr1, 0);
            return;
        }
_L5:
        if (l1 <= 0L) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        while (bytesLeftInWriteWindow <= 0L) 
        {
            wait();
        }
          goto _L3
_L6:
        throw new InterruptedIOException();
_L3:
        int j;
        j = Math.min((int)Math.min(l1, bytesLeftInWriteWindow), frameWriter.maxDataLength());
        bytesLeftInWriteWindow = bytesLeftInWriteWindow - (long)j;
        this;
        JVM INSTR monitorexit ;
          goto _L4
        vr1;
        throw vr1;
_L4:
        l1 -= j;
        FrameWriter framewriter = frameWriter;
        boolean flag1;
        if (flag && l1 == 0L)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        framewriter.data(flag1, i, vr1, j);
          goto _L5
_L2:
        return;
        vr1;
          goto _L6
    }

    final void writeSynReply(int i, boolean flag, List list)
    {
        frameWriter.synReply(flag, i, list);
    }

    final void writeSynReset(int i, ErrorCode errorcode)
    {
        frameWriter.rstStream(i, errorcode);
    }

    final void writeSynResetLater(int i, ErrorCode errorcode)
    {
        executor.submit(new _cls1(i, errorcode));
    }

    final void writeWindowUpdateLater(int i, long l)
    {
        executor.execute(new _cls2(i, l));
    }

    static 
    {
        boolean flag;
        if (!com/squareup/okhttp/internal/spdy/SpdyConnection.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
        executor = new ThreadPoolExecutor(0, 0x7fffffff, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp SpdyConnection", true));
    }







/*
    static boolean access$1402(SpdyConnection spdyconnection, boolean flag)
    {
        spdyconnection.shutdown = flag;
        return flag;
    }

*/



/*
    static int access$1502(SpdyConnection spdyconnection, int i)
    {
        spdyconnection.lastGoodStreamId = i;
        return i;
    }

*/








/*
    static boolean access$2102(SpdyConnection spdyconnection, boolean flag)
    {
        spdyconnection.receivedInitialPeerSettings = flag;
        return flag;
    }

*/








    private class _cls6 extends NamedRunnable
    {

        final SpdyConnection this$0;
        final vr val$buffer;
        final int val$byteCount;
        final boolean val$inFinished;
        final int val$streamId;

        public void execute()
        {
            SpdyConnection spdyconnection;
            Exception exception;
            boolean flag;
            try
            {
                flag = pushObserver.onData(streamId, buffer, byteCount, inFinished);
            }
            catch (IOException ioexception)
            {
                return;
            }
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            frameWriter.rstStream(streamId, ErrorCode.CANCEL);
            if (flag)
            {
                break MISSING_BLOCK_LABEL_63;
            }
            if (!inFinished)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            spdyconnection = SpdyConnection.this;
            spdyconnection;
            JVM INSTR monitorenter ;
            currentPushRequests.remove(Integer.valueOf(streamId));
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            exception;
            throw exception;
        }

        transient _cls6(int j, boolean flag)
        {
            this$0 = SpdyConnection.this;
            streamId = i;
            buffer = vr1;
            byteCount = j;
            inFinished = flag;
            super(final_s, final_aobj);
        }
    }


    private class _cls5 extends NamedRunnable
    {

        final SpdyConnection this$0;
        final boolean val$inFinished;
        final List val$requestHeaders;
        final int val$streamId;

        public void execute()
        {
            boolean flag = pushObserver.onHeaders(streamId, requestHeaders, inFinished);
            SpdyConnection spdyconnection;
            Exception exception;
            if (flag)
            {
                try
                {
                    frameWriter.rstStream(streamId, ErrorCode.CANCEL);
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }
            if (flag)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            if (!inFinished)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            spdyconnection = SpdyConnection.this;
            spdyconnection;
            JVM INSTR monitorenter ;
            currentPushRequests.remove(Integer.valueOf(streamId));
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            exception;
            throw exception;
        }

        transient _cls5(List list, boolean flag)
        {
            this$0 = SpdyConnection.this;
            streamId = i;
            requestHeaders = list;
            inFinished = flag;
            super(final_s, final_aobj);
        }
    }


    private class _cls4 extends NamedRunnable
    {

        final SpdyConnection this$0;
        final List val$requestHeaders;
        final int val$streamId;

        public void execute()
        {
            if (!pushObserver.onRequest(streamId, requestHeaders))
            {
                break MISSING_BLOCK_LABEL_77;
            }
            frameWriter.rstStream(streamId, ErrorCode.CANCEL);
            SpdyConnection spdyconnection = SpdyConnection.this;
            spdyconnection;
            JVM INSTR monitorenter ;
            currentPushRequests.remove(Integer.valueOf(streamId));
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
            return;
            IOException ioexception;
            ioexception;
        }

        transient _cls4(int i, List list)
        {
            this$0 = SpdyConnection.this;
            streamId = i;
            requestHeaders = list;
            super(final_s, final_aobj);
        }
    }


    private class _cls7 extends NamedRunnable
    {

        final SpdyConnection this$0;
        final ErrorCode val$errorCode;
        final int val$streamId;

        public void execute()
        {
            pushObserver.onReset(streamId, errorCode);
            SpdyConnection spdyconnection = SpdyConnection.this;
            spdyconnection;
            JVM INSTR monitorenter ;
            currentPushRequests.remove(Integer.valueOf(streamId));
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        transient _cls7(int i, ErrorCode errorcode)
        {
            this$0 = SpdyConnection.this;
            streamId = i;
            errorCode = errorcode;
            super(final_s, final_aobj);
        }
    }


    private class _cls3 extends NamedRunnable
    {

        final SpdyConnection this$0;
        final int val$payload1;
        final int val$payload2;
        final Ping val$ping;
        final boolean val$reply;

        public void execute()
        {
            try
            {
                writePing(reply, payload1, payload2, ping);
                return;
            }
            catch (IOException ioexception)
            {
                return;
            }
        }

        transient _cls3(int j, Ping ping1)
        {
            this$0 = SpdyConnection.this;
            reply = flag;
            payload1 = i;
            payload2 = j;
            ping = ping1;
            super(final_s, final_aobj);
        }
    }


    private class _cls1 extends NamedRunnable
    {

        final SpdyConnection this$0;
        final ErrorCode val$errorCode;
        final int val$streamId;

        public void execute()
        {
            try
            {
                writeSynReset(streamId, errorCode);
                return;
            }
            catch (IOException ioexception)
            {
                return;
            }
        }

        transient _cls1(int i, ErrorCode errorcode)
        {
            this$0 = SpdyConnection.this;
            streamId = i;
            errorCode = errorcode;
            super(final_s, final_aobj);
        }
    }


    private class _cls2 extends NamedRunnable
    {

        final SpdyConnection this$0;
        final int val$streamId;
        final long val$unacknowledgedBytesRead;

        public void execute()
        {
            try
            {
                frameWriter.windowUpdate(streamId, unacknowledgedBytesRead);
                return;
            }
            catch (IOException ioexception)
            {
                return;
            }
        }

        transient _cls2(int i, long l)
        {
            this$0 = SpdyConnection.this;
            streamId = i;
            unacknowledgedBytesRead = l;
            super(final_s, final_aobj);
        }
    }

}
