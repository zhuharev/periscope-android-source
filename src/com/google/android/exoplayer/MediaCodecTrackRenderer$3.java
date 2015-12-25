// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecTrackRenderer

class val.initializationDuration
    implements Runnable
{

    final MediaCodecTrackRenderer this$0;
    final String val$decoderName;
    final long val$initializationDuration;
    final long val$initializedTimestamp;

    public void run()
    {
        MediaCodecTrackRenderer.access$000(MediaCodecTrackRenderer.this).onDecoderInitialized(val$decoderName, val$initializedTimestamp, val$initializationDuration);
    }

    entListener()
    {
        this$0 = final_mediacodectrackrenderer;
        val$decoderName = s;
        val$initializedTimestamp = l;
        val$initializationDuration = J.this;
        super();
    }
}
