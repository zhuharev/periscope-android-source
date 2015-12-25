// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            ECConstants, ZTauElement, ECFieldElement, SimpleBigDecimal, 
//            ECCurve

class Tnaf
{

    private static final BigInteger aIW;
    private static final BigInteger aIX;
    private static final BigInteger aIY;
    public static final ZTauElement aIZ[];
    private static byte aJa[][];
    public static final ZTauElement aJb[];
    private static byte aJc[][] = {
        null, {
            1
        }, null, {
            -1, 0, 1
        }, null, {
            1, 0, 1
        }, null, {
            -1, 0, 0, -1
        }
    };

    Tnaf()
    {
    }

    public static byte _mth02CA(ECCurve.F2m f2m)
    {
        if (!f2m.FECB())
        {
            throw new IllegalArgumentException("No Koblitz curve (ABC), TNAF multiplication not possible");
        }
        return ((byte)(!f2m.FB46().isZero() ? 1 : -1));
    }

    public static BigInteger _mth02CA(byte byte0, int i)
    {
        if (byte0 == 1)
        {
            return BigInteger.valueOf(6L);
        } else
        {
            return BigInteger.valueOf(10L);
        }
    }

    private static SimpleBigDecimal _mth02CA(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2, byte byte0, int i, int j)
    {
        int k = (i + 5) / 2 + j;
        biginteger = biginteger1.multiply(biginteger.shiftRight((i - k - 2) + byte0));
        biginteger2 = biginteger.add(biginteger2.multiply(biginteger.shiftRight(i)));
        biginteger1 = biginteger2.shiftRight(k - j);
        biginteger = biginteger1;
        if (biginteger2.testBit(k - j - 1))
        {
            biginteger = biginteger1.add(ECConstants.ONE);
        }
        return new SimpleBigDecimal(biginteger, j);
    }

    public static ZTauElement _mth02CA(BigInteger biginteger, int i, byte byte0, BigInteger abiginteger[], byte byte1, byte byte2)
    {
        BigInteger biginteger1;
        if (byte1 == 1)
        {
            biginteger1 = abiginteger[0].add(abiginteger[1]);
        } else
        {
            biginteger1 = abiginteger[0].subtract(abiginteger[1]);
        }
        Object obj1 = _mth02CA(byte1, i, true)[1];
        Object obj = _mth02CA(biginteger, abiginteger[0], ((BigInteger) (obj1)), byte0, i, 10);
        obj1 = _mth02CA(biginteger, abiginteger[1], ((BigInteger) (obj1)), byte0, i, 10);
        i = ((SimpleBigDecimal) (obj)).aIV;
        if (((SimpleBigDecimal) (obj1)).aIV != i)
        {
            throw new IllegalArgumentException("lambda0 and lambda1 do not have same scale");
        }
        if (byte1 != 1 && byte1 != -1)
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        BigInteger biginteger2 = ((SimpleBigDecimal) (obj))._mth03EF();
        BigInteger biginteger3 = ((SimpleBigDecimal) (obj1))._mth03EF();
        SimpleBigDecimal simplebigdecimal = new SimpleBigDecimal(((SimpleBigDecimal) (obj)).aIU.subtract(biginteger2.shiftLeft(((SimpleBigDecimal) (obj)).aIV)), ((SimpleBigDecimal) (obj)).aIV);
        obj1 = new SimpleBigDecimal(((SimpleBigDecimal) (obj1)).aIU.subtract(biginteger3.shiftLeft(((SimpleBigDecimal) (obj1)).aIV)), ((SimpleBigDecimal) (obj1)).aIV);
        obj = simplebigdecimal._mth02CA(simplebigdecimal);
        if (byte1 == 1)
        {
            obj = ((SimpleBigDecimal) (obj))._mth02CA(((SimpleBigDecimal) (obj1)));
        } else
        {
            obj = ((SimpleBigDecimal) (obj))._mth02CA(new SimpleBigDecimal(((SimpleBigDecimal) (obj1)).aIU.negate(), ((SimpleBigDecimal) (obj1)).aIV));
        }
        SimpleBigDecimal simplebigdecimal1 = ((SimpleBigDecimal) (obj1))._mth02CA(((SimpleBigDecimal) (obj1)))._mth02CA(((SimpleBigDecimal) (obj1)));
        Object obj2 = simplebigdecimal1._mth02CA(((SimpleBigDecimal) (obj1)));
        if (byte1 == 1)
        {
            obj1 = simplebigdecimal._mth02CA(new SimpleBigDecimal(simplebigdecimal1.aIU.negate(), simplebigdecimal1.aIV));
            simplebigdecimal = simplebigdecimal._mth02CA(((SimpleBigDecimal) (obj2)));
        } else
        {
            obj1 = simplebigdecimal._mth02CA(simplebigdecimal1);
            simplebigdecimal = simplebigdecimal._mth02CA(new SimpleBigDecimal(((SimpleBigDecimal) (obj2)).aIU.negate(), ((SimpleBigDecimal) (obj2)).aIV));
        }
        int j = 0;
        i = 0;
        obj2 = ECConstants.ONE;
        if (((SimpleBigDecimal) (obj)).aIU.compareTo(((BigInteger) (obj2)).shiftLeft(((SimpleBigDecimal) (obj)).aIV)) >= 0)
        {
            obj2 = aIW;
            if (((SimpleBigDecimal) (obj1)).aIU.compareTo(((BigInteger) (obj2)).shiftLeft(((SimpleBigDecimal) (obj1)).aIV)) < 0)
            {
                i = byte1;
                byte2 = j;
            } else
            {
                byte2 = 1;
            }
        } else
        {
            obj2 = ECConstants.ars;
            byte2 = j;
            if (simplebigdecimal.aIU.compareTo(((BigInteger) (obj2)).shiftLeft(simplebigdecimal.aIV)) >= 0)
            {
                i = byte1;
                byte2 = j;
            }
        }
        obj2 = aIW;
        if (((SimpleBigDecimal) (obj)).aIU.compareTo(((BigInteger) (obj2)).shiftLeft(((SimpleBigDecimal) (obj)).aIV)) < 0)
        {
            obj = ECConstants.ONE;
            if (((SimpleBigDecimal) (obj1)).aIU.compareTo(((BigInteger) (obj)).shiftLeft(((SimpleBigDecimal) (obj1)).aIV)) >= 0)
            {
                i = (byte)(-byte1);
                j = byte2;
            } else
            {
                j = -1;
            }
        } else
        {
            obj = aIX;
            j = byte2;
            if (simplebigdecimal.aIU.compareTo(((BigInteger) (obj)).shiftLeft(simplebigdecimal.aIV)) < 0)
            {
                i = (byte)(-byte1);
                j = byte2;
            }
        }
        obj = new ZTauElement(biginteger2.add(BigInteger.valueOf(j)), biginteger3.add(BigInteger.valueOf(i)));
        return new ZTauElement(biginteger.subtract(biginteger1.multiply(((ZTauElement) (obj)).ana)).subtract(BigInteger.valueOf(2L).multiply(abiginteger[1]).multiply(((ZTauElement) (obj)).aJh)), abiginteger[1].multiply(((ZTauElement) (obj)).ana).subtract(abiginteger[0].multiply(((ZTauElement) (obj)).aJh)));
    }

