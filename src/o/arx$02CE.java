// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            arx, _cls0142, _cls05E3

public final class <init> extends <init>
{

    private arx bCl;

    public final void _mth02BE(View view, float f)
    {
        boolean flag1;
        if (view == arx._mth02BB(bCl))
        {
            boolean flag;
            if (f > 0.0F || f == 0.0F && view.getTop() > (int)bCl.bBX)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            int j;
            if (flag)
            {
                j = (int)bCl.bBW;
            } else
            {
                j = 0;
            }
            arx._mth02CB(bCl)._mth02BC(view.getLeft(), j);
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        } else
        {
            int i = bCl.getHeight();
            if (f > 0.0F || f == 0.0F && view.getTop() > i / 2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            boolean flag2 = flag1;
            if (!flag1)
            {
                i -= view.getHeight();
            }
            arx._mth02CB(bCl)._mth02BC(view.getLeft(), i);
            flag1 = flag2;
        }
        bCl.invalidate();
        if (flag1)
        {
            if (arx._mth02BC(bCl) != null)
            {
                arx._mth02BC(bCl)._mth0209();
            }
        } else
        if (arx._mth02BC(bCl) != null)
        {
            arx._mth02BC(bCl)._mth0155();
        }
        arx._mth02CA(bCl, view, flag1);
    }

    public final void _mth02CB(View view, int i, int j, int k, int l)
    {
        float f = 0.0F;
        switch (view.getId())
        {
        case 2131558549: 
            f = (float)j / bCl.bBW;
            break;

        default:
            if (arx._mth02CA(bCl, view))
            {
                i = bCl.getHeight();
                k = view.getHeight();
                f = (float)(i - j) / (float)k;
            }
            break;
        }
        if (arx._mth02CA(bCl) != null)
        {
            arx._mth02CA(bCl)._mth02BF(view, f);
        }
        ((w.View)view.getLayoutParams()).bCm = f;
        bCl.invalidate();
    }

    public final int _mth02CF(View view, int i, int j)
    {
        switch (view.getId())
        {
        case 2131558549: 
            if ((float)i > bCl.bBW)
            {
                return (int)bCl.bBW;
            }
            if (i < 0)
            {
                return 0;
            } else
            {
                return view.getTop() + (int)((float)j * arx._mth02CE(bCl));
            }
        }
        if (arx._mth02CA(bCl, view))
        {
            j = bCl.getHeight();
            return Math.max(j - view.getHeight(), Math.min(i, j));
        } else
        {
            return 0;
        }
    }

    public final int _mth06E5(View view)
    {
        switch (view.getId())
        {
        case 2131558549: 
            return (int)bCl.bBW;
        }
        if (arx._mth02CA(bCl, view))
        {
            return view.getHeight();
        } else
        {
            return 0;
        }
    }

    public final boolean _mth1420(View view)
    {
        if (arx._mth02CA(bCl, view))
        {
            return !arx._mth02CB(bCl, view) && !view.canScrollVertically((int)(arx._mth02CF(bCl) - arx._mth141D(bCl)));
        }
        return !arx._mth02CB(bCl, view) && view == arx._mth02BB(bCl);
    }

    public final void FE76(int i)
    {
        if (arx._mth02CA(bCl) != null)
        {
            arx._mth02CA(bCl)._mth037A(arx._mth02CB(bCl)._fld0211, i);
        }
    }

    public final int FE7A(int i)
    {
        for (int j = i; j >= 0; j--)
        {
            if (bCl.getChildAt(j).getVisibility() != 8)
            {
                return j;
            }
        }

        return i;
    }

    private w.View(arx arx1)
    {
        bCl = arx1;
        super();
    }

    init>(arx arx1, byte byte0)
    {
        this(arx1);
    }
}
