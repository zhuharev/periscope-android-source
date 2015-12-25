// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import java.util.Arrays;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            Chunk, Format

public abstract class DataChunk extends Chunk
{

    private static final int READ_GRANULARITY = 16384;
    private byte data[];
    private int limit;
    private volatile boolean loadCanceled;

    public DataChunk(DataSource datasource, DataSpec dataspec, int i, int j, Format format, int k, byte abyte0[])
    {
        super(datasource, dataspec, i, j, format, k);
        data = abyte0;
    }

    private void maybeExpandData()
    {
        if (data == null)
        {
            data = new byte[16384];
            return;
        }
        if (data.length < limit + 16384)
        {
            data = Arrays.copyOf(data, data.length + 16384);
        }
    }

    public long bytesLoaded()
    {
        return (long)limit;
    }

    public final void cancelLoad()
    {
        loadCanceled = true;
    }

    public abstract void consume(byte abyte0[], int i);

    public byte[] getDataHolder()
    {
        return data;
    }

    public final boolean isLoadCanceled()
    {
        return loadCanceled;
    }

    public final void load()
    {
        dataSource.open(dataSpec);
        limit = 0;
        int i = 0;
_L2:
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        int k;
        if (loadCanceled)
        {
            break; /* Loop/switch isn't completed */
        }
        maybeExpandData();
        k = dataSource.read(data, limit, 16384);
        int j;
        j = k;
        i = j;
        if (k == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        limit = limit + j;
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
        if (!loadCanceled)
        {
            consume(data, limit);
        }
        dataSource.close();
        return;
        Exception exception;
        exception;
        dataSource.close();
        throw exception;
    }
}
