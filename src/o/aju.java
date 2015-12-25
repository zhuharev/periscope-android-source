// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.widget.ImageView;

// Referenced classes of package o:
//            aqr, aka, ajk

final class aju extends aqr
{

    private ajk._cls02CA bpR;
    private aka bpS;
    private boolean bpT;

    aju(ajk._cls02CA _pcls02ca, boolean flag, aka aka1)
    {
        bpR = _pcls02ca;
        bpT = flag;
        bpS = aka1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        bpR.bpQ = bpS.cD();
        if (bpT)
        {
            ajk._mth02BD(bpR.bpC).setVisibility(4);
        }
    }

    public final void onAnimationStart(Animator animator)
    {
        if (!bpT)
        {
            ajk._mth02BD(bpR.bpC).setVisibility(0);
            ajk._mth02BD(bpR.bpC).setImageResource(bpS.cD());
        }
    }
}
