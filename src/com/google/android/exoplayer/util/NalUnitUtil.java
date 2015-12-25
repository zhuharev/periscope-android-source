// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import java.util.Arrays;

// Referenced classes of package com.google.android.exoplayer.util:
//            Assertions, ParsableByteArray, CodecSpecificDataUtil

public final class NalUnitUtil
{

    public static final float ASPECT_RATIO_IDC_VALUES[] = {
        1.0F, 1.0F, 1.090909F, 0.9090909F, 1.454545F, 1.212121F, 2.181818F, 1.818182F, 2.909091F, 2.424242F, 
        1.636364F, 1.363636F, 1.939394F, 1.616162F, 1.333333F, 1.5F, 2.0F
    };
    public static final int EXTENDED_SAR = 255;
    public static final byte NAL_START_CODE[] = {
        0, 0, 0, 1
    };
    private static int scratchEscapePositions[] = new int[10];
    private static final Object scratchEscapePositionsLock = new Object();

    private NalUnitUtil()
    {
    }

    public static void clearPrefixFlags(boolean aflag[])
    {
        aflag[0] = false;
        aflag[1] = false;
        aflag[2] = false;
    }

    public static int findNalUnit(byte abyte0[], int i, int j, boolean aflag[])
    {
        int l = j - i;
        boolean flag;
        if (l >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (l == 0)
        {
            return j;
        }
        if (aflag != null)
        {
            if (aflag[0])
            {
                clearPrefixFlags(aflag);
                return i - 3;
            }
            if (l > 1 && aflag[1] && abyte0[i] == 1)
            {
                clearPrefixFlags(aflag);
                return i - 2;
            }
            if (l > 2 && aflag[2] && abyte0[i] == 0 && abyte0[i + 1] == 1)
            {
                clearPrefixFlags(aflag);
                return i - 1;
            }
        }
        int i1 = j - 1;
        int k;
        for (i += 2; i < i1; i = k + 3)
        {
            k = i;
            if ((abyte0[i] & 0xfe) != 0)
            {
                continue;
            }
            if (abyte0[i - 2] == 0 && abyte0[i - 1] == 0 && abyte0[i] == 1)
            {
                if (aflag != null)
                {
                    clearPrefixFlags(aflag);
                }
                return i - 2;
            }
            k = i - 2;
        }

        if (aflag != null)
        {
            boolean flag1;
            if (l > 2)
            {
                if (abyte0[j - 3] == 0 && abyte0[j - 2] == 0 && abyte0[i1] == 1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            } else
            if (l == 2)
            {
                if (aflag[2] && abyte0[j - 2] == 0 && abyte0[i1] == 1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            } else
            if (aflag[1] && abyte0[i1] == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            aflag[0] = flag1;
            if (l > 1)
            {
                if (abyte0[j - 2] == 0 && abyte0[i1] == 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            } else
            if (aflag[2] && abyte0[i1] == 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            aflag[1] = flag1;
            if (abyte0[i1] == 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            aflag[2] = flag1;
        }
        return j;
    }

    private static int findNextUnescapeIndex(byte abyte0[], int i, int j)
    {
        for (; i < j - 2; i++)
        {
            if (abyte0[i] == 0 && abyte0[i + 1] == 0 && abyte0[i + 2] == 3)
            {
                return i;
            }
        }

        return j;
    }

    public static int getH265NalUnitType(byte abyte0[], int i)
    {
        return (abyte0[i + 3] & 0x7e) >> 1;
    }

    public static int getNalUnitType(byte abyte0[], int i)
    {
        return abyte0[i + 3] & 0x1f;
    }

    public static byte[] parseChildNalUnit(ParsableByteArray parsablebytearray)
    {
        int i = parsablebytearray.readUnsignedShort();
        int j = parsablebytearray.getPosition();
        parsablebytearray.skipBytes(i);
        return CodecSpecificDataUtil.buildNalUnit(parsablebytearray.data, j, i);
    }

    public static int unescapeStream(byte abyte0[], int i)
    {
        Object obj = scratchEscapePositionsLock;
        obj;
        JVM INSTR monitorenter ;
        int j;
        int k;
        j = 0;
        k = 0;
_L2:
        int i1;
        i1 = k;
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        int j1 = findNextUnescapeIndex(abyte0, j, i);
        int l;
        l = j1;
        j = l;
        k = i1;
        if (j1 >= i)
        {
            continue; /* Loop/switch isn't completed */
        }
        int ai[];
        if (scratchEscapePositions.length <= i1)
        {
            scratchEscapePositions = Arrays.copyOf(scratchEscapePositions, scratchEscapePositions.length << 1);
        }
        ai = scratchEscapePositions;
        k = i1 + 1;
        ai[i1] = l;
        j = l + 3;
        if (true) goto _L2; else goto _L1
_L4:
        if (j >= i1)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        j1 = scratchEscapePositions[j] - i;
        System.arraycopy(abyte0, i, abyte0, k, j1);
        k += j1;
        int k1 = k + 1;
        abyte0[k] = 0;
        k = k1 + 1;
        abyte0[k1] = 0;
        i += j1 + 3;
        j++;
        continue; /* Loop/switch isn't completed */
        System.arraycopy(abyte0, i, abyte0, k, l - k);
        obj;
        JVM INSTR monitorexit ;
        return l;
        abyte0;
        throw abyte0;
_L1:
        l = i - i1;
        i = 0;
        k = 0;
        j = 0;
        if (true) goto _L4; else goto _L3
_L3:
    }

}
