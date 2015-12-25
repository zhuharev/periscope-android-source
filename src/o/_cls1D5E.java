// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package o:
//            _cls1601, _cls0433, _cls026A

class _cls1D5E
    implements FB4B.if
{

    final _cls1601 FE7F;
    final _cls1601._cls02CB FEAB;

    _cls1D5E(_cls1601._cls02CB _pcls02cb, _cls1601 _pcls1601)
    {
        FEAB = _pcls02cb;
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

    public boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        return FE7F.performAccessibilityAction(view, i, bundle);
    }

    public void sendAccessibilityEvent(View view, int i)
    {
        FE7F.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityevent)
    {
        FE7F.sendAccessibilityEventUnchecked(view, accessibilityevent);
    }

    public Object _mth02BB(View view)
    {
        view = FE7F._mth141D(view);
        if (view != null)
        {
            return view._mth02D0();
        } else
        {
            return null;
        }
    }

    public void _mth02CA(View view, Object obj)
    {
        FE7F._mth02CA(view, new _cls026A(obj));
    }
}
