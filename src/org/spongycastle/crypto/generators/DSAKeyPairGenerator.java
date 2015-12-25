// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.DSAKeyGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.math.ec.WNafUtil;
import org.spongycastle.util.BigIntegers;

public class DSAKeyPairGenerator
    implements AsymmetricCipherKeyPairGenerator
{

    private static final BigInteger ONE = BigInteger.valueOf(1L);
    public DSAKeyGenerationParameters atW;

    public DSAKeyPairGenerator()
    {
    }

    public final AsymmetricCipherKeyPair _mth1491()
    {
        DSAParameters dsaparameters = atW.axf;
        BigInteger biginteger1 = dsaparameters.amN;
        java.security.SecureRandom securerandom = ((KeyGenerationParameters) (atW)).amC;
        int i = biginteger1.bitLength();
        BigInteger biginteger;
        do
        {
            biginteger = BigIntegers._mth02CB(ONE, biginteger1.subtract(ONE), securerandom);
        } while (WNafUtil._mth1FBE(biginteger) < i >>> 2);
        biginteger1 = dsaparameters.amM;
        return new AsymmetricCipherKeyPair(new DSAPublicKeyParameters(dsaparameters.amO.modPow(biginteger, biginteger1), dsaparameters), new DSAPrivateKeyParameters(biginteger, dsaparameters));
    }

}
