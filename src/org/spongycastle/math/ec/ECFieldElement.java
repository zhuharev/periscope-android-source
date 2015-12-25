// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.math.ec:
//            ECConstants, LongArray

public abstract class ECFieldElement
    implements ECConstants
{
    public static class F2m extends ECFieldElement
    {

        private int aIE;
        private int aIF[];
        private LongArray aIG;
        private int afJ;

        public static void _mth02CB(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
        {
            if (!(ecfieldelement instanceof F2m) || !(ecfieldelement1 instanceof F2m))
            {
                throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
            }
            ecfieldelement = (F2m)ecfieldelement;
            ecfieldelement1 = (F2m)ecfieldelement1;
            if (((F2m) (ecfieldelement)).aIE != ((F2m) (ecfieldelement1)).aIE)
            {
                throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
            }
            if (((F2m) (ecfieldelement)).afJ != ((F2m) (ecfieldelement1)).afJ || !Arrays._mth1427(((F2m) (ecfieldelement)).aIF, ((F2m) (ecfieldelement1)).aIF))
            {
                throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
            } else
            {
                return;
            }
        }

        public final int bitLength()
        {
            return aIG._mth03EE();
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (!(obj instanceof F2m))
            {
                return false;
            }
            obj = (F2m)obj;
            return afJ == ((F2m) (obj)).afJ && aIE == ((F2m) (obj)).aIE && Arrays._mth1427(aIF, ((F2m) (obj)).aIF) && aIG.equals(((F2m) (obj)).aIG);
        }

        public final int getFieldSize()
        {
            return afJ;
        }

        public int hashCode()
        {
            return aIG.hashCode() ^ afJ ^ Arrays.hashCode(aIF);
        }

        public final boolean isZero()
        {
            long al[] = aIG.aIQ;
            for (int i = 0; i < al.length; i++)
            {
                if (al[i] != 0L)
                {
                    return false;
                }
            }

            return true;
        }

        public final BigInteger toBigInteger()
        {
            LongArray longarray = aIG;
            int l1 = longarray._mth14D2(longarray.aIQ.length);
            if (l1 == 0)
            {
                return ECConstants.ZERO;
            }
            long l2 = longarray.aIQ[l1 - 1];
            byte abyte0[] = new byte[8];
            int i = 0;
            boolean flag = false;
            for (int j = 7; j >= 0;)
            {
                int j1;
label0:
                {
                    byte byte0 = (byte)(int)(l2 >>> j * 8);
                    if (!flag)
                    {
                        j1 = i;
                        if (byte0 == 0)
                        {
                            break label0;
                        }
                    }
                    flag = true;
                    j1 = i + 1;
                    abyte0[i] = byte0;
                }
                j--;
                i = j1;
            }

            byte abyte1[] = new byte[(l1 - 1) * 8 + i];
            for (int k = 0; k < i; k++)
            {
                abyte1[k] = abyte0[k];
            }

            for (int l = l1 - 2; l >= 0; l--)
            {
                long l3 = longarray.aIQ[l];
                for (int i1 = 7; i1 >= 0;)
                {
                    int k1 = i + 1;
                    abyte1[i] = (byte)(int)(l3 >>> i1 * 8);
                    i1--;
                    i = k1;
                }

            }

            return new BigInteger(1, abyte1);
        }

        public final ECFieldElement _mth02BB(ECFieldElement ecfieldelement)
        {
            return _mth141D(ecfieldelement.FF4E());
        }

        public final ECFieldElement _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
        {
            LongArray longarray = aIG;
            LongArray longarray1 = ((F2m)ecfieldelement).aIG;
            ecfieldelement1 = ((F2m)ecfieldelement1).aIG;
            int i = longarray._mth14D2(longarray.aIQ.length);
            if (i == 0)
            {
                ecfieldelement = longarray;
            } else
            {
                int k = i << 1;
                ecfieldelement = new long[k];
                for (int j = 0; j < k;)
                {
                    long l1 = longarray.aIQ[j >>> 1];
                    int l = j + 1;
                    ecfieldelement[j] = LongArray._mth1646((int)l1);
                    j = l + 1;
                    ecfieldelement[l] = LongArray._mth1646((int)(l1 >>> 32));
                }

                ecfieldelement = new LongArray(ecfieldelement, 0, ecfieldelement.length);
            }
            longarray1 = longarray1._mth02CA(ecfieldelement1);
            ecfieldelement1 = ecfieldelement;
            if (ecfieldelement == longarray)
            {
                ecfieldelement1 = (LongArray)ecfieldelement.clone();
            }
            ecfieldelement1._mth02CA(longarray1, 0);
            ecfieldelement1._mth02CB(afJ, aIF);
            return new F2m(afJ, aIF, ecfieldelement1);
        }

        public final ECFieldElement _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement ecfieldelement2)
        {
            return _mth02CB(ecfieldelement, ecfieldelement1, ecfieldelement2);
        }

        public final ECFieldElement _mth02CB(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement ecfieldelement2)
        {
label0:
            {
                LongArray longarray = aIG;
                LongArray longarray1 = ((F2m)ecfieldelement).aIG;
                ecfieldelement = ((F2m)ecfieldelement1).aIG;
                ecfieldelement2 = ((F2m)ecfieldelement2).aIG;
                ecfieldelement1 = longarray._mth02CA(longarray1);
                ecfieldelement2 = ecfieldelement._mth02CA(ecfieldelement2);
                if (ecfieldelement1 != longarray)
                {
                    ecfieldelement = ecfieldelement1;
                    if (ecfieldelement1 != longarray1)
                    {
                        break label0;
                    }
                }
                ecfieldelement = (LongArray)ecfieldelement1.clone();
            }
            ecfieldelement._mth02CA(ecfieldelement2, 0);
            ecfieldelement._mth02CB(afJ, aIF);
            return new F2m(afJ, aIF, ecfieldelement);
        }

        public final ECFieldElement _mth02CE(ECFieldElement ecfieldelement)
        {
            LongArray longarray = (LongArray)aIG.clone();
            longarray._mth02CA(((F2m)ecfieldelement).aIG, 0);
            return new F2m(afJ, aIF, longarray);
        }

        public final ECFieldElement _mth02CF(ECFieldElement ecfieldelement)
        {
            return _mth02CE(ecfieldelement);
        }

        public final ECFieldElement _mth141D(ECFieldElement ecfieldelement)
        {
            return new F2m(afJ, aIF, aIG._mth02CA(((F2m)ecfieldelement).aIG, afJ, aIF));
        }

        public final ECFieldElement FF26()
        {
            int i = afJ;
            int ai[] = aIF;
            LongArray longarray = aIG;
            if (longarray.aIQ.length == 0)
            {
                longarray = new LongArray(new long[] {
                    1L
                });
            } else
            {
                int j = Math.max(1, longarray._mth03DD());
                long al[] = new long[j];
                System.arraycopy(longarray.aIQ, 0, al, 0, Math.min(longarray.aIQ.length, j));
                al[0] = al[0] ^ 1L;
                longarray = new LongArray(al);
            }
            return new F2m(i, ai, longarray);
        }

        public final ECFieldElement FF29()
        {
            return this;
        }

        public final ECFieldElement FF4C()
        {
            return new F2m(afJ, aIF, aIG._mth02CE(afJ, aIF));
        }

        public final ECFieldElement FF4E()
        {
            return new F2m(afJ, aIF, aIG._mth02CF(afJ, aIF));
        }

        public final ECFieldElement FF52()
        {
            LongArray longarray;
label0:
            {
label1:
                {
                    int i;
label2:
                    {
                        longarray = aIG;
                        if (longarray.FF53())
                        {
                            break label1;
                        }
                        long al[] = longarray.aIQ;
                        i = 0;
                        do
                        {
                            if (i >= al.length)
                            {
                                break;
                            }
                            if (al[i] != 0L)
                            {
                                i = 0;
                                break label2;
                            }
                            i++;
                        } while (true);
                        i = 1;
                    }
                    if (i == 0)
                    {
                        break label0;
                    }
                }
                return this;
            }
            int k = afJ - 1;
            int i1 = afJ;
            int ai[] = aIF;
            int l = longarray._mth14D2(longarray.aIQ.length);
            int j = l;
            if (l != 0)
            {
                long al1[] = new long[(i1 + 63 >>> 6) << 1];
                System.arraycopy(longarray.aIQ, 0, al1, 0, j);
                do
                {
                    k--;
                    if (k < 0)
                    {
                        break;
                    }
                    LongArray._mth02CA(al1, j);
                    j = LongArray._mth02CA(al1, 0, al1.length, i1, ai);
                } while (true);
                longarray = new LongArray(al1, 0, j);
            }
            return new F2m(afJ, aIF, longarray);
        }

        public final boolean FF53()
        {
            return aIG.FF53();
        }

        public final boolean FF66()
        {
            LongArray longarray = aIG;
            return longarray.aIQ.length > 0 && (longarray.aIQ[0] & 1L) != 0L;
        }

        public F2m(int i, int j, int k, int l, BigInteger biginteger)
        {
            if (k == 0 && l == 0)
            {
                aIE = 2;
                aIF = (new int[] {
                    j
                });
            } else
            {
                if (k >= l)
                {
                    throw new IllegalArgumentException("k2 must be smaller than k3");
                }
                if (k <= 0)
                {
                    throw new IllegalArgumentException("k2 must be larger than 0");
                }
                aIE = 3;
                aIF = (new int[] {
                    j, k, l
                });
            }
            afJ = i;
            aIG = new LongArray(biginteger);
        }

        private F2m(int i, int ai[], LongArray longarray)
        {
            afJ = i;
            if (ai.length == 1)
            {
                i = 2;
            } else
            {
                i = 3;
            }
            aIE = i;
            aIF = ai;
            aIG = longarray;
        }
    }

    public static class Fp extends ECFieldElement
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
            if (!(obj instanceof Fp))
            {
                return false;
            }
            obj = (Fp)obj;
            return amN.equals(((Fp) (obj)).amN) && amZ.equals(((Fp) (obj)).amZ);
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
            return new Fp(amN, aIC, _mth02CF(amZ, modInverse(ecfieldelement.toBigInteger())));
        }

        public final ECFieldElement _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
        {
            BigInteger biginteger = amZ;
            ecfieldelement = ecfieldelement.toBigInteger();
            ecfieldelement1 = ecfieldelement1.toBigInteger();
            biginteger = biginteger.multiply(biginteger);
            ecfieldelement = ecfieldelement.multiply(ecfieldelement1);
            return new Fp(amN, aIC, _mth02BD(biginteger.add(ecfieldelement)));
        }

        public final ECFieldElement _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement ecfieldelement2)
        {
            BigInteger biginteger = amZ;
            ecfieldelement = ecfieldelement.toBigInteger();
            ecfieldelement1 = ecfieldelement1.toBigInteger();
            ecfieldelement2 = ecfieldelement2.toBigInteger();
            ecfieldelement = biginteger.multiply(ecfieldelement);
            ecfieldelement1 = ecfieldelement1.multiply(ecfieldelement2);
            return new Fp(amN, aIC, _mth02BD(ecfieldelement.subtract(ecfieldelement1)));
        }

        public final ECFieldElement _mth02CB(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement ecfieldelement2)
        {
            BigInteger biginteger = amZ;
            ecfieldelement = ecfieldelement.toBigInteger();
            ecfieldelement1 = ecfieldelement1.toBigInteger();
            ecfieldelement2 = ecfieldelement2.toBigInteger();
            ecfieldelement = biginteger.multiply(ecfieldelement);
            ecfieldelement1 = ecfieldelement1.multiply(ecfieldelement2);
            return new Fp(amN, aIC, _mth02BD(ecfieldelement.add(ecfieldelement1)));
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
            return new Fp(biginteger1, biginteger2, ecfieldelement);
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
            return new Fp(biginteger1, biginteger2, ecfieldelement);
        }

        public final ECFieldElement _mth141D(ECFieldElement ecfieldelement)
        {
            return new Fp(amN, aIC, _mth02CF(amZ, ecfieldelement.toBigInteger()));
        }

        public final ECFieldElement FF26()
        {
            BigInteger biginteger1 = amZ.add(ECConstants.ONE);
            BigInteger biginteger = biginteger1;
            if (biginteger1.compareTo(amN) == 0)
            {
                biginteger = ECConstants.ZERO;
            }
            return new Fp(amN, aIC, biginteger);
        }

        public final ECFieldElement FF29()
        {
            if (amZ.signum() == 0)
            {
                return this;
            } else
            {
                return new Fp(amN, aIC, amN.subtract(amZ));
            }
        }

        public final ECFieldElement FF4C()
        {
            return new Fp(amN, aIC, _mth02CF(amZ, amZ));
        }

        public final ECFieldElement FF4E()
        {
            return new Fp(amN, aIC, modInverse(amZ));
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
                obj = new Fp(amN, aIC, amZ.modPow(((BigInteger) (obj)), amN));
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
                    obj1 = new Fp(amN, aIC, biginteger2);
                    if (((ECFieldElement) (obj1)).FF4C().equals(this))
                    {
                        return ((ECFieldElement) (obj1));
                    } else
                    {
                        return null;
                    }
                }
                obj1 = _mth02CF(biginteger2, ECConstants.ars.modPow(amN.shiftRight(2), amN));
                obj1 = new Fp(amN, aIC, ((BigInteger) (obj1)));
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
                    return new Fp(biginteger6, biginteger8, abiginteger.shiftRight(1));
                }
            } while (biginteger11.equals(ECConstants.ONE) || biginteger11.equals(biginteger10));
            return null;
        }

        public Fp(BigInteger biginteger, BigInteger biginteger1)
        {
            this(biginteger, _mth02BC(biginteger), biginteger1);
        }

        Fp(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2)
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


    public ECFieldElement()
    {
    }

    public int bitLength()
    {
        return toBigInteger().bitLength();
    }

    public abstract int getFieldSize();

    public boolean isZero()
    {
        return toBigInteger().signum() == 0;
    }

    public abstract BigInteger toBigInteger();

    public String toString()
    {
        return toBigInteger().toString(16);
    }

    public abstract ECFieldElement _mth02BB(ECFieldElement ecfieldelement);

    public ECFieldElement _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
    {
        return FF4C()._mth02CE(ecfieldelement._mth141D(ecfieldelement1));
    }

    public ECFieldElement _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement ecfieldelement2)
    {
        return _mth141D(ecfieldelement)._mth02CF(ecfieldelement1._mth141D(ecfieldelement2));
    }

    public ECFieldElement _mth02CB(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement ecfieldelement2)
    {
        return _mth141D(ecfieldelement)._mth02CE(ecfieldelement1._mth141D(ecfieldelement2));
    }

    public abstract ECFieldElement _mth02CE(ECFieldElement ecfieldelement);

    public abstract ECFieldElement _mth02CF(ECFieldElement ecfieldelement);

    public abstract ECFieldElement _mth141D(ECFieldElement ecfieldelement);

    public abstract ECFieldElement FF26();

    public abstract ECFieldElement FF29();

    public abstract ECFieldElement FF4C();

    public abstract ECFieldElement FF4E();

    public abstract ECFieldElement FF52();

    public boolean FF53()
    {
        return bitLength() == 1;
    }

    public boolean FF66()
    {
        return toBigInteger().testBit(0);
    }
}
