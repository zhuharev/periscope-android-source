// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            _cls025F, _cls1D5B, _cls1422, _cls0631, 
//            _cls1D59

abstract class _cls0254 extends _cls025F
{

    final Context mContext;
    private Map _fld152C;
    private Map _fld15A7;

    _cls0254(Context context, Object obj)
    {
        super(obj);
        mContext = context;
    }

    final void _mth02C6(int i)
    {
        if (_fld152C == null)
        {
            return;
        }
        Iterator iterator = _fld152C.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (i == ((MenuItem)iterator.next()).getGroupId())
            {
                iterator.remove();
            }
        } while (true);
    }

    final void _mth02C7(int i)
    {
        if (_fld152C == null)
        {
            return;
        }
        Iterator iterator = _fld152C.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (i != ((MenuItem)iterator.next()).getItemId())
            {
                continue;
            }
            iterator.remove();
            break;
        } while (true);
    }

    final SubMenu _mth02CA(SubMenu submenu)
    {
        if (submenu instanceof _cls1D5B)
        {
            _cls1D5B _lcls1d5b = (_cls1D5B)submenu;
            if (_fld15A7 == null)
            {
                _fld15A7 = new _cls1422();
            }
            SubMenu submenu1 = (SubMenu)_fld15A7.get(_lcls1d5b);
            submenu = submenu1;
            if (submenu1 == null)
            {
                submenu = mContext;
                if (android.os.Build.VERSION.SDK_INT >= 14)
                {
                    submenu = new _cls0631(submenu, _lcls1d5b);
                } else
                {
                    throw new UnsupportedOperationException();
                }
                _fld15A7.put(_lcls1d5b, submenu);
            }
            return submenu;
        } else
        {
            return submenu;
        }
    }

    final MenuItem _mth141D(MenuItem menuitem)
    {
        if (menuitem instanceof _cls1D59)
        {
            _cls1D59 _lcls1d59 = (_cls1D59)menuitem;
            if (_fld152C == null)
            {
                _fld152C = new _cls1422();
            }
            MenuItem menuitem1 = (MenuItem)_fld152C.get(menuitem);
            menuitem = menuitem1;
            if (menuitem1 == null)
            {
                menuitem = _cls141D.if._mth02CA(mContext, _lcls1d59);
                _fld152C.put(_lcls1d59, menuitem);
            }
            return menuitem;
        } else
        {
            return menuitem;
        }
    }

    final void _mth1449()
    {
        if (_fld152C != null)
        {
            _fld152C.clear();
        }
        if (_fld15A7 != null)
        {
            _fld15A7.clear();
        }
    }
}
