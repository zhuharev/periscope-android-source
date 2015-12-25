// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import o.vu;

// Referenced classes of package com.squareup.okhttp:
//            RequestBody, MediaType

final class nit> extends RequestBody
{

    final int val$byteCount;
    final byte val$content[];
    final MediaType val$contentType;
    final int val$offset;

    public final long contentLength()
    {
        return (long)val$byteCount;
    }

    public final MediaType contentType()
    {
        return val$contentType;
    }

    public final void writeTo(vu vu1)
    {
        vu1._mth02BD(val$content, val$offset, val$byteCount);
    }

    ()
    {
        val$contentType = mediatype;
        val$byteCount = i;
        val$content = abyte0;
        val$offset = j;
        super();
    }
}
