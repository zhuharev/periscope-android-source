// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import tv.periscope.android.util.Size;

// Referenced classes of package o:
//            aaw, aas

public final class aat extends aaw
{

    private static float baH[] = {
        0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F
    };
    public int baI;

    public aat()
    {
        float af[] = baH;
        FloatBuffer floatbuffer = ByteBuffer.allocateDirect(af.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatbuffer.put(af);
        floatbuffer.position(0);
        af = new int[1];
        GLES20.glGenBuffers(1, af, 0);
        GLES20.glBindBuffer(34962, af[0]);
        GLES20.glBufferData(34962, floatbuffer.capacity() << 2, floatbuffer, 35044);
        baI = af[0];
    }

    public final void _mth02CE(int i, int j, int k, int l, int i1)
    {
        GLES20.glBindBuffer(34962, baI);
        int j1 = GLES20.glGetAttribLocation(bbB.baG, "Position");
        GLES20.glEnableVertexAttribArray(j1);
        GLES20.glVertexAttribPointer(j1, 2, 5126, false, 8, 0);
        GLES20.glDisable(2884);
        GLES20.glDisable(2929);
        GLES20.glDisable(3042);
        GLES20.glDepthFunc(519);
        int ai[] = new int[4];
        GLES20.glGetIntegerv(2978, ai, 0);
        Size size = Size._mth05D5(ai[2], ai[3]);
        GLES20.glUniform4f(GLES20.glGetUniformLocation(bbB.baG, "OffsetScale"), (float)i / (float)size.bac, j / size._fld0575, (float)k / (float)size.bac, (float)l / (float)size._fld0575);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(bbB.baG, "Rotation"), i1);
        GLES20.glDrawArrays(5, 0, 4);
    }

}
