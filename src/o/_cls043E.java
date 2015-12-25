// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;

// Referenced classes of package o:
//            _cls05D4, _cls0645, _cls06BA

public final class _cls043E
    implements _cls05D4
{

    private final _cls06BA je;
    private final Bitmap oW;

    public _cls043E(Bitmap bitmap, _cls06BA _pcls06ba)
    {
        if (bitmap == null)
        {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (_pcls06ba == null)
        {
            throw new NullPointerException("BitmapPool must not be null");
        } else
        {
            oW = bitmap;
            je = _pcls06ba;
            return;
        }
    }

    public final volatile Object get()
    {
        return oW;
    }

    public final int getSize()
    {
        return _cls0645._mth037A(oW);
    }

    public final void recycle()
    {
        if (!je._mth02BD(oW))
        {
            oW.recycle();
        }
    }
}
