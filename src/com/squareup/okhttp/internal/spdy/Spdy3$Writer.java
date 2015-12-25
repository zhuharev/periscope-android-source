// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;
import o.vr;
import o.vu;
import o.vw;
import o.vx;
import o.wc;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            FrameWriter, Spdy3, Header, ErrorCode, 
//            Settings

static final class headerBlockBuffer
    implements FrameWriter
{

    private final boolean client;
    private boolean closed;
    private final vr headerBlockBuffer = new vr();
    private final vu headerBlockOut;
    private final vu sink;

    private void writeNameValueBlockToBuffer(List list)
    {
        if (headerBlockBuffer.size != 0L)
        {
            throw new IllegalStateException();
        }
        headerBlockOut._mth0456(list.size());
        int i = 0;
        for (int j = list.size(); i < j; i++)
        {
            vw vw1 = ((Header)list.get(i)).name;
            headerBlockOut._mth0456(vw1.data.length);
            headerBlockOut._mth02CA(vw1);
            vw1 = ((Header)list.get(i)).value;
            headerBlockOut._mth0456(vw1.data.length);
            headerBlockOut._mth02CA(vw1);
        }

        headerBlockOut.flush();
    }

    public final void ackSettings(Settings settings1)
    {
    }

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        closed = true;
        Util.closeAll(sink, headerBlockOut);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void connectionPreface()
    {
        this;
        JVM INSTR monitorenter ;
    }

    public final void data(boolean flag, int i, vr vr1, int j)
    {
        this;
        JVM INSTR monitorenter ;
        int k;
        if (flag)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        sendDataFrame(i, k, vr1, j);
        this;
        JVM INSTR monitorexit ;
        return;
        vr1;
        throw vr1;
    }

    public final void flush()
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        sink.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void goAway(int i, ErrorCode errorcode, byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        if (errorcode.spdyGoAwayCode == -1)
        {
            throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
        }
        sink._mth0456(0x80030007);
        sink._mth0456(8);
        sink._mth0456(i);
        sink._mth0456(errorcode.spdyGoAwayCode);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        errorcode;
        throw errorcode;
    }

    public final void headers(int i, List list)
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        writeNameValueBlockToBuffer(list);
        int j = (int)(headerBlockBuffer.size + 4L);
        sink._mth0456(0x80030008);
        sink._mth0456(0xffffff & j | 0);
        sink._mth0456(0x7fffffff & i);
        sink._mth02CA(headerBlockBuffer);
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        throw list;
    }

    public final int maxDataLength()
    {
        return 16383;
    }

    public final void ping(boolean flag, int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag2;
        if (closed)
        {
            throw new IOException("closed");
        }
        flag2 = client;
        break MISSING_BLOCK_LABEL_25;
_L2:
        if (flag == flag1)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        throw new IllegalArgumentException("payload != reply");
        sink._mth0456(0x80030006);
        sink._mth0456(4);
        sink._mth0456(i);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        throw exception;
        Exception exception;
        boolean flag1;
        if ((i & 1) == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag2 != flag1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void pushPromise(int i, int j, List list)
    {
    }

    public final void rstStream(int i, ErrorCode errorcode)
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        if (errorcode.spdyRstCode == -1)
        {
            throw new IllegalArgumentException();
        }
        sink._mth0456(0x80030003);
        sink._mth0456(8);
        sink._mth0456(0x7fffffff & i);
        sink._mth0456(errorcode.spdyRstCode);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        errorcode;
        throw errorcode;
    }

    final void sendDataFrame(int i, int j, vr vr1, int k)
    {
        if (closed)
        {
            throw new IOException("closed");
        }
        if ((long)k > 0xffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder("FRAME_TOO_LARGE max size is 16Mib: ")).append(k).toString());
        }
        sink._mth0456(0x7fffffff & i);
        sink._mth0456((j & 0xff) << 24 | 0xffffff & k);
        if (k > 0)
        {
            sink.write(vr1, k);
        }
    }

    public final void settings(Settings settings1)
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        int i = settings1.size();
        sink._mth0456(0x80030004);
        sink._mth0456(0xffffff & (i << 3) + 4 | 0);
        sink._mth0456(i);
        int j = 0;
_L2:
        if (j > 10)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        if (settings1.isSet(j))
        {
            int k = settings1.flags(j);
            sink._mth0456((k & 0xff) << 24 | 0xffffff & j);
            sink._mth0456(settings1.get(j));
        }
        break MISSING_BLOCK_LABEL_147;
        sink.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        settings1;
        throw settings1;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void synReply(boolean flag, int i, List list)
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        writeNameValueBlockToBuffer(list);
        int j;
        int k;
        if (flag)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        k = (int)(headerBlockBuffer.size + 4L);
        sink._mth0456(0x80030002);
        sink._mth0456((j & 0xff) << 24 | 0xffffff & k);
        sink._mth0456(0x7fffffff & i);
        sink._mth02CA(headerBlockBuffer);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        throw list;
    }

    public final void synStream(boolean flag, boolean flag1, int i, int j, List list)
    {
        this;
        JVM INSTR monitorenter ;
        int k;
        if (closed)
        {
            throw new IOException("closed");
        }
        writeNameValueBlockToBuffer(list);
        k = (int)(headerBlockBuffer.size + 10L);
        break MISSING_BLOCK_LABEL_39;
_L2:
        sink._mth0456(0x80030001);
        sink._mth0456(((flag2 | byte0) & 0xff) << 24 | 0xffffff & k);
        sink._mth0456(0x7fffffff & i);
        sink._mth0456(0x7fffffff & j);
        sink._mth0457(0);
        sink._mth02CA(headerBlockBuffer);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        throw list;
        boolean flag2;
        byte byte0;
        if (flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag1)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void windowUpdate(int i, long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
          goto _L1
_L2:
        throw new IllegalArgumentException((new StringBuilder("windowSizeIncrement must be between 1 and 0x7fffffff: ")).append(l).toString());
_L3:
        sink._mth0456(0x80030009);
        sink._mth0456(8);
        sink._mth0456(i);
        sink._mth0456((int)l);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
_L1:
        if (l != 0L && l <= 0x7fffffffL) goto _L3; else goto _L2
    }

    (vu vu1, boolean flag)
    {
        sink = vu1;
        client = flag;
        vu1 = new Deflater();
        vu1.setDictionary(Spdy3.DICTIONARY);
        headerBlockOut = wc._mth02CA(new vx(headerBlockBuffer, vu1));
    }
}
