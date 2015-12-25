// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            ry, ra, rl

public final class sh extends ry
{

    private String RO;
    private ExecutorService RP;
    private long RQ;
    private TimeUnit RR;

    public sh(String s, ExecutorService executorservice, long l, TimeUnit timeunit)
    {
        RO = s;
        RP = executorservice;
        RQ = l;
        RR = timeunit;
        super();
    }

    public final void _mth012A()
    {
        InterruptedException interruptedexception;
        try
        {
            ra._mth0454()._mth02BE("Fabric", (new StringBuilder("Executing shutdown hook for ")).append(RO).toString());
            RP.shutdown();
            if (!RP.awaitTermination(RQ, RR))
            {
                ra._mth0454()._mth02BE("Fabric", (new StringBuilder()).append(RO).append(" did not shut down in the allocated time. Requesting immediate shutdown.").toString());
                RP.shutdownNow();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InterruptedException interruptedexception)
        {
            ra._mth0454()._mth02BE("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[] {
                RO
            }));
        }
        RP.shutdownNow();
    }
}
