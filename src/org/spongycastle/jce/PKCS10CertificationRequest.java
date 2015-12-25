// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce;

import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.CertificationRequest;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;

public class PKCS10CertificationRequest extends CertificationRequest
{

    private static Hashtable Ma;
    private static Hashtable aCU;
    private static Hashtable aDp;
    private static Hashtable aGm;
    private static HashSet aGn;

    private static RSASSAPSSparams _mth02CA(AlgorithmIdentifier algorithmidentifier, int i)
    {
        return new RSASSAPSSparams(algorithmidentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.abd, algorithmidentifier), new ASN1Integer(i), new ASN1Integer(1L));
    }

    public byte[] getEncoded()
    {
        byte abyte0[];
        try
        {
            abyte0 = getEncoded("DER");
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException(ioexception.toString());
        }
        return abyte0;
    }

    static 
    {
        aCU = new Hashtable();
        Ma = new Hashtable();
        aGm = new Hashtable();
        aDp = new Hashtable();
        aGn = new HashSet();
        aCU.put("MD2WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"));
        aCU.put("MD2WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"));
        aCU.put("MD5WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
        aCU.put("MD5WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
        aCU.put("RSAWITHMD5", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
        aCU.put("SHA1WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
        aCU.put("SHA1WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
        aCU.put("SHA224WITHRSAENCRYPTION", PKCSObjectIdentifiers.abj);
        aCU.put("SHA224WITHRSA", PKCSObjectIdentifiers.abj);
        aCU.put("SHA256WITHRSAENCRYPTION", PKCSObjectIdentifiers.abg);
        aCU.put("SHA256WITHRSA", PKCSObjectIdentifiers.abg);
        aCU.put("SHA384WITHRSAENCRYPTION", PKCSObjectIdentifiers.abh);
        aCU.put("SHA384WITHRSA", PKCSObjectIdentifiers.abh);
        aCU.put("SHA512WITHRSAENCRYPTION", PKCSObjectIdentifiers.abi);
        aCU.put("SHA512WITHRSA", PKCSObjectIdentifiers.abi);
        aCU.put("SHA1WITHRSAANDMGF1", PKCSObjectIdentifiers.abf);
        aCU.put("SHA224WITHRSAANDMGF1", PKCSObjectIdentifiers.abf);
        aCU.put("SHA256WITHRSAANDMGF1", PKCSObjectIdentifiers.abf);
        aCU.put("SHA384WITHRSAANDMGF1", PKCSObjectIdentifiers.abf);
        aCU.put("SHA512WITHRSAANDMGF1", PKCSObjectIdentifiers.abf);
        aCU.put("RSAWITHSHA1", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
        aCU.put("RIPEMD128WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.afo);
        aCU.put("RIPEMD128WITHRSA", TeleTrusTObjectIdentifiers.afo);
        aCU.put("RIPEMD160WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.afn);
        aCU.put("RIPEMD160WITHRSA", TeleTrusTObjectIdentifiers.afn);
        aCU.put("RIPEMD256WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.afp);
        aCU.put("RIPEMD256WITHRSA", TeleTrusTObjectIdentifiers.afp);
        aCU.put("SHA1WITHDSA", new ASN1ObjectIdentifier("1.2.840.10040.4.3"));
        aCU.put("DSAWITHSHA1", new ASN1ObjectIdentifier("1.2.840.10040.4.3"));
        aCU.put("SHA224WITHDSA", NISTObjectIdentifiers.aad);
        aCU.put("SHA256WITHDSA", NISTObjectIdentifiers.aae);
        aCU.put("SHA384WITHDSA", NISTObjectIdentifiers.aaf);
        aCU.put("SHA512WITHDSA", NISTObjectIdentifiers.aag);
        aCU.put("SHA1WITHECDSA", X9ObjectIdentifiers.alF);
        aCU.put("SHA224WITHECDSA", X9ObjectIdentifiers.alJ);
        aCU.put("SHA256WITHECDSA", X9ObjectIdentifiers.alK);
        aCU.put("SHA384WITHECDSA", X9ObjectIdentifiers.alL);
        aCU.put("SHA512WITHECDSA", X9ObjectIdentifiers.alM);
        aCU.put("ECDSAWITHSHA1", X9ObjectIdentifiers.alF);
        aCU.put("GOST3411WITHGOST3410", CryptoProObjectIdentifiers.XX);
        aCU.put("GOST3410WITHGOST3411", CryptoProObjectIdentifiers.XX);
        aCU.put("GOST3411WITHECGOST3410", CryptoProObjectIdentifiers.XY);
        aCU.put("GOST3411WITHECGOST3410-2001", CryptoProObjectIdentifiers.XY);
        aCU.put("GOST3411WITHGOST3410-2001", CryptoProObjectIdentifiers.XY);
        aDp.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        aDp.put(PKCSObjectIdentifiers.abj, "SHA224WITHRSA");
        aDp.put(PKCSObjectIdentifiers.abg, "SHA256WITHRSA");
        aDp.put(PKCSObjectIdentifiers.abh, "SHA384WITHRSA");
        aDp.put(PKCSObjectIdentifiers.abi, "SHA512WITHRSA");
        aDp.put(CryptoProObjectIdentifiers.XX, "GOST3411WITHGOST3410");
        aDp.put(CryptoProObjectIdentifiers.XY, "GOST3411WITHECGOST3410");
        aDp.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        aDp.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        aDp.put(new ASN1ObjectIdentifier("1.2.840.10040.4.3"), "SHA1WITHDSA");
        aDp.put(X9ObjectIdentifiers.alF, "SHA1WITHECDSA");
        aDp.put(X9ObjectIdentifiers.alJ, "SHA224WITHECDSA");
        aDp.put(X9ObjectIdentifiers.alK, "SHA256WITHECDSA");
        aDp.put(X9ObjectIdentifiers.alL, "SHA384WITHECDSA");
        aDp.put(X9ObjectIdentifiers.alM, "SHA512WITHECDSA");
        aDp.put(OIWObjectIdentifiers.aax, "SHA1WITHRSA");
        aDp.put(OIWObjectIdentifiers.aaw, "SHA1WITHDSA");
        aDp.put(NISTObjectIdentifiers.aad, "SHA224WITHDSA");
        aDp.put(NISTObjectIdentifiers.aae, "SHA256WITHDSA");
        aGm.put(PKCSObjectIdentifiers.aaX, "RSA");
        aGm.put(X9ObjectIdentifiers.amm, "DSA");
        aGn.add(X9ObjectIdentifiers.alF);
        aGn.add(X9ObjectIdentifiers.alJ);
        aGn.add(X9ObjectIdentifiers.alK);
        aGn.add(X9ObjectIdentifiers.alL);
        aGn.add(X9ObjectIdentifiers.alM);
        aGn.add(X9ObjectIdentifiers.amn);
        aGn.add(NISTObjectIdentifiers.aad);
        aGn.add(NISTObjectIdentifiers.aae);
        aGn.add(CryptoProObjectIdentifiers.XX);
        aGn.add(CryptoProObjectIdentifiers.XY);
        AlgorithmIdentifier algorithmidentifier = new AlgorithmIdentifier(OIWObjectIdentifiers.aav, DERNull.WL);
        Ma.put("SHA1WITHRSAANDMGF1", _mth02CA(algorithmidentifier, 20));
        algorithmidentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.ZG, DERNull.WL);
        Ma.put("SHA224WITHRSAANDMGF1", _mth02CA(algorithmidentifier, 28));
        algorithmidentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.ZD, DERNull.WL);
        Ma.put("SHA256WITHRSAANDMGF1", _mth02CA(algorithmidentifier, 32));
        algorithmidentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.ZE, DERNull.WL);
        Ma.put("SHA384WITHRSAANDMGF1", _mth02CA(algorithmidentifier, 48));
        algorithmidentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.ZF, DERNull.WL);
        Ma.put("SHA512WITHRSAANDMGF1", _mth02CA(algorithmidentifier, 64));
    }
}
