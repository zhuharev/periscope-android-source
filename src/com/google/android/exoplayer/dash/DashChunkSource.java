// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer.BehindLiveWindowException;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.TimeRange;
import com.google.android.exoplayer.chunk.Chunk;
import com.google.android.exoplayer.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer.chunk.ChunkOperationHolder;
import com.google.android.exoplayer.chunk.ChunkSource;
import com.google.android.exoplayer.chunk.ContainerMediaChunk;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.FormatEvaluator;
import com.google.android.exoplayer.chunk.InitializationChunk;
import com.google.android.exoplayer.chunk.MediaChunk;
import com.google.android.exoplayer.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer.dash.mpd.AdaptationSet;
import com.google.android.exoplayer.dash.mpd.ContentProtection;
import com.google.android.exoplayer.dash.mpd.MediaPresentationDescription;
import com.google.android.exoplayer.dash.mpd.Period;
import com.google.android.exoplayer.dash.mpd.RangedUri;
import com.google.android.exoplayer.dash.mpd.Representation;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.ChunkIndex;
import com.google.android.exoplayer.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer.extractor.webm.WebmExtractor;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Clock;
import com.google.android.exoplayer.util.ManifestFetcher;
import com.google.android.exoplayer.util.MimeTypes;
import com.google.android.exoplayer.util.SystemClock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.dash:
//            DefaultDashTrackSelector, DashWrappingSegmentIndex, DashTrackSelector, DashSegmentIndex

