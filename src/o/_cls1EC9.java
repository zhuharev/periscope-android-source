// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.Menu;

// Referenced classes of package o:
//            _cls1E5B, _cls02E0

final class _cls1EC9
    implements Runnable
{

    private _cls1E5B _fld14AD;

    _cls1EC9(_cls1E5B _pcls1e5b)
    {
        _fld14AD = _pcls1e5b;
        super();
    }

    public final void run()
    {
        _cls02E0 _lcls02e0;
        _cls1E5B _lcls1e5b;
        Menu menu;
        _lcls1e5b = _fld14AD;
        menu = _lcls1e5b.getMenu();
        if (menu instanceof _cls02E0)
        {
            _lcls02e0 = (_cls02E0)menu;
        } else
        {
            _lcls02e0 = null;
        }
        if (_lcls02e0 != null && !_lcls02e0._fld3043)
        {
            _lcls02e0._fld3043 = true;
            _lcls02e0._fld30A1 = false;
        }
        menu.clear();
        if (!_lcls1e5b._fld142F.onCreatePanelMenu(0, menu) || !_lcls1e5b._fld142F.onPreparePanel(0, null, menu))
        {
            menu.clear();
        }
        Exception exception;
        if (_lcls02e0 != null)
        {
            _lcls02e0._fld3043 = false;
            if (_lcls02e0._fld30A1)
            {
                _lcls02e0._fld30A1 = false;
                _lcls02e0.FF9E(true);
            }
            return;
        } else
        {
            return;
        }
        exception;
        if (_lcls02e0 != null)
        {
            _lcls02e0._fld3043 = false;
            if (_lcls02e0._fld30A1)
            {
                _lcls02e0._fld30A1 = false;
                _lcls02e0.FF9E(true);
            }
        }
        throw exception;
    }
}
