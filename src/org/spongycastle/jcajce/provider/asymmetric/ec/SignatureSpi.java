// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.ECDSASigner;
import org.spongycastle.crypto.signers.ECNRSigner;
import org.spongycastle.crypto.signers.HMacDSAKCalculator;
import org.spongycastle.jcajce.provider.asymmetric.util.DSABase;
import org.spongycastle.jcajce.provider.asymmetric.util.DSAEncoder;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;

public class SignatureSpi extends DSABase
{
    static class PlainDSAEncoder
        implements DSAEncoder
    {

        public final byte[] _mth02CB(BigInteger biginteger, BigInteger biginteger1)
        {
            biginteger = biginteger.toByteArray();
            if (biginteger[0] == 0)
            {
                byte abyte0[] = new byte[biginteger.length - 1];
                System.arraycopy(biginteger, 1, abyte0, 0, abyte0.length);
                biginteger = abyte0;
            }
            biginteger1 = biginteger1.toByteArray();
            if (biginteger1[0] == 0)
            {
                byte abyte1[] = new byte[biginteger1.length - 1];
                System.arraycopy(biginteger1, 1, abyte1, 0, abyte1.length);
                biginteger1 = abyte1;
            }
            byte abyte2[];
            if (biginteger.length > biginteger1.length)
            {
                abyte2 = new byte[biginteger.length << 1];
            } else
            {
                abyte2 = new byte[biginteger1.length << 1];
            }
            System.arraycopy(biginteger, 0, abyte2, abyte2.length / 2 - biginteger.length, biginteger.length);
            System.arraycopy(biginteger1, 0, abyte2, abyte2.length - biginteger1.length, biginteger1.length);
            return abyte2;
        }

        public final BigInteger[] _mth1D57(byte abyte0[])
        {
            byte abyte1[] = new byte[abyte0.length / 2];
            byte abyte2[] = new byte[abyte0.length / 2];
            System.arraycopy(abyte0, 0, abyte1, 0, abyte1.length);
            System.arraycopy(abyte0, abyte1.length, abyte2, 0, abyte2.length);
            return (new BigInteger[] {
                new BigInteger(1, abyte1), new BigInteger(1, abyte2)
            });
        }

        private PlainDSAEncoder()
        {
        }

        PlainDSAEncoder(byte byte0)
        {
            this();
        }
    }

    static class StdDSAEncoder
        implements DSAEncoder
    {

        public final byte[] _mth02CB(BigInteger biginteger, BigInteger biginteger1)
        {
            ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
            biginteger = new ASN1Integer(biginteger);
            asn1encodablevector.VS.addElement(biginteger);
            biginteger = new ASN1Integer(biginteger1);
            asn1encodablevector.VS.addElement(biginteger);
            return (new DERSequence(asn1encodablevector)).getEncoded("DER");
        }

        public final BigInteger[] _mth1D57(byte abyte0[])
        {
            abyte0 = (ASN1Sequence)ASN1Primitive._mth0640(abyte0);
            return (new BigInteger[] {
                new BigInteger(ASN1Integer.FB1D(abyte0._mth144B(0)).bytes), new BigInteger(ASN1Integer.FB1D(abyte0._mth144B(1)).bytes)
            });
        }

        private StdDSAEncoder()
        {
        }

        StdDSAEncoder(byte byte0)
        {
            this();
        }
    }

    public static class ecCVCDSA extends SignatureSpi
    {

        public ecCVCDSA()
        {
            super(new SHA1Digest(), new ECDSASigner(), new PlainDSAEncoder((byte)0));
        }
    }

    public static class ecCVCDSA224 extends SignatureSpi
    {

        public ecCVCDSA224()
        {
            super(new SHA224Digest(), new ECDSASigner(), new PlainDSAEncoder((byte)0));
        }
    }

    public static class ecCVCDSA256 extends SignatureSpi
    {

        public ecCVCDSA256()
        {
            super(new SHA256Digest(), new ECDSASigner(), new PlainDSAEncoder((byte)0));
        }
    }

