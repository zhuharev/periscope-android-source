// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;

// Referenced classes of package o:
//            _cls04AB, _cls0192

public abstract class _cls03B5 extends _cls04AB
    implements _cls0192.if
{

    public _cls03B5(ImageView imageview)
    {
        super(imageview);
    }

    public final void _mth02BE(Drawable drawable)
    {
        ((ImageView)view).setImageDrawable(drawable);
    }

    public final void _mth02BF(Drawable drawable)
    {
        ((ImageView)view).setImageDrawable(drawable);
    }

    protected abstract void _mth02C6(Object obj);

    public final void _mth02CA(TransitionDrawable transitiondrawable)
    {
        ((ImageView)view).setImageDrawable(transitiondrawable);
    }

    public void _mth02CA(Object obj, _cls0192 _pcls0192)
    {
        if (_pcls0192 == null || !_pcls0192._mth02CA(obj, this))
        {
            _mth02C6(obj);
        }
    }

    public final Drawable _mth038A()
    {
        return ((ImageView)view).getDrawable();
    }

    public final void _mth1FBE(Drawable drawable)
    {
        ((ImageView)view).setImageDrawable(drawable);
    }
}
