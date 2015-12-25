// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.util.Util;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

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
            l = Util.parseXsDateTime(s);
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
