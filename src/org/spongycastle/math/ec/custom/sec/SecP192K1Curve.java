// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.math.ec.custom.sec:
//            SecP192K1Point, SecP192K1FieldElement

public class SecP192K1Curve extends org.spongycastle.math.ec.ECCurve.AbstractFp
{

    public static final BigInteger amN = new BigInteger(1, Hex._mth1508("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));
    private SecP192K1Point aJm;

    public SecP192K1Curve()
    {
        super(amN);
        aJm = new SecP192K1Point(this, null, null);
        aIr = new SecP192K1FieldElement(ECConstants.ZERO);
        aIs = new SecP192K1FieldElement(BigInteger.valueOf(3L));
        aIt = new BigInteger(1, Hex._mth1508("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D"));
        aIu = BigInteger.valueOf(1L);
        aIv = 2;
    }

    public final int getFieldSize()
    {
        return amN.bitLength();
    }

    public final ECFieldElement _mth02BB(BigInteger biginteger)
    {
        return new SecP192K1FieldElement(biginteger);
    }

    protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
    {
        return new SecP192K1Point(this, ecfieldelement, ecfieldelement1, flag);
    }

    protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
    {
        return new SecP192K1Point(this, ecfieldelement, ecfieldelement1, aecfieldelement, flag);
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
        return new SecP192K1Curve();
    }

    public final ECPoint _mth5B80()
    {
        return aJm;
    }

}
