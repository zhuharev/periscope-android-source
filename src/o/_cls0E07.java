// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class _cls0E07 extends AccessibilityNodeProvider
{

    final _cls0719.if _fld0694;

    _cls0E07(_cls0719.if if1)
    {
        _fld0694 = if1;
        super();
    }

    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i)
    {
        return (AccessibilityNodeInfo)_fld0694._mth02B9(i);
    }

    public final List findAccessibilityNodeInfosByText(String s, int i)
    {
        return _fld0694.findAccessibilityNodeInfosByText(s, i);
    }

    public final boolean performAction(int i, int j, Bundle bundle)
    {
        return _fld0694.performAction(i, j, bundle);
    }
}
