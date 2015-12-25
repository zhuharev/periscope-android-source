// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.view.View;

// Referenced classes of package o:
//            aqr, aky

final class ala extends aqr
{

    private aky brD;
    private View brE;
    private View brF;

    ala(aky aky, View view, View view1)
    {
        brD = aky;
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
