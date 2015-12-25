// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.view.View;

// Referenced classes of package o:
//            aqr, aed

final class aeg extends aqr
{

    private aed bhH;
    private View bhJ;

    aeg(aed aed, View view)
    {
        bhH = aed;
        bhJ = view;
        super();
    }

    public final void onAnimationStart(Animator animator)
    {
        bhJ.setVisibility(0);
    }
}
