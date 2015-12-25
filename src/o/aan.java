// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

// Referenced classes of package o:
//            _cls0443, _cls1D3C, _cls06BA

public class aan extends _cls0443
{

    private final Paint mPaint;

    public aan(Context context)
    {
        this(_cls1D3C._mth0640(context).je);
    }

    private aan(_cls06BA _pcls06ba)
    {
        super(_pcls06ba);
        mPaint = new Paint(3);
    }

    public final String getId()
    {
        return o/aan.getName();
    }

    protected final Bitmap _mth02CA(_cls06BA _pcls06ba, Bitmap bitmap, int i, int j)
    {
        i = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmap1 = _pcls06ba._mth02CB(i, i, android.graphics.Bitmap.Config.ARGB_8888);
        _pcls06ba = bitmap1;
        if (bitmap1 == null)
        {
            _pcls06ba = Bitmap.createBitmap(i, i, android.graphics.Bitmap.Config.ARGB_8888);
        }
        bitmap = new BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        mPaint.setShader(bitmap);
        bitmap = new Canvas(_pcls06ba);
        float f = (float)i / 2.0F;
        bitmap.drawCircle(f, f, f, mPaint);
        return _pcls06ba;
    }
}
