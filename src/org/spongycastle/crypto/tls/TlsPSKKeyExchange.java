// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.TBSCertificate;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;

// Referenced classes of package org.spongycastle.crypto.tls:
//            AbstractTlsKeyExchange, TlsFatalAlert, Certificate, TlsUtils, 
//            TlsEncryptionCredentials, TlsCredentials, ServerDHParams, TlsDHUtils, 
//            CertificateRequest

public class TlsPSKKeyExchange extends AbstractTlsKeyExchange
{

    private AsymmetricKeyParameter aBH;
    private byte aCb[];
    private DHPrivateKeyParameters aCc;
    private DHPublicKeyParameters aCd;
    private RSAKeyParameters aCe;
    private TlsEncryptionCredentials aCf;
    private byte aCg[];

    public final void _mth02CA(org.spongycastle.crypto.tls.Certificate certificate)
    {
        if (azH != 15)
        {
            throw new TlsFatalAlert((short)10);
        }
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
        throw new TlsFatalAlert((short)10);
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

    public final void _mth02CB(ByteArrayInputStream bytearrayinputstream)
    {
        aCb = TlsUtils._mth02C8(bytearrayinputstream);
        if (azH == 14)
        {
            aCd = TlsDHUtils._mth02CA(ServerDHParams._mth141D(bytearrayinputstream)._mth09A8());
        }
    }

    public final void _mth02CB(TlsProtocol.HandshakeMessage handshakemessage)
    {
        throw new NullPointerException();
    }

    public final boolean _mth04E7()
    {
        switch (azH)
        {
        case 14: // '\016'
        case 24: // '\030'
            return true;
        }
        return false;
    }

    public final byte[] _mth04ED()
    {
        aCb = null;
        if (aCb == null && !_mth04E7())
        {
            return null;
        }
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        if (aCb == null)
        {
            TlsUtils._mth02CE(TlsUtils.WQ, bytearrayoutputstream);
        } else
        {
            TlsUtils._mth02CE(aCb, bytearrayoutputstream);
        }
        if (azH == 14)
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            return bytearrayoutputstream.toByteArray();
        }
    }

    public final void _mth09F0()
    {
        if (azH == 15)
        {
            throw new TlsFatalAlert((short)10);
        } else
        {
            return;
        }
    }

    public final byte[] _mth0E04()
    {
        throw new NullPointerException();
    }
}
