// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.jcajce.provider.util.DigestFactory;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.rsa:
//            RSAUtil

public class PSSSignatureSpi extends SignatureSpi
{
    class NullPssDigest
        implements Digest
    {

        private Digest aEj;
        private boolean aEk;
        private PSSSignatureSpi aEl;
        private ByteArrayOutputStream anR;

        public final int doFinal(byte abyte0[], int i)
        {
            byte abyte1[] = anR.toByteArray();
            if (aEk)
            {
                System.arraycopy(abyte1, 0, abyte0, i, abyte1.length);
            } else
            {
                aEj.update(abyte1, 0, abyte1.length);
                aEj.doFinal(abyte0, i);
            }
            anR.reset();
            aEj.reset();
            boolean flag;
            if (!aEk)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            aEk = flag;
            return abyte1.length;
        }

        public final void reset()
        {
            anR.reset();
            aEj.reset();
        }

        public final void update(byte byte0)
        {
            anR.write(byte0);
        }

        public final void update(byte abyte0[], int i, int j)
        {
            anR.write(abyte0, i, j);
        }

        public final String _mth14AC()
        {
            return "NULL";
        }

        public final int _mth14AF()
        {
            return aEj._mth14AF();
        }

        public NullPssDigest(Digest digest)
        {
            aEl = PSSSignatureSpi.this;
            super();
            anR = new ByteArrayOutputStream();
            aEk = true;
            aEj = digest;
        }
    }

    public static class PSSwithRSA extends PSSSignatureSpi
    {

        public PSSwithRSA()
        {
            super(new RSABlindedEngine(), null);
        }
    }

    public static class SHA1withRSA extends PSSSignatureSpi
    {

        public SHA1withRSA()
        {
            super(new RSABlindedEngine(), PSSParameterSpec.DEFAULT);
        }
    }

    public static class SHA224withRSA extends PSSSignatureSpi
    {

