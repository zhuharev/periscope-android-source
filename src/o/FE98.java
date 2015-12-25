// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package o:
//            FE79

final class FE98 extends Animation
{

    private FE79 _fld1E7F;

    FE98(FE79 fe79)
    {
        _fld1E7F = fe79;
        super();
    }

    public final void applyTransformation(float f, Transformation transformation)
    {
        FE79._mth02CA(_fld1E7F, f);
    }
}
