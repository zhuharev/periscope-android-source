// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            FEA9, _cls14F4, FE70, _cls1646, 
//            _cls14F0

class _cls1D56 extends FEA9
{

    final _cls14F4 _fld04BA;

    _cls1D56(_cls14F4 _pcls14f4)
    {
        _fld04BA = _pcls14f4;
        super();
    }

    public void _mth02B3(View view)
    {
        FE70._mth02CE(_fld04BA._fld0192, 1.0F);
        _fld04BA._fld025C._mth02CA(null);
        _fld04BA._fld025C = null;
    }

    public void FF70(View view)
    {
        _fld04BA._fld0192.setVisibility(0);
        _fld04BA._fld0192.sendAccessibilityEvent(32);
        if (_fld04BA._fld0192.getParent() != null)
        {
            FE70._mth02B9((View)_fld04BA._fld0192.getParent());
        }
    }
}
