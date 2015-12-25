// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.ParserException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class HlsParserUtil
{

    private static final String BOOLEAN_NO = "NO";
    private static final String BOOLEAN_YES = "YES";

    private HlsParserUtil()
    {
    }

    public static Pattern compileBooleanAttrPattern(String s)
    {
        return Pattern.compile((new StringBuilder()).append(s).append("=(YES").append("|NO").append(")").toString());
    }

    public static double parseDoubleAttr(String s, Pattern pattern, String s1)
    {
        return Double.parseDouble(parseStringAttr(s, pattern, s1));
    }

    public static int parseIntAttr(String s, Pattern pattern, String s1)
    {
        return Integer.parseInt(parseStringAttr(s, pattern, s1));
    }

    public static boolean parseOptionalBooleanAttr(String s, Pattern pattern)
    {
        s = pattern.matcher(s);
        if (s.find())
        {
            return "YES".equals(s.group(1));
        } else
        {
            return false;
        }
    }

    public static String parseOptionalStringAttr(String s, Pattern pattern)
    {
        s = pattern.matcher(s);
        if (s.find())
        {
            return s.group(1);
        } else
        {
            return null;
        }
    }

    public static String parseStringAttr(String s, Pattern pattern, String s1)
    {
        pattern = pattern.matcher(s);
        if (pattern.find() && pattern.groupCount() == 1)
        {
            return pattern.group(1);
        } else
        {
            throw new ParserException((new StringBuilder("Couldn't match ")).append(s1).append(" tag in ").append(s).toString());
        }
    }
}
