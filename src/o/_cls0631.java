// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

// Referenced classes of package o:
//            _cls05DB, _cls1D5B

public final class _cls0631 extends _cls05DB
    implements SubMenu
{

    public _cls0631(Context context, _cls1D5B _pcls1d5b)
    {
        super(context, _pcls1d5b);
    }

    public final void clearHeader()
    {
        ((_cls1D5B)_fld15A8).clearHeader();
    }

    public final MenuItem getItem()
    {
        return _mth141D(((_cls1D5B)_fld15A8).getItem());
    }

    public final SubMenu setHeaderIcon(int i)
    {
        ((_cls1D5B)_fld15A8).setHeaderIcon(i);
        return this;
    }

    public final SubMenu setHeaderIcon(Drawable drawable)
    {
        ((_cls1D5B)_fld15A8).setHeaderIcon(drawable);
        return this;
    }

    public final SubMenu setHeaderTitle(int i)
    {
        ((_cls1D5B)_fld15A8).setHeaderTitle(i);
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charsequence)
    {
        ((_cls1D5B)_fld15A8).setHeaderTitle(charsequence);
        return this;
    }

    public final SubMenu setHeaderView(View view)
    {
        ((_cls1D5B)_fld15A8).setHeaderView(view);
        return this;
    }

    public final SubMenu setIcon(int i)
    {
        ((_cls1D5B)_fld15A8).setIcon(i);
        return this;
    }

    public final SubMenu setIcon(Drawable drawable)
    {
        ((_cls1D5B)_fld15A8).setIcon(drawable);
        return this;
    }
}
