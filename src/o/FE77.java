// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class FE77
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    private final Context mContext;
    private if _fld012D;
    private _cls02CA _fld013A;

    public FE77()
    {
    }

    public FE77(Context context)
    {
        mContext = context;
    }

    public boolean hasSubMenu()
    {
        return false;
    }

    public boolean isVisible()
    {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuitem)
    {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction()
    {
        return false;
    }

    public void onPrepareSubMenu(SubMenu submenu)
    {
    }

    public boolean overridesItemVisibility()
    {
        return false;
    }

    public void reset()
    {
        _fld013A = null;
        _fld012D = null;
    }

    public void _mth02CA(if if1)
    {
        _fld012D = if1;
    }

    public void _mth02CA(_cls02CA _pcls02ca)
    {
        if (_fld013A != null && _pcls02ca != null)
        {
            Log.w("ActionProvider(support)", (new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ")).append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?").toString());
        }
        _fld013A = _pcls02ca;
    }

    public void _mth141D(boolean flag)
    {
        if (_fld012D != null)
        {
            _fld012D._mth02BB(flag);
        }
    }
}
