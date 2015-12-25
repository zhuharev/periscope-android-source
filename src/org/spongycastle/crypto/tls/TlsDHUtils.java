// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.agreement.DHBasicAgreement;
import org.spongycastle.crypto.generators.DHBasicKeyPairGenerator;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHKeyParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.util.BigIntegers;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsUtils, ServerDHParams, TlsFatalAlert

public class TlsDHUtils
{

    private static BigInteger ONE = BigInteger.valueOf(1L);
    private static BigInteger ars = BigInteger.valueOf(2L);

    public TlsDHUtils()
    {
    }

    public static BigInteger _mth02BC(InputStream inputstream)
    {
        return new BigInteger(1, TlsUtils._mth02C8(inputstream));
    }

    private static AsymmetricCipherKeyPair _mth02CA(SecureRandom securerandom, DHParameters dhparameters)
    {
        DHBasicKeyPairGenerator dhbasickeypairgenerator = new DHBasicKeyPairGenerator();
        dhbasickeypairgenerator.atT = (DHKeyGenerationParameters)new DHKeyGenerationParameters(securerandom, dhparameters);
        return dhbasickeypairgenerator._mth1491();
    }

    public static DHPrivateKeyParameters _mth02CA(SecureRandom securerandom, DHParameters dhparameters, ByteArrayOutputStream bytearrayoutputstream)
    {
        securerandom = _mth02CA(securerandom, dhparameters);
        (new ServerDHParams((DHPublicKeyParameters)((AsymmetricCipherKeyPair) (securerandom)).amu)).encode(bytearrayoutputstream);
        return (DHPrivateKeyParameters)((AsymmetricCipherKeyPair) (securerandom)).amv;
    }

    public static DHPrivateKeyParameters _mth02CA(SecureRandom securerandom, DHParameters dhparameters, OutputStream outputstream)
    {
        securerandom = _mth02CA(securerandom, dhparameters);
        TlsUtils._mth02CE(BigIntegers._mth02D1(((DHPublicKeyParameters)((AsymmetricCipherKeyPair) (securerandom)).amu).axe), outputstream);
        return (DHPrivateKeyParameters)((AsymmetricCipherKeyPair) (securerandom)).amv;
    }

    public static DHPublicKeyParameters _mth02CA(DHPublicKeyParameters dhpublickeyparameters)
    {
        BigInteger biginteger = dhpublickeyparameters.axe;
        Object obj = ((DHKeyParameters) (dhpublickeyparameters)).axb;
        BigInteger biginteger1 = ((DHParameters) (obj)).amM;
        obj = ((DHParameters) (obj)).amO;
        if (!biginteger1.isProbablePrime(2))
        {
            throw new TlsFatalAlert((short)47);
        }
        if (((BigInteger) (obj)).compareTo(ars) < 0 || ((BigInteger) (obj)).compareTo(biginteger1.subtract(ars)) > 0)
        {
            throw new TlsFatalAlert((short)47);
        }
        if (biginteger.compareTo(ars) < 0 || biginteger.compareTo(biginteger1.subtract(ONE)) > 0)
        {
            throw new TlsFatalAlert((short)47);
        } else
        {
            return dhpublickeyparameters;
        }
    }

    public static void _mth02CA(BigInteger biginteger, OutputStream outputstream)
    {
        TlsUtils._mth02CE(BigIntegers._mth02D1(biginteger), outputstream);
    }

    public static byte[] _mth02CA(DHPublicKeyParameters dhpublickeyparameters, DHPrivateKeyParameters dhprivatekeyparameters)
    {
        DHBasicAgreement dhbasicagreement = new DHBasicAgreement();
        dhbasicagreement._mth02CA(dhprivatekeyparameters);
        return BigIntegers._mth02D1(dhbasicagreement._mth02CB(dhpublickeyparameters));
    }

}
