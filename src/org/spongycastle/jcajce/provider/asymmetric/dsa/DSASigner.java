// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.DSAKey;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.HMacDSAKCalculator;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.dsa:
//            DSAUtil, BCDSAPublicKey

public class DSASigner extends SignatureSpi
    implements PKCSObjectIdentifiers, X509ObjectIdentifiers
{
    public static class detDSA extends DSASigner
    {

        public detDSA()
        {
            super(new SHA1Digest(), new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA1Digest())));
        }
    }

    public static class detDSA224 extends DSASigner
    {

        public detDSA224()
        {
            super(new SHA224Digest(), new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA224Digest())));
        }
    }

    public static class detDSA256 extends DSASigner
    {

        public detDSA256()
        {
            super(new SHA256Digest(), new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA256Digest())));
        }
    }

    public static class detDSA384 extends DSASigner
    {

        public detDSA384()
        {
            super(new SHA384Digest(), new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA384Digest())));
        }
    }

    public static class detDSA512 extends DSASigner
    {

        public detDSA512()
        {
            super(new SHA512Digest(), new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA512Digest())));
        }
    }

    public static class dsa224 extends DSASigner
    {

        public dsa224()
        {
            super(new SHA224Digest(), new org.spongycastle.crypto.signers.DSASigner());
        }
    }

    public static class dsa256 extends DSASigner
    {

        public dsa256()
        {
            super(new SHA256Digest(), new org.spongycastle.crypto.signers.DSASigner());
        }
    }

    public static class dsa384 extends DSASigner
    {

        public dsa384()
        {
            super(new SHA384Digest(), new org.spongycastle.crypto.signers.DSASigner());
        }
    }

    public static class dsa512 extends DSASigner
    {

        public dsa512()
        {
            super(new SHA512Digest(), new org.spongycastle.crypto.signers.DSASigner());
        }
    }

    public static class noneDSA extends DSASigner
    {

        public noneDSA()
        {
            super(new NullDigest(), new org.spongycastle.crypto.signers.DSASigner());
        }
    }

    public static class stdDSA extends DSASigner
    {

        public stdDSA()
        {
            super(new SHA1Digest(), new org.spongycastle.crypto.signers.DSASigner());
        }
    }


    private DSA aCZ;
    private SecureRandom amC;
    private Digest amS;

    protected DSASigner(Digest digest, org.spongycastle.crypto.signers.DSASigner dsasigner)
    {
        amS = digest;
        aCZ = dsasigner;
    }

    protected Object engineGetParameter(String s)
    {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineInitSign(PrivateKey privatekey)
    {
        org.spongycastle.crypto.params.DSAPrivateKeyParameters dsaprivatekeyparameters = DSAUtil._mth02CA(privatekey);
        privatekey = dsaprivatekeyparameters;
        if (amC != null)
        {
            privatekey = new ParametersWithRandom(dsaprivatekeyparameters, amC);
        }
        amS.reset();
        aCZ._mth02CA(true, privatekey);
    }

    protected void engineInitSign(PrivateKey privatekey, SecureRandom securerandom)
    {
        amC = securerandom;
        engineInitSign(privatekey);
    }

    protected void engineInitVerify(PublicKey publickey)
    {
        if (publickey instanceof DSAKey)
        {
            publickey = DSAUtil._mth02CA(publickey);
        } else
        {
            try
            {
                publickey = DSAUtil._mth02CA(new BCDSAPublicKey(SubjectPublicKeyInfo._mth13A5(publickey.getEncoded())));
            }
            // Misplaced declaration of an exception variable
            catch (PublicKey publickey)
            {
                throw new InvalidKeyException("can't recognise key type in DSA based signer");
            }
        }
        amS.reset();
        aCZ._mth02CA(false, publickey);
    }

    protected void engineSetParameter(String s, Object obj)
    {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineSetParameter(AlgorithmParameterSpec algorithmparameterspec)
    {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected byte[] engineSign()
    {
        byte abyte0[] = new byte[amS._mth14AF()];
        amS.doFinal(abyte0, 0);
        BigInteger biginteger;
        BigInteger abiginteger[];
        BigInteger biginteger1;
        try
        {
            abiginteger = aCZ._mth1428(abyte0);
        }
        catch (Exception exception)
        {
            throw new SignatureException(exception.toString());
        }
        biginteger = abiginteger[0];
        biginteger1 = abiginteger[1];
        biginteger = (new DERSequence(new ASN1Integer[] {
            new ASN1Integer(biginteger), new ASN1Integer(biginteger1)
        })).getEncoded("DER");
        return biginteger;
    }

    protected void engineUpdate(byte byte0)
    {
        amS.update(byte0);
    }

    protected void engineUpdate(byte abyte0[], int i, int j)
    {
        amS.update(abyte0, i, j);
    }

    protected boolean engineVerify(byte abyte0[])
    {
        byte abyte1[] = new byte[amS._mth14AF()];
        amS.doFinal(abyte1, 0);
        BigInteger abiginteger[];
        try
        {
            abyte0 = (ASN1Sequence)ASN1Primitive._mth0640(abyte0);
            abiginteger = new BigInteger[2];
            abiginteger[0] = new BigInteger(((ASN1Integer)abyte0._mth144B(0)).bytes);
            abiginteger[1] = new BigInteger(((ASN1Integer)abyte0._mth144B(1)).bytes);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new SignatureException("error decoding signature bytes.");
        }
        return aCZ._mth02CA(abyte1, abiginteger[0], abiginteger[1]);
    }
}
