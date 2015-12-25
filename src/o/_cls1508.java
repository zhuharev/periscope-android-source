// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;

public abstract class _cls1508
{

    static int _fld1D4F = 0x100000;
    Matrix _fld1D37;

    public _cls1508()
    {
    }

    static Bitmap _mth02CA(Drawable drawable)
    {
        int i = drawable.getIntrinsicWidth();
        int j = drawable.getIntrinsicHeight();
        if (i <= 0 || j <= 0)
        {
            return null;
        }
        float f = Math.min(1.0F, (float)_fld1D4F / (float)(i * j));
        if ((drawable instanceof BitmapDrawable) && f == 1.0F)
        {
            return ((BitmapDrawable)drawable).getBitmap();
        } else
        {
            i = (int)((float)i * f);
            j = (int)((float)j * f);
            Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            Rect rect = drawable.getBounds();
            int k = rect.left;
            int l = rect.top;
            int i1 = rect.right;
            int j1 = rect.bottom;
            drawable.setBounds(0, 0, i, j);
            drawable.draw(canvas);
            drawable.setBounds(k, l, i1, j1);
            return bitmap;
        }
    }

    public static ImageView _mth02CA(Context context, Parcelable parcelable)
    {
        Object obj = null;
        if (parcelable instanceof Bundle)
        {
            parcelable = (Bundle)parcelable;
            obj = (Bitmap)parcelable.getParcelable("sharedElement:snapshot:bitmap");
            if (obj == null)
            {
                return null;
            }
            context = new ImageView(context);
            context.setImageBitmap(((Bitmap) (obj)));
            context.setScaleType(android.widget.ImageView.ScaleType.valueOf(parcelable.getString("sharedElement:snapshot:imageScaleType")));
            if (context.getScaleType() == android.widget.ImageView.ScaleType.MATRIX)
            {
                parcelable = parcelable.getFloatArray("sharedElement:snapshot:imageMatrix");
                obj = new Matrix();
                ((Matrix) (obj)).setValues(parcelable);
                context.setImageMatrix(((Matrix) (obj)));
            }
            return context;
        }
        if (parcelable instanceof Bitmap)
        {
            parcelable = (Bitmap)parcelable;
            obj = new ImageView(context);
            ((ImageView) (obj)).setImageBitmap(parcelable);
        }
        return ((ImageView) (obj));
    }

}
