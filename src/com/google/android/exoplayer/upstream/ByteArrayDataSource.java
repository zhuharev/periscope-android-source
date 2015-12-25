// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            DataSource, DataSpec

public final class ByteArrayDataSource
    implements DataSource
{

    private final byte data[];
    private int readPosition;
    private int remainingBytes;

    public ByteArrayDataSource(byte abyte0[])
    {
        Assertions.checkNotNull(abyte0);
        boolean flag;
        if (abyte0.length > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        data = abyte0;
    }

    public final void close()
    {
    }

    public final long open(DataSpec dataspec)
    {
        readPosition = (int)dataspec.position;
        long l;
        if (dataspec.length == -1L)
        {
            l = (long)data.length - dataspec.position;
        } else
        {
            l = dataspec.length;
        }
        remainingBytes = (int)l;
        if (remainingBytes <= 0 || readPosition + remainingBytes > data.length)
        {
            throw new IOException((new StringBuilder("Unsatisfiable range: [")).append(readPosition).append(", ").append(dataspec.length).append("], length: ").append(data.length).toString());
        } else
        {
            return (long)remainingBytes;
        }
    }

    public final int read(byte abyte0[], int i, int j)
    {
        if (remainingBytes == 0)
        {
            return -1;
        } else
        {
            j = Math.min(j, remainingBytes);
            System.arraycopy(data, readPosition, abyte0, i, j);
            readPosition = readPosition + j;
            remainingBytes = remainingBytes - j;
            return j;
        }
    }
}
