// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

// Referenced classes of package o:
//            _cls02E0, _cls1D38, _cls03F3

public final class _cls0621 extends _cls02E0
    implements SubMenu
{

    public _cls02E0 _fld0232;
    private _cls03F3 _fld029C;

    public _cls0621(Context context, _cls02E0 _pcls02e0, _cls03F3 _pcls03f3)
    {
        super(context);
        _fld0232 = _pcls02e0;
        _fld029C = _pcls03f3;
    }

    public final MenuItem getItem()
    {
        return _fld029C;
    }

    public final SubMenu setHeaderIcon(int i)
    {
        super._mth02CA(0, null, 0, _cls1D38._mth02CB(super.mContext, i), null);
        return this;
    }

    public final SubMenu setHeaderIcon(Drawable drawable)
    {
        super._mth02CA(0, null, 0, drawable, null);
        return this;
    }

    public final SubMenu setHeaderTitle(int i)
    {
        super._mth02CA(0, super.mContext.getResources().getString(i), 0, null, null);
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charsequence)
    {
        super._mth02CA(0, charsequence, 0, null, null);
        return this;
    }

    public final SubMenu setHeaderView(View view)
    {
        super._mth02CA(0, null, 0, null, view);
        return this;
    }

    public final SubMenu setIcon(int i)
    {
        _fld029C.setIcon(i);
        return this;
    }

    public final SubMenu setIcon(Drawable drawable)
    {
        _fld029C.setIcon(drawable);
        return this;
    }

    public final void setQwertyMode(boolean flag)
    {
        _fld0232.setQwertyMode(flag);
    }

    public final boolean _mth02BB(_cls03F3 _pcls03f3)
    {
        return _fld0232._mth02BB(_pcls03f3);
    }

    public final void _mth02CA(_cls02E0.if if1)
    {
        _fld0232._mth02CA(if1);
    }

    final boolean _mth02CB(_cls02E0 _pcls02e0, MenuItem menuitem)
    {
        return super._mth02CB(_pcls02e0, menuitem) || _fld0232._mth02CB(_pcls02e0, menuitem);
    }

    public final boolean _mth141D(_cls03F3 _pcls03f3)
    {
        return _fld0232._mth141D(_pcls03f3);
    }

    public final String _mth1466()
    {
        int i;
        if (_fld029C != null)
        {
            i = _fld029C.getItemId();
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(super._mth1466()).append(":").append(i).toString();
        }
    }

    public final boolean _mth14BE()
    {
        return _fld0232._mth14BE();
    }

    public final boolean _mth14EA()
    {
        return _fld0232._mth14EA();
    }

    public final _cls02E0 _mth155D()
    {
        return _fld0232;
    }
}
