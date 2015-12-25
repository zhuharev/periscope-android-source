// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

// Referenced classes of package o:
//            _cls1ECA

final class _cls309D extends Animation
{

    private _cls1ECA.if _fld1647;
    private _cls1ECA _fld1D27;

    _cls309D(_cls1ECA _pcls1eca, _cls1ECA.if if1)
    {
        _fld1D27 = _pcls1eca;
        _fld1647 = if1;
        super();
    }

    public final void applyTransformation(float f, Transformation transformation)
    {
        if (_fld1D27._fld159F)
        {
            _cls1ECA._mth02CA(_fld1D27, f, _fld1647);
            return;
        }
        float f1 = _cls1ECA._mth02CA(_fld1D27, _fld1647);
        float f2 = _fld1647._fld1E8D;
        float f4 = _fld1647._fld1E8B;
        float f3 = _fld1647._fld3033;
        _cls1ECA._mth02CB(_fld1D27, f, _fld1647);
        if (f <= 0.5F)
        {
            float f6 = f / 0.5F;
            f6 = _cls1ECA._mth1424().getInterpolation(f6);
            transformation = _fld1647;
            transformation._fld1D4D = f4 + (0.8F - f1) * f6;
            ((_cls1ECA.if) (transformation))._fld1D3C.invalidateDrawable(null);
        }
        if (f > 0.5F)
        {
            float f5 = (f - 0.5F) / 0.5F;
            f5 = _cls1ECA._mth1424().getInterpolation(f5);
            transformation = _fld1647;
            transformation._fld1D50 = f2 + f5 * (0.8F - f1);
            ((_cls1ECA.if) (transformation))._fld1D3C.invalidateDrawable(null);
        }
        transformation = _fld1647;
        transformation._fld0E46 = f3 + 0.25F * f;
        ((_cls1ECA.if) (transformation))._fld1D3C.invalidateDrawable(null);
        f1 = _cls1ECA._mth02CA(_fld1D27) / 5F;
        transformation = _fld1D27;
        transformation._fld0E46 = 216F * f + f1 * 1080F;
        transformation.invalidateSelf();
    }
}
