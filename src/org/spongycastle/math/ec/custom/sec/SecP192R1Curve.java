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
//            SecP192R1Point, SecP192R1FieldElement

public class SecP192R1Curve extends org.spongycastle.math.ec.ECCurve.AbstractFp
{

    public static final BigInteger amN = new BigInteger(1, Hex._mth1508("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));
    private SecP192R1Point aJo;

    public SecP192R1Curve()
    {
        super(amN);
        aJo = new SecP192R1Point(this, null, null);
        aIr = new SecP192R1FieldElement(new BigInteger(1, Hex._mth1508("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC")));
        aIs = new SecP192R1FieldElement(new BigInteger(1, Hex._mth1508("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1")));
        aIt = new BigInteger(1, Hex._mth1508("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831"));
        aIu = BigInteger.valueOf(1L);
        aIv = 2;
    }

    public final int getFieldSize()
    {
        return amN.bitLength();
    }

    public final ECFieldElement _mth02BB(BigInteger biginteger)
    {
        return new SecP192R1FieldElement(biginteger);
    }

    protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
    {
        return new SecP192R1Point(this, ecfieldelement, ecfieldelement1, flag);
    }

    protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
    {
        return new SecP192R1Point(this, ecfieldelement, ecfieldelement1, aecfieldelement, flag);
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
        return new SecP192R1Curve();
    }

    public final ECPoint _mth5B80()
    {
        return aJo;
    }

}
