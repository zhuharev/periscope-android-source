// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.ws;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import o.vr;
import o.vv;
import o.wc;
import o.wn;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.ws:
//            WebSocketProtocol

public final class WebSocketReader
{
    public static interface FrameCallback
    {

        public abstract void onClose(int i, String s);

        public abstract void onMessage(vv vv1, com.squareup.okhttp.ws.WebSocket.PayloadType payloadtype);

        public abstract void onPing(vr vr1);

        public abstract void onPong(vr vr1);
    }

    final class FramedMessageSource
        implements wn
    {

        final WebSocketReader this$0;

        public final void close()
        {
            if (messageClosed)
            {
                return;
            }
            messageClosed = true;
            if (closed)
            {
                return;
            }
            source._mth02D1(frameLength - frameBytesRead);
            while (!isFinalFrame) 
            {
                readUntilNonControlFrame();
                source._mth02D1(frameLength);
            }
        }

        public final long read(vr vr1, long l)
        {
            if (closed)
            {
                throw new IOException("closed");
            }
            if (messageClosed)
            {
                throw new IllegalStateException("closed");
            }
            if (frameBytesRead == frameLength)
            {
                if (isFinalFrame)
                {
                    return -1L;
                }
                readUntilNonControlFrame();
                if (opcode != 0)
                {
                    throw new ProtocolException((new StringBuilder("Expected continuation opcode. Got: ")).append(Integer.toHexString(opcode)).toString());
                }
                if (isFinalFrame && frameLength == 0L)
                {
                    return -1L;
                }
            }
            l = Math.min(l, frameLength - frameBytesRead);
            if (isMasked)
            {
                l = Math.min(l, maskBuffer.length);
                long l1 = source.read(maskBuffer, 0, (int)l);
                l = l1;
                if (l1 == -1L)
                {
                    throw new EOFException();
                }
                WebSocketProtocol.toggleMask(maskBuffer, l, maskKey, frameBytesRead);
                vr1._mth02BC(maskBuffer, 0, (int)l);
            } else
            {
                long l2 = source.read(vr1, l);
                l = l2;
                if (l2 == -1L)
                {
                    throw new EOFException();
                }
            }
            frameBytesRead = frameBytesRead + l;
            return l;
        }

        public final wo timeout()
        {
            return source.timeout();
        }

        private FramedMessageSource()
        {
            this$0 = WebSocketReader.this;
            super();
        }

        FramedMessageSource(_cls1 _pcls1)
        {
            this();
        }
    }


    private boolean closed;
    private long frameBytesRead;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final wn framedMessageSource = new FramedMessageSource(null);
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private boolean isMasked;
    private final byte maskBuffer[] = new byte[2048];
    private final byte maskKey[] = new byte[4];
    private boolean messageClosed;
    private int opcode;
    private final vv source;

    public WebSocketReader(boolean flag, vv vv1, FrameCallback framecallback)
    {
        if (vv1 == null)
        {
            throw new NullPointerException("source == null");
        }
        if (framecallback == null)
        {
            throw new NullPointerException("frameCallback == null");
        } else
        {
            isClient = flag;
            source = vv1;
            frameCallback = framecallback;
            return;
        }
    }

