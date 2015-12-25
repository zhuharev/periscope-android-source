// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package o:
//            aky

final class alg
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    private aky brD;
    private View brE;

    alg(aky aky, View view)
    {
        brD = aky;
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
