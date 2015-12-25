// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package o:
//            _cls1D59, FE77

public class _cls14BE
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    static final _cls02CE _fld1D5F;

    public _cls14BE()
    {
    }

    public static MenuItem _mth02CA(MenuItem menuitem, View view)
    {
        if (menuitem instanceof _cls1D59)
        {
            return ((_cls1D59)menuitem).setActionView(view);
        } else
        {
            return _fld1D5F._mth02CA(menuitem, view);
        }
    }

    public static MenuItem _mth02CA(MenuItem menuitem, FE77 fe77)
    {
        if (menuitem instanceof _cls1D59)
        {
            return ((_cls1D59)menuitem)._mth02CA(fe77);
        } else
        {
            Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            return menuitem;
        }
    }

    public static View _mth02CA(MenuItem menuitem)
    {
        if (menuitem instanceof _cls1D59)
        {
            return ((_cls1D59)menuitem).getActionView();
        } else
        {
            return _fld1D5F._mth02CA(menuitem);
        }
    }

    public static void _mth02CA(MenuItem menuitem, int i)
    {
        if (menuitem instanceof _cls1D59)
        {
            ((_cls1D59)menuitem).setShowAsAction(i);
            return;
        } else
        {
            _fld1D5F._mth02CA(menuitem, i);
            return;
        }
    }

    public static MenuItem _mth02CB(MenuItem menuitem, int i)
    {
        if (menuitem instanceof _cls1D59)
        {
            return ((_cls1D59)menuitem).setActionView(i);
        } else
        {
            return _fld1D5F._mth02CB(menuitem, i);
        }
    }

    public static boolean _mth02CB(MenuItem menuitem)
    {
        if (menuitem instanceof _cls1D59)
        {
            return ((_cls1D59)menuitem).expandActionView();
        } else
        {
            return _fld1D5F._mth02CB(menuitem);
        }
    }

    public static boolean _mth02CE(MenuItem menuitem)
    {
        if (menuitem instanceof _cls1D59)
        {
            return ((_cls1D59)menuitem).isActionViewExpanded();
        } else
        {
            return _fld1D5F._mth02CE(menuitem);
        }
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 14)
        {
            _fld1D5F = new _cls02CB();
        } else
        if (i >= 11)
        {
            _fld1D5F = new _cls02CA();
        } else
        {
            _fld1D5F = new if();
        }
    }
}
