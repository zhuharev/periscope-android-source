// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import org.xmlpull.v1.XmlPullParser;

public final class ParserUtil
{

    private ParserUtil()
    {
    }

    public static boolean isEndTag(XmlPullParser xmlpullparser, String s)
    {
        return xmlpullparser.getEventType() == 3 && s.equals(xmlpullparser.getName());
    }

    public static boolean isStartTag(XmlPullParser xmlpullparser)
    {
        return xmlpullparser.getEventType() == 2;
    }

    public static boolean isStartTag(XmlPullParser xmlpullparser, String s)
    {
        return xmlpullparser.getEventType() == 2 && s.equals(xmlpullparser.getName());
    }

    public static String removeNamespacePrefix(String s)
    {
        return s.replaceFirst("^.*:", "");
    }
}
