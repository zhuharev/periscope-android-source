// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package o:
//            aqq, aiq, ais, aix

final class air extends aqq
{

    final ViewGroup boe;
    final aix bof;
    private aiq bog;

    air(aiq aiq1, ViewGroup viewgroup, aix aix)
    {
        bog = aiq1;
        boe = viewgroup;
        bof = aix;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        bog.mHandler.post(new ais(this));
        bog.bod.decrementAndGet();
    }

    public final void onAnimationStart(Animation animation)
    {
        bog.bod.incrementAndGet();
    }
}
