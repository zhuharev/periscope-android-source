// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls1D59, _cls02E0, FE77, _cls0715, 
//            _cls0621, _cls0408

public final class _cls03F3
    implements _cls1D59
{

    private CharSequence mTitle;
    private final int _fld09AF;
    private final int _fld09B0;
    final int _fld09B9;
    private CharSequence _fld09F0;
    private Intent _fld0E04;
    char _fld0E05;
    char _fld0E16;
    private Drawable _fld0E17;
    private int _fld0E1B;
    private android.view.MenuItem.OnMenuItemClickListener _fld0E1C;
    public int _fld0E20;
    public _cls02E0 FB30;
    _cls0621 FB5E;
    private final int FE7C;
    public int FE95;
    private View FE9F;
    public FE77 FEA7;
    private _cls14BE._cls02CF FECB;
    public boolean FECC;
    private android.view.ContextMenu.ContextMenuInfo FEE2;

    _cls03F3(_cls02E0 _pcls02e0, int i, int j, int k, int l, CharSequence charsequence, int i1)
    {
        _fld0E1B = 0;
        _fld0E20 = 16;
        FE95 = 0;
        FECC = false;
        FB30 = _pcls02e0;
        FE7C = j;
        _fld09AF = i;
        _fld09B0 = k;
        _fld09B9 = l;
        mTitle = charsequence;
        FE95 = i1;
    }

    static _cls02E0 _mth02BC(_cls03F3 _pcls03f3)
    {
        return _pcls03f3.FB30;
    }

    private _cls03F3 _mth1540(View view)
    {
        FE9F = view;
        FEA7 = null;
        if (view != null && view.getId() == -1 && FE7C > 0)
        {
            view.setId(FE7C);
        }
        view = FB30;
        view._fld1F3F = true;
        view.FF9E(true);
        return this;
    }

    public final boolean collapseActionView()
    {
        if ((FE95 & 8) == 0)
        {
            return false;
        }
        if (FE9F == null)
        {
            return true;
        }
        if (FECB == null || FECB.onMenuItemActionCollapse(this))
        {
            return FB30._mth02BB(this);
        } else
        {
            return false;
        }
    }

    public final boolean expandActionView()
    {
        if (!_mth1D58())
        {
            return false;
        }
        if (FECB == null || FECB.onMenuItemActionExpand(this))
        {
            return FB30._mth141D(this);
        } else
        {
            return false;
        }
    }

    public final ActionProvider getActionProvider()
    {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final View getActionView()
    {
        if (FE9F != null)
        {
            return FE9F;
        }
        if (FEA7 != null)
        {
            FE9F = FEA7.onCreateActionView(this);
            return FE9F;
        } else
        {
            return null;
        }
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
        if (_fld0E17 != null)
        {
            return _fld0E17;
        }
        if (_fld0E1B != 0)
        {
            Drawable drawable = _cls0715._mth02CB(FB30.mContext, _fld0E1B);
            _fld0E1B = 0;
            _fld0E17 = drawable;
            return drawable;
        } else
        {
            return null;
        }
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
        return FEE2;
    }

    public final char getNumericShortcut()
    {
        return _fld0E05;
    }

    public final int getOrder()
    {
        return _fld09B0;
    }

    public final SubMenu getSubMenu()
    {
        return FB5E;
    }

    public final CharSequence getTitle()
    {
        return mTitle;
    }

    public final CharSequence getTitleCondensed()
    {
        CharSequence charsequence;
        if (_fld09F0 != null)
        {
            charsequence = _fld09F0;
        } else
        {
            charsequence = mTitle;
        }
        if (android.os.Build.VERSION.SDK_INT < 18 && charsequence != null && !(charsequence instanceof String))
        {
            return charsequence.toString();
        } else
        {
            return charsequence;
        }
    }

    public final boolean hasSubMenu()
    {
        return FB5E != null;
    }

    public final boolean isActionViewExpanded()
    {
        return FECC;
    }

    public final boolean isCheckable()
    {
        return (_fld0E20 & 1) == 1;
    }

    public final boolean isChecked()
    {
        return (_fld0E20 & 2) == 2;
    }

    public final boolean isEnabled()
    {
        return (_fld0E20 & 0x10) != 0;
    }

    public final boolean isVisible()
    {
        if (FEA7 != null && FEA7.overridesItemVisibility())
        {
            return (_fld0E20 & 8) == 0 && FEA7.isVisible();
        }
        return (_fld0E20 & 8) == 0;
    }

    public final MenuItem setActionProvider(ActionProvider actionprovider)
    {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final MenuItem setActionView(int i)
    {
        Context context = FB30.mContext;
        _mth1540(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public final MenuItem setActionView(View view)
    {
        return _mth1540(view);
    }

    public final MenuItem setAlphabeticShortcut(char c)
    {
        if (_fld0E16 == c)
        {
            return this;
        } else
        {
            _fld0E16 = Character.toLowerCase(c);
            FB30.FF9E(false);
            return this;
        }
    }

    public final MenuItem setCheckable(boolean flag)
    {
        int i = _fld0E20;
        int j = _fld0E20;
        boolean flag1;
        if (flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        _fld0E20 = j & -2 | flag1;
        if (i != _fld0E20)
        {
            FB30.FF9E(false);
        }
        return this;
    }

    public final MenuItem setChecked(boolean flag)
    {
        if ((_fld0E20 & 4) != 0)
        {
            _cls02E0 _lcls02e0 = FB30;
            int j = getGroupId();
            int k = _lcls02e0.FF89.size();
            for (int i = 0; i < k; i++)
            {
                _cls03F3 _lcls03f3 = (_cls03F3)_lcls02e0.FF89.get(i);
                if (_lcls03f3.getGroupId() != j)
                {
                    continue;
                }
                boolean flag1;
                if ((_lcls03f3._fld0E20 & 4) != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag1 || !_lcls03f3.isCheckable())
                {
                    continue;
                }
                if (_lcls03f3 == this)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                _lcls03f3._mth02B9(flag);
            }

            return this;
        } else
        {
            _mth02B9(flag);
            return this;
        }
    }

    public final MenuItem setEnabled(boolean flag)
    {
        if (flag)
        {
            _fld0E20 = _fld0E20 | 0x10;
        } else
        {
            _fld0E20 = _fld0E20 & 0xffffffef;
        }
        FB30.FF9E(false);
        return this;
    }

    public final MenuItem setIcon(int i)
    {
        _fld0E17 = null;
        _fld0E1B = i;
        FB30.FF9E(false);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable)
    {
        _fld0E1B = 0;
        _fld0E17 = drawable;
        FB30.FF9E(false);
        return this;
    }

    public final MenuItem setIntent(Intent intent)
    {
        _fld0E04 = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c)
    {
        if (_fld0E05 == c)
        {
            return this;
        } else
        {
            _fld0E05 = c;
            FB30.FF9E(false);
            return this;
        }
    }

    public final MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onactionexpandlistener)
    {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public final MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        _fld0E1C = onmenuitemclicklistener;
        return this;
    }

    public final MenuItem setShortcut(char c, char c1)
    {
        _fld0E05 = c;
        _fld0E16 = Character.toLowerCase(c1);
        FB30.FF9E(false);
        return this;
    }

    public final void setShowAsAction(int i)
    {
        switch (i & 3)
        {
        default:
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            FE95 = i;
            break;
        }
        FB30._mth14EB();
    }

    public final MenuItem setShowAsActionFlags(int i)
    {
        setShowAsAction(i);
        return this;
    }

    public final MenuItem setTitle(int i)
    {
        return setTitle(((CharSequence) (FB30.mContext.getString(i))));
    }

    public final MenuItem setTitle(CharSequence charsequence)
    {
        mTitle = charsequence;
        FB30.FF9E(false);
        if (FB5E != null)
        {
            FB5E.setHeaderTitle(charsequence);
        }
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charsequence)
    {
        _fld09F0 = charsequence;
        FB30.FF9E(false);
        return this;
    }

    public final MenuItem setVisible(boolean flag)
    {
        if (_mth0559(flag))
        {
            _cls02E0 _lcls02e0 = FB30;
            _lcls02e0._fld1ECD = true;
            _lcls02e0.FF9E(true);
        }
        return this;
    }

    public final String toString()
    {
        if (mTitle != null)
        {
            return mTitle.toString();
        } else
        {
            return null;
        }
    }

    final void _mth02B9(boolean flag)
    {
        int i = _fld0E20;
        int j = _fld0E20;
        byte byte0;
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        _fld0E20 = j & -3 | byte0;
        if (i != _fld0E20)
        {
            FB30.FF9E(false);
        }
    }

    public final FE77 _mth02C7()
    {
        return FEA7;
    }

    public final _cls03F3 _mth02CA(FE77 fe77)
    {
        if (FEA7 != null)
        {
            FEA7.reset();
        }
        FE9F = null;
        FEA7 = fe77;
        FB30.FF9E(true);
        if (FEA7 != null)
        {
            FEA7._mth02CA(new _cls0408(this));
        }
        return this;
    }

    public final _cls1D59 _mth02CA(_cls0441._cls02CB _pcls02cb)
    {
        FECB = _pcls02cb;
        return this;
    }

    final boolean _mth0559(boolean flag)
    {
        int i = _fld0E20;
        int j = _fld0E20;
        byte byte0;
        if (flag)
        {
            byte0 = 0;
        } else
        {
            byte0 = 8;
        }
        _fld0E20 = j & -9 | byte0;
        return i != _fld0E20;
    }

    public final boolean _mth1D52()
    {
        if (_fld0E1C != null && _fld0E1C.onMenuItemClick(this))
        {
            return true;
        }
        if (FB30._mth02CB(FB30._mth155D(), this))
        {
            return true;
        }
        if (_fld0E04 == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        FB30.mContext.startActivity(_fld0E04);
        return true;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", activitynotfoundexception);
        return FEA7 != null && FEA7.onPerformDefaultAction();
    }

    public final boolean _mth1D58()
    {
        if ((FE95 & 8) != 0)
        {
            if (FE9F == null && FEA7 != null)
            {
                FE9F = FEA7.onCreateActionView(this);
            }
            return FE9F != null;
        } else
        {
            return false;
        }
    }
}
