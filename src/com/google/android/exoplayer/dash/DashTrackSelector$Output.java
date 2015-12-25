// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.dash.mpd.MediaPresentationDescription;

// Referenced classes of package com.google.android.exoplayer.dash:
//            DashTrackSelector

public static interface ription
{

    public abstract void adaptiveTrack(MediaPresentationDescription mediapresentationdescription, int i, int j, int ai[]);

    public abstract void fixedTrack(MediaPresentationDescription mediapresentationdescription, int i, int j, int k);
}