        public SHA224withRSA()
        {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), 28, 1));
        }
    }

    public static class SHA256withRSA extends PSSSignatureSpi
    {

        public SHA256withRSA()
        {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-256"), 32, 1));
        }
    }

    public static class SHA384withRSA extends PSSSignatureSpi
    {

        public SHA384withRSA()
        {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-384", "MGF1", new MGF1ParameterSpec("SHA-384"), 48, 1));
        }
    }

    public static class SHA512withRSA extends PSSSignatureSpi
    {

        public SHA512withRSA()
        {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512", "MGF1", new MGF1ParameterSpec("SHA-512"), 64, 1));
        }
    }

    public static class nonePSS extends PSSSignatureSpi
    {

        public nonePSS()
        {
            super(new RSABlindedEngine(), null, true);
        }
    }


    private AlgorithmParameters aDC;
    private PSSParameterSpec aEd;
    private PSSParameterSpec aEe;
    private AsymmetricBlockCipher aEf;
    private int aEg;
    private boolean aEh;
    private PSSSigner aEi;
    private Digest azr;
    private Digest azs;
    private byte azy;

    protected PSSSignatureSpi(AsymmetricBlockCipher asymmetricblockcipher, PSSParameterSpec pssparameterspec, boolean flag)
    {
        aEf = asymmetricblockcipher;
        aEe = pssparameterspec;
        if (pssparameterspec == null)
        {
            aEd = PSSParameterSpec.DEFAULT;
        } else
        {
            aEd = pssparameterspec;
        }
        azs = DigestFactory.FB4B(aEd.getDigestAlgorithm());
        aEg = aEd.getSaltLength();
        if (aEd.getTrailerField() != 1)
        {
            throw new IllegalArgumentException("unknown trailer field");
        } else
        {
            azy = -68;
            aEh = flag;
            _mth15BE();
            return;
        }
    }

    protected PSSSignatureSpi(RSABlindedEngine rsablindedengine, PSSParameterSpec pssparameterspec)
    {
        this(((AsymmetricBlockCipher) (rsablindedengine)), pssparameterspec, false);
    }

    private void _mth15BE()
    {
        if (aEh)
        {
            azr = new NullPssDigest(azs);
            return;
        } else
        {
            azr = azs;
            return;
        }
    }

    protected Object engineGetParameter(String s)
    {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    protected AlgorithmParameters engineGetParameters()
    {
        if (aDC == null && aEd != null)
        {
            try
            {
                aDC = AlgorithmParameters.getInstance("PSS", "SC");
                aDC.init(aEd);
            }
            catch (Exception exception)
            {
                throw new RuntimeException(exception.toString());
            }
        }
        return aDC;
    }

    protected void engineInitSign(PrivateKey privatekey)
    {
        if (!(privatekey instanceof RSAPrivateKey))
        {
            throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
        } else
        {
            aEi = new PSSSigner(aEf, azr, azs, aEg, azy);
            aEi._mth02CA(true, RSAUtil._mth02CA((RSAPrivateKey)privatekey));
            return;
        }
    }

    protected void engineInitSign(PrivateKey privatekey, SecureRandom securerandom)
    {
        if (!(privatekey instanceof RSAPrivateKey))
        {
            throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
        } else
        {
            aEi = new PSSSigner(aEf, azr, azs, aEg, azy);
            aEi._mth02CA(true, new ParametersWithRandom(RSAUtil._mth02CA((RSAPrivateKey)privatekey), securerandom));
            return;
        }
    }

    protected void engineInitVerify(PublicKey publickey)
    {
        if (!(publickey instanceof RSAPublicKey))
        {
            throw new InvalidKeyException("Supplied key is not a RSAPublicKey instance");
        } else
        {
            aEi = new PSSSigner(aEf, azr, azs, aEg, azy);
            aEi._mth02CA(false, RSAUtil._mth02CA((RSAPublicKey)publickey));
            return;
        }
    }

    protected void engineSetParameter(String s, Object obj)
    {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineSetParameter(AlgorithmParameterSpec algorithmparameterspec)
    {
        if (algorithmparameterspec instanceof PSSParameterSpec)
        {
            algorithmparameterspec = (PSSParameterSpec)algorithmparameterspec;
            if (aEe != null && !DigestFactory._mth1428(aEe.getDigestAlgorithm(), algorithmparameterspec.getDigestAlgorithm()))
            {
                throw new InvalidParameterException((new StringBuilder("parameter must be using ")).append(aEe.getDigestAlgorithm()).toString());
            }
            if (!algorithmparameterspec.getMGFAlgorithm().equalsIgnoreCase("MGF1") && !algorithmparameterspec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.abd.identifier))
            {
                throw new InvalidParameterException("unknown mask generation function specified");
            }
            if (!(algorithmparameterspec.getMGFParameters() instanceof MGF1ParameterSpec))
            {
                throw new InvalidParameterException("unkown MGF parameters");
            }
            MGF1ParameterSpec mgf1parameterspec = (MGF1ParameterSpec)algorithmparameterspec.getMGFParameters();
            if (!DigestFactory._mth1428(mgf1parameterspec.getDigestAlgorithm(), algorithmparameterspec.getDigestAlgorithm()))
            {
                throw new InvalidParameterException("digest algorithm for MGF should be the same as for PSS parameters.");
            }
            org.spongycastle.crypto.ExtendedDigest extendeddigest = DigestFactory.FB4B(mgf1parameterspec.getDigestAlgorithm());
            if (extendeddigest == null)
            {
                throw new InvalidParameterException((new StringBuilder("no match on MGF digest algorithm: ")).append(mgf1parameterspec.getDigestAlgorithm()).toString());
            }
            aDC = null;
            aEd = algorithmparameterspec;
            azs = extendeddigest;
            aEg = aEd.getSaltLength();
            if (aEd.getTrailerField() != 1)
            {
                throw new IllegalArgumentException("unknown trailer field");
            } else
            {
                azy = -68;
                _mth15BE();
                return;
            }
        } else
        {
            throw new InvalidParameterException("Only PSSParameterSpec supported");
        }
    }

    protected byte[] engineSign()
    {
        byte abyte0[];
        try
        {
            abyte0 = aEi._mth14B6();
        }
        catch (CryptoException cryptoexception)
        {
            throw new SignatureException(cryptoexception.getMessage());
        }
        return abyte0;
    }

    protected void engineUpdate(byte byte0)
    {
        aEi.azr.update(byte0);
    }

    protected void engineUpdate(byte abyte0[], int i, int j)
    {
        aEi.azr.update(abyte0, i, j);
    }

    protected boolean engineVerify(byte abyte0[])
    {
        return aEi.FE73(abyte0);
    }
}
