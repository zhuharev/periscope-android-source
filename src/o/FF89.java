// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

// Referenced classes of package o:
//            _cls1D59, _cls1D38, FE77, _cls03F3

public final class FF89
    implements _cls1D59
{

    private Context mContext;
    private CharSequence mTitle;
    private final int _fld09AF = 0;
    private final int _fld09B0 = 0;
    private final int _fld09B9 = 0;
    private CharSequence _fld09F0;
    private Intent _fld0E04;
    private char _fld0E05;
    private char _fld0E16;
    private Drawable _fld0E17;
    private int _fld0E1B;
    private android.view.MenuItem.OnMenuItemClickListener _fld0E1C;
    private int _fld0E20;
    private final int FE7C = 0x102002c;

    public FF89(Context context, int i, int j, int k, int l, CharSequence charsequence)
    {
        _fld0E1B = 0;
        _fld0E20 = 16;
        mContext = context;
        mTitle = charsequence;
    }

    public final boolean collapseActionView()
    {
        return false;
    }

    public final boolean expandActionView()
    {
        return false;
    }

    public final ActionProvider getActionProvider()
    {
        throw new UnsupportedOperationException();
    }

    public final View getActionView()
    {
        return null;
    }

    public final char getAlphabeticShortcut()
    {
        return _fld0E16;
    }

    public final int getGroupId()
    {
        return _fld09AF;
    }

    public final Drawable getIcon()
    {
        return _fld0E17;
    }

    public final Intent getIntent()
    {
        return _fld0E04;
    }

    public final int getItemId()
    {
        return FE7C;
    }

    public final android.view.ContextMenu.ContextMenuInfo getMenuInfo()
    {
        return null;
    }

    public final char getNumericShortcut()
    {
        return _fld0E05;
    }

    public final int getOrder()
    {
        return _fld09B9;
    }

    public final SubMenu getSubMenu()
    {
        return null;
    }

    public final CharSequence getTitle()
    {
        return mTitle;
    }

    public final CharSequence getTitleCondensed()
    {
        if (_fld09F0 != null)
        {
            return _fld09F0;
        } else
        {
            return mTitle;
        }
    }

    public final boolean hasSubMenu()
    {
        return false;
    }

    public final boolean isActionViewExpanded()
    {
        return false;
    }

    public final boolean isCheckable()
    {
        return (_fld0E20 & 1) != 0;
    }

    public final boolean isChecked()
    {
        return (_fld0E20 & 2) != 0;
    }

    public final boolean isEnabled()
    {
        return (_fld0E20 & 0x10) != 0;
    }

    public final boolean isVisible()
    {
        return (_fld0E20 & 8) == 0;
    }

    public final MenuItem setActionProvider(ActionProvider actionprovider)
    {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setActionView(int i)
    {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setActionView(View view)
    {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setAlphabeticShortcut(char c)
    {
        _fld0E16 = c;
        return this;
    }

    public final MenuItem setCheckable(boolean flag)
    {
        int i = _fld0E20;
        boolean flag1;
        if (flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        _fld0E20 = i & -2 | flag1;
        return this;
    }

    public final MenuItem setChecked(boolean flag)
    {
        int i = _fld0E20;
        byte byte0;
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        _fld0E20 = i & -3 | byte0;
        return this;
    }

    public final MenuItem setEnabled(boolean flag)
    {
        int i = _fld0E20;
        byte byte0;
        if (flag)
        {
            byte0 = 16;
        } else
        {
            byte0 = 0;
        }
        _fld0E20 = i & 0xffffffef | byte0;
        return this;
    }

    public final MenuItem setIcon(int i)
    {
        _fld0E1B = i;
        _fld0E17 = _cls1D38._mth02CB(mContext, i);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable)
    {
        _fld0E17 = drawable;
        _fld0E1B = 0;
        return this;
    }

    public final MenuItem setIntent(Intent intent)
    {
        _fld0E04 = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c)
    {
        _fld0E05 = c;
        return this;
    }

    public final MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onactionexpandlistener)
    {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        _fld0E1C = onmenuitemclicklistener;
        return this;
    }

    public final MenuItem setShortcut(char c, char c1)
    {
        _fld0E05 = c;
        _fld0E16 = c1;
        return this;
    }

    public final void setShowAsAction(int i)
    {
    }

    public final MenuItem setShowAsActionFlags(int i)
    {
        setShowAsAction(i);
        return this;
    }

    public final MenuItem setTitle(int i)
    {
        mTitle = mContext.getResources().getString(i);
        return this;
    }

    public final MenuItem setTitle(CharSequence charsequence)
    {
        mTitle = charsequence;
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charsequence)
    {
        _fld09F0 = charsequence;
        return this;
    }

    public final MenuItem setVisible(boolean flag)
    {
        int i = _fld0E20;
        byte byte0;
        if (flag)
        {
            byte0 = 0;
        } else
        {
            byte0 = 8;
        }
        _fld0E20 = i & 8 | byte0;
        return this;
    }

    public final FE77 _mth02C7()
    {
        return null;
    }

    public final _cls03F3 _mth02CA(FE77 fe77)
    {
        throw new UnsupportedOperationException();
    }

    public final _cls1D59 _mth02CA(_cls0441._cls02CB _pcls02cb)
    {
        return this;
    }
}
