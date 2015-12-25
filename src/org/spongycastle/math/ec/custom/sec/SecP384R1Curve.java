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
//            SecP384R1Point, SecP384R1FieldElement

public class SecP384R1Curve extends org.spongycastle.math.ec.ECCurve.AbstractFp
{

    public static final BigInteger amN = new BigInteger(1, Hex._mth1508("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));
    private SecP384R1Point aJt;

    public SecP384R1Curve()
    {
        super(amN);
        aJt = new SecP384R1Point(this, null, null);
        aIr = new SecP384R1FieldElement(new BigInteger(1, Hex._mth1508("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC")));
        aIs = new SecP384R1FieldElement(new BigInteger(1, Hex._mth1508("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF")));
        aIt = new BigInteger(1, Hex._mth1508("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973"));
        aIu = BigInteger.valueOf(1L);
        aIv = 2;
    }

    public final int getFieldSize()
    {
        return amN.bitLength();
    }

    public final ECFieldElement _mth02BB(BigInteger biginteger)
    {
        return new SecP384R1FieldElement(biginteger);
    }

    protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
    {
        return new SecP384R1Point(this, ecfieldelement, ecfieldelement1, flag);
    }

    protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
    {
        return new SecP384R1Point(this, ecfieldelement, ecfieldelement1, aecfieldelement, flag);
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
        return new SecP384R1Curve();
    }

    public final ECPoint _mth5B80()
    {
        return aJt;
    }

}
