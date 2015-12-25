// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.MediaFormat;

// Referenced classes of package com.google.android.exoplayer.extractor.mp4:
//            AtomParsers, TrackEncryptionBox

static final class nalUnitLengthFieldLength
{

    public MediaFormat mediaFormat;
    public int nalUnitLengthFieldLength;
    public final TrackEncryptionBox trackEncryptionBoxes[];

    public (int i)
    {
        trackEncryptionBoxes = new TrackEncryptionBox[i];
        nalUnitLengthFieldLength = -1;
    }
}
