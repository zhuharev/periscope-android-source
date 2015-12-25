// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package o:
//            _cls217C, FE9B

class _cls1D4F
{

    _cls1D4F()
    {
    }

    public static void _mth02CA(View view, FE9B fe9b)
    {
        if (fe9b != null)
        {
            view.animate().setListener(new _cls217C(fe9b, view));
            return;
        } else
        {
            view.animate().setListener(null);
            return;
        }
    }
}
