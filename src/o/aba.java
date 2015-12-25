// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.opengl.GLES20;
import java.util.List;
import tv.periscope.android.util.Size;

// Referenced classes of package o:
//            aat, aas, aaq, aax, 
//            FF6A, aau

public class aba
{

    protected int LN;
    public boolean bay;
    protected int bbJ;
    public aat bbK;
    public aas bbL;
    public aas bbM;
    public aaq bbN;

    public aba(Context context)
    {
        LN = -1;
        bbJ = -1;
        bbK = new aat();
        bbM = new aas(context, 0x7f050004, 0x7f050002);
        bbL = new aas(context, 0x7f050004, 0x7f050003);
        bbN = new aaq();
    }

    public final void setRotation(int i)
    {
        LN = i;
    }

    public final void _mth02CA(aax aax1)
    {
        Size size2 = aax1.af();
        if (size2 == null)
        {
            return;
        }
        int k = _mth30FC(aax1.ad());
        int ai[] = new int[4];
        GLES20.glGetIntegerv(2978, ai, 0);
        Size size3 = Size._mth05D5(ai[2], ai[3]);
        aaq aaq1 = bbN;
        aaq1.bay = bay;
        if (!size2._mth02CA(aaq1.bav) || !size3._mth02CA(aaq1.baw) || k != aaq1.bax)
        {
            aaq1.U();
            boolean flag;
            if (size3.bac * size3._fld0575 <= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            float f;
            if (flag)
            {
                f = 0.0F;
            } else
            {
                f = (float)size3.bac / (float)size3._fld0575;
            }
            Size size;
            if (k == 90 || k == 270)
            {
                size = Size._mth05D5(size2._fld0575, size2.bac);
            } else
            {
                size = size2;
            }
            if (size.bac * size._fld0575 <= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            float f1;
            if (flag)
            {
                f1 = 0.0F;
            } else
            {
                f1 = (float)size.bac / (float)size._fld0575;
            }
            aaq1.bau = 0;
            aaq1.bat = 0;
            if (f < f1)
            {
                size = Size._mth02BE((float)size3._fld0575 * f1, size3._fld0575);
                aaq1.bat = (size3.bac - size.bac) / 2;
            } else
            {
                size = Size._mth02BE(size3.bac, (float)size3.bac / f1);
                aaq1.bau = (size3._fld0575 - size._fld0575) / 2;
            }
            FF6A._mth02CB("RTMP", (new StringBuilder()).append(aaq1.baz).append(" Dest ").append(size3).append(" Source ").append(size2).append(" Rot: ").append(k).append(" Crop: ").append(aaq1.bat).append("x").append(aaq1.bau).toString());
            int j = size2.bac;
            int i = size2._fld0575;
            Size size1;
            if (k == 90 || k == 270)
            {
                size1 = Size._mth05D5(size._fld0575, size.bac);
            } else
            {
                size1 = size;
            }
            int l = size1.bac;
            if (k == 90 || k == 270)
            {
                size1 = Size._mth05D5(size._fld0575, size.bac);
            } else
            {
                size1 = size;
            }
            int i1 = size1._fld0575;
            aaq1.aTz = size;
            aaq1.bax = k;
            aaq1.baw = size3;
            aaq1.bav = size2;
            while (j / 2 > l && i / 2 > i1) 
            {
                j /= 2;
                i /= 2;
                aaq1.bas.add(new aau(j, i, 6407, 5121));
            }
        }
        bbN._mth02CA(bbM, bbL, bbK, aax1);
    }

    public final void _mth1D41(int i)
    {
        bbJ = i;
    }

    protected int _mth30FC(int i)
    {
        return i;
    }
}
