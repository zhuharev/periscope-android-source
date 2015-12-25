// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

// Referenced classes of package o:
//            aqr, agl, ask

final class agm extends aqr
{

    private agl bkd;

    agm(agl agl1)
    {
        bkd = agl1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        animator = bkd.bjP;
        android.widget.EditText edittext = ((ask) (animator)).bCU;
        if (edittext != null)
        {
            ((InputMethodManager)edittext.getContext().getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
        }
        ((ask) (animator)).bCV.setImageDrawable(null);
        bkd.bjP.setVisibility(8);
        bkd.bjX = false;
        bkd.bjR.getViewTreeObserver().removeOnGlobalLayoutListener(bkd.bkc);
    }
}
