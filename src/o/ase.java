// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;

// Referenced classes of package o:
//            aqr, asd

final class ase extends aqr
{

    private asd bCF;

    ase(asd asd1)
    {
        bCF = asd1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        asd._mth02CA(bCF, false);
    }

    public final void onAnimationStart(Animator animator)
    {
        bCF.setVisibility(0);
        asd._mth02CA(bCF, true);
        asd._mth02CB(bCF, true);
    }
}
