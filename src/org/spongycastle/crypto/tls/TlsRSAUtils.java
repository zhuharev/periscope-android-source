// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.OutputStream;
import java.security.SecureRandom;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsContext, TlsUtils, TlsFatalAlert, ProtocolVersion

public class TlsRSAUtils
{

    public TlsRSAUtils()
    {
    }

    public static byte[] _mth02CA(TlsContext tlscontext, RSAKeyParameters rsakeyparameters, OutputStream outputstream)
    {
        byte abyte0[];
        PKCS1Encoding pkcs1encoding;
        abyte0 = new byte[48];
        tlscontext._mth03D2().nextBytes(abyte0);
        TlsUtils._mth02CA(tlscontext._mth043A(), abyte0, 0);
        pkcs1encoding = new PKCS1Encoding(new RSABlindedEngine());
        pkcs1encoding._mth02CA(true, new ParametersWithRandom(rsakeyparameters, tlscontext._mth03D2()));
        rsakeyparameters = pkcs1encoding._mth1FBE(abyte0, 0, 48);
        if (!TlsUtils._mth02CB(tlscontext))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        outputstream.write(rsakeyparameters);
        return abyte0;
        try
        {
            TlsUtils._mth02CE(rsakeyparameters, outputstream);
        }
        // Misplaced declaration of an exception variable
        catch (TlsContext tlscontext)
        {
            throw new TlsFatalAlert((short)80);
        }
        return abyte0;
    }

    public static byte[] _mth02CA(TlsContext tlscontext, RSAKeyParameters rsakeyparameters, byte abyte0[])
    {
        ProtocolVersion protocolversion = tlscontext._mth043A();
        byte abyte2[] = new byte[48];
        tlscontext._mth03D2().nextBytes(abyte2);
        byte abyte1[] = Arrays._mth1D4C(abyte2);
        int i;
        int k;
        try
        {
            PKCS1Encoding pkcs1encoding = new PKCS1Encoding(new RSABlindedEngine(), abyte2);
            pkcs1encoding._mth02CA(false, new ParametersWithRandom(rsakeyparameters, tlscontext._mth03D2()));
            tlscontext = pkcs1encoding._mth1FBE(abyte0, 0, abyte0.length);
        }
        // Misplaced declaration of an exception variable
        catch (TlsContext tlscontext)
        {
            tlscontext = abyte1;
        }
        i = protocolversion.version >> 8 ^ tlscontext[0] & 0xff | protocolversion.version & 0xff ^ tlscontext[1] & 0xff;
        i |= i >> 1;
        i |= i >> 2;
        k = ~(((i | i >> 4) & 1) - 1);
        for (int j = 0; j < 48; j++)
        {
            tlscontext[j] = (byte)(tlscontext[j] & ~k | abyte2[j] & k);
        }

        return tlscontext;
    }
}
