// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

// Referenced classes of package o:
//            ug

public static abstract class Tz extends Tz
{

    private final Closeable TF;
    private final boolean Tz;

    protected final void done()
    {
        if (TF instanceof Flushable)
        {
            ((Flushable)TF).flush();
        }
        if (Tz)
        {
            try
            {
                TF.close();
                return;
            }
            catch (IOException ioexception)
            {
                return;
            }
        } else
        {
            TF.close();
            return;
        }
    }

    protected oseable(Closeable closeable, boolean flag)
    {
        TF = closeable;
        Tz = flag;
    }
}
