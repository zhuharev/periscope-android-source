// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package o:
//            FE9B

final class _cls1D37 extends AnimatorListenerAdapter
{

    final FE9B _fld0294;
    final View _fld0295;

    _cls1D37(FE9B fe9b, View view)
    {
        _fld0294 = fe9b;
        _fld0295 = view;
        super();
    }

    public final void onAnimationCancel(Animator animator)
    {
        _fld0294._mth02B4(_fld0295);
    }

    public final void onAnimationEnd(Animator animator)
    {
        _fld0294._mth02B3(_fld0295);
    }

    public final void onAnimationStart(Animator animator)
    {
        _fld0294.FF70(_fld0295);
    }
}
