// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.util.Arrays;

class LongArray
{

    private static final int aIO[] = {
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
    static final byte aIP[] = {
        0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 
        4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 
        5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 
        5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 
        6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 
        6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 
        6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 
        7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 
        7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 
        7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 
        7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 
        7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 
        7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 
        8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 
        8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 
        8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 
        8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 
        8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 
        8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 
        8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 
        8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 
        8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 
        8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 
        8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 
        8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 
        8, 8, 8, 8, 8, 8
    };
    long aIQ[];

    private LongArray(int i)
    {
        aIQ = new long[i];
    }

    public LongArray(BigInteger biginteger)
    {
        if (biginteger == null || biginteger.signum() < 0)
        {
            throw new IllegalArgumentException("invalid F2m field value");
        }
        if (biginteger.signum() == 0)
        {
            aIQ = (new long[] {
                0L
            });
            return;
        }
        biginteger = biginteger.toByteArray();
        int j = biginteger.length;
        int k = 0;
        int i = j;
        if (biginteger[0] == 0)
        {
            i = j - 1;
            k = 1;
        }
        j = (i + 7) / 8;
        aIQ = new long[j];
        int k1 = j - 1;
        int l1 = i % 8 + k;
        long l2 = 0L;
        int i1 = k;
        j = k1;
        i = i1;
        if (k < l1)
        {
            for (i = i1; i < l1; i++)
            {
                l2 = l2 << 8 | (long)(biginteger[i] & 0xff);
            }

            long al[] = aIQ;
            j = k1 - 1;
            al[k1] = l2;
        }
        for (; j >= 0; j--)
        {
            long l3 = 0L;
            for (int l = 0; l < 8;)
            {
                int j1 = i + 1;
                l3 = l3 << 8 | (long)(biginteger[i] & 0xff);
                l++;
                i = j1;
            }

            aIQ[j] = l3;
        }

    }

    public LongArray(long al[])
    {
        aIQ = al;
    }

    public LongArray(long al[], int i, int j)
    {
        if (i == 0 && j == al.length)
        {
            aIQ = al;
            return;
        } else
        {
            aIQ = new long[j];
            System.arraycopy(al, i, aIQ, 0, j);
            return;
        }
    }

    static int _mth02CA(long al[], int i, int j, int k, int ai[])
    {
        int i2 = k + 63 >>> 6;
        if (j < i2)
        {
            return j;
        }
        int k1 = Math.min(j << 6, (k << 1) - 1);
        int l;
        for (l = (j << 6) - k1; l >= 64; l -= 64)
        {
            j--;
        }

        int j1 = ai.length;
        int l1 = ai[j1 - 1];
        if (j1 > 1)
        {
            j1 = ai[j1 - 2];
        } else
        {
            j1 = 0;
        }
        l1 = Math.max(k, l1 + 64);
        int j2 = Math.min(k1 - l1, k - j1) + l >> 6;
        l = k1;
        j1 = j;
        if (j2 > 1)
        {
            l = j - j2;
            _mth02CB(al, i, j, l, k, ai);
            while (j > l) 
            {
                j--;
                al[i + j] = 0L;
            }
            l <<= 6;
            j1 = j;
        }
        j = l;
        if (l > l1)
        {
            _mth02CA(al, i, j1, l1, k, ai);
            j = l1;
        }
        if (j > k)
        {
            do
            {
                int i1 = j - 1;
                if (i1 < k)
                {
                    break;
                }
                j = i1;
                if (_mth02CA(al, i, i1))
                {
                    _mth02CB(al, i, i1, k, ai);
                    j = i1;
                }
            } while (true);
        }
        return i2;
    }

    private static long _mth02CA(long al[], int i, long al1[], int j, int k, int l)
    {
        long l1 = 0L;
        for (int i1 = 0; i1 < k; i1++)
        {
            long l2 = al[i + i1];
            al1[j + i1] = l2 << l | l1;
            l1 = l2 >>> 64 - l;
        }

        return l1;
    }

    private static void _mth02CA(long l, long al[], int i, long al1[], int j)
    {
        if ((1L & l) != 0L)
        {
            for (j = 0; j < i; j++)
            {
                int k = j + 0;
                al1[k] = al1[k] ^ al[j + 0];
            }

        }
        j = 1;
        do
        {
            long l1 = l >>> 1;
            l = l1;
            if (l1 != 0L)
            {
                if ((1L & l) != 0L)
                {
                    long l2 = _mth02CB(al1, 0, al, 0, i, j);
                    if (l2 != 0L)
                    {
                        int i1 = i + 0;
                        al1[i1] = al1[i1] ^ l2;
                    }
                }
                j++;
            } else
            {
                return;
            }
        } while (true);
    }

    private void _mth02CA(LongArray longarray, int i, int j)
    {
        int k = i + 63 >>> 6;
        int l = j >>> 6;
        i = j & 0x3f;
        if (i == 0)
        {
            long al[] = aIQ;
            longarray = longarray.aIQ;
            for (i = 0; i < k; i++)
            {
                j = l + i;
                al[j] = al[j] ^ longarray[i + 0];
            }

            return;
        }
        long l1 = _mth02CB(aIQ, l, longarray.aIQ, 0, k, i);
        if (l1 != 0L)
        {
            longarray = aIQ;
            i = k + l;
            longarray[i] = longarray[i] ^ l1;
        }
    }

    static void _mth02CA(long al[], int i)
    {
        int k = i << 1;
        int j = i;
        i = k;
        do
        {
            j--;
            if (j >= 0)
            {
                long l = al[j];
                i--;
                al[i] = _mth1646((int)(l >>> 32));
                i--;
                al[i] = _mth1646((int)l);
            } else
            {
                return;
            }
        } while (true);
    }

    private static void _mth02CA(long al[], int i, int j, int k, int l, int ai[])
    {
        int i1 = k >>> 6;
        do
        {
            j--;
            if (j <= i1)
            {
                break;
            }
            long l1 = al[i + j];
            if (l1 != 0L)
            {
                al[i + j] = 0L;
                _mth02CA(al, i, j << 6, l1, l, ai);
            }
        } while (true);
        j = k & 0x3f;
        long l2 = al[i + i1] >>> j;
        if (l2 != 0L)
        {
            i1 = i + i1;
            al[i1] = al[i1] ^ l2 << j;
            _mth02CA(al, i, k, l2, l, ai);
        }
    }

    private static void _mth02CA(long al[], int i, int j, long l)
    {
        i += j >>> 6;
        j &= 0x3f;
        if (j == 0)
        {
            al[i] = al[i] ^ l;
            return;
        }
        al[i] = al[i] ^ l << j;
        l >>>= 64 - j;
        if (l != 0L)
        {
            i++;
            al[i] = al[i] ^ l;
        }
    }

    private static void _mth02CA(long al[], int i, int j, long l, int k, int ai[])
    {
        k = j - k;
        j = ai.length;
        do
        {
            j--;
            if (j >= 0)
            {
                _mth02CA(al, i, ai[j] + k, l);
            } else
            {
                _mth02CA(al, i, k, l);
                return;
            }
        } while (true);
    }

    private static void _mth02CA(long al[], int i, long al1[], int j, long al2[], int k, int l)
    {
        for (int i1 = 0; i1 < l; i1++)
        {
            al2[k + i1] = al[i + i1] ^ al1[j + i1];
        }

    }

    private static boolean _mth02CA(long al[], int i, int j)
    {
        return (al[i + (j >>> 6)] & 1L << (j & 0x3f)) != 0L;
    }

    private static long _mth02CB(long al[], int i, long al1[], int j, int k, int l)
    {
        long l1 = 0L;
        for (int i1 = 0; i1 < k; i1++)
        {
            long l2 = al1[j + i1];
            int j1 = i + i1;
            al[j1] = al[j1] ^ (l2 << l | l1);
            l1 = l2 >>> 64 - l;
        }

        return l1;
    }

    private static void _mth02CB(long al[], int i, int j, int k, int l, int ai[])
    {
        int i1 = (k << 6) - l;
        l = ai.length;
        do
        {
            l--;
            if (l >= 0)
            {
                _mth02CF(al, i, al, i + k, j - k, ai[l] + i1);
            } else
            {
                _mth02CF(al, i, al, i + k, j - k, i1);
                return;
            }
        } while (true);
    }

    private static void _mth02CB(long al[], int i, int j, int k, int ai[])
    {
        int l = i + (j >>> 6);
        al[l] = al[l] ^ 1L << (j & 0x3f);
        k = j - k;
        j = ai.length;
        do
        {
            j--;
            if (j >= 0)
            {
                int i1 = ai[j] + k;
                int j1 = i + (i1 >>> 6);
                al[j1] = al[j1] ^ 1L << (i1 & 0x3f);
            } else
            {
                i += k >>> 6;
                al[i] = al[i] ^ 1L << (k & 0x3f);
                return;
            }
        } while (true);
    }

    private static void _mth02CB(long al[], int i, long al1[], int j, long al2[], int k, int l)
    {
        for (int i1 = 0; i1 < l; i1++)
        {
            int j1 = i + i1;
            al[j1] = al[j1] ^ (al1[j + i1] ^ al2[k + i1]);
        }

    }

    private static long _mth02CE(long al[], int i, long al1[], int j, int k, int l)
    {
        long l1 = 0L;
        do
        {
            k--;
            if (k >= 0)
            {
                long l2 = al1[j + k];
                int i1 = i + k;
                al[i1] = al[i1] ^ (l2 >>> l | l1);
                l1 = l2 << 64 - l;
            } else
            {
                return l1;
            }
        } while (true);
    }

    private static void _mth02CF(long al[], int i, long al1[], int j, int k, int l)
    {
        int i1 = i + (l >>> 6);
        i = l & 0x3f;
        if (i == 0)
        {
            for (i = 0; i < k; i++)
            {
                l = i1 + i;
                al[l] = al[l] ^ al1[j + i];
            }

            return;
        } else
        {
            long l1 = _mth02CE(al, i1 + 1, al1, j, k, 64 - i);
            al[i1] = al[i1] ^ l1;
            return;
        }
    }

    private int _mth156A(int i)
    {
        i = i + 62 >>> 6;
        int j;
        long l;
        do
        {
            if (i == 0)
            {
                return 0;
            }
            long al[] = aIQ;
            j = i - 1;
            l = al[j];
            i = j;
        } while (l == 0L);
        return (j << 6) + _mth1D35(l);
    }

    static long _mth1646(int i)
    {
        int j = aIO[i & 0xff];
        int k = aIO[i >>> 8 & 0xff];
        return ((long)(aIO[i >>> 16 & 0xff] | aIO[i >>> 24] << 16) & 0xffffffffL) << 32 | (long)(j | k << 16) & 0xffffffffL;
    }

    private static int _mth1D35(long l)
    {
        int j = (int)(l >>> 32);
        int i = j;
        if (j == 0)
        {
            i = (int)l;
            j = 0;
        } else
        {
            j = 32;
        }
        int k = i >>> 16;
        if (k == 0)
        {
            k = i >>> 8;
            if (k == 0)
            {
                i = aIP[i];
            } else
            {
                i = aIP[k] + 8;
            }
        } else
        {
            i = k >>> 8;
            if (i == 0)
            {
                i = aIP[k] + 16;
            } else
            {
                i = aIP[i] + 24;
            }
        }
        return j + i;
    }

    public Object clone()
    {
        return new LongArray(Arrays._mth02BF(aIQ));
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof LongArray))
        {
            return false;
        }
        obj = (LongArray)obj;
        int j = _mth14D2(aIQ.length);
        if (((LongArray) (obj))._mth14D2(((LongArray) (obj)).aIQ.length) != j)
        {
            return false;
        }
        for (int i = 0; i < j; i++)
        {
            if (aIQ[i] != ((LongArray) (obj)).aIQ[i])
            {
                return false;
            }
        }

