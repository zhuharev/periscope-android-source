// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.CacheStrategy;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import com.squareup.okhttp.internal.io.FileSystem;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import o.vq;
import o.vr;
import o.vt;
import o.vu;
import o.vv;
import o.vw;
import o.vy;
import o.vz;
import o.wc;
import o.wm;
import o.wn;

// Referenced classes of package com.squareup.okhttp:
//            Response, Request, ResponseBody, MediaType, 
//            Handshake, Headers, Protocol

public final class Cache
{
    static class CacheResponseBody extends ResponseBody
    {

        private final vv bodySource;
        private final String contentLength;
        private final String contentType;
        private final com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot;

        public long contentLength()
        {
            NumberFormatException numberformatexception;
label0:
            {
                long l;
                try
                {
                    if (contentLength == null)
                    {
                        break label0;
                    }
                    l = Long.parseLong(contentLength);
                }
                // Misplaced declaration of an exception variable
                catch (NumberFormatException numberformatexception)
                {
                    return -1L;
                }
                return l;
            }
            return -1L;
        }

        public MediaType contentType()
        {
            if (contentType != null)
            {
                return MediaType.parse(contentType);
            } else
            {
                return null;
            }
        }

        public vv source()
        {
            return bodySource;
        }


        public CacheResponseBody(com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot1, String s, String s1)
        {
            snapshot = snapshot1;
            contentType = s;
            contentLength = s1;
            class _cls1 extends vz
            {

                final CacheResponseBody this$0;
                final com.squareup.okhttp.internal.DiskLruCache.Snapshot val$snapshot;

                public void close()
                {
                    snapshot.close();
                    close();
                }

                _cls1(com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot1)
                {
                    this$0 = CacheResponseBody.this;
                    snapshot = snapshot1;
                    vz(final_wn);
                }
            }

            bodySource = wc._mth02CB(new _cls1(snapshot1));
        }
    }

    static final class Entry
    {

        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final String url;
        private final Headers varyHeaders;

        private boolean isHttps()
        {
            return url.startsWith("https://");
        }

        private List readCertificateList(vv vv1)
        {
            int j = Cache.readInt(vv1);
            if (j == -1)
            {
                return Collections.emptyList();
            }
            CertificateFactory certificatefactory;
            ArrayList arraylist;
            vr vr1;
            Object obj;
            int i;
            try
            {
                certificatefactory = CertificateFactory.getInstance("X.509");
                arraylist = new ArrayList(j);
            }
            // Misplaced declaration of an exception variable
            catch (vv vv1)
            {
                throw new IOException(vv1.getMessage());
            }
            i = 0;
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = vv1.FF90();
            vr1 = new vr();
            obj = vw._mth02E2(((String) (obj)));
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_81;
            }
            throw new IllegalArgumentException("byteString == null");
            ((vw) (obj))._mth02CA(vr1);
            arraylist.add(certificatefactory.generateCertificate(new vt(vr1)));
            i++;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_35;
_L1:
            return arraylist;
        }

