// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.view.View;

// Referenced classes of package o:
//            aqr, aly

final class ame extends aqr
{

    private View brF;
    private aly bsE;

    ame(aly aly, View view)
    {
        bsE = aly;
        brF = view;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        brF.setBackground(null);
    }
}
