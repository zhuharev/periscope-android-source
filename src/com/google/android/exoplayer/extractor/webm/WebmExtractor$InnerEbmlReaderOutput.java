// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;

// Referenced classes of package com.google.android.exoplayer.extractor.webm:
//            EbmlReaderOutput, WebmExtractor

final class <init>
    implements EbmlReaderOutput
{

    final WebmExtractor this$0;

    public final void binaryElement(int i, int j, ExtractorInput extractorinput)
    {
        WebmExtractor.this.binaryElement(i, j, extractorinput);
    }

    public final void endMasterElement(int i)
    {
        WebmExtractor.this.endMasterElement(i);
    }

    public final void floatElement(int i, double d)
    {
        WebmExtractor.this.floatElement(i, d);
    }

    public final int getElementType(int i)
    {
        return WebmExtractor.this.getElementType(i);
    }

    public final void integerElement(int i, long l)
    {
        WebmExtractor.this.integerElement(i, l);
    }

    public final void startMasterElement(int i, long l, long l1)
    {
        WebmExtractor.this.startMasterElement(i, l, l1);
    }

    public final void stringElement(int i, String s)
    {
        WebmExtractor.this.stringElement(i, s);
    }

    private ()
    {
        this$0 = WebmExtractor.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
