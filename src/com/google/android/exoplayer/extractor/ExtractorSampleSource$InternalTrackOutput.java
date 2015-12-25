// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.upstream.Allocator;

// Referenced classes of package com.google.android.exoplayer.extractor:
//            DefaultTrackOutput, ExtractorSampleSource

class this._cls0 extends DefaultTrackOutput
{

    final ExtractorSampleSource this$0;

    public void sampleMetadata(long l, int i, int j, int k, byte abyte0[])
    {
        super.sampleMetadata(l, i, j, k, abyte0);
        int _tmp = ExtractorSampleSource.access$008(ExtractorSampleSource.this);
    }

    public (Allocator allocator)
    {
        this$0 = ExtractorSampleSource.this;
        super(allocator);
    }
}
