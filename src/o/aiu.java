// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.os.Handler;
import android.view.ViewGroup;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package o:
//            aqr, ait, aiv, aix

final class aiu extends aqr
{

    final ViewGroup boe;
    final aix bon;
    private ait boo;

    aiu(ait ait1, ViewGroup viewgroup, aix aix)
    {
        boo = ait1;
        boe = viewgroup;
        bon = aix;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        boo.mHandler.post(new aiv(this));
        boo.bod.decrementAndGet();
    }

    public final void onAnimationStart(Animator animator)
    {
        boo.bod.incrementAndGet();
    }
}
