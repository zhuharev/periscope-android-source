// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.chunk.Format;

// Referenced classes of package com.google.android.exoplayer.dash:
//            DashChunkSource

static final class fixedFormat
{

    private final int adaptationSetIndex;
    private final Format adaptiveFormats[];
    private final int adaptiveMaxHeight;
    private final int adaptiveMaxWidth;
    private final Format fixedFormat;
    public final MediaFormat trackFormat;

    public final boolean isAdaptive()
    {
        return adaptiveFormats != null;
    }






    public (MediaFormat mediaformat, int i, Format format)
    {
        trackFormat = mediaformat;
        adaptationSetIndex = i;
        fixedFormat = format;
        adaptiveFormats = null;
        adaptiveMaxWidth = -1;
        adaptiveMaxHeight = -1;
    }

    public adaptiveMaxHeight(MediaFormat mediaformat, int i, Format aformat[], int j, int k)
    {
        trackFormat = mediaformat;
        adaptationSetIndex = i;
        adaptiveFormats = aformat;
        adaptiveMaxWidth = j;
        adaptiveMaxHeight = k;
        fixedFormat = null;
    }
}
