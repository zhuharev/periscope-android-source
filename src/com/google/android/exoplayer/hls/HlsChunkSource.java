// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer.chunk.BaseChunkSampleSourceEventListener;
import com.google.android.exoplayer.chunk.Chunk;
import com.google.android.exoplayer.chunk.ChunkOperationHolder;
import com.google.android.exoplayer.chunk.DataChunk;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer.extractor.ts.PtsTimestampAdjuster;
import com.google.android.exoplayer.extractor.ts.TsExtractor;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.UriUtil;
import com.google.android.exoplayer.util.Util;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsPlaylist, HlsPlaylistParser, Variant, HlsMediaPlaylist, 
//            HlsMasterPlaylist, TsChunk, HlsExtractorWrapper

public class HlsChunkSource
{
    static class EncryptionKeyChunk extends DataChunk
    {

        public final String iv;
        private byte result[];
        public final int variantIndex;

        protected void consume(byte abyte0[], int i)
        {
            result = Arrays.copyOf(abyte0, i);
        }

        public byte[] getResult()
        {
            return result;
        }

        public EncryptionKeyChunk(DataSource datasource, DataSpec dataspec, byte abyte0[], String s, int i)
        {
            super(datasource, dataspec, 3, 0, null, -1, abyte0);
            iv = s;
            variantIndex = i;
        }
    }

    public static interface EventListener
        extends BaseChunkSampleSourceEventListener
    {
    }

    static class MediaPlaylistChunk extends DataChunk
    {

        private final HlsPlaylistParser playlistParser;
        private final String playlistUrl;
        private HlsMediaPlaylist result;
        public final int variantIndex;

        protected void consume(byte abyte0[], int i)
        {
            result = (HlsMediaPlaylist)playlistParser.parse(playlistUrl, new ByteArrayInputStream(abyte0, 0, i));
        }

        public HlsMediaPlaylist getResult()
        {
            return result;
        }

        public MediaPlaylistChunk(DataSource datasource, DataSpec dataspec, byte abyte0[], HlsPlaylistParser hlsplaylistparser, int i, String s)
        {
            super(datasource, dataspec, 4, 0, null, -1, abyte0);
            variantIndex = i;
            playlistParser = hlsplaylistparser;
            playlistUrl = s;
        }
    }


    private static final String AAC_FILE_EXTENSION = ".aac";
    public static final int ADAPTIVE_MODE_ABRUPT = 3;
    public static final int ADAPTIVE_MODE_NONE = 0;
    public static final int ADAPTIVE_MODE_SPLICE = 1;
    private static final float BANDWIDTH_FRACTION = 0.8F;
    public static final long DEFAULT_MAX_BUFFER_TO_SWITCH_DOWN_MS = 20000L;
    public static final long DEFAULT_MIN_BUFFER_TO_SWITCH_UP_MS = 5000L;
    public static final long DEFAULT_PLAYLIST_BLACKLIST_MS = 60000L;
    private static final String MP3_FILE_EXTENSION = ".mp3";
    private static final String TAG = "HlsChunkSource";
    private final int adaptiveMaxHeight;
    private final int adaptiveMaxWidth;
    private final int adaptiveMode;
    private final BandwidthMeter bandwidthMeter;
    private final String baseUri;
    private final DataSource dataSource;
    private long durationUs;
    private byte encryptionIv[];
    private String encryptionIvString;
    private byte encryptionKey[];
    private Uri encryptionKeyUri;
    private IOException fatalError;
    private boolean live;
    private final long maxBufferDurationToSwitchDownUs;
    private final long minBufferDurationToSwitchUpUs;
    private final HlsPlaylistParser playlistParser;
    private PtsTimestampAdjuster ptsTimestampAdjuster;
    private byte scratchSpace[];
    private int selectedVariantIndex;
    private final long variantBlacklistTimes[];
    private final long variantLastPlaylistLoadTimesMs[];
    private final HlsMediaPlaylist variantPlaylists[];
    private final Variant variants[];

    public HlsChunkSource(DataSource datasource, String s, HlsPlaylist hlsplaylist, BandwidthMeter bandwidthmeter, int ai[], int i)
    {
        this(datasource, s, hlsplaylist, bandwidthmeter, ai, i, 5000L, 20000L);
    }

