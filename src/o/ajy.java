// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package o:
//            aqr, ajk, aka, ajz

final class ajy extends aqr
{

    final ajk._cls02CA bpR;
    private aka bpS;
    private ObjectAnimator bpU;
    final AnimatorSet bpV;

    ajy(ajk._cls02CA _pcls02ca, aka aka1, ObjectAnimator objectanimator, AnimatorSet animatorset)
    {
        bpR = _pcls02ca;
        bpS = aka1;
        bpU = objectanimator;
        bpV = animatorset;
        super();
    }

    public final void onAnimationRepeat(Animator animator)
    {
        ajk._mth1FBE(bpR.bpC).setVisibility(4);
        ajk._mth1FBE(bpR.bpC).setImageResource(bpS.cB());
        if (bpS.cC() == 0)
        {
            ajk._mth1FBE(bpR.bpC).setColorFilter(null);
        } else
        {
            ajk._mth1FBE(bpR.bpC).setColorFilter(bpS.cC());
        }
        ajk._mth02BC(bpR.bpC).setBackgroundResource(bpS.cA());
        bpU.addUpdateListener(new ajz(this));
    }
}
