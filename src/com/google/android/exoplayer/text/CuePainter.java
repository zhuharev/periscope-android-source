// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.exoplayer.util.Util;

// Referenced classes of package com.google.android.exoplayer.text:
//            Cue, CaptionStyleCompat

final class CuePainter
{

    private static final float INNER_PADDING_RATIO = 0.125F;
    private static final String TAG = "CuePainter";
    private boolean applyEmbeddedStyles;
    private int backgroundColor;
    private float bottomPaddingFraction;
    private final float cornerRadius;
    private float cueLine;
    private int cueLineAnchor;
    private int cueLineType;
    private float cuePosition;
    private int cuePositionAnchor;
    private float cueSize;
    private CharSequence cueText;
    private android.text.Layout.Alignment cueTextAlignment;
    private int edgeColor;
    private int edgeType;
    private int foregroundColor;
    private final RectF lineBounds = new RectF();
    private final float outlineWidth;
    private final Paint paint = new Paint();
    private int parentBottom;
    private int parentLeft;
    private int parentRight;
    private int parentTop;
    private final float shadowOffset;
    private final float shadowRadius;
    private final float spacingAdd;
    private final float spacingMult;
    private StaticLayout textLayout;
    private int textLeft;
    private int textPaddingX;
    private final TextPaint textPaint = new TextPaint();
    private float textSizePx;
    private int textTop;
    private int windowColor;

    public CuePainter(Context context)
    {
        TypedArray typedarray = context.obtainStyledAttributes(null, new int[] {
            0x1010217, 0x1010218
        }, 0, 0);
        spacingAdd = typedarray.getDimensionPixelSize(0, 0);
        spacingMult = typedarray.getFloat(1, 1.0F);
        typedarray.recycle();
        int i = Math.round(((float)context.getResources().getDisplayMetrics().densityDpi * 2.0F) / 160F);
        cornerRadius = i;
        outlineWidth = i;
        shadowRadius = i;
        shadowOffset = i;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setStyle(android.graphics.Paint.Style.FILL);
    }

    private static boolean areCharSequencesEqual(CharSequence charsequence, CharSequence charsequence1)
    {
        return charsequence == charsequence1 || charsequence != null && charsequence.equals(charsequence1);
    }