    public HlsChunkSource(DataSource datasource, String s, HlsPlaylist hlsplaylist, BandwidthMeter bandwidthmeter, int ai[], int i, long l, long l1)
    {
        dataSource = datasource;
        bandwidthMeter = bandwidthmeter;
        adaptiveMode = i;
        minBufferDurationToSwitchUpUs = 1000L * l;
        maxBufferDurationToSwitchDownUs = 1000L * l1;
        baseUri = hlsplaylist.baseUri;
        playlistParser = new HlsPlaylistParser();
        if (hlsplaylist.type == 1)
        {
            variants = (new Variant[] {
                new Variant(0, s, 0, null, -1, -1)
            });
            variantPlaylists = new HlsMediaPlaylist[1];
            variantLastPlaylistLoadTimesMs = new long[1];
            variantBlacklistTimes = new long[1];
            setMediaPlaylist(0, (HlsMediaPlaylist)hlsplaylist);
            adaptiveMaxWidth = -1;
            i = -1;
        } else
        {
            datasource = ((HlsMasterPlaylist)hlsplaylist).variants;
            variants = buildOrderedVariants(datasource, ai);
            variantPlaylists = new HlsMediaPlaylist[variants.length];
            variantLastPlaylistLoadTimesMs = new long[variants.length];
            variantBlacklistTimes = new long[variants.length];
            int k = -1;
            int j = -1;
            int j1 = 0x7fffffff;
            for (int i1 = 0; i1 < variants.length;)
            {
                int i2 = datasource.indexOf(variants[i1]);
                int k1 = j1;
                if (i2 < j1)
                {
                    k1 = i2;
                    selectedVariantIndex = i1;
                }
                s = variants[i1].format;
                k = Math.max(((Format) (s)).width, k);
                j = Math.max(((Format) (s)).height, j);
                i1++;
                j1 = k1;
            }

            if (variants.length <= 1 || i == 0)
            {
                adaptiveMaxWidth = -1;
                i = -1;
            } else
            {
                if (k <= 0)
                {
                    k = 1920;
                }
                adaptiveMaxWidth = k;
                if (j > 0)
                {
                    i = j;
                } else
                {
                    i = 1080;
                }
            }
        }
        adaptiveMaxHeight = i;
    }

    private boolean allVariantsBlacklisted()
    {
        for (int i = 0; i < variantBlacklistTimes.length; i++)
        {
            if (variantBlacklistTimes[i] == 0L)
            {
                return false;
            }
        }

        return true;
    }

    private static Variant[] buildOrderedVariants(List list, int ai[])
    {
        ArrayList arraylist = new ArrayList();
        if (ai != null)
        {
            for (int i = 0; i < ai.length; i++)
            {
                arraylist.add(list.get(ai[i]));
            }

        } else
        {
            arraylist.addAll(list);
        }
        list = new ArrayList();
        ai = new ArrayList();
        for (int j = 0; j < arraylist.size(); j++)
        {
            Variant variant = (Variant)arraylist.get(j);
            if (variant.format.height > 0 || variantHasExplicitCodecWithPrefix(variant, "avc"))
            {
                list.add(variant);
                continue;
            }
            if (variantHasExplicitCodecWithPrefix(variant, "mp4a"))
            {
                ai.add(variant);
            }
        }

        if (list.isEmpty())
        {
            list = arraylist;
            if (ai.size() < arraylist.size())
            {
                arraylist.removeAll(ai);
                list = arraylist;
            }
        }
        ai = new Variant[list.size()];
        list.toArray(ai);
        Arrays.sort(ai, new _cls1());
        return ai;
    }

    private void clearEncryptionData()
    {
        encryptionKeyUri = null;
        encryptionKey = null;
        encryptionIvString = null;
        encryptionIv = null;
    }

    private void clearStaleBlacklistedVariants()
    {
        long l = SystemClock.elapsedRealtime();
        for (int i = 0; i < variantBlacklistTimes.length; i++)
        {
            if (variantBlacklistTimes[i] != 0L && l - variantBlacklistTimes[i] > 60000L)
            {
                variantBlacklistTimes[i] = 0L;
            }
        }

    }

    private int getLiveStartChunkMediaSequence(int i)
    {
        HlsMediaPlaylist hlsmediaplaylist = variantPlaylists[i];
        if (hlsmediaplaylist.segments.size() > 3)
        {
            i = hlsmediaplaylist.segments.size() - 3;
        } else
        {
            i = 0;
        }
        return i + hlsmediaplaylist.mediaSequence;
    }

