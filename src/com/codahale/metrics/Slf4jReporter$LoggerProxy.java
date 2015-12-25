// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import o.wt;
import o.wv;

// Referenced classes of package com.codahale.metrics:
//            Slf4jReporter

static abstract class logger
{

    protected final wt logger;

    transient abstract void log(wv wv, String s, Object aobj[]);

    public (wt wt)
    {
        logger = wt;
    }
}
