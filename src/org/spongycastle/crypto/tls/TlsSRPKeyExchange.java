// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.agreement.srp.SRP6Util;

// Referenced classes of package org.spongycastle.crypto.tls:
//            AbstractTlsKeyExchange, TlsFatalAlert, TlsUtils, TlsContext, 
//            Certificate, CertificateRequest

public class TlsSRPKeyExchange extends AbstractTlsKeyExchange
{

    private byte aCs[];
    private BigInteger amY;

    public final void _mth02CA(Certificate certificate)
    {
        throw new TlsFatalAlert((short)10);
    }

    public final void _mth02CA(CertificateRequest certificaterequest)
    {
        throw new TlsFatalAlert((short)10);
    }

    public final void _mth02CA(TlsContext tlscontext)
    {
        super._mth02CA(tlscontext);
    }

    public final void _mth02CB(ByteArrayInputStream bytearrayinputstream)
    {
        byte abyte2[] = TlsUtils._mth02C8(bytearrayinputstream);
        byte abyte1[] = TlsUtils._mth02C8(bytearrayinputstream);
        byte abyte0[] = TlsUtils._mth02BF(bytearrayinputstream);
        bytearrayinputstream = TlsUtils._mth02C8(bytearrayinputstream);
        BigInteger biginteger = new BigInteger(1, abyte2);
        new BigInteger(1, abyte1);
        aCs = abyte0;
        try
        {
            amY = SRP6Util._mth02CA(biginteger, new BigInteger(1, bytearrayinputstream));
        }
        // Misplaced declaration of an exception variable
        catch (ByteArrayInputStream bytearrayinputstream)
        {
            throw new TlsFatalAlert((short)47);
        }
        TlsUtils._mth02BD((short)2);
        azJ._mth03D2();
        throw new NullPointerException();
    }

    public final void _mth02CB(TlsProtocol.HandshakeMessage handshakemessage)
    {
        handshakemessage = aCs;
        throw new NullPointerException();
    }

    public final boolean _mth04E7()
    {
        return true;
    }

    public final void _mth09F0()
    {
    }

    public final byte[] _mth0E04()
    {
        CryptoException cryptoexception;
        try
        {
            BigInteger biginteger = amY;
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (CryptoException cryptoexception)
        {
            throw new TlsFatalAlert((short)47);
        }
    }
}
