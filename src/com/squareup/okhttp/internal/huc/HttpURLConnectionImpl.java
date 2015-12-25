// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpDate;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RetryableSink;
import com.squareup.okhttp.internal.http.StatusLine;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import o.vu;

public class HttpURLConnectionImpl extends HttpURLConnection
{

    private static final Set METHODS = new LinkedHashSet(Arrays.asList(new String[] {
        "OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH"
    }));
    final OkHttpClient client;
    private long fixedContentLength;
    private int followUpCount;
    Handshake handshake;
    protected HttpEngine httpEngine;
    protected IOException httpEngineFailure;
    private com.squareup.okhttp.Headers.Builder requestHeaders;
    private Headers responseHeaders;
    private Route route;

    public HttpURLConnectionImpl(URL url, OkHttpClient okhttpclient)
    {
        super(url);
        requestHeaders = new com.squareup.okhttp.Headers.Builder();
        fixedContentLength = -1L;
        client = okhttpclient;
    }

    private String defaultUserAgent()
    {
        String s = System.getProperty("http.agent");
        if (s != null)
        {
            return s;
        } else
        {
            return (new StringBuilder("Java")).append(System.getProperty("java.version")).toString();
        }
    }

    private boolean execute(boolean flag)
    {
        httpEngine.sendRequest();
        route = httpEngine.getRoute();
        if (httpEngine.getConnection() == null) goto _L2; else goto _L1
_L1:
        Object obj = httpEngine.getConnection().getHandshake();
_L4:
        try
        {
            handshake = ((Handshake) (obj));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            HttpEngine httpengine = httpEngine.recover(((IOException) (obj)));
            if (httpengine != null)
            {
                httpEngine = httpengine;
                return false;
            } else
            {
                httpEngineFailure = ((IOException) (obj));
                throw obj;
            }
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        httpEngine.readResponse();
        return true;
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private Headers getHeaders()
    {
        if (responseHeaders == null)
        {
            Response response = getResponse().getResponse();
            responseHeaders = response.headers().newBuilder().add((new StringBuilder()).append(Platform.get().getPrefix()).append("-Response-Source").toString(), responseSourceHeader(response)).build();
        }
        return responseHeaders;
    }

    private HttpEngine getResponse()
    {
        initHttpEngine();
        if (httpEngine.hasResponse())
        {
            return httpEngine;
        }
        do
        {
            while (!execute(true)) ;
            Response response = httpEngine.getResponse();
            Request request = httpEngine.followUpRequest();
            if (request == null)
            {
                httpEngine.releaseConnection();
                return httpEngine;
            }
            int i = followUpCount + 1;
            followUpCount = i;
            if (i > 20)
            {
                throw new ProtocolException((new StringBuilder("Too many follow-up requests: ")).append(followUpCount).toString());
            }
            url = request.url();
            requestHeaders = request.headers().newBuilder();
            o.wm wm = httpEngine.getRequestBody();
            if (!request.method().equals(method))
            {
                wm = null;
            }
            if (wm != null && !(wm instanceof RetryableSink))
            {
                throw new HttpRetryException("Cannot retry streamed HTTP body", responseCode);
            }
            if (!httpEngine.sameConnection(request.url()))
            {
                httpEngine.releaseConnection();
            }
            Connection connection = httpEngine.close();
            httpEngine = newHttpEngine(request.method(), connection, (RetryableSink)wm, response);
        } while (true);
    }

    private void initHttpEngine()
    {
        if (httpEngineFailure != null)
        {
            throw httpEngineFailure;
        }
        if (httpEngine != null)
        {
            return;
        }
        connected = true;
        try
        {
            if (!doOutput)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            if (method.equals("GET"))
            {
                method = "POST";
                break MISSING_BLOCK_LABEL_94;
            }
        }
        catch (IOException ioexception)
        {
            httpEngineFailure = ioexception;
            throw ioexception;
        }
        if (!HttpMethod.permitsRequestBody(method))
        {
            throw new ProtocolException((new StringBuilder()).append(method).append(" does not support writing").toString());
        }
        httpEngine = newHttpEngine(method, null, null, null);
        return;
    }

    private HttpEngine newHttpEngine(String s, Connection connection, RetryableSink retryablesink, Response response)
    {
        Object obj = (new com.squareup.okhttp.Request.Builder()).url(getURL()).method(s, null);
        Object obj1 = requestHeaders.build();
        int i = 0;
        for (int j = ((Headers) (obj1)).size(); i < j; i++)
        {
            ((com.squareup.okhttp.Request.Builder) (obj)).addHeader(((Headers) (obj1)).name(i), ((Headers) (obj1)).value(i));
        }

        boolean flag1 = false;
        boolean flag = false;
        if (HttpMethod.permitsRequestBody(s))
        {
            if (fixedContentLength != -1L)
            {
                ((com.squareup.okhttp.Request.Builder) (obj)).header("Content-Length", Long.toString(fixedContentLength));
            } else
            if (chunkLength > 0)
            {
                ((com.squareup.okhttp.Request.Builder) (obj)).header("Transfer-Encoding", "chunked");
            } else
            {
                flag = true;
            }
            flag1 = flag;
            if (((Headers) (obj1)).get("Content-Type") == null)
            {
                ((com.squareup.okhttp.Request.Builder) (obj)).header("Content-Type", "application/x-www-form-urlencoded");
                flag1 = flag;
            }
        }
        if (((Headers) (obj1)).get("User-Agent") == null)
        {
            ((com.squareup.okhttp.Request.Builder) (obj)).header("User-Agent", defaultUserAgent());
        }
        obj1 = ((com.squareup.okhttp.Request.Builder) (obj)).build();
        obj = client;
        s = ((String) (obj));
        if (Internal.instance.internalCache(((OkHttpClient) (obj))) != null)
        {
            s = ((String) (obj));
            if (!getUseCaches())
            {
                s = client.clone().setCache(null);
            }
        }
        return new HttpEngine(s, ((Request) (obj1)), flag1, true, false, connection, null, retryablesink, response);
    }

    private static String responseSourceHeader(Response response)
    {
        if (response.networkResponse() == null)
        {
            if (response.cacheResponse() == null)
            {
                return "NONE";
            } else
            {
                return (new StringBuilder("CACHE ")).append(response.code()).toString();
            }
        }
        if (response.cacheResponse() == null)
        {
            return (new StringBuilder("NETWORK ")).append(response.code()).toString();
        } else
        {
            return (new StringBuilder("CONDITIONAL_CACHE ")).append(response.networkResponse().code()).toString();
        }
    }

    private void setProtocols(String s, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        if (flag)
        {
            arraylist.addAll(client.getProtocols());
        }
        s = s.split(",", -1);
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            String s1 = s[i];
            try
            {
                arraylist.add(Protocol.get(s1));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new IllegalStateException(s);
            }
        }

        client.setProtocols(arraylist);
    }

    public final void addRequestProperty(String s, String s1)
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot add request property after connection is made");
        }
        if (s == null)
        {
            throw new NullPointerException("field == null");
        }
        if (s1 == null)
        {
            Platform.get().logW((new StringBuilder("Ignoring header ")).append(s).append(" because its value was null.").toString());
            return;
        }
        if ("X-Android-Transports".equals(s) || "X-Android-Protocols".equals(s))
        {
            setProtocols(s1, true);
            return;
        } else
        {
            requestHeaders.add(s, s1);
            return;
        }
    }

    public final void connect()
    {
        initHttpEngine();
        while (!execute(false)) ;
    }

    public final void disconnect()
    {
        if (httpEngine == null)
        {
            return;
        } else
        {
            httpEngine.disconnect();
            return;
        }
    }

    public int getConnectTimeout()
    {
        return client.getConnectTimeout();
    }

    public final InputStream getErrorStream()
    {
        IOException ioexception;
label0:
        {
            Object obj;
            try
            {
                obj = getResponse();
                if (!HttpEngine.hasBody(((HttpEngine) (obj)).getResponse()) || ((HttpEngine) (obj)).getResponse().code() < 400)
                {
                    break label0;
                }
                obj = ((HttpEngine) (obj)).getResponse().body().byteStream();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                return null;
            }
            return ((InputStream) (obj));
        }
        return null;
    }

    public final String getHeaderField(int i)
    {
        IOException ioexception;
        String s;
        try
        {
            s = getHeaders().value(i);
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return null;
        }
        return s;
    }

    public final String getHeaderField(String s)
    {
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        return StatusLine.get(getResponse().getResponse()).toString();
        s = getHeaders().get(s);
        return s;
_L2:
        return null;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final String getHeaderFieldKey(int i)
    {
        IOException ioexception;
        String s;
        try
        {
            s = getHeaders().name(i);
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return null;
        }
        return s;
    }

    public final Map getHeaderFields()
    {
        IOException ioexception;
        Map map;
        try
        {
            map = OkHeaders.toMultimap(getHeaders(), StatusLine.get(getResponse().getResponse()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return Collections.emptyMap();
        }
        return map;
    }

    public final InputStream getInputStream()
    {
        if (!doInput)
        {
            throw new ProtocolException("This protocol does not support input");
        }
        HttpEngine httpengine = getResponse();
        if (getResponseCode() >= 400)
        {
            throw new FileNotFoundException(url.toString());
        } else
        {
            return httpengine.getResponse().body().byteStream();
        }
    }

    public final OutputStream getOutputStream()
    {
        connect();
        vu vu1 = httpEngine.getBufferedRequestBody();
        if (vu1 == null)
        {
            throw new ProtocolException((new StringBuilder("method does not support a request body: ")).append(method).toString());
        }
        if (httpEngine.hasResponse())
        {
            throw new ProtocolException("cannot write request body after response has been read");
        } else
        {
            return vu1.FEE4();
        }
    }

    public final Permission getPermission()
    {
        String s = getURL().getHost();
        int i = Util.getEffectivePort(getURL());
        if (usingProxy())
        {
            InetSocketAddress inetsocketaddress = (InetSocketAddress)client.getProxy().address();
            s = inetsocketaddress.getHostName();
            i = inetsocketaddress.getPort();
        }
        return new SocketPermission((new StringBuilder()).append(s).append(":").append(i).toString(), "connect, resolve");
    }

    public int getReadTimeout()
    {
        return client.getReadTimeout();
    }

    public final Map getRequestProperties()
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot access request header fields after connection is set");
        } else
        {
            return OkHeaders.toMultimap(requestHeaders.build(), null);
        }
    }

    public final String getRequestProperty(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return requestHeaders.get(s);
        }
    }

    public final int getResponseCode()
    {
        return getResponse().getResponse().code();
    }

    public String getResponseMessage()
    {
        return getResponse().getResponse().message();
    }

    public void setConnectTimeout(int i)
    {
        client.setConnectTimeout(i, TimeUnit.MILLISECONDS);
    }

    public void setFixedLengthStreamingMode(int i)
    {
        setFixedLengthStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(long l)
    {
        if (super.connected)
        {
            throw new IllegalStateException("Already connected");
        }
        if (chunkLength > 0)
        {
            throw new IllegalStateException("Already in chunked mode");
        }
        if (l < 0L)
        {
            throw new IllegalArgumentException("contentLength < 0");
        } else
        {
            fixedContentLength = l;
            super.fixedContentLength = (int)Math.min(l, 0x7fffffffL);
            return;
        }
    }

    public void setIfModifiedSince(long l)
    {
        super.setIfModifiedSince(l);
        if (ifModifiedSince != 0L)
        {
            requestHeaders.set("If-Modified-Since", HttpDate.format(new Date(ifModifiedSince)));
            return;
        } else
        {
            requestHeaders.removeAll("If-Modified-Since");
            return;
        }
    }

    public void setInstanceFollowRedirects(boolean flag)
    {
        client.setFollowRedirects(flag);
    }

    public void setReadTimeout(int i)
    {
        client.setReadTimeout(i, TimeUnit.MILLISECONDS);
    }

    public void setRequestMethod(String s)
    {
        if (!METHODS.contains(s))
        {
            throw new ProtocolException((new StringBuilder("Expected one of ")).append(METHODS).append(" but was ").append(s).toString());
        } else
        {
            method = s;
            return;
        }
    }

    public final void setRequestProperty(String s, String s1)
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot set request property after connection is made");
        }
        if (s == null)
        {
            throw new NullPointerException("field == null");
        }
        if (s1 == null)
        {
            Platform.get().logW((new StringBuilder("Ignoring header ")).append(s).append(" because its value was null.").toString());
            return;
        }
        if ("X-Android-Transports".equals(s) || "X-Android-Protocols".equals(s))
        {
            setProtocols(s1, false);
            return;
        } else
        {
            requestHeaders.set(s, s1);
            return;
        }
    }

    public final boolean usingProxy()
    {
        Proxy proxy;
        if (route != null)
        {
            proxy = route.getProxy();
        } else
        {
            proxy = client.getProxy();
        }
        return proxy != null && proxy.type() != java.net.Proxy.Type.DIRECT;
    }

}
