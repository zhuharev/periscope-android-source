// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.webm;

import android.util.Pair;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.MimeTypes;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.extractor.webm:
//            WebmExtractor

static final class <init>
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
    static String access$202( , String s)
    {
        .language = s;
        return s;
    }

*/

    private language()
    {
        width = -1;
        height = -1;
        channelCount = 1;
        sampleRate = 8000;
        codecDelayNs = 0L;
        seekPreRollNs = 0L;
        language = "eng";
    }

    language(language language1)
    {
        this();
    }
}
