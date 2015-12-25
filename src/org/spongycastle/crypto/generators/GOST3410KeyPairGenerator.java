// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.GOST3410KeyGenerationParameters;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.math.ec.WNafUtil;

public class GOST3410KeyPairGenerator
    implements AsymmetricCipherKeyPairGenerator
{

    public GOST3410KeyGenerationParameters auf;

    public GOST3410KeyPairGenerator()
    {
    }

    public final AsymmetricCipherKeyPair _mth1491()
    {
        GOST3410Parameters gost3410parameters = auf.axm;
        java.security.SecureRandom securerandom = ((KeyGenerationParameters) (auf)).amC;
        BigInteger biginteger = gost3410parameters.amN;
        BigInteger biginteger1 = gost3410parameters.amM;
        BigInteger biginteger2 = gost3410parameters.amW;
        BigInteger biginteger3;
        do
        {
            biginteger3 = new BigInteger(256, securerandom);
        } while (biginteger3.signum() <= 0 || biginteger3.compareTo(biginteger) >= 0 || WNafUtil._mth1FBE(biginteger3) < 64);
        return new AsymmetricCipherKeyPair(new GOST3410PublicKeyParameters(biginteger2.modPow(biginteger3, biginteger1), gost3410parameters), new GOST3410PrivateKeyParameters(biginteger3, gost3410parameters));
    }
}
