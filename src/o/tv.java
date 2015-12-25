// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ts, tx, rz

final class tv
    implements Runnable
{

    private ts Tk;

    tv(ts ts1)
    {
        Tk = ts1;
        super();
    }

    public final void run()
    {
        Exception exception;
        try
        {
            Tk.strategy$3c51a58.sendEvents();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            rz._mth037A(Tk.context, "Failed to send events files.");
        }
    }
}
