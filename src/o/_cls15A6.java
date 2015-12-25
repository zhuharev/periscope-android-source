// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            _cls4E36, FF68, _cls14F4, FE70

class _cls15A6
    implements _cls4E36
{

    final _cls14F4 _fld04BA;

    _cls15A6(_cls14F4 _pcls14f4)
    {
        _fld04BA = _pcls14f4;
        super();
    }

    public FF68 _mth02CA(View view, FF68 ff68)
    {
        int i = ff68.getSystemWindowInsetTop();
        int j = _cls14F4._mth02CE(_fld04BA, i);
        FF68 ff68_1 = ff68;
        if (i != j)
        {
            ff68_1 = ff68._mth02CB(ff68.getSystemWindowInsetLeft(), j, ff68.getSystemWindowInsetRight(), ff68.getSystemWindowInsetBottom());
        }
        return FE70._mth02CA(view, ff68_1);
    }
}
