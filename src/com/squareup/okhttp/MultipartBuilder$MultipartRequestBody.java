// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.EOFException;
import java.util.List;
import o.vr;
import o.vu;
import o.vw;

// Referenced classes of package com.squareup.okhttp:
//            RequestBody, MultipartBuilder, MediaType, Headers

static final class partBodies extends RequestBody
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
            vu1._mth02C8(MultipartBuilder.access$000());
            vu1._mth02CA(boundary);
            vu1._mth02C8(MultipartBuilder.access$100());
            if (obj != null)
            {
                int j = 0;
                for (int l = ((Headers) (obj)).size(); j < l; j++)
                {
                    vu1._mth02B8(((Headers) (obj)).name(j))._mth02C8(MultipartBuilder.access$200())._mth02B8(((Headers) (obj)).value(j))._mth02C8(MultipartBuilder.access$100());
                }

            }
            obj = requestbody.contentType();
            if (obj != null)
            {
                vu1._mth02B8("Content-Type: ")._mth02B8(((MediaType) (obj)).toString())._mth02C8(MultipartBuilder.access$100());
            }
            long l2 = requestbody.contentLength();
            if (l2 != -1L)
            {
                vu1._mth02B8("Content-Length: ").FF9E(l2)._mth02C8(MultipartBuilder.access$100());
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
            vu1._mth02C8(MultipartBuilder.access$100());
            if (flag)
            {
                l1 += l2;
            } else
            {
                ((RequestBody)partBodies.get(i)).writeTo(vu1);
            }
            vu1._mth02C8(MultipartBuilder.access$100());
        }

        vu1._mth02C8(MultipartBuilder.access$000());
        vu1._mth02CA(boundary);
        vu1._mth02C8(MultipartBuilder.access$000());
        vu1._mth02C8(MultipartBuilder.access$100());
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

    public (MediaType mediatype, vw vw1, List list, List list1)
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
