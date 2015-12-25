// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class HttpDate
{

    private static final DateFormat BROWSER_COMPATIBLE_DATE_FORMATS[];
    private static final String BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[];
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final ThreadLocal STANDARD_DATE_FORMAT = new _cls1();

    private HttpDate()
    {
    }

    public static String format(Date date)
    {
        return ((DateFormat)STANDARD_DATE_FORMAT.get()).format(date);
    }

    public static Date parse(String s)
    {
        ParsePosition parseposition;
        if (s.length() == 0)
        {
            return null;
        }
        parseposition = new ParsePosition(0);
        Date date = ((DateFormat)STANDARD_DATE_FORMAT.get()).parse(s, parseposition);
        if (parseposition.getIndex() == s.length())
        {
            return date;
        }
        String as[] = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        as;
        JVM INSTR monitorenter ;
        int i = 0;
        int j = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        DateFormat dateformat = BROWSER_COMPATIBLE_DATE_FORMATS[i];
        Object obj;
        obj = dateformat;
        if (dateformat != null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        obj = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i], Locale.US);
        ((DateFormat) (obj)).setTimeZone(GMT);
        BROWSER_COMPATIBLE_DATE_FORMATS[i] = ((DateFormat) (obj));
        int k;
        parseposition.setIndex(0);
        obj = ((DateFormat) (obj)).parse(s, parseposition);
        k = parseposition.getIndex();
        if (k == 0)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        as;
        JVM INSTR monitorexit ;
        return ((Date) (obj));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        break MISSING_BLOCK_LABEL_163;
        s;
        throw s;
        return null;
    }

    static 
    {
        String as[] = new String[15];
        as[0] = "EEE, dd MMM yyyy HH:mm:ss zzz";
        as[1] = "EEEE, dd-MMM-yy HH:mm:ss zzz";
        as[2] = "EEE MMM d HH:mm:ss yyyy";
        as[3] = "EEE, dd-MMM-yyyy HH:mm:ss z";
        as[4] = "EEE, dd-MMM-yyyy HH-mm-ss z";
        as[5] = "EEE, dd MMM yy HH:mm:ss z";
        as[6] = "EEE dd-MMM-yyyy HH:mm:ss z";
        as[7] = "EEE dd MMM yyyy HH:mm:ss z";
        as[8] = "EEE dd-MMM-yyyy HH-mm-ss z";
        as[9] = "EEE dd-MMM-yy HH:mm:ss z";
        as[10] = "EEE dd MMM yy HH:mm:ss z";
        as[11] = "EEE,dd-MMM-yy HH:mm:ss z";
        as[12] = "EEE,dd-MMM-yyyy HH:mm:ss z";
        as[13] = "EEE, dd-MM-yyyy HH:mm:ss z";
        as[14] = "EEE MMM d yyyy HH:mm:ss z";
        BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = as;
        BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[as.length];
    }


    private class _cls1 extends ThreadLocal
    {

        protected final volatile Object initialValue()
        {
            return initialValue();
        }

        protected final DateFormat initialValue()
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpledateformat.setLenient(false);
            simpledateformat.setTimeZone(HttpDate.GMT);
            return simpledateformat;
        }

        _cls1()
        {
        }
    }

}
