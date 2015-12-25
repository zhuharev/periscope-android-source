// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            PolynomialGF2mSmallM, GF2mField

public class PolynomialRingGF2m
{

    private GF2mField aLU;
    private PolynomialGF2mSmallM aON;
    private PolynomialGF2mSmallM aOO[];
    private PolynomialGF2mSmallM aOP[];

    public PolynomialRingGF2m(GF2mField gf2mfield, PolynomialGF2mSmallM polynomialgf2msmallm)
    {
        aLU = gf2mfield;
        aON = polynomialgf2msmallm;
        _mth1542();
        _mth1543();
    }

    private void _mth1542()
    {
        PolynomialGF2mSmallM polynomialgf2msmallm = aON;
        int i = polynomialgf2msmallm.aOM.length - 1;
        if (polynomialgf2msmallm.aOM[i] == 0)
        {
            i = -1;
        }
        aOO = new PolynomialGF2mSmallM[i];
        for (int j = 0; j < i >> 1; j++)
        {
            int ai[] = new int[(j << 1) + 1];
            ai[j << 1] = 1;
            aOO[j] = new PolynomialGF2mSmallM(aLU, ai);
        }

        for (int k = i >> 1; k < i; k++)
        {
            int ai1[] = new int[(k << 1) + 1];
            ai1[k << 1] = 1;
            PolynomialGF2mSmallM polynomialgf2msmallm1 = new PolynomialGF2mSmallM(aLU, ai1);
            PolynomialGF2mSmallM apolynomialgf2msmallm[] = aOO;
            PolynomialGF2mSmallM polynomialgf2msmallm2 = aON;
            int ai2[] = polynomialgf2msmallm1._mth0640(polynomialgf2msmallm1.aOM, polynomialgf2msmallm2.aOM);
            apolynomialgf2msmallm[k] = new PolynomialGF2mSmallM(polynomialgf2msmallm1.aLU, ai2);
        }

    }

    private void _mth1543()
    {
        PolynomialGF2mSmallM polynomialgf2msmallm = aON;
        int i = polynomialgf2msmallm.aOM.length - 1;
        if (polynomialgf2msmallm.aOM[i] == 0)
        {
            i = -1;
        }
        PolynomialGF2mSmallM apolynomialgf2msmallm[] = new PolynomialGF2mSmallM[i];
        for (int j = i - 1; j >= 0; j--)
        {
            apolynomialgf2msmallm[j] = new PolynomialGF2mSmallM(aOO[j]);
        }

        aOP = new PolynomialGF2mSmallM[i];
        for (int k = i - 1; k >= 0; k--)
        {
            aOP[k] = new PolynomialGF2mSmallM(aLU, k);
        }

        for (int j1 = 0; j1 < i; j1++)
        {
            PolynomialGF2mSmallM polynomialgf2msmallm1 = apolynomialgf2msmallm[j1];
            int l;
            if (j1 < 0 || j1 > polynomialgf2msmallm1.aOz)
            {
                l = 0;
            } else
            {
                l = polynomialgf2msmallm1.aOM[j1];
            }
            if (l == 0)
            {
                boolean flag = false;
                int i2;
                for (l = j1 + 1; l < i; l = i2 + 1)
                {
                    polynomialgf2msmallm1 = apolynomialgf2msmallm[l];
                    int l1;
                    if (j1 < 0 || j1 > polynomialgf2msmallm1.aOz)
                    {
                        l1 = 0;
                    } else
                    {
                        l1 = polynomialgf2msmallm1.aOM[j1];
                    }
                    i2 = l;
                    if (l1 != 0)
                    {
                        flag = true;
                        polynomialgf2msmallm1 = apolynomialgf2msmallm[j1];
                        apolynomialgf2msmallm[j1] = apolynomialgf2msmallm[l];
                        apolynomialgf2msmallm[l] = polynomialgf2msmallm1;
                        PolynomialGF2mSmallM apolynomialgf2msmallm1[] = aOP;
                        PolynomialGF2mSmallM polynomialgf2msmallm4 = apolynomialgf2msmallm1[j1];
                        apolynomialgf2msmallm1[j1] = apolynomialgf2msmallm1[l];
                        apolynomialgf2msmallm1[l] = polynomialgf2msmallm4;
                        i2 = i;
                    }
                }

                if (!flag)
                {
                    throw new ArithmeticException("Squaring matrix is not invertible.");
                }
            }
            apolynomialgf2msmallm1 = apolynomialgf2msmallm[j1];
            if (j1 < 0 || j1 > ((PolynomialGF2mSmallM) (apolynomialgf2msmallm1)).aOz)
            {
                l = 0;
            } else
            {
                l = ((PolynomialGF2mSmallM) (apolynomialgf2msmallm1)).aOM[j1];
            }
            l = aLU.FF68(l);
            apolynomialgf2msmallm[j1]._mth02B0(l);
            aOP[j1]._mth02B0(l);
            for (int i1 = 0; i1 < i; i1++)
            {
                if (i1 == j1)
                {
                    continue;
                }
                PolynomialGF2mSmallM polynomialgf2msmallm2 = apolynomialgf2msmallm[i1];
                int k1;
                if (j1 < 0 || j1 > polynomialgf2msmallm2.aOz)
                {
                    k1 = 0;
                } else
                {
                    k1 = polynomialgf2msmallm2.aOM[j1];
                }
                if (k1 != 0)
                {
                    PolynomialGF2mSmallM polynomialgf2msmallm3 = apolynomialgf2msmallm[j1]._mth029F(k1);
                    PolynomialGF2mSmallM polynomialgf2msmallm5 = aOP[j1]._mth029F(k1);
                    apolynomialgf2msmallm[i1]._mth02CA(polynomialgf2msmallm3);
                    aOP[i1]._mth02CA(polynomialgf2msmallm5);
                }
            }

        }

    }

    public final PolynomialGF2mSmallM[] _mth153D()
    {
        return aOP;
    }
}
