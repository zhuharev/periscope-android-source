// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Referenced classes of package o:
//            so

final class sr extends FutureTask
{

    private so Sz;

    sr(so so1, so._cls02CF _pcls02cf)
    {
        Sz = so1;
        super(_pcls02cf);
    }

    protected final void done()
    {
        CancellationException cancellationexception;
        try
        {
            so.access$400(Sz, get());
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Log.w("AsyncTask", interruptedexception);
            return;
        }
        catch (ExecutionException executionexception)
        {
            throw new RuntimeException("An error occured while executing doInBackground()", executionexception.getCause());
        }
        // Misplaced declaration of an exception variable
        catch (CancellationException cancellationexception)
        {
            so.access$400(Sz, null);
        }
    }
}
