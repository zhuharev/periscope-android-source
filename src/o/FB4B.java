// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import android.view.View;

// Referenced classes of package o:
//            FE72

class FB4B
{
    /* member class not found */
    class if {}


    FB4B()
    {
    }

    public static Object _mth02CA(if if1)
    {
        return new FE72(if1);
    }

    public static boolean _mth02CA(Object obj, View view, int i, Bundle bundle)
    {
        return ((android.view.View.AccessibilityDelegate)obj).performAccessibilityAction(view, i, bundle);
    }

    public static Object _mth02CE(Object obj, View view)
    {
        return ((android.view.View.AccessibilityDelegate)obj).getAccessibilityNodeProvider(view);
    }
}
