// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.ttml;

import android.graphics.Color;
import android.util.Log;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.text.SubtitleParser;
import com.google.android.exoplayer.util.ParserUtil;
import com.google.android.exoplayer.util.Util;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

// Referenced classes of package com.google.android.exoplayer.text.ttml:
//            TtmlStyle, TtmlNode, TtmlSubtitle

public final class TtmlParser
    implements SubtitleParser
{

    private static final String ATTR_BEGIN = "begin";
    private static final String ATTR_DURATION = "dur";
    private static final String ATTR_END = "end";
    private static final String ATTR_STYLE = "style";
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final int DEFAULT_FRAMERATE = 30;
    private static final int DEFAULT_SUBFRAMERATE = 1;
    private static final int DEFAULT_TICKRATE = 1;
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final String TAG = "TtmlParser";
    private final boolean strictParsing;
    private final XmlPullParserFactory xmlParserFactory;

    public TtmlParser()
    {
        this(false);
    }

    public TtmlParser(boolean flag)
    {
        strictParsing = flag;
        try
        {
            xmlParserFactory = XmlPullParserFactory.newInstance();
            return;
        }
        catch (XmlPullParserException xmlpullparserexception)
        {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", xmlpullparserexception);
        }
    }

    private TtmlStyle createIfNull(TtmlStyle ttmlstyle)
    {
        if (ttmlstyle == null)
        {
            return new TtmlStyle();
        } else
        {
            return ttmlstyle;
        }
    }

    private static boolean isSupportedTag(String s)
    {
        return s.equals("tt") || s.equals("head") || s.equals("body") || s.equals("div") || s.equals("p") || s.equals("span") || s.equals("br") || s.equals("style") || s.equals("styling") || s.equals("layout") || s.equals("region") || s.equals("metadata") || s.equals("smpte:image") || s.equals("smpte:data") || s.equals("smpte:information");
    }

    private Map parseHeader(XmlPullParser xmlpullparser, Map map)
    {
        do
        {
            xmlpullparser.next();
            if (ParserUtil.isStartTag(xmlpullparser, "style"))
            {
                String s = xmlpullparser.getAttributeValue(null, "style");
                TtmlStyle ttmlstyle = parseStyleAttributes(xmlpullparser, new TtmlStyle());
                if (s != null)
                {
                    String as[] = parseStyleIds(s);
                    for (int i = 0; i < as.length; i++)
                    {
                        ttmlstyle.chain((TtmlStyle)map.get(as[i]));
                    }

                }
                if (ttmlstyle.getId() != null)
                {
                    map.put(ttmlstyle.getId(), ttmlstyle);
                }
            }
        } while (!ParserUtil.isEndTag(xmlpullparser, "head"));
        return map;
    }

    private TtmlNode parseNode(XmlPullParser xmlpullparser, TtmlNode ttmlnode)
    {
        long l6 = 0L;
        long l = -1L;
        long l1 = -1L;
        String as[] = null;
        int j = xmlpullparser.getAttributeCount();
        TtmlStyle ttmlstyle = parseStyleAttributes(xmlpullparser, null);
        for (int i = 0; i < j;)
        {
            String s = ParserUtil.removeNamespacePrefix(xmlpullparser.getAttributeName(i));
            String s1 = xmlpullparser.getAttributeValue(i);
            String as1[];
            long l2;
            long l4;
            long l7;
            if (s.equals("begin"))
            {
                l4 = parseTimeExpression(s1, 30, 1, 1);
                l2 = l6;
                l7 = l1;
                as1 = as;
            } else
            if (s.equals("end"))
            {
                l7 = parseTimeExpression(s1, 30, 1, 1);
                l2 = l6;
                l4 = l;
                as1 = as;
            } else
            if (s.equals("dur"))
            {
                l2 = parseTimeExpression(s1, 30, 1, 1);
                l4 = l;
                l7 = l1;
                as1 = as;
            } else
            {
                l2 = l6;
                l4 = l;
                l7 = l1;
                as1 = as;
                if (s.equals("style"))
                {
                    String as2[] = parseStyleIds(s1);
                    l2 = l6;
                    l4 = l;
                    l7 = l1;
                    as1 = as;
                    if (as2.length > 0)
                    {
                        as1 = as2;
                        l7 = l1;
                        l4 = l;
                        l2 = l6;
                    }
                }
            }
            i++;
            l6 = l2;
            l = l4;
            l1 = l7;
            as = as1;
        }

        long l8 = l;
        long l5 = l1;
        if (ttmlnode != null)
        {
            l8 = l;
            l5 = l1;
            if (ttmlnode.startTimeUs != -1L)
            {
                long l3 = l;
                if (l != -1L)
                {
                    l3 = l + ttmlnode.startTimeUs;
                }
                l8 = l3;
                l5 = l1;
                if (l1 != -1L)
                {
                    l5 = l1 + ttmlnode.startTimeUs;
                    l8 = l3;
                }
            }
        }
        l = l5;
        if (l5 == -1L)
        {
            if (l6 > 0L)
            {
                l = l8 + l6;
            } else
            {
                l = l5;
                if (ttmlnode != null)
                {
                    l = l5;
                    if (ttmlnode.endTimeUs != -1L)
                    {
                        l = ttmlnode.endTimeUs;
                    }
                }
            }
        }
        return TtmlNode.buildNode(xmlpullparser.getName(), l8, l, ttmlstyle, as);
    }

    private TtmlStyle parseStyleAttributes(XmlPullParser xmlpullparser, TtmlStyle ttmlstyle)
    {
        IllegalArgumentException illegalargumentexception;
        int j = xmlpullparser.getAttributeCount();
        int i = 0;
        TtmlStyle ttmlstyle1;
        for (ttmlstyle1 = ttmlstyle; i < j; ttmlstyle1 = ttmlstyle)
        {
            ttmlstyle = xmlpullparser.getAttributeName(i);
            String s = xmlpullparser.getAttributeValue(i);
            ttmlstyle = ParserUtil.removeNamespacePrefix(ttmlstyle);
            byte byte0 = -1;
            switch (ttmlstyle.hashCode())
            {
            case 3355: 
                if (ttmlstyle.equals("id"))
                {
                    byte0 = 0;
                }
                break;

            case 1287124693: 
                if (ttmlstyle.equals("backgroundColor"))
                {
                    byte0 = 1;
                }
                break;

            case 94842723: 
                if (ttmlstyle.equals("color"))
                {
                    byte0 = 2;
                }
                break;

            case -1224696685: 
                if (ttmlstyle.equals("fontFamily"))
                {
                    byte0 = 3;
                }
                break;

            case 365601008: 
                if (ttmlstyle.equals("fontSize"))
                {
                    byte0 = 4;
                }
                break;

            case -734428249: 
                if (ttmlstyle.equals("fontWeight"))
                {
                    byte0 = 5;
                }
                break;

            case -1550943582: 
                if (ttmlstyle.equals("fontStyle"))
                {
                    byte0 = 6;
                }
                break;

            case -1065511464: 
                if (ttmlstyle.equals("textAlign"))
                {
                    byte0 = 7;
                }
                break;

            case -879295043: 
                if (ttmlstyle.equals("textDecoration"))
                {
                    byte0 = 8;
                }
                break;
            }
            switch (byte0)
            {
            default:
                ttmlstyle = ttmlstyle1;
                break;

            case 0: // '\0'
                ttmlstyle = ttmlstyle1;
                if ("style".equals(xmlpullparser.getName()))
                {
                    ttmlstyle = createIfNull(ttmlstyle1).setId(s);
                }
                break;

            case 1: // '\001'
                ttmlstyle = createIfNull(ttmlstyle1);
                try
                {
                    ttmlstyle.setBackgroundColor(Color.parseColor(s));
                }
                // Misplaced declaration of an exception variable
                catch (IllegalArgumentException illegalargumentexception)
                {
                    Log.w("TtmlParser", (new StringBuilder("failed parsing background value: '")).append(s).append("'").toString());
                }
                break;

            case 2: // '\002'
                ttmlstyle = createIfNull(ttmlstyle1);
                try
                {
                    ttmlstyle.setColor(Color.parseColor(s));
                }
                // Misplaced declaration of an exception variable
                catch (IllegalArgumentException illegalargumentexception)
                {
                    Log.w("TtmlParser", (new StringBuilder("failed parsing color value: '")).append(s).append("'").toString());
                }
                break;

            case 3: // '\003'
                ttmlstyle = createIfNull(ttmlstyle1).setFontFamily(s);
                break;

            case 4: // '\004'
                ttmlstyle = ttmlstyle1;
                break;

            case 5: // '\005'
                ttmlstyle = createIfNull(ttmlstyle1).setBold("bold".equalsIgnoreCase(s));
                break;

            case 6: // '\006'
                ttmlstyle = createIfNull(ttmlstyle1).setItalic("italic".equalsIgnoreCase(s));
                break;

            case 7: // '\007'
                ttmlstyle = Util.toLowerInvariant(s);
                byte byte1 = -1;
                switch (ttmlstyle.hashCode())
                {
                case 3317767: 
                    if (ttmlstyle.equals("left"))
                    {
                        byte1 = 0;
                    }
                    break;

                case 109757538: 
                    if (ttmlstyle.equals("start"))
                    {
                        byte1 = 1;
                    }
                    break;

                case 108511772: 
                    if (ttmlstyle.equals("right"))
                    {
                        byte1 = 2;
                    }
                    break;

                case 100571: 
                    if (ttmlstyle.equals("end"))
                    {
                        byte1 = 3;
                    }
                    break;

                case -1364013995: 
                    if (ttmlstyle.equals("center"))
                    {
                        byte1 = 4;
                    }
                    break;
                }
                switch (byte1)
                {
                default:
                    ttmlstyle = ttmlstyle1;
                    break;

                case 0: // '\0'
                    ttmlstyle = createIfNull(ttmlstyle1).setTextAlign(android.text.Layout.Alignment.ALIGN_NORMAL);
                    break;

                case 1: // '\001'
                    ttmlstyle = createIfNull(ttmlstyle1).setTextAlign(android.text.Layout.Alignment.ALIGN_NORMAL);
                    break;

                case 2: // '\002'
                    ttmlstyle = createIfNull(ttmlstyle1).setTextAlign(android.text.Layout.Alignment.ALIGN_OPPOSITE);
                    break;

                case 3: // '\003'
                    ttmlstyle = createIfNull(ttmlstyle1).setTextAlign(android.text.Layout.Alignment.ALIGN_OPPOSITE);
                    break;

                case 4: // '\004'
                    ttmlstyle = createIfNull(ttmlstyle1).setTextAlign(android.text.Layout.Alignment.ALIGN_CENTER);
                    break;
                }
                break;

            case 8: // '\b'
                ttmlstyle = Util.toLowerInvariant(s);
                byte byte2 = -1;
                switch (ttmlstyle.hashCode())
                {
                case 1679736913: 
                    if (ttmlstyle.equals("linethrough"))
                    {
                        byte2 = 0;
                    }
                    break;

                case 913457136: 
                    if (ttmlstyle.equals("nolinethrough"))
                    {
                        byte2 = 1;
                    }
                    break;

                case -1026963764: 
                    if (ttmlstyle.equals("underline"))
                    {
                        byte2 = 2;
                    }
                    break;

                case -1461280213: 
                    if (ttmlstyle.equals("nounderline"))
                    {
                        byte2 = 3;
                    }
                    break;
                }
                switch (byte2)
                {
                default:
                    ttmlstyle = ttmlstyle1;
                    break;

                case 0: // '\0'
                    ttmlstyle = createIfNull(ttmlstyle1).setLinethrough(true);
                    break;

                case 1: // '\001'
                    ttmlstyle = createIfNull(ttmlstyle1).setLinethrough(false);
                    break;

                case 2: // '\002'
                    ttmlstyle = createIfNull(ttmlstyle1).setUnderline(true);
                    break;

                case 3: // '\003'
                    ttmlstyle = createIfNull(ttmlstyle1).setUnderline(false);
                    break;
                }
                break;
            }
            i++;
        }

        return ttmlstyle1;
    }

    private String[] parseStyleIds(String s)
    {
        return s.split("\\s+");
    }

    private static long parseTimeExpression(String s, int i, int j, int k)
    {
        Matcher matcher = CLOCK_TIME.matcher(s);
        if (matcher.matches())
        {
            double d5 = Long.parseLong(matcher.group(1)) * 3600L;
            double d6 = Long.parseLong(matcher.group(2)) * 60L;
            double d7 = Long.parseLong(matcher.group(3));
            s = matcher.group(4);
            double d;
            if (s != null)
            {
                d = Double.parseDouble(s);
            } else
            {
                d = 0.0D;
            }
            s = matcher.group(5);
            double d2;
            if (s != null)
            {
                d2 = (double)Long.parseLong(s) / (double)i;
            } else
            {
                d2 = 0.0D;
            }
            s = matcher.group(6);
            double d4;
            if (s != null)
            {
                d4 = (double)Long.parseLong(s) / (double)j / (double)i;
            } else
            {
                d4 = 0.0D;
            }
            return (long)((d4 + (d5 + d6 + d7 + d + d2)) * 1000000D);
        }
        matcher = OFFSET_TIME.matcher(s);
        if (matcher.matches())
        {
            double d3 = Double.parseDouble(matcher.group(1));
            s = matcher.group(2);
            double d1;
            if (s.equals("h"))
            {
                d1 = d3 * 3600D;
            } else
            if (s.equals("m"))
            {
                d1 = d3 * 60D;
            } else
            {
                d1 = d3;
                if (!s.equals("s"))
                {
                    if (s.equals("ms"))
                    {
                        d1 = d3 / 1000D;
                    } else
                    if (s.equals("f"))
                    {
                        d1 = d3 / (double)i;
                    } else
                    {
                        d1 = d3;
                        if (s.equals("t"))
                        {
                            d1 = d3 / (double)k;
                        }
                    }
                }
            }
            return (long)(1000000D * d1);
        } else
        {
            throw new ParserException((new StringBuilder("Malformed time expression: ")).append(s).toString());
        }
    }

    public final boolean canParse(String s)
    {
        return "application/ttml+xml".equals(s);
    }

    public final Subtitle parse(InputStream inputstream)
    {
        Object obj;
        int i;
        int j;
        int k;
        XmlPullParser xmlpullparser;
        HashMap hashmap;
        LinkedList linkedlist;
        Object obj1;
        try
        {
            xmlpullparser = xmlParserFactory.newPullParser();
            hashmap = new HashMap();
            xmlpullparser.setInput(inputstream, null);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new ParserException("Unable to parse source", inputstream);
        }
        inputstream = null;
        linkedlist = new LinkedList();
        j = 0;
        k = xmlpullparser.getEventType();
_L14:
        if (k == 1) goto _L2; else goto _L1
_L1:
        obj = (TtmlNode)linkedlist.peekLast();
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        obj1 = xmlpullparser.getName();
        if (k != 2) goto _L4; else goto _L3
_L3:
        if (isSupportedTag(((String) (obj1)))) goto _L6; else goto _L5
_L5:
        Log.i("TtmlParser", (new StringBuilder("Ignoring unsupported tag: ")).append(xmlpullparser.getName()).toString());
        i = j + 1;
        obj = inputstream;
          goto _L7
_L6:
        if (!"head".equals(obj1)) goto _L9; else goto _L8
_L8:
        parseHeader(xmlpullparser, hashmap);
        i = j;
        obj = inputstream;
          goto _L7
_L9:
        obj1 = parseNode(xmlpullparser, ((TtmlNode) (obj)));
        linkedlist.addLast(obj1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        ((TtmlNode) (obj)).addChild(((TtmlNode) (obj1)));
        i = j;
        obj = inputstream;
          goto _L7
        obj;
        if (strictParsing)
        {
            throw obj;
        }
        Log.w("TtmlParser", "Suppressing parser error", ((Throwable) (obj)));
        i = j + 1;
        obj = inputstream;
          goto _L7
_L4:
        if (k != 4) goto _L11; else goto _L10
_L10:
        ((TtmlNode) (obj)).addChild(TtmlNode.buildTextNode(xmlpullparser.getText()));
        i = j;
        obj = inputstream;
          goto _L7
_L11:
        obj = inputstream;
        if (k != 3) goto _L13; else goto _L12
_L12:
        if (xmlpullparser.getName().equals("tt"))
        {
            inputstream = new TtmlSubtitle((TtmlNode)linkedlist.getLast(), hashmap);
        }
        linkedlist.removeLast();
        obj = inputstream;
          goto _L13
_L7:
        xmlpullparser.next();
        k = xmlpullparser.getEventType();
        j = i;
        inputstream = ((InputStream) (obj));
          goto _L14
_L2:
        return inputstream;
_L13:
        i = j;
          goto _L7
        if (k == 2)
        {
            i = j + 1;
            obj = inputstream;
        } else
        {
            i = j;
            obj = inputstream;
            if (k == 3)
            {
                i = j - 1;
                obj = inputstream;
            }
        }
          goto _L7
    }

}
