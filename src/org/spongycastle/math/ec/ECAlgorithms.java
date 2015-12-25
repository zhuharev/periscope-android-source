// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.ec.endo.GLVEndomorphism;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.PolynomialExtensionField;

// Referenced classes of package org.spongycastle.math.ec:
//            ECPoint, ECCurve, ECMultiplier, WNafPreCompInfo, 
//            WNafUtil, ECFieldElement, ECConstants, ECPointMap

public class ECAlgorithms
{

    public ECAlgorithms()
    {
    }

    public static ECPoint _mth02CA(ECCurve eccurve, ECPoint ecpoint)
    {
        if (!eccurve._mth02BB(ecpoint.FF79()))
        {
            throw new IllegalArgumentException("Point must be on the same curve");
        } else
        {
            return eccurve._mth02CE(ecpoint);
        }
    }

    public static ECPoint _mth02CA(ECPoint ecpoint, BigInteger biginteger, ECPoint ecpoint1, BigInteger biginteger1)
    {
        Object obj = ecpoint.FF79();
        if (!((ECCurve) (obj))._mth02BB(ecpoint1.FF79()))
        {
            throw new IllegalArgumentException("Point must be on the same curve");
        }
        Object obj1 = ((ECCurve) (obj))._mth02CE(ecpoint1);
        if ((obj instanceof ECCurve.F2m) && ((ECCurve.F2m)obj).FECB())
        {
            ecpoint = ecpoint.FF79().FE9F()._mth02CA(ecpoint, biginteger)._mth141D(((ECPoint) (obj1)).FF79().FE9F()._mth02CA(((ECPoint) (obj1)), biginteger1));
            if (!ecpoint.isValid())
            {
                throw new IllegalArgumentException("Invalid point");
            } else
            {
                return ecpoint;
            }
        }
        obj = ((ECCurve) (obj)).FE95();
        if (obj instanceof GLVEndomorphism)
        {
            ecpoint1 = new ECPoint[2];
            ecpoint1[0] = ecpoint;
            ecpoint1[1] = obj1;
            obj = (GLVEndomorphism)obj;
            BigInteger biginteger2 = ecpoint1[0].FF79().getOrder();
            ecpoint = new BigInteger[4];
            int i = 0;
            int k = 0;
            for (; i < 2; i++)
            {
                obj1 = ((GLVEndomorphism) (obj))._mth02BF((new BigInteger[] {
                    biginteger, biginteger1
                })[i].mod(biginteger2));
                int l = k + 1;
                ecpoint[k] = obj1[0];
                k = l + 1;
                ecpoint[l] = obj1[1];
            }

            biginteger = ((GLVEndomorphism) (obj))._mth043D();
            k = ecpoint1.length;
            i = k << 1;
            biginteger1 = new boolean[i];
            WNafPreCompInfo awnafprecompinfo[] = new WNafPreCompInfo[i];
            byte abyte0[][] = new byte[i][];
            for (int j = 0; j < k; j++)
            {
                int i1 = j << 1;
                int k1 = i1 + 1;
                obj1 = ecpoint[i1];
                byte byte0;
                if (((BigInteger) (obj1)).signum() < 0)
                {
                    byte0 = 1;
                } else
                {
                    byte0 = 0;
                }
                biginteger1[i1] = byte0;
                obj1 = ((BigInteger) (obj1)).abs();
                BigInteger biginteger4 = ecpoint[k1];
                if (biginteger4.signum() < 0)
                {
                    byte0 = 1;
                } else
                {
                    byte0 = 0;
                }
                biginteger1[k1] = byte0;
                biginteger4 = biginteger4.abs();
                int i2 = Math.max(2, Math.min(16, WNafUtil._mth1D0A(Math.max(((BigInteger) (obj1)).bitLength(), biginteger4.bitLength()))));
                ECPoint ecpoint2 = ecpoint1[j];
                ECPoint ecpoint3 = WNafUtil._mth02CA(ecpoint2, i2, true, biginteger);
                awnafprecompinfo[i1] = WNafUtil._mth037A(ecpoint2);
                awnafprecompinfo[k1] = WNafUtil._mth037A(ecpoint3);
                abyte0[i1] = WNafUtil._mth02CF(i2, ((BigInteger) (obj1)));
                abyte0[k1] = WNafUtil._mth02CF(i2, biginteger4);
            }

            ecpoint = _mth02CA(((boolean []) (biginteger1)), awnafprecompinfo, abyte0);
            if (!ecpoint.isValid())
            {
                throw new IllegalArgumentException("Invalid point");
            } else
            {
                return ecpoint;
            }
        }
        boolean flag;
        if (biginteger.signum() < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (biginteger1.signum() < 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        awnafprecompinfo = biginteger.abs();
        BigInteger biginteger3 = biginteger1.abs();
        int j1 = Math.max(2, Math.min(16, WNafUtil._mth1D0A(awnafprecompinfo.bitLength())));
        int l1 = Math.max(2, Math.min(16, WNafUtil._mth1D0A(biginteger3.bitLength())));
        ecpoint1 = WNafUtil._mth02CA(ecpoint, j1, true);
        biginteger1 = WNafUtil._mth02CA(((ECPoint) (obj1)), l1, true);
        if (flag)
        {
            ecpoint = ecpoint1._mth03F5();
        } else
        {
            ecpoint = ecpoint1._mth03D9();
        }
        if (flag1)
        {
            biginteger = biginteger1._mth03F5();
        } else
        {
            biginteger = biginteger1._mth03D9();
        }
        if (flag)
        {
            ecpoint1 = ecpoint1._mth03D9();
        } else
        {
            ecpoint1 = ecpoint1._mth03F5();
        }
        if (flag1)
        {
            biginteger1 = biginteger1._mth03D9();
        } else
        {
            biginteger1 = biginteger1._mth03F5();
        }
        ecpoint = _mth02CA(((ECPoint []) (ecpoint)), ((ECPoint []) (ecpoint1)), WNafUtil._mth02CF(j1, awnafprecompinfo), ((ECPoint []) (biginteger)), ((ECPoint []) (biginteger1)), WNafUtil._mth02CF(l1, biginteger3));
        if (!ecpoint.isValid())
        {
            throw new IllegalArgumentException("Invalid point");
        } else
        {
            return ecpoint;
        }
    }

    static ECPoint _mth02CA(ECPoint ecpoint, BigInteger biginteger, ECPointMap ecpointmap, BigInteger biginteger1)
    {
        boolean flag;
        if (biginteger.signum() < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (biginteger1.signum() < 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        BigInteger biginteger2 = biginteger.abs();
        BigInteger biginteger3 = biginteger1.abs();
        int i = Math.max(2, Math.min(16, WNafUtil._mth1D0A(Math.max(biginteger2.bitLength(), biginteger3.bitLength()))));
        biginteger = WNafUtil._mth02CA(ecpoint, i, true, ecpointmap);
        ecpointmap = WNafUtil._mth037A(ecpoint);
        biginteger1 = WNafUtil._mth037A(biginteger);
        if (flag)
        {
            ecpoint = ecpointmap._mth03F5();
        } else
        {
            ecpoint = ecpointmap._mth03D9();
        }
        if (flag1)
        {
            biginteger = biginteger1._mth03F5();
        } else
        {
            biginteger = biginteger1._mth03D9();
        }
        if (flag)
        {
            ecpointmap = ecpointmap._mth03D9();
        } else
        {
            ecpointmap = ecpointmap._mth03F5();
        }
        if (flag1)
        {
            biginteger1 = biginteger1._mth03D9();
        } else
        {
            biginteger1 = biginteger1._mth03F5();
        }
        return _mth02CA(((ECPoint []) (ecpoint)), ((ECPoint []) (ecpointmap)), WNafUtil._mth02CF(i, biginteger2), ((ECPoint []) (biginteger)), ((ECPoint []) (biginteger1)), WNafUtil._mth02CF(i, biginteger3));
    }

    private static ECPoint _mth02CA(ECPoint aecpoint[], ECPoint aecpoint1[], byte abyte0[], ECPoint aecpoint2[], ECPoint aecpoint3[], byte abyte1[])
    {
        int j = Math.max(abyte0.length, abyte1.length);
        ECPoint ecpoint1 = aecpoint[0].FF79()._mth5B80();
        int i = 0;
        int l = j - 1;
        ECPoint ecpoint = ecpoint1;
        for (; l >= 0; l--)
        {
            int k;
            if (l < abyte0.length)
            {
                k = abyte0[l];
            } else
            {
                k = 0;
            }
            byte byte0;
            if (l < abyte1.length)
            {
                byte0 = abyte1[l];
            } else
            {
                byte0 = 0;
            }
            if ((k | byte0) == 0)
            {
                i++;
                continue;
            }
            Object obj1 = ecpoint1;
            Object obj = obj1;
            if (k != 0)
            {
                int i1 = Math.abs(k);
                if (k < 0)
                {
                    obj = aecpoint1;
                } else
                {
                    obj = aecpoint;
                }
                obj = ((ECPoint) (obj1))._mth141D(obj[i1 >>> 1]);
            }
            obj1 = obj;
            if (byte0 != 0)
            {
                k = Math.abs(byte0);
                if (byte0 < 0)
                {
                    obj1 = aecpoint3;
                } else
                {
                    obj1 = aecpoint2;
                }
                obj1 = ((ECPoint) (obj))._mth141D(obj1[k >>> 1]);
            }
            obj = ecpoint;
            k = i;
            if (i > 0)
            {
                obj = ecpoint._mth1483(i);
                k = 0;
            }
            ecpoint = ((ECPoint) (obj))._mth02BB(((ECPoint) (obj1)));
            i = k;
        }

        aecpoint = ecpoint;
        if (i > 0)
        {
            aecpoint = ecpoint._mth1483(i);
        }
        return aecpoint;
    }

    private static ECPoint _mth02CA(boolean aflag[], WNafPreCompInfo awnafprecompinfo[], byte abyte0[][])
    {
        int i = 0;
        int j1 = abyte0.length;
        for (int j = 0; j < j1; j++)
        {
            i = Math.max(i, abyte0[j].length);
        }

        ECPoint ecpoint1 = awnafprecompinfo[0]._mth03D9()[0].FF79()._mth5B80();
        boolean flag = false;
        int i1 = i - 1;
        i = ((flag) ? 1 : 0);
        ECPoint ecpoint = ecpoint1;
        for (; i1 >= 0; i1--)
        {
            Object obj = ecpoint1;
            for (int k = 0; k < j1;)
            {
                byte abyte1[] = abyte0[k];
                byte byte0;
                if (i1 < abyte1.length)
                {
                    byte0 = abyte1[i1];
                } else
                {
                    byte0 = 0;
                }
                Object obj1 = obj;
                if (byte0 != 0)
                {
                    int k1 = Math.abs(byte0);
                    obj1 = awnafprecompinfo[k];
                    boolean flag1;
                    if (byte0 < 0)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag1 == aflag[k])
                    {
                        obj1 = ((WNafPreCompInfo) (obj1))._mth03D9();
                    } else
                    {
                        obj1 = ((WNafPreCompInfo) (obj1))._mth03F5();
                    }
                    obj1 = ((ECPoint) (obj))._mth141D(obj1[k1 >>> 1]);
                }
                k++;
                obj = obj1;
            }

            if (obj == ecpoint1)
            {
                i++;
                continue;
            }
            ECPoint ecpoint2 = ecpoint;
            int l = i;
            if (i > 0)
            {
                ecpoint2 = ecpoint._mth1483(i);
                l = 0;
            }
            ecpoint = ecpoint2._mth02BB(((ECPoint) (obj)));
            i = l;
        }

        aflag = ecpoint;
        if (i > 0)
        {
            aflag = ecpoint._mth1483(i);
        }
        return aflag;
    }

    public static void _mth02CA(ECFieldElement aecfieldelement[], int i, int j)
    {
        ECFieldElement aecfieldelement1[] = new ECFieldElement[j];
        aecfieldelement1[0] = aecfieldelement[0];
        i = 0;
        do
        {
            i++;
            if (i >= j)
            {
                break;
            }
            aecfieldelement1[i] = aecfieldelement1[i - 1]._mth141D(aecfieldelement[i + 0]);
        } while (true);
        i--;
        ECFieldElement ecfieldelement = aecfieldelement1[i].FF4E();
        do
        {
            j = i;
            if (j > 0)
            {
                i = j - 1;
                j += 0;
                ECFieldElement ecfieldelement1 = aecfieldelement[j];
                aecfieldelement[j] = aecfieldelement1[i]._mth141D(ecfieldelement);
                ecfieldelement = ecfieldelement._mth141D(ecfieldelement1);
            } else
            {
                aecfieldelement[0] = ecfieldelement;
                return;
            }
        } while (true);
    }

    public static ECPoint _mth02CB(ECPoint ecpoint)
    {
        if (!ecpoint.isValid())
        {
            throw new IllegalArgumentException("Invalid point");
        } else
        {
            return ecpoint;
        }
    }

    public static ECPoint _mth02CE(ECPoint ecpoint, BigInteger biginteger)
    {
        BigInteger biginteger1 = biginteger.abs();
        ECPoint ecpoint2 = ecpoint.FF79()._mth5B80();
        int j = biginteger1.bitLength();
        ECPoint ecpoint1 = ecpoint2;
        if (j > 0)
        {
            ecpoint1 = ecpoint2;
            if (biginteger1.testBit(0))
            {
                ecpoint1 = ecpoint;
            }
            int i = 1;
            ecpoint2 = ecpoint;
            ecpoint = ecpoint1;
            do
            {
                ecpoint1 = ecpoint;
                if (i >= j)
                {
                    break;
                }
                ecpoint2 = ecpoint2._mth038E();
                ecpoint1 = ecpoint;
                if (biginteger1.testBit(i))
                {
                    ecpoint1 = ecpoint._mth141D(ecpoint2);
                }
                i++;
                ecpoint = ecpoint1;
            } while (true);
        }
        if (biginteger.signum() < 0)
        {
            return ecpoint1._mth029C();
        } else
        {
            return ecpoint1;
        }
    }

    public static boolean _mth02CF(ECCurve eccurve)
    {
        eccurve = eccurve.FB25();
        return eccurve._mth0546() > 1 && eccurve._mth0506().equals(ECConstants.ars) && (eccurve instanceof PolynomialExtensionField);
    }

    public static boolean _mth141D(ECCurve eccurve)
    {
        return eccurve.FB25()._mth0546() == 1;
    }
}
