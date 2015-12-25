// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.internal.NamedRunnable;

// Referenced classes of package com.squareup.okhttp.internal.ws:
//            RealWebSocket

class val.reason extends NamedRunnable
{

    final val.reason this$1;
    final int val$code;
    final String val$reason;

    protected void execute()
    {
        RealWebSocket.access$100(_fld0, val$code, val$reason);
    }

    transient (int i, String s1)
    {
        this$1 = final_;
        val$code = i;
        val$reason = s1;
        super(final_s, _5B_Ljava.lang.Object_3B_.this);
    }
}
