// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package o:
//            _cls03B5

public final class _cls02A1 extends _cls03B5
{

    public _cls02A1(ImageView imageview)
    {
        super(imageview);
    }

    protected final void _mth02C6(Object obj)
    {
        obj = (Bitmap)obj;
        ((ImageView)view).setImageBitmap(((Bitmap) (obj)));
    }
}
