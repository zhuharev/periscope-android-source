// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat192;

// Referenced classes of package org.spongycastle.math.ec.custom.sec:
//            SecP192R1FieldElement, SecP192R1Field, SecP192R1Curve

public class SecP192R1Point extends org.spongycastle.math.ec.ECPoint.AbstractFp
{

    public SecP192R1Point(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
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

    SecP192R1Point(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
    {
        super(eccurve, ecfieldelement, ecfieldelement1, aecfieldelement);
        aHv = flag;
    }

    public SecP192R1Point(SecP192R1Curve secp192r1curve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
    {
        this(((ECCurve) (secp192r1curve)), ecfieldelement, ecfieldelement1, false);
    }

    public final ECPoint _mth029C()
    {
        if (_mth021D())
        {
            return this;
        } else
        {
            return new SecP192R1Point(alm, aII, aIJ.FF29(), aIK, aHv);
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
        SecP192R1FieldElement secp192r1fieldelement2 = (SecP192R1FieldElement)aIJ;
        if (secp192r1fieldelement2.isZero())
        {
            return eccurve._mth5B80();
        }
        SecP192R1FieldElement secp192r1fieldelement4 = (SecP192R1FieldElement)aII;
        SecP192R1FieldElement secp192r1fieldelement3 = (SecP192R1FieldElement)aIK[0];
        int ai2[] = Nat192._mth05E4();
        int ai1[] = Nat192._mth05E4();
        int ai3[] = Nat192._mth05E4();
        SecP192R1Field._mth02BD(secp192r1fieldelement2.asZ, ai3);
        int ai4[] = Nat192._mth05E4();
        SecP192R1Field._mth02BD(ai3, ai4);
        boolean flag = secp192r1fieldelement3.FF53();
        int ai[] = secp192r1fieldelement3.asZ;
        if (!flag)
        {
            ai = ai1;
            SecP192R1Field._mth02BD(secp192r1fieldelement3.asZ, ai);
        }
        SecP192R1Field._mth141D(secp192r1fieldelement4.asZ, ai, ai2);
        SecP192R1Field._mth02CB(secp192r1fieldelement4.asZ, ai, ai1);
        SecP192R1Field._mth02CE(ai1, ai2, ai1);
        SecP192R1Field._mth02BB(Nat192._mth037A(ai1, ai1, ai1), ai1);
        SecP192R1Field._mth02CE(ai3, secp192r1fieldelement4.asZ, ai3);
        SecP192R1Field._mth02BB(Nat._mth02CE(6, ai3, 2, 0), ai3);
        SecP192R1Field._mth02BB(Nat._mth02CA(6, ai4, 3, 0, ai2), ai2);
        SecP192R1FieldElement secp192r1fieldelement = new SecP192R1FieldElement(ai4);
        SecP192R1Field._mth02BD(ai1, secp192r1fieldelement.asZ);
        SecP192R1Field._mth141D(secp192r1fieldelement.asZ, ai3, secp192r1fieldelement.asZ);
        SecP192R1Field._mth141D(secp192r1fieldelement.asZ, ai3, secp192r1fieldelement.asZ);
        secp192r1fieldelement4 = new SecP192R1FieldElement(ai3);
        SecP192R1Field._mth141D(ai3, secp192r1fieldelement.asZ, secp192r1fieldelement4.asZ);
        SecP192R1Field._mth02CE(secp192r1fieldelement4.asZ, ai1, secp192r1fieldelement4.asZ);
        SecP192R1Field._mth141D(secp192r1fieldelement4.asZ, ai2, secp192r1fieldelement4.asZ);
        SecP192R1FieldElement secp192r1fieldelement1 = new SecP192R1FieldElement(ai1);
        SecP192R1Field._mth037A(secp192r1fieldelement2.asZ, secp192r1fieldelement1.asZ);
        if (!flag)
        {
            SecP192R1Field._mth02CE(secp192r1fieldelement1.asZ, secp192r1fieldelement3.asZ, secp192r1fieldelement1.asZ);
        }
        flag = aHv;
        return new SecP192R1Point(eccurve, secp192r1fieldelement, secp192r1fieldelement4, new ECFieldElement[] {
            secp192r1fieldelement1
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
        SecP192R1FieldElement secp192r1fieldelement6 = (SecP192R1FieldElement)aII;
        SecP192R1FieldElement secp192r1fieldelement5 = (SecP192R1FieldElement)aIJ;
        SecP192R1FieldElement secp192r1fieldelement2 = (SecP192R1FieldElement)ecpoint._mth0134();
        SecP192R1FieldElement secp192r1fieldelement1 = (SecP192R1FieldElement)ecpoint._mth0141();
        SecP192R1FieldElement secp192r1fieldelement3 = (SecP192R1FieldElement)aIK[0];
        SecP192R1FieldElement secp192r1fieldelement4 = (SecP192R1FieldElement)ecpoint._mth1425(0);
        int ai3[] = Nat192._mth05E7();
        int ai4[] = Nat192._mth05E4();
        int ai5[] = Nat192._mth05E4();
        int ai6[] = Nat192._mth05E4();
        boolean flag = secp192r1fieldelement3.FF53();
        int ai[];
        if (flag)
        {
            ecpoint = secp192r1fieldelement2.asZ;
            ai = secp192r1fieldelement1.asZ;
        } else
        {
            ai = ai5;
            SecP192R1Field._mth02BD(secp192r1fieldelement3.asZ, ai);
            ecpoint = ai4;
            SecP192R1Field._mth02CE(ai, secp192r1fieldelement2.asZ, ecpoint);
            SecP192R1Field._mth02CE(ai, secp192r1fieldelement3.asZ, ai);
            SecP192R1Field._mth02CE(ai, secp192r1fieldelement1.asZ, ai);
        }
        boolean flag1 = secp192r1fieldelement4.FF53();
        int ai1[];
        int ai2[];
        if (flag1)
        {
            ai1 = secp192r1fieldelement6.asZ;
            ai2 = secp192r1fieldelement5.asZ;
        } else
        {
            ai2 = ai6;
            SecP192R1Field._mth02BD(secp192r1fieldelement4.asZ, ai2);
            ai1 = ai3;
            SecP192R1Field._mth02CE(ai2, secp192r1fieldelement6.asZ, ai1);
            SecP192R1Field._mth02CE(ai2, secp192r1fieldelement4.asZ, ai2);
            SecP192R1Field._mth02CE(ai2, secp192r1fieldelement5.asZ, ai2);
        }
        int ai7[] = Nat192._mth05E4();
        SecP192R1Field._mth141D(ai1, ecpoint, ai7);
        SecP192R1Field._mth141D(ai2, ai, ai4);
        if (Nat192._mth02C8(ai7))
        {
            if (Nat192._mth02C8(ai4))
            {
                return _mth038E();
            } else
            {
                return eccurve._mth5B80();
            }
        }
        SecP192R1Field._mth02BD(ai7, ai5);
        ecpoint = Nat192._mth05E4();
        SecP192R1Field._mth02CE(ai5, ai7, ecpoint);
        SecP192R1Field._mth02CE(ai5, ai1, ai5);
        SecP192R1Field._mth02BB(ecpoint, ecpoint);
        Nat192._mth1FBE(ai2, ecpoint, ai3);
        SecP192R1Field._mth02BB(Nat192._mth037A(ai5, ai5, ecpoint), ecpoint);
        SecP192R1FieldElement secp192r1fieldelement = new SecP192R1FieldElement(ai6);
        SecP192R1Field._mth02BD(ai4, secp192r1fieldelement.asZ);
        SecP192R1Field._mth141D(secp192r1fieldelement.asZ, ecpoint, secp192r1fieldelement.asZ);
        ecpoint = new SecP192R1FieldElement(ecpoint);
        SecP192R1Field._mth141D(ai5, secp192r1fieldelement.asZ, ((SecP192R1FieldElement) (ecpoint)).asZ);
        SecP192R1Field._mth02CF(((SecP192R1FieldElement) (ecpoint)).asZ, ai4, ai3);
        SecP192R1Field._mth02BC(ai3, ((SecP192R1FieldElement) (ecpoint)).asZ);
        ai1 = new SecP192R1FieldElement(ai7);
        if (!flag)
        {
            SecP192R1Field._mth02CE(((SecP192R1FieldElement) (ai1)).asZ, secp192r1fieldelement3.asZ, ((SecP192R1FieldElement) (ai1)).asZ);
        }
        if (!flag1)
        {
            SecP192R1Field._mth02CE(((SecP192R1FieldElement) (ai1)).asZ, secp192r1fieldelement4.asZ, ((SecP192R1FieldElement) (ai1)).asZ);
        }
        flag = aHv;
        return new SecP192R1Point(eccurve, secp192r1fieldelement, ecpoint, new ECFieldElement[] {
            ai1
        }, flag);
    }

    protected final ECPoint FF7D()
    {
        return new SecP192R1Point(null, FF8A(), FF93());
    }
}
