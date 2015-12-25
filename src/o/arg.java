// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;

// Referenced classes of package o:
//            are

final class arg
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    private are bBp;

    arg(are are1)
    {
        bBp = are1;
        super();
    }

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        bBp.setAlpha(((Float)valueanimator.getAnimatedValue()).floatValue());
    }
}
