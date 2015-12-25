// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.ImageView;

// Referenced classes of package o:
//            arw

public class arv extends FrameLayout
{
    final class if extends Animation
    {

        private arv bBV;
        private View mView;

        protected final void applyTransformation(float f, Transformation transformation)
        {
            mView.setScaleX(f);
            mView.setScaleY(f);
            transformation.setAlpha((float)((((double)f - 0.0D) / 1.0D) * -0.5D + 0.5D));
        }

        public if(ImageView imageview)
        {
            bBV = arv.this;
            super();
            mView = imageview;
        }
    }


    public if bBR;
    public if bBS;
    private ImageView bBT;
    private ImageView bBU;

    public arv(Context context)
    {
        super(context);
        init();
    }

    public arv(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public arv(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        setVisibility(8);
        bBT = new ImageView(getContext());
        bBT.setImageResource(0x7f020110);
        addView(bBT);
        bBR = new if(bBT);
        bBR.setDuration(2500L);
        bBR.setRepeatCount(-1);
        bBR.setInterpolator(new AccelerateDecelerateInterpolator());
        bBU = new ImageView(getContext());
        bBU.setImageResource(0x7f020110);
        bBU.setVisibility(8);
        addView(bBU);
        bBS = new if(bBU);
        bBS.setDuration(2500L);
        bBS.setRepeatCount(-1);
        bBS.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    static ImageView _mth02CA(arv arv1)
    {
        return arv1.bBU;
    }

    static Animation _mth02CB(arv arv1)
    {
        return arv1.bBS;
    }

    public final void start()
    {
        setVisibility(0);
        bBT.startAnimation(bBR);
        postDelayed(new arw(this), 1250L);
    }
}
