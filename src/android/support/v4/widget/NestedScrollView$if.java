// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;
import o.020B;
import o.026A;
import o.1484;
import o.1601;

// Referenced classes of package android.support.v4.widget:
//            NestedScrollView

static final class  extends _cls1601
{

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        view = (NestedScrollView)view;
        accessibilityevent.setClassName(android/widget/ScrollView.getName());
        accessibilityevent = _cls020B._mth02CA(accessibilityevent);
        boolean flag;
        if (NestedScrollView._mth02CA(view) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        accessibilityevent.setScrollable(flag);
        accessibilityevent.setScrollX(view.getScrollX());
        accessibilityevent.setScrollY(view.getScrollY());
        accessibilityevent.setMaxScrollX(view.getScrollX());
        accessibilityevent.setMaxScrollY(NestedScrollView._mth02CA(view));
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        if (super.performAccessibilityAction(view, i, bundle))
        {
            return true;
        }
        view = (NestedScrollView)view;
        if (!view.isEnabled())
        {
            return false;
        }
        switch (i)
        {
        case 4096: 
            i = view.getHeight();
            int j = view.getPaddingBottom();
            int l = view.getPaddingTop();
            i = Math.min(view.getScrollY() + (i - j - l), NestedScrollView._mth02CA(view));
            if (i != view.getScrollY())
            {
                view.smoothScrollBy(0 - view.getScrollX(), i - view.getScrollY());
                return true;
            } else
            {
                return false;
            }

        case 8192: 
            i = view.getHeight();
            int k = view.getPaddingBottom();
            int i1 = view.getPaddingTop();
            i = Math.max(view.getScrollY() - (i - k - i1), 0);
            if (i != view.getScrollY())
            {
                view.smoothScrollBy(0 - view.getScrollX(), i - view.getScrollY());
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
        view = (NestedScrollView)view;
        _pcls026a.setClassName(android/widget/ScrollView.getName());
        if (view.isEnabled())
        {
            int i = NestedScrollView._mth02CA(view);
            if (i > 0)
            {
                _pcls026a.setScrollable(true);
                if (view.getScrollY() > 0)
                {
                    _pcls026a.addAction(8192);
                }
                if (view.getScrollY() < i)
                {
                    _pcls026a.addAction(4096);
                }
            }
        }
    }

    ()
    {
    }
}
