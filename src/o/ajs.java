// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.view.View;

// Referenced classes of package o:
//            aqr, ajk

final class ajs extends aqr
{

    private ajk._cls02CA bpR;

    ajs(ajk._cls02CA _pcls02ca)
    {
        bpR = _pcls02ca;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        ajk._mth02BC(bpR.bpC).setVisibility(8);
    }
}
