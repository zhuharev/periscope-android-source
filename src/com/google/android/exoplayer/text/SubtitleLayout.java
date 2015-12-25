// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.text:
//            CaptionStyleCompat, CuePainter, Cue

public final class SubtitleLayout extends View
{

    private static final int ABSOLUTE = 2;
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08F;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533F;
    private static final int FRACTIONAL = 0;
    private static final int FRACTIONAL_IGNORE_PADDING = 1;
    private boolean applyEmbeddedStyles;
    private float bottomPaddingFraction;
    private List cues;
    private final List painters;
    private CaptionStyleCompat style;
    private float textSize;
    private int textSizeType;

    public SubtitleLayout(Context context)
    {
        this(context, null);
    }

    public SubtitleLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        painters = new ArrayList();
        textSizeType = 0;
        textSize = 0.0533F;
        applyEmbeddedStyles = true;
        style = CaptionStyleCompat.DEFAULT;
        bottomPaddingFraction = 0.08F;
    }

    private void setTextSize(int i, float f)
    {
        if (textSizeType == i && textSize == f)
        {
            return;
        } else
        {
            textSizeType = i;
            textSize = f;
            invalidate();
            return;
        }
    }

    public final void dispatchDraw(Canvas canvas)
    {
        int i;
        if (cues == null)
        {
            i = 0;
        } else
        {
            i = cues.size();
        }
        int j = getTop();
        int l1 = getBottom();
        int l = getLeft() + getPaddingLeft();
        int i1 = j + getPaddingTop();
        int j1 = getRight() + getPaddingRight();
        int k1 = l1 - getPaddingBottom();
        if (k1 <= i1 || j1 <= l)
        {
            return;
        }
        float f;
        if (textSizeType == 2)
        {
            f = textSize;
        } else
        {
            f = textSize;
            if (textSizeType == 0)
            {
                j = k1 - i1;
            } else
            {
                j = l1 - j;
            }
            f *= j;
        }
        if (f <= 0.0F)
        {
            return;
        }
        for (int k = 0; k < i; k++)
        {
            ((CuePainter)painters.get(k)).draw((Cue)cues.get(k), applyEmbeddedStyles, style, f, bottomPaddingFraction, canvas, l, i1, j1, k1);
        }

    }

    public final void setApplyEmbeddedStyles(boolean flag)
    {
        if (applyEmbeddedStyles == flag)
        {
            return;
        } else
        {
            applyEmbeddedStyles = flag;
            invalidate();
            return;
        }
    }

    public final void setBottomPaddingFraction(float f)
    {
        if (bottomPaddingFraction == f)
        {
            return;
        } else
        {
            bottomPaddingFraction = f;
            invalidate();
            return;
        }
    }

    public final void setCues(List list)
    {
        if (cues == list)
        {
            return;
        }
        cues = list;
        int i;
        if (list == null)
        {
            i = 0;
        } else
        {
            i = list.size();
        }
        for (; painters.size() < i; painters.add(new CuePainter(getContext()))) { }
        invalidate();
    }

    public final void setFixedTextSize(int i, float f)
    {
        Object obj = getContext();
        if (obj == null)
        {
            obj = Resources.getSystem();
        } else
        {
            obj = ((Context) (obj)).getResources();
        }
        setTextSize(2, TypedValue.applyDimension(i, f, ((Resources) (obj)).getDisplayMetrics()));
    }

    public final void setFractionalTextSize(float f)
    {
        setFractionalTextSize(f, false);
    }

    public final void setFractionalTextSize(float f, boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        setTextSize(i, f);
    }

    public final void setStyle(CaptionStyleCompat captionstylecompat)
    {
        if (style == captionstylecompat)
        {
            return;
        } else
        {
            style = captionstylecompat;
            invalidate();
            return;
        }
    }
}
