// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            GF2nField, GF2Polynomial

public class GF2nPolynomialField extends GF2nField
{

    protected final void _mth1532()
    {
        aOE = new GF2Polynomial(1);
        aOE.FE9B(0);
        aOE.FE9B(0);
        aOE = new GF2Polynomial(1);
        aOE.FE9B(0);
        aOE.FE9B(0);
        aOE = new GF2Polynomial(1);
        int i;
label0:
        do
        {
            aOE._mth13DD();
            aOE.FE9B(0);
            aOE.FE9B(0);
            GF2Polynomial gf2polynomial = aOE;
            if (gf2polynomial.isZero())
            {
                i = 0;
                continue;
            }
            GF2Polynomial gf2polynomial5 = new GF2Polynomial(gf2polynomial);
            gf2polynomial5._mth1431();
            int j1 = gf2polynomial5.len;
            GF2Polynomial gf2polynomial2 = new GF2Polynomial(gf2polynomial5.len, "X");
            i = 1;
            do
            {
                if (i > j1 - 1 >> 1)
                {
                    break;
                }
                if (!gf2polynomial2.isZero())
                {
                    if (gf2polynomial2.aOt.length >= gf2polynomial2.aOs << 1)
                    {
                        for (int j = gf2polynomial2.aOs - 1; j >= 0; j--)
                        {
                            gf2polynomial2.aOt[(j << 1) + 1] = GF2Polynomial.aOv[gf2polynomial2.aOt[j] >>> 16 & 0xff] | GF2Polynomial.aOv[(gf2polynomial2.aOt[j] & 0xff000000) >>> 24] << 16;
                            gf2polynomial2.aOt[j << 1] = GF2Polynomial.aOv[gf2polynomial2.aOt[j] & 0xff] | GF2Polynomial.aOv[gf2polynomial2.aOt[j] >>> 8 & 0xff] << 16;
                        }

                        gf2polynomial2.aOs = gf2polynomial2.aOs << 1;
                        gf2polynomial2.len = (gf2polynomial2.len << 1) - 1;
                    } else
                    {
                        int ai[] = new int[gf2polynomial2.aOs << 1];
                        for (int k = 0; k < gf2polynomial2.aOs; k++)
                        {
                            ai[k << 1] = GF2Polynomial.aOv[gf2polynomial2.aOt[k] & 0xff] | GF2Polynomial.aOv[gf2polynomial2.aOt[k] >>> 8 & 0xff] << 16;
                            ai[(k << 1) + 1] = GF2Polynomial.aOv[gf2polynomial2.aOt[k] >>> 16 & 0xff] | GF2Polynomial.aOv[(gf2polynomial2.aOt[k] & 0xff000000) >>> 24] << 16;
                        }

                        gf2polynomial2.aOt = null;
                        gf2polynomial2.aOt = ai;
                        gf2polynomial2.aOs = gf2polynomial2.aOs << 1;
                        gf2polynomial2.len = (gf2polynomial2.len << 1) - 1;
                    }
                }
                GF2Polynomial gf2polynomial1 = gf2polynomial2._mth02CB(gf2polynomial5);
                gf2polynomial2 = gf2polynomial1;
                GF2Polynomial gf2polynomial3 = new GF2Polynomial(32, "X");
                int k1 = Math.min(gf2polynomial1.aOs, gf2polynomial3.aOs);
                Object obj;
                if (gf2polynomial1.len >= gf2polynomial3.len)
                {
                    gf2polynomial1 = new GF2Polynomial(gf2polynomial1);
                    int l = 0;
                    do
                    {
                        obj = gf2polynomial1;
                        if (l >= k1)
                        {
                            break;
                        }
                        obj = gf2polynomial1.aOt;
                        obj[l] = obj[l] ^ gf2polynomial3.aOt[l];
                        l++;
                    } while (true);
                } else
                {
                    gf2polynomial3 = new GF2Polynomial(gf2polynomial3);
                    int i1 = 0;
                    do
                    {
                        obj = gf2polynomial3;
                        if (i1 >= k1)
                        {
                            break;
                        }
                        obj = gf2polynomial3.aOt;
                        obj[i1] = obj[i1] ^ gf2polynomial1.aOt[i1];
                        i1++;
                    } while (true);
                }
                ((GF2Polynomial) (obj))._mth14EE();
                if (!((GF2Polynomial) (obj)).isZero())
                {
                    if (gf2polynomial5.isZero() && ((GF2Polynomial) (obj)).isZero())
                    {
                        throw new ArithmeticException("Both operands of gcd equal zero.");
                    }
                    if (gf2polynomial5.isZero())
                    {
                        obj = new GF2Polynomial(((GF2Polynomial) (obj)));
                    } else
                    if (((GF2Polynomial) (obj)).isZero())
                    {
                        obj = new GF2Polynomial(gf2polynomial5);
                    } else
                    {
                        Object obj1 = new GF2Polynomial(gf2polynomial5);
                        GF2Polynomial gf2polynomial4;
                        for (obj = new GF2Polynomial(((GF2Polynomial) (obj))); !((GF2Polynomial) (obj)).isZero(); obj = gf2polynomial4)
                        {
                            gf2polynomial4 = ((GF2Polynomial) (obj1))._mth02CB(((GF2Polynomial) (obj)));
                            obj1 = obj;
                        }

                        obj = obj1;
                    }
                    if (!((GF2Polynomial) (obj)).FF53())
                    {
                        i = 0;
                        continue label0;
                    }
                } else
                {
                    i = 0;
                    continue label0;
                }
                i++;
            } while (true);
            i = 1;
        } while (i == 0);
    }
}
