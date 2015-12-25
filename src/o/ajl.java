// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AnimationUtils;
import java.util.List;

// Referenced classes of package o:
//            ajk, aka, ajr, ajt, 
//            ajs

final class ajl
    implements ajk.if
{

    private ajk bpC;

    ajl(ajk ajk1)
    {
        bpC = ajk1;
        super();
    }

    public final void cU()
    {
        int i = ajk._mth02CE(bpC)._fld025F;
        ajk._cls02CA _lcls02ca = ajk._mth02CF(bpC);
        aka aka1 = (aka)ajk._mth02BB(_lcls02ca.bpC).get(i);
        if (_lcls02ca.bpI == null)
        {
            int j = aka1.cA();
            boolean flag;
            if (_lcls02ca.bpP != j || ajk._mth02BC(_lcls02ca.bpC).getVisibility() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                _lcls02ca.bpI = _lcls02ca._mth02CF(aka1);
                _lcls02ca.bpI.addListener(new ajr(_lcls02ca));
                _lcls02ca.bpI.start();
            }
        }
    }

    public final void cV()
    {
        ajk._cls02CA _lcls02ca = ajk._mth02CF(bpC);
        if (_lcls02ca.bpJ == null)
        {
            Object obj = ObjectAnimator.ofFloat(ajk._mth02BC(_lcls02ca.bpC), View.SCALE_X, new float[] {
                0.0F, 1.0F
            }).setDuration(100L);
            Object obj1 = ObjectAnimator.ofFloat(ajk._mth02BC(_lcls02ca.bpC), View.SCALE_Y, new float[] {
                0.0F, 1.0F
            }).setDuration(100L);
            _lcls02ca.bpJ = new AnimatorSet();
            _lcls02ca.bpJ.play(((Animator) (obj))).with(((Animator) (obj1)));
            obj1 = _lcls02ca.bpJ;
            obj = _lcls02ca.bpC;
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                obj = AnimationUtils.loadInterpolator(((android.content.Context) (obj)), 0x10c000e);
            } else
            {
                obj = AnimationUtils.loadInterpolator(((android.content.Context) (obj)), 0x10c0003);
            }
            ((AnimatorSet) (obj1)).setInterpolator(((android.animation.TimeInterpolator) (obj)));
            _lcls02ca.bpJ.addListener(new ajt(_lcls02ca));
        }
        _lcls02ca.bpJ.start();
    }

    public final void cW()
    {
        ajk._cls02CA _lcls02ca = ajk._mth02CF(bpC);
        if (_lcls02ca.bpK == null)
        {
            Object obj = ObjectAnimator.ofFloat(ajk._mth02BC(_lcls02ca.bpC), View.SCALE_X, new float[] {
                1.0F, 0.0F
            }).setDuration(100L);
            Object obj1 = ObjectAnimator.ofFloat(ajk._mth02BC(_lcls02ca.bpC), View.SCALE_Y, new float[] {
                1.0F, 0.0F
            }).setDuration(100L);
            _lcls02ca.bpK = new AnimatorSet();
            _lcls02ca.bpK.play(((Animator) (obj))).with(((Animator) (obj1)));
            obj1 = _lcls02ca.bpK;
            obj = _lcls02ca.bpC;
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                obj = AnimationUtils.loadInterpolator(((android.content.Context) (obj)), 0x10c000d);
            } else
            {
                obj = AnimationUtils.loadInterpolator(((android.content.Context) (obj)), 0x10c0006);
            }
            ((AnimatorSet) (obj1)).setInterpolator(((android.animation.TimeInterpolator) (obj)));
            _lcls02ca.bpK.addListener(new ajs(_lcls02ca));
        }
        _lcls02ca.bpK.start();
    }
}
