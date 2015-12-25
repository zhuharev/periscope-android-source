// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

// Referenced classes of package o:
//            ajy, ajk

final class ajz
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    private ajy bpW;

    ajz(ajy ajy1)
    {
        bpW = ajy1;
        super();
    }

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        if (valueanimator.getAnimatedFraction() >= 0.25F && !bpW.bpV.isStarted())
        {
            ajk._mth1FBE(bpW.bpR.bpC).setVisibility(0);
            AnimatorSet animatorset = bpW.bpV;
            valueanimator = bpW.bpR.bpC;
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                valueanimator = AnimationUtils.loadInterpolator(valueanimator, 0x10c000e);
            } else
            {
                valueanimator = AnimationUtils.loadInterpolator(valueanimator, 0x10c0003);
            }
            animatorset.setInterpolator(valueanimator);
            bpW.bpV.start();
        }
    }
}
