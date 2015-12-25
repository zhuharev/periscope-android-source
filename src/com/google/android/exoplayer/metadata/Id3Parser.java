// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.metadata;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.google.android.exoplayer.metadata:
//            MetadataParser, TxxxMetadata, PrivMetadata, GeobMetadata

public final class Id3Parser
    implements MetadataParser
{

    private static final int ID3_TEXT_ENCODING_ISO_8859_1 = 0;
    private static final int ID3_TEXT_ENCODING_UTF_16 = 1;
    private static final int ID3_TEXT_ENCODING_UTF_16BE = 2;
    private static final int ID3_TEXT_ENCODING_UTF_8 = 3;

    public Id3Parser()
    {
    }

    private static int delimiterLength(int i)
    {
        return i != 0 && i != 3 ? 2 : 1;
    }

    private static String getCharsetName(int i)
    {
        switch (i)
        {
        case 0: // '\0'
            return "ISO-8859-1";

        case 1: // '\001'
            return "UTF-16";

        case 2: // '\002'
            return "UTF-16BE";

        case 3: // '\003'
            return "UTF-8";
        }
        return "ISO-8859-1";
    }

    private static int indexOf(byte abyte0[], int i, byte byte0)
    {
        for (; i < abyte0.length; i++)
        {
            if (abyte0[i] == byte0)
            {
                return i;
            }
        }

        return abyte0.length;
    }

    private static int indexOfEOS(byte abyte0[], int i, int j)
    {
label0:
        {
            int k = indexOf(abyte0, i, (byte)0);
            if (j != 0)
            {
                i = k;
                if (j != 3)
                {
                    break label0;
                }
            }
            return k;
        }
        for (; i < abyte0.length - 1; i = indexOf(abyte0, i + 1, (byte)0))
        {
            if (abyte0[i + 1] == 0)
            {
                return i;
            }
        }

        return abyte0.length;
    }

    private static int parseId3Header(ParsableByteArray parsablebytearray)
    {
        int i = parsablebytearray.readUnsignedByte();
        int j = parsablebytearray.readUnsignedByte();
        int k = parsablebytearray.readUnsignedByte();
        if (i != 73 || j != 68 || k != 51)
        {
            throw new ParserException(String.format(Locale.US, "Unexpected ID3 file identifier, expected \"ID3\", actual \"%c%c%c\".", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)
            }));
        }
        parsablebytearray.skipBytes(2);
        k = parsablebytearray.readUnsignedByte();
        j = parsablebytearray.readSynchSafeInt();
        i = j;
        if ((k & 2) != 0)
        {
            i = parsablebytearray.readSynchSafeInt();
            if (i > 4)
            {
                parsablebytearray.skipBytes(i - 4);
            }
            i = j - i;
        }
        j = i;
        if ((k & 8) != 0)
        {
            j = i - 10;
        }
        return j;
    }

    public final boolean canParse(String s)
    {
        return s.equals("application/id3");
    }

    public final volatile Object parse(byte abyte0[], int i)
    {
        return parse(abyte0, i);
    }

    public final Map parse(byte abyte0[], int i)
    {
        HashMap hashmap = new HashMap();
        abyte0 = new ParsableByteArray(abyte0, i);
        int j;
        for (i = parseId3Header(abyte0); i > 0; i -= j + 10)
        {
            int k = abyte0.readUnsignedByte();
            int l = abyte0.readUnsignedByte();
            int i1 = abyte0.readUnsignedByte();
            int j1 = abyte0.readUnsignedByte();
            j = abyte0.readSynchSafeInt();
            if (j <= 1)
            {
                break;
            }
            abyte0.skipBytes(2);
            if (k == 84 && l == 88 && i1 == 88 && j1 == 88)
            {
                k = abyte0.readUnsignedByte();
                String s = getCharsetName(k);
                byte abyte3[] = new byte[j - 1];
                abyte0.readBytes(abyte3, 0, j - 1);
                l = indexOfEOS(abyte3, 0, k);
                String s4 = new String(abyte3, 0, l, s);
                l += delimiterLength(k);
                hashmap.put("TXXX", new TxxxMetadata(s4, new String(abyte3, l, indexOfEOS(abyte3, l, k) - l, s)));
                continue;
            }
            if (k == 80 && l == 82 && i1 == 73 && j1 == 86)
            {
                byte abyte1[] = new byte[j];
                abyte0.readBytes(abyte1, 0, j);
                k = indexOf(abyte1, 0, (byte)0);
                String s2 = new String(abyte1, 0, k, "ISO-8859-1");
                byte abyte5[] = new byte[j - k - 1];
                System.arraycopy(abyte1, k + 1, abyte5, 0, j - k - 1);
                hashmap.put("PRIV", new PrivMetadata(s2, abyte5));
                continue;
            }
            if (k == 71 && l == 69 && i1 == 79 && j1 == 66)
            {
                k = abyte0.readUnsignedByte();
                String s6 = getCharsetName(k);
                byte abyte2[] = new byte[j - 1];
                abyte0.readBytes(abyte2, 0, j - 1);
                l = indexOf(abyte2, 0, (byte)0);
                String s3 = new String(abyte2, 0, l, "ISO-8859-1");
                l++;
                i1 = indexOfEOS(abyte2, l, k);
                String s5 = new String(abyte2, l, i1 - l, s6);
                i1 += delimiterLength(k);
                l = indexOfEOS(abyte2, i1, k);
                s6 = new String(abyte2, i1, l - i1, s6);
                i1 = j - 1 - l - delimiterLength(k);
                byte abyte6[] = new byte[i1];
                System.arraycopy(abyte2, delimiterLength(k) + l, abyte6, 0, i1);
                hashmap.put("GEOB", new GeobMetadata(s3, s5, s6, abyte6));
            } else
            {
                String s1 = String.format(Locale.US, "%c%c%c%c", new Object[] {
                    Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(i1), Integer.valueOf(j1)
                });
                byte abyte4[] = new byte[j];
                abyte0.readBytes(abyte4, 0, j);
                hashmap.put(s1, abyte4);
            }
        }

        return Collections.unmodifiableMap(hashmap);
    }
}