    public static byte[] _mth02CA(byte byte0, ZTauElement ztauelement, byte byte1, BigInteger biginteger, BigInteger biginteger1, ZTauElement aztauelement[])
    {
        if (byte0 != 1 && byte0 != -1)
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        BigInteger biginteger2 = ztauelement.ana.multiply(ztauelement.ana);
        BigInteger biginteger3 = ztauelement.ana.multiply(ztauelement.aJh);
        BigInteger biginteger4 = ztauelement.aJh.multiply(ztauelement.aJh).shiftLeft(1);
        if (byte0 == 1)
        {
            biginteger2 = biginteger2.add(biginteger3).add(biginteger4);
        } else
        if (byte0 == -1)
        {
            biginteger2 = biginteger2.subtract(biginteger3).add(biginteger4);
        } else
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        byte1 = biginteger2.bitLength();
        if (byte1 > 30)
        {
            byte1 = byte1 + 4 + 4;
        } else
        {
            byte1 = 38;
        }
        byte abyte0[] = new byte[byte1];
        BigInteger biginteger5 = biginteger.shiftRight(1);
        biginteger2 = ztauelement.ana;
        ztauelement = ztauelement.aJh;
        for (byte1 = 0; !biginteger2.equals(ECConstants.ZERO) || !ztauelement.equals(ECConstants.ZERO); byte1++)
        {
            Object obj;
            if (biginteger2.testBit(0))
            {
                obj = biginteger2.add(ztauelement.multiply(biginteger1)).mod(biginteger);
                byte byte2;
                if (((BigInteger) (obj)).compareTo(biginteger5) >= 0)
                {
                    byte2 = (byte)((BigInteger) (obj)).subtract(biginteger).intValue();
                } else
                {
                    byte2 = (byte)((BigInteger) (obj)).intValue();
                }
                abyte0[byte1] = byte2;
                boolean flag = true;
                byte byte3 = byte2;
                if (byte2 < 0)
                {
                    flag = false;
                    byte3 = (byte)(-byte2);
                }
                if (flag)
                {
                    biginteger2 = biginteger2.subtract(aztauelement[byte3].ana);
                    obj = ztauelement.subtract(aztauelement[byte3].aJh);
                    ztauelement = biginteger2;
                } else
                {
                    biginteger2 = biginteger2.add(aztauelement[byte3].ana);
                    obj = ztauelement.add(aztauelement[byte3].aJh);
                    ztauelement = biginteger2;
                }
            } else
            {
                abyte0[byte1] = 0;
                obj = ztauelement;
                ztauelement = biginteger2;
            }
            if (byte0 == 1)
            {
                biginteger2 = ((BigInteger) (obj)).add(ztauelement.shiftRight(1));
            } else
            {
                biginteger2 = ((BigInteger) (obj)).subtract(ztauelement.shiftRight(1));
            }
            ztauelement = ztauelement.shiftRight(1).negate();
        }

        return abyte0;
    }

