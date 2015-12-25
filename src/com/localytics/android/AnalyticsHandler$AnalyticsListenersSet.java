// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.Map;

// Referenced classes of package com.localytics.android:
//            AnalyticsListener, AnalyticsHandler

final class <init> extends <init>
    implements AnalyticsListener
{

    final AnalyticsHandler this$0;

    public final void localyticsDidTagEvent(String s, Map map, long l)
    {
        this;
        JVM INSTR monitorenter ;
        callListeners("localyticsDidTagEvent", new Class[] {
            java/lang/String, java/util/Map, Long.TYPE
        }, new Object[] {
            s, map, Long.valueOf(l)
        });
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final void localyticsSessionDidOpen(boolean flag, boolean flag1, boolean flag2)
    {
        this;
        JVM INSTR monitorenter ;
        callListeners("localyticsSessionDidOpen", new Class[] {
            Boolean.TYPE, Boolean.TYPE, Boolean.TYPE
        }, new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(flag1), Boolean.valueOf(flag2)
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void localyticsSessionWillClose()
    {
        this;
        JVM INSTR monitorenter ;
        callListeners("localyticsSessionWillClose", null, null);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void localyticsSessionWillOpen(boolean flag, boolean flag1, boolean flag2)
    {
        this;
        JVM INSTR monitorenter ;
        callListeners("localyticsSessionWillOpen", new Class[] {
            Boolean.TYPE, Boolean.TYPE, Boolean.TYPE
        }, new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(flag1), Boolean.valueOf(flag2)
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private ()
    {
        this$0 = AnalyticsHandler.this;
        super(AnalyticsHandler.this);
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
