// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package o:
//            aqr, aft, asa

final class afv extends aqr
{

    private aft bjj;

    afv(aft aft1)
    {
        bjj = aft1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        bjj.setVisibility(8);
    }

    public final void onAnimationStart(Animator animator)
    {
        aft._mth02CF(bjj).setVisibility(4);
        aft._mth141D(bjj).setVisibility(4);
        aft._mth02BB(bjj).setVisibility(4);
        aft._mth02BC(bjj).setVisibility(4);
    }
}
