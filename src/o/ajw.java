// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package o:
//            ajk, aap

final class ajw
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    private ajk._cls02CA bpR;

    ajw(ajk._cls02CA _pcls02ca)
    {
        bpR = _pcls02ca;
        super();
    }

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = valueanimator.getAnimatedFraction();
        ajk._mth037A(bpR.bpC).setBackgroundColor(bpR.bpO._mth1428(f));
        ajk._mth02CA(bpR.bpC, bpR.bpN._mth1428(f));
    }
}
