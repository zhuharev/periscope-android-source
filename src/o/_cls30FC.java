// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.animation.Animation;

// Referenced classes of package o:
//            _cls1ECA

final class _cls30FC
    implements android.view.animation.Animation.AnimationListener
{

    private _cls1ECA.if _fld1647;
    private _cls1ECA _fld1D27;

    _cls30FC(_cls1ECA _pcls1eca, _cls1ECA.if if1)
    {
        _fld1D27 = _pcls1eca;
        _fld1647 = if1;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
    }

    public final void onAnimationRepeat(Animation animation)
    {
        _cls1ECA.if if1 = _fld1647;
        if1._fld1E8B = if1._fld1D4D;
        if1._fld1E8D = if1._fld1D50;
        if1._fld3033 = if1._fld0E46;
        if1 = _fld1647;
        if1._fld1D66 = (if1._fld1D66 + 1) % if1._fld1D5D.length;
        if1._fld029F = if1._fld1D5D[if1._fld1D66];
        if1 = _fld1647;
        if1._fld1D4D = _fld1647._fld1D50;
        if1._fld1D3C.invalidateDrawable(null);
        if (_fld1D27._fld159F)
        {
            _fld1D27._fld159F = false;
            animation.setDuration(1332L);
            animation = _fld1647;
            if (((_cls1ECA.if) (animation))._fld3035)
            {
                animation._fld3035 = false;
                ((_cls1ECA.if) (animation))._fld1D3C.invalidateDrawable(null);
            }
            return;
        } else
        {
            _cls1ECA._mth02CA(_fld1D27, (_cls1ECA._mth02CA(_fld1D27) + 1.0F) % 5F);
            return;
        }
    }

    public final void onAnimationStart(Animation animation)
    {
        _cls1ECA._mth02CA(_fld1D27, 0.0F);
    }
}
