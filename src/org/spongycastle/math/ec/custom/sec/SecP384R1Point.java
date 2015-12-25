// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat384;

// Referenced classes of package org.spongycastle.math.ec.custom.sec:
//            SecP384R1FieldElement, SecP384R1Field, SecP384R1Curve

public class SecP384R1Point extends org.spongycastle.math.ec.ECPoint.AbstractFp
{

    public SecP384R1Point(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
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

    SecP384R1Point(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
    {
        super(eccurve, ecfieldelement, ecfieldelement1, aecfieldelement);
        aHv = flag;
    }

    public SecP384R1Point(SecP384R1Curve secp384r1curve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
    {
        this(((ECCurve) (secp384r1curve)), ecfieldelement, ecfieldelement1, false);
    }

    public final ECPoint _mth029C()
    {
        if (_mth021D())
        {
            return this;
        } else
        {
            return new SecP384R1Point(alm, aII, aIJ.FF29(), aIK, aHv);
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
        SecP384R1FieldElement secp384r1fieldelement2 = (SecP384R1FieldElement)aIJ;
        if (secp384r1fieldelement2.isZero())
        {
            return eccurve._mth5B80();
        }
        SecP384R1FieldElement secp384r1fieldelement4 = (SecP384R1FieldElement)aII;
        SecP384R1FieldElement secp384r1fieldelement3 = (SecP384R1FieldElement)aIK[0];
        int ai2[] = Nat._mth1D37(12);
        int ai1[] = Nat._mth1D37(12);
        int ai3[] = Nat._mth1D37(12);
        SecP384R1Field._mth02BD(secp384r1fieldelement2.asZ, ai3);
        int ai4[] = Nat._mth1D37(12);
        SecP384R1Field._mth02BD(ai3, ai4);
        boolean flag = secp384r1fieldelement3.FF53();
        int ai[] = secp384r1fieldelement3.asZ;
        if (!flag)
        {
            ai = ai1;
            SecP384R1Field._mth02BD(secp384r1fieldelement3.asZ, ai);
        }
        SecP384R1Field._mth141D(secp384r1fieldelement4.asZ, ai, ai2);
        SecP384R1Field._mth02CB(secp384r1fieldelement4.asZ, ai, ai1);
        SecP384R1Field._mth02CE(ai1, ai2, ai1);
        SecP384R1Field._mth02BB(Nat._mth02CB(12, ai1, ai1, ai1), ai1);
        SecP384R1Field._mth02CE(ai3, secp384r1fieldelement4.asZ, ai3);
        SecP384R1Field._mth02BB(Nat._mth02CE(12, ai3, 2, 0), ai3);
        SecP384R1Field._mth02BB(Nat._mth02CA(12, ai4, 3, 0, ai2), ai2);
        SecP384R1FieldElement secp384r1fieldelement = new SecP384R1FieldElement(ai4);
        SecP384R1Field._mth02BD(ai1, secp384r1fieldelement.asZ);
        SecP384R1Field._mth141D(secp384r1fieldelement.asZ, ai3, secp384r1fieldelement.asZ);
        SecP384R1Field._mth141D(secp384r1fieldelement.asZ, ai3, secp384r1fieldelement.asZ);
        secp384r1fieldelement4 = new SecP384R1FieldElement(ai3);
        SecP384R1Field._mth141D(ai3, secp384r1fieldelement.asZ, secp384r1fieldelement4.asZ);
        SecP384R1Field._mth02CE(secp384r1fieldelement4.asZ, ai1, secp384r1fieldelement4.asZ);
        SecP384R1Field._mth141D(secp384r1fieldelement4.asZ, ai2, secp384r1fieldelement4.asZ);
        SecP384R1FieldElement secp384r1fieldelement1 = new SecP384R1FieldElement(ai1);
        SecP384R1Field._mth037A(secp384r1fieldelement2.asZ, secp384r1fieldelement1.asZ);
        if (!flag)
        {
            SecP384R1Field._mth02CE(secp384r1fieldelement1.asZ, secp384r1fieldelement3.asZ, secp384r1fieldelement1.asZ);
        }
        flag = aHv;
        return new SecP384R1Point(eccurve, secp384r1fieldelement, secp384r1fieldelement4, new ECFieldElement[] {
            secp384r1fieldelement1
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
        SecP384R1FieldElement secp384r1fieldelement6 = (SecP384R1FieldElement)aII;
        SecP384R1FieldElement secp384r1fieldelement5 = (SecP384R1FieldElement)aIJ;
        SecP384R1FieldElement secp384r1fieldelement2 = (SecP384R1FieldElement)ecpoint._mth0134();
        SecP384R1FieldElement secp384r1fieldelement1 = (SecP384R1FieldElement)ecpoint._mth0141();
        SecP384R1FieldElement secp384r1fieldelement3 = (SecP384R1FieldElement)aIK[0];
        SecP384R1FieldElement secp384r1fieldelement4 = (SecP384R1FieldElement)ecpoint._mth1425(0);
        int ai3[] = Nat._mth1D37(24);
        int ai4[] = Nat._mth1D37(24);
        int ai5[] = Nat._mth1D37(12);
        int ai6[] = Nat._mth1D37(12);
        boolean flag = secp384r1fieldelement3.FF53();
        int ai[];
        if (flag)
        {
            ai = secp384r1fieldelement2.asZ;
            ecpoint = secp384r1fieldelement1.asZ;
        } else
        {
            ecpoint = ai5;
            SecP384R1Field._mth02BD(secp384r1fieldelement3.asZ, ecpoint);
            ai = ai4;
            SecP384R1Field._mth02CE(ecpoint, secp384r1fieldelement2.asZ, ai);
            SecP384R1Field._mth02CE(ecpoint, secp384r1fieldelement3.asZ, ecpoint);
            SecP384R1Field._mth02CE(ecpoint, secp384r1fieldelement1.asZ, ecpoint);
        }
        boolean flag1 = secp384r1fieldelement4.FF53();
        int ai1[];
        int ai2[];
        if (flag1)
        {
            ai1 = secp384r1fieldelement6.asZ;
            ai2 = secp384r1fieldelement5.asZ;
        } else
        {
            ai2 = ai6;
            SecP384R1Field._mth02BD(secp384r1fieldelement4.asZ, ai2);
            ai1 = ai3;
            SecP384R1Field._mth02CE(ai2, secp384r1fieldelement6.asZ, ai1);
            SecP384R1Field._mth02CE(ai2, secp384r1fieldelement4.asZ, ai2);
            SecP384R1Field._mth02CE(ai2, secp384r1fieldelement5.asZ, ai2);
        }
        int ai7[] = Nat._mth1D37(12);
        SecP384R1Field._mth141D(ai1, ai, ai7);
        ai = Nat._mth1D37(12);
        SecP384R1Field._mth141D(ai2, ecpoint, ai);
        if (Nat._mth02BE(12, ai7))
        {
            if (Nat._mth02BE(12, ai))
            {
                return _mth038E();
            } else
            {
                return eccurve._mth5B80();
            }
        }
        SecP384R1Field._mth02BD(ai7, ai5);
        ecpoint = Nat._mth1D37(12);
        SecP384R1Field._mth02CE(ai5, ai7, ecpoint);
        SecP384R1Field._mth02CE(ai5, ai1, ai5);
        SecP384R1Field._mth02BB(ecpoint, ecpoint);
        Nat384._mth1FBE(ai2, ecpoint, ai3);
        SecP384R1Field._mth02BB(Nat._mth02CB(12, ai5, ai5, ecpoint), ecpoint);
        ai1 = new SecP384R1FieldElement(ai6);
        SecP384R1Field._mth02BD(ai, ((SecP384R1FieldElement) (ai1)).asZ);
        SecP384R1Field._mth141D(((SecP384R1FieldElement) (ai1)).asZ, ecpoint, ((SecP384R1FieldElement) (ai1)).asZ);
        ecpoint = new SecP384R1FieldElement(ecpoint);
        SecP384R1Field._mth141D(ai5, ((SecP384R1FieldElement) (ai1)).asZ, ((SecP384R1FieldElement) (ecpoint)).asZ);
        Nat384._mth1FBE(((SecP384R1FieldElement) (ecpoint)).asZ, ai, ai4);
        SecP384R1Field._mth02BB(ai3, ai4, ai3);
        SecP384R1Field._mth02BC(ai3, ((SecP384R1FieldElement) (ecpoint)).asZ);
        SecP384R1FieldElement secp384r1fieldelement = new SecP384R1FieldElement(ai7);
        if (!flag)
        {
            SecP384R1Field._mth02CE(secp384r1fieldelement.asZ, secp384r1fieldelement3.asZ, secp384r1fieldelement.asZ);
        }
        if (!flag1)
        {
            SecP384R1Field._mth02CE(secp384r1fieldelement.asZ, secp384r1fieldelement4.asZ, secp384r1fieldelement.asZ);
        }
        flag = aHv;
        return new SecP384R1Point(eccurve, ai1, ecpoint, new ECFieldElement[] {
            secp384r1fieldelement
        }, flag);
    }

    protected final ECPoint FF7D()
    {
        return new SecP384R1Point(null, FF8A(), FF93());
    }
}
