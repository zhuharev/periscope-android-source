// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;

// Referenced classes of package org.spongycastle.asn1.cryptopro:
//            CryptoProObjectIdentifiers

public class ECGOST3410NamedCurves
{

    private static Hashtable Ma;
    private static Hashtable Yi;
    private static Hashtable Yj;

    public ECGOST3410NamedCurves()
    {
    }

    public static ECDomainParameters _mth02CB(ASN1ObjectIdentifier asn1objectidentifier)
    {
        return (ECDomainParameters)Ma.get(asn1objectidentifier);
    }

    public static String _mth02CE(ASN1ObjectIdentifier asn1objectidentifier)
    {
        return (String)Yj.get(asn1objectidentifier);
    }

    public static ECDomainParameters _mth09F2(String s)
    {
        s = (ASN1ObjectIdentifier)Yi.get(s);
        if (s != null)
        {
            return (ECDomainParameters)Ma.get(s);
        } else
        {
            return null;
        }
    }

    public static ASN1ObjectIdentifier _mth1422(String s)
    {
        return (ASN1ObjectIdentifier)Yi.get(s);
    }

    static 
    {
        Yi = new Hashtable();
        Ma = new Hashtable();
        Yj = new Hashtable();
        Object obj1 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        Object obj = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        obj1 = new org.spongycastle.math.ec.ECCurve.Fp(((BigInteger) (obj1)), new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"), ((BigInteger) (obj)), ECConstants.ONE);
        obj = new ECDomainParameters(((ECCurve) (obj1)), ((ECCurve) (obj1))._mth02CA(new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612"), false), ((BigInteger) (obj)));
        Ma.put(CryptoProObjectIdentifiers.Yd, obj);
        obj1 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        obj = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        obj1 = new org.spongycastle.math.ec.ECCurve.Fp(((BigInteger) (obj1)), new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"), ((BigInteger) (obj)), ECConstants.ONE);
        obj = new ECDomainParameters(((ECCurve) (obj1)), ((ECCurve) (obj1))._mth02CA(new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612"), false), ((BigInteger) (obj)));
        Ma.put(CryptoProObjectIdentifiers.Yg, obj);
        obj1 = new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823193");
        obj = new BigInteger("57896044618658097711785492504343953927102133160255826820068844496087732066703");
        obj1 = new org.spongycastle.math.ec.ECCurve.Fp(((BigInteger) (obj1)), new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823190"), new BigInteger("28091019353058090096996979000309560759124368558014865957655842872397301267595"), ((BigInteger) (obj)), ECConstants.ONE);
        obj = new ECDomainParameters(((ECCurve) (obj1)), ((ECCurve) (obj1))._mth02CA(new BigInteger("1"), new BigInteger("28792665814854611296992347458380284135028636778229113005756334730996303888124"), false), ((BigInteger) (obj)));
        Ma.put(CryptoProObjectIdentifiers.Ye, obj);
        obj1 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        obj = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        obj1 = new org.spongycastle.math.ec.ECCurve.Fp(((BigInteger) (obj1)), new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), ((BigInteger) (obj)), ECConstants.ONE);
        obj = new ECDomainParameters(((ECCurve) (obj1)), ((ECCurve) (obj1))._mth02CA(new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247"), false), ((BigInteger) (obj)));
        Ma.put(CryptoProObjectIdentifiers.Yh, obj);
        obj1 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        obj = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        obj1 = new org.spongycastle.math.ec.ECCurve.Fp(((BigInteger) (obj1)), new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), ((BigInteger) (obj)), ECConstants.ONE);
        obj = new ECDomainParameters(((ECCurve) (obj1)), ((ECCurve) (obj1))._mth02CA(new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247"), false), ((BigInteger) (obj)));
        Ma.put(CryptoProObjectIdentifiers.Yf, obj);
        Yi.put("GostR3410-2001-CryptoPro-A", CryptoProObjectIdentifiers.Yd);
        Yi.put("GostR3410-2001-CryptoPro-B", CryptoProObjectIdentifiers.Ye);
        Yi.put("GostR3410-2001-CryptoPro-C", CryptoProObjectIdentifiers.Yf);
        Yi.put("GostR3410-2001-CryptoPro-XchA", CryptoProObjectIdentifiers.Yg);
        Yi.put("GostR3410-2001-CryptoPro-XchB", CryptoProObjectIdentifiers.Yh);
        Yj.put(CryptoProObjectIdentifiers.Yd, "GostR3410-2001-CryptoPro-A");
        Yj.put(CryptoProObjectIdentifiers.Ye, "GostR3410-2001-CryptoPro-B");
        Yj.put(CryptoProObjectIdentifiers.Yf, "GostR3410-2001-CryptoPro-C");
        Yj.put(CryptoProObjectIdentifiers.Yg, "GostR3410-2001-CryptoPro-XchA");
        Yj.put(CryptoProObjectIdentifiers.Yh, "GostR3410-2001-CryptoPro-XchB");
    }
}
