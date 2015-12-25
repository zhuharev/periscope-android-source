// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.opengl.GLES20;
import java.util.Stack;

// Referenced classes of package o:
//            aau, aas, aay

public class aaw
{

    protected aas bbB;
    private int bbC;
    private Stack bbD;

    public aaw()
    {
        bbD = new Stack();
    }

    public final void ab()
    {
        GLES20.glUseProgram(0);
        GLES20.glBindBuffer(34962, 0);
        for (int i = 0; i < bbC; i++)
        {
            GLES20.glActiveTexture(33984 + i);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindTexture(36197, 0);
        }

    }

    final void ac()
    {
        bbD.pop();
        aau aau1 = (aau)bbD.peek();
        GLES20.glBindFramebuffer(36160, aau1.baK);
        GLES20.glViewport(0, 0, aau1.bac, aau1._fld0575);
        if (bbD.size() == 1)
        {
            bbD.pop();
        }
    }

    public final void _mth02CA(String s, aay aay1, int i, int j)
    {
        i = GLES20.glGetUniformLocation(bbB.baG, s);
        if (i != -1)
        {
            GLES20.glActiveTexture(bbC + 33984);
            j = aay1._mth02E3(9729, 33071);
            GLES20.glUniform1i(i, bbC);
            bbC = bbC + j;
        }
    }

    public final void _mth02CA(aas aas1)
    {
        bbB = aas1;
        bbC = 0;
        GLES20.glUseProgram(bbB.baG);
    }

    final void _mth02CA(aau aau1)
    {
        if (bbD.size() == 0)
        {
            int ai[] = new int[4];
            GLES20.glGetIntegerv(2978, ai, 0);
            int ai1[] = new int[1];
            GLES20.glGetIntegerv(36006, ai1, 0);
            bbD.push(new aau(ai[2], ai[3], ai1[0]));
        }
        bbD.push(aau1);
        GLES20.glBindFramebuffer(36160, aau1.baK);
        GLES20.glViewport(0, 0, aau1.bac, aau1._fld0575);
    }
}
