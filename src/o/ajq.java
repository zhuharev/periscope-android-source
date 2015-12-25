// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.widget.ImageView;

// Referenced classes of package o:
//            aqr, ajk, aka

final class ajq extends aqr
{

    private ajk._cls02CA bpR;
    private aka bpS;

    ajq(ajk._cls02CA _pcls02ca, aka aka1)
    {
        bpR = _pcls02ca;
        bpS = aka1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        ajk._mth1FBE(bpR.bpC).setVisibility(0);
        bpR.bpP = bpS.cA();
    }
}
