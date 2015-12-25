// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ail extends FrameLayout
{

    private int bac;
    private boolean bgy;
    private final int bnA;
    private final RectF bnB;
    private final int bnC;
    private final int bnD;
    private final Drawable bnE;
    private final Drawable bnF;
    private final Drawable bnG;
    final ImageView bnH;
    private int bnI;
    private int bnJ;
    private boolean bnx;
    private boolean bny;
    private boolean bnz;
    private final Paint mPaint;
    private int _fld0575;
    private boolean _fld1FD2;

    public ail(Context context)
    {
        this(context, null);
    }

    public ail(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ail(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _fld1FD2 = true;
        Resources resources = context.getResources();
        bnE = resources.getDrawable(0x7f02007c);
        bnF = resources.getDrawable(0x7f020063);
        bnG = resources.getDrawable(0x7f02007e);
        bnI = bnE.getIntrinsicWidth();
        bnJ = bnE.getIntrinsicHeight();
        bnE.setBounds(0, 0, bnI, bnJ);
        bnC = resources.getColor(0x7f0c0081);
        bnD = resources.getColor(0x7f0c0046);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        bnB = new RectF();
        bnA = resources.getDimensionPixelSize(0x7f0900a7);
        bnH = new ImageView(context, attributeset, i);
        addView(bnH);
        setBackground(getResources().getDrawable(0x7f02011b));
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (bnx)
        {
            bnF.draw(canvas);
        } else
        if (bny)
        {
            float f = (float)(bac - bnI) / 2.0F;
            float f2 = (float)(_fld0575 - bnJ) / 2.0F;
            canvas.save();
            canvas.translate(f, f2);
            bnE.draw(canvas);
            canvas.restore();
        }
        if (bnz || bgy)
        {
            boolean flag;
            if (getLayoutDirection() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                canvas.drawRect(bnB, mPaint);
            } else
            {
                float f1 = bac - bnA;
                canvas.save();
                canvas.translate(f1, 0.0F);
                canvas.drawRect(bnB, mPaint);
                canvas.restore();
            }
        }
        bnG.draw(canvas);
    }

    public boolean isEnabled()
    {
        return _fld1FD2;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (flag)
        {
            bac = k - i;
            _fld0575 = l - j;
            bnB.set(0.0F, 0.0F, bnA, _fld0575);
            bnF.setBounds(0, 0, bac, _fld0575);
            bnG.setBounds(0, 0, bac, _fld0575);
        }
    }

    public void setDeleteEnabled(boolean flag)
    {
        if (flag)
        {
            setReplayEnabled(false);
        }
        if (bnx != flag)
        {
            invalidate();
        }
        bnx = flag;
    }

    public void setEnabled(boolean flag)
    {
        if (_fld1FD2 != flag)
        {
            _fld1FD2 = flag;
            if (!_fld1FD2)
            {
                bnH.setAlpha(0.2F);
                getBackground().setAlpha(51);
                return;
            }
            bnH.setAlpha(1.0F);
            getBackground().setAlpha(255);
        }
    }

    public void setFeatured(boolean flag, int i)
    {
        boolean flag1;
        if (bnz != flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        boolean flag2 = flag1;
        if (flag)
        {
            flag2 = flag1;
            if (i != mPaint.getColor())
            {
                flag2 = true;
                Paint paint = mPaint;
                if (i == 0)
                {
                    i = bnD;
                }
                paint.setColor(i);
            }
        }
        bnz = flag;
        if (flag2)
        {
            invalidate();
        }
    }

    public void setLive(boolean flag)
    {
        if (bgy != flag)
        {
            if (flag)
            {
                mPaint.setColor(bnC);
            }
            invalidate();
        }
        bgy = flag;
    }

    public void setReplayEnabled(boolean flag)
    {
        if (flag)
        {
            setDeleteEnabled(false);
        }
        if (bny != flag)
        {
            invalidate();
        }
        bny = flag;
    }
}
