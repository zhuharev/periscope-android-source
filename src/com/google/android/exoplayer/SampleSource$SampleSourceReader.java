// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


// Referenced classes of package com.google.android.exoplayer:
//            SampleSource, MediaFormat, MediaFormatHolder, SampleHolder

public static interface 
{

    public abstract boolean continueBuffering(int i, long l);

    public abstract void disable(int i);

    public abstract void enable(int i, long l);

    public abstract long getBufferedPositionUs();

    public abstract MediaFormat getFormat(int i);

    public abstract int getTrackCount();

    public abstract void maybeThrowError();

    public abstract boolean prepare(long l);

    public abstract int readData(int i, long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag);

    public abstract void release();

    public abstract void seekToUs(long l);
}
