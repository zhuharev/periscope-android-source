// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.math.ec.custom.sec:
//            SecP224R1Curve, SecP224R1Field

public class SecP224R1FieldElement extends ECFieldElement
{

    private static BigInteger aJk;
    protected int asZ[];

    public SecP224R1FieldElement()
    {
        asZ = Nat224._mth05E4();
    }

    public SecP224R1FieldElement(BigInteger biginteger)
    {
        if (biginteger == null || biginteger.signum() < 0 || biginteger.compareTo(aJk) >= 0)
        {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        } else
        {
            asZ = SecP224R1Field._mth02BE(biginteger);
            return;
        }
    }

    protected SecP224R1FieldElement(int ai[])
    {
        asZ = ai;
    }

    private static void _mth02CA(int ai[], int ai1[], int ai2[], int ai3[])
    {
        SecP224R1Field._mth02CE(ai1, ai, ai1);
        SecP224R1Field._mth037A(ai1, ai1);
        SecP224R1Field._mth02BD(ai, ai3);
        SecP224R1Field._mth02CB(ai2, ai3, ai);
        SecP224R1Field._mth02CE(ai2, ai3, ai2);
        SecP224R1Field._mth02BB(Nat._mth02CE(7, ai2, 2, 0), ai2);
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof SecP224R1FieldElement))
        {
            return false;
        } else
        {
            obj = (SecP224R1FieldElement)obj;
            return Nat224._mth1FBE(asZ, ((SecP224R1FieldElement) (obj)).asZ);
        }
    }

    public final int getFieldSize()
    {
        return aJk.bitLength();
    }

    public int hashCode()
    {
        return aJk.hashCode() ^ Arrays._mth02CB(asZ, 0, 7);
    }

    public final boolean isZero()
    {
        return Nat224._mth02C8(asZ);
    }

    public final BigInteger toBigInteger()
    {
        return Nat224._mth02C9(asZ);
    }

    public final ECFieldElement _mth02BB(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat224._mth05E4();
        Mod._mth02BC(SecP224R1Field.aqr, ((SecP224R1FieldElement)ecfieldelement).asZ, ai);
        SecP224R1Field._mth02CE(ai, asZ, ai);
        return new SecP224R1FieldElement(ai);
    }

    public final ECFieldElement _mth02CE(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat224._mth05E4();
        SecP224R1Field._mth02CB(asZ, ((SecP224R1FieldElement)ecfieldelement).asZ, ai);
        return new SecP224R1FieldElement(ai);
    }

    public final ECFieldElement _mth02CF(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat224._mth05E4();
        SecP224R1Field._mth141D(asZ, ((SecP224R1FieldElement)ecfieldelement).asZ, ai);
        return new SecP224R1FieldElement(ai);
    }

    public final ECFieldElement _mth141D(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat224._mth05E4();
        SecP224R1Field._mth02CE(asZ, ((SecP224R1FieldElement)ecfieldelement).asZ, ai);
        return new SecP224R1FieldElement(ai);
    }

    public final ECFieldElement FF26()
    {
        int ai[] = Nat224._mth05E4();
        SecP224R1Field._mth141D(asZ, ai);
        return new SecP224R1FieldElement(ai);
    }

    public final ECFieldElement FF29()
    {
        int ai[] = Nat224._mth05E4();
        SecP224R1Field._mth02BB(asZ, ai);
        return new SecP224R1FieldElement(ai);
    }

    public final ECFieldElement FF4C()
    {
        int ai[] = Nat224._mth05E4();
        SecP224R1Field._mth02BD(asZ, ai);
        return new SecP224R1FieldElement(ai);
    }

    public final ECFieldElement FF4E()
    {
        int ai[] = Nat224._mth05E4();
        Mod._mth02BC(SecP224R1Field.aqr, asZ, ai);
        return new SecP224R1FieldElement(ai);
    }

    public final ECFieldElement FF52()
    {
        int ai[] = asZ;
        if (Nat224._mth02C8(ai) || Nat224._mth02BF(ai))
        {
            return this;
        }
        int ai1[] = Nat224._mth05E4();
        SecP224R1Field._mth02BB(ai, ai1);
        int ai2[] = Mod._mth02BE(SecP224R1Field.aqr);
        int ai3[] = Nat224._mth05E4();
        int ai4[] = Nat224._mth05E4();
        int ai6[] = Nat224._mth05E4();
        Nat224._mth02C8(ai, ai4);
        for (int i = 0; i < 7; i++)
        {
            Nat224._mth02C8(ai4, ai6);
            SecP224R1Field._mth02CA(ai4, 1 << i, ai4);
            SecP224R1Field._mth02CE(ai4, ai6, ai4);
        }

        SecP224R1Field._mth02CA(ai4, 95, ai4);
        if (!Nat224._mth02BF(ai4))
        {
            return null;
        }
        do
        {
            int k;
label0:
            {
                int ai5[] = Nat224._mth05E4();
                Nat224._mth02C8(ai2, ai5);
                int ai7[] = Nat224._mth05E4();
                ai7[0] = 1;
                int ai8[] = Nat224._mth05E4();
                Nat224._mth02C8(ai1, ai8);
                int ai9[] = Nat224._mth05E4();
                int ai10[] = Nat224._mth05E4();
                for (int j = 0; j < 7; j++)
                {
                    Nat224._mth02C8(ai5, ai9);
                    Nat224._mth02C8(ai7, ai10);
                    int l = 1 << j;
                    do
                    {
                        l--;
                        if (l < 0)
                        {
                            break;
                        }
                        _mth02CA(ai5, ai7, ai8, ai3);
                    } while (true);
                    SecP224R1Field._mth02CE(ai7, ai10, ai3);
                    SecP224R1Field._mth02CE(ai3, ai1, ai3);
                    SecP224R1Field._mth02CE(ai5, ai9, ai8);
                    SecP224R1Field._mth02CB(ai8, ai3, ai8);
                    SecP224R1Field._mth02CE(ai5, ai10, ai3);
                    Nat224._mth02C8(ai8, ai5);
                    SecP224R1Field._mth02CE(ai7, ai9, ai7);
                    SecP224R1Field._mth02CB(ai7, ai3, ai7);
                    SecP224R1Field._mth02BD(ai7, ai8);
                    SecP224R1Field._mth02CE(ai8, ai1, ai8);
                }

                ai9 = Nat224._mth05E4();
                ai10 = Nat224._mth05E4();
                k = 1;
                do
                {
                    if (k >= 96)
                    {
                        break;
                    }
                    Nat224._mth02C8(ai5, ai9);
                    Nat224._mth02C8(ai7, ai10);
                    _mth02CA(ai5, ai7, ai8, ai3);
                    if (Nat224._mth02C8(ai5))
                    {
                        Mod._mth02BC(SecP224R1Field.aqr, ai10, ai3);
                        SecP224R1Field._mth02CE(ai3, ai9, ai3);
                        k = 1;
                        break label0;
                    }
                    k++;
                } while (true);
                k = 0;
            }
            if (k != 0)
            {
                break;
            }
            SecP224R1Field._mth141D(ai2, ai2);
        } while (true);
        SecP224R1Field._mth02BD(ai3, ai2);
        if (Nat224._mth1FBE(ai, ai2))
        {
            return new SecP224R1FieldElement(ai3);
        } else
        {
            return null;
        }
    }

    public final boolean FF53()
    {
        return Nat224._mth02BF(asZ);
    }

    public final boolean FF66()
    {
        return Nat224._mth02CE(asZ, 0) == 1;
    }

    static 
    {
        aJk = SecP224R1Curve.amN;
    }
}
