// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.squareup.okhttp:
//            OkHttpClient, Request, Dispatcher, RequestBody, 
//            MediaType, Response, Callback, Interceptor, 
//            Connection

public class Call
{
    class ApplicationInterceptorChain
        implements Interceptor.Chain
    {

        private final boolean forWebSocket;
        private final int index;
        private final Request request;
        final Call this$0;

        public Connection connection()
        {
            return null;
        }

        public Response proceed(Request request1)
        {
            if (index < client.interceptors().size())
            {
                request1 = new ApplicationInterceptorChain(index + 1, request1, forWebSocket);
                return ((Interceptor)client.interceptors().get(index)).intercept(request1);
            } else
            {
                return getResponse(request1, forWebSocket);
            }
        }

        public Request request()
        {
            return request;
        }

        ApplicationInterceptorChain(int i, Request request1, boolean flag)
        {
            this$0 = Call.this;
            super();
            index = i;
            request = request1;
            forWebSocket = flag;
        }
    }

    final class AsyncCall extends NamedRunnable
    {

        private final boolean forWebSocket;
        private final Callback responseCallback;
        final Call this$0;

        final void cancel()
        {
            Call.this.cancel();
        }

        protected final void execute()
        {
            boolean flag;
            boolean flag1;
            flag1 = false;
            flag = flag1;
            Response response = getResponseWithInterceptorChain(forWebSocket);
            flag = flag1;
            if (!canceled)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            flag = true;
            responseCallback.onFailure(originalRequest, new IOException("Canceled"));
            break MISSING_BLOCK_LABEL_70;
            flag = true;
            responseCallback.onResponse(response);
            client.getDispatcher().finished(this);
            return;
            Object obj;
            obj;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_125;
            }
            Internal.logger.log(Level.INFO, (new StringBuilder("Callback failure for ")).append(toLoggableString()).toString(), ((Throwable) (obj)));
            break MISSING_BLOCK_LABEL_145;
            responseCallback.onFailure(engine.getRequest(), ((IOException) (obj)));
            client.getDispatcher().finished(this);
            return;
            obj;
            client.getDispatcher().finished(this);
            throw obj;
        }

        final Call get()
        {
            return Call.this;
        }

        final String host()
        {
            return originalRequest.url().getHost();
        }

        final Request request()
        {
            return originalRequest;
        }

        final Object tag()
        {
            return originalRequest.tag();
        }

        private AsyncCall(Callback callback, boolean flag)
        {
            this$0 = Call.this;
            super("OkHttp %s", new Object[] {
                originalRequest.urlString()
            });
            responseCallback = callback;
            forWebSocket = flag;
        }

        AsyncCall(Callback callback, boolean flag, _cls1 _pcls1)
        {
            this(callback, flag);
        }
    }


    volatile boolean canceled;
    private final OkHttpClient client;
    HttpEngine engine;
    private boolean executed;
    Request originalRequest;

    protected Call(OkHttpClient okhttpclient, Request request)
    {
        client = okhttpclient.copyWithDefaults();
        originalRequest = request;
    }

    private Response getResponseWithInterceptorChain(boolean flag)
    {
        return (new ApplicationInterceptorChain(0, originalRequest, flag)).proceed(originalRequest);
    }

    private String toLoggableString()
    {
        String s;
        if (canceled)
        {
            s = "canceled call";
        } else
        {
            s = "call";
        }
        String s1;
        try
        {
            s1 = (new URL(originalRequest.url(), "/...")).toString();
            s1 = (new StringBuilder()).append(s).append(" to ").append(s1).toString();
        }
        catch (MalformedURLException malformedurlexception)
        {
            return s;
        }
        return s1;
    }

    public void cancel()
    {
        canceled = true;
        if (engine != null)
        {
            engine.disconnect();
        }
    }

    public void enqueue(Callback callback)
    {
        enqueue(callback, false);
    }

    void enqueue(Callback callback, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (executed)
        {
            throw new IllegalStateException("Already Executed");
        }
        executed = true;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        callback;
        throw callback;
_L1:
        client.getDispatcher().enqueue(new AsyncCall(callback, flag, null));
        return;
    }

    public Response execute()
    {
        this;
        JVM INSTR monitorenter ;
        if (executed)
        {
            throw new IllegalStateException("Already Executed");
        }
        executed = true;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_34;
        Exception exception;
        exception;
        throw exception;
        Response response;
        client.getDispatcher().executed(this);
        response = getResponseWithInterceptorChain(false);
        if (response != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new IOException("Canceled");
        client.getDispatcher().finished(this);
        return response;
        response;
        client.getDispatcher().finished(this);
        throw response;
    }

    Response getResponse(Request request, boolean flag)
    {
        RequestBody requestbody = request.body();
        Object obj = request;
        if (requestbody != null)
        {
            request = request.newBuilder();
            obj = requestbody.contentType();
            if (obj != null)
            {
                request.header("Content-Type", ((MediaType) (obj)).toString());
            }
            long l = requestbody.contentLength();
            if (l != -1L)
            {
                request.header("Content-Length", Long.toString(l));
                request.removeHeader("Transfer-Encoding");
            } else
            {
                request.header("Transfer-Encoding", "chunked");
                request.removeHeader("Content-Length");
            }
            obj = request.build();
        }
        engine = new HttpEngine(client, ((Request) (obj)), false, false, flag, null, null, null, null);
        int i = 0;
        do
        {
            if (canceled)
            {
                engine.releaseConnection();
                return null;
            }
            try
            {
                engine.sendRequest();
                engine.readResponse();
            }
            // Misplaced declaration of an exception variable
            catch (Request request)
            {
                HttpEngine httpengine = engine.recover(request, null);
                if (httpengine != null)
                {
                    engine = httpengine;
                } else
                {
                    throw request;
                }
                continue;
            }
            request = engine.getResponse();
            Request request1 = engine.followUpRequest();
            if (request1 == null)
            {
                if (!flag)
                {
                    engine.releaseConnection();
                }
                return request;
            }
            i++;
            if (i > 20)
            {
                throw new ProtocolException((new StringBuilder("Too many follow-up requests: ")).append(i).toString());
            }
            if (!engine.sameConnection(request1.url()))
            {
                engine.releaseConnection();
            }
            Connection connection = engine.close();
            engine = new HttpEngine(client, request1, false, false, flag, connection, null, null, request);
        } while (true);
    }

    public boolean isCanceled()
    {
        return canceled;
    }

    Object tag()
    {
        return originalRequest.tag();
    }



}
