// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import o.vr;
import o.vv;
import o.wq;

// Referenced classes of package com.squareup.okhttp:
//            MediaType

public abstract class ResponseBody
    implements Closeable
{

    private Reader reader;

    public ResponseBody()
    {
    }

    private Charset charset()
    {
        MediaType mediatype = contentType();
        if (mediatype != null)
        {
            return mediatype.charset(Util.UTF_8);
        } else
        {
            return Util.UTF_8;
        }
    }

    public static ResponseBody create(final MediaType contentType, final long contentLength, final vv content)
    {
        if (content == null)
        {
            throw new NullPointerException("source == null");
        } else
        {
            return new _cls1();
        }
    }

    public static ResponseBody create(MediaType mediatype, String s)
    {
        Charset charset1 = Util.UTF_8;
        MediaType mediatype1 = mediatype;
        if (mediatype != null)
        {
            Charset charset2 = mediatype.charset();
            charset1 = charset2;
            mediatype1 = mediatype;
            if (charset2 == null)
            {
                charset1 = Util.UTF_8;
                mediatype1 = MediaType.parse((new StringBuilder()).append(mediatype).append("; charset=utf-8").toString());
            }
        }
        mediatype = new vr();
        if (s == null)
        {
            throw new IllegalArgumentException("string == null");
        }
        if (charset1 == null)
        {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset1.equals(wq.UTF_8))
        {
            mediatype = mediatype._mth02B5(s);
        } else
        {
            s = s.getBytes(charset1);
            mediatype = mediatype._mth02BC(s, 0, s.length);
        }
        return create(mediatype1, ((vr) (mediatype)).size, ((vv) (mediatype)));
    }

    public static ResponseBody create(MediaType mediatype, byte abyte0[])
    {
        vr vr1 = new vr();
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            vr1 = vr1._mth02BC(abyte0, 0, abyte0.length);
            return create(mediatype, abyte0.length, ((vv) (vr1)));
        }
    }

    public final InputStream byteStream()
    {
        return source().FF49();
    }

    public final byte[] bytes()
    {
        vv vv1;
        long l;
        l = contentLength();
        if (l > 0x7fffffffL)
        {
            throw new IOException((new StringBuilder("Cannot buffer entire body for content length: ")).append(l).toString());
        }
        vv1 = source();
        Object obj = vv1.FF98();
        Util.closeQuietly(vv1);
        break MISSING_BLOCK_LABEL_63;
        obj;
        Util.closeQuietly(vv1);
        throw obj;
        if (l != -1L && l != (long)obj.length)
        {
            throw new IOException("Content-Length and stream length disagree");
        } else
        {
            return ((byte []) (obj));
        }
    }

    public final Reader charStream()
    {
        Reader reader1 = reader;
        if (reader1 != null)
        {
            return reader1;
        } else
        {
            InputStreamReader inputstreamreader = new InputStreamReader(byteStream(), charset());
            reader = inputstreamreader;
            return inputstreamreader;
        }
    }

    public void close()
    {
        source().close();
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract vv source();

    public final String string()
    {
        return new String(bytes(), charset().name());
    }

    private class _cls1 extends ResponseBody
    {

        final vv val$content;
        final long val$contentLength;
        final MediaType val$contentType;

        public final long contentLength()
        {
            return contentLength;
        }

        public final MediaType contentType()
        {
            return contentType;
        }

        public final vv source()
        {
            return content;
        }

        _cls1()
        {
            contentType = mediatype;
            contentLength = l;
            content = vv1;
            super();
        }
    }

}
