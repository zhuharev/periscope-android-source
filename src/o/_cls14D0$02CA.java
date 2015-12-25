// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

// Referenced classes of package o:
//            FEDF, _cls14D0, _cls02E0

class .lback extends FEDF
{

    final _cls14D0 FF74;

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return FF74.dispatchKeyEvent(keyevent) || super.dispatchKeyEvent(keyevent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyevent)
    {
        return super.dispatchKeyShortcutEvent(keyevent) || FF74.onKeyShortcut(keyevent.getKeyCode(), keyevent);
    }

    public void onContentChanged()
    {
    }

    public boolean onCreatePanelMenu(int i, Menu menu)
    {
        if (i == 0 && !(menu instanceof _cls02E0))
        {
            return false;
        } else
        {
            return super.onCreatePanelMenu(i, menu);
        }
    }

    public boolean onMenuOpened(int i, Menu menu)
    {
        super.onMenuOpened(i, menu);
        FF74.onMenuOpened(i, menu);
        return true;
    }

    public void onPanelClosed(int i, Menu menu)
    {
        super.onPanelClosed(i, menu);
        FF74.onPanelClosed(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu)
    {
        _cls02E0 _lcls02e0;
        if (menu instanceof _cls02E0)
        {
            _lcls02e0 = (_cls02E0)menu;
        } else
        {
            _lcls02e0 = null;
        }
        if (i == 0 && _lcls02e0 == null)
        {
            return false;
        }
        if (_lcls02e0 != null)
        {
            _lcls02e0.FB46 = true;
        }
        boolean flag = super.onPreparePanel(i, view, menu);
        if (_lcls02e0 != null)
        {
            _lcls02e0.FB46 = false;
        }
        return flag;
    }

    .lback(_cls14D0 _pcls14d0, android.view.lback lback)
    {
        FF74 = _pcls14d0;
        super(lback);
    }
}
