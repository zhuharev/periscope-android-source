// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.Assertions;
import java.io.ByteArrayOutputStream;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            DataSink, DataSpec

public final class ByteArrayDataSink
    implements DataSink
{

    private ByteArrayOutputStream stream;

    public ByteArrayDataSink()
    {
    }

    public final void close()
    {
        stream.close();
    }

    public final byte[] getData()
    {
        if (stream == null)
        {
            return null;
        } else
        {
            return stream.toByteArray();
        }
    }

    public final DataSink open(DataSpec dataspec)
    {
        if (dataspec.length == -1L)
        {
            stream = new ByteArrayOutputStream();
            return this;
        }
        boolean flag;
        if (dataspec.length <= 0x7fffffffL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        stream = new ByteArrayOutputStream((int)dataspec.length);
        return this;
    }

    public final void write(byte abyte0[], int i, int j)
    {
        stream.write(abyte0, i, j);
    }
}
