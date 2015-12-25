// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;

import com.google.android.exoplayer.ParserException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifestParser

static class baseUri extends baseUri
{

    private static final String KEY_DISPLAY_HEIGHT = "DisplayHeight";
    private static final String KEY_DISPLAY_WIDTH = "DisplayWidth";
    private static final String KEY_FRAGMENT_DURATION = "d";
    private static final String KEY_FRAGMENT_REPEAT_COUNT = "r";
    private static final String KEY_FRAGMENT_START_TIME = "t";
    private static final String KEY_LANGUAGE = "Language";
    private static final String KEY_MAX_HEIGHT = "MaxHeight";
    private static final String KEY_MAX_WIDTH = "MaxWidth";
    private static final String KEY_NAME = "Name";
    private static final String KEY_QUALITY_LEVELS = "QualityLevels";
    private static final String KEY_SUB_TYPE = "Subtype";
    private static final String KEY_TIME_SCALE = "TimeScale";
    private static final String KEY_TYPE = "Type";
    private static final String KEY_TYPE_AUDIO = "audio";
    private static final String KEY_TYPE_TEXT = "text";
    private static final String KEY_TYPE_VIDEO = "video";
    private static final String KEY_URL = "Url";
    public static final String TAG = "StreamIndex";
    private static final String TAG_STREAM_FRAGMENT = "c";
    private final String baseUri;
    private int displayHeight;
    private int displayWidth;
    private String language;
    private long lastChunkDuration;
    private int maxHeight;
    private int maxWidth;
    private String name;
    private int qualityLevels;
    private ArrayList startTimes;
    private String subType;
    private long timescale;
    private final List tracks = new LinkedList();
    private int type;
    private String url;

    private void parseStreamElementStartTag(XmlPullParser xmlpullparser)
    {
        type = parseType(xmlpullparser);
        putNormalizedAttribute("Type", Integer.valueOf(type));
        if (type == 2)
        {
            subType = parseRequiredString(xmlpullparser, "Subtype");
        } else
        {
            subType = xmlpullparser.getAttributeValue(null, "Subtype");
        }
        name = xmlpullparser.getAttributeValue(null, "Name");
        qualityLevels = parseInt(xmlpullparser, "QualityLevels", -1);
        url = parseRequiredString(xmlpullparser, "Url");
        maxWidth = parseInt(xmlpullparser, "MaxWidth", -1);
        maxHeight = parseInt(xmlpullparser, "MaxHeight", -1);
        displayWidth = parseInt(xmlpullparser, "DisplayWidth", -1);
        displayHeight = parseInt(xmlpullparser, "DisplayHeight", -1);
        language = xmlpullparser.getAttributeValue(null, "Language");
        timescale = parseInt(xmlpullparser, "TimeScale", -1);
        if (timescale == -1L)
        {
            timescale = ((Long)getNormalizedAttribute("TimeScale")).longValue();
        }
        startTimes = new ArrayList();
    }

    private void parseStreamFragmentStartTag(XmlPullParser xmlpullparser)
    {
        int i = startTimes.size();
        long l1 = parseLong(xmlpullparser, "t", -1L);
        long l = l1;
        if (l1 == -1L)
        {
            if (i == 0)
            {
                l = 0L;
            } else
            if (lastChunkDuration != -1L)
            {
                l = ((Long)startTimes.get(i - 1)).longValue() + lastChunkDuration;
            } else
            {
                throw new ParserException("Unable to infer start time");
            }
        }
        startTimes.add(Long.valueOf(l));
        lastChunkDuration = parseLong(xmlpullparser, "d", -1L);
        l1 = parseLong(xmlpullparser, "r", 1L);
        if (l1 > 1L && lastChunkDuration == -1L)
        {
            throw new ParserException("Repeated chunk with unspecified duration");
        }
        for (int j = 1; (long)j < l1; j++)
        {
            startTimes.add(Long.valueOf(lastChunkDuration * (long)j + l));
        }

    }

    private int parseType(XmlPullParser xmlpullparser)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, "Type");
        if (xmlpullparser != null)
        {
            if ("audio".equalsIgnoreCase(xmlpullparser))
            {
                return 0;
            }
            if ("video".equalsIgnoreCase(xmlpullparser))
            {
                return 1;
            }
            if ("text".equalsIgnoreCase(xmlpullparser))
            {
                return 2;
            } else
            {
                throw new ParserException((new StringBuilder("Invalid key value[")).append(xmlpullparser).append("]").toString());
            }
        } else
        {
            throw new n("Type");
        }
    }

    public void addChild(Object obj)
    {
        if (obj instanceof n)
        {
            tracks.add((tracks)obj);
        }
    }

    public Object build()
    {
        tracks atracks[] = new tracks[tracks.size()];
        tracks.toArray(atracks);
        return new tracks(baseUri, url, type, subType, timescale, name, qualityLevels, maxWidth, maxHeight, displayWidth, displayHeight, language, atracks, startTimes, lastChunkDuration);
    }

    public boolean handleChildInline(String s)
    {
        return "c".equals(s);
    }

    public void parseStartTag(XmlPullParser xmlpullparser)
    {
        if ("c".equals(xmlpullparser.getName()))
        {
            parseStreamFragmentStartTag(xmlpullparser);
            return;
        } else
        {
            parseStreamElementStartTag(xmlpullparser);
            return;
        }
    }

    public n(n n, String s)
    {
        super(n, s, "StreamIndex");
        baseUri = s;
    }
}
