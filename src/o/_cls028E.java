// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package o:
//            FF6B

public final class _cls028E
    implements Runnable
{

    private FF6B uQ;
    private Date uT;
    private Thread uU;
    private Throwable uV;

    public _cls028E(FF6B ff6b, Date date, Thread thread, Throwable throwable)
    {
        uQ = ff6b;
        uT = date;
        uU = thread;
        uV = throwable;
        super();
    }

    public final void run()
    {
        if (!FF6B._mth02CA(uQ).get())
        {
            FF6B._mth02CB(uQ, uT, uU, uV);
        }
    }
}
