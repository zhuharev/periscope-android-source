// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;

// Referenced classes of package o:
//            rz, ua, to

public final class ud
    implements Runnable
{

    private final ua Tp;
    private final Context context;

    public ud(Context context1, to to)
    {
        context = context1;
        Tp = to;
    }

    public final void run()
    {
        Exception exception;
        try
        {
            rz._mth02BD(context, "Performing time based file roll over.");
            if (!Tp.rollFileOver())
            {
                Tp.cancelTimeBasedFileRollOver();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            rz._mth037A(context, "Failed to roll over file");
        }
    }
}
