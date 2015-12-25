// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

// Referenced classes of package o:
//            aqr, agl, ask

final class agn extends aqr
{

    private agl bkd;

    agn(agl agl1)
    {
        bkd = agl1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        animator = bkd.bjP;
        ((ask) (animator)).bCU.requestFocus();
        animator = ((ask) (animator)).bCU;
        if (animator != null)
        {
            ((InputMethodManager)animator.getContext().getSystemService("input_method")).showSoftInput(animator, 1);
        }
    }

    public final void onAnimationStart(Animator animator)
    {
        bkd.bjP.setVisibility(0);
        bkd.bjR.getViewTreeObserver().addOnGlobalLayoutListener(bkd.bkc);
    }
}
