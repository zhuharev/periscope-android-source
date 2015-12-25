// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.GLES20;

// Referenced classes of package o:
//            xm, aax, aba, aar, 
//            _cls0675

final class xs
    implements aar._cls02CB
{

    private xm._cls141D aTX;

    xs(xm._cls141D _pcls141d)
    {
        aTX = _pcls141d;
        super();
    }

    public final void FB8C()
    {
        if (xm._mth141D(aTX.aTI).bbE.getTimestamp() >= xm._mth02C9(aTX.aTI))
        {
            if (xm._mth02CC(aTX.aTI))
            {
                xm._mth02CA(aTX.aTI)._mth02CA(xm._mth141D(aTX.aTI));
                if (xm._mth1427(aTX.aTI))
                {
                    xm._mth1428(aTX.aTI);
                    xm._mth02CA(aTX.aTI, false);
                }
            } else
            {
                GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
                GLES20.glClear(16384);
            }
            aar aar1 = xm.FE73(aTX.aTI);
            long l = xm._mth141D(aTX.aTI).bbE.getTimestamp();
            long l1 = xm._mth02C9(aTX.aTI);
            EGLExt.eglPresentationTimeANDROID(aar1.baB, aar1.baA, l - l1);
            aar1 = xm.FE73(aTX.aTI);
            EGL14.eglSwapBuffers(aar1.baB, aar1.baA);
        }
    }

    public final void FB90()
    {
        _cls0675._mth02CB(new RuntimeException("Dropped frame, failed to acquire video context."));
    }
}
