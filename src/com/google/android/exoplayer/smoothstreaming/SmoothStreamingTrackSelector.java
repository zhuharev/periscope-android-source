// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;


// Referenced classes of package com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifest

public interface SmoothStreamingTrackSelector
{
    public static interface Output
    {

        public abstract void adaptiveTrack(SmoothStreamingManifest smoothstreamingmanifest, int i, int ai[]);

        public abstract void fixedTrack(SmoothStreamingManifest smoothstreamingmanifest, int i, int j);
    }


    public abstract void selectTracks(SmoothStreamingManifest smoothstreamingmanifest, Output output);
}
