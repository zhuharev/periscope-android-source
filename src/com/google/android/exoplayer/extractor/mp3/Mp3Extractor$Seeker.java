// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.extractor.SeekMap;

// Referenced classes of package com.google.android.exoplayer.extractor.mp3:
//            Mp3Extractor

static interface 
    extends SeekMap
{

    public abstract long getDurationUs();

    public abstract long getTimeUs(long l);
}
