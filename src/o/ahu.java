// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package o:
//            ahm

final class ahu
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    private ahm bmh;
    private View bmi;
    private aht.if bmj;

    ahu(aht.if if1, ahm ahm1, View view)
    {
        bmj = if1;
        bmh = ahm1;
        bmi = view;
        super();
    }

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        bmh.blS = (long)(4500F * f);
        bmh.blR = f;
        bmi.setAlpha(f);
    }
}
