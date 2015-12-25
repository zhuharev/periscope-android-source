// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            afu, afv, aqd, asa, 
//            aos

public class aft extends RelativeLayout
{

    private static final long biS;
    private static final long biT;
    private static final long biU;
    float KP;
    private View biV;
    aqd biW;
    private TextView biX;
    private asa biY;
    View biZ;
    private TextView bja;
    private View bjb;
    ObjectAnimator bjc;
    ObjectAnimator bjd;
    int bje;
    private long bjf;
    private float bjg;
    long bjh;
    long bji;

    public aft(Context context)
    {
        super(context);
        KP = 1.0F;
        bjg = 0.3F;
        init(context);
    }

    public aft(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        KP = 1.0F;
        bjg = 0.3F;
        init(context);
    }

    public aft(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        KP = 1.0F;
        bjg = 0.3F;
        init(context);
    }

    private void bQ()
    {
        bjc = ObjectAnimator.ofFloat(this, View.ALPHA, new float[] {
            0.0F, 1.0F
        });
        bjc.setDuration(biT);
        bjc.addListener(new afu(this));
    }

    private void bR()
    {
        bjd = ObjectAnimator.ofFloat(this, View.ALPHA, new float[] {
            1.0F, 0.0F
        });
        bjd.setDuration(biU);
        bjd.addListener(new afv(this));
    }

    private void bS()
    {
        bjb.setVisibility(0);
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(bjb, View.ALPHA, new float[] {
            1.0F, 0.0F
        });
        objectanimator.setStartDelay(biS);
        objectanimator.start();
        bjf = System.currentTimeMillis();
    }

    private void init(Context context)
    {
        View view = LayoutInflater.from(context).inflate(0x7f030077, this, true);
        biV = view.findViewById(0x7f0d0182);
        biW = (aqd)view.findViewById(0x7f0d007c);
        biX = (TextView)view.findViewById(0x7f0d0124);
        biY = (asa)view.findViewById(0x7f0d0183);
        biZ = view.findViewById(0x7f0d0180);
        bja = (TextView)view.findViewById(0x7f0d0181);
        bjb = view.findViewById(0x7f0d017d);
        float f = context.getResources().getDimension(0x7f09009e);
        biW.setCornerRadius(new float[] {
            f, f, f, f
        });
        bQ();
        bR();
        context = aos._mth02B2(context);
        bje = (int)((float)Math.min(((Point) (context)).x, ((Point) (context)).y) * 0.75F);
    }

    static asa _mth02BB(aft aft1)
    {
        return aft1.biY;
    }

    static TextView _mth02BC(aft aft1)
    {
        return aft1.bja;
    }

    static long _mth02CA(aft aft1)
    {
        return aft1.bjf;
    }

    private void _mth02CA(Point point)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)biZ.getLayoutParams();
        layoutparams.height = (int)((float)point.y * bjg);
        biZ.setLayoutParams(layoutparams);
    }

    private void _mth02CA(boolean flag, Point point)
    {
        float f;
        if (flag)
        {
            f = 0.25F;
        } else
        {
            f = 0.35F;
        }
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)biV.getLayoutParams();
        int i = (int)((float)point.y * f);
        layoutparams.height = i;
        layoutparams.width = i;
        biV.setLayoutParams(layoutparams);
    }

    static void _mth02CB(aft aft1)
    {
        aft1.bS();
    }

    static boolean _mth02CE(aft aft1)
    {
        return _cls141D.if._mth02CB(aft1.getContext()) && System.currentTimeMillis() - aft1.bjf < biS;
    }

    static View _mth02CF(aft aft1)
    {
        return aft1.bjb;
    }

    static View _mth141D(aft aft1)
    {
        return aft1.biV;
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        configuration = getContext();
        Point point = aos._mth02B2(configuration);
        boolean flag1 = _cls141D.if._mth02CB(configuration);
        _mth02CA(flag1, point);
        _mth02CA(point);
        if (bjf == 0L && flag1)
        {
            bS();
            return;
        }
        configuration = bjb;
        boolean flag;
        if (_cls141D.if._mth02CB(getContext()) && System.currentTimeMillis() - bjf < biS)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        byte byte0;
        if (flag)
        {
            byte0 = 0;
        } else
        {
            byte0 = 8;
        }
        configuration.setVisibility(byte0);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        Context context = getContext();
        Point point = aos._mth02B2(context);
        _mth02CA(_cls141D.if._mth02CB(context), point);
        _mth02CA(point);
    }

    public final void seekTo(long l)
    {
        if (bji != l)
        {
            if (l < 0L)
            {
                l = 0L;
            } else
            if (l > bjh)
            {
                l = bjh;
            }
            biX.setText(_cls141D.if._mth02CA(TimeUnit.MILLISECONDS.toSeconds(l)));
            bji = l;
            biY.setProgress((int)bji);
        }
    }

    public void setDuration(long l)
    {
        bjh = l;
        biY.setMax((int)bjh);
    }

    public void setEndTime(long l)
    {
        seekTo(l);
        bjb.setVisibility(4);
        biY.setVisibility(4);
        bja.setVisibility(4);
    }

    public void setInitialTime(long l)
    {
        biY.setInitialProgress((int)l);
        seekTo(l);
    }

    public void setThumb(Drawable drawable)
    {
        biW.setImageDrawable(drawable);
    }

    public void setZoom(float f, int i)
    {
        KP = f;
        int j = (int)((float)bje * KP);
        biY.setBarWidth(j);
        asa asa1 = biY;
        long l1 = bjh;
        f = j;
        long l = TimeUnit.MILLISECONDS.toHours(l1);
        if (l < 1L)
        {
            l = TimeUnit.SECONDS.toMillis(30L);
        } else
        {
            l = TimeUnit.MINUTES.toMillis(l);
        }
        if (l > 0L)
        {
            j = (int)(l1 / l);
        } else
        {
            j = 0;
        }
        asa1.setSegmentSize(f / (float)j);
        biY.invalidate();
        if (i > 0)
        {
            bja.setText(getResources().getString(i));
            return;
        } else
        {
            bja.setText("");
            return;
        }
    }

    public void setZoomZonePercentage(float f)
    {
        if (Float.compare(bjg, f) != 0)
        {
            bjg = f;
            _mth02CA(aos._mth02B2(getContext()));
        }
    }

    static 
    {
        biS = TimeUnit.SECONDS.toMillis(20L);
        biT = TimeUnit.MILLISECONDS.toMillis(100L);
        biU = TimeUnit.SECONDS.toMillis(1L);
    }
}
