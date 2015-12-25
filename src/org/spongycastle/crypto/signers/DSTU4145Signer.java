// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.FixedPointCombMultiplier;
import org.spongycastle.util.Arrays;

public class DSTU4145Signer
    implements DSA
{

    private static final BigInteger ONE = BigInteger.valueOf(1L);
    private SecureRandom amC;
    private ECKeyParameters azc;

    public DSTU4145Signer()
    {
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (flag)
        {
            if (cipherparameters instanceof ParametersWithRandom)
            {
                cipherparameters = (ParametersWithRandom)cipherparameters;
                amC = ((ParametersWithRandom) (cipherparameters)).amC;
                cipherparameters = ((ParametersWithRandom) (cipherparameters)).axC;
            } else
            {
                amC = new SecureRandom();
            }
            azc = (ECPrivateKeyParameters)cipherparameters;
            return;
        } else
        {
            azc = (ECPublicKeyParameters)cipherparameters;
            return;
        }
    }

    public final boolean _mth02CA(byte abyte0[], BigInteger biginteger, BigInteger biginteger1)
    {
        if (biginteger.signum() <= 0 || biginteger1.signum() <= 0)
        {
            return false;
        }
        ECDomainParameters ecdomainparameters = azc.aub;
        BigInteger biginteger3 = ecdomainparameters.alr;
        if (biginteger.compareTo(biginteger3) >= 0 || biginteger1.compareTo(biginteger3) >= 0)
        {
            return false;
        }
        ECCurve eccurve = ecdomainparameters.alm;
        BigInteger biginteger2 = new BigInteger(1, Arrays.FE76(abyte0));
        int i = eccurve.getFieldSize();
        abyte0 = biginteger2;
        Object obj = abyte0;
        if (biginteger2.bitLength() > i)
        {
            obj = abyte0.mod(ONE.shiftLeft(i));
        }
        obj = eccurve._mth02BB(((BigInteger) (obj)));
        abyte0 = ((byte []) (obj));
        if (((ECFieldElement) (obj)).isZero())
        {
            abyte0 = eccurve._mth02BB(ONE);
        }
        biginteger1 = ECAlgorithms._mth02CA(ecdomainparameters.axi, biginteger1, ((ECPublicKeyParameters)azc).axk, biginteger)._mth0188();
        if (biginteger1._mth021D())
        {
            return false;
        }
        biginteger1 = abyte0._mth141D(biginteger1.FF8A()).toBigInteger();
        i = biginteger3.bitLength() - 1;
        abyte0 = biginteger1;
        if (biginteger1.bitLength() > i)
        {
            abyte0 = biginteger1.mod(ONE.shiftLeft(i));
        }
        return abyte0.compareTo(biginteger) == 0;
    }

    public final BigInteger[] _mth1428(byte abyte0[])
    {
        ECDomainParameters ecdomainparameters = azc.aub;
        Object obj1 = ecdomainparameters.alm;
        BigInteger biginteger = new BigInteger(1, Arrays.FE76(abyte0));
        int i = ((ECCurve) (obj1)).getFieldSize();
        abyte0 = biginteger;
        Object obj = abyte0;
        if (biginteger.bitLength() > i)
        {
            obj = abyte0.mod(ONE.shiftLeft(i));
        }
        obj = ((ECCurve) (obj1))._mth02BB(((BigInteger) (obj)));
        abyte0 = ((byte []) (obj));
        if (((ECFieldElement) (obj)).isZero())
        {
            abyte0 = ((ECCurve) (obj1))._mth02BB(ONE);
        }
        obj1 = ecdomainparameters.alr;
        BigInteger biginteger1 = ((ECPrivateKeyParameters)azc).awZ;
        FixedPointCombMultiplier fixedpointcombmultiplier = new FixedPointCombMultiplier();
        do
        {
            BigInteger biginteger2;
            do
            {
                do
                {
                    obj = amC;
                    biginteger2 = new BigInteger(((BigInteger) (obj1)).bitLength() - 1, ((java.util.Random) (obj)));
                    obj = fixedpointcombmultiplier._mth02CA(ecdomainparameters.axi, biginteger2)._mth0188().FF8A();
                } while (((ECFieldElement) (obj)).isZero());
                biginteger = abyte0._mth141D(((ECFieldElement) (obj))).toBigInteger();
                int j = ((BigInteger) (obj1)).bitLength() - 1;
                obj = biginteger;
                if (biginteger.bitLength() > j)
                {
                    obj = biginteger.mod(ONE.shiftLeft(j));
                }
            } while (((BigInteger) (obj)).signum() == 0);
            biginteger = ((BigInteger) (obj)).multiply(biginteger1).add(biginteger2).mod(((BigInteger) (obj1)));
        } while (biginteger.signum() == 0);
        return (new BigInteger[] {
            obj, biginteger
        });
    }

}
