// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.animation.Animation;

// Referenced classes of package o:
//            FE79, _cls1ECA, _cls1D31

final class FE7F
    implements android.view.animation.Animation.AnimationListener
{

    private FE79 _fld1E7F;

    FE7F(FE79 fe79)
    {
        _fld1E7F = fe79;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        if (FE79._mth02CA(_fld1E7F))
        {
            FE79._mth02CB(_fld1E7F).setAlpha(255);
            FE79._mth02CB(_fld1E7F).start();
            if (FE79._mth02CE(_fld1E7F) && FE79._mth02CF(_fld1E7F) != null)
            {
                FE79._mth02CF(_fld1E7F)._mth1D5B();
            }
        } else
        {
            FE79._mth02CB(_fld1E7F).stop();
            FE79._mth141D(_fld1E7F).setVisibility(8);
            FE79._mth02CA(_fld1E7F, 255);
            if (FE79._mth02BB(_fld1E7F))
            {
                FE79._mth02CA(_fld1E7F, 0.0F);
            } else
            {
                FE79._mth02CA(_fld1E7F, _fld1E7F._fld1500 - FE79._mth02BC(_fld1E7F), true);
            }
        }
        FE79._mth02CB(_fld1E7F, FE79._mth141D(_fld1E7F).getTop());
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
