// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import o.vv;
import o.vw;
import o.wc;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyConnection, ErrorCode, SpdyStream, Variant, 
//            FrameReader, HeadersMode, Ping, Settings

class <init> extends NamedRunnable
    implements <init>
{

    FrameReader frameReader;
    final SpdyConnection this$0;

    private void ackSettingsLater(Settings settings1)
    {
        class _cls2 extends NamedRunnable
        {

            final SpdyConnection.Reader this$1;
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
                this$1 = SpdyConnection.Reader.this;
                peerSettings = settings1;
                super(final_s, aobj);
            }
        }

        SpdyConnection.access$1900().execute(new _cls2(new Object[] {
            SpdyConnection.access$900(SpdyConnection.this)
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
        if (SpdyConnection.access$1100(SpdyConnection.this, i))
        {
            SpdyConnection.access$1200(SpdyConnection.this, i, vv1, j, flag);
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
                SpdyConnection.access$1000(SpdyConnection.this, errorcode, errorcode3);
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
            SpdyConnection.access$1000(SpdyConnection.this, errorcode2, errorcode4);
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
            SpdyConnection.access$1000(SpdyConnection.this, errorcode1, errorcode2);
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
        vw = (SpdyStream[])SpdyConnection.access$1700(SpdyConnection.this).values().toArray(new SpdyStream[SpdyConnection.access$1700(SpdyConnection.this).size()]);
        SpdyConnection.access$1402(SpdyConnection.this, true);
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
        if (SpdyConnection.access$1100(SpdyConnection.this, i))
        {
            SpdyConnection.access$1300(SpdyConnection.this, i, list, flag1);
            return;
        }
        SpdyConnection spdyconnection = SpdyConnection.this;
        spdyconnection;
        JVM INSTR monitorenter ;
        boolean flag2 = SpdyConnection.access$1400(SpdyConnection.this);
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
        j = SpdyConnection.access$1500(SpdyConnection.this);
        if (i > j)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        spdyconnection;
        JVM INSTR monitorexit ;
        return;
        j = SpdyConnection.access$1600(SpdyConnection.this);
        if (i % 2 != j % 2)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        spdyconnection;
        JVM INSTR monitorexit ;
        return;
        list = new SpdyStream(i, SpdyConnection.this, flag, flag1, list);
        SpdyConnection.access$1502(SpdyConnection.this, i);
        SpdyConnection.access$1700(SpdyConnection.this).put(Integer.valueOf(i), list);
        class _cls1 extends NamedRunnable
        {

            final SpdyConnection.Reader this$1;
            final SpdyStream val$newStream;

            public void execute()
            {
                try
                {
                    SpdyConnection.access$1800(this$0).receive(newStream);
                    return;
                }
                catch (IOException ioexception)
                {
                    throw new RuntimeException(ioexception);
                }
            }

            transient _cls1(Object aobj[], SpdyStream spdystream)
            {
                this$1 = SpdyConnection.Reader.this;
                newStream = spdystream;
                super(final_s, aobj);
            }
        }

        SpdyConnection.access$1900().execute(new _cls1(new Object[] {
            SpdyConnection.access$900(SpdyConnection.this), Integer.valueOf(i)
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
            Ping ping1 = SpdyConnection.access$2200(SpdyConnection.this, i);
            if (ping1 != null)
            {
                ping1.receive();
            }
            return;
        } else
        {
            SpdyConnection.access$2300(SpdyConnection.this, true, i, j, null);
            return;
        }
    }

    public void priority(int i, int j, int k, boolean flag)
    {
    }

    public void pushPromise(int i, int j, List list)
    {
        SpdyConnection.access$2400(SpdyConnection.this, j, list);
    }

    public void rstStream(int i, ErrorCode errorcode)
    {
        if (SpdyConnection.access$1100(SpdyConnection.this, i))
        {
            SpdyConnection.access$2000(SpdyConnection.this, i, errorcode);
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
        if (!SpdyConnection.access$2100(SpdyConnection.this))
        {
            addBytesToWriteWindow(l1);
            SpdyConnection.access$2102(SpdyConnection.this, true);
        }
        l = l1;
        settings1 = spdystream;
        if (SpdyConnection.access$1700(SpdyConnection.this).isEmpty())
        {
            break MISSING_BLOCK_LABEL_209;
        }
        settings1 = (SpdyStream[])SpdyConnection.access$1700(SpdyConnection.this).values().toArray(new SpdyStream[SpdyConnection.access$1700(SpdyConnection.this).size()]);
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

    private _cls1()
    {
        this$0 = SpdyConnection.this;
        super("OkHttp %s", new Object[] {
            SpdyConnection.access$900(SpdyConnection.this)
        });
    }

    _cls900(_cls900 _pcls900)
    {
        this();
    }
}
