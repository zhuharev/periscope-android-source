// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v7.widget.Toolbar;
import android.view.View;

// Referenced classes of package o:
//            FEA9, _cls13B1

final class _cls14A6 extends FEA9
{

    private _cls13B1 iX;
    private int iY;
    private boolean _fld03F9;

    _cls14A6(_cls13B1 _pcls13b1, int i)
    {
        iX = _pcls13b1;
        iY = i;
        super();
        _fld03F9 = false;
    }

    public final void _mth02B3(View view)
    {
        if (!_fld03F9)
        {
            iX.iK.setVisibility(iY);
        }
    }

    public final void _mth02B4(View view)
    {
        _fld03F9 = true;
    }

    public final void FF70(View view)
    {
        iX.iK.setVisibility(0);
    }
}
