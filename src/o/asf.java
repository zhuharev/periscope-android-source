// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;

// Referenced classes of package o:
//            aqr, asd

final class asf extends aqr
{

    private asd bCF;

    asf(asd asd1)
    {
        bCF = asd1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        asd._mth02CA(bCF, false);
        asd._mth02CB(bCF, false);
        bCF.setVisibility(8);
    }

    public final void onAnimationStart(Animator animator)
    {
        asd._mth02CA(bCF, true);
    }
}
