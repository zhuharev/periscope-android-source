// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;


// Referenced classes of package com.google.android.exoplayer.extractor:
//            ExtractorOutput, ExtractorInput, PositionHolder

public interface Extractor
{

    public static final int RESULT_CONTINUE = 0;
    public static final int RESULT_END_OF_INPUT = -1;
    public static final int RESULT_SEEK = 1;

    public abstract void init(ExtractorOutput extractoroutput);

    public abstract int read(ExtractorInput extractorinput, PositionHolder positionholder);

    public abstract void seek();

    public abstract boolean sniff(ExtractorInput extractorinput);
}
