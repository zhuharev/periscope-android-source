// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.widget.ProgressBar;

// Referenced classes of package o:
//            aqr, ajc

final class ajd extends aqr
{

    private ajc boV;

    ajd(ajc ajc1)
    {
        boV = ajc1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        boV.boT.setVisibility(8);
    }
}
