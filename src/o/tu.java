// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ts, tx, rz

final class tu
    implements Runnable
{

    private Object Ti;
    private ts Tk;

    tu(ts ts1, Object obj)
    {
        Tk = ts1;
        Ti = obj;
        super();
    }

    public final void run()
    {
        Exception exception;
        try
        {
            Tk.strategy$3c51a58.recordEvent(Ti);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            rz._mth037A(Tk.context, "Crashlytics failed to record event");
        }
    }
}
