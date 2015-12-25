// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            Slf4jReporter

public static final class  extends Enum
{

    private static final ERROR $VALUES[];
    public static final ERROR DEBUG;
    public static final ERROR ERROR;
    public static final ERROR INFO;
    public static final ERROR TRACE;
    public static final ERROR WARN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/codahale/metrics/Slf4jReporter$LoggingLevel, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TRACE = new <init>("TRACE", 0);
        DEBUG = new <init>("DEBUG", 1);
        INFO = new <init>("INFO", 2);
        WARN = new <init>("WARN", 3);
        ERROR = new <init>("ERROR", 4);
        $VALUES = (new .VALUES[] {
            TRACE, DEBUG, INFO, WARN, ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
