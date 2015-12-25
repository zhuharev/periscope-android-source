// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.view.View;

// Referenced classes of package o:
//            aqr, aey

final class afd extends aqr
{

    private aey big;

    afd(aey aey1)
    {
        big = aey1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        aey._mth02BB(big).setVisibility(4);
        aey._mth141D(big).setVisibility(0);
    }
}
