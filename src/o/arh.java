// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.animation.ValueAnimator;

// Referenced classes of package o:
//            aqr, are

final class arh extends aqr
{

    private are bBp;

    arh(are are1)
    {
        bBp = are1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        bBp.clearAnimation();
        are._mth02CF(bBp).removeUpdateListener(are._mth02CE(bBp));
        bBp.setVisibility(8);
        bBp.FE7B = false;
    }
}
