// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.widget.ImageView;

// Referenced classes of package o:
//            apx

final class apz
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    private apx bzF;

    apz(apx apx1)
    {
        bzF = apx1;
        super();
    }

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        apx._mth02CB(bzF).setColorFilter(((Integer)valueanimator.getAnimatedValue()).intValue());
    }
}
