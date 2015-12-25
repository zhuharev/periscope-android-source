// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            LinearLayoutManager

static final class cn
{

    boolean ce;
    int cf;
    int cg;
    int ch;
    int ci;
    int cj;
    int ck;
    boolean cl;
    int cm;
    List cn;
    int _fld1D4A;

    private View _mth0630()
    {
        int j = cn.size();
        for (int i = 0; i < j; i++)
        {
            cn cn1 = (cn)cn.get(i);
            boolean flag;
            if ((cn1.cn & 8) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && cg == cn1.utPosition())
            {
                cn cn2 = _mth02CF(cn1);
                if (cn2 == null)
                {
                    i = -1;
                } else
                {
                    i = cn2.utPosition();
                }
                cg = i;
                return cn1.cg;
            }
        }

        return null;
    }

    final View _mth02CA(cg cg1)
    {
        if (cn != null)
        {
            return _mth0630();
        } else
        {
            cg1 = cg1._mth0630(cg, false);
            cg = cg + ch;
            return cg1;
        }
    }

    public final ch _mth02CF(ch ch1)
    {
        int i1 = cn.size();
        ch ch2 = null;
        int j = 0x7fffffff;
        int i = 0;
        ch ch3;
        do
        {
            ch3 = ch2;
            if (i >= i1)
            {
                break;
            }
            ch ch4 = (cn)cn.get(i);
            ch3 = ch2;
            int k = j;
            if (ch4 != ch1)
            {
                boolean flag;
                if ((ch4.cn & 8) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ch3 = ch2;
                k = j;
                if (!flag)
                {
                    int l = (ch4.utPosition() - cg) * ch;
                    ch3 = ch2;
                    k = j;
                    if (l >= 0)
                    {
                        ch3 = ch2;
                        k = j;
                        if (l < j)
                        {
                            ch2 = ch4;
                            k = l;
                            ch3 = ch2;
                            if (l == 0)
                            {
                                break;
                            }
                            ch3 = ch2;
                        }
                    }
                }
            }
            i++;
            ch2 = ch3;
            j = k;
        } while (true);
        return ch3;
    }

    ()
    {
        ce = true;
        ck = 0;
        cl = false;
        cn = null;
    }
}
