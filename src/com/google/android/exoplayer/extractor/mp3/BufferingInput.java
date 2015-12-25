// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.io.EOFException;
import java.nio.BufferOverflowException;

final class BufferingInput
{

    private final ParsableByteArray buffer;
    private final int capacity;
    private int markPosition;
    private int readPosition;
    private int writePosition;

    public BufferingInput(int i)
    {
        capacity = i;
        buffer = new ParsableByteArray(i << 1);
    }

    private boolean ensureLoaded(ExtractorInput extractorinput, int i)
    {
        if ((readPosition + i) - markPosition > capacity)
        {
            throw new BufferOverflowException();
        }
        i -= writePosition - readPosition;
        if (i > 0)
        {
            if (!extractorinput.readFully(buffer.data, writePosition, i, true))
            {
                return false;
            }
            writePosition = writePosition + i;
        }
        return true;
    }

    private boolean readInternal(ExtractorInput extractorinput, byte abyte0[], int i, int j)
    {
        if (!ensureLoaded(extractorinput, j))
        {
            return false;
        }
        if (abyte0 != null)
        {
            System.arraycopy(buffer.data, readPosition, abyte0, i, j);
        }
        readPosition = readPosition + j;
        return true;
    }

    public final int drainToOutput(TrackOutput trackoutput, int i)
    {
        if (i == 0)
        {
            return 0;
        } else
        {
            buffer.setPosition(readPosition);
            i = Math.min(writePosition - readPosition, i);
            trackoutput.sampleData(buffer, i);
            readPosition = readPosition + i;
            return i;
        }
    }

    public final int getAvailableByteCount()
    {
        return writePosition - readPosition;
    }

    public final ParsableByteArray getParsableByteArray(ExtractorInput extractorinput, int i)
    {
        if (!ensureLoaded(extractorinput, i))
        {
            throw new EOFException();
        } else
        {
            extractorinput = new ParsableByteArray(buffer.data, writePosition);
            extractorinput.setPosition(readPosition);
            readPosition = readPosition + i;
            return extractorinput;
        }
    }

    public final void mark()
    {
        if (readPosition > capacity)
        {
            System.arraycopy(buffer.data, readPosition, buffer.data, 0, writePosition - readPosition);
            writePosition = writePosition - readPosition;
            readPosition = 0;
        }
        markPosition = readPosition;
    }

    public final void read(ExtractorInput extractorinput, byte abyte0[], int i, int j)
    {
        if (!readInternal(extractorinput, abyte0, i, j))
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public final boolean readAllowingEndOfInput(ExtractorInput extractorinput, byte abyte0[], int i, int j)
    {
        return readInternal(extractorinput, abyte0, i, j);
    }

    public final void reset()
    {
        readPosition = 0;
        writePosition = 0;
        markPosition = 0;
    }

    public final void returnToMark()
    {
        readPosition = markPosition;
    }

    public final void skip(ExtractorInput extractorinput, int i)
    {
        if (!readInternal(extractorinput, null, 0, i))
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }
}