        return true;
    }

    public int hashCode()
    {
        int k = _mth14D2(aIQ.length);
        int j = 1;
        for (int i = 0; i < k; i++)
        {
            long l = aIQ[i];
            j = (j * 31 ^ (int)l) * 31 ^ (int)(l >>> 32);
        }

        return j;
    }

    public String toString()
    {
        int i = _mth14D2(aIQ.length);
        if (i == 0)
        {
            return "0";
        }
        long al[] = aIQ;
        i--;
        StringBuffer stringbuffer = new StringBuffer(Long.toBinaryString(al[i]));
        do
        {
            i--;
            if (i >= 0)
            {
                String s = Long.toBinaryString(aIQ[i]);
                int j = s.length();
                if (j < 64)
                {
                    stringbuffer.append("0000000000000000000000000000000000000000000000000000000000000000".substring(j));
                }
                stringbuffer.append(s);
            } else
            {
                return stringbuffer.toString();
            }
        } while (true);
    }

    public final LongArray _mth02CA(LongArray longarray)
    {
        int j = _mth03EE();
        int i = j;
        if (j == 0)
        {
            return this;
        }
        int i1 = longarray._mth03EE();
        j = i1;
        if (i1 == 0)
        {
            return longarray;
        }
        LongArray longarray1 = this;
        LongArray longarray2 = longarray;
        int j1 = i;
        i1 = j;
        if (i > j)
        {
            longarray2 = this;
            longarray1 = longarray;
            i1 = i;
            j1 = j;
        }
        int j2 = j1 + 63 >>> 6;
        j = i1 + 63 >>> 6;
        int i2 = j1 + i1 + 62 >>> 6;
        if (j2 == 1)
        {
            long l2 = longarray1.aIQ[0];
            if (l2 == 1L)
            {
                return longarray2;
            } else
            {
                longarray = new long[i2];
                _mth02CA(l2, longarray2.aIQ, j, ((long []) (longarray)), 0);
                return new LongArray(longarray, 0, i2);
            }
        }
        i1 = i1 + 7 + 63 >>> 6;
        longarray = new int[16];
        long al2[] = new long[i1 << 4];
        i = i1;
        longarray[1] = i;
        System.arraycopy(longarray2.aIQ, 0, al2, i, j);
        j1 = 2;
        j = i;
        for (i = j1; i < 16; i++)
        {
            int k1 = j + i1;
            j = k1;
            longarray[i] = k1;
            if ((i & 1) == 0)
            {
                _mth02CA(al2, j >>> 1, al2, j, i1, 1);
            } else
            {
                _mth02CA(al2, i1, al2, j - i1, al2, j, i1);
            }
        }

        long al1[] = new long[al2.length];
        _mth02CA(al2, 0, al1, 0, al2.length, 4);
        long al[] = longarray1.aIQ;
        long al3[] = new long[i2 << 3];
label0:
        for (i = 0; i < j2; i++)
        {
            long l3 = al[i];
            int k = i;
            do
            {
                int l1 = (int)l3;
                l3 >>>= 4;
                int k2 = (int)l3;
                _mth02CB(al3, k, al2, longarray[l1 & 0xf], al1, longarray[k2 & 0xf], i1);
                long l4 = l3 >>> 4;
                l3 = l4;
                if (l4 == 0L)
                {
                    continue label0;
                }
                k += i2;
            } while (true);
        }

        i = al3.length;
        do
        {
            int l = i - i2;
            i = l;
            if (l != 0)
            {
                _mth02CB(al3, i - i2, al3, i, i2, 8);
            } else
            {
                return new LongArray(al3, 0, i2);
            }
        } while (true);
    }

    public final LongArray _mth02CA(LongArray longarray, int i, int ai[])
    {
        int k = _mth03EE();
        int j = k;
        if (k == 0)
        {
            return this;
        }
        int j1 = longarray._mth03EE();
        k = j1;
        if (j1 == 0)
        {
            return longarray;
        }
        LongArray longarray1 = this;
        LongArray longarray2 = longarray;
        int k1 = j;
        j1 = k;
        if (j > k)
        {
            longarray2 = this;
            longarray1 = longarray;
            j1 = j;
            k1 = k;
        }
        int k2 = k1 + 63 >>> 6;
        k = j1 + 63 >>> 6;
        int j2 = k1 + j1 + 62 >>> 6;
        if (k2 == 1)
        {
            long l3 = longarray1.aIQ[0];
            if (l3 == 1L)
            {
                return longarray2;
            } else
            {
                longarray = new long[j2];
                _mth02CA(l3, longarray2.aIQ, k, ((long []) (longarray)), 0);
                return new LongArray(longarray, 0, _mth02CA(((long []) (longarray)), 0, j2, i, ai));
            }
        }
        j1 = j1 + 7 + 63 >>> 6;
        longarray = new int[16];
        long al2[] = new long[j1 << 4];
        j = j1;
        longarray[1] = j;
        System.arraycopy(longarray2.aIQ, 0, al2, j, k);
        k1 = 2;
        k = j;
        for (j = k1; j < 16; j++)
        {
            int l1 = k + j1;
            k = l1;
            longarray[j] = l1;
            if ((j & 1) == 0)
            {
                _mth02CA(al2, k >>> 1, al2, k, j1, 1);
            } else
            {
                _mth02CA(al2, j1, al2, k - j1, al2, k, j1);
            }
        }

        long al1[] = new long[al2.length];
        _mth02CA(al2, 0, al1, 0, al2.length, 4);
        long al[] = longarray1.aIQ;
        long al3[] = new long[j2 << 3];
label0:
        for (j = 0; j < k2; j++)
        {
            long l4 = al[j];
            int l = j;
            do
            {
                int i2 = (int)l4;
                l4 >>>= 4;
                int l2 = (int)l4;
                _mth02CB(al3, l, al2, longarray[i2 & 0xf], al1, longarray[l2 & 0xf], j1);
                long l5 = l4 >>> 4;
                l4 = l5;
                if (l5 == 0L)
                {
                    continue label0;
                }
                l += j2;
            } while (true);
        }

        j = al3.length;
        do
        {
            int i1 = j - j2;
            j = i1;
            if (i1 != 0)
            {
                _mth02CB(al3, j - j2, al3, j, j2, 8);
            } else
            {
                return new LongArray(al3, 0, _mth02CA(al3, 0, j2, i, ai));
            }
        } while (true);
    }

    public final void _mth02CA(LongArray longarray, int i)
    {
        int j = longarray._mth14D2(longarray.aIQ.length);
        if (j == 0)
        {
            return;
        }
        if (j > aIQ.length)
        {
            long al[] = new long[j];
            System.arraycopy(aIQ, 0, al, 0, Math.min(aIQ.length, j));
            aIQ = al;
        }
        long al1[] = aIQ;
        longarray = longarray.aIQ;
        for (i = 0; i < j; i++)
        {
            int k = i + 0;
            al1[k] = al1[k] ^ longarray[i + 0];
        }

    }

    public final void _mth02CB(int i, int ai[])
    {
        long al[] = aIQ;
        i = _mth02CA(al, 0, al.length, i, ai);
        if (i < al.length)
        {
            aIQ = new long[i];
            System.arraycopy(al, 0, aIQ, 0, i);
        }
    }

    public final LongArray _mth02CE(int i, int ai[])
    {
        int j = _mth14D2(aIQ.length);
        if (j == 0)
        {
            return this;
        }
        int l = j << 1;
        long al[] = new long[l];
        for (int k = 0; k < l;)
        {
            long l1 = aIQ[k >>> 1];
            int i1 = k + 1;
            al[k] = _mth1646((int)l1);
            k = i1 + 1;
            al[i1] = _mth1646((int)(l1 >>> 32));
        }

        return new LongArray(al, 0, _mth02CA(al, 0, al.length, i, ai));
    }

    public final LongArray _mth02CF(int i, int ai[])
    {
        int j = _mth03EE();
        if (j == 0)
        {
            throw new IllegalStateException();
        }
        if (j == 1)
        {
            return this;
        }
        LongArray longarray1 = (LongArray)clone();
        int l = i + 63 >>> 6;
        LongArray longarray2 = new LongArray(l);
        _mth02CB(longarray2.aIQ, 0, i, i, ai);
        ai = new LongArray(l);
        ((LongArray) (ai)).aIQ[0] = 1L;
        LongArray longarray = new LongArray(l);
        int ai1[] = new int[2];
        ai1[0] = j;
        ai1[1] = i + 1;
        LongArray alongarray[] = new LongArray[2];
        alongarray[0] = longarray1;
        alongarray[1] = longarray2;
        int ai2[] = new int[2];
        int[] _tmp = ai2;
        ai2[0] = 1;
        ai2[1] = 0;
        LongArray alongarray1[] = new LongArray[2];
        alongarray1[0] = ai;
        alongarray1[1] = longarray;
        int i2 = 1;
        l = ai1[1];
        i = ai2[1];
        int i1 = l - ai1[0];
        do
        {
            int k1 = i2;
            int l1 = l;
            int k = i;
            int j1 = i1;
            if (i1 < 0)
            {
                j1 = -i1;
                ai1[i2] = l;
                ai2[i2] = i;
                k1 = 1 - i2;
                l1 = ai1[k1];
                k = ai2[k1];
            }
            alongarray[k1]._mth02CA(alongarray[1 - k1], ai1[1 - k1], j1);
            l = alongarray[k1]._mth156A(l1);
            if (l == 0)
            {
                return alongarray1[1 - k1];
            }
            i = ai2[1 - k1];
            alongarray1[k1]._mth02CA(alongarray1[1 - k1], i, j1);
            i1 = i + j1;
            if (i1 > k)
            {
                i = i1;
            } else
            {
                i = k;
                if (i1 == k)
                {
                    i = alongarray1[k1]._mth156A(k);
                }
            }
            i1 = j1 + (l - l1);
            i2 = k1;
        } while (true);
    }

    public final int _mth03DD()
    {
        return _mth14D2(aIQ.length);
    }

    public final int _mth03EE()
    {
        int i = aIQ.length;
        int j;
        long l;
        do
        {
            if (i == 0)
            {
                return 0;
            }
            long al[] = aIQ;
            j = i - 1;
            l = al[j];
            i = j;
        } while (l == 0L);
        return (j << 6) + _mth1D35(l);
    }

    public final int _mth14D2(int i)
    {
        long al[] = aIQ;
        int j = Math.min(i, al.length);
        i = j;
        if (j <= 0)
        {
            return 0;
        }
        j = i;
        if (al[0] != 0L)
        {
            do
            {
                j = i - 1;
                i = j;
            } while (al[j] == 0L);
            return j + 1;
        }
        do
        {
            i = j - 1;
            if (al[i] != 0L)
            {
                return i + 1;
            }
            j = i;
        } while (i > 0);
        return 0;
    }

    public final boolean FF53()
    {
        long al[] = aIQ;
        if (al[0] != 1L)
        {
            return false;
        }
        for (int i = 1; i < al.length; i++)
        {
            if (al[i] != 0L)
            {
                return false;
            }
        }

        return true;
    }

}
