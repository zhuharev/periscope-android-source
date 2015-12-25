// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package o:
//            _cls1428

final class _cls02B9 extends _cls1428.if
{

    private _cls1428 _fld1D65;
    private Fragment FE78;

    _cls02B9(_cls1428 _pcls1428, View view, Animation animation, Fragment fragment)
    {
        _fld1D65 = _pcls1428;
        FE78 = fragment;
        super(view, animation);
    }

    public final void onAnimationEnd(Animation animation)
    {
        super.onAnimationEnd(animation);
        if (FE78.mAnimatingAway != null)
        {
            FE78.mAnimatingAway = null;
            _fld1D65._mth02CA(FE78, FE78.mStateAfterAnimating, 0, 0, false);
        }
    }
}
