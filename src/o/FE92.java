// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package o:
//            FEE8

final class FE92
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final View _fld0295;
    final FEE8 _fld0296;

    FE92(FEE8 fee8, View view)
    {
        _fld0296 = fee8;
        _fld0295 = view;
        super();
    }

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        _fld0296.FF9F();
    }
}
