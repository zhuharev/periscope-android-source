// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

// Referenced classes of package o:
//            atu, ahm, ahu, ahv

public class aht extends android.support.v7.widget.RecyclerView._cls02CC
{
    static final class if
        implements Runnable
    {

        View bmc;
        ahm bmd;
        ValueAnimator bme;
        boolean bmf;
        boolean bmg;

        public final boolean cq()
        {
            if (!bmg && bme != null && !bme.isStarted())
            {
                bme.start();
                bmg = true;
                return true;
            } else
            {
                return false;
            }
        }

        public final void run()
        {
            cq();
        }

        ValueAnimator _mth02CA(View view, ahm ahm1)
        {
            ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
                ahm1.blR, 0.0F
            });
            valueanimator.setDuration(ahm1.blS);
            valueanimator.setInterpolator(new DecelerateInterpolator());
            valueanimator.addUpdateListener(new ahu(this, ahm1, view));
            valueanimator.addListener(new ahv(this));
            return valueanimator;
        }

        if(View view, ahm ahm1)
        {
            bmc = view;
            bmd = ahm1;
            bme = _mth02CA(view, ahm1);
        }
    }


    public atu bmb;

    public aht(View view)
    {
        super(view);
    }
}
