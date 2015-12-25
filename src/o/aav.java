// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.lang.ref.WeakReference;

// Referenced classes of package o:
//            FF6A

public class aav extends SurfaceView
    implements android.view.SurfaceHolder.Callback
{
    public static class aux
    {

        public EGLSurface _mth02CA(EGLDisplay egldisplay, EGLConfig eglconfig, SurfaceHolder surfaceholder)
        {
            try
            {
                egldisplay = EGL14.eglCreateWindowSurface(egldisplay, eglconfig, surfaceholder, new int[] {
                    12344
                }, 0);
            }
            // Misplaced declaration of an exception variable
            catch (EGLDisplay egldisplay)
            {
                FF6A._mth02CA("GLRenderView", "eglCreateWindowSurface", egldisplay);
                return null;
            }
            return egldisplay;
        }

        public void _mth02CA(EGLDisplay egldisplay, EGLSurface eglsurface)
        {
            EGL14.eglDestroySurface(egldisplay, eglsurface);
        }

        aux()
        {
        }

        aux(byte byte0)
        {
            this();
        }
    }

    abstract class if
        implements _cls02CE
    {

        private int baV[];
        private aav baW;

        public final EGLConfig _mth02CA(EGLDisplay egldisplay)
        {
            int ai[] = new int[1];
            if (!EGL14.eglChooseConfig(egldisplay, baV, 0, null, 0, 0, ai, 0))
            {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = ai[0];
            if (i <= 0)
            {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig aeglconfig[] = new EGLConfig[i];
            if (!EGL14.eglChooseConfig(egldisplay, baV, 0, aeglconfig, 0, i, ai, 0))
            {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            egldisplay = _mth02CA(egldisplay, aeglconfig);
            if (egldisplay == null)
            {
                throw new IllegalArgumentException("No config chosen");
            } else
            {
                return egldisplay;
            }
        }

        abstract EGLConfig _mth02CA(EGLDisplay egldisplay, EGLConfig aeglconfig[]);

        public if(int ai[])
        {
            baW = aav.this;
            super();
            if (aav._mth02CB(baW) != 2 && aav._mth02CB(baW) != 3)
            {
                aav1 = ai;
            } else
            {
                int i = ai.length;
                aav1 = new int[i + 2];
                System.arraycopy(ai, 0, aav.this, 0, i - 1);
                aav.this[i - 1] = 12352;
                if (aav._mth02CB(baW) == 2)
                {
                    aav.this[i] = 4;
                } else
                {
                    aav.this[i] = 64;
                }
                aav.this[i + 1] = 12344;
            }
            baV = aav.this;
        }
    }

    /* member class not found */
    class _cls02BB {}

    /* member class not found */
    class _cls02BC {}

    /* member class not found */
    class _cls02BD {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}

    /* member class not found */
    class _cls037A {}

    /* member class not found */
    class _cls141D {}


    private static final _cls02BC baL = new _cls02BC((byte)0);
    private final WeakReference baM;
    public _cls02BB baN;
    private _cls02BD baO;
    private _cls02CE baP;
    private _cls02CF baQ;
    private aux baR;
    private int baS;
    private int baT;
    private boolean baU;
    private boolean mDetached;

    public aav(Context context)
    {
        super(context);
        baM = new WeakReference(this);
        getHolder().addCallback(this);
    }

    public aav(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        baM = new WeakReference(this);
        getHolder().addCallback(this);
    }

    public static _cls02BC V()
    {
        return baL;
    }

    static _cls02BD _mth02BB(aav aav1)
    {
        return aav1.baO;
    }

    static int _mth02CB(aav aav1)
    {
        return aav1.baT;
    }

    static _cls02CE _mth02CE(aav aav1)
    {
        return aav1.baP;
    }

    static _cls02CF _mth02CF(aav aav1)
    {
        return aav1.baQ;
    }

    static aux _mth141D(aav aav1)
    {
        return aav1.baR;
    }

    protected void finalize()
    {
        if (baN != null)
        {
            baN.aa();
        }
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (mDetached && baO != null)
        {
            int i = 1;
            if (baN != null)
            {
                i = baN.getRenderMode();
            }
            baN = new _cls02BB(baM);
            if (i != 1)
            {
                baN.setRenderMode(i);
            }
            baN.start();
        }
        mDetached = false;
    }

    protected void onDetachedFromWindow()
    {
        if (baN != null)
        {
            baN.aa();
        }
        mDetached = true;
        super.onDetachedFromWindow();
    }

    public void setDebugFlags(int i)
    {
        baS = i;
    }

    public void setEGLConfigChooser(int i, int j, int k, int l, int i1, int j1)
    {
        setEGLConfigChooser(((_cls02CE) (new _cls02CA(i, j, k, l, i1, j1))));
    }

    public void setEGLConfigChooser(_cls02CE _pcls02ce)
    {
        if (baN != null)
        {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        } else
        {
            baP = _pcls02ce;
            return;
        }
    }

    public void setEGLConfigChooser(boolean flag)
    {
        setEGLConfigChooser(((_cls02CE) (new _cls037A(flag))));
    }

    public void setEGLContextClientVersion(int i)
    {
        if (baN != null)
        {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        } else
        {
            baT = i;
            return;
        }
    }

    public void setEGLContextFactory(_cls02CF _pcls02cf)
    {
        if (baN != null)
        {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        } else
        {
            baQ = _pcls02cf;
            return;
        }
    }

    public void setEGLWindowSurfaceFactory(aux aux1)
    {
        if (baN != null)
        {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        } else
        {
            baR = aux1;
            return;
        }
    }

    public void setPreserveEGLContextOnPause(boolean flag)
    {
        baU = flag;
    }

    public void setRenderMode(int i)
    {
        baN.setRenderMode(i);
    }

    public void setRenderer(_cls02BD _pcls02bd)
    {
        if (baN != null)
        {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
        if (baP == null)
        {
            baP = new _cls037A(true);
        }
        if (baQ == null)
        {
            baQ = new _cls02CB((byte)0);
        }
        if (baR == null)
        {
            baR = new aux((byte)0);
        }
        baO = _pcls02bd;
        baN = new _cls02BB(baM);
        baN.start();
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        if (baN == null) goto _L2; else goto _L1
_L1:
        _cls02BB _lcls02bb = baN;
        surfaceholder = baL;
        surfaceholder;
        JVM INSTR monitorenter ;
        _lcls02bb.bac = j;
        _lcls02bb._fld0575 = k;
        _lcls02bb.bbw = true;
        _lcls02bb.bbt = true;
        _lcls02bb.bbu = false;
        baL.notifyAll();
_L10:
        if (_lcls02bb.bbk || _lcls02bb.aVj || _lcls02bb.bbu) goto _L4; else goto _L3
_L3:
        if (!_lcls02bb.bbo || !_lcls02bb.bbp) goto _L6; else goto _L5
_L5:
        boolean flag = _lcls02bb.Z();
        if (!flag) goto _L6; else goto _L7
_L7:
        i = 1;
          goto _L8
_L6:
        i = 0;
_L8:
        if (i == 0) goto _L4; else goto _L9
_L9:
        baL.wait();
          goto _L10
_L11:
        Thread.currentThread().interrupt();
          goto _L10
_L4:
        surfaceholder;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
_L2:
        return;
        InterruptedException interruptedexception;
        interruptedexception;
          goto _L11
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        if (baN == null) goto _L2; else goto _L1
_L1:
        _cls02BB _lcls02bb = baN;
        surfaceholder = baL;
        surfaceholder;
        JVM INSTR monitorenter ;
        _lcls02bb.bbl = true;
        _lcls02bb.bbq = false;
        baL.notifyAll();
_L6:
        if (!_lcls02bb.bbn || _lcls02bb.bbq) goto _L4; else goto _L3
_L3:
        boolean flag = _lcls02bb.bbk;
        if (flag) goto _L4; else goto _L5
_L5:
        baL.wait();
          goto _L6
_L7:
        Thread.currentThread().interrupt();
          goto _L6
_L4:
        surfaceholder;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
_L2:
        return;
        InterruptedException interruptedexception;
        interruptedexception;
          goto _L7
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        if (baN == null) goto _L2; else goto _L1
_L1:
        _cls02BB _lcls02bb = baN;
        surfaceholder = baL;
        surfaceholder;
        JVM INSTR monitorenter ;
        _lcls02bb.bbl = false;
        baL.notifyAll();
_L6:
        if (_lcls02bb.bbn) goto _L4; else goto _L3
_L3:
        boolean flag = _lcls02bb.bbk;
        if (flag) goto _L4; else goto _L5
_L5:
        baL.wait();
          goto _L6
_L7:
        Thread.currentThread().interrupt();
          goto _L6
_L4:
        surfaceholder;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
_L2:
        return;
        InterruptedException interruptedexception;
        interruptedexception;
          goto _L7
    }

}
