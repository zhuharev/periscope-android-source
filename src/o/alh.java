// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.view.View;

// Referenced classes of package o:
//            aqr, aky

final class alh extends aqr
{

    private aky brD;
    private View brF;

    alh(aky aky, View view)
    {
        brD = aky;
        brF = view;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        brF.setBackground(null);
    }
}
