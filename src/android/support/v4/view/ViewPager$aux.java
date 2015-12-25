// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.database.DataSetObserver;

// Referenced classes of package android.support.v4.view:
//            ViewPager

final class <init> extends DataSetObserver
{

    private ViewPager FB27;

    public final void onChanged()
    {
        FB27._mth15EE();
    }

    public final void onInvalidated()
    {
        FB27._mth15EE();
    }

    private (ViewPager viewpager)
    {
        FB27 = viewpager;
        super();
    }

    >(ViewPager viewpager, byte byte0)
    {
        this(viewpager);
    }
}
