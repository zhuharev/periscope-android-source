// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.chunk.Format;

// Referenced classes of package com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingChunkSource

static final class fixedFormat
{

    private final Format adaptiveFormats[];
    private final int adaptiveMaxHeight;
    private final int adaptiveMaxWidth;
    private final int elementIndex;
    private final Format fixedFormat;
    public final MediaFormat trackFormat;

    public final boolean isAdaptive()
    {
        return adaptiveFormats != null;
    }






    public (MediaFormat mediaformat, int i, Format format)
    {
        trackFormat = mediaformat;
        elementIndex = i;
        fixedFormat = format;
        adaptiveFormats = null;
        adaptiveMaxWidth = -1;
        adaptiveMaxHeight = -1;
    }

    public adaptiveMaxHeight(MediaFormat mediaformat, int i, Format aformat[], int j, int k)
    {
        trackFormat = mediaformat;
        elementIndex = i;
        adaptiveFormats = aformat;
        adaptiveMaxWidth = j;
        adaptiveMaxHeight = k;
        fixedFormat = null;
    }
}
