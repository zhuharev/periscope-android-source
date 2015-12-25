// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import o.026A;
import o.1484;
import o.1601;
import o.FB54;

// Referenced classes of package android.support.v4.view:
//            ViewPager

final class FB27 extends _cls1601
{

    private ViewPager FB27;

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v4/view/ViewPager.getName());
        view = _cls1484._mth02E3();
        boolean flag;
        if (ViewPager._mth02CA(FB27) != null && ViewPager._mth02CA(FB27).getCount() > 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setScrollable(flag);
        if (accessibilityevent.getEventType() == 4096 && ViewPager._mth02CA(FB27) != null)
        {
            view.setItemCount(ViewPager._mth02CA(FB27).getCount());
            view.setFromIndex(ViewPager._mth02CB(FB27));
            view.setToIndex(ViewPager._mth02CB(FB27));
        }
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        if (super.performAccessibilityAction(view, i, bundle))
        {
            return true;
        }
        switch (i)
        {
        case 4096: 
            if (FB27.canScrollHorizontally(1))
            {
                FB27.setCurrentItem(ViewPager._mth02CB(FB27) + 1);
                return true;
            } else
            {
                return false;
            }

        case 8192: 
            if (FB27.canScrollHorizontally(-1))
            {
                FB27.setCurrentItem(ViewPager._mth02CB(FB27) - 1);
                return true;
            } else
            {
                return false;
            }
        }
        return false;
    }

    public final void _mth02CA(View view, _cls026A _pcls026a)
    {
        super._mth02CA(view, _pcls026a);
        _pcls026a.setClassName(android/support/v4/view/ViewPager.getName());
        boolean flag;
        if (ViewPager._mth02CA(FB27) != null && ViewPager._mth02CA(FB27).getCount() > 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _pcls026a.setScrollable(flag);
        if (FB27.canScrollHorizontally(1))
        {
            _pcls026a.addAction(4096);
        }
        if (FB27.canScrollHorizontally(-1))
        {
            _pcls026a.addAction(8192);
        }
    }

    yEvent(ViewPager viewpager)
    {
        FB27 = viewpager;
        super();
    }
}
