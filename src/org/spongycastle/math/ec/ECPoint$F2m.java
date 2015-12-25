// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;


// Referenced classes of package org.spongycastle.math.ec:
//            ECPoint, ECCurve, ECFieldElement, ECConstants

public static class aHv extends ractF2m
{

    public final ECFieldElement _mth0141()
    {
        int i = FF81();
        switch (i)
        {
        case 5: // '\005'
        case 6: // '\006'
            ECFieldElement ecfieldelement = aII;
            ECFieldElement ecfieldelement1 = aIJ;
            if (_mth021D() || ecfieldelement.isZero())
            {
                return ecfieldelement1;
            }
            ecfieldelement1 = ecfieldelement1._mth02CE(ecfieldelement)._mth141D(ecfieldelement);
            ecfieldelement = ecfieldelement1;
            if (6 == i)
            {
                ECFieldElement ecfieldelement2 = aIK[0];
                ecfieldelement = ecfieldelement1;
                if (!ecfieldelement2.FF53())
                {
                    ecfieldelement = ecfieldelement1._mth02BB(ecfieldelement2);
                }
            }
            return ecfieldelement;
        }
        return aIJ;
    }

    protected final boolean _mth0232()
    {
        ECFieldElement ecfieldelement = _mth014D();
        if (ecfieldelement.isZero())
        {
            return false;
        }
        ECFieldElement ecfieldelement1 = _mth0163();
        switch (FF81())
        {
        case 5: // '\005'
        case 6: // '\006'
            return ecfieldelement1.FF66() != ecfieldelement.FF66();
        }
        return ecfieldelement1._mth02BB(ecfieldelement).FF66();
    }

    public final ECPoint _mth029C()
    {
        if (_mth021D())
        {
            return this;
        }
        ECFieldElement ecfieldelement = aII;
        if (ecfieldelement.isZero())
        {
            return this;
        }
        switch (FF81())
        {
        case 0: // '\0'
            ECFieldElement ecfieldelement1 = aIJ;
            return new <init>(alm, ecfieldelement, ecfieldelement1._mth02CE(ecfieldelement), aHv);

        case 1: // '\001'
            ECFieldElement ecfieldelement5 = aIJ;
            ECFieldElement ecfieldelement2 = aIK[0];
            ECCurve eccurve = alm;
            ecfieldelement5 = ecfieldelement5._mth02CE(ecfieldelement);
            boolean flag = aHv;
            return new <init>(eccurve, ecfieldelement, ecfieldelement5, new ECFieldElement[] {
                ecfieldelement2
            }, flag);

        case 5: // '\005'
            ECFieldElement ecfieldelement3 = aIJ;
            return new <init>(alm, ecfieldelement, ecfieldelement3.FF26(), aHv);

        case 6: // '\006'
            ECFieldElement ecfieldelement6 = aIJ;
            ECFieldElement ecfieldelement4 = aIK[0];
            ECCurve eccurve1 = alm;
            ecfieldelement6 = ecfieldelement6._mth02CE(ecfieldelement4);
            boolean flag1 = aHv;
            return new <init>(eccurve1, ecfieldelement, ecfieldelement6, new ECFieldElement[] {
                ecfieldelement4
            }, flag1);
        }
        throw new IllegalStateException("unsupported coordinate system");
    }

