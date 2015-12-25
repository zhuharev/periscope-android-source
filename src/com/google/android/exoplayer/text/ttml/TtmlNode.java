// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.ttml;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

// Referenced classes of package com.google.android.exoplayer.text.ttml:
//            TtmlRenderUtil, TtmlStyle

final class TtmlNode
{

    public static final String ATTR_ID = "id";
    public static final String ATTR_TTS_BACKGROUND_COLOR = "backgroundColor";
    public static final String ATTR_TTS_COLOR = "color";
    public static final String ATTR_TTS_FONT_FAMILY = "fontFamily";
    public static final String ATTR_TTS_FONT_SIZE = "fontSize";
    public static final String ATTR_TTS_FONT_STYLE = "fontStyle";
    public static final String ATTR_TTS_FONT_WEIGHT = "fontWeight";
    public static final String ATTR_TTS_TEXT_ALIGN = "textAlign";
    public static final String ATTR_TTS_TEXT_DECORATION = "textDecoration";
    public static final String BOLD = "bold";
    public static final String CENTER = "center";
    public static final String END = "end";
    public static final String ITALIC = "italic";
    public static final String LEFT = "left";
    public static final String LINETHROUGH = "linethrough";
    public static final String NO_LINETHROUGH = "nolinethrough";
    public static final String NO_UNDERLINE = "nounderline";
    public static final String RIGHT = "right";
    public static final String START = "start";
    public static final String TAG_BODY = "body";
    public static final String TAG_BR = "br";
    public static final String TAG_DIV = "div";
    public static final String TAG_HEAD = "head";
    public static final String TAG_LAYOUT = "layout";
    public static final String TAG_METADATA = "metadata";
    public static final String TAG_P = "p";
    public static final String TAG_REGION = "region";
    public static final String TAG_SMPTE_DATA = "smpte:data";
    public static final String TAG_SMPTE_IMAGE = "smpte:image";
    public static final String TAG_SMPTE_INFORMATION = "smpte:information";
    public static final String TAG_SPAN = "span";
    public static final String TAG_STYLE = "style";
    public static final String TAG_STYLING = "styling";
    public static final String TAG_TT = "tt";
    public static final long UNDEFINED_TIME = -1L;
    public static final String UNDERLINE = "underline";
    private List children;
    private int end;
    public final long endTimeUs;
    public final boolean isTextNode;
    private int start;
    public final long startTimeUs;
    public final TtmlStyle style;
    private String styleIds[];
    public final String tag;
    public final String text;

