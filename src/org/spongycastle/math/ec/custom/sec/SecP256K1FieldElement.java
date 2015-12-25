// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.math.ec.custom.sec:
//            SecP256K1Curve, SecP256K1Field

public class SecP256K1FieldElement extends ECFieldElement
{

    private static BigInteger aJk;
    protected int asZ[];

    public SecP256K1FieldElement()
    {
        asZ = Nat256._mth05E4();
    }

    public SecP256K1FieldElement(BigInteger biginteger)
    {
        if (biginteger == null || biginteger.signum() < 0 || biginteger.compareTo(aJk) >= 0)
        {
            throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
        } else
        {
            asZ = SecP256K1Field._mth02BE(biginteger);
            return;
        }
    }

    protected SecP256K1FieldElement(int ai[])
    {
        asZ = ai;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof SecP256K1FieldElement))
        {
            return false;
        } else
        {
            obj = (SecP256K1FieldElement)obj;
            return Nat256._mth1FBE(asZ, ((SecP256K1FieldElement) (obj)).asZ);
        }
    }

    public final int getFieldSize()
    {
        return aJk.bitLength();
    }

    public int hashCode()
    {
        return aJk.hashCode() ^ Arrays._mth02CB(asZ, 0, 8);
    }

    public final boolean isZero()
    {
        return Nat256._mth02C8(asZ);
    }

    public final BigInteger toBigInteger()
    {
        return Nat256._mth02C9(asZ);
    }

    public final ECFieldElement _mth02BB(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat256._mth05E4();
        Mod._mth02BC(SecP256K1Field.aqr, ((SecP256K1FieldElement)ecfieldelement).asZ, ai);
        SecP256K1Field._mth02CE(ai, asZ, ai);
        return new SecP256K1FieldElement(ai);
    }

    public final ECFieldElement _mth02CE(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat256._mth05E4();
        SecP256K1Field._mth02CB(asZ, ((SecP256K1FieldElement)ecfieldelement).asZ, ai);
        return new SecP256K1FieldElement(ai);
    }

    public final ECFieldElement _mth02CF(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat256._mth05E4();
        SecP256K1Field._mth141D(asZ, ((SecP256K1FieldElement)ecfieldelement).asZ, ai);
        return new SecP256K1FieldElement(ai);
    }

    public final ECFieldElement _mth141D(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat256._mth05E4();
        SecP256K1Field._mth02CE(asZ, ((SecP256K1FieldElement)ecfieldelement).asZ, ai);
        return new SecP256K1FieldElement(ai);
    }

    public final ECFieldElement FF26()
    {
        int ai[] = Nat256._mth05E4();
        SecP256K1Field._mth141D(asZ, ai);
        return new SecP256K1FieldElement(ai);
    }

    public final ECFieldElement FF29()
    {
        int ai[] = Nat256._mth05E4();
        SecP256K1Field._mth02BB(asZ, ai);
        return new SecP256K1FieldElement(ai);
    }

    public final ECFieldElement FF4C()
    {
        int ai[] = Nat256._mth05E4();
        SecP256K1Field._mth02BD(asZ, ai);
        return new SecP256K1FieldElement(ai);
    }

    public final ECFieldElement FF4E()
    {
        int ai[] = Nat256._mth05E4();
        Mod._mth02BC(SecP256K1Field.aqr, asZ, ai);
        return new SecP256K1FieldElement(ai);
    }

    public final ECFieldElement FF52()
    {
        int ai[] = asZ;
        if (Nat256._mth02C8(ai) || Nat256._mth02BF(ai))
        {
            return this;
        }
        int ai1[] = Nat256._mth05E4();
        SecP256K1Field._mth02BD(ai, ai1);
        SecP256K1Field._mth02CE(ai1, ai, ai1);
        int ai2[] = Nat256._mth05E4();
        SecP256K1Field._mth02BD(ai1, ai2);
        SecP256K1Field._mth02CE(ai2, ai, ai2);
        int ai3[] = Nat256._mth05E4();
        SecP256K1Field._mth02CA(ai2, 3, ai3);
        SecP256K1Field._mth02CE(ai3, ai2, ai3);
        SecP256K1Field._mth02CA(ai3, 3, ai3);
        SecP256K1Field._mth02CE(ai3, ai2, ai3);
        SecP256K1Field._mth02CA(ai3, 2, ai3);
        SecP256K1Field._mth02CE(ai3, ai1, ai3);
        int ai4[] = Nat256._mth05E4();
        SecP256K1Field._mth02CA(ai3, 11, ai4);
        SecP256K1Field._mth02CE(ai4, ai3, ai4);
        SecP256K1Field._mth02CA(ai4, 22, ai3);
        SecP256K1Field._mth02CE(ai3, ai4, ai3);
        int ai5[] = Nat256._mth05E4();
        SecP256K1Field._mth02CA(ai3, 44, ai5);
        SecP256K1Field._mth02CE(ai5, ai3, ai5);
        int ai6[] = Nat256._mth05E4();
        SecP256K1Field._mth02CA(ai5, 88, ai6);
        SecP256K1Field._mth02CE(ai6, ai5, ai6);
        SecP256K1Field._mth02CA(ai6, 44, ai5);
        SecP256K1Field._mth02CE(ai5, ai3, ai5);
        SecP256K1Field._mth02CA(ai5, 3, ai3);
        SecP256K1Field._mth02CE(ai3, ai2, ai3);
        SecP256K1Field._mth02CA(ai3, 23, ai3);
        SecP256K1Field._mth02CE(ai3, ai4, ai3);
        SecP256K1Field._mth02CA(ai3, 6, ai3);
        SecP256K1Field._mth02CE(ai3, ai1, ai3);
        SecP256K1Field._mth02CA(ai3, 2, ai3);
        SecP256K1Field._mth02BD(ai3, ai1);
        if (Nat256._mth1FBE(ai, ai1))
        {
            return new SecP256K1FieldElement(ai3);
        } else
        {
            return null;
        }
    }

    public final boolean FF53()
    {
        return Nat256._mth02BF(asZ);
    }

    public final boolean FF66()
    {
        return Nat256._mth02CE(asZ, 0) == 1;
    }

    static 
    {
        aJk = SecP256K1Curve.amN;
    }
}
