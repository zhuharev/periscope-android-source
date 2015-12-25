// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.PopupWindow;

// Referenced classes of package o:
//            FEA9, _cls14F4, _cls14F0, FE70, 
//            _cls1646

class _cls1D5F extends FEA9
{

    final _cls14F4._cls02CA _fld0505;

    _cls1D5F(_cls14F4._cls02CA _pcls02ca)
    {
        _fld0505 = _pcls02ca;
        super();
    }

    public void _mth02B3(View view)
    {
        _fld0505._fld04BA._fld0192.setVisibility(8);
        if (_fld0505._fld04BA._fld01AD != null)
        {
            _fld0505._fld04BA._fld01AD.dismiss();
        } else
        if (_fld0505._fld04BA._fld0192.getParent() instanceof View)
        {
            FE70._mth02B9((View)_fld0505._fld04BA._fld0192.getParent());
        }
        _fld0505._fld04BA._fld0192.removeAllViews();
        _fld0505._fld04BA._fld025C._mth02CA(null);
        _fld0505._fld04BA._fld025C = null;
    }
}
