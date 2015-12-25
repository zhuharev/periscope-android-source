// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.widget.ImageView;

// Referenced classes of package o:
//            _cls03B5, _cls0EB2, _cls043B, _cls0192

public final class _cls03AB extends _cls03B5
{

    private int pL;
    private _cls0EB2 rP;

    public _cls03AB(ImageView imageview)
    {
        this(imageview, -1);
    }

    private _cls03AB(ImageView imageview, int i)
    {
        super(imageview);
        pL = -1;
    }

    public final void onStart()
    {
        if (rP != null)
        {
            rP.start();
        }
    }

    public final void onStop()
    {
        if (rP != null)
        {
            rP.stop();
        }
    }

    protected final void _mth02C6(Object obj)
    {
        obj = (_cls0EB2)obj;
        ((ImageView)view).setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
    }

    public final void _mth02CA(Object obj, _cls0192 _pcls0192)
    {
        _cls0EB2 _lcls0eb2 = (_cls0EB2)obj;
        obj = _lcls0eb2;
        if (!_lcls0eb2.FB82())
        {
            float f = (float)((ImageView)view).getWidth() / (float)((ImageView)view).getHeight();
            float f1 = (float)_lcls0eb2.getIntrinsicWidth() / (float)_lcls0eb2.getIntrinsicHeight();
            obj = _lcls0eb2;
            if (Math.abs(f - 1.0F) <= 0.05F)
            {
                obj = _lcls0eb2;
                if (Math.abs(f1 - 1.0F) <= 0.05F)
                {
                    obj = new _cls043B(_lcls0eb2, ((ImageView)view).getWidth());
                }
            }
        }
        super._mth02CA(obj, _pcls0192);
        rP = ((_cls0EB2) (obj));
        ((_cls0EB2) (obj))._mth15AE(pL);
        ((_cls0EB2) (obj)).start();
    }
}
