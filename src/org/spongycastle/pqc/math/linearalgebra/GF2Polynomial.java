// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;

import java.util.Random;

// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            IntUtils

public class GF2Polynomial
{

    private static Random aOu = new Random();
    static final short aOv[] = {
        0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 
        68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 
        272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 
        340, 341, 1024, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 
        1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 
        1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 
        1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 
        4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 
        4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 
        4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 
        5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 
        5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 
        5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, 16384, 16385, 
        16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 
        16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 
        16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 
        17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 
        17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 
        17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 
        17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 
        20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 
        20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 
        20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 
        21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 
        21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 
        21828, 21829, 21840, 21841, 21844, 21845
    };
    private static final int aOw[] = {
        1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 
        1024, 2048, 4096, 8192, 16384, 32768, 0x10000, 0x20000, 0x40000, 0x80000, 
        0x100000, 0x200000, 0x400000, 0x800000, 0x1000000, 0x2000000, 0x4000000, 0x8000000, 0x10000000, 0x20000000, 
        0x40000000, 0x80000000, 0
    };
    private static final int aOx[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };
    int aOs;
    int aOt[];
    int len;

    public GF2Polynomial(int i)
    {
        int j = i;
        if (i <= 0)
        {
            j = 1;
        }
        aOs = (j - 1 >> 5) + 1;
        aOt = new int[aOs];
        len = j;
    }

    public GF2Polynomial(int i, String s)
    {
        int j = i;
        if (i <= 0)
        {
            j = 1;
        }
        aOs = (j - 1 >> 5) + 1;
        aOt = new int[aOs];
        len = j;
        if (s.equalsIgnoreCase("ZERO"))
        {
            _mth13D7();
            return;
        }
        if (s.equalsIgnoreCase("ONE"))
        {
            _mth0E87();
            return;
        }
        if (s.equalsIgnoreCase("RANDOM"))
        {
            _mth13DD();
            return;
        }
        if (s.equalsIgnoreCase("X"))
        {
            _mth10D4();
            return;
        }
        if (s.equalsIgnoreCase("ALL"))
        {
            _mth10DE();
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Error: GF2Polynomial was called using ")).append(s).append(" as value!").toString());
        }
    }

    private GF2Polynomial(int i, int ai[])
    {
        int j = i;
        if (i <= 0)
        {
            j = 1;
        }
        aOs = (j - 1 >> 5) + 1;
        aOt = new int[aOs];
        len = j;
        i = Math.min(aOs, ai.length);
        System.arraycopy(ai, 0, aOt, 0, i);
        _mth14EE();
    }

    public GF2Polynomial(GF2Polynomial gf2polynomial)
    {
        len = gf2polynomial.len;
        aOs = gf2polynomial.aOs;
        aOt = IntUtils._mth02D1(gf2polynomial.aOt);
    }

    private void _mth02CA(GF2Polynomial gf2polynomial)
    {
        FE92(gf2polynomial.len);
        _mth02CE(gf2polynomial);
    }

    private void _mth02CE(GF2Polynomial gf2polynomial)
    {
        for (int i = 0; i < Math.min(aOs, gf2polynomial.aOs); i++)
        {
            int ai[] = aOt;
            ai[i] = ai[i] ^ gf2polynomial.aOt[i];
        }

        _mth14EE();
    }

    private void _mth0E87()
    {
        for (int i = 1; i < aOs; i++)
        {
            aOt[i] = 0;
        }

        aOt[0] = 1;
    }

    private void _mth10D4()
    {
        for (int i = 1; i < aOs; i++)
        {
            aOt[i] = 0;
        }

        aOt[0] = 2;
    }

    private void _mth10DE()
    {
        for (int i = 0; i < aOs; i++)
        {
            aOt[i] = -1;
        }

        _mth14EE();
    }

    private void _mth13D7()
    {
        for (int i = 0; i < aOs; i++)
        {
            aOt[i] = 0;
        }

    }

    private void FE92(int i)
    {
        if (len >= i)
        {
            return;
        }
        len = i;
        int j = (i - 1 >>> 5) + 1;
        if (aOs >= j)
        {
            return;
        }
        if (aOt.length >= j)
        {
            for (i = aOs; i < j; i++)
            {
                aOt[i] = 0;
            }

            aOs = j;
            return;
        } else
        {
            int ai[] = new int[j];
            System.arraycopy(aOt, 0, ai, 0, aOs);
            aOs = j;
            aOt = null;
            aOt = ai;
            return;
        }
    }

