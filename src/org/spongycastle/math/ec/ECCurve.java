// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Random;
import org.spongycastle.math.ec.endo.ECEndomorphism;
import org.spongycastle.math.ec.endo.GLVEndomorphism;
import org.spongycastle.math.ec.endo.GLVTypeBEndomorphism;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.FiniteFields;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Integers;

// Referenced classes of package org.spongycastle.math.ec:
//            ECPoint, ECFieldElement, PreCompInfo, ECAlgorithms, 
//            GLVMultiplier, WNafL2RMultiplier, ECMultiplier, ECConstants, 
//            WTauNafMultiplier, Tnaf

public abstract class ECCurve
{
    public static abstract class AbstractF2m extends ECCurve
    {

        protected AbstractF2m(int i, int j, int k, int l)
        {
            if (j == 0)
            {
                throw new IllegalArgumentException("k1 must be > 0");
            }
            org.spongycastle.math.field.GenericPolynomialExtensionField genericpolynomialextensionfield;
            if (k == 0)
            {
                if (l != 0)
                {
                    throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
                }
                genericpolynomialextensionfield = FiniteFields._mth1FBE(new int[] {
                    0, j, i
                });
            } else
            {
                if (k <= j)
                {
                    throw new IllegalArgumentException("k2 must be > k1");
                }
                if (l <= k)
                {
                    throw new IllegalArgumentException("k3 must be > k2");
                }
                genericpolynomialextensionfield = FiniteFields._mth1FBE(new int[] {
                    0, j, k, l, i
                });
            }
            super(genericpolynomialextensionfield);
        }
    }

    public static abstract class AbstractFp extends ECCurve
    {

        protected final ECPoint _mth02CB(int i, BigInteger biginteger)
        {
            ECFieldElement ecfieldelement1 = _mth02BB(biginteger);
            ECFieldElement ecfieldelement = ecfieldelement1.FF4C()._mth02CE(aIr)._mth141D(ecfieldelement1)._mth02CE(aIs).FF52();
            if (ecfieldelement == null)
            {
                throw new IllegalArgumentException("Invalid point compression");
            }
            boolean flag1 = ecfieldelement.FF66();
            boolean flag;
            if (i == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            biginteger = ecfieldelement;
            if (flag1 != flag)
            {
                biginteger = ecfieldelement.FF29();
            }
            return _mth02CA(ecfieldelement1, biginteger, true);
        }

        public AbstractFp(BigInteger biginteger)
        {
            super(FiniteFields._mth02C8(biginteger));
        }
    }

    public class Config
    {

        private int aIv;
        private ECEndomorphism aIw;
        private ECMultiplier aIx;
        private ECCurve aIy;

        public final Config _mth02CA(GLVTypeBEndomorphism glvtypebendomorphism)
        {
            aIw = glvtypebendomorphism;
            return this;
        }

        public final Config _mth0E32(int i)
        {
            aIv = i;
            return this;
        }

        public final ECCurve FEA7()
        {
            if (!aIy._mth071D(aIv))
            {
                throw new IllegalStateException("unsupported coordinate system");
            }
            ECCurve eccurve = aIy._mth30FE();
            if (eccurve == aIy)
            {
                throw new IllegalStateException("implementation returned current curve");
            } else
            {
                eccurve.aIv = aIv;
                eccurve.aIw = aIw;
                eccurve.aIx = aIx;
                return eccurve;
            }
        }

        Config(int i, ECEndomorphism ecendomorphism, ECMultiplier ecmultiplier)
        {
            aIy = ECCurve.this;
            super();
            aIv = i;
            aIw = ecendomorphism;
            aIx = ecmultiplier;
        }
    }

    public static class F2m extends AbstractF2m
    {

        private byte aIA;
        private BigInteger aIB[];
        private ECPoint.F2m aIz;
        public int afJ;
        public int avj;
        public int avk;
        public int avl;

        public final int getFieldSize()
        {
            return afJ;
        }

        public final ECFieldElement _mth02BB(BigInteger biginteger)
        {
            return new ECFieldElement.F2m(afJ, avj, avk, avl, biginteger);
        }

