// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.graphics.Matrix;

final class pz
{

    Bitmap oW;
    int rotation;

    public pz(Bitmap bitmap, int i)
    {
        oW = bitmap;
        rotation = i % 360;
    }

    public final Matrix _mth0167()
    {
        Matrix matrix = new Matrix();
        if (oW != null && rotation != 0)
        {
            int i = oW.getWidth() / 2;
            int j = oW.getHeight() / 2;
            matrix.preTranslate(-i, -j);
            matrix.postRotate(rotation);
            if (oW == null)
            {
                i = 0;
            } else
            {
                if ((rotation / 90) % 2 != 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0)
                {
                    i = oW.getHeight();
                } else
                {
                    i = oW.getWidth();
                }
            }
            float f = i / 2;
            if (oW == null)
            {
                i = 0;
            } else
            {
                if ((rotation / 90) % 2 != 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0)
                {
                    i = oW.getWidth();
                } else
                {
                    i = oW.getHeight();
                }
            }
            matrix.postTranslate(f, i / 2);
        }
        return matrix;
    }
}
