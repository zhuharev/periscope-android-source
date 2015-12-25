// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.webvtt;

import android.text.Html;
import android.util.Log;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.text.SubtitleParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.android.exoplayer.text.webvtt:
//            WebvttCue, WebvttSubtitle

public final class WebvttParser
    implements SubtitleParser
{
    static final class PositionHolder
    {

        public int lineType;
        public float position;
        public int positionAnchor;

        private PositionHolder()
        {
        }

    }


    private static final Pattern COMMENT_BLOCK = Pattern.compile("^NOTE(( |\t).*)?$");
    private static final Pattern CUE_IDENTIFIER = Pattern.compile("^(?!.*(-->)).*$");
    private static final Pattern CUE_SETTING = Pattern.compile("\\S*:\\S*");
    private static final Pattern HEADER = Pattern.compile("^\uFEFF?WEBVTT(( |\t).*)?$");
    private static final Pattern METADATA_HEADER = Pattern.compile("\\S*[:=]\\S*");
    private static final String TAG = "WebvttParser";
    private static final Pattern TIMESTAMP = Pattern.compile("(\\d+:)?[0-5]\\d:[0-5]\\d\\.\\d{3}");
    private final PositionHolder positionHolder;
    private final boolean strictParsing;
    private final StringBuilder textBuilder;

    public WebvttParser()
    {
        this(false);
    }

    public WebvttParser(boolean flag)
    {
        strictParsing = flag;
        positionHolder = new PositionHolder();
        textBuilder = new StringBuilder();
    }

    private static int alignmentToAnchor(android.text.Layout.Alignment alignment)
    {
        if (alignment == null)
        {
            return 0x80000000;
        }
        static class _cls1
        {

            static final int $SwitchMap$android$text$Layout$Alignment[];

            static 
            {
                $SwitchMap$android$text$Layout$Alignment = new int[android.text.Layout.Alignment.values().length];
                try
                {
                    $SwitchMap$android$text$Layout$Alignment[android.text.Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    $SwitchMap$android$text$Layout$Alignment[android.text.Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$android$text$Layout$Alignment[android.text.Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
            }
        }

        switch (_cls1..SwitchMap.android.text.Layout.Alignment[alignment.ordinal()])
        {
        case 1: // '\001'
            return 0;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return 2;
        }
        Log.w("WebvttParser", (new StringBuilder("Unrecognized alignment: ")).append(alignment).toString());
        return 0;
    }

    private static void parseLineAttribute(String s, PositionHolder positionholder)
    {
        int j = s.indexOf(",");
        int i;
        if (j != -1)
        {
            i = parsePositionAnchor(s.substring(j + 1));
            s = s.substring(0, j);
        } else
        {
            i = 0x80000000;
        }
        float f;
        if (s.endsWith("%"))
        {
            f = parsePercentage(s);
            j = 0;
        } else
        {
            f = Integer.parseInt(s);
            j = 1;
        }
        positionholder.position = f;
        positionholder.positionAnchor = i;
        positionholder.lineType = j;
    }

    private static float parsePercentage(String s)
    {
        if (!s.endsWith("%"))
        {
            throw new NumberFormatException("Percentages must end with %");
        } else
        {
            return Float.parseFloat(s.substring(0, s.length() - 1)) / 100F;
        }
    }

    private static int parsePositionAnchor(String s)
    {
        byte byte0 = -1;
        switch (s.hashCode())
        {
        case 109757538: 
            if (s.equals("start"))
            {
                byte0 = 0;
            }
            break;

        case -1074341483: 
            if (s.equals("middle"))
            {
                byte0 = 1;
            }
            break;

        case 100571: 
            if (s.equals("end"))
            {
                byte0 = 2;
            }
            break;
        }
        switch (byte0)
        {
        case 0: // '\0'
            return 0;

        case 1: // '\001'
            return 1;

        case 2: // '\002'
            return 2;
        }
        Log.w("WebvttParser", (new StringBuilder("Invalid anchor value: ")).append(s).toString());
        return 0x80000000;
    }

    private static void parsePositionAttribute(String s, PositionHolder positionholder)
    {
        int j = s.indexOf(",");
        int i;
        if (j != -1)
        {
            i = parsePositionAnchor(s.substring(j + 1));
            s = s.substring(0, j);
        } else
        {
            i = 0x80000000;
        }
        positionholder.position = parsePercentage(s);
        positionholder.positionAnchor = i;
        positionholder.lineType = 0x80000000;
    }

    private static android.text.Layout.Alignment parseTextAlignment(String s)
    {
        byte byte0 = -1;
        switch (s.hashCode())
        {
        case 109757538: 
            if (s.equals("start"))
            {
                byte0 = 0;
            }
            break;

        case 3317767: 
            if (s.equals("left"))
            {
                byte0 = 1;
            }
            break;

        case -1074341483: 
            if (s.equals("middle"))
            {
                byte0 = 2;
            }
            break;

        case 100571: 
            if (s.equals("end"))
            {
                byte0 = 3;
            }
            break;

        case 108511772: 
            if (s.equals("right"))
            {
                byte0 = 4;
            }
            break;
        }
        switch (byte0)
        {
        case 0: // '\0'
        case 1: // '\001'
            return android.text.Layout.Alignment.ALIGN_NORMAL;

        case 2: // '\002'
            return android.text.Layout.Alignment.ALIGN_CENTER;

        case 3: // '\003'
        case 4: // '\004'
            return android.text.Layout.Alignment.ALIGN_OPPOSITE;
        }
        Log.w("WebvttParser", (new StringBuilder("Invalid alignment value: ")).append(s).toString());
        return null;
    }

    private static long parseTimestampUs(String s)
    {
        long l = 0L;
        s = s.split("\\.", 2);
        String as[] = s[0].split(":");
        for (int i = 0; i < as.length; i++)
        {
            l = 60L * l + Long.parseLong(as[i]);
        }

        return (1000L * l + Long.parseLong(s[1])) * 1000L;
    }

    public final boolean canParse(String s)
    {
        return "text/vtt".equals(s);
    }

    public final volatile Subtitle parse(InputStream inputstream)
    {
        return parse(inputstream);
    }

    public final WebvttSubtitle parse(InputStream inputstream)
    {
        ArrayList arraylist;
        BufferedReader bufferedreader;
label0:
        {
            arraylist = new ArrayList();
            bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
            inputstream = bufferedreader.readLine();
            if (inputstream == null || !HEADER.matcher(inputstream).matches())
            {
                throw new ParserException((new StringBuilder("Expected WEBVTT. Got ")).append(inputstream).toString());
            }
            do
            {
                inputstream = bufferedreader.readLine();
                if (inputstream == null)
                {
                    throw new ParserException("Expected an empty line after webvtt header");
                }
                if (inputstream.isEmpty())
                {
                    break label0;
                }
            } while (!strictParsing || METADATA_HEADER.matcher(inputstream).find());
            throw new ParserException((new StringBuilder("Unexpected line: ")).append(inputstream).toString());
        }
_L4:
        float f;
        float f2;
        float f4;
        Object obj1;
        int i;
        int j;
        int i1;
        long l1;
        long l2;
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (COMMENT_BLOCK.matcher(s).find())
        {
            do
            {
                inputstream = bufferedreader.readLine();
            } while (inputstream != null && !inputstream.isEmpty());
            continue; /* Loop/switch isn't completed */
        }
        inputstream = s;
        if (CUE_IDENTIFIER.matcher(s).find())
        {
            inputstream = bufferedreader.readLine();
            if (inputstream == null)
            {
                break; /* Loop/switch isn't completed */
            }
        }
        s = null;
        f2 = 1.401298E-45F;
        j = 0x80000000;
        i1 = 0x80000000;
        f = 1.401298E-45F;
        i = 0x80000000;
        f4 = 1.401298E-45F;
        obj1 = TIMESTAMP.matcher(inputstream);
        if (!((Matcher) (obj1)).find())
        {
            throw new ParserException((new StringBuilder("Expected cue start time: ")).append(inputstream).toString());
        }
        l1 = parseTimestampUs(((Matcher) (obj1)).group());
        if (!((Matcher) (obj1)).find())
        {
            throw new ParserException((new StringBuilder("Expected cue end time: ")).append(inputstream).toString());
        }
        obj1 = ((Matcher) (obj1)).group();
        l2 = parseTimestampUs(((String) (obj1)));
        inputstream = inputstream.substring(inputstream.indexOf(((String) (obj1))) + ((String) (obj1)).length());
        obj1 = CUE_SETTING.matcher(inputstream);
        inputstream = s;
_L2:
        float f1;
        float f3;
        Object obj;
        String s2;
        String s3;
        int k;
        if (!((Matcher) (obj1)).find())
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = ((Matcher) (obj1)).group();
        String as[] = s2.split(":", 2);
        obj = as[0];
        s3 = as[1];
        f1 = f2;
        k = j;
        f3 = f;
        if (!"line".equals(obj))
        {
            break MISSING_BLOCK_LABEL_526;
        }
        f1 = f2;
        k = j;
        f3 = f;
        parseLineAttribute(s3, positionHolder);
        f1 = f2;
        k = j;
        f3 = f;
        f2 = positionHolder.position;
        f1 = f2;
        k = j;
        f3 = f;
        j = positionHolder.lineType;
        f1 = f2;
        k = j;
        f3 = f;
        int j1 = positionHolder.positionAnchor;
        f1 = f2;
        i1 = j1;
        break MISSING_BLOCK_LABEL_799;
        f1 = f2;
        k = j;
        f3 = f;
        if (!"align".equals(obj))
        {
            break MISSING_BLOCK_LABEL_573;
        }
        f1 = f2;
        k = j;
        f3 = f;
        obj = parseTextAlignment(s3);
        inputstream = ((InputStream) (obj));
        f1 = f2;
        break MISSING_BLOCK_LABEL_799;
        f1 = f2;
        k = j;
        f3 = f;
        if (!"position".equals(obj))
        {
            break MISSING_BLOCK_LABEL_660;
        }
        f1 = f2;
        k = j;
        f3 = f;
        parsePositionAttribute(s3, positionHolder);
        f1 = f2;
        k = j;
        f3 = f;
        f = positionHolder.position;
        f1 = f2;
        k = j;
        f3 = f;
        j1 = positionHolder.positionAnchor;
        f1 = f2;
        i = j1;
        break MISSING_BLOCK_LABEL_799;
        f1 = f2;
        k = j;
        f3 = f;
        if (!"size".equals(obj))
        {
            break MISSING_BLOCK_LABEL_708;
        }
        f1 = f2;
        k = j;
        f3 = f;
        float f5 = parsePercentage(s3);
        f1 = f2;
        f4 = f5;
        break MISSING_BLOCK_LABEL_799;
        f1 = f2;
        k = j;
        f3 = f;
        try
        {
            Log.w("WebvttParser", (new StringBuilder("Unknown cue setting ")).append(((String) (obj))).append(":").append(s3).toString());
            continue; /* Loop/switch isn't completed */
        }
        catch (NumberFormatException numberformatexception)
        {
            Log.w("WebvttParser", (new StringBuilder()).append(numberformatexception.getMessage()).append(": ").append(s2).toString());
            f = f3;
            j = k;
        }
        f2 = f1;
        if (true) goto _L2; else goto _L1
_L1:
        int l = i;
        if (f != 1.401298E-45F)
        {
            l = i;
            if (i == 0x80000000)
            {
                l = alignmentToAnchor(inputstream);
            }
        }
        textBuilder.setLength(0);
        do
        {
            String s1 = bufferedreader.readLine();
            if (s1 == null || s1.isEmpty())
            {
                break;
            }
            if (textBuilder.length() > 0)
            {
                textBuilder.append("<br>");
            }
            textBuilder.append(s1.trim());
        } while (true);
        arraylist.add(new WebvttCue(l1, l2, Html.fromHtml(textBuilder.toString()), inputstream, f2, j, i1, f, l, f4));
        if (true) goto _L4; else goto _L3
_L3:
        return new WebvttSubtitle(arraylist);
    }

}
