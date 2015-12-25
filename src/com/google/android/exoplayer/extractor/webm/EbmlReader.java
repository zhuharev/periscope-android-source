// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;

// Referenced classes of package com.google.android.exoplayer.extractor.webm:
//            EbmlReaderOutput

interface EbmlReader
{

    public static final int TYPE_BINARY = 4;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_MASTER = 1;
    public static final int TYPE_STRING = 3;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_UNSIGNED_INT = 2;

    public abstract void init(EbmlReaderOutput ebmlreaderoutput);

    public abstract boolean read(ExtractorInput extractorinput);

    public abstract void reset();
}