    public final ECPoint _mth02BB(ECPoint ecpoint)
    {
        if (_mth021D())
        {
            return ecpoint;
        }
        if (ecpoint._mth021D())
        {
            return _mth038E();
        }
        ECCurve eccurve = FF79();
        ECFieldElement ecfieldelement = aII;
        if (ecfieldelement.isZero())
        {
            return ecpoint;
        }
        switch (eccurve.FB5E())
        {
        case 6: // '\006'
            ECFieldElement ecfieldelement1 = ecpoint.aII;
            ECFieldElement ecfieldelement2 = ecpoint.aIK[0];
            if (ecfieldelement1.isZero() || !ecfieldelement2.FF53())
            {
                return _mth038E()._mth141D(ecpoint);
            }
            ecfieldelement2 = aIJ;
            ECFieldElement ecfieldelement6 = aIK[0];
            ECFieldElement ecfieldelement3 = ecpoint.aIJ;
            ECFieldElement ecfieldelement4 = ecfieldelement.FF4C();
            ECFieldElement ecfieldelement5 = ecfieldelement2.FF4C();
            ecfieldelement = ecfieldelement6.FF4C();
            ecfieldelement2 = ecfieldelement2._mth141D(ecfieldelement6);
            ecfieldelement2 = eccurve.FB46()._mth141D(ecfieldelement)._mth02CE(ecfieldelement5)._mth02CE(ecfieldelement2);
            ecfieldelement3 = ecfieldelement3.FF26();
            ecfieldelement4 = eccurve.FB46()._mth02CE(ecfieldelement3)._mth141D(ecfieldelement)._mth02CE(ecfieldelement5)._mth02CB(ecfieldelement2, ecfieldelement4, ecfieldelement);
            ecfieldelement5 = ecfieldelement1._mth141D(ecfieldelement);
            ecfieldelement1 = ecfieldelement5._mth02CE(ecfieldelement2).FF4C();
            if (ecfieldelement1.isZero())
            {
                if (ecfieldelement4.isZero())
                {
                    return ecpoint._mth038E();
                } else
                {
                    return eccurve._mth5B80();
                }
            }
            if (ecfieldelement4.isZero())
            {
                return new <init>(eccurve, ecfieldelement4, eccurve.FB4C().FF52(), aHv);
            } else
            {
                ecpoint = ecfieldelement4.FF4C()._mth141D(ecfieldelement5);
                ecfieldelement = ecfieldelement4._mth141D(ecfieldelement1)._mth141D(ecfieldelement);
                ecfieldelement1 = ecfieldelement4._mth02CE(ecfieldelement1).FF4C()._mth02CB(ecfieldelement2, ecfieldelement3, ecfieldelement);
                boolean flag = aHv;
                return new <init>(eccurve, ecpoint, ecfieldelement1, new ECFieldElement[] {
                    ecfieldelement
                }, flag);
            }
        }
        return _mth038E()._mth141D(ecpoint);
    }

    public final ECPoint _mth02BD(ECFieldElement ecfieldelement)
    {
        if (_mth021D())
        {
            return this;
        }
        switch (FF81())
        {
        case 5: // '\005'
            ECFieldElement ecfieldelement1 = _mth014D();
            ECFieldElement ecfieldelement3 = _mth0163();
            ECFieldElement ecfieldelement4 = ecfieldelement1._mth141D(ecfieldelement);
            ecfieldelement = ecfieldelement3._mth02CE(ecfieldelement1)._mth02BB(ecfieldelement)._mth02CE(ecfieldelement4);
            return FF79()._mth02CA(ecfieldelement1, ecfieldelement, _mth0164(), aHv);

        case 6: // '\006'
            ECFieldElement ecfieldelement5 = _mth014D();
            ECFieldElement ecfieldelement6 = _mth0163();
            Object obj = _mth0164()[0];
            ECFieldElement ecfieldelement2 = ecfieldelement5._mth141D(ecfieldelement.FF4C());
            ecfieldelement5 = ecfieldelement6._mth02CE(ecfieldelement5)._mth02CE(ecfieldelement2);
            ecfieldelement = ((ECFieldElement) (obj))._mth141D(ecfieldelement);
            obj = FF79();
            boolean flag = aHv;
            return ((ECCurve) (obj))._mth02CA(ecfieldelement2, ecfieldelement5, new ECFieldElement[] {
                ecfieldelement
            }, flag);
        }
        return super._mth02BD(ecfieldelement);
    }

