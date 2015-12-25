// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

// Referenced classes of package o:
//            arf, arg, arh

public class are extends ImageView
{

    public arf bBj;
    public ValueAnimator bBk;
    public ValueAnimator bBl;
    private BitmapDrawable bBm;
    private Rect bBn;
    private float bBo;
    private Bitmap mBitmap;
    private Paint mPaint;
    public boolean FE7B;

    public are(Context context)
    {
        super(context);
        init();
    }

    public are(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public are(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        Object obj = getDrawable();
        if (obj == null)
        {
            bBm = (BitmapDrawable)getResources().getDrawable(0x7f020077);
        } else
        {
            bBm = (BitmapDrawable)obj;
        }
        mBitmap = bBm.getBitmap();
        mPaint = new Paint(6);
        bBn = new Rect(0, 0, 0, 0);
        bBj = new arf(this);
        obj = new LinearInterpolator();
        bBk = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        bBk.setInterpolator(((android.animation.TimeInterpolator) (obj)));
        bBk.setRepeatCount(-1);
        bBk.setRepeatMode(1);
        bBk.setDuration(1700L);
        bBl = ValueAnimator.ofFloat(new float[] {
            1.0F, 0.0F
        });
        bBl.setInterpolator(new LinearInterpolator());
        bBl.setDuration(300L);
        bBl.addUpdateListener(new arg(this));
        bBl.addListener(new arh(this));
    }

    static float _mth02CA(are are1, float f)
    {
        are1.bBo = f;
        return f;
    }

    static BitmapDrawable _mth02CA(are are1)
    {
        return are1.bBm;
    }

    static boolean _mth02CA(are are1, boolean flag)
    {
        are1.FE7B = true;
        return true;
    }

    static boolean _mth02CB(are are1)
    {
        return are1.FE7B;
    }

    static android.animation.ValueAnimator.AnimatorUpdateListener _mth02CE(are are1)
    {
        return are1.bBj;
    }

    static ValueAnimator _mth02CF(are are1)
    {
        return are1.bBk;
    }

    protected void onDraw(Canvas canvas)
    {
        int j = getWidth();
        int k = mBitmap.getWidth();
        int i;
        for (i = (int)(-bBo); i < j; i += k)
        {
            canvas.drawBitmap(mBitmap, i, 0.0F, mPaint);
        }

        if (i - j > 0)
        {
            bBn.set(i, 0, i - j, mBitmap.getHeight());
            canvas.drawBitmap(mBitmap, bBn, bBn, mPaint);
        }
    }
}
