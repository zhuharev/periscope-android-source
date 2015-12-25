// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            _cls1D10, _cls02E0

final class _cls1FE9
    implements Runnable
{

    private _cls1D10 _fld1FE8;
    private _cls1FE8 _fld1FE9;

    public final void run()
    {
        Object obj = _cls1D10._mth02CF(_fld1FE8);
        if (((_cls02E0) (obj))._fld1E8F != null)
        {
            ((_cls02E0) (obj))._fld1E8F.CA(((_cls02E0) (obj)));
        }
        obj = (View)_cls1D10._mth141D(_fld1FE8);
        if (obj != null && ((View) (obj)).getWindowToken() != null && _fld1FE9._mth1D64())
        {
            _fld1FE8._fld1D46 = _fld1FE9;
        }
        _fld1FE8._fld1E38 = null;
    }

    public .View(_cls1D10 _pcls1d10, .View view)
    {
        _fld1FE8 = _pcls1d10;
        super();
        _fld1FE9 = view;
    }
}
