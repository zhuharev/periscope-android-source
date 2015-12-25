// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package o:
//            aqr, ans

final class ant extends aqr
{

    private ans buK;

    ant(ans ans1)
    {
        buK = ans1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        ans._mth02CA(buK, false);
    }

    public final void onAnimationStart(Animator animator)
    {
        animator = ans._mth02CA(buK);
        if (animator != null)
        {
            ((InputMethodManager)animator.getContext().getSystemService("input_method")).hideSoftInputFromWindow(animator.getWindowToken(), 0);
        }
        buK.setVisibility(0);
        ans._mth02CA(buK, true);
        ans._mth02CB(buK, true);
    }
}
