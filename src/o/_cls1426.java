// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class _cls1426 extends AccessibilityNodeProvider
{

    final _cls0E27.if _fld0716;

    _cls1426(_cls0E27.if if1)
    {
        _fld0716 = if1;
        super();
    }

    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i)
    {
        return (AccessibilityNodeInfo)_fld0716._mth02B9(i);
    }

    public final List findAccessibilityNodeInfosByText(String s, int i)
    {
        return _fld0716.findAccessibilityNodeInfosByText(s, i);
    }

    public final AccessibilityNodeInfo findFocus(int i)
    {
        return (AccessibilityNodeInfo)_fld0716._mth0559(i);
    }

    public final boolean performAction(int i, int j, Bundle bundle)
    {
        return _fld0716.performAction(i, j, bundle);
    }
}
