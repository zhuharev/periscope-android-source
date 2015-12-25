// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.upstream.DataSource;
import java.io.EOFException;
import java.util.Arrays;

// Referenced classes of package com.google.android.exoplayer.extractor:
//            ExtractorInput

public final class DefaultExtractorInput
    implements ExtractorInput
{

    private static final byte SCRATCH_SPACE[] = new byte[4096];
    private final DataSource dataSource;
    private byte peekBuffer[];
    private int peekBufferLength;
    private int peekBufferPosition;
    private long position;
    private final long streamLength;

    public DefaultExtractorInput(DataSource datasource, long l, long l1)
    {
        dataSource = datasource;
        position = l;
        streamLength = l1;
        peekBuffer = new byte[8192];
    }

    private void ensureSpaceForPeek(int i)
    {
        i = peekBufferPosition + i;
        if (i > peekBuffer.length)
        {
            peekBuffer = Arrays.copyOf(peekBuffer, Math.max(peekBuffer.length << 1, i));
        }
    }

    private void updatePeekBuffer(int i)
    {
        peekBufferLength = peekBufferLength - i;
        peekBufferPosition = 0;
        byte abyte0[] = peekBuffer;
        System.arraycopy(abyte0, i, abyte0, 0, peekBufferLength);
    }

    public final void advancePeekPosition(int i)
    {
        ensureSpaceForPeek(i);
        int l = i - Math.min(peekBufferLength - peekBufferPosition, i);
        int k = peekBufferLength;
        for (int j = l; j > 0;)
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            int i1 = dataSource.read(peekBuffer, k, j);
            if (i1 == -1)
            {
                throw new EOFException();
            }
            j -= i1;
            k += i1;
        }

        peekBufferPosition = peekBufferPosition + i;
        peekBufferLength = peekBufferLength + l;
    }

    public final long getLength()
    {
        return streamLength;
    }

    public final long getPosition()
    {
        return position;
    }

    public final void peekFully(byte abyte0[], int i, int j)
    {
        ensureSpaceForPeek(j);
        int l = Math.min(peekBufferLength - peekBufferPosition, j);
        System.arraycopy(peekBuffer, peekBufferPosition, abyte0, i, l);
        int k = i + l;
        int i1 = j - l;
        l = peekBufferLength;
        for (i = i1; i > 0;)
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            int j1 = dataSource.read(peekBuffer, l, i);
            if (j1 == -1)
            {
                throw new EOFException();
            }
            System.arraycopy(peekBuffer, l, abyte0, k, j1);
            i -= j1;
            l += j1;
            k += j1;
        }

        peekBufferPosition = peekBufferPosition + j;
        peekBufferLength = peekBufferLength + i1;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        if (Thread.interrupted())
        {
            throw new InterruptedException();
        }
        int k = Math.min(peekBufferLength, j);
        System.arraycopy(peekBuffer, 0, abyte0, i, k);
        j -= k;
        if (j != 0)
        {
            i = dataSource.read(abyte0, i + k, j);
        } else
        {
            i = 0;
        }
        if (i == -1)
        {
            return -1;
        } else
        {
            updatePeekBuffer(k);
            i += k;
            position = position + (long)i;
            return i;
        }
    }

    public final void readFully(byte abyte0[], int i, int j)
    {
        readFully(abyte0, i, j, false);
    }

    public final boolean readFully(byte abyte0[], int i, int j, boolean flag)
    {
        int l = Math.min(peekBufferLength, j);
        System.arraycopy(peekBuffer, 0, abyte0, i, l);
        int k = i + l;
        int i1;
        for (i = j - l; i > 0; i -= i1)
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            i1 = dataSource.read(abyte0, k, i);
            if (i1 == -1)
            {
                if (flag && i == j)
                {
                    return false;
                } else
                {
                    throw new EOFException();
                }
            }
            k += i1;
        }

        updatePeekBuffer(l);
        position = position + (long)j;
        return true;
    }

    public final void resetPeekPosition()
    {
        peekBufferPosition = 0;
    }

    public final void skipFully(int i)
    {
        int k = Math.min(peekBufferLength, i);
        int l;
        for (int j = i - k; j > 0; j -= l)
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            l = dataSource.read(SCRATCH_SPACE, 0, Math.min(SCRATCH_SPACE.length, j));
            if (l == -1)
            {
                throw new EOFException();
            }
        }

        updatePeekBuffer(k);
        position = position + (long)i;
    }

}
