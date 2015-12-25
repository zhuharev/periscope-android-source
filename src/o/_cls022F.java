// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Date;
import java.util.concurrent.Callable;

// Referenced classes of package o:
//            FF6B

final class _cls022F
    implements Callable
{

    private FF6B uQ;
    private Date uT;
    private Thread uU;
    private Throwable uV;

    _cls022F(FF6B ff6b, Date date, Thread thread, Throwable throwable)
    {
        uQ = ff6b;
        uT = date;
        uU = thread;
        uV = throwable;
        super();
    }

    public final Object call()
    {
        FF6B._mth02CA(uQ, uT, uU, uV);
        return null;
    }
}
