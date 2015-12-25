// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            ECPoint, ECPointMap, ECCurve, WNafPreCompInfo

public abstract class WNafUtil
{

    private static final byte WQ[] = new byte[0];
    private static final int aJf[] = {
        13, 41, 121, 337, 897, 2305
    };
    private static final int _fld1506[] = new int[0];

    public WNafUtil()
    {
    }

    public static ECPoint _mth02CA(ECPoint ecpoint, int i, boolean flag, ECPointMap ecpointmap)
    {
        ECCurve eccurve = ecpoint.FF79();
        WNafPreCompInfo wnafprecompinfo = _mth02CA(ecpoint, i, true);
        ECPoint ecpoint1 = ecpointmap._mth02BC(ecpoint);
        ecpoint = eccurve._mth02CA(ecpoint1, "bc_wnaf");
        if (ecpoint != null && (ecpoint instanceof WNafPreCompInfo))
        {
            ecpoint = (WNafPreCompInfo)ecpoint;
        } else
        {
            ecpoint = new WNafPreCompInfo();
        }
        ECPoint ecpoint2 = wnafprecompinfo._mth03F9();
        if (ecpoint2 != null)
        {
            ecpoint._mth02BD(ecpointmap._mth02BC(ecpoint2));
        }
        ECPoint aecpoint1[] = wnafprecompinfo._mth03D9();
        ECPoint aecpoint[] = new ECPoint[aecpoint1.length];
        for (i = 0; i < aecpoint1.length; i++)
        {
            aecpoint[i] = ecpointmap._mth02BC(aecpoint1[i]);
        }

        ecpoint._mth02CB(aecpoint);
        ecpointmap = new ECPoint[aecpoint.length];
        for (i = 0; i < ecpointmap.length; i++)
        {
            ecpointmap[i] = aecpoint[i]._mth029C();
        }

        ecpoint._mth02CE(ecpointmap);
        eccurve._mth02CA(ecpoint1, "bc_wnaf", ecpoint);
        return ecpoint1;
    }

    public static WNafPreCompInfo _mth02CA(ECPoint ecpoint, int i, boolean flag)
    {
        ECCurve eccurve = ecpoint.FF79();
        PreCompInfo precompinfo = eccurve._mth02CA(ecpoint, "bc_wnaf");
        WNafPreCompInfo wnafprecompinfo;
        if (precompinfo != null && (precompinfo instanceof WNafPreCompInfo))
        {
            wnafprecompinfo = (WNafPreCompInfo)precompinfo;
        } else
        {
            wnafprecompinfo = new WNafPreCompInfo();
        }
        ECPoint aecpoint2[] = wnafprecompinfo._mth03D9();
        ECPoint aecpoint[] = aecpoint2;
        if (aecpoint2 == null)
        {
            aecpoint = new ECPoint[1];
            aecpoint[0] = ecpoint;
        }
        int j = aecpoint.length;
        int i1 = 1 << Math.max(0, i - 2);
        aecpoint2 = aecpoint;
        if (j < i1)
        {
            aecpoint2 = new ECPoint[i1];
            System.arraycopy(aecpoint, 0, aecpoint2, 0, aecpoint.length);
            if (i1 == 2)
            {
                aecpoint2[1] = aecpoint2[0]._mth039A();
            } else
            {
                ECPoint ecpoint2 = wnafprecompinfo._mth03F9();
                i = j;
                ECPoint ecpoint1 = ecpoint2;
                if (ecpoint2 == null)
                {
                    ecpoint1 = aecpoint2[0]._mth038E();
                    wnafprecompinfo._mth02BD(ecpoint1);
                    i = j;
                }
                for (; i < i1; i++)
                {
                    aecpoint2[i] = ecpoint1._mth141D(aecpoint2[i - 1]);
                }

            }
            eccurve._mth02CA(aecpoint2);
        }
        wnafprecompinfo._mth02CB(aecpoint2);
        if (flag)
        {
            ECPoint aecpoint3[] = wnafprecompinfo._mth03F5();
            ECPoint aecpoint1[];
            if (aecpoint3 == null)
            {
                i = 0;
                aecpoint1 = new ECPoint[i1];
            } else
            {
                int l = aecpoint3.length;
                int k = l;
                i = k;
                aecpoint1 = aecpoint3;
                if (l < i1)
                {
                    aecpoint1 = new ECPoint[i1];
                    System.arraycopy(aecpoint3, 0, aecpoint1, 0, aecpoint3.length);
                    i = k;
                }
            }
            for (; i < i1; i++)
            {
                aecpoint1[i] = aecpoint2[i]._mth029C();
            }

            wnafprecompinfo._mth02CE(aecpoint1);
        }
        eccurve._mth02CA(ecpoint, "bc_wnaf", wnafprecompinfo);
        return wnafprecompinfo;
    }

