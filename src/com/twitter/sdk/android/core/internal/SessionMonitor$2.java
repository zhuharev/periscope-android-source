// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;


// Referenced classes of package com.twitter.sdk.android.core.internal:
//            SessionMonitor

class this._cls0
    implements Runnable
{

    final SessionMonitor this$0;

    public void run()
    {
        verifyAll();
    }

    ()
    {
        this$0 = SessionMonitor.this;
        super();
    }
}
