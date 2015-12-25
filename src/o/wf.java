// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package o:
//            vn, wc

final class wf extends vn
{

    private Socket Vt;

    wf(Socket socket)
    {
        Vt = socket;
        super();
    }

    protected final void timedOut()
    {
        try
        {
            Vt.close();
            return;
        }
        catch (Exception exception)
        {
            wc._mth0284().log(Level.WARNING, (new StringBuilder("Failed to close timed out socket ")).append(Vt).toString(), exception);
        }
    }
}
