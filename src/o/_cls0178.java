// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

// Referenced classes of package o:
//            _cls0192

public final class _cls0178
    implements _cls0192
{

    private final int duration;
    private final _cls0192 rK;

    public _cls0178(_cls0192 _pcls0192, int i)
    {
        rK = _pcls0192;
        duration = i;
    }

    public final boolean _mth02CA(Object obj, _cls0192.if if1)
    {
        obj = (Drawable)obj;
        Drawable drawable = if1._mth038A();
        if (drawable != null)
        {
            obj = new TransitionDrawable(new Drawable[] {
                drawable, obj
            });
            ((TransitionDrawable) (obj)).setCrossFadeEnabled(true);
            ((TransitionDrawable) (obj)).startTransition(duration);
            if1._mth02CA(((TransitionDrawable) (obj)));
            return true;
        } else
        {
            rK._mth02CA(obj, if1);
            return false;
        }
    }
}
