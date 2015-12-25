// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.ProgressDialog;

// Referenced classes of package o:
//            pr, px

final class ps
    implements Runnable
{

    private pr Om;

    ps(pr pr1)
    {
        Om = pr1;
        super();
    }

    public final void run()
    {
        Om.Oi._mth02CA(Om);
        if (Om.Oj.getWindow() != null)
        {
            Om.Oj.dismiss();
        }
    }
}
