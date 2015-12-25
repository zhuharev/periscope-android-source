// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package o:
//            _cls010B, FEE7

final class _cls05F0
    implements android.view.View.OnKeyListener
{

    private _cls010B hb;

    _cls05F0(_cls010B _pcls010b)
    {
        hb = _pcls010b;
        super();
    }

    public final boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (_cls010B._mth02CC(hb) == null)
        {
            return false;
        }
        if (_cls010B._mth02C8(hb).isPopupShowing() && _cls010B._mth02C8(hb).getListSelection() != -1)
        {
            return _cls010B._mth02CA(hb, view, i, keyevent);
        }
        if (!_cls010B._cls02CA._mth02CA(_cls010B._mth02C8(hb)) && FEE7._mth02CA(keyevent) && keyevent.getAction() == 1 && i == 66)
        {
            view.cancelLongPress();
            _cls010B._mth02CA(hb, 0, null, _cls010B._mth02C8(hb).getText().toString());
            return true;
        } else
        {
            return false;
        }
    }
}
