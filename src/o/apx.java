// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

// Referenced classes of package o:
//            apy, apz, aqa, aqb, 
//            aos

public class apx extends RelativeLayout
{

    private static final ArgbEvaluator bzs = new ArgbEvaluator();
    private aqb bzA;
    private int bzB;
    private int bzC;
    private int bzD;
    private int bzE;
    private ImageView bzt;
    private ImageView bzu;
    private ImageView bzv;
    private ImageView bzw;
    private apy bzx;
    private apz bzy;
    private aqa bzz;

    public apx(Context context)
    {
        super(context);
        bzB = 0xff000000;
        bzC = 0xff000000;
        bzD = 0xff000000;
        bzE = 0xff000000;
        init();
    }

    public apx(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bzB = 0xff000000;
        bzC = 0xff000000;
        bzD = 0xff000000;
        bzE = 0xff000000;
        init();
    }

    public apx(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bzB = 0xff000000;
        bzC = 0xff000000;
        bzD = 0xff000000;
        bzE = 0xff000000;
        init();
    }

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(0x7f03004c, this, true);
        bzt = (ImageView)findViewById(0x7f0d0103);
        bzu = (ImageView)findViewById(0x7f0d0104);
        bzv = (ImageView)findViewById(0x7f0d0105);
        bzw = (ImageView)findViewById(0x7f0d0106);
        bzx = new apy(this);
        bzy = new apz(this);
        bzz = new aqa(this);
        bzA = new aqb(this);
        ek();
    }

    static ImageView _mth02CA(apx apx1)
    {
        return apx1.bzt;
    }

    private static void _mth02CA(android.animation.ValueAnimator.AnimatorUpdateListener animatorupdatelistener, int i, int j, long l)
    {
        ValueAnimator valueanimator = ValueAnimator.ofObject(bzs, new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        valueanimator.addUpdateListener(animatorupdatelistener);
        valueanimator.setDuration(l).start();
    }

    static ImageView _mth02CB(apx apx1)
    {
        return apx1.bzu;
    }

    static ImageView _mth02CE(apx apx1)
    {
        return apx1.bzv;
    }

    static ImageView _mth02CF(apx apx1)
    {
        return apx1.bzw;
    }

    public void ek()
    {
        Object obj = aos._mth02B2(getContext());
        float f = (float)Math.max(((Point) (obj)).x, ((Point) (obj)).y) * 0.618F;
        obj = bzt;
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)((View) (obj)).getLayoutParams();
        layoutparams.width = (int)f;
        layoutparams.height = (int)f;
        ((View) (obj)).setLayoutParams(layoutparams);
        obj = bzu;
        layoutparams = (android.widget.FrameLayout.LayoutParams)((View) (obj)).getLayoutParams();
        layoutparams.width = (int)f;
        layoutparams.height = (int)f;
        ((View) (obj)).setLayoutParams(layoutparams);
        obj = bzv;
        layoutparams = (android.widget.FrameLayout.LayoutParams)((View) (obj)).getLayoutParams();
        layoutparams.width = (int)f;
        layoutparams.height = (int)f;
        ((View) (obj)).setLayoutParams(layoutparams);
        obj = bzw;
        layoutparams = (android.widget.FrameLayout.LayoutParams)((View) (obj)).getLayoutParams();
        layoutparams.width = (int)f;
        layoutparams.height = (int)f;
        ((View) (obj)).setLayoutParams(layoutparams);
    }

    public void setBitmapPixels(Bitmap bitmap, int i, long l)
    {
        int k = bitmap.getWidth() / 4;
        int j1 = (bitmap.getWidth() / 4) * 3;
        int k1 = bitmap.getHeight() / 4;
        int l1 = (bitmap.getHeight() / 4) * 3;
        int j;
        int i1;
        switch (i)
        {
        case 3: // '\003'
            i1 = bitmap.getPixel(j1, k1);
            i = bitmap.getPixel(j1, l1);
            j = bitmap.getPixel(k, k1);
            k = bitmap.getPixel(k, l1);
            break;

        case 1: // '\001'
            i1 = bitmap.getPixel(k, l1);
            i = bitmap.getPixel(k, k1);
            j = bitmap.getPixel(j1, l1);
            k = bitmap.getPixel(j1, k1);
            break;

        case 2: // '\002'
            i1 = bitmap.getPixel(j1, l1);
            i = bitmap.getPixel(k, l1);
            j = bitmap.getPixel(j1, k1);
            k = bitmap.getPixel(k, k1);
            break;

        default:
            i1 = bitmap.getPixel(k, k1);
            i = bitmap.getPixel(j1, k1);
            j = bitmap.getPixel(k, l1);
            k = bitmap.getPixel(j1, l1);
            break;
        }
        _mth02CA(i1, i, j, k, l);
    }

    public final void _mth02CA(int i, int j, int k, int l, long l1)
    {
        _mth02CA(((android.animation.ValueAnimator.AnimatorUpdateListener) (bzx)), bzB, i, l1);
        bzB = i;
        _mth02CA(((android.animation.ValueAnimator.AnimatorUpdateListener) (bzy)), bzC, j, l1);
        bzC = j;
        _mth02CA(((android.animation.ValueAnimator.AnimatorUpdateListener) (bzz)), bzD, k, l1);
        bzD = k;
        _mth02CA(((android.animation.ValueAnimator.AnimatorUpdateListener) (bzA)), bzE, l, l1);
        bzE = l;
    }

}
