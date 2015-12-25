// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package o:
//            aqr, aft, asa

final class afu extends aqr
{

    private aft bjj;

    afu(aft aft1)
    {
        bjj = aft1;
        super();
    }

    public final void onAnimationStart(Animator animator)
    {
        if (aft._mth02CA(bjj) == 0L && _cls141D.if._mth02CB(bjj.getContext()))
        {
            aft._mth02CB(bjj);
        } else
        {
            animator = aft._mth02CF(bjj);
            byte byte0;
            if (aft._mth02CE(bjj))
            {
                byte0 = 0;
            } else
            {
                byte0 = 8;
            }
            animator.setVisibility(byte0);
        }
        aft._mth141D(bjj).setVisibility(0);
        aft._mth02BB(bjj).setVisibility(0);
        aft._mth02BC(bjj).setVisibility(0);
        bjj.setVisibility(0);
    }
}
