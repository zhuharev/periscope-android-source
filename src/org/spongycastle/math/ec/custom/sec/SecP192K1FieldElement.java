// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat192;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.math.ec.custom.sec:
//            SecP192K1Curve, SecP192K1Field

public class SecP192K1FieldElement extends ECFieldElement
{

    private static BigInteger aJk;
    protected int asZ[];

    public SecP192K1FieldElement()
    {
        asZ = Nat192._mth05E4();
    }

    public SecP192K1FieldElement(BigInteger biginteger)
    {
        if (biginteger == null || biginteger.signum() < 0 || biginteger.compareTo(aJk) >= 0)
        {
            throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
        } else
        {
            asZ = SecP192K1Field._mth02BE(biginteger);
            return;
        }
    }

    protected SecP192K1FieldElement(int ai[])
    {
        asZ = ai;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof SecP192K1FieldElement))
        {
            return false;
        } else
        {
            obj = (SecP192K1FieldElement)obj;
            return Nat192._mth1FBE(asZ, ((SecP192K1FieldElement) (obj)).asZ);
        }
    }

    public final int getFieldSize()
    {
        return aJk.bitLength();
    }

    public int hashCode()
    {
        return aJk.hashCode() ^ Arrays._mth02CB(asZ, 0, 6);
    }

    public final boolean isZero()
    {
        return Nat192._mth02C8(asZ);
    }

    public final BigInteger toBigInteger()
    {
        return Nat192._mth02C9(asZ);
    }

    public final ECFieldElement _mth02BB(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat192._mth05E4();
        Mod._mth02BC(SecP192K1Field.aqr, ((SecP192K1FieldElement)ecfieldelement).asZ, ai);
        SecP192K1Field._mth02CE(ai, asZ, ai);
        return new SecP192K1FieldElement(ai);
    }

    public final ECFieldElement _mth02CE(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat192._mth05E4();
        SecP192K1Field._mth02CB(asZ, ((SecP192K1FieldElement)ecfieldelement).asZ, ai);
        return new SecP192K1FieldElement(ai);
    }

    public final ECFieldElement _mth02CF(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat192._mth05E4();
        SecP192K1Field._mth141D(asZ, ((SecP192K1FieldElement)ecfieldelement).asZ, ai);
        return new SecP192K1FieldElement(ai);
    }

    public final ECFieldElement _mth141D(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat192._mth05E4();
        SecP192K1Field._mth02CE(asZ, ((SecP192K1FieldElement)ecfieldelement).asZ, ai);
        return new SecP192K1FieldElement(ai);
    }

    public final ECFieldElement FF26()
    {
        int ai[] = Nat192._mth05E4();
        SecP192K1Field._mth141D(asZ, ai);
        return new SecP192K1FieldElement(ai);
    }

    public final ECFieldElement FF29()
    {
        int ai[] = Nat192._mth05E4();
        SecP192K1Field._mth02BB(asZ, ai);
        return new SecP192K1FieldElement(ai);
    }

    public final ECFieldElement FF4C()
    {
        int ai[] = Nat192._mth05E4();
        SecP192K1Field._mth02BD(asZ, ai);
        return new SecP192K1FieldElement(ai);
    }

    public final ECFieldElement FF4E()
    {
        int ai[] = Nat192._mth05E4();
        Mod._mth02BC(SecP192K1Field.aqr, asZ, ai);
        return new SecP192K1FieldElement(ai);
    }

    public final ECFieldElement FF52()
    {
        int ai[] = asZ;
        if (Nat192._mth02C8(ai) || Nat192._mth02BF(ai))
        {
            return this;
        }
        int ai1[] = Nat192._mth05E4();
        SecP192K1Field._mth02BD(ai, ai1);
        SecP192K1Field._mth02CE(ai1, ai, ai1);
        int ai2[] = Nat192._mth05E4();
        SecP192K1Field._mth02BD(ai1, ai2);
        SecP192K1Field._mth02CE(ai2, ai, ai2);
        int ai3[] = Nat192._mth05E4();
        SecP192K1Field._mth02CA(ai2, 3, ai3);
        SecP192K1Field._mth02CE(ai3, ai2, ai3);
        SecP192K1Field._mth02CA(ai3, 2, ai3);
        SecP192K1Field._mth02CE(ai3, ai1, ai3);
        SecP192K1Field._mth02CA(ai3, 8, ai1);
        SecP192K1Field._mth02CE(ai1, ai3, ai1);
        SecP192K1Field._mth02CA(ai1, 3, ai3);
        SecP192K1Field._mth02CE(ai3, ai2, ai3);
        int ai4[] = Nat192._mth05E4();
        SecP192K1Field._mth02CA(ai3, 16, ai4);
        SecP192K1Field._mth02CE(ai4, ai1, ai4);
        SecP192K1Field._mth02CA(ai4, 35, ai1);
        SecP192K1Field._mth02CE(ai1, ai4, ai1);
        SecP192K1Field._mth02CA(ai1, 70, ai4);
        SecP192K1Field._mth02CE(ai4, ai1, ai4);
        SecP192K1Field._mth02CA(ai4, 19, ai1);
        SecP192K1Field._mth02CE(ai1, ai3, ai1);
        SecP192K1Field._mth02CA(ai1, 20, ai1);
        SecP192K1Field._mth02CE(ai1, ai3, ai1);
        SecP192K1Field._mth02CA(ai1, 4, ai1);
        SecP192K1Field._mth02CE(ai1, ai2, ai1);
        SecP192K1Field._mth02CA(ai1, 6, ai1);
        SecP192K1Field._mth02CE(ai1, ai2, ai1);
        SecP192K1Field._mth02BD(ai1, ai1);
        SecP192K1Field._mth02BD(ai1, ai2);
        if (Nat192._mth1FBE(ai, ai2))
        {
            return new SecP192K1FieldElement(ai1);
        } else
        {
            return null;
        }
    }

    public final boolean FF53()
    {
        return Nat192._mth02BF(asZ);
    }

    public final boolean FF66()
    {
        return Nat192._mth02CE(asZ, 0) == 1;
    }

    static 
    {
        aJk = SecP192K1Curve.amN;
    }
}
