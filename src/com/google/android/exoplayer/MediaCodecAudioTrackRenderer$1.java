// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecAudioTrackRenderer

class Exception
    implements Runnable
{

    final MediaCodecAudioTrackRenderer this$0;
    final com.google.android.exoplayer.audio.ion val$e;

    public void run()
    {
        MediaCodecAudioTrackRenderer.access$000(MediaCodecAudioTrackRenderer.this).onAudioTrackInitializationError(val$e);
    }

    Exception()
    {
        this$0 = final_mediacodecaudiotrackrenderer;
        val$e = com.google.android.exoplayer.audio.ion.this;
        super();
    }
}
