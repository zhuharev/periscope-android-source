// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;

// Referenced classes of package o:
//            aqr, aka

final class ajx extends aqr
{

    private ajk._cls02CA bpR;
    private aka bpS;

    ajx(ajk._cls02CA _pcls02ca, aka aka)
    {
        bpR = _pcls02ca;
        bpS = aka;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        bpR._mth02BB(bpS);
        bpR.bpO = null;
        bpR.bpN = null;
    }
}
