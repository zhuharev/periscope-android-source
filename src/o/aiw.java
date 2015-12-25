// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package o:
//            aqr, aix, ait

final class aiw extends aqr
{

    private aix bon;
    private ait boo;
    private float boq;

    aiw(ait ait, aix aix, float f)
    {
        boo = ait;
        bon = aix;
        boq = f;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        animator = new AnimatorSet();
        ArrayList arraylist = new ArrayList();
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(bon, View.SCALE_X, new float[] {
            boq, 1.0F
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(bon, View.SCALE_Y, new float[] {
            boq, 1.0F
        });
        arraylist.add(objectanimator);
        arraylist.add(objectanimator1);
        animator.setDuration(100L);
        animator.playTogether(arraylist);
        animator.start();
    }
}