    public static class ecCVCDSA384 extends SignatureSpi
    {

        public ecCVCDSA384()
        {
            super(new SHA384Digest(), new ECDSASigner(), new PlainDSAEncoder((byte)0));
        }
    }

    public static class ecCVCDSA512 extends SignatureSpi
    {

        public ecCVCDSA512()
        {
            super(new SHA512Digest(), new ECDSASigner(), new PlainDSAEncoder((byte)0));
        }
    }

    public static class ecDSA extends SignatureSpi
    {

        public ecDSA()
        {
            super(new SHA1Digest(), new ECDSASigner(), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecDSA224 extends SignatureSpi
    {

        public ecDSA224()
        {
            super(new SHA224Digest(), new ECDSASigner(), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecDSA256 extends SignatureSpi
    {

        public ecDSA256()
        {
            super(new SHA256Digest(), new ECDSASigner(), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecDSA384 extends SignatureSpi
    {

        public ecDSA384()
        {
            super(new SHA384Digest(), new ECDSASigner(), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecDSA512 extends SignatureSpi
    {

        public ecDSA512()
        {
            super(new SHA512Digest(), new ECDSASigner(), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecDSARipeMD160 extends SignatureSpi
    {

        public ecDSARipeMD160()
        {
            super(new RIPEMD160Digest(), new ECDSASigner(), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecDSAnone extends SignatureSpi
    {

        public ecDSAnone()
        {
            super(new NullDigest(), new ECDSASigner(), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecDetDSA extends SignatureSpi
    {

        public ecDetDSA()
        {
            super(new SHA1Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA1Digest())), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecDetDSA224 extends SignatureSpi
    {

        public ecDetDSA224()
        {
            super(new SHA224Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA224Digest())), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecDetDSA256 extends SignatureSpi
    {

        public ecDetDSA256()
        {
            super(new SHA256Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA256Digest())), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecDetDSA384 extends SignatureSpi
    {

        public ecDetDSA384()
        {
            super(new SHA384Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA384Digest())), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecDetDSA512 extends SignatureSpi
    {

        public ecDetDSA512()
        {
            super(new SHA512Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA512Digest())), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecNR extends SignatureSpi
    {

        public ecNR()
        {
            super(new SHA1Digest(), new ECNRSigner(), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecNR224 extends SignatureSpi
    {

        public ecNR224()
        {
            super(new SHA224Digest(), new ECNRSigner(), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecNR256 extends SignatureSpi
    {

        public ecNR256()
        {
            super(new SHA256Digest(), new ECNRSigner(), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecNR384 extends SignatureSpi
    {

        public ecNR384()
        {
            super(new SHA384Digest(), new ECNRSigner(), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecNR512 extends SignatureSpi
    {

        public ecNR512()
        {
            super(new SHA512Digest(), new ECNRSigner(), new StdDSAEncoder((byte)0));
        }
    }

    public static class ecPlainDSARP160 extends SignatureSpi
    {

        public ecPlainDSARP160()
        {
            super(new RIPEMD160Digest(), new ECDSASigner(), new PlainDSAEncoder((byte)0));
        }
    }


    SignatureSpi(Digest digest, DSA dsa, DSAEncoder dsaencoder)
    {
        super(digest, dsa, dsaencoder);
    }

    protected void engineInitSign(PrivateKey privatekey)
    {
        privatekey = ECUtil._mth02CF(privatekey);
        amS.reset();
        if (appRandom != null)
        {
            aCZ._mth02CA(true, new ParametersWithRandom(privatekey, appRandom));
            return;
        } else
        {
            aCZ._mth02CA(true, privatekey);
            return;
        }
    }

    protected void engineInitVerify(PublicKey publickey)
    {
        publickey = ECUtil._mth02CF(publickey);
        amS.reset();
        aCZ._mth02CA(false, publickey);
    }
}
