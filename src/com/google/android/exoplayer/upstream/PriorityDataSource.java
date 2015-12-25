// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.Assertions;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            DataSource, NetworkLock, DataSpec

public final class PriorityDataSource
    implements DataSource
{

    private final int priority;
    private final DataSource upstream;

    public PriorityDataSource(int i, DataSource datasource)
    {
        priority = i;
        upstream = (DataSource)Assertions.checkNotNull(datasource);
    }

    public final void close()
    {
        upstream.close();
    }

    public final long open(DataSpec dataspec)
    {
        NetworkLock.instance.proceedOrThrow(priority);
        return upstream.open(dataspec);
    }

    public final int read(byte abyte0[], int i, int j)
    {
        NetworkLock.instance.proceedOrThrow(priority);
        return upstream.read(abyte0, i, j);
    }
}
