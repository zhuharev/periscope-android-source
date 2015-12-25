// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.MimeTypes;
import com.google.android.exoplayer.util.ParserUtil;
import com.google.android.exoplayer.util.UriUtil;
import com.google.android.exoplayer.util.Util;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            AdaptationSet, ContentProtection, MediaPresentationDescription, Period, 
//            RangedUri, Representation, UtcTimingElement, UrlTemplate, 
//            SegmentBase

public class MediaPresentationDescriptionParser extends DefaultHandler
    implements com.google.android.exoplayer.upstream.UriLoadable.Parser
{
    public static final class ContentProtectionsBuilder
        implements Comparator
    {

        private ArrayList adaptationSetProtections;
        private ArrayList currentRepresentationProtections;
        private ArrayList representationProtections;
        private boolean representationProtectionsSet;

        private void maybeAddContentProtection(List list, ContentProtection contentprotection)
        {
            if (!list.contains(contentprotection))
            {
                for (int i = 0; i < list.size(); i++)
                {
                    boolean flag;
                    if (!((ContentProtection)list.get(i)).schemeUriId.equals(contentprotection.schemeUriId))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    Assertions.checkState(flag);
                }

                list.add(contentprotection);
            }
        }

        public final void addAdaptationSetProtection(ContentProtection contentprotection)
        {
            if (adaptationSetProtections == null)
            {
                adaptationSetProtections = new ArrayList();
            }
            maybeAddContentProtection(adaptationSetProtections, contentprotection);
        }

        public final void addRepresentationProtection(ContentProtection contentprotection)
        {
            if (currentRepresentationProtections == null)
            {
                currentRepresentationProtections = new ArrayList();
            }
            maybeAddContentProtection(currentRepresentationProtections, contentprotection);
        }

        public final ArrayList build()
        {
            if (adaptationSetProtections == null)
            {
                return representationProtections;
            }
            if (representationProtections == null)
            {
                return adaptationSetProtections;
            }
            for (int i = 0; i < representationProtections.size(); i++)
            {
                maybeAddContentProtection(adaptationSetProtections, (ContentProtection)representationProtections.get(i));
            }

            return adaptationSetProtections;
        }

        public final int compare(ContentProtection contentprotection, ContentProtection contentprotection1)
        {
            return contentprotection.schemeUriId.compareTo(contentprotection1.schemeUriId);
        }

        public final volatile int compare(Object obj, Object obj1)
        {
            return compare((ContentProtection)obj, (ContentProtection)obj1);
        }

        public final void endRepresentation()
        {
            if (!representationProtectionsSet)
            {
                if (currentRepresentationProtections != null)
                {
                    Collections.sort(currentRepresentationProtections, this);
                }
                representationProtections = currentRepresentationProtections;
                representationProtectionsSet = true;
            } else
            if (currentRepresentationProtections == null)
            {
                boolean flag;
                if (representationProtections == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Assertions.checkState(flag);
            } else
            {
                Collections.sort(currentRepresentationProtections, this);
                Assertions.checkState(currentRepresentationProtections.equals(representationProtections));
            }
            currentRepresentationProtections = null;
        }

        protected ContentProtectionsBuilder()
        {
        }
    }


    private static final Pattern FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private final String contentId;
    private final XmlPullParserFactory xmlParserFactory;

    public MediaPresentationDescriptionParser()
    {
        this(null);
    }

    public MediaPresentationDescriptionParser(String s)
    {
        contentId = s;
        try
        {
            xmlParserFactory = XmlPullParserFactory.newInstance();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", s);
        }
    }

    private static int checkContentTypeConsistency(int i, int j)
    {
        if (i == -1)
        {
            return j;
        }
        if (j == -1)
        {
            return i;
        }
        boolean flag;
        if (i == j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        return i;
    }

    private static String checkLanguageConsistency(String s, String s1)
    {
        if (s == null)
        {
            return s1;
        }
        if (s1 == null)
        {
            return s;
        } else
        {
            Assertions.checkState(s.equals(s1));
            return s;
        }
    }

    protected static String parseBaseUrl(XmlPullParser xmlpullparser, String s)
    {
        xmlpullparser.next();
        return UriUtil.resolve(s, xmlpullparser.getText());
    }

    protected static long parseDateTime(XmlPullParser xmlpullparser, String s, long l)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser == null)
        {
            return l;
        } else
        {
            return Util.parseXsDateTime(xmlpullparser);
        }
    }

    protected static long parseDuration(XmlPullParser xmlpullparser, String s, long l)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser == null)
        {
            return l;
        } else
        {
            return Util.parseXsDuration(xmlpullparser);
        }
    }

    protected static float parseFrameRate(XmlPullParser xmlpullparser, float f)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, "frameRate");
        float f1 = f;
        if (xmlpullparser != null)
        {
            xmlpullparser = FRAME_RATE_PATTERN.matcher(xmlpullparser);
            f1 = f;
            if (xmlpullparser.matches())
            {
                int i = Integer.parseInt(xmlpullparser.group(1));
                xmlpullparser = xmlpullparser.group(2);
                if (!TextUtils.isEmpty(xmlpullparser))
                {
                    return (float)i / (float)Integer.parseInt(xmlpullparser);
                }
                f1 = i;
            }
        }
        return f1;
    }

    protected static int parseInt(XmlPullParser xmlpullparser, String s)
    {
        return parseInt(xmlpullparser, s, -1);
    }

    protected static int parseInt(XmlPullParser xmlpullparser, String s, int i)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser == null)
        {
            return i;
        } else
        {
            return Integer.parseInt(xmlpullparser);
        }
    }

    protected static long parseLong(XmlPullParser xmlpullparser, String s)
    {
        return parseLong(xmlpullparser, s, -1L);
    }

    protected static long parseLong(XmlPullParser xmlpullparser, String s, long l)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser == null)
        {
            return l;
        } else
        {
            return Long.parseLong(xmlpullparser);
        }
    }

    protected static String parseString(XmlPullParser xmlpullparser, String s, String s1)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser == null)
        {
            return s1;
        } else
        {
            return xmlpullparser;
        }
    }

    protected AdaptationSet buildAdaptationSet(int i, int j, List list, List list1)
    {
        return new AdaptationSet(i, j, list, list1);
    }

    protected ContentProtection buildContentProtection(String s, UUID uuid, byte abyte0[])
    {
        return new ContentProtection(s, uuid, abyte0);
    }

    protected Format buildFormat(String s, String s1, int i, int j, float f, int k, int l, 
            int i1, String s2, String s3)
    {
        return new Format(s, s1, i, j, f, k, l, i1, s2, s3);
    }

    protected MediaPresentationDescription buildMediaPresentationDescription(long l, long l1, long l2, boolean flag, 
            long l3, long l4, UtcTimingElement utctimingelement, String s, List list)
    {
        return new MediaPresentationDescription(l, l1, l2, flag, l3, l4, utctimingelement, s, list);
    }

    protected Period buildPeriod(String s, long l, List list)
    {
        return new Period(s, l, list);
    }

    protected RangedUri buildRangedUri(String s, String s1, long l, long l1)
    {
        return new RangedUri(s, s1, l, l1);
    }

    protected Representation buildRepresentation(String s, int i, Format format, SegmentBase segmentbase)
    {
        return Representation.newInstance(s, i, format, segmentbase);
    }

    protected SegmentBase.SegmentList buildSegmentList(RangedUri rangeduri, long l, long l1, int i, long l2, List list, List list1)
    {
        return new SegmentBase.SegmentList(rangeduri, l, l1, i, l2, list, list1);
    }

    protected SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri rangeduri, long l, long l1, int i, long l2, List list, UrlTemplate urltemplate, UrlTemplate urltemplate1, String s)
    {
        return new SegmentBase.SegmentTemplate(rangeduri, l, l1, i, l2, list, urltemplate, urltemplate1, s);
    }

    protected SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long l, long l1)
    {
        return new SegmentBase.SegmentTimelineElement(l, l1);
    }

    protected SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri rangeduri, long l, long l1, String s, long l2, long l3)
    {
        return new SegmentBase.SingleSegmentBase(rangeduri, l, l1, s, l2, l3);
    }

    protected UtcTimingElement buildUtcTimingElement(String s, String s1)
    {
        return new UtcTimingElement(s, s1);
    }

    protected int getContentType(Representation representation)
    {
        String s = representation.format.mimeType;
        if (TextUtils.isEmpty(s))
        {
            return -1;
        }
        if (MimeTypes.isVideo(s))
        {
            return 0;
        }
        if (MimeTypes.isAudio(s))
        {
            return 1;
        }
        if (MimeTypes.isText(s) || "application/ttml+xml".equals(s))
        {
            return 2;
        }
        if ("application/mp4".equals(s))
        {
            representation = representation.format.codecs;
            if ("stpp".equals(representation) || "wvtt".equals(representation))
            {
                return 2;
            }
        }
        return -1;
    }

    public MediaPresentationDescription parse(String s, InputStream inputstream)
    {
        try
        {
            XmlPullParser xmlpullparser = xmlParserFactory.newPullParser();
            xmlpullparser.setInput(inputstream, null);
            if (xmlpullparser.next() != 2 || !"MPD".equals(xmlpullparser.getName()))
            {
                throw new ParserException("inputStream does not contain a valid media presentation description");
            }
            s = parseMediaPresentationDescription(xmlpullparser, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ParserException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ParserException(s);
        }
        return s;
    }

    public volatile Object parse(String s, InputStream inputstream)
    {
        return parse(s, inputstream);
    }

    protected AdaptationSet parseAdaptationSet(XmlPullParser xmlpullparser, String s, SegmentBase segmentbase)
    {
        int i1 = parseInt(xmlpullparser, "id", -1);
        int k = parseContentType(xmlpullparser);
        String s3 = xmlpullparser.getAttributeValue(null, "mimeType");
        String s4 = xmlpullparser.getAttributeValue(null, "codecs");
        int j1 = parseInt(xmlpullparser, "width", -1);
        int k1 = parseInt(xmlpullparser, "height", -1);
        float f = parseFrameRate(xmlpullparser, -1F);
        int j = -1;
        int l1 = parseInt(xmlpullparser, "audioSamplingRate", -1);
        String s1 = xmlpullparser.getAttributeValue(null, "lang");
        ContentProtectionsBuilder contentprotectionsbuilder = new ContentProtectionsBuilder();
        ArrayList arraylist = new ArrayList();
        boolean flag = false;
        Object obj = segmentbase;
        segmentbase = s;
        int i;
        do
        {
            xmlpullparser.next();
            String s2;
            Object obj1;
            int l;
            boolean flag1;
            if (ParserUtil.isStartTag(xmlpullparser, "BaseURL"))
            {
                i = k;
                l = j;
                s2 = s1;
                flag1 = flag;
                obj1 = segmentbase;
                s = ((String) (obj));
                if (!flag)
                {
                    obj1 = parseBaseUrl(xmlpullparser, segmentbase);
                    flag1 = true;
                    i = k;
                    l = j;
                    s2 = s1;
                    s = ((String) (obj));
                }
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "ContentProtection"))
            {
                contentprotectionsbuilder.addAdaptationSetProtection(parseContentProtection(xmlpullparser));
                i = k;
                l = j;
                s2 = s1;
                flag1 = flag;
                obj1 = segmentbase;
                s = ((String) (obj));
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "ContentComponent"))
            {
                s2 = checkLanguageConsistency(s1, xmlpullparser.getAttributeValue(null, "lang"));
                i = checkContentTypeConsistency(k, parseContentType(xmlpullparser));
                l = j;
                flag1 = flag;
                obj1 = segmentbase;
                s = ((String) (obj));
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "Representation"))
            {
                s = parseRepresentation(xmlpullparser, segmentbase, s3, s4, j1, k1, f, j, l1, s1, ((SegmentBase) (obj)), contentprotectionsbuilder);
                contentprotectionsbuilder.endRepresentation();
                i = checkContentTypeConsistency(k, getContentType(s));
                arraylist.add(s);
                l = j;
                s2 = s1;
                flag1 = flag;
                obj1 = segmentbase;
                s = ((String) (obj));
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "AudioChannelConfiguration"))
            {
                l = parseAudioChannelConfiguration(xmlpullparser);
                i = k;
                s2 = s1;
                flag1 = flag;
                obj1 = segmentbase;
                s = ((String) (obj));
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "SegmentBase"))
            {
                s = parseSegmentBase(xmlpullparser, segmentbase, (SegmentBase.SingleSegmentBase)obj);
                i = k;
                l = j;
                s2 = s1;
                flag1 = flag;
                obj1 = segmentbase;
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "SegmentList"))
            {
                s = parseSegmentList(xmlpullparser, segmentbase, (SegmentBase.SegmentList)obj);
                i = k;
                l = j;
                s2 = s1;
                flag1 = flag;
                obj1 = segmentbase;
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "SegmentTemplate"))
            {
                s = parseSegmentTemplate(xmlpullparser, segmentbase, (SegmentBase.SegmentTemplate)obj);
                i = k;
                l = j;
                s2 = s1;
                flag1 = flag;
                obj1 = segmentbase;
            } else
            {
                i = k;
                l = j;
                s2 = s1;
                flag1 = flag;
                obj1 = segmentbase;
                s = ((String) (obj));
                if (ParserUtil.isStartTag(xmlpullparser))
                {
                    parseAdaptationSetChild(xmlpullparser);
                    s = ((String) (obj));
                    obj1 = segmentbase;
                    flag1 = flag;
                    s2 = s1;
                    l = j;
                    i = k;
                }
            }
            k = i;
            j = l;
            s1 = s2;
            flag = flag1;
            segmentbase = ((SegmentBase) (obj1));
            obj = s;
        } while (!ParserUtil.isEndTag(xmlpullparser, "AdaptationSet"));
        return buildAdaptationSet(i1, i, arraylist, contentprotectionsbuilder.build());
    }

    protected void parseAdaptationSetChild(XmlPullParser xmlpullparser)
    {
    }

    protected int parseAudioChannelConfiguration(XmlPullParser xmlpullparser)
    {
        int i;
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(parseString(xmlpullparser, "schemeIdUri", null)))
        {
            i = parseInt(xmlpullparser, "value");
        } else
        {
            i = -1;
        }
        do
        {
            xmlpullparser.next();
        } while (!ParserUtil.isEndTag(xmlpullparser, "AudioChannelConfiguration"));
        return i;
    }

    protected ContentProtection parseContentProtection(XmlPullParser xmlpullparser)
    {
        String s = xmlpullparser.getAttributeValue(null, "schemeIdUri");
        UUID uuid1 = null;
        Object obj = null;
        UUID uuid;
        byte abyte0[];
        do
        {
            xmlpullparser.next();
            uuid = uuid1;
            abyte0 = ((byte []) (obj));
            if (ParserUtil.isStartTag(xmlpullparser, "cenc:pssh"))
            {
                uuid = uuid1;
                abyte0 = ((byte []) (obj));
                if (xmlpullparser.next() == 4)
                {
                    abyte0 = Base64.decode(xmlpullparser.getText(), 0);
                    obj = PsshAtomUtil.parseUuid(abyte0);
                    uuid = ((UUID) (obj));
                    if (obj == null)
                    {
                        throw new ParserException("Invalid pssh atom in cenc:pssh element");
                    }
                }
            }
            uuid1 = uuid;
            obj = abyte0;
        } while (!ParserUtil.isEndTag(xmlpullparser, "ContentProtection"));
        return buildContentProtection(s, uuid, abyte0);
    }

    protected int parseContentType(XmlPullParser xmlpullparser)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, "contentType");
        if (!TextUtils.isEmpty(xmlpullparser))
        {
            if ("audio".equals(xmlpullparser))
            {
                return 1;
            }
            if ("video".equals(xmlpullparser))
            {
                return 0;
            }
            if ("text".equals(xmlpullparser))
            {
                return 2;
            }
        }
        return -1;
    }

    protected RangedUri parseInitialization(XmlPullParser xmlpullparser, String s)
    {
        return parseRangedUrl(xmlpullparser, s, "sourceURL", "range");
    }

    protected MediaPresentationDescription parseMediaPresentationDescription(XmlPullParser xmlpullparser, String s)
    {
        long l5 = parseDateTime(xmlpullparser, "availabilityStartTime", -1L);
        long l4 = parseDuration(xmlpullparser, "mediaPresentationDuration", -1L);
        long l6 = parseDuration(xmlpullparser, "minBufferTime", -1L);
        Object obj = xmlpullparser.getAttributeValue(null, "type");
        boolean flag4;
        if (obj != null)
        {
            flag4 = ((String) (obj)).equals("dynamic");
        } else
        {
            flag4 = false;
        }
        long l1;
        if (flag4)
        {
            l1 = parseDuration(xmlpullparser, "minimumUpdatePeriod", -1L);
        } else
        {
            l1 = -1L;
        }
        long l2;
        if (flag4)
        {
            l2 = parseDuration(xmlpullparser, "timeShiftBufferDepth", -1L);
        } else
        {
            l2 = -1L;
        }
        Object obj1 = null;
        obj = null;
        ArrayList arraylist = new ArrayList();
        long l;
        if (flag4)
        {
            l = -1L;
        } else
        {
            l = 0L;
        }
        boolean flag1 = false;
        boolean flag = false;
        long l3 = l;
        Object obj2;
        Object obj3;
        do
        {
            xmlpullparser.next();
            String s1;
            boolean flag2;
            boolean flag3;
            if (ParserUtil.isStartTag(xmlpullparser, "BaseURL"))
            {
                obj2 = obj1;
                obj3 = obj;
                flag2 = flag1;
                l = l3;
                flag3 = flag;
                s1 = s;
                if (!flag)
                {
                    s1 = parseBaseUrl(xmlpullparser, s);
                    flag3 = true;
                    obj2 = obj1;
                    obj3 = obj;
                    flag2 = flag1;
                    l = l3;
                }
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "UTCTiming"))
            {
                obj2 = parseUtcTiming(xmlpullparser);
                obj3 = obj;
                flag2 = flag1;
                l = l3;
                flag3 = flag;
                s1 = s;
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "Location"))
            {
                obj3 = xmlpullparser.nextText();
                obj2 = obj1;
                flag2 = flag1;
                l = l3;
                flag3 = flag;
                s1 = s;
            } else
            {
                obj2 = obj1;
                obj3 = obj;
                flag2 = flag1;
                l = l3;
                flag3 = flag;
                s1 = s;
                if (ParserUtil.isStartTag(xmlpullparser, "Period"))
                {
                    obj2 = obj1;
                    obj3 = obj;
                    flag2 = flag1;
                    l = l3;
                    flag3 = flag;
                    s1 = s;
                    if (!flag1)
                    {
                        obj2 = parsePeriod(xmlpullparser, s, l3);
                        obj3 = (Period)((Pair) (obj2)).first;
                        if (((Period) (obj3)).startMs == -1L)
                        {
                            if (flag4)
                            {
                                flag2 = true;
                                obj2 = obj1;
                                obj3 = obj;
                                l = l3;
                                flag3 = flag;
                                s1 = s;
                            } else
                            {
                                throw new ParserException((new StringBuilder("Unable to determine start of period ")).append(arraylist.size()).toString());
                            }
                        } else
                        {
                            l = ((Long)((Pair) (obj2)).second).longValue();
                            if (l == -1L)
                            {
                                l = -1L;
                            } else
                            {
                                l = ((Period) (obj3)).startMs + l;
                            }
                            arraylist.add(obj3);
                            s1 = s;
                            flag3 = flag;
                            flag2 = flag1;
                            obj3 = obj;
                            obj2 = obj1;
                        }
                    }
                }
            }
            obj1 = obj2;
            obj = obj3;
            flag1 = flag2;
            l3 = l;
            flag = flag3;
            s = s1;
        } while (!ParserUtil.isEndTag(xmlpullparser, "MPD"));
        l3 = l4;
        if (!flag4)
        {
            l3 = l4;
            if (l4 == -1L)
            {
                if (l != -1L)
                {
                    l3 = l;
                } else
                {
                    throw new ParserException("Unable to determine duration of static manifest.");
                }
            }
        }
        return buildMediaPresentationDescription(l5, l3, l6, flag4, l1, l2, ((UtcTimingElement) (obj2)), ((String) (obj3)), arraylist);
    }

    protected Pair parsePeriod(XmlPullParser xmlpullparser, String s, long l)
    {
        String s3 = xmlpullparser.getAttributeValue(null, "id");
        l = parseDuration(xmlpullparser, "start", l);
        long l1 = parseDuration(xmlpullparser, "duration", -1L);
        Object obj = null;
        ArrayList arraylist = new ArrayList();
        boolean flag = false;
        String s1 = s;
        do
        {
            xmlpullparser.next();
            String s2;
            boolean flag1;
            if (ParserUtil.isStartTag(xmlpullparser, "BaseURL"))
            {
                flag1 = flag;
                s2 = s1;
                s = ((String) (obj));
                if (!flag)
                {
                    s2 = parseBaseUrl(xmlpullparser, s1);
                    flag1 = true;
                    s = ((String) (obj));
                }
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "AdaptationSet"))
            {
                arraylist.add(parseAdaptationSet(xmlpullparser, s1, ((SegmentBase) (obj))));
                flag1 = flag;
                s2 = s1;
                s = ((String) (obj));
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "SegmentBase"))
            {
                s = parseSegmentBase(xmlpullparser, s1, null);
                flag1 = flag;
                s2 = s1;
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "SegmentList"))
            {
                s = parseSegmentList(xmlpullparser, s1, null);
                flag1 = flag;
                s2 = s1;
            } else
            {
                flag1 = flag;
                s2 = s1;
                s = ((String) (obj));
                if (ParserUtil.isStartTag(xmlpullparser, "SegmentTemplate"))
                {
                    s = parseSegmentTemplate(xmlpullparser, s1, null);
                    s2 = s1;
                    flag1 = flag;
                }
            }
            flag = flag1;
            s1 = s2;
            obj = s;
        } while (!ParserUtil.isEndTag(xmlpullparser, "Period"));
        return Pair.create(buildPeriod(s3, l, arraylist), Long.valueOf(l1));
    }

    protected RangedUri parseRangedUrl(XmlPullParser xmlpullparser, String s, String s1, String s2)
    {
        s1 = xmlpullparser.getAttributeValue(null, s1);
        long l = 0L;
        long l2 = -1L;
        xmlpullparser = xmlpullparser.getAttributeValue(null, s2);
        long l1 = l2;
        if (xmlpullparser != null)
        {
            xmlpullparser = xmlpullparser.split("-");
            long l3 = Long.parseLong(xmlpullparser[0]);
            l = l3;
            l1 = l2;
            if (xmlpullparser.length == 2)
            {
                l1 = (Long.parseLong(xmlpullparser[1]) - l3) + 1L;
                l = l3;
            }
        }
        return buildRangedUri(s, s1, l, l1);
    }

    protected Representation parseRepresentation(XmlPullParser xmlpullparser, String s, String s1, String s2, int i, int j, float f, 
            int k, int l, String s3, SegmentBase segmentbase, ContentProtectionsBuilder contentprotectionsbuilder)
    {
        String s4 = xmlpullparser.getAttributeValue(null, "id");
        int i1 = parseInt(xmlpullparser, "bandwidth");
        String s5 = parseString(xmlpullparser, "mimeType", s1);
        String s6 = parseString(xmlpullparser, "codecs", s2);
        int j1 = parseInt(xmlpullparser, "width", i);
        int k1 = parseInt(xmlpullparser, "height", j);
        f = parseFrameRate(xmlpullparser, f);
        int l1 = parseInt(xmlpullparser, "audioSamplingRate", l);
        i = 0;
        s2 = s;
        do
        {
            xmlpullparser.next();
            if (ParserUtil.isStartTag(xmlpullparser, "BaseURL"))
            {
                j = i;
                s1 = s2;
                l = k;
                s = segmentbase;
                if (i == 0)
                {
                    s1 = parseBaseUrl(xmlpullparser, s2);
                    j = 1;
                    l = k;
                    s = segmentbase;
                }
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "AudioChannelConfiguration"))
            {
                l = parseAudioChannelConfiguration(xmlpullparser);
                j = i;
                s1 = s2;
                s = segmentbase;
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "SegmentBase"))
            {
                s = parseSegmentBase(xmlpullparser, s2, (SegmentBase.SingleSegmentBase)segmentbase);
                j = i;
                s1 = s2;
                l = k;
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "SegmentList"))
            {
                s = parseSegmentList(xmlpullparser, s2, (SegmentBase.SegmentList)segmentbase);
                j = i;
                s1 = s2;
                l = k;
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "SegmentTemplate"))
            {
                s = parseSegmentTemplate(xmlpullparser, s2, (SegmentBase.SegmentTemplate)segmentbase);
                j = i;
                s1 = s2;
                l = k;
            } else
            {
                j = i;
                s1 = s2;
                l = k;
                s = segmentbase;
                if (ParserUtil.isStartTag(xmlpullparser, "ContentProtection"))
                {
                    contentprotectionsbuilder.addRepresentationProtection(parseContentProtection(xmlpullparser));
                    s = segmentbase;
                    l = k;
                    s1 = s2;
                    j = i;
                }
            }
            i = j;
            s2 = s1;
            k = l;
            segmentbase = s;
        } while (!ParserUtil.isEndTag(xmlpullparser, "Representation"));
        xmlpullparser = buildFormat(s4, s5, j1, k1, f, l, l1, i1, s3, s6);
        s2 = contentId;
        if (s == null)
        {
            s = new SegmentBase.SingleSegmentBase(s1);
        }
        return buildRepresentation(s2, -1, xmlpullparser, s);
    }

    protected SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xmlpullparser, String s, SegmentBase.SingleSegmentBase singlesegmentbase)
    {
        long l;
        if (singlesegmentbase != null)
        {
            l = singlesegmentbase.timescale;
        } else
        {
            l = 1L;
        }
        long l2 = parseLong(xmlpullparser, "timescale", l);
        if (singlesegmentbase != null)
        {
            l = singlesegmentbase.presentationTimeOffset;
        } else
        {
            l = 0L;
        }
        long l3 = parseLong(xmlpullparser, "presentationTimeOffset", l);
        if (singlesegmentbase != null)
        {
            l = singlesegmentbase.indexStart;
        } else
        {
            l = 0L;
        }
        long l1;
        if (singlesegmentbase != null)
        {
            l1 = singlesegmentbase.indexLength;
        } else
        {
            l1 = -1L;
        }
        Object obj = xmlpullparser.getAttributeValue(null, "indexRange");
        if (obj != null)
        {
            String as[] = ((String) (obj)).split("-");
            l = Long.parseLong(as[0]);
            l1 = (Long.parseLong(as[1]) - l) + 1L;
        }
        if (singlesegmentbase != null)
        {
            singlesegmentbase = singlesegmentbase.initialization;
        } else
        {
            singlesegmentbase = null;
        }
        do
        {
            xmlpullparser.next();
            as = singlesegmentbase;
            if (ParserUtil.isStartTag(xmlpullparser, "Initialization"))
            {
                as = parseInitialization(xmlpullparser, s);
            }
            singlesegmentbase = as;
        } while (!ParserUtil.isEndTag(xmlpullparser, "SegmentBase"));
        return buildSingleSegmentBase(as, l2, l3, s, l, l1);
    }

    protected SegmentBase.SegmentList parseSegmentList(XmlPullParser xmlpullparser, String s, SegmentBase.SegmentList segmentlist)
    {
        long l;
        if (segmentlist != null)
        {
            l = segmentlist.timescale;
        } else
        {
            l = 1L;
        }
        long l1 = parseLong(xmlpullparser, "timescale", l);
        if (segmentlist != null)
        {
            l = segmentlist.presentationTimeOffset;
        } else
        {
            l = 0L;
        }
        long l2 = parseLong(xmlpullparser, "presentationTimeOffset", l);
        if (segmentlist != null)
        {
            l = segmentlist.duration;
        } else
        {
            l = -1L;
        }
        l = parseLong(xmlpullparser, "duration", l);
        int i;
        if (segmentlist != null)
        {
            i = segmentlist.startNumber;
        } else
        {
            i = 1;
        }
        i = parseInt(xmlpullparser, "startNumber", i);
        RangedUri rangeduri1 = null;
        List list1 = null;
        Object obj = null;
        List list;
        RangedUri rangeduri;
        ArrayList arraylist;
        do
        {
            xmlpullparser.next();
            if (ParserUtil.isStartTag(xmlpullparser, "Initialization"))
            {
                rangeduri = parseInitialization(xmlpullparser, s);
                list = list1;
                arraylist = ((ArrayList) (obj));
            } else
            if (ParserUtil.isStartTag(xmlpullparser, "SegmentTimeline"))
            {
                list = parseSegmentTimeline(xmlpullparser);
                rangeduri = rangeduri1;
                arraylist = ((ArrayList) (obj));
            } else
            {
                rangeduri = rangeduri1;
                list = list1;
                arraylist = ((ArrayList) (obj));
                if (ParserUtil.isStartTag(xmlpullparser, "SegmentURL"))
                {
                    arraylist = ((ArrayList) (obj));
                    if (obj == null)
                    {
                        arraylist = new ArrayList();
                    }
                    arraylist.add(parseSegmentUrl(xmlpullparser, s));
                    list = list1;
                    rangeduri = rangeduri1;
                }
            }
            rangeduri1 = rangeduri;
            list1 = list;
            obj = arraylist;
        } while (!ParserUtil.isEndTag(xmlpullparser, "SegmentList"));
        s = rangeduri;
        obj = list;
        xmlpullparser = arraylist;
        if (segmentlist != null)
        {
            if (rangeduri == null)
            {
                rangeduri = segmentlist.initialization;
            }
            if (list == null)
            {
                list = segmentlist.segmentTimeline;
            }
            if (arraylist != null)
            {
                s = rangeduri;
                obj = list;
                xmlpullparser = arraylist;
            } else
            {
                xmlpullparser = segmentlist.mediaSegments;
                obj = list;
                s = rangeduri;
            }
        }
        return buildSegmentList(s, l1, l2, i, l, ((List) (obj)), xmlpullparser);
    }

    protected SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xmlpullparser, String s, SegmentBase.SegmentTemplate segmenttemplate)
    {
        long l;
        if (segmenttemplate != null)
        {
            l = segmenttemplate.timescale;
        } else
        {
            l = 1L;
        }
        long l1 = parseLong(xmlpullparser, "timescale", l);
        if (segmenttemplate != null)
        {
            l = segmenttemplate.presentationTimeOffset;
        } else
        {
            l = 0L;
        }
        long l2 = parseLong(xmlpullparser, "presentationTimeOffset", l);
        if (segmenttemplate != null)
        {
            l = segmenttemplate.duration;
        } else
        {
            l = -1L;
        }
        l = parseLong(xmlpullparser, "duration", l);
        int i;
        if (segmenttemplate != null)
        {
            i = segmenttemplate.startNumber;
        } else
        {
            i = 1;
        }
        i = parseInt(xmlpullparser, "startNumber", i);
        Object obj;
        if (segmenttemplate != null)
        {
            obj = segmenttemplate.mediaTemplate;
        } else
        {
            obj = null;
        }
        UrlTemplate urltemplate = parseUrlTemplate(xmlpullparser, "media", ((UrlTemplate) (obj)));
        if (segmenttemplate != null)
        {
            obj = segmenttemplate.initializationTemplate;
        } else
        {
            obj = null;
        }
        UrlTemplate urltemplate1 = parseUrlTemplate(xmlpullparser, "initialization", ((UrlTemplate) (obj)));
        RangedUri rangeduri = null;
        Object obj1 = null;
        List list;
        do
        {
            xmlpullparser.next();
            if (ParserUtil.isStartTag(xmlpullparser, "Initialization"))
            {
                obj = parseInitialization(xmlpullparser, s);
                list = ((List) (obj1));
            } else
            {
                obj = rangeduri;
                list = ((List) (obj1));
                if (ParserUtil.isStartTag(xmlpullparser, "SegmentTimeline"))
                {
                    list = parseSegmentTimeline(xmlpullparser);
                    obj = rangeduri;
                }
            }
            rangeduri = ((RangedUri) (obj));
            obj1 = list;
        } while (!ParserUtil.isEndTag(xmlpullparser, "SegmentTemplate"));
        obj1 = obj;
        xmlpullparser = list;
        if (segmenttemplate != null)
        {
            if (obj == null)
            {
                obj = segmenttemplate.initialization;
            }
            if (list != null)
            {
                obj1 = obj;
                xmlpullparser = list;
            } else
            {
                xmlpullparser = segmenttemplate.segmentTimeline;
                obj1 = obj;
            }
        }
        return buildSegmentTemplate(((RangedUri) (obj1)), l1, l2, i, l, xmlpullparser, urltemplate1, urltemplate, s);
    }

    protected List parseSegmentTimeline(XmlPullParser xmlpullparser)
    {
        ArrayList arraylist = new ArrayList();
        long l = 0L;
        do
        {
            xmlpullparser.next();
            long l1 = l;
            if (ParserUtil.isStartTag(xmlpullparser, "S"))
            {
                l = parseLong(xmlpullparser, "t", l);
                long l2 = parseLong(xmlpullparser, "d");
                int j = parseInt(xmlpullparser, "r", 0);
                int i = 0;
                do
                {
                    l1 = l;
                    if (i >= j + 1)
                    {
                        break;
                    }
                    arraylist.add(buildSegmentTimelineElement(l, l2));
                    l += l2;
                    i++;
                } while (true);
            }
            l = l1;
        } while (!ParserUtil.isEndTag(xmlpullparser, "SegmentTimeline"));
        return arraylist;
    }

    protected RangedUri parseSegmentUrl(XmlPullParser xmlpullparser, String s)
    {
        return parseRangedUrl(xmlpullparser, s, "media", "mediaRange");
    }

    protected UrlTemplate parseUrlTemplate(XmlPullParser xmlpullparser, String s, UrlTemplate urltemplate)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            return UrlTemplate.compile(xmlpullparser);
        } else
        {
            return urltemplate;
        }
    }

    protected UtcTimingElement parseUtcTiming(XmlPullParser xmlpullparser)
    {
        return buildUtcTimingElement(xmlpullparser.getAttributeValue(null, "schemeIdUri"), xmlpullparser.getAttributeValue(null, "value"));
    }

}
