// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.util.Util;

// Referenced classes of package com.google.android.exoplayer.extractor.mp4:
//            TrackEncryptionBox

public final class Track
{

    public static final int TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    public static final int TYPE_soun = Util.getIntegerCodeForString("soun");
    public static final int TYPE_subt = Util.getIntegerCodeForString("subt");
    public static final int TYPE_text = Util.getIntegerCodeForString("text");
    public static final int TYPE_vide = Util.getIntegerCodeForString("vide");
    public final long durationUs;
    public final int id;
    public final MediaFormat mediaFormat;
    public final int nalUnitLengthFieldLength;
    public final TrackEncryptionBox sampleDescriptionEncryptionBoxes[];
    public final long timescale;
    public final int type;

    public Track(int i, int j, long l, long l1, MediaFormat mediaformat, 
            TrackEncryptionBox atrackencryptionbox[], int k)
    {
        id = i;
        type = j;
        timescale = l;
        durationUs = l1;
        mediaFormat = mediaformat;
        sampleDescriptionEncryptionBoxes = atrackencryptionbox;
        nalUnitLengthFieldLength = k;
    }

}
