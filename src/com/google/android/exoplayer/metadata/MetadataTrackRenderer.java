// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.SampleSourceTrackRenderer;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.exoplayer.metadata:
//            MetadataParser

public final class MetadataTrackRenderer extends SampleSourceTrackRenderer
    implements android.os.Handler.Callback
{
    public static interface MetadataRenderer
    {

        public abstract void onMetadata(Object obj);
    }


    private static final int MSG_INVOKE_RENDERER = 0;
    private final MediaFormatHolder formatHolder = new MediaFormatHolder();
    private boolean inputStreamEnded;
    private final Handler metadataHandler;
    private final MetadataParser metadataParser;
    private final MetadataRenderer metadataRenderer;
    private Object pendingMetadata;
    private long pendingMetadataTimestamp;
    private final SampleHolder sampleHolder = new SampleHolder(1);

    public MetadataTrackRenderer(SampleSource samplesource, MetadataParser metadataparser, MetadataRenderer metadatarenderer, Looper looper)
    {
        super(new SampleSource[] {
            samplesource
        });
        metadataParser = (MetadataParser)Assertions.checkNotNull(metadataparser);
        metadataRenderer = (MetadataRenderer)Assertions.checkNotNull(metadatarenderer);
        if (looper == null)
        {
            samplesource = null;
        } else
        {
            samplesource = new Handler(looper, this);
        }
        metadataHandler = samplesource;
    }

    private void invokeRenderer(Object obj)
    {
        if (metadataHandler != null)
        {
            metadataHandler.obtainMessage(0, obj).sendToTarget();
            return;
        } else
        {
            invokeRendererInternal(obj);
            return;
        }
    }

    private void invokeRendererInternal(Object obj)
    {
        metadataRenderer.onMetadata(obj);
    }

    private void seekToInternal()
    {
        pendingMetadata = null;
        inputStreamEnded = false;
    }

    protected final void doSomeWork(long l, long l1)
    {
        continueBufferingSource(l);
        if (!inputStreamEnded && pendingMetadata == null)
        {
            sampleHolder.clearData();
            int i = readSource(l, formatHolder, sampleHolder, false);
            if (i == -3)
            {
                pendingMetadataTimestamp = sampleHolder.timeUs;
                try
                {
                    pendingMetadata = metadataParser.parse(sampleHolder.data.array(), sampleHolder.size);
                }
                catch (IOException ioexception)
                {
                    throw new ExoPlaybackException(ioexception);
                }
            } else
            if (i == -1)
            {
                inputStreamEnded = true;
            }
        }
        if (pendingMetadata != null && pendingMetadataTimestamp <= l)
        {
            invokeRenderer(pendingMetadata);
            pendingMetadata = null;
        }
    }

    protected final long getBufferedPositionUs()
    {
        return -3L;
    }

    public final boolean handleMessage(Message message)
    {
        switch (message.what)
        {
        case 0: // '\0'
            invokeRendererInternal(message.obj);
            return true;
        }
        return false;
    }

    protected final boolean handlesTrack(MediaFormat mediaformat)
    {
        return metadataParser.canParse(mediaformat.mimeType);
    }

    protected final boolean isEnded()
    {
        return inputStreamEnded;
    }

    protected final boolean isReady()
    {
        return true;
    }

    protected final void onDisabled()
    {
        pendingMetadata = null;
        super.onDisabled();
    }

    protected final void onEnabled(int i, long l, boolean flag)
    {
        super.onEnabled(i, l, flag);
        seekToInternal();
    }

    protected final void seekTo(long l)
    {
        super.seekTo(l);
        seekToInternal();
    }
}
