// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;

// Referenced classes of package o:
//            pz, pv, pw

abstract class pu extends ImageView
{
    public static interface if
    {

        public abstract void _mth02BF(Bitmap bitmap);
    }


    private Matrix OM;
    private Matrix OO;
    private final Matrix OP;
    private final float OQ[];
    protected final pz OR;
    private int OS;
    private int OT;
    private float OU;
    private pv OV;
    private if OW;
    protected Handler handler;

    public pu(Context context)
    {
        super(context);
        OM = new Matrix();
        OO = new Matrix();
        OP = new Matrix();
        OQ = new float[9];
        OR = new pz(null, 0);
        OS = -1;
        OT = -1;
        handler = new Handler();
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    public pu(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        OM = new Matrix();
        OO = new Matrix();
        OP = new Matrix();
        OQ = new float[9];
        OR = new pz(null, 0);
        OS = -1;
        OT = -1;
        handler = new Handler();
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    public pu(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        OM = new Matrix();
        OO = new Matrix();
        OP = new Matrix();
        OQ = new float[9];
        OR = new pz(null, 0);
        OS = -1;
        OT = -1;
        handler = new Handler();
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    private void _mth02CA(Bitmap bitmap, int i)
    {
        super.setImageBitmap(bitmap);
        Object obj = getDrawable();
        if (obj != null)
        {
            ((Drawable) (obj)).setDither(true);
        }
        obj = OR.oW;
        OR.oW = bitmap;
        OR.rotation = i;
        if (obj != null && obj != bitmap && OW != null)
        {
            OW._mth02BF(((Bitmap) (obj)));
        }
    }

    private void _mth02CA(pz pz1, Matrix matrix, boolean flag)
    {
        float f = getWidth();
        float f1 = getHeight();
        int i;
        if (pz1.oW == null)
        {
            i = 0;
        } else
        {
            if ((pz1.rotation / 90) % 2 != 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                i = pz1.oW.getHeight();
            } else
            {
                i = pz1.oW.getWidth();
            }
        }
        float f2 = i;
        if (pz1.oW == null)
        {
            i = 0;
        } else
        {
            if ((pz1.rotation / 90) % 2 != 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                i = pz1.oW.getWidth();
            } else
            {
                i = pz1.oW.getHeight();
            }
        }
        float f3 = i;
        matrix.reset();
        float f4 = Math.min(Math.min(f / f2, 3F), Math.min(f1 / f3, 3F));
        if (flag)
        {
            matrix.postConcat(pz1._mth0167());
        }
        matrix.postScale(f4, f4);
        matrix.postTranslate((f - f2 * f4) / 2.0F, (f1 - f3 * f4) / 2.0F);
    }

    public void clear()
    {
        setImageBitmapResetBase(null, true);
    }

    protected final float getScale()
    {
        OO.getValues(OQ);
        return OQ[0];
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            OO.getValues(OQ);
            if (OQ[0] > 1.0F)
            {
                _mth02CE(1.0F, (float)getWidth() / 2.0F, (float)getHeight() / 2.0F);
                return true;
            }
        }
        return super.onKeyUp(i, keyevent);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        OS = k - i;
        OT = l - j;
        pv pv1 = OV;
        if (pv1 != null)
        {
            OV = null;
            pv1.run();
        }
        if (OR.oW != null)
        {
            _mth02CA(OR, OM, true);
            OP.set(OM);
            OP.postConcat(OO);
            setImageMatrix(OP);
        }
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        _mth02CA(bitmap, 0);
    }

    public void setImageBitmapResetBase(Bitmap bitmap, boolean flag)
    {
        setImageRotateBitmapResetBase(new pz(bitmap, 0), flag);
    }

    public void setImageRotateBitmapResetBase(pz pz1, boolean flag)
    {
        if (getWidth() <= 0)
        {
            OV = new pv(this, pz1, flag);
            return;
        }
        if (pz1.oW != null)
        {
            _mth02CA(pz1, OM, true);
            _mth02CA(pz1.oW, pz1.rotation);
        } else
        {
            OM.reset();
            setImageBitmap(null);
        }
        if (flag)
        {
            OO.reset();
        }
        OP.set(OM);
        OP.postConcat(OO);
        setImageMatrix(OP);
        float f;
        if (OR.oW == null)
        {
            f = 1.0F;
        } else
        {
            pz1 = OR;
            int i;
            if (pz1.oW == null)
            {
                i = 0;
            } else
            {
                if ((pz1.rotation / 90) % 2 != 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0)
                {
                    i = pz1.oW.getHeight();
                } else
                {
                    i = pz1.oW.getWidth();
                }
            }
            f = (float)i / (float)OS;
            pz1 = OR;
            if (pz1.oW == null)
            {
                i = 0;
            } else
            {
                if ((pz1.rotation / 90) % 2 != 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0)
                {
                    i = pz1.oW.getWidth();
                } else
                {
                    i = pz1.oW.getHeight();
                }
            }
            f = Math.max(f, (float)i / (float)OT) * 4F;
        }
        OU = f;
    }

    public void setRecycler(if if1)
    {
        OW = if1;
    }

    protected final void _mth02BB(boolean flag, boolean flag1)
    {
        Object obj = OR.oW;
        if (obj == null)
        {
            return;
        }
        OP.set(OM);
        OP.postConcat(OO);
        Matrix matrix = OP;
        obj = new RectF(0.0F, 0.0F, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight());
        matrix.mapRect(((RectF) (obj)));
        float f3 = ((RectF) (obj)).height();
        float f2 = ((RectF) (obj)).width();
        float f1 = 0.0F;
        float f = 0.0F;
        int i = getHeight();
        if (f3 < (float)i)
        {
            f = ((float)i - f3) / 2.0F - ((RectF) (obj)).top;
        } else
        if (((RectF) (obj)).top > 0.0F)
        {
            f = -((RectF) (obj)).top;
        } else
        if (((RectF) (obj)).bottom < (float)i)
        {
            f = (float)getHeight() - ((RectF) (obj)).bottom;
        }
        i = getWidth();
        if (f2 < (float)i)
        {
            f1 = ((float)i - f2) / 2.0F - ((RectF) (obj)).left;
        } else
        if (((RectF) (obj)).left > 0.0F)
        {
            f1 = -((RectF) (obj)).left;
        } else
        if (((RectF) (obj)).right < (float)i)
        {
            f1 = (float)i - ((RectF) (obj)).right;
        }
        _mth037A(f1, f);
        OP.set(OM);
        OP.postConcat(OO);
        setImageMatrix(OP);
    }

    protected void _mth02CE(float f, float f1, float f2)
    {
        float f3 = f;
        if (f > OU)
        {
            f3 = OU;
        }
        OO.getValues(OQ);
        f = f3 / OQ[0];
        OO.postScale(f, f, f1, f2);
        OP.set(OM);
        OP.postConcat(OO);
        setImageMatrix(OP);
        _mth02BB(true, true);
    }

    protected final void _mth02CF(float f, float f1, float f2, float f3)
    {
        OO.getValues(OQ);
        f = (f - OQ[0]) / 300F;
        OO.getValues(OQ);
        f3 = OQ[0];
        long l = System.currentTimeMillis();
        handler.post(new pw(this, 300F, l, f3, f, f1, f2));
    }

    protected void _mth037A(float f, float f1)
    {
        OO.postTranslate(f, f1);
    }

    protected final void _mth1FBE(float f, float f1)
    {
        _mth037A(f, f1);
        OP.set(OM);
        OP.postConcat(OO);
        setImageMatrix(OP);
    }

    public Matrix FF7F()
    {
        Matrix matrix = new Matrix();
        _mth02CA(OR, matrix, false);
        matrix.postConcat(OO);
        return matrix;
    }
}
