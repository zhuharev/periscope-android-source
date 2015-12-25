// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util;

import java.math.BigInteger;

public final class Arrays
{

    private Arrays()
    {
    }

    public static byte[] copyOf(byte abyte0[], int i)
    {
        byte abyte1[] = new byte[i];
        if (i < abyte0.length)
        {
            System.arraycopy(abyte0, 0, abyte1, 0, i);
            return abyte1;
        } else
        {
            System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
            return abyte1;
        }
    }

    public static int[] copyOf(int ai[], int i)
    {
        int ai1[] = new int[i];
        if (i < ai.length)
        {
            System.arraycopy(ai, 0, ai1, 0, i);
            return ai1;
        } else
        {
            System.arraycopy(ai, 0, ai1, 0, ai.length);
            return ai1;
        }
    }

    public static long[] copyOf(long al[], int i)
    {
        long al1[] = new long[i];
        if (i < al.length)
        {
            System.arraycopy(al, 0, al1, 0, i);
            return al1;
        } else
        {
            System.arraycopy(al, 0, al1, 0, al.length);
            return al1;
        }
    }

    public static byte[] copyOfRange(byte abyte0[], int i, int j)
    {
        j = _mth02B2(i, j);
        byte abyte1[] = new byte[j];
        if (abyte0.length - i < j)
        {
            System.arraycopy(abyte0, i, abyte1, 0, abyte0.length - i);
            return abyte1;
        } else
        {
            System.arraycopy(abyte0, i, abyte1, 0, j);
            return abyte1;
        }
    }

    public static int[] copyOfRange(int ai[], int i, int j)
    {
        j = _mth02B2(i, j);
        int ai1[] = new int[j];
        if (ai.length - i < j)
        {
            System.arraycopy(ai, i, ai1, 0, ai.length - i);
            return ai1;
        } else
        {
            System.arraycopy(ai, i, ai1, 0, j);
            return ai1;
        }
    }

    public static long[] copyOfRange(long al[], int i, int j)
    {
        j = _mth02B2(i, j);
        long al1[] = new long[j];
        if (al.length - i < j)
        {
            System.arraycopy(al, i, al1, 0, al.length - i);
            return al1;
        } else
        {
            System.arraycopy(al, i, al1, 0, j);
            return al1;
        }
    }