    private static BigInteger[] _mth02CA(byte byte0, int i, boolean flag)
    {
        if (byte0 != 1 && byte0 != -1)
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        BigInteger biginteger;
        BigInteger biginteger1;
        if (flag)
        {
            biginteger1 = ECConstants.ars;
            biginteger = BigInteger.valueOf(byte0);
        } else
        {
            biginteger1 = ECConstants.ZERO;
            biginteger = ECConstants.ONE;
        }
        for (int j = 1; j < i; j++)
        {
            BigInteger biginteger2;
            if (byte0 == 1)
            {
                biginteger2 = biginteger;
            } else
            {
                biginteger2 = biginteger.negate();
            }
            biginteger2 = biginteger2.subtract(biginteger1.shiftLeft(1));
            biginteger1 = biginteger;
            biginteger = biginteger2;
        }

        return (new BigInteger[] {
            biginteger1, biginteger
        });
    }

    public static ECPoint.F2m[] _mth02CA(ECPoint.F2m f2m, byte byte0)
    {
        ECPoint.F2m af2m[] = new ECPoint.F2m[16];
        af2m[1] = f2m;
        byte abyte0[][];
        if (byte0 == 0)
        {
            abyte0 = aJa;
        } else
        {
            abyte0 = aJc;
        }
        for (byte0 = 3; byte0 < 8; byte0 += 2)
        {
            byte abyte1[] = abyte0[byte0];
            ECPoint.F2m f2m1 = (ECPoint.F2m)((ECCurve.F2m)f2m.FF79())._mth5B80();
            for (int i = abyte1.length - 1; i >= 0; i--)
            {
                ECPoint.F2m f2m2 = f2m1._mth039B();
                if (abyte1[i] == 1)
                {
                    f2m1 = f2m2._mth02CA(f2m);
                    continue;
                }
                f2m1 = f2m2;
                if (abyte1[i] != -1)
                {
                    continue;
                }
                if (f2m._mth021D())
                {
                    f2m1 = f2m2;
                } else
                {
                    f2m1 = f2m2._mth02CA((ECPoint.F2m)f2m._mth029C());
                }
            }

            af2m[byte0] = f2m1;
        }

        f2m.FF79()._mth02CA(af2m);
        return af2m;
    }

    public static ECPoint.F2m _mth02CB(ECPoint.F2m f2m)
    {
        return f2m._mth039B();
    }

    public static BigInteger[] _mth02CB(ECCurve.F2m f2m)
    {
        byte byte0;
        byte byte1;
        int i;
        int j;
label0:
        {
            if (!f2m.FECB())
            {
                throw new IllegalArgumentException("si is defined for Koblitz curves only");
            }
            i = f2m.afJ;
            j = f2m.FB46().toBigInteger().intValue();
            byte0 = f2m.FECC();
            f2m = f2m.FB52();
            if (f2m != null)
            {
                if (f2m.equals(ECConstants.ars))
                {
                    byte1 = 1;
                    break label0;
                }
                if (f2m.equals(ECConstants.aIp))
                {
                    byte1 = 2;
                    break label0;
                }
            }
            throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
        }
        f2m = _mth02CA(byte0, (i + 3) - j, false);
        if (byte0 == 1)
        {
            f2m[0] = f2m[0].negate();
            f2m[1] = f2m[1].negate();
        }
        return (new BigInteger[] {
            ECConstants.ONE.add(f2m[1]).shiftRight(byte1), ECConstants.ONE.add(f2m[0]).shiftRight(byte1).negate()
        });
    }

    static 
    {
        aIW = ECConstants.ONE.negate();
        aIX = ECConstants.ars.negate();
        aIY = ECConstants.aIo.negate();
        aIZ = (new ZTauElement[] {
            null, new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null, new ZTauElement(aIY, aIW), null, new ZTauElement(aIW, aIW), null, new ZTauElement(ECConstants.ONE, aIW), null
        });
        byte abyte0[] = {
            -1, 0, 1
        };
        byte abyte1[] = {
            1, 0, 1
        };
        aJa = (new byte[][] {
            null, new byte[] {
                1
            }, null, abyte0, null, abyte1, null, new byte[] {
                -1, 0, 0, 1
            }
        });
        aJb = (new ZTauElement[] {
            null, new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null, new ZTauElement(aIY, ECConstants.ONE), null, new ZTauElement(aIW, ECConstants.ONE), null, new ZTauElement(ECConstants.ONE, ECConstants.ONE), null
        });
    }
}
