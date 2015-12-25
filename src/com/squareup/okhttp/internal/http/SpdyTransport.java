// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.Header;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.spdy.SpdyStream;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import o.vw;
import o.wc;
import o.wm;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Transport, OkHeaders, StatusLine, RequestLine, 
//            HttpEngine, RealResponseBody, RetryableSink

public final class SpdyTransport
    implements Transport
{

    private static final List HTTP_2_PROHIBITED_HEADERS = Util.immutableList(new vw[] {
        vw._mth02C0("connection"), vw._mth02C0("host"), vw._mth02C0("keep-alive"), vw._mth02C0("proxy-connection"), vw._mth02C0("te"), vw._mth02C0("transfer-encoding"), vw._mth02C0("encoding"), vw._mth02C0("upgrade")
    });
    private static final List SPDY_3_PROHIBITED_HEADERS = Util.immutableList(new vw[] {
        vw._mth02C0("connection"), vw._mth02C0("host"), vw._mth02C0("keep-alive"), vw._mth02C0("proxy-connection"), vw._mth02C0("transfer-encoding")
    });
    private final HttpEngine httpEngine;
    private final SpdyConnection spdyConnection;
    private SpdyStream stream;

    public SpdyTransport(HttpEngine httpengine, SpdyConnection spdyconnection)
    {
        httpEngine = httpengine;
        spdyConnection = spdyconnection;
    }

    private static boolean isProhibitedHeader(Protocol protocol, vw vw1)
    {
        if (protocol == Protocol.SPDY_3)
        {
            return SPDY_3_PROHIBITED_HEADERS.contains(vw1);
        }
        if (protocol == Protocol.HTTP_2)
        {
            return HTTP_2_PROHIBITED_HEADERS.contains(vw1);
        } else
        {
            throw new AssertionError(protocol);
        }
    }

    private static String joinOnNull(String s, String s1)
    {
        return (new StringBuilder(s)).append('\0').append(s1).toString();
    }

    public static com.squareup.okhttp.Response.Builder readNameValueBlock(List list, Protocol protocol)
    {
        String s1 = null;
        String s = "HTTP/1.1";
        com.squareup.okhttp.Headers.Builder builder = new com.squareup.okhttp.Headers.Builder();
        builder.set(OkHeaders.SELECTED_PROTOCOL, protocol.toString());
        int i = 0;
        for (int i1 = list.size(); i < i1; i++)
        {
            vw vw1 = ((Header)list.get(i)).name;
            String s5 = ((Header)list.get(i)).value._mth0178();
            for (int j = 0; j < s5.length();)
            {
                int l = s5.indexOf('\0', j);
                int k = l;
                if (l == -1)
                {
                    k = s5.length();
                }
                String s3 = s5.substring(j, k);
                String s2;
                String s4;
                if (vw1.equals(Header.RESPONSE_STATUS))
                {
                    s2 = s3;
                    s4 = s;
                } else
                if (vw1.equals(Header.VERSION))
                {
                    s2 = s1;
                    s4 = s3;
                } else
                {
                    s2 = s1;
                    s4 = s;
                    if (!isProhibitedHeader(protocol, vw1))
                    {
                        builder.add(vw1._mth0178(), s3);
                        s4 = s;
                        s2 = s1;
                    }
                }
                j = k + 1;
                s1 = s2;
                s = s4;
            }

        }

        if (s1 == null)
        {
            throw new ProtocolException("Expected ':status' header not present");
        } else
        {
            list = StatusLine.parse((new StringBuilder()).append(s).append(" ").append(s1).toString());
            return (new com.squareup.okhttp.Response.Builder()).protocol(protocol).code(((StatusLine) (list)).code).message(((StatusLine) (list)).message).headers(builder.build());
        }
    }

    public static List writeNameValueBlock(Request request, Protocol protocol, String s)
    {
        Headers headers = request.headers();
        ArrayList arraylist = new ArrayList(headers.size() + 10);
        arraylist.add(new Header(Header.TARGET_METHOD, request.method()));
        arraylist.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        String s1 = HttpEngine.hostHeader(request.url());
        if (Protocol.SPDY_3 == protocol)
        {
            arraylist.add(new Header(Header.VERSION, s));
            arraylist.add(new Header(Header.TARGET_HOST, s1));
        } else
        if (Protocol.HTTP_2 == protocol)
        {
            arraylist.add(new Header(Header.TARGET_AUTHORITY, s1));
        } else
        {
            throw new AssertionError();
        }
        arraylist.add(new Header(Header.TARGET_SCHEME, request.url().getProtocol()));
        request = new LinkedHashSet();
        int i = 0;
label0:
        for (int k = headers.size(); i < k; i++)
        {
            s = vw._mth02C0(headers.name(i).toLowerCase(Locale.US));
            String s2 = headers.value(i);
            if (isProhibitedHeader(protocol, s) || s.equals(Header.TARGET_METHOD) || s.equals(Header.TARGET_PATH) || s.equals(Header.TARGET_SCHEME) || s.equals(Header.TARGET_AUTHORITY) || s.equals(Header.TARGET_HOST) || s.equals(Header.VERSION))
            {
                continue;
            }
            if (request.add(s))
            {
                arraylist.add(new Header(s, s2));
                continue;
            }
            int j = 0;
            do
            {
                if (j >= arraylist.size())
                {
                    continue label0;
                }
                if (((Header)arraylist.get(j)).name.equals(s))
                {
                    arraylist.set(j, new Header(s, joinOnNull(((Header)arraylist.get(j)).value._mth0178(), s2)));
                    continue label0;
                }
                j++;
            } while (true);
        }

        return arraylist;
    }

    public final boolean canReuseConnection()
    {
        return true;
    }

    public final wm createRequestBody(Request request, long l)
    {
        return stream.getSink();
    }

    public final void disconnect(HttpEngine httpengine)
    {
        if (stream != null)
        {
            stream.close(ErrorCode.CANCEL);
        }
    }

    public final void finishRequest()
    {
        stream.getSink().close();
    }

    public final ResponseBody openResponseBody(Response response)
    {
        return new RealResponseBody(response.headers(), wc._mth02CB(stream.getSource()));
    }

    public final com.squareup.okhttp.Response.Builder readResponseHeaders()
    {
        return readNameValueBlock(stream.getResponseHeaders(), spdyConnection.getProtocol());
    }

    public final void releaseConnectionOnIdle()
    {
    }

    public final void writeRequestBody(RetryableSink retryablesink)
    {
        retryablesink.writeToSocket(stream.getSink());
    }

    public final void writeRequestHeaders(Request request)
    {
        if (stream != null)
        {
            return;
        } else
        {
            httpEngine.writingRequestHeaders();
            boolean flag = httpEngine.permitsRequestBody();
            String s = RequestLine.version(httpEngine.getConnection().getProtocol());
            stream = spdyConnection.newStream(writeNameValueBlock(request, spdyConnection.getProtocol(), s), flag, true);
            stream.readTimeout().timeout(httpEngine.client.getReadTimeout(), TimeUnit.MILLISECONDS);
            return;
        }
    }

}
