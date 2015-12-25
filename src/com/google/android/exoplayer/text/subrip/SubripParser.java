// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.subrip;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.text.SubtitleParser;
import com.google.android.exoplayer.util.LongArray;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.android.exoplayer.text.subrip:
//            SubripSubtitle

public final class SubripParser
    implements SubtitleParser
{

    private static final Pattern SUBRIP_TIMESTAMP = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+),(\\d+)");
    private static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("(\\S*)\\s*-->\\s*(\\S*)");
    private static final String TAG = "SubripParser";
    private final boolean strictParsing;
    private final StringBuilder textBuilder;

    public SubripParser()
    {
        this(false);
    }

    public SubripParser(boolean flag)
    {
        strictParsing = flag;
        textBuilder = new StringBuilder();
    }

    private static long parseTimecode(String s)
    {
        s = SUBRIP_TIMESTAMP.matcher(s);
        if (!s.matches())
        {
            throw new NumberFormatException("has invalid format");
        } else
        {
            return (Long.parseLong(s.group(1)) * 60L * 60L * 1000L + Long.parseLong(s.group(2)) * 60L * 1000L + Long.parseLong(s.group(3)) * 1000L + Long.parseLong(s.group(4))) * 1000L;
        }
    }

    public final boolean canParse(String s)
    {
        return "application/x-subrip".equals(s);
    }

    public final volatile Subtitle parse(InputStream inputstream)
    {
        return parse(inputstream);
    }

    public final SubripSubtitle parse(InputStream inputstream)
    {
        ArrayList arraylist;
        LongArray longarray;
        arraylist = new ArrayList();
        longarray = new LongArray();
        inputstream = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
_L4:
        String s = inputstream.readLine();
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.length() == 0) goto _L4; else goto _L3
_L3:
        Integer.parseInt(s);
          goto _L5
_L6:
        if (!strictParsing)
        {
            Log.w("SubripParser", (new StringBuilder("Skipping invalid index: ")).append(s).toString());
        } else
        {
            throw new ParserException((new StringBuilder("Expected numeric counter: ")).append(s).toString());
        }
          goto _L4
_L5:
        boolean flag;
label0:
        {
            flag = false;
            String s1 = inputstream.readLine();
            Matcher matcher = SUBRIP_TIMING_LINE.matcher(s1);
            if (matcher.find())
            {
                longarray.add(parseTimecode(matcher.group(1)));
                if (!TextUtils.isEmpty(matcher.group(2)))
                {
                    flag = true;
                    longarray.add(parseTimecode(matcher.group(2)));
                }
                break label0;
            }
            if (!strictParsing)
            {
                Log.w("SubripParser", (new StringBuilder("Skipping invalid timing: ")).append(s1).toString());
            } else
            {
                throw new ParserException((new StringBuilder("Expected timing line: ")).append(s1).toString());
            }
        }
          goto _L4
        textBuilder.setLength(0);
        do
        {
            String s2 = inputstream.readLine();
            if (TextUtils.isEmpty(s2))
            {
                break;
            }
            if (textBuilder.length() > 0)
            {
                textBuilder.append("<br>");
            }
            textBuilder.append(s2.trim());
        } while (true);
        arraylist.add(new Cue(Html.fromHtml(textBuilder.toString())));
        if (flag)
        {
            arraylist.add(null);
        }
          goto _L4
_L2:
        inputstream = new Cue[arraylist.size()];
        arraylist.toArray(inputstream);
        return new SubripSubtitle(inputstream, longarray.toArray());
        NumberFormatException numberformatexception;
        numberformatexception;
          goto _L6
    }

}
