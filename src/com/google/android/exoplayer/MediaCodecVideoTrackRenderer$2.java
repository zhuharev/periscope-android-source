// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.view.Surface;

// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecVideoTrackRenderer

class val.surface
    implements Runnable
{

    final MediaCodecVideoTrackRenderer this$0;
    final Surface val$surface;

    public void run()
    {
        MediaCodecVideoTrackRenderer.access$000(MediaCodecVideoTrackRenderer.this).onDrawnToSurface(val$surface);
    }

    entListener()
    {
        this$0 = final_mediacodecvideotrackrenderer;
        val$surface = Surface.this;
        super();
    }
}
