// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketListener;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Random;
import java.util.concurrent.Executor;
import o.vr;
import o.vu;
import o.vv;

// Referenced classes of package com.squareup.okhttp.internal.ws:
//            WebSocketWriter, WebSocketReader

public abstract class RealWebSocket
    implements WebSocket
{

    private static final int CLOSE_PROTOCOL_EXCEPTION = 1002;
    private final Object closeLock = new Object();
    private final WebSocketListener listener;
    private final WebSocketReader reader;
    private volatile boolean readerSentClose;
    private final WebSocketWriter writer;
    private volatile boolean writerSentClose;

    public RealWebSocket(boolean flag, vv vv, vu vu, Random random, final Executor replyExecutor, final WebSocketListener listener, final String url)
    {
        this.listener = listener;
        writer = new WebSocketWriter(flag, vu, random);
        reader = new WebSocketReader(flag, vv, new _cls1());
    }

    private void peerClose(int i, String s)
    {
        Object obj = closeLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag1;
        readerSentClose = true;
        flag1 = writerSentClose;
        boolean flag;
        if (!flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        s;
        throw s;
_L1:
        if (flag)
        {
            try
            {
                writer.writeClose(i, s);
            }
            catch (IOException ioexception) { }
        }
        try
        {
            closeConnection();
        }
        catch (IOException ioexception1) { }
        listener.onClose(i, s);
        return;
    }

    private void readerErrorClose(IOException ioexception)
    {
        Object obj = closeLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag1;
        readerSentClose = true;
        flag1 = writerSentClose;
        boolean flag;
        if (!flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        ioexception;
        throw ioexception;
_L1:
        if (flag && (ioexception instanceof ProtocolException))
        {
            try
            {
                writer.writeClose(1002, null);
            }
            catch (IOException ioexception1) { }
        }
        try
        {
            closeConnection();
        }
        catch (IOException ioexception2) { }
        listener.onFailure(ioexception);
        return;
    }

    public void close(int i, String s)
    {
        if (writerSentClose)
        {
            throw new IllegalStateException("closed");
        }
        Object obj = closeLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        writerSentClose = true;
        flag = readerSentClose;
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        s;
        throw s;
_L1:
        writer.writeClose(i, s);
        if (flag)
        {
            closeConnection();
        }
        return;
    }

    public abstract void closeConnection();

    public vu newMessageSink(com.squareup.okhttp.ws.WebSocket.PayloadType payloadtype)
    {
        if (writerSentClose)
        {
            throw new IllegalStateException("closed");
        } else
        {
            return writer.newMessageSink(payloadtype);
        }
    }

    public boolean readMessage()
    {
        boolean flag;
        try
        {
            reader.processNextFrame();
            flag = readerSentClose;
        }
        catch (IOException ioexception)
        {
            readerErrorClose(ioexception);
            return false;
        }
        return !flag;
    }

    public void sendMessage(com.squareup.okhttp.ws.WebSocket.PayloadType payloadtype, vr vr)
    {
        if (writerSentClose)
        {
            throw new IllegalStateException("closed");
        } else
        {
            writer.sendMessage(payloadtype, vr);
            return;
        }
    }

    public void sendPing(vr vr)
    {
        if (writerSentClose)
        {
            throw new IllegalStateException("closed");
        } else
        {
            writer.writePing(vr);
            return;
        }
    }

    public void sendPong(vr vr)
    {
        if (writerSentClose)
        {
            throw new IllegalStateException("closed");
        } else
        {
            writer.writePong(vr);
            return;
        }
    }



    private class _cls1
        implements WebSocketReader.FrameCallback
    {

        final RealWebSocket this$0;
        final WebSocketListener val$listener;
        final Executor val$replyExecutor;
        final String val$url;

        public void onClose(int i, String s)
        {
            class _cls2 extends NamedRunnable
            {

                final _cls1 this$1;
                final int val$code;
                final String val$reason;

                protected void execute()
                {
                    peerClose(code, reason);
                }

                transient _cls2(int i, String s1)
                {
                    this$1 = _cls1.this;
                    code = i;
                    reason = s1;
                    super(final_s, final_aobj);
                }
            }

            replyExecutor.execute(new _cls2(i, s));
        }

        public void onMessage(vv vv, com.squareup.okhttp.ws.WebSocket.PayloadType payloadtype)
        {
            listener.onMessage(vv, payloadtype);
        }

        public void onPing(vr vr)
        {
            class _cls1 extends NamedRunnable
            {

                final _cls1 this$1;
                final vr val$buffer;

                protected void execute()
                {
                    try
                    {
                        writer.writePong(buffer);
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        return;
                    }
                }

                transient _cls1(Object aobj[], vr vr)
                {
                    this$1 = _cls1.this;
                    buffer = vr;
                    super(final_s, aobj);
                }
            }

            replyExecutor.execute(new _cls1(new Object[] {
                url
            }, vr));
        }

        public void onPong(vr vr)
        {
            listener.onPong(vr);
        }

        _cls1()
        {
            this$0 = RealWebSocket.this;
            listener = websocketlistener;
            replyExecutor = executor;
            url = s;
            super();
        }
    }

}
