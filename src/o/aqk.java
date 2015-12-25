// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.widget.ImageView;
import java.util.Map;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            aqr, aqf, adc, aui, 
//            zp

final class aqk extends aqr
{

    private aqf bAJ;

    aqk(aqf aqf1)
    {
        bAJ = aqf1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        aqf._mth02CA(bAJ, false);
        aqf._mth02CB(bAJ, false);
        bAJ.setVisibility(8);
        if (aqf._mth02CB(bAJ))
        {
            aqf._mth02CE(bAJ);
        }
        if (aqf._mth02CF(bAJ) != null)
        {
            if (aui._mth02BF(aqf._mth02CF(bAJ).id))
            {
                animator = bAJ;
                ((aqf) (animator)).bAl.setImageDrawable(null);
                animator.aWS = null;
                animator._mth1D4F("-1");
                animator = bAJ;
                zp zp1 = aqf._mth141D(bAJ);
                String s = aqf._mth02CF(bAJ).id;
                animator._mth02CF((PsUser)zp1.aWM.get(s));
            }
            aqf._mth02CA(bAJ, null);
            bAJ.show();
        }
    }

    public final void onAnimationStart(Animator animator)
    {
        aqf._mth02CA(bAJ, true);
    }
}
