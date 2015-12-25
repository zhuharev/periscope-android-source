// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;

// Referenced classes of package org.spongycastle.math.ec:
//            ECFieldElement, ECConstants

public static class amZ extends ECFieldElement
{

    private BigInteger aIC;
    private BigInteger amN;
    private BigInteger amZ;

    private BigInteger modInverse(BigInteger biginteger)
    {
        int i = amN.bitLength();
        int j = i + 31 >> 5;
        int ai[] = Nat._mth141D(i, amN);
        biginteger = Nat._mth141D(i, biginteger);
        int ai1[] = Nat._mth1D37(j);
        Mod._mth02BC(ai, biginteger, ai1);
        return Nat._mth02BF(j, ai1);
    }

    static BigInteger _mth02BC(BigInteger biginteger)
    {
        int i = biginteger.bitLength();
        if (i >= 96 && biginteger.shiftRight(i - 64).longValue() == -1L)
        {
            return ONE.shiftLeft(i).subtract(biginteger);
        } else
        {
            return null;
        }
    }

    private BigInteger _mth02BD(BigInteger biginteger)
    {
        if (aIC != null)
        {
            boolean flag;
            if (biginteger.signum() < 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            BigInteger biginteger1 = biginteger;
            if (flag)
            {
                biginteger1 = biginteger.abs();
            }
            int i = amN.bitLength();
            boolean flag1 = aIC.equals(ECConstants.ONE);
            biginteger = biginteger1;
            do
            {
                biginteger1 = biginteger;
                if (biginteger.bitLength() <= i + 1)
                {
                    break;
                }
                biginteger1 = biginteger.shiftRight(i);
                BigInteger biginteger2 = biginteger.subtract(biginteger1.shiftLeft(i));
                biginteger = biginteger1;
                if (!flag1)
                {
                    biginteger = biginteger1.multiply(aIC);
                }
                biginteger = biginteger.add(biginteger2);
            } while (true);
            for (; biginteger1.compareTo(amN) >= 0; biginteger1 = biginteger1.subtract(amN)) { }
            biginteger = biginteger1;
            if (flag)
            {
                biginteger = biginteger1;
                if (biginteger1.signum() != 0)
                {
                    biginteger = amN.subtract(biginteger1);
                }
            }
            return biginteger;
        } else
        {
            return biginteger.mod(amN);
        }
    }

    private BigInteger[] _mth02CA(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2)
    {
        int i = biginteger2.bitLength();
        int k = biginteger2.getLowestSetBit();
        BigInteger biginteger6 = ECConstants.ONE;
        BigInteger biginteger5 = ECConstants.ars;
        BigInteger biginteger4 = biginteger;
        BigInteger biginteger7 = ECConstants.ONE;
        BigInteger biginteger3 = ECConstants.ONE;
        for (i--; i >= k + 1; i--)
        {
            biginteger7 = _mth02BD(biginteger7.multiply(biginteger3));
            if (biginteger2.testBit(i))
            {
                biginteger3 = _mth02BD(biginteger7.multiply(biginteger1));
                biginteger6 = _mth02BD(biginteger6.multiply(biginteger4));
                biginteger5 = _mth02BD(biginteger4.multiply(biginteger5).subtract(biginteger.multiply(biginteger7)));
                biginteger4 = _mth02BD(biginteger4.multiply(biginteger4).subtract(biginteger3.shiftLeft(1)));
            } else
            {
                biginteger3 = biginteger7;
                biginteger6 = _mth02BD(biginteger6.multiply(biginteger5).subtract(biginteger7));
                biginteger4 = _mth02BD(biginteger4.multiply(biginteger5).subtract(biginteger.multiply(biginteger7)));
                biginteger5 = _mth02BD(biginteger5.multiply(biginteger5).subtract(biginteger7.shiftLeft(1)));
            }
        }

        biginteger3 = _mth02BD(biginteger7.multiply(biginteger3));
        biginteger7 = _mth02BD(biginteger3.multiply(biginteger1));
        biginteger2 = _mth02BD(biginteger6.multiply(biginteger5).subtract(biginteger3));
        biginteger1 = _mth02BD(biginteger4.multiply(biginteger5).subtract(biginteger.multiply(biginteger3)));
        biginteger = _mth02BD(biginteger3.multiply(biginteger7));
        for (int j = 1; j <= k; j++)
        {
            biginteger2 = _mth02BD(biginteger2.multiply(biginteger1));
            biginteger1 = _mth02BD(biginteger1.multiply(biginteger1).subtract(biginteger.shiftLeft(1)));
            biginteger = _mth02BD(biginteger.multiply(biginteger));
        }

        return (new BigInteger[] {
            biginteger2, biginteger1
        });
    }

    private BigInteger _mth02CF(BigInteger biginteger, BigInteger biginteger1)
    {
        return _mth02BD(biginteger.multiply(biginteger1));
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof _cls02BD))
        {
            return false;
        }
        obj = (_cls02BD)obj;
        return amN.equals(((amN) (obj)).amN) && amZ.equals(((amZ) (obj)).amZ);
    }

    public final int getFieldSize()
    {
        return amN.bitLength();
    }

    public int hashCode()
    {
        return amN.hashCode() ^ amZ.hashCode();
    }

    public final BigInteger toBigInteger()
    {
        return amZ;
    }

    public final ECFieldElement _mth02BB(ECFieldElement ecfieldelement)
    {
        return new <init>(amN, aIC, _mth02CF(amZ, modInverse(ecfieldelement.toBigInteger())));
    }

    public final ECFieldElement _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
    {
        BigInteger biginteger = amZ;
        ecfieldelement = ecfieldelement.toBigInteger();
        ecfieldelement1 = ecfieldelement1.toBigInteger();
        biginteger = biginteger.multiply(biginteger);
        ecfieldelement = ecfieldelement.multiply(ecfieldelement1);
        return new <init>(amN, aIC, _mth02BD(biginteger.add(ecfieldelement)));
    }

    public final ECFieldElement _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement ecfieldelement2)
    {
        BigInteger biginteger = amZ;
        ecfieldelement = ecfieldelement.toBigInteger();
        ecfieldelement1 = ecfieldelement1.toBigInteger();
        ecfieldelement2 = ecfieldelement2.toBigInteger();
        ecfieldelement = biginteger.multiply(ecfieldelement);
        ecfieldelement1 = ecfieldelement1.multiply(ecfieldelement2);
        return new <init>(amN, aIC, _mth02BD(ecfieldelement.subtract(ecfieldelement1)));
    }

    public final ECFieldElement _mth02CB(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement ecfieldelement2)
    {
        BigInteger biginteger = amZ;
        ecfieldelement = ecfieldelement.toBigInteger();
        ecfieldelement1 = ecfieldelement1.toBigInteger();
        ecfieldelement2 = ecfieldelement2.toBigInteger();
        ecfieldelement = biginteger.multiply(ecfieldelement);
        ecfieldelement1 = ecfieldelement1.multiply(ecfieldelement2);
        return new <init>(amN, aIC, _mth02BD(ecfieldelement.add(ecfieldelement1)));
    }

    public final ECFieldElement _mth02CE(ECFieldElement ecfieldelement)
    {
        BigInteger biginteger1 = amN;
        BigInteger biginteger2 = aIC;
        BigInteger biginteger = amZ.add(ecfieldelement.toBigInteger());
        ecfieldelement = biginteger;
        if (biginteger.compareTo(amN) >= 0)
        {
            ecfieldelement = biginteger.subtract(amN);
        }
        return new <init>(biginteger1, biginteger2, ecfieldelement);
    }

    public final ECFieldElement _mth02CF(ECFieldElement ecfieldelement)
    {
        BigInteger biginteger1 = amN;
        BigInteger biginteger2 = aIC;
        BigInteger biginteger = amZ.subtract(ecfieldelement.toBigInteger());
        ecfieldelement = biginteger;
        if (biginteger.signum() < 0)
        {
            ecfieldelement = biginteger.add(amN);
        }
        return new <init>(biginteger1, biginteger2, ecfieldelement);
    }

    public final ECFieldElement _mth141D(ECFieldElement ecfieldelement)
    {
        return new <init>(amN, aIC, _mth02CF(amZ, ecfieldelement.toBigInteger()));
    }

    public final ECFieldElement FF26()
    {
        BigInteger biginteger1 = amZ.add(ECConstants.ONE);
        BigInteger biginteger = biginteger1;
        if (biginteger1.compareTo(amN) == 0)
        {
            biginteger = ECConstants.ZERO;
        }
        return new <init>(amN, aIC, biginteger);
    }

    public final ECFieldElement FF29()
    {
        if (amZ.signum() == 0)
        {
            return this;
        } else
        {
            return new <init>(amN, aIC, amN.subtract(amZ));
        }
    }

    public final ECFieldElement FF4C()
    {
        return new <init>(amN, aIC, _mth02CF(amZ, amZ));
    }

    public final ECFieldElement FF4E()
    {
        return new <init>(amN, aIC, modInverse(amZ));
    }

    public final ECFieldElement FF52()
    {
        if (isZero() || FF53())
        {
            return this;
        }
        if (!amN.testBit(0))
        {
            throw new RuntimeException("not done yet");
        }
        if (amN.testBit(1))
        {
            Object obj = amN.shiftRight(2).add(ECConstants.ONE);
            obj = new <init>(amN, aIC, amZ.modPow(((BigInteger) (obj)), amN));
            if (((ECFieldElement) (obj)).FF4C().equals(this))
            {
                return ((ECFieldElement) (obj));
            } else
            {
                return null;
            }
        }
        if (amN.testBit(2))
        {
            Object obj1 = amZ.modPow(amN.shiftRight(3), amN);
            BigInteger biginteger2 = _mth02CF(((BigInteger) (obj1)), amZ);
            if (_mth02CF(biginteger2, ((BigInteger) (obj1))).equals(ECConstants.ONE))
            {
                obj1 = new <init>(amN, aIC, biginteger2);
                if (((ECFieldElement) (obj1)).FF4C().equals(this))
                {
                    return ((ECFieldElement) (obj1));
                } else
                {
                    return null;
                }
            }
            obj1 = _mth02CF(biginteger2, ECConstants.ars.modPow(amN.shiftRight(2), amN));
            obj1 = new <init>(amN, aIC, ((BigInteger) (obj1)));
            if (((ECFieldElement) (obj1)).FF4C().equals(this))
            {
                return ((ECFieldElement) (obj1));
            } else
            {
                return null;
            }
        }
        BigInteger biginteger5 = amN.shiftRight(1);
        if (!amZ.modPow(biginteger5, amN).equals(ECConstants.ONE))
        {
            return null;
        }
        BigInteger biginteger7 = amZ;
        BigInteger biginteger3 = biginteger7.shiftLeft(1);
        BigInteger biginteger = biginteger3;
        if (biginteger3.compareTo(amN) >= 0)
        {
            biginteger = biginteger3.subtract(amN);
        }
        biginteger3 = biginteger.shiftLeft(1);
        biginteger = biginteger3;
        if (biginteger3.compareTo(amN) >= 0)
        {
            biginteger = biginteger3.subtract(amN);
        }
        BigInteger biginteger9 = biginteger5.add(ECConstants.ONE);
        BigInteger biginteger10 = amN.subtract(ECConstants.ONE);
        Random random = new Random();
        BigInteger biginteger11;
        do
        {
            BigInteger biginteger4;
            do
            {
                biginteger4 = new BigInteger(amN.bitLength(), random);
            } while (biginteger4.compareTo(amN) >= 0 || !_mth02BD(biginteger4.multiply(biginteger4).subtract(biginteger)).modPow(biginteger5, amN).equals(biginteger10));
            BigInteger abiginteger[] = _mth02CA(biginteger4, biginteger7, biginteger9);
            biginteger11 = abiginteger[0];
            abiginteger = abiginteger[1];
            if (_mth02CF(abiginteger, abiginteger).equals(biginteger))
            {
                BigInteger biginteger6 = amN;
                BigInteger biginteger8 = aIC;
                BigInteger biginteger1 = abiginteger;
                abiginteger = biginteger1;
                if (biginteger1.testBit(0))
                {
                    abiginteger = amN.subtract(biginteger1);
                }
                return new <init>(biginteger6, biginteger8, abiginteger.shiftRight(1));
            }
        } while (biginteger11.equals(ECConstants.ONE) || biginteger11.equals(biginteger10));
        return null;
    }

    public (BigInteger biginteger, BigInteger biginteger1)
    {
        this(biginteger, _mth02BC(biginteger), biginteger1);
    }

    _cls02BC(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2)
    {
        if (biginteger2 == null || biginteger2.signum() < 0 || biginteger2.compareTo(biginteger) >= 0)
        {
            throw new IllegalArgumentException("x value invalid in Fp field element");
        } else
        {
            amN = biginteger;
            aIC = biginteger1;
            amZ = biginteger2;
            return;
        }
    }
}