    private TtmlNode(String s, String s1, long l, long l1, TtmlStyle ttmlstyle, 
            String as[])
    {
        tag = s;
        text = s1;
        style = ttmlstyle;
        styleIds = as;
        boolean flag;
        if (s1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isTextNode = flag;
        startTimeUs = l;
        endTimeUs = l1;
    }

    public static TtmlNode buildNode(String s, long l, long l1, TtmlStyle ttmlstyle, String as[])
    {
        return new TtmlNode(s, null, l, l1, ttmlstyle, as);
    }

    public static TtmlNode buildTextNode(String s)
    {
        return new TtmlNode(null, TtmlRenderUtil.applyTextElementSpacePolicy(s), -1L, -1L, null, null);
    }

    private void getEventTimes(TreeSet treeset, boolean flag)
    {
        boolean flag2 = "p".equals(tag);
        if (flag || flag2)
        {
            if (startTimeUs != -1L)
            {
                treeset.add(Long.valueOf(startTimeUs));
            }
            if (endTimeUs != -1L)
            {
                treeset.add(Long.valueOf(endTimeUs));
            }
        }
        if (children == null)
        {
            return;
        }
        for (int i = 0; i < children.size(); i++)
        {
            TtmlNode ttmlnode = (TtmlNode)children.get(i);
            boolean flag1;
            if (flag || flag2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ttmlnode.getEventTimes(treeset, flag1);
        }

    }

    private void traverseForStyle(SpannableStringBuilder spannablestringbuilder, Map map)
    {
        if (start != end)
        {
            TtmlStyle ttmlstyle = TtmlRenderUtil.resolveStyle(style, styleIds, map);
            if (ttmlstyle != null)
            {
                TtmlRenderUtil.applyStylesToSpan(spannablestringbuilder, start, end, ttmlstyle);
            }
            for (int i = 0; i < getChildCount(); i++)
            {
                getChild(i).traverseForStyle(spannablestringbuilder, map);
            }

        }
    }

    private SpannableStringBuilder traverseForText(long l, SpannableStringBuilder spannablestringbuilder, boolean flag)
    {
        start = spannablestringbuilder.length();
        end = start;
        if (isTextNode && flag)
        {
            spannablestringbuilder.append(text);
            return spannablestringbuilder;
        }
        if ("br".equals(tag) && flag)
        {
            spannablestringbuilder.append('\n');
            return spannablestringbuilder;
        }
        if (!"metadata".equals(tag) && isActive(l))
        {
            boolean flag2 = "p".equals(tag);
            for (int i = 0; i < getChildCount(); i++)
            {
                TtmlNode ttmlnode = getChild(i);
                boolean flag1;
                if (flag || flag2)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                ttmlnode.traverseForText(l, spannablestringbuilder, flag1);
            }

            if (flag2)
            {
                TtmlRenderUtil.endParagraph(spannablestringbuilder);
            }
            end = spannablestringbuilder.length();
        }
        return spannablestringbuilder;
    }

    public final void addChild(TtmlNode ttmlnode)
    {
        if (children == null)
        {
            children = new ArrayList();
        }
        children.add(ttmlnode);
    }

    public final TtmlNode getChild(int i)
    {
        if (children == null)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return (TtmlNode)children.get(i);
        }
    }

    public final int getChildCount()
    {
        if (children == null)
        {
            return 0;
        } else
        {
            return children.size();
        }
    }

    public final long[] getEventTimesUs()
    {
        Object obj = new TreeSet();
        getEventTimes(((TreeSet) (obj)), false);
        long al[] = new long[((TreeSet) (obj)).size()];
        obj = ((TreeSet) (obj)).iterator();
        int j;
        for (int i = 0; ((Iterator) (obj)).hasNext(); i = j)
        {
            long l = ((Long)((Iterator) (obj)).next()).longValue();
            j = i + 1;
            al[i] = l;
        }

        return al;
    }

    public final String[] getStyleIds()
    {
        return styleIds;
    }

    public final CharSequence getText(long l, Map map)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        traverseForText(l, spannablestringbuilder, false);
        traverseForStyle(spannablestringbuilder, map);
        int i = spannablestringbuilder.length();
        int j1;
        for (int k = 0; k < i; i = j1)
        {
            j1 = i;
            if (spannablestringbuilder.charAt(k) == ' ')
            {
                for (j1 = k + 1; j1 < spannablestringbuilder.length() && spannablestringbuilder.charAt(j1) == ' '; j1++) { }
                int i2 = j1 - (k + 1);
                j1 = i;
                if (i2 > 0)
                {
                    spannablestringbuilder.delete(k, k + i2);
                    j1 = i - i2;
                }
            }
            k++;
        }

        int i1 = i;
        if (i > 0)
        {
            i1 = i;
            if (spannablestringbuilder.charAt(0) == ' ')
            {
                spannablestringbuilder.delete(0, 1);
                i1 = i - 1;
            }
        }
        int k1 = 0;
        for (i = i1; k1 < i - 1; i = i1)
        {
            i1 = i;
            if (spannablestringbuilder.charAt(k1) == '\n')
            {
                i1 = i;
                if (spannablestringbuilder.charAt(k1 + 1) == ' ')
                {
                    spannablestringbuilder.delete(k1 + 1, k1 + 2);
                    i1 = i - 1;
                }
            }
            k1++;
        }

        i1 = i;
        if (i > 0)
        {
            i1 = i;
            if (spannablestringbuilder.charAt(i - 1) == ' ')
            {
                spannablestringbuilder.delete(i - 1, i);
                i1 = i - 1;
            }
        }
        int l1;
        for (int j = 0; j < i1 - 1; i1 = l1)
        {
            l1 = i1;
            if (spannablestringbuilder.charAt(j) == ' ')
            {
                l1 = i1;
                if (spannablestringbuilder.charAt(j + 1) == '\n')
                {
                    spannablestringbuilder.delete(j, j + 1);
                    l1 = i1 - 1;
                }
            }
            j++;
        }

        if (i1 > 0 && spannablestringbuilder.charAt(i1 - 1) == '\n')
        {
            spannablestringbuilder.delete(i1 - 1, i1);
        }
        return spannablestringbuilder;
    }

    public final boolean isActive(long l)
    {
        return startTimeUs == -1L && endTimeUs == -1L || startTimeUs <= l && endTimeUs == -1L || startTimeUs == -1L && l < endTimeUs || startTimeUs <= l && l < endTimeUs;
    }
}
