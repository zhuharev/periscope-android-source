// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;

// Referenced classes of package o:
//            aqr, acv

public final class acw extends aqr
{

    private acv bdH;

    acw(acv acv1)
    {
        bdH = acv1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        super.onAnimationEnd(animator);
        bdH.finish();
    }
}
