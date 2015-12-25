// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.ttml;

import com.google.android.exoplayer.util.Assertions;

public final class TtmlStyle
{

    private static final short OFF = 0;
    private static final short ON = 1;
    public static final short STYLE_BOLD = 1;
    public static final short STYLE_BOLD_ITALIC = 3;
    public static final short STYLE_ITALIC = 2;
    public static final short STYLE_NORMAL = 0;
    public static final short UNSPECIFIED = -1;
    private int backgroundColor;
    private boolean backgroundColorSpecified;
    private short bold;
    private int color;
    private boolean colorSpecified;
    private String fontFamily;
    private String id;
    private TtmlStyle inheritableStyle;
    private short italic;
    private short linethrough;
    private android.text.Layout.Alignment textAlign;
    private short underline;

    public TtmlStyle()
    {
        linethrough = -1;
        underline = -1;
        bold = -1;
        italic = -1;
    }

    private TtmlStyle inherit(TtmlStyle ttmlstyle, boolean flag)
    {
        if (ttmlstyle != null)
        {
            if (!colorSpecified && ttmlstyle.colorSpecified)
            {
                setColor(ttmlstyle.color);
            }
            if (bold == -1)
            {
                bold = ttmlstyle.bold;
            }
            if (italic == -1)
            {
                italic = ttmlstyle.italic;
            }
            if (fontFamily == null)
            {
                fontFamily = ttmlstyle.fontFamily;
            }
            if (linethrough == -1)
            {
                linethrough = ttmlstyle.linethrough;
            }
            if (underline == -1)
            {
                underline = ttmlstyle.underline;
            }
            if (textAlign == null)
            {
                textAlign = ttmlstyle.textAlign;
            }
            if (flag && !backgroundColorSpecified && ttmlstyle.backgroundColorSpecified)
            {
                setBackgroundColor(ttmlstyle.backgroundColor);
            }
        }
        return this;
    }

    private boolean isFullyInheritable()
    {
        return !backgroundColorSpecified;
    }

    public final TtmlStyle chain(TtmlStyle ttmlstyle)
    {
        return inherit(ttmlstyle, true);
    }

    public final int getBackgroundColor()
    {
        return backgroundColor;
    }

    public final int getColor()
    {
        return color;
    }

    public final String getFontFamily()
    {
        return fontFamily;
    }

    public final String getId()
    {
        return id;
    }

    public final TtmlStyle getInheritableStyle()
    {
        if (isFullyInheritable())
        {
            return this;
        }
        if (inheritableStyle == null)
        {
            inheritableStyle = (new TtmlStyle()).inherit(this);
        }
        return inheritableStyle;
    }

    public final short getStyle()
    {
        if (bold == -1 && italic == -1)
        {
            return -1;
        }
        short word0 = 0;
        if (bold != -1)
        {
            word0 = (short)(bold + 0);
        }
        short word1 = word0;
        if (italic != -1)
        {
            word1 = (short)(italic + word0);
        }
        return word1;
    }

    public final android.text.Layout.Alignment getTextAlign()
    {
        return textAlign;
    }

    public final boolean hasBackgroundColorSpecified()
    {
        return backgroundColorSpecified;
    }

    public final boolean hasColorSpecified()
    {
        return colorSpecified;
    }

    public final TtmlStyle inherit(TtmlStyle ttmlstyle)
    {
        return inherit(ttmlstyle, false);
    }

    public final boolean isLinethrough()
    {
        return linethrough == 1;
    }

    public final boolean isUnderline()
    {
        return underline == 1;
    }

    public final TtmlStyle setBackgroundColor(int i)
    {
        backgroundColor = i;
        backgroundColorSpecified = true;
        return this;
    }

    public final TtmlStyle setBold(boolean flag)
    {
        boolean flag1;
        if (inheritableStyle == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        short word0;
        if (flag)
        {
            word0 = 1;
        } else
        {
            word0 = 0;
        }
        bold = word0;
        return this;
    }

    public final TtmlStyle setColor(int i)
    {
        boolean flag;
        if (inheritableStyle == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        color = i;
        colorSpecified = true;
        return this;
    }

    public final TtmlStyle setFontFamily(String s)
    {
        boolean flag;
        if (inheritableStyle == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        fontFamily = s;
        return this;
    }

    public final TtmlStyle setId(String s)
    {
        id = s;
        return this;
    }

    public final TtmlStyle setItalic(boolean flag)
    {
        boolean flag1;
        if (inheritableStyle == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        short word0;
        if (flag)
        {
            word0 = 2;
        } else
        {
            word0 = 0;
        }
        italic = word0;
        return this;
    }

    public final TtmlStyle setLinethrough(boolean flag)
    {
        boolean flag1;
        if (inheritableStyle == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        short word0;
        if (flag)
        {
            word0 = 1;
        } else
        {
            word0 = 0;
        }
        linethrough = word0;
        return this;
    }

    public final TtmlStyle setTextAlign(android.text.Layout.Alignment alignment)
    {
        textAlign = alignment;
        return this;
    }

    public final TtmlStyle setUnderline(boolean flag)
    {
        boolean flag1;
        if (inheritableStyle == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        short word0;
        if (flag)
        {
            word0 = 1;
        } else
        {
            word0 = 0;
        }
        underline = word0;
        return this;
    }
}
