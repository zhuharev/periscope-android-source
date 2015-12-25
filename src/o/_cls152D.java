// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;

final class _cls152D extends _cls1504._cls02CB
{

    _cls152D(String s, int i)
    {
        super(s, 1, (byte)0);
    }

    protected final void _mth02CA(Throwable throwable)
    {
        if (Log.isLoggable("PriorityExecutor", 6))
        {
            Log.e("PriorityExecutor", "Request threw uncaught throwable", throwable);
        }
    }
}