    public static int[] _mth02CE(int i, BigInteger biginteger)
    {
        if (i == 2)
        {
            return _mth037A(biginteger);
        }
        if (i < 2 || i > 16)
        {
            throw new IllegalArgumentException("'width' must be in the range [2, 16]");
        }
        if (biginteger.bitLength() >>> 16 != 0)
        {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        }
        if (biginteger.signum() == 0)
        {
            return _fld1506;
        }
        int ai[] = new int[biginteger.bitLength() / i + 1];
        int j1 = 1 << i;
        boolean flag1 = false;
        int k = 0;
        int j = 0;
        int i1;
        do
        {
            i1 = k;
            if (j > biginteger.bitLength())
            {
                break;
            }
            if (biginteger.testBit(j) == flag1)
            {
                j++;
                k = i1;
            } else
            {
                biginteger = biginteger.shiftRight(j);
                int l = biginteger.intValue() & j1 - 1;
                k = l;
                if (flag1)
                {
                    k = l + 1;
                }
                boolean flag;
                if ((k & j1 >>> 1) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                flag1 = flag;
                l = k;
                if (flag)
                {
                    l = k - j1;
                }
                if (i1 > 0)
                {
                    j--;
                }
                k = i1 + 1;
                ai[i1] = l << 16 | j;
                j = i;
            }
        } while (true);
        biginteger = ai;
        if (ai.length > i1)
        {
            biginteger = new int[i1];
            System.arraycopy(ai, 0, biginteger, 0, biginteger.length);
        }
        return biginteger;
    }

    public static byte[] _mth02CF(int i, BigInteger biginteger)
    {
        if (i == 2)
        {
            if (biginteger.signum() == 0)
            {
                return WQ;
            }
            BigInteger biginteger1 = biginteger.shiftLeft(1).add(biginteger);
            int l = biginteger1.bitLength() - 1;
            byte abyte0[] = new byte[l];
            biginteger1 = biginteger1.xor(biginteger);
            int j;
            for (i = 1; i < l; i = j + 1)
            {
                j = i;
                if (!biginteger1.testBit(i))
                {
                    continue;
                }
                if (biginteger.testBit(i))
                {
                    j = -1;
                } else
                {
                    j = 1;
                }
                abyte0[i - 1] = (byte)j;
                j = i + 1;
            }

            abyte0[l - 1] = 1;
            return abyte0;
        }
        if (i < 2 || i > 8)
        {
            throw new IllegalArgumentException("'width' must be in the range [2, 8]");
        }
        if (biginteger.signum() == 0)
        {
            return WQ;
        }
        byte abyte1[] = new byte[biginteger.bitLength() + 1];
        int l1 = 1 << i;
        boolean flag1 = false;
        int j1 = 0;
        for (int k = 0; k <= biginteger.bitLength();)
        {
            if (biginteger.testBit(k) == flag1)
            {
                k++;
            } else
            {
                biginteger = biginteger.shiftRight(k);
                int k1 = biginteger.intValue() & l1 - 1;
                int i1 = k1;
                if (flag1)
                {
                    i1 = k1 + 1;
                }
                boolean flag;
                if ((i1 & l1 >>> 1) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                flag1 = flag;
                k1 = i1;
                if (flag)
                {
                    k1 = i1 - l1;
                }
                if (j1 > 0)
                {
                    k--;
                }
                k = j1 + k;
                j1 = k + 1;
                abyte1[k] = (byte)k1;
                k = i;
            }
        }

        biginteger = abyte1;
        if (abyte1.length > j1)
        {
            biginteger = new byte[j1];
            System.arraycopy(abyte1, 0, biginteger, 0, biginteger.length);
        }
        return biginteger;
    }

    public static WNafPreCompInfo _mth037A(ECPoint ecpoint)
    {
        ecpoint = ecpoint.FF79()._mth02CA(ecpoint, "bc_wnaf");
        if (ecpoint != null && (ecpoint instanceof WNafPreCompInfo))
        {
            return (WNafPreCompInfo)ecpoint;
        } else
        {
            return new WNafPreCompInfo();
        }
    }

    public static int[] _mth037A(BigInteger biginteger)
    {
        if (biginteger.bitLength() >>> 16 != 0)
        {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        }
        if (biginteger.signum() == 0)
        {
            return _fld1506;
        }
        BigInteger biginteger1 = biginteger.shiftLeft(1).add(biginteger);
        int j1 = biginteger1.bitLength();
        int ai[] = new int[j1 >> 1];
        biginteger1 = biginteger1.xor(biginteger);
        int l = 0;
        int k = 0;
        for (int i = 1; i < j1 - 1; i++)
        {
            if (!biginteger1.testBit(i))
            {
                k++;
                continue;
            }
            byte byte0;
            if (biginteger.testBit(i))
            {
                byte0 = -1;
            } else
            {
                byte0 = 1;
            }
            int i1 = l + 1;
            ai[l] = byte0 << 16 | k;
            k = 1;
            i++;
            l = i1;
        }

        int j = l + 1;
        ai[l] = 0x10000 | k;
        biginteger = ai;
        if (ai.length > j)
        {
            biginteger = new int[j];
            System.arraycopy(ai, 0, biginteger, 0, biginteger.length);
        }
        return biginteger;
    }

    public static int _mth1D0A(int i)
    {
        int ai[] = aJf;
        int j;
        for (j = 0; j < ai.length && i >= ai[j]; j++) { }
        return j + 2;
    }

    public static int _mth1FBE(BigInteger biginteger)
    {
        if (biginteger.signum() == 0)
        {
            return 0;
        } else
        {
            return biginteger.shiftLeft(1).add(biginteger).xor(biginteger).bitCount();
        }
    }

}
