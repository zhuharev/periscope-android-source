// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

// Referenced classes of package o:
//            _cls1601, FEE3, _cls026A

final class FF2C extends _cls1601
{

    private FEE3 fJ;

    FF2C(FEE3 fee3)
    {
        fJ = fee3;
        super();
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        if (super.performAccessibilityAction(view, i, bundle))
        {
            return true;
        }
        if (!fJ.FB48() && fJ.eH.dG != null)
        {
            view = fJ.eH.dG;
            return false;
        } else
        {
            return false;
        }
    }

    public final void _mth02CA(View view, _cls026A _pcls026a)
    {
        super._mth02CA(view, _pcls026a);
        if (!fJ.FB48() && fJ.eH.dG != null)
        {
            android.support.v7.widget.RecyclerView._cls02BB _lcls02bb = fJ.eH.dG;
            android.support.v7.widget.RecyclerView._cls02CC _lcls02cc = RecyclerView._mth1508(view);
            if (_lcls02cc != null)
            {
                boolean flag;
                if ((_lcls02cc._fld0E20 & 8) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    int i;
                    if (_lcls02bb._mth027E())
                    {
                        i = android.support.v7.widget.RecyclerView._cls02BB._mth1D38(view);
                    } else
                    {
                        i = 0;
                    }
                    int j;
                    if (_lcls02bb._mth026A())
                    {
                        j = android.support.v7.widget.RecyclerView._cls02BB._mth1D38(view);
                    } else
                    {
                        j = 0;
                    }
                    _pcls026a._mth02BC(_cls026A._cls037A._mth02CB(i, 1, j, 1, false, false));
                }
            }
        }
    }
}