    public static void fill(byte abyte0[], byte byte0)
    {
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = byte0;
        }

    }

    public static void fill(long al[], long l)
    {
        for (int i = 0; i < al.length; i++)
        {
            al[i] = 0L;
        }

    }

    public static void fill(short aword0[], short word0)
    {
        for (word0 = 0; word0 < aword0.length; word0++)
        {
            aword0[word0] = 0;
        }

    }

    public static int hashCode(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return 0;
        }
        int j = abyte0.length;
        int i = j;
        j++;
        do
        {
            i--;
            if (i >= 0)
            {
                j = j * 257 ^ abyte0[i];
            } else
            {
                return j;
            }
        } while (true);
    }

    public static int hashCode(char ac[])
    {
        if (ac == null)
        {
            return 0;
        }
        int j = ac.length;
        int i = j;
        j++;
        do
        {
            i--;
            if (i >= 0)
            {
                j = j * 257 ^ ac[i];
            } else
            {
                return j;
            }
        } while (true);
    }

    public static int hashCode(int ai[])
    {
        if (ai == null)
        {
            return 0;
        }
        int j = ai.length;
        int i = j;
        j++;
        do
        {
            i--;
            if (i >= 0)
            {
                j = j * 257 ^ ai[i];
            } else
            {
                return j;
            }
        } while (true);
    }

    public static int hashCode(short aword0[])
    {
        if (aword0 == null)
        {
            return 0;
        }
        int j = aword0.length;
        int i = j;
        j++;
        do
        {
            i--;
            if (i >= 0)
            {
                j = j * 257 ^ aword0[i] & 0xff;
            } else
            {
                return j;
            }
        } while (true);
    }

    private static int _mth02B2(int i, int j)
    {
        int k = j - i;
        if (k < 0)
        {
            StringBuffer stringbuffer = new StringBuffer(i);
            stringbuffer.append(" > ").append(j);
            throw new IllegalArgumentException(stringbuffer.toString());
        } else
        {
            return k;
        }
    }

    public static boolean _mth02BD(int ai[], int i)
    {
        for (int j = 0; j < ai.length; j++)
        {
            if (ai[j] == i)
            {
                return true;
            }
        }

        return false;
    }

    public static long[] _mth02BF(long al[])
    {
        if (al == null)
        {
            return null;
        } else
        {
            long al1[] = new long[al.length];
            System.arraycopy(al, 0, al1, 0, al.length);
            return al1;
        }
    }

    public static int _mth02CA(BigInteger abiginteger[])
    {
        if (abiginteger == null)
        {
            return 0;
        }
        int j = abiginteger.length;
        int i = j;
        j++;
        do
        {
            i--;
            if (i >= 0)
            {
                j = j * 257 ^ abiginteger[i].hashCode();
            } else
            {
                return j;
            }
        } while (true);
    }

    public static boolean _mth02CA(char ac[], char ac1[])
    {
        if (ac == ac1)
        {
            return true;
        }
        if (ac == null || ac1 == null)
        {
            return false;
        }
        if (ac.length != ac1.length)
        {
            return false;
        }
        for (int i = 0; i != ac.length; i++)
        {
            if (ac[i] != ac1[i])
            {
                return false;
            }
        }

        return true;
    }

    public static boolean _mth02CA(BigInteger abiginteger[], BigInteger abiginteger1[])
    {
        if (abiginteger == abiginteger1)
        {
            return true;
        }
        if (abiginteger == null || abiginteger1 == null)
        {
            return false;
        }
        if (abiginteger.length != abiginteger1.length)
        {
            return false;
        }
        for (int i = 0; i != abiginteger.length; i++)
        {
            BigInteger biginteger = abiginteger[i];
            BigInteger biginteger1 = abiginteger1[i];
            if (biginteger == null)
            {
                if (biginteger1 != null)
                {
                    return false;
                }
                continue;
            }
            if (!biginteger.equals(biginteger1))
            {
                return false;
            }
        }

        return true;
    }

    public static BigInteger[] _mth02CA(BigInteger abiginteger[], int i)
    {
        BigInteger abiginteger1[] = new BigInteger[i];
        if (i < abiginteger.length)
        {
            System.arraycopy(abiginteger, 0, abiginteger1, 0, i);
            return abiginteger1;
        } else
        {
            System.arraycopy(abiginteger, 0, abiginteger1, 0, abiginteger.length);
            return abiginteger1;
        }
    }

    public static BigInteger[] _mth02CA(BigInteger abiginteger[], int i, int j)
    {
        j = _mth02B2(i, j);
        BigInteger abiginteger1[] = new BigInteger[j];
        if (abiginteger.length - i < j)
        {
            System.arraycopy(abiginteger, i, abiginteger1, 0, abiginteger.length - i);
            return abiginteger1;
        } else
        {
            System.arraycopy(abiginteger, i, abiginteger1, 0, j);
            return abiginteger1;
        }
    }

    public static byte[][] _mth02CA(byte abyte0[][])
    {
        if (abyte0 == null)
        {
            return null;
        }
        byte abyte2[][] = new byte[abyte0.length][];
        for (int i = 0; i != abyte2.length; i++)
        {
            byte abyte3[] = abyte0[i];
            byte abyte1[];
            if (abyte3 == null)
            {
                abyte1 = null;
            } else
            {
                abyte1 = new byte[abyte3.length];
                System.arraycopy(abyte3, 0, abyte1, 0, abyte3.length);
            }
            abyte2[i] = abyte1;
        }

        return abyte2;
    }

    public static int _mth02CB(int ai[], int i, int j)
    {
        if (ai == null)
        {
            return 0;
        }
        i = j;
        j++;
        do
        {
            i--;
            if (i >= 0)
            {
                j = j * 257 ^ ai[i + 0];
            } else
            {
                return j;
            }
        } while (true);
    }

    public static boolean _mth02CB(short aword0[], short word0)
    {
        for (int i = 0; i < aword0.length; i++)
        {
            if (aword0[i] == word0)
            {
                return true;
            }
        }

        return false;
    }

    public static byte[] _mth02CB(byte abyte0[], byte byte0)
    {
        if (abyte0 == null)
        {
            return (new byte[] {
                byte0
            });
        } else
        {
            int i = abyte0.length;
            byte abyte1[] = new byte[i + 1];
            System.arraycopy(abyte0, 0, abyte1, 1, i);
            abyte1[0] = byte0;
            return abyte1;
        }
    }

    public static BigInteger[] _mth02CB(BigInteger abiginteger[])
    {
        if (abiginteger == null)
        {
            return null;
        } else
        {
            BigInteger abiginteger1[] = new BigInteger[abiginteger.length];
            System.arraycopy(abiginteger, 0, abiginteger1, 0, abiginteger.length);
            return abiginteger1;
        }
    }

    public static short[] _mth02CB(short aword0[])
    {
        if (aword0 == null)
        {
            return null;
        } else
        {
            short aword1[] = new short[aword0.length];
            System.arraycopy(aword0, 0, aword1, 0, aword0.length);
            return aword1;
        }
    }

    public static byte[][][] _mth02CB(byte abyte0[][][])
    {
        if (abyte0 == null)
        {
            return null;
        }
        byte abyte1[][][] = new byte[abyte0.length][][];
        for (int i = 0; i != abyte1.length; i++)
        {
            abyte1[i] = _mth02CA(abyte0[i]);
        }

        return abyte1;
    }

    public static int _mth02CE(short aword0[][])
    {
        int j = 0;
        for (int i = 0; i != aword0.length; i++)
        {
            j = j * 257 + hashCode(aword0[i]);
        }

        return j;
    }

    public static int _mth02CE(short aword0[][][])
    {
        int j = 0;
        for (int i = 0; i != aword0.length; i++)
        {
            short aword1[][] = aword0[i];
            int l = 0;
            for (int k = 0; k != aword1.length; k++)
            {
                l = l * 257 + hashCode(aword1[k]);
            }

            j = j * 257 + l;
        }

        return j;
    }

    public static byte[] _mth02CE(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        if (abyte0 != null && abyte1 != null && abyte2 != null)
        {
            byte abyte3[] = new byte[abyte0.length + abyte1.length + abyte2.length];
            System.arraycopy(abyte0, 0, abyte3, 0, abyte0.length);
            System.arraycopy(abyte1, 0, abyte3, abyte0.length, abyte1.length);
            System.arraycopy(abyte2, 0, abyte3, abyte0.length + abyte1.length, abyte2.length);
            return abyte3;
        }
        if (abyte1 == null)
        {
            return _mth0640(abyte0, abyte2);
        } else
        {
            return _mth0640(abyte0, abyte1);
        }
    }

    public static byte[] _mth02CE(byte abyte0[], byte abyte1[], byte abyte2[], byte abyte3[])
    {
        if (abyte0 != null && abyte1 != null && abyte2 != null && abyte3 != null)
        {
            byte abyte4[] = new byte[abyte0.length + abyte1.length + abyte2.length + abyte3.length];
            System.arraycopy(abyte0, 0, abyte4, 0, abyte0.length);
            System.arraycopy(abyte1, 0, abyte4, abyte0.length, abyte1.length);
            System.arraycopy(abyte2, 0, abyte4, abyte0.length + abyte1.length, abyte2.length);
            System.arraycopy(abyte3, 0, abyte4, abyte0.length + abyte1.length + abyte2.length, abyte3.length);
            return abyte4;
        }
        if (abyte3 == null)
        {
            return _mth02CE(abyte0, abyte1, abyte2);
        }
        if (abyte2 == null)
        {
            return _mth02CE(abyte0, abyte1, abyte3);
        }
        if (abyte1 == null)
        {
            return _mth02CE(abyte0, abyte2, abyte3);
        } else
        {
            return _mth02CE(abyte1, abyte2, abyte3);
        }
    }

    public static boolean _mth02CF(long al[], long al1[])
    {
        if (al == al1)
        {
            return true;
        }
        if (al == null || al1 == null)
        {
            return false;
        }
        if (al.length != al1.length)
        {
            return false;
        }
        for (int i = 0; i != al.length; i++)
        {
            if (al[i] != al1[i])
            {
                return false;
            }
        }

        return true;
    }

    public static int[] _mth02D1(int ai[])
    {
        if (ai == null)
        {
            return null;
        } else
        {
            int ai1[] = new int[ai.length];
            System.arraycopy(ai, 0, ai1, 0, ai.length);
            return ai1;
        }
    }

    public static byte[] _mth0640(byte abyte0[], byte abyte1[])
    {
        if (abyte0 != null && abyte1 != null)
        {
            byte abyte2[] = new byte[abyte0.length + abyte1.length];
            System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
            System.arraycopy(abyte1, 0, abyte2, abyte0.length, abyte1.length);
            return abyte2;
        }
        if (abyte1 != null)
        {
            if (abyte1 == null)
            {
                return null;
            } else
            {
                abyte0 = new byte[abyte1.length];
                System.arraycopy(abyte1, 0, abyte0, 0, abyte1.length);
                return abyte0;
            }
        }
        if (abyte0 == null)
        {
            return null;
        } else
        {
            abyte1 = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
            return abyte1;
        }
    }

    public static long[] _mth141D(long al[], long al1[])
    {
        if (al == null)
        {
            return null;
        }
        if (al1 == null || al1.length != al.length)
        {
            if (al == null)
            {
                return null;
            } else
            {
                al1 = new long[al.length];
                System.arraycopy(al, 0, al1, 0, al.length);
                return al1;
            }
        } else
        {
            System.arraycopy(al, 0, al1, 0, al1.length);
            return al1;
        }
    }

    public static boolean _mth1427(byte abyte0[], byte abyte1[])
    {
        if (abyte0 == abyte1)
        {
            return true;
        }
        if (abyte0 == null || abyte1 == null)
        {
            return false;
        }
        if (abyte0.length != abyte1.length)
        {
            return false;
        }
        for (int i = 0; i != abyte0.length; i++)
        {
            if (abyte0[i] != abyte1[i])
            {
                return false;
            }
        }

        return true;
    }

    public static boolean _mth1427(int ai[], int ai1[])
    {
        if (ai == ai1)
        {
            return true;
        }
        if (ai == null || ai1 == null)
        {
            return false;
        }
        if (ai.length != ai1.length)
        {
            return false;
        }
        for (int i = 0; i != ai.length; i++)
        {
            if (ai[i] != ai1[i])
            {
                return false;
            }
        }

        return true;
    }

    public static boolean _mth1428(byte abyte0[], byte abyte1[])
    {
        if (abyte0 == abyte1)
        {
            return true;
        }
        if (abyte0 == null || abyte1 == null)
        {
            return false;
        }
        if (abyte0.length != abyte1.length)
        {
            return false;
        }
        int j = 0;
        for (int i = 0; i != abyte0.length; i++)
        {
            j |= abyte0[i] ^ abyte1[i];
        }

        return j == 0;
    }

    public static byte[] _mth1D4C(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        } else
        {
            byte abyte1[] = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
            return abyte1;
        }
    }

    public static byte[] FE73(byte abyte0[], byte abyte1[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        if (abyte1 == null || abyte1.length != abyte0.length)
        {
            if (abyte0 == null)
            {
                return null;
            } else
            {
                abyte1 = new byte[abyte0.length];
                System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
                return abyte1;
            }
        } else
        {
            System.arraycopy(abyte0, 0, abyte1, 0, abyte1.length);
            return abyte1;
        }
    }

    public static byte[] FE76(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        int i = 0;
        int k = abyte0.length;
        int j = k;
        byte abyte1[] = new byte[k];
        do
        {
            j--;
            if (j >= 0)
            {
                int l = i + 1;
                abyte1[j] = abyte0[i];
                i = l;
            } else
            {
                return abyte1;
            }
        } while (true);
    }
}
