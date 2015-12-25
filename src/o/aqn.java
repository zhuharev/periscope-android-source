// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.transition.Transition;

// Referenced classes of package o:
//            aqf

final class aqn
    implements android.transition.Transition.TransitionListener
{

    private aqf bAJ;

    aqn(aqf aqf1)
    {
        bAJ = aqf1;
        super();
    }

    public final void onTransitionCancel(Transition transition)
    {
    }

    public final void onTransitionEnd(Transition transition)
    {
        aqf._mth02CF(bAJ, false);
    }

    public final void onTransitionPause(Transition transition)
    {
    }

    public final void onTransitionResume(Transition transition)
    {
    }

    public final void onTransitionStart(Transition transition)
    {
        aqf._mth02CF(bAJ, true);
    }
}
