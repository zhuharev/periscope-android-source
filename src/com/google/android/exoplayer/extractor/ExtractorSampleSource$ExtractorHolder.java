// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import java.io.EOFException;

// Referenced classes of package com.google.android.exoplayer.extractor:
//            ExtractorSampleSource, Extractor, ExtractorInput, ExtractorOutput

static final class extractorOutput
{

    private Extractor extractor;
    private final ExtractorOutput extractorOutput;
    private final Extractor extractors[];

    public final Extractor selectExtractor(ExtractorInput extractorinput)
    {
        if (extractor != null)
        {
            return extractor;
        }
        Extractor aextractor[] = extractors;
        int j = aextractor.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                break;
            }
            Extractor extractor1 = aextractor[i];
            try
            {
                if (extractor1.sniff(extractorinput))
                {
                    extractor = extractor1;
                    break;
                }
            }
            catch (EOFException eofexception) { }
            extractorinput.resetPeekPosition();
            i++;
        } while (true);
        if (extractor == null)
        {
            throw new tFormatException(extractors);
        } else
        {
            extractor.init(extractorOutput);
            return extractor;
        }
    }

    public tFormatException(Extractor aextractor[], ExtractorOutput extractoroutput)
    {
        extractors = aextractor;
        extractorOutput = extractoroutput;
    }
}
