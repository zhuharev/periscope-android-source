// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class _cls0E08
    implements _cls1D3A._cls02CF
{

    private Toolbar iF;

    public _cls0E08()
    {
    }

    public _cls0E08(Toolbar toolbar)
    {
        iF = toolbar;
        super();
    }

    public final boolean onMenuItemClick(MenuItem menuitem)
    {
        if (Toolbar._mth02CA(iF) != null)
        {
            return Toolbar._mth02CA(iF).onMenuItemClick(menuitem);
        } else
        {
            return false;
        }
    }
}
