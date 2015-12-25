// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package o:
//            FE79

final class _cls013C extends Animation
{

    private FE79 _fld1E7F;

    _cls013C(FE79 fe79)
    {
        _fld1E7F = fe79;
        super();
    }

    public final void applyTransformation(float f, Transformation transformation)
    {
        float f1 = FE79._mth1FBE(_fld1E7F);
        float f2 = -FE79._mth1FBE(_fld1E7F);
        FE79._mth02CA(_fld1E7F, f1 + f2 * f);
        FE79._mth02CB(_fld1E7F, f);
    }
}
