// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            Vector, RandUtils, IntUtils, LittleEndianConversions, 
//            GF2mField, GF2mVector, Permutation

public class GF2Vector extends Vector
{

    public int aOy[];

    public GF2Vector(int i)
    {
        if (i < 0)
        {
            throw new ArithmeticException("Negative length.");
        } else
        {
            length = i;
            aOy = new int[i + 31 >> 5];
            return;
        }
    }

    public GF2Vector(int i, int j, SecureRandom securerandom)
    {
        if (j > i)
        {
            throw new ArithmeticException("The hamming weight is greater than the length of vector.");
        }
        length = i;
        aOy = new int[i + 31 >> 5];
        int ai[] = new int[i];
        for (int k = 0; k < i; k++)
        {
            ai[k] = k;
        }

        int l = i;
        for (i = 0; i < j; i++)
        {
            int i1 = RandUtils._mth02CB(securerandom, l);
            FE9B(ai[i1]);
            l--;
            ai[i1] = ai[l];
        }

    }

    public GF2Vector(int i, SecureRandom securerandom)
    {
        length = i;
        int l = i + 31 >> 5;
        aOy = new int[l];
        for (int j = l - 1; j >= 0; j--)
        {
            aOy[j] = securerandom.nextInt();
        }

        i &= 0x1f;
        if (i != 0)
        {
            securerandom = aOy;
            int k = l - 1;
            securerandom[k] = securerandom[k] & (1 << i) - 1;
        }
    }

    private GF2Vector(int i, int ai[])
    {
        if (i < 0)
        {
            throw new ArithmeticException("negative length");
        }
        length = i;
        int j = i + 31 >> 5;
        if (ai.length != j)
        {
            throw new ArithmeticException("length mismatch");
        }
        aOy = IntUtils._mth02D1(ai);
        i &= 0x1f;
        if (i != 0)
        {
            ai = aOy;
            j--;
            ai[j] = ai[j] & (1 << i) - 1;
        }
    }

    private GF2Vector(GF2Vector gf2vector)
    {
        length = gf2vector.length;
        aOy = IntUtils._mth02D1(gf2vector.aOy);
    }

    protected GF2Vector(int ai[], int i)
    {
        aOy = ai;
        length = i;
    }

    public static GF2Vector _mth02CB(int i, byte abyte0[])
    {
        if (i < 0)
        {
            throw new ArithmeticException("negative length");
        }
        if (abyte0.length > i + 7 >> 3)
        {
            throw new ArithmeticException("length mismatch");
        } else
        {
            return new GF2Vector(i, LittleEndianConversions._mth15AE(abyte0));
        }
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof GF2Vector))
        {
            return false;
        }
        obj = (GF2Vector)obj;
        return length == ((GF2Vector) (obj)).length && IntUtils.equals(aOy, ((GF2Vector) (obj)).aOy);
    }

    public final byte[] getEncoded()
    {
        int i = length;
        return LittleEndianConversions._mth02CF(aOy, i + 7 >> 3);
    }

    public int hashCode()
    {
        return length * 31 + aOy.hashCode();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < length; i++)
        {
            if (i != 0 && (i & 0x1f) == 0)
            {
                stringbuffer.append(' ');
            }
            if ((aOy[i >> 5] & 1 << (i & 0x1f)) == 0)
            {
                stringbuffer.append('0');
            } else
            {
                stringbuffer.append('1');
            }
        }

        return stringbuffer.toString();
    }

    public final GF2mVector _mth02CA(GF2mField gf2mfield)
    {
        int i = gf2mfield.aOz;
        if (length % i != 0)
        {
            throw new ArithmeticException("conversion is impossible");
        }
        i = length / i;
        int ai[] = new int[i];
        int j = 0;
        for (i--; i >= 0; i--)
        {
            for (int k = gf2mfield.aOz - 1; k >= 0; k--)
            {
                if ((aOy[j >>> 5] >>> (j & 0x1f) & 1) == 1)
                {
                    ai[i] = ai[i] ^ 1 << k;
                }
                j++;
            }

        }

        return new GF2mVector(gf2mfield, ai);
    }

    public final GF2Vector _mth02CB(Permutation permutation)
    {
        permutation = IntUtils._mth02D1(permutation.aOL);
        if (length != permutation.length)
        {
            throw new ArithmeticException("length mismatch");
        }
        GF2Vector gf2vector = new GF2Vector(length);
        for (int i = 0; i < permutation.length; i++)
        {
            if ((aOy[permutation[i] >> 5] & 1 << (permutation[i] & 0x1f)) != 0)
            {
                int ai[] = gf2vector.aOy;
                int j = i >> 5;
                ai[j] = ai[j] | 1 << (i & 0x1f);
            }
        }

        return gf2vector;
    }

    public final GF2Vector _mth141D(GF2Vector gf2vector)
    {
        if (!(gf2vector instanceof GF2Vector))
        {
            throw new ArithmeticException("vector is not defined over GF(2)");
        }
        GF2Vector gf2vector1 = (GF2Vector)gf2vector;
        if (length != gf2vector1.length)
        {
            throw new ArithmeticException("length mismatch");
        }
        gf2vector = IntUtils._mth02D1(((GF2Vector)gf2vector).aOy);
        for (int i = gf2vector.length - 1; i >= 0; i--)
        {
            gf2vector[i] = gf2vector[i] ^ aOy[i];
        }

        return new GF2Vector(length, gf2vector);
    }

    public final void FE9B(int i)
    {
        if (i >= length)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            int ai[] = aOy;
            int j = i >> 5;
            ai[j] = ai[j] | 1 << (i & 0x1f);
            return;
        }
    }

    public final GF2Vector FEE8(int i)
    {
        if (i > length)
        {
            throw new ArithmeticException("invalid length");
        }
        if (i == length)
        {
            return new GF2Vector(this);
        }
        GF2Vector gf2vector = new GF2Vector(i);
        int j = length - i >> 5;
        int l = length - i & 0x1f;
        int i1 = i + 31 >> 5;
        i = j;
        if (l != 0)
        {
            for (j = 0; j < i1 - 1;)
            {
                int ai[] = gf2vector.aOy;
                int ai3[] = aOy;
                int k = i + 1;
                ai[j] = ai3[i] >>> l | aOy[k] << 32 - l;
                j++;
                i = k;
            }

            int ai1[] = gf2vector.aOy;
            int ai4[] = aOy;
            j = i + 1;
            ai1[i1 - 1] = ai4[i] >>> l;
            if (j < aOy.length)
            {
                int ai2[] = gf2vector.aOy;
                i = i1 - 1;
                ai2[i] = ai2[i] | aOy[j] << 32 - l;
                return gf2vector;
            }
        } else
        {
            System.arraycopy(aOy, j, gf2vector.aOy, 0, i1);
        }
        return gf2vector;
    }
}
