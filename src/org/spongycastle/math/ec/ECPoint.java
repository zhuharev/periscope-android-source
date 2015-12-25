// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.util.BigIntegers;

// Referenced classes of package org.spongycastle.math.ec:
//            ECFieldElement, ECCurve, ECConstants, ECAlgorithms

public abstract class ECPoint
{
    public static abstract class AbstractF2m extends ECPoint
    {

        protected final boolean FF77()
        {
            Object obj = FF79();
            ECFieldElement ecfieldelement9 = aII;
            ECFieldElement ecfieldelement6 = ((ECCurve) (obj)).FB46();
            ECFieldElement ecfieldelement = ((ECCurve) (obj)).FB4C();
            int i = ((ECCurve) (obj)).FB5E();
            if (i == 6)
            {
                ECFieldElement ecfieldelement4 = aIK[0];
                boolean flag = ecfieldelement4.FF53();
                if (ecfieldelement9.isZero())
                {
                    ECFieldElement ecfieldelement1 = aIJ.FF4C();
                    obj = ecfieldelement;
                    if (!flag)
                    {
                        obj = ecfieldelement._mth141D(ecfieldelement4.FF4C());
                    }
                    return ecfieldelement1.equals(obj);
                }
                obj = aIJ;
                ECFieldElement ecfieldelement2 = ecfieldelement9.FF4C();
                if (flag)
                {
                    obj = ((ECFieldElement) (obj)).FF4C()._mth02CE(((ECFieldElement) (obj)))._mth02CE(ecfieldelement6);
                    ecfieldelement = ecfieldelement2.FF4C()._mth02CE(ecfieldelement);
                } else
                {
                    ecfieldelement9 = ecfieldelement4.FF4C();
                    ECFieldElement ecfieldelement7 = ecfieldelement9.FF4C();
                    obj = ((ECFieldElement) (obj))._mth02CE(ecfieldelement4)._mth02CB(((ECFieldElement) (obj)), ecfieldelement6, ecfieldelement9);
                    ecfieldelement = ecfieldelement2._mth02CA(ecfieldelement, ecfieldelement7);
                }
                return ((ECFieldElement) (obj))._mth141D(ecfieldelement2).equals(ecfieldelement);
            }
            obj = aIJ;
            ECFieldElement ecfieldelement8 = ((ECFieldElement) (obj))._mth02CE(ecfieldelement9)._mth141D(((ECFieldElement) (obj)));
            ECFieldElement ecfieldelement3;
            ECFieldElement ecfieldelement5;
            switch (i)
            {
            case 0: // '\0'
                obj = ecfieldelement6;
                ecfieldelement3 = ecfieldelement;
                ecfieldelement5 = ecfieldelement8;
                break;

            case 1: // '\001'
                ECFieldElement ecfieldelement10 = aIK[0];
                obj = ecfieldelement6;
                ecfieldelement3 = ecfieldelement;
                ecfieldelement5 = ecfieldelement8;
                if (!ecfieldelement10.FF53())
                {
                    ecfieldelement3 = ecfieldelement10._mth141D(ecfieldelement10.FF4C());
                    ecfieldelement5 = ecfieldelement8._mth141D(ecfieldelement10);
                    obj = ecfieldelement6._mth141D(ecfieldelement10);
                    ecfieldelement3 = ecfieldelement._mth141D(ecfieldelement3);
                }
                break;

            default:
                throw new IllegalStateException("unsupported coordinate system");
            }
            return ecfieldelement5.equals(ecfieldelement9._mth02CE(((ECFieldElement) (obj)))._mth141D(ecfieldelement9.FF4C())._mth02CE(ecfieldelement3));
        }

        protected AbstractF2m(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
        {
            super(eccurve, ecfieldelement, ecfieldelement1);
        }

        protected AbstractF2m(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[])
        {
            super(eccurve, ecfieldelement, ecfieldelement1, aecfieldelement);
        }
    }

    public static abstract class AbstractFp extends ECPoint
    {

        protected final boolean _mth0232()
        {
            return FF93().FF66();
        }

        protected final boolean FF77()
        {
            ECFieldElement ecfieldelement6 = aII;
            ECFieldElement ecfieldelement = aIJ;
            ECFieldElement ecfieldelement4 = alm.FB46();
            ECFieldElement ecfieldelement3 = alm.FB4C();
            ECFieldElement ecfieldelement5 = ecfieldelement.FF4C();
            ECFieldElement ecfieldelement1;
            ECFieldElement ecfieldelement2;
            switch (FF81())
            {
            case 0: // '\0'
                ecfieldelement2 = ecfieldelement5;
                ecfieldelement = ecfieldelement4;
                ecfieldelement1 = ecfieldelement3;
                break;

            case 1: // '\001'
                ECFieldElement ecfieldelement7 = aIK[0];
                ecfieldelement2 = ecfieldelement5;
                ecfieldelement = ecfieldelement4;
                ecfieldelement1 = ecfieldelement3;
                if (!ecfieldelement7.FF53())
                {
                    ecfieldelement = ecfieldelement7.FF4C();
                    ecfieldelement1 = ecfieldelement7._mth141D(ecfieldelement);
                    ecfieldelement2 = ecfieldelement5._mth141D(ecfieldelement7);
                    ecfieldelement = ecfieldelement4._mth141D(ecfieldelement);
                    ecfieldelement1 = ecfieldelement3._mth141D(ecfieldelement1);
                }
                break;

            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
                ECFieldElement ecfieldelement8 = aIK[0];
                ecfieldelement2 = ecfieldelement5;
                ecfieldelement = ecfieldelement4;
                ecfieldelement1 = ecfieldelement3;
                if (!ecfieldelement8.FF53())
                {
                    ecfieldelement1 = ecfieldelement8.FF4C();
                    ecfieldelement = ecfieldelement1.FF4C();
                    ecfieldelement1 = ecfieldelement1._mth141D(ecfieldelement);
                    ecfieldelement = ecfieldelement4._mth141D(ecfieldelement);
                    ecfieldelement1 = ecfieldelement3._mth141D(ecfieldelement1);
                    ecfieldelement2 = ecfieldelement5;
                }
                break;

            default:
                throw new IllegalStateException("unsupported coordinate system");
            }
            return ecfieldelement2.equals(ecfieldelement6.FF4C()._mth02CE(ecfieldelement)._mth141D(ecfieldelement6)._mth02CE(ecfieldelement1));
        }

        public AbstractFp(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
        {
            super(eccurve, ecfieldelement, ecfieldelement1);
        }

        public AbstractFp(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[])
        {
            super(eccurve, ecfieldelement, ecfieldelement1, aecfieldelement);
        }
    }

    public static class F2m extends AbstractF2m
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
                return new F2m(alm, ecfieldelement, ecfieldelement1._mth02CE(ecfieldelement), aHv);

            case 1: // '\001'
                ECFieldElement ecfieldelement5 = aIJ;
                ECFieldElement ecfieldelement2 = aIK[0];
                ECCurve eccurve = alm;
                ecfieldelement5 = ecfieldelement5._mth02CE(ecfieldelement);
                boolean flag = aHv;
                return new F2m(eccurve, ecfieldelement, ecfieldelement5, new ECFieldElement[] {
                    ecfieldelement2
                }, flag);

            case 5: // '\005'
                ECFieldElement ecfieldelement3 = aIJ;
                return new F2m(alm, ecfieldelement, ecfieldelement3.FF26(), aHv);

