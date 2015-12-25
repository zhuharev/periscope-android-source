// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            GF2mVector, IntUtils, GF2mField, RandUtils, 
//            PolynomialRingGF2

public class PolynomialGF2mSmallM
{

    GF2mField aLU;
    public int aOM[];
    int aOz;

    public PolynomialGF2mSmallM(GF2mField gf2mfield, int i)
    {
        aLU = gf2mfield;
        aOz = i;
        aOM = new int[i + 1];
        aOM[i] = 1;
    }

    public PolynomialGF2mSmallM(GF2mField gf2mfield, int i, char c, SecureRandom securerandom)
    {
        aLU = gf2mfield;
        aOM = _mth141D(i, securerandom);
        _mth153A();
    }

    public PolynomialGF2mSmallM(GF2mField gf2mfield, int ai[])
    {
        aLU = gf2mfield;
        aOM = _mth1428(ai);
        _mth153A();
    }

    public PolynomialGF2mSmallM(GF2mVector gf2mvector)
    {
        this(gf2mvector.aLU, IntUtils._mth02D1(gf2mvector.aOB));
    }

    public PolynomialGF2mSmallM(PolynomialGF2mSmallM polynomialgf2msmallm)
    {
        aLU = polynomialgf2msmallm.aLU;
        aOz = polynomialgf2msmallm.aOz;
        aOM = IntUtils._mth02D1(polynomialgf2msmallm.aOM);
    }

    static int[] _mth02BB(int ai[], int i)
    {
        int j;
        for (j = ai.length - 1; j >= 0 && ai[j] == 0; j--) { }
        if (j == -1)
        {
            return new int[1];
        } else
        {
            int ai1[] = new int[j + i + 1];
            System.arraycopy(ai, 0, ai1, i, j + 1);
            return ai1;
        }
    }

    static int _mth0640(int ai[])
    {
        int i;
        for (i = ai.length - 1; i >= 0 && ai[i] == 0; i--) { }
        if (i == -1)
        {
            return 0;
        } else
        {
            return ai[i];
        }
    }

    private int[] _mth141D(int i, SecureRandom securerandom)
    {
        int ai3[] = new int[i + 1];
        ai3[i] = 1;
        ai3[0] = aLU._mth02CA(securerandom);
        for (int j = 1; j < i; j++)
        {
            ai3[j] = RandUtils._mth02CB(securerandom, 1 << aLU.aOz);
        }

        do
        {
            int k;
label0:
            {
                if (ai3[0] == 0)
                {
                    k = 0;
                    break label0;
                }
                for (k = ai3.length - 1; k >= 0 && ai3[k] == 0; k--) { }
                int ai[] = new int[2];
                int[] _tmp = ai;
                ai[0] = 0;
                ai[1] = 1;
                int l1 = aLU.aOz;
                int i1 = 0;
                do
                {
                    if (i1 >= k >> 1)
                    {
                        break;
                    }
                    for (int j1 = l1 - 1; j1 >= 0; j1--)
                    {
                        ai = _mth0640(_mth02D1(ai, ai), ai3);
                    }

                    int ai4[] = _mth1428(ai);
                    int ai1[] = _mth02CC(ai4, new int[] {
                        0, 1
                    });
                    ai = ai3;
                    int k1;
                    for (k1 = ai1.length - 1; k1 >= 0 && ai1[k1] == 0; k1--) { }
                    int ai2[] = ai;
                    if (k1 != -1)
                    {
                        do
                        {
                            for (k1 = ai2.length - 1; k1 >= 0 && ai2[k1] == 0; k1--) { }
                            if (k1 == -1)
                            {
                                break;
                            }
                            ai = _mth0640(ai1, ai2);
                            ai1 = new int[ai2.length];
                            System.arraycopy(ai2, 0, ai1, 0, ai1.length);
                            ai2 = new int[ai.length];
                            System.arraycopy(ai, 0, ai2, 0, ai2.length);
                        } while (true);
                        ai = aLU;
                        for (k1 = ai1.length - 1; k1 >= 0 && ai1[k1] == 0; k1--) { }
                        if (k1 == -1)
                        {
                            k1 = 0;
                        } else
                        {
                            k1 = ai1[k1];
                        }
                        ai = _mth141D(ai1, ai._mth1D4B(k1, (1 << ((GF2mField) (ai)).aOz) - 2));
                    }
                    for (k1 = ai.length - 1; k1 >= 0 && ai[k1] == 0; k1--) { }
                    if (k1 != 0)
                    {
                        k = 0;
                        break label0;
                    }
                    i1++;
                    ai = ai4;
                } while (true);
                k = 1;
            }
            if (k == 0)
            {
                int l = RandUtils._mth02CB(securerandom, i);
                if (l == 0)
                {
                    ai3[0] = aLU._mth02CA(securerandom);
                } else
                {
                    ai3[l] = RandUtils._mth02CB(securerandom, 1 << aLU.aOz);
                }
            } else
            {
                return ai3;
            }
        } while (true);
    }

