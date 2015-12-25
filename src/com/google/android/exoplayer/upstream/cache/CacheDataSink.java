// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream.cache;

import com.google.android.exoplayer.upstream.DataSink;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.upstream.cache:
//            Cache

public final class CacheDataSink
    implements DataSink
{
    public static class CacheDataSinkException extends IOException
    {

        public CacheDataSinkException(IOException ioexception)
        {
            super(ioexception);
        }
    }


    private final Cache cache;
    private DataSpec dataSpec;
    private long dataSpecBytesWritten;
    private File file;
    private final long maxCacheFileSize;
    private FileOutputStream outputStream;
    private long outputStreamBytesWritten;

    public CacheDataSink(Cache cache1, long l)
    {
        cache = (Cache)Assertions.checkNotNull(cache1);
        maxCacheFileSize = l;
    }

    private void closeCurrentOutputStream()
    {
        if (outputStream == null)
        {
            return;
        }
        outputStream.flush();
        outputStream.getFD().sync();
        Util.closeQuietly(outputStream);
        cache.commitFile(file);
        outputStream = null;
        file = null;
        return;
        Exception exception;
        exception;
        Util.closeQuietly(outputStream);
        file.delete();
        outputStream = null;
        file = null;
        throw exception;
    }

    private void openNextOutputStream()
    {
        file = cache.startFile(dataSpec.key, dataSpec.absoluteStreamPosition + dataSpecBytesWritten, Math.min(dataSpec.length - dataSpecBytesWritten, maxCacheFileSize));
        outputStream = new FileOutputStream(file);
        outputStreamBytesWritten = 0L;
    }

    public final void close()
    {
        try
        {
            closeCurrentOutputStream();
            return;
        }
        catch (IOException ioexception)
        {
            throw new CacheDataSinkException(ioexception);
        }
    }

    public final DataSink open(DataSpec dataspec)
    {
        boolean flag;
        if (dataspec.length != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        try
        {
            dataSpec = dataspec;
            dataSpecBytesWritten = 0L;
            openNextOutputStream();
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            throw new CacheDataSinkException(dataspec);
        }
        return this;
    }

    public final void write(byte abyte0[], int i, int j)
    {
        int k = 0;
_L2:
        if (k >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        int l;
        try
        {
            if (outputStreamBytesWritten == maxCacheFileSize)
            {
                closeCurrentOutputStream();
                openNextOutputStream();
            }
            l = (int)Math.min(j - k, maxCacheFileSize - outputStreamBytesWritten);
            outputStream.write(abyte0, i + k, l);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new CacheDataSinkException(abyte0);
        }
        k += l;
        outputStreamBytesWritten = outputStreamBytesWritten + (long)l;
        dataSpecBytesWritten = dataSpecBytesWritten + (long)l;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
