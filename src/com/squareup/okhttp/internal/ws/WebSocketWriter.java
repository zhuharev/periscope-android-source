// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.ws;

import java.io.IOException;
import java.util.Random;
import o.vr;
import o.vu;
import o.vv;
import o.wc;
import o.wm;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.ws:
//            WebSocketProtocol

public final class WebSocketWriter
{
    final class FrameSink
        implements wm
    {

        private boolean isFirstFrame;
        private com.squareup.okhttp.ws.WebSocket.PayloadType payloadType;
        final WebSocketWriter this$0;

        public final void close()
        {
            if (closed)
            {
                throw new IOException("closed");
            }
            vu vu1 = sink;
            vu1;
            JVM INSTR monitorenter ;
            sink._mth04C0(128);
            if (isClient)
            {
                sink._mth04C0(128);
                random.nextBytes(maskKey);
                sink._mth02C8(maskKey);
                break MISSING_BLOCK_LABEL_126;
            }
            sink._mth04C0(0);
            sink.flush();
            vu1;
            JVM INSTR monitorexit ;
              goto _L1
            Exception exception;
            exception;
            throw exception;
_L1:
            activeWriter = false;
            return;
        }

        public final void flush()
        {
            if (closed)
            {
                throw new IOException("closed");
            }
            vu vu1 = sink;
            vu1;
            JVM INSTR monitorenter ;
            sink.flush();
            vu1;
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
            writeFrame(payloadType, vr1, l, isFirstFrame, false);
            isFirstFrame = false;
        }


/*
        static com.squareup.okhttp.ws.WebSocket.PayloadType access$102(FrameSink framesink, com.squareup.okhttp.ws.WebSocket.PayloadType payloadtype)
        {
            framesink.payloadType = payloadtype;
            return payloadtype;
        }

*/


/*
        static boolean access$202(FrameSink framesink, boolean flag)
        {
            framesink.isFirstFrame = flag;
            return flag;
        }

*/

        private FrameSink()
        {
            this$0 = WebSocketWriter.this;
            super();
        }

        FrameSink(_cls1 _pcls1)
        {
            this();
        }
    }


    private boolean activeWriter;
    private boolean closed;
    private final FrameSink frameSink = new FrameSink(null);
    private final boolean isClient;
    private final byte maskBuffer[];
    private final byte maskKey[];
    private final Random random;
    private final vu sink;

    public WebSocketWriter(boolean flag, vu vu1, Random random1)
    {
        if (vu1 == null)
        {
            throw new NullPointerException("sink == null");
        }
        if (random1 == null)
        {
            throw new NullPointerException("random == null");
        }
        isClient = flag;
        sink = vu1;
        random = random1;
        if (flag)
        {
            vu1 = new byte[4];
        } else
        {
            vu1 = null;
        }
        maskKey = vu1;
        if (flag)
        {
            vu1 = new byte[2048];
        } else
        {
            vu1 = null;
        }
        maskBuffer = vu1;
    }

    private void writeAllMasked(vv vv1, long l)
    {
        int i;
        for (long l1 = 0L; l1 < l; l1 += i)
        {
            i = (int)Math.min(l, maskBuffer.length);
            i = vv1.read(maskBuffer, 0, i);
            if (i == -1)
            {
                throw new AssertionError();
            }
            WebSocketProtocol.toggleMask(maskBuffer, i, maskKey, l1);
            sink._mth02BD(maskBuffer, 0, i);
        }

    }

    private void writeControlFrame(int i, vr vr1)
    {
        if (closed)
        {
            throw new IOException("closed");
        }
        int j = 0;
        if (vr1 != null)
        {
            int k = (int)vr1.size;
            j = k;
            if (k > 125)
            {
                throw new IllegalArgumentException("Payload size must be less than or equal to 125");
            }
        }
        sink._mth04C0(i | 0x80);
        if (isClient)
        {
            sink._mth04C0(j | 0x80);
            random.nextBytes(maskKey);
            sink._mth02C8(maskKey);
            if (vr1 != null)
            {
                writeAllMasked(vr1, j);
            }
        } else
        {
            sink._mth04C0(j);
            if (vr1 != null)
            {
                sink._mth02CA(vr1);
            }
        }
        sink.flush();
    }

