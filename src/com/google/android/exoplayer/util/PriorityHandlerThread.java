// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import android.os.HandlerThread;
import android.os.Process;

public final class PriorityHandlerThread extends HandlerThread
{

    private final int priority;

    public PriorityHandlerThread(String s, int i)
    {
        super(s);
        priority = i;
    }

    public final void run()
    {
        Process.setThreadPriority(priority);
        super.run();
    }
}
