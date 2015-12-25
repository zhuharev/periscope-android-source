// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.ws;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.ws.RealWebSocket;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import o.vu;
import o.vv;

// Referenced classes of package com.squareup.okhttp.ws:
//            WebSocketCall, WebSocketListener

static class connection extends RealWebSocket
{

    private final Connection connection;

    static RealWebSocket create(Response response, Connection connection1, vv vv, vu vu, Random random, WebSocketListener websocketlistener)
    {
        response = response.request().urlString();
        ThreadPoolExecutor threadpoolexecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(), Util.threadFactory(String.format("OkHttp %s WebSocket", new Object[] {
            response
        }), true));
        threadpoolexecutor.allowCoreThreadTimeOut(true);
        return new <init>(connection1, vv, vu, random, threadpoolexecutor, websocketlistener, response);
    }

    protected void closeConnection()
    {
        Internal.instance.closeIfOwnedBy(connection, this);
    }

    private (Connection connection1, vv vv, vu vu, Random random, Executor executor, WebSocketListener websocketlistener, String s)
    {
        super(true, vv, vu, random, executor, websocketlistener, s);
        connection = connection1;
    }
}
