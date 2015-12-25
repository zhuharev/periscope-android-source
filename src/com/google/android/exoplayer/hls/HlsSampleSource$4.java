// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsSampleSource

class val.e
    implements Runnable
{

    final HlsSampleSource this$0;
    final IOException val$e;

    public void run()
    {
        HlsSampleSource.access$100(HlsSampleSource.this).onLoadError(HlsSampleSource.access$000(HlsSampleSource.this), val$e);
    }

    entListener()
    {
        this$0 = final_hlssamplesource;
        val$e = IOException.this;
        super();
    }
}
