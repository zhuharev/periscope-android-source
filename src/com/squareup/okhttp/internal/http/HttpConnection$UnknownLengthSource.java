// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import o.vr;
import o.vv;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

class <init> extends <init>
{

    private boolean inputExhausted;
    final HttpConnection this$0;

    public void close()
    {
        if (closed)
        {
            return;
        }
        if (!inputExhausted)
        {
            unexpectedEndOfInput();
        }
        closed = true;
    }

    public long read(vr vr, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        if (inputExhausted)
        {
            return -1L;
        }
        l = HttpConnection.access$500(HttpConnection.this).read(vr, l);
        if (l == -1L)
        {
            inputExhausted = true;
            endOfInput(false);
            return -1L;
        } else
        {
            return l;
        }
    }

    private ()
    {
        this$0 = HttpConnection.this;
        super(HttpConnection.this, null);
    }

    >(> >)
    {
        this();
    }
}
