// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.opengl.GLES20;
import tv.periscope.android.util.Size;

public class aay
{

    protected int bbH;
    protected Size bbI;

    public aay(Size size)
    {
        bbI = size;
        size = new int[1];
        GLES20.glGenTextures(1, size, 0);
        bbH = size[0];
    }

    void U()
    {
        GLES20.glDeleteTextures(1, new int[] {
            bbH
        }, 0);
    }

    public final Size af()
    {
        return bbI;
    }

    public final int ag()
    {
        return bbH;
    }

    public int _mth02E3(int i, int j)
    {
        GLES20.glBindTexture(3553, bbH);
        GLES20.glTexParameteri(3553, 10241, i);
        GLES20.glTexParameteri(3553, 10240, i);
        GLES20.glTexParameteri(3553, 10242, j);
        GLES20.glTexParameteri(3553, 10243, j);
        return 1;
    }
}