    public final nt _mth02CA(nt nt)
    {
        nt nt1 = this;
_L6:
        Object obj;
        ECFieldElement ecfieldelement10;
        ECCurve eccurve;
        int i;
        if (nt1._mth021D())
        {
            return nt;
        }
        if (nt._mth021D())
        {
            return nt1;
        }
        eccurve = nt1.FF79();
        i = eccurve.FB5E();
        obj = nt1.aII;
        ecfieldelement10 = nt.aII;
        i;
        JVM INSTR lookupswitch 3: default 80
    //                   0: 83
    //                   1: 208
    //                   6: 501;
           goto _L1 _L2 _L3 _L4
_L2:
        ECFieldElement ecfieldelement = nt1.aIJ;
        ECFieldElement ecfieldelement3 = nt.aIJ;
        nt = ((ECFieldElement) (obj))._mth02CE(ecfieldelement10);
        ecfieldelement3 = ecfieldelement._mth02CE(ecfieldelement3);
        if (nt.isZero())
        {
            if (ecfieldelement3.isZero())
            {
                return (nt.isZero)nt1._mth038E();
            } else
            {
                return (_cls038E)eccurve._mth5B80();
            }
        } else
        {
            ecfieldelement3 = ecfieldelement3._mth02BB(nt);
            nt = ecfieldelement3.FF4C()._mth02CE(ecfieldelement3)._mth02CE(nt)._mth02CE(eccurve.FB46());
            return new <init>(eccurve, nt, ecfieldelement3._mth141D(((ECFieldElement) (obj))._mth02CE(nt))._mth02CE(nt)._mth02CE(ecfieldelement), nt1.aHv);
        }
_L3:
        ECFieldElement ecfieldelement4 = nt1.aIJ;
        ECFieldElement ecfieldelement1 = nt1.aIK[0];
        ECFieldElement ecfieldelement5 = nt.aIJ;
        ECFieldElement ecfieldelement8 = nt.aIK[0];
        boolean flag = ecfieldelement8.FF53();
        ecfieldelement5 = ecfieldelement1._mth141D(ecfieldelement5);
        if (flag)
        {
            nt = ecfieldelement4;
        } else
        {
            nt = ecfieldelement4._mth141D(ecfieldelement8);
        }
        ECFieldElement ecfieldelement11 = ecfieldelement5._mth02CE(nt);
        ecfieldelement5 = ecfieldelement1._mth141D(ecfieldelement10);
        if (flag)
        {
            nt = ((nt) (obj));
        } else
        {
            nt = ((ECFieldElement) (obj))._mth141D(ecfieldelement8);
        }
        ECFieldElement ecfieldelement13 = ecfieldelement5._mth02CE(nt);
        if (ecfieldelement13.isZero())
        {
            if (ecfieldelement11.isZero())
            {
                return (nt.isZero)nt1._mth038E();
            } else
            {
                return (_cls038E)eccurve._mth5B80();
            }
        }
        ecfieldelement5 = ecfieldelement13.FF4C();
        ecfieldelement10 = ecfieldelement5._mth141D(ecfieldelement13);
        if (flag)
        {
            nt = ecfieldelement1;
        } else
        {
            nt = ecfieldelement1._mth141D(ecfieldelement8);
        }
        ECFieldElement ecfieldelement17 = ecfieldelement11._mth02CE(ecfieldelement13);
        ECFieldElement ecfieldelement19 = ecfieldelement17._mth02CB(ecfieldelement11, ecfieldelement5, eccurve.FB46())._mth141D(nt)._mth02CE(ecfieldelement10);
        ECFieldElement ecfieldelement15 = ecfieldelement13._mth141D(ecfieldelement19);
        if (flag)
        {
            ecfieldelement1 = ecfieldelement5;
        } else
        {
            ecfieldelement1 = ecfieldelement5._mth141D(ecfieldelement8);
        }
        obj = ecfieldelement11._mth02CB(((ECFieldElement) (obj)), ecfieldelement13, ecfieldelement4)._mth02CB(ecfieldelement1, ecfieldelement17, ecfieldelement19);
        nt = ecfieldelement10._mth141D(nt);
        flag = nt1.aHv;
        return new <init>(eccurve, ecfieldelement15, ((ECFieldElement) (obj)), new ECFieldElement[] {
            nt
        }, flag);
_L4:
        if (!((ECFieldElement) (obj)).isZero())
        {
            break; /* Loop/switch isn't completed */
        }
        if (ecfieldelement10.isZero())
        {
            return (nt.isZero)eccurve._mth5B80();
        }
        obj = nt;
        nt1 = nt;
        nt = (() (obj));
        if (true) goto _L6; else goto _L5
_L5:
        ECFieldElement ecfieldelement12 = nt1.aIJ;
        ECFieldElement ecfieldelement16 = nt1.aIK[0];
        ECFieldElement ecfieldelement14 = nt.aIJ;
        ECFieldElement ecfieldelement18 = nt.aIK[0];
        boolean flag1 = ecfieldelement16.FF53();
        ECFieldElement ecfieldelement6 = ecfieldelement10;
        Object obj1 = ecfieldelement14;
        nt = ecfieldelement6;
        ECFieldElement ecfieldelement2 = ((ECFieldElement) (obj1));
        if (!flag1)
        {
            nt = ecfieldelement6._mth141D(ecfieldelement16);
            ecfieldelement2 = ((ECFieldElement) (obj1))._mth141D(ecfieldelement16);
        }
        boolean flag2 = ecfieldelement18.FF53();
        Object obj2 = obj;
        obj1 = ecfieldelement12;
        obj = obj2;
        ecfieldelement6 = ((ECFieldElement) (obj1));
        if (!flag2)
        {
            obj = ((ECFieldElement) (obj2))._mth141D(ecfieldelement18);
            ecfieldelement6 = ((ECFieldElement) (obj1))._mth141D(ecfieldelement18);
        }
        ecfieldelement2 = ecfieldelement6._mth02CE(ecfieldelement2);
        obj1 = ((ECFieldElement) (obj))._mth02CE(nt);
        if (((ECFieldElement) (obj1)).isZero())
        {
            if (ecfieldelement2.isZero())
            {
                return (nt.isZero)nt1._mth038E();
            } else
            {
                return (_cls038E)eccurve._mth5B80();
            }
        }
        if (ecfieldelement10.isZero())
        {
            obj = nt1._mth0188();
            nt = ((ECPoint) (obj))._mth0134();
            ecfieldelement2 = ((ECPoint) (obj))._mth0141();
            obj1 = ecfieldelement2._mth02CE(ecfieldelement14)._mth02BB(nt);
            obj = ((ECFieldElement) (obj1)).FF4C()._mth02CE(((ECFieldElement) (obj1)))._mth02CE(nt)._mth02CE(eccurve.FB46());
            if (((ECFieldElement) (obj)).isZero())
            {
                return new <init>(eccurve, ((ECFieldElement) (obj)), eccurve.FB4C().FF52(), nt1.aHv);
            }
            ecfieldelement2 = ((ECFieldElement) (obj1))._mth141D(nt._mth02CE(((ECFieldElement) (obj))))._mth02CE(((ECFieldElement) (obj)))._mth02CE(ecfieldelement2)._mth02BB(((ECFieldElement) (obj)))._mth02CE(((ECFieldElement) (obj)));
            nt = eccurve._mth02BB(ECConstants.ONE);
        } else
        {
            obj1 = ((ECFieldElement) (obj1)).FF4C();
            obj = ecfieldelement2._mth141D(((ECFieldElement) (obj)));
            ECFieldElement ecfieldelement9 = ecfieldelement2._mth141D(nt);
            ECFieldElement ecfieldelement7 = ((ECFieldElement) (obj))._mth141D(ecfieldelement9);
            if (ecfieldelement7.isZero())
            {
                return new <init>(eccurve, ecfieldelement7, eccurve.FB4C().FF52(), nt1.aHv);
            }
            obj = ecfieldelement2._mth141D(((ECFieldElement) (obj1)));
            nt = ((nt) (obj));
            if (!flag2)
            {
                nt = ((ECFieldElement) (obj))._mth141D(ecfieldelement18);
            }
            ecfieldelement9 = ecfieldelement9._mth02CE(((ECFieldElement) (obj1)))._mth02CA(nt, ecfieldelement12._mth02CE(ecfieldelement16));
            obj1 = nt;
            obj = ecfieldelement7;
            ecfieldelement2 = ecfieldelement9;
            nt = ((nt) (obj1));
            if (!flag1)
            {
                nt = ((ECFieldElement) (obj1))._mth141D(ecfieldelement16);
                ecfieldelement2 = ecfieldelement9;
                obj = ecfieldelement7;
            }
        }
        flag1 = nt1.aHv;
        return new <init>(eccurve, ((ECFieldElement) (obj)), ecfieldelement2, new ECFieldElement[] {
            nt
        }, flag1);
_L1:
        throw new IllegalStateException("unsupported coordinate system");
    }

