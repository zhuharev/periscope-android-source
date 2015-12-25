// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package o:
//            FE79, _cls1ECA

final class FEF4 extends Animation
{

    private FE79 _fld1E7F;
    private int _fld1F32;
    private int _fld1F33;

    FEF4(FE79 fe79, int i, int j)
    {
        _fld1E7F = fe79;
        _fld1F32 = i;
        _fld1F33 = j;
        super();
    }

    public final void applyTransformation(float f, Transformation transformation)
    {
        FE79._mth02CB(_fld1E7F).setAlpha((int)((float)_fld1F32 + (float)(_fld1F33 - _fld1F32) * f));
    }
}
