// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.webm;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.extractor.ChunkIndex;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.LongArray;
import com.google.android.exoplayer.util.MimeTypes;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.google.android.exoplayer.extractor.webm:
//            DefaultEbmlReader, EbmlReader, VarintReader, Sniffer, 
//            EbmlReaderOutput

public final class WebmExtractor
    implements Extractor
{
    final class InnerEbmlReaderOutput
        implements EbmlReaderOutput
    {

        final WebmExtractor this$0;

        public final void binaryElement(int i, int j, ExtractorInput extractorinput)
        {
            WebmExtractor.this.binaryElement(i, j, extractorinput);
        }

        public final void endMasterElement(int i)
        {
            WebmExtractor.this.endMasterElement(i);
        }

        public final void floatElement(int i, double d)
        {
            WebmExtractor.this.floatElement(i, d);
        }

        public final int getElementType(int i)
        {
            return WebmExtractor.this.getElementType(i);
        }

        public final void integerElement(int i, long l)
        {
            WebmExtractor.this.integerElement(i, l);
        }

        public final void startMasterElement(int i, long l, long l1)
        {
            WebmExtractor.this.startMasterElement(i, l, l1);
        }

        public final void stringElement(int i, String s)
        {
            WebmExtractor.this.stringElement(i, s);
        }

        private InnerEbmlReaderOutput()
        {
            this$0 = WebmExtractor.this;
            super();
        }

    }

    static final class Track
    {

        public int channelCount;
        public long codecDelayNs;
        public String codecId;
        public byte codecPrivate[];
        public int defaultSampleDurationNs;
        public byte encryptionKeyId[];
        public boolean hasContentEncryption;
        public int height;
        private String language;
        public int nalUnitLengthFieldLength;
        public int number;
        public TrackOutput output;
        public int sampleRate;
        public byte sampleStrippedBytes[];
        public long seekPreRollNs;
        public int type;
        public int width;

        private static Pair parseAvcCodecPrivate(ParsableByteArray parsablebytearray)
        {
            ArrayList arraylist;
            int i;
            int j;
            int k;
            boolean flag;
            try
            {
                parsablebytearray.setPosition(4);
                j = (parsablebytearray.readUnsignedByte() & 3) + 1;
            }
            // Misplaced declaration of an exception variable
            catch (ParsableByteArray parsablebytearray)
            {
                throw new ParserException("Error parsing AVC codec private");
            }
            if (j != 3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            arraylist = new ArrayList();
            k = parsablebytearray.readUnsignedByte();
            i = 0;
_L2:
            if (i >= (k & 0x1f))
            {
                break; /* Loop/switch isn't completed */
            }
            arraylist.add(NalUnitUtil.parseChildNalUnit(parsablebytearray));
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            k = parsablebytearray.readUnsignedByte();
            i = 0;
_L4:
            if (i >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            arraylist.add(NalUnitUtil.parseChildNalUnit(parsablebytearray));
            i++;
            if (true) goto _L4; else goto _L3
_L3:
            parsablebytearray = Pair.create(arraylist, Integer.valueOf(j));
            return parsablebytearray;
        }

        private static Pair parseHevcCodecPrivate(ParsableByteArray parsablebytearray)
        {
            int i;
            int j;
            byte abyte0[];
            int k;
            int l;
            int i1;
            int j1;
            int k1;
            int l1;
            try
            {
                parsablebytearray.setPosition(21);
                i1 = parsablebytearray.readUnsignedByte();
                j1 = parsablebytearray.readUnsignedByte();
            }
            // Misplaced declaration of an exception variable
            catch (ParsableByteArray parsablebytearray)
            {
                throw new ParserException("Error parsing HEVC codec private");
            }
            i = 0;
            l = parsablebytearray.getPosition();
            j = 0;
_L9:
            if (j >= j1) goto _L2; else goto _L1
_L1:
            parsablebytearray.skipBytes(1);
            k1 = parsablebytearray.readUnsignedShort();
            k = 0;
_L4:
            if (k >= k1)
            {
                break; /* Loop/switch isn't completed */
            }
            l1 = parsablebytearray.readUnsignedShort();
            i += l1 + 4;
            parsablebytearray.skipBytes(l1);
            k++;
            if (true) goto _L4; else goto _L3
_L2:
            parsablebytearray.setPosition(l);
            abyte0 = new byte[i];
            l = 0;
            j = 0;
_L10:
            if (j >= j1) goto _L6; else goto _L5
_L5:
            parsablebytearray.skipBytes(1);
            k1 = parsablebytearray.readUnsignedShort();
            k = 0;
_L8:
            if (k >= k1)
            {
                continue; /* Loop/switch isn't completed */
            }
            l1 = parsablebytearray.readUnsignedShort();
            System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, abyte0, l, NalUnitUtil.NAL_START_CODE.length);
            l += NalUnitUtil.NAL_START_CODE.length;
            System.arraycopy(parsablebytearray.data, parsablebytearray.getPosition(), abyte0, l, l1);
            l += l1;
            parsablebytearray.skipBytes(l1);
            k++;
            if (true) goto _L8; else goto _L7
_L7:
            continue; /* Loop/switch isn't completed */
_L12:
            parsablebytearray = Collections.singletonList(abyte0);
_L13:
            parsablebytearray = Pair.create(parsablebytearray, Integer.valueOf((i1 & 3) + 1));
            return parsablebytearray;
_L3:
            j++;
              goto _L9
            j++;
              goto _L10
_L6:
            if (i != 0) goto _L12; else goto _L11
_L11:
            parsablebytearray = null;
              goto _L13
        }

        private static List parseVorbisCodecPrivate(byte abyte0[])
        {
_L2:
            k = j + 1;
            j = abyte0[j];
            if (abyte0[k] == 1)
            {
                break MISSING_BLOCK_LABEL_47;
            }
            throw new ParserException("Error parsing vorbis codec private");
            abyte1 = new byte[l];
            System.arraycopy(abyte0, k, abyte1, 0, l);
            k += l;
            if (abyte0[k] == 3)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            throw new ParserException("Error parsing vorbis codec private");
            i = k + (i + j);
            if (abyte0[i] == 5)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            throw new ParserException("Error parsing vorbis codec private");
            byte abyte2[] = new byte[abyte0.length - i];
            System.arraycopy(abyte0, i, abyte2, 0, abyte0.length - i);
            abyte0 = new ArrayList(2);
            abyte0.add(abyte1);
            abyte0.add(abyte2);
            return abyte0;
            byte abyte1[];
            int i;
            int j;
            int k;
            int l;
            if (abyte0[0] != 2)
            {
                try
                {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    throw new ParserException("Error parsing vorbis codec private");
                }
            }
            i = 1;
            j = 0;
            for (; abyte0[i] == -1; i++)
            {
                j += 255;
            }

            k = i + 1;
            l = j + abyte0[i];
            i = 0;
            j = k;
            while (abyte0[j] == -1) 
            {
                i += 255;
                j++;
            }
            if (true) goto _L2; else goto _L1
_L1:
        }

        public final void initializeOutput(ExtractorOutput extractoroutput, int i, long l)
        {
            byte byte0 = -1;
            Object obj1 = null;
            Object obj = codecId;
            char c = '\uFFFF';
            switch (((String) (obj)).hashCode())
            {
            case 82338133: 
                if (((String) (obj)).equals("V_VP8"))
                {
                    c = '\0';
                }
                break;

            case 82338134: 
                if (((String) (obj)).equals("V_VP9"))
                {
                    c = '\001';
                }
                break;

            case -2095575984: 
                if (((String) (obj)).equals("V_MPEG4/ISO/SP"))
                {
                    c = '\002';
                }
                break;

            case -538363189: 
                if (((String) (obj)).equals("V_MPEG4/ISO/ASP"))
                {
                    c = '\003';
                }
                break;

            case -2095576542: 
                if (((String) (obj)).equals("V_MPEG4/ISO/AP"))
                {
                    c = '\004';
                }
                break;

            case -538363109: 
                if (((String) (obj)).equals("V_MPEG4/ISO/AVC"))
                {
                    c = '\005';
                }
                break;

            case 855502857: 
                if (((String) (obj)).equals("V_MPEGH/ISO/HEVC"))
                {
                    c = '\006';
                }
                break;

            case -1730367663: 
                if (((String) (obj)).equals("A_VORBIS"))
                {
                    c = '\007';
                }
                break;

            case 1951062397: 
                if (((String) (obj)).equals("A_OPUS"))
                {
                    c = '\b';
                }
                break;

            case 62923557: 
                if (((String) (obj)).equals("A_AAC"))
                {
                    c = '\t';
                }
                break;

            case -1482641357: 
                if (((String) (obj)).equals("A_MPEG/L3"))
                {
                    c = '\n';
                }
                break;

            case 62923603: 
                if (((String) (obj)).equals("A_AC3"))
                {
                    c = '\013';
                }
                break;

            case 62927045: 
                if (((String) (obj)).equals("A_DTS"))
                {
                    c = '\f';
                }
                break;

            case 542569478: 
                if (((String) (obj)).equals("A_DTS/EXPRESS"))
                {
                    c = '\r';
                }
                break;

            case -356037306: 
                if (((String) (obj)).equals("A_DTS/LOSSLESS"))
                {
                    c = '\016';
                }
                break;

            case 1422270023: 
                if (((String) (obj)).equals("S_TEXT/UTF8"))
                {
                    c = '\017';
                }
                break;
            }
            switch (c)
            {
            case 0: // '\0'
                obj = "video/x-vnd.on2.vp8";
                c = byte0;
                break;

            case 1: // '\001'
                obj = "video/x-vnd.on2.vp9";
                c = byte0;
                break;

            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
                obj = "video/mp4v-es";
                if (codecPrivate == null)
                {
                    obj1 = null;
                } else
                {
                    obj1 = Collections.singletonList(codecPrivate);
                }
                c = byte0;
                break;

            case 5: // '\005'
                obj = "video/avc";
                Pair pair = parseAvcCodecPrivate(new ParsableByteArray(codecPrivate));
                obj1 = (List)pair.first;
                nalUnitLengthFieldLength = ((Integer)pair.second).intValue();
                c = byte0;
                break;

            case 6: // '\006'
                obj = "video/hevc";
                Pair pair1 = parseHevcCodecPrivate(new ParsableByteArray(codecPrivate));
                obj1 = (List)pair1.first;
                nalUnitLengthFieldLength = ((Integer)pair1.second).intValue();
                c = byte0;
                break;

            case 7: // '\007'
                obj = "audio/vorbis";
                c = '\u2000';
                obj1 = parseVorbisCodecPrivate(codecPrivate);
                break;

            case 8: // '\b'
                obj = "audio/opus";
                c = '\u1680';
                obj1 = new ArrayList(3);
                ((List) (obj1)).add(codecPrivate);
                ((List) (obj1)).add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(codecDelayNs).array());
                ((List) (obj1)).add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(seekPreRollNs).array());
                break;

            case 9: // '\t'
                obj = "audio/mp4a-latm";
                obj1 = Collections.singletonList(codecPrivate);
                c = byte0;
                break;

            case 10: // '\n'
                obj = "audio/mpeg";
                c = '\u1000';
                break;

            case 11: // '\013'
                obj = "audio/ac3";
                c = byte0;
                break;

            case 12: // '\f'
            case 13: // '\r'
                obj = "audio/vnd.dts";
                c = byte0;
                break;

            case 14: // '\016'
                obj = "audio/vnd.dts.hd";
                c = byte0;
                break;

            case 15: // '\017'
                obj = "application/x-subrip";
                c = byte0;
                break;

            default:
                throw new ParserException("Unrecognized codec identifier.");
            }
            if (MimeTypes.isAudio(((String) (obj))))
            {
                obj = MediaFormat.createAudioFormat(i, ((String) (obj)), -1, c, l, channelCount, sampleRate, ((List) (obj1)), language);
            } else
            if (MimeTypes.isVideo(((String) (obj))))
            {
                obj = MediaFormat.createVideoFormat(i, ((String) (obj)), -1, c, l, width, height, ((List) (obj1)));
            } else
            if ("application/x-subrip".equals(obj))
            {
                obj = MediaFormat.createTextFormat(i, ((String) (obj)), -1, l, language);
            } else
            {
                throw new ParserException("Unexpected MIME type.");
            }
            output = extractoroutput.track(number);
            output.format(((MediaFormat) (obj)));
        }


/*
        static String access$202(Track track, String s)
        {
            track.language = s;
            return s;
        }

*/

        private Track()
        {
            width = -1;
            height = -1;
            channelCount = 1;
            sampleRate = 8000;
            codecDelayNs = 0L;
            seekPreRollNs = 0L;
            language = "eng";
        }

    }


    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_DTS = "A_DTS";
    private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    private static final int ID_AUDIO = 225;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_DURATION = 155;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 0x1f43b675;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 0x1c53bb6b;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 0x23e383;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 0x1a45dfa3;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_INFO = 0x1549a966;
    private static final int ID_LANGUAGE = 0x22b59c;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 0x114d9b74;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 0x18538067;
    private static final int ID_SEGMENT_INFO = 0x1549a966;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_TIMECODE_SCALE = 0x2ad7b1;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 0x1654ae6b;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int MP3_MAX_INPUT_SIZE = 4096;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    private static final byte SUBRIP_PREFIX[] = {
        49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 
        44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 
        48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 
        48, 10
    };
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final byte SUBRIP_TIMECODE_EMPTY[] = {
        32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 
        32, 32
    };
    private static final int SUBRIP_TIMECODE_LENGTH = 12;
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int UNKNOWN = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private long blockDurationUs;
    private int blockFlags;
    private int blockLacingSampleCount;
    private int blockLacingSampleIndex;
    private int blockLacingSampleSizes[];
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private LongArray cueClusterPositions;
    private LongArray cueTimesUs;
    private long cuesContentPosition;
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private ExtractorOutput extractorOutput;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleRead;
    private boolean sampleSeenReferenceBlock;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentDrmInitData;
    private boolean sentSeekMap;
    private final ParsableByteArray subripSample;
    private long timecodeScale;
    private final SparseArray tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;

    public WebmExtractor()
    {
        this(((EbmlReader) (new DefaultEbmlReader())));
    }

    WebmExtractor(EbmlReader ebmlreader)
    {
        segmentContentPosition = -1L;
        segmentContentSize = -1L;
        timecodeScale = -1L;
        durationTimecode = -1L;
        durationUs = -1L;
        cuesContentPosition = -1L;
        seekPositionAfterBuildingCues = -1L;
        clusterTimecodeUs = -1L;
        reader = ebmlreader;
        reader.init(new InnerEbmlReaderOutput());
        varintReader = new VarintReader();
        tracks = new SparseArray();
        scratch = new ParsableByteArray(4);
        vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        seekEntryIdBytes = new ParsableByteArray(4);
        nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        nalLength = new ParsableByteArray(4);
        sampleStrippedBytes = new ParsableByteArray();
        subripSample = new ParsableByteArray();
    }

    private SeekMap buildSeekMap()
    {
        if (segmentContentPosition == -1L || durationUs == -1L || cueTimesUs == null || cueTimesUs.size() == 0 || cueClusterPositions == null || cueClusterPositions.size() != cueTimesUs.size())
        {
            cueTimesUs = null;
            cueClusterPositions = null;
            return SeekMap.UNSEEKABLE;
        }
        int k = cueTimesUs.size();
        int ai[] = new int[k];
        long al[] = new long[k];
        long al1[] = new long[k];
        long al2[] = new long[k];
        for (int i = 0; i < k; i++)
        {
            al2[i] = cueTimesUs.get(i);
            al[i] = segmentContentPosition + cueClusterPositions.get(i);
        }

        for (int j = 0; j < k - 1; j++)
        {
            ai[j] = (int)(al[j + 1] - al[j]);
            al1[j] = al2[j + 1] - al2[j];
        }

        ai[k - 1] = (int)((segmentContentPosition + segmentContentSize) - al[k - 1]);
        al1[k - 1] = durationUs - al2[k - 1];
        cueTimesUs = null;
        cueClusterPositions = null;
        return new ChunkIndex(ai, al, al1, al2);
    }

    private void commitSampleToOutput(Track track, long l)
    {
        if ("S_TEXT/UTF8".equals(track.codecId))
        {
            writeSubripSample(track);
        }
        track.output.sampleMetadata(l, blockFlags, sampleBytesWritten, 0, track.encryptionKeyId);
        sampleRead = true;
        resetSample();
    }

    private static int[] ensureArrayCapacity(int ai[], int i)
    {
        if (ai == null)
        {
            return new int[i];
        }
        if (ai.length >= i)
        {
            return ai;
        } else
        {
            return new int[Math.max(ai.length << 1, i)];
        }
    }

    private static boolean isCodecSupported(String s)
    {
        return "V_VP8".equals(s) || "V_VP9".equals(s) || "V_MPEG4/ISO/SP".equals(s) || "V_MPEG4/ISO/ASP".equals(s) || "V_MPEG4/ISO/AP".equals(s) || "V_MPEG4/ISO/AVC".equals(s) || "V_MPEGH/ISO/HEVC".equals(s) || "A_OPUS".equals(s) || "A_VORBIS".equals(s) || "A_AAC".equals(s) || "A_MPEG/L3".equals(s) || "A_AC3".equals(s) || "A_DTS".equals(s) || "A_DTS/EXPRESS".equals(s) || "A_DTS/LOSSLESS".equals(s) || "S_TEXT/UTF8".equals(s);
    }

    private boolean maybeSeekForCues(PositionHolder positionholder, long l)
    {
        if (seekForCues)
        {
            seekPositionAfterBuildingCues = l;
            positionholder.position = cuesContentPosition;
            seekForCues = false;
            return true;
        }
        if (sentSeekMap && seekPositionAfterBuildingCues != -1L)
        {
            positionholder.position = seekPositionAfterBuildingCues;
            seekPositionAfterBuildingCues = -1L;
            return true;
        } else
        {
            return false;
        }
    }

    private void readScratch(ExtractorInput extractorinput, int i)
    {
        if (scratch.limit() >= i)
        {
            return;
        }
        if (scratch.capacity() < i)
        {
            scratch.reset(Arrays.copyOf(scratch.data, Math.max(scratch.data.length << 1, i)), scratch.limit());
        }
        extractorinput.readFully(scratch.data, scratch.limit(), i - scratch.limit());
        scratch.setLimit(i);
    }

    private int readToOutput(ExtractorInput extractorinput, TrackOutput trackoutput, int i)
    {
        int j = sampleStrippedBytes.bytesLeft();
        if (j > 0)
        {
            i = Math.min(i, j);
            trackoutput.sampleData(sampleStrippedBytes, i);
        } else
        {
            i = trackoutput.sampleData(extractorinput, i, false);
        }
        sampleBytesRead = sampleBytesRead + i;
        sampleBytesWritten = sampleBytesWritten + i;
        return i;
    }

    private void readToTarget(ExtractorInput extractorinput, byte abyte0[], int i, int j)
    {
        int k = Math.min(j, sampleStrippedBytes.bytesLeft());
        extractorinput.readFully(abyte0, i + k, j - k);
        if (k > 0)
        {
            sampleStrippedBytes.readBytes(abyte0, i, k);
        }
        sampleBytesRead = sampleBytesRead + j;
    }

    private void resetSample()
    {
        sampleBytesRead = 0;
        sampleBytesWritten = 0;
        sampleCurrentNalBytesRemaining = 0;
        sampleEncodingHandled = false;
        sampleStrippedBytes.reset();
    }

    private long scaleTimecodeToUs(long l)
    {
        if (timecodeScale == -1L)
        {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        } else
        {
            return Util.scaleLargeTimestamp(l, timecodeScale, 1000L);
        }
    }

    private static void setSubripSampleEndTimecode(byte abyte0[], long l)
    {
        byte abyte1[];
        if (l == -1L)
        {
            abyte1 = SUBRIP_TIMECODE_EMPTY;
        } else
        {
            int i = (int)(l / 0xd693a400L);
            l -= (long)i * 0xd693a400L;
            int j = (int)(l / 0x3938700L);
            l -= 0x3938700 * j;
            int k = (int)(l / 0xf4240L);
            int i1 = (int)((l - (long)(0xf4240 * k)) / 1000L);
            abyte1 = String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i1)
            }).getBytes();
        }
        System.arraycopy(abyte1, 0, abyte0, 19, 12);
    }

    private void writeSampleData(ExtractorInput extractorinput, Track track, int i)
    {
        if ("S_TEXT/UTF8".equals(track.codecId))
        {
            int j = SUBRIP_PREFIX.length + i;
            if (subripSample.capacity() < j)
            {
                subripSample.data = Arrays.copyOf(SUBRIP_PREFIX, j + i);
            }
            extractorinput.readFully(subripSample.data, SUBRIP_PREFIX.length, i);
            subripSample.setPosition(0);
            subripSample.setLimit(j);
            return;
        }
        TrackOutput trackoutput = track.output;
        if (!sampleEncodingHandled)
        {
            if (track.hasContentEncryption)
            {
                blockFlags = blockFlags & -3;
                extractorinput.readFully(scratch.data, 0, 1);
                sampleBytesRead = sampleBytesRead + 1;
                if ((scratch.data[0] & 0x80) == 128)
                {
                    throw new ParserException("Extension bit is set in signal byte");
                }
                if ((scratch.data[0] & 1) == 1)
                {
                    scratch.data[0] = 8;
                    scratch.setPosition(0);
                    trackoutput.sampleData(scratch, 1);
                    sampleBytesWritten = sampleBytesWritten + 1;
                    blockFlags = blockFlags | 2;
                }
            } else
            if (track.sampleStrippedBytes != null)
            {
                sampleStrippedBytes.reset(track.sampleStrippedBytes, track.sampleStrippedBytes.length);
            }
            sampleEncodingHandled = true;
        }
        i += sampleStrippedBytes.limit();
        if ("V_MPEG4/ISO/AVC".equals(track.codecId) || "V_MPEGH/ISO/HEVC".equals(track.codecId))
        {
            byte abyte0[] = nalLength.data;
            abyte0[0] = 0;
            abyte0[1] = 0;
            abyte0[2] = 0;
            int k = track.nalUnitLengthFieldLength;
            int l = track.nalUnitLengthFieldLength;
            while (sampleBytesRead < i) 
            {
                if (sampleCurrentNalBytesRemaining == 0)
                {
                    readToTarget(extractorinput, abyte0, 4 - l, k);
                    nalLength.setPosition(0);
                    sampleCurrentNalBytesRemaining = nalLength.readUnsignedIntToInt();
                    nalStartCode.setPosition(0);
                    trackoutput.sampleData(nalStartCode, 4);
                    sampleBytesWritten = sampleBytesWritten + 4;
                } else
                {
                    sampleCurrentNalBytesRemaining = sampleCurrentNalBytesRemaining - readToOutput(extractorinput, trackoutput, sampleCurrentNalBytesRemaining);
                }
            }
        } else
        {
            while (sampleBytesRead < i) 
            {
                readToOutput(extractorinput, trackoutput, i - sampleBytesRead);
            }
        }
        if ("A_VORBIS".equals(track.codecId))
        {
            vorbisNumPageSamples.setPosition(0);
            trackoutput.sampleData(vorbisNumPageSamples, 4);
            sampleBytesWritten = sampleBytesWritten + 4;
        }
    }

    private void writeSubripSample(Track track)
    {
        setSubripSampleEndTimecode(subripSample.data, blockDurationUs);
        track.output.sampleData(subripSample, subripSample.limit());
        sampleBytesWritten = sampleBytesWritten + subripSample.limit();
    }

    final void binaryElement(int i, int j, ExtractorInput extractorinput)
    {
        switch (i)
        {
        case 21419: 
            Arrays.fill(seekEntryIdBytes.data, (byte)0);
            extractorinput.readFully(seekEntryIdBytes.data, 4 - j, j);
            seekEntryIdBytes.setPosition(0);
            seekEntryId = (int)seekEntryIdBytes.readUnsignedInt();
            return;

        case 25506: 
            currentTrack.codecPrivate = new byte[j];
            extractorinput.readFully(currentTrack.codecPrivate, 0, j);
            return;

        case 16981: 
            currentTrack.sampleStrippedBytes = new byte[j];
            extractorinput.readFully(currentTrack.sampleStrippedBytes, 0, j);
            return;

        case 18402: 
            currentTrack.encryptionKeyId = new byte[j];
            extractorinput.readFully(currentTrack.encryptionKeyId, 0, j);
            return;

        case 161: 
        case 163: 
            if (blockState == 0)
            {
                blockTrackNumber = (int)varintReader.readUnsignedVarint(extractorinput, false, true);
                blockTrackNumberLength = varintReader.getLastLength();
                blockDurationUs = -1L;
                blockState = 1;
                scratch.reset();
            }
            Track track = (Track)tracks.get(blockTrackNumber);
            if (track == null)
            {
                extractorinput.skipFully(j - blockTrackNumberLength);
                blockState = 0;
                return;
            }
            if (blockState == 1)
            {
                readScratch(extractorinput, 3);
                int k = (scratch.data[2] & 6) >> 1;
                if (k == 0)
                {
                    blockLacingSampleCount = 1;
                    blockLacingSampleSizes = ensureArrayCapacity(blockLacingSampleSizes, 1);
                    blockLacingSampleSizes[0] = j - blockTrackNumberLength - 3;
                } else
                {
                    if (i != 163)
                    {
                        throw new ParserException("Lacing only supported in SimpleBlocks.");
                    }
                    readScratch(extractorinput, 4);
                    blockLacingSampleCount = (scratch.data[3] & 0xff) + 1;
                    blockLacingSampleSizes = ensureArrayCapacity(blockLacingSampleSizes, blockLacingSampleCount);
                    if (k == 2)
                    {
                        j = (j - blockTrackNumberLength - 4) / blockLacingSampleCount;
                        Arrays.fill(blockLacingSampleSizes, 0, blockLacingSampleCount, j);
                    } else
                    if (k == 1)
                    {
                        int j1 = 0;
                        k = 4;
                        for (int l = 0; l < blockLacingSampleCount - 1; l++)
                        {
                            blockLacingSampleSizes[l] = 0;
                            int l1 = k;
                            int j2;
                            do
                            {
                                k = l1 + 1;
                                readScratch(extractorinput, k);
                                j2 = scratch.data[k - 1] & 0xff;
                                int ai[] = blockLacingSampleSizes;
                                ai[l] = ai[l] + j2;
                                l1 = k;
                            } while (j2 == 255);
                            j1 += blockLacingSampleSizes[l];
                        }

                        blockLacingSampleSizes[blockLacingSampleCount - 1] = j - blockTrackNumberLength - k - j1;
                    } else
                    if (k == 3)
                    {
                        int k1 = 0;
                        k = 4;
                        for (int i1 = 0; i1 < blockLacingSampleCount - 1; i1++)
                        {
                            blockLacingSampleSizes[i1] = 0;
                            int k2 = k + 1;
                            readScratch(extractorinput, k2);
                            if (scratch.data[k2 - 1] == 0)
                            {
                                throw new ParserException("No valid varint length mask found");
                            }
                            long l4 = 0L;
                            int i2 = 0;
                            long l3;
                            do
                            {
                                k = k2;
                                l3 = l4;
                                if (i2 >= 8)
                                {
                                    break;
                                }
                                int l2 = 1 << 7 - i2;
                                if ((scratch.data[k2 - 1] & l2) != 0)
                                {
                                    int j3 = k2 - 1;
                                    k2 += i2;
                                    readScratch(extractorinput, k2);
                                    byte abyte0[] = scratch.data;
                                    k = j3 + 1;
                                    long l5 = abyte0[j3] & 0xff & ~l2;
                                    int i3;
                                    for (; k < k2; k = i3)
                                    {
                                        byte abyte1[] = scratch.data;
                                        i3 = k + 1;
                                        l5 = l5 << 8 | (long)(abyte1[k] & 0xff);
                                    }

                                    k = k2;
                                    l3 = l5;
                                    if (i1 > 0)
                                    {
                                        l3 = l5 - ((1L << i2 * 7 + 6) - 1L);
                                        k = k2;
                                    }
                                    break;
                                }
                                i2++;
                            } while (true);
                            if (l3 < 0xffffffff80000000L || l3 > 0x7fffffffL)
                            {
                                throw new ParserException("EBML lacing sample size out of range.");
                            }
                            i2 = (int)l3;
                            int ai1[] = blockLacingSampleSizes;
                            if (i1 != 0)
                            {
                                i2 = blockLacingSampleSizes[i1 - 1] + i2;
                            }
                            ai1[i1] = i2;
                            k1 += blockLacingSampleSizes[i1];
                        }

                        blockLacingSampleSizes[blockLacingSampleCount - 1] = j - blockTrackNumberLength - k - k1;
                    } else
                    {
                        throw new IllegalStateException((new StringBuilder("Unexpected lacing value: ")).append(k).toString());
                    }
                }
                j = scratch.data[0];
                k = scratch.data[1];
                blockTimeUs = clusterTimecodeUs + scaleTimecodeToUs(j << 8 | k & 0xff);
                if ((scratch.data[2] & 8) == 8)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                boolean flag;
                if (track.type == 2 || i == 163 && (scratch.data[2] & 0x80) == 128)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (j != 0)
                {
                    j = 0x8000000;
                } else
                {
                    j = 0;
                }
                blockFlags = flag | j;
                blockState = 2;
                blockLacingSampleIndex = 0;
            }
            if (i == 163)
            {
                for (; blockLacingSampleIndex < blockLacingSampleCount; blockLacingSampleIndex = blockLacingSampleIndex + 1)
                {
                    writeSampleData(extractorinput, track, blockLacingSampleSizes[blockLacingSampleIndex]);
                    commitSampleToOutput(track, blockTimeUs + (long)((blockLacingSampleIndex * track.defaultSampleDurationNs) / 1000));
                }

                blockState = 0;
                return;
            } else
            {
                writeSampleData(extractorinput, track, blockLacingSampleSizes[0]);
                return;
            }
        }
        throw new ParserException((new StringBuilder("Unexpected id: ")).append(i).toString());
    }

    final void endMasterElement(int i)
    {
        switch (i)
        {
        default:
            return;

        case 357149030: 
            if (timecodeScale == -1L)
            {
                timecodeScale = 0xf4240L;
            }
            if (durationTimecode != -1L)
            {
                durationUs = scaleTimecodeToUs(durationTimecode);
            }
            return;

        case 19899: 
            if (seekEntryId == -1 || seekEntryPosition == -1L)
            {
                throw new ParserException("Mandatory element SeekID or SeekPosition not found");
            }
            if (seekEntryId == 0x1c53bb6b)
            {
                cuesContentPosition = seekEntryPosition;
            }
            return;

        case 475249515: 
            if (!sentSeekMap)
            {
                extractorOutput.seekMap(buildSeekMap());
                sentSeekMap = true;
            }
            return;

        case 160: 
            if (blockState != 2)
            {
                return;
            }
            if (!sampleSeenReferenceBlock)
            {
                blockFlags = blockFlags | 1;
            }
            commitSampleToOutput((Track)tracks.get(blockTrackNumber), blockTimeUs);
            blockState = 0;
            return;

        case 25152: 
            if (currentTrack.hasContentEncryption)
            {
                if (currentTrack.encryptionKeyId == null)
                {
                    throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                }
                if (!sentDrmInitData)
                {
                    extractorOutput.drmInitData(new com.google.android.exoplayer.drm.DrmInitData.Universal("video/webm", currentTrack.encryptionKeyId));
                    sentDrmInitData = true;
                }
            }
            return;

        case 28032: 
            if (currentTrack.hasContentEncryption && currentTrack.sampleStrippedBytes != null)
            {
                throw new ParserException("Combining encryption and compression is not supported");
            } else
            {
                return;
            }

        case 174: 
            if (tracks.get(currentTrack.number) == null && isCodecSupported(currentTrack.codecId))
            {
                currentTrack.initializeOutput(extractorOutput, currentTrack.number, durationUs);
                tracks.put(currentTrack.number, currentTrack);
            }
            currentTrack = null;
            return;

        case 374648427: 
            break;
        }
        if (tracks.size() == 0)
        {
            throw new ParserException("No valid tracks were found");
        } else
        {
            extractorOutput.endTracks();
            return;
        }
    }

    final void floatElement(int i, double d)
    {
        switch (i)
        {
        default:
            return;

        case 17545: 
            durationTimecode = (long)d;
            return;

        case 181: 
            currentTrack.sampleRate = (int)d;
            return;
        }
    }

    final int getElementType(int i)
    {
        switch (i)
        {
        case 160: 
        case 174: 
        case 183: 
        case 187: 
        case 224: 
        case 225: 
        case 18407: 
        case 19899: 
        case 20532: 
        case 20533: 
        case 25152: 
        case 28032: 
        case 290298740: 
        case 357149030: 
        case 374648427: 
        case 408125543: 
        case 440786851: 
        case 475249515: 
        case 524531317: 
            return 1;

        case 131: 
        case 155: 
        case 159: 
        case 176: 
        case 179: 
        case 186: 
        case 215: 
        case 231: 
        case 241: 
        case 251: 
        case 16980: 
        case 17029: 
        case 17143: 
        case 18401: 
        case 18408: 
        case 20529: 
        case 20530: 
        case 21420: 
        case 22186: 
        case 22203: 
        case 2352003: 
        case 2807729: 
            return 2;

        case 134: 
        case 17026: 
        case 2274716: 
            return 3;

        case 161: 
        case 163: 
        case 16981: 
        case 18402: 
        case 21419: 
        case 25506: 
            return 4;

        case 181: 
        case 17545: 
            return 5;
        }
        return 0;
    }

    public final void init(ExtractorOutput extractoroutput)
    {
        extractorOutput = extractoroutput;
    }

    final void integerElement(int i, long l)
    {
        switch (i)
        {
        default:
            return;

        case 17143: 
            if (l != 1L)
            {
                throw new ParserException((new StringBuilder("EBMLReadVersion ")).append(l).append(" not supported").toString());
            } else
            {
                return;
            }

        case 17029: 
            if (l < 1L || l > 2L)
            {
                throw new ParserException((new StringBuilder("DocTypeReadVersion ")).append(l).append(" not supported").toString());
            } else
            {
                return;
            }

        case 21420: 
            seekEntryPosition = segmentContentPosition + l;
            return;

        case 2807729: 
            timecodeScale = l;
            return;

        case 176: 
            currentTrack.width = (int)l;
            return;

        case 186: 
            currentTrack.height = (int)l;
            return;

        case 215: 
            currentTrack.number = (int)l;
            return;

        case 131: 
            currentTrack.type = (int)l;
            return;

        case 2352003: 
            currentTrack.defaultSampleDurationNs = (int)l;
            return;

        case 22186: 
            currentTrack.codecDelayNs = l;
            return;

        case 22203: 
            currentTrack.seekPreRollNs = l;
            return;

        case 159: 
            currentTrack.channelCount = (int)l;
            return;

        case 251: 
            sampleSeenReferenceBlock = true;
            return;

        case 20529: 
            if (l != 0L)
            {
                throw new ParserException((new StringBuilder("ContentEncodingOrder ")).append(l).append(" not supported").toString());
            } else
            {
                return;
            }

        case 20530: 
            if (l != 1L)
            {
                throw new ParserException((new StringBuilder("ContentEncodingScope ")).append(l).append(" not supported").toString());
            } else
            {
                return;
            }

        case 16980: 
            if (l != 3L)
            {
                throw new ParserException((new StringBuilder("ContentCompAlgo ")).append(l).append(" not supported").toString());
            } else
            {
                return;
            }

        case 18401: 
            if (l != 5L)
            {
                throw new ParserException((new StringBuilder("ContentEncAlgo ")).append(l).append(" not supported").toString());
            } else
            {
                return;
            }

        case 18408: 
            if (l != 1L)
            {
                throw new ParserException((new StringBuilder("AESSettingsCipherMode ")).append(l).append(" not supported").toString());
            } else
            {
                return;
            }

        case 179: 
            cueTimesUs.add(scaleTimecodeToUs(l));
            return;

        case 241: 
            if (!seenClusterPositionForCurrentCuePoint)
            {
                cueClusterPositions.add(l);
                seenClusterPositionForCurrentCuePoint = true;
            }
            return;

        case 231: 
            clusterTimecodeUs = scaleTimecodeToUs(l);
            return;

        case 155: 
            blockDurationUs = scaleTimecodeToUs(l);
            return;
        }
    }

    public final int read(ExtractorInput extractorinput, PositionHolder positionholder)
    {
        sampleRead = false;
        boolean flag;
        for (flag = true; flag && !sampleRead;)
        {
            boolean flag2 = reader.read(extractorinput);
            boolean flag1 = flag2;
            flag = flag1;
            if (flag2)
            {
                flag = flag1;
                if (maybeSeekForCues(positionholder, extractorinput.getPosition()))
                {
                    return 1;
                }
            }
        }

        return !flag ? -1 : 0;
    }

    public final void seek()
    {
        clusterTimecodeUs = -1L;
        blockState = 0;
        reader.reset();
        varintReader.reset();
        resetSample();
    }

    public final boolean sniff(ExtractorInput extractorinput)
    {
        return (new Sniffer()).sniff(extractorinput);
    }

    final void startMasterElement(int i, long l, long l1)
    {
        switch (i)
        {
        default:
            return;

        case 408125543: 
            if (segmentContentPosition != -1L && segmentContentPosition != l)
            {
                throw new ParserException("Multiple Segment elements not supported");
            } else
            {
                segmentContentPosition = l;
                segmentContentSize = l1;
                return;
            }

        case 19899: 
            seekEntryId = -1;
            seekEntryPosition = -1L;
            return;

        case 475249515: 
            cueTimesUs = new LongArray();
            cueClusterPositions = new LongArray();
            return;

        case 187: 
            seenClusterPositionForCurrentCuePoint = false;
            return;

        case 524531317: 
            if (!sentSeekMap)
            {
                if (cuesContentPosition != -1L)
                {
                    seekForCues = true;
                    return;
                }
                extractorOutput.seekMap(SeekMap.UNSEEKABLE);
                sentSeekMap = true;
            }
            return;

        case 160: 
            sampleSeenReferenceBlock = false;
            return;

        case 25152: 
            return;

        case 20533: 
            currentTrack.hasContentEncryption = true;
            return;

        case 174: 
            currentTrack = new Track();
            return;
        }
    }

    final void stringElement(int i, String s)
    {
        switch (i)
        {
        default:
            return;

        case 17026: 
            if (!"webm".equals(s) && !"matroska".equals(s))
            {
                throw new ParserException((new StringBuilder("DocType ")).append(s).append(" not supported").toString());
            } else
            {
                return;
            }

        case 134: 
            currentTrack.codecId = s;
            return;

        case 2274716: 
            currentTrack.language = s;
            return;
        }
    }

}
