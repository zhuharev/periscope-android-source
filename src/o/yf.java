// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.SystemClock;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

final class yf
{

    public final PriorityBlockingQueue aUB;
    public final aug._cls02CA aUC;
    long aUD;

    public yf(aug._cls02CA _pcls02ca, Comparator comparator)
    {
        aUB = new PriorityBlockingQueue(11, comparator);
        aUC = _pcls02ca;
    }

    public final boolean ready()
    {
        if (aUC.duration <= 0L)
        {
            return true;
        }
        return SystemClock.elapsedRealtime() - aUD >= aUC.duration;
    }
}