        private void writeCertList(vu vu1, List list)
        {
            int i;
            int j;
            try
            {
                vu1.FF9E(list.size());
                vu1._mth04C0(10);
            }
            // Misplaced declaration of an exception variable
            catch (vu vu1)
            {
                throw new IOException(vu1.getMessage());
            }
            i = 0;
            j = list.size();
_L2:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            vu1._mth02B8(vq._mth02BF(vw._mth02C9(((Certificate)list.get(i)).getEncoded()).data));
            vu1._mth04C0(10);
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public final boolean matches(Request request, Response response1)
        {
            return url.equals(request.urlString()) && requestMethod.equals(request.method()) && OkHeaders.varyMatches(response1, varyHeaders, request);
        }

        public final Response response(Request request, com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot)
        {
            request = responseHeaders.get("Content-Type");
            String s = responseHeaders.get("Content-Length");
            Request request1 = (new Request.Builder()).url(url).method(requestMethod, null).headers(varyHeaders).build();
            return (new Response.Builder()).request(request1).protocol(protocol).code(code).message(message).headers(responseHeaders).body(new CacheResponseBody(snapshot, request, s)).handshake(handshake).build();
        }

        public final void writeTo(com.squareup.okhttp.internal.DiskLruCache.Editor editor)
        {
            editor = wc._mth02CA(editor.newSink(0));
            editor._mth02B8(url);
            editor._mth04C0(10);
            editor._mth02B8(requestMethod);
            editor._mth04C0(10);
            editor.FF9E(varyHeaders.size());
            editor._mth04C0(10);
            int i = 0;
            for (int j = varyHeaders.size(); i < j; i++)
            {
                editor._mth02B8(varyHeaders.name(i));
                editor._mth02B8(": ");
                editor._mth02B8(varyHeaders.value(i));
                editor._mth04C0(10);
            }

            editor._mth02B8((new StatusLine(protocol, code, message)).toString());
            editor._mth04C0(10);
            editor.FF9E(responseHeaders.size());
            editor._mth04C0(10);
            i = 0;
            for (int k = responseHeaders.size(); i < k; i++)
            {
                editor._mth02B8(responseHeaders.name(i));
                editor._mth02B8(": ");
                editor._mth02B8(responseHeaders.value(i));
                editor._mth04C0(10);
            }

            if (isHttps())
            {
                editor._mth04C0(10);
                editor._mth02B8(handshake.cipherSuite());
                editor._mth04C0(10);
                writeCertList(editor, handshake.peerCertificates());
                writeCertList(editor, handshake.localCertificates());
            }
            editor.close();
        }

        public Entry(Response response1)
        {
            url = response1.request().urlString();
            varyHeaders = OkHeaders.varyHeaders(response1);
            requestMethod = response1.request().method();
            protocol = response1.protocol();
            code = response1.code();
            message = response1.message();
            responseHeaders = response1.headers();
            handshake = response1.handshake();
        }

        public Entry(wn wn1)
        {
            o.wi wi;
            Object obj;
            int j;
            wi = wc._mth02CB(wn1);
            url = wi.FF90();
            requestMethod = wi.FF90();
            obj = new Builder();
            j = Cache.readInt(wi);
            int i = 0;
_L2:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            ((Headers.Builder) (obj)).addLenient(wi.FF90());
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            varyHeaders = ((Headers.Builder) (obj)).build();
            obj = StatusLine.parse(wi.FF90());
            protocol = ((StatusLine) (obj)).protocol;
            code = ((StatusLine) (obj)).code;
            message = ((StatusLine) (obj)).message;
            obj = new Headers.Builder();
            j = Cache.readInt(wi);
            i = 0;
_L4:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            ((Headers.Builder) (obj)).addLenient(wi.FF90());
            i++;
            if (true) goto _L4; else goto _L3
_L3:
            responseHeaders = ((Headers.Builder) (obj)).build();
            if (isHttps())
            {
                String s = wi.FF90();
                if (s.length() > 0)
                {
                    throw new IOException((new StringBuilder("expected \"\" but was \"")).append(s).append("\"").toString());
                }
                handshake = Handshake.get(wi.FF90(), readCertificateList(wi), readCertificateList(wi));
                break MISSING_BLOCK_LABEL_248;
            }
            handshake = null;
            wn1.close();
            return;
            Exception exception;
            exception;
            wn1.close();
            throw exception;
        }
    }


    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 0x31191;
    private final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache = new _cls1();
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    public Cache(File file, long l)
    {
        cache = DiskLruCache.create(FileSystem.SYSTEM, file, 0x31191, 2, l);
    }

