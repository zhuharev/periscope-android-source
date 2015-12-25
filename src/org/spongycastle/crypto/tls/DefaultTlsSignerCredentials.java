// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CryptoException;

// Referenced classes of package org.spongycastle.crypto.tls:
//            AbstractTlsSignerCredentials, TlsUtils, TlsFatalAlert, SignatureAndHashAlgorithm, 
//            Certificate

public class DefaultTlsSignerCredentials extends AbstractTlsSignerCredentials
{

    public final SignatureAndHashAlgorithm _mth050F()
    {
        return null;
    }

    public final Certificate _mth067B()
    {
        return null;
    }

    public final byte[] _mth15EE(byte abyte0[])
    {
        try
        {
            if (TlsUtils._mth02CF(null))
            {
                throw new NullPointerException();
            } else
            {
                throw new NullPointerException();
            }
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new TlsFatalAlert((short)80);
        }
    }
}