    private int getNextVariantIndex(TsChunk tschunk, long l)
    {
        clearStaleBlacklistedVariants();
        long l1 = bandwidthMeter.getBitrateEstimate();
        if (variantBlacklistTimes[selectedVariantIndex] != 0L)
        {
            return getVariantIndexForBandwidth(l1);
        }
        if (tschunk == null)
        {
            return selectedVariantIndex;
        }
        if (l1 == -1L)
        {
            return selectedVariantIndex;
        }
        int i = getVariantIndexForBandwidth(l1);
        if (i == selectedVariantIndex)
        {
            return selectedVariantIndex;
        }
        if (adaptiveMode == 1)
        {
            l1 = tschunk.startTimeUs;
        } else
        {
            l1 = tschunk.endTimeUs;
        }
        l = l1 - l;
        if (variantBlacklistTimes[selectedVariantIndex] != 0L || i > selectedVariantIndex && l < maxBufferDurationToSwitchDownUs || i < selectedVariantIndex && l > minBufferDurationToSwitchUpUs)
        {
            return i;
        } else
        {
            return selectedVariantIndex;
        }
    }

    private int getVariantIndex(Format format)
    {
        for (int i = 0; i < variants.length; i++)
        {
            if (variants[i].format.equals(format))
            {
                return i;
            }
        }

        throw new IllegalStateException((new StringBuilder("Invalid format: ")).append(format).toString());
    }