        public final ECPoint _mth02CA(BigInteger biginteger, BigInteger biginteger1, boolean flag)
        {
            ECFieldElement.F2m f2m = new ECFieldElement.F2m(afJ, avj, avk, avl, biginteger);
            biginteger1 = new ECFieldElement.F2m(afJ, avj, avk, avl, biginteger1);
            switch (FB5E())
            {
            default:
                biginteger = biginteger1;
                break;

            case 5: // '\005'
            case 6: // '\006'
                if (f2m.isZero())
                {
                    biginteger = biginteger1;
                    if (!biginteger1.FF4C().equals(FB4C()))
                    {
                        throw new IllegalArgumentException();
                    }
                } else
                {
                    biginteger = biginteger1._mth02BB(f2m)._mth02CE(f2m);
                }
                break;
            }
            return new ECPoint.F2m(this, f2m, biginteger, flag);
        }

        protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
        {
            return new ECPoint.F2m(this, ecfieldelement, ecfieldelement1, flag);
        }

        protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
        {
            return new ECPoint.F2m(this, ecfieldelement, ecfieldelement1, aecfieldelement, flag);
        }

        protected final ECPoint _mth02CB(int i, BigInteger biginteger)
        {
            ECFieldElement.F2m f2m1 = new ECFieldElement.F2m(afJ, avj, avk, avl, biginteger);
            Object obj2 = null;
            Object obj;
            if (f2m1.isZero())
            {
                obj = aIs.FF52();
            } else
            {
                obj = f2m1.FF4C().FF4E()._mth141D(aIs)._mth02CE(aIr)._mth02CE(f2m1);
                if (((ECFieldElement) (obj)).isZero())
                {
                    biginteger = ((BigInteger) (obj));
                } else
                {
                    biginteger = ECConstants.ZERO;
                    ECFieldElement.F2m f2m = new ECFieldElement.F2m(afJ, avj, avk, avl, biginteger);
                    Random random = new Random();
                    do
                    {
                        biginteger = new BigInteger(afJ, random);
                        ECFieldElement.F2m f2m2 = new ECFieldElement.F2m(afJ, avj, avk, avl, biginteger);
                        biginteger = f2m;
                        Object obj1 = obj;
                        for (int j = 1; j <= afJ - 1; j++)
                        {
                            obj1 = ((ECFieldElement) (obj1)).FF4C();
                            biginteger = biginteger.FF4C()._mth02CE(((ECFieldElement) (obj1))._mth141D(f2m2));
                            obj1 = ((ECFieldElement) (obj1))._mth02CE(((ECFieldElement) (obj)));
                        }

                        if (((ECFieldElement) (obj1)).isZero())
                        {
                            continue;
                        }
                        biginteger = null;
                        break;
                    } while (biginteger.FF4C()._mth02CE(biginteger).isZero());
                }
                obj = obj2;
                if (biginteger != null)
                {
                    boolean flag1 = biginteger.FF66();
                    boolean flag;
                    if (i == 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    obj = biginteger;
                    if (flag1 != flag)
                    {
                        obj = biginteger.FF26();
                    }
                    switch (FB5E())
                    {
                    case 5: // '\005'
                    case 6: // '\006'
                        obj = ((ECFieldElement) (obj))._mth02CE(f2m1);
                        break;

                    default:
                        obj = ((ECFieldElement) (obj))._mth141D(f2m1);
                        break;
                    }
                }
            }
            if (obj == null)
            {
                throw new IllegalArgumentException("Invalid point compression");
            } else
            {
                return new ECPoint.F2m(this, f2m1, ((ECFieldElement) (obj)), true);
            }
        }

        public final boolean _mth071D(int i)
        {
            switch (i)
            {
            case 0: // '\0'
            case 1: // '\001'
            case 6: // '\006'
                return true;
            }
            return false;
        }

        protected final ECCurve _mth30FE()
        {
            return new F2m(afJ, avj, avk, avl, aIr, aIs, aIt, aIu);
        }

        protected final ECMultiplier _mth4E40()
        {
            if (FECB())
            {
                return new WTauNafMultiplier();
            } else
            {
                return super._mth4E40();
            }
        }

        public final ECPoint _mth5B80()
        {
            return aIz;
        }

        public final boolean FECB()
        {
            return aIt != null && aIu != null && aIs.FF53() && (aIr.isZero() || aIr.FF53());
        }

        final byte FECC()
        {
            this;
            JVM INSTR monitorenter ;
            byte byte0;
            if (aIA == 0)
            {
                aIA = Tnaf._mth02CA(this);
            }
            byte0 = aIA;
            this;
            JVM INSTR monitorexit ;
            return byte0;
            Exception exception;
            exception;
            throw exception;
        }

        final BigInteger[] FEE2()
        {
            this;
            JVM INSTR monitorenter ;
            BigInteger abiginteger[];
            if (aIB == null)
            {
                aIB = Tnaf._mth02CB(this);
            }
            abiginteger = aIB;
            this;
            JVM INSTR monitorexit ;
            return abiginteger;
            Exception exception;
            exception;
            throw exception;
        }

        public F2m(int i, int j, int k, int l, BigInteger biginteger, BigInteger biginteger1)
        {
            this(i, j, k, l, biginteger, biginteger1, null, null);
        }

        public F2m(int i, int j, int k, int l, BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2, 
                BigInteger biginteger3)
        {
            super(i, j, k, l);
            aIA = 0;
            aIB = null;
            afJ = i;
            avj = j;
            avk = k;
            avl = l;
            aIt = biginteger2;
            aIu = biginteger3;
            aIz = new ECPoint.F2m(this, null, null);
            aIr = new ECFieldElement.F2m(afJ, avj, avk, avl, biginteger);
            aIs = new ECFieldElement.F2m(afJ, avj, avk, avl, biginteger1);
            aIv = 6;
        }

        private F2m(int i, int j, int k, int l, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, BigInteger biginteger, 
                BigInteger biginteger1)
        {
            super(i, j, k, l);
            aIA = 0;
            aIB = null;
            afJ = i;
            avj = j;
            avk = k;
            avl = l;
            aIt = biginteger;
            aIu = biginteger1;
            aIz = new ECPoint.F2m(this, null, null);
            aIr = ecfieldelement;
            aIs = ecfieldelement1;
            aIv = 6;
        }

        public F2m(int i, int j, BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2, BigInteger biginteger3)
        {
            this(i, j, 0, 0, biginteger, biginteger1, biginteger2, biginteger3);
        }
    }

