// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.ImageView;

public class aix extends ImageView
{

    private static Paint bor = new Paint(3);
    private static SparseArray bos = new SparseArray();
    private int bot;
    private int bou;
    int bov;

    public aix(Context context)
    {
        super(context);
        bot = 0x7f0200c1;
        bou = 0x7f0200c2;
        setImageResource(bot);
    }

    public aix(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bot = 0x7f0200c1;
        bou = 0x7f0200c2;
        setImageResource(bot);
    }

    public aix(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bot = 0x7f0200c1;
        bou = 0x7f0200c2;
        setImageResource(bot);
    }

    private Bitmap _mth02CA(int i, Bitmap bitmap, Bitmap bitmap1)
    {
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = bor;
        float f = (float)(bitmap.getWidth() - bitmap1.getWidth()) / 2.0F;
        float f1 = (float)(bitmap.getHeight() - bitmap1.getHeight()) / 2.0F;
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        PorterDuffColorFilter porterduffcolorfilter = (PorterDuffColorFilter)bos.get(i);
        bitmap = porterduffcolorfilter;
        if (porterduffcolorfilter == null)
        {
            bitmap = new PorterDuffColorFilter(i, android.graphics.PorterDuff.Mode.SRC_ATOP);
            bos.put(i, bitmap);
        }
        paint.setColorFilter(bitmap);
        canvas.drawBitmap(bitmap1, f, f1, paint);
        paint.setColorFilter(null);
        bov = bitmap2.getHeight();
        return bitmap2;
    }

    public void setColor(int i)
    {
        Object obj = getResources();
        obj = _mth02CA(i, BitmapFactory.decodeResource(((android.content.res.Resources) (obj)), bot), BitmapFactory.decodeResource(((android.content.res.Resources) (obj)), bou));
        setImageDrawable(new BitmapDrawable(getResources(), ((Bitmap) (obj))));
    }

    public void setColorAndDrawables(int i, int j, int k)
    {
        bot = j;
        bou = k;
        setColor(i);
    }

    public void setColorAndDrawables(int i, Bitmap bitmap, Bitmap bitmap1)
    {
        bitmap = _mth02CA(i, bitmap, bitmap1);
        setImageDrawable(new BitmapDrawable(getResources(), bitmap));
    }

}
