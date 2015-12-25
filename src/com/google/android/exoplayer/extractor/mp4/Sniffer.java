// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;

// Referenced classes of package com.google.android.exoplayer.extractor.mp4:
//            Atom

final class Sniffer
{

    private static final int COMPATIBLE_BRANDS[] = {
        Util.getIntegerCodeForString("isom"), Util.getIntegerCodeForString("iso2"), Util.getIntegerCodeForString("avc1"), Util.getIntegerCodeForString("hvc1"), Util.getIntegerCodeForString("hev1"), Util.getIntegerCodeForString("mp41"), Util.getIntegerCodeForString("mp42"), Util.getIntegerCodeForString("3g2a"), Util.getIntegerCodeForString("3g2b"), Util.getIntegerCodeForString("3gr6"), 
        Util.getIntegerCodeForString("3gs6"), Util.getIntegerCodeForString("3ge6"), Util.getIntegerCodeForString("3gg6"), Util.getIntegerCodeForString("M4V "), Util.getIntegerCodeForString("M4A "), Util.getIntegerCodeForString("f4v "), Util.getIntegerCodeForString("kddi"), Util.getIntegerCodeForString("M4VP"), Util.getIntegerCodeForString("qt  "), Util.getIntegerCodeForString("MSNV")
    };

    private Sniffer()
    {
    }

    private static boolean isCompatibleBrand(int i)
    {
        if (i >>> 8 == Util.getIntegerCodeForString("3gp"))
        {
            return true;
        }
        int ai[] = COMPATIBLE_BRANDS;
        int k = ai.length;
        for (int j = 0; j < k; j++)
        {
            if (ai[j] == i)
            {
                return true;
            }
        }

        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorinput)
    {
        return sniffInternal(extractorinput, 4096, true);
    }

    private static boolean sniffInternal(ExtractorInput extractorinput, int i, boolean flag)
    {
        long l1 = extractorinput.getLength();
        if (l1 == -1L || l1 > (long)i)
        {
            l1 = i;
        }
        int i1 = (int)l1;
        ParsableByteArray parsablebytearray = new ParsableByteArray(64);
        int k = 0;
        i = 0;
        boolean flag2 = false;
        boolean flag1;
        do
        {
            flag1 = flag2;
            if (k >= i1)
            {
                break;
            }
            int j = 8;
            extractorinput.peekFully(parsablebytearray.data, 0, 8);
            parsablebytearray.setPosition(0);
            long l3 = parsablebytearray.readUnsignedInt();
            int l = parsablebytearray.readInt();
            long l2 = l3;
            if (l3 == 1L)
            {
                extractorinput.peekFully(parsablebytearray.data, 8, 8);
                j = 16;
                l2 = parsablebytearray.readLong();
            }
            if (l2 < (long)j)
            {
                return false;
            }
            int j1 = (int)l2 - j;
            if (l == Atom.TYPE_ftyp)
            {
                if (j1 < 8)
                {
                    return false;
                }
                j1 = (j1 - 8) / 4;
                extractorinput.peekFully(parsablebytearray.data, 0, (j1 + 2) * 4);
                l = 0;
                do
                {
                    j = i;
                    if (l >= j1 + 2)
                    {
                        break;
                    }
                    if (l != 1 && isCompatibleBrand(parsablebytearray.readInt()))
                    {
                        j = 1;
                        break;
                    }
                    l++;
                } while (true);
                if (j == 0)
                {
                    return false;
                }
            } else
            {
                if (l == Atom.TYPE_moof)
                {
                    flag1 = true;
                    break;
                }
                j = i;
                if (j1 != 0)
                {
                    flag1 = flag2;
                    if ((long)k + l2 >= (long)i1)
                    {
                        break;
                    }
                    extractorinput.advancePeekPosition(j1);
                    j = i;
                }
            }
            k = (int)((long)k + l2);
            i = j;
        } while (true);
        return i != 0 && flag == flag1;
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorinput)
    {
        return sniffInternal(extractorinput, 128, false);
    }

}
