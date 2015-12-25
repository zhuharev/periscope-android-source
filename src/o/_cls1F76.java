// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            FEA9, _cls1F31, FE70, _cls0EC0

final class _cls1F76 extends FEA9
{

    private _cls1F31 _fld30A4;

    _cls1F76(_cls1F31 _pcls1f31)
    {
        _fld30A4 = _pcls1f31;
        super();
    }

    public final void _mth02B3(View view)
    {
        if (_cls1F31._mth02CA(_fld30A4) && _cls1F31._mth02CB(_fld30A4) != null)
        {
            FE70._mth02CB(_cls1F31._mth02CB(_fld30A4), 0.0F);
            FE70._mth02CB(_cls1F31._mth02CE(_fld30A4), 0.0F);
        }
        _cls1F31._mth02CE(_fld30A4).setVisibility(8);
        _cls1F31._mth02CE(_fld30A4).setTransitioning(false);
        _cls1F31._mth02CA(_fld30A4, null);
        view = _fld30A4;
        if (((_cls1F31) (view))._fld1686 != null)
        {
            ((_cls1F31) (view))._fld1686._mth02CA(((_cls1F31) (view))._fld1681);
            view._fld1681 = null;
            view._fld1686 = null;
        }
        if (_cls1F31._mth02CF(_fld30A4) != null)
        {
            FE70._mth02B9(_cls1F31._mth02CF(_fld30A4));
        }
    }
}
