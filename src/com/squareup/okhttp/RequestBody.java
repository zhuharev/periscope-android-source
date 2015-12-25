// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.File;
import o.vu;

// Referenced classes of package com.squareup.okhttp:
//            MediaType

public abstract class RequestBody
{

    public RequestBody()
    {
    }

    public static RequestBody create(final MediaType contentType, final File file)
    {
        if (file == null)
        {
            throw new NullPointerException("content == null");
        } else
        {
            return new _cls2();
        }
    }

    public static RequestBody create(MediaType mediatype, String s)
    {
        java.nio.charset.Charset charset = Util.UTF_8;
        MediaType mediatype1 = mediatype;
        if (mediatype != null)
        {
            java.nio.charset.Charset charset1 = mediatype.charset();
            charset = charset1;
            mediatype1 = mediatype;
            if (charset1 == null)
            {
                charset = Util.UTF_8;
                mediatype1 = MediaType.parse((new StringBuilder()).append(mediatype).append("; charset=utf-8").toString());
            }
        }
        return create(mediatype1, s.getBytes(charset));
    }

    public static RequestBody create(MediaType mediatype, byte abyte0[])
    {
        return create(mediatype, abyte0, 0, abyte0.length);
    }

    public static RequestBody create(final MediaType contentType, final byte content[], final int offset, final int byteCount)
    {
        if (content == null)
        {
            throw new NullPointerException("content == null");
        } else
        {
            Util.checkOffsetAndCount(content.length, offset, byteCount);
            return new _cls1();
        }
    }

    public long contentLength()
    {
        return -1L;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(vu vu);

    private class _cls2 extends RequestBody
    {

        final MediaType val$contentType;
        final File val$file;

        public final long contentLength()
        {
            return file.length();
        }

        public final MediaType contentType()
        {
            return contentType;
        }

        public final void writeTo(vu vu1)
        {
            o.wn wn = null;
            o.wn wn1 = wc.source(file);
            wn = wn1;
            vu1._mth02CA(wn1);
            Util.closeQuietly(wn1);
            return;
            vu1;
            Util.closeQuietly(wn);
            throw vu1;
        }

        _cls2()
        {
            contentType = mediatype;
            file = file1;
            super();
        }
    }


    private class _cls1 extends RequestBody
    {

        final int val$byteCount;
        final byte val$content[];
        final MediaType val$contentType;
        final int val$offset;

        public final long contentLength()
        {
            return (long)byteCount;
        }

        public final MediaType contentType()
        {
            return contentType;
        }

        public final void writeTo(vu vu1)
        {
            vu1._mth02BD(content, offset, byteCount);
        }

        _cls1()
        {
            contentType = mediatype;
            byteCount = i;
            content = abyte0;
            offset = j;
            super();
        }
    }

}