    private GF2Polynomial FEA9(int i)
    {
        GF2Polynomial gf2polynomial = new GF2Polynomial(len + i, aOt);
        if (i >= 32)
        {
            int i1 = i >>> 5;
            if (gf2polynomial.aOs <= gf2polynomial.aOt.length)
            {
                for (int j = gf2polynomial.aOs - 1; j >= i1; j--)
                {
                    int ai[] = gf2polynomial.aOt;
                    ai[j] = ai[j - i1];
                }

                for (int k = 0; k < i1; k++)
                {
                    gf2polynomial.aOt[k] = 0;
                }

            } else
            {
                int ai1[] = new int[gf2polynomial.aOs];
                System.arraycopy(gf2polynomial.aOt, 0, ai1, i1, gf2polynomial.aOs - i1);
                gf2polynomial.aOt = null;
                gf2polynomial.aOt = ai1;
            }
        }
        int l = i & 0x1f;
        if (l != 0)
        {
            for (i = gf2polynomial.aOs - 1; i > 0; i--)
            {
                int ai2[] = gf2polynomial.aOt;
                ai2[i] = ai2[i] << l;
                ai2 = gf2polynomial.aOt;
                ai2[i] = ai2[i] | gf2polynomial.aOt[i - 1] >>> 32 - l;
            }

            int ai3[] = gf2polynomial.aOt;
            ai3[0] = ai3[0] << l;
        }
        return gf2polynomial;
    }

    public Object clone()
    {
        return new GF2Polynomial(this);
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof GF2Polynomial))
        {
            return false;
        }
        obj = (GF2Polynomial)obj;
        if (len != ((GF2Polynomial) (obj)).len)
        {
            return false;
        }
        for (int i = 0; i < aOs; i++)
        {
            if (aOt[i] != ((GF2Polynomial) (obj)).aOt[i])
            {
                return false;
            }
        }

        return true;
    }

    public int hashCode()
    {
        return len + aOt.hashCode();
    }

    public final boolean isZero()
    {
        if (len == 0)
        {
            return true;
        }
        for (int i = 0; i < aOs; i++)
        {
            if (aOt[i] != 0)
            {
                return false;
            }
        }

        return true;
    }

    public final GF2Polynomial _mth02CB(GF2Polynomial gf2polynomial)
    {
        GF2Polynomial gf2polynomial1 = new GF2Polynomial(this);
        gf2polynomial = new GF2Polynomial(gf2polynomial);
        if (gf2polynomial.isZero())
        {
            throw new RuntimeException();
        }
        gf2polynomial1._mth1431();
        gf2polynomial._mth1431();
        if (gf2polynomial1.len < gf2polynomial.len)
        {
            return gf2polynomial1;
        }
        do
        {
            int i = gf2polynomial1.len - gf2polynomial.len;
            if (i >= 0)
            {
                gf2polynomial1._mth02CA(gf2polynomial.FEA9(i));
                gf2polynomial1._mth1431();
            } else
            {
                return gf2polynomial1;
            }
        } while (true);
    }

    public final void _mth13DD()
    {
        for (int i = 0; i < aOs; i++)
        {
            aOt[i] = aOu.nextInt();
        }

        _mth14EE();
    }

    public final void _mth1431()
    {
        int i;
        for (i = aOs - 1; aOt[i] == 0 && i > 0; i--) { }
        int k = aOt[i];
        int j;
        for (j = 0; k != 0; j++)
        {
            k >>>= 1;
        }

        len = (i << 5) + j;
        aOs = i + 1;
    }

    void _mth14EE()
    {
        if ((len & 0x1f) != 0)
        {
            int ai[] = aOt;
            int i = aOs - 1;
            ai[i] = ai[i] & aOx[len & 0x1f];
        }
    }

    public final void FE9B(int i)
    {
        if (i < 0 || i > len - 1)
        {
            throw new RuntimeException();
        }
        if (i > len - 1)
        {
            return;
        } else
        {
            int ai[] = aOt;
            int j = i >>> 5;
            ai[j] = ai[j] | aOw[i & 0x1f];
            return;
        }
    }

    public final boolean FF53()
    {
        for (int i = 1; i < aOs; i++)
        {
            if (aOt[i] != 0)
            {
                return false;
            }
        }

        return aOt[0] == 1;
    }

}
