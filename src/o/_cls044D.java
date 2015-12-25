// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;

// Referenced classes of package o:
//            _cls0443, _cls06BA

public final class _cls044D extends _cls0443
{

    public _cls044D(_cls06BA _pcls06ba)
    {
        super(_pcls06ba);
    }

    public final String getId()
    {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }

    protected final Bitmap _mth02CA(_cls06BA _pcls06ba, Bitmap bitmap, int i, int j)
    {
        Object obj;
        if (bitmap.getConfig() != null)
        {
            obj = bitmap.getConfig();
        } else
        {
            obj = android.graphics.Bitmap.Config.ARGB_8888;
        }
        obj = _pcls06ba._mth02CB(i, j, ((android.graphics.Bitmap.Config) (obj)));
        bitmap = _cls141D.if._mth02CA(((Bitmap) (obj)), bitmap, i, j);
        if (obj != null && obj != bitmap && !_pcls06ba._mth02BD(((Bitmap) (obj))))
        {
            ((Bitmap) (obj)).recycle();
        }
        return bitmap;
    }
}
