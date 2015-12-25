// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.animation.Animation;
import android.widget.TextView;

// Referenced classes of package o:
//            aqf, xf

final class aqm
    implements android.view.animation.Animation.AnimationListener
{

    private aqf bAJ;

    aqm(aqf aqf1)
    {
        bAJ = aqf1;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
        aqf._mth02BD(bAJ).setVisibility(0);
        xf._mth02CA(xf.if.aSM);
    }
}
