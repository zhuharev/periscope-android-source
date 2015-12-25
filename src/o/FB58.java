// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package o:
//            FE92, FEE8

class FB58
{

    FB58()
    {
    }

    public static void _mth02CA(View view, FEE8 fee8)
    {
        FE92 fe92 = null;
        if (fee8 != null)
        {
            fe92 = new FE92(fee8, view);
        }
        view.animate().setUpdateListener(fe92);
    }
}
