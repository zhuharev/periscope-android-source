// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            UriDataSource, TransferListener, DataSpec

public final class ContentDataSource
    implements UriDataSource
{
    public static class ContentDataSourceException extends IOException
    {

        public ContentDataSourceException(IOException ioexception)
        {
            super(ioexception);
        }
    }


    private long bytesRemaining;
    private InputStream inputStream;
    private final TransferListener listener;
    private boolean opened;
    private final ContentResolver resolver;
    private String uriString;

    public ContentDataSource(Context context)
    {
        this(context, null);
    }

    public ContentDataSource(Context context, TransferListener transferlistener)
    {
        resolver = context.getContentResolver();
        listener = transferlistener;
    }

    public final void close()
    {
        uriString = null;
        if (inputStream == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        inputStream.close();
        inputStream = null;
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
        throw new ContentDataSourceException(((IOException) (obj)));
        obj;
        inputStream = null;
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
label0:
        {
            uriString = dataspec.uri.toString();
            inputStream = new FileInputStream(resolver.openAssetFileDescriptor(dataspec.uri, "r").getFileDescriptor());
            if (inputStream.skip(dataspec.position) < dataspec.position)
            {
                throw new EOFException();
            }
            if (dataspec.length != -1L)
            {
                bytesRemaining = dataspec.length;
                break label0;
            }
            try
            {
                bytesRemaining = inputStream.available();
                if (bytesRemaining == 0L)
                {
                    bytesRemaining = -1L;
                }
            }
            // Misplaced declaration of an exception variable
            catch (DataSpec dataspec)
            {
                throw new ContentDataSourceException(dataspec);
            }
        }
        opened = true;
        if (listener != null)
        {
            listener.onTransferStart();
        }
        return bytesRemaining;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        {
            if (bytesRemaining == 0L)
            {
                return -1;
            }
            try
            {
                if (bytesRemaining == -1L)
                {
                    break MISSING_BLOCK_LABEL_36;
                }
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new ContentDataSourceException(abyte0);
            }
        }
        j = (int)Math.min(bytesRemaining, j);
        i = inputStream.read(abyte0, i, j);
        break MISSING_BLOCK_LABEL_60;
        if (i > 0)
        {
            if (bytesRemaining != -1L)
            {
                bytesRemaining = bytesRemaining - (long)i;
            }
            if (listener != null)
            {
                listener.onBytesTransferred(i);
            }
        }
        return i;
    }
}
