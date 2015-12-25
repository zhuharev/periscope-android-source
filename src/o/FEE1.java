// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.Callable;

// Referenced classes of package o:
//            ra, rl, FE94

final class FEE1
    implements Callable
{

    private FE94 ux;
    private Callable uy;

    FEE1(FE94 fe94, Callable callable)
    {
        ux = fe94;
        uy = callable;
        super();
    }

    public final Object call()
    {
        Object obj;
        try
        {
            obj = uy.call();
        }
        catch (Exception exception)
        {
            ra._mth0454()._mth02CB("CrashlyticsCore", "Failed to execute task.", exception);
            return null;
        }
        return obj;
    }
}
