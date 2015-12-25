// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import android.net.Uri;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Assertions;

// Referenced classes of package com.google.android.exoplayer.extractor:
//            ExtractorSampleSource, PositionHolder, DefaultExtractorInput, Extractor, 
//            ExtractorInput

static class pendingExtractorSeek
    implements com.google.android.exoplayer.upstream.
{

    private final Allocator allocator;
    private final DataSource dataSource;
    private final dataSource extractorHolder;
    private volatile boolean loadCanceled;
    private boolean pendingExtractorSeek;
    private final PositionHolder positionHolder = new PositionHolder();
    private final int requestedBufferSize;
    private final Uri uri;

    public void cancelLoad()
    {
        loadCanceled = true;
    }

    public boolean isLoadCanceled()
    {
        return loadCanceled;
    }

    public void load()
    {
        int i = 0;
_L4:
        DefaultExtractorInput defaultextractorinput;
        DefaultExtractorInput defaultextractorinput1;
        int k;
        if (i != 0 || loadCanceled)
        {
            break; /* Loop/switch isn't completed */
        }
        defaultextractorinput1 = null;
        k = i;
        defaultextractorinput = defaultextractorinput1;
        long l3 = positionHolder.position;
        k = i;
        defaultextractorinput = defaultextractorinput1;
        long l2 = dataSource.open(new DataSpec(uri, l3, -1L, null));
        long l1;
        long l = l2;
        l1 = l;
        if (l2 != -1L)
        {
            l1 = l + l3;
        }
        k = i;
        defaultextractorinput = defaultextractorinput1;
        defaultextractorinput1 = new DefaultExtractorInput(dataSource, l3, l1);
        k = i;
        defaultextractorinput = defaultextractorinput1;
        Extractor extractor = extractorHolder.ectExtractor(defaultextractorinput1);
        int j;
        j = i;
        k = i;
        defaultextractorinput = defaultextractorinput1;
        if (!pendingExtractorSeek)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        k = i;
        defaultextractorinput = defaultextractorinput1;
        extractor.seek();
        k = i;
        defaultextractorinput = defaultextractorinput1;
        pendingExtractorSeek = false;
        j = i;
_L2:
        if (j != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = j;
        defaultextractorinput = defaultextractorinput1;
        if (loadCanceled)
        {
            break; /* Loop/switch isn't completed */
        }
        k = j;
        defaultextractorinput = defaultextractorinput1;
        allocator.blockWhileTotalBytesAllocatedExceeds(requestedBufferSize);
        k = j;
        defaultextractorinput = defaultextractorinput1;
        j = extractor.read(defaultextractorinput1, positionHolder);
        if (true) goto _L2; else goto _L1
_L1:
        if (j == 1)
        {
            i = 0;
        } else
        {
            positionHolder.position = defaultextractorinput1.getPosition();
            i = j;
        }
        dataSource.close();
        if (true) goto _L4; else goto _L3
        Exception exception;
        exception;
        if (k != 1 && defaultextractorinput != null)
        {
            positionHolder.position = defaultextractorinput.getPosition();
        }
        dataSource.close();
        throw exception;
_L3:
    }

    public (Uri uri1, DataSource datasource,  , Allocator allocator1, int i, long l)
    {
        uri = (Uri)Assertions.checkNotNull(uri1);
        dataSource = (DataSource)Assertions.checkNotNull(datasource);
        extractorHolder = (extractorHolder)Assertions.checkNotNull();
        allocator = (Allocator)Assertions.checkNotNull(allocator1);
        requestedBufferSize = i;
        positionHolder.position = l;
        pendingExtractorSeek = true;
    }
}
