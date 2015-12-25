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
//            SecP521R1Curve, SecP521R1Field

public class SecP521R1FieldElement extends ECFieldElement
{

    private static BigInteger aJk;
    protected int asZ[];

    public SecP521R1FieldElement()
    {
        asZ = Nat._mth1D37(17);
    }

    public SecP521R1FieldElement(BigInteger biginteger)
    {
        if (biginteger == null || biginteger.signum() < 0 || biginteger.compareTo(aJk) >= 0)
        {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        } else
        {
            asZ = SecP521R1Field._mth02BE(biginteger);
            return;
        }
    }

    protected SecP521R1FieldElement(int ai[])
    {
        asZ = ai;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof SecP521R1FieldElement))
        {
            return false;
        } else
        {
            obj = (SecP521R1FieldElement)obj;
            return Nat._mth02CE(17, asZ, ((SecP521R1FieldElement) (obj)).asZ);
        }
    }

    public final int getFieldSize()
    {
        return aJk.bitLength();
    }

    public int hashCode()
    {
        return aJk.hashCode() ^ Arrays._mth02CB(asZ, 0, 17);
    }

    public final boolean isZero()
    {
        return Nat._mth02BE(17, asZ);
    }

    public final BigInteger toBigInteger()
    {
        return Nat._mth02BF(17, asZ);
    }

    public final ECFieldElement _mth02BB(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat._mth1D37(17);
        Mod._mth02BC(SecP521R1Field.aqr, ((SecP521R1FieldElement)ecfieldelement).asZ, ai);
        SecP521R1Field._mth02CE(ai, asZ, ai);
        return new SecP521R1FieldElement(ai);
    }

    public final ECFieldElement _mth02CE(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat._mth1D37(17);
        SecP521R1Field._mth02CB(asZ, ((SecP521R1FieldElement)ecfieldelement).asZ, ai);
        return new SecP521R1FieldElement(ai);
    }

    public final ECFieldElement _mth02CF(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat._mth1D37(17);
        SecP521R1Field._mth141D(asZ, ((SecP521R1FieldElement)ecfieldelement).asZ, ai);
        return new SecP521R1FieldElement(ai);
    }

    public final ECFieldElement _mth141D(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat._mth1D37(17);
        SecP521R1Field._mth02CE(asZ, ((SecP521R1FieldElement)ecfieldelement).asZ, ai);
        return new SecP521R1FieldElement(ai);
    }

    public final ECFieldElement FF26()
    {
        int ai[] = Nat._mth1D37(17);
        SecP521R1Field._mth141D(asZ, ai);
        return new SecP521R1FieldElement(ai);
    }

    public final ECFieldElement FF29()
    {
        int ai[] = Nat._mth1D37(17);
        SecP521R1Field._mth02BB(asZ, ai);
        return new SecP521R1FieldElement(ai);
    }

    public final ECFieldElement FF4C()
    {
        int ai[] = Nat._mth1D37(17);
        SecP521R1Field._mth02BD(asZ, ai);
        return new SecP521R1FieldElement(ai);
    }

    public final ECFieldElement FF4E()
    {
        int ai[] = Nat._mth1D37(17);
        Mod._mth02BC(SecP521R1Field.aqr, asZ, ai);
        return new SecP521R1FieldElement(ai);
    }

    public final ECFieldElement FF52()
    {
        int ai[] = asZ;
        if (Nat._mth02BE(17, ai) || Nat._mth1FBE(17, ai))
        {
            return this;
        }
        int ai1[] = Nat._mth1D37(17);
        int ai2[] = Nat._mth1D37(17);
        SecP521R1Field._mth02CA(ai, 519, ai1);
        SecP521R1Field._mth02BD(ai1, ai2);
        if (Nat._mth02CE(17, ai, ai2))
        {
            return new SecP521R1FieldElement(ai1);
        } else
        {
            return null;
        }
    }

    public final boolean FF53()
    {
        return Nat._mth1FBE(17, asZ);
    }

    public final boolean FF66()
    {
        return Nat._mth02CE(asZ, 0) == 1;
    }

    static 
    {
        aJk = SecP521R1Curve.amN;
    }
}
