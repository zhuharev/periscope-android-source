// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v4.view.ViewPager;

public final class _cls1425
    implements Runnable
{

    private ViewPager FB27;

    public _cls1425(ViewPager viewpager)
    {
        FB27 = viewpager;
        super();
    }

    public final void run()
    {
        ViewPager._mth02CB(FB27, 0);
        ViewPager viewpager = FB27;
        viewpager._mth02CC(viewpager._fld025F);
    }
}
