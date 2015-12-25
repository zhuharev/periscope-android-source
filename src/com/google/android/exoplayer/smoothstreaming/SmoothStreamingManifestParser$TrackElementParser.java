// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;

import com.google.android.exoplayer.util.CodecSpecificDataUtil;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifestParser

static class > extends >
{

    private static final String KEY_BITRATE = "Bitrate";
    private static final String KEY_CHANNELS = "Channels";
    private static final String KEY_CODEC_PRIVATE_DATA = "CodecPrivateData";
    private static final String KEY_FOUR_CC = "FourCC";
    private static final String KEY_INDEX = "Index";
    private static final String KEY_MAX_HEIGHT = "MaxHeight";
    private static final String KEY_MAX_WIDTH = "MaxWidth";
    private static final String KEY_SAMPLING_RATE = "SamplingRate";
    private static final String KEY_TYPE = "Type";
    public static final String TAG = "QualityLevel";
    private int bitrate;
    private int channels;
    private final List csd = new LinkedList();
    private int index;
    private int maxHeight;
    private int maxWidth;
    private String mimeType;
    private int samplingRate;

    private static String fourCCToMimeType(String s)
    {
        if (s.equalsIgnoreCase("H264") || s.equalsIgnoreCase("X264") || s.equalsIgnoreCase("AVC1") || s.equalsIgnoreCase("DAVC"))
        {
            return "video/avc";
        }
        if (s.equalsIgnoreCase("AAC") || s.equalsIgnoreCase("AACL") || s.equalsIgnoreCase("AACH") || s.equalsIgnoreCase("AACP"))
        {
            return "audio/mp4a-latm";
        }
        if (s.equalsIgnoreCase("TTML"))
        {
            return "application/ttml+xml";
        } else
        {
            return null;
        }
    }

    private static byte[] hexStringToByteArray(String s)
    {
        byte abyte0[] = new byte[s.length() / 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            int j = i << 1;
            abyte0[i] = (byte)((Character.digit(s.charAt(j), 16) << 4) + Character.digit(s.charAt(j + 1), 16));
        }

        return abyte0;
    }

    public Object build()
    {
        byte abyte0[][] = null;
        if (!csd.isEmpty())
        {
            abyte0 = new byte[csd.size()][];
            csd.toArray(abyte0);
        }
        return new csd(index, bitrate, mimeType, abyte0, maxWidth, maxHeight, samplingRate, channels);
    }

    public void parseStartTag(XmlPullParser xmlpullparser)
    {
        int i = ((Integer)getNormalizedAttribute("Type")).intValue();
        index = parseInt(xmlpullparser, "Index", -1);
        bitrate = parseRequiredInt(xmlpullparser, "Bitrate");
        String s;
        if (i == 1)
        {
            maxHeight = parseRequiredInt(xmlpullparser, "MaxHeight");
            maxWidth = parseRequiredInt(xmlpullparser, "MaxWidth");
            s = fourCCToMimeType(parseRequiredString(xmlpullparser, "FourCC"));
        } else
        {
            maxHeight = -1;
            maxWidth = -1;
            s = xmlpullparser.getAttributeValue(null, "FourCC");
            if (s != null)
            {
                s = fourCCToMimeType(s);
            } else
            if (i == 0)
            {
                s = "audio/mp4a-latm";
            } else
            {
                s = null;
            }
        }
        mimeType = s;
        if (i == 0)
        {
            samplingRate = parseRequiredInt(xmlpullparser, "SamplingRate");
            channels = parseRequiredInt(xmlpullparser, "Channels");
        } else
        {
            samplingRate = -1;
            channels = -1;
        }
        xmlpullparser = xmlpullparser.getAttributeValue(null, "CodecPrivateData");
        if (xmlpullparser != null && xmlpullparser.length() > 0)
        {
            xmlpullparser = hexStringToByteArray(xmlpullparser);
            byte abyte0[][] = CodecSpecificDataUtil.splitNalUnits(xmlpullparser);
            if (abyte0 == null)
            {
                csd.add(xmlpullparser);
                return;
            }
            for (int j = 0; j < abyte0.length; j++)
            {
                csd.add(abyte0[j]);
            }

        }
    }

    public ( , String s)
    {
        super(, s, "QualityLevel");
    }
}
