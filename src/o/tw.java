// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ts, tx, rz

final class tw
    implements Runnable
{

    private ts Tk;

    tw(ts ts1)
    {
        Tk = ts1;
        super();
    }

    public final void run()
    {
        Exception exception;
        try
        {
            tx tx1 = Tk.strategy$3c51a58;
            Tk.strategy$3c51a58 = Tk.getDisabledEventsStrategy$34c68017();
            tx1.deleteAllEvents();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            rz._mth037A(Tk.context, "Failed to disable events.");
        }
    }
}
