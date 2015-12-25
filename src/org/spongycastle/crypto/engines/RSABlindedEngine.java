// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.util.BigIntegers;

// Referenced classes of package org.spongycastle.crypto.engines:
//            RSACoreEngine

public class RSABlindedEngine
    implements AsymmetricBlockCipher
{

    private static final BigInteger ONE = BigInteger.valueOf(1L);
    private SecureRandom amC;
    private RSACoreEngine asA;
    private RSAKeyParameters asB;

    public RSABlindedEngine()
    {
        asA = new RSACoreEngine();
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        asA._mth02CA(flag, cipherparameters);
        if (cipherparameters instanceof ParametersWithRandom)
        {
            cipherparameters = (ParametersWithRandom)cipherparameters;
            asB = (RSAKeyParameters)((ParametersWithRandom) (cipherparameters)).axC;
            amC = ((ParametersWithRandom) (cipherparameters)).amC;
            return;
        } else
        {
            asB = (RSAKeyParameters)cipherparameters;
            amC = new SecureRandom();
            return;
        }
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
        if (asB == null)
        {
            throw new IllegalStateException("RSA engine not initialised");
        }
        abyte0 = asA._mth1427(abyte0, i, j);
        if (asB instanceof RSAPrivateCrtKeyParameters)
        {
            Object obj = (RSAPrivateCrtKeyParameters)asB;
            BigInteger biginteger = ((RSAPrivateCrtKeyParameters) (obj)).axF;
            if (biginteger != null)
            {
                obj = ((RSAKeyParameters) (obj)).adi;
                BigInteger biginteger1 = BigIntegers._mth02CB(ONE, ((BigInteger) (obj)).subtract(ONE), amC);
                abyte0 = biginteger1.modPow(biginteger, ((BigInteger) (obj))).multiply(abyte0).mod(((BigInteger) (obj)));
                abyte0 = asA._mth02CF(abyte0).multiply(biginteger1.modInverse(((BigInteger) (obj)))).mod(((BigInteger) (obj)));
            } else
            {
                abyte0 = asA._mth02CF(abyte0);
            }
        } else
        {
            abyte0 = asA._mth02CF(abyte0);
        }
        return asA._mth02CE(abyte0);
    }

}
