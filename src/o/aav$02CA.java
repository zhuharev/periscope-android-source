// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;

// Referenced classes of package o:
//            aav

class bbd extends bbd
{

    private aav baW;
    private int baX[];
    private int baY;
    private int baZ;
    private int bba;
    private int bbb;
    private int bbc;
    private int bbd;

    public final EGLConfig _mth02CA(EGLDisplay egldisplay, EGLConfig aeglconfig[])
    {
        int j1 = aeglconfig.length;
        for (int i = 0; i < j1; i++)
        {
            EGLConfig eglconfig = aeglconfig[i];
            int j;
            if (EGL14.eglGetConfigAttrib(egldisplay, eglconfig, 12325, baX, 0))
            {
                j = baX[0];
            } else
            {
                j = 0;
            }
            int k;
            if (EGL14.eglGetConfigAttrib(egldisplay, eglconfig, 12326, baX, 0))
            {
                k = baX[0];
            } else
            {
                k = 0;
            }
            if (j < bbc || k < bbd)
            {
                continue;
            }
            if (EGL14.eglGetConfigAttrib(egldisplay, eglconfig, 12324, baX, 0))
            {
                j = baX[0];
            } else
            {
                j = 0;
            }
            if (EGL14.eglGetConfigAttrib(egldisplay, eglconfig, 12323, baX, 0))
            {
                k = baX[0];
            } else
            {
                k = 0;
            }
            int l;
            if (EGL14.eglGetConfigAttrib(egldisplay, eglconfig, 12322, baX, 0))
            {
                l = baX[0];
            } else
            {
                l = 0;
            }
            int i1;
            if (EGL14.eglGetConfigAttrib(egldisplay, eglconfig, 12321, baX, 0))
            {
                i1 = baX[0];
            } else
            {
                i1 = 0;
            }
            if (j == baY && k == baZ && l == bba && i1 == bbb)
            {
                return eglconfig;
            }
        }

        return null;
    }

    public ig(aav aav1, int i, int j, int k, int l, int i1, int j1)
    {
        baW = aav1;
        super(aav1, new int[] {
            12324, i, 12323, j, 12322, k, 12321, l, 12325, i1, 
            12326, j1, 12344
        });
        baX = new int[1];
        baY = i;
        baZ = j;
        bba = k;
        bbb = l;
        bbc = i1;
        bbd = j1;
    }
}
