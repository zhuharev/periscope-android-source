// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import o.vv;

// Referenced classes of package com.squareup.okhttp:
//            ResponseBody, MediaType

final class nit> extends ResponseBody
{

    final vv val$content;
    final long val$contentLength;
    final MediaType val$contentType;

    public final long contentLength()
    {
        return val$contentLength;
    }

    public final MediaType contentType()
    {
        return val$contentType;
    }

    public final vv source()
    {
        return val$content;
    }

    ()
    {
        val$contentType = mediatype;
        val$contentLength = l;
        val$content = vv;
        super();
    }
}
