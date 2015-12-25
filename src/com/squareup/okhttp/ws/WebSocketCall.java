// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.ws;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.ws.RealWebSocket;
import java.net.ProtocolException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import o.vq;
import o.vu;
import o.vv;
import o.vw;
import o.wc;

// Referenced classes of package com.squareup.okhttp.ws:
//            WebSocketListener

public class WebSocketCall
{
    static class ConnectionWebSocket extends RealWebSocket
    {

        private final Connection connection;

        static RealWebSocket create(Response response, Connection connection1, vv vv, vu vu, Random random1, WebSocketListener websocketlistener)
        {
            response = response.request().urlString();
            ThreadPoolExecutor threadpoolexecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(), Util.threadFactory(String.format("OkHttp %s WebSocket", new Object[] {
                response
            }), true));
            threadpoolexecutor.allowCoreThreadTimeOut(true);
            return new ConnectionWebSocket(connection1, vv, vu, random1, threadpoolexecutor, websocketlistener, response);
        }

        protected void closeConnection()
        {
            Internal.instance.closeIfOwnedBy(connection, this);
        }

        private ConnectionWebSocket(Connection connection1, vv vv, vu vu, Random random1, Executor executor, WebSocketListener websocketlistener, String s)
        {
            super(true, vv, vu, random1, executor, websocketlistener, s);
            connection = connection1;
        }
    }


    private final Call call;
    private final String key;
    private final Random random;
    private final Request request;

    protected WebSocketCall(OkHttpClient okhttpclient, Request request1)
    {
        this(okhttpclient, request1, ((Random) (new SecureRandom())));
    }

    WebSocketCall(OkHttpClient okhttpclient, Request request1, Random random1)
    {
        if (!"GET".equals(request1.method()))
        {
            throw new IllegalArgumentException((new StringBuilder("Request must be GET: ")).append(request1.method()).toString());
        }
        String s = request1.urlString();
        if (s.startsWith("ws://"))
        {
            s = (new StringBuilder("http://")).append(s.substring(5)).toString();
        } else
        if (s.startsWith("wss://"))
        {
            s = (new StringBuilder("https://")).append(s.substring(6)).toString();
        } else
        if (!s.startsWith("http://") && !s.startsWith("https://"))
        {
            throw new IllegalArgumentException((new StringBuilder("Request url must use 'ws', 'wss', 'http', or 'https' scheme: ")).append(s).toString());
        }
        random = random1;
        byte abyte0[] = new byte[16];
        random1.nextBytes(abyte0);
        key = vq._mth02BF(vw._mth02C9(abyte0).data);
        okhttpclient = okhttpclient.clone();
        okhttpclient.setProtocols(Collections.singletonList(Protocol.HTTP_1_1));
        request1 = request1.newBuilder().url(s).header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", key).header("Sec-WebSocket-Version", "13").build();
        request = request1;
        call = okhttpclient.newCall(request1);
    }

    public static WebSocketCall create(OkHttpClient okhttpclient, Request request1)
    {
        return new WebSocketCall(okhttpclient, request1);
    }

    private void createWebSocket(Response response, WebSocketListener websocketlistener)
    {
        if (response.code() != 101)
        {
            Internal.instance.callEngineReleaseConnection(call);
            throw new ProtocolException((new StringBuilder("Expected HTTP 101 response but was '")).append(response.code()).append(" ").append(response.message()).append("'").toString());
        }
        Object obj = response.header("Connection");
        if (!"Upgrade".equalsIgnoreCase(((String) (obj))))
        {
            throw new ProtocolException((new StringBuilder("Expected 'Connection' header value 'Upgrade' but was '")).append(((String) (obj))).append("'").toString());
        }
        obj = response.header("Upgrade");
        if (!"websocket".equalsIgnoreCase(((String) (obj))))
        {
            throw new ProtocolException((new StringBuilder("Expected 'Upgrade' header value 'websocket' but was '")).append(((String) (obj))).append("'").toString());
        }
        obj = response.header("Sec-WebSocket-Accept");
        String s = Util.shaBase64((new StringBuilder()).append(key).append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11").toString());
        if (!s.equals(obj))
        {
            throw new ProtocolException((new StringBuilder("Expected 'Sec-WebSocket-Accept' header value '")).append(s).append("' but was '").append(((String) (obj))).append("'").toString());
        }
        obj = Internal.instance.callEngineGetConnection(call);
        if (!Internal.instance.clearOwner(((Connection) (obj))))
        {
            throw new IllegalStateException("Unable to take ownership of connection.");
        } else
        {
            Object obj1 = ((Connection) (obj)).getSocket();
            obj1 = ConnectionWebSocket.create(response, ((Connection) (obj)), wc._mth02CB(wc._mth02CB(((java.net.Socket) (obj1)))), wc._mth02CA(wc._mth02CA(((java.net.Socket) (obj1)))), random, websocketlistener);
            (new Thread(new _cls2(new Object[] {
                request.urlString()
            }, ((RealWebSocket) (obj1))))).start();
            Internal.instance.connectionSetOwner(((Connection) (obj)), obj1);
            websocketlistener.onOpen(((WebSocket) (obj1)), request, response);
            return;
        }
    }

    public void cancel()
    {
        call.cancel();
    }

    public void enqueue(final WebSocketListener listener)
    {
        listener = new _cls1();
        Internal.instance.callEnqueue(call, listener, true);
    }


    private class _cls2 extends NamedRunnable
    {

        final WebSocketCall this$0;
        final RealWebSocket val$webSocket;

        protected void execute()
        {
            while (webSocket.readMessage()) ;
        }

        transient _cls2(Object aobj[], RealWebSocket realwebsocket)
        {
            this$0 = WebSocketCall.this;
            webSocket = realwebsocket;
            super(final_s, aobj);
        }
    }


    private class _cls1
        implements Callback
    {

        final WebSocketCall this$0;
        final WebSocketListener val$listener;

        public void onFailure(Request request1, IOException ioexception)
        {
            listener.onFailure(ioexception);
        }

        public void onResponse(Response response)
        {
            try
            {
                createWebSocket(response, listener);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Response response)
            {
                listener.onFailure(response);
            }
        }

        _cls1()
        {
            this$0 = WebSocketCall.this;
            listener = websocketlistener;
            super();
        }
    }

}
