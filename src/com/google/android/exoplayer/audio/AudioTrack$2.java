// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.audio;

import android.media.AudioTrack;

// Referenced classes of package com.google.android.exoplayer.audio:
//            AudioTrack

class val.toRelease extends Thread
{

    final com.google.android.exoplayer.audio.AudioTrack this$0;
    final AudioTrack val$toRelease;

    public void run()
    {
        val$toRelease.release();
    }

    ()
    {
        this$0 = final_audiotrack;
        val$toRelease = AudioTrack.this;
        super();
    }
}