    static int _mth1427(int ai[])
    {
        int i;
        for (i = ai.length - 1; i >= 0 && ai[i] == 0; i--) { }
        return i;
    }

    static int[] _mth1428(int ai[])
    {
        int i;
        for (i = ai.length - 1; i >= 0 && ai[i] == 0; i--) { }
        if (i == -1)
        {
            return new int[1];
        }
        if (ai.length == i + 1)
        {
            return IntUtils._mth02D1(ai);
        } else
        {
            int ai1[] = new int[i + 1];
            System.arraycopy(ai, 0, ai1, 0, i + 1);
            return ai1;
        }
    }

    private void _mth153A()
    {
        for (aOz = aOM.length - 1; aOz >= 0 && aOM[aOz] == 0; aOz = aOz - 1) { }
    }

    public boolean equals(Object obj)
    {
label0:
        {
            int i;
label1:
            {
                if (obj == null || !(obj instanceof PolynomialGF2mSmallM))
                {
                    return false;
                }
                PolynomialGF2mSmallM polynomialgf2msmallm = (PolynomialGF2mSmallM)obj;
                if (!aLU.equals(polynomialgf2msmallm.aLU) || aOz != polynomialgf2msmallm.aOz)
                {
                    break label0;
                }
                obj = aOM;
                int ai[] = polynomialgf2msmallm.aOM;
                for (i = obj.length - 1; i >= 0 && obj[i] == 0; i--) { }
                int j;
                for (j = ai.length - 1; j >= 0 && ai[j] == 0; j--) { }
                if (i != j)
                {
                    i = 0;
                    break label1;
                }
                j = 0;
                do
                {
                    if (j > i)
                    {
                        break;
                    }
                    if (obj[j] != ai[j])
                    {
                        i = 0;
                        break label1;
                    }
                    j++;
                } while (true);
                i = 1;
            }
            if (i != 0)
            {
                return true;
            }
        }
        return false;
    }

    public final byte[] getEncoded()
    {
        int j = 8;
        int i = 1;
        for (; aLU.aOz > j; j += 8)
        {
            i++;
        }

        byte abyte0[] = new byte[aOM.length * i];
        i = 0;
        for (int k = 0; k < aOM.length; k++)
        {
            for (int l = 0; l < j;)
            {
                int i1 = i + 1;
                abyte0[i] = (byte)(aOM[k] >>> l);
                l += 8;
                i = i1;
            }

        }

        return abyte0;
    }

    public int hashCode()
    {
        int j = aLU.hashCode();
        for (int i = 0; i < aOM.length; i++)
        {
            j = j * 31 + aOM[i];
        }

        return j;
    }

    public String toString()
    {
        String s = (new StringBuilder(" Polynomial over ")).append(aLU.toString()).append(": \n").toString();
        for (int i = 0; i < aOM.length; i++)
        {
            s = (new StringBuilder()).append(s).append(aLU._mth020B(aOM[i])).append("Y^").append(i).append("+").toString();
        }

        return (new StringBuilder()).append(s).append(";").toString();
    }

    public final int _mth027F(int i)
    {
        int k = aOM[aOz];
        for (int j = aOz - 1; j >= 0; j--)
        {
            k = PolynomialRingGF2._mth1428(k, i, aLU.aOA) ^ aOM[j];
        }

        return k;
    }

    public final PolynomialGF2mSmallM _mth029F(int i)
    {
        if (!aLU._mth0208(i))
        {
            throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
        } else
        {
            int ai[] = _mth141D(aOM, i);
            return new PolynomialGF2mSmallM(aLU, ai);
        }
    }

    public final void _mth02B0(int i)
    {
        if (!aLU._mth0208(i))
        {
            throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
        } else
        {
            aOM = _mth141D(aOM, i);
            _mth153A();
            return;
        }
    }

    public final void _mth02CA(PolynomialGF2mSmallM polynomialgf2msmallm)
    {
        aOM = _mth02CC(aOM, polynomialgf2msmallm.aOM);
        _mth153A();
    }

    int[] _mth02CC(int ai[], int ai1[])
    {
        if (ai.length < ai1.length)
        {
            int ai2[] = new int[ai1.length];
            System.arraycopy(ai1, 0, ai2, 0, ai1.length);
            ai1 = ai2;
        } else
        {
            int ai3[] = new int[ai.length];
            System.arraycopy(ai, 0, ai3, 0, ai.length);
            ai = ai1;
            ai1 = ai3;
        }
        for (int i = ai.length - 1; i >= 0; i--)
        {
            ai1[i] = GF2mField._mth1D40(ai1[i], ai[i]);
        }

        return ai1;
    }

