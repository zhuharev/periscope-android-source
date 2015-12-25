// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ts, tx, rz

final class tt
    implements Runnable
{

    private Object Ti;
    private boolean Tj;
    private ts Tk;

    tt(ts ts1, Object obj, boolean flag)
    {
        Tk = ts1;
        Ti = obj;
        Tj = flag;
        super();
    }

    public final void run()
    {
        Exception exception;
        try
        {
            Tk.strategy$3c51a58.recordEvent(Ti);
            if (Tj)
            {
                Tk.strategy$3c51a58.rollFileOver();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            rz._mth037A(Tk.context, "Failed to record event.");
        }
    }
}
