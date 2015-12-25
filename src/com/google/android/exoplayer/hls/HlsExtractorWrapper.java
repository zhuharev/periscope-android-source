// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import android.util.SparseArray;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.DefaultTrackOutput;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.MimeTypes;

public final class HlsExtractorWrapper
    implements ExtractorOutput
{

    private final int adaptiveMaxHeight;
    private final int adaptiveMaxWidth;
    private Allocator allocator;
    private final Extractor extractor;
    public final Format format;
    private boolean prepared;
    private MediaFormat sampleQueueFormats[];
    private final SparseArray sampleQueues = new SparseArray();
    private final boolean shouldSpliceIn;
    private boolean spliceConfigured;
    public final long startTimeUs;
    private volatile boolean tracksBuilt;
    public final int trigger;

    public HlsExtractorWrapper(int i, Format format1, long l, Extractor extractor1, boolean flag, int j, 
            int k)
    {
        trigger = i;
        format = format1;
        startTimeUs = l;
        extractor = extractor1;
        shouldSpliceIn = flag;
        adaptiveMaxWidth = j;
        adaptiveMaxHeight = k;
    }

    public final void clear()
    {
        for (int i = 0; i < sampleQueues.size(); i++)
        {
            ((DefaultTrackOutput)sampleQueues.valueAt(i)).clear();
        }

    }

    public final void configureSpliceTo(HlsExtractorWrapper hlsextractorwrapper)
    {
        Assertions.checkState(isPrepared());
        if (spliceConfigured || !hlsextractorwrapper.shouldSpliceIn || !hlsextractorwrapper.isPrepared())
        {
            return;
        }
        boolean flag = true;
        int j = getTrackCount();
        for (int i = 0; i < j; i++)
        {
            flag &= ((DefaultTrackOutput)sampleQueues.valueAt(i)).configureSpliceTo((DefaultTrackOutput)hlsextractorwrapper.sampleQueues.valueAt(i));
        }

        spliceConfigured = flag;
    }

    public final void discardUntil(int i, long l)
    {
        Assertions.checkState(isPrepared());
        ((DefaultTrackOutput)sampleQueues.valueAt(i)).discardUntil(l);
    }

    public final void drmInitData(DrmInitData drminitdata)
    {
    }

    public final void endTracks()
    {
        tracksBuilt = true;
    }

    public final long getLargestParsedTimestampUs()
    {
        long l = 0x8000000000000000L;
        for (int i = 0; i < sampleQueues.size(); i++)
        {
            l = Math.max(l, ((DefaultTrackOutput)sampleQueues.valueAt(i)).getLargestParsedTimestampUs());
        }

        return l;
    }

    public final MediaFormat getMediaFormat(int i)
    {
        Assertions.checkState(isPrepared());
        return sampleQueueFormats[i];
    }

    public final boolean getSample(int i, SampleHolder sampleholder)
    {
        Assertions.checkState(isPrepared());
        return ((DefaultTrackOutput)sampleQueues.valueAt(i)).getSample(sampleholder);
    }

    public final int getTrackCount()
    {
        Assertions.checkState(isPrepared());
        return sampleQueues.size();
    }

    public final boolean hasSamples(int i)
    {
        Assertions.checkState(isPrepared());
        return !((DefaultTrackOutput)sampleQueues.valueAt(i)).isEmpty();
    }

    public final void init(Allocator allocator1)
    {
        allocator = allocator1;
        extractor.init(this);
    }

    public final boolean isPrepared()
    {
label0:
        {
            if (prepared || !tracksBuilt)
            {
                break label0;
            }
            for (int i = 0; i < sampleQueues.size(); i++)
            {
                if (!((DefaultTrackOutput)sampleQueues.valueAt(i)).hasFormat())
                {
                    return false;
                }
            }

            prepared = true;
            sampleQueueFormats = new MediaFormat[sampleQueues.size()];
            for (int j = 0; j < sampleQueueFormats.length; j++)
            {
                MediaFormat mediaformat;
label1:
                {
                    MediaFormat mediaformat1 = ((DefaultTrackOutput)sampleQueues.valueAt(j)).getFormat();
                    mediaformat = mediaformat1;
                    if (!MimeTypes.isVideo(mediaformat1.mimeType))
                    {
                        break label1;
                    }
                    if (adaptiveMaxWidth == -1)
                    {
                        mediaformat = mediaformat1;
                        if (adaptiveMaxHeight == -1)
                        {
                            break label1;
                        }
                    }
                    mediaformat = mediaformat1.copyWithMaxVideoDimensions(adaptiveMaxWidth, adaptiveMaxHeight);
                }
                sampleQueueFormats[j] = mediaformat;
            }

        }
        return prepared;
    }

    public final int read(ExtractorInput extractorinput)
    {
        int i = extractor.read(extractorinput, null);
        boolean flag;
        if (i != 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        return i;
    }

    public final void seekMap(SeekMap seekmap)
    {
    }

    public final TrackOutput track(int i)
    {
        DefaultTrackOutput defaulttrackoutput = new DefaultTrackOutput(allocator);
        sampleQueues.put(i, defaulttrackoutput);
        return defaulttrackoutput;
    }
}
