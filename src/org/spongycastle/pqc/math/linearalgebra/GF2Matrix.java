// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;

// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            Matrix, IntUtils, Permutation, LittleEndianConversions, 
//            GF2Vector, Vector

public class GF2Matrix extends Matrix
{

    private int aOr[][];
    private int length;

    private GF2Matrix(int i, char c)
    {
        this(i, 'I', new SecureRandom());
    }

    private GF2Matrix(int i, char c, SecureRandom securerandom)
    {
        if (i <= 0)
        {
            throw new ArithmeticException("Size of matrix is non-positive.");
        }
        switch (c)
        {
        case 90: // 'Z'
            _mth1D38(i, i);
            return;

        case 73: // 'I'
            FB58(i);
            return;

        case 76: // 'L'
            _mth02CA(i, securerandom);
            return;

        case 85: // 'U'
            _mth02CB(i, securerandom);
            return;

        case 82: // 'R'
            _mth02CE(i, securerandom);
            return;
        }
        throw new ArithmeticException("Unknown matrix type.");
    }

    private GF2Matrix(int i, int j)
    {
        if (j <= 0 || i <= 0)
        {
            throw new ArithmeticException("size of matrix is non-positive");
        } else
        {
            _mth1D38(i, j);
            return;
        }
    }

    public GF2Matrix(int i, int ai[][])
    {
        if (ai[0].length != i + 31 >> 5)
        {
            throw new ArithmeticException("Int array does not match given number of columns.");
        }
        numColumns = i;
        aOK = ai.length;
        length = ai[0].length;
        i &= 0x1f;
        if (i == 0)
        {
            i = -1;
        } else
        {
            i = (1 << i) - 1;
        }
        for (int j = 0; j < aOK; j++)
        {
            int ai1[] = ai[j];
            int k = length - 1;
            ai1[k] = ai1[k] & i;
        }

        aOr = ai;
    }

    public GF2Matrix(GF2Matrix gf2matrix)
    {
        numColumns = gf2matrix.getNumColumns();
        aOK = gf2matrix.getNumRows();
        length = gf2matrix.length;
        aOr = new int[gf2matrix.aOr.length][];
        for (int i = 0; i < aOr.length; i++)
        {
            aOr[i] = IntUtils._mth02D1(gf2matrix.aOr[i]);
        }

    }

