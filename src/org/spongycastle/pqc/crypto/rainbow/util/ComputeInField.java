// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.rainbow.util;

import java.lang.reflect.Array;

// Referenced classes of package org.spongycastle.pqc.crypto.rainbow.util:
//            GF2Field

public class ComputeInField
{

    private short aNS[];
    private short aNV[][];

    public ComputeInField()
    {
    }

    public static short[] _mth02CA(short word0, short aword0[])
    {
        short aword1[] = new short[aword0.length];
        for (int i = 0; i < aword1.length; i++)
        {
            aword1[i] = GF2Field._mth02CE(word0, aword0[i]);
        }

        return aword1;
    }

    public static short[] _mth02CA(short aword0[], short aword1[])
    {
        if (aword0.length != aword1.length)
        {
            throw new RuntimeException("Multiplication is not possible!");
        }
        short aword2[] = new short[aword0.length];
        for (int i = 0; i < aword2.length; i++)
        {
            aword2[i] = GF2Field._mth02CB(aword0[i], aword1[i]);
        }

        return aword2;
    }

    public static short[][] _mth02CA(short word0, short aword0[][])
    {
        int i = aword0.length;
        int k = aword0[0].length;
        short aword1[][] = (short[][])Array.newInstance(Short.TYPE, new int[] {
            i, k
        });
        for (int j = 0; j < aword0.length; j++)
        {
            for (int l = 0; l < aword0[0].length; l++)
            {
                aword1[j][l] = GF2Field._mth02CE(word0, aword0[j][l]);
            }

        }

        return aword1;
    }

    public static short[][] _mth02CA(short aword0[][], short aword1[][])
    {
        if (aword0.length != aword1.length || aword0[0].length != aword1[0].length)
        {
            throw new RuntimeException("Addition is not possible!");
        }
        int i = aword0.length;
        int k = aword0.length;
        short aword2[][] = (short[][])Array.newInstance(Short.TYPE, new int[] {
            i, k
        });
        for (int j = 0; j < aword0.length; j++)
        {
            for (int l = 0; l < aword1.length; l++)
            {
                aword2[j][l] = GF2Field._mth02CB(aword0[j][l], aword1[j][l]);
            }

        }

        return aword2;
    }

    public static short[] _mth02CB(short aword0[][], short aword1[])
    {
        if (aword0[0].length != aword1.length)
        {
            throw new RuntimeException("Multiplication is not possible!");
        }
        short aword2[] = new short[aword0.length];
        for (int i = 0; i < aword0.length; i++)
        {
            for (int j = 0; j < aword1.length; j++)
            {
                short word0 = GF2Field._mth02CE(aword0[i][j], aword1[j]);
                aword2[i] = GF2Field._mth02CB(aword2[i], word0);
            }

        }

        return aword2;
    }

    public static short[][] _mth02CB(short aword0[], short aword1[])
    {
        if (aword0.length != aword1.length)
        {
            throw new RuntimeException("Multiplication is not possible!");
        }
        int i = aword0.length;
        int k = aword1.length;
        short aword2[][] = (short[][])Array.newInstance(Short.TYPE, new int[] {
            i, k
        });
        for (int j = 0; j < aword0.length; j++)
        {
            for (int l = 0; l < aword1.length; l++)
            {
                aword2[j][l] = GF2Field._mth02CE(aword0[j], aword1[l]);
            }

        }

        return aword2;
    }

