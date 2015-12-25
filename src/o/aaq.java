// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.opengl.GLES20;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.periscope.android.util.Size;

// Referenced classes of package o:
//            aau, aay, aat, aax, 
//            aas

public final class aaq
{

    Size aTz;
    ArrayList bas;
    int bat;
    int bau;
    Size bav;
    Size baw;
    int bax;
    boolean bay;
    public String baz;

    public aaq()
    {
        bas = new ArrayList();
        baz = "";
    }

    public final void U()
    {
        aau aau1;
        for (Iterator iterator = bas.iterator(); iterator.hasNext(); GLES20.glDeleteFramebuffers(1, new int[] {
    aau1.baK
}, 0))
        {
            aau1 = (aau)iterator.next();
            aau1.baJ.U();
        }

        bas.clear();
    }

    public final aau _mth02CA(aas aas1, aas aas2, aat aat1, aax aax1)
    {
        Object obj = null;
        for (Iterator iterator = bas.iterator(); iterator.hasNext(); aat1.ac())
        {
            aau aau1 = (aau)iterator.next();
            aat1._mth02CA(aau1);
            if (aax1 instanceof aax)
            {
                obj = aas2;
            } else
            {
                obj = aas1;
            }
            aat1._mth02CA(((aas) (obj)));
            GLES20.glUniform1f(GLES20.glGetUniformLocation(((aas) (obj)).baG, "Random"), (float)Math.random());
            aat1._mth02CA("Texture0", aax1, 9729, 33071);
            aax1 = new int[4];
            GLES20.glGetIntegerv(2978, aax1, 0);
            aax1 = Size._mth05D5(aax1[2], aax1[3]);
            aat1._mth02CE(0, 0, ((Size) (aax1)).bac, ((Size) (aax1))._fld0575, 0);
            aax1 = aau1.baJ;
            obj = aau1;
            aat1.ab();
        }

        float f;
        if (bay)
        {
            f = 1.0F;
        } else
        {
            f = 0.0F;
        }
        if ((bas.size() & 1) != 0)
        {
            if (bay)
            {
                f = 0.0F;
            } else
            {
                f = 1.0F;
            }
        }
        if (aax1 instanceof aax)
        {
            aas1 = aas2;
        }
        aat1._mth02CA(aas1);
        aat1._mth02CA("Texture0", aax1, 9729, 33071);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(aas1.baG, "Mirror"), f);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(aas1.baG, "Random"), (float)Math.random());
        aat1._mth02CE(bat, bau, aTz.bac, aTz._fld0575, bax);
        aat1.ab();
        return ((aau) (obj));
    }
}
