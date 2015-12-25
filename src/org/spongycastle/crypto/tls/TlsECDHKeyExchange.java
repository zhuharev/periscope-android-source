// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.util.Vector;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.TBSCertificate;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;

// Referenced classes of package org.spongycastle.crypto.tls:
//            AbstractTlsKeyExchange, TlsRSASigner, TlsECDSASigner, Certificate, 
//            TlsFatalAlert, TlsECCUtils, TlsUtils, TlsSigner, 
//            CertificateRequest, TlsContext, TlsAgreementCredentials, AbstractTlsSigner

public class TlsECDHKeyExchange extends AbstractTlsKeyExchange
{

    protected AbstractTlsSigner aBF;
    protected AsymmetricKeyParameter aBH;
    private TlsAgreementCredentials aBJ;
    protected int aBP[];
    protected short aBQ[];
    protected ECPrivateKeyParameters aBR;
    protected ECPublicKeyParameters aBS;
    private short azC[];

    public TlsECDHKeyExchange(int i, Vector vector, int ai[], short aword0[], short aword1[])
    {
        super(i, vector);
        switch (i)
        {
        case 19: // '\023'
            aBF = new TlsRSASigner();
            break;

        case 17: // '\021'
            aBF = new TlsECDSASigner();
            break;

        case 16: // '\020'
        case 18: // '\022'
            aBF = null;
            break;

        default:
            throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
        azH = i;
        aBP = ai;
        aBQ = aword0;
        azC = aword1;
    }

    public final void _mth02CA(org.spongycastle.crypto.tls.Certificate certificate)
    {
        if (certificate.isEmpty())
        {
            throw new TlsFatalAlert((short)42);
        }
        Certificate certificate1 = certificate._mth0130(0);
        org.spongycastle.asn1.x509.SubjectPublicKeyInfo subjectpublickeyinfo = certificate1.air.ajP;
        try
        {
            aBH = PublicKeyFactory._mth02CA(subjectpublickeyinfo);
        }
        // Misplaced declaration of an exception variable
        catch (org.spongycastle.crypto.tls.Certificate certificate)
        {
            throw new TlsFatalAlert((short)43);
        }
        if (aBF == null)
        {
            try
            {
                aBS = TlsECCUtils._mth02CA((ECPublicKeyParameters)aBH);
            }
            // Misplaced declaration of an exception variable
            catch (org.spongycastle.crypto.tls.Certificate certificate)
            {
                throw new TlsFatalAlert((short)46);
            }
            TlsUtils._mth02CA(certificate1, 8);
        } else
        {
            if (!aBF._mth02CE(aBH))
            {
                throw new TlsFatalAlert((short)46);
            }
            TlsUtils._mth02CA(certificate1, 128);
        }
        super._mth02CA(certificate);
    }

    public void _mth02CA(CertificateRequest certificaterequest)
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
            case 65: // 'A'
            case 66: // 'B'
                i++;
                break;
            }
        } while (true);
    }

    public final void _mth02CA(TlsContext tlscontext)
    {
        super._mth02CA(tlscontext);
        if (aBF != null)
        {
            aBF._mth02CA(tlscontext);
        }
    }

    public final void _mth02CB(TlsProtocol.HandshakeMessage handshakemessage)
    {
        if (aBJ == null)
        {
            aBR = TlsECCUtils._mth02CA(azJ._mth03D2(), azC, ((ECKeyParameters) (aBS)).aub, handshakemessage);
        }
    }

    public final void _mth02CE(ByteArrayInputStream bytearrayinputstream)
    {
        if (aBS != null)
        {
            return;
        } else
        {
            bytearrayinputstream = TlsUtils._mth02BF(bytearrayinputstream);
            org.spongycastle.crypto.params.ECDomainParameters ecdomainparameters = ((ECKeyParameters) (aBR)).aub;
            aBS = TlsECCUtils._mth02CA(TlsECCUtils._mth02CA(azC, ecdomainparameters, bytearrayinputstream));
            return;
        }
    }

    public final boolean _mth04E7()
    {
        switch (azH)
        {
        case 17: // '\021'
        case 19: // '\023'
        case 20: // '\024'
            return true;
        }
        return false;
    }

    public final void _mth09F0()
    {
        throw new TlsFatalAlert((short)10);
    }

    public final byte[] _mth0E04()
    {
        if (aBJ != null)
        {
            return aBJ._mth02CB(aBS);
        }
        if (aBR != null)
        {
            return TlsECCUtils._mth02CA(aBS, aBR);
        } else
        {
            throw new TlsFatalAlert((short)80);
        }
    }
}