    public static class Fp extends AbstractFp
    {

        private BigInteger aIC;
        private ECPoint.Fp aID;
        private BigInteger amN;

        public final int getFieldSize()
        {
            return amN.bitLength();
        }

        public final ECFieldElement _mth02BB(BigInteger biginteger)
        {
            return new ECFieldElement.Fp(amN, aIC, biginteger);
        }

        protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag)
        {
            return new ECPoint.Fp(this, ecfieldelement, ecfieldelement1, flag);
        }

        protected final ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag)
        {
            return new ECPoint.Fp(this, ecfieldelement, ecfieldelement1, aecfieldelement, flag);
        }

        public final ECPoint _mth02CE(ECPoint ecpoint)
        {
            if (this != ecpoint.FF79() && FB5E() == 2 && !ecpoint._mth021D())
            {
                switch (ecpoint.FF79().FB5E())
                {
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                    Object obj = ecpoint.aII.toBigInteger();
                    obj = new ECFieldElement.Fp(amN, aIC, ((BigInteger) (obj)));
                    Object obj1 = ecpoint.aIJ.toBigInteger();
                    obj1 = new ECFieldElement.Fp(amN, aIC, ((BigInteger) (obj1)));
                    Object obj2 = ecpoint.aIK[0].toBigInteger();
                    obj2 = new ECFieldElement.Fp(amN, aIC, ((BigInteger) (obj2)));
                    boolean flag = ecpoint.aHv;
                    return new ECPoint.Fp(this, ((ECFieldElement) (obj)), ((ECFieldElement) (obj1)), new ECFieldElement[] {
                        obj2
                    }, flag);
                }
            }
            return super._mth02CE(ecpoint);
        }

        public final boolean _mth071D(int i)
        {
            switch (i)
            {
            case 0: // '\0'
            case 1: // '\001'
            case 2: // '\002'
            case 4: // '\004'
                return true;
            }
            return false;
        }

        protected final ECCurve _mth30FE()
        {
            return new Fp(amN, aIC, aIr, aIs, aIt, aIu);
        }

        public final ECPoint _mth5B80()
        {
            return aID;
        }

        public Fp(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2)
        {
            this(biginteger, biginteger1, biginteger2, null, null);
        }

        public Fp(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2, BigInteger biginteger3, BigInteger biginteger4)
        {
            super(biginteger);
            amN = biginteger;
            aIC = ECFieldElement.Fp._mth02BC(biginteger);
            aID = new ECPoint.Fp(this, null, null);
            aIr = new ECFieldElement.Fp(amN, aIC, biginteger1);
            aIs = new ECFieldElement.Fp(amN, aIC, biginteger2);
            aIt = biginteger3;
            aIu = biginteger4;
            aIv = 4;
        }

