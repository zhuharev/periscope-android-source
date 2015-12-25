// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.ProgressDialog;
import android.os.Handler;

// Referenced classes of package o:
//            ps, px

public final class pr extends px.if
    implements Runnable
{

    final px Oi;
    final ProgressDialog Oj;
    private final Runnable Ok;
    private final ps Ol = new ps(this);
    private final Handler handler;

    public pr(px px1, Runnable runnable, ProgressDialog progressdialog, Handler handler1)
    {
        Oi = px1;
        Oj = progressdialog;
        Ok = runnable;
        Oi._mth02CB(this);
        handler = handler1;
    }

    public final void run()
    {
        Ok.run();
        handler.post(Ol);
        return;
        Exception exception;
        exception;
        handler.post(Ol);
        throw exception;
    }

    public final void _mth0107()
    {
        Oj.show();
    }

    public final void FF84()
    {
        Ol.run();
        handler.removeCallbacks(Ol);
    }

    public final void FF95()
    {
        Oj.hide();
    }
}
