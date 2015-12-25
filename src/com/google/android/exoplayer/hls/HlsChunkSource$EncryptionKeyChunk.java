// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.DataChunk;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import java.util.Arrays;

// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsChunkSource

static class variantIndex extends DataChunk
{

    public final String iv;
    private byte result[];
    public final int variantIndex;

    protected void consume(byte abyte0[], int i)
    {
        result = Arrays.copyOf(abyte0, i);
    }

    public byte[] getResult()
    {
        return result;
    }

    public (DataSource datasource, DataSpec dataspec, byte abyte0[], String s, int i)
    {
        super(datasource, dataspec, 3, 0, null, -1, abyte0);
        iv = s;
        variantIndex = i;
    }
}
