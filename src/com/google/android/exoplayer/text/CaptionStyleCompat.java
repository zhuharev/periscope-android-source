// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text;

import android.graphics.Typeface;
import com.google.android.exoplayer.util.Util;

public final class CaptionStyleCompat
{

    public static final CaptionStyleCompat DEFAULT = new CaptionStyleCompat(-1, 0xff000000, 0, 0, -1, null);
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int USE_TRACK_COLOR_SETTINGS = 1;
    public final int backgroundColor;
    public final int edgeColor;
    public final int edgeType;
    public final int foregroundColor;
    public final Typeface typeface;
    public final int windowColor;

    public CaptionStyleCompat(int i, int j, int k, int l, int i1, Typeface typeface1)
    {
        foregroundColor = i;
        backgroundColor = j;
        windowColor = k;
        edgeType = l;
        edgeColor = i1;
        typeface = typeface1;
    }

    public static CaptionStyleCompat createFromCaptionStyle(android.view.accessibility.CaptioningManager.CaptionStyle captionstyle)
    {
        if (Util.SDK_INT >= 21)
        {
            return createFromCaptionStyleV21(captionstyle);
        } else
        {
            return createFromCaptionStyleV19(captionstyle);
        }
    }

    private static CaptionStyleCompat createFromCaptionStyleV19(android.view.accessibility.CaptioningManager.CaptionStyle captionstyle)
    {
        return new CaptionStyleCompat(captionstyle.foregroundColor, captionstyle.backgroundColor, 0, captionstyle.edgeType, captionstyle.edgeColor, captionstyle.getTypeface());
    }

    private static CaptionStyleCompat createFromCaptionStyleV21(android.view.accessibility.CaptioningManager.CaptionStyle captionstyle)
    {
        int i;
        if (captionstyle.hasForegroundColor())
        {
            i = captionstyle.foregroundColor;
        } else
        {
            i = DEFAULT.foregroundColor;
        }
        int j;
        if (captionstyle.hasBackgroundColor())
        {
            j = captionstyle.backgroundColor;
        } else
        {
            j = DEFAULT.backgroundColor;
        }
        int k;
        if (captionstyle.hasWindowColor())
        {
            k = captionstyle.windowColor;
        } else
        {
            k = DEFAULT.windowColor;
        }
        int l;
        if (captionstyle.hasEdgeType())
        {
            l = captionstyle.edgeType;
        } else
        {
            l = DEFAULT.edgeType;
        }
        int i1;
        if (captionstyle.hasEdgeColor())
        {
            i1 = captionstyle.edgeColor;
        } else
        {
            i1 = DEFAULT.edgeColor;
        }
        return new CaptionStyleCompat(i, j, k, l, i1, captionstyle.getTypeface());
    }

}
