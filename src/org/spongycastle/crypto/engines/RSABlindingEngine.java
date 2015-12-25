// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSABlindingParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;

// Referenced classes of package org.spongycastle.crypto.engines:
//            RSACoreEngine

public class RSABlindingEngine
    implements AsymmetricBlockCipher
{

    private boolean amy;
    private RSACoreEngine asA;
    private RSAKeyParameters asB;
    private BigInteger asC;

    public RSABlindingEngine()
    {
        asA = new RSACoreEngine();
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof ParametersWithRandom)
        {
            cipherparameters = (RSABlindingParameters)((ParametersWithRandom)cipherparameters).axC;
        } else
        {
            cipherparameters = (RSABlindingParameters)cipherparameters;
        }
        asA._mth02CA(flag, null);
        amy = flag;
        asB = null;
        asC = null;
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
        abyte0 = asA._mth1427(abyte0, i, j);
        if (amy)
        {
            abyte0 = abyte0.multiply(asC.modPow(asB.axE, asB.adi)).mod(asB.adi);
        } else
        {
            BigInteger biginteger = asB.adi;
            abyte0 = abyte0.multiply(asC.modInverse(biginteger)).mod(biginteger);
        }
        return asA._mth02CE(abyte0);
    }
}
