// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.opengl.GLES20;
import tv.periscope.android.util.Size;

// Referenced classes of package o:
//            aay

public final class aau
{

    aay baJ;
    int baK;
    int bac;
    int _fld0575;

    public aau(int i, int j, int k)
    {
        bac = i;
        _fld0575 = j;
        baK = k;
    }

    public aau(int i, int j, int k, int l)
    {
        bac = i;
        _fld0575 = j;
        int ai[] = new int[1];
        GLES20.glGenFramebuffers(1, ai, 0);
        baK = ai[0];
        ai = new int[1];
        GLES20.glGetIntegerv(36006, ai, 0);
        GLES20.glBindFramebuffer(36160, baK);
        baJ = new aay(Size._mth05D5(i, j));
        GLES20.glBindTexture(3553, baJ.ag());
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6407, i, j, 0, 6407, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, baJ.ag(), 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, ai[0]);
    }
}
