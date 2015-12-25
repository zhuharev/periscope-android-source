// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package o:
//            aip, aiu, aiw, aix

public final class ait extends aip
{

    final AtomicInteger bod = new AtomicInteger(0);
    final Handler mHandler = new Handler(Looper.getMainLooper());

    public ait(Context context)
    {
        super(context);
    }

    public final void _mth02CA(aix aix, RelativeLayout relativelayout, boolean flag)
    {
        relativelayout.addView(aix);
        Object obj = _mth02CA(bod, aix, ((ViewGroup) (relativelayout)), 1);
        float f = super.bnU.nextFloat();
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(aix, View.ROTATION, new float[] {
            0.0F, f * 28.6F - 14.3F
        });
        objectanimator.setDuration(3000L);
        obj = ObjectAnimator.ofFloat(aix, View.X, View.Y, ((android.graphics.Path) (obj)));
        ((ObjectAnimator) (obj)).setDuration(3000L);
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(aix, View.ALPHA, new float[] {
            1.0F, 0.0F
        });
        objectanimator1.setDuration(3000L);
        objectanimator1.addListener(new aiu(this, relativelayout, aix));
        if (flag)
        {
            f = 1.4F;
        } else
        {
            f = 1.1F;
        }
        relativelayout = ObjectAnimator.ofFloat(aix, View.SCALE_X, new float[] {
            0.2F, f
        });
        relativelayout.addListener(new aiw(this, aix, f));
        AnimatorSet animatorset = new AnimatorSet();
        ArrayList arraylist = new ArrayList();
        aix = ObjectAnimator.ofFloat(aix, View.SCALE_Y, new float[] {
            0.2F, f
        });
        arraylist.add(relativelayout);
        arraylist.add(aix);
        animatorset.setDuration(200L);
        animatorset.playTogether(arraylist);
        animatorset.start();
        aix = new AnimatorSet();
        relativelayout = new ArrayList();
        relativelayout.add(obj);
        relativelayout.add(objectanimator1);
        relativelayout.add(objectanimator);
        aix.setInterpolator(new LinearInterpolator());
        aix.playTogether(relativelayout);
        aix.start();
    }
}
