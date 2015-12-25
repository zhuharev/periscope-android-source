// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

// Referenced classes of package o:
//            _cls0722, _cls09A3, _cls1FD1, _cls1541, 
//            _cls0715, _cls13D3, _cls03F3, _cls1D3A, 
//            _cls1D10, _cls0285, _cls01C0, _cls02E0, 
//            FE70, _cls1646, _cls14A6, FF8C

public final class _cls13B1
    implements _cls0722
{

    private final _cls0715 E;
    Toolbar iK;
    private int iL;
    private FF8C iM;
    private Drawable iN;
    private Drawable iO;
    private boolean iP;
    private CharSequence iQ;
    android.view.Window.Callback iR;
    boolean iS;
    private int iT;
    private int iU;
    private Drawable iV;
    CharSequence mTitle;
    private _cls1D10 _fld03D9;
    private CharSequence _fld0578;
    private View _fld05E4;
    private Drawable _fld0EB2;

    public _cls13B1(Toolbar toolbar, boolean flag)
    {
        this(toolbar, flag, _cls09F3.if.abc_action_bar_up_description, FE79.if.abc_ic_ab_back_mtrl_am_alpha);
    }

    private _cls13B1(Toolbar toolbar, boolean flag, int i, int j)
    {
        iT = 0;
        iU = 0;
        iK = toolbar;
        mTitle = toolbar.iq;
        _fld0578 = toolbar.ir;
        boolean flag1;
        if (mTitle != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        iP = flag1;
        Drawable drawable;
        if (toolbar.hZ != null)
        {
            drawable = toolbar.hZ.getDrawable();
        } else
        {
            drawable = null;
        }
        iO = drawable;
        if (flag)
        {
            toolbar = toolbar.getContext();
            toolbar = new _cls09A3(toolbar, toolbar.obtainStyledAttributes(null, _cls1FD1.ActionBar, _cls1541.actionBarStyle, 0));
            int k = _cls1FD1.ActionBar_title;
            Object obj = ((_cls09A3) (toolbar)).hU.getText(k);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                iP = true;
                mTitle = ((CharSequence) (obj));
                if ((iL & 8) != 0)
                {
                    iK.setTitle(((CharSequence) (obj)));
                }
            }
            k = _cls1FD1.ActionBar_subtitle;
            obj = ((_cls09A3) (toolbar)).hU.getText(k);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                _fld0578 = ((CharSequence) (obj));
                if ((iL & 8) != 0)
                {
                    iK.setSubtitle(((CharSequence) (obj)));
                }
            }
            obj = toolbar.getDrawable(_cls1FD1.ActionBar_logo);
            if (obj != null)
            {
                iN = ((Drawable) (obj));
                _mth012D();
            }
            obj = toolbar.getDrawable(_cls1FD1.ActionBar_icon);
            if (iO == null && obj != null)
            {
                _fld0EB2 = ((Drawable) (obj));
                _mth012D();
            }
            obj = toolbar.getDrawable(_cls1FD1.ActionBar_homeAsUpIndicator);
            if (obj != null)
            {
                iO = ((Drawable) (obj));
                _mth013C();
            }
            k = _cls1FD1.ActionBar_displayOptions;
            setDisplayOptions(((_cls09A3) (toolbar)).hU.getInt(k, 0));
            k = _cls1FD1.ActionBar_customNavigationLayout;
            k = ((_cls09A3) (toolbar)).hU.getResourceId(k, 0);
            if (k != 0)
            {
                View view = LayoutInflater.from(iK.getContext()).inflate(k, iK, false);
                if (_fld05E4 != null && (iL & 0x10) != 0)
                {
                    iK.removeView(_fld05E4);
                }
                _fld05E4 = view;
                if (view != null && (iL & 0x10) != 0)
                {
                    iK.addView(_fld05E4);
                }
                setDisplayOptions(iL | 0x10);
            }
            k = _cls1FD1.ActionBar_height;
            k = ((_cls09A3) (toolbar)).hU.getLayoutDimension(k, 0);
            if (k > 0)
            {
                android.view.ViewGroup.LayoutParams layoutparams = iK.getLayoutParams();
                layoutparams.height = k;
                iK.setLayoutParams(layoutparams);
            }
            k = _cls1FD1.ActionBar_contentInsetStart;
            k = ((_cls09A3) (toolbar)).hU.getDimensionPixelOffset(k, -1);
            int i1 = _cls1FD1.ActionBar_contentInsetEnd;
            i1 = ((_cls09A3) (toolbar)).hU.getDimensionPixelOffset(i1, -1);
            if (k >= 0 || i1 >= 0)
            {
                iK.setContentInsetsRelative(Math.max(k, 0), Math.max(i1, 0));
            }
            k = _cls1FD1.ActionBar_titleTextStyle;
            k = ((_cls09A3) (toolbar)).hU.getResourceId(k, 0);
            if (k != 0)
            {
                iK.setTitleTextAppearance(iK.getContext(), k);
            }
            k = _cls1FD1.ActionBar_subtitleTextStyle;
            k = ((_cls09A3) (toolbar)).hU.getResourceId(k, 0);
            if (k != 0)
            {
                iK.setSubtitleTextAppearance(iK.getContext(), k);
            }
            k = _cls1FD1.ActionBar_popupTheme;
            k = ((_cls09A3) (toolbar)).hU.getResourceId(k, 0);
            if (k != 0)
            {
                iK.setPopupTheme(k);
            }
            ((_cls09A3) (toolbar)).hU.recycle();
            if (((_cls09A3) (toolbar)).E == null)
            {
                toolbar.E = _cls0715._mth1FBE(((_cls09A3) (toolbar)).mContext);
            }
            E = ((_cls09A3) (toolbar)).E;
        } else
        {
            int l = 11;
            Object obj1 = iK;
            if (((Toolbar) (obj1)).hZ != null)
            {
                obj1 = ((Toolbar) (obj1)).hZ.getDrawable();
            } else
            {
                obj1 = null;
            }
            if (obj1 != null)
            {
                l = 15;
            }
            iL = l;
            E = _cls0715._mth1FBE(toolbar.getContext());
        }
        if (i != iU)
        {
            iU = i;
            toolbar = iK;
            if (toolbar.hZ != null)
            {
                toolbar = toolbar.hZ.getContentDescription();
            } else
            {
                toolbar = null;
            }
            if (TextUtils.isEmpty(toolbar))
            {
                i = iU;
                if (i == 0)
                {
                    toolbar = null;
                } else
                {
                    toolbar = iK.getContext().getString(i);
                }
                iQ = toolbar;
                _mth013A();
            }
        }
        toolbar = iK;
        if (toolbar.hZ != null)
        {
            toolbar = toolbar.hZ.getContentDescription();
        } else
        {
            toolbar = null;
        }
        iQ = toolbar;
        toolbar = E._mth02BD(j, false);
        if (iV != toolbar)
        {
            iV = toolbar;
            _mth013C();
        }
        iK.setNavigationOnClickListener(new _cls13D3(this));
    }

    private void _mth012D()
    {
        Drawable drawable = null;
        if ((iL & 2) != 0)
        {
            if ((iL & 1) != 0)
            {
                if (iN != null)
                {
                    drawable = iN;
                } else
                {
                    drawable = _fld0EB2;
                }
            } else
            {
                drawable = _fld0EB2;
            }
        }
        iK.setLogo(drawable);
    }

    private void _mth013A()
    {
        if ((iL & 4) != 0)
        {
            if (TextUtils.isEmpty(iQ))
            {
                iK.setNavigationContentDescription(iU);
                return;
            }
            iK.setNavigationContentDescription(iQ);
        }
    }

    private void _mth013C()
    {
        if ((iL & 4) != 0)
        {
            Toolbar toolbar = iK;
            Drawable drawable;
            if (iO != null)
            {
                drawable = iO;
            } else
            {
                drawable = iV;
            }
            toolbar.setNavigationIcon(drawable);
        }
    }

    public final void collapseActionView()
    {
        Object obj = iK;
        if (((Toolbar) (obj)).iC == null)
        {
            obj = null;
        } else
        {
            obj = ((Toolbar) (obj)).iC.iG;
        }
        if (obj != null)
        {
            ((_cls03F3) (obj)).collapseActionView();
        }
    }

    public final void dismissPopupMenus()
    {
        Toolbar toolbar = iK;
        if (toolbar._fld039B != null)
        {
            toolbar._fld039B.dismissPopupMenus();
        }
    }

    public final Context getContext()
    {
        return iK.getContext();
    }

    public final int getDisplayOptions()
    {
        return iL;
    }

    public final Menu getMenu()
    {
        Toolbar toolbar = iK;
        toolbar.FE7F();
        return toolbar._fld039B._mth1601();
    }

    public final int getNavigationMode()
    {
        return 0;
    }

    public final boolean hasExpandedActionView()
    {
        Toolbar toolbar = iK;
        return toolbar.iC != null && toolbar.iC.iG != null;
    }

    public final boolean hideOverflowMenu()
    {
        Object obj = iK;
        if (((Toolbar) (obj))._fld039B != null)
        {
            obj = ((Toolbar) (obj))._fld039B;
            boolean flag;
            if (((_cls1D3A) (obj))._fld2183 != null && ((_cls1D3A) (obj))._fld2183.hideOverflowMenu())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    public final boolean isOverflowMenuShowing()
    {
        return iK.isOverflowMenuShowing();
    }

    public final void setCollapsible(boolean flag)
    {
        iK.setCollapsible(flag);
    }

    public final void setDisplayOptions(int i)
    {
        int j = iL ^ i;
        iL = i;
        if (j != 0)
        {
            if ((j & 4) != 0)
            {
                if ((i & 4) != 0)
                {
                    _mth013C();
                    _mth013A();
                } else
                {
                    iK.setNavigationIcon(null);
                }
            }
            if ((j & 3) != 0)
            {
                _mth012D();
            }
            if ((j & 8) != 0)
            {
                if ((i & 8) != 0)
                {
                    iK.setTitle(mTitle);
                    iK.setSubtitle(_fld0578);
                } else
                {
                    iK.setTitle(null);
                    iK.setSubtitle(null);
                }
            }
            if ((j & 0x10) != 0 && _fld05E4 != null)
            {
                if ((i & 0x10) != 0)
                {
                    iK.addView(_fld05E4);
                    return;
                }
                iK.removeView(_fld05E4);
            }
        }
    }

    public final void setIcon(int i)
    {
        Drawable drawable;
        if (i != 0)
        {
            drawable = E._mth02BD(i, false);
        } else
        {
            drawable = null;
        }
        _fld0EB2 = drawable;
        _mth012D();
    }

    public final void setIcon(Drawable drawable)
    {
        _fld0EB2 = drawable;
        _mth012D();
    }

    public final void setLogo(int i)
    {
        Drawable drawable;
        if (i != 0)
        {
            drawable = E._mth02BD(i, false);
        } else
        {
            drawable = null;
        }
        iN = drawable;
        _mth012D();
    }

    public final void setMenu(Menu menu, _cls0491.if if1)
    {
        if (_fld03D9 == null)
        {
            _fld03D9 = new _cls1D10(iK.getContext());
            _fld03D9.FE7C = _cls0285.action_menu_presenter;
        }
        _fld03D9._fld14B5 = if1;
        iK.setMenu((_cls02E0)menu, _fld03D9);
    }

    public final void setMenuPrepared()
    {
        iS = true;
    }

    public final void setWindowCallback(android.view.Window.Callback callback)
    {
        iR = callback;
    }

    public final void setWindowTitle(CharSequence charsequence)
    {
        if (!iP)
        {
            mTitle = charsequence;
            if ((iL & 8) != 0)
            {
                iK.setTitle(charsequence);
            }
        }
    }

    public final boolean showOverflowMenu()
    {
        return iK.showOverflowMenu();
    }

    public final _cls1646 _mth02CA(int i, long l)
    {
        _cls1646 _lcls1646 = FE70._mth1428(iK);
        float f;
        if (i == 0)
        {
            f = 1.0F;
        } else
        {
            f = 0.0F;
        }
        return _lcls1646._mth02CE(f)._mth02CB(l)._mth02CA(new _cls14A6(this, i));
    }

    public final void _mth02CA(_cls1E5B.if if1, _cls1E5B._cls02CA _pcls02ca)
    {
        iK.setMenuCallbacks(if1, _pcls02ca);
    }

    public final void _mth02CA(FF8C ff8c)
    {
        if (iM != null && iM.getParent() == iK)
        {
            iK.removeView(iM);
        }
        iM = ff8c;
    }

    public final boolean FB60()
    {
        Toolbar toolbar = iK;
        return toolbar.getVisibility() == 0 && toolbar._fld039B != null && toolbar._fld039B._fld1546;
    }

    public final boolean FBE6()
    {
label0:
        {
            boolean flag;
label1:
            {
                Object obj = iK;
                if (((Toolbar) (obj))._fld039B == null)
                {
                    break label0;
                }
                obj = ((Toolbar) (obj))._fld039B;
                if (((_cls1D3A) (obj))._fld2183 != null)
                {
                    obj = ((_cls1D3A) (obj))._fld2183;
                    if (((_cls1D10) (obj))._fld1E38 != null || ((_cls1D10) (obj)).isOverflowMenuShowing())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        flag = true;
                        break label1;
                    }
                }
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    public final Toolbar FE92()
    {
        return iK;
    }

    public final void FE9B()
    {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final void FEA9()
    {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }
}
