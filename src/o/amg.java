// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.view.View;

// Referenced classes of package o:
//            aqr, aly

final class amg extends aqr
{

    private View brE;
    private View brF;
    private aly bsE;

    amg(aly aly, View view, View view1)
    {
        bsE = aly;
        brE = view;
        brF = view1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        brE.setVisibility(4);
        brF.setBackgroundResource(0x7f020065);
    }
}
