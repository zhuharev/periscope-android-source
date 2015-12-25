// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecVideoTrackRenderer

class val.elapsedToNotify
    implements Runnable
{

    final MediaCodecVideoTrackRenderer this$0;
    final int val$countToNotify;
    final long val$elapsedToNotify;

    public void run()
    {
        MediaCodecVideoTrackRenderer.access$000(MediaCodecVideoTrackRenderer.this).onDroppedFrames(val$countToNotify, val$elapsedToNotify);
    }

    entListener()
    {
        this$0 = final_mediacodecvideotrackrenderer;
        val$countToNotify = i;
        val$elapsedToNotify = J.this;
        super();
    }
}
