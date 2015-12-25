// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            UriDataSource, TransferListener, DataSpec

public final class FileDataSource
    implements UriDataSource
{
    public static class FileDataSourceException extends IOException
    {

        public FileDataSourceException(IOException ioexception)
        {
            super(ioexception);
        }
    }


    private long bytesRemaining;
    private RandomAccessFile file;
    private final TransferListener listener;
    private boolean opened;
    private String uriString;

    public FileDataSource()
    {
        this(null);
    }

    public FileDataSource(TransferListener transferlistener)
    {
        listener = transferlistener;
    }

    public final void close()
    {
        uriString = null;
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        file.close();
        file = null;
        if (opened)
        {
            opened = false;
            if (listener != null)
            {
                listener.onTransferEnd();
                return;
            }
        }
        break MISSING_BLOCK_LABEL_99;
        Object obj;
        obj;
        throw new FileDataSourceException(((IOException) (obj)));
        obj;
        file = null;
        if (opened)
        {
            opened = false;
            if (listener != null)
            {
                listener.onTransferEnd();
            }
        }
        throw obj;
    }

    public final String getUri()
    {
        return uriString;
    }

    public final long open(DataSpec dataspec)
    {
        long l;
        try
        {
            uriString = dataspec.uri.toString();
            file = new RandomAccessFile(dataspec.uri.getPath(), "r");
            file.seek(dataspec.position);
            if (dataspec.length == -1L)
            {
                l = file.length() - dataspec.position;
                break MISSING_BLOCK_LABEL_74;
            }
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            throw new FileDataSourceException(dataspec);
        }
        l = dataspec.length;
        bytesRemaining = l;
        if (bytesRemaining < 0L)
        {
            throw new EOFException();
        }
        break MISSING_BLOCK_LABEL_109;
        opened = true;
        if (listener != null)
        {
            listener.onTransferStart();
        }
        return bytesRemaining;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        if (bytesRemaining == 0L)
        {
            return -1;
        }
        try
        {
            i = file.read(abyte0, i, (int)Math.min(bytesRemaining, j));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new FileDataSourceException(abyte0);
        }
        if (i > 0)
        {
            bytesRemaining = bytesRemaining - (long)i;
            if (listener != null)
            {
                listener.onBytesTransferred(i);
            }
        }
        return i;
    }
}
