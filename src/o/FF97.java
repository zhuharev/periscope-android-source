// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package o:
//            FF6B, ra, rl

final class FF97
    implements Callable
{

    private FF6B uQ;

    FF97(FF6B ff6b)
    {
        uQ = ff6b;
        super();
    }

    public final Object call()
    {
        if (!FF6B._mth02CA(uQ).get())
        {
            ra._mth0454()._mth02BE("CrashlyticsCore", "Finalizing previously open sessions.");
            FF6B._mth02BB(uQ);
            FF6B._mth02CB(uQ, true);
            ra._mth0454()._mth02BE("CrashlyticsCore", "Closed all previously open sessions");
            return Boolean.valueOf(true);
        } else
        {
            ra._mth0454()._mth02BE("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
            return Boolean.valueOf(false);
        }
    }
}
