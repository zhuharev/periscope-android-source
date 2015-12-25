// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

final class FB35 extends android.view.View.AccessibilityDelegate
{

    final _cls1D67.if FEF4;

    FB35(_cls1D67.if if1)
    {
        FEF4 = if1;
        super();
    }

    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        return FEF4.dispatchPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        FEF4.onInitializeAccessibilityEvent(view, accessibilityevent);
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilitynodeinfo)
    {
        FEF4._mth02CA(view, accessibilitynodeinfo);
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        FEF4.onPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return FEF4.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
    }

    public final void sendAccessibilityEvent(View view, int i)
    {
        FEF4.sendAccessibilityEvent(view, i);
    }

    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityevent)
    {
        FEF4.sendAccessibilityEventUnchecked(view, accessibilityevent);
    }
}