            case 6: // '\006'
                ECFieldElement ecfieldelement6 = aIJ;
                ECFieldElement ecfieldelement4 = aIK[0];
                ECCurve eccurve1 = alm;
                ecfieldelement6 = ecfieldelement6._mth02CE(ecfieldelement4);
                boolean flag1 = aHv;
                return new F2m(eccurve1, ecfieldelement, ecfieldelement6, new ECFieldElement[] {
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
                    return new F2m(eccurve, ecfieldelement4, eccurve.FB4C().FF52(), aHv);
                } else
                {
                    ecpoint = ecfieldelement4.FF4C()._mth141D(ecfieldelement5);
                    ecfieldelement = ecfieldelement4._mth141D(ecfieldelement1)._mth141D(ecfieldelement);
                    ecfieldelement1 = ecfieldelement4._mth02CE(ecfieldelement1).FF4C()._mth02CB(ecfieldelement2, ecfieldelement3, ecfieldelement);
                    boolean flag = aHv;
                    return new F2m(eccurve, ecpoint, ecfieldelement1, new ECFieldElement[] {
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

        public final F2m _mth02CA(F2m f2m)
        {
            F2m f2m1 = this;
_L6:
            Object obj;
            ECFieldElement ecfieldelement10;
            ECCurve eccurve;
            int i;
            if (f2m1._mth021D())
            {
                return f2m;
            }
            if (f2m._mth021D())
            {
                return f2m1;
            }
            eccurve = f2m1.FF79();
            i = eccurve.FB5E();
            obj = f2m1.aII;
            ecfieldelement10 = f2m.aII;
            i;
            JVM INSTR lookupswitch 3: default 80
        //                       0: 83
        //                       1: 208
        //                       6: 501;
               goto _L1 _L2 _L3 _L4
_L2:
            ECFieldElement ecfieldelement = f2m1.aIJ;
            ECFieldElement ecfieldelement3 = f2m.aIJ;
            f2m = ((ECFieldElement) (obj))._mth02CE(ecfieldelement10);
            ecfieldelement3 = ecfieldelement._mth02CE(ecfieldelement3);
            if (f2m.isZero())
            {
                if (ecfieldelement3.isZero())
                {
                    return (F2m)f2m1._mth038E();
                } else
                {
                    return (F2m)eccurve._mth5B80();
                }
            } else
            {
                ecfieldelement3 = ecfieldelement3._mth02BB(f2m);
                f2m = ecfieldelement3.FF4C()._mth02CE(ecfieldelement3)._mth02CE(f2m)._mth02CE(eccurve.FB46());
                return new F2m(eccurve, f2m, ecfieldelement3._mth141D(((ECFieldElement) (obj))._mth02CE(f2m))._mth02CE(f2m)._mth02CE(ecfieldelement), f2m1.aHv);
            }
_L3:
            ECFieldElement ecfieldelement4 = f2m1.aIJ;
            ECFieldElement ecfieldelement1 = f2m1.aIK[0];
            ECFieldElement ecfieldelement5 = f2m.aIJ;
            ECFieldElement ecfieldelement8 = f2m.aIK[0];
            boolean flag = ecfieldelement8.FF53();
            ecfieldelement5 = ecfieldelement1._mth141D(ecfieldelement5);
            if (flag)
            {
                f2m = ecfieldelement4;
            } else
            {
                f2m = ecfieldelement4._mth141D(ecfieldelement8);
            }
            ECFieldElement ecfieldelement11 = ecfieldelement5._mth02CE(f2m);
            ecfieldelement5 = ecfieldelement1._mth141D(ecfieldelement10);
            if (flag)
            {
                f2m = ((F2m) (obj));
            } else
            {
                f2m = ((ECFieldElement) (obj))._mth141D(ecfieldelement8);
            }
            ECFieldElement ecfieldelement13 = ecfieldelement5._mth02CE(f2m);
            if (ecfieldelement13.isZero())
            {
                if (ecfieldelement11.isZero())
                {
                    return (F2m)f2m1._mth038E();
                } else
                {
                    return (F2m)eccurve._mth5B80();
                }
            }
            ecfieldelement5 = ecfieldelement13.FF4C();
            ecfieldelement10 = ecfieldelement5._mth141D(ecfieldelement13);
            if (flag)
            {
                f2m = ecfieldelement1;
            } else
            {
                f2m = ecfieldelement1._mth141D(ecfieldelement8);
            }
            ECFieldElement ecfieldelement17 = ecfieldelement11._mth02CE(ecfieldelement13);
            ECFieldElement ecfieldelement19 = ecfieldelement17._mth02CB(ecfieldelement11, ecfieldelement5, eccurve.FB46())._mth141D(f2m)._mth02CE(ecfieldelement10);
            ECFieldElement ecfieldelement15 = ecfieldelement13._mth141D(ecfieldelement19);
            if (flag)
            {
                ecfieldelement1 = ecfieldelement5;
            } else
            {
                ecfieldelement1 = ecfieldelement5._mth141D(ecfieldelement8);
            }
            obj = ecfieldelement11._mth02CB(((ECFieldElement) (obj)), ecfieldelement13, ecfieldelement4)._mth02CB(ecfieldelement1, ecfieldelement17, ecfieldelement19);
            f2m = ecfieldelement10._mth141D(f2m);
            flag = f2m1.aHv;
            return new F2m(eccurve, ecfieldelement15, ((ECFieldElement) (obj)), new ECFieldElement[] {
                f2m
            }, flag);
_L4:
            if (!((ECFieldElement) (obj)).isZero())
            {
                break; /* Loop/switch isn't completed */
            }
            if (ecfieldelement10.isZero())
            {
                return (F2m)eccurve._mth5B80();
            }
            obj = f2m;
            f2m1 = f2m;
            f2m = ((F2m) (obj));
            if (true) goto _L6; else goto _L5
_L5:
            ECFieldElement ecfieldelement12 = f2m1.aIJ;
            ECFieldElement ecfieldelement16 = f2m1.aIK[0];
            ECFieldElement ecfieldelement14 = f2m.aIJ;
            ECFieldElement ecfieldelement18 = f2m.aIK[0];
            boolean flag1 = ecfieldelement16.FF53();
            ECFieldElement ecfieldelement6 = ecfieldelement10;
            Object obj1 = ecfieldelement14;
            f2m = ecfieldelement6;
            ECFieldElement ecfieldelement2 = ((ECFieldElement) (obj1));
            if (!flag1)
            {
                f2m = ecfieldelement6._mth141D(ecfieldelement16);
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
            obj1 = ((ECFieldElement) (obj))._mth02CE(f2m);
            if (((ECFieldElement) (obj1)).isZero())
            {
                if (ecfieldelement2.isZero())
                {
                    return (F2m)f2m1._mth038E();
                } else
                {
                    return (F2m)eccurve._mth5B80();
                }
            }
            if (ecfieldelement10.isZero())
            {
                obj = f2m1._mth0188();
                f2m = ((ECPoint) (obj))._mth0134();
                ecfieldelement2 = ((ECPoint) (obj))._mth0141();
                obj1 = ecfieldelement2._mth02CE(ecfieldelement14)._mth02BB(f2m);
                obj = ((ECFieldElement) (obj1)).FF4C()._mth02CE(((ECFieldElement) (obj1)))._mth02CE(f2m)._mth02CE(eccurve.FB46());
                if (((ECFieldElement) (obj)).isZero())
                {
                    return new F2m(eccurve, ((ECFieldElement) (obj)), eccurve.FB4C().FF52(), f2m1.aHv);
                }
                ecfieldelement2 = ((ECFieldElement) (obj1))._mth141D(f2m._mth02CE(((ECFieldElement) (obj))))._mth02CE(((ECFieldElement) (obj)))._mth02CE(ecfieldelement2)._mth02BB(((ECFieldElement) (obj)))._mth02CE(((ECFieldElement) (obj)));
                f2m = eccurve._mth02BB(ECConstants.ONE);
            } else
            {
                obj1 = ((ECFieldElement) (obj1)).FF4C();
                obj = ecfieldelement2._mth141D(((ECFieldElement) (obj)));
                ECFieldElement ecfieldelement9 = ecfieldelement2._mth141D(f2m);
                ECFieldElement ecfieldelement7 = ((ECFieldElement) (obj))._mth141D(ecfieldelement9);
                if (ecfieldelement7.isZero())
                {
                    return new F2m(eccurve, ecfieldelement7, eccurve.FB4C().FF52(), f2m1.aHv);
                }
                obj = ecfieldelement2._mth141D(((ECFieldElement) (obj1)));
                f2m = ((F2m) (obj));
                if (!flag2)
                {
                    f2m = ((ECFieldElement) (obj))._mth141D(ecfieldelement18);
                }
                ecfieldelement9 = ecfieldelement9._mth02CE(((ECFieldElement) (obj1)))._mth02CA(f2m, ecfieldelement12._mth02CE(ecfieldelement16));
                obj1 = f2m;
                obj = ecfieldelement7;
                ecfieldelement2 = ecfieldelement9;
                f2m = ((F2m) (obj1));
                if (!flag1)
                {
                    f2m = ((ECFieldElement) (obj1))._mth141D(ecfieldelement16);
                    ecfieldelement2 = ecfieldelement9;
                    obj = ecfieldelement7;
                }
            }
            flag1 = f2m1.aHv;
            return new F2m(eccurve, ((ECFieldElement) (obj)), ecfieldelement2, new ECFieldElement[] {
                f2m
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
                return new F2m(eccurve, ecfieldelement4, ecfieldelement._mth02CA(ecfieldelement4, ecfieldelement1.FF26()), aHv);

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
                return new F2m(eccurve, ecfieldelement7, ecfieldelement, new ECFieldElement[] {
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
                    return new F2m(eccurve, ecfieldelement13, eccurve.FB4C().FF52(), aHv);
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
                return new F2m(eccurve, ecfieldelement16, ecfieldelement, new ECFieldElement[] {
                    ecfieldelement3
                }, flag1);
            }
            throw new IllegalStateException("unsupported coordinate system");
        }

        public final F2m _mth039B()
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
                return new F2m(eccurve, ecfieldelement2.FF4C(), ecfieldelement.FF4C(), aHv);

            case 1: // '\001'
            case 6: // '\006'
                ECFieldElement ecfieldelement3 = aIJ;
                ECFieldElement ecfieldelement1 = aIK[0];
                ecfieldelement2 = ecfieldelement2.FF4C();
                ecfieldelement3 = ecfieldelement3.FF4C();
                ecfieldelement1 = ecfieldelement1.FF4C();
                boolean flag = aHv;
                return new F2m(eccurve, ecfieldelement2, ecfieldelement3, new ECFieldElement[] {
                    ecfieldelement1
                }, flag);
            }
            throw new IllegalStateException("unsupported coordinate system");
        }

        public final ECPoint _mth141D(ECPoint ecpoint)
        {
            if (alm != ecpoint.alm)
            {
                throw new IllegalArgumentException("Only points on the same curve can be added or subtracted");
            } else
            {
                return _mth02CA((F2m)ecpoint);
            }
        }

        protected final ECPoint FF7D()
        {
            return new F2m(null, FF8A(), FF93());
        }

        public F2m(ECCurve.F2m f2m, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
        {
            this(((ECCurve) (f2m)), ecfieldelement, ecfieldelement1, false);
        }

        public F2m(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
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
                ECFieldElement.F2m._mth02CB(aII, aIJ);
                if (eccurve != null)
                {
                    ECFieldElement.F2m._mth02CB(aII, alm.FB46());
                }
            }
            aHv = flag;
        }

        F2m(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
        {
            super(eccurve, ecfieldelement, ecfieldelement1, aecfieldelement);
            aHv = flag;
        }
    }

    public static class Fp extends AbstractFp
    {

        private ECFieldElement _mth02CE(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
        {
            ECFieldElement ecfieldelement3 = FF79().FB46();
            if (ecfieldelement3.isZero() || ecfieldelement.FF53())
            {
                return ecfieldelement3;
            }
            ECFieldElement ecfieldelement2 = ecfieldelement1;
            if (ecfieldelement1 == null)
            {
                ecfieldelement2 = ecfieldelement.FF4C();
            }
            ecfieldelement = ecfieldelement2.FF4C();
            ecfieldelement1 = ecfieldelement3.FF29();
            if (ecfieldelement1.bitLength() < ecfieldelement3.bitLength())
            {
                return ecfieldelement._mth141D(ecfieldelement1).FF29();
            } else
            {
                return ecfieldelement._mth141D(ecfieldelement3);
            }
        }

        private Fp _mth1D4C(boolean flag)
        {
            ECFieldElement ecfieldelement2 = aII;
            ECFieldElement ecfieldelement4 = aIJ;
            Object obj = aIK[0];
            ECFieldElement ecfieldelement1 = aIK[1];
            ECFieldElement ecfieldelement = ecfieldelement1;
            if (ecfieldelement1 == null)
            {
                ECFieldElement aecfieldelement[] = aIK;
                ecfieldelement = _mth02CE(aIK[0], null);
                aecfieldelement[1] = ecfieldelement;
            }
            aecfieldelement = ecfieldelement2.FF4C();
            ECFieldElement ecfieldelement3 = aecfieldelement._mth02CE(aecfieldelement)._mth02CE(aecfieldelement)._mth02CE(ecfieldelement);
            aecfieldelement = ecfieldelement4._mth02CE(ecfieldelement4);
            ecfieldelement4 = aecfieldelement._mth141D(ecfieldelement4);
            ecfieldelement2 = ecfieldelement2._mth141D(ecfieldelement4);
            ECFieldElement ecfieldelement5 = ecfieldelement2._mth02CE(ecfieldelement2);
            ecfieldelement2 = ecfieldelement3.FF4C()._mth02CF(ecfieldelement5._mth02CE(ecfieldelement5));
            ecfieldelement4 = ecfieldelement4.FF4C();
            ecfieldelement4 = ecfieldelement4._mth02CE(ecfieldelement4);
            ecfieldelement3 = ecfieldelement3._mth141D(ecfieldelement5._mth02CF(ecfieldelement2))._mth02CF(ecfieldelement4);
            if (flag)
            {
                ecfieldelement = ecfieldelement4._mth141D(ecfieldelement);
                ecfieldelement = ecfieldelement._mth02CE(ecfieldelement);
            } else
            {
                ecfieldelement = null;
            }
            if (!((ECFieldElement) (obj)).FF53())
            {
                aecfieldelement = aecfieldelement._mth141D(((ECFieldElement) (obj)));
            }
            obj = FF79();
            flag = aHv;
            return new Fp(((ECCurve) (obj)), ecfieldelement2, ecfieldelement3, new ECFieldElement[] {
                aecfieldelement, ecfieldelement
            }, flag);
        }

        public final ECPoint _mth029C()
        {
            if (_mth021D())
            {
                return this;
            }
            ECCurve eccurve = FF79();
            if (eccurve.FB5E() != 0)
            {
                return new Fp(eccurve, aII, aIJ.FF29(), aIK, aHv);
            } else
            {
                return new Fp(eccurve, aII, aIJ.FF29(), aHv);
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
            ECFieldElement ecfieldelement = aIJ;
            if (ecfieldelement.isZero())
            {
                return ecpoint;
            }
            ECCurve eccurve = FF79();
            switch (eccurve.FB5E())
            {
            case 0: // '\0'
                ECFieldElement ecfieldelement1 = aII;
                ECFieldElement ecfieldelement2 = ecpoint.aII;
                ECFieldElement ecfieldelement3 = ecpoint.aIJ;
                ecpoint = ecfieldelement2._mth02CF(ecfieldelement1);
                ECFieldElement ecfieldelement4 = ecfieldelement3._mth02CF(ecfieldelement);
                if (ecpoint.isZero())
                {
                    if (ecfieldelement4.isZero())
                    {
                        return _mth039A();
                    } else
                    {
                        return this;
                    }
                }
                ecfieldelement3 = ecpoint.FF4C();
                ECFieldElement ecfieldelement5 = ecfieldelement4.FF4C();
                ECFieldElement ecfieldelement7 = ecfieldelement3._mth141D(ecfieldelement1._mth02CE(ecfieldelement1)._mth02CE(ecfieldelement2))._mth02CF(ecfieldelement5);
                if (ecfieldelement7.isZero())
                {
                    return eccurve._mth5B80();
                } else
                {
                    ECFieldElement ecfieldelement6 = ecfieldelement7._mth141D(ecpoint).FF4E();
                    ecfieldelement4 = ecfieldelement7._mth141D(ecfieldelement6)._mth141D(ecfieldelement4);
                    ecpoint = ecfieldelement._mth02CE(ecfieldelement)._mth141D(ecfieldelement3)._mth141D(ecpoint)._mth141D(ecfieldelement6)._mth02CF(ecfieldelement4);
                    ecfieldelement2 = ecpoint._mth02CF(ecfieldelement4)._mth141D(ecfieldelement4._mth02CE(ecpoint))._mth02CE(ecfieldelement2);
                    return new Fp(eccurve, ecfieldelement2, ecfieldelement1._mth02CF(ecfieldelement2)._mth141D(ecpoint)._mth02CF(ecfieldelement), aHv);
                }

            case 4: // '\004'
                return _mth1D4C(false)._mth141D(ecpoint);
            }
            return _mth038E()._mth141D(ecpoint);
        }

        public final ECPoint _mth038E()
        {
            if (_mth021D())
            {
                return this;
            }
            ECCurve eccurve = FF79();
            ECFieldElement ecfieldelement8 = aIJ;
            if (ecfieldelement8.isZero())
            {
                return eccurve._mth5B80();
            }
            int i = eccurve.FB5E();
            ECFieldElement ecfieldelement9 = aII;
            switch (i)
            {
            case 0: // '\0'
                ECFieldElement ecfieldelement = ecfieldelement9.FF4C();
                ecfieldelement = ecfieldelement._mth02CE(ecfieldelement)._mth02CE(ecfieldelement)._mth02CE(FF79().FB46())._mth02BB(ecfieldelement8._mth02CE(ecfieldelement8));
                ECFieldElement ecfieldelement3 = ecfieldelement.FF4C()._mth02CF(ecfieldelement9._mth02CE(ecfieldelement9));
                return new Fp(eccurve, ecfieldelement3, ecfieldelement._mth141D(ecfieldelement9._mth02CF(ecfieldelement3))._mth02CF(ecfieldelement8), aHv);

            case 1: // '\001'
                ECFieldElement ecfieldelement10 = aIK[0];
                boolean flag = ecfieldelement10.FF53();
                ECFieldElement ecfieldelement4 = eccurve.FB46();
                ECFieldElement ecfieldelement1 = ecfieldelement4;
                if (!ecfieldelement4.isZero())
                {
                    ecfieldelement1 = ecfieldelement4;
                    if (!flag)
                    {
                        ecfieldelement1 = ecfieldelement4._mth141D(ecfieldelement10.FF4C());
                    }
                }
                ecfieldelement4 = ecfieldelement9.FF4C();
                ECFieldElement ecfieldelement6 = ecfieldelement1._mth02CE(ecfieldelement4._mth02CE(ecfieldelement4)._mth02CE(ecfieldelement4));
                if (flag)
                {
                    ecfieldelement1 = ecfieldelement8;
                } else
                {
                    ecfieldelement1 = ecfieldelement8._mth141D(ecfieldelement10);
                }
                if (flag)
                {
                    ecfieldelement4 = ecfieldelement8.FF4C();
                } else
                {
                    ecfieldelement4 = ecfieldelement1._mth141D(ecfieldelement8);
                }
                ecfieldelement8 = ecfieldelement9._mth141D(ecfieldelement4);
                ecfieldelement8 = ecfieldelement8._mth02CE(ecfieldelement8);
                ecfieldelement10 = ecfieldelement8._mth02CE(ecfieldelement8);
                ECFieldElement ecfieldelement12 = ecfieldelement6.FF4C()._mth02CF(ecfieldelement10._mth02CE(ecfieldelement10));
                ecfieldelement9 = ecfieldelement1._mth02CE(ecfieldelement1);
                ecfieldelement8 = ecfieldelement12._mth141D(ecfieldelement9);
                ecfieldelement4 = ecfieldelement4._mth02CE(ecfieldelement4);
                ecfieldelement6 = ecfieldelement10._mth02CF(ecfieldelement12)._mth141D(ecfieldelement6);
                ecfieldelement10 = ecfieldelement4.FF4C();
                ecfieldelement6 = ecfieldelement6._mth02CF(ecfieldelement10._mth02CE(ecfieldelement10));
                if (flag)
                {
                    ecfieldelement4 = ecfieldelement4._mth02CE(ecfieldelement4);
                } else
                {
                    ecfieldelement4 = ecfieldelement9.FF4C();
                }
                ecfieldelement1 = ecfieldelement4._mth02CE(ecfieldelement4)._mth141D(ecfieldelement1);
                flag = aHv;
                return new Fp(eccurve, ecfieldelement8, ecfieldelement6, new ECFieldElement[] {
                    ecfieldelement1
                }, flag);

            case 2: // '\002'
                ECFieldElement ecfieldelement5 = aIK[0];
                boolean flag1 = ecfieldelement5.FF53();
                ECFieldElement ecfieldelement13 = ecfieldelement8.FF4C();
                ECFieldElement ecfieldelement11 = ecfieldelement13.FF4C();
                ECFieldElement ecfieldelement14 = eccurve.FB46();
                ECFieldElement ecfieldelement15 = ecfieldelement14.FF29();
                ECFieldElement ecfieldelement2;
                ECFieldElement ecfieldelement7;
                if (ecfieldelement15.toBigInteger().equals(BigInteger.valueOf(3L)))
                {
                    if (flag1)
                    {
                        ecfieldelement2 = ecfieldelement5;
                    } else
                    {
                        ecfieldelement2 = ecfieldelement5.FF4C();
                    }
                    ecfieldelement2 = ecfieldelement9._mth02CE(ecfieldelement2)._mth141D(ecfieldelement9._mth02CF(ecfieldelement2));
                    ecfieldelement7 = ecfieldelement2._mth02CE(ecfieldelement2)._mth02CE(ecfieldelement2);
                    ecfieldelement2 = ecfieldelement13._mth141D(ecfieldelement9);
                    ecfieldelement2 = ecfieldelement2._mth02CE(ecfieldelement2);
                    ecfieldelement2 = ecfieldelement2._mth02CE(ecfieldelement2);
                } else
                {
                    ecfieldelement2 = ecfieldelement9.FF4C();
                    ecfieldelement7 = ecfieldelement2._mth02CE(ecfieldelement2)._mth02CE(ecfieldelement2);
                    if (flag1)
                    {
                        ecfieldelement2 = ecfieldelement7._mth02CE(ecfieldelement14);
                    } else
                    {
                        ecfieldelement2 = ecfieldelement7;
                        if (!ecfieldelement14.isZero())
                        {
                            if (flag1)
                            {
                                ecfieldelement2 = ecfieldelement5;
                            } else
                            {
                                ecfieldelement2 = ecfieldelement5.FF4C();
                            }
                            ecfieldelement2 = ecfieldelement2.FF4C();
                            if (ecfieldelement15.bitLength() < ecfieldelement14.bitLength())
                            {
                                ecfieldelement2 = ecfieldelement7._mth02CF(ecfieldelement2._mth141D(ecfieldelement15));
                            } else
                            {
                                ecfieldelement2 = ecfieldelement7._mth02CE(ecfieldelement2._mth141D(ecfieldelement14));
                            }
                        }
                    }
                    ecfieldelement7 = ecfieldelement9._mth141D(ecfieldelement13);
                    ecfieldelement7 = ecfieldelement7._mth02CE(ecfieldelement7);
                    ecfieldelement9 = ecfieldelement7._mth02CE(ecfieldelement7);
                    ecfieldelement7 = ecfieldelement2;
                    ecfieldelement2 = ecfieldelement9;
                }
                ecfieldelement9 = ecfieldelement7.FF4C()._mth02CF(ecfieldelement2._mth02CE(ecfieldelement2));
                ecfieldelement2 = ecfieldelement2._mth02CF(ecfieldelement9)._mth141D(ecfieldelement7);
                ecfieldelement7 = ecfieldelement11._mth02CE(ecfieldelement11);
                ecfieldelement7 = ecfieldelement7._mth02CE(ecfieldelement7);
                ecfieldelement11 = ecfieldelement2._mth02CF(ecfieldelement7._mth02CE(ecfieldelement7));
                ecfieldelement7 = ecfieldelement8._mth02CE(ecfieldelement8);
                ecfieldelement2 = ecfieldelement7;
                if (!flag1)
                {
                    ecfieldelement2 = ecfieldelement7._mth141D(ecfieldelement5);
                }
                flag1 = aHv;
                return new Fp(eccurve, ecfieldelement9, ecfieldelement11, new ECFieldElement[] {
                    ecfieldelement2
                }, flag1);

            case 4: // '\004'
                return _mth1D4C(true);
            }
            throw new IllegalStateException("unsupported coordinate system");
        }

        public final ECPoint _mth039A()
        {
            if (_mth021D())
            {
                return this;
            }
            ECFieldElement ecfieldelement = aIJ;
            if (ecfieldelement.isZero())
            {
                return this;
            }
            ECCurve eccurve = FF79();
            switch (eccurve.FB5E())
            {
            case 0: // '\0'
                ECFieldElement ecfieldelement1 = aII;
                ECFieldElement ecfieldelement3 = ecfieldelement._mth02CE(ecfieldelement);
                ECFieldElement ecfieldelement2 = ecfieldelement3.FF4C();
                ECFieldElement ecfieldelement4 = ecfieldelement1.FF4C();
                ecfieldelement4 = ecfieldelement4._mth02CE(ecfieldelement4)._mth02CE(ecfieldelement4)._mth02CE(FF79().FB46());
                ECFieldElement ecfieldelement5 = ecfieldelement4.FF4C();
                ecfieldelement5 = ecfieldelement1._mth02CE(ecfieldelement1)._mth02CE(ecfieldelement1)._mth141D(ecfieldelement2)._mth02CF(ecfieldelement5);
                if (ecfieldelement5.isZero())
                {
                    return FF79()._mth5B80();
                } else
                {
                    ecfieldelement3 = ecfieldelement5._mth141D(ecfieldelement3).FF4E();
                    ecfieldelement4 = ecfieldelement5._mth141D(ecfieldelement3)._mth141D(ecfieldelement4);
                    ecfieldelement2 = ecfieldelement2.FF4C()._mth141D(ecfieldelement3)._mth02CF(ecfieldelement4);
                    ecfieldelement3 = ecfieldelement2._mth02CF(ecfieldelement4)._mth141D(ecfieldelement4._mth02CE(ecfieldelement2))._mth02CE(ecfieldelement1);
                    return new Fp(eccurve, ecfieldelement3, ecfieldelement1._mth02CF(ecfieldelement3)._mth141D(ecfieldelement2)._mth02CF(ecfieldelement), aHv);
                }

            case 4: // '\004'
                return _mth1D4C(false)._mth141D(this);
            }
            return _mth038E()._mth141D(this);
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
            int i = eccurve.FB5E();
            Object obj = aII;
            ECFieldElement ecfieldelement = aIJ;
            ECFieldElement ecfieldelement1 = ecpoint.aII;
            ECFieldElement ecfieldelement2 = ecpoint.aIJ;
            switch (i)
            {
            case 0: // '\0'
                ecpoint = ecfieldelement1._mth02CF(((ECFieldElement) (obj)));
                ecfieldelement2 = ecfieldelement2._mth02CF(ecfieldelement);
                if (ecpoint.isZero())
                {
                    if (ecfieldelement2.isZero())
                    {
                        return _mth038E();
                    } else
                    {
                        return eccurve._mth5B80();
                    }
                } else
                {
                    ecpoint = ecfieldelement2._mth02BB(ecpoint);
                    ecfieldelement1 = ecpoint.FF4C()._mth02CF(((ECFieldElement) (obj)))._mth02CF(ecfieldelement1);
                    return new Fp(eccurve, ecfieldelement1, ecpoint._mth141D(((ECFieldElement) (obj))._mth02CF(ecfieldelement1))._mth02CF(ecfieldelement), aHv);
                }

            case 1: // '\001'
                ECFieldElement ecfieldelement3 = aIK[0];
                ECFieldElement ecfieldelement4 = ecpoint.aIK[0];
                boolean flag = ecfieldelement3.FF53();
                boolean flag2 = ecfieldelement4.FF53();
                if (!flag)
                {
                    ecfieldelement2 = ecfieldelement2._mth141D(ecfieldelement3);
                }
                if (!flag2)
                {
                    ecfieldelement = ecfieldelement._mth141D(ecfieldelement4);
                }
                ecfieldelement2 = ecfieldelement2._mth02CF(ecfieldelement);
                if (flag)
                {
                    ecpoint = ecfieldelement1;
                } else
                {
                    ecpoint = ecfieldelement1._mth141D(ecfieldelement3);
                }
                if (!flag2)
                {
                    obj = ((ECFieldElement) (obj))._mth141D(ecfieldelement4);
                }
                ecfieldelement1 = ecpoint._mth02CF(((ECFieldElement) (obj)));
                if (ecfieldelement1.isZero())
                {
                    if (ecfieldelement2.isZero())
                    {
                        return _mth038E();
                    } else
                    {
                        return eccurve._mth5B80();
                    }
                }
                if (flag)
                {
                    ecpoint = ecfieldelement4;
                } else
                if (flag2)
                {
                    ecpoint = ecfieldelement3;
                } else
                {
                    ecpoint = ecfieldelement3._mth141D(ecfieldelement4);
                }
                ecfieldelement4 = ecfieldelement1.FF4C();
                ecfieldelement3 = ecfieldelement4._mth141D(ecfieldelement1);
                ecfieldelement4 = ecfieldelement4._mth141D(((ECFieldElement) (obj)));
                ECFieldElement ecfieldelement8 = ecfieldelement2.FF4C()._mth141D(ecpoint)._mth02CF(ecfieldelement3)._mth02CF(ecfieldelement4._mth02CE(ecfieldelement4));
                obj = ecfieldelement1._mth141D(ecfieldelement8);
                ecfieldelement = ecfieldelement4._mth02CF(ecfieldelement8)._mth02CA(ecfieldelement2, ecfieldelement, ecfieldelement3);
                ecpoint = ecfieldelement3._mth141D(ecpoint);
                flag = aHv;
                return new Fp(eccurve, ((ECFieldElement) (obj)), ecfieldelement, new ECFieldElement[] {
                    ecpoint
                }, flag);

            case 2: // '\002'
            case 4: // '\004'
                ECFieldElement ecfieldelement13 = aIK[0];
                ECFieldElement ecfieldelement14 = ecpoint.aIK[0];
                boolean flag1 = ecfieldelement13.FF53();
                Object obj1 = null;
                if (!flag1 && ecfieldelement13.equals(ecfieldelement14))
                {
                    ecpoint = ((ECFieldElement) (obj))._mth02CF(ecfieldelement1);
                    ECFieldElement ecfieldelement5 = ecfieldelement._mth02CF(ecfieldelement2);
                    if (ecpoint.isZero())
                    {
                        if (ecfieldelement5.isZero())
                        {
                            return _mth038E();
                        } else
                        {
                            return eccurve._mth5B80();
                        }
                    }
                    ecfieldelement2 = ecpoint.FF4C();
                    ECFieldElement ecfieldelement9 = ((ECFieldElement) (obj))._mth141D(ecfieldelement2);
                    obj = ecfieldelement1._mth141D(ecfieldelement2);
                    ecfieldelement = ecfieldelement9._mth02CF(((ECFieldElement) (obj)))._mth141D(ecfieldelement);
                    obj = ecfieldelement5.FF4C()._mth02CF(ecfieldelement9)._mth02CF(((ECFieldElement) (obj)));
                    ecfieldelement1 = ecfieldelement9._mth02CF(((ECFieldElement) (obj)))._mth141D(ecfieldelement5)._mth02CF(ecfieldelement);
                    if (flag1)
                    {
                        ecfieldelement = ecfieldelement2;
                        ecfieldelement2 = ((ECFieldElement) (obj));
                    } else
                    {
                        ecpoint = ecpoint._mth141D(ecfieldelement13);
                        ecfieldelement2 = ((ECFieldElement) (obj));
                        ecfieldelement = obj1;
                    }
                } else
                {
                    if (flag1)
                    {
                        ecpoint = ecfieldelement2;
                    } else
                    {
                        ecpoint = ecfieldelement13.FF4C();
                        ecfieldelement1 = ecpoint._mth141D(ecfieldelement1);
                        ecpoint = ecpoint._mth141D(ecfieldelement13)._mth141D(ecfieldelement2);
                    }
                    boolean flag3 = ecfieldelement14.FF53();
                    if (flag3)
                    {
                        ecfieldelement2 = ecfieldelement;
                        ecfieldelement = ((ECFieldElement) (obj));
                        obj = ecfieldelement2;
                    } else
                    {
                        ECFieldElement ecfieldelement6 = ecfieldelement14.FF4C();
                        ecfieldelement2 = ecfieldelement6._mth141D(((ECFieldElement) (obj)));
                        obj = ecfieldelement6._mth141D(ecfieldelement14)._mth141D(ecfieldelement);
                        ecfieldelement = ecfieldelement2;
                    }
                    ECFieldElement ecfieldelement7 = ecfieldelement._mth02CF(ecfieldelement1);
                    ecpoint = ((ECFieldElement) (obj))._mth02CF(ecpoint);
                    if (ecfieldelement7.isZero())
                    {
                        if (ecpoint.isZero())
                        {
                            return _mth038E();
                        } else
                        {
                            return eccurve._mth5B80();
                        }
                    }
                    ECFieldElement ecfieldelement10 = ecfieldelement7.FF4C();
                    ecfieldelement1 = ecfieldelement10._mth141D(ecfieldelement7);
                    ecfieldelement = ecfieldelement10._mth141D(ecfieldelement);
                    ECFieldElement ecfieldelement11 = ecpoint.FF4C()._mth02CE(ecfieldelement1)._mth02CF(ecfieldelement._mth02CE(ecfieldelement));
                    ECFieldElement ecfieldelement12 = ecfieldelement._mth02CF(ecfieldelement11)._mth02CA(ecpoint, ecfieldelement1, ((ECFieldElement) (obj)));
                    obj = ecfieldelement7;
                    ecpoint = ((ECPoint) (obj));
                    if (!flag1)
                    {
                        ecpoint = ((ECFieldElement) (obj))._mth141D(ecfieldelement13);
                    }
                    obj = ecpoint;
                    if (!flag3)
                    {
                        obj = ecpoint._mth141D(ecfieldelement14);
                    }
                    ecpoint = ((ECPoint) (obj));
                    ecfieldelement1 = ecfieldelement12;
                    ecfieldelement2 = ecfieldelement11;
                    ecfieldelement = obj1;
                    if (obj == ecfieldelement7)
                    {
                        ecfieldelement = ecfieldelement10;
                        ecfieldelement2 = ecfieldelement11;
                        ecfieldelement1 = ecfieldelement12;
                        ecpoint = ((ECPoint) (obj));
                    }
                }
                if (i == 4)
                {
                    ecfieldelement = _mth02CE(ecpoint, ecfieldelement);
                    ECFieldElement aecfieldelement[] = new ECFieldElement[2];
                    aecfieldelement[0] = ecpoint;
                    aecfieldelement[1] = ecfieldelement;
                    ecpoint = aecfieldelement;
                } else
                {
                    ECFieldElement aecfieldelement1[] = new ECFieldElement[1];
                    aecfieldelement1[0] = ecpoint;
                    ecpoint = aecfieldelement1;
                }
                return new Fp(eccurve, ecfieldelement2, ecfieldelement1, ecpoint, aHv);
            }
            throw new IllegalStateException("unsupported coordinate system");
        }

        public final ECFieldElement _mth1425(int i)
        {
            if (i == 1 && 4 == FF81())
            {
                ECFieldElement ecfieldelement1 = aIK[1];
                ECFieldElement ecfieldelement = ecfieldelement1;
                if (ecfieldelement1 == null)
                {
                    ECFieldElement aecfieldelement[] = aIK;
                    ecfieldelement = _mth02CE(aIK[0], null);
                    aecfieldelement[1] = ecfieldelement;
                }
                return ecfieldelement;
            } else
            {
                return super._mth1425(i);
            }
        }

        public final ECPoint _mth1483(int i)
        {
            if (i < 0)
            {
                throw new IllegalArgumentException("'e' cannot be negative");
            }
            if (i == 0 || _mth021D())
            {
                return this;
            }
            if (i == 1)
            {
                return _mth038E();
            }
            ECCurve eccurve = FF79();
            Object obj3 = aIJ;
            if (((ECFieldElement) (obj3)).isZero())
            {
                return eccurve._mth5B80();
            }
            int k = eccurve.FB5E();
            ECFieldElement ecfieldelement6 = eccurve.FB46();
            ECFieldElement ecfieldelement4 = aII;
            ECFieldElement ecfieldelement3;
            if (aIK.length <= 0)
            {
                ecfieldelement3 = eccurve._mth02BB(ECConstants.ONE);
            } else
            {
                ecfieldelement3 = aIK[0];
            }
            Object obj1 = obj3;
            Object obj = ecfieldelement6;
            Object obj2 = ecfieldelement4;
            if (!ecfieldelement3.FF53())
            {
                obj1 = obj3;
                obj = ecfieldelement6;
                obj2 = ecfieldelement4;
                switch (k)
                {
                default:
                    obj1 = obj3;
                    obj = ecfieldelement6;
                    obj2 = ecfieldelement4;
                    break;

                case 3: // '\003'
                    break;

                case 1: // '\001'
                    obj = ecfieldelement3.FF4C();
                    obj2 = ecfieldelement4._mth141D(ecfieldelement3);
                    obj1 = ((ECFieldElement) (obj3))._mth141D(((ECFieldElement) (obj)));
                    obj = _mth02CE(ecfieldelement3, ((ECFieldElement) (obj)));
                    break;

                case 2: // '\002'
                    obj = _mth02CE(ecfieldelement3, null);
                    obj1 = obj3;
                    obj2 = ecfieldelement4;
                    break;

                case 4: // '\004'
                    obj1 = aIK[1];
                    obj = obj1;
                    if (obj1 == null)
                    {
                        obj1 = aIK;
                        obj = _mth02CE(aIK[0], null);
                        obj1[1] = obj;
                    }
                    obj2 = ecfieldelement4;
                    obj1 = obj3;
                    break;
                }
            }
            int j = 0;
            obj3 = obj2;
            obj2 = obj;
            while (j < i) 
            {
                if (((ECFieldElement) (obj1)).isZero())
                {
                    return eccurve._mth5B80();
                }
                ECFieldElement ecfieldelement = ((ECFieldElement) (obj3)).FF4C();
                ECFieldElement ecfieldelement7 = ecfieldelement._mth02CE(ecfieldelement)._mth02CE(ecfieldelement);
                ECFieldElement ecfieldelement5 = ((ECFieldElement) (obj1))._mth02CE(((ECFieldElement) (obj1)));
                ecfieldelement = ecfieldelement5._mth141D(((ECFieldElement) (obj1)));
                obj1 = ((ECFieldElement) (obj3))._mth141D(ecfieldelement);
                obj1 = ((ECFieldElement) (obj1))._mth02CE(((ECFieldElement) (obj1)));
                ecfieldelement = ecfieldelement.FF4C();
                ECFieldElement ecfieldelement8 = ecfieldelement._mth02CE(ecfieldelement);
                obj3 = obj2;
                ecfieldelement = ecfieldelement7;
                if (!((ECFieldElement) (obj2)).isZero())
                {
                    ecfieldelement = ecfieldelement7._mth02CE(((ECFieldElement) (obj2)));
                    obj2 = ecfieldelement8._mth141D(((ECFieldElement) (obj2)));
                    obj3 = ((ECFieldElement) (obj2))._mth02CE(((ECFieldElement) (obj2)));
                }
                ecfieldelement7 = ecfieldelement.FF4C()._mth02CF(((ECFieldElement) (obj1))._mth02CE(((ECFieldElement) (obj1))));
                obj1 = ecfieldelement._mth141D(((ECFieldElement) (obj1))._mth02CF(ecfieldelement7))._mth02CF(ecfieldelement8);
                if (ecfieldelement3.FF53())
                {
                    ecfieldelement = ecfieldelement5;
                } else
                {
                    ecfieldelement = ecfieldelement5._mth141D(ecfieldelement3);
                }
                j++;
                obj2 = obj3;
                obj3 = ecfieldelement7;
                ecfieldelement3 = ecfieldelement;
            }
            switch (k)
            {
            case 0: // '\0'
                ecfieldelement3 = ecfieldelement3.FF4E();
                ECFieldElement ecfieldelement1 = ecfieldelement3.FF4C();
                ecfieldelement3 = ecfieldelement1._mth141D(ecfieldelement3);
                return new Fp(eccurve, ((ECFieldElement) (obj3))._mth141D(ecfieldelement1), ((ECFieldElement) (obj1))._mth141D(ecfieldelement3), aHv);

            case 1: // '\001'
                ECFieldElement ecfieldelement2 = ((ECFieldElement) (obj3))._mth141D(ecfieldelement3);
                ecfieldelement3 = ecfieldelement3._mth141D(ecfieldelement3.FF4C());
                boolean flag = aHv;
                return new Fp(eccurve, ecfieldelement2, ((ECFieldElement) (obj1)), new ECFieldElement[] {
                    ecfieldelement3
                }, flag);

            case 2: // '\002'
                boolean flag1 = aHv;
                return new Fp(eccurve, ((ECFieldElement) (obj3)), ((ECFieldElement) (obj1)), new ECFieldElement[] {
                    ecfieldelement3
                }, flag1);

            case 4: // '\004'
                boolean flag2 = aHv;
                return new Fp(eccurve, ((ECFieldElement) (obj3)), ((ECFieldElement) (obj1)), new ECFieldElement[] {
                    ecfieldelement3, obj2
                }, flag2);
            }
            throw new IllegalStateException("unsupported coordinate system");
        }

        protected final ECPoint FF7D()
        {
            return new Fp(null, FF8A(), FF93());
        }

        public Fp(ECCurve.Fp fp, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
        {
            this(((ECCurve) (fp)), ecfieldelement, ecfieldelement1, false);
        }

        public Fp(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
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

        Fp(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
        {
            super(eccurve, ecfieldelement, ecfieldelement1, aecfieldelement);
            aHv = flag;
        }
    }


    private static ECFieldElement aIH[] = new ECFieldElement[0];
    public boolean aHv;
    public ECFieldElement aII;
    public ECFieldElement aIJ;
    public ECFieldElement aIK[];
    protected Hashtable aIL;
    public ECCurve alm;

    protected ECPoint(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
    {
        int i;
        if (eccurve == null)
        {
            i = 0;
        } else
        {
            i = eccurve.FB5E();
        }
        ECFieldElement aecfieldelement[];
        switch (i)
        {
        case 0: // '\0'
        case 5: // '\005'
            aecfieldelement = aIH;
            break;

        default:
            ECFieldElement ecfieldelement2 = eccurve._mth02BB(ECConstants.ONE);
            switch (i)
            {
            case 1: // '\001'
            case 2: // '\002'
            case 6: // '\006'
                aecfieldelement = new ECFieldElement[1];
                aecfieldelement[0] = ecfieldelement2;
                break;

            case 3: // '\003'
                aecfieldelement = new ECFieldElement[3];
                aecfieldelement[0] = ecfieldelement2;
                aecfieldelement[1] = ecfieldelement2;
                aecfieldelement[2] = ecfieldelement2;
                break;

            case 4: // '\004'
                aecfieldelement = new ECFieldElement[2];
                aecfieldelement[0] = ecfieldelement2;
                aecfieldelement[1] = eccurve.FB46();
                break;

            case 5: // '\005'
            default:
                throw new IllegalArgumentException("unknown coordinate system");
            }
            break;
        }
        this(eccurve, ecfieldelement, ecfieldelement1, aecfieldelement);
    }

    protected ECPoint(ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[])
    {
        aIL = null;
        alm = eccurve;
        aII = ecfieldelement;
        aIJ = ecfieldelement1;
        aIK = aecfieldelement;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof ECPoint))
        {
            return false;
        } else
        {
            return _mth02CF((ECPoint)obj);
        }
    }

    public final byte[] getEncoded()
    {
        return _mth15AE(aHv);
    }

    public int hashCode()
    {
        ECCurve eccurve = alm;
        int i;
        if (eccurve == null)
        {
            i = 0;
        } else
        {
            i = ~eccurve.hashCode();
        }
        int j = i;
        if (!_mth021D())
        {
            ECPoint ecpoint = _mth0188();
            j = i ^ ecpoint.aII.hashCode() * 17 ^ ecpoint._mth0141().hashCode() * 257;
        }
        return j;
    }

    public final boolean isValid()
    {
        if (_mth021D())
        {
            return true;
        }
        if (alm != null)
        {
            if (!FF77())
            {
                return false;
            }
            if (!FF73())
            {
                return false;
            }
        }
        return true;
    }

    public String toString()
    {
        if (_mth021D())
        {
            return "INF";
        }
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append('(');
        stringbuffer.append(aII);
        stringbuffer.append(',');
        stringbuffer.append(aIJ);
        for (int i = 0; i < aIK.length; i++)
        {
            stringbuffer.append(',');
            stringbuffer.append(aIK[i]);
        }

        stringbuffer.append(')');
        return stringbuffer.toString();
    }

    public final ECFieldElement _mth0134()
    {
        return aII;
    }

    public ECFieldElement _mth0141()
    {
        return aIJ;
    }

    protected final ECFieldElement _mth014D()
    {
        return aII;
    }

    protected final ECFieldElement _mth0163()
    {
        return aIJ;
    }

    protected final ECFieldElement[] _mth0164()
    {
        return aIK;
    }

    public final boolean _mth0186()
    {
        int i;
        if (alm == null)
        {
            i = 0;
        } else
        {
            i = alm.FB5E();
        }
        return i == 0 || i == 5 || _mth021D() || aIK[0].FF53();
    }

    public final ECPoint _mth0188()
    {
        if (_mth021D())
        {
            return this;
        }
        int i;
        if (alm == null)
        {
            i = 0;
        } else
        {
            i = alm.FB5E();
        }
        switch (i)
        {
        case 0: // '\0'
        case 5: // '\005'
            return this;
        }
        ECFieldElement ecfieldelement = _mth1425(0);
        if (ecfieldelement.FF53())
        {
            return this;
        } else
        {
            return _mth02BC(ecfieldelement.FF4E());
        }
    }

    public final boolean _mth021D()
    {
        return aII == null || aIJ == null || aIK.length > 0 && aIK[0].isZero();
    }

    protected abstract boolean _mth0232();

    public abstract ECPoint _mth029C();

    public ECPoint _mth02BB(ECPoint ecpoint)
    {
        return _mth038E()._mth141D(ecpoint);
    }

    final ECPoint _mth02BC(ECFieldElement ecfieldelement)
    {
        int i;
        if (alm == null)
        {
            i = 0;
        } else
        {
            i = alm.FB5E();
        }
        switch (i)
        {
        case 1: // '\001'
        case 6: // '\006'
            return alm._mth02CA(aII._mth141D(ecfieldelement), aIJ._mth141D(ecfieldelement), aHv);

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            ECFieldElement ecfieldelement1 = ecfieldelement.FF4C();
            ecfieldelement = ecfieldelement1._mth141D(ecfieldelement);
            return alm._mth02CA(aII._mth141D(ecfieldelement1), aIJ._mth141D(ecfieldelement), aHv);
        }
        throw new IllegalStateException("not a projective coordinate system");
    }

    public ECPoint _mth02BD(ECFieldElement ecfieldelement)
    {
        if (_mth021D())
        {
            return this;
        } else
        {
            return alm._mth02CA(aII._mth141D(ecfieldelement), aIJ, aIK, aHv);
        }
    }

    public final boolean _mth02CF(ECPoint ecpoint)
    {
        ECPoint ecpoint1;
        Object obj;
label0:
        {
            if (ecpoint == null)
            {
                return false;
            }
            ECCurve eccurve = alm;
            ECCurve eccurve1 = ecpoint.alm;
            boolean flag;
            if (eccurve == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            boolean flag1;
            if (eccurve1 == null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            boolean flag2 = _mth021D();
            boolean flag3 = ecpoint._mth021D();
            if (flag2 || flag3)
            {
                return flag2 && flag3 && (flag || flag1 || eccurve._mth02BB(eccurve1));
            }
            ECPoint ecpoint2 = this;
            if (flag)
            {
                ecpoint1 = ecpoint2;
                obj = ecpoint;
                if (flag1)
                {
                    break label0;
                }
            }
            if (flag)
            {
                obj = ecpoint._mth0188();
                ecpoint1 = ecpoint2;
            } else
            if (flag1)
            {
                ecpoint1 = ecpoint2._mth0188();
                obj = ecpoint;
            } else
            {
                if (!eccurve._mth02BB(eccurve1))
                {
                    return false;
                }
                obj = new ECPoint[2];
                obj[0] = this;
                obj[1] = eccurve._mth02CE(ecpoint);
                eccurve._mth02CA(((ECPoint []) (obj)));
                ecpoint1 = obj[0];
                obj = obj[1];
            }
        }
        return ecpoint1.aII.equals(((ECPoint) (obj)).aII) && ecpoint1._mth0141().equals(((ECPoint) (obj))._mth0141());
    }

    public ECPoint _mth037A(ECFieldElement ecfieldelement)
    {
        if (_mth021D())
        {
            return this;
        } else
        {
            return alm._mth02CA(aII, aIJ._mth141D(ecfieldelement), aIK, aHv);
        }
    }

    public abstract ECPoint _mth038E();

    public ECPoint _mth039A()
    {
        return _mth02BB(this);
    }

    public abstract ECPoint _mth141D(ECPoint ecpoint);

    public ECFieldElement _mth1425(int i)
    {
        if (i < 0 || i >= aIK.length)
        {
            return null;
        } else
        {
            return aIK[i];
        }
    }

    public ECPoint _mth1483(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
        ECPoint ecpoint = this;
        do
        {
            i--;
            if (i >= 0)
            {
                ecpoint = ecpoint._mth038E();
            } else
            {
                return ecpoint;
            }
        } while (true);
    }

    public final byte[] _mth15AE(boolean flag)
    {
        if (_mth021D())
        {
            return new byte[1];
        }
        Object obj = _mth0188();
        ECFieldElement ecfieldelement = ((ECPoint) (obj)).aII;
        byte abyte0[] = BigIntegers._mth02BB((ecfieldelement.getFieldSize() + 7) / 8, ecfieldelement.toBigInteger());
        if (flag)
        {
            byte abyte2[] = new byte[abyte0.length + 1];
            int i;
            if (((ECPoint) (obj))._mth0232())
            {
                i = 3;
            } else
            {
                i = 2;
            }
            abyte2[0] = (byte)i;
            System.arraycopy(abyte0, 0, abyte2, 1, abyte0.length);
            return abyte2;
        } else
        {
            obj = ((ECPoint) (obj))._mth0141();
            byte abyte1[] = BigIntegers._mth02BB((((ECFieldElement) (obj)).getFieldSize() + 7) / 8, ((ECFieldElement) (obj)).toBigInteger());
            byte abyte3[] = new byte[abyte0.length + abyte1.length + 1];
            abyte3[0] = 4;
            System.arraycopy(abyte0, 0, abyte3, 1, abyte0.length);
            System.arraycopy(abyte1, 0, abyte3, abyte0.length + 1, abyte1.length);
            return abyte3;
        }
    }

    protected final boolean FF73()
    {
        BigInteger biginteger = alm.FB52();
        return biginteger == null || biginteger.equals(ECConstants.ONE) || !ECAlgorithms._mth02CE(this, biginteger)._mth021D();
    }

    protected abstract boolean FF77();

    public final ECPoint FF78()
    {
        return _mth0188().FF7D();
    }

    public final ECCurve FF79()
    {
        return alm;
    }

    public abstract ECPoint FF7D();

    protected final int FF81()
    {
        if (alm == null)
        {
            return 0;
        } else
        {
            return alm.FB5E();
        }
    }

    public final ECFieldElement FF8A()
    {
        if (!_mth0186())
        {
            throw new IllegalStateException("point not in normal form");
        } else
        {
            return aII;
        }
    }

    public final ECFieldElement FF93()
    {
        if (!_mth0186())
        {
            throw new IllegalStateException("point not in normal form");
        } else
        {
            return _mth0141();
        }
    }

}
