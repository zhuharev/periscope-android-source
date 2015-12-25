// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

// Referenced classes of package o:
//            _cls14D2

public class _cls1D64
{

    public static final int abc_action_bar_embed_tabs = 0x7f080003;
    public static final int abc_action_bar_embed_tabs_pre_jb = 0x7f080001;
    public static final int abc_config_allowActionMenuItemTextWithIcon = 0x7f080002;
    public static final int abc_config_showMenuShortcutsWhenKeyboardPresent = 0x7f080007;
    public final View mView;
    public ViewParent _fld1E59;
    public boolean _fld1E5B;
    private int _fld1EC9[];

    public _cls1D64()
    {
    }

    public _cls1D64(ViewGroup viewgroup)
    {
        mView = viewgroup;
    }

    public final boolean dispatchNestedFling(float f, float f1, boolean flag)
    {
        if (_fld1E5B && _fld1E59 != null)
        {
            return _cls14D2._mth02CA(_fld1E59, mView, f, f1, flag);
        } else
        {
            return false;
        }
    }

    public final boolean dispatchNestedPreScroll(int i, int j, int ai[], int ai1[])
    {
        if (_fld1E5B && _fld1E59 != null)
        {
            if (i != 0 || j != 0)
            {
                int k = 0;
                int l = 0;
                if (ai1 != null)
                {
                    mView.getLocationInWindow(ai1);
                    k = ai1[0];
                    l = ai1[1];
                }
                int ai2[] = ai;
                if (ai == null)
                {
                    if (_fld1EC9 == null)
                    {
                        _fld1EC9 = new int[2];
                    }
                    ai2 = _fld1EC9;
                }
                ai2[0] = 0;
                ai2[1] = 0;
                _cls14D2._mth02CA(_fld1E59, mView, i, j, ai2);
                if (ai1 != null)
                {
                    mView.getLocationInWindow(ai1);
                    ai1[0] = ai1[0] - k;
                    ai1[1] = ai1[1] - l;
                }
                return ai2[0] != 0 || ai2[1] != 0;
            }
            if (ai1 != null)
            {
                ai1[0] = 0;
                ai1[1] = 0;
            }
        }
        return false;
    }

    public final boolean dispatchNestedScroll(int i, int j, int k, int l, int ai[])
    {
        if (_fld1E5B && _fld1E59 != null)
        {
            if (i != 0 || j != 0 || k != 0 || l != 0)
            {
                int i1 = 0;
                int j1 = 0;
                if (ai != null)
                {
                    mView.getLocationInWindow(ai);
                    i1 = ai[0];
                    j1 = ai[1];
                }
                _cls14D2._mth02CA(_fld1E59, mView, i, j, k, l);
                if (ai != null)
                {
                    mView.getLocationInWindow(ai);
                    ai[0] = ai[0] - i1;
                    ai[1] = ai[1] - j1;
                }
                return true;
            }
            if (ai != null)
            {
                ai[0] = 0;
                ai[1] = 0;
            }
        }
        return false;
    }

    public final boolean startNestedScroll(int i)
    {
        boolean flag;
        if (_fld1E59 != null)
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
        if (_fld1E5B)
        {
            ViewParent viewparent = mView.getParent();
            View view = mView;
            for (; viewparent != null; viewparent = viewparent.getParent())
            {
                if (_cls14D2._mth02CA(viewparent, view, mView, i))
                {
                    _fld1E59 = viewparent;
                    _cls14D2._mth02CB(viewparent, view, mView, i);
                    return true;
                }
                if (viewparent instanceof View)
                {
                    view = (View)viewparent;
                }
            }

        }
        return false;
    }
}
