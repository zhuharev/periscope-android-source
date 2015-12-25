// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.djb;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.math.ec.custom.djb:
//            Curve25519, Curve25519Field

public class Curve25519FieldElement extends ECFieldElement
{

    private static BigInteger aJk;
    private static final int aJl[] = {
        0x4a0ea0b0, 0xc4ee1b27, 0xad2fe478, 0x2f431806, 0x3dfbd7a7, 0x2b4d0099, 0x4fc1df0b, 0x2b832480
    };
    protected int asZ[];

    public Curve25519FieldElement()
    {
        asZ = Nat256._mth05E4();
    }

    public Curve25519FieldElement(BigInteger biginteger)
    {
        if (biginteger == null || biginteger.signum() < 0 || biginteger.compareTo(aJk) >= 0)
        {
            throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
        } else
        {
            asZ = Curve25519Field._mth02BE(biginteger);
            return;
        }
    }

    protected Curve25519FieldElement(int ai[])
    {
        asZ = ai;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof Curve25519FieldElement))
        {
            return false;
        } else
        {
            obj = (Curve25519FieldElement)obj;
            return Nat256._mth1FBE(asZ, ((Curve25519FieldElement) (obj)).asZ);
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
        Mod._mth02BC(Curve25519Field.aqr, ((Curve25519FieldElement)ecfieldelement).asZ, ai);
        Curve25519Field._mth02CE(ai, asZ, ai);
        return new Curve25519FieldElement(ai);
    }

    public final ECFieldElement _mth02CE(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat256._mth05E4();
        Curve25519Field._mth02CB(asZ, ((Curve25519FieldElement)ecfieldelement).asZ, ai);
        return new Curve25519FieldElement(ai);
    }

    public final ECFieldElement _mth02CF(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat256._mth05E4();
        Curve25519Field._mth141D(asZ, ((Curve25519FieldElement)ecfieldelement).asZ, ai);
        return new Curve25519FieldElement(ai);
    }

    public final ECFieldElement _mth141D(ECFieldElement ecfieldelement)
    {
        int ai[] = Nat256._mth05E4();
        Curve25519Field._mth02CE(asZ, ((Curve25519FieldElement)ecfieldelement).asZ, ai);
        return new Curve25519FieldElement(ai);
    }

    public final ECFieldElement FF26()
    {
        int ai[] = Nat256._mth05E4();
        Curve25519Field._mth141D(asZ, ai);
        return new Curve25519FieldElement(ai);
    }

    public final ECFieldElement FF29()
    {
        int ai[] = Nat256._mth05E4();
        Curve25519Field._mth02BB(asZ, ai);
        return new Curve25519FieldElement(ai);
    }

    public final ECFieldElement FF4C()
    {
        int ai[] = Nat256._mth05E4();
        Curve25519Field._mth02BD(asZ, ai);
        return new Curve25519FieldElement(ai);
    }

    public final ECFieldElement FF4E()
    {
        int ai[] = Nat256._mth05E4();
        Mod._mth02BC(Curve25519Field.aqr, asZ, ai);
        return new Curve25519FieldElement(ai);
    }

    public final ECFieldElement FF52()
    {
        int ai[] = asZ;
        if (Nat256._mth02C8(ai) || Nat256._mth02BF(ai))
        {
            return this;
        }
        int ai1[] = Nat256._mth05E4();
        Curve25519Field._mth02BD(ai, ai1);
        Curve25519Field._mth02CE(ai1, ai, ai1);
        Curve25519Field._mth02BD(ai1, ai1);
        Curve25519Field._mth02CE(ai1, ai, ai1);
        int ai2[] = Nat256._mth05E4();
        Curve25519Field._mth02BD(ai1, ai2);
        Curve25519Field._mth02CE(ai2, ai, ai2);
        int ai3[] = Nat256._mth05E4();
        Curve25519Field._mth02CA(ai2, 3, ai3);
        Curve25519Field._mth02CE(ai3, ai1, ai3);
        Curve25519Field._mth02CA(ai3, 4, ai1);
        Curve25519Field._mth02CE(ai1, ai2, ai1);
        Curve25519Field._mth02CA(ai1, 4, ai3);
        Curve25519Field._mth02CE(ai3, ai2, ai3);
        Curve25519Field._mth02CA(ai3, 15, ai2);
        Curve25519Field._mth02CE(ai2, ai3, ai2);
        Curve25519Field._mth02CA(ai2, 30, ai3);
        Curve25519Field._mth02CE(ai3, ai2, ai3);
        Curve25519Field._mth02CA(ai3, 60, ai2);
        Curve25519Field._mth02CE(ai2, ai3, ai2);
        Curve25519Field._mth02CA(ai2, 11, ai3);
        Curve25519Field._mth02CE(ai3, ai1, ai3);
        Curve25519Field._mth02CA(ai3, 120, ai1);
        Curve25519Field._mth02CE(ai1, ai2, ai1);
        Curve25519Field._mth02BD(ai1, ai1);
        Curve25519Field._mth02BD(ai1, ai2);
        if (Nat256._mth1FBE(ai, ai2))
        {
            return new Curve25519FieldElement(ai1);
        }
        Curve25519Field._mth02CE(ai1, aJl, ai1);
        Curve25519Field._mth02BD(ai1, ai2);
        if (Nat256._mth1FBE(ai, ai2))
        {
            return new Curve25519FieldElement(ai1);
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
        aJk = Curve25519.amN;
    }
}
