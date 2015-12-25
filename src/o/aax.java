// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import tv.periscope.android.util.Size;

// Referenced classes of package o:
//            aay

public final class aax extends aay
{

    public SurfaceTexture bbE;
    private volatile boolean bbF;
    private int bbG;

    public aax()
    {
        super(null);
        bbE = new SurfaceTexture(bbH);
    }

    public final void U()
    {
        super.U();
        bbE.releaseTexImage();
        bbE.release();
        SurfaceTexture surfacetexture = bbE;
        surfacetexture;
        JVM INSTR monitorenter ;
        bbE.notifyAll();
        surfacetexture;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final int ad()
    {
        SurfaceTexture surfacetexture = bbE;
        surfacetexture;
        JVM INSTR monitorenter ;
        int i = bbG;
        surfacetexture;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean ae()
    {
        SurfaceTexture surfacetexture = bbE;
        surfacetexture;
        JVM INSTR monitorenter ;
        if (!bbF)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        bbF = false;
        surfacetexture;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        try
        {
            bbE.wait(100L);
        }
        catch (InterruptedException interruptedexception) { }
        if (!bbF)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        bbF = false;
        return true;
        surfacetexture;
        JVM INSTR monitorexit ;
          goto _L1
        exception;
        throw exception;
_L1:
        return false;
    }

    public final void _mth02CA(Size size, int i)
    {
        SurfaceTexture surfacetexture = bbE;
        surfacetexture;
        JVM INSTR monitorenter ;
        bbE.updateTexImage();
        bbI = size;
        bbG = i;
        bbF = true;
        bbE.notifyAll();
        surfacetexture;
        JVM INSTR monitorexit ;
        return;
        size;
        throw size;
    }

    public final int _mth02E3(int i, int j)
    {
        GLES20.glBindTexture(36197, bbH);
        GLES20.glTexParameteri(36197, 10241, i);
        GLES20.glTexParameteri(36197, 10240, i);
        GLES20.glTexParameteri(36197, 10242, j);
        GLES20.glTexParameteri(36197, 10243, j);
        return 3;
    }
}
