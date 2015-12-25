// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.TimeRange;

// Referenced classes of package com.google.android.exoplayer.dash:
//            DashChunkSource

class val.seekRange
    implements Runnable
{

    final DashChunkSource this$0;
    final TimeRange val$seekRange;

    public void run()
    {
        DashChunkSource.access$500(DashChunkSource.this).onAvailableRangeChanged(val$seekRange);
    }

    entListener()
    {
        this$0 = final_dashchunksource;
        val$seekRange = TimeRange.this;
        super();
    }
}
