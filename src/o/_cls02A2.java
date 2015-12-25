// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

// Referenced classes of package o:
//            _cls03B5

public final class _cls02A2 extends _cls03B5
{

    public _cls02A2(ImageView imageview)
    {
        super(imageview);
    }

    protected final void _mth02C6(Object obj)
    {
        obj = (Drawable)obj;
        ((ImageView)view).setImageDrawable(((Drawable) (obj)));
    }
}
