// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import java.util.ArrayList;
import o.02E0;
import o.03F3;
import o.0491;
import o.0621;
import o.706C;

// Referenced classes of package android.support.v7.widget:
//            Toolbar

public class <init>
    implements _cls0491
{

    private Toolbar iF;
    public _cls03F3 iG;
    private _cls02E0 FB30;

    public static int _mth02B2(int i)
    {
        if (i >= 200 && i <= 299)
        {
            return 0;
        }
        if (i >= 300 && i <= 399)
        {
            return 1;
        }
        if (i >= 400 && i <= 499)
        {
            return 0;
        }
        return i < 500 ? 1 : 1;
    }

    public final void _mth02CA(Context context, _cls02E0 _pcls02e0)
    {
        if (FB30 != null && iG != null)
        {
            FB30._mth02BB(iG);
        }
        FB30 = _pcls02e0;
    }

    public final boolean _mth02CA(_cls0621 _pcls0621)
    {
        return false;
    }

    public final void _mth02CB(_cls02E0 _pcls02e0, boolean flag)
    {
    }

    public final boolean _mth02CB(_cls03F3 _pcls03f3)
    {
        Toolbar._mth02CB(iF);
        if (Toolbar._mth02CE(iF).getParent() != iF)
        {
            iF.addView(Toolbar._mth02CE(iF));
        }
        iF._fldif = _pcls03f3.getActionView();
        iG = _pcls03f3;
        if (iF._fldif.getParent() != iF)
        {
            A a = Toolbar.FEF4();
            a.gravity = Toolbar._mth02CF(iF) & 0x70 | 0x800003;
            a.iH = 2;
            iF._fldif.setLayoutParams(a);
            iF.addView(iF._fldif);
        }
        Toolbar toolbar = iF;
        for (int i = toolbar.getChildCount() - 1; i >= 0; i--)
        {
            View view = toolbar.getChildAt(i);
            if (((A)view.getLayoutParams()).iH != 2 && view != toolbar._fld039B)
            {
                toolbar.removeViewAt(i);
                toolbar.iw.add(view);
            }
        }

        iF.requestLayout();
        _pcls03f3.FECC = true;
        _pcls03f3.FB30.FF9E(false);
        if (iF._fldif instanceof _cls706C)
        {
            ((_cls706C)iF._fldif).onActionViewExpanded();
        }
        return true;
    }

    public final boolean _mth02CE(_cls03F3 _pcls03f3)
    {
        if (iF._fldif instanceof _cls706C)
        {
            ((_cls706C)iF._fldif).onActionViewCollapsed();
        }
        iF.removeView(iF._fldif);
        iF.removeView(Toolbar._mth02CE(iF));
        iF._fldif = null;
        iF._mth012B();
        iG = null;
        iF.requestLayout();
        _pcls03f3.FECC = false;
        _pcls03f3.FB30.FF9E(false);
        return true;
    }

    public final boolean _mth05F2()
    {
        return false;
    }

    public final void _mth1427(boolean flag)
    {
        if (iG != null)
        {
            boolean flag2 = false;
            boolean flag1 = flag2;
            if (FB30 != null)
            {
                int j = FB30.size();
                int i = 0;
                do
                {
                    flag1 = flag2;
                    if (i >= j)
                    {
                        break;
                    }
                    if (FB30.getItem(i) == iG)
                    {
                        flag1 = true;
                        break;
                    }
                    i++;
                } while (true);
            }
            if (!flag1)
            {
                _mth02CE(iG);
            }
        }
    }

    public A()
    {
    }

    private A(Toolbar toolbar)
    {
        iF = toolbar;
        super();
    }

    iF(Toolbar toolbar, byte byte0)
    {
        this(toolbar);
    }
}
