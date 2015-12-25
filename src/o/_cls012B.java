// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.animation.Animation;

// Referenced classes of package o:
//            FE79

final class _cls012B
    implements android.view.animation.Animation.AnimationListener
{

    private FE79 _fld1E7F;

    _cls012B(FE79 fe79)
    {
        _fld1E7F = fe79;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        if (!FE79._mth02BB(_fld1E7F))
        {
            FE79._mth02CA(_fld1E7F, null);
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
