// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.math.ec:
//            ECFieldElement, LongArray, ECConstants

public static class aIG extends ECFieldElement
{

    private int aIE;
    private int aIF[];
    private LongArray aIG;
    private int afJ;

    public static void _mth02CB(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
    {
        if (!(ecfieldelement instanceof aIG) || !(ecfieldelement1 instanceof aIG))
        {
            throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
        }
        ecfieldelement = (aIG)ecfieldelement;
        ecfieldelement1 = (aIG)ecfieldelement1;
        if (((aIG) (ecfieldelement)).aIE != ((aIE) (ecfieldelement1)).aIE)
        {
            throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
        }
        if (((aIE) (ecfieldelement)).afJ != ((afJ) (ecfieldelement1)).afJ || !Arrays._mth1427(((afJ) (ecfieldelement)).aIF, ((aIF) (ecfieldelement1)).aIF))
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
        if (!(obj instanceof aIG))
        {
            return false;
        }
        obj = (aIG)obj;
        return afJ == ((afJ) (obj)).afJ && aIE == ((aIE) (obj)).aIE && Arrays._mth1427(aIF, ((aIF) (obj)).aIF) && aIG.equals(((aIG) (obj)).aIG);
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
        LongArray longarray1 = ((aIG)ecfieldelement).aIG;
        ecfieldelement1 = ((aIG)ecfieldelement1).aIG;
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
        return new <init>(afJ, aIF, ecfieldelement1);
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
            LongArray longarray1 = ((aIG)ecfieldelement).aIG;
            ecfieldelement = ((aIG)ecfieldelement1).aIG;
            ecfieldelement2 = ((aIG)ecfieldelement2).aIG;
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
        return new <init>(afJ, aIF, ecfieldelement);
    }

    public final ECFieldElement _mth02CE(ECFieldElement ecfieldelement)
    {
        LongArray longarray = (LongArray)aIG.clone();
        longarray._mth02CA(((aIG)ecfieldelement).aIG, 0);
        return new <init>(afJ, aIF, longarray);
    }

    public final ECFieldElement _mth02CF(ECFieldElement ecfieldelement)
    {
        return _mth02CE(ecfieldelement);
    }

    public final ECFieldElement _mth141D(ECFieldElement ecfieldelement)
    {
        return new <init>(afJ, aIF, aIG._mth02CA(((aIG)ecfieldelement).aIG, afJ, aIF));
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
        return new <init>(i, ai, longarray);
    }

    public final ECFieldElement FF29()
    {
        return this;
    }

    public final ECFieldElement FF4C()
    {
        return new <init>(afJ, aIF, aIG._mth02CE(afJ, aIF));
    }

    public final ECFieldElement FF4E()
    {
        return new <init>(afJ, aIF, aIG._mth02CF(afJ, aIF));
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
        return new <init>(afJ, aIF, longarray);
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

    public (int i, int j, int k, int l, BigInteger biginteger)
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

    private aIG(int i, int ai[], LongArray longarray)
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
