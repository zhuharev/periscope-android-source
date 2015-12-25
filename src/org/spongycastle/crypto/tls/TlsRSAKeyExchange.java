// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.TBSCertificate;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.io.Streams;

// Referenced classes of package org.spongycastle.crypto.tls:
//            AbstractTlsKeyExchange, Certificate, TlsFatalAlert, TlsUtils, 
//            CertificateRequest, TlsEncryptionCredentials, TlsCredentials, TlsRSAUtils

public class TlsRSAKeyExchange extends AbstractTlsKeyExchange
{

    private AsymmetricKeyParameter aBH;
    private RSAKeyParameters aCe;
    private TlsEncryptionCredentials aCf;
    private byte aCg[];

    public TlsRSAKeyExchange(Vector vector)
    {
        super(1, vector);
        aBH = null;
        aCe = null;
        aCf = null;
    }

    public final void _mth02CA(org.spongycastle.crypto.tls.Certificate certificate)
    {
        if (certificate.isEmpty())
        {
            throw new TlsFatalAlert((short)42);
        }
        Certificate certificate1 = certificate._mth0130(0);
        Object obj = certificate1.air.ajP;
        try
        {
            aBH = PublicKeyFactory._mth02CA(((org.spongycastle.asn1.x509.SubjectPublicKeyInfo) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (org.spongycastle.crypto.tls.Certificate certificate)
        {
            throw new TlsFatalAlert((short)43);
        }
        if (aBH.awQ)
        {
            throw new TlsFatalAlert((short)80);
        }
        obj = (RSAKeyParameters)aBH;
        if (!((RSAKeyParameters) (obj)).axE.isProbablePrime(2))
        {
            throw new TlsFatalAlert((short)47);
        } else
        {
            aCe = ((RSAKeyParameters) (obj));
            TlsUtils._mth02CA(certificate1, 32);
            super._mth02CA(certificate);
            return;
        }
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
        if (!(tlscredentials instanceof TlsEncryptionCredentials))
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            _mth02CA(tlscredentials._mth067B());
            aCf = (TlsEncryptionCredentials)tlscredentials;
            return;
        }
    }

    public final void _mth02CB(TlsProtocol.HandshakeMessage handshakemessage)
    {
        aCg = TlsRSAUtils._mth02CA(azJ, aCe, handshakemessage);
    }

    public final void _mth02CE(ByteArrayInputStream bytearrayinputstream)
    {
        if (TlsUtils._mth02CB(azJ))
        {
            bytearrayinputstream = Streams._mth02D1(bytearrayinputstream);
        } else
        {
            bytearrayinputstream = TlsUtils._mth02C8(bytearrayinputstream);
        }
        aCg = aCf._mth1508(bytearrayinputstream);
    }

    public final void _mth09F0()
    {
        throw new TlsFatalAlert((short)10);
    }

    public final byte[] _mth0E04()
    {
        if (aCg == null)
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            byte abyte0[] = aCg;
            aCg = null;
            return abyte0;
        }
    }
}
