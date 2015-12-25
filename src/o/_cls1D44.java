// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package o:
//            _cls1601, _cls026A

class _cls1D44
    implements _cls1D67.if
{

    final _cls1601 FE7F;
    final _cls1601.if FE98;

    _cls1D44(_cls1601.if if1, _cls1601 _pcls1601)
    {
        FE98 = if1;
        FE7F = _pcls1601;
        super();
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        return FE7F.dispatchPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        FE7F.onInitializeAccessibilityEvent(view, accessibilityevent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        FE7F.onPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return FE7F.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
    }

    public void sendAccessibilityEvent(View view, int i)
    {
        FE7F.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityevent)
    {
        FE7F.sendAccessibilityEventUnchecked(view, accessibilityevent);
    }

    public void _mth02CA(View view, Object obj)
    {
        FE7F._mth02CA(view, new _cls026A(obj));
    }
}
