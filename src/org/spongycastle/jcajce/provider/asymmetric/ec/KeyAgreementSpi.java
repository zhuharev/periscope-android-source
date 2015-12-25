// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x9.X9IntegerConverter;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.agreement.ECDHCBasicAgreement;
import org.spongycastle.crypto.agreement.ECMQVBasicAgreement;
import org.spongycastle.crypto.agreement.kdf.DHKDFParameters;
import org.spongycastle.crypto.agreement.kdf.ECDHKEKGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.MQVPrivateParameters;
import org.spongycastle.crypto.params.MQVPublicParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jce.interfaces.ECPrivateKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.interfaces.MQVPrivateKey;
import org.spongycastle.jce.interfaces.MQVPublicKey;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;

public class KeyAgreementSpi extends javax.crypto.KeyAgreementSpi
{
    public static class DH extends KeyAgreementSpi
    {

        public DH()
        {
            super("ECDH", new ECDHBasicAgreement(), null);
        }
    }

    public static class DHC extends KeyAgreementSpi
    {

        public DHC()
        {
            super("ECDHC", new ECDHCBasicAgreement(), null);
        }
    }

    public static class DHwithSHA1KDF extends KeyAgreementSpi
    {

        public DHwithSHA1KDF()
        {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
        }
    }

    public static class MQV extends KeyAgreementSpi
    {

        public MQV()
        {
            super("ECMQV", new ECMQVBasicAgreement(), null);
        }
    }

    public static class MQVwithSHA1KDF extends KeyAgreementSpi
    {

        public MQVwithSHA1KDF()
        {
            super("ECMQVwithSHA1KDF", new ECMQVBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
        }
    }


    private static final Hashtable aCU;
    private static final Hashtable aDp;
    private static final Hashtable aDq;
    private static final X9IntegerConverter alw = new X9IntegerConverter();
    private BigInteger aCT;
    private String aDr;
    private ECDomainParameters aDs;
    private BasicAgreement aDt;
    private DerivationFunction arM;

    protected KeyAgreementSpi(String s, BasicAgreement basicagreement, ECDHKEKGenerator ecdhkekgenerator)
    {
        aDr = s;
        aDt = basicagreement;
        arM = ecdhkekgenerator;
    }

    private void _mth02CA(Key key)
    {
        if (aDt instanceof ECMQVBasicAgreement)
        {
            if (!(key instanceof MQVPrivateKey))
            {
                key = (new StringBuilder()).append(aDr).append(" key agreement requires ");
                String s = org/spongycastle/jce/interfaces/MQVPrivateKey.getName();
                throw new InvalidKeyException(key.append(s.substring(s.lastIndexOf('.') + 1)).append(" for initialisation").toString());
            }
            MQVPrivateKey mqvprivatekey = (MQVPrivateKey)key;
            ECPrivateKeyParameters ecprivatekeyparameters = (ECPrivateKeyParameters)ECUtil._mth02CF(mqvprivatekey._mth1E6C());
            ECPrivateKeyParameters ecprivatekeyparameters1 = (ECPrivateKeyParameters)ECUtil._mth02CF(mqvprivatekey._mth1E6F());
            key = null;
            if (mqvprivatekey._mth1E8F() != null)
            {
                key = (ECPublicKeyParameters)ECUtil._mth02CF(mqvprivatekey._mth1E8F());
            }
            key = new MQVPrivateParameters(ecprivatekeyparameters, ecprivatekeyparameters1, key);
            aDs = ((ECKeyParameters) (ecprivatekeyparameters)).aub;
            aDt._mth02CA(key);
            return;
        }
        if (!(key instanceof PrivateKey))
        {
            key = (new StringBuilder()).append(aDr).append(" key agreement requires ");
            String s1 = org/spongycastle/jce/interfaces/ECPrivateKey.getName();
            throw new InvalidKeyException(key.append(s1.substring(s1.lastIndexOf('.') + 1)).append(" for initialisation").toString());
        } else
        {
            key = (ECPrivateKeyParameters)ECUtil._mth02CF((PrivateKey)key);
            aDs = ((ECKeyParameters) (key)).aub;
            aDt._mth02CA(key);
            return;
        }
    }

