// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.Predicate;
import java.io.IOException;
import java.util.Map;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            UriDataSource, DataSpec

public interface HttpDataSource
    extends UriDataSource
{
    public static class HttpDataSourceException extends IOException
    {

        public final DataSpec dataSpec;

        public HttpDataSourceException(DataSpec dataspec)
        {
            dataSpec = dataspec;
        }

        public HttpDataSourceException(IOException ioexception, DataSpec dataspec)
        {
            super(ioexception);
            dataSpec = dataspec;
        }

        public HttpDataSourceException(String s, DataSpec dataspec)
        {
            super(s);
            dataSpec = dataspec;
        }

        public HttpDataSourceException(String s, IOException ioexception, DataSpec dataspec)
        {
            super(s, ioexception);
            dataSpec = dataspec;
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException
    {

        public final String contentType;

        public InvalidContentTypeException(String s, DataSpec dataspec)
        {
            super((new StringBuilder("Invalid content type: ")).append(s).toString(), dataspec);
            contentType = s;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException
    {

        public final Map headerFields;
        public final int responseCode;

        public InvalidResponseCodeException(int i, Map map, DataSpec dataspec)
        {
            super((new StringBuilder("Response code: ")).append(i).toString(), dataspec);
            responseCode = i;
            headerFields = map;
        }
    }


    public static final Predicate REJECT_PAYWALL_TYPES = new _cls1();

    public abstract void clearAllRequestProperties();

    public abstract void clearRequestProperty(String s);

    public abstract void close();

    public abstract Map getResponseHeaders();

    public abstract long open(DataSpec dataspec);

    public abstract int read(byte abyte0[], int i, int j);

    public abstract void setRequestProperty(String s, String s1);


    private class _cls1
        implements Predicate
    {

        public final volatile boolean evaluate(Object obj)
        {
            return evaluate((String)obj);
        }

        public final boolean evaluate(String s)
        {
            s = Util.toLowerInvariant(s);
            return !TextUtils.isEmpty(s) && (!s.contains("text") || s.contains("text/vtt")) && !s.contains("html") && !s.contains("xml");
        }

        _cls1()
        {
        }
    }

}
