// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.FixedPointCombMultiplier;
import org.spongycastle.math.ec.WNafUtil;

public class ECKeyPairGenerator
    implements AsymmetricCipherKeyPairGenerator, ECConstants
{

    private SecureRandom amC;
    private ECDomainParameters aub;

    public ECKeyPairGenerator()
    {
    }

    public final void _mth02CA(ECKeyGenerationParameters eckeygenerationparameters)
    {
        eckeygenerationparameters = (ECKeyGenerationParameters)eckeygenerationparameters;
        amC = ((KeyGenerationParameters) (eckeygenerationparameters)).amC;
        aub = eckeygenerationparameters.axj;
        if (amC == null)
        {
            amC = new SecureRandom();
        }
    }

    public AsymmetricCipherKeyPair _mth1491()
    {
        BigInteger biginteger = aub.alr;
        int i = biginteger.bitLength();
        BigInteger biginteger1;
        do
        {
            biginteger1 = new BigInteger(i, amC);
        } while (biginteger1.compareTo(ars) < 0 || biginteger1.compareTo(biginteger) >= 0 || WNafUtil._mth1FBE(biginteger1) < i >>> 2);
        return new AsymmetricCipherKeyPair(new ECPublicKeyParameters((new FixedPointCombMultiplier())._mth02CA(aub.axi, biginteger1), aub), new ECPrivateKeyParameters(biginteger1, aub));
    }
}