    private void abortQuietly(com.squareup.okhttp.internal.DiskLruCache.Editor editor)
    {
        if (editor == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        editor.abort();
        return;
        editor;
    }

    private CacheRequest put(Response response)
    {
        Object obj = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method()))
        {
            com.squareup.okhttp.internal.DiskLruCache.Editor editor;
            Entry entry;
            try
            {
                remove(response.request());
            }
            // Misplaced declaration of an exception variable
            catch (Response response) { }
            return null;
        }
        if (!((String) (obj)).equals("GET"))
        {
            return null;
        }
        if (OkHeaders.hasVaryAll(response))
        {
            return null;
        }
        entry = new Entry(response);
        obj = null;
        try
        {
            editor = cache.edit(urlToKey(response.request()));
        }
        // Misplaced declaration of an exception variable
        catch (Response response)
        {
            abortQuietly(((com.squareup.okhttp.internal.DiskLruCache.Editor) (obj)));
            return null;
        }
        response = editor;
        if (editor == null)
        {
            return null;
        }
        obj = response;
        entry.writeTo(response);
        obj = response;
        response = new CacheRequestImpl(response);
        return response;
    }

    private static int readInt(vv vv1)
    {
        long l;
        try
        {
            l = vv1.FF74();
            vv1 = vv1.FF90();
        }
        // Misplaced declaration of an exception variable
        catch (vv vv1)
        {
            throw new IOException(vv1.getMessage());
        }
        if (l < 0L || l > 0x7fffffffL)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        if (vv1.isEmpty())
        {
            break MISSING_BLOCK_LABEL_68;
        }
        throw new IOException((new StringBuilder("expected an int but was \"")).append(l).append(vv1).append("\"").toString());
        return (int)l;
    }

    private void remove(Request request)
    {
        cache.remove(urlToKey(request));
    }

    private void trackConditionalCacheHit()
    {
        this;
        JVM INSTR monitorenter ;
        hitCount = hitCount + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void trackResponse(CacheStrategy cachestrategy)
    {
        this;
        JVM INSTR monitorenter ;
        requestCount = requestCount + 1;
        if (cachestrategy.networkRequest == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        networkCount = networkCount + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        if (cachestrategy.cacheResponse != null)
        {
            hitCount = hitCount + 1;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        cachestrategy;
        throw cachestrategy;
    }

    private void update(Response response, Response response1)
    {
        Entry entry = new Entry(response1);
        response1 = ((CacheResponseBody)response.body()).snapshot;
        response = null;
        com.squareup.okhttp.internal.DiskLruCache.Editor editor;
        try
        {
            editor = response1.edit();
        }
        // Misplaced declaration of an exception variable
        catch (Response response1)
        {
            abortQuietly(response);
            return;
        }
        response1 = editor;
        if (editor == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        response = response1;
        entry.writeTo(response1);
        response = response1;
        response1.commit();
    }

    private static String urlToKey(Request request)
    {
        return Util.md5Hex(request.urlString());
    }

    public final void close()
    {
        cache.close();
    }

    public final void delete()
    {
        cache.delete();
    }

    public final void evictAll()
    {
        cache.evictAll();
    }

    public final void flush()
    {
        cache.flush();
    }

    final Response get(Request request)
    {
        Object obj = urlToKey(request);
        try
        {
            obj = cache.get(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Request request)
        {
            return null;
        }
        if (obj == null)
        {
            return null;
        }
        Entry entry;
        try
        {
            entry = new Entry(((com.squareup.okhttp.internal.DiskLruCache.Snapshot) (obj)).getSource(0));
        }
        // Misplaced declaration of an exception variable
        catch (Request request)
        {
            Util.closeQuietly(((java.io.Closeable) (obj)));
            return null;
        }
        obj = entry.response(request, ((com.squareup.okhttp.internal.DiskLruCache.Snapshot) (obj)));
        if (!entry.matches(request, ((Response) (obj))))
        {
            Util.closeQuietly(((Response) (obj)).body());
            return null;
        } else
        {
            return ((Response) (obj));
        }
    }

    public final File getDirectory()
    {
        return cache.getDirectory();
    }

    public final int getHitCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = hitCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final long getMaxSize()
    {
        return cache.getMaxSize();
    }

    public final int getNetworkCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = networkCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final int getRequestCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = requestCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final long getSize()
    {
        return cache.size();
    }

    public final int getWriteAbortCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = writeAbortCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final int getWriteSuccessCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = writeSuccessCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean isClosed()
    {
        return cache.isClosed();
    }

    public final Iterator urls()
    {
        return new _cls2();
    }









/*
    static int access$808(Cache cache1)
    {
        int i = cache1.writeSuccessCount;
        cache1.writeSuccessCount = i + 1;
        return i;
    }

*/


/*
    static int access$908(Cache cache1)
    {
        int i = cache1.writeAbortCount;
        cache1.writeAbortCount = i + 1;
        return i;
    }

*/

    private class _cls1
        implements InternalCache
    {

        final Cache this$0;

        public Response get(Request request)
        {
            return Cache.this.get(request);
        }

        public CacheRequest put(Response response)
        {
            return Cache.this.put(response);
        }

        public void remove(Request request)
        {
            Cache.this.remove(request);
        }

        public void trackConditionalCacheHit()
        {
            Cache.this.trackConditionalCacheHit();
        }

        public void trackResponse(CacheStrategy cachestrategy)
        {
            Cache.this.trackResponse(cachestrategy);
        }

        public void update(Response response, Response response1)
        {
            Cache.this.update(response, response1);
        }

        _cls1()
        {
            this$0 = Cache.this;
            super();
        }
    }


    private class _cls2
        implements Iterator
    {

        boolean canRemove;
        final Iterator _flddelegate;
        String nextUrl;
        final Cache this$0;

        public boolean hasNext()
        {
            if (nextUrl != null)
            {
                return true;
            }
            canRemove = false;
_L2:
            com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot;
            if (!_flddelegate.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            snapshot = (com.squareup.okhttp.internal.DiskLruCache.Snapshot)_flddelegate.next();
            nextUrl = wc._mth02CB(snapshot.getSource(0)).FF90();
            snapshot.close();
            return true;
_L3:
            snapshot.close();
            if (true) goto _L2; else goto _L1
            Object obj;
            obj;
            snapshot.close();
            throw obj;
_L1:
            return false;
            obj;
              goto _L3
        }

        public volatile Object next()
        {
            return next();
        }

        public String next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            } else
            {
                String s = nextUrl;
                nextUrl = null;
                canRemove = true;
                return s;
            }
        }

        public void remove()
        {
            if (!canRemove)
            {
                throw new IllegalStateException("remove() before next()");
            } else
            {
                _flddelegate.remove();
                return;
            }
        }

        _cls2()
        {
            this$0 = Cache.this;
            super();
            _flddelegate = cache.snapshots();
        }
    }

}
