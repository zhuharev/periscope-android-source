// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.ws;

import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.ws.RealWebSocket;

// Referenced classes of package com.squareup.okhttp.ws:
//            WebSocketCall

class ble extends NamedRunnable
{

    final WebSocketCall this$0;
    final RealWebSocket val$webSocket;

    protected void execute()
    {
        while (val$webSocket.readMessage()) ;
    }

    transient Socket(Object aobj[], RealWebSocket realwebsocket)
    {
        this$0 = final_websocketcall;
        val$webSocket = realwebsocket;
        super(String.this, aobj);
    }
}
