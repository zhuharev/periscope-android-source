// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;

import com.google.android.exoplayer.util.Assertions;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifestParser, SmoothStreamingManifest

static class streamElements extends streamElements
{

    private static final String KEY_DURATION = "Duration";
    private static final String KEY_DVR_WINDOW_LENGTH = "DVRWindowLength";
    private static final String KEY_IS_LIVE = "IsLive";
    private static final String KEY_LOOKAHEAD_COUNT = "LookaheadCount";
    private static final String KEY_MAJOR_VERSION = "MajorVersion";
    private static final String KEY_MINOR_VERSION = "MinorVersion";
    private static final String KEY_TIME_SCALE = "TimeScale";
    public static final String TAG = "SmoothStreamingMedia";
    private long duration;
    private long dvrWindowLength;
    private boolean isLive;
    private int lookAheadCount;
    private int majorVersion;
    private int minorVersion;
    private timescale protectionElement;
    private List streamElements;
    private long timescale;

    public void addChild(Object obj)
    {
        if (obj instanceof streamElements)
        {
            streamElements.add((streamElements)obj);
            return;
        }
        if (obj instanceof streamElements)
        {
            boolean flag;
            if (protectionElement == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            protectionElement = (protectionElement)obj;
        }
    }

    public Object build()
    {
        protectionElement aprotectionelement[] = new protectionElement[streamElements.size()];
        streamElements.toArray(aprotectionelement);
        return new SmoothStreamingManifest(majorVersion, minorVersion, timescale, duration, dvrWindowLength, lookAheadCount, isLive, protectionElement, aprotectionelement);
    }

    public void parseStartTag(XmlPullParser xmlpullparser)
    {
        majorVersion = parseRequiredInt(xmlpullparser, "MajorVersion");
        minorVersion = parseRequiredInt(xmlpullparser, "MinorVersion");
        timescale = parseLong(xmlpullparser, "TimeScale", 0x989680L);
        duration = parseRequiredLong(xmlpullparser, "Duration");
        dvrWindowLength = parseLong(xmlpullparser, "DVRWindowLength", 0L);
        lookAheadCount = parseInt(xmlpullparser, "LookaheadCount", -1);
        isLive = parseBoolean(xmlpullparser, "IsLive", false);
        putNormalizedAttribute("TimeScale", Long.valueOf(timescale));
    }

    public ( , String s)
    {
        super(, s, "SmoothStreamingMedia");
        lookAheadCount = -1;
        protectionElement = null;
        streamElements = new LinkedList();
    }
}
