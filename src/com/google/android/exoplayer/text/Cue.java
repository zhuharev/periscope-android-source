// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text;


public class Cue
{

    public static final int ANCHOR_TYPE_END = 2;
    public static final int ANCHOR_TYPE_MIDDLE = 1;
    public static final int ANCHOR_TYPE_START = 0;
    public static final float DIMEN_UNSET = 1.401298E-45F;
    public static final int LINE_TYPE_FRACTION = 0;
    public static final int LINE_TYPE_NUMBER = 1;
    public static final int TYPE_UNSET = 0x80000000;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final int positionAnchor;
    public final float size;
    public final CharSequence text;
    public final android.text.Layout.Alignment textAlignment;

    public Cue()
    {
        this(null);
    }

    public Cue(CharSequence charsequence)
    {
        this(charsequence, null, 1.401298E-45F, 0x80000000, 0x80000000, 1.401298E-45F, 0x80000000, 1.401298E-45F);
    }

    public Cue(CharSequence charsequence, android.text.Layout.Alignment alignment, float f, int i, int j, float f1, int k, 
            float f2)
    {
        text = charsequence;
        textAlignment = alignment;
        line = f;
        lineType = i;
        lineAnchor = j;
        position = f1;
        positionAnchor = k;
        size = f2;
    }
}
