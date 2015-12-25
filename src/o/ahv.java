// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;

// Referenced classes of package o:
//            aqr

final class ahv extends aqr
{

    private aht.if bmj;

    ahv(aht.if if1)
    {
        bmj = if1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        bmj.bmf = true;
        bmj.bme = null;
        bmj.bmd = null;
        bmj.bmc = null;
    }
}
