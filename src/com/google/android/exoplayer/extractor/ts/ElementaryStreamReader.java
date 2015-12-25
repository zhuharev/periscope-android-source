// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.ParsableByteArray;

abstract class ElementaryStreamReader
{

    protected final TrackOutput output;

    protected ElementaryStreamReader(TrackOutput trackoutput)
    {
        output = trackoutput;
    }

    public abstract void consume(ParsableByteArray parsablebytearray, long l, boolean flag);

    public abstract void packetFinished();

    public abstract void seek();
}
