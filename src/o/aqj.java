// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;

// Referenced classes of package o:
//            aqr, aqf

final class aqj extends aqr
{

    private aqf bAJ;

    aqj(aqf aqf1)
    {
        bAJ = aqf1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        aqf._mth02CA(bAJ, false);
        if (aqf._mth02CA(bAJ))
        {
            aqf._mth02CE(bAJ, false);
            bAJ._mth02CB(null);
        }
    }

    public final void onAnimationStart(Animator animator)
    {
        bAJ.setVisibility(0);
        aqf._mth02CA(bAJ, true);
        aqf._mth02CB(bAJ, true);
    }
}
