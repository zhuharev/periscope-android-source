// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;

import o.ig;
import o.is;
import o.tp;

// Referenced classes of package com.twitter.sdk.android.core.internal.scribe:
//            ScribeEvent

public static class gson
    implements tp
{

    private final ig gson;

    public byte[] toBytes(ScribeEvent scribeevent)
    {
        ig ig1 = gson;
        if (scribeevent == null)
        {
            scribeevent = ig1._mth02CA(is.GB);
        } else
        {
            scribeevent = ig1._mth02CA(scribeevent, scribeevent.getClass());
        }
        return scribeevent.getBytes("UTF-8");
    }

    public volatile byte[] toBytes(Object obj)
    {
        return toBytes((ScribeEvent)obj);
    }

    public (ig ig1)
    {
        gson = ig1;
    }
}
