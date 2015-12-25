// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;

// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            GF2mField, PolynomialGF2mSmallM, PolynomialRingGF2, GF2Matrix, 
//            GF2Vector, Permutation

public final class GoppaCode
{
    public static class MaMaPe
    {

        public Permutation aLW;
        public GF2Matrix aLX;
        private GF2Matrix aOJ;

        public MaMaPe(GF2Matrix gf2matrix, GF2Matrix gf2matrix1, Permutation permutation)
        {
            aOJ = gf2matrix;
            aLX = gf2matrix1;
            aLW = permutation;
        }
    }

    public static class MatrixSet
    {
    }


    private GoppaCode()
    {
    }

    public static GF2Matrix _mth02CA(GF2mField gf2mfield, PolynomialGF2mSmallM polynomialgf2msmallm)
    {
        int i3 = gf2mfield.aOz;
        int j3 = 1 << i3;
        int i = polynomialgf2msmallm.aOM.length - 1;
        if (polynomialgf2msmallm.aOM[i] == 0)
        {
            i = -1;
        }
        int ai[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            i, j3
        });
        int ai1[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            i, j3
        });
        for (int j = 0; j < j3; j++)
        {
            ai1[0][j] = gf2mfield._mth1D4B(polynomialgf2msmallm._mth027F(j), (1 << gf2mfield.aOz) - 2);
        }

        for (int k = 1; k < i; k++)
        {
            for (int j1 = 0; j1 < j3; j1++)
            {
                ai1[k][j1] = PolynomialRingGF2._mth1428(ai1[k - 1][j1], j1, gf2mfield.aOA);
            }

        }

        for (int l = 0; l < i; l++)
        {
            for (int k1 = 0; k1 < j3; k1++)
            {
                for (int i2 = 0; i2 <= l; i2++)
                {
                    int ai2[] = ai[l];
                    int k3 = ai[l][k1];
                    int i4 = ai1[i2][k1];
                    int k2 = (i + i2) - l;
                    if (k2 < 0 || k2 > polynomialgf2msmallm.aOz)
                    {
                        k2 = 0;
                    } else
                    {
                        k2 = polynomialgf2msmallm.aOM[k2];
                    }
                    ai2[k1] = GF2mField._mth1D40(k3, PolynomialRingGF2._mth1428(i4, k2, gf2mfield.aOA));
                }

            }

        }

        gf2mfield = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            i * i3, j3 + 31 >>> 5
        });
        for (int i1 = 0; i1 < j3; i1++)
        {
            int l2 = i1 >>> 5;
            for (int l1 = 0; l1 < i; l1++)
            {
                int l3 = ai[l1][i1];
                for (int j2 = 0; j2 < i3; j2++)
                {
                    if ((l3 >>> j2 & 1) != 0)
                    {
                        polynomialgf2msmallm = gf2mfield[(l1 + 1) * i3 - j2 - 1];
                        polynomialgf2msmallm[l2] = polynomialgf2msmallm[l2] ^ 1 << (i1 & 0x1f);
                    }
                }

            }

        }

        return new GF2Matrix(j3, gf2mfield);
    }

    public static GF2Vector _mth02CA(GF2Vector gf2vector, GF2mField gf2mfield, PolynomialGF2mSmallM polynomialgf2msmallm, PolynomialGF2mSmallM apolynomialgf2msmallm[])
    {
        GF2Vector gf2vector1;
        int i;
        int l1;
label0:
        {
            l1 = 1 << gf2mfield.aOz;
            gf2vector1 = new GF2Vector(l1);
            i = gf2vector.aOy.length - 1;
            do
            {
                if (i < 0)
                {
                    break;
                }
                if (gf2vector.aOy[i] != 0)
                {
                    i = 0;
                    break label0;
                }
                i--;
            } while (true);
            i = 1;
        }
        if (i == 0)
        {
            PolynomialGF2mSmallM polynomialgf2msmallm1 = new PolynomialGF2mSmallM(gf2vector._mth02CA(gf2mfield));
            gf2vector = polynomialgf2msmallm1.aOM;
            int ai6[] = polynomialgf2msmallm.aOM;
            int ai3[] = PolynomialGF2mSmallM._mth1428(ai6);
            int ai2[] = polynomialgf2msmallm1._mth0640(gf2vector, ai6);
            gf2vector = new int[1];
            GF2Vector _tmp = gf2vector;
            gf2vector[0] = 0;
            Object obj2;
            for (int ai[] = polynomialgf2msmallm1._mth0640(new int[] {
    1
}, ai6); PolynomialGF2mSmallM._mth1427(ai2) != -1; ai = PolynomialGF2mSmallM._mth1428(((int []) (obj2))))
            {
                obj2 = polynomialgf2msmallm1._mth02CD(ai3, ai2);
                ai3 = PolynomialGF2mSmallM._mth1428(ai2);
                ai2 = PolynomialGF2mSmallM._mth1428(obj2[1]);
                obj2 = polynomialgf2msmallm1._mth02CC(gf2vector, polynomialgf2msmallm1._mth0640(polynomialgf2msmallm1._mth02D1(obj2[0], ai), ai6));
                gf2vector = PolynomialGF2mSmallM._mth1428(ai);
            }

            int j = PolynomialGF2mSmallM._mth0640(ai3);
            Object obj = polynomialgf2msmallm1.aLU;
            gf2vector = polynomialgf2msmallm1._mth141D(gf2vector, ((GF2mField) (obj))._mth1D4B(j, (1 << ((GF2mField) (obj)).aOz) - 2));
            gf2vector = new PolynomialGF2mSmallM(polynomialgf2msmallm1.aLU, gf2vector);
            int ai1[] = new int[2];
            ai1[1] = 1;
            ai1 = gf2vector._mth02CC(((PolynomialGF2mSmallM) (gf2vector)).aOM, ai1);
            gf2vector = new PolynomialGF2mSmallM(((PolynomialGF2mSmallM) (gf2vector)).aLU, ai1);
            int i2 = apolynomialgf2msmallm.length;
            ai1 = new int[i2];
            for (j = 0; j < i2; j++)
            {
                for (int l = 0; l < i2; l++)
                {
                    if (j < apolynomialgf2msmallm[l].aOM.length && l < ((PolynomialGF2mSmallM) (gf2vector)).aOM.length)
                    {
                        GF2mField gf2mfield1 = ((PolynomialGF2mSmallM) (gf2vector)).aLU;
                        int j1 = PolynomialRingGF2._mth1428(apolynomialgf2msmallm[l].aOM[j], ((PolynomialGF2mSmallM) (gf2vector)).aOM[l], gf2mfield1.aOA);
                        ai1[j] = GF2mField._mth1D40(ai1[j], j1);
                    }
                }

            }

            for (j = 0; j < i2; j++)
            {
                apolynomialgf2msmallm = ((PolynomialGF2mSmallM) (gf2vector)).aLU;
                int k1 = ai1[j];
                for (int i1 = 1; i1 < ((GF2mField) (apolynomialgf2msmallm)).aOz; i1++)
                {
                    k1 = PolynomialRingGF2._mth1428(k1, k1, ((GF2mField) (apolynomialgf2msmallm)).aOA);
                }

                ai1[j] = k1;
            }

            PolynomialGF2mSmallM polynomialgf2msmallm2 = new PolynomialGF2mSmallM(((PolynomialGF2mSmallM) (gf2vector)).aLU, ai1);
            j = polynomialgf2msmallm.aOz;
            Object obj1 = PolynomialGF2mSmallM._mth1428(polynomialgf2msmallm.aOM);
            apolynomialgf2msmallm = polynomialgf2msmallm2._mth0640(polynomialgf2msmallm2.aOM, polynomialgf2msmallm.aOM);
            ai1 = new int[1];
            int[] _tmp1 = ai1;
            ai1[0] = 0;
            gf2vector = new int[1];
            GF2Vector _tmp2 = gf2vector;
            gf2vector[0] = 1;
            while (PolynomialGF2mSmallM._mth1427(apolynomialgf2msmallm) > j >> 1) 
            {
                obj1 = polynomialgf2msmallm2._mth02CD(((int []) (obj1)), apolynomialgf2msmallm);
                int ai5[] = obj1[1];
                obj1 = obj1[0];
                int ai4[] = polynomialgf2msmallm.aOM;
                ai4 = polynomialgf2msmallm2._mth02CC(ai1, polynomialgf2msmallm2._mth0640(polynomialgf2msmallm2._mth02D1(((int []) (obj1)), gf2vector), ai4));
                obj1 = apolynomialgf2msmallm;
                apolynomialgf2msmallm = ai5;
                ai1 = gf2vector;
                gf2vector = ai4;
            }
            polynomialgf2msmallm = new PolynomialGF2mSmallM[2];
            polynomialgf2msmallm[0] = new PolynomialGF2mSmallM(polynomialgf2msmallm2.aLU, apolynomialgf2msmallm);
            polynomialgf2msmallm[1] = new PolynomialGF2mSmallM(polynomialgf2msmallm2.aLU, gf2vector);
            gf2vector = polynomialgf2msmallm[0];
            apolynomialgf2msmallm = polynomialgf2msmallm[0];
            apolynomialgf2msmallm = gf2vector._mth02D1(((PolynomialGF2mSmallM) (gf2vector)).aOM, ((PolynomialGF2mSmallM) (apolynomialgf2msmallm)).aOM);
            gf2vector = new PolynomialGF2mSmallM(((PolynomialGF2mSmallM) (gf2vector)).aLU, apolynomialgf2msmallm);
            apolynomialgf2msmallm = polynomialgf2msmallm[1];
            polynomialgf2msmallm = polynomialgf2msmallm[1];
            polynomialgf2msmallm = apolynomialgf2msmallm._mth02D1(((PolynomialGF2mSmallM) (apolynomialgf2msmallm)).aOM, polynomialgf2msmallm.aOM);
            polynomialgf2msmallm = new PolynomialGF2mSmallM(((PolynomialGF2mSmallM) (apolynomialgf2msmallm)).aLU, polynomialgf2msmallm);
            apolynomialgf2msmallm = PolynomialGF2mSmallM._mth02BB(polynomialgf2msmallm.aOM, 1);
            polynomialgf2msmallm = new PolynomialGF2mSmallM(polynomialgf2msmallm.aLU, apolynomialgf2msmallm);
            polynomialgf2msmallm = gf2vector._mth02CC(((PolynomialGF2mSmallM) (gf2vector)).aOM, polynomialgf2msmallm.aOM);
            gf2vector = new PolynomialGF2mSmallM(((PolynomialGF2mSmallM) (gf2vector)).aLU, polynomialgf2msmallm);
            if (((PolynomialGF2mSmallM) (gf2vector)).aOz == -1)
            {
                j = 0;
            } else
            {
                j = ((PolynomialGF2mSmallM) (gf2vector)).aOM[((PolynomialGF2mSmallM) (gf2vector)).aOz];
            }
            gf2vector = gf2vector._mth029F(gf2mfield._mth1D4B(j, (1 << gf2mfield.aOz) - 2));
            for (int k = 0; k < l1; k++)
            {
                if (gf2vector._mth027F(k) == 0)
                {
                    gf2vector1.FE9B(k);
                }
            }

        }
        return gf2vector1;
    }

    public static MaMaPe _mth02CA(GF2Matrix gf2matrix, SecureRandom securerandom)
    {
        ArithmeticException arithmeticexception;
        int i = gf2matrix.getNumColumns();
        GF2Matrix gf2matrix1 = null;
        GF2Matrix gf2matrix2;
        Permutation permutation;
        GF2Matrix gf2matrix3;
        GF2Matrix gf2matrix4;
        boolean flag;
        do
        {
            permutation = new Permutation(i, securerandom);
            gf2matrix3 = (GF2Matrix)gf2matrix._mth02CA(permutation);
            gf2matrix4 = gf2matrix3._mth0E11();
            flag = true;
            try
            {
                gf2matrix2 = (GF2Matrix)gf2matrix4._mth0E2D();
            }
            // Misplaced declaration of an exception variable
            catch (ArithmeticException arithmeticexception)
            {
                flag = false;
                gf2matrix2 = gf2matrix1;
            }
            gf2matrix1 = gf2matrix2;
        } while (!flag);
        return new MaMaPe(gf2matrix4, ((GF2Matrix)gf2matrix2._mth02CA(gf2matrix3))._mth0E19(), permutation);
    }
}
