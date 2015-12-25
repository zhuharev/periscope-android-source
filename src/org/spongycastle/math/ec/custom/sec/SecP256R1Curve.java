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
//            SecP256R1Point, SecP256R1FieldElement

public class SecP256R1Curve extends org.spongycastle.math.ec.ECCurve.AbstractFp
{

    public static final BigInteger amN = new BigInteger(1, Hex._mth1508("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));
    private SecP256R1Point aJs;

    public SecP256R1Curve()
    {
        super(amN);
        aJs = new SecP256R1Point(this, null, null);
        aIr = new SecP256R1FieldElement(new BigInteger(1, Hex._mth1508("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC")));
        aIs = new SecP256R1FieldElement(new BigInteger(1, Hex._mth1508("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B")));
        aIt = new BigInteger(1, Hex._mth1508("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551"));
        aIu = BigInteger.valueOf(1L);
        aIv = 2;
    }

    public final int getFieldSize()
    {
        return amN.bitLength();
    }

    public final ECFieldElement _mth02BB(BigInteger biginteger)
    {
        return new SecP256R1FieldElement(biginteger);
    }

    protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
    {
        return new SecP256R1Point(this, ecfieldelement, ecfieldelement1, flag);
    }

    protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
    {
        return new SecP256R1Point(this, ecfieldelement, ecfieldelement1, aecfieldelement, flag);
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
        return new SecP256R1Curve();
    }

    public final ECPoint _mth5B80()
    {
        return aJs;
    }

}
