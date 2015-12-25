// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package o:
//            aly

final class amf
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    private View brE;
    private aly bsE;

    amf(aly aly, View view)
    {
        bsE = aly;
        brE = view;
        super();
    }

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        android.view.ViewGroup.LayoutParams layoutparams = brE.getLayoutParams();
        layoutparams.height = ((Integer)valueanimator.getAnimatedValue()).intValue();
        brE.setLayoutParams(layoutparams);
    }
}
