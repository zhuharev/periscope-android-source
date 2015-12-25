// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.dash.mpd.MediaPresentationDescription;

public interface DashTrackSelector
{
    public static interface Output
    {

        public abstract void adaptiveTrack(MediaPresentationDescription mediapresentationdescription, int i, int j, int ai[]);

        public abstract void fixedTrack(MediaPresentationDescription mediapresentationdescription, int i, int j, int k);
    }


    public abstract void selectTracks(MediaPresentationDescription mediapresentationdescription, int i, Output output);
}
