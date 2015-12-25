// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Process;

final class _cls1528 extends Thread
{

    private _cls1504.if on;

    _cls1528(_cls1504.if if1, Runnable runnable, String s)
    {
        on = if1;
        super(runnable, s);
    }

    public final void run()
    {
        Process.setThreadPriority(10);
        super.run();
    }
}