        private Fp(BigInteger biginteger, BigInteger biginteger1, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, BigInteger biginteger2, BigInteger biginteger3)
        {
            super(biginteger);
            amN = biginteger;
            aIC = biginteger1;
            aID = new ECPoint.Fp(this, null, null);
            aIr = ecfieldelement;
            aIs = ecfieldelement1;
            aIt = biginteger2;
            aIu = biginteger3;
            aIv = 4;
        }
    }


    private FiniteField aIq;
    public ECFieldElement aIr;
    public ECFieldElement aIs;
    public BigInteger aIt;
    public BigInteger aIu;
    public int aIv;
    protected ECEndomorphism aIw;
    protected ECMultiplier aIx;

    protected ECCurve(FiniteField finitefield)
    {
        aIv = 0;
        aIw = null;
        aIx = null;
        aIq = finitefield;
    }

    private ECPoint _mth02CE(BigInteger biginteger, BigInteger biginteger1)
    {
        biginteger = _mth02CA(biginteger, biginteger1, false);
        if (!biginteger.isValid())
        {
            throw new IllegalArgumentException("Invalid point coordinates");
        } else
        {
            return biginteger;
        }
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof ECCurve) && _mth02BB((ECCurve)obj);
    }

    public abstract int getFieldSize();

    public final BigInteger getOrder()
    {
        return aIt;
    }

    public int hashCode()
    {
        return aIq.hashCode() ^ Integers.rotateLeft(aIr.toBigInteger().hashCode(), 8) ^ Integers.rotateLeft(aIs.toBigInteger().hashCode(), 16);
    }

    public final ECPoint _mth01C3(byte abyte0[])
    {
        int i = (getFieldSize() + 7) / 8;
        byte byte0 = abyte0[0];
        switch (byte0)
        {
        case 0: // '\0'
            if (abyte0.length != 1)
            {
                throw new IllegalArgumentException("Incorrect length for infinity encoding");
            }
            abyte0 = _mth5B80();
            break;

        case 2: // '\002'
        case 3: // '\003'
            if (abyte0.length != i + 1)
            {
                throw new IllegalArgumentException("Incorrect length for compressed encoding");
            }
            ECPoint ecpoint = _mth02CB(byte0 & 1, BigIntegers.FE7A(abyte0, 1, i));
            abyte0 = ecpoint;
            if (!ecpoint.FF73())
            {
                throw new IllegalArgumentException("Invalid point");
            }
            break;

        case 4: // '\004'
            if (abyte0.length != i * 2 + 1)
            {
                throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
            }
            abyte0 = _mth02CE(BigIntegers.FE7A(abyte0, 1, i), BigIntegers.FE7A(abyte0, i + 1, i));
            break;

        case 6: // '\006'
        case 7: // '\007'
            if (abyte0.length != i * 2 + 1)
            {
                throw new IllegalArgumentException("Incorrect length for hybrid encoding");
            }
            BigInteger biginteger = BigIntegers.FE7A(abyte0, 1, i);
            abyte0 = BigIntegers.FE7A(abyte0, i + 1, i);
            boolean flag1 = abyte0.testBit(0);
            boolean flag;
            if (byte0 == 7)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag1 != flag)
            {
                throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
            }
            abyte0 = _mth02CE(biginteger, abyte0);
            break;

        case 1: // '\001'
        case 5: // '\005'
        default:
            throw new IllegalArgumentException((new StringBuilder("Invalid point encoding 0x")).append(Integer.toString(byte0, 16)).toString());
        }
        if (byte0 != 0 && abyte0._mth021D())
        {
            throw new IllegalArgumentException("Invalid infinity encoding");
        } else
        {
            return abyte0;
        }
    }

    public abstract ECFieldElement _mth02BB(BigInteger biginteger);

    public final boolean _mth02BB(ECCurve eccurve)
    {
        return this == eccurve || eccurve != null && aIq.equals(eccurve.aIq) && aIr.toBigInteger().equals(eccurve.aIr.toBigInteger()) && aIs.toBigInteger().equals(eccurve.aIs.toBigInteger());
    }

    public ECPoint _mth02CA(BigInteger biginteger, BigInteger biginteger1, boolean flag)
    {
        return _mth02CA(_mth02BB(biginteger), _mth02BB(biginteger1), flag);
    }

    public abstract ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, boolean flag);

    public abstract ECPoint _mth02CA(ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[], boolean flag);

    public final PreCompInfo _mth02CA(ECPoint ecpoint, String s)
    {
        if (ecpoint == null || this != ecpoint.FF79())
        {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
        ecpoint;
        JVM INSTR monitorenter ;
        Hashtable hashtable = ecpoint.aIL;
        if (hashtable == null)
        {
            s = null;
            break MISSING_BLOCK_LABEL_47;
        }
        s = (PreCompInfo)hashtable.get(s);
        ecpoint;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public final void _mth02CA(ECPoint ecpoint, String s, PreCompInfo precompinfo)
    {
        if (ecpoint == null || this != ecpoint.FF79())
        {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
        ecpoint;
        JVM INSTR monitorenter ;
        Hashtable hashtable1 = ecpoint.aIL;
        Hashtable hashtable;
        hashtable = hashtable1;
        if (hashtable1 != null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        hashtable = new Hashtable(4);
        ecpoint.aIL = hashtable;
        hashtable.put(s, precompinfo);
        ecpoint;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final void _mth02CA(ECPoint aecpoint[])
    {
        if (aecpoint == null)
        {
            throw new IllegalArgumentException("'points' cannot be null");
        }
        for (int i = 0; i < aecpoint.length; i++)
        {
            ECPoint ecpoint = aecpoint[i];
            if (ecpoint != null && this != ecpoint.FF79())
            {
                throw new IllegalArgumentException("'points' entries must be null or on this curve");
            }
        }

        if (aIv == 0)
        {
            return;
        }
        ECFieldElement aecfieldelement[] = new ECFieldElement[aecpoint.length];
        int ai[] = new int[aecpoint.length];
        int j = 0;
        for (int k = 0; k < aecpoint.length;)
        {
            ECPoint ecpoint1 = aecpoint[k];
            int i1 = j;
            if (ecpoint1 != null)
            {
                i1 = j;
                if (!ecpoint1._mth0186())
                {
                    aecfieldelement[j] = ecpoint1._mth1425(0);
                    i1 = j + 1;
                    ai[j] = k;
                }
            }
            k++;
            j = i1;
        }

        if (j == 0)
        {
            return;
        }
        ECAlgorithms._mth02CA(aecfieldelement, 0, j);
        for (int l = 0; l < j; l++)
        {
            int j1 = ai[l];
            aecpoint[j1] = aecpoint[j1]._mth02BC(aecfieldelement[l]);
        }

    }

    protected abstract ECPoint _mth02CB(int i, BigInteger biginteger);

    public ECPoint _mth02CE(ECPoint ecpoint)
    {
        if (this == ecpoint.FF79())
        {
            return ecpoint;
        }
        if (ecpoint._mth021D())
        {
            return _mth5B80();
        }
        ecpoint = ecpoint._mth0188();
        ecpoint = _mth02CA(ecpoint._mth0134().toBigInteger(), ecpoint._mth0141().toBigInteger(), ecpoint.aHv);
        if (!ecpoint.isValid())
        {
            throw new IllegalArgumentException("Invalid point coordinates");
        } else
        {
            return ecpoint;
        }
    }

    public boolean _mth071D(int i)
    {
        return i == 0;
    }

    public final Config _mth30C3()
    {
        return new Config(aIv, aIw, aIx);
    }

    public abstract ECCurve _mth30FE();

    protected ECMultiplier _mth4E40()
    {
        if (aIw instanceof GLVEndomorphism)
        {
            return new GLVMultiplier(this, (GLVEndomorphism)aIw);
        } else
        {
            return new WNafL2RMultiplier();
        }
    }

    public abstract ECPoint _mth5B80();

    public final FiniteField FB25()
    {
        return aIq;
    }

    public final ECFieldElement FB46()
    {
        return aIr;
    }

    public final ECFieldElement FB4C()
    {
        return aIs;
    }

    public final BigInteger FB52()
    {
        return aIu;
    }

    public final int FB5E()
    {
        return aIv;
    }

    public final ECEndomorphism FE95()
    {
        return aIw;
    }

    public final ECMultiplier FE9F()
    {
        this;
        JVM INSTR monitorenter ;
        ECMultiplier ecmultiplier;
        if (aIx == null)
        {
            aIx = _mth4E40();
        }
        ecmultiplier = aIx;
        this;
        JVM INSTR monitorexit ;
        return ecmultiplier;
        Exception exception;
        exception;
        throw exception;
    }
}
