// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import java.util.List;

// Referenced classes of package com.google.android.exoplayer.extractor.mp4:
//            AtomParsers

static final class pixelWidthAspectRatio
{

    public final List initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthAspectRatio;

    public (List list, int i, float f)
    {
        initializationData = list;
        nalUnitLengthFieldLength = i;
        pixelWidthAspectRatio = f;
    }
}
