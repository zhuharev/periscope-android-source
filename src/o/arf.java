// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.graphics.drawable.BitmapDrawable;

// Referenced classes of package o:
//            are

final class arf
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    private are bBp;

    arf(are are1)
    {
        bBp = are1;
        super();
    }

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        are._mth02CA(bBp, valueanimator.getAnimatedFraction() * (float)are._mth02CA(bBp).getIntrinsicWidth());
        if (!are._mth02CB(bBp))
        {
            if (valueanimator.getCurrentPlayTime() < 300L)
            {
                float f = (float)((((double)valueanimator.getCurrentPlayTime() - 0.0D) / 300D) * 1.0D + 0.0D);
                bBp.setAlpha(f);
            } else
            {
                are._mth02CA(bBp, true);
            }
        }
        bBp.invalidate();
    }
}
