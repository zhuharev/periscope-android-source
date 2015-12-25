// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat224;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.math.ec.custom.sec:
//            SecP224K1Curve, SecP224K1Field

public class SecP224K1FieldElement extends ECFieldElement
{

    private static BigInteger aJk;
    private static final int aJl[] = {
        0x33bfd202, 0xdcfad133, 0x2287624a, 0xc3811ba8, 0xa85558fc, 0x1eaef5d7, 0x8edf154c
    };
    protected int asZ[];

    public SecP224K1FieldElement()
    {
        asZ = Nat224._mth05E4();
    }

    public SecP224K1FieldElement(BigInteger biginteger)
    {
        if (biginteger == null || biginteger.signum() < 0 || biginteger.compareTo(aJk) >= 0)
        {
            throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
        } else
        {
            asZ = SecP224K1Field._mth02BE(biginteger);
            return;
        }
    }

    protected SecP224K1FieldElement(int ai[])
    {
        asZ = ai;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof SecP224K1FieldElement))
        {
            return false;
        } else
        {
            obj = (SecP224K1FieldElement)obj;
            return Nat224._mth1FBE(asZ, ((SecP224K1FieldElement) (obj)).asZ);
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
        Mod._mth02BC(SecP224K1Field.aqr, ((SecP224K1FieldElement)ecfieldelement).asZ, ai);
        SecP224K1Field._mth02CE(ai, asZ, ai);
        return new SecP224K1FieldElement(ai);
    }

    public final ECFieldElement _mth02CE(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat224._mth05E4();
        SecP224K1Field._mth02CB(asZ, ((SecP224K1FieldElement)ecfieldelement).asZ, ai);
        return new SecP224K1FieldElement(ai);
    }

    public final ECFieldElement _mth02CF(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat224._mth05E4();
        SecP224K1Field._mth141D(asZ, ((SecP224K1FieldElement)ecfieldelement).asZ, ai);
        return new SecP224K1FieldElement(ai);
    }

    public final ECFieldElement _mth141D(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat224._mth05E4();
        SecP224K1Field._mth02CE(asZ, ((SecP224K1FieldElement)ecfieldelement).asZ, ai);
        return new SecP224K1FieldElement(ai);
    }

    public final ECFieldElement FF26()
    {
        int ai[] = Nat224._mth05E4();
        SecP224K1Field._mth141D(asZ, ai);
        return new SecP224K1FieldElement(ai);
    }

    public final ECFieldElement FF29()
    {
        int ai[] = Nat224._mth05E4();
        SecP224K1Field._mth02BB(asZ, ai);
        return new SecP224K1FieldElement(ai);
    }

    public final ECFieldElement FF4C()
    {
        int ai[] = Nat224._mth05E4();
        SecP224K1Field._mth02BD(asZ, ai);
        return new SecP224K1FieldElement(ai);
    }

    public final ECFieldElement FF4E()
    {
        int ai[] = Nat224._mth05E4();
        Mod._mth02BC(SecP224K1Field.aqr, asZ, ai);
        return new SecP224K1FieldElement(ai);
    }

    public final ECFieldElement FF52()
    {
        int ai[] = asZ;
        if (Nat224._mth02C8(ai) || Nat224._mth02BF(ai))
        {
            return this;
        }
        int ai1[] = Nat224._mth05E4();
        SecP224K1Field._mth02BD(ai, ai1);
        SecP224K1Field._mth02CE(ai1, ai, ai1);
        SecP224K1Field._mth02BD(ai1, ai1);
        SecP224K1Field._mth02CE(ai1, ai, ai1);
        int ai2[] = Nat224._mth05E4();
        SecP224K1Field._mth02BD(ai1, ai2);
        SecP224K1Field._mth02CE(ai2, ai, ai2);
        int ai3[] = Nat224._mth05E4();
        SecP224K1Field._mth02CA(ai2, 4, ai3);
        SecP224K1Field._mth02CE(ai3, ai2, ai3);
        int ai4[] = Nat224._mth05E4();
        SecP224K1Field._mth02CA(ai3, 3, ai4);
        SecP224K1Field._mth02CE(ai4, ai1, ai4);
        SecP224K1Field._mth02CA(ai4, 8, ai4);
        SecP224K1Field._mth02CE(ai4, ai3, ai4);
        SecP224K1Field._mth02CA(ai4, 4, ai3);
        SecP224K1Field._mth02CE(ai3, ai2, ai3);
        SecP224K1Field._mth02CA(ai3, 19, ai2);
        SecP224K1Field._mth02CE(ai2, ai4, ai2);
        int ai5[] = Nat224._mth05E4();
        SecP224K1Field._mth02CA(ai2, 42, ai5);
        SecP224K1Field._mth02CE(ai5, ai2, ai5);
        SecP224K1Field._mth02CA(ai5, 23, ai2);
        SecP224K1Field._mth02CE(ai2, ai3, ai2);
        SecP224K1Field._mth02CA(ai2, 84, ai3);
        SecP224K1Field._mth02CE(ai3, ai5, ai3);
        SecP224K1Field._mth02CA(ai3, 20, ai3);
        SecP224K1Field._mth02CE(ai3, ai4, ai3);
        SecP224K1Field._mth02CA(ai3, 3, ai3);
        SecP224K1Field._mth02CE(ai3, ai, ai3);
        SecP224K1Field._mth02CA(ai3, 2, ai3);
        SecP224K1Field._mth02CE(ai3, ai, ai3);
        SecP224K1Field._mth02CA(ai3, 4, ai3);
        SecP224K1Field._mth02CE(ai3, ai1, ai3);
        SecP224K1Field._mth02BD(ai3, ai3);
        SecP224K1Field._mth02BD(ai3, ai5);
        if (Nat224._mth1FBE(ai, ai5))
        {
            return new SecP224K1FieldElement(ai3);
        }
        SecP224K1Field._mth02CE(ai3, aJl, ai3);
        SecP224K1Field._mth02BD(ai3, ai5);
        if (Nat224._mth1FBE(ai, ai5))
        {
            return new SecP224K1FieldElement(ai3);
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
        aJk = SecP224K1Curve.amN;
    }
}