public class DashChunkSource
    implements ChunkSource, DashTrackSelector.Output
{
    public static interface EventListener
    {

        public abstract void onAvailableRangeChanged(TimeRange timerange);
    }

    static final class ExposedTrack
    {

        private final int adaptationSetIndex;
        private final Format adaptiveFormats[];
        private final int adaptiveMaxHeight;
        private final int adaptiveMaxWidth;
        private final Format fixedFormat;
        public final MediaFormat trackFormat;

        public final boolean isAdaptive()
        {
            return adaptiveFormats != null;
        }






        public ExposedTrack(MediaFormat mediaformat, int i, Format format)
        {
            trackFormat = mediaformat;
            adaptationSetIndex = i;
            fixedFormat = format;
            adaptiveFormats = null;
            adaptiveMaxWidth = -1;
            adaptiveMaxHeight = -1;
        }

        public ExposedTrack(MediaFormat mediaformat, int i, Format aformat[], int j, int k)
        {
            trackFormat = mediaformat;
            adaptationSetIndex = i;
            adaptiveFormats = aformat;
            adaptiveMaxWidth = j;
            adaptiveMaxHeight = k;
            fixedFormat = null;
        }
    }

    public static class NoAdaptationSetException extends IOException
    {

        public NoAdaptationSetException(String s)
        {
            super(s);
        }
    }

    static final class PeriodHolder
    {

        private long availableEndTimeUs;
        private long availableStartTimeUs;
        private DrmInitData drmInitData;
        private boolean indexIsExplicit;
        private boolean indexIsUnbounded;
        public final int localIndex;
        public final HashMap representationHolders = new HashMap();
        private final int representationIndices[];
        public final long startTimeUs;

        private static DrmInitData getDrmInitData(AdaptationSet adaptationset)
        {
            String s;
            if (DashChunkSource.mimeTypeIsWebm(((Representation)adaptationset.representations.get(0)).format.mimeType))
            {
                s = "video/webm";
            } else
            {
                s = "video/mp4";
            }
            if (adaptationset.contentProtections.isEmpty())
            {
                return null;
            }
            com.google.android.exoplayer.drm.DrmInitData.Mapped mapped = null;
            for (int i = 0; i < adaptationset.contentProtections.size();)
            {
                ContentProtection contentprotection = (ContentProtection)adaptationset.contentProtections.get(i);
                com.google.android.exoplayer.drm.DrmInitData.Mapped mapped1 = mapped;
                if (contentprotection.uuid != null)
                {
                    mapped1 = mapped;
                    if (contentprotection.data != null)
                    {
                        mapped1 = mapped;
                        if (mapped == null)
                        {
                            mapped1 = new com.google.android.exoplayer.drm.DrmInitData.Mapped(s);
                        }
                        mapped1.put(contentprotection.uuid, contentprotection.data);
                    }
                }
                i++;
                mapped = mapped1;
            }

            return mapped;
        }

        private static long getPeriodDurationUs(MediaPresentationDescription mediapresentationdescription, int i)
        {
            long l = mediapresentationdescription.getPeriodDuration(i);
            if (l == -1L)
            {
                return -1L;
            } else
            {
                return 1000L * l;
            }
        }

        private static int getRepresentationIndex(List list, String s)
        {
            for (int i = 0; i < list.size(); i++)
            {
                if (s.equals(((Representation)list.get(i)).format.id))
                {
                    return i;
                }
            }

            throw new IllegalStateException((new StringBuilder("Missing format id: ")).append(s).toString());
        }

        private void updateRepresentationIndependentProperties(long l, Representation representation)
        {
            representation = representation.getIndex();
            if (representation != null)
            {
                int i = representation.getFirstSegmentNum();
                int j = representation.getLastSegmentNum(l);
                boolean flag;
                if (j == -1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                indexIsUnbounded = flag;
                indexIsExplicit = representation.isExplicit();
                availableStartTimeUs = startTimeUs + representation.getTimeUs(i);
                if (!indexIsUnbounded)
                {
                    availableEndTimeUs = startTimeUs + representation.getTimeUs(j) + representation.getDurationUs(j, l);
                }
                return;
            } else
            {
                indexIsUnbounded = false;
                indexIsExplicit = true;
                availableStartTimeUs = startTimeUs;
                availableEndTimeUs = startTimeUs + l;
                return;
            }
        }

        public final long getAvailableEndTimeUs()
        {
            if (isIndexUnbounded())
            {
                throw new IllegalStateException("Period has unbounded index");
            } else
            {
                return availableEndTimeUs;
            }
        }

        public final long getAvailableStartTimeUs()
        {
            return availableStartTimeUs;
        }

        public final boolean isIndexExplicit()
        {
            return indexIsExplicit;
        }

        public final boolean isIndexUnbounded()
        {
            return indexIsUnbounded;
        }

        public final void updatePeriod(MediaPresentationDescription mediapresentationdescription, int i, ExposedTrack exposedtrack)
        {
            Period period = mediapresentationdescription.getPeriod(i);
            long l = getPeriodDurationUs(mediapresentationdescription, i);
            mediapresentationdescription = ((AdaptationSet)period.adaptationSets.get(exposedtrack.adaptationSetIndex)).representations;
            for (i = 0; i < representationIndices.length; i++)
            {
                exposedtrack = (Representation)mediapresentationdescription.get(representationIndices[i]);
                ((RepresentationHolder)representationHolders.get(((Representation) (exposedtrack)).format.id)).updateRepresentation(l, exposedtrack);
            }

            updateRepresentationIndependentProperties(l, (Representation)mediapresentationdescription.get(representationIndices[0]));
        }



/*
        static DrmInitData access$202(PeriodHolder periodholder, DrmInitData drminitdata)
        {
            periodholder.drmInitData = drminitdata;
            return drminitdata;
        }

*/

        public PeriodHolder(int i, MediaPresentationDescription mediapresentationdescription, int j, ExposedTrack exposedtrack)
        {
            localIndex = i;
            Period period = mediapresentationdescription.getPeriod(j);
            long l = getPeriodDurationUs(mediapresentationdescription, j);
            AdaptationSet adaptationset = (AdaptationSet)period.adaptationSets.get(exposedtrack.adaptationSetIndex);
            mediapresentationdescription = adaptationset.representations;
            startTimeUs = period.startMs * 1000L;
            drmInitData = getDrmInitData(adaptationset);
            if (!exposedtrack.isAdaptive())
            {
                representationIndices = (new int[] {
                    getRepresentationIndex(mediapresentationdescription, exposedtrack.fixedFormat.id)
                });
            } else
            {
                representationIndices = new int[exposedtrack.adaptiveFormats.length];
                for (i = 0; i < exposedtrack.adaptiveFormats.length; i++)
                {
                    representationIndices[i] = getRepresentationIndex(mediapresentationdescription, exposedtrack.adaptiveFormats[i].id);
                }

            }
            for (i = 0; i < representationIndices.length; i++)
            {
                exposedtrack = (Representation)mediapresentationdescription.get(representationIndices[i]);
                RepresentationHolder representationholder = new RepresentationHolder(startTimeUs, l, exposedtrack);
                representationHolders.put(((Representation) (exposedtrack)).format.id, representationholder);
            }

            updateRepresentationIndependentProperties(l, (Representation)mediapresentationdescription.get(representationIndices[0]));
        }
    }

    static final class RepresentationHolder
    {

        public final ChunkExtractorWrapper extractorWrapper;
        public MediaFormat mediaFormat;
        private long periodDurationUs;
        private final long periodStartTimeUs;
        public Representation representation;
        public DashSegmentIndex segmentIndex;
        private int segmentNumShift;

        public final int getFirstAvailableSegmentNum()
        {
            return segmentIndex.getFirstSegmentNum() + segmentNumShift;
        }

        public final long getSegmentEndTimeUs(int i)
        {
            return getSegmentStartTimeUs(i) + segmentIndex.getDurationUs(i - segmentNumShift, periodDurationUs);
        }

        public final int getSegmentNum(long l)
        {
            return segmentIndex.getSegmentNum(l - periodStartTimeUs, periodDurationUs) + segmentNumShift;
        }

        public final long getSegmentStartTimeUs(int i)
        {
            return segmentIndex.getTimeUs(i - segmentNumShift) + periodStartTimeUs;
        }

        public final RangedUri getSegmentUrl(int i)
        {
            return segmentIndex.getSegmentUrl(i - segmentNumShift);
        }

        public final boolean isLastSegment(int i)
        {
            int j = segmentIndex.getLastSegmentNum(periodDurationUs);
            return j != -1 && i == segmentNumShift + j;
        }

        public final void updateRepresentation(long l, Representation representation1)
        {
            DashSegmentIndex dashsegmentindex = representation.getIndex();
            DashSegmentIndex dashsegmentindex1 = representation1.getIndex();
            periodDurationUs = l;
            representation = representation1;
            if (dashsegmentindex == null)
            {
                return;
            }
            segmentIndex = dashsegmentindex1;
            if (!dashsegmentindex.isExplicit())
            {
                return;
            }
            int i = dashsegmentindex.getLastSegmentNum(periodDurationUs);
            l = dashsegmentindex.getTimeUs(i) + dashsegmentindex.getDurationUs(i, periodDurationUs);
            i = dashsegmentindex1.getFirstSegmentNum();
            long l1 = dashsegmentindex1.getTimeUs(i);
            if (l == l1)
            {
                segmentNumShift = segmentNumShift + ((dashsegmentindex.getLastSegmentNum(periodDurationUs) + 1) - i);
                return;
            }
            if (l < l1)
            {
                throw new BehindLiveWindowException();
            } else
            {
                segmentNumShift = segmentNumShift + (dashsegmentindex.getSegmentNum(l1, periodDurationUs) - i);
                return;
            }
        }

        public RepresentationHolder(long l, long l1, Representation representation1)
        {
            periodStartTimeUs = l;
            periodDurationUs = l1;
            representation = representation1;
            Object obj = representation1.format.mimeType;
            if (DashChunkSource.mimeTypeIsRawText(((String) (obj))))
            {
                obj = null;
            } else
            {
                if (DashChunkSource.mimeTypeIsWebm(((String) (obj))))
                {
                    obj = new WebmExtractor();
                } else
                {
                    obj = new FragmentedMp4Extractor();
                }
                obj = new ChunkExtractorWrapper(((com.google.android.exoplayer.extractor.Extractor) (obj)));
            }
            extractorWrapper = ((ChunkExtractorWrapper) (obj));
            segmentIndex = representation1.getIndex();
        }
    }


    private static final String TAG = "DashChunkSource";
    private final FormatEvaluator adaptiveFormatEvaluator;
    private TimeRange availableRange;
    private final long availableRangeValues[];
    private MediaPresentationDescription currentManifest;
    private final DataSource dataSource;
    private final long elapsedRealtimeOffsetUs;
    private ExposedTrack enabledTrack;
    private final com.google.android.exoplayer.chunk.FormatEvaluator.Evaluation evaluation;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private IOException fatalError;
    private boolean lastChunkWasInitialization;
    private final boolean live;
    private final long liveEdgeLatencyUs;
    private final ManifestFetcher manifestFetcher;
    private int nextPeriodHolderIndex;
    private final SparseArray periodHolders;
    private boolean prepareCalled;
    private boolean startAtLiveEdge;
    private final Clock systemClock;
    private final DashTrackSelector trackSelector;
    private final ArrayList tracks;

    public DashChunkSource(MediaPresentationDescription mediapresentationdescription, DashTrackSelector dashtrackselector, DataSource datasource, FormatEvaluator formatevaluator)
    {
        this(null, mediapresentationdescription, dashtrackselector, datasource, formatevaluator, ((Clock) (new SystemClock())), 0L, 0L, false, null, null);
    }

    public DashChunkSource(DataSource datasource, FormatEvaluator formatevaluator, long l, int i, List list)
    {
        this(buildManifest(l, i, list), ((DashTrackSelector) (DefaultDashTrackSelector.newVideoInstance(null, false, false))), datasource, formatevaluator);
    }

    public transient DashChunkSource(DataSource datasource, FormatEvaluator formatevaluator, long l, int i, Representation arepresentation[])
    {
        this(datasource, formatevaluator, l, i, Arrays.asList(arepresentation));
    }

    public DashChunkSource(ManifestFetcher manifestfetcher, DashTrackSelector dashtrackselector, DataSource datasource, FormatEvaluator formatevaluator, long l, long l1, Handler handler, EventListener eventlistener)
    {
        this(manifestfetcher, (MediaPresentationDescription)manifestfetcher.getManifest(), dashtrackselector, datasource, formatevaluator, ((Clock) (new SystemClock())), 1000L * l, 1000L * l1, true, handler, eventlistener);
    }

    public DashChunkSource(ManifestFetcher manifestfetcher, DashTrackSelector dashtrackselector, DataSource datasource, FormatEvaluator formatevaluator, long l, long l1, boolean flag, Handler handler, EventListener eventlistener)
    {
        this(manifestfetcher, (MediaPresentationDescription)manifestfetcher.getManifest(), dashtrackselector, datasource, formatevaluator, ((Clock) (new SystemClock())), 1000L * l, 1000L * l1, flag, handler, eventlistener);
    }

    DashChunkSource(ManifestFetcher manifestfetcher, MediaPresentationDescription mediapresentationdescription, DashTrackSelector dashtrackselector, DataSource datasource, FormatEvaluator formatevaluator, Clock clock, long l, long l1, boolean flag, Handler handler, EventListener eventlistener)
    {
        manifestFetcher = manifestfetcher;
        currentManifest = mediapresentationdescription;
        trackSelector = dashtrackselector;
        dataSource = datasource;
        adaptiveFormatEvaluator = formatevaluator;
        systemClock = clock;
        liveEdgeLatencyUs = l;
        elapsedRealtimeOffsetUs = l1;
        startAtLiveEdge = flag;
        eventHandler = handler;
        eventListener = eventlistener;
        evaluation = new com.google.android.exoplayer.chunk.FormatEvaluator.Evaluation();
        availableRangeValues = new long[2];
        periodHolders = new SparseArray();
        tracks = new ArrayList();
        live = mediapresentationdescription.dynamic;
    }

    private static MediaPresentationDescription buildManifest(long l, int i, List list)
    {
        return new MediaPresentationDescription(-1L, l, -1L, false, -1L, -1L, null, null, Collections.singletonList(new Period(null, 0L, Collections.singletonList(new AdaptationSet(0, i, list)))));
    }

    private PeriodHolder findPeriodHolder(long l)
    {
        if (l < ((PeriodHolder)periodHolders.valueAt(0)).getAvailableStartTimeUs())
        {
            return (PeriodHolder)periodHolders.valueAt(0);
        }
        for (int i = 0; i < periodHolders.size() - 1; i++)
        {
            PeriodHolder periodholder = (PeriodHolder)periodHolders.valueAt(i);
            if (l < periodholder.getAvailableEndTimeUs())
            {
                return periodholder;
            }
        }

        return (PeriodHolder)periodHolders.valueAt(periodHolders.size() - 1);
    }

    private static String getAudioMediaMimeType(Format format)
    {
        String s = format.codecs;
        if (TextUtils.isEmpty(s))
        {
            Log.w("DashChunkSource", (new StringBuilder("Codecs attribute missing: ")).append(format.id).toString());
            return "audio/x-unknown";
        }
        if (s.startsWith("mp4a"))
        {
            return "audio/mp4a-latm";
        }
        if (s.startsWith("ac-3") || s.startsWith("dac3"))
        {
            return "audio/ac3";
        }
        if (s.startsWith("ec-3") || s.startsWith("dec3"))
        {
            return "audio/eac3";
        }
        if (s.startsWith("dtsc") || s.startsWith("dtse"))
        {
            return "audio/vnd.dts";
        }
        if (s.startsWith("dtsh") || s.startsWith("dtsl"))
        {
            return "audio/vnd.dts.hd";
        }
        if (s.startsWith("opus"))
        {
            return "audio/opus";
        } else
        {
            Log.w("DashChunkSource", (new StringBuilder("Failed to parse mime from codecs: ")).append(format.id).append(", ").append(s).toString());
            return "audio/x-unknown";
        }
    }

    private TimeRange getAvailableRange(long l)
    {
        PeriodHolder periodholder = (PeriodHolder)periodHolders.valueAt(0);
        PeriodHolder periodholder1 = (PeriodHolder)periodHolders.valueAt(periodHolders.size() - 1);
        if (!currentManifest.dynamic || periodholder1.isIndexExplicit())
        {
            return new com.google.android.exoplayer.TimeRange.StaticTimeRange(periodholder.getAvailableStartTimeUs(), periodholder1.getAvailableEndTimeUs());
        }
        long l3 = periodholder.getAvailableStartTimeUs();
        long l1;
        if (periodholder1.isIndexUnbounded())
        {
            l1 = 0x7fffffffffffffffL;
        } else
        {
            l1 = periodholder1.getAvailableEndTimeUs();
        }
        long l4 = systemClock.elapsedRealtime();
        long l5 = currentManifest.availabilityStartTime;
        long l2;
        if (currentManifest.timeShiftBufferDepth == -1L)
        {
            l2 = -1L;
        } else
        {
            l2 = currentManifest.timeShiftBufferDepth * 1000L;
        }
        return new com.google.android.exoplayer.TimeRange.DynamicTimeRange(l3, l1, l4 * 1000L - (l - l5 * 1000L), l2, systemClock);
    }

    private static String getMediaMimeType(Format format)
    {
        String s = format.mimeType;
        if (MimeTypes.isAudio(s))
        {
            return getAudioMediaMimeType(format);
        }
        if (MimeTypes.isVideo(s))
        {
            return getVideoMediaMimeType(format);
        }
        if (mimeTypeIsRawText(s))
        {
            return s;
        }
        if ("application/mp4".equals(s) && "stpp".equals(format.codecs))
        {
            return "application/ttml+xml";
        } else
        {
            return null;
        }
    }

    private long getNowUnixTimeUs()
    {
        if (elapsedRealtimeOffsetUs != 0L)
        {
            return systemClock.elapsedRealtime() * 1000L + elapsedRealtimeOffsetUs;
        } else
        {
            return System.currentTimeMillis() * 1000L;
        }
    }

    private static MediaFormat getTrackFormat(int i, Format format, String s, long l)
    {
        switch (i)
        {
        case 0: // '\0'
            return MediaFormat.createVideoFormat(-1, s, format.bitrate, -1, l, format.width, format.height, null);

        case 1: // '\001'
            return MediaFormat.createAudioFormat(-1, s, format.bitrate, -1, l, format.audioChannels, format.audioSamplingRate, null, format.language);

        case 2: // '\002'
            return MediaFormat.createTextFormat(-1, s, format.bitrate, l, format.language);
        }
        return null;
    }

    private static String getVideoMediaMimeType(Format format)
    {
        String s = format.codecs;
        if (TextUtils.isEmpty(s))
        {
            Log.w("DashChunkSource", (new StringBuilder("Codecs attribute missing: ")).append(format.id).toString());
            return "video/x-unknown";
        }
        if (s.startsWith("avc1") || s.startsWith("avc3"))
        {
            return "video/avc";
        }
        if (s.startsWith("hev1") || s.startsWith("hvc1"))
        {
            return "video/hevc";
        }
        if (s.startsWith("vp9"))
        {
            return "video/x-vnd.on2.vp9";
        }
        if (s.startsWith("vp8"))
        {
            return "video/x-vnd.on2.vp8";
        } else
        {
            Log.w("DashChunkSource", (new StringBuilder("Failed to parse mime from codecs: ")).append(format.id).append(", ").append(s).toString());
            return "video/x-unknown";
        }
    }

    static boolean mimeTypeIsRawText(String s)
    {
        return "text/vtt".equals(s) || "application/ttml+xml".equals(s);
    }

    static boolean mimeTypeIsWebm(String s)
    {
        return s.startsWith("video/webm") || s.startsWith("audio/webm") || s.startsWith("application/webm");
    }

    private Chunk newInitializationChunk(RangedUri rangeduri, RangedUri rangeduri1, Representation representation, ChunkExtractorWrapper chunkextractorwrapper, DataSource datasource, int i, int j)
    {
        RangedUri rangeduri2 = rangeduri1;
        if (rangeduri != null)
        {
            rangeduri1 = rangeduri.attemptMerge(rangeduri1);
            rangeduri2 = rangeduri1;
            if (rangeduri1 == null)
            {
                rangeduri2 = rangeduri;
            }
        }
        return new InitializationChunk(datasource, new DataSpec(rangeduri2.getUri(), rangeduri2.start, rangeduri2.length, representation.getCacheKey()), j, representation.format, chunkextractorwrapper, i);
    }

    private Chunk newMediaChunk(PeriodHolder periodholder, RepresentationHolder representationholder, DataSource datasource, MediaFormat mediaformat, int i, int j)
    {
        Representation representation = representationholder.representation;
        Format format = representation.format;
        long l = representationholder.getSegmentStartTimeUs(i);
        long l1 = representationholder.getSegmentEndTimeUs(i);
        Object obj = representationholder.getSegmentUrl(i);
        obj = new DataSpec(((RangedUri) (obj)).getUri(), ((RangedUri) (obj)).start, ((RangedUri) (obj)).length, representation.getCacheKey());
        long l2 = periodholder.startTimeUs;
        long l3 = representation.presentationTimeOffsetUs;
        if (mimeTypeIsRawText(format.mimeType))
        {
            return new SingleSampleMediaChunk(datasource, ((DataSpec) (obj)), 1, format, l, l1, i, enabledTrack.trackFormat, null, periodholder.localIndex);
        }
        boolean flag;
        if (mediaformat != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new ContainerMediaChunk(datasource, ((DataSpec) (obj)), j, format, l, l1, i, l2 - l3, representationholder.extractorWrapper, mediaformat, enabledTrack.adaptiveMaxWidth, enabledTrack.adaptiveMaxHeight, periodholder.drmInitData, flag, periodholder.localIndex);
    }

    private void notifyAvailableRangeChanged(final TimeRange seekRange)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls1());
        }
    }

    private void processManifest(MediaPresentationDescription mediapresentationdescription)
    {
        PeriodHolder periodholder1;
        for (Period period = mediapresentationdescription.getPeriod(0); periodHolders.size() > 0 && ((PeriodHolder)periodHolders.valueAt(0)).startTimeUs < period.startMs * 1000L; periodHolders.remove(periodholder1.localIndex))
        {
            periodholder1 = (PeriodHolder)periodHolders.valueAt(0);
        }

        int i;
        try
        {
            i = periodHolders.size();
        }
        // Misplaced declaration of an exception variable
        catch (MediaPresentationDescription mediapresentationdescription)
        {
            fatalError = mediapresentationdescription;
            return;
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        ((PeriodHolder)periodHolders.valueAt(0)).updatePeriod(mediapresentationdescription, 0, enabledTrack);
        if (i <= 1)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        i--;
        ((PeriodHolder)periodHolders.valueAt(i)).updatePeriod(mediapresentationdescription, i, enabledTrack);
        for (int j = periodHolders.size(); j < mediapresentationdescription.getPeriodCount(); j++)
        {
            PeriodHolder periodholder = new PeriodHolder(nextPeriodHolderIndex, mediapresentationdescription, j, enabledTrack);
            periodHolders.put(nextPeriodHolderIndex, periodholder);
            nextPeriodHolderIndex = nextPeriodHolderIndex + 1;
        }

        TimeRange timerange = getAvailableRange(getNowUnixTimeUs());
        if (availableRange == null || !availableRange.equals(timerange))
        {
            availableRange = timerange;
            notifyAvailableRangeChanged(availableRange);
        }
        currentManifest = mediapresentationdescription;
        return;
    }

    public void adaptiveTrack(MediaPresentationDescription mediapresentationdescription, int i, int j, int ai[])
    {
        if (adaptiveFormatEvaluator == null)
        {
            Log.w("DashChunkSource", "Skipping adaptive track (missing format evaluator)");
            return;
        }
        AdaptationSet adaptationset = (AdaptationSet)mediapresentationdescription.getPeriod(i).adaptationSets.get(j);
        int l = 0;
        int k = 0;
        Format format = null;
        Format aformat[] = new Format[ai.length];
        for (i = 0; i < aformat.length; i++)
        {
            Format format1 = ((Representation)adaptationset.representations.get(ai[i])).format;
            if (format == null || format1.height > k)
            {
                format = format1;
            }
            l = Math.max(l, format1.width);
            k = Math.max(k, format1.height);
            aformat[i] = format1;
        }

        Arrays.sort(aformat, new com.google.android.exoplayer.chunk.Format.DecreasingBandwidthComparator());
        long l1;
        if (live)
        {
            l1 = -1L;
        } else
        {
            l1 = mediapresentationdescription.duration * 1000L;
        }
        mediapresentationdescription = getMediaMimeType(format);
        if (mediapresentationdescription == null)
        {
            Log.w("DashChunkSource", "Skipped adaptive track (unknown media mime type)");
            return;
        }
        mediapresentationdescription = getTrackFormat(adaptationset.type, format, mediapresentationdescription, l1);
        if (mediapresentationdescription == null)
        {
            Log.w("DashChunkSource", "Skipped adaptive track (unknown media format)");
            return;
        } else
        {
            tracks.add(new ExposedTrack(mediapresentationdescription.copyAsAdaptive(), j, aformat, l, k));
            return;
        }
    }

    public void continueBuffering(long l)
    {
        if (manifestFetcher == null || !currentManifest.dynamic || fatalError != null)
        {
            return;
        }
        MediaPresentationDescription mediapresentationdescription = (MediaPresentationDescription)manifestFetcher.getManifest();
        if (currentManifest != mediapresentationdescription && mediapresentationdescription != null)
        {
            processManifest(mediapresentationdescription);
        }
        long l1 = currentManifest.minUpdatePeriod;
        l = l1;
        if (l1 == 0L)
        {
            l = 5000L;
        }
        if (android.os.SystemClock.elapsedRealtime() > manifestFetcher.getManifestLoadStartTimestamp() + l)
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
        periodHolders.clear();
        evaluation.format = null;
        availableRange = null;
        fatalError = null;
        enabledTrack = null;
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
            processManifest((MediaPresentationDescription)manifestFetcher.getManifest());
            return;
        } else
        {
            processManifest(currentManifest);
            return;
        }
    }

    public void fixedTrack(MediaPresentationDescription mediapresentationdescription, int i, int j, int k)
    {
        AdaptationSet adaptationset = (AdaptationSet)mediapresentationdescription.getPeriod(i).adaptationSets.get(j);
        Format format = ((Representation)adaptationset.representations.get(k)).format;
        String s = getMediaMimeType(format);
        if (s == null)
        {
            Log.w("DashChunkSource", (new StringBuilder("Skipped track ")).append(format.id).append(" (unknown media mime type)").toString());
            return;
        }
        i = adaptationset.type;
        long l;
        if (mediapresentationdescription.dynamic)
        {
            l = -1L;
        } else
        {
            l = mediapresentationdescription.duration * 1000L;
        }
        mediapresentationdescription = getTrackFormat(i, format, s, l);
        if (mediapresentationdescription == null)
        {
            Log.w("DashChunkSource", (new StringBuilder("Skipped track ")).append(format.id).append(" (unknown media format)").toString());
            return;
        } else
        {
            tracks.add(new ExposedTrack(mediapresentationdescription, j, format));
            return;
        }
    }

    TimeRange getAvailableRange()
    {
        return availableRange;
    }

    public final void getChunkOperation(List list, long l, long l1, ChunkOperationHolder chunkoperationholder)
    {
        if (fatalError != null)
        {
            chunkoperationholder.chunk = null;
            return;
        }
        evaluation.queueSize = list.size();
        if (evaluation.format == null || !lastChunkWasInitialization)
        {
            if (enabledTrack.isAdaptive())
            {
                adaptiveFormatEvaluator.evaluate(list, l1, enabledTrack.adaptiveFormats, evaluation);
            } else
            {
                evaluation.format = enabledTrack.fixedFormat;
                evaluation.trigger = 2;
            }
        }
        Object obj = evaluation.format;
        chunkoperationholder.queueSize = evaluation.queueSize;
        if (obj == null)
        {
            chunkoperationholder.chunk = null;
            return;
        }
        if (chunkoperationholder.queueSize == list.size() && chunkoperationholder.chunk != null && chunkoperationholder.chunk.format.equals(obj))
        {
            return;
        }
        chunkoperationholder.chunk = null;
        availableRange.getCurrentBoundsUs(availableRangeValues);
        PeriodHolder periodholder;
        int i;
        if (list.isEmpty())
        {
            l1 = l;
            if (live)
            {
                if (startAtLiveEdge)
                {
                    l1 = Math.max(availableRangeValues[0], availableRangeValues[1] - liveEdgeLatencyUs);
                } else
                {
                    l1 = Math.max(Math.min(l, availableRangeValues[1] - 1L), availableRangeValues[0]);
                }
            }
            periodholder = findPeriodHolder(l1);
            i = 1;
        } else
        {
            if (startAtLiveEdge)
            {
                startAtLiveEdge = false;
            }
            MediaChunk mediachunk = (MediaChunk)list.get(chunkoperationholder.queueSize - 1);
            l1 = mediachunk.endTimeUs;
            if (live && l1 < availableRangeValues[0])
            {
                fatalError = new BehindLiveWindowException();
                return;
            }
            if (currentManifest.dynamic && l1 >= availableRangeValues[1])
            {
                return;
            }
            if (!currentManifest.dynamic)
            {
                periodholder = (PeriodHolder)periodHolders.valueAt(periodHolders.size() - 1);
                if (mediachunk.parentId == periodholder.localIndex && ((RepresentationHolder)periodholder.representationHolders.get(mediachunk.format.id)).isLastSegment(mediachunk.chunkIndex))
                {
                    chunkoperationholder.endOfStream = true;
                    return;
                }
            }
            boolean flag = false;
            PeriodHolder periodholder1 = (PeriodHolder)periodHolders.get(mediachunk.parentId);
            if (periodholder1 == null)
            {
                periodholder = (PeriodHolder)periodHolders.valueAt(0);
                i = 1;
                l1 = l;
            } else
            {
                periodholder = periodholder1;
                l1 = l;
                i = ((flag) ? 1 : 0);
                if (!periodholder1.isIndexUnbounded())
                {
                    periodholder = periodholder1;
                    l1 = l;
                    i = ((flag) ? 1 : 0);
                    if (((RepresentationHolder)periodholder1.representationHolders.get(mediachunk.format.id)).isLastSegment(mediachunk.chunkIndex))
                    {
                        periodholder = (PeriodHolder)periodHolders.get(mediachunk.parentId + 1);
                        i = 1;
                        l1 = l;
                    }
                }
            }
        }
        RepresentationHolder representationholder = (RepresentationHolder)periodholder.representationHolders.get(((Format) (obj)).id);
        Representation representation = representationholder.representation;
        RangedUri rangeduri = null;
        obj = null;
        MediaFormat mediaformat = representationholder.mediaFormat;
        if (mediaformat == null)
        {
            rangeduri = representation.getInitializationUri();
        }
        if (representationholder.segmentIndex == null)
        {
            obj = representation.getIndexUri();
        }
        if (rangeduri != null || obj != null)
        {
            list = newInitializationChunk(rangeduri, ((RangedUri) (obj)), representation, representationholder.extractorWrapper, dataSource, periodholder.localIndex, evaluation.trigger);
            lastChunkWasInitialization = true;
            chunkoperationholder.chunk = list;
            return;
        }
        if (list.isEmpty())
        {
            i = representationholder.getSegmentNum(l1);
        } else
        if (i != 0)
        {
            i = representationholder.getFirstAvailableSegmentNum();
        } else
        {
            i = ((MediaChunk)list.get(chunkoperationholder.queueSize - 1)).chunkIndex + 1;
        }
        list = newMediaChunk(periodholder, representationholder, dataSource, mediaformat, i, evaluation.trigger);
        lastChunkWasInitialization = false;
        chunkoperationholder.chunk = list;
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
        }
        if (manifestFetcher != null)
        {
            manifestFetcher.maybeThrowError();
        }
    }

    public void onChunkLoadCompleted(Chunk chunk)
    {
        if (chunk instanceof InitializationChunk)
        {
            chunk = (InitializationChunk)chunk;
            Object obj = ((InitializationChunk) (chunk)).format.id;
            PeriodHolder periodholder = (PeriodHolder)periodHolders.get(((InitializationChunk) (chunk)).parentId);
            if (periodholder == null)
            {
                return;
            }
            obj = (RepresentationHolder)periodholder.representationHolders.get(obj);
            if (chunk.hasFormat())
            {
                obj.mediaFormat = chunk.getFormat();
            }
            if (chunk.hasSeekMap())
            {
                obj.segmentIndex = new DashWrappingSegmentIndex((ChunkIndex)chunk.getSeekMap(), ((InitializationChunk) (chunk)).dataSpec.uri.toString());
            }
            if (periodholder.drmInitData == null && chunk.hasDrmInitData())
            {
                periodholder.drmInitData = chunk.getDrmInitData();
            }
        }
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
                trackSelector.selectTracks(currentManifest, 0, this);
            }
            catch (IOException ioexception)
            {
                fatalError = ioexception;
            }
        }
        return fatalError == null;
    }


    private class _cls1
        implements Runnable
    {

        final DashChunkSource this$0;
        final TimeRange val$seekRange;

        public void run()
        {
            eventListener.onAvailableRangeChanged(seekRange);
        }

        _cls1()
        {
            this$0 = DashChunkSource.this;
            seekRange = timerange;
            super();
        }
    }

}
