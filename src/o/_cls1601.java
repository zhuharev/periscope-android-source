// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package o:
//            _cls026A, _cls0433

public class _cls1601
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    private static final _cls02CA FBE7;
    private static final Object FBFF;
    final Object FE79;

    public _cls1601()
    {
        FE79 = FBE7._mth02CA(this);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        return FBE7._mth02CA(FBFF, view, accessibilityevent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        FBE7._mth02CB(FBFF, view, accessibilityevent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        FBE7._mth02CE(FBFF, view, accessibilityevent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return FBE7._mth02CA(FBFF, viewgroup, view, accessibilityevent);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        return FBE7._mth02CA(FBFF, view, i, bundle);
    }

    public void sendAccessibilityEvent(View view, int i)
    {
        FBE7._mth02CA(FBFF, view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityevent)
    {
        FBE7._mth02CF(FBFF, view, accessibilityevent);
    }

    public void _mth02CA(View view, _cls026A _pcls026a)
    {
        FBE7._mth02CA(FBFF, view, _pcls026a);
    }

    public _cls0433 _mth141D(View view)
    {
        return FBE7._mth02CB(FBFF, view);
    }

    Object FB1D()
    {
        return FE79;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            FBE7 = new _cls02CB();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            FBE7 = new if();
        } else
        {
            FBE7 = new _cls02CE();
        }
        FBFF = FBE7.FB39();
    }
}
