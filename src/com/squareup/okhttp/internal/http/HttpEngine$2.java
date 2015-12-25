// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import o.vr;
import o.vu;
import o.vv;
import o.wn;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            CacheRequest, HttpEngine

class val.cacheBody
    implements wn
{

    boolean cacheRequestClosed;
    final HttpEngine this$0;
    final vu val$cacheBody;
    final CacheRequest val$cacheRequest;
    final vv val$source;

    public void close()
    {
        if (!cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS))
        {
            cacheRequestClosed = true;
            val$cacheRequest.abort();
        }
        val$source.close();
    }

    public long read(vr vr1, long l)
    {
        try
        {
            l = val$source.read(vr1, l);
        }
        // Misplaced declaration of an exception variable
        catch (vr vr1)
        {
            if (!cacheRequestClosed)
            {
                cacheRequestClosed = true;
                val$cacheRequest.abort();
            }
            throw vr1;
        }
        if (l == -1L)
        {
            if (!cacheRequestClosed)
            {
                cacheRequestClosed = true;
                val$cacheBody.close();
            }
            return -1L;
        } else
        {
            vr1._mth02CA(val$cacheBody.FE93(), vr1.size - l, l);
            val$cacheBody._mth0165();
            return l;
        }
    }

    public wo timeout()
    {
        return val$source.timeout();
    }

    ()
    {
        this$0 = final_httpengine;
        val$source = vv1;
        val$cacheRequest = cacherequest;
        val$cacheBody = vu.this;
        super();
    }
}