    public final ECPoint _mth037A(ECFieldElement ecfieldelement)
    {
        if (_mth021D())
        {
            return this;
        }
        switch (FF81())
        {
        case 5: // '\005'
        case 6: // '\006'
            ECFieldElement ecfieldelement1 = _mth014D();
            ecfieldelement = _mth0163()._mth02CE(ecfieldelement1)._mth141D(ecfieldelement)._mth02CE(ecfieldelement1);
            return FF79()._mth02CA(ecfieldelement1, ecfieldelement, _mth0164(), aHv);
        }
        return super._mth037A(ecfieldelement);
    }

    public final ECPoint _mth038E()
    {
        if (_mth021D())
        {
            return this;
        }
        ECCurve eccurve = FF79();
        ECFieldElement ecfieldelement = aII;
        if (ecfieldelement.isZero())
        {
            return eccurve._mth5B80();
        }
        switch (eccurve.FB5E())
        {
        case 0: // '\0'
            ECFieldElement ecfieldelement1 = aIJ._mth02BB(ecfieldelement)._mth02CE(ecfieldelement);
            ECFieldElement ecfieldelement4 = ecfieldelement1.FF4C()._mth02CE(ecfieldelement1)._mth02CE(eccurve.FB46());
            return new <init>(eccurve, ecfieldelement4, ecfieldelement._mth02CA(ecfieldelement4, ecfieldelement1.FF26()), aHv);

        case 1: // '\001'
            ECFieldElement ecfieldelement5 = aIJ;
            ECFieldElement ecfieldelement7 = aIK[0];
            boolean flag = ecfieldelement7.FF53();
            ECFieldElement ecfieldelement2;
            if (flag)
            {
                ecfieldelement2 = ecfieldelement;
            } else
            {
                ecfieldelement2 = ecfieldelement._mth141D(ecfieldelement7);
            }
            if (!flag)
            {
                ecfieldelement5 = ecfieldelement5._mth141D(ecfieldelement7);
            }
            ecfieldelement = ecfieldelement.FF4C();
            ecfieldelement7 = ecfieldelement._mth02CE(ecfieldelement5);
            ecfieldelement5 = ecfieldelement2.FF4C();
            ECFieldElement ecfieldelement9 = ecfieldelement7._mth02CE(ecfieldelement2);
            ECFieldElement ecfieldelement11 = ecfieldelement9._mth02CB(ecfieldelement7, ecfieldelement5, eccurve.FB46());
            ecfieldelement7 = ecfieldelement2._mth141D(ecfieldelement11);
            ecfieldelement = ecfieldelement.FF4C()._mth02CB(ecfieldelement2, ecfieldelement11, ecfieldelement9);
            ecfieldelement2 = ecfieldelement2._mth141D(ecfieldelement5);
            flag = aHv;
            return new <init>(eccurve, ecfieldelement7, ecfieldelement, new ECFieldElement[] {
                ecfieldelement2
            }, flag);

        case 6: // '\006'
            ECFieldElement ecfieldelement14 = aIJ;
            ECFieldElement ecfieldelement15 = aIK[0];
            boolean flag1 = ecfieldelement15.FF53();
            ECFieldElement ecfieldelement6;
            if (flag1)
            {
                ecfieldelement6 = ecfieldelement14;
            } else
            {
                ecfieldelement6 = ecfieldelement14._mth141D(ecfieldelement15);
            }
            ECFieldElement ecfieldelement8;
            if (flag1)
            {
                ecfieldelement8 = ecfieldelement15;
            } else
            {
                ecfieldelement8 = ecfieldelement15.FF4C();
            }
            ECFieldElement ecfieldelement12 = eccurve.FB46();
            ECFieldElement ecfieldelement10;
            if (flag1)
            {
                ecfieldelement10 = ecfieldelement12;
            } else
            {
                ecfieldelement10 = ecfieldelement12._mth141D(ecfieldelement8);
            }
            ECFieldElement ecfieldelement13 = ecfieldelement14.FF4C()._mth02CE(ecfieldelement6)._mth02CE(ecfieldelement10);
            if (ecfieldelement13.isZero())
            {
                return new <init>(eccurve, ecfieldelement13, eccurve.FB4C().FF52(), aHv);
            }
            ECFieldElement ecfieldelement16 = ecfieldelement13.FF4C();
            ECFieldElement ecfieldelement3;
            if (flag1)
            {
                ecfieldelement3 = ecfieldelement13;
            } else
            {
                ecfieldelement3 = ecfieldelement13._mth141D(ecfieldelement8);
            }
            ECFieldElement ecfieldelement17 = eccurve.FB4C();
            if (ecfieldelement17.bitLength() < eccurve.getFieldSize() >> 1)
            {
                ecfieldelement6 = ecfieldelement14._mth02CE(ecfieldelement).FF4C();
                if (ecfieldelement17.FF53())
                {
                    ecfieldelement = ecfieldelement10._mth02CE(ecfieldelement8).FF4C();
                } else
                {
                    ecfieldelement = ecfieldelement10._mth02CA(ecfieldelement17, ecfieldelement8.FF4C());
                }
                ecfieldelement6 = ecfieldelement6._mth02CE(ecfieldelement13)._mth02CE(ecfieldelement8)._mth141D(ecfieldelement6)._mth02CE(ecfieldelement)._mth02CE(ecfieldelement16);
                if (ecfieldelement12.isZero())
                {
                    ecfieldelement = ecfieldelement6._mth02CE(ecfieldelement3);
                } else
                {
                    ecfieldelement = ecfieldelement6;
                    if (!ecfieldelement12.FF53())
                    {
                        ecfieldelement = ecfieldelement6._mth02CE(ecfieldelement12.FF26()._mth141D(ecfieldelement3));
                    }
                }
            } else
            {
                if (!flag1)
                {
                    ecfieldelement = ecfieldelement._mth141D(ecfieldelement15);
                }
                ecfieldelement = ecfieldelement._mth02CA(ecfieldelement13, ecfieldelement6)._mth02CE(ecfieldelement16)._mth02CE(ecfieldelement3);
            }
            flag1 = aHv;
            return new <init>(eccurve, ecfieldelement16, ecfieldelement, new ECFieldElement[] {
                ecfieldelement3
            }, flag1);
        }
        throw new IllegalStateException("unsupported coordinate system");
    }

