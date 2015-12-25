// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Base64;
import android.util.SparseArray;
import com.google.android.exoplayer.BehindLiveWindowException;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.chunk.Chunk;
import com.google.android.exoplayer.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer.chunk.ChunkOperationHolder;
import com.google.android.exoplayer.chunk.ChunkSource;
import com.google.android.exoplayer.chunk.ContainerMediaChunk;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.FormatEvaluator;
import com.google.android.exoplayer.chunk.MediaChunk;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer.extractor.mp4.Track;
import com.google.android.exoplayer.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.CodecSpecificDataUtil;
import com.google.android.exoplayer.util.ManifestFetcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifest, SmoothStreamingTrackSelector

public class SmoothStreamingChunkSource
    implements ChunkSource, SmoothStreamingTrackSelector.Output
{
    static final class ExposedTrack
    {

        private final Format adaptiveFormats[];
        private final int adaptiveMaxHeight;
        private final int adaptiveMaxWidth;
        private final int elementIndex;
        private final Format fixedFormat;
        public final MediaFormat trackFormat;

        public final boolean isAdaptive()
        {
            return adaptiveFormats != null;
        }






        public ExposedTrack(MediaFormat mediaformat, int i, Format format)
        {
            trackFormat = mediaformat;
            elementIndex = i;
            fixedFormat = format;
            adaptiveFormats = null;
            adaptiveMaxWidth = -1;
            adaptiveMaxHeight = -1;
        }

        public ExposedTrack(MediaFormat mediaformat, int i, Format aformat[], int j, int k)
        {
            trackFormat = mediaformat;
            elementIndex = i;
            adaptiveFormats = aformat;
            adaptiveMaxWidth = j;
            adaptiveMaxHeight = k;
            fixedFormat = null;
        }
    }


    private static final int INITIALIZATION_VECTOR_SIZE = 8;
    private static final int MINIMUM_MANIFEST_REFRESH_PERIOD_MS = 5000;
    private final FormatEvaluator adaptiveFormatEvaluator;
    private SmoothStreamingManifest currentManifest;
    private int currentManifestChunkOffset;
    private final DataSource dataSource;
    private final com.google.android.exoplayer.drm.DrmInitData.Mapped drmInitData;
    private ExposedTrack enabledTrack;
    private final com.google.android.exoplayer.chunk.FormatEvaluator.Evaluation evaluation;
    private final SparseArray extractorWrappers;
    private IOException fatalError;
    private final boolean live;
    private final long liveEdgeLatencyUs;
    private final ManifestFetcher manifestFetcher;
    private final SparseArray mediaFormats;
    private boolean needManifestRefresh;
    private boolean prepareCalled;
    private final TrackEncryptionBox trackEncryptionBoxes[];
    private final SmoothStreamingTrackSelector trackSelector;
    private final ArrayList tracks;

    public SmoothStreamingChunkSource(SmoothStreamingManifest smoothstreamingmanifest, SmoothStreamingTrackSelector smoothstreamingtrackselector, DataSource datasource, FormatEvaluator formatevaluator)
    {
        this(null, smoothstreamingmanifest, smoothstreamingtrackselector, datasource, formatevaluator, 0L);
    }

    private SmoothStreamingChunkSource(ManifestFetcher manifestfetcher, SmoothStreamingManifest smoothstreamingmanifest, SmoothStreamingTrackSelector smoothstreamingtrackselector, DataSource datasource, FormatEvaluator formatevaluator, long l)
    {
        manifestFetcher = manifestfetcher;
        currentManifest = smoothstreamingmanifest;
        trackSelector = smoothstreamingtrackselector;
        dataSource = datasource;
        adaptiveFormatEvaluator = formatevaluator;
        liveEdgeLatencyUs = 1000L * l;
        evaluation = new com.google.android.exoplayer.chunk.FormatEvaluator.Evaluation();
        tracks = new ArrayList();
        extractorWrappers = new SparseArray();
        mediaFormats = new SparseArray();
        live = smoothstreamingmanifest.isLive;
        manifestfetcher = smoothstreamingmanifest.protectionElement;
        if (manifestfetcher != null)
        {
            smoothstreamingmanifest = getProtectionElementKeyId(((SmoothStreamingManifest.ProtectionElement) (manifestfetcher)).data);
            trackEncryptionBoxes = new TrackEncryptionBox[1];
            trackEncryptionBoxes[0] = new TrackEncryptionBox(true, 8, smoothstreamingmanifest);
            drmInitData = new com.google.android.exoplayer.drm.DrmInitData.Mapped("video/mp4");
            drmInitData.put(((SmoothStreamingManifest.ProtectionElement) (manifestfetcher)).uuid, ((SmoothStreamingManifest.ProtectionElement) (manifestfetcher)).data);
            return;
        } else
        {
            trackEncryptionBoxes = null;
            drmInitData = null;
            return;
        }
    }

    public SmoothStreamingChunkSource(ManifestFetcher manifestfetcher, SmoothStreamingTrackSelector smoothstreamingtrackselector, DataSource datasource, FormatEvaluator formatevaluator, long l)
    {
        this(manifestfetcher, (SmoothStreamingManifest)manifestfetcher.getManifest(), smoothstreamingtrackselector, datasource, formatevaluator, l);
    }

    private static long getLiveSeekPosition(SmoothStreamingManifest smoothstreamingmanifest, long l)
    {
        long l1 = 0x8000000000000000L;
        for (int i = 0; i < smoothstreamingmanifest.streamElements.length;)
        {
            SmoothStreamingManifest.StreamElement streamelement = smoothstreamingmanifest.streamElements[i];
            long l2 = l1;
            if (streamelement.chunkCount > 0)
            {
                l2 = Math.max(l1, streamelement.getStartTimeUs(streamelement.chunkCount - 1) + streamelement.getChunkDurationUs(streamelement.chunkCount - 1));
            }
            i++;
            l1 = l2;
        }

        return l1 - l;
    }

    private static int getManifestTrackIndex(SmoothStreamingManifest.StreamElement streamelement, Format format)
    {
        streamelement = streamelement.tracks;
        for (int i = 0; i < streamelement.length; i++)
        {
            if (((SmoothStreamingManifest.TrackElement) (streamelement[i])).format.equals(format))
            {
                return i;
            }
        }

        throw new IllegalStateException((new StringBuilder("Invalid format: ")).append(format).toString());
    }

    private static int getManifestTrackKey(int i, int j)
    {
        boolean flag;
        if (i <= 0x10000 && j <= 0x10000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        return i << 16 | j;
    }

    private static byte[] getProtectionElementKeyId(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < abyte0.length; i += 2)
        {
            stringbuilder.append((char)abyte0[i]);
        }

        abyte0 = stringbuilder.toString();
        abyte0 = Base64.decode(abyte0.substring(abyte0.indexOf("<KID>") + 5, abyte0.indexOf("</KID>")), 0);
        swap(abyte0, 0, 3);
        swap(abyte0, 1, 2);
        swap(abyte0, 4, 5);
        swap(abyte0, 6, 7);
        return abyte0;
    }

    private MediaFormat initManifestTrack(SmoothStreamingManifest smoothstreamingmanifest, int i, int j)
    {
        int k = getManifestTrackKey(i, j);
        Object obj = (MediaFormat)mediaFormats.get(k);
        if (obj != null)
        {
            return ((MediaFormat) (obj));
        }
        long l;
        if (live)
        {
            l = -1L;
        } else
        {
            l = smoothstreamingmanifest.durationUs;
        }
        obj = smoothstreamingmanifest.streamElements[i];
        Object obj1 = ((SmoothStreamingManifest.StreamElement) (obj)).tracks[j].format;
        smoothstreamingmanifest = ((SmoothStreamingManifest.StreamElement) (obj)).tracks[j].csd;
        switch (((SmoothStreamingManifest.StreamElement) (obj)).type)
        {
        case 1: // '\001'
            smoothstreamingmanifest = MediaFormat.createVideoFormat(-1, ((Format) (obj1)).mimeType, ((Format) (obj1)).bitrate, -1, l, ((Format) (obj1)).width, ((Format) (obj1)).height, Arrays.asList(smoothstreamingmanifest));
            i = Track.TYPE_vide;
            break;

        case 0: // '\0'
            if (smoothstreamingmanifest != null)
            {
                smoothstreamingmanifest = Arrays.asList(smoothstreamingmanifest);
            } else
            {
                smoothstreamingmanifest = Collections.singletonList(CodecSpecificDataUtil.buildAacAudioSpecificConfig(((Format) (obj1)).audioSamplingRate, ((Format) (obj1)).audioChannels));
            }
            smoothstreamingmanifest = MediaFormat.createAudioFormat(-1, ((Format) (obj1)).mimeType, ((Format) (obj1)).bitrate, -1, l, ((Format) (obj1)).audioChannels, ((Format) (obj1)).audioSamplingRate, smoothstreamingmanifest, ((Format) (obj1)).language);
            i = Track.TYPE_soun;
            break;

        case 2: // '\002'
            smoothstreamingmanifest = MediaFormat.createTextFormat(-1, ((Format) (obj1)).mimeType, ((Format) (obj1)).bitrate, l, ((Format) (obj1)).language);
            i = Track.TYPE_text;
            break;

        default:
            throw new IllegalStateException((new StringBuilder("Invalid type: ")).append(((SmoothStreamingManifest.StreamElement) (obj)).type).toString());
        }
        obj1 = new FragmentedMp4Extractor(1);
        long l1 = ((SmoothStreamingManifest.StreamElement) (obj)).timescale;
        TrackEncryptionBox atrackencryptionbox[] = trackEncryptionBoxes;
        byte byte0;
        if (i == Track.TYPE_vide)
        {
            byte0 = 4;
        } else
        {
            byte0 = -1;
        }
        ((FragmentedMp4Extractor) (obj1)).setTrack(new Track(j, i, l1, l, smoothstreamingmanifest, atrackencryptionbox, byte0));
        mediaFormats.put(k, smoothstreamingmanifest);
        extractorWrappers.put(k, new ChunkExtractorWrapper(((com.google.android.exoplayer.extractor.Extractor) (obj1))));
        return smoothstreamingmanifest;
    }

    private static MediaChunk newMediaChunk(Format format, Uri uri, String s, ChunkExtractorWrapper chunkextractorwrapper, DrmInitData drminitdata, DataSource datasource, int i, long l, long l1, int j, MediaFormat mediaformat, int k, int i1)
    {
        return new ContainerMediaChunk(datasource, new DataSpec(uri, 0L, -1L, s), j, format, l, l1, i, l, chunkextractorwrapper, mediaformat, k, i1, drminitdata, true, -1);
    }

    private static void swap(byte abyte0[], int i, int j)
    {
        byte byte0 = abyte0[i];
        abyte0[i] = abyte0[j];
        abyte0[j] = byte0;
    }

    public void adaptiveTrack(SmoothStreamingManifest smoothstreamingmanifest, int i, int ai[])
    {
        if (adaptiveFormatEvaluator == null)
        {
            return;
        }
        MediaFormat mediaformat = null;
        SmoothStreamingManifest.StreamElement streamelement = smoothstreamingmanifest.streamElements[i];
        int l = -1;
        int k = -1;
        Format aformat[] = new Format[ai.length];
        for (int j = 0; j < aformat.length; j++)
        {
            int i1 = ai[j];
            aformat[j] = streamelement.tracks[i1].format;
            MediaFormat mediaformat1 = initManifestTrack(smoothstreamingmanifest, i, i1);
            if (mediaformat == null || mediaformat1.height > k)
            {
                mediaformat = mediaformat1;
            }
            l = Math.max(l, mediaformat1.width);
            k = Math.max(k, mediaformat1.height);
        }

        Arrays.sort(aformat, new com.google.android.exoplayer.chunk.Format.DecreasingBandwidthComparator());
        smoothstreamingmanifest = mediaformat.copyAsAdaptive();
        tracks.add(new ExposedTrack(smoothstreamingmanifest, i, aformat, l, k));
    }

    public void continueBuffering(long l)
    {
        if (manifestFetcher == null || !currentManifest.isLive || fatalError != null)
        {
            return;
        }
        SmoothStreamingManifest smoothstreamingmanifest = (SmoothStreamingManifest)manifestFetcher.getManifest();
        if (currentManifest != smoothstreamingmanifest && smoothstreamingmanifest != null)
        {
            SmoothStreamingManifest.StreamElement streamelement = currentManifest.streamElements[enabledTrack.elementIndex];
            int i = streamelement.chunkCount;
            SmoothStreamingManifest.StreamElement streamelement1 = smoothstreamingmanifest.streamElements[enabledTrack.elementIndex];
            if (i == 0 || streamelement1.chunkCount == 0)
            {
                currentManifestChunkOffset = currentManifestChunkOffset + i;
            } else
            {
                l = streamelement.getStartTimeUs(i - 1);
                long l1 = streamelement.getChunkDurationUs(i - 1);
                long l2 = streamelement1.getStartTimeUs(0);
                if (l + l1 <= l2)
                {
                    currentManifestChunkOffset = currentManifestChunkOffset + i;
                } else
                {
                    currentManifestChunkOffset = currentManifestChunkOffset + streamelement.getChunkIndex(l2);
                }
            }
            currentManifest = smoothstreamingmanifest;
            needManifestRefresh = false;
        }
        if (needManifestRefresh && SystemClock.elapsedRealtime() > manifestFetcher.getManifestLoadStartTimestamp() + 5000L)
        {
            manifestFetcher.requestRefresh();
        }
    }

    public void disable(List list)
    {
        if (enabledTrack.isAdaptive())
        {
            adaptiveFormatEvaluator.disable();
        }
        if (manifestFetcher != null)
        {
            manifestFetcher.disable();
        }
        evaluation.format = null;
        fatalError = null;
    }

    public void enable(int i)
    {
        enabledTrack = (ExposedTrack)tracks.get(i);
        if (enabledTrack.isAdaptive())
        {
            adaptiveFormatEvaluator.enable();
        }
        if (manifestFetcher != null)
        {
            manifestFetcher.enable();
        }
    }

    public void fixedTrack(SmoothStreamingManifest smoothstreamingmanifest, int i, int j)
    {
        MediaFormat mediaformat = initManifestTrack(smoothstreamingmanifest, i, j);
        smoothstreamingmanifest = smoothstreamingmanifest.streamElements[i].tracks[j].format;
        tracks.add(new ExposedTrack(mediaformat, i, smoothstreamingmanifest));
    }

    public final void getChunkOperation(List list, long l, long l1, ChunkOperationHolder chunkoperationholder)
    {
        if (fatalError != null)
        {
            chunkoperationholder.chunk = null;
            return;
        }
        evaluation.queueSize = list.size();
        if (enabledTrack.isAdaptive())
        {
            adaptiveFormatEvaluator.evaluate(list, l1, enabledTrack.adaptiveFormats, evaluation);
        } else
        {
            evaluation.format = enabledTrack.fixedFormat;
            evaluation.trigger = 2;
        }
        Format format = evaluation.format;
        chunkoperationholder.queueSize = evaluation.queueSize;
        if (format == null)
        {
            chunkoperationholder.chunk = null;
            return;
        }
        if (chunkoperationholder.queueSize == list.size() && chunkoperationholder.chunk != null && chunkoperationholder.chunk.format.equals(format))
        {
            return;
        }
        chunkoperationholder.chunk = null;
        SmoothStreamingManifest.StreamElement streamelement = currentManifest.streamElements[enabledTrack.elementIndex];
        if (streamelement.chunkCount == 0)
        {
            if (currentManifest.isLive)
            {
                needManifestRefresh = true;
                return;
            } else
            {
                chunkoperationholder.endOfStream = true;
                return;
            }
        }
        int i;
        if (list.isEmpty())
        {
            if (live)
            {
                l = getLiveSeekPosition(currentManifest, liveEdgeLatencyUs);
            }
            i = streamelement.getChunkIndex(l);
        } else
        {
            i = (((MediaChunk)list.get(chunkoperationholder.queueSize - 1)).chunkIndex + 1) - currentManifestChunkOffset;
        }
        if (live && i < 0)
        {
            fatalError = new BehindLiveWindowException();
            return;
        }
        if (currentManifest.isLive)
        {
            if (i >= streamelement.chunkCount)
            {
                needManifestRefresh = true;
                return;
            }
            if (i == streamelement.chunkCount - 1)
            {
                needManifestRefresh = true;
            }
        } else
        if (i >= streamelement.chunkCount)
        {
            chunkoperationholder.endOfStream = true;
            return;
        }
        boolean flag;
        if (!currentManifest.isLive && i == streamelement.chunkCount - 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l1 = streamelement.getStartTimeUs(i);
        if (flag)
        {
            l = -1L;
        } else
        {
            l = l1 + streamelement.getChunkDurationUs(i);
        }
        int j = currentManifestChunkOffset;
        int k = getManifestTrackIndex(streamelement, format);
        int i1 = getManifestTrackKey(enabledTrack.elementIndex, k);
        chunkoperationholder.chunk = newMediaChunk(format, streamelement.buildRequestUri(k, i), null, (ChunkExtractorWrapper)extractorWrappers.get(i1), drmInitData, dataSource, i + j, l1, l, evaluation.trigger, (MediaFormat)mediaFormats.get(i1), enabledTrack.adaptiveMaxWidth, enabledTrack.adaptiveMaxHeight);
    }

    public final MediaFormat getFormat(int i)
    {
        return ((ExposedTrack)tracks.get(i)).trackFormat;
    }

    public int getTrackCount()
    {
        return tracks.size();
    }

    public void maybeThrowError()
    {
        if (fatalError != null)
        {
            throw fatalError;
        } else
        {
            manifestFetcher.maybeThrowError();
            return;
        }
    }

    public void onChunkLoadCompleted(Chunk chunk)
    {
    }

    public void onChunkLoadError(Chunk chunk, Exception exception)
    {
    }

    public boolean prepare()
    {
        if (!prepareCalled)
        {
            prepareCalled = true;
            try
            {
                trackSelector.selectTracks(currentManifest, this);
            }
            catch (IOException ioexception)
            {
                fatalError = ioexception;
            }
        }
        return fatalError == null;
    }
}
