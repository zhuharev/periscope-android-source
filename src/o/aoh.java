// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;

// Referenced classes of package o:
//            FB85, aoi, aoj

public final class aoh extends Thread
{

    private final Bitmap buU;
    private final float buV;
    private final int buW;
    final aoj buX;
    private final Context mContext;

    public aoh(Context context, Bitmap bitmap, float f, int i, aoj aoj)
    {
        mContext = context;
        buU = bitmap;
        buV = f;
        buW = i;
        buX = aoj;
    }

    public final void run()
    {
        Bitmap bitmap = buU;
        float f = buV;
        Object obj = bitmap;
        if (f != 0.0F)
        {
            obj = new Matrix();
            ((Matrix) (obj)).postRotate(f);
            obj = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj)), false);
        }
        bitmap = FB85._mth02CA(mContext, ((Bitmap) (obj)), buW);
        if (obj != buU)
        {
            ((Bitmap) (obj)).recycle();
        }
        if (buX != null)
        {
            (new Handler(Looper.getMainLooper())).post(new aoi(this, bitmap));
        }
    }
}