    public final > _mth039B()
    {
        if (_mth021D())
        {
            return this;
        }
        ECCurve eccurve = FF79();
        int i = eccurve.FB5E();
        ECFieldElement ecfieldelement2 = aII;
        switch (i)
        {
        case 0: // '\0'
        case 5: // '\005'
            ECFieldElement ecfieldelement = aIJ;
            return new <init>(eccurve, ecfieldelement2.FF4C(), ecfieldelement.FF4C(), aHv);

        case 1: // '\001'
        case 6: // '\006'
            ECFieldElement ecfieldelement3 = aIJ;
            ECFieldElement ecfieldelement1 = aIK[0];
            ecfieldelement2 = ecfieldelement2.FF4C();
            ecfieldelement3 = ecfieldelement3.FF4C();
            ecfieldelement1 = ecfieldelement1.FF4C();
            boolean flag = aHv;
            return new <init>(eccurve, ecfieldelement2, ecfieldelement3, new ECFieldElement[] {
                ecfieldelement1
            }, flag);
        }
        throw new IllegalStateException("unsupported coordinate system");
    }

    public final ECPoint _mth141D(ECPoint ecpoint)
    {
        if (super.alm != ecpoint.alm)
        {
            throw new IllegalArgumentException("Only points on the same curve can be added or subtracted");
        } else
        {
            return _mth02CA((_cls02CA)ecpoint);
        }
    }

    protected final ECPoint FF7D()
    {
        return new <init>(null, FF8A(), FF93());
    }

    public nt(nt nt, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
    {
        this(((ECCurve) (nt)), ecfieldelement, ecfieldelement1, false);
    }

    public nt(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
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
        }
        if (ecfieldelement != null)
        {
            nt.F2m._mth02CB(aII, aIJ);
            if (eccurve != null)
            {
                nt.F2m._mth02CB(aII, alm.FB46());
            }
        }
        aHv = flag;
    }

    nt(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
    {
        super(eccurve, ecfieldelement, ecfieldelement1, aecfieldelement);
        aHv = flag;
    }
}
