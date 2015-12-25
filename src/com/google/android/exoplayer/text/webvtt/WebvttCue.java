// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.webvtt;

import com.google.android.exoplayer.text.Cue;

final class WebvttCue extends Cue
{

    public final long endTime;
    public final long startTime;

    public WebvttCue(long l, long l1, CharSequence charsequence)
    {
        this(l, l1, charsequence, null, 1.401298E-45F, 0x80000000, 0x80000000, 1.401298E-45F, 0x80000000, 1.401298E-45F);
    }

    public WebvttCue(long l, long l1, CharSequence charsequence, android.text.Layout.Alignment alignment, float f, 
            int i, int j, float f1, int k, float f2)
    {
        super(charsequence, alignment, f, i, j, f1, k, f2);
        startTime = l;
        endTime = l1;
    }

    public WebvttCue(CharSequence charsequence)
    {
        this(0L, 0L, charsequence);
    }

    public final boolean isNormalCue()
    {
        return line == 1.401298E-45F && position == 1.401298E-45F;
    }
}
