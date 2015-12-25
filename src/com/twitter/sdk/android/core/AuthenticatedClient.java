// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.internal.TwitterRequestHeaders;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import retrofit.client.Client;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.FormUrlEncodedTypedOutput;
import retrofit.mime.TypedOutput;

// Referenced classes of package com.twitter.sdk.android.core:
//            DefaultClient, TwitterAuthConfig, Session

public class AuthenticatedClient extends DefaultClient
{

    private static final String FAKE_URL = "https://twitter.com";
    private final TwitterAuthConfig authConfig;
    private final Session session;

    public AuthenticatedClient(TwitterAuthConfig twitterauthconfig, Session session1, SSLSocketFactory sslsocketfactory)
    {
        super(sslsocketfactory);
        authConfig = twitterauthconfig;
        session = session1;
    }

    public Response execute(Request request)
    {
        request = new Request(request.getMethod(), request.getUrl(), getAuthHeaders(request), request.getBody());
        return wrappedClient.execute(request);
    }

    protected List getAuthHeaders(Request request)
    {
        Object obj = new TwitterRequestHeaders(request.getMethod(), request.getUrl(), authConfig, session, null, getPostParams(request));
        request = new ArrayList(request.getHeaders());
        java.util.Map.Entry entry;
        for (obj = ((TwitterRequestHeaders) (obj)).getHeaders().entrySet().iterator(); ((Iterator) (obj)).hasNext(); request.add(new Header((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        return request;
    }

    protected Map getPostParams(Request request)
    {
        TreeMap treemap = new TreeMap();
        if ("POST".equals(request.getMethod().toUpperCase(Locale.US)))
        {
            request = request.getBody();
            if (request instanceof FormUrlEncodedTypedOutput)
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                request.writeTo(bytearrayoutputstream);
                request = bytearrayoutputstream.toString("UTF-8");
                if (request.length() > 0)
                {
                    NameValuePair namevaluepair;
                    for (request = URLEncodedUtils.parse(URI.create((new StringBuilder("https://twitter.com/?")).append(request).toString()), "UTF-8").iterator(); request.hasNext(); treemap.put(namevaluepair.getName(), namevaluepair.getValue()))
                    {
                        namevaluepair = (NameValuePair)request.next();
                    }

                }
            }
        }
        return treemap;
    }
}
