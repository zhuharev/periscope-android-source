// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.math.ec.custom.sec:
//            SecP224R1Point, SecP224R1FieldElement

public class SecP224R1Curve extends org.spongycastle.math.ec.ECCurve.AbstractFp
{

    public static final BigInteger amN = new BigInteger(1, Hex._mth1508("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));
    private SecP224R1Point aJq;

    public SecP224R1Curve()
    {
        super(amN);
        aJq = new SecP224R1Point(this, null, null);
        aIr = new SecP224R1FieldElement(new BigInteger(1, Hex._mth1508("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        aIs = new SecP224R1FieldElement(new BigInteger(1, Hex._mth1508("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        aIt = new BigInteger(1, Hex._mth1508("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        aIu = BigInteger.valueOf(1L);
        aIv = 2;
    }

    public final int getFieldSize()
    {
        return amN.bitLength();
    }

    public final ECFieldElement _mth02BB(BigInteger biginteger)
    {
        return new SecP224R1FieldElement(biginteger);
    }

    protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
    {
        return new SecP224R1Point(this, ecfieldelement, ecfieldelement1, flag);
    }

    protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
    {
        return new SecP224R1Point(this, ecfieldelement, ecfieldelement1, aecfieldelement, flag);
    }

    public final boolean _mth071D(int i)
    {
        switch (i)
        {
        case 2: // '\002'
            return true;
        }
        return false;
    }

    protected final ECCurve _mth30FE()
    {
        return new SecP224R1Curve();
    }

    public final ECPoint _mth5B80()
    {
        return aJq;
    }

}
