// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import java.net.Proxy;
import o.wc;
import o.wm;
import o.wn;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Transport, HttpEngine, HttpConnection, OkHeaders, 
//            RealResponseBody, RequestLine, RetryableSink

public final class HttpTransport
    implements Transport
{

    private final HttpConnection httpConnection;
    private final HttpEngine httpEngine;

    public HttpTransport(HttpEngine httpengine, HttpConnection httpconnection)
    {
        httpEngine = httpengine;
        httpConnection = httpconnection;
    }

    private wn getTransferStream(Response response)
    {
        if (!HttpEngine.hasBody(response))
        {
            return httpConnection.newFixedLengthSource(0L);
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding")))
        {
            return httpConnection.newChunkedSource(httpEngine);
        }
        long l = OkHeaders.contentLength(response);
        if (l != -1L)
        {
            return httpConnection.newFixedLengthSource(l);
        } else
        {
            return httpConnection.newUnknownLengthSource();
        }
    }

    public final boolean canReuseConnection()
    {
        if ("close".equalsIgnoreCase(httpEngine.getRequest().header("Connection")))
        {
            return false;
        }
        if ("close".equalsIgnoreCase(httpEngine.getResponse().header("Connection")))
        {
            return false;
        }
        return !httpConnection.isClosed();
    }

    public final wm createRequestBody(Request request, long l)
    {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding")))
        {
            return httpConnection.newChunkedSink();
        }
        if (l != -1L)
        {
            return httpConnection.newFixedLengthSink(l);
        } else
        {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    public final void disconnect(HttpEngine httpengine)
    {
        httpConnection.closeIfOwnedBy(httpengine);
    }

    public final void finishRequest()
    {
        httpConnection.flush();
    }

    public final ResponseBody openResponseBody(Response response)
    {
        wn wn = getTransferStream(response);
        return new RealResponseBody(response.headers(), wc._mth02CB(wn));
    }

    public final com.squareup.okhttp.Response.Builder readResponseHeaders()
    {
        return httpConnection.readResponse();
    }

    public final void releaseConnectionOnIdle()
    {
        if (canReuseConnection())
        {
            httpConnection.poolOnIdle();
            return;
        } else
        {
            httpConnection.closeOnIdle();
            return;
        }
    }

    public final void writeRequestBody(RetryableSink retryablesink)
    {
        httpConnection.writeRequestBody(retryablesink);
    }

    public final void writeRequestHeaders(Request request)
    {
        httpEngine.writingRequestHeaders();
        String s = RequestLine.get(request, httpEngine.getConnection().getRoute().getProxy().type(), httpEngine.getConnection().getProtocol());
        httpConnection.writeRequest(request.headers(), s);
    }
}
