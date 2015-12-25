// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import o.vr;
import o.vu;
import o.vw;

// Referenced classes of package com.squareup.okhttp:
//            MediaType, RequestBody, Headers

public final class MultipartBuilder
{
    static final class MultipartRequestBody extends RequestBody
    {

        private final vw boundary;
        private long contentLength;
        private final MediaType contentType;
        private final List partBodies;
        private final List partHeaders;

        private long writeOrCountBytes(vu vu1, boolean flag)
        {
            long l1 = 0L;
            vu vu2 = null;
            if (flag)
            {
                vu1 = new vr();
                vu2 = vu1;
            }
            int i = 0;
            for (int k = partHeaders.size(); i < k; i++)
            {
                Object obj = (Headers)partHeaders.get(i);
                RequestBody requestbody = (RequestBody)partBodies.get(i);
                vu1._mth02C8(MultipartBuilder.DASHDASH);
                vu1._mth02CA(boundary);
                vu1._mth02C8(MultipartBuilder.CRLF);
                if (obj != null)
                {
                    int j = 0;
                    for (int l = ((Headers) (obj)).size(); j < l; j++)
                    {
                        vu1._mth02B8(((Headers) (obj)).name(j))._mth02C8(MultipartBuilder.COLONSPACE)._mth02B8(((Headers) (obj)).value(j))._mth02C8(MultipartBuilder.CRLF);
                    }

                }
                obj = requestbody.contentType();
                if (obj != null)
                {
                    vu1._mth02B8("Content-Type: ")._mth02B8(((MediaType) (obj)).toString())._mth02C8(MultipartBuilder.CRLF);
                }
                long l2 = requestbody.contentLength();
                if (l2 != -1L)
                {
                    vu1._mth02B8("Content-Length: ").FF9E(l2)._mth02C8(MultipartBuilder.CRLF);
                } else
                if (flag)
                {
                    try
                    {
                        vu2._mth02D1(((vr) (vu2)).size);
                    }
                    // Misplaced declaration of an exception variable
                    catch (vu vu1)
                    {
                        throw new AssertionError(vu1);
                    }
                    return -1L;
                }
                vu1._mth02C8(MultipartBuilder.CRLF);
                if (flag)
                {
                    l1 += l2;
                } else
                {
                    ((RequestBody)partBodies.get(i)).writeTo(vu1);
                }
                vu1._mth02C8(MultipartBuilder.CRLF);
            }

            vu1._mth02C8(MultipartBuilder.DASHDASH);
            vu1._mth02CA(boundary);
            vu1._mth02C8(MultipartBuilder.DASHDASH);
            vu1._mth02C8(MultipartBuilder.CRLF);
            long l3 = l1;
            if (flag)
            {
                l3 = l1 + ((vr) (vu2)).size;
                vu2.clear();
            }
            return l3;
        }

        public final long contentLength()
        {
            long l = contentLength;
            if (l != -1L)
            {
                return l;
            } else
            {
                long l1 = writeOrCountBytes(null, true);
                contentLength = l1;
                return l1;
            }
        }

        public final MediaType contentType()
        {
            return contentType;
        }

        public final void writeTo(vu vu1)
        {
            writeOrCountBytes(vu1, false);
        }

        public MultipartRequestBody(MediaType mediatype, vw vw1, List list, List list1)
        {
            contentLength = -1L;
            if (mediatype == null)
            {
                throw new NullPointerException("type == null");
            } else
            {
                boundary = vw1;
                contentType = MediaType.parse((new StringBuilder()).append(mediatype).append("; boundary=").append(vw1._mth0178()).toString());
                partHeaders = Util.immutableList(list);
                partBodies = Util.immutableList(list1);
                return;
            }
        }
    }


    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    private static final byte COLONSPACE[] = {
        58, 32
    };
    private static final byte CRLF[] = {
        13, 10
    };
    private static final byte DASHDASH[] = {
        45, 45
    };
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    private final vw boundary;
    private final List partBodies;
    private final List partHeaders;
    private MediaType type;

    public MultipartBuilder()
    {
        this(UUID.randomUUID().toString());
    }

    public MultipartBuilder(String s)
    {
        type = MIXED;
        partHeaders = new ArrayList();
        partBodies = new ArrayList();
        boundary = vw._mth02C0(s);
    }

    private static StringBuilder appendQuotedString(StringBuilder stringbuilder, String s)
    {
        stringbuilder.append('"');
        int i = 0;
        for (int j = s.length(); i < j; i++)
        {
            char c = s.charAt(i);
            switch (c)
            {
            case 10: // '\n'
                stringbuilder.append("%0A");
                break;

            case 13: // '\r'
                stringbuilder.append("%0D");
                break;

            case 34: // '"'
                stringbuilder.append("%22");
                break;

            default:
                stringbuilder.append(c);
                break;
            }
        }

        stringbuilder.append('"');
        return stringbuilder;
    }

    public final MultipartBuilder addFormDataPart(String s, String s1)
    {
        return addFormDataPart(s, null, RequestBody.create(null, s1));
    }

    public final MultipartBuilder addFormDataPart(String s, String s1, RequestBody requestbody)
    {
        if (s == null)
        {
            throw new NullPointerException("name == null");
        }
        StringBuilder stringbuilder = new StringBuilder("form-data; name=");
        appendQuotedString(stringbuilder, s);
        if (s1 != null)
        {
            stringbuilder.append("; filename=");
            appendQuotedString(stringbuilder, s1);
        }
        return addPart(Headers.of(new String[] {
            "Content-Disposition", stringbuilder.toString()
        }), requestbody);
    }

    public final MultipartBuilder addPart(Headers headers, RequestBody requestbody)
    {
        if (requestbody == null)
        {
            throw new NullPointerException("body == null");
        }
        if (headers != null && headers.get("Content-Type") != null)
        {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
        if (headers != null && headers.get("Content-Length") != null)
        {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        } else
        {
            partHeaders.add(headers);
            partBodies.add(requestbody);
            return this;
        }
    }

    public final MultipartBuilder addPart(RequestBody requestbody)
    {
        return addPart(null, requestbody);
    }

    public final RequestBody build()
    {
        if (partHeaders.isEmpty())
        {
            throw new IllegalStateException("Multipart body must have at least one part.");
        } else
        {
            return new MultipartRequestBody(type, boundary, partHeaders, partBodies);
        }
    }

    public final MultipartBuilder type(MediaType mediatype)
    {
        if (mediatype == null)
        {
            throw new NullPointerException("type == null");
        }
        if (!mediatype.type().equals("multipart"))
        {
            throw new IllegalArgumentException((new StringBuilder("multipart != ")).append(mediatype).toString());
        } else
        {
            type = mediatype;
            return this;
        }
    }




}
