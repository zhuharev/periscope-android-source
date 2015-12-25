// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.view.Surface;

// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecVideoTrackRenderer

public static interface 
    extends 
{

    public abstract void onDrawnToSurface(Surface surface);

    public abstract void onDroppedFrames(int i, long l);

    public abstract void onVideoSizeChanged(int i, int j, int k, float f);
}
