// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.Assertions;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            DataSource, DataSink, DataSpec

public final class TeeDataSource
    implements DataSource
{

    private final DataSink dataSink;
    private final DataSource upstream;

    public TeeDataSource(DataSource datasource, DataSink datasink)
    {
        upstream = (DataSource)Assertions.checkNotNull(datasource);
        dataSink = (DataSink)Assertions.checkNotNull(datasink);
    }

    public final void close()
    {
        upstream.close();
        dataSink.close();
        return;
        Exception exception;
        exception;
        dataSink.close();
        throw exception;
    }

    public final long open(DataSpec dataspec)
    {
        long l = upstream.open(dataspec);
        DataSpec dataspec1 = dataspec;
        if (dataspec.length == -1L)
        {
            dataspec1 = dataspec;
            if (l != -1L)
            {
                dataspec1 = new DataSpec(dataspec.uri, dataspec.absoluteStreamPosition, dataspec.position, l, dataspec.key, dataspec.flags);
            }
        }
        dataSink.open(dataspec1);
        return l;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        j = upstream.read(abyte0, i, j);
        if (j > 0)
        {
            dataSink.write(abyte0, i, j);
        }
        return j;
    }
}
