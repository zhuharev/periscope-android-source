// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.Arrays;

// Referenced classes of package o:
//            xe

public class aqd extends ImageView
{
    public static final class if extends Enum
    {

        public static final int bzP = 1;
        private static int bzQ = 2;
        public static final int bzR = 3;
        public static final int bzS[] = el();
        private static final int bzT[] = {
            1, 2, 3
        };

        public static int[] el()
        {
            return (int[])bzT.clone();
        }

    }


    private int bac;
    private Bitmap bzI;
    private Canvas bzJ;
    private Path bzK;
    private RectF bzL;
    private float bzM[];
    private int bzN;
    private int bzO;
    private final Paint mPaint;
    private Drawable _fld0407;
    private int _fld0575;

    public aqd(Context context)
    {
        super(context);
        mPaint = new Paint();
        _mth141D(context, null);
    }

    public aqd(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mPaint = new Paint();
        _mth141D(context, attributeset);
    }

    public aqd(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mPaint = new Paint();
        _mth141D(context, attributeset);
    }

    private void _mth0E40(int i, int j)
    {
        if (i == 0 || j == 0)
        {
            return;
        }
        if (bzJ != null && i == bac && j == _fld0575)
        {
            bzJ.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            return;
        }
        bzI = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        bzJ = new Canvas(bzI);
        mPaint.setShader(new BitmapShader(bzI, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
        bzL.set(0.0F, 0.0F, i, j);
        bzK.reset();
        if (bzN == if.bzR)
        {
            bzK.addRoundRect(bzL, bzM, android.graphics.Path.Direction.CW);
        } else
        {
            bzK.addOval(bzL, android.graphics.Path.Direction.CW);
        }
        bac = i;
        _fld0575 = j;
    }

    private void _mth141D(Context context, AttributeSet attributeset)
    {
        bzK = new Path();
        bzL = new RectF();
        bzN = if.bzP;
        mPaint.setAntiAlias(true);
        bzM = new float[8];
        if (attributeset != null)
        {
            context = context.obtainStyledAttributes(attributeset, xe.MaskImageView);
            attributeset = if.bzS;
            int i = if.bzP;
            bzN = attributeset[context.getInteger(0, 0)];
            if (bzN == if.bzR)
            {
                attributeset = new float[4];
                Arrays.fill(attributeset, context.getDimension(1, 0.0F));
                setCornerRadius(attributeset);
            }
            context.recycle();
        }
    }

    protected void onDraw(Canvas canvas)
    {
        if (bzN == if.bzP || _fld0407 == null && bzO == 0)
        {
            super.onDraw(canvas);
            return;
        } else
        {
            super.onDraw(bzJ);
            canvas.drawPath(bzK, mPaint);
            return;
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        i = k - i;
        j = l - j;
        if (bzI == null || bzI.getHeight() != j || bzI.getWidth() != i)
        {
            _mth0E40(i, j);
        }
    }

    public void setCornerRadius(float af[])
    {
        if (af.length < 4)
        {
            throw new IllegalArgumentException((new StringBuilder("Expected radius size 4, got: ")).append(af.length).toString());
        }
        for (int i = 0; i < bzM.length; i++)
        {
            bzM[i] = af[i / 2];
        }

        setMaskType$7e5a8108(if.bzR);
    }

    public void setImageDrawable(Drawable drawable)
    {
        if (_fld0407 != drawable)
        {
            _fld0407 = drawable;
            bzO = 0;
            if (drawable == null)
            {
                bzI = null;
                bzJ = null;
                mPaint.setShader(null);
            } else
            {
                _mth0E40(getWidth(), getHeight());
            }
        }
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int i)
    {
        if (bzO != i)
        {
            bzO = i;
            _fld0407 = null;
            if (i == 0)
            {
                bzI = null;
                bzJ = null;
                mPaint.setShader(null);
            } else
            {
                _mth0E40(getWidth(), getHeight());
            }
        }
        super.setImageResource(i);
    }

    public void setMaskType$7e5a8108(int i)
    {
        bzN = i;
    }
}
