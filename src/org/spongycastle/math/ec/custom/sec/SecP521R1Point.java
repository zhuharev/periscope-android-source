// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat;

// Referenced classes of package org.spongycastle.math.ec.custom.sec:
//            SecP521R1FieldElement, SecP521R1Field, SecP521R1Curve

public class SecP521R1Point extends org.spongycastle.math.ec.ECPoint.AbstractFp
{

    public SecP521R1Point(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
    {
        super(eccurve, ecfieldelement, ecfieldelement1);
        boolean flag1;
        if (ecfieldelement == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        boolean flag2;
        if (ecfieldelement1 == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag1 != flag2)
        {
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        } else
        {
            aHv = flag;
            return;
        }
    }

    SecP521R1Point(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
    {
        super(eccurve, ecfieldelement, ecfieldelement1, aecfieldelement);
        aHv = flag;
    }

    public SecP521R1Point(SecP521R1Curve secp521r1curve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
    {
        this(((ECCurve) (secp521r1curve)), ecfieldelement, ecfieldelement1, false);
    }

    public final ECPoint _mth029C()
    {
        if (_mth021D())
        {
            return this;
        } else
        {
            return new SecP521R1Point(alm, aII, aIJ.FF29(), aIK, aHv);
        }
    }

    public final ECPoint _mth02BB(ECPoint ecpoint)
    {
        if (this == ecpoint)
        {
            if (_mth021D() || aIJ.isZero())
            {
                return this;
            } else
            {
                return _mth038E()._mth141D(this);
            }
        }
        if (_mth021D())
        {
            return ecpoint;
        }
        if (ecpoint._mth021D())
        {
            return _mth038E();
        }
        if (aIJ.isZero())
        {
            return ecpoint;
        } else
        {
            return _mth038E()._mth141D(ecpoint);
        }
    }

    public final ECPoint _mth038E()
    {
        if (_mth021D())
        {
            return this;
        }
        ECCurve eccurve = FF79();
        SecP521R1FieldElement secp521r1fieldelement2 = (SecP521R1FieldElement)aIJ;
        if (secp521r1fieldelement2.isZero())
        {
            return eccurve._mth5B80();
        }
        SecP521R1FieldElement secp521r1fieldelement4 = (SecP521R1FieldElement)aII;
        SecP521R1FieldElement secp521r1fieldelement3 = (SecP521R1FieldElement)aIK[0];
        int ai2[] = Nat._mth1D37(17);
        int ai1[] = Nat._mth1D37(17);
        int ai3[] = Nat._mth1D37(17);
        SecP521R1Field._mth02BD(secp521r1fieldelement2.asZ, ai3);
        int ai4[] = Nat._mth1D37(17);
        SecP521R1Field._mth02BD(ai3, ai4);
        boolean flag = secp521r1fieldelement3.FF53();
        int ai[] = secp521r1fieldelement3.asZ;
        if (!flag)
        {
            ai = ai1;
            SecP521R1Field._mth02BD(secp521r1fieldelement3.asZ, ai);
        }
        SecP521R1Field._mth141D(secp521r1fieldelement4.asZ, ai, ai2);
        SecP521R1Field._mth02CB(secp521r1fieldelement4.asZ, ai, ai1);
        SecP521R1Field._mth02CE(ai1, ai2, ai1);
        Nat._mth02CB(17, ai1, ai1, ai1);
        SecP521R1Field._mth037A(ai1);
        SecP521R1Field._mth02CE(ai3, secp521r1fieldelement4.asZ, ai3);
        Nat._mth02CE(17, ai3, 2, 0);
        SecP521R1Field._mth037A(ai3);
        Nat._mth02CA(17, ai4, 3, 0, ai2);
        SecP521R1Field._mth037A(ai2);
        SecP521R1FieldElement secp521r1fieldelement = new SecP521R1FieldElement(ai4);
        SecP521R1Field._mth02BD(ai1, secp521r1fieldelement.asZ);
        SecP521R1Field._mth141D(secp521r1fieldelement.asZ, ai3, secp521r1fieldelement.asZ);
        SecP521R1Field._mth141D(secp521r1fieldelement.asZ, ai3, secp521r1fieldelement.asZ);
        secp521r1fieldelement4 = new SecP521R1FieldElement(ai3);
        SecP521R1Field._mth141D(ai3, secp521r1fieldelement.asZ, secp521r1fieldelement4.asZ);
        SecP521R1Field._mth02CE(secp521r1fieldelement4.asZ, ai1, secp521r1fieldelement4.asZ);
        SecP521R1Field._mth141D(secp521r1fieldelement4.asZ, ai2, secp521r1fieldelement4.asZ);
        SecP521R1FieldElement secp521r1fieldelement1 = new SecP521R1FieldElement(ai1);
        SecP521R1Field._mth037A(secp521r1fieldelement2.asZ, secp521r1fieldelement1.asZ);
        if (!flag)
        {
            SecP521R1Field._mth02CE(secp521r1fieldelement1.asZ, secp521r1fieldelement3.asZ, secp521r1fieldelement1.asZ);
        }
        flag = aHv;
        return new SecP521R1Point(eccurve, secp521r1fieldelement, secp521r1fieldelement4, new ECFieldElement[] {
            secp521r1fieldelement1
        }, flag);
    }

    public final ECPoint _mth039A()
    {
        if (_mth021D() || aIJ.isZero())
        {
            return this;
        } else
        {
            return _mth038E()._mth141D(this);
        }
    }

    public final ECPoint _mth141D(ECPoint ecpoint)
    {
        if (_mth021D())
        {
            return ecpoint;
        }
        if (ecpoint._mth021D())
        {
            return this;
        }
        if (this == ecpoint)
        {
            return _mth038E();
        }
        ECCurve eccurve = FF79();
        SecP521R1FieldElement secp521r1fieldelement6 = (SecP521R1FieldElement)aII;
        SecP521R1FieldElement secp521r1fieldelement5 = (SecP521R1FieldElement)aIJ;
        SecP521R1FieldElement secp521r1fieldelement2 = (SecP521R1FieldElement)ecpoint._mth0134();
        SecP521R1FieldElement secp521r1fieldelement1 = (SecP521R1FieldElement)ecpoint._mth0141();
        SecP521R1FieldElement secp521r1fieldelement3 = (SecP521R1FieldElement)aIK[0];
        SecP521R1FieldElement secp521r1fieldelement4 = (SecP521R1FieldElement)ecpoint._mth1425(0);
        int ai3[] = Nat._mth1D37(17);
        int ai4[] = Nat._mth1D37(17);
        int ai5[] = Nat._mth1D37(17);
        int ai6[] = Nat._mth1D37(17);
        boolean flag = secp521r1fieldelement3.FF53();
        int ai[];
        if (flag)
        {
            ecpoint = secp521r1fieldelement2.asZ;
            ai = secp521r1fieldelement1.asZ;
        } else
        {
            ai = ai5;
            SecP521R1Field._mth02BD(secp521r1fieldelement3.asZ, ai);
            ecpoint = ai4;
            SecP521R1Field._mth02CE(ai, secp521r1fieldelement2.asZ, ecpoint);
            SecP521R1Field._mth02CE(ai, secp521r1fieldelement3.asZ, ai);
            SecP521R1Field._mth02CE(ai, secp521r1fieldelement1.asZ, ai);
        }
        boolean flag1 = secp521r1fieldelement4.FF53();
        int ai1[];
        int ai2[];
        if (flag1)
        {
            ai1 = secp521r1fieldelement6.asZ;
            ai2 = secp521r1fieldelement5.asZ;
        } else
        {
            ai2 = ai6;
            SecP521R1Field._mth02BD(secp521r1fieldelement4.asZ, ai2);
            ai1 = ai3;
            SecP521R1Field._mth02CE(ai2, secp521r1fieldelement6.asZ, ai1);
            SecP521R1Field._mth02CE(ai2, secp521r1fieldelement4.asZ, ai2);
            SecP521R1Field._mth02CE(ai2, secp521r1fieldelement5.asZ, ai2);
        }
        int ai7[] = Nat._mth1D37(17);
        SecP521R1Field._mth141D(ai1, ecpoint, ai7);
        SecP521R1Field._mth141D(ai2, ai, ai4);
        if (Nat._mth02BE(17, ai7))
        {
            if (Nat._mth02BE(17, ai4))
            {
                return _mth038E();
            } else
            {
                return eccurve._mth5B80();
            }
        }
        SecP521R1Field._mth02BD(ai7, ai5);
        ecpoint = Nat._mth1D37(17);
        SecP521R1Field._mth02CE(ai5, ai7, ecpoint);
        SecP521R1Field._mth02CE(ai5, ai1, ai5);
        SecP521R1Field._mth02CE(ai2, ecpoint, ai3);
        SecP521R1FieldElement secp521r1fieldelement = new SecP521R1FieldElement(ai6);
        SecP521R1Field._mth02BD(ai4, secp521r1fieldelement.asZ);
        SecP521R1Field._mth02CB(secp521r1fieldelement.asZ, ecpoint, secp521r1fieldelement.asZ);
        SecP521R1Field._mth141D(secp521r1fieldelement.asZ, ai5, secp521r1fieldelement.asZ);
        SecP521R1Field._mth141D(secp521r1fieldelement.asZ, ai5, secp521r1fieldelement.asZ);
        ecpoint = new SecP521R1FieldElement(ecpoint);
        SecP521R1Field._mth141D(ai5, secp521r1fieldelement.asZ, ((SecP521R1FieldElement) (ecpoint)).asZ);
        SecP521R1Field._mth02CE(((SecP521R1FieldElement) (ecpoint)).asZ, ai4, ai4);
        SecP521R1Field._mth141D(ai4, ai3, ((SecP521R1FieldElement) (ecpoint)).asZ);
        ai1 = new SecP521R1FieldElement(ai7);
        if (!flag)
        {
            SecP521R1Field._mth02CE(((SecP521R1FieldElement) (ai1)).asZ, secp521r1fieldelement3.asZ, ((SecP521R1FieldElement) (ai1)).asZ);
        }
        if (!flag1)
        {
            SecP521R1Field._mth02CE(((SecP521R1FieldElement) (ai1)).asZ, secp521r1fieldelement4.asZ, ((SecP521R1FieldElement) (ai1)).asZ);
        }
        flag = aHv;
        return new SecP521R1Point(eccurve, secp521r1fieldelement, ecpoint, new ECFieldElement[] {
            ai1
        }, flag);
    }

    protected final ECPoint FF7D()
    {
        return new SecP521R1Point(null, FF8A(), FF93());
    }
}
