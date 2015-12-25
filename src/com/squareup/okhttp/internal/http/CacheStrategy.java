// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpDate, HeaderParser, OkHeaders

public final class CacheStrategy
{
    public static class Factory
    {

        private int ageSeconds;
        final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        final long nowMillis;
        private long receivedResponseMillis;
        final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        private long cacheResponseAge()
        {
            long l;
            if (servedDate != null)
            {
                l = Math.max(0L, receivedResponseMillis - servedDate.getTime());
            } else
            {
                l = 0L;
            }
            if (ageSeconds != -1)
            {
                l = Math.max(l, TimeUnit.SECONDS.toMillis(ageSeconds));
            }
            return l + (receivedResponseMillis - sentRequestMillis) + (nowMillis - receivedResponseMillis);
        }

        private long computeFreshnessLifetime()
        {
            CacheControl cachecontrol = cacheResponse.cacheControl();
            if (cachecontrol.maxAgeSeconds() != -1)
            {
                return TimeUnit.SECONDS.toMillis(cachecontrol.maxAgeSeconds());
            }
            if (expires != null)
            {
                long l;
                if (servedDate != null)
                {
                    l = servedDate.getTime();
                } else
                {
                    l = receivedResponseMillis;
                }
                l = expires.getTime() - l;
                if (l > 0L)
                {
                    return l;
                } else
                {
                    return 0L;
                }
            }
            if (lastModified != null && cacheResponse.request().url().getQuery() == null)
            {
                long l1;
                if (servedDate != null)
                {
                    l1 = servedDate.getTime();
                } else
                {
                    l1 = sentRequestMillis;
                }
                l1 -= lastModified.getTime();
                if (l1 > 0L)
                {
                    return l1 / 10L;
                } else
                {
                    return 0L;
                }
            } else
            {
                return 0L;
            }
        }

