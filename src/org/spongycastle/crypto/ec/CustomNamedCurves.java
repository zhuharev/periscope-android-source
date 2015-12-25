// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.ec;

import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.sec.SECObjectIdentifiers;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.endo.GLVTypeBEndomorphism;
import org.spongycastle.math.ec.endo.GLVTypeBParameters;
import org.spongycastle.util.Strings;

public class CustomNamedCurves
{

    private static _cls6 apA;
    private static _cls7 apB;
    private static _cls8 apC;
    private static _cls9 apD;
    private static Hashtable apE;
    private static Hashtable apF;
    private static Hashtable apG;
    private static Hashtable apH = new Hashtable();
    private static _cls1 apv;
    private static _cls2 apw;
    private static _cls3 apx;
    private static _cls4 apy;
    private static _cls5 apz;

    public CustomNamedCurves()
    {
    }

    static ECCurve _mth02CA(org.spongycastle.math.ec.ECCurve.AbstractFp abstractfp)
    {
        return abstractfp;
    }

    static ECCurve _mth02CA(org.spongycastle.math.ec.ECCurve.AbstractFp abstractfp, GLVTypeBParameters glvtypebparameters)
    {
        return abstractfp._mth30C3()._mth02CA(new GLVTypeBEndomorphism(abstractfp, glvtypebparameters)).FEA7();
    }

    private static void _mth02CA(String s, ASN1ObjectIdentifier asn1objectidentifier, X9ECParametersHolder x9ecparametersholder)
    {
        apE.put(s, x9ecparametersholder);
        apF.put(s, asn1objectidentifier);
        apH.put(asn1objectidentifier, s);
        apG.put(asn1objectidentifier, x9ecparametersholder);
    }

    public static X9ECParameters _mth141D(ASN1ObjectIdentifier asn1objectidentifier)
    {
        asn1objectidentifier = (X9ECParametersHolder)apG.get(asn1objectidentifier);
        if (asn1objectidentifier == null)
        {
            return null;
        } else
        {
            return asn1objectidentifier.getParameters();
        }
    }

    public static X9ECParameters _mth14BB(String s)
    {
        s = (X9ECParametersHolder)apE.get(Strings.FE91(s));
        if (s == null)
        {
            return null;
        } else
        {
            return s.getParameters();
        }
    }

    public static Enumeration _mth1681()
    {
        return apE.keys();
    }

    static 
    {
        apv = new _cls1();
        apw = new _cls2();
        apx = new _cls3();
        apy = new _cls4();
        apz = new _cls5();
        apA = new _cls6();
        apB = new _cls7();
        apC = new _cls8();
        apD = new _cls9();
        apE = new Hashtable();
        apF = new Hashtable();
        apG = new Hashtable();
        Object obj = apv;
        apE.put("curve25519", obj);
        _mth02CA("secp192k1", SECObjectIdentifiers.aeI, apw);
        _mth02CA("secp192r1", SECObjectIdentifiers.aeR, apx);
        _mth02CA("secp224k1", SECObjectIdentifiers.aeJ, apy);
        _mth02CA("secp224r1", SECObjectIdentifiers.aeK, apz);
        _mth02CA("secp256k1", SECObjectIdentifiers.aev, apA);
        _mth02CA("secp256r1", SECObjectIdentifiers.aeS, apB);
        _mth02CA("secp384r1", SECObjectIdentifiers.aeL, apC);
        _mth02CA("secp521r1", SECObjectIdentifiers.aeM, apD);
        obj = SECObjectIdentifiers.aeR;
        String s = Strings.FE91("P-192");
        apF.put(s, obj);
        apE.put(s, apG.get(obj));
        obj = SECObjectIdentifiers.aeK;
        s = Strings.FE91("P-224");
        apF.put(s, obj);
        apE.put(s, apG.get(obj));
        obj = SECObjectIdentifiers.aeS;
        s = Strings.FE91("P-256");
        apF.put(s, obj);
        apE.put(s, apG.get(obj));
        obj = SECObjectIdentifiers.aeL;
        s = Strings.FE91("P-384");
        apF.put(s, obj);
        apE.put(s, apG.get(obj));
        obj = SECObjectIdentifiers.aeM;
        s = Strings.FE91("P-521");
        apF.put(s, obj);
        apE.put(s, apG.get(obj));
    }

