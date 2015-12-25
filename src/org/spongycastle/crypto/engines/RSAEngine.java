// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;

// Referenced classes of package org.spongycastle.crypto.engines:
//            RSACoreEngine

public class RSAEngine
    implements AsymmetricBlockCipher
{

    private RSACoreEngine asA;

    public RSAEngine()
    {
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (asA == null)
        {
            asA = new RSACoreEngine();
        }
        asA._mth02CA(flag, cipherparameters);
    }

    public final int _mth148C()
    {
        return asA._mth148C();
    }

    public final int _mth148E()
    {
        return asA._mth148E();
    }

    public final byte[] _mth1FBE(byte abyte0[], int i, int j)
    {
        if (asA == null)
        {
            throw new IllegalStateException("RSA engine not initialised");
        } else
        {
            return asA._mth02CE(asA._mth02CF(asA._mth1427(abyte0, i, j)));
        }
    }
}