    int[][] _mth02CD(int ai[], int ai1[])
    {
        int i;
        for (i = ai1.length - 1; i >= 0 && ai1[i] == 0; i--) { }
        int j;
        for (j = ai.length - 1; j >= 0 && ai[j] == 0; j--) { }
        if (i == -1)
        {
            throw new ArithmeticException("Division by zero.");
        }
        int ai2[][] = new int[2][];
        ai2[0] = new int[1];
        ai2[1] = new int[j + 1];
        j = _mth0640(ai1);
        j = aLU.FF68(j);
        ai2[0][0] = 0;
        System.arraycopy(ai, 0, ai2[1], 0, ai2[1].length);
        int ai3[];
        for (; i <= _mth1427(ai2[1]); ai2[1] = _mth02CC(ai3, ai2[1]))
        {
            ai = new int[1];
            GF2mField gf2mfield = aLU;
            ai[0] = PolynomialRingGF2._mth1428(_mth0640(ai2[1]), j, gf2mfield.aOA);
            ai3 = _mth141D(ai1, ai[0]);
            int k = _mth1427(ai2[1]) - i;
            ai3 = _mth02BB(ai3, k);
            ai2[0] = _mth02CC(_mth02BB(ai, k), ai2[0]);
        }

        return ai2;
    }

    int[] _mth02D1(int ai[], int ai1[])
    {
        int i;
        for (i = ai.length - 1; i >= 0 && ai[i] == 0; i--) { }
        int j;
        for (j = ai1.length - 1; j >= 0 && ai1[j] == 0; j--) { }
        int ai2[];
        if (i < j)
        {
            ai2 = ai1;
            ai1 = ai;
        } else
        {
            ai2 = ai;
        }
        ai2 = _mth1428(ai2);
        int ai3[] = _mth1428(ai1);
        if (ai3.length == 1)
        {
            return _mth141D(ai2, ai3[0]);
        }
        i = ai2.length;
        j = ai3.length;
        if (j != i)
        {
            ai = new int[j];
            ai1 = new int[i - j];
            System.arraycopy(ai2, 0, ai, 0, j);
            System.arraycopy(ai2, j, ai1, 0, ai1.length);
            return _mth02CC(_mth02D1(ai, ai3), _mth02BB(_mth02D1(ai1, ai3), j));
        } else
        {
            int k = i + 1 >>> 1;
            i -= k;
            int ai4[] = new int[k];
            int ai5[] = new int[k];
            ai = new int[i];
            ai1 = new int[i];
            System.arraycopy(ai2, 0, ai4, 0, k);
            System.arraycopy(ai2, k, ai, 0, i);
            System.arraycopy(ai3, 0, ai5, 0, k);
            System.arraycopy(ai3, k, ai1, 0, i);
            ai2 = _mth02CC(ai4, ai);
            ai3 = _mth02CC(ai5, ai1);
            ai4 = _mth02D1(ai4, ai5);
            ai2 = _mth02D1(ai2, ai3);
            ai = _mth02D1(ai, ai1);
            return _mth02CC(_mth02BB(_mth02CC(_mth02CC(_mth02CC(ai2, ai4), ai), _mth02BB(ai, k)), k), ai4);
        }
    }

    int[] _mth0640(int ai[], int ai1[])
    {
        int i;
        for (i = ai1.length - 1; i >= 0 && ai1[i] == 0; i--) { }
        if (i == -1)
        {
            throw new ArithmeticException("Division by zero");
        }
        int ai2[] = new int[ai.length];
        int j = _mth0640(ai1);
        j = aLU.FF68(j);
        System.arraycopy(ai, 0, ai2, 0, ai2.length);
        int k;
        for (ai = ai2; i <= _mth1427(ai); ai = _mth02CC(_mth141D(_mth02BB(ai1, _mth1427(ai) - i), k), ai))
        {
            GF2mField gf2mfield = aLU;
            k = PolynomialRingGF2._mth1428(_mth0640(ai), j, gf2mfield.aOA);
        }

        return ai;
    }

    int[] _mth141D(int ai[], int i)
    {
        int j;
        for (j = ai.length - 1; j >= 0 && ai[j] == 0; j--) { }
        int k = j;
        if (j == -1 || i == 0)
        {
            return new int[1];
        }
        if (i == 1)
        {
            return IntUtils._mth02D1(ai);
        }
        int ai1[] = new int[k + 1];
        for (; k >= 0; k--)
        {
            GF2mField gf2mfield = aLU;
            ai1[k] = PolynomialRingGF2._mth1428(ai[k], i, gf2mfield.aOA);
        }

        return ai1;
    }
}
