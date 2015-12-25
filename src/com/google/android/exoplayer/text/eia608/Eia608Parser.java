// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.eia608;

import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package com.google.android.exoplayer.text.eia608:
//            ClosedCaptionText, ClosedCaptionCtrl, ClosedCaption, ClosedCaptionList

public final class Eia608Parser
{

    private static final int BASIC_CHARACTER_SET[] = {
        32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 
        225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 
        52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 
        62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 
        72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 
        82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 
        233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 
        102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 
        112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 
        122, 231, 247, 209, 241, 9632
    };
    private static final int COUNTRY_CODE = 181;
    private static final int PAYLOAD_TYPE_CC = 4;
    private static final int PROVIDER_CODE = 49;
    private static final int SPECIAL_CHARACTER_SET[] = {
        174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 
        232, 226, 234, 238, 244, 251
    };
    private static final int SPECIAL_ES_FR_CHARACTER_SET[] = {
        193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 
        8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 
        202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 
        171, 187
    };
    private static final int SPECIAL_PT_DE_CHARACTER_SET[] = {
        195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 
        125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 
        223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 
        9492, 9496
    };
    private static final int USER_DATA_TYPE_CODE = 3;
    private static final int USER_ID = 0x47413934;
    private final ArrayList captions = new ArrayList();
    private final ParsableBitArray seiBuffer = new ParsableBitArray();
    private final StringBuilder stringBuilder = new StringBuilder();

    Eia608Parser()
    {
    }

    private void addBufferedText()
    {
        if (stringBuilder.length() > 0)
        {
            captions.add(new ClosedCaptionText(stringBuilder.toString()));
            stringBuilder.setLength(0);
        }
    }

    private void addCtrl(byte byte0, byte byte1)
    {
        addBufferedText();
        captions.add(new ClosedCaptionCtrl(byte0, byte1));
    }

    private void backspace()
    {
        addCtrl((byte)20, (byte)33);
    }

    private static char getChar(byte byte0)
    {
        return (char)BASIC_CHARACTER_SET[(byte0 & 0x7f) - 32];
    }

    private static char getExtendedEsFrChar(byte byte0)
    {
        return (char)SPECIAL_ES_FR_CHARACTER_SET[byte0 & 0x1f];
    }

    private static char getExtendedPtDeChar(byte byte0)
    {
        return (char)SPECIAL_PT_DE_CHARACTER_SET[byte0 & 0x1f];
    }

    private static char getSpecialChar(byte byte0)
    {
        return (char)SPECIAL_CHARACTER_SET[byte0 & 0xf];
    }

    public static boolean isSeiMessageEia608(int i, int j, ParsableByteArray parsablebytearray)
    {
        if (i != 4 || j < 8)
        {
            return false;
        }
        i = parsablebytearray.getPosition();
        j = parsablebytearray.readUnsignedByte();
        int k = parsablebytearray.readUnsignedShort();
        int l = parsablebytearray.readInt();
        int i1 = parsablebytearray.readUnsignedByte();
        parsablebytearray.setPosition(i);
        return j == 181 && k == 49 && l == 0x47413934 && i1 == 3;
    }

    final boolean canParse(String s)
    {
        return s.equals("application/eia-608");
    }

    final ClosedCaptionList parse(SampleHolder sampleholder)
    {
        if (sampleholder.size < 10)
        {
            return null;
        }
        captions.clear();
        stringBuilder.setLength(0);
        seiBuffer.reset(sampleholder.data.array());
        seiBuffer.skipBits(67);
        int j = seiBuffer.readBits(5);
        seiBuffer.skipBits(8);
        for (int i = 0; i < j; i++)
        {
            seiBuffer.skipBits(5);
            if (!seiBuffer.readBit())
            {
                seiBuffer.skipBits(18);
                continue;
            }
            if (seiBuffer.readBits(2) != 0)
            {
                seiBuffer.skipBits(16);
                continue;
            }
            seiBuffer.skipBits(1);
            byte byte0 = (byte)seiBuffer.readBits(7);
            seiBuffer.skipBits(1);
            byte byte1 = (byte)seiBuffer.readBits(7);
            if (byte0 == 0 && byte1 == 0)
            {
                continue;
            }
            if ((byte0 == 17 || byte0 == 25) && (byte1 & 0x70) == 48)
            {
                stringBuilder.append(getSpecialChar(byte1));
                continue;
            }
            if ((byte0 == 18 || byte0 == 26) && (byte1 & 0x60) == 32)
            {
                backspace();
                stringBuilder.append(getExtendedEsFrChar(byte1));
                continue;
            }
            if ((byte0 == 19 || byte0 == 27) && (byte1 & 0x60) == 32)
            {
                backspace();
                stringBuilder.append(getExtendedPtDeChar(byte1));
                continue;
            }
            if (byte0 < 32)
            {
                addCtrl(byte0, byte1);
                continue;
            }
            stringBuilder.append(getChar(byte0));
            if (byte1 >= 32)
            {
                stringBuilder.append(getChar(byte1));
            }
        }

        addBufferedText();
        if (captions.isEmpty())
        {
            return null;
        } else
        {
            ClosedCaption aclosedcaption[] = new ClosedCaption[captions.size()];
            captions.toArray(aclosedcaption);
            return new ClosedCaptionList(sampleholder.timeUs, sampleholder.isDecodeOnly(), aclosedcaption);
        }
    }

}
