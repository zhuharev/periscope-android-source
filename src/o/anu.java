// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;

// Referenced classes of package o:
//            aqr, ans

final class anu extends aqr
{

    private ans buK;

    anu(ans ans1)
    {
        buK = ans1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        ans._mth02CA(buK, false);
        ans._mth02CB(buK, false);
        buK.setVisibility(8);
    }

    public final void onAnimationStart(Animator animator)
    {
        ans._mth02CA(buK, true);
    }
}
