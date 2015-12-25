// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ra, rl, FE94

final class FEA3
    implements Runnable
{

    private Runnable uw;
    private FE94 ux;

    FEA3(FE94 fe94, Runnable runnable)
    {
        ux = fe94;
        uw = runnable;
        super();
    }

    public final void run()
    {
        try
        {
            uw.run();
            return;
        }
        catch (Exception exception)
        {
            ra._mth0454()._mth02CB("CrashlyticsCore", "Failed to execute task.", exception);
        }
    }
}
