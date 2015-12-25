// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.TBSCertificate;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHKeyParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;

// Referenced classes of package org.spongycastle.crypto.tls:
//            AbstractTlsKeyExchange, TlsRSASigner, TlsDSSSigner, Certificate, 
//            TlsFatalAlert, TlsDHUtils, TlsUtils, TlsSigner, 
//            CertificateRequest, TlsContext, TlsAgreementCredentials, AbstractTlsSigner

public class TlsDHKeyExchange extends AbstractTlsKeyExchange
{

    protected AbstractTlsSigner aBF;
    protected DHParameters aBG;
    protected AsymmetricKeyParameter aBH;
    protected DHPublicKeyParameters aBI;
    private TlsAgreementCredentials aBJ;
    private DHPrivateKeyParameters aBK;
    protected DHPrivateKeyParameters aBL;

    public TlsDHKeyExchange(int i, Vector vector, DHParameters dhparameters)
    {
        super(i, vector);
        switch (i)
        {
        case 7: // '\007'
        case 9: // '\t'
            aBF = null;
            break;

        case 5: // '\005'
            aBF = new TlsRSASigner();
            break;

        case 3: // '\003'
            aBF = new TlsDSSSigner();
            break;

        case 4: // '\004'
        case 6: // '\006'
        case 8: // '\b'
        default:
            throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
        aBG = dhparameters;
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
                aBI = TlsDHUtils._mth02CA((DHPublicKeyParameters)aBH);
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
            case 3: // '\003'
            case 4: // '\004'
            case 64: // '@'
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
            aBK = TlsDHUtils._mth02CA(azJ._mth03D2(), ((DHKeyParameters) (aBI)).axb, handshakemessage);
        }
    }

    public final boolean _mth04E7()
    {
        switch (azH)
        {
        case 3: // '\003'
        case 5: // '\005'
        case 11: // '\013'
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
            return aBJ._mth02CB(aBI);
        }
        if (aBL != null)
        {
            return TlsDHUtils._mth02CA(null, aBL);
        }
        if (aBK != null)
        {
            return TlsDHUtils._mth02CA(aBI, aBK);
        } else
        {
            throw new TlsFatalAlert((short)80);
        }
    }

    static 
    {
        BigInteger.valueOf(1L);
        BigInteger.valueOf(2L);
    }
}
