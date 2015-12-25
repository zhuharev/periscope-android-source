// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.MenuItem;
import android.view.View;

class _cls14EA
{

    _cls14EA()
    {
    }

    public static MenuItem _mth02CA(MenuItem menuitem, View view)
    {
        return menuitem.setActionView(view);
    }

    public static View _mth02CA(MenuItem menuitem)
    {
        return menuitem.getActionView();
    }

    public static void _mth02CA(MenuItem menuitem, int i)
    {
        menuitem.setShowAsAction(i);
    }

    public static MenuItem _mth02CB(MenuItem menuitem, int i)
    {
        return menuitem.setActionView(i);
    }
}
