// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package o:
//            aip, air, aix

public final class aiq extends aip
{
    static final class if extends Animation
    {

        private PathMeasure boi;
        private View boj;
        private float bok;
        private float bol;
        private float bom;

        protected final void applyTransformation(float f, Transformation transformation)
        {
            android.graphics.Matrix matrix = transformation.getMatrix();
            boi.getMatrix(bok * f, matrix, 1);
            boj.setRotation(bol * f);
            if (3000F * f < 200F)
            {
                double d = f;
                double d2 = bom;
                d = 0.20000000298023224D + ((d - 0.0D) / 0.066666670143604279D) * (d2 - 0.20000000298023224D);
                boj.setScaleX((float)d);
                boj.setScaleY((float)d);
            } else
            if (3000F * f < 300F)
            {
                double d1 = f;
                double d3 = bom;
                d1 = d3 + ((d1 - 0.066666670143604279D) / 0.033333331346511841D) * (1.0D - d3);
                boj.setScaleX((float)d1);
                boj.setScaleY((float)d1);
            } else
            {
                boj.setScaleX(1.0F);
                boj.setScaleY(1.0F);
            }
            transformation.setAlpha(1.0F - f);
        }

        public if(Path path, float f, ViewGroup viewgroup, aix aix1, float f1)
        {
            boi = new PathMeasure(path, false);
            bok = boi.getLength();
            boj = aix1;
            bol = f;
            bom = f1;
            viewgroup.setLayerType(2, null);
        }
    }


    private final int bob;
    private final int boc;
    final AtomicInteger bod = new AtomicInteger(0);
    Handler mHandler;

    public aiq(Context context)
    {
        super(context);
        context = context.getResources();
        bob = context.getDimensionPixelSize(0x7f090081);
        boc = context.getDimensionPixelSize(0x7f090080);
        mHandler = new Handler(Looper.getMainLooper());
    }

    public final void _mth02CA(aix aix1, RelativeLayout relativelayout, boolean flag)
    {
        relativelayout.addView(aix1, new android.view.ViewGroup.LayoutParams(bob, boc));
        Object obj = _mth02CA(bod, aix1, ((ViewGroup) (relativelayout)), 2);
        float f1 = super.bnU.nextFloat();
        float f;
        if (flag)
        {
            f = 1.4F;
        } else
        {
            f = 1.1F;
        }
        obj = new if(((Path) (obj)), f1 * 28.6F - 14.3F, relativelayout, aix1, f);
        ((Animation) (obj)).setDuration(3000L);
        ((Animation) (obj)).setInterpolator(new LinearInterpolator());
        ((Animation) (obj)).setAnimationListener(new air(this, relativelayout, aix1));
        relativelayout = new AnimationSet(false);
        relativelayout.addAnimation(((Animation) (obj)));
        relativelayout.setInterpolator(new LinearInterpolator());
        aix1.startAnimation(relativelayout);
    }
}
