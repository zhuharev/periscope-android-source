// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.animation.Interpolator;

abstract class _cls1D16
    implements Interpolator
{

    private final float _fld13B0[];
    private final float _fld13DE;

    public _cls1D16(float af[])
    {
        _fld13B0 = af;
        _fld13DE = 1.0F / (float)(_fld13B0.length - 1);
    }

    public float getInterpolation(float f)
    {
        if (f >= 1.0F)
        {
            return 1.0F;
        }
        if (f <= 0.0F)
        {
            return 0.0F;
        } else
        {
            int i = Math.min((int)((float)(_fld13B0.length - 1) * f), _fld13B0.length - 2);
            f = (f - (float)i * _fld13DE) / _fld13DE;
            return _fld13B0[i] + (_fld13B0[i + 1] - _fld13B0[i]) * f;
        }
    }
}
