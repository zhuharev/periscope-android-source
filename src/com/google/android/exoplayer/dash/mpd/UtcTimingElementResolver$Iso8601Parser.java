// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.ParserException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            UtcTimingElementResolver

static class <init>
    implements com.google.android.exoplayer.upstream.<init>
{

    public Long parse(String s, InputStream inputstream)
    {
        s = (new BufferedReader(new InputStreamReader(inputstream))).readLine();
        long l;
        try
        {
            inputstream = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            inputstream.setTimeZone(TimeZone.getTimeZone("UTC"));
            l = inputstream.parse(s).getTime();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ParserException(s);
        }
        return Long.valueOf(l);
    }

    public volatile Object parse(String s, InputStream inputstream)
    {
        return parse(s, inputstream);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