    private void _mth0998()
    {
        for (int i = aNV.length - 1; i > 0; i--)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                short word0 = aNV[j][i];
                short word1 = GF2Field._mth02BF(aNV[i][i]);
                if (word1 == 0)
                {
                    throw new RuntimeException("The matrix is not invertible");
                }
                for (int k = i; k < aNV.length * 2; k++)
                {
                    short word2 = GF2Field._mth02CE(word0, GF2Field._mth02CE(aNV[i][k], word1));
                    short aword0[] = aNV[j];
                    aword0[k] = GF2Field._mth02CB(aword0[k], word2);
                }

            }

        }

    }

    private void _mth09B7()
    {
        short word0 = GF2Field._mth02BF(aNV[aNV.length - 1][aNV.length - 1]);
        if (word0 == 0)
        {
            throw new RuntimeException("The equation system is not solvable");
        }
        aNS[aNV.length - 1] = GF2Field._mth02CE(aNV[aNV.length - 1][aNV.length], word0);
        for (int i = aNV.length - 2; i >= 0; i--)
        {
            short word1 = aNV[i][aNV.length];
            for (int j = aNV.length - 1; j > i; j--)
            {
                word1 = GF2Field._mth02CB(word1, GF2Field._mth02CE(aNV[i][j], aNS[j]));
            }

            short word2 = GF2Field._mth02BF(aNV[i][i]);
            if (word2 == 0)
            {
                throw new RuntimeException("Not solvable equation system");
            }
            aNS[i] = GF2Field._mth02CE(word1, word2);
        }

    }

    private void _mth1D59(boolean flag)
    {
        int j;
        if (flag)
        {
            j = aNV.length * 2;
        } else
        {
            j = aNV.length + 1;
        }
        for (int i = 0; i < aNV.length - 1; i++)
        {
            for (int k = i + 1; k < aNV.length; k++)
            {
                short word0 = aNV[k][i];
                short word1 = GF2Field._mth02BF(aNV[i][i]);
                if (word1 == 0)
                {
                    throw new RuntimeException("Matrix not invertible! We have to choose another one!");
                }
                for (int l = i; l < j; l++)
                {
                    short word2 = GF2Field._mth02CE(word0, GF2Field._mth02CE(aNV[i][l], word1));
                    short aword0[] = aNV[k];
                    aword0[l] = GF2Field._mth02CB(aword0[l], word2);
                }

            }

        }

    }

    public final short[] _mth02CA(short aword0[][], short aword1[])
    {
        int j;
        int l;
        try
        {
            if (aword0.length != aword1.length)
            {
                throw new RuntimeException("The equation system is not solvable");
            }
            int i = aword0.length;
            int k = aword0.length;
            aNV = (short[][])Array.newInstance(Short.TYPE, new int[] {
                i, k + 1
            });
            aNS = new short[aword0.length];
        }
        // Misplaced declaration of an exception variable
        catch (short aword0[][])
        {
            return null;
        }
        j = 0;
_L5:
        if (j >= aword0.length)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        l = 0;
_L2:
        if (l >= aword0[0].length)
        {
            break; /* Loop/switch isn't completed */
        }
        aNV[j][l] = aword0[j][l];
        l++;
        if (true) goto _L2; else goto _L1
_L3:
        for (; j >= aword1.length; j = 0)
        {
            break MISSING_BLOCK_LABEL_140;
        }

        aNV[j][aword1.length] = GF2Field._mth02CB(aword1[j], aNV[j][aword1.length]);
        j++;
          goto _L3
        _mth1D59(false);
        _mth09B7();
        aword0 = aNS;
        return aword0;
_L1:
        j++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final short[][] _mth02CA(short aword0[][])
    {
        int i = aword0.length;
        int k = aword0.length;
        aNV = (short[][])Array.newInstance(Short.TYPE, new int[] {
            i, k * 2
        });
        if (aword0.length != aword0[0].length)
        {
            throw new RuntimeException("The matrix is not invertible. Please choose another one!");
        }
          goto _L1
_L5:
        int j;
        if (j >= aword0.length) goto _L3; else goto _L2
_L2:
        int l = 0;
        do
        {
            short word0;
            try
            {
                if (l >= aword0.length)
                {
                    break;
                }
                aNV[j][l] = aword0[j][l];
            }
            // Misplaced declaration of an exception variable
            catch (short aword0[][])
            {
                return null;
            }
            l++;
        } while (true);
        l = aword0.length;
_L4:
        if (l >= aword0.length * 2)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        aNV[j][l] = 0;
        l++;
          goto _L4
        aNV[j][aNV.length + j] = 1;
        j++;
          goto _L5
_L3:
        _mth1D59(true);
        j = 0;
_L13:
        if (j >= aNV.length) goto _L7; else goto _L6
_L6:
        word0 = GF2Field._mth02BF(aNV[j][j]);
        l = j;
_L9:
        if (l >= aNV.length * 2)
        {
            break; /* Loop/switch isn't completed */
        }
        aword0 = aNV[j];
        aword0[l] = GF2Field._mth02CE(aword0[l], word0);
        l++;
        if (true) goto _L9; else goto _L8
_L7:
        _mth0998();
        j = aNV.length;
        l = aNV.length;
        aword0 = (short[][])Array.newInstance(Short.TYPE, new int[] {
            j, l
        });
        j = 0;
_L12:
        if (j >= aNV.length)
        {
            break; /* Loop/switch isn't completed */
        }
        l = aNV.length;
_L10:
        if (l >= aNV.length * 2)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        aword0[j][l - aNV.length] = aNV[j][l];
        l++;
          goto _L10
        j++;
        if (true) goto _L12; else goto _L11
_L11:
        return aword0;
_L1:
        j = 0;
          goto _L5
_L8:
        j++;
          goto _L13
    }
}