    private void writeFrame(com.squareup.okhttp.ws.WebSocket.PayloadType payloadtype, vr vr1, long l, boolean flag, boolean flag1)
    {
        char c;
        if (closed)
        {
            throw new IOException("closed");
        }
        c = '\0';
        if (flag)
        {
            switch (_cls1..SwitchMap.com.squareup.okhttp.ws.WebSocket.PayloadType[payloadtype.ordinal()])
            {
            case 1: // '\001'
                c = '\001';
                break;

            case 2: // '\002'
                c = '\002';
                break;

            default:
                throw new IllegalStateException((new StringBuilder("Unknown payload type: ")).append(payloadtype).toString());
            }
        }
        payloadtype = sink;
        payloadtype;
        JVM INSTR monitorenter ;
        int i;
        i = c;
        if (flag1)
        {
            i = c | 0x80;
        }
        sink._mth04C0(i);
        c = '\0';
        if (!isClient)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        c = '\200';
        random.nextBytes(maskKey);
        if (l > 125L)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        i = (int)l;
        sink._mth04C0(c | i);
        break MISSING_BLOCK_LABEL_255;
        if (l > 65535L)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        sink._mth04C0(c | 0x7e);
        sink._mth0457((int)l);
        break MISSING_BLOCK_LABEL_255;
        sink._mth04C0(c | 0x7f);
        sink._mth02B9(l);
        if (isClient)
        {
            sink._mth02C8(maskKey);
            writeAllMasked(vr1, l);
            break MISSING_BLOCK_LABEL_296;
        }
        sink.write(vr1, l);
        sink.flush();
        payloadtype;
        JVM INSTR monitorexit ;
        return;
        vr1;
        throw vr1;
    }

    public final vu newMessageSink(com.squareup.okhttp.ws.WebSocket.PayloadType payloadtype)
    {
        if (payloadtype == null)
        {
            throw new NullPointerException("type == null");
        }
        if (activeWriter)
        {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        } else
        {
            activeWriter = true;
            frameSink.payloadType = payloadtype;
            frameSink.isFirstFrame = true;
            return wc._mth02CA(frameSink);
        }
    }

    public final void sendMessage(com.squareup.okhttp.ws.WebSocket.PayloadType payloadtype, vr vr1)
    {
        if (payloadtype == null)
        {
            throw new NullPointerException("type == null");
        }
        if (vr1 == null)
        {
            throw new NullPointerException("payload == null");
        }
        if (activeWriter)
        {
            throw new IllegalStateException("A message writer is active. Did you call close()?");
        } else
        {
            writeFrame(payloadtype, vr1, vr1.size, true, true);
            return;
        }
    }

    public final void writeClose(int i, String s)
    {
        vr vr1;
        vr1 = null;
        if (i != 0)
        {
            if (i < 1000 || i >= 5000)
            {
                throw new IllegalArgumentException("Code must be in range [1000,5000).");
            }
            vr vr2 = new vr();
            vr2._mth02BA(i);
            vr1 = vr2;
            if (s != null)
            {
                vr2._mth02B5(s);
                vr1 = vr2;
            }
        } else
        if (s != null)
        {
            throw new IllegalArgumentException("Code required to include reason.");
        }
        s = sink;
        s;
        JVM INSTR monitorenter ;
        writeControlFrame(8, vr1);
        closed = true;
        s;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void writePing(vr vr1)
    {
        vu vu1 = sink;
        vu1;
        JVM INSTR monitorenter ;
        writeControlFrame(9, vr1);
        vu1;
        JVM INSTR monitorexit ;
        return;
        vr1;
        throw vr1;
    }

    public final void writePong(vr vr1)
    {
        vu vu1 = sink;
        vu1;
        JVM INSTR monitorenter ;
        writeControlFrame(10, vr1);
        vu1;
        JVM INSTR monitorexit ;
        return;
        vr1;
        throw vr1;
    }








/*
    static boolean access$902(WebSocketWriter websocketwriter, boolean flag)
    {
        websocketwriter.activeWriter = flag;
        return flag;
    }

*/

    private class _cls1
    {

        static final int $SwitchMap$com$squareup$okhttp$ws$WebSocket$PayloadType[];

        static 
        {
            $SwitchMap$com$squareup$okhttp$ws$WebSocket$PayloadType = new int[com.squareup.okhttp.ws.WebSocket.PayloadType.values().length];
            try
            {
                $SwitchMap$com$squareup$okhttp$ws$WebSocket$PayloadType[com.squareup.okhttp.ws.WebSocket.PayloadType.TEXT.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                $SwitchMap$com$squareup$okhttp$ws$WebSocket$PayloadType[com.squareup.okhttp.ws.WebSocket.PayloadType.BINARY.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
        }
    }

}