    private int getVariantIndexForBandwidth(long l)
    {
        long l1 = l;
        if (l == -1L)
        {
            l1 = 0L;
        }
        int k = (int)((float)l1 * 0.8F);
        int j = -1;
        for (int i = 0; i < variants.length; i++)
        {
            if (variantBlacklistTimes[i] != 0L)
            {
                continue;
            }
            if (variants[i].format.bitrate <= k)
            {
                return i;
            }
            j = i;
        }

        boolean flag;
        if (j != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        return j;
    }

    private EncryptionKeyChunk newEncryptionKeyChunk(Uri uri, String s, int i)
    {
        uri = new DataSpec(uri, 0L, -1L, null, 1);
        return new EncryptionKeyChunk(dataSource, uri, scratchSpace, s, i);
    }

    private MediaPlaylistChunk newMediaPlaylistChunk(int i)
    {
        Uri uri = UriUtil.resolveToUri(baseUri, variants[i].url);
        DataSpec dataspec = new DataSpec(uri, 0L, -1L, null, 1);
        return new MediaPlaylistChunk(dataSource, dataspec, scratchSpace, playlistParser, i, uri.toString());
    }

    private void setEncryptionData(Uri uri, String s, byte abyte0[])
    {
        String s1;
        if (s.toLowerCase(Locale.getDefault()).startsWith("0x"))
        {
            s1 = s.substring(2);
        } else
        {
            s1 = s;
        }
        byte abyte1[] = (new BigInteger(s1, 16)).toByteArray();
        byte abyte2[] = new byte[16];
        int i;
        if (abyte1.length > 16)
        {
            i = abyte1.length - 16;
        } else
        {
            i = 0;
        }
        System.arraycopy(abyte1, i, abyte2, (16 - abyte1.length) + i, abyte1.length - i);
        encryptionKeyUri = uri;
        encryptionKey = abyte0;
        encryptionIvString = s;
        encryptionIv = abyte2;
    }

    private void setMediaPlaylist(int i, HlsMediaPlaylist hlsmediaplaylist)
    {
        variantLastPlaylistLoadTimesMs[i] = SystemClock.elapsedRealtime();
        variantPlaylists[i] = hlsmediaplaylist;
        live = live | hlsmediaplaylist.live;
        long l;
        if (live)
        {
            l = -1L;
        } else
        {
            l = hlsmediaplaylist.durationUs;
        }
        durationUs = l;
    }

    private boolean shouldRerequestLiveMediaPlaylist(int i)
    {
        HlsMediaPlaylist hlsmediaplaylist = variantPlaylists[i];
        return SystemClock.elapsedRealtime() - variantLastPlaylistLoadTimesMs[i] >= (long)((hlsmediaplaylist.targetDurationSecs * 1000) / 2);
    }

    private static boolean variantHasExplicitCodecWithPrefix(Variant variant, String s)
    {
        variant = variant.format.codecs;
        if (TextUtils.isEmpty(variant))
        {
            return false;
        }
        variant = variant.split("(\\s*,\\s*)|(\\s*$)");
        for (int i = 0; i < variant.length; i++)
        {
            if (variant[i].startsWith(s))
            {
                return true;
            }
        }

        return false;
    }

    public void getChunkOperation(TsChunk tschunk, long l, long l1, ChunkOperationHolder chunkoperationholder)
    {
        int j1;
        boolean flag1;
label0:
        {
            int i;
            if (adaptiveMode == 0)
            {
                i = selectedVariantIndex;
            } else
            {
                j1 = getNextVariantIndex(tschunk, l1);
                i = j1;
                if (tschunk != null)
                {
                    i = j1;
                    if (!variants[j1].format.equals(tschunk.format))
                    {
                        i = j1;
                        if (adaptiveMode == 1)
                        {
                            flag1 = true;
                            break label0;
                        }
                    }
                }
            }
            flag1 = false;
            j1 = i;
        }
        Object obj = variantPlaylists[j1];
        if (obj == null)
        {
            chunkoperationholder.chunk = newMediaPlaylistChunk(j1);
            return;
        }
        selectedVariantIndex = j1;
        boolean flag = false;
        int j;
        if (live)
        {
            if (tschunk == null)
            {
                j = getLiveStartChunkMediaSequence(j1);
            } else
            {
                int k;
                if (flag1)
                {
                    k = tschunk.chunkIndex;
                } else
                {
                    k = tschunk.chunkIndex + 1;
                }
                j = k;
                if (k < ((HlsMediaPlaylist) (obj)).mediaSequence)
                {
                    j = getLiveStartChunkMediaSequence(j1);
                    flag = true;
                }
            }
        } else
        if (tschunk == null)
        {
            j = Util.binarySearchFloor(((HlsMediaPlaylist) (obj)).segments, Long.valueOf(l), true, true) + ((HlsMediaPlaylist) (obj)).mediaSequence;
        } else
        if (flag1)
        {
            j = tschunk.chunkIndex;
        } else
        {
            j = tschunk.chunkIndex + 1;
        }
        int i1 = j - ((HlsMediaPlaylist) (obj)).mediaSequence;
        if (i1 >= ((HlsMediaPlaylist) (obj)).segments.size())
        {
            if (!((HlsMediaPlaylist) (obj)).live)
            {
                chunkoperationholder.endOfStream = true;
                return;
            }
            if (shouldRerequestLiveMediaPlaylist(j1))
            {
                chunkoperationholder.chunk = newMediaPlaylistChunk(j1);
            }
            return;
        }
        HlsMediaPlaylist.Segment segment = (HlsMediaPlaylist.Segment)((HlsMediaPlaylist) (obj)).segments.get(i1);
        Uri uri = UriUtil.resolveToUri(((HlsMediaPlaylist) (obj)).baseUri, segment.url);
        if (segment.isEncrypted)
        {
            obj = UriUtil.resolveToUri(((HlsMediaPlaylist) (obj)).baseUri, segment.encryptionKeyUri);
            if (!((Uri) (obj)).equals(encryptionKeyUri))
            {
                chunkoperationholder.chunk = newEncryptionKeyChunk(((Uri) (obj)), segment.encryptionIV, selectedVariantIndex);
                return;
            }
            if (!Util.areEqual(segment.encryptionIV, encryptionIvString))
            {
                setEncryptionData(((Uri) (obj)), segment.encryptionIV, encryptionKey);
            }
        } else
        {
            clearEncryptionData();
        }
        obj = new DataSpec(uri, segment.byterangeOffset, segment.byterangeLength, null);
        if (live)
        {
            if (tschunk == null)
            {
                l = 0L;
            } else
            if (flag1)
            {
                l = tschunk.startTimeUs;
            } else
            {
                l = tschunk.endTimeUs;
            }
        } else
        {
            l = segment.startTimeUs;
        }
        l1 = (long)(segment.durationSecs * 1000000D);
        Format format = variants[selectedVariantIndex].format;
        if (uri.getLastPathSegment().endsWith(".aac"))
        {
            tschunk = new HlsExtractorWrapper(0, format, l, new AdtsExtractor(l), flag1, adaptiveMaxWidth, adaptiveMaxHeight);
        } else
        if (uri.getLastPathSegment().endsWith(".mp3"))
        {
            tschunk = new HlsExtractorWrapper(0, format, l, new Mp3Extractor(l), flag1, adaptiveMaxWidth, adaptiveMaxHeight);
        } else
        if (tschunk == null || segment.discontinuity || flag || !format.equals(tschunk.format))
        {
            if (tschunk == null || segment.discontinuity || flag || ptsTimestampAdjuster == null)
            {
                ptsTimestampAdjuster = new PtsTimestampAdjuster(l);
            }
            tschunk = new HlsExtractorWrapper(0, format, l, new TsExtractor(ptsTimestampAdjuster), flag1, adaptiveMaxWidth, adaptiveMaxHeight);
        } else
        {
            tschunk = tschunk.extractorWrapper;
        }
        chunkoperationholder.chunk = new TsChunk(dataSource, ((DataSpec) (obj)), 0, format, l, l + l1, j, tschunk, encryptionKey, encryptionIv);
    }

    public long getDurationUs()
    {
        return durationUs;
    }

    public void maybeThrowError()
    {
        if (fatalError != null)
        {
            throw fatalError;
        } else
        {
            return;
        }
    }

    public void onChunkLoadCompleted(Chunk chunk)
    {
        if (chunk instanceof MediaPlaylistChunk)
        {
            chunk = (MediaPlaylistChunk)chunk;
            scratchSpace = chunk.getDataHolder();
            setMediaPlaylist(((MediaPlaylistChunk) (chunk)).variantIndex, chunk.getResult());
            return;
        }
        if (chunk instanceof EncryptionKeyChunk)
        {
            chunk = (EncryptionKeyChunk)chunk;
            scratchSpace = chunk.getDataHolder();
            setEncryptionData(((EncryptionKeyChunk) (chunk)).dataSpec.uri, ((EncryptionKeyChunk) (chunk)).iv, chunk.getResult());
        }
    }

    public boolean onChunkLoadError(Chunk chunk, IOException ioexception)
    {
        if (chunk.bytesLoaded() == 0L && ((chunk instanceof TsChunk) || (chunk instanceof MediaPlaylistChunk) || (chunk instanceof EncryptionKeyChunk)) && (ioexception instanceof com.google.android.exoplayer.upstream.HttpDataSource.InvalidResponseCodeException))
        {
            int j = ((com.google.android.exoplayer.upstream.HttpDataSource.InvalidResponseCodeException)ioexception).responseCode;
            if (j == 404 || j == 410)
            {
                int i;
                if (chunk instanceof TsChunk)
                {
                    i = getVariantIndex(((TsChunk)chunk).format);
                } else
                if (chunk instanceof MediaPlaylistChunk)
                {
                    i = ((MediaPlaylistChunk)chunk).variantIndex;
                } else
                {
                    i = ((EncryptionKeyChunk)chunk).variantIndex;
                }
                boolean flag;
                if (variantBlacklistTimes[i] != 0L)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                variantBlacklistTimes[i] = SystemClock.elapsedRealtime();
                if (flag)
                {
                    Log.w("HlsChunkSource", (new StringBuilder("Already blacklisted variant (")).append(j).append("): ").append(chunk.dataSpec.uri).toString());
                    return false;
                }
                if (!allVariantsBlacklisted())
                {
                    Log.w("HlsChunkSource", (new StringBuilder("Blacklisted variant (")).append(j).append("): ").append(chunk.dataSpec.uri).toString());
                    return true;
                } else
                {
                    Log.w("HlsChunkSource", (new StringBuilder("Final variant not blacklisted (")).append(j).append("): ").append(chunk.dataSpec.uri).toString());
                    variantBlacklistTimes[i] = 0L;
                    return false;
                }
            }
        }
        return false;
    }

    public void reset()
    {
        fatalError = null;
    }

    private class _cls1
        implements Comparator
    {

        private final Comparator formatComparator = new com.google.android.exoplayer.chunk.Format.DecreasingBandwidthComparator();

        public final int compare(Variant variant, Variant variant1)
        {
            return formatComparator.compare(variant.format, variant1.format);
        }

        public final volatile int compare(Object obj, Object obj1)
        {
            return compare((Variant)obj, (Variant)obj1);
        }

        _cls1()
        {
        }
    }

}
