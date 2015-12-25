// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.util.Assertions;
import java.nio.charset.Charset;
import java.util.Stack;

// Referenced classes of package com.google.android.exoplayer.extractor.webm:
//            EbmlReader, VarintReader, EbmlReaderOutput

final class DefaultEbmlReader
    implements EbmlReader
{
    static final class MasterElement
    {

        private final long elementEndPosition;
        private final int elementId;



        private MasterElement(int i, long l)
        {
            elementId = i;
            elementEndPosition = l;
        }

        MasterElement(int i, long l, _cls1 _pcls1)
        {
            this(i, l);
        }
    }


    private static final int ELEMENT_STATE_READ_CONTENT = 2;
    private static final int ELEMENT_STATE_READ_CONTENT_SIZE = 1;
    private static final int ELEMENT_STATE_READ_ID = 0;
    private static final int MAX_INTEGER_ELEMENT_SIZE_BYTES = 8;
    private static final int VALID_FLOAT32_ELEMENT_SIZE_BYTES = 4;
    private static final int VALID_FLOAT64_ELEMENT_SIZE_BYTES = 8;
    private long elementContentSize;
    private int elementId;
    private int elementState;
    private final Stack masterElementsStack = new Stack();
    private EbmlReaderOutput output;
    private final byte scratch[] = new byte[8];
    private final VarintReader varintReader = new VarintReader();

    DefaultEbmlReader()
    {
    }

    private double readFloat(ExtractorInput extractorinput, int i)
    {
        long l = readInteger(extractorinput, i);
        if (i == 4)
        {
            return (double)Float.intBitsToFloat((int)l);
        } else
        {
            return Double.longBitsToDouble(l);
        }
    }

    private long readInteger(ExtractorInput extractorinput, int i)
    {
        extractorinput.readFully(scratch, 0, i);
        long l = 0L;
        for (int j = 0; j < i; j++)
        {
            l = l << 8 | (long)(scratch[j] & 0xff);
        }

        return l;
    }

    private String readString(ExtractorInput extractorinput, int i)
    {
        byte abyte0[] = new byte[i];
        extractorinput.readFully(abyte0, 0, i);
        return new String(abyte0, Charset.forName("UTF-8"));
    }

    public final void init(EbmlReaderOutput ebmlreaderoutput)
    {
        output = ebmlreaderoutput;
    }

    public final boolean read(ExtractorInput extractorinput)
    {
        boolean flag;
        if (output != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        do
        {
            if (!masterElementsStack.isEmpty() && extractorinput.getPosition() >= ((MasterElement)masterElementsStack.peek()).elementEndPosition)
            {
                output.endMasterElement(((MasterElement)masterElementsStack.pop()).elementId);
                return true;
            }
            if (elementState == 0)
            {
                long l = varintReader.readUnsignedVarint(extractorinput, true, false);
                if (l == -1L)
                {
                    return false;
                }
                elementId = (int)l;
                elementState = 1;
            }
            if (elementState == 1)
            {
                elementContentSize = varintReader.readUnsignedVarint(extractorinput, false, true);
                elementState = 2;
            }
            int i = output.getElementType(elementId);
            switch (i)
            {
            case 1: // '\001'
                long l1 = extractorinput.getPosition();
                long l2 = elementContentSize;
                masterElementsStack.add(new MasterElement(elementId, l1 + l2));
                output.startMasterElement(elementId, l1, elementContentSize);
                elementState = 0;
                return true;

            case 2: // '\002'
                if (elementContentSize > 8L)
                {
                    throw new IllegalStateException((new StringBuilder("Invalid integer size: ")).append(elementContentSize).toString());
                } else
                {
                    output.integerElement(elementId, readInteger(extractorinput, (int)elementContentSize));
                    elementState = 0;
                    return true;
                }

            case 5: // '\005'
                if (elementContentSize != 4L && elementContentSize != 8L)
                {
                    throw new IllegalStateException((new StringBuilder("Invalid float size: ")).append(elementContentSize).toString());
                } else
                {
                    output.floatElement(elementId, readFloat(extractorinput, (int)elementContentSize));
                    elementState = 0;
                    return true;
                }

            case 3: // '\003'
                if (elementContentSize > 0x7fffffffL)
                {
                    throw new IllegalStateException((new StringBuilder("String element size: ")).append(elementContentSize).toString());
                } else
                {
                    output.stringElement(elementId, readString(extractorinput, (int)elementContentSize));
                    elementState = 0;
                    return true;
                }

            case 4: // '\004'
                output.binaryElement(elementId, (int)elementContentSize, extractorinput);
                elementState = 0;
                return true;

            case 0: // '\0'
                extractorinput.skipFully((int)elementContentSize);
                elementState = 0;
                break;

            default:
                throw new IllegalStateException((new StringBuilder("Invalid element type ")).append(i).toString());
            }
        } while (true);
    }

    public final void reset()
    {
        elementState = 0;
        masterElementsStack.clear();
        varintReader.reset();
    }
}