    private void _mth02CA(int i, SecureRandom securerandom)
    {
        aOK = i;
        numColumns = i;
        length = i + 31 >>> 5;
        i = aOK;
        int j = length;
        aOr = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            i, j
        });
        for (i = 0; i < aOK; i++)
        {
            int i1 = i >>> 5;
            int j1 = i & 0x1f;
            for (int k = 0; k < i1; k++)
            {
                aOr[i][k] = securerandom.nextInt();
            }

            aOr[i][i1] = securerandom.nextInt() >>> 31 - j1 | 1 << j1;
            for (int l = i1 + 1; l < length; l++)
            {
                aOr[i][l] = 0;
            }

        }

    }

    private void _mth02CB(int i, SecureRandom securerandom)
    {
        aOK = i;
        numColumns = i;
        length = i + 31 >>> 5;
        int j = aOK;
        int l = length;
        aOr = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            j, l
        });
        i &= 0x1f;
        if (i == 0)
        {
            i = -1;
        } else
        {
            i = (1 << i) - 1;
        }
        for (int k = 0; k < aOK; k++)
        {
            int l1 = k >>> 5;
            int i2 = k & 0x1f;
            for (int i1 = 0; i1 < l1; i1++)
            {
                aOr[k][i1] = 0;
            }

            aOr[k][l1] = securerandom.nextInt() << i2 | 1 << i2;
            for (int j1 = l1 + 1; j1 < length; j1++)
            {
                aOr[k][j1] = securerandom.nextInt();
            }

            int ai[] = aOr[k];
            int k1 = length - 1;
            ai[k1] = ai[k1] & i;
        }

    }

    private void _mth02CE(int i, SecureRandom securerandom)
    {
        aOK = i;
        numColumns = i;
        length = i + 31 >>> 5;
        int j = aOK;
        int l = length;
        aOr = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            j, l
        });
        GF2Matrix gf2matrix = (GF2Matrix)(new GF2Matrix(i, 'L', securerandom))._mth02CA(new GF2Matrix(i, 'U', securerandom));
        securerandom = IntUtils._mth02D1((new Permutation(i, securerandom)).aOL);
        for (int k = 0; k < i; k++)
        {
            System.arraycopy(gf2matrix.aOr[k], 0, aOr[securerandom[k]], 0, length);
        }

    }

    private static void _mth02CE(int ai[], int ai1[], int i)
    {
        for (int j = ai1.length - 1; j >= i; j--)
        {
            ai1[j] = ai[j] ^ ai1[j];
        }

    }

    public static GF2Matrix[] _mth02CF(int i, SecureRandom securerandom)
    {
        int i2 = i + 31 >> 5;
        GF2Matrix gf2matrix1 = new GF2Matrix(i, 'L', securerandom);
        GF2Matrix gf2matrix = new GF2Matrix(i, 'U', securerandom);
        GF2Matrix gf2matrix2 = (GF2Matrix)gf2matrix1._mth02CA(gf2matrix);
        securerandom = new Permutation(i, securerandom);
        int ai[] = IntUtils._mth02D1(((Permutation) (securerandom)).aOL);
        int ai1[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            i, i2
        });
        for (int j = 0; j < i; j++)
        {
            System.arraycopy(gf2matrix2.aOr[ai[j]], 0, ai1[j], 0, i2);
        }

        gf2matrix2 = new GF2Matrix(i, ai1);
        GF2Matrix gf2matrix3 = new GF2Matrix(i, 'I');
        for (int k = 0; k < i; k++)
        {
            int j2 = k >>> 5;
            for (int i1 = k + 1; i1 < i; i1++)
            {
                if ((gf2matrix1.aOr[i1][j2] & 1 << (k & 0x1f)) == 0)
                {
                    continue;
                }
                for (int k1 = 0; k1 <= j2; k1++)
                {
                    int ai2[] = gf2matrix3.aOr[i1];
                    ai2[k1] = ai2[k1] ^ gf2matrix3.aOr[k][k1];
                }

            }

        }

        gf2matrix1 = new GF2Matrix(i, 'I');
        for (i--; i >= 0; i--)
        {
            int l1 = i >>> 5;
            for (int l = i - 1; l >= 0; l--)
            {
                if ((gf2matrix.aOr[l][l1] & 1 << (i & 0x1f)) == 0)
                {
                    continue;
                }
                for (int j1 = l1; j1 < i2; j1++)
                {
                    int ai3[] = gf2matrix1.aOr[l];
                    ai3[j1] = ai3[j1] ^ gf2matrix1.aOr[i][j1];
                }

            }

        }

        return (new GF2Matrix[] {
            gf2matrix2, (GF2Matrix)gf2matrix1._mth02CA(gf2matrix3._mth02CA(securerandom))
        });
    }

    private void _mth1D38(int i, int j)
    {
        aOK = i;
        numColumns = j;
        length = j + 31 >>> 5;
        i = aOK;
        j = length;
        aOr = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            i, j
        });
        for (i = 0; i < aOK; i++)
        {
            for (j = 0; j < length; j++)
            {
                aOr[i][j] = 0;
            }

        }

    }

    private void FB58(int i)
    {
        aOK = i;
        numColumns = i;
        length = i + 31 >>> 5;
        i = aOK;
        int j = length;
        aOr = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            i, j
        });
        for (i = 0; i < aOK; i++)
        {
            for (int k = 0; k < length; k++)
            {
                aOr[i][k] = 0;
            }

        }

        for (i = 0; i < aOK; i++)
        {
            aOr[i][i >>> 5] = 1 << (i & 0x1f);
        }

    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof GF2Matrix))
        {
            return false;
        }
        obj = (GF2Matrix)obj;
        if (aOK != ((GF2Matrix) (obj)).aOK || numColumns != ((GF2Matrix) (obj)).numColumns || length != ((GF2Matrix) (obj)).length)
        {
            return false;
        }
        for (int i = 0; i < aOK; i++)
        {
            if (!IntUtils.equals(aOr[i], ((GF2Matrix) (obj)).aOr[i]))
            {
                return false;
            }
        }

        return true;
    }

    public final byte[] getEncoded()
    {
        byte abyte0[] = new byte[(numColumns + 7 >>> 3) * aOK + 8];
        LittleEndianConversions._mth037A(aOK, abyte0, 0);
        LittleEndianConversions._mth037A(numColumns, abyte0, 4);
        int j1 = numColumns >>> 5;
        int k1 = numColumns;
        int i = 8;
        for (int j = 0; j < aOK; j++)
        {
            for (int k = 0; k < j1;)
            {
                LittleEndianConversions._mth037A(aOr[j][k], abyte0, i);
                k++;
                i += 4;
            }

            for (int l = 0; l < (k1 & 0x1f);)
            {
                int i1 = i + 1;
                abyte0[i] = (byte)(aOr[j][j1] >>> l);
                l += 8;
                i = i1;
            }

        }

        return abyte0;
    }

    public int hashCode()
    {
        int j = (aOK * 31 + numColumns) * 31 + length;
        for (int i = 0; i < aOK; i++)
        {
            j = j * 31 + aOr[i].hashCode();
        }

        return j;
    }

    public String toString()
    {
        int k1 = numColumns & 0x1f;
        int i;
        if (k1 == 0)
        {
            i = length;
        } else
        {
            i = length - 1;
        }
        StringBuffer stringbuffer = new StringBuffer();
        for (int j = 0; j < aOK; j++)
        {
            stringbuffer.append((new StringBuilder()).append(j).append(": ").toString());
            for (int k = 0; k < i; k++)
            {
                int l1 = aOr[j][k];
                for (int i1 = 0; i1 < 32; i1++)
                {
                    if ((l1 >>> i1 & 1) == 0)
                    {
                        stringbuffer.append('0');
                    } else
                    {
                        stringbuffer.append('1');
                    }
                }

                stringbuffer.append(' ');
            }

            int j1 = aOr[j][length - 1];
            for (int l = 0; l < k1; l++)
            {
                if ((j1 >>> l & 1) == 0)
                {
                    stringbuffer.append('0');
                } else
                {
                    stringbuffer.append('1');
                }
            }

            stringbuffer.append('\n');
        }

        return stringbuffer.toString();
    }

    public final GF2Matrix _mth02CA(Matrix matrix)
    {
        if (!(matrix instanceof GF2Matrix))
        {
            throw new ArithmeticException("matrix is not defined over GF(2)");
        }
        if (matrix.aOK != numColumns)
        {
            throw new ArithmeticException("length mismatch");
        }
        GF2Matrix gf2matrix = (GF2Matrix)matrix;
        matrix = new GF2Matrix(aOK, matrix.numColumns);
        int j2 = numColumns & 0x1f;
        int j;
        if (j2 == 0)
        {
            j = length;
        } else
        {
            j = length - 1;
        }
        for (int k = 0; k < aOK; k++)
        {
            int i = 0;
            for (int l = 0; l < j; l++)
            {
                int k2 = aOr[k][l];
                for (int j1 = 0; j1 < 32; j1++)
                {
                    if ((1 << j1 & k2) != 0)
                    {
                        for (int l1 = 0; l1 < gf2matrix.length; l1++)
                        {
                            int ai[] = ((GF2Matrix) (matrix)).aOr[k];
                            ai[l1] = ai[l1] ^ gf2matrix.aOr[i][l1];
                        }

                    }
                    i++;
                }

            }

            int i2 = aOr[k][length - 1];
            for (int i1 = 0; i1 < j2; i1++)
            {
                if ((1 << i1 & i2) != 0)
                {
                    for (int k1 = 0; k1 < gf2matrix.length; k1++)
                    {
                        int ai1[] = ((GF2Matrix) (matrix)).aOr[k];
                        ai1[k1] = ai1[k1] ^ gf2matrix.aOr[i][k1];
                    }

                }
                i++;
            }

        }

        return matrix;
    }

    public final GF2Matrix _mth02CA(Permutation permutation)
    {
        permutation = IntUtils._mth02D1(permutation.aOL);
        if (permutation.length != numColumns)
        {
            throw new ArithmeticException("length mismatch");
        }
        GF2Matrix gf2matrix = new GF2Matrix(aOK, numColumns);
        for (int i = numColumns - 1; i >= 0; i--)
        {
            int k = i >>> 5;
            int l = permutation[i];
            int i1 = permutation[i];
            for (int j = aOK - 1; j >= 0; j--)
            {
                int ai[] = gf2matrix.aOr[j];
                ai[k] = ai[k] | (aOr[j][l >>> 5] >>> (i1 & 0x1f) & 1) << (i & 0x1f);
            }

        }

        return gf2matrix;
    }

    public final GF2Vector _mth02CB(GF2Vector gf2vector)
    {
        if (!(gf2vector instanceof GF2Vector))
        {
            throw new ArithmeticException("vector is not defined over GF(2)");
        }
        if (((Vector) (gf2vector)).length != aOK)
        {
            throw new ArithmeticException("length mismatch");
        }
        gf2vector = ((GF2Vector)gf2vector).aOy;
        int ai[] = new int[length];
        int i2 = aOK >> 5;
        int j2 = aOK;
        int i = 0;
        for (int j = 0; j < i2;)
        {
            int l = 1;
            int k1;
            int l1;
            do
            {
                if ((gf2vector[j] & l) != 0)
                {
                    for (int j1 = 0; j1 < length; j1++)
                    {
                        ai[j1] = ai[j1] ^ aOr[i][j1];
                    }

                }
                k1 = i + 1;
                l1 = l << 1;
                l = l1;
                i = k1;
            } while (l1 != 0);
            j++;
            i = k1;
        }

        for (int k = 1; k != 1 << (j2 & 0x1f); k <<= 1)
        {
            if ((gf2vector[i2] & k) != 0)
            {
                for (int i1 = 0; i1 < length; i1++)
                {
                    ai[i1] = ai[i1] ^ aOr[i][i1];
                }

            }
            i++;
        }

        return new GF2Vector(ai, numColumns);
    }

    public final GF2Vector _mth02CE(GF2Vector gf2vector)
    {
        if (!(gf2vector instanceof GF2Vector))
        {
            throw new ArithmeticException("vector is not defined over GF(2)");
        }
        if (((Vector) (gf2vector)).length != aOK)
        {
            throw new ArithmeticException("length mismatch");
        }
        gf2vector = ((GF2Vector)gf2vector).aOy;
        int ai[] = new int[aOK + numColumns + 31 >>> 5];
        int j3 = aOK >>> 5;
        int i = 0;
        for (int j = 0; j < j3;)
        {
            int l = 1;
            int i2;
            int l2;
            do
            {
                if ((gf2vector[j] & l) != 0)
                {
                    for (int k1 = 0; k1 < length; k1++)
                    {
                        ai[k1] = ai[k1] ^ aOr[i][k1];
                    }

                    int l1 = numColumns + i >>> 5;
                    int k2 = numColumns;
                    ai[l1] = ai[l1] | 1 << (k2 + i & 0x1f);
                }
                i2 = i + 1;
                l2 = l << 1;
                l = l2;
                i = i2;
            } while (l2 != 0);
            j++;
            i = i2;
        }

        int j2 = aOK;
        for (int k = 1; k != 1 << (j2 & 0x1f); k <<= 1)
        {
            if ((gf2vector[j3] & k) != 0)
            {
                for (int i1 = 0; i1 < length; i1++)
                {
                    ai[i1] = ai[i1] ^ aOr[i][i1];
                }

                int j1 = numColumns + i >>> 5;
                int i3 = numColumns;
                ai[j1] = ai[j1] | 1 << (i3 + i & 0x1f);
            }
            i++;
        }

        return new GF2Vector(ai, aOK + numColumns);
    }

    public final GF2Vector _mth02CF(GF2Vector gf2vector)
    {
        if (!(gf2vector instanceof GF2Vector))
        {
            throw new ArithmeticException("vector is not defined over GF(2)");
        }
        if (((Vector) (gf2vector)).length != numColumns)
        {
            throw new ArithmeticException("length mismatch");
        }
        gf2vector = ((GF2Vector)gf2vector).aOy;
        int ai[] = new int[aOK + 31 >>> 5];
        for (int i = 0; i < aOK; i++)
        {
            int j = 0;
            for (int l = 0; l < length; l++)
            {
                j ^= aOr[i][l] & gf2vector[l];
            }

            int j1 = 0;
            for (int i1 = 0; i1 < 32; i1++)
            {
                j1 ^= j >>> i1 & 1;
            }

            if (j1 == 1)
            {
                int k = i >>> 5;
                ai[k] = ai[k] | 1 << (i & 0x1f);
            }
        }

        return new GF2Vector(ai, aOK);
    }

    public final GF2Matrix _mth0E11()
    {
        if (numColumns <= aOK)
        {
            throw new ArithmeticException("empty submatrix");
        }
        int l = aOK + 31 >> 5;
        int i = aOK;
        int ai[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            i, l
        });
        int j = (1 << (aOK & 0x1f)) - 1;
        i = j;
        if (j == 0)
        {
            i = -1;
        }
        for (int k = aOK - 1; k >= 0; k--)
        {
            System.arraycopy(aOr[k], 0, ai[k], 0, l);
            int ai1[] = ai[k];
            int i1 = l - 1;
            ai1[i1] = ai1[i1] & i;
        }

        return new GF2Matrix(aOK, ai);
    }

    public final GF2Matrix _mth0E15()
    {
        int i = numColumns;
        int j = aOK;
        GF2Matrix gf2matrix = new GF2Matrix(aOK, i + j);
        i = (aOK - 1) + numColumns;
        for (int k = aOK - 1; k >= 0;)
        {
            System.arraycopy(aOr[k], 0, gf2matrix.aOr[k], 0, length);
            int ai[] = gf2matrix.aOr[k];
            int l = i >> 5;
            ai[l] = ai[l] | 1 << (i & 0x1f);
            k--;
            i--;
        }

        return gf2matrix;
    }

    public final GF2Matrix _mth0E19()
    {
        if (numColumns <= aOK)
        {
            throw new ArithmeticException("empty submatrix");
        }
        int j1 = aOK >> 5;
        int i2 = aOK & 0x1f;
        GF2Matrix gf2matrix = new GF2Matrix(aOK, numColumns - aOK);
        for (int k = aOK - 1; k >= 0; k--)
        {
            if (i2 != 0)
            {
                int i = j1;
                for (int l = 0; l < gf2matrix.length - 1;)
                {
                    int ai[] = gf2matrix.aOr[k];
                    int ai3[] = aOr[k];
                    int k1 = i + 1;
                    ai[l] = ai3[i] >>> i2 | aOr[k][k1] << 32 - i2;
                    l++;
                    i = k1;
                }

                int ai1[] = gf2matrix.aOr[k];
                int l1 = gf2matrix.length;
                int ai4[] = aOr[k];
                int i1 = i + 1;
                ai1[l1 - 1] = ai4[i] >>> i2;
                if (i1 < length)
                {
                    int ai2[] = gf2matrix.aOr[k];
                    int j = gf2matrix.length - 1;
                    ai2[j] = ai2[j] | aOr[k][i1] << 32 - i2;
                }
            } else
            {
                System.arraycopy(aOr[k], j1, gf2matrix.aOr[k], 0, gf2matrix.length);
            }
        }

        return gf2matrix;
    }

    public final GF2Matrix _mth0E21()
    {
        int i = numColumns;
        int k = aOK;
        int ai[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            i, k + 31 >>> 5
        });
        for (int j = 0; j < aOK; j++)
        {
            for (int l = 0; l < numColumns; l++)
            {
                int i1 = aOr[j][l >>> 5];
                int j1 = j >>> 5;
                if ((i1 >>> (l & 0x1f) & 1) == 1)
                {
                    int ai1[] = ai[l];
                    ai1[j1] = ai1[j1] | 1 << (j & 0x1f);
                }
            }

        }

        return new GF2Matrix(aOK, ai);
    }

    public final GF2Matrix _mth0E2D()
    {
        if (aOK != numColumns)
        {
            throw new ArithmeticException("Matrix is not invertible.");
        }
        int i = aOK;
        int i1 = length;
        int ai[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            i, i1
        });
        for (i = aOK - 1; i >= 0; i--)
        {
            ai[i] = IntUtils._mth02D1(aOr[i]);
        }

        i = aOK;
        i1 = length;
        int ai1[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            i, i1
        });
        for (int j = aOK - 1; j >= 0; j--)
        {
            ai1[j][j >> 5] = 1 << (j & 0x1f);
        }

        for (int j1 = 0; j1 < aOK; j1++)
        {
            int l1 = j1 >> 5;
            int i2 = 1 << (j1 & 0x1f);
            if ((ai[j1][l1] & i2) == 0)
            {
                boolean flag = false;
                int k1;
                for (int k = j1 + 1; k < aOK; k = k1 + 1)
                {
                    k1 = k;
                    if ((ai[k][l1] & i2) != 0)
                    {
                        flag = true;
                        int ai2[] = ai[j1];
                        ai[j1] = ai[k];
                        ai[k] = ai2;
                        ai2 = ai1[j1];
                        ai1[j1] = ai1[k];
                        ai1[k] = ai2;
                        k1 = aOK;
                    }
                }

                if (!flag)
                {
                    throw new ArithmeticException("Matrix is not invertible.");
                }
            }
            for (int l = aOK - 1; l >= 0; l--)
            {
                if (l != j1 && (ai[l][l1] & i2) != 0)
                {
                    _mth02CE(ai[j1], ai[l], l1);
                    _mth02CE(ai1[j1], ai1[l], 0);
                }
            }

        }

        return new GF2Matrix(numColumns, ai1);
    }
}
