// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.widget.ListAdapter;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package o:
//            FEDF, _cls1E5B, _cls0722, _cls02E0, 
//            _cls1541, _cls1F30, _cls02B1, _cls0491

final class .lback extends FEDF
{

    private _cls1E5B _fld14AD;

    public final View onCreatePanelView(int i)
    {
        switch (i)
        {
        case 0: // '\0'
            Object obj = _fld14AD._fld0E01.getMenu();
            if (onPreparePanel(i, null, ((Menu) (obj))) && onMenuOpened(i, ((Menu) (obj))))
            {
                _cls1E5B _lcls1e5b = _fld14AD;
                if (_lcls1e5b._fld148E == null && (obj instanceof _cls02E0))
                {
                    _cls02E0 _lcls02e0 = (_cls02E0)obj;
                    Object obj2 = _lcls1e5b._fld0E01.getContext();
                    TypedValue typedvalue = new TypedValue();
                    Object obj1 = ((Context) (obj2)).getResources().newTheme();
                    ((android.content.res.Theme) (obj1)).setTo(((Context) (obj2)).getTheme());
                    ((android.content.res.Theme) (obj1)).resolveAttribute(_cls1541.actionBarPopupTheme, typedvalue, true);
                    if (typedvalue.resourceId != 0)
                    {
                        ((android.content.res.Theme) (obj1)).applyStyle(typedvalue.resourceId, true);
                    }
                    ((android.content.res.Theme) (obj1)).resolveAttribute(_cls1541.panelMenuListTheme, typedvalue, true);
                    if (typedvalue.resourceId != 0)
                    {
                        ((android.content.res.Theme) (obj1)).applyStyle(typedvalue.resourceId, true);
                    } else
                    {
                        ((android.content.res.Theme) (obj1)).applyStyle(_cls1F30.Theme_AppCompat_CompactMenu, true);
                    }
                    obj2 = new ContextThemeWrapper(((Context) (obj2)), 0);
                    ((Context) (obj2)).getTheme().setTo(((android.content.res.Theme) (obj1)));
                    _lcls1e5b._fld148E = new _cls02B1(((Context) (obj2)), c_list_menu_item_layout);
                    _lcls1e5b._fld148E._fld14B5 = new <init>(_lcls1e5b, (byte)0);
                    obj1 = _lcls1e5b._fld148E;
                    obj2 = _lcls02e0.mContext;
                    _lcls02e0._fld5B80.add(new WeakReference(obj1));
                    ((_cls0491) (obj1))._mth02CA(((Context) (obj2)), _lcls02e0);
                    _lcls02e0._fld1F3F = true;
                }
                if (obj == null || _lcls1e5b._fld148E == null)
                {
                    return null;
                }
                obj = _lcls1e5b._fld148E;
                if (((_cls02B1) (obj))._fld1D1D == null)
                {
                    obj._fld1D1D = new nit>(((_cls02B1) (obj)));
                }
                if (((_cls02B1) (obj))._fld1D1D.getCount() > 0)
                {
                    return (View)_lcls1e5b._fld148E._mth02CE(_lcls1e5b._fld0E01.FE92());
                } else
                {
                    return null;
                }
            }
            break;
        }
        return super.onCreatePanelView(i);
    }

    public final boolean onPreparePanel(int i, View view, Menu menu)
    {
        boolean flag = super.onPreparePanel(i, view, menu);
        if (flag && !_fld14AD._fld10D9)
        {
            _fld14AD._fld0E01.setMenuPrepared();
            _fld14AD._fld10D9 = true;
        }
        return flag;
    }

    public .lback(_cls1E5B _pcls1e5b, android.view.lback lback)
    {
        _fld14AD = _pcls1e5b;
        super(lback);
    }
}
