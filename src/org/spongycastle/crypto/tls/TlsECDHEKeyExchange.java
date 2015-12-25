// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.TeeInputStream;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsECDHKeyExchange, CertificateRequest, TlsFatalAlert, TlsSignerCredentials, 
//            TlsCredentials, TlsContext, SignerInputBuffer, TlsECCUtils, 
//            TlsUtils, DigitallySigned, TlsSigner, SecurityParameters, 
//            NamedCurve, DigestInputBuffer, SignatureAndHashAlgorithm, CombinedHash

public class TlsECDHEKeyExchange extends TlsECDHKeyExchange
{

    private TlsSignerCredentials aBE;

    public TlsECDHEKeyExchange(int i, Vector vector, int ai[], short aword0[], short aword1[])
    {
        super(i, vector, ai, aword0, aword1);
        aBE = null;
    }

    public final void _mth02CA(CertificateRequest certificaterequest)
    {
        certificaterequest = certificaterequest._mth0579();
        int i = 0;
        do
        {
            if (i >= certificaterequest.length)
            {
                break;
            }
            switch (certificaterequest[i])
            {
            default:
                throw new TlsFatalAlert((short)47);

            case 1: // '\001'
            case 2: // '\002'
            case 64: // '@'
                i++;
                break;
            }
        } while (true);
    }

    public final void _mth02CA(TlsCredentials tlscredentials)
    {
        if (!(tlscredentials instanceof TlsSignerCredentials))
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            _mth02CA(tlscredentials._mth067B());
            aBE = (TlsSignerCredentials)tlscredentials;
            return;
        }
    }

    public final void _mth02CB(ByteArrayInputStream bytearrayinputstream)
    {
        SecurityParameters securityparameters = azJ._mth03DC();
        SignerInputBuffer signerinputbuffer = new SignerInputBuffer();
        TeeInputStream teeinputstream = new TeeInputStream(bytearrayinputstream, signerinputbuffer);
        org.spongycastle.crypto.params.ECDomainParameters ecdomainparameters = TlsECCUtils._mth02CA(aBP, aBQ, teeinputstream);
        byte abyte0[] = TlsUtils._mth02BF(teeinputstream);
        bytearrayinputstream = DigitallySigned._mth02CA(azJ, bytearrayinputstream);
        Signer signer = aBF._mth02CA(bytearrayinputstream._mth072B(), aBH);
        signer.update(securityparameters.aBj, 0, securityparameters.aBj.length);
        signer.update(securityparameters.aBk, 0, securityparameters.aBk.length);
        signerinputbuffer._mth02CA(signer);
        if (!signer.FE73(bytearrayinputstream.getSignature()))
        {
            throw new TlsFatalAlert((short)51);
        } else
        {
            aBS = TlsECCUtils._mth02CA(TlsECCUtils._mth02CA(aBQ, ecdomainparameters, abyte0));
            return;
        }
    }

    public final byte[] _mth04ED()
    {
        byte byte0 = -1;
        int i;
        if (aBP == null)
        {
            i = 23;
        } else
        {
            int j = 0;
            do
            {
                i = byte0;
                if (j >= aBP.length)
                {
                    break;
                }
                i = aBP[j];
                if (NamedCurve.isValid(i) && TlsECCUtils._mth05D2(i))
                {
                    break;
                }
                j++;
            } while (true);
        }
        Object obj = null;
        if (i >= 0)
        {
            obj = TlsECCUtils._mth02B6(i);
        } else
        if (Arrays._mth02BD(aBP, 65281))
        {
            obj = TlsECCUtils._mth02B6(23);
        } else
        if (Arrays._mth02BD(aBP, 65282))
        {
            obj = TlsECCUtils._mth02B6(10);
        }
        if (obj == null)
        {
            throw new TlsFatalAlert((short)80);
        }
        Object obj1 = TlsECCUtils._mth02CA(azJ._mth03D2(), ((org.spongycastle.crypto.params.ECDomainParameters) (obj)));
        aBR = (ECPrivateKeyParameters)((AsymmetricCipherKeyPair) (obj1)).amv;
        DigestInputBuffer digestinputbuffer = new DigestInputBuffer();
        if (i < 0)
        {
            TlsECCUtils._mth02CA(aBQ, ((org.spongycastle.crypto.params.ECDomainParameters) (obj)), digestinputbuffer);
        } else
        {
            TlsECCUtils._mth02CA(i, digestinputbuffer);
        }
        obj = (ECPublicKeyParameters)((AsymmetricCipherKeyPair) (obj1)).amu;
        TlsECCUtils._mth02CA(aBQ, ((ECPublicKeyParameters) (obj)).axk, digestinputbuffer);
        if (TlsUtils._mth02CF(azJ))
        {
            obj = aBE._mth050F();
            if (obj == null)
            {
                throw new TlsFatalAlert((short)80);
            }
            obj1 = TlsUtils._mth02BD(((SignatureAndHashAlgorithm) (obj))._mth09AA());
        } else
        {
            obj = null;
            obj1 = new CombinedHash();
        }
        SecurityParameters securityparameters = azJ._mth03DC();
        ((Digest) (obj1)).update(securityparameters.aBj, 0, securityparameters.aBj.length);
        ((Digest) (obj1)).update(securityparameters.aBk, 0, securityparameters.aBk.length);
        digestinputbuffer._mth02CB(((Digest) (obj1)));
        byte abyte0[] = new byte[((Digest) (obj1))._mth14AF()];
        ((Digest) (obj1)).doFinal(abyte0, 0);
        (new DigitallySigned(((SignatureAndHashAlgorithm) (obj)), aBE._mth15EE(abyte0)))._mth02CB(digestinputbuffer);
        return digestinputbuffer.toByteArray();
    }
}
