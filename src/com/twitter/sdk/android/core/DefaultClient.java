// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import o.ra;
import o.rl;
import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;

public class DefaultClient
    implements Client
{

    final SSLSocketFactory sslSocketFactory;
    final Client wrappedClient;

    public DefaultClient(SSLSocketFactory sslsocketfactory)
    {
        sslSocketFactory = sslsocketfactory;
        if (hasOkHttpOnClasspath())
        {
            wrappedClient = new _cls1();
            return;
        } else
        {
            wrappedClient = new _cls2();
            return;
        }
    }

    private boolean hasOkHttpOnClasspath()
    {
        boolean flag = false;
        Class.forName("com.squareup.okhttp.OkUrlFactory");
        flag = true;
_L1:
        boolean flag1 = false;
        Class.forName("com.squareup.okhttp.OkHttpClient");
        flag1 = true;
_L2:
        if (flag1 != flag)
        {
            ra._mth0454()._mth02BE("Twitter", "Retrofit detected an unsupported OkHttp on the classpath.\nTo use OkHttp with this version of Retrofit, you'll need:\n1. com.squareup.okhttp:okhttp:1.6.0 (or newer)\n2. com.squareup.okhttp:okhttp-urlconnection:1.6.0 (or newer)\nNote that OkHttp 2.0.0+ is supported!");
            return false;
        } else
        {
            return flag1;
        }
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
          goto _L1
        classnotfoundexception;
          goto _L2
    }

    public Response execute(Request request)
    {
        return wrappedClient.execute(request);
    }

    HttpURLConnection openSslConnection(HttpURLConnection httpurlconnection)
    {
        if (sslSocketFactory != null && (httpurlconnection instanceof HttpsURLConnection))
        {
            ((HttpsURLConnection)httpurlconnection).setSSLSocketFactory(sslSocketFactory);
        }
        return httpurlconnection;
    }

    private class _cls1 extends OkClient
    {

        final DefaultClient this$0;

        protected HttpURLConnection openConnection(Request request)
        {
            return openSslConnection(super.openConnection(request));
        }

        _cls1()
        {
            this$0 = DefaultClient.this;
            super();
        }
    }


    private class _cls2 extends UrlConnectionClient
    {

        final DefaultClient this$0;

        protected HttpURLConnection openConnection(Request request)
        {
            return openSslConnection(super.openConnection(request));
        }

        _cls2()
        {
            this$0 = DefaultClient.this;
            super();
        }
    }

}
