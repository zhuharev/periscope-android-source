// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.djb;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat256;

// Referenced classes of package org.spongycastle.math.ec.custom.djb:
//            Curve25519FieldElement, Curve25519Field, Curve25519

public class Curve25519Point extends org.spongycastle.math.ec.ECPoint.AbstractFp
{

    public Curve25519Point(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
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

    Curve25519Point(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
    {
        super(eccurve, ecfieldelement, ecfieldelement1, aecfieldelement);
        aHv = flag;
    }

    public Curve25519Point(Curve25519 curve25519, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
    {
        this(((ECCurve) (curve25519)), ecfieldelement, ecfieldelement1, false);
    }

    private Curve25519FieldElement _mth02CA(Curve25519FieldElement curve25519fieldelement, int ai[])
    {
        Curve25519FieldElement curve25519fieldelement1 = (Curve25519FieldElement)FF79().FB46();
        if (curve25519fieldelement.FF53())
        {
            return curve25519fieldelement1;
        }
        Curve25519FieldElement curve25519fieldelement2 = new Curve25519FieldElement();
        int ai1[] = ai;
        if (ai == null)
        {
            ai1 = curve25519fieldelement2.asZ;
            Curve25519Field._mth02BD(curve25519fieldelement.asZ, ai1);
        }
        Curve25519Field._mth02BD(ai1, curve25519fieldelement2.asZ);
        Curve25519Field._mth02CE(curve25519fieldelement2.asZ, curve25519fieldelement1.asZ, curve25519fieldelement2.asZ);
        return curve25519fieldelement2;
    }

    private Curve25519FieldElement _mth0423()
    {
        Curve25519FieldElement curve25519fieldelement1 = (Curve25519FieldElement)aIK[1];
        Curve25519FieldElement curve25519fieldelement = curve25519fieldelement1;
        if (curve25519fieldelement1 == null)
        {
            ECFieldElement aecfieldelement[] = aIK;
            curve25519fieldelement = _mth02CA((Curve25519FieldElement)aIK[0], null);
            aecfieldelement[1] = curve25519fieldelement;
        }
        return curve25519fieldelement;
    }

    private Curve25519Point _mth1D53(boolean flag)
    {
        Curve25519FieldElement curve25519fieldelement2 = (Curve25519FieldElement)aII;
        Curve25519FieldElement curve25519fieldelement3 = (Curve25519FieldElement)aIJ;
        Curve25519FieldElement curve25519fieldelement = (Curve25519FieldElement)aIK[0];
        Object obj = _mth0423();
        int ai2[] = Nat256._mth05E4();
        Curve25519Field._mth02BD(curve25519fieldelement2.asZ, ai2);
        Curve25519Field._mth141D(Nat256._mth037A(ai2, ai2, ai2) + Nat256._mth02C9(((Curve25519FieldElement) (obj)).asZ, ai2), ai2);
        int ai3[] = Nat256._mth05E4();
        Curve25519Field._mth037A(curve25519fieldelement3.asZ, ai3);
        int ai[] = Nat256._mth05E4();
        Curve25519Field._mth02CE(ai3, curve25519fieldelement3.asZ, ai);
        int ai4[] = Nat256._mth05E4();
        Curve25519Field._mth02CE(ai, curve25519fieldelement2.asZ, ai4);
        Curve25519Field._mth037A(ai4, ai4);
        int ai1[] = Nat256._mth05E4();
        Curve25519Field._mth02BD(ai, ai1);
        Curve25519Field._mth037A(ai1, ai1);
        Curve25519FieldElement curve25519fieldelement1 = new Curve25519FieldElement(ai);
        Curve25519Field._mth02BD(ai2, curve25519fieldelement1.asZ);
        Curve25519Field._mth141D(curve25519fieldelement1.asZ, ai4, curve25519fieldelement1.asZ);
        Curve25519Field._mth141D(curve25519fieldelement1.asZ, ai4, curve25519fieldelement1.asZ);
        curve25519fieldelement2 = new Curve25519FieldElement(ai4);
        Curve25519Field._mth141D(ai4, curve25519fieldelement1.asZ, curve25519fieldelement2.asZ);
        Curve25519Field._mth02CE(curve25519fieldelement2.asZ, ai2, curve25519fieldelement2.asZ);
        Curve25519Field._mth141D(curve25519fieldelement2.asZ, ai1, curve25519fieldelement2.asZ);
        Curve25519FieldElement curve25519fieldelement4 = new Curve25519FieldElement(ai3);
        if (!Nat256._mth02BF(curve25519fieldelement.asZ))
        {
            Curve25519Field._mth02CE(curve25519fieldelement4.asZ, curve25519fieldelement.asZ, curve25519fieldelement4.asZ);
        }
        curve25519fieldelement = null;
        if (flag)
        {
            curve25519fieldelement = new Curve25519FieldElement(ai1);
            Curve25519Field._mth02CE(curve25519fieldelement.asZ, ((Curve25519FieldElement) (obj)).asZ, curve25519fieldelement.asZ);
            Curve25519Field._mth037A(curve25519fieldelement.asZ, curve25519fieldelement.asZ);
        }
        obj = FF79();
        flag = aHv;
        return new Curve25519Point(((ECCurve) (obj)), curve25519fieldelement1, curve25519fieldelement2, new ECFieldElement[] {
            curve25519fieldelement4, curve25519fieldelement
        }, flag);
    }

    public final ECPoint _mth029C()
    {
        if (_mth021D())
        {
            return this;
        } else
        {
            return new Curve25519Point(FF79(), aII, aIJ.FF29(), aIK, aHv);
        }
    }

    public final ECPoint _mth02BB(ECPoint ecpoint)
    {
        if (this == ecpoint)
        {
            return _mth039A();
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
            return _mth1D53(false)._mth141D(ecpoint);
        }
    }

    public final ECPoint _mth038E()
    {
        if (_mth021D())
        {
            return this;
        }
        ECCurve eccurve = FF79();
        if (aIJ.isZero())
        {
            return eccurve._mth5B80();
        } else
        {
            return _mth1D53(true);
        }
    }

    public final ECPoint _mth039A()
    {
        if (_mth021D())
        {
            return this;
        }
        if (aIJ.isZero())
        {
            return this;
        } else
        {
            return _mth1D53(false)._mth141D(this);
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
        Curve25519FieldElement curve25519fieldelement6 = (Curve25519FieldElement)aII;
        Curve25519FieldElement curve25519fieldelement5 = (Curve25519FieldElement)aIJ;
        Curve25519FieldElement curve25519fieldelement3 = (Curve25519FieldElement)aIK[0];
        Curve25519FieldElement curve25519fieldelement2 = (Curve25519FieldElement)ecpoint._mth0134();
        Curve25519FieldElement curve25519fieldelement1 = (Curve25519FieldElement)ecpoint._mth0141();
        Curve25519FieldElement curve25519fieldelement4 = (Curve25519FieldElement)ecpoint._mth1425(0);
        int ai3[] = Nat256._mth05E7();
        int ai4[] = Nat256._mth05E4();
        int ai5[] = Nat256._mth05E4();
        int ai6[] = Nat256._mth05E4();
        boolean flag = curve25519fieldelement3.FF53();
        int ai[];
        if (flag)
        {
            ecpoint = curve25519fieldelement2.asZ;
            ai = curve25519fieldelement1.asZ;
        } else
        {
            ai = ai5;
            Curve25519Field._mth02BD(curve25519fieldelement3.asZ, ai);
            ecpoint = ai4;
            Curve25519Field._mth02CE(ai, curve25519fieldelement2.asZ, ecpoint);
            Curve25519Field._mth02CE(ai, curve25519fieldelement3.asZ, ai);
            Curve25519Field._mth02CE(ai, curve25519fieldelement1.asZ, ai);
        }
        boolean flag1 = curve25519fieldelement4.FF53();
        int ai1[];
        int ai2[];
        if (flag1)
        {
            ai1 = curve25519fieldelement6.asZ;
            ai2 = curve25519fieldelement5.asZ;
        } else
        {
            ai2 = ai6;
            Curve25519Field._mth02BD(curve25519fieldelement4.asZ, ai2);
            ai1 = ai3;
            Curve25519Field._mth02CE(ai2, curve25519fieldelement6.asZ, ai1);
            Curve25519Field._mth02CE(ai2, curve25519fieldelement4.asZ, ai2);
            Curve25519Field._mth02CE(ai2, curve25519fieldelement5.asZ, ai2);
        }
        int ai7[] = Nat256._mth05E4();
        Curve25519Field._mth141D(ai1, ecpoint, ai7);
        Curve25519Field._mth141D(ai2, ai, ai4);
        if (Nat256._mth02C8(ai7))
        {
            if (Nat256._mth02C8(ai4))
            {
                return _mth038E();
            } else
            {
                return eccurve._mth5B80();
            }
        }
        ecpoint = Nat256._mth05E4();
        Curve25519Field._mth02BD(ai7, ecpoint);
        int ai8[] = Nat256._mth05E4();
        Curve25519Field._mth02CE(ecpoint, ai7, ai8);
        Curve25519Field._mth02CE(ecpoint, ai1, ai5);
        Curve25519Field._mth02BB(ai8, ai8);
        Nat256._mth1FBE(ai2, ai8, ai3);
        Curve25519Field._mth141D(Nat256._mth037A(ai5, ai5, ai8), ai8);
        Curve25519FieldElement curve25519fieldelement = new Curve25519FieldElement(ai6);
        Curve25519Field._mth02BD(ai4, curve25519fieldelement.asZ);
        Curve25519Field._mth141D(curve25519fieldelement.asZ, ai8, curve25519fieldelement.asZ);
        ai1 = new Curve25519FieldElement(ai8);
        Curve25519Field._mth141D(ai5, curve25519fieldelement.asZ, ((Curve25519FieldElement) (ai1)).asZ);
        Curve25519Field._mth02CF(((Curve25519FieldElement) (ai1)).asZ, ai4, ai3);
        Curve25519Field._mth02BC(ai3, ((Curve25519FieldElement) (ai1)).asZ);
        ai2 = new Curve25519FieldElement(ai7);
        if (!flag)
        {
            Curve25519Field._mth02CE(((Curve25519FieldElement) (ai2)).asZ, curve25519fieldelement3.asZ, ((Curve25519FieldElement) (ai2)).asZ);
        }
        if (!flag1)
        {
            Curve25519Field._mth02CE(((Curve25519FieldElement) (ai2)).asZ, curve25519fieldelement4.asZ, ((Curve25519FieldElement) (ai2)).asZ);
        }
        if (!flag || !flag1)
        {
            ecpoint = null;
        }
        ecpoint = _mth02CA(ai2, ecpoint);
        flag = aHv;
        return new Curve25519Point(eccurve, curve25519fieldelement, ai1, new ECFieldElement[] {
            ai2, ecpoint
        }, flag);
    }

    public final ECFieldElement _mth1425(int i)
    {
        if (i == 1)
        {
            return _mth0423();
        } else
        {
            return super._mth1425(i);
        }
    }

    protected final ECPoint FF7D()
    {
        return new Curve25519Point(null, FF8A(), FF93());
    }
}