    private void readControlFrame()
    {
        vr vr1 = null;
        if (frameBytesRead < frameLength)
        {
            vr vr2 = new vr();
            if (isClient)
            {
                source._mth02CA(vr2, frameLength);
                vr1 = vr2;
            } else
            {
                do
                {
                    vr1 = vr2;
                    if (frameBytesRead >= frameLength)
                    {
                        break;
                    }
                    int i = (int)Math.min(frameLength - frameBytesRead, maskBuffer.length);
                    i = source.read(maskBuffer, 0, i);
                    if (i == -1)
                    {
                        throw new EOFException();
                    }
                    WebSocketProtocol.toggleMask(maskBuffer, i, maskKey, frameBytesRead);
                    vr2._mth02BC(maskBuffer, 0, i);
                    frameBytesRead = frameBytesRead + (long)i;
                } while (true);
            }
        }
        switch (opcode)
        {
        case 9: // '\t'
            frameCallback.onPing(vr1);
            return;

        case 10: // '\n'
            frameCallback.onPong(vr1);
            return;

        case 8: // '\b'
            short word0 = 0;
            String s = "";
            if (vr1 != null)
            {
                word0 = vr1.readShort();
                s = vr1.FF8B();
            }
            frameCallback.onClose(word0, s);
            closed = true;
            return;
        }
        throw new IllegalStateException((new StringBuilder("Unknown control opcode: ")).append(Integer.toHexString(opcode)).toString());
    }

    private void readHeader()
    {
        if (closed)
        {
            throw new IOException("closed");
        }
        int j = source.readByte() & 0xff;
        opcode = j & 0xf;
        boolean flag2;
        if ((j & 0x80) != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        isFinalFrame = flag2;
        if ((j & 8) != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        isControlFrame = flag2;
        if (isControlFrame && !isFinalFrame)
        {
            throw new ProtocolException("Control frames must be final.");
        }
        boolean flag;
        if ((j & 0x40) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if ((j & 0x20) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if ((j & 0x10) != 0)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (flag || flag1 || j)
        {
            throw new ProtocolException("Reserved flags are unsupported.");
        }
        int i = source.readByte() & 0xff;
        if ((i & 0x80) != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        isMasked = flag2;
        if (isMasked == isClient)
        {
            throw new ProtocolException("Client-sent frames must be masked. Server sent must not.");
        }
        frameLength = i & 0x7f;
        if (frameLength == 126L)
        {
            frameLength = (long)source.readShort() & 65535L;
        } else
        if (frameLength == 127L)
        {
            frameLength = source.readLong();
            if (frameLength < 0L)
            {
                throw new ProtocolException((new StringBuilder("Frame length 0x")).append(Long.toHexString(frameLength)).append(" > 0x7FFFFFFFFFFFFFFF").toString());
            }
        }
        frameBytesRead = 0L;
        if (isControlFrame && frameLength > 125L)
        {
            throw new ProtocolException("Control frame must be less than 125B.");
        }
        if (isMasked)
        {
            source.readFully(maskKey);
        }
    }

    private void readMessageFrame()
    {
        com.squareup.okhttp.ws.WebSocket.PayloadType payloadtype;
        switch (opcode)
        {
        case 1: // '\001'
            payloadtype = com.squareup.okhttp.ws.WebSocket.PayloadType.TEXT;
            break;

        case 2: // '\002'
            payloadtype = com.squareup.okhttp.ws.WebSocket.PayloadType.BINARY;
            break;

        default:
            throw new IllegalStateException((new StringBuilder("Unknown opcode: ")).append(Integer.toHexString(opcode)).toString());
        }
        messageClosed = false;
        frameCallback.onMessage(wc._mth02CB(framedMessageSource), payloadtype);
        if (!messageClosed)
        {
            throw new IllegalStateException("Listener failed to call close on message payload.");
        } else
        {
            return;
        }
    }

    private void readUntilNonControlFrame()
    {
        do
        {
            if (closed)
            {
                break;
            }
            readHeader();
            if (!isControlFrame)
            {
                break;
            }
            readControlFrame();
        } while (true);
    }

    public final void processNextFrame()
    {
        readHeader();
        if (isControlFrame)
        {
            readControlFrame();
            return;
        } else
        {
            readMessageFrame();
            return;
        }
    }






/*
    static boolean access$202(WebSocketReader websocketreader, boolean flag)
    {
        websocketreader.messageClosed = flag;
        return flag;
    }

*/



/*
    static long access$302(WebSocketReader websocketreader, long l)
    {
        websocketreader.frameBytesRead = l;
        return l;
    }

*/






}
