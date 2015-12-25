// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecVideoTrackRenderer

class val.currentPixelWidthHeightRatio
    implements Runnable
{

    final MediaCodecVideoTrackRenderer this$0;
    final int val$currentHeight;
    final float val$currentPixelWidthHeightRatio;
    final int val$currentUnappliedRotationDegrees;
    final int val$currentWidth;

    public void run()
    {
        MediaCodecVideoTrackRenderer.access$000(MediaCodecVideoTrackRenderer.this).onVideoSizeChanged(val$currentWidth, val$currentHeight, val$currentUnappliedRotationDegrees, val$currentPixelWidthHeightRatio);
    }

    entListener()
    {
        this$0 = final_mediacodecvideotrackrenderer;
        val$currentWidth = i;
        val$currentHeight = j;
        val$currentUnappliedRotationDegrees = k;
        val$currentPixelWidthHeightRatio = F.this;
        super();
    }
}
