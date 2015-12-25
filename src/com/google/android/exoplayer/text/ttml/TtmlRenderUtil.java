// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.ttml;

import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.Map;

// Referenced classes of package com.google.android.exoplayer.text.ttml:
//            TtmlStyle

final class TtmlRenderUtil
{

    private static final StrikethroughSpan STRIKETHROUGH_SPAN = new StrikethroughSpan();
    private static final StyleSpan STYLE_SPANS[] = {
        new StyleSpan(0), new StyleSpan(1), new StyleSpan(2), new StyleSpan(3)
    };
    private static final UnderlineSpan UNDERLINE_SPAN = new UnderlineSpan();

    private TtmlRenderUtil()
    {
    }

    public static void applyStylesToSpan(SpannableStringBuilder spannablestringbuilder, int i, int j, TtmlStyle ttmlstyle)
    {
        if (ttmlstyle.getStyle() != -1)
        {
            spannablestringbuilder.setSpan(STYLE_SPANS[ttmlstyle.getStyle()], i, j, 33);
        }
        if (ttmlstyle.isLinethrough())
        {
            spannablestringbuilder.setSpan(STRIKETHROUGH_SPAN, i, j, 33);
        }
        if (ttmlstyle.isUnderline())
        {
            spannablestringbuilder.setSpan(UNDERLINE_SPAN, i, j, 33);
        }
        if (ttmlstyle.hasColorSpecified())
        {
            spannablestringbuilder.setSpan(new ForegroundColorSpan(ttmlstyle.getColor()), i, j, 33);
        }
        if (ttmlstyle.hasBackgroundColorSpecified())
        {
            spannablestringbuilder.setSpan(new BackgroundColorSpan(ttmlstyle.getBackgroundColor()), i, j, 33);
        }
        if (ttmlstyle.getFontFamily() != null)
        {
            spannablestringbuilder.setSpan(new TypefaceSpan(ttmlstyle.getFontFamily()), i, j, 33);
        }
        if (ttmlstyle.getTextAlign() != null)
        {
            spannablestringbuilder.setSpan(new android.text.style.AlignmentSpan.Standard(ttmlstyle.getTextAlign()), i, j, 33);
        }
    }

    static String applyTextElementSpacePolicy(String s)
    {
        return s.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    static void endParagraph(SpannableStringBuilder spannablestringbuilder)
    {
        int i;
        for (i = spannablestringbuilder.length() - 1; i >= 0 && spannablestringbuilder.charAt(i) == ' '; i--) { }
        if (i >= 0 && spannablestringbuilder.charAt(i) != '\n')
        {
            spannablestringbuilder.append('\n');
        }
    }

    public static TtmlStyle resolveStyle(TtmlStyle ttmlstyle, String as[], Map map)
    {
        if (ttmlstyle == null && as == null)
        {
            return null;
        }
        if (ttmlstyle == null && as.length == 1)
        {
            return (TtmlStyle)map.get(as[0]);
        }
        if (ttmlstyle == null && as.length > 1)
        {
            ttmlstyle = new TtmlStyle();
            for (int i = 0; i < as.length; i++)
            {
                ttmlstyle.chain((TtmlStyle)map.get(as[i]));
            }

            return ttmlstyle;
        }
        if (ttmlstyle != null && as != null && as.length == 1)
        {
            return ttmlstyle.chain((TtmlStyle)map.get(as[0]));
        }
        if (ttmlstyle != null && as != null && as.length > 1)
        {
            for (int j = 0; j < as.length; j++)
            {
                ttmlstyle.chain((TtmlStyle)map.get(as[j]));
            }

            return ttmlstyle;
        } else
        {
            return ttmlstyle;
        }
    }

}
