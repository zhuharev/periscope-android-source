// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package o:
//            FF6A

public final class aox
{

    private MediaMuxer bwU;
    private int bwV;
    private int bwW;
    private long bwX[];

    public aox()
    {
        bwV = -1;
        bwW = -1;
        bwX = new long[2];
    }

    private void _mth02CA(int i, ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo)
    {
        this;
        JVM INSTR monitorenter ;
        if (bwU == null || i < 0)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        Object obj;
        if (bufferinfo.presentationTimeUs >= bwX[i])
        {
            break MISSING_BLOCK_LABEL_101;
        }
        obj = new StringBuilder();
        StringBuilder stringbuilder;
        if (i == bwV)
        {
            bytebuffer = "Audio";
        } else
        {
            bytebuffer = "Video";
        }
        FF6A._mth02CB("RTMP", ((StringBuilder) (obj)).append(bytebuffer).append(" time reversed from ").append(bwX[i] / 1000L).append(" to ").append(bufferinfo.presentationTimeUs / 1000L).toString());
        this;
        JVM INSTR monitorexit ;
        return;
        if (bufferinfo.presentationTimeUs - bwX[i] <= 0x186a0L)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        stringbuilder = new StringBuilder();
        if (i == bwV)
        {
            obj = "Audio";
        } else
        {
            obj = "Video";
        }
        FF6A._mth02CB("RTMP", stringbuilder.append(((String) (obj))).append(" time jump from ").append(bwX[i] / 1000L).append(" to ").append(bufferinfo.presentationTimeUs / 1000L).toString());
        bwX[i] = bufferinfo.presentationTimeUs;
        bwU.writeSampleData(i, bytebuffer, bufferinfo);
        bytebuffer.position(bufferinfo.offset);
        bytebuffer.limit(bufferinfo.offset + bufferinfo.size);
        this;
        JVM INSTR monitorexit ;
        return;
        bytebuffer;
        throw bytebuffer;
    }

    public final void dX()
    {
        this;
        JVM INSTR monitorenter ;
        MediaMuxer mediamuxer = bwU;
        if (mediamuxer == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        bwU.stop();
        bwU.release();
        FF6A._mth02CB("RTMP", "Recording ended");
        break MISSING_BLOCK_LABEL_40;
        Object obj;
        obj;
        ((Exception) (obj)).printStackTrace();
        bwU = null;
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public final void _mth02CA(String s, MediaFormat mediaformat, MediaFormat mediaformat1)
    {
        this;
        JVM INSTR monitorenter ;
        long al[];
        al = bwX;
        bwX[1] = 0L;
        al[0] = 0L;
        bwU = new MediaMuxer(s, 0);
        bwV = bwU.addTrack(mediaformat);
        bwW = bwU.addTrack(mediaformat1);
        bwU.start();
        FF6A._mth02CB("RTMP", (new StringBuilder("Recording started to: ")).append(s).toString());
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        s.printStackTrace();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final void _mth02CE(ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo)
    {
        this;
        JVM INSTR monitorenter ;
        _mth02CA(bwV, bytebuffer, bufferinfo);
        this;
        JVM INSTR monitorexit ;
        return;
        bytebuffer;
        throw bytebuffer;
    }

    public final void _mth02CF(ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo)
    {
        this;
        JVM INSTR monitorenter ;
        _mth02CA(bwW, bytebuffer, bufferinfo);
        this;
        JVM INSTR monitorexit ;
        return;
        bytebuffer;
        throw bytebuffer;
    }
}
