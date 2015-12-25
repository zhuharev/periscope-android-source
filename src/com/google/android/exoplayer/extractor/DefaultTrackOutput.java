// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package com.google.android.exoplayer.extractor:
//            TrackOutput, RollingSampleBuffer, ExtractorInput

public class DefaultTrackOutput
    implements TrackOutput
{

    private volatile MediaFormat format;
    private volatile long largestParsedTimestampUs;
    private long lastReadTimeUs;
    private boolean needKeyframe;
    private final RollingSampleBuffer rollingBuffer;
    private final SampleHolder sampleInfoHolder = new SampleHolder(0);
    private long spliceOutTimeUs;

    public DefaultTrackOutput(Allocator allocator)
    {
        rollingBuffer = new RollingSampleBuffer(allocator);
        needKeyframe = true;
        lastReadTimeUs = 0x8000000000000000L;
        spliceOutTimeUs = 0x8000000000000000L;
        largestParsedTimestampUs = 0x8000000000000000L;
    }

    private boolean advanceToEligibleSample()
    {
        boolean flag = rollingBuffer.peekSample(sampleInfoHolder);
        boolean flag1 = flag;
        if (needKeyframe)
        {
            do
            {
                flag1 = flag;
                if (!flag)
                {
                    break;
                }
                flag1 = flag;
                if (sampleInfoHolder.isSyncFrame())
                {
                    break;
                }
                rollingBuffer.skipSample();
                flag = rollingBuffer.peekSample(sampleInfoHolder);
            } while (true);
        }
        if (!flag1)
        {
            return false;
        }
        return spliceOutTimeUs == 0x8000000000000000L || sampleInfoHolder.timeUs < spliceOutTimeUs;
    }

    public void clear()
    {
        rollingBuffer.clear();
        needKeyframe = true;
        lastReadTimeUs = 0x8000000000000000L;
        spliceOutTimeUs = 0x8000000000000000L;
        largestParsedTimestampUs = 0x8000000000000000L;
    }

    public boolean configureSpliceTo(DefaultTrackOutput defaulttrackoutput)
    {
        if (spliceOutTimeUs != 0x8000000000000000L)
        {
            return true;
        }
        long l;
        if (rollingBuffer.peekSample(sampleInfoHolder))
        {
            l = sampleInfoHolder.timeUs;
        } else
        {
            l = lastReadTimeUs + 1L;
        }
        for (defaulttrackoutput = defaulttrackoutput.rollingBuffer; defaulttrackoutput.peekSample(sampleInfoHolder) && (sampleInfoHolder.timeUs < l || !sampleInfoHolder.isSyncFrame()); defaulttrackoutput.skipSample()) { }
        if (defaulttrackoutput.peekSample(sampleInfoHolder))
        {
            spliceOutTimeUs = sampleInfoHolder.timeUs;
            return true;
        } else
        {
            return false;
        }
    }

    public void discardUntil(long l)
    {
        while (rollingBuffer.peekSample(sampleInfoHolder) && sampleInfoHolder.timeUs < l) 
        {
            rollingBuffer.skipSample();
            needKeyframe = true;
        }
        lastReadTimeUs = 0x8000000000000000L;
    }

    public void discardUpstreamSamples(int i)
    {
        rollingBuffer.discardUpstreamSamples(i);
        long l;
        if (rollingBuffer.peekSample(sampleInfoHolder))
        {
            l = sampleInfoHolder.timeUs;
        } else
        {
            l = 0x8000000000000000L;
        }
        largestParsedTimestampUs = l;
    }

    public void format(MediaFormat mediaformat)
    {
        format = mediaformat;
    }

    public MediaFormat getFormat()
    {
        return format;
    }

    public long getLargestParsedTimestampUs()
    {
        return largestParsedTimestampUs;
    }

    public int getReadIndex()
    {
        return rollingBuffer.getReadIndex();
    }

    public boolean getSample(SampleHolder sampleholder)
    {
        if (!advanceToEligibleSample())
        {
            return false;
        } else
        {
            rollingBuffer.readSample(sampleholder);
            needKeyframe = false;
            lastReadTimeUs = sampleholder.timeUs;
            return true;
        }
    }

    public int getWriteIndex()
    {
        return rollingBuffer.getWriteIndex();
    }

    public boolean hasFormat()
    {
        return format != null;
    }

    public boolean isEmpty()
    {
        return !advanceToEligibleSample();
    }

    public int sampleData(ExtractorInput extractorinput, int i, boolean flag)
    {
        return rollingBuffer.appendData(extractorinput, i, flag);
    }

    public int sampleData(DataSource datasource, int i, boolean flag)
    {
        return rollingBuffer.appendData(datasource, i, flag);
    }

    public void sampleData(ParsableByteArray parsablebytearray, int i)
    {
        rollingBuffer.appendData(parsablebytearray, i);
    }

    public void sampleMetadata(long l, int i, int j, int k, byte abyte0[])
    {
        largestParsedTimestampUs = Math.max(largestParsedTimestampUs, l);
        rollingBuffer.commitSample(l, i, rollingBuffer.getWritePosition() - (long)j - (long)k, j, abyte0);
    }

    public boolean skipToKeyframeBefore(long l)
    {
        return rollingBuffer.skipToKeyframeBefore(l);
    }
}