        private CacheStrategy getCandidate()
        {
            if (cacheResponse == null)
            {
                return new CacheStrategy(request, null, null);
            }
            if (request.isHttps() && cacheResponse.handshake() == null)
            {
                return new CacheStrategy(request, null, null);
            }
            if (!CacheStrategy.isCacheable(cacheResponse, request))
            {
                return new CacheStrategy(request, null, null);
            }
            Object obj = request.cacheControl();
            if (((CacheControl) (obj)).noCache() || hasConditions(request))
            {
                return new CacheStrategy(request, null, null);
            }
            long l4 = cacheResponseAge();
            long l1 = computeFreshnessLifetime();
            long l = l1;
            if (((CacheControl) (obj)).maxAgeSeconds() != -1)
            {
                l = Math.min(l1, TimeUnit.SECONDS.toMillis(((CacheControl) (obj)).maxAgeSeconds()));
            }
            l1 = 0L;
            if (((CacheControl) (obj)).minFreshSeconds() != -1)
            {
                l1 = TimeUnit.SECONDS.toMillis(((CacheControl) (obj)).minFreshSeconds());
            }
            long l3 = 0L;
            CacheControl cachecontrol = cacheResponse.cacheControl();
            long l2 = l3;
            if (!cachecontrol.mustRevalidate())
            {
                l2 = l3;
                if (((CacheControl) (obj)).maxStaleSeconds() != -1)
                {
                    l2 = TimeUnit.SECONDS.toMillis(((CacheControl) (obj)).maxStaleSeconds());
                }
            }
            if (!cachecontrol.noCache() && l4 + l1 < l + l2)
            {
                obj = cacheResponse.newBuilder();
                if (l4 + l1 >= l)
                {
                    ((com.squareup.okhttp.Response.Builder) (obj)).addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (l4 > 0x5265c00L && isFreshnessLifetimeHeuristic())
                {
                    ((com.squareup.okhttp.Response.Builder) (obj)).addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new CacheStrategy(null, ((com.squareup.okhttp.Response.Builder) (obj)).build(), null);
            }
            obj = request.newBuilder();
            if (etag != null)
            {
                ((com.squareup.okhttp.Request.Builder) (obj)).header("If-None-Match", etag);
            } else
            if (lastModified != null)
            {
                ((com.squareup.okhttp.Request.Builder) (obj)).header("If-Modified-Since", lastModifiedString);
            } else
            if (servedDate != null)
            {
                ((com.squareup.okhttp.Request.Builder) (obj)).header("If-Modified-Since", servedDateString);
            }
            obj = ((com.squareup.okhttp.Request.Builder) (obj)).build();
            if (hasConditions(((Request) (obj))))
            {
                return new CacheStrategy(((Request) (obj)), cacheResponse, null);
            } else
            {
                return new CacheStrategy(((Request) (obj)), null, null);
            }
        }

        private static boolean hasConditions(Request request1)
        {
            return request1.header("If-Modified-Since") != null || request1.header("If-None-Match") != null;
        }

        private boolean isFreshnessLifetimeHeuristic()
        {
            return cacheResponse.cacheControl().maxAgeSeconds() == -1 && expires == null;
        }

        public CacheStrategy get()
        {
            CacheStrategy cachestrategy = getCandidate();
            if (cachestrategy.networkRequest != null && request.cacheControl().onlyIfCached())
            {
                return new CacheStrategy(null, null, null);
            } else
            {
                return cachestrategy;
            }
        }

        public Factory(long l, Request request1, Response response)
        {
            ageSeconds = -1;
            nowMillis = l;
            request = request1;
            cacheResponse = response;
            if (response != null)
            {
                request1 = response.headers();
                int i = 0;
                for (int j = request1.size(); i < j; i++)
                {
                    response = request1.name(i);
                    String s = request1.value(i);
                    if ("Date".equalsIgnoreCase(response))
                    {
                        servedDate = HttpDate.parse(s);
                        servedDateString = s;
                        continue;
                    }
                    if ("Expires".equalsIgnoreCase(response))
                    {
                        expires = HttpDate.parse(s);
                        continue;
                    }
                    if ("Last-Modified".equalsIgnoreCase(response))
                    {
                        lastModified = HttpDate.parse(s);
                        lastModifiedString = s;
                        continue;
                    }
                    if ("ETag".equalsIgnoreCase(response))
                    {
                        etag = s;
                        continue;
                    }
                    if ("Age".equalsIgnoreCase(response))
                    {
                        ageSeconds = HeaderParser.parseSeconds(s, -1);
                        continue;
                    }
                    if (OkHeaders.SENT_MILLIS.equalsIgnoreCase(response))
                    {
                        sentRequestMillis = Long.parseLong(s);
                        continue;
                    }
                    if (OkHeaders.RECEIVED_MILLIS.equalsIgnoreCase(response))
                    {
                        receivedResponseMillis = Long.parseLong(s);
                    }
                }

            }
        }
    }


    public final Response cacheResponse;
    public final Request networkRequest;

    private CacheStrategy(Request request, Response response)
    {
        networkRequest = request;
        cacheResponse = response;
    }

    CacheStrategy(Request request, Response response, _cls1 _pcls1)
    {
        this(request, response);
    }

    public static boolean isCacheable(Response response, Request request)
    {
        response.code();
        JVM INSTR lookupswitch 13: default 120
    //                   200: 123
    //                   203: 123
    //                   204: 123
    //                   300: 123
    //                   301: 123
    //                   302: 126
    //                   307: 126
    //                   308: 123
    //                   404: 123
    //                   405: 123
    //                   410: 123
    //                   414: 123
    //                   501: 123;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L3 _L3 _L2 _L2 _L2 _L2 _L2 _L2
_L3:
        if (response.header("Expires") != null || response.cacheControl().maxAgeSeconds() != -1 || response.cacheControl().isPublic() || response.cacheControl().isPrivate()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        return !response.cacheControl().noStore() && !request.cacheControl().noStore();
    }
}
