// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            asb, ase, asf, aos

public abstract class asd extends FrameLayout
    implements asb, android.view.View.OnClickListener
{

    public View bAy;
    public View bAz;
    public final ArrayList bCD;
    public final ArrayList bCE;
    public boolean buH;
    public int _fld0575;
    public boolean _fld1EC8;

    public asd(Context context)
    {
        super(context);
        bCD = new ArrayList();
        bCE = new ArrayList();
        init(context);
    }

    public asd(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bCD = new ArrayList();
        bCE = new ArrayList();
        init(context);
    }

    public asd(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bCD = new ArrayList();
        bCE = new ArrayList();
        init(context);
    }

    private void ez()
    {
        bCD.add(new ase(this));
        bCE.add(new asf(this));
    }

    private void init(Context context)
    {
        LayoutInflater.from(context).inflate(0x7f030080, this, true);
        bAz = findViewById(0x7f0d014d);
        bAz.setOnClickListener(this);
        bAy = findViewById(0x7f0d014e);
        bAy.setOnClickListener(this);
        _fld0575 = aos._mth02B2(getContext()).y;
        ez();
    }

    static boolean _mth02CA(asd asd1, boolean flag)
    {
        asd1._fld1EC8 = flag;
        return flag;
    }

    static boolean _mth02CB(asd asd1, boolean flag)
    {
        asd1.buH = flag;
        return flag;
    }

    public final void hide()
    {
        if (_fld1EC8)
        {
            return;
        }
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(bAz, View.ALPHA, new float[] {
            0.6F, 0.0F
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(bAy, View.TRANSLATION_Y, new float[] {
            0.0F, (float)_fld0575
        });
        Object obj = getContext();
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            obj = AnimationUtils.loadInterpolator(((Context) (obj)), 0x10c000d);
        } else
        {
            obj = AnimationUtils.loadInterpolator(((Context) (obj)), 0x10c0006);
        }
        objectanimator1.setInterpolator(((android.animation.TimeInterpolator) (obj)));
        for (obj = bCE.iterator(); ((Iterator) (obj)).hasNext(); objectanimator1.addListener((android.animation.Animator.AnimatorListener)((Iterator) (obj)).next())) { }
        obj = new AnimatorSet();
        ((AnimatorSet) (obj)).play(objectanimator1).with(objectanimator);
        ((AnimatorSet) (obj)).start();
    }

    public final boolean isShowing()
    {
        return buH;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558733: 
            hide();
            break;
        }
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        _fld0575 = aos._mth02B2(getContext()).y;
    }
}
