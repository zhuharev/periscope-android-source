// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            ChunkExtractorWrapper

public static interface 
    extends TrackOutput
{

    public abstract void drmInitData(DrmInitData drminitdata);

    public abstract void seekMap(SeekMap seekmap);
}
