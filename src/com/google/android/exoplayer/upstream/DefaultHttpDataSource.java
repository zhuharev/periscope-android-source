// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Predicate;
import com.google.android.exoplayer.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o.aum;
import o.aun;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            HttpDataSource, DataSpec, TransferListener

public class DefaultHttpDataSource
    implements HttpDataSource
{

    private static final Pattern CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "DefaultHttpDataSource";
    private static CookieManager cookieManager = new CookieManager(new aun(), new aum());
    private static final AtomicReference skipBufferReference = new AtomicReference();
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesSkipped;
    private long bytesToRead;
    private long bytesToSkip;
    private final int connectTimeoutMillis;
    private HttpURLConnection connection;
    private final Predicate contentTypePredicate;
    private DataSpec dataSpec;
    private InputStream inputStream;
    private final TransferListener listener;
    private boolean opened;
    private final int readTimeoutMillis;
    private final HashMap requestProperties;
    private final String userAgent;

    public DefaultHttpDataSource(String s, Predicate predicate)
    {
        this(s, predicate, null);
    }

    public DefaultHttpDataSource(String s, Predicate predicate, TransferListener transferlistener)
    {
        this(s, predicate, transferlistener, 8000, 8000);
    }

    public DefaultHttpDataSource(String s, Predicate predicate, TransferListener transferlistener, int i, int j)
    {
        this(s, predicate, transferlistener, i, j, false);
    }

    public DefaultHttpDataSource(String s, Predicate predicate, TransferListener transferlistener, int i, int j, boolean flag)
    {
        userAgent = Assertions.checkNotEmpty(s);
        contentTypePredicate = predicate;
        listener = transferlistener;
        requestProperties = new HashMap();
        connectTimeoutMillis = i;
        readTimeoutMillis = j;
        allowCrossProtocolRedirects = flag;
    }

    private void closeConnectionQuietly()
    {
        if (connection != null)
        {
            try
            {
                connection.disconnect();
            }
            catch (Exception exception)
            {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", exception);
            }
            connection = null;
        }
    }

    private static long getContentLength(HttpURLConnection httpurlconnection)
    {
        String s;
        long l;
        long l1 = -1L;
        s = httpurlconnection.getHeaderField("Content-Length");
        l = l1;
        if (!TextUtils.isEmpty(s))
        {
            try
            {
                l = Long.parseLong(s);
            }
            // Misplaced declaration of an exception variable
            catch (NumberFormatException numberformatexception1)
            {
                Log.e("DefaultHttpDataSource", (new StringBuilder("Unexpected Content-Length [")).append(s).append("]").toString());
                l = l1;
            }
        }
        httpurlconnection = httpurlconnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(httpurlconnection)) goto _L2; else goto _L1
_L1:
        Matcher matcher = CONTENT_RANGE_HEADER.matcher(httpurlconnection);
        if (!matcher.find()) goto _L2; else goto _L3
_L3:
        long l3 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1L;
        long l2;
        if (l < 0L)
        {
            return l3;
        }
        l2 = l;
        if (l == l3)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        Log.w("DefaultHttpDataSource", (new StringBuilder("Inconsistent headers [")).append(s).append("] [").append(httpurlconnection).append("]").toString());
        l2 = Math.max(l, l3);
        return l2;
_L5:
        Log.e("DefaultHttpDataSource", (new StringBuilder("Unexpected Content-Range [")).append(httpurlconnection).append("]").toString());
_L2:
        NumberFormatException numberformatexception1;
        return l;
        NumberFormatException numberformatexception;
        numberformatexception;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static URL handleRedirect(URL url, String s)
    {
        if (s == null)
        {
            throw new ProtocolException("Null location redirect");
        }
        url = new URL(url, s);
        s = url.getProtocol();
        if (!"https".equals(s) && !"http".equals(s))
        {
            throw new ProtocolException((new StringBuilder("Unsupported protocol redirect: ")).append(s).toString());
        } else
        {
            return url;
        }
    }

    private HttpURLConnection makeConnection(DataSpec dataspec)
    {
        URL url = new URL(dataspec.uri.toString());
        byte abyte0[] = dataspec.postBody;
        long l = dataspec.position;
        long l1 = dataspec.length;
        boolean flag;
        if ((dataspec.flags & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!allowCrossProtocolRedirects)
        {
            return makeConnection(url, abyte0, l, l1, flag, true);
        }
        int i = 0;
        dataspec = url;
        do
        {
            int j = i;
            i = j + 1;
            if (j <= 20)
            {
                Object obj = makeConnection(((URL) (dataspec)), abyte0, l, l1, flag, false);
                int k = ((HttpURLConnection) (obj)).getResponseCode();
                if (k == 300 || k == 301 || k == 302 || k == 303 || abyte0 == null && (k == 307 || k == 308))
                {
                    abyte0 = null;
                    String s = ((HttpURLConnection) (obj)).getHeaderField("Location");
                    Map map = ((HttpURLConnection) (obj)).getHeaderFields();
                    ((HttpURLConnection) (obj)).disconnect();
                    dataspec = handleRedirect(dataspec, s);
                    try
                    {
                        cookieManager.put(dataspec.toURI(), map);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        Log.w("DefaultHttpDataSource", ((Throwable) (obj)));
                        ((URISyntaxException) (obj)).printStackTrace();
                    }
                } else
                {
                    return ((HttpURLConnection) (obj));
                }
            } else
            {
                throw new NoRouteToHostException((new StringBuilder("Too many redirects: ")).append(i).toString());
            }
        } while (true);
    }

    private HttpURLConnection makeConnection(URL url, byte abyte0[], long l, long l1, boolean flag, 
            boolean flag1)
    {
        HttpURLConnection httpurlconnection;
        httpurlconnection = (HttpURLConnection)url.openConnection();
        httpurlconnection.setConnectTimeout(connectTimeoutMillis);
        httpurlconnection.setReadTimeout(readTimeoutMillis);
        HashMap hashmap = requestProperties;
        hashmap;
        JVM INSTR monitorenter ;
        java.util.Map.Entry entry;
        for (Iterator iterator = requestProperties.entrySet().iterator(); iterator.hasNext(); httpurlconnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        hashmap;
        JVM INSTR monitorexit ;
          goto _L1
        url;
        throw url;
_L1:
        if (l != 0L || l1 != -1L)
        {
            String s1 = (new StringBuilder("bytes=")).append(l).append("-").toString();
            String s = s1;
            if (l1 != -1L)
            {
                s = (new StringBuilder()).append(s1).append((l + l1) - 1L).toString();
            }
            httpurlconnection.setRequestProperty("Range", s);
        }
        httpurlconnection.setRequestProperty("User-Agent", userAgent);
        if (!flag)
        {
            httpurlconnection.setRequestProperty("Accept-Encoding", "identity");
        }
        try
        {
            url = cookieManager.get(url.toURI(), httpurlconnection.getRequestProperties());
            if (url.containsKey("Cookie"))
            {
                httpurlconnection.setRequestProperty("Cookie", (String)((List)url.get("Cookie")).get(0));
            }
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Log.w("DefaultHttpDataSource", url);
        }
        httpurlconnection.setInstanceFollowRedirects(flag1);
        if (abyte0 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        httpurlconnection.setDoOutput(flag);
        if (abyte0 != null)
        {
            httpurlconnection.setFixedLengthStreamingMode(abyte0.length);
            httpurlconnection.connect();
            url = httpurlconnection.getOutputStream();
            url.write(abyte0);
            url.close();
            return httpurlconnection;
        } else
        {
            httpurlconnection.connect();
            return httpurlconnection;
        }
    }

    private int readInternal(byte abyte0[], int i, int j)
    {
        if (bytesToRead != -1L)
        {
            j = (int)Math.min(j, bytesToRead - bytesRead);
        }
        if (j == 0)
        {
            return -1;
        }
        i = inputStream.read(abyte0, i, j);
        if (i == -1)
        {
            if (bytesToRead != -1L && bytesToRead != bytesRead)
            {
                throw new EOFException();
            } else
            {
                return -1;
            }
        }
        bytesRead = bytesRead + (long)i;
        if (listener != null)
        {
            listener.onBytesTransferred(i);
        }
        return i;
    }

    private void skipInternal()
    {
        if (bytesSkipped == bytesToSkip)
        {
            return;
        }
        byte abyte1[] = (byte[])skipBufferReference.getAndSet(null);
        byte abyte0[] = abyte1;
        if (abyte1 == null)
        {
            abyte0 = new byte[4096];
        }
        do
        {
            if (bytesSkipped == bytesToSkip)
            {
                break;
            }
            int i = (int)Math.min(bytesToSkip - bytesSkipped, abyte0.length);
            i = inputStream.read(abyte0, 0, i);
            if (Thread.interrupted())
            {
                throw new InterruptedIOException();
            }
            if (i == -1)
            {
                throw new EOFException();
            }
            bytesSkipped = bytesSkipped + (long)i;
            if (listener != null)
            {
                listener.onBytesTransferred(i);
            }
        } while (true);
        skipBufferReference.set(abyte0);
    }

    protected final long bytesRead()
    {
        return bytesRead;
    }

    protected final long bytesRemaining()
    {
        if (bytesToRead == -1L)
        {
            return bytesToRead;
        } else
        {
            return bytesToRead - bytesRead;
        }
    }

    protected final long bytesSkipped()
    {
        return bytesSkipped;
    }

    public void clearAllRequestProperties()
    {
        HashMap hashmap = requestProperties;
        hashmap;
        JVM INSTR monitorenter ;
        requestProperties.clear();
        hashmap;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void clearRequestProperty(String s)
    {
        Assertions.checkNotNull(s);
        HashMap hashmap = requestProperties;
        hashmap;
        JVM INSTR monitorenter ;
        requestProperties.remove(s);
        hashmap;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void close()
    {
        if (inputStream == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        Util.maybeTerminateInputStream(connection, bytesRemaining());
        inputStream.close();
        break MISSING_BLOCK_LABEL_42;
        Object obj;
        obj;
        throw new HttpDataSource.HttpDataSourceException(((IOException) (obj)), dataSpec);
        inputStream = null;
        closeConnectionQuietly();
        if (opened)
        {
            opened = false;
            if (listener != null)
            {
                listener.onTransferEnd();
                return;
            }
        }
        break MISSING_BLOCK_LABEL_120;
        obj;
        inputStream = null;
        closeConnectionQuietly();
        if (opened)
        {
            opened = false;
            if (listener != null)
            {
                listener.onTransferEnd();
            }
        }
        throw obj;
    }

    protected final HttpURLConnection getConnection()
    {
        return connection;
    }

    public Map getResponseHeaders()
    {
        if (connection == null)
        {
            return null;
        } else
        {
            return connection.getHeaderFields();
        }
    }

    public String getUri()
    {
        if (connection == null)
        {
            return null;
        } else
        {
            return connection.getURL().toString();
        }
    }

    public long open(DataSpec dataspec)
    {
        dataSpec = dataspec;
        bytesRead = 0L;
        bytesSkipped = 0L;
        try
        {
            connection = makeConnection(dataspec);
        }
        catch (IOException ioexception)
        {
            throw new HttpDataSource.HttpDataSourceException((new StringBuilder("Unable to connect to ")).append(dataspec.uri.toString()).toString(), ioexception, dataspec);
        }
        int i;
        try
        {
            i = connection.getResponseCode();
        }
        catch (IOException ioexception1)
        {
            closeConnectionQuietly();
            throw new HttpDataSource.HttpDataSourceException((new StringBuilder("Unable to connect to ")).append(dataspec.uri.toString()).toString(), ioexception1, dataspec);
        }
        if (i < 200 || i > 299)
        {
            Map map = connection.getHeaderFields();
            closeConnectionQuietly();
            throw new HttpDataSource.InvalidResponseCodeException(i, map, dataspec);
        }
        String s = connection.getContentType();
        if (contentTypePredicate != null && !contentTypePredicate.evaluate(s))
        {
            closeConnectionQuietly();
            throw new HttpDataSource.InvalidContentTypeException(s, dataspec);
        }
        long l;
        if (i == 200 && dataspec.position != 0L)
        {
            l = dataspec.position;
        } else
        {
            l = 0L;
        }
        bytesToSkip = l;
        if ((dataspec.flags & 1) == 0)
        {
            long l1 = getContentLength(connection);
            if (dataspec.length != -1L)
            {
                l1 = dataspec.length;
            } else
            if (l1 != -1L)
            {
                l1 -= bytesToSkip;
            } else
            {
                l1 = -1L;
            }
            bytesToRead = l1;
        } else
        {
            bytesToRead = dataspec.length;
        }
        try
        {
            inputStream = connection.getInputStream();
        }
        catch (IOException ioexception2)
        {
            closeConnectionQuietly();
            throw new HttpDataSource.HttpDataSourceException(ioexception2, dataspec);
        }
        opened = true;
        if (listener != null)
        {
            listener.onTransferStart();
        }
        return bytesToRead;
    }

    public int read(byte abyte0[], int i, int j)
    {
        try
        {
            skipInternal();
            i = readInternal(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new HttpDataSource.HttpDataSourceException(abyte0, dataSpec);
        }
        return i;
    }

    public void setRequestProperty(String s, String s1)
    {
        Assertions.checkNotNull(s);
        Assertions.checkNotNull(s1);
        HashMap hashmap = requestProperties;
        hashmap;
        JVM INSTR monitorenter ;
        requestProperties.put(s, s1);
        hashmap;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

}
