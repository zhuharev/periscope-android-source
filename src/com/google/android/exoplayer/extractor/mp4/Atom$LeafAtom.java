// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package com.google.android.exoplayer.extractor.mp4:
//            Atom

static final class data extends Atom
{

    public final ParsableByteArray data;

    public (int i, ParsableByteArray parsablebytearray)
    {
        super(i);
        data = parsablebytearray;
    }
}
