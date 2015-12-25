// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.util:
//            ManifestFetcher

class val.e
    implements Runnable
{

    final ManifestFetcher this$0;
    final IOException val$e;

    public void run()
    {
        ManifestFetcher.access$000(ManifestFetcher.this).onManifestError(val$e);
    }

    entListener()
    {
        this$0 = final_manifestfetcher;
        val$e = IOException.this;
        super();
    }
}