    private class _cls1 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            ECCurve eccurve = CustomNamedCurves._mth02CA(new Curve25519());
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("042AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD245A20AE19A1B8A086B4E01EDD2C7748D14C923D4D7E6D7C61B229E9C5A27ECED3D9")), eccurve.getOrder(), eccurve.FB52(), null);
        }

        _cls1()
        {
        }
    }


    private class _cls2 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            Object obj = new BigInteger("bb85691939b869c1d087f601554b96b80cb4f55b35f433c2", 16);
            BigInteger biginteger = new BigInteger("3d84f26c12238d7b4f3d516613c1759033b1a5800175d0b1", 16);
            BigInteger biginteger1 = new BigInteger("71169be7330b3038edb025f1", 16);
            BigInteger biginteger2 = new BigInteger("-b3fb3400dec5c4adceb8655c", 16);
            BigInteger biginteger3 = new BigInteger("12511cfe811d0f4e6bc688b4d", 16);
            BigInteger biginteger4 = new BigInteger("71169be7330b3038edb025f1", 16);
            BigInteger biginteger5 = new BigInteger("71169be7330b3038edb025f1d0f9", 16);
            BigInteger biginteger6 = new BigInteger("b3fb3400dec5c4adceb8655d4c94", 16);
            obj = new GLVTypeBParameters(((BigInteger) (obj)), biginteger, new BigInteger[] {
                biginteger1, biginteger2
            }, new BigInteger[] {
                biginteger3, biginteger4
            }, biginteger5, biginteger6, 208);
            obj = CustomNamedCurves._mth02CA(new SecP192K1Curve(), ((GLVTypeBParameters) (obj)));
            return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("04DB4FF10EC057E9AE26B07D0280B7F4341DA5D1B1EAE06C7D9B2F2F6D9C5628A7844163D015BE86344082AA88D95E2F9D")), ((ECCurve) (obj)).getOrder(), ((ECCurve) (obj)).FB52(), null);
        }

        _cls2()
        {
        }
    }


    private class _cls3 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            byte abyte0[] = Hex._mth1508("3045AE6FC8422F64ED579528D38120EAE12196D5");
            ECCurve eccurve = CustomNamedCurves._mth02CA(new SecP192R1Curve());
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("04188DA80EB03090F67CBF20EB43A18800F4FF0AFD82FF101207192B95FFC8DA78631011ED6B24CDD573F977A11E794811")), eccurve.getOrder(), eccurve.FB52(), abyte0);
        }

        _cls3()
        {
        }
    }


    private class _cls4 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            Object obj = new BigInteger("fe0e87005b4e83761908c5131d552a850b3f58b749c37cf5b84d6768", 16);
            BigInteger biginteger = new BigInteger("60dcd2104c4cbc0be6eeefc2bdd610739ec34e317f9b33046c9e4788", 16);
            BigInteger biginteger1 = new BigInteger("6b8cf07d4ca75c88957d9d670591", 16);
            BigInteger biginteger2 = new BigInteger("-b8adf1378a6eb73409fa6c9c637d", 16);
            BigInteger biginteger3 = new BigInteger("1243ae1b4d71613bc9f780a03690e", 16);
            BigInteger biginteger4 = new BigInteger("6b8cf07d4ca75c88957d9d670591", 16);
            BigInteger biginteger5 = new BigInteger("6b8cf07d4ca75c88957d9d67059037a4", 16);
            BigInteger biginteger6 = new BigInteger("b8adf1378a6eb73409fa6c9c637ba7f5", 16);
            obj = new GLVTypeBParameters(((BigInteger) (obj)), biginteger, new BigInteger[] {
                biginteger1, biginteger2
            }, new BigInteger[] {
                biginteger3, biginteger4
            }, biginteger5, biginteger6, 240);
            obj = CustomNamedCurves._mth02CA(new SecP224K1Curve(), ((GLVTypeBParameters) (obj)));
            return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("04A1455B334DF099DF30FC28A169A467E9E47075A90F7E650EB6B7A45C7E089FED7FBA344282CAFBD6F7E319F7C0B0BD59E2CA4BDB556D61A5")), ((ECCurve) (obj)).getOrder(), ((ECCurve) (obj)).FB52(), null);
        }

        _cls4()
        {
        }
    }


    private class _cls5 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            byte abyte0[] = Hex._mth1508("BD71344799D5C7FCDC45B59FA3B9AB8F6A948BC5");
            ECCurve eccurve = CustomNamedCurves._mth02CA(new SecP224R1Curve());
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("04B70E0CBD6BB4BF7F321390B94A03C1D356C21122343280D6115C1D21BD376388B5F723FB4C22DFE6CD4375A05A07476444D5819985007E34")), eccurve.getOrder(), eccurve.FB52(), abyte0);
        }

        _cls5()
        {
        }
    }


    private class _cls6 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            Object obj = new BigInteger("7ae96a2b657c07106e64479eac3434e99cf0497512f58995c1396c28719501ee", 16);
            BigInteger biginteger = new BigInteger("5363ad4cc05c30e0a5261c028812645a122e22ea20816678df02967c1b23bd72", 16);
            BigInteger biginteger1 = new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16);
            BigInteger biginteger2 = new BigInteger("-e4437ed6010e88286f547fa90abfe4c3", 16);
            BigInteger biginteger3 = new BigInteger("114ca50f7a8e2f3f657c1108d9d44cfd8", 16);
            BigInteger biginteger4 = new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16);
            BigInteger biginteger5 = new BigInteger("3086d221a7d46bcde86c90e49284eb153dab", 16);
            BigInteger biginteger6 = new BigInteger("e4437ed6010e88286f547fa90abfe4c42212", 16);
            obj = new GLVTypeBParameters(((BigInteger) (obj)), biginteger, new BigInteger[] {
                biginteger1, biginteger2
            }, new BigInteger[] {
                biginteger3, biginteger4
            }, biginteger5, biginteger6, 272);
            obj = CustomNamedCurves._mth02CA(new SecP256K1Curve(), ((GLVTypeBParameters) (obj)));
            return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("0479BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8")), ((ECCurve) (obj)).getOrder(), ((ECCurve) (obj)).FB52(), null);
        }

        _cls6()
        {
        }
    }


    private class _cls7 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            byte abyte0[] = Hex._mth1508("C49D360886E704936A6678E1139D26B7819F7E90");
            ECCurve eccurve = CustomNamedCurves._mth02CA(new SecP256R1Curve());
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("046B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C2964FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5")), eccurve.getOrder(), eccurve.FB52(), abyte0);
        }

        _cls7()
        {
        }
    }


    private class _cls8 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            byte abyte0[] = Hex._mth1508("A335926AA319A27A1D00896A6773A4827ACDAC73");
            ECCurve eccurve = CustomNamedCurves._mth02CA(new SecP384R1Curve());
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("04AA87CA22BE8B05378EB1C71EF320AD746E1D3B628BA79B9859F741E082542A385502F25DBF55296C3A545E3872760AB73617DE4A96262C6F5D9E98BF9292DC29F8F41DBD289A147CE9DA3113B5F0B8C00A60B1CE1D7E819D7A431D7C90EA0E5F")), eccurve.getOrder(), eccurve.FB52(), abyte0);
        }

        _cls8()
        {
        }
    }


    private class _cls9 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            byte abyte0[] = Hex._mth1508("D09E8800291CB85396CC6717393284AAA0DA64BA");
            ECCurve eccurve = CustomNamedCurves._mth02CA(new SecP521R1Curve());
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("0400C6858E06B70404E9CD9E3ECB662395B4429C648139053FB521F828AF606B4D3DBAA14B5E77EFE75928FE1DC127A2FFA8DE3348B3C1856A429BF97E7E31C2E5BD66011839296A789A3BC0045C8A5FB42C7D1BD998F54449579B446817AFBD17273E662C97EE72995EF42640C550B9013FAD0761353C7086A272C24088BE94769FD16650")), eccurve.getOrder(), eccurve.FB52(), abyte0);
        }

        _cls9()
        {
        }
    }

}