    private void drawLayout(Canvas canvas)
    {
        StaticLayout staticlayout = textLayout;
        if (staticlayout == null)
        {
            return;
        }
        int i1 = canvas.save();
        canvas.translate(textLeft, textTop);
        if (Color.alpha(windowColor) > 0)
        {
            paint.setColor(windowColor);
            canvas.drawRect(-textPaddingX, 0.0F, staticlayout.getWidth() + textPaddingX, staticlayout.getHeight(), paint);
        }
        if (Color.alpha(backgroundColor) > 0)
        {
            paint.setColor(backgroundColor);
            float f = staticlayout.getLineTop(0);
            int k = staticlayout.getLineCount();
            for (int i = 0; i < k; i++)
            {
                lineBounds.left = staticlayout.getLineLeft(i) - (float)textPaddingX;
                lineBounds.right = staticlayout.getLineRight(i) + (float)textPaddingX;
                lineBounds.top = f;
                lineBounds.bottom = staticlayout.getLineBottom(i);
                f = lineBounds.bottom;
                canvas.drawRoundRect(lineBounds, cornerRadius, cornerRadius, paint);
            }

        }
        if (edgeType == 1)
        {
            textPaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
            textPaint.setStrokeWidth(outlineWidth);
            textPaint.setColor(edgeColor);
            textPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            staticlayout.draw(canvas);
        } else
        if (edgeType == 2)
        {
            textPaint.setShadowLayer(shadowRadius, shadowOffset, shadowOffset, edgeColor);
        } else
        if (edgeType == 3 || edgeType == 4)
        {
            boolean flag;
            if (edgeType == 3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            int j;
            if (flag)
            {
                j = -1;
            } else
            {
                j = edgeColor;
            }
            int l;
            if (flag)
            {
                l = edgeColor;
            } else
            {
                l = -1;
            }
            float f1 = shadowRadius / 2.0F;
            textPaint.setColor(foregroundColor);
            textPaint.setStyle(android.graphics.Paint.Style.FILL);
            textPaint.setShadowLayer(shadowRadius, -f1, -f1, j);
            staticlayout.draw(canvas);
            textPaint.setShadowLayer(shadowRadius, f1, f1, l);
        }
        textPaint.setColor(foregroundColor);
        textPaint.setStyle(android.graphics.Paint.Style.FILL);
        staticlayout.draw(canvas);
        textPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        canvas.restoreToCount(i1);
    }

    public final void draw(Cue cue, boolean flag, CaptionStyleCompat captionstylecompat, float f, float f1, Canvas canvas, int i, 
            int j, int k, int l)
    {
        CharSequence charsequence = cue.text;
        if (TextUtils.isEmpty(charsequence))
        {
            return;
        }
        Object obj = charsequence;
        if (!flag)
        {
            obj = charsequence.toString();
        }
        if (areCharSequencesEqual(cueText, ((CharSequence) (obj))) && Util.areEqual(cueTextAlignment, cue.textAlignment) && cueLine == cue.line && cueLineType == cue.lineType && Util.areEqual(Integer.valueOf(cueLineAnchor), Integer.valueOf(cue.lineAnchor)) && cuePosition == cue.position && Util.areEqual(Integer.valueOf(cuePositionAnchor), Integer.valueOf(cue.positionAnchor)) && cueSize == cue.size && applyEmbeddedStyles == flag && foregroundColor == captionstylecompat.foregroundColor && backgroundColor == captionstylecompat.backgroundColor && windowColor == captionstylecompat.windowColor && edgeType == captionstylecompat.edgeType && edgeColor == captionstylecompat.edgeColor && Util.areEqual(textPaint.getTypeface(), captionstylecompat.typeface) && textSizePx == f && bottomPaddingFraction == f1 && parentLeft == i && parentTop == j && parentRight == k && parentBottom == l)
        {
            drawLayout(canvas);
            return;
        }
        cueText = ((CharSequence) (obj));
        cueTextAlignment = cue.textAlignment;
        cueLine = cue.line;
        cueLineType = cue.lineType;
        cueLineAnchor = cue.lineAnchor;
        cuePosition = cue.position;
        cuePositionAnchor = cue.positionAnchor;
        cueSize = cue.size;
        applyEmbeddedStyles = flag;
        foregroundColor = captionstylecompat.foregroundColor;
        backgroundColor = captionstylecompat.backgroundColor;
        windowColor = captionstylecompat.windowColor;
        edgeType = captionstylecompat.edgeType;
        edgeColor = captionstylecompat.edgeColor;
        textPaint.setTypeface(captionstylecompat.typeface);
        textSizePx = f;
        bottomPaddingFraction = f1;
        parentLeft = i;
        parentTop = j;
        parentRight = k;
        parentBottom = l;
        k = parentRight - parentLeft;
        l = parentBottom - parentTop;
        textPaint.setTextSize(f);
        int i1 = (int)(0.125F * f + 0.5F);
        j = k - (i1 << 1);
        i = j;
        if (cueSize != 1.401298E-45F)
        {
            i = (int)((float)j * cueSize);
        }
        if (i <= 0)
        {
            Log.w("CuePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (cueTextAlignment == null)
        {
            cue = android.text.Layout.Alignment.ALIGN_CENTER;
        } else
        {
            cue = cueTextAlignment;
        }
        textLayout = new StaticLayout(((CharSequence) (obj)), textPaint, i, cue, spacingMult, spacingAdd, true);
        int j1 = textLayout.getHeight();
        j = 0;
        int k1 = textLayout.getLineCount();
        for (i = 0; i < k1; i++)
        {
            j = Math.max((int)Math.ceil(textLayout.getLineWidth(i)), j);
        }

        j += i1 << 1;
        if (cuePosition != 1.401298E-45F)
        {
            i = Math.round((float)k * cuePosition) + parentLeft;
            if (cuePositionAnchor == 2)
            {
                i -= j;
            } else
            if (cuePositionAnchor == 1)
            {
                i = ((i << 1) - j) / 2;
            }
            i = Math.max(i, parentLeft);
            k = i;
            j = Math.min(i + j, parentRight);
        } else
        {
            i = (k - j) / 2;
            k = i;
            j = i + j;
        }
        if (cueLine != 1.401298E-45F)
        {
            if (cueLineType == 0)
            {
                i = Math.round((float)l * cueLine) + parentTop;
            } else
            {
                i = textLayout.getLineBottom(0) - textLayout.getLineTop(0);
                if (cueLine >= 0.0F)
                {
                    i = Math.round(cueLine * (float)i) + parentTop;
                } else
                {
                    i = Math.round(cueLine * (float)i) + parentBottom;
                }
            }
            if (cueLineAnchor == 2)
            {
                i -= j1;
            } else
            if (cueLineAnchor == 1)
            {
                i = ((i << 1) - j1) / 2;
            }
            l = i;
            if (i + j1 > parentBottom)
            {
                i = parentBottom - j1;
            } else
            {
                i = l;
                if (l < parentTop)
                {
                    i = parentTop;
                }
            }
        } else
        {
            i = parentBottom - j1 - (int)((float)l * f1);
        }
        textLayout = new StaticLayout(((CharSequence) (obj)), textPaint, j - k, cue, spacingMult, spacingAdd, true);
        textLeft = k;
        textTop = i;
        textPaddingX = i1;
        drawLayout(canvas);
    }
}
