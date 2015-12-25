// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            ChunkSampleSource

class val.e
    implements Runnable
{

    final ChunkSampleSource this$0;
    final IOException val$e;

    public void run()
    {
        ChunkSampleSource.access$100(ChunkSampleSource.this).onLoadError(ChunkSampleSource.access$000(ChunkSampleSource.this), val$e);
    }

    entListener()
    {
        this$0 = final_chunksamplesource;
        val$e = IOException.this;
        super();
    }
}
