// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

// Referenced classes of package o:
//            _cls14F4, FE70, _cls1646, _cls1D5F, 
//            _cls0E45, _cls6C35

public class _cls0501
    implements ject
{

    final _cls14F4 _fld04BA;
    private .Menu _fld0501;

    public void _mth02CA(_cls6C35 _pcls6c35)
    {
        _fld0501.CA(_pcls6c35);
        if (_fld04BA._fld01AD != null)
        {
            _fld04BA._fld0422.getDecorView().removeCallbacks(_fld04BA._fld025B);
        }
        if (_fld04BA._fld0192 != null)
        {
            _cls14F4._mth02CE(_fld04BA);
            _fld04BA._fld025C = FE70._mth1428(_fld04BA._fld0192)._mth02CE(0.0F);
            _fld04BA._fld025C._mth02CA(new _cls1D5F(this));
        }
        if (_fld04BA.FB88 != null)
        {
            _fld04BA.FB88.onSupportActionModeFinished(_fld04BA._fld0178);
        }
        _fld04BA._fld0178 = null;
    }

    public boolean _mth02CA(_cls6C35 _pcls6c35, Menu menu)
    {
        return _fld0501.CA(_pcls6c35, menu);
    }

    public boolean _mth02CA(_cls6C35 _pcls6c35, MenuItem menuitem)
    {
        return _fld0501.CA(_pcls6c35, menuitem);
    }

    public boolean _mth02CB(_cls6C35 _pcls6c35, Menu menu)
    {
        return _fld0501.CB(_pcls6c35, menu);
    }

    public .Menu(_cls14F4 _pcls14f4, .Menu menu)
    {
        _fld04BA = _pcls14f4;
        super();
        _fld0501 = menu;
    }
}
