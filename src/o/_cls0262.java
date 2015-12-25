// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package o:
//            FF6B, _cls043A, _cls03DC

public final class _cls0262
    implements Callable
{

    private FF6B uQ;
    private long uW;
    private String uX;

    public _cls0262(FF6B ff6b, long l, String s)
    {
        uQ = ff6b;
        uW = l;
        uX = s;
        super();
    }

    public final Object call()
    {
        if (!FF6B._mth02CA(uQ).get())
        {
            _cls043A _lcls043a = FF6B._mth02CB(uQ);
            long l = uW;
            String s = uX;
            _lcls043a.ve._mth02CA(l, s);
        }
        return null;
    }
}
