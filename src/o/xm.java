// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import tv.periscope.android.util.Size;

// Referenced classes of package o:
//            xl, FF6A, xo, aoe, 
//            xp, aar, xq, xn, 
//            aax, aav, _cls0675, aba, 
//            aaq, aat, aas, aaz, 
//            aed, xr

public final class xm
    implements xl, android.graphics.SurfaceTexture.OnFrameAvailableListener
{
    public final class aux
        implements aav._cls02BD
    {

        final xm aTI;

        public final void _mth02D0(int i, int j)
        {
            GLES20.glViewport(0, 0, i, j);
        }

        public final void FC61()
        {
            xm._mth037A(aTI).post(new xr(this));
        }

        public final void FE99()
        {
            aba aba1 = xm._mth02CB(aTI);
            boolean flag;
            if (xm._mth02BC(aTI).facing == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            aba1.bay = flag;
            xm._mth02CB(aTI)._mth02CA(xm._mth141D(aTI));
        }

        public aux()
        {
            aTI = xm.this;
            super();
        }
    }

    final class if extends _cls02CF
    {

        private xm aTI;

        public final void run()
        {
            xm._mth02CD(aTI).start();
            Object obj = super.aTT;
            obj;
            JVM INSTR monitorenter ;
            super.FE7B = true;
            super.aTT.notifyAll();
            obj;
            JVM INSTR monitorexit ;
              goto _L1
            Object obj1;
            obj1;
            throw obj1;
_L1:
            ByteBuffer abytebuffer[] = xm._mth02CD(aTI).getInputBuffers();
_L3:
            boolean flag;
            if (!super.aTS)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = null;
            _cls02CA _lcls02ca = (_cls02CA)xm._mth02D1(aTI).poll(1000L, TimeUnit.MICROSECONDS);
            obj = _lcls02ca;
_L4:
            if (obj != null)
            {
                do
                {
                    int i;
                    if (!super.aTS)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (!i)
                    {
                        break;
                    }
                    i = xm._mth02CD(aTI).dequeueInputBuffer(1000L);
                    if (i == -1)
                    {
                        continue;
                    }
                    ByteBuffer bytebuffer = abytebuffer[i];
                    bytebuffer.clear();
                    if (((_cls02CA) (obj)).aTM > 0)
                    {
                        int j = Math.min(bytebuffer.capacity(), ((_cls02CA) (obj)).aTM);
                        bytebuffer.put(((_cls02CA) (obj)).aTL, 0, j);
                        bytebuffer.flip();
                    }
                    xm._mth02CD(aTI).queueInputBuffer(i, 0, bytebuffer.limit(), ((_cls02CA) (obj)).aTN / 1000L, 0);
                    break;
                } while (true);
                xm._mth02CB(aTI, ((_cls02CA) (obj)));
            }
            if (true) goto _L3; else goto _L2
_L2:
            xm._mth02CD(aTI).stop();
            return;
            bytebuffer;
              goto _L4
        }

        private if()
        {
            aTI = xm.this;
            super();
        }

        if(byte byte0)
        {
            this();
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}

    /* member class not found */
    class if {}

    /* member class not found */
    class _cls141D {}


    private Size aTA;
    private boolean aTB;
    private int aTC;
    private MediaFormat aTD;
    private int aTE;
    private long aTF;
    private long aTG;
    private Camera aTc;
    private android.hardware.Camera.CameraInfo aTd;
    private AudioRecord aTe;
    private MediaCodec aTf;
    private MediaCodec aTg;
    private xl.if aTh;
    private aav aTi;
    private aax aTj;
    private aar aTk;
    private aar aTl;
    private aba aTm;
    private aba aTn;
    private _cls02CE aTo;
    private _cls141D aTp;
    private _cls02CB aTq;
    private if aTr;
    private ArrayBlockingQueue aTs;
    private ArrayBlockingQueue aTt;
    private boolean aTu;
    private boolean aTv;
    private int aTw;
    private int aTx;
    private int aTy;
    private Size aTz;
    private Handler mHandler;
    private long FB3B;

    public xm()
    {
        aTd = new android.hardware.Camera.CameraInfo();
        aTs = new ArrayBlockingQueue(45);
        aTt = new ArrayBlockingQueue(45);
        aTw = 0x64000;
        aTx = 24;
        aTy = 0;
        aTz = Size.bvm;
        aTA = Size.bvm;
        aTB = true;
        mHandler = new Handler(Looper.getMainLooper());
        aTC = 32768;
        aTD = null;
        aTE = 0;
        aTF = 0L;
        aTG = 0L;
    }

    static Camera _mth02BB(xm xm1)
    {
        return xm1.aTc;
    }

    static android.hardware.Camera.CameraInfo _mth02BC(xm xm1)
    {
        return xm1.aTd;
    }

    static Size _mth02BD(xm xm1)
    {
        return xm1.aTA;
    }

    static ArrayBlockingQueue _mth02BE(xm xm1)
    {
        return xm1.aTs;
    }

    static long _mth02BF(xm xm1)
    {
        return xm1.aTF;
    }

    static long _mth02C8(xm xm1)
    {
        return xm1.aTG;
    }

    static long _mth02C9(xm xm1)
    {
        return xm1.FB3B;
    }

    static MediaFormat _mth02CA(xm xm1, MediaFormat mediaformat)
    {
        xm1.aTD = mediaformat;
        return mediaformat;
    }

    static aax _mth02CA(xm xm1, aax aax1)
    {
        xm1.aTj = aax1;
        return aax1;
    }

    static aba _mth02CA(xm xm1)
    {
        return xm1.aTm;
    }

    static aba _mth02CA(xm xm1, aaz aaz)
    {
        xm1.aTn = aaz;
        return aaz;
    }

    static aba _mth02CA(xm xm1, aba aba1)
    {
        xm1.aTm = aba1;
        return aba1;
    }

    static void _mth02CA(xm xm1, _cls02CA _pcls02ca)
    {
        try
        {
            xm1.aTt.put(_pcls02ca);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (xm xm1)
        {
            FF6A._mth02CE("cameraBroadcaster", "dropping audio samples");
        }
    }

    static boolean _mth02CA(xm xm1, boolean flag)
    {
        xm1.aTB = false;
        return false;
    }

    static aba _mth02CB(xm xm1)
    {
        return xm1.aTn;
    }

    static void _mth02CB(xm xm1, _cls02CA _pcls02ca)
    {
        try
        {
            xm1.aTs.put(_pcls02ca);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (xm xm1)
        {
            FF6A._mth02CE("cameraBroadcaster", "dropping audio samples");
        }
    }

    static boolean _mth02CC(xm xm1)
    {
        return xm1.aTv;
    }

    static MediaCodec _mth02CD(xm xm1)
    {
        return xm1.aTg;
    }

    static xl.if _mth02CE(xm xm1)
    {
        return xm1.aTh;
    }

    static void _mth02CF(xm xm1)
    {
        xm1.FB43();
    }

    static ArrayBlockingQueue _mth02D1(xm xm1)
    {
        return xm1.aTt;
    }

    static aav _mth037A(xm xm1)
    {
        return xm1.aTi;
    }

    static MediaCodec _mth0640(xm xm1)
    {
        return xm1.aTf;
    }

    static aax _mth141D(xm xm1)
    {
        return xm1.aTj;
    }

    static boolean _mth1427(xm xm1)
    {
        return xm1.aTB;
    }

    static void _mth1428(xm xm1)
    {
        int ai[] = new int[0x2c600];
        GLES20.glReadPixels(0, 0, 320, 568, 6408, 5121, IntBuffer.wrap(ai));
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN)
        {
            for (int i = ai.length - 1; i >= 0; i--)
            {
                int l = ai[i];
                ai[i] = 0xff00ff00 & l | l << 16 & 0xff0000 | l >> 16 & 0xff;
            }

        } else
        {
            for (int j = ai.length - 1; j >= 0; j--)
            {
                int i1 = ai[j];
                ai[j] = i1 >> 8 & 0xffffff | i1 << 24 & 0xff000000;
            }

        }
        int ai1[] = new int[0x2c600];
        for (int k = 0; k < 568; k++)
        {
            for (int j1 = 0; j1 < 320; j1++)
            {
                ai1[(568 - k - 1) * 320 + j1] = ai[k * 320 + j1];
            }

        }

        xm1.mHandler.post(new xo(xm1, ai1));
    }

    static AudioRecord _mth1FBE(xm xm1)
    {
        return xm1.aTe;
    }

    private void FB41()
    {
        int i = AudioRecord.getMinBufferSize(44100, 16, 2) * 12;
        aTe = new AudioRecord(1, 44100, 16, 2, i);
        aTF = i / 2;
        aTG = (aTF * 0x3b9aca00L) / 44100L;
    }

    private void FB43()
    {
        try
        {
            if (aTc != null)
            {
                aTc.stopPreview();
                aTc.release();
                aTc = null;
            }
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
        aTc = aoe._mth02CA(aTy, aTd);
    }

    private void FB56()
    {
        this;
        JVM INSTR monitorenter ;
        FF6A._mth02CB("RTMP", "resetCamera");
        if (aTl != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        aTl._mth02CA(new xp(this));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private MediaCodec FB74()
    {
        MediaFormat mediaformat = new MediaFormat();
        mediaformat.setString("mime", "audio/mp4a-latm");
        mediaformat.setInteger("aac-profile", 2);
        mediaformat.setInteger("sample-rate", 44100);
        mediaformat.setInteger("channel-count", 1);
        mediaformat.setInteger("bitrate", aTC);
        mediaformat.setInteger("max-input-size", 2048);
        MediaCodec mediacodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
        mediacodec.configure(mediaformat, null, null, 1);
        return mediacodec;
    }

    private MediaCodec FB78()
    {
        MediaCodec mediacodec = MediaCodec.createEncoderByType("video/avc");
        Object obj = MediaFormat.createVideoFormat("video/avc", 320, 568);
        ((MediaFormat) (obj)).setInteger("bitrate", aTw);
        ((MediaFormat) (obj)).setInteger("frame-rate", aTx);
        ((MediaFormat) (obj)).setInteger("i-frame-interval", 2);
        ((MediaFormat) (obj)).setInteger("color-format", 0x7f000789);
        boolean flag1 = true;
        String s = mediacodec.getName();
        FF6A._mth02CB("RTMP", (new StringBuilder("Encoder: ")).append(s).toString());
        int i = 0;
        boolean flag;
        do
        {
            flag = flag1;
            if (i >= 2)
            {
                break;
            }
            if (s.equals((new String[] {
    "OMX.Exynos.AVC.Encoder", "OMX.qcom.video.encoder.avc"
})[i]))
            {
                flag = false;
                break;
            }
            i++;
        } while (true);
        if (flag)
        {
            ((MediaFormat) (obj)).setInteger("profile", 2);
            ((MediaFormat) (obj)).setInteger("level", 64);
        } else
        {
            ((MediaFormat) (obj)).setInteger("profile", 8);
            ((MediaFormat) (obj)).setInteger("level", 64);
        }
        try
        {
            mediacodec.configure(((MediaFormat) (obj)), null, null, 1);
        }
        catch (Exception exception)
        {
            FF6A._mth02CB("RTMP", exception.getMessage());
            mediacodec.release();
            mediacodec = null;
        }
        exception = mediacodec;
        if (mediacodec == null)
        {
            FF6A._mth02CB("RTMP", "Configuring encoder for baseline profile");
            exception = MediaCodec.createEncoderByType("video/avc");
            MediaFormat mediaformat = MediaFormat.createVideoFormat("video/avc", 320, 568);
            mediaformat.setInteger("bitrate", aTw);
            mediaformat.setInteger("frame-rate", aTx);
            mediaformat.setInteger("i-frame-interval", 2);
            mediaformat.setInteger("color-format", 0x7f000789);
            exception.configure(mediaformat, null, null, 1);
        }
        return exception;
    }

    static aar FE73(xm xm1)
    {
        return xm1.aTl;
    }

    static MediaFormat FF9E(xm xm1)
    {
        return xm1.aTD;
    }

    public final int getMaxZoom()
    {
        if (aTc != null)
        {
            android.hardware.Camera.Parameters parameters = aTc.getParameters();
            if (parameters.isZoomSupported())
            {
                return parameters.getMaxZoom();
            }
        }
        return 0;
    }

    public final void onFrameAvailable(SurfaceTexture surfacetexture)
    {
        this;
        JVM INSTR monitorenter ;
        if (aTl != null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        aTl._mth02CA(new xq(this, surfacetexture));
        this;
        JVM INSTR monitorexit ;
        return;
        surfacetexture;
        throw surfacetexture;
    }

    public final void setZoom(int i)
    {
        this;
        JVM INSTR monitorenter ;
        android.hardware.Camera.Parameters parameters;
        if (aTc == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        parameters = aTc.getParameters();
        if (!parameters.isZoomSupported() || i < 0)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        if (i <= parameters.getMaxZoom())
        {
            FF6A._mth02CB("RTMP", (new StringBuilder("Zoom: ")).append(i).append(" (max: ").append(parameters.getMaxZoom()).append(")").toString());
            aTE = i;
            parameters.setZoom(i);
            aTc.setParameters(parameters);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void stopPreview()
    {
        this;
        JVM INSTR monitorenter ;
        FF6A._mth02CB("RTMP", "Camera stopPreview");
        if (aTc != null)
        {
            aTc.stopPreview();
            aTc.release();
            aTc = null;
        }
        if (aTk != null)
        {
            aTk.U();
            aTk = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth02CA(aed aed)
    {
        aTh = aed;
    }

    public final boolean _mth02CA(aav aav1)
    {
        this;
        JVM INSTR monitorenter ;
        FF6A._mth02CB("RTMP", "Camera startPreview");
        aTi = aav1;
        FB43();
        FB41();
        aTf = FB78();
        android.view.Surface surface = aTf.createInputSurface();
        aTg = FB74();
        FF6A._mth02CB("RTMP", "Encoders created");
        aTl = new aar();
        if (!aTl._mth02CA(null, surface))
        {
            aTl = null;
            throw new RuntimeException("Failed to create video encoder context");
        }
        aTl._mth02CA(new xn(this, aav1));
        aTj.bbE.setOnFrameAvailableListener(this);
        aTc.setPreviewTexture(aTj.bbE);
        aTk = new aar();
        if (!aTk._mth02CA(aTl, null))
        {
            throw new RuntimeException("Failed to create video render context");
        }
        aTi.setEGLContextFactory(new aar._cls02CA(aTk));
        aTi.setEGLConfigChooser(new aar.if());
        aTi.getHolder().setFormat(1);
        aTi.setRenderer(new aux());
        aTi.setRenderMode(0);
        FB89();
        this;
        JVM INSTR monitorexit ;
        return true;
        aav1;
        FF6A._mth02CB("RTMP", (new StringBuilder("Failed to start camera:")).append(aav1.toString()).toString());
        _cls0675._mth02CB(aav1);
        this;
        JVM INSTR monitorexit ;
        return false;
        aav1;
        throw aav1;
    }

    public final void _mth1D32(int i)
    {
        if (aTn != null)
        {
            aTn.setRotation(i);
            aTn._mth1D41(aTd.facing);
        }
    }

    public final void _mth1D3E(int i)
    {
        if (aTw != i)
        {
            aTw = i;
            if (aTf != null)
            {
                FB38();
            }
        }
    }

    public final void _mth1D41(int i)
    {
        if (aTy != i)
        {
            aTy = i;
            FB56();
        }
    }

    public final void _mth1D43(int i)
    {
        this;
        JVM INSTR monitorenter ;
        int j = aTC;
        if (i != j)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        aTC = i;
        FF6A._mth02CB("RTMP", (new StringBuilder("Audio bitrate change to ")).append(aTC / 1024).append(" kbits/s").toString());
        this;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        if (aTg != null)
        {
            StringBuilder stringbuilder = new StringBuilder("resetAudioEncoder ");
            String s;
            if (aTu)
            {
                s = "Encoding";
            } else
            {
                s = "Not encoding";
            }
            FF6A._mth02CB("RTMP", stringbuilder.append(s).toString());
            if (aTu)
            {
                if (aTo != null)
                {
                    Object obj = aTo;
                    obj.aTS = true;
                    IOException ioexception;
                    try
                    {
                        ((_cls02CF) (obj)).aTU.join();
                    }
                    catch (InterruptedException interruptedexception) { }
                    aTo = null;
                }
                if (aTr != null)
                {
                    obj = aTr;
                    obj.aTS = true;
                    try
                    {
                        ((_cls02CF) (obj)).aTU.join();
                    }
                    catch (InterruptedException interruptedexception1) { }
                    aTr = null;
                }
                if (aTq != null)
                {
                    obj = aTq;
                    obj.aTS = true;
                    try
                    {
                        ((_cls02CF) (obj)).aTU.join();
                    }
                    catch (InterruptedException interruptedexception2) { }
                    aTq = null;
                }
                if (aTg != null)
                {
                    aTg.stop();
                    aTg.release();
                    aTg = null;
                }
            }
            aTD = null;
            try
            {
                aTg = FB74();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                _cls0675._mth02CB(ioexception);
            }
            if (aTg != null && aTu)
            {
                FF6A._mth02CB("RTMP", (new StringBuilder("Audio bitrate change to ")).append(aTC / 1024).append(" kbits/s").toString());
                FB41();
                aTr = new if((byte)0);
                ioexception = aTr;
                ioexception.aTU = new Thread(new if(ioexception));
                ((_cls02CF) (ioexception)).aTU.start();
                aTr.FC5F();
                aTq = new _cls02CB((byte)0);
                ioexception = aTq;
                ioexception.aTU = new Thread(new if(ioexception));
                ((_cls02CF) (ioexception)).aTU.start();
                aTo = new _cls02CE((byte)0);
                ioexception = aTo;
                ioexception.aTU = new Thread(new if(ioexception));
                ((_cls02CF) (ioexception)).aTU.start();
            }
        }
        return;
    }

    public final void _mth30F6()
    {
        this;
        JVM INSTR monitorenter ;
        FF6A._mth02CB("RTMP", "Camera startEncoding");
        if (!aTu)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        FF6A._mth02CB("RTMP", "Camera is already encoding, no need to start it");
        this;
        JVM INSTR monitorexit ;
        return;
        aTu = true;
        FB3B = System.nanoTime();
        if (aTf != null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        FF6A._mth02CA("RTMP", "Video encoder null in startEncoding");
        this;
        JVM INSTR monitorexit ;
        return;
        aTr = new if((byte)0);
        Object obj = aTr;
        obj.aTU = new Thread(new if(((_cls02CF) (obj))));
        ((_cls02CF) (obj)).aTU.start();
        aTr.FC5F();
        aTq = new _cls02CB((byte)0);
        obj = aTq;
        obj.aTU = new Thread(new if(((_cls02CF) (obj))));
        ((_cls02CF) (obj)).aTU.start();
        aTp = new _cls141D((byte)0);
        obj = aTp;
        obj.aTU = new Thread(new if(((_cls02CF) (obj))));
        ((_cls02CF) (obj)).aTU.start();
        aTp.FC5F();
        aTo = new _cls02CE((byte)0);
        obj = aTo;
        obj.aTU = new Thread(new if(((_cls02CF) (obj))));
        ((_cls02CF) (obj)).aTU.start();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth4E2B()
    {
        this;
        JVM INSTR monitorenter ;
        aTv = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth4E41()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        FF6A._mth02CB("RTMP", "Camera stopBroadcast");
        aTu = false;
        aTv = false;
        if (aTo == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        obj = aTo;
        obj.aTS = true;
        Exception exception;
        try
        {
            ((_cls02CF) (obj)).aTU.join();
        }
        catch (InterruptedException interruptedexception) { }
        aTo = null;
        if (aTq == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        obj = aTq;
        obj.aTS = true;
        try
        {
            ((_cls02CF) (obj)).aTU.join();
        }
        catch (InterruptedException interruptedexception1) { }
        aTq = null;
        if (aTr == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        obj = aTr;
        obj.aTS = true;
        try
        {
            ((_cls02CF) (obj)).aTU.join();
        }
        catch (InterruptedException interruptedexception2) { }
        aTr = null;
        if (aTp == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        obj = aTp;
        obj.aTS = true;
        try
        {
            ((_cls02CF) (obj)).aTU.join();
        }
        catch (InterruptedException interruptedexception3) { }
        aTp = null;
        if (aTf != null)
        {
            aTf.stop();
            aTf.release();
            aTf = null;
        }
        if (aTm != null)
        {
            Object obj1 = aTm;
            if (((aba) (obj1)).bbN != null)
            {
                ((aba) (obj1)).bbN.U();
            }
            GLES20.glDeleteBuffers(1, new int[] {
                ((aba) (obj1)).bbK.baI
            }, 0);
            aas aas1 = ((aba) (obj1)).bbM;
            if (aas1.baG != -1)
            {
                GLES20.glDeleteProgram(aas1.baG);
            }
            aas1.baG = -1;
            obj1 = ((aba) (obj1)).bbL;
            if (((aas) (obj1)).baG != -1)
            {
                GLES20.glDeleteProgram(((aas) (obj1)).baG);
            }
            obj1.baG = -1;
            aTm = null;
        }
        if (aTl != null)
        {
            aTl.U();
            aTl = null;
        }
        aTD = null;
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        throw exception;
    }

    public final int _mth722B()
    {
        return aTw;
    }

    public final int FB24()
    {
        return aTy;
    }

    public final void FB38()
    {
        this;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder = new StringBuilder("resetVideoEncoder ");
        Object obj;
        if (aTu)
        {
            obj = "Encoding";
        } else
        {
            obj = "Not encoding";
        }
        FF6A._mth02CB("RTMP", stringbuilder.append(((String) (obj))).toString());
        if (!aTu)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        if (aTo == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        obj = aTo;
        obj.aTS = true;
        try
        {
            ((_cls02CF) (obj)).aTU.join();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        aTo = null;
        if (aTp == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj = aTp;
        obj.aTS = true;
        try
        {
            ((_cls02CF) (obj)).aTU.join();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        aTp = null;
        if (aTf != null)
        {
            aTf.stop();
            aTf.release();
            aTf = null;
        }
        try
        {
            aTf = FB78();
            obj = aTf.createInputSurface();
            aTl._mth02CA(((android.view.Surface) (obj)));
            break MISSING_BLOCK_LABEL_164;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        _cls0675._mth02CB(((Throwable) (obj)));
        if (aTf != null && aTu)
        {
            aTp = new _cls141D((byte)0);
            obj = aTp;
            obj.aTU = new Thread(new if(((_cls02CF) (obj))));
            ((_cls02CF) (obj)).aTU.start();
            aTp.FC5F();
            aTo = new _cls02CE((byte)0);
            obj = aTo;
            obj.aTU = new Thread(new if(((_cls02CF) (obj))));
            ((_cls02CF) (obj)).aTU.start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public final void FB89()
    {
        Object obj = ((WindowManager)aTi.getContext().getApplicationContext().getSystemService("window")).getDefaultDisplay();
        Object obj1 = new Point();
        ((Display) (obj)).getSize(((Point) (obj1)));
        aTz = Size._mth05D5(((Point) (obj1)).x, ((Point) (obj1)).y);
        aTc.stopPreview();
        obj1 = aTc.getParameters();
        ((android.hardware.Camera.Parameters) (obj1)).setRecordingHint(true);
        int ai[] = aoe._mth02CA(24000, ((android.hardware.Camera.Parameters) (obj1)).getSupportedPreviewFpsRange());
        if (ai != null)
        {
            ((android.hardware.Camera.Parameters) (obj1)).setPreviewFpsRange(ai[0], ai[1]);
        }
        aoe._mth02CA(aTc, ((android.hardware.Camera.Parameters) (obj1)));
        int i = aTd.orientation;
        ai = aTz;
        if (i == 90 || i == 270)
        {
            ai = Size._mth05D5(((Size) (ai))._fld0575, ((Size) (ai)).bac);
        }
        ai = aoe._mth02CA(ai, ((android.hardware.Camera.Parameters) (obj1)).getSupportedPreviewSizes());
        FF6A._mth02CB("RTMP", (new StringBuilder("Camera Resolution:")).append(ai).toString());
        ((android.hardware.Camera.Parameters) (obj1)).setPreviewSize(((Size) (ai)).bac, ((Size) (ai))._fld0575);
        aTA = ai;
        ((android.hardware.Camera.Parameters) (obj1)).setZoom(aTE);
        aTc.setParameters(((android.hardware.Camera.Parameters) (obj1)));
        aTc.startPreview();
    }
}
