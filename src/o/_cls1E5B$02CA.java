// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.MenuItem;

// Referenced classes of package o:
//            _cls1E5B, _cls0722, _cls02E0

public final class <init>
    implements ject
{

    private _cls1E5B _fld14AD;

    public final void _mth02CA(_cls02E0 _pcls02e0)
    {
        if (_fld14AD._fld142F != null)
        {
            if (_fld14AD._fld0E01.isOverflowMenuShowing())
            {
                _fld14AD._fld142F.onPanelClosed(108, _pcls02e0);
                return;
            }
            if (_fld14AD._fld142F.onPreparePanel(0, null, _pcls02e0))
            {
                _fld14AD._fld142F.onMenuOpened(108, _pcls02e0);
            }
        }
    }

    public final boolean _mth02CA(_cls02E0 _pcls02e0, MenuItem menuitem)
    {
        return false;
    }

    public .MenuItem()
    {
    }

    private .MenuItem(_cls1E5B _pcls1e5b)
    {
        _fld14AD = _pcls1e5b;
        super();
    }

    ject(_cls1E5B _pcls1e5b, byte byte0)
    {
        this(_pcls1e5b);
    }
}
