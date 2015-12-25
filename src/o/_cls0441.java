// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

// Referenced classes of package o:
//            _cls0254, _cls1D59

public class _cls0441 extends _cls0254
    implements MenuItem
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    private Method FF29;

    public _cls0441(Context context, _cls1D59 _pcls1d59)
    {
        super(context, _pcls1d59);
    }

    public boolean collapseActionView()
    {
        return ((_cls1D59)_fld15A8).collapseActionView();
    }

    public boolean expandActionView()
    {
        return ((_cls1D59)_fld15A8).expandActionView();
    }

    public ActionProvider getActionProvider()
    {
        FE77 fe77 = ((_cls1D59)_fld15A8)._mth02C7();
        if (fe77 instanceof if)
        {
            return ((if)fe77).FF4C;
        } else
        {
            return null;
        }
    }

    public View getActionView()
    {
        View view = ((_cls1D59)_fld15A8).getActionView();
        if (view instanceof _cls02CA)
        {
            return (View)((_cls02CA)view).FF52;
        } else
        {
            return view;
        }
    }

    public char getAlphabeticShortcut()
    {
        return ((_cls1D59)_fld15A8).getAlphabeticShortcut();
    }

    public int getGroupId()
    {
        return ((_cls1D59)_fld15A8).getGroupId();
    }

    public Drawable getIcon()
    {
        return ((_cls1D59)_fld15A8).getIcon();
    }

    public Intent getIntent()
    {
        return ((_cls1D59)_fld15A8).getIntent();
    }

    public int getItemId()
    {
        return ((_cls1D59)_fld15A8).getItemId();
    }

    public android.view.ContextMenu.ContextMenuInfo getMenuInfo()
    {
        return ((_cls1D59)_fld15A8).getMenuInfo();
    }

    public char getNumericShortcut()
    {
        return ((_cls1D59)_fld15A8).getNumericShortcut();
    }

    public int getOrder()
    {
        return ((_cls1D59)_fld15A8).getOrder();
    }

    public SubMenu getSubMenu()
    {
        return _mth02CA(((_cls1D59)_fld15A8).getSubMenu());
    }

    public CharSequence getTitle()
    {
        return ((_cls1D59)_fld15A8).getTitle();
    }

    public CharSequence getTitleCondensed()
    {
        return ((_cls1D59)_fld15A8).getTitleCondensed();
    }

    public boolean hasSubMenu()
    {
        return ((_cls1D59)_fld15A8).hasSubMenu();
    }

    public boolean isActionViewExpanded()
    {
        return ((_cls1D59)_fld15A8).isActionViewExpanded();
    }

    public boolean isCheckable()
    {
        return ((_cls1D59)_fld15A8).isCheckable();
    }

    public boolean isChecked()
    {
        return ((_cls1D59)_fld15A8).isChecked();
    }

    public boolean isEnabled()
    {
        return ((_cls1D59)_fld15A8).isEnabled();
    }

    public boolean isVisible()
    {
        return ((_cls1D59)_fld15A8).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionprovider)
    {
        _cls1D59 _lcls1d59 = (_cls1D59)_fld15A8;
        if (actionprovider != null)
        {
            actionprovider = _mth02CA(actionprovider);
        } else
        {
            actionprovider = null;
        }
        _lcls1d59._mth02CA(actionprovider);
        return this;
    }

    public MenuItem setActionView(int i)
    {
        ((_cls1D59)_fld15A8).setActionView(i);
        View view = ((_cls1D59)_fld15A8).getActionView();
        if (view instanceof CollapsibleActionView)
        {
            ((_cls1D59)_fld15A8).setActionView(new _cls02CA(view));
        }
        return this;
    }

    public MenuItem setActionView(View view)
    {
        Object obj = view;
        if (view instanceof CollapsibleActionView)
        {
            obj = new _cls02CA(view);
        }
        ((_cls1D59)_fld15A8).setActionView(((View) (obj)));
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c)
    {
        ((_cls1D59)_fld15A8).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setCheckable(boolean flag)
    {
        ((_cls1D59)_fld15A8).setCheckable(flag);
        return this;
    }

    public MenuItem setChecked(boolean flag)
    {
        ((_cls1D59)_fld15A8).setChecked(flag);
        return this;
    }

    public MenuItem setEnabled(boolean flag)
    {
        ((_cls1D59)_fld15A8).setEnabled(flag);
        return this;
    }

    public MenuItem setIcon(int i)
    {
        ((_cls1D59)_fld15A8).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable)
    {
        ((_cls1D59)_fld15A8).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent)
    {
        ((_cls1D59)_fld15A8).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c)
    {
        ((_cls1D59)_fld15A8).setNumericShortcut(c);
        return this;
    }

    public MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onactionexpandlistener)
    {
        _cls1D59 _lcls1d59 = (_cls1D59)_fld15A8;
        if (onactionexpandlistener != null)
        {
            onactionexpandlistener = new _cls02CB(onactionexpandlistener);
        } else
        {
            onactionexpandlistener = null;
        }
        _lcls1d59._mth02CA(onactionexpandlistener);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        _cls1D59 _lcls1d59 = (_cls1D59)_fld15A8;
        if (onmenuitemclicklistener != null)
        {
            onmenuitemclicklistener = new _cls02CE(onmenuitemclicklistener);
        } else
        {
            onmenuitemclicklistener = null;
        }
        _lcls1d59.setOnMenuItemClickListener(onmenuitemclicklistener);
        return this;
    }

    public MenuItem setShortcut(char c, char c1)
    {
        ((_cls1D59)_fld15A8).setShortcut(c, c1);
        return this;
    }

    public void setShowAsAction(int i)
    {
        ((_cls1D59)_fld15A8).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i)
    {
        ((_cls1D59)_fld15A8).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i)
    {
        ((_cls1D59)_fld15A8).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charsequence)
    {
        ((_cls1D59)_fld15A8).setTitle(charsequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charsequence)
    {
        ((_cls1D59)_fld15A8).setTitleCondensed(charsequence);
        return this;
    }

    public MenuItem setVisible(boolean flag)
    {
        return ((_cls1D59)_fld15A8).setVisible(flag);
    }

    if _mth02CA(ActionProvider actionprovider)
    {
        return new if(mContext, actionprovider);
    }

    public void _mth05D9(boolean flag)
    {
        try
        {
            if (FF29 == null)
            {
                FF29 = ((_cls1D59)_fld15A8).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] {
                    Boolean.TYPE
                });
            }
            FF29.invoke(_fld15A8, new Object[] {
                Boolean.valueOf(flag)
            });
            return;
        }
        catch (Exception exception)
        {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", exception);
        }
    }
}
