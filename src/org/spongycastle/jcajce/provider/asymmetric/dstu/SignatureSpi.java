// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dstu;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.ua.DSTU4145Params;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.DSTU4145Signer;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jce.interfaces.ECKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.provider.BouncyCastleProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.dstu:
//            BCDSTU4145PublicKey

public class SignatureSpi extends java.security.SignatureSpi
    implements PKCSObjectIdentifiers, X509ObjectIdentifiers
{

    private static byte aDl[] = {
        10, 9, 13, 6, 14, 11, 4, 5, 15, 1, 
        3, 12, 7, 0, 8, 2, 8, 0, 12, 4, 
        9, 6, 7, 11, 2, 3, 1, 15, 5, 14, 
        10, 13, 15, 6, 5, 8, 14, 11, 10, 4, 
        12, 0, 3, 7, 2, 9, 1, 13, 3, 8, 
        13, 9, 6, 11, 15, 0, 2, 5, 12, 10, 
        4, 14, 1, 7, 15, 8, 14, 9, 7, 2, 
        0, 13, 12, 6, 1, 5, 11, 4, 3, 10, 
        2, 8, 9, 7, 5, 15, 0, 11, 12, 1, 
        13, 14, 10, 3, 6, 4, 3, 8, 11, 5, 
        6, 4, 14, 10, 2, 12, 1, 7, 9, 15, 
        13, 0, 1, 2, 3, 14, 6, 13, 11, 8, 
        15, 10, 12, 5, 7, 9, 0, 4
    };
    private GOST3411Digest aDj;
    private DSTU4145Signer aDk;

    public SignatureSpi()
    {
        aDk = new DSTU4145Signer();
    }

    private static byte[] _mth1D4B(byte abyte0[])
    {
        byte abyte1[] = new byte[128];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte1[i << 1] = (byte)(abyte0[i] >> 4 & 0xf);
            abyte1[(i << 1) + 1] = (byte)(abyte0[i] & 0xf);
        }

        return abyte1;
    }

    protected Object engineGetParameter(String s)
    {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineInitSign(PrivateKey privatekey)
    {
        org.spongycastle.crypto.params.AsymmetricKeyParameter asymmetrickeyparameter = null;
        if (privatekey instanceof ECKey)
        {
            asymmetrickeyparameter = ECUtil._mth02CF(privatekey);
        }
        aDj = new GOST3411Digest(aDl);
        if (appRandom != null)
        {
            aDk._mth02CA(true, new ParametersWithRandom(asymmetrickeyparameter, appRandom));
            return;
        } else
        {
            aDk._mth02CA(true, asymmetrickeyparameter);
            return;
        }
    }

    protected void engineInitVerify(PublicKey publickey)
    {
        org.spongycastle.crypto.params.AsymmetricKeyParameter asymmetrickeyparameter;
        if (publickey instanceof ECPublicKey)
        {
            asymmetrickeyparameter = ECUtil._mth02CF(publickey);
            break MISSING_BLOCK_LABEL_63;
        }
        publickey = BouncyCastleProvider._mth141D(SubjectPublicKeyInfo._mth13A5(publickey.getEncoded()));
        if (publickey instanceof ECPublicKey)
        {
            asymmetrickeyparameter = ECUtil._mth02CF(publickey);
            break MISSING_BLOCK_LABEL_63;
        } else
        {
            try
            {
                throw new InvalidKeyException("can't recognise key type in DSA based signer");
            }
            // Misplaced declaration of an exception variable
            catch (PublicKey publickey)
            {
                throw new InvalidKeyException("can't recognise key type in DSA based signer");
            }
        }
        publickey = (BCDSTU4145PublicKey)publickey;
        if (((BCDSTU4145PublicKey) (publickey)).aDf != null)
        {
            publickey = ((BCDSTU4145PublicKey) (publickey)).aDf.afX;
        } else
        {
            publickey = DSTU4145Params._mth0997();
        }
        aDj = new GOST3411Digest(_mth1D4B(publickey));
        aDk._mth02CA(false, asymmetrickeyparameter);
        return;
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
        byte abyte0[] = new byte[aDj._mth14AF()];
        aDj.doFinal(abyte0, 0);
        Object aobj[];
        byte abyte1[];
        int i;
        try
        {
            aobj = aDk._mth1428(abyte0);
            abyte0 = aobj[0].toByteArray();
            aobj = aobj[1].toByteArray();
            if (abyte0.length > aobj.length)
            {
                i = abyte0.length << 1;
                break MISSING_BLOCK_LABEL_71;
            }
        }
        catch (Exception exception)
        {
            throw new SignatureException(exception.toString());
        }
        i = aobj.length << 1;
        abyte1 = new byte[i];
        System.arraycopy(((Object) (aobj)), 0, abyte1, abyte1.length / 2 - aobj.length, aobj.length);
        System.arraycopy(abyte0, 0, abyte1, abyte1.length - abyte0.length, abyte0.length);
        abyte0 = (new DEROctetString(abyte1)).getEncoded();
        return abyte0;
    }

    protected void engineUpdate(byte byte0)
    {
        aDj.update(byte0);
    }

    protected void engineUpdate(byte abyte0[], int i, int j)
    {
        aDj.update(abyte0, i, j);
    }

    protected boolean engineVerify(byte abyte0[])
    {
        byte abyte1[] = new byte[aDj._mth14AF()];
        aDj.doFinal(abyte1, 0);
        Object aobj[];
        try
        {
            aobj = ((ASN1OctetString)ASN1OctetString._mth0640(abyte0))._mth0501();
            abyte0 = new byte[aobj.length / 2];
            byte abyte2[] = new byte[aobj.length / 2];
            System.arraycopy(((Object) (aobj)), 0, abyte2, 0, aobj.length / 2);
            System.arraycopy(((Object) (aobj)), aobj.length / 2, abyte0, 0, aobj.length / 2);
            aobj = new BigInteger[2];
            aobj[0] = new BigInteger(1, abyte0);
            aobj[1] = new BigInteger(1, abyte2);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new SignatureException("error decoding signature bytes.");
        }
        return aDk._mth02CA(abyte1, aobj[0], aobj[1]);
    }

}
