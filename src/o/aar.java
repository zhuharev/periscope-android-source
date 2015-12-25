// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;

public final class aar
{
    public static final class if
        implements aav._cls02CE
    {

        public final EGLConfig _mth02CA(EGLDisplay egldisplay)
        {
            EGLConfig aeglconfig[] = new EGLConfig[1];
            int ai[] = new int[1];
            EGL14.eglChooseConfig(egldisplay, new int[] {
                12324, 8, 12323, 8, 12322, 8, 12321, 0, 12352, 4, 
                12344
            }, 0, aeglconfig, 0, 1, ai, 0);
            return aeglconfig[0];
        }

        public if()
        {
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    public EGLSurface baA;
    public EGLDisplay baB;
    private EGLConfig baC;
    EGLContext baD;
    private Surface baE;

    public aar()
    {
        baE = null;
    }

    public final void U()
    {
        this;
        JVM INSTR monitorenter ;
        if (baB != null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        EGL14.eglMakeCurrent(baB, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(baB, baA);
        EGL14.eglDestroyContext(baB, baD);
        EGL14.eglTerminate(baB);
        baD = null;
        baA = null;
        baB = null;
        if (baE != null)
        {
            baE.release();
            baE = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth02CA(Surface surface)
    {
        this;
        JVM INSTR monitorenter ;
        EGL14.eglDestroySurface(baB, baA);
        baA = EGL14.eglCreateWindowSurface(baB, baC, surface, new int[] {
            12344
        }, 0);
        if (baE != null)
        {
            baE.release();
        }
        baE = surface;
        this;
        JVM INSTR monitorexit ;
        return;
        surface;
        throw surface;
    }

    public final boolean _mth02CA(_cls02CB _pcls02cb)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        boolean flag;
        flag = false;
        i = 0;
_L5:
        if (flag || i >= 10) goto _L2; else goto _L1
_L1:
        boolean flag2 = EGL14.eglMakeCurrent(baB, baA, baA, baD);
        boolean flag1;
        flag1 = flag2;
        flag = flag1;
        if (flag2) goto _L4; else goto _L3
_L3:
        EGL14.eglMakeCurrent(baB, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        try
        {
            Thread.sleep(10L);
        }
        catch (InterruptedException interruptedexception) { }
        i++;
        flag = flag1;
_L4:
        if (true) goto _L5; else goto _L2
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        _pcls02cb.FB8C();
        GLES20.glFinish();
        EGL14.eglMakeCurrent(baB, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        break MISSING_BLOCK_LABEL_126;
        _pcls02cb.FB90();
        this;
        JVM INSTR monitorexit ;
        return false;
        _pcls02cb;
        throw _pcls02cb;
    }

    public final boolean _mth02CA(aar aar1, Surface surface)
    {
        this;
        JVM INSTR monitorenter ;
        baB = EGL14.eglGetDisplay(0);
        if (baB != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
_L2:
        int ai[] = new int[2];
        int ai1[] = new int[2];
        if (EGL14.eglInitialize(baB, ai1, 0, ai, 0))
        {
            break MISSING_BLOCK_LABEL_61;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        aeglconfig = new EGLConfig[1];
        ai2 = new int[1];
        if (EGL14.eglChooseConfig(baB, new int[] {
    12324, 8, 12323, 8, 12322, 8, 12321, 0, 12339, 5, 
    12352, 4, i, c, 12344
}, 0, aeglconfig, 0, 1, ai2, 0))
        {
            break MISSING_BLOCK_LABEL_184;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        baC = aeglconfig[0];
        if (surface == null)
        {
            break MISSING_BLOCK_LABEL_333;
        }
        ai3 = new int[1];
        EGL14.eglGetConfigAttrib(baB, baC, 12610, ai3, 0);
        if (ai3[0] != 0)
        {
            break MISSING_BLOCK_LABEL_333;
        }
        if (EGL14.eglChooseConfig(baB, new int[] {
    12324, 8, 12323, 8, 12322, 8, 12321, 0, 12339, 5, 
    12352, 4, 12344
}, 0, aeglconfig, 0, 1, ai2, 0))
        {
            break MISSING_BLOCK_LABEL_326;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        baC = aeglconfig[0];
        if (aar1 == null)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        aar1 = aar1.baD;
        break MISSING_BLOCK_LABEL_349;
        aar1 = EGL14.EGL_NO_CONTEXT;
        aar1 = EGL14.eglCreateContext(baB, baC, aar1, new int[] {
            12440, 2, 12344
        }, 0);
        if (EGL14.eglGetError() == 12288)
        {
            break MISSING_BLOCK_LABEL_395;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        baD = aar1;
        if (surface == null)
        {
            break MISSING_BLOCK_LABEL_438;
        }
        baE = surface;
        baA = EGL14.eglCreateWindowSurface(baB, baC, surface, new int[] {
            12344
        }, 0);
        break MISSING_BLOCK_LABEL_483;
        baA = EGL14.eglCreatePbufferSurface(baB, baC, new int[] {
            12375, 4, 12374, 4, 12344
        }, 0);
        if (baA == EGL14.EGL_NO_SURFACE)
        {
            break MISSING_BLOCK_LABEL_510;
        }
        i = EGL14.eglGetError();
        if (i == 12288)
        {
            return true;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        aar1;
        throw aar1;
        EGLConfig aeglconfig[];
        int ai2[];
        int ai3[];
        int i;
        char c;
        if (surface != null)
        {
            i = 12610;
        } else
        {
            i = 12344;
        }
        if (surface != null)
        {
            c = '\001';
        } else
        {
            c = '\u3038';
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
