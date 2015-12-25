// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;

import android.util.Pair;
import com.google.android.exoplayer.ParserException;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifestParser

static abstract class tag
{

    private final String baseUri;
    private final List normalizedAttributes = new LinkedList();
    private final normalizedAttributes parent;
    private final String tag;

    private tag newChildParser(tag tag1, String s, String s1)
    {
        if ("QualityLevel".equals(s))
        {
            return new rser(tag1, s1);
        }
        if ("Protection".equals(s))
        {
            return new entParser(tag1, s1);
        }
        if ("StreamIndex".equals(s))
        {
            return new arser(tag1, s1);
        } else
        {
            return null;
        }
    }

    protected void addChild(Object obj)
    {
    }

    protected abstract Object build();

    protected final Object getNormalizedAttribute(String s)
    {
        arser arser = this;
        do
        {
            for (int i = 0; i < arser.normalizedAttributes.size(); i++)
            {
                Pair pair = (Pair)arser.normalizedAttributes.get(i);
                if (((String)pair.first).equals(s))
                {
                    return pair.second;
                }
            }

            if (arser.parent == null)
            {
                return null;
            }
            arser = arser.parent;
        } while (true);
    }

    protected boolean handleChildInline(String s)
    {
        return false;
    }

    public final Object parse(XmlPullParser xmlpullparser)
    {
        boolean flag = false;
        int j = 0;
        do
        {
            int i;
            boolean flag1;
            switch (xmlpullparser.getEventType())
            {
            default:
                flag1 = flag;
                i = j;
                break;

            case 2: // '\002'
                Object obj = xmlpullparser.getName();
                if (tag.equals(obj))
                {
                    flag1 = true;
                    parseStartTag(xmlpullparser);
                    i = j;
                    break;
                }
                flag1 = flag;
                i = j;
                if (!flag)
                {
                    break;
                }
                if (j > 0)
                {
                    i = j + 1;
                    flag1 = flag;
                    break;
                }
                if (handleChildInline(((String) (obj))))
                {
                    parseStartTag(xmlpullparser);
                    flag1 = flag;
                    i = j;
                    break;
                }
                obj = newChildParser(this, ((String) (obj)), baseUri);
                if (obj == null)
                {
                    i = 1;
                    flag1 = flag;
                } else
                {
                    addChild(((addChild) (obj)).parse(xmlpullparser));
                    flag1 = flag;
                    i = j;
                }
                break;

            case 4: // '\004'
                flag1 = flag;
                i = j;
                if (!flag)
                {
                    break;
                }
                flag1 = flag;
                i = j;
                if (j == 0)
                {
                    parseText(xmlpullparser);
                    flag1 = flag;
                    i = j;
                }
                break;

            case 3: // '\003'
                flag1 = flag;
                i = j;
                if (!flag)
                {
                    break;
                }
                if (j > 0)
                {
                    i = j - 1;
                    flag1 = flag;
                    break;
                }
                String s = xmlpullparser.getName();
                parseEndTag(xmlpullparser);
                flag1 = flag;
                i = j;
                if (!handleChildInline(s))
                {
                    return build();
                }
                break;

            case 1: // '\001'
                return null;
            }
            xmlpullparser.next();
            flag = flag1;
            j = i;
        } while (true);
    }

    protected final boolean parseBoolean(XmlPullParser xmlpullparser, String s, boolean flag)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            return Boolean.parseBoolean(xmlpullparser);
        } else
        {
            return flag;
        }
    }

    protected void parseEndTag(XmlPullParser xmlpullparser)
    {
    }

    protected final int parseInt(XmlPullParser xmlpullparser, String s, int i)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            try
            {
                i = Integer.parseInt(xmlpullparser);
            }
            // Misplaced declaration of an exception variable
            catch (XmlPullParser xmlpullparser)
            {
                throw new ParserException(xmlpullparser);
            }
            return i;
        } else
        {
            return i;
        }
    }

    protected final long parseLong(XmlPullParser xmlpullparser, String s, long l)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            try
            {
                l = Long.parseLong(xmlpullparser);
            }
            // Misplaced declaration of an exception variable
            catch (XmlPullParser xmlpullparser)
            {
                throw new ParserException(xmlpullparser);
            }
            return l;
        } else
        {
            return l;
        }
    }

    protected final int parseRequiredInt(XmlPullParser xmlpullparser, String s)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            int i;
            try
            {
                i = Integer.parseInt(xmlpullparser);
            }
            // Misplaced declaration of an exception variable
            catch (XmlPullParser xmlpullparser)
            {
                throw new ParserException(xmlpullparser);
            }
            return i;
        } else
        {
            throw new ception(s);
        }
    }

    protected final long parseRequiredLong(XmlPullParser xmlpullparser, String s)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            long l;
            try
            {
                l = Long.parseLong(xmlpullparser);
            }
            // Misplaced declaration of an exception variable
            catch (XmlPullParser xmlpullparser)
            {
                throw new ParserException(xmlpullparser);
            }
            return l;
        } else
        {
            throw new ception(s);
        }
    }

    protected final String parseRequiredString(XmlPullParser xmlpullparser, String s)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            return xmlpullparser;
        } else
        {
            throw new ception(s);
        }
    }

    protected void parseStartTag(XmlPullParser xmlpullparser)
    {
    }

    protected void parseText(XmlPullParser xmlpullparser)
    {
    }

    protected final void putNormalizedAttribute(String s, Object obj)
    {
        normalizedAttributes.add(Pair.create(s, obj));
    }

    public ception(ception ception, String s, String s1)
    {
        parent = ception;
        baseUri = s;
        tag = s1;
    }
}
