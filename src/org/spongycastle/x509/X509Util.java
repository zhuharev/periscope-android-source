// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.util.Strings;

class X509Util
{
    static class Implementation
    {

        Object aQp;
        Provider aQq;

        Implementation(Object obj, Provider provider)
        {
            aQp = obj;
            aQq = provider;
        }
    }


    private static Hashtable Ma;
    private static Hashtable aCU;
    private static HashSet aGn;

    X509Util()
    {
    }

    static Provider getProvider(String s)
    {
        Provider provider = Security.getProvider(s);
        if (provider == null)
        {
            throw new NoSuchProviderException((new StringBuilder("Provider ")).append(s).append(" not found").toString());
        } else
        {
            return provider;
        }
    }

    private static RSASSAPSSparams _mth02CA(AlgorithmIdentifier algorithmidentifier, int i)
    {
        return new RSASSAPSSparams(algorithmidentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.abd, algorithmidentifier), new ASN1Integer(i), new ASN1Integer(1L));
    }

    static Implementation _mth02CA(String s, String s1, Provider provider)
    {
        s1 = Strings.FE7C(s1);
        do
        {
            String s2 = provider.getProperty((new StringBuilder("Alg.Alias.")).append(s).append(".").append(s1).toString());
            if (s2 == null)
            {
                break;
            }
            s1 = s2;
        } while (true);
        String s3 = provider.getProperty((new StringBuilder()).append(s).append(".").append(s1).toString());
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        try
        {
            s = provider.getClass().getClassLoader();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException((new StringBuilder("algorithm ")).append(s1).append(" in provider ").append(provider.getName()).append(" but no class \"").append(s3).append("\" found!").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException((new StringBuilder("algorithm ")).append(s1).append(" in provider ").append(provider.getName()).append(" but class \"").append(s3).append("\" inaccessible!").toString());
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        s = s.loadClass(s3);
        break MISSING_BLOCK_LABEL_105;
        s = Class.forName(s3);
        s = new Implementation(s.newInstance(), provider);
        return s;
        throw new NoSuchAlgorithmException((new StringBuilder("cannot find implementation ")).append(s1).append(" for provider ").append(provider.getName()).toString());
    }

    static 
    {
        aCU = new Hashtable();
        Ma = new Hashtable();
        aGn = new HashSet();
        aCU.put("MD2WITHRSAENCRYPTION", PKCSObjectIdentifiers.aaY);
        aCU.put("MD2WITHRSA", PKCSObjectIdentifiers.aaY);
        aCU.put("MD5WITHRSAENCRYPTION", PKCSObjectIdentifiers.aba);
        aCU.put("MD5WITHRSA", PKCSObjectIdentifiers.aba);
        aCU.put("SHA1WITHRSAENCRYPTION", PKCSObjectIdentifiers.abb);
        aCU.put("SHA1WITHRSA", PKCSObjectIdentifiers.abb);
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
        aCU.put("RIPEMD160WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.afn);
        aCU.put("RIPEMD160WITHRSA", TeleTrusTObjectIdentifiers.afn);
        aCU.put("RIPEMD128WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.afo);
        aCU.put("RIPEMD128WITHRSA", TeleTrusTObjectIdentifiers.afo);
        aCU.put("RIPEMD256WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.afp);
        aCU.put("RIPEMD256WITHRSA", TeleTrusTObjectIdentifiers.afp);
        aCU.put("SHA1WITHDSA", X9ObjectIdentifiers.amn);
        aCU.put("DSAWITHSHA1", X9ObjectIdentifiers.amn);
        aCU.put("SHA224WITHDSA", NISTObjectIdentifiers.aad);
        aCU.put("SHA256WITHDSA", NISTObjectIdentifiers.aae);
        aCU.put("SHA384WITHDSA", NISTObjectIdentifiers.aaf);
        aCU.put("SHA512WITHDSA", NISTObjectIdentifiers.aag);
        aCU.put("SHA1WITHECDSA", X9ObjectIdentifiers.alF);
        aCU.put("ECDSAWITHSHA1", X9ObjectIdentifiers.alF);
        aCU.put("SHA224WITHECDSA", X9ObjectIdentifiers.alJ);
        aCU.put("SHA256WITHECDSA", X9ObjectIdentifiers.alK);
        aCU.put("SHA384WITHECDSA", X9ObjectIdentifiers.alL);
        aCU.put("SHA512WITHECDSA", X9ObjectIdentifiers.alM);
        aCU.put("GOST3411WITHGOST3410", CryptoProObjectIdentifiers.XX);
        aCU.put("GOST3411WITHGOST3410-94", CryptoProObjectIdentifiers.XX);
        aCU.put("GOST3411WITHECGOST3410", CryptoProObjectIdentifiers.XY);
        aCU.put("GOST3411WITHECGOST3410-2001", CryptoProObjectIdentifiers.XY);
        aCU.put("GOST3411WITHGOST3410-2001", CryptoProObjectIdentifiers.XY);
        aGn.add(X9ObjectIdentifiers.alF);
        aGn.add(X9ObjectIdentifiers.alJ);
        aGn.add(X9ObjectIdentifiers.alK);
        aGn.add(X9ObjectIdentifiers.alL);
        aGn.add(X9ObjectIdentifiers.alM);
        aGn.add(X9ObjectIdentifiers.amn);
        aGn.add(NISTObjectIdentifiers.aad);
        aGn.add(NISTObjectIdentifiers.aae);
        aGn.add(NISTObjectIdentifiers.aaf);
        aGn.add(NISTObjectIdentifiers.aag);
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
