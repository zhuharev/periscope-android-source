// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.google.android.exoplayer:
//            TrackRenderer, SampleSource, ExoPlaybackException, MediaFormat, 
//            MediaFormatHolder, SampleHolder

public abstract class SampleSourceTrackRenderer extends TrackRenderer
{

    private long durationUs;
    private SampleSource.SampleSourceReader enabledSource;
    private int enabledSourceTrackIndex;
    private int handledSourceIndices[];
    private int handledSourceTrackIndices[];
    private final SampleSource.SampleSourceReader sources[];

    public transient SampleSourceTrackRenderer(SampleSource asamplesource[])
    {
        sources = new SampleSource.SampleSourceReader[asamplesource.length];
        for (int i = 0; i < asamplesource.length; i++)
        {
            sources[i] = asamplesource[i].register();
        }

    }

    private void maybeThrowError(SampleSource.SampleSourceReader samplesourcereader)
    {
        try
        {
            samplesourcereader.maybeThrowError();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SampleSource.SampleSourceReader samplesourcereader)
        {
            throw new ExoPlaybackException(samplesourcereader);
        }
    }

    public final boolean continueBufferingSource(long l)
    {
        return enabledSource.continueBuffering(enabledSourceTrackIndex, l);
    }

    protected boolean doPrepare(long l)
    {
        boolean flag = true;
        for (int i = 0; i < sources.length; i++)
        {
            flag &= sources[i].prepare(l);
        }

        if (!flag)
        {
            return false;
        }
        int j = 0;
        for (int i1 = 0; i1 < sources.length; i1++)
        {
            j += sources[i1].getTrackCount();
        }

        long l2 = 0L;
        int j1 = 0;
        Object obj = new int[j];
        int ai[] = new int[j];
        int i2 = sources.length;
        for (int k = 0; k < i2; k++)
        {
            SampleSource.SampleSourceReader samplesourcereader = sources[k];
            int j2 = samplesourcereader.getTrackCount();
            for (int l1 = 0; l1 < j2;)
            {
                MediaFormat mediaformat = samplesourcereader.getFormat(l1);
                boolean flag1;
                try
                {
                    flag1 = handlesTrack(mediaformat);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new ExoPlaybackException(((Throwable) (obj)));
                }
                l = l2;
                int k1 = j1;
                if (flag1)
                {
                    obj[j1] = k;
                    ai[j1] = l1;
                    j1++;
                    l = l2;
                    k1 = j1;
                    if (l2 != -1L)
                    {
                        long l3 = mediaformat.durationUs;
                        if (l3 == -1L)
                        {
                            l = -1L;
                            k1 = j1;
                        } else
                        {
                            l = l2;
                            k1 = j1;
                            if (l3 != -2L)
                            {
                                l = Math.max(l2, l3);
                                k1 = j1;
                            }
                        }
                    }
                }
                l1++;
                l2 = l;
                j1 = k1;
            }

        }

        durationUs = l2;
        handledSourceIndices = Arrays.copyOf(((int []) (obj)), j1);
        handledSourceTrackIndices = Arrays.copyOf(ai, j1);
        return true;
    }

    public long getBufferedPositionUs()
    {
        return enabledSource.getBufferedPositionUs();
    }

    protected long getDurationUs()
    {
        return durationUs;
    }

    public final MediaFormat getFormat(int i)
    {
        return sources[handledSourceIndices[i]].getFormat(handledSourceTrackIndices[i]);
    }

    protected final int getTrackCount()
    {
        return handledSourceTrackIndices.length;
    }

    public abstract boolean handlesTrack(MediaFormat mediaformat);

    protected void maybeThrowError()
    {
        if (enabledSource != null)
        {
            maybeThrowError(enabledSource);
            return;
        }
        int j = sources.length;
        for (int i = 0; i < j; i++)
        {
            maybeThrowError(sources[i]);
        }

    }

    public void onDisabled()
    {
        enabledSource.disable(enabledSourceTrackIndex);
        enabledSource = null;
    }

    public void onEnabled(int i, long l, boolean flag)
    {
        enabledSource = sources[handledSourceIndices[i]];
        enabledSourceTrackIndex = handledSourceTrackIndices[i];
        enabledSource.enable(enabledSourceTrackIndex, l);
    }

    protected void onReleased()
    {
        int j = sources.length;
        for (int i = 0; i < j; i++)
        {
            sources[i].release();
        }

    }

    public final int readSource(long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag)
    {
        return enabledSource.readData(enabledSourceTrackIndex, l, mediaformatholder, sampleholder, flag);
    }

    public void seekTo(long l)
    {
        enabledSource.seekToUs(l);
    }
}
