// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Process;

public abstract class ry
    implements Runnable
{

    public ry()
    {
    }

    public final void run()
    {
        Process.setThreadPriority(10);
        _mth012A();
    }

    public abstract void _mth012A();
}
