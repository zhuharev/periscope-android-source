// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecTrackRenderer

class coderInitializationException
    implements Runnable
{

    final MediaCodecTrackRenderer this$0;
    final coderInitializationException val$e;

    public void run()
    {
        MediaCodecTrackRenderer.access$000(MediaCodecTrackRenderer.this).onDecoderInitializationError(val$e);
    }

    coderInitializationException()
    {
        this$0 = final_mediacodectrackrenderer;
        val$e = coderInitializationException.this;
        super();
    }
}
