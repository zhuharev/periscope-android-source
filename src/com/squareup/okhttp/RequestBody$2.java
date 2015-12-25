// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.File;
import o.vu;
import o.wc;

// Referenced classes of package com.squareup.okhttp:
//            RequestBody, MediaType

final class nit> extends RequestBody
{

    final MediaType val$contentType;
    final File val$file;

    public final long contentLength()
    {
        return val$file.length();
    }

    public final MediaType contentType()
    {
        return val$contentType;
    }

    public final void writeTo(vu vu1)
    {
        o.wn wn = null;
        o.wn wn1 = wc.source(val$file);
        wn = wn1;
        vu1._mth02CA(wn1);
        Util.closeQuietly(wn1);
        return;
        vu1;
        Util.closeQuietly(wn);
        throw vu1;
    }

    ()
    {
        val$contentType = mediatype;
        val$file = file1;
        super();
    }
}