    protected Key engineDoPhase(Key key, boolean flag)
    {
        if (aDs == null)
        {
            throw new IllegalStateException((new StringBuilder()).append(aDr).append(" not initialised.").toString());
        }
        if (!flag)
        {
            throw new IllegalStateException((new StringBuilder()).append(aDr).append(" can only be between two parties.").toString());
        }
        if (aDt instanceof ECMQVBasicAgreement)
        {
            if (!(key instanceof MQVPublicKey))
            {
                key = (new StringBuilder()).append(aDr).append(" key agreement requires ");
                String s = org/spongycastle/jce/interfaces/MQVPublicKey.getName();
                throw new InvalidKeyException(key.append(s.substring(s.lastIndexOf('.') + 1)).append(" for doPhase").toString());
            }
            key = (MQVPublicKey)key;
            key = new MQVPublicParameters((ECPublicKeyParameters)ECUtil._mth02CF(key._mth1E93()), (ECPublicKeyParameters)ECUtil._mth02CF(key._mth1ECD()));
        } else
        {
            if (!(key instanceof PublicKey))
            {
                key = (new StringBuilder()).append(aDr).append(" key agreement requires ");
                String s1 = org/spongycastle/jce/interfaces/ECPublicKey.getName();
                throw new InvalidKeyException(key.append(s1.substring(s1.lastIndexOf('.') + 1)).append(" for doPhase").toString());
            }
            key = ECUtil._mth02CF((PublicKey)key);
        }
        aCT = aDt._mth02CB(key);
        return null;
    }

    protected int engineGenerateSecret(byte abyte0[], int i)
    {
        byte abyte1[] = engineGenerateSecret();
        if (abyte0.length - i < abyte1.length)
        {
            throw new ShortBufferException((new StringBuilder()).append(aDr).append(" key agreement: need ").append(abyte1.length).append(" bytes").toString());
        } else
        {
            System.arraycopy(abyte1, 0, abyte0, i, abyte1.length);
            return abyte1.length;
        }
    }

    protected SecretKey engineGenerateSecret(String s)
    {
        Object obj = X9IntegerConverter._mth02CA(aCT, X9IntegerConverter._mth02CB(aDs.alm));
        String s1 = Strings.FE7C(s);
        String s2 = s;
        if (aDp.containsKey(s1))
        {
            s2 = ((ASN1ObjectIdentifier)aDp.get(s1)).identifier;
        }
        byte abyte0[];
        if (arM != null)
        {
            if (!aCU.containsKey(s2))
            {
                throw new NoSuchAlgorithmException((new StringBuilder("unknown algorithm encountered: ")).append(s).toString());
            }
            int i = ((Integer)aCU.get(s2)).intValue();
            obj = new DHKDFParameters(new ASN1ObjectIdentifier(s2), i, ((byte []) (obj)));
            abyte0 = new byte[i / 8];
            arM._mth02CA(((org.spongycastle.crypto.DerivationParameters) (obj)));
            arM._mth02BF(abyte0, 0, abyte0.length);
        } else
        {
            abyte0 = ((byte []) (obj));
            if (aCU.containsKey(s2))
            {
                abyte0 = new byte[((Integer)aCU.get(s2)).intValue() / 8];
                System.arraycopy(obj, 0, abyte0, 0, abyte0.length);
            }
        }
        if (aDq.containsKey(s2))
        {
            DESParameters._mth1D55(abyte0);
        }
        return new SecretKeySpec(abyte0, s);
    }

    protected byte[] engineGenerateSecret()
    {
        if (arM != null)
        {
            throw new UnsupportedOperationException("KDF can only be used when algorithm is known");
        } else
        {
            return X9IntegerConverter._mth02CA(aCT, X9IntegerConverter._mth02CB(aDs.alm));
        }
    }

    protected void engineInit(Key key, SecureRandom securerandom)
    {
        _mth02CA(key);
    }

    protected void engineInit(Key key, AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (algorithmparameterspec != null)
        {
            throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
        } else
        {
            _mth02CA(key);
            return;
        }
    }

    static 
    {
        aCU = new Hashtable();
        aDp = new Hashtable();
        aDq = new Hashtable();
        Integer integer = Integers.valueOf(64);
        Integer integer1 = Integers.valueOf(128);
        Integer integer2 = Integers.valueOf(192);
        Integer integer3 = Integers.valueOf(256);
        aCU.put(NISTObjectIdentifiers.ZL.identifier, integer1);
        aCU.put(NISTObjectIdentifiers.ZR.identifier, integer2);
        aCU.put(NISTObjectIdentifiers.ZX.identifier, integer3);
        aCU.put(NISTObjectIdentifiers.ZO.identifier, integer1);
        aCU.put(NISTObjectIdentifiers.ZU.identifier, integer2);
        aCU.put(NISTObjectIdentifiers.aaa.identifier, integer3);
        aCU.put(PKCSObjectIdentifiers.acU.identifier, integer2);
        aCU.put(PKCSObjectIdentifiers.abw.identifier, integer2);
        aCU.put(OIWObjectIdentifiers.aau.identifier, integer);
        aDp.put("DESEDE", PKCSObjectIdentifiers.abw);
        aDp.put("AES", NISTObjectIdentifiers.ZX);
        aDp.put("DES", OIWObjectIdentifiers.aau);
        aDq.put("DES", "DES");
        aDq.put("DESEDE", "DES");
        aDq.put(OIWObjectIdentifiers.aau.identifier, "DES");
        aDq.put(PKCSObjectIdentifiers.abw.identifier, "DES");
        aDq.put(PKCSObjectIdentifiers.acU.identifier, "DES");
    }
}
