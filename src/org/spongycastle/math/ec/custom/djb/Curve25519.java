// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.djb;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.math.ec.custom.djb:
//            Curve25519Field, Curve25519Point, Curve25519FieldElement

public class Curve25519 extends org.spongycastle.math.ec.ECCurve.AbstractFp
{

    public static final BigInteger amN;
    private Curve25519Point aJi;

    public Curve25519()
    {
        super(amN);
        aJi = new Curve25519Point(this, null, null);
        aIr = new Curve25519FieldElement(new BigInteger(1, Hex._mth1508("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144")));
        aIs = new Curve25519FieldElement(new BigInteger(1, Hex._mth1508("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864")));
        aIt = new BigInteger(1, Hex._mth1508("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
        aIu = BigInteger.valueOf(8L);
        aIv = 4;
    }

    public final int getFieldSize()
    {
        return amN.bitLength();
    }

    public final ECFieldElement _mth02BB(BigInteger biginteger)
    {
        return new Curve25519FieldElement(biginteger);
    }

    protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
    {
        return new Curve25519Point(this, ecfieldelement, ecfieldelement1, flag);
    }

    protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
    {
        return new Curve25519Point(this, ecfieldelement, ecfieldelement1, aecfieldelement, flag);
    }

    public final boolean _mth071D(int i)
    {
        switch (i)
        {
        case 4: // '\004'
            return true;
        }
        return false;
    }

    protected final ECCurve _mth30FE()
    {
        return new Curve25519();
    }

    public final ECPoint _mth5B80()
    {
        return aJi;
    }

    static 
    {
        amN = Nat256._mth02C9(Curve25519Field.aqr);
    }
}
