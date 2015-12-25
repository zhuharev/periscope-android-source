// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


public final class CodecCounters
{

    public int codecInitCount;
    public int codecReleaseCount;
    public int droppedOutputBufferCount;
    public int outputBuffersChangedCount;
    public int outputFormatChangedCount;
    public int renderedOutputBufferCount;
    public int skippedOutputBufferCount;

    public CodecCounters()
    {
    }

    public final void ensureUpdated()
    {
        this;
        JVM INSTR monitorenter ;
    }

    public final String getDebugString()
    {
        ensureUpdated();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("cic:").append(codecInitCount);
        stringbuilder.append(" crc:").append(codecReleaseCount);
        stringbuilder.append(" ofc:").append(outputFormatChangedCount);
        stringbuilder.append(" obc:").append(outputBuffersChangedCount);
        stringbuilder.append(" ren:").append(renderedOutputBufferCount);
        stringbuilder.append(" sob:").append(skippedOutputBufferCount);
        stringbuilder.append(" dob:").append(droppedOutputBufferCount);
        return stringbuilder.toString();
    }
}
