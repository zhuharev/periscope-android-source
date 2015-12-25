// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.math.ec.custom.sec:
//            SecP384R1Curve, SecP384R1Field

public class SecP384R1FieldElement extends ECFieldElement
{

    private static BigInteger aJk;
    protected int asZ[];

    public SecP384R1FieldElement()
    {
        asZ = Nat._mth1D37(12);
    }

    public SecP384R1FieldElement(BigInteger biginteger)
    {
        if (biginteger == null || biginteger.signum() < 0 || biginteger.compareTo(aJk) >= 0)
        {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        } else
        {
            asZ = SecP384R1Field._mth02BE(biginteger);
            return;
        }
    }

    protected SecP384R1FieldElement(int ai[])
    {
        asZ = ai;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof SecP384R1FieldElement))
        {
            return false;
        } else
        {
            obj = (SecP384R1FieldElement)obj;
            return Nat._mth02CE(12, asZ, ((SecP384R1FieldElement) (obj)).asZ);
        }
    }

    public final int getFieldSize()
    {
        return aJk.bitLength();
    }

    public int hashCode()
    {
        return aJk.hashCode() ^ Arrays._mth02CB(asZ, 0, 12);
    }

    public final boolean isZero()
    {
        return Nat._mth02BE(12, asZ);
    }

    public final BigInteger toBigInteger()
    {
        return Nat._mth02BF(12, asZ);
    }

    public final ECFieldElement _mth02BB(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat._mth1D37(12);
        Mod._mth02BC(SecP384R1Field.aqr, ((SecP384R1FieldElement)ecfieldelement).asZ, ai);
        SecP384R1Field._mth02CE(ai, asZ, ai);
        return new SecP384R1FieldElement(ai);
    }

    public final ECFieldElement _mth02CE(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat._mth1D37(12);
        SecP384R1Field._mth02CB(asZ, ((SecP384R1FieldElement)ecfieldelement).asZ, ai);
        return new SecP384R1FieldElement(ai);
    }

    public final ECFieldElement _mth02CF(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat._mth1D37(12);
        SecP384R1Field._mth141D(asZ, ((SecP384R1FieldElement)ecfieldelement).asZ, ai);
        return new SecP384R1FieldElement(ai);
    }

    public final ECFieldElement _mth141D(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat._mth1D37(12);
        SecP384R1Field._mth02CE(asZ, ((SecP384R1FieldElement)ecfieldelement).asZ, ai);
        return new SecP384R1FieldElement(ai);
    }

    public final ECFieldElement FF26()
    {
        int ai[] = Nat._mth1D37(12);
        SecP384R1Field._mth141D(asZ, ai);
        return new SecP384R1FieldElement(ai);
    }

    public final ECFieldElement FF29()
    {
        int ai[] = Nat._mth1D37(12);
        SecP384R1Field._mth02BB(asZ, ai);
        return new SecP384R1FieldElement(ai);
    }

    public final ECFieldElement FF4C()
    {
        int ai[] = Nat._mth1D37(12);
        SecP384R1Field._mth02BD(asZ, ai);
        return new SecP384R1FieldElement(ai);
    }

    public final ECFieldElement FF4E()
    {
        int ai[] = Nat._mth1D37(12);
        Mod._mth02BC(SecP384R1Field.aqr, asZ, ai);
        return new SecP384R1FieldElement(ai);
    }

    public final ECFieldElement FF52()
    {
        int ai[] = asZ;
        if (Nat._mth02BE(12, ai) || Nat._mth1FBE(12, ai))
        {
            return this;
        }
        int ai1[] = Nat._mth1D37(12);
        int ai2[] = Nat._mth1D37(12);
        int ai3[] = Nat._mth1D37(12);
        int ai4[] = Nat._mth1D37(12);
        SecP384R1Field._mth02BD(ai, ai1);
        SecP384R1Field._mth02CE(ai1, ai, ai1);
        SecP384R1Field._mth02CA(ai1, 2, ai2);
        SecP384R1Field._mth02CE(ai2, ai1, ai2);
        SecP384R1Field._mth02BD(ai2, ai2);
        SecP384R1Field._mth02CE(ai2, ai, ai2);
        SecP384R1Field._mth02CA(ai2, 5, ai3);
        SecP384R1Field._mth02CE(ai3, ai2, ai3);
        SecP384R1Field._mth02CA(ai3, 5, ai4);
        SecP384R1Field._mth02CE(ai4, ai2, ai4);
        SecP384R1Field._mth02CA(ai4, 15, ai2);
        SecP384R1Field._mth02CE(ai2, ai4, ai2);
        SecP384R1Field._mth02CA(ai2, 2, ai3);
        SecP384R1Field._mth02CE(ai1, ai3, ai1);
        SecP384R1Field._mth02CA(ai3, 28, ai3);
        SecP384R1Field._mth02CE(ai2, ai3, ai2);
        SecP384R1Field._mth02CA(ai2, 60, ai3);
        SecP384R1Field._mth02CE(ai3, ai2, ai3);
        SecP384R1Field._mth02CA(ai3, 120, ai2);
        SecP384R1Field._mth02CE(ai2, ai3, ai2);
        SecP384R1Field._mth02CA(ai2, 15, ai2);
        SecP384R1Field._mth02CE(ai2, ai4, ai2);
        SecP384R1Field._mth02CA(ai2, 33, ai2);
        SecP384R1Field._mth02CE(ai2, ai1, ai2);
        SecP384R1Field._mth02CA(ai2, 64, ai2);
        SecP384R1Field._mth02CE(ai2, ai, ai2);
        SecP384R1Field._mth02CA(ai2, 30, ai1);
        SecP384R1Field._mth02BD(ai1, ai2);
        if (Nat._mth02CE(12, ai, ai2))
        {
            return new SecP384R1FieldElement(ai1);
        } else
        {
            return null;
        }
    }

    public final boolean FF53()
    {
        return Nat._mth1FBE(12, asZ);
    }

    public final boolean FF66()
    {
        return Nat._mth02CE(asZ, 0) == 1;
    }

    static 
    {
        aJk = SecP384R1Curve.amN;
    }
}
